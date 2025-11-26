package androidx.leanback.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.ColorInt;
import androidx.leanback.R;
import androidx.leanback.app.HeadersFragment;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.transition.TransitionListener;
import androidx.leanback.util.StateMachine;
import androidx.leanback.widget.BrowseFrameLayout;
import androidx.leanback.widget.InvisibleRowPresenter;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.PageRow;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowHeaderPresenter;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.ScaleFrameLayout;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class BrowseFragment extends BaseFragment {
    private static final String ARG_HEADERS_STATE;
    private static final String ARG_TITLE;
    private static final String CURRENT_SELECTED_POSITION = "currentSelectedPosition";
    static final boolean DEBUG = false;
    public static final int HEADERS_DISABLED = 3;
    public static final int HEADERS_ENABLED = 1;
    public static final int HEADERS_HIDDEN = 2;
    static final String HEADER_SHOW = "headerShow";
    static final String HEADER_STACK_INDEX = "headerStackIndex";
    private static final String IS_PAGE_ROW = "isPageRow";
    private static final String LB_HEADERS_BACKSTACK = "lbHeadersBackStack_";
    static final String TAG = "BrowseFragment";
    final StateMachine.Event EVT_HEADER_VIEW_CREATED = new StateMachine.Event("headerFragmentViewCreated");
    final StateMachine.Event EVT_MAIN_FRAGMENT_VIEW_CREATED = new StateMachine.Event("mainFragmentViewCreated");
    final StateMachine.Event EVT_SCREEN_DATA_READY = new StateMachine.Event("screenDataReady");
    final StateMachine.State STATE_SET_ENTRANCE_START_STATE = new StateMachine.State("SET_ENTRANCE_START_STATE") {
        public void run() {
            BrowseFragment.this.setEntranceTransitionStartState();
        }
    };
    private ObjectAdapter mAdapter;
    private PresenterSelector mAdapterPresenter;
    BackStackListener mBackStackChangedListener;
    private int mBrandColor = 0;
    private boolean mBrandColorSet;
    BrowseFrameLayout mBrowseFrame;
    BrowseTransitionListener mBrowseTransitionListener;
    boolean mCanShowHeaders = true;
    private int mContainerListAlignTop;
    private int mContainerListMarginStart;
    OnItemViewSelectedListener mExternalOnItemViewSelectedListener;
    private HeadersFragment.OnHeaderClickedListener mHeaderClickedListener = new HeadersFragment.OnHeaderClickedListener() {
        public void onHeaderClicked(RowHeaderPresenter.ViewHolder viewHolder, Row row) {
            Fragment fragment;
            BrowseFragment browseFragment = BrowseFragment.this;
            if (browseFragment.mCanShowHeaders && browseFragment.mShowingHeaders && !browseFragment.isInHeadersTransition() && (fragment = BrowseFragment.this.mMainFragment) != null && fragment.getView() != null) {
                BrowseFragment.this.startHeadersTransitionInternal(false);
                BrowseFragment.this.mMainFragment.getView().requestFocus();
            }
        }
    };
    private PresenterSelector mHeaderPresenterSelector;
    private HeadersFragment.OnHeaderViewSelectedListener mHeaderViewSelectedListener = new HeadersFragment.OnHeaderViewSelectedListener() {
        public void onHeaderSelected(RowHeaderPresenter.ViewHolder viewHolder, Row row) {
            int selectedPosition = BrowseFragment.this.mHeadersFragment.getSelectedPosition();
            BrowseFragment browseFragment = BrowseFragment.this;
            if (browseFragment.mShowingHeaders) {
                browseFragment.onRowSelected(selectedPosition);
            }
        }
    };
    boolean mHeadersBackStackEnabled = true;
    HeadersFragment mHeadersFragment;
    private int mHeadersState = 1;
    Object mHeadersTransition;
    boolean mIsPageRow;
    Fragment mMainFragment;
    MainFragmentAdapter mMainFragmentAdapter;
    private MainFragmentAdapterRegistry mMainFragmentAdapterRegistry = new MainFragmentAdapterRegistry();
    ListRowDataAdapter mMainFragmentListRowDataAdapter;
    MainFragmentRowsAdapter mMainFragmentRowsAdapter;
    private boolean mMainFragmentScaleEnabled = true;
    private final BrowseFrameLayout.OnChildFocusListener mOnChildFocusListener = new BrowseFrameLayout.OnChildFocusListener() {
        public void onRequestChildFocus(View view, View view2) {
            if (!BrowseFragment.this.getChildFragmentManager().isDestroyed()) {
                BrowseFragment browseFragment = BrowseFragment.this;
                if (browseFragment.mCanShowHeaders && !browseFragment.isInHeadersTransition()) {
                    int id = view.getId();
                    if (id == R.id.browse_container_dock) {
                        BrowseFragment browseFragment2 = BrowseFragment.this;
                        if (browseFragment2.mShowingHeaders) {
                            browseFragment2.startHeadersTransitionInternal(false);
                            return;
                        }
                    }
                    if (id == R.id.browse_headers_dock) {
                        BrowseFragment browseFragment3 = BrowseFragment.this;
                        if (!browseFragment3.mShowingHeaders) {
                            browseFragment3.startHeadersTransitionInternal(true);
                        }
                    }
                }
            }
        }

        public boolean onRequestFocusInDescendants(int i5, Rect rect) {
            HeadersFragment headersFragment;
            if (BrowseFragment.this.getChildFragmentManager().isDestroyed()) {
                return true;
            }
            BrowseFragment browseFragment = BrowseFragment.this;
            if (browseFragment.mCanShowHeaders && browseFragment.mShowingHeaders && (headersFragment = browseFragment.mHeadersFragment) != null && headersFragment.getView() != null && BrowseFragment.this.mHeadersFragment.getView().requestFocus(i5, rect)) {
                return true;
            }
            Fragment fragment = BrowseFragment.this.mMainFragment;
            if (fragment != null && fragment.getView() != null && BrowseFragment.this.mMainFragment.getView().requestFocus(i5, rect)) {
                return true;
            }
            if (BrowseFragment.this.getTitleView() == null || !BrowseFragment.this.getTitleView().requestFocus(i5, rect)) {
                return false;
            }
            return true;
        }
    };
    private final BrowseFrameLayout.OnFocusSearchListener mOnFocusSearchListener = new BrowseFrameLayout.OnFocusSearchListener() {
        public View onFocusSearch(View view, int i5) {
            int i6;
            Fragment fragment;
            BrowseFragment browseFragment = BrowseFragment.this;
            if (browseFragment.mCanShowHeaders && browseFragment.isInHeadersTransition()) {
                return view;
            }
            if (BrowseFragment.this.getTitleView() != null && view != BrowseFragment.this.getTitleView() && i5 == 33) {
                return BrowseFragment.this.getTitleView();
            }
            if (BrowseFragment.this.getTitleView() == null || !BrowseFragment.this.getTitleView().hasFocus() || i5 != 130) {
                boolean z4 = true;
                if (view.getLayoutDirection() != 1) {
                    z4 = false;
                }
                int i7 = 17;
                if (z4) {
                    i6 = 66;
                } else {
                    i6 = 17;
                }
                if (!z4) {
                    i7 = 66;
                }
                BrowseFragment browseFragment2 = BrowseFragment.this;
                if (!browseFragment2.mCanShowHeaders || i5 != i6) {
                    if (i5 == i7) {
                        if (!(browseFragment2.isVerticalScrolling() || (fragment = BrowseFragment.this.mMainFragment) == null || fragment.getView() == null)) {
                            return BrowseFragment.this.mMainFragment.getView();
                        }
                    } else if (i5 != 130 || !browseFragment2.mShowingHeaders) {
                        return null;
                    }
                } else if (!browseFragment2.isVerticalScrolling()) {
                    BrowseFragment browseFragment3 = BrowseFragment.this;
                    if (!browseFragment3.mShowingHeaders && browseFragment3.isHeadersDataReady()) {
                        return BrowseFragment.this.mHeadersFragment.getVerticalGridView();
                    }
                }
                return view;
            }
            BrowseFragment browseFragment4 = BrowseFragment.this;
            if (!browseFragment4.mCanShowHeaders || !browseFragment4.mShowingHeaders) {
                return browseFragment4.mMainFragment.getView();
            }
            return browseFragment4.mHeadersFragment.getVerticalGridView();
        }
    };
    private OnItemViewClickedListener mOnItemViewClickedListener;
    Object mPageRow;
    private float mScaleFactor;
    private ScaleFrameLayout mScaleFrameLayout;
    private Object mSceneAfterEntranceTransition;
    Object mSceneWithHeaders;
    Object mSceneWithoutHeaders;
    private int mSelectedPosition = -1;
    private final SetSelectionRunnable mSetSelectionRunnable = new SetSelectionRunnable();
    boolean mShowingHeaders = true;
    boolean mStopped = true;
    private final RecyclerView.OnScrollListener mWaitScrollFinishAndCommitMainFragment = new RecyclerView.OnScrollListener() {
        public void onScrollStateChanged(RecyclerView recyclerView, int i5) {
            if (i5 == 0) {
                recyclerView.removeOnScrollListener(this);
                BrowseFragment browseFragment = BrowseFragment.this;
                if (!browseFragment.mStopped) {
                    browseFragment.commitMainFragment();
                }
            }
        }
    };
    String mWithHeadersBackStackName;

    final class BackStackListener implements FragmentManager.OnBackStackChangedListener {
        int mIndexOfHeadersBackStack = -1;
        int mLastEntryCount;

        BackStackListener() {
            this.mLastEntryCount = BrowseFragment.this.getFragmentManager().getBackStackEntryCount();
        }

        /* access modifiers changed from: package-private */
        public void load(Bundle bundle) {
            boolean z4;
            if (bundle != null) {
                int i5 = bundle.getInt(BrowseFragment.HEADER_STACK_INDEX, -1);
                this.mIndexOfHeadersBackStack = i5;
                BrowseFragment browseFragment = BrowseFragment.this;
                if (i5 == -1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                browseFragment.mShowingHeaders = z4;
                return;
            }
            BrowseFragment browseFragment2 = BrowseFragment.this;
            if (!browseFragment2.mShowingHeaders) {
                browseFragment2.getFragmentManager().beginTransaction().addToBackStack(BrowseFragment.this.mWithHeadersBackStackName).commit();
            }
        }

        public void onBackStackChanged() {
            if (BrowseFragment.this.getFragmentManager() == null) {
                Log.w(BrowseFragment.TAG, "getFragmentManager() is null, stack:", new Exception());
                return;
            }
            int backStackEntryCount = BrowseFragment.this.getFragmentManager().getBackStackEntryCount();
            int i5 = this.mLastEntryCount;
            if (backStackEntryCount > i5) {
                int i6 = backStackEntryCount - 1;
                if (BrowseFragment.this.mWithHeadersBackStackName.equals(BrowseFragment.this.getFragmentManager().getBackStackEntryAt(i6).getName())) {
                    this.mIndexOfHeadersBackStack = i6;
                }
            } else if (backStackEntryCount < i5 && this.mIndexOfHeadersBackStack >= backStackEntryCount) {
                if (!BrowseFragment.this.isHeadersDataReady()) {
                    BrowseFragment.this.getFragmentManager().beginTransaction().addToBackStack(BrowseFragment.this.mWithHeadersBackStackName).commit();
                    return;
                }
                this.mIndexOfHeadersBackStack = -1;
                BrowseFragment browseFragment = BrowseFragment.this;
                if (!browseFragment.mShowingHeaders) {
                    browseFragment.startHeadersTransitionInternal(true);
                }
            }
            this.mLastEntryCount = backStackEntryCount;
        }

        /* access modifiers changed from: package-private */
        public void save(Bundle bundle) {
            bundle.putInt(BrowseFragment.HEADER_STACK_INDEX, this.mIndexOfHeadersBackStack);
        }
    }

    @Deprecated
    public static class BrowseTransitionListener {
        public void onHeadersTransitionStart(boolean z4) {
        }

        public void onHeadersTransitionStop(boolean z4) {
        }
    }

    private class ExpandPreLayout implements ViewTreeObserver.OnPreDrawListener {
        static final int STATE_FIRST_DRAW = 1;
        static final int STATE_INIT = 0;
        static final int STATE_SECOND_DRAW = 2;
        private final Runnable mCallback;
        private int mState;
        private final View mView;
        private MainFragmentAdapter mainFragmentAdapter;

        ExpandPreLayout(Runnable runnable, MainFragmentAdapter mainFragmentAdapter2, View view) {
            this.mView = view;
            this.mCallback = runnable;
            this.mainFragmentAdapter = mainFragmentAdapter2;
        }

        /* access modifiers changed from: package-private */
        public void execute() {
            this.mView.getViewTreeObserver().addOnPreDrawListener(this);
            this.mainFragmentAdapter.setExpand(false);
            this.mView.invalidate();
            this.mState = 0;
        }

        public boolean onPreDraw() {
            if (BrowseFragment.this.getView() == null || FragmentUtil.getContext(BrowseFragment.this) == null) {
                this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
            int i5 = this.mState;
            if (i5 == 0) {
                this.mainFragmentAdapter.setExpand(true);
                this.mView.invalidate();
                this.mState = 1;
                return false;
            } else if (i5 != 1) {
                return false;
            } else {
                this.mCallback.run();
                this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
                this.mState = 2;
                return false;
            }
        }
    }

    @Deprecated
    public static abstract class FragmentFactory<T extends Fragment> {
        public abstract T createFragment(Object obj);
    }

    @Deprecated
    public interface FragmentHost {
        void notifyDataReady(MainFragmentAdapter mainFragmentAdapter);

        void notifyViewCreated(MainFragmentAdapter mainFragmentAdapter);

        void showTitleView(boolean z4);
    }

    private final class FragmentHostImpl implements FragmentHost {
        boolean mShowTitleView = true;

        FragmentHostImpl() {
        }

        public void notifyDataReady(MainFragmentAdapter mainFragmentAdapter) {
            MainFragmentAdapter mainFragmentAdapter2 = BrowseFragment.this.mMainFragmentAdapter;
            if (mainFragmentAdapter2 != null && mainFragmentAdapter2.getFragmentHost() == this) {
                BrowseFragment browseFragment = BrowseFragment.this;
                if (browseFragment.mIsPageRow) {
                    browseFragment.mStateMachine.fireEvent(browseFragment.EVT_SCREEN_DATA_READY);
                }
            }
        }

        public void notifyViewCreated(MainFragmentAdapter mainFragmentAdapter) {
            BrowseFragment browseFragment = BrowseFragment.this;
            browseFragment.mStateMachine.fireEvent(browseFragment.EVT_MAIN_FRAGMENT_VIEW_CREATED);
            BrowseFragment browseFragment2 = BrowseFragment.this;
            if (!browseFragment2.mIsPageRow) {
                browseFragment2.mStateMachine.fireEvent(browseFragment2.EVT_SCREEN_DATA_READY);
            }
        }

        public void showTitleView(boolean z4) {
            this.mShowTitleView = z4;
            MainFragmentAdapter mainFragmentAdapter = BrowseFragment.this.mMainFragmentAdapter;
            if (mainFragmentAdapter != null && mainFragmentAdapter.getFragmentHost() == this) {
                BrowseFragment browseFragment = BrowseFragment.this;
                if (browseFragment.mIsPageRow) {
                    browseFragment.updateTitleViewVisibility();
                }
            }
        }
    }

    @Deprecated
    public static class ListRowFragmentFactory extends FragmentFactory<RowsFragment> {
        public RowsFragment createFragment(Object obj) {
            return new RowsFragment();
        }
    }

    @Deprecated
    public static class MainFragmentAdapter<T extends Fragment> {
        private final T mFragment;
        FragmentHostImpl mFragmentHost;
        private boolean mScalingEnabled;

        public MainFragmentAdapter(T t5) {
            this.mFragment = t5;
        }

        public final T getFragment() {
            return this.mFragment;
        }

        public final FragmentHost getFragmentHost() {
            return this.mFragmentHost;
        }

        public boolean isScalingEnabled() {
            return this.mScalingEnabled;
        }

        public boolean isScrolling() {
            return false;
        }

        public void onTransitionEnd() {
        }

        public boolean onTransitionPrepare() {
            return false;
        }

        public void onTransitionStart() {
        }

        public void setAlignment(int i5) {
        }

        public void setEntranceTransitionState(boolean z4) {
        }

        public void setExpand(boolean z4) {
        }

        /* access modifiers changed from: package-private */
        public void setFragmentHost(FragmentHostImpl fragmentHostImpl) {
            this.mFragmentHost = fragmentHostImpl;
        }

        public void setScalingEnabled(boolean z4) {
            this.mScalingEnabled = z4;
        }
    }

    @Deprecated
    public interface MainFragmentAdapterProvider {
        MainFragmentAdapter getMainFragmentAdapter();
    }

    @Deprecated
    public static final class MainFragmentAdapterRegistry {
        private static final FragmentFactory sDefaultFragmentFactory = new ListRowFragmentFactory();
        private final Map<Class<?>, FragmentFactory> mItemToFragmentFactoryMapping = new HashMap();

        public MainFragmentAdapterRegistry() {
            registerFragment(ListRow.class, sDefaultFragmentFactory);
        }

        public Fragment createFragment(Object obj) {
            FragmentFactory fragmentFactory;
            if (obj == null) {
                fragmentFactory = sDefaultFragmentFactory;
            } else {
                fragmentFactory = this.mItemToFragmentFactoryMapping.get(obj.getClass());
            }
            if (fragmentFactory == null && !(obj instanceof PageRow)) {
                fragmentFactory = sDefaultFragmentFactory;
            }
            return fragmentFactory.createFragment(obj);
        }

        public void registerFragment(Class<?> cls, FragmentFactory fragmentFactory) {
            this.mItemToFragmentFactoryMapping.put(cls, fragmentFactory);
        }
    }

    class MainFragmentItemViewSelectedListener implements OnItemViewSelectedListener {
        MainFragmentRowsAdapter mMainFragmentRowsAdapter;

        public MainFragmentItemViewSelectedListener(MainFragmentRowsAdapter mainFragmentRowsAdapter) {
            this.mMainFragmentRowsAdapter = mainFragmentRowsAdapter;
        }

        public void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
            BrowseFragment.this.onRowSelected(this.mMainFragmentRowsAdapter.getSelectedPosition());
            OnItemViewSelectedListener onItemViewSelectedListener = BrowseFragment.this.mExternalOnItemViewSelectedListener;
            if (onItemViewSelectedListener != null) {
                onItemViewSelectedListener.onItemSelected(viewHolder, obj, viewHolder2, row);
            }
        }
    }

    @Deprecated
    public static class MainFragmentRowsAdapter<T extends Fragment> {
        private final T mFragment;

        public MainFragmentRowsAdapter(T t5) {
            if (t5 != null) {
                this.mFragment = t5;
                return;
            }
            throw new IllegalArgumentException("Fragment can't be null");
        }

        public RowPresenter.ViewHolder findRowViewHolderByPosition(int i5) {
            return null;
        }

        public final T getFragment() {
            return this.mFragment;
        }

        public int getSelectedPosition() {
            return 0;
        }

        public void setAdapter(ObjectAdapter objectAdapter) {
        }

        public void setOnItemViewClickedListener(OnItemViewClickedListener onItemViewClickedListener) {
        }

        public void setOnItemViewSelectedListener(OnItemViewSelectedListener onItemViewSelectedListener) {
        }

        public void setSelectedPosition(int i5, boolean z4) {
        }

        public void setSelectedPosition(int i5, boolean z4, Presenter.ViewHolderTask viewHolderTask) {
        }
    }

    @Deprecated
    public interface MainFragmentRowsAdapterProvider {
        MainFragmentRowsAdapter getMainFragmentRowsAdapter();
    }

    private final class SetSelectionRunnable implements Runnable {
        static final int TYPE_INTERNAL_SYNC = 0;
        static final int TYPE_INVALID = -1;
        static final int TYPE_USER_REQUEST = 1;
        private int mPosition;
        private boolean mSmooth;
        private int mType;

        SetSelectionRunnable() {
            reset();
        }

        private void reset() {
            this.mPosition = -1;
            this.mType = -1;
            this.mSmooth = false;
        }

        /* access modifiers changed from: package-private */
        public void post(int i5, int i6, boolean z4) {
            if (i6 >= this.mType) {
                this.mPosition = i5;
                this.mType = i6;
                this.mSmooth = z4;
                BrowseFragment.this.mBrowseFrame.removeCallbacks(this);
                BrowseFragment browseFragment = BrowseFragment.this;
                if (!browseFragment.mStopped) {
                    browseFragment.mBrowseFrame.post(this);
                }
            }
        }

        public void run() {
            BrowseFragment.this.setSelection(this.mPosition, this.mSmooth);
            reset();
        }

        public void start() {
            if (this.mType != -1) {
                BrowseFragment.this.mBrowseFrame.post(this);
            }
        }

        public void stop() {
            BrowseFragment.this.mBrowseFrame.removeCallbacks(this);
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        Class<BrowseFragment> cls = BrowseFragment.class;
        sb.append(cls.getCanonicalName());
        sb.append(".title");
        ARG_TITLE = sb.toString();
        ARG_HEADERS_STATE = cls.getCanonicalName() + ".headersState";
    }

    public static Bundle createArgs(Bundle bundle, String str, int i5) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(ARG_TITLE, str);
        bundle.putInt(ARG_HEADERS_STATE, i5);
        return bundle;
    }

    private boolean createMainFragment(ObjectAdapter objectAdapter, int i5) {
        Object obj;
        boolean z4;
        boolean z5 = true;
        Object obj2 = null;
        if (!this.mCanShowHeaders) {
            obj = null;
        } else if (objectAdapter == null || objectAdapter.size() == 0) {
            return false;
        } else {
            if (i5 < 0) {
                i5 = 0;
            } else if (i5 >= objectAdapter.size()) {
                throw new IllegalArgumentException(String.format("Invalid position %d requested", new Object[]{Integer.valueOf(i5)}));
            }
            obj = objectAdapter.get(i5);
        }
        boolean z6 = this.mIsPageRow;
        Object obj3 = this.mPageRow;
        if (!this.mCanShowHeaders || !(obj instanceof PageRow)) {
            z4 = false;
        } else {
            z4 = true;
        }
        this.mIsPageRow = z4;
        if (z4) {
            obj2 = obj;
        }
        this.mPageRow = obj2;
        if (this.mMainFragment != null) {
            if (!z6) {
                z5 = z4;
            } else if (z4 && (obj3 == null || obj3 == obj2)) {
                z5 = false;
            }
        }
        if (!z5) {
            return z5;
        }
        Fragment createFragment = this.mMainFragmentAdapterRegistry.createFragment(obj);
        this.mMainFragment = createFragment;
        if (createFragment instanceof MainFragmentAdapterProvider) {
            setMainFragmentAdapter();
            return z5;
        }
        throw new IllegalArgumentException("Fragment must implement MainFragmentAdapterProvider");
    }

    private void expandMainFragment(boolean z4) {
        int i5;
        float f5;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mScaleFrameLayout.getLayoutParams();
        if (!z4) {
            i5 = this.mContainerListMarginStart;
        } else {
            i5 = 0;
        }
        marginLayoutParams.setMarginStart(i5);
        this.mScaleFrameLayout.setLayoutParams(marginLayoutParams);
        this.mMainFragmentAdapter.setExpand(z4);
        setMainFragmentAlignment();
        if (z4 || !this.mMainFragmentScaleEnabled || !this.mMainFragmentAdapter.isScalingEnabled()) {
            f5 = 1.0f;
        } else {
            f5 = this.mScaleFactor;
        }
        this.mScaleFrameLayout.setLayoutScaleY(f5);
        this.mScaleFrameLayout.setChildScale(f5);
    }

    private void onExpandTransitionStart(boolean z4, Runnable runnable) {
        if (z4) {
            runnable.run();
        } else {
            new ExpandPreLayout(runnable, this.mMainFragmentAdapter, getView()).execute();
        }
    }

    private void readArguments(Bundle bundle) {
        if (bundle != null) {
            String str = ARG_TITLE;
            if (bundle.containsKey(str)) {
                setTitle(bundle.getString(str));
            }
            String str2 = ARG_HEADERS_STATE;
            if (bundle.containsKey(str2)) {
                setHeadersState(bundle.getInt(str2));
            }
        }
    }

    private void replaceMainFragment(int i5) {
        boolean z4;
        if (createMainFragment(this.mAdapter, i5)) {
            swapToMainFragment();
            if (!this.mCanShowHeaders || !this.mShowingHeaders) {
                z4 = true;
            } else {
                z4 = false;
            }
            expandMainFragment(z4);
        }
    }

    private void setHeadersOnScreen(boolean z4) {
        int i5;
        View view = this.mHeadersFragment.getView();
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (z4) {
                i5 = 0;
            } else {
                i5 = -this.mContainerListMarginStart;
            }
            marginLayoutParams.setMarginStart(i5);
            view.setLayoutParams(marginLayoutParams);
        }
    }

    private void setMainFragmentAlignment() {
        int i5 = this.mContainerListAlignTop;
        if (this.mMainFragmentScaleEnabled && this.mMainFragmentAdapter.isScalingEnabled() && this.mShowingHeaders) {
            i5 = (int) ((((float) i5) / this.mScaleFactor) + 0.5f);
        }
        this.mMainFragmentAdapter.setAlignment(i5);
    }

    private void swapToMainFragment() {
        if (!this.mStopped) {
            VerticalGridView verticalGridView = this.mHeadersFragment.getVerticalGridView();
            if (!isShowingHeaders() || verticalGridView == null || verticalGridView.getScrollState() == 0) {
                commitMainFragment();
                return;
            }
            getChildFragmentManager().beginTransaction().replace(R.id.scale_frame, new Fragment()).commit();
            verticalGridView.removeOnScrollListener(this.mWaitScrollFinishAndCommitMainFragment);
            verticalGridView.addOnScrollListener(this.mWaitScrollFinishAndCommitMainFragment);
        }
    }

    private void updateWrapperPresenter() {
        ObjectAdapter objectAdapter = this.mAdapter;
        if (objectAdapter == null) {
            this.mAdapterPresenter = null;
            return;
        }
        final PresenterSelector presenterSelector = objectAdapter.getPresenterSelector();
        if (presenterSelector == null) {
            throw new IllegalArgumentException("Adapter.getPresenterSelector() is null");
        } else if (presenterSelector != this.mAdapterPresenter) {
            this.mAdapterPresenter = presenterSelector;
            Presenter[] presenters = presenterSelector.getPresenters();
            final InvisibleRowPresenter invisibleRowPresenter = new InvisibleRowPresenter();
            int length = presenters.length;
            final Presenter[] presenterArr = new Presenter[(length + 1)];
            System.arraycopy(presenterArr, 0, presenters, 0, presenters.length);
            presenterArr[length] = invisibleRowPresenter;
            this.mAdapter.setPresenterSelector(new PresenterSelector() {
                public Presenter getPresenter(Object obj) {
                    if (((Row) obj).isRenderedAsRowView()) {
                        return presenterSelector.getPresenter(obj);
                    }
                    return invisibleRowPresenter;
                }

                public Presenter[] getPresenters() {
                    return presenterArr;
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public final void commitMainFragment() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        int i5 = R.id.scale_frame;
        if (childFragmentManager.findFragmentById(i5) != this.mMainFragment) {
            childFragmentManager.beginTransaction().replace(i5, this.mMainFragment).commit();
        }
    }

    /* access modifiers changed from: protected */
    public Object createEntranceTransition() {
        return TransitionHelper.loadTransition(FragmentUtil.getContext(this), R.transition.lb_browse_entrance_transition);
    }

    /* access modifiers changed from: package-private */
    public void createHeadersTransition() {
        int i5;
        Context context = FragmentUtil.getContext(this);
        if (this.mShowingHeaders) {
            i5 = R.transition.lb_browse_headers_in;
        } else {
            i5 = R.transition.lb_browse_headers_out;
        }
        Object loadTransition = TransitionHelper.loadTransition(context, i5);
        this.mHeadersTransition = loadTransition;
        TransitionHelper.addTransitionListener(loadTransition, new TransitionListener() {
            public void onTransitionEnd(Object obj) {
                VerticalGridView verticalGridView;
                Fragment fragment;
                View view;
                BrowseFragment browseFragment = BrowseFragment.this;
                browseFragment.mHeadersTransition = null;
                MainFragmentAdapter mainFragmentAdapter = browseFragment.mMainFragmentAdapter;
                if (mainFragmentAdapter != null) {
                    mainFragmentAdapter.onTransitionEnd();
                    BrowseFragment browseFragment2 = BrowseFragment.this;
                    if (!browseFragment2.mShowingHeaders && (fragment = browseFragment2.mMainFragment) != null && (view = fragment.getView()) != null && !view.hasFocus()) {
                        view.requestFocus();
                    }
                }
                HeadersFragment headersFragment = BrowseFragment.this.mHeadersFragment;
                if (headersFragment != null) {
                    headersFragment.onTransitionEnd();
                    BrowseFragment browseFragment3 = BrowseFragment.this;
                    if (browseFragment3.mShowingHeaders && (verticalGridView = browseFragment3.mHeadersFragment.getVerticalGridView()) != null && !verticalGridView.hasFocus()) {
                        verticalGridView.requestFocus();
                    }
                }
                BrowseFragment.this.updateTitleViewVisibility();
                BrowseFragment browseFragment4 = BrowseFragment.this;
                BrowseTransitionListener browseTransitionListener = browseFragment4.mBrowseTransitionListener;
                if (browseTransitionListener != null) {
                    browseTransitionListener.onHeadersTransitionStop(browseFragment4.mShowingHeaders);
                }
            }

            public void onTransitionStart(Object obj) {
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void createStateMachineStates() {
        super.createStateMachineStates();
        this.mStateMachine.addState(this.STATE_SET_ENTRANCE_START_STATE);
    }

    /* access modifiers changed from: package-private */
    public void createStateMachineTransitions() {
        super.createStateMachineTransitions();
        this.mStateMachine.addTransition(this.STATE_ENTRANCE_ON_PREPARED, this.STATE_SET_ENTRANCE_START_STATE, this.EVT_HEADER_VIEW_CREATED);
        this.mStateMachine.addTransition(this.STATE_ENTRANCE_ON_PREPARED, this.STATE_ENTRANCE_ON_PREPARED_ON_CREATEVIEW, this.EVT_MAIN_FRAGMENT_VIEW_CREATED);
        this.mStateMachine.addTransition(this.STATE_ENTRANCE_ON_PREPARED, this.STATE_ENTRANCE_PERFORM, this.EVT_SCREEN_DATA_READY);
    }

    public void enableMainFragmentScaling(boolean z4) {
        this.mMainFragmentScaleEnabled = z4;
    }

    @Deprecated
    public void enableRowScaling(boolean z4) {
        enableMainFragmentScaling(z4);
    }

    public ObjectAdapter getAdapter() {
        return this.mAdapter;
    }

    @ColorInt
    public int getBrandColor() {
        return this.mBrandColor;
    }

    public HeadersFragment getHeadersFragment() {
        return this.mHeadersFragment;
    }

    public int getHeadersState() {
        return this.mHeadersState;
    }

    public Fragment getMainFragment() {
        return this.mMainFragment;
    }

    public final MainFragmentAdapterRegistry getMainFragmentRegistry() {
        return this.mMainFragmentAdapterRegistry;
    }

    public OnItemViewClickedListener getOnItemViewClickedListener() {
        return this.mOnItemViewClickedListener;
    }

    public OnItemViewSelectedListener getOnItemViewSelectedListener() {
        return this.mExternalOnItemViewSelectedListener;
    }

    public RowsFragment getRowsFragment() {
        Fragment fragment = this.mMainFragment;
        if (fragment instanceof RowsFragment) {
            return (RowsFragment) fragment;
        }
        return null;
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public RowPresenter.ViewHolder getSelectedRowViewHolder() {
        MainFragmentRowsAdapter mainFragmentRowsAdapter = this.mMainFragmentRowsAdapter;
        if (mainFragmentRowsAdapter == null) {
            return null;
        }
        return this.mMainFragmentRowsAdapter.findRowViewHolderByPosition(mainFragmentRowsAdapter.getSelectedPosition());
    }

    /* access modifiers changed from: package-private */
    public boolean isFirstRowWithContent(int i5) {
        ObjectAdapter objectAdapter = this.mAdapter;
        if (!(objectAdapter == null || objectAdapter.size() == 0)) {
            int i6 = 0;
            while (i6 < this.mAdapter.size()) {
                if (!((Row) this.mAdapter.get(i6)).isRenderedAsRowView()) {
                    i6++;
                } else if (i5 == i6) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isFirstRowWithContentOrPageRow(int i5) {
        ObjectAdapter objectAdapter = this.mAdapter;
        if (!(objectAdapter == null || objectAdapter.size() == 0)) {
            int i6 = 0;
            while (i6 < this.mAdapter.size()) {
                Row row = (Row) this.mAdapter.get(i6);
                if (!row.isRenderedAsRowView() && !(row instanceof PageRow)) {
                    i6++;
                } else if (i5 == i6) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean isHeadersDataReady() {
        ObjectAdapter objectAdapter = this.mAdapter;
        if (objectAdapter == null || objectAdapter.size() == 0) {
            return false;
        }
        return true;
    }

    public final boolean isHeadersTransitionOnBackEnabled() {
        return this.mHeadersBackStackEnabled;
    }

    public boolean isInHeadersTransition() {
        if (this.mHeadersTransition != null) {
            return true;
        }
        return false;
    }

    public boolean isShowingHeaders() {
        return this.mShowingHeaders;
    }

    /* access modifiers changed from: package-private */
    public boolean isVerticalScrolling() {
        if (this.mHeadersFragment.isScrolling() || this.mMainFragmentAdapter.isScrolling()) {
            return true;
        }
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context context = FragmentUtil.getContext(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.styleable.LeanbackTheme);
        this.mContainerListMarginStart = (int) obtainStyledAttributes.getDimension(R.styleable.LeanbackTheme_browseRowsMarginStart, (float) context.getResources().getDimensionPixelSize(R.dimen.lb_browse_rows_margin_start));
        this.mContainerListAlignTop = (int) obtainStyledAttributes.getDimension(R.styleable.LeanbackTheme_browseRowsMarginTop, (float) context.getResources().getDimensionPixelSize(R.dimen.lb_browse_rows_margin_top));
        obtainStyledAttributes.recycle();
        readArguments(getArguments());
        if (this.mCanShowHeaders) {
            if (this.mHeadersBackStackEnabled) {
                this.mWithHeadersBackStackName = LB_HEADERS_BACKSTACK + this;
                this.mBackStackChangedListener = new BackStackListener();
                getFragmentManager().addOnBackStackChangedListener(this.mBackStackChangedListener);
                this.mBackStackChangedListener.load(bundle);
            } else if (bundle != null) {
                this.mShowingHeaders = bundle.getBoolean(HEADER_SHOW);
            }
        }
        this.mScaleFactor = getResources().getFraction(R.fraction.lb_browse_rows_scale, 1, 1);
    }

    public HeadersFragment onCreateHeadersFragment() {
        return new HeadersFragment();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        boolean z4;
        int i5;
        FragmentManager childFragmentManager = getChildFragmentManager();
        int i6 = R.id.scale_frame;
        if (childFragmentManager.findFragmentById(i6) == null) {
            this.mHeadersFragment = onCreateHeadersFragment();
            createMainFragment(this.mAdapter, this.mSelectedPosition);
            FragmentTransaction replace = getChildFragmentManager().beginTransaction().replace(R.id.browse_headers_dock, this.mHeadersFragment);
            Fragment fragment = this.mMainFragment;
            if (fragment != null) {
                replace.replace(i6, fragment);
            } else {
                MainFragmentAdapter mainFragmentAdapter = new MainFragmentAdapter(null);
                this.mMainFragmentAdapter = mainFragmentAdapter;
                mainFragmentAdapter.setFragmentHost(new FragmentHostImpl());
            }
            replace.commit();
        } else {
            this.mHeadersFragment = (HeadersFragment) getChildFragmentManager().findFragmentById(R.id.browse_headers_dock);
            this.mMainFragment = getChildFragmentManager().findFragmentById(i6);
            if (bundle == null || !bundle.getBoolean(IS_PAGE_ROW, false)) {
                z4 = false;
            } else {
                z4 = true;
            }
            this.mIsPageRow = z4;
            if (bundle != null) {
                i5 = bundle.getInt(CURRENT_SELECTED_POSITION, 0);
            } else {
                i5 = 0;
            }
            this.mSelectedPosition = i5;
            setMainFragmentAdapter();
        }
        this.mHeadersFragment.setHeadersGone(true ^ this.mCanShowHeaders);
        PresenterSelector presenterSelector = this.mHeaderPresenterSelector;
        if (presenterSelector != null) {
            this.mHeadersFragment.setPresenterSelector(presenterSelector);
        }
        this.mHeadersFragment.setAdapter(this.mAdapter);
        this.mHeadersFragment.setOnHeaderViewSelectedListener(this.mHeaderViewSelectedListener);
        this.mHeadersFragment.setOnHeaderClickedListener(this.mHeaderClickedListener);
        View inflate = layoutInflater.inflate(R.layout.lb_browse_fragment, viewGroup, false);
        getProgressBarManager().setRootView((ViewGroup) inflate);
        BrowseFrameLayout browseFrameLayout = (BrowseFrameLayout) inflate.findViewById(R.id.browse_frame);
        this.mBrowseFrame = browseFrameLayout;
        browseFrameLayout.setOnChildFocusListener(this.mOnChildFocusListener);
        this.mBrowseFrame.setOnFocusSearchListener(this.mOnFocusSearchListener);
        installTitleView(layoutInflater, this.mBrowseFrame, bundle);
        ScaleFrameLayout scaleFrameLayout = (ScaleFrameLayout) inflate.findViewById(i6);
        this.mScaleFrameLayout = scaleFrameLayout;
        scaleFrameLayout.setPivotX(0.0f);
        this.mScaleFrameLayout.setPivotY((float) this.mContainerListAlignTop);
        if (this.mBrandColorSet) {
            this.mHeadersFragment.setBackgroundColor(this.mBrandColor);
        }
        this.mSceneWithHeaders = TransitionHelper.createScene(this.mBrowseFrame, new Runnable() {
            public void run() {
                BrowseFragment.this.showHeaders(true);
            }
        });
        this.mSceneWithoutHeaders = TransitionHelper.createScene(this.mBrowseFrame, new Runnable() {
            public void run() {
                BrowseFragment.this.showHeaders(false);
            }
        });
        this.mSceneAfterEntranceTransition = TransitionHelper.createScene(this.mBrowseFrame, new Runnable() {
            public void run() {
                BrowseFragment.this.setEntranceTransitionEndState();
            }
        });
        return inflate;
    }

    public void onDestroy() {
        if (this.mBackStackChangedListener != null) {
            getFragmentManager().removeOnBackStackChangedListener(this.mBackStackChangedListener);
        }
        super.onDestroy();
    }

    public void onDestroyView() {
        setMainFragmentRowsAdapter((MainFragmentRowsAdapter) null);
        this.mPageRow = null;
        this.mMainFragmentAdapter = null;
        this.mMainFragment = null;
        this.mHeadersFragment = null;
        this.mBrowseFrame = null;
        this.mScaleFrameLayout = null;
        this.mSceneAfterEntranceTransition = null;
        this.mSceneWithHeaders = null;
        this.mSceneWithoutHeaders = null;
        super.onDestroyView();
    }

    /* access modifiers changed from: protected */
    public void onEntranceTransitionEnd() {
        MainFragmentAdapter mainFragmentAdapter = this.mMainFragmentAdapter;
        if (mainFragmentAdapter != null) {
            mainFragmentAdapter.onTransitionEnd();
        }
        HeadersFragment headersFragment = this.mHeadersFragment;
        if (headersFragment != null) {
            headersFragment.onTransitionEnd();
        }
    }

    /* access modifiers changed from: protected */
    public void onEntranceTransitionPrepare() {
        this.mHeadersFragment.onTransitionPrepare();
        this.mMainFragmentAdapter.setEntranceTransitionState(false);
        this.mMainFragmentAdapter.onTransitionPrepare();
    }

    /* access modifiers changed from: protected */
    public void onEntranceTransitionStart() {
        this.mHeadersFragment.onTransitionStart();
        this.mMainFragmentAdapter.onTransitionStart();
    }

    /* access modifiers changed from: package-private */
    public void onRowSelected(int i5) {
        this.mSetSelectionRunnable.post(i5, 0, true);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(CURRENT_SELECTED_POSITION, this.mSelectedPosition);
        bundle.putBoolean(IS_PAGE_ROW, this.mIsPageRow);
        BackStackListener backStackListener = this.mBackStackChangedListener;
        if (backStackListener != null) {
            backStackListener.save(bundle);
        } else {
            bundle.putBoolean(HEADER_SHOW, this.mShowingHeaders);
        }
    }

    public void onStart() {
        Fragment fragment;
        HeadersFragment headersFragment;
        super.onStart();
        this.mHeadersFragment.setAlignment(this.mContainerListAlignTop);
        setMainFragmentAlignment();
        if (this.mCanShowHeaders && this.mShowingHeaders && (headersFragment = this.mHeadersFragment) != null && headersFragment.getView() != null) {
            this.mHeadersFragment.getView().requestFocus();
        } else if (!((this.mCanShowHeaders && this.mShowingHeaders) || (fragment = this.mMainFragment) == null || fragment.getView() == null)) {
            this.mMainFragment.getView().requestFocus();
        }
        if (this.mCanShowHeaders) {
            showHeaders(this.mShowingHeaders);
        }
        this.mStateMachine.fireEvent(this.EVT_HEADER_VIEW_CREATED);
        this.mStopped = false;
        commitMainFragment();
        this.mSetSelectionRunnable.start();
    }

    public void onStop() {
        this.mStopped = true;
        this.mSetSelectionRunnable.stop();
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void runEntranceTransition(Object obj) {
        TransitionHelper.runTransition(this.mSceneAfterEntranceTransition, obj);
    }

    public void setAdapter(ObjectAdapter objectAdapter) {
        this.mAdapter = objectAdapter;
        updateWrapperPresenter();
        if (getView() != null) {
            updateMainFragmentRowsAdapter();
            this.mHeadersFragment.setAdapter(this.mAdapter);
        }
    }

    public void setBrandColor(@ColorInt int i5) {
        this.mBrandColor = i5;
        this.mBrandColorSet = true;
        HeadersFragment headersFragment = this.mHeadersFragment;
        if (headersFragment != null) {
            headersFragment.setBackgroundColor(i5);
        }
    }

    public void setBrowseTransitionListener(BrowseTransitionListener browseTransitionListener) {
        this.mBrowseTransitionListener = browseTransitionListener;
    }

    /* access modifiers changed from: package-private */
    public void setEntranceTransitionEndState() {
        setHeadersOnScreen(this.mShowingHeaders);
        setSearchOrbViewOnScreen(true);
        this.mMainFragmentAdapter.setEntranceTransitionState(true);
    }

    /* access modifiers changed from: package-private */
    public void setEntranceTransitionStartState() {
        setHeadersOnScreen(false);
        setSearchOrbViewOnScreen(false);
    }

    public void setHeaderPresenterSelector(PresenterSelector presenterSelector) {
        this.mHeaderPresenterSelector = presenterSelector;
        HeadersFragment headersFragment = this.mHeadersFragment;
        if (headersFragment != null) {
            headersFragment.setPresenterSelector(presenterSelector);
        }
    }

    public void setHeadersState(int i5) {
        if (i5 < 1 || i5 > 3) {
            throw new IllegalArgumentException("Invalid headers state: " + i5);
        } else if (i5 != this.mHeadersState) {
            this.mHeadersState = i5;
            if (i5 == 1) {
                this.mCanShowHeaders = true;
                this.mShowingHeaders = true;
            } else if (i5 == 2) {
                this.mCanShowHeaders = true;
                this.mShowingHeaders = false;
            } else if (i5 != 3) {
                Log.w(TAG, "Unknown headers state: " + i5);
            } else {
                this.mCanShowHeaders = false;
                this.mShowingHeaders = false;
            }
            HeadersFragment headersFragment = this.mHeadersFragment;
            if (headersFragment != null) {
                headersFragment.setHeadersGone(true ^ this.mCanShowHeaders);
            }
        }
    }

    public final void setHeadersTransitionOnBackEnabled(boolean z4) {
        this.mHeadersBackStackEnabled = z4;
    }

    /* access modifiers changed from: package-private */
    public void setMainFragmentAdapter() {
        boolean z4;
        MainFragmentAdapter mainFragmentAdapter = ((MainFragmentAdapterProvider) this.mMainFragment).getMainFragmentAdapter();
        this.mMainFragmentAdapter = mainFragmentAdapter;
        mainFragmentAdapter.setFragmentHost(new FragmentHostImpl());
        if (!this.mIsPageRow) {
            Fragment fragment = this.mMainFragment;
            if (fragment instanceof MainFragmentRowsAdapterProvider) {
                setMainFragmentRowsAdapter(((MainFragmentRowsAdapterProvider) fragment).getMainFragmentRowsAdapter());
            } else {
                setMainFragmentRowsAdapter((MainFragmentRowsAdapter) null);
            }
            if (this.mMainFragmentRowsAdapter == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.mIsPageRow = z4;
            return;
        }
        setMainFragmentRowsAdapter((MainFragmentRowsAdapter) null);
    }

    /* access modifiers changed from: package-private */
    public void setMainFragmentRowsAdapter(MainFragmentRowsAdapter mainFragmentRowsAdapter) {
        MainFragmentRowsAdapter mainFragmentRowsAdapter2 = this.mMainFragmentRowsAdapter;
        if (mainFragmentRowsAdapter != mainFragmentRowsAdapter2) {
            if (mainFragmentRowsAdapter2 != null) {
                mainFragmentRowsAdapter2.setAdapter((ObjectAdapter) null);
            }
            this.mMainFragmentRowsAdapter = mainFragmentRowsAdapter;
            if (mainFragmentRowsAdapter != null) {
                mainFragmentRowsAdapter.setOnItemViewSelectedListener(new MainFragmentItemViewSelectedListener(mainFragmentRowsAdapter));
                this.mMainFragmentRowsAdapter.setOnItemViewClickedListener(this.mOnItemViewClickedListener);
            }
            updateMainFragmentRowsAdapter();
        }
    }

    public void setOnItemViewClickedListener(OnItemViewClickedListener onItemViewClickedListener) {
        this.mOnItemViewClickedListener = onItemViewClickedListener;
        MainFragmentRowsAdapter mainFragmentRowsAdapter = this.mMainFragmentRowsAdapter;
        if (mainFragmentRowsAdapter != null) {
            mainFragmentRowsAdapter.setOnItemViewClickedListener(onItemViewClickedListener);
        }
    }

    public void setOnItemViewSelectedListener(OnItemViewSelectedListener onItemViewSelectedListener) {
        this.mExternalOnItemViewSelectedListener = onItemViewSelectedListener;
    }

    /* access modifiers changed from: package-private */
    public void setSearchOrbViewOnScreen(boolean z4) {
        int i5;
        View searchAffordanceView = getTitleViewAdapter().getSearchAffordanceView();
        if (searchAffordanceView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) searchAffordanceView.getLayoutParams();
            if (z4) {
                i5 = 0;
            } else {
                i5 = -this.mContainerListMarginStart;
            }
            marginLayoutParams.setMarginStart(i5);
            searchAffordanceView.setLayoutParams(marginLayoutParams);
        }
    }

    public void setSelectedPosition(int i5) {
        setSelectedPosition(i5, true);
    }

    /* access modifiers changed from: package-private */
    public void setSelection(int i5, boolean z4) {
        if (i5 != -1) {
            this.mSelectedPosition = i5;
            HeadersFragment headersFragment = this.mHeadersFragment;
            if (headersFragment != null && this.mMainFragmentAdapter != null) {
                headersFragment.setSelectedPosition(i5, z4);
                replaceMainFragment(i5);
                MainFragmentRowsAdapter mainFragmentRowsAdapter = this.mMainFragmentRowsAdapter;
                if (mainFragmentRowsAdapter != null) {
                    mainFragmentRowsAdapter.setSelectedPosition(i5, z4);
                }
                updateTitleViewVisibility();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void showHeaders(boolean z4) {
        this.mHeadersFragment.setHeadersEnabled(z4);
        setHeadersOnScreen(z4);
        expandMainFragment(!z4);
    }

    public void startHeadersTransition(boolean z4) {
        if (!this.mCanShowHeaders) {
            throw new IllegalStateException("Cannot start headers transition");
        } else if (!isInHeadersTransition() && this.mShowingHeaders != z4) {
            startHeadersTransitionInternal(z4);
        }
    }

    /* access modifiers changed from: package-private */
    public void startHeadersTransitionInternal(final boolean z4) {
        if (!getFragmentManager().isDestroyed() && isHeadersDataReady()) {
            this.mShowingHeaders = z4;
            this.mMainFragmentAdapter.onTransitionPrepare();
            this.mMainFragmentAdapter.onTransitionStart();
            onExpandTransitionStart(!z4, new Runnable() {
                public void run() {
                    Object obj;
                    BrowseFragment.this.mHeadersFragment.onTransitionPrepare();
                    BrowseFragment.this.mHeadersFragment.onTransitionStart();
                    BrowseFragment.this.createHeadersTransition();
                    BrowseTransitionListener browseTransitionListener = BrowseFragment.this.mBrowseTransitionListener;
                    if (browseTransitionListener != null) {
                        browseTransitionListener.onHeadersTransitionStart(z4);
                    }
                    if (z4) {
                        obj = BrowseFragment.this.mSceneWithHeaders;
                    } else {
                        obj = BrowseFragment.this.mSceneWithoutHeaders;
                    }
                    TransitionHelper.runTransition(obj, BrowseFragment.this.mHeadersTransition);
                    BrowseFragment browseFragment = BrowseFragment.this;
                    if (!browseFragment.mHeadersBackStackEnabled) {
                        return;
                    }
                    if (!z4) {
                        browseFragment.getFragmentManager().beginTransaction().addToBackStack(BrowseFragment.this.mWithHeadersBackStackName).commit();
                        return;
                    }
                    int i5 = browseFragment.mBackStackChangedListener.mIndexOfHeadersBackStack;
                    if (i5 >= 0) {
                        BrowseFragment.this.getFragmentManager().popBackStackImmediate(browseFragment.getFragmentManager().getBackStackEntryAt(i5).getId(), 1);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void updateMainFragmentRowsAdapter() {
        ListRowDataAdapter listRowDataAdapter = this.mMainFragmentListRowDataAdapter;
        ListRowDataAdapter listRowDataAdapter2 = null;
        if (listRowDataAdapter != null) {
            listRowDataAdapter.detach();
            this.mMainFragmentListRowDataAdapter = null;
        }
        if (this.mMainFragmentRowsAdapter != null) {
            ObjectAdapter objectAdapter = this.mAdapter;
            if (objectAdapter != null) {
                listRowDataAdapter2 = new ListRowDataAdapter(objectAdapter);
            }
            this.mMainFragmentListRowDataAdapter = listRowDataAdapter2;
            this.mMainFragmentRowsAdapter.setAdapter(listRowDataAdapter2);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateTitleViewVisibility() {
        boolean z4;
        int i5;
        MainFragmentAdapter mainFragmentAdapter;
        boolean z5;
        MainFragmentAdapter mainFragmentAdapter2;
        if (!this.mShowingHeaders) {
            if (!this.mIsPageRow || (mainFragmentAdapter2 = this.mMainFragmentAdapter) == null) {
                z5 = isFirstRowWithContent(this.mSelectedPosition);
            } else {
                z5 = mainFragmentAdapter2.mFragmentHost.mShowTitleView;
            }
            if (z5) {
                showTitle(6);
            } else {
                showTitle(false);
            }
        } else {
            if (!this.mIsPageRow || (mainFragmentAdapter = this.mMainFragmentAdapter) == null) {
                z4 = isFirstRowWithContent(this.mSelectedPosition);
            } else {
                z4 = mainFragmentAdapter.mFragmentHost.mShowTitleView;
            }
            boolean isFirstRowWithContentOrPageRow = isFirstRowWithContentOrPageRow(this.mSelectedPosition);
            if (z4) {
                i5 = 2;
            } else {
                i5 = 0;
            }
            if (isFirstRowWithContentOrPageRow) {
                i5 |= 4;
            }
            if (i5 != 0) {
                showTitle(i5);
            } else {
                showTitle(false);
            }
        }
    }

    public void setSelectedPosition(int i5, boolean z4) {
        this.mSetSelectionRunnable.post(i5, 1, z4);
    }

    public void setSelectedPosition(int i5, boolean z4, Presenter.ViewHolderTask viewHolderTask) {
        if (this.mMainFragmentAdapterRegistry != null) {
            if (viewHolderTask != null) {
                startHeadersTransition(false);
            }
            MainFragmentRowsAdapter mainFragmentRowsAdapter = this.mMainFragmentRowsAdapter;
            if (mainFragmentRowsAdapter != null) {
                mainFragmentRowsAdapter.setSelectedPosition(i5, z4, viewHolderTask);
            }
        }
    }
}
