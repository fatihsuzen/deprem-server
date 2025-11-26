package androidx.leanback.app;

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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.leanback.R;
import androidx.leanback.app.HeadersSupportFragment;
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

public class BrowseSupportFragment extends BaseSupportFragment {
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
    static final String TAG = "BrowseSupportFragment";
    final StateMachine.Event EVT_HEADER_VIEW_CREATED = new StateMachine.Event("headerFragmentViewCreated");
    final StateMachine.Event EVT_MAIN_FRAGMENT_VIEW_CREATED = new StateMachine.Event("mainFragmentViewCreated");
    final StateMachine.Event EVT_SCREEN_DATA_READY = new StateMachine.Event("screenDataReady");
    final StateMachine.State STATE_SET_ENTRANCE_START_STATE = new StateMachine.State("SET_ENTRANCE_START_STATE") {
        public void run() {
            BrowseSupportFragment.this.setEntranceTransitionStartState();
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
    private HeadersSupportFragment.OnHeaderClickedListener mHeaderClickedListener = new HeadersSupportFragment.OnHeaderClickedListener() {
        public void onHeaderClicked(RowHeaderPresenter.ViewHolder viewHolder, Row row) {
            Fragment fragment;
            BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
            if (browseSupportFragment.mCanShowHeaders && browseSupportFragment.mShowingHeaders && !browseSupportFragment.isInHeadersTransition() && (fragment = BrowseSupportFragment.this.mMainFragment) != null && fragment.getView() != null) {
                BrowseSupportFragment.this.startHeadersTransitionInternal(false);
                BrowseSupportFragment.this.mMainFragment.getView().requestFocus();
            }
        }
    };
    private PresenterSelector mHeaderPresenterSelector;
    private HeadersSupportFragment.OnHeaderViewSelectedListener mHeaderViewSelectedListener = new HeadersSupportFragment.OnHeaderViewSelectedListener() {
        public void onHeaderSelected(RowHeaderPresenter.ViewHolder viewHolder, Row row) {
            int selectedPosition = BrowseSupportFragment.this.mHeadersSupportFragment.getSelectedPosition();
            BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
            if (browseSupportFragment.mShowingHeaders) {
                browseSupportFragment.onRowSelected(selectedPosition);
            }
        }
    };
    boolean mHeadersBackStackEnabled = true;
    private int mHeadersState = 1;
    HeadersSupportFragment mHeadersSupportFragment;
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
            if (!BrowseSupportFragment.this.getChildFragmentManager().isDestroyed()) {
                BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
                if (browseSupportFragment.mCanShowHeaders && !browseSupportFragment.isInHeadersTransition()) {
                    int id = view.getId();
                    if (id == R.id.browse_container_dock) {
                        BrowseSupportFragment browseSupportFragment2 = BrowseSupportFragment.this;
                        if (browseSupportFragment2.mShowingHeaders) {
                            browseSupportFragment2.startHeadersTransitionInternal(false);
                            return;
                        }
                    }
                    if (id == R.id.browse_headers_dock) {
                        BrowseSupportFragment browseSupportFragment3 = BrowseSupportFragment.this;
                        if (!browseSupportFragment3.mShowingHeaders) {
                            browseSupportFragment3.startHeadersTransitionInternal(true);
                        }
                    }
                }
            }
        }

        public boolean onRequestFocusInDescendants(int i5, Rect rect) {
            HeadersSupportFragment headersSupportFragment;
            if (BrowseSupportFragment.this.getChildFragmentManager().isDestroyed()) {
                return true;
            }
            BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
            if (browseSupportFragment.mCanShowHeaders && browseSupportFragment.mShowingHeaders && (headersSupportFragment = browseSupportFragment.mHeadersSupportFragment) != null && headersSupportFragment.getView() != null && BrowseSupportFragment.this.mHeadersSupportFragment.getView().requestFocus(i5, rect)) {
                return true;
            }
            Fragment fragment = BrowseSupportFragment.this.mMainFragment;
            if (fragment != null && fragment.getView() != null && BrowseSupportFragment.this.mMainFragment.getView().requestFocus(i5, rect)) {
                return true;
            }
            if (BrowseSupportFragment.this.getTitleView() == null || !BrowseSupportFragment.this.getTitleView().requestFocus(i5, rect)) {
                return false;
            }
            return true;
        }
    };
    private final BrowseFrameLayout.OnFocusSearchListener mOnFocusSearchListener = new BrowseFrameLayout.OnFocusSearchListener() {
        public View onFocusSearch(View view, int i5) {
            int i6;
            Fragment fragment;
            BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
            if (browseSupportFragment.mCanShowHeaders && browseSupportFragment.isInHeadersTransition()) {
                return view;
            }
            if (BrowseSupportFragment.this.getTitleView() != null && view != BrowseSupportFragment.this.getTitleView() && i5 == 33) {
                return BrowseSupportFragment.this.getTitleView();
            }
            if (BrowseSupportFragment.this.getTitleView() == null || !BrowseSupportFragment.this.getTitleView().hasFocus() || i5 != 130) {
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
                BrowseSupportFragment browseSupportFragment2 = BrowseSupportFragment.this;
                if (!browseSupportFragment2.mCanShowHeaders || i5 != i6) {
                    if (i5 == i7) {
                        if (!(browseSupportFragment2.isVerticalScrolling() || (fragment = BrowseSupportFragment.this.mMainFragment) == null || fragment.getView() == null)) {
                            return BrowseSupportFragment.this.mMainFragment.getView();
                        }
                    } else if (i5 != 130 || !browseSupportFragment2.mShowingHeaders) {
                        return null;
                    }
                } else if (!browseSupportFragment2.isVerticalScrolling()) {
                    BrowseSupportFragment browseSupportFragment3 = BrowseSupportFragment.this;
                    if (!browseSupportFragment3.mShowingHeaders && browseSupportFragment3.isHeadersDataReady()) {
                        return BrowseSupportFragment.this.mHeadersSupportFragment.getVerticalGridView();
                    }
                }
                return view;
            }
            BrowseSupportFragment browseSupportFragment4 = BrowseSupportFragment.this;
            if (!browseSupportFragment4.mCanShowHeaders || !browseSupportFragment4.mShowingHeaders) {
                return browseSupportFragment4.mMainFragment.getView();
            }
            return browseSupportFragment4.mHeadersSupportFragment.getVerticalGridView();
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
                BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
                if (!browseSupportFragment.mStopped) {
                    browseSupportFragment.commitMainFragment();
                }
            }
        }
    };
    String mWithHeadersBackStackName;

    final class BackStackListener implements FragmentManager.OnBackStackChangedListener {
        int mIndexOfHeadersBackStack = -1;
        int mLastEntryCount;

        BackStackListener() {
            this.mLastEntryCount = BrowseSupportFragment.this.getFragmentManager().getBackStackEntryCount();
        }

        /* access modifiers changed from: package-private */
        public void load(Bundle bundle) {
            boolean z4;
            if (bundle != null) {
                int i5 = bundle.getInt(BrowseSupportFragment.HEADER_STACK_INDEX, -1);
                this.mIndexOfHeadersBackStack = i5;
                BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
                if (i5 == -1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                browseSupportFragment.mShowingHeaders = z4;
                return;
            }
            BrowseSupportFragment browseSupportFragment2 = BrowseSupportFragment.this;
            if (!browseSupportFragment2.mShowingHeaders) {
                browseSupportFragment2.getFragmentManager().beginTransaction().addToBackStack(BrowseSupportFragment.this.mWithHeadersBackStackName).commit();
            }
        }

        public void onBackStackChanged() {
            if (BrowseSupportFragment.this.getFragmentManager() == null) {
                Log.w(BrowseSupportFragment.TAG, "getFragmentManager() is null, stack:", new Exception());
                return;
            }
            int backStackEntryCount = BrowseSupportFragment.this.getFragmentManager().getBackStackEntryCount();
            int i5 = this.mLastEntryCount;
            if (backStackEntryCount > i5) {
                int i6 = backStackEntryCount - 1;
                if (BrowseSupportFragment.this.mWithHeadersBackStackName.equals(BrowseSupportFragment.this.getFragmentManager().getBackStackEntryAt(i6).getName())) {
                    this.mIndexOfHeadersBackStack = i6;
                }
            } else if (backStackEntryCount < i5 && this.mIndexOfHeadersBackStack >= backStackEntryCount) {
                if (!BrowseSupportFragment.this.isHeadersDataReady()) {
                    BrowseSupportFragment.this.getFragmentManager().beginTransaction().addToBackStack(BrowseSupportFragment.this.mWithHeadersBackStackName).commit();
                    return;
                }
                this.mIndexOfHeadersBackStack = -1;
                BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
                if (!browseSupportFragment.mShowingHeaders) {
                    browseSupportFragment.startHeadersTransitionInternal(true);
                }
            }
            this.mLastEntryCount = backStackEntryCount;
        }

        /* access modifiers changed from: package-private */
        public void save(Bundle bundle) {
            bundle.putInt(BrowseSupportFragment.HEADER_STACK_INDEX, this.mIndexOfHeadersBackStack);
        }
    }

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
            if (BrowseSupportFragment.this.getView() == null || BrowseSupportFragment.this.getContext() == null) {
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

    public static abstract class FragmentFactory<T extends Fragment> {
        public abstract T createFragment(Object obj);
    }

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
            MainFragmentAdapter mainFragmentAdapter2 = BrowseSupportFragment.this.mMainFragmentAdapter;
            if (mainFragmentAdapter2 != null && mainFragmentAdapter2.getFragmentHost() == this) {
                BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
                if (browseSupportFragment.mIsPageRow) {
                    browseSupportFragment.mStateMachine.fireEvent(browseSupportFragment.EVT_SCREEN_DATA_READY);
                }
            }
        }

        public void notifyViewCreated(MainFragmentAdapter mainFragmentAdapter) {
            BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
            browseSupportFragment.mStateMachine.fireEvent(browseSupportFragment.EVT_MAIN_FRAGMENT_VIEW_CREATED);
            BrowseSupportFragment browseSupportFragment2 = BrowseSupportFragment.this;
            if (!browseSupportFragment2.mIsPageRow) {
                browseSupportFragment2.mStateMachine.fireEvent(browseSupportFragment2.EVT_SCREEN_DATA_READY);
            }
        }

        public void showTitleView(boolean z4) {
            this.mShowTitleView = z4;
            MainFragmentAdapter mainFragmentAdapter = BrowseSupportFragment.this.mMainFragmentAdapter;
            if (mainFragmentAdapter != null && mainFragmentAdapter.getFragmentHost() == this) {
                BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
                if (browseSupportFragment.mIsPageRow) {
                    browseSupportFragment.updateTitleViewVisibility();
                }
            }
        }
    }

    public static class ListRowFragmentFactory extends FragmentFactory<RowsSupportFragment> {
        public RowsSupportFragment createFragment(Object obj) {
            return new RowsSupportFragment();
        }
    }

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

    public interface MainFragmentAdapterProvider {
        MainFragmentAdapter getMainFragmentAdapter();
    }

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
            BrowseSupportFragment.this.onRowSelected(this.mMainFragmentRowsAdapter.getSelectedPosition());
            OnItemViewSelectedListener onItemViewSelectedListener = BrowseSupportFragment.this.mExternalOnItemViewSelectedListener;
            if (onItemViewSelectedListener != null) {
                onItemViewSelectedListener.onItemSelected(viewHolder, obj, viewHolder2, row);
            }
        }
    }

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
                BrowseSupportFragment.this.mBrowseFrame.removeCallbacks(this);
                BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
                if (!browseSupportFragment.mStopped) {
                    browseSupportFragment.mBrowseFrame.post(this);
                }
            }
        }

        public void run() {
            BrowseSupportFragment.this.setSelection(this.mPosition, this.mSmooth);
            reset();
        }

        public void start() {
            if (this.mType != -1) {
                BrowseSupportFragment.this.mBrowseFrame.post(this);
            }
        }

        public void stop() {
            BrowseSupportFragment.this.mBrowseFrame.removeCallbacks(this);
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        Class<BrowseSupportFragment> cls = BrowseSupportFragment.class;
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
        View view = this.mHeadersSupportFragment.getView();
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
            VerticalGridView verticalGridView = this.mHeadersSupportFragment.getVerticalGridView();
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
        return TransitionHelper.loadTransition(getContext(), R.transition.lb_browse_entrance_transition);
    }

    /* access modifiers changed from: package-private */
    public void createHeadersTransition() {
        int i5;
        Context context = getContext();
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
                BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
                browseSupportFragment.mHeadersTransition = null;
                MainFragmentAdapter mainFragmentAdapter = browseSupportFragment.mMainFragmentAdapter;
                if (mainFragmentAdapter != null) {
                    mainFragmentAdapter.onTransitionEnd();
                    BrowseSupportFragment browseSupportFragment2 = BrowseSupportFragment.this;
                    if (!browseSupportFragment2.mShowingHeaders && (fragment = browseSupportFragment2.mMainFragment) != null && (view = fragment.getView()) != null && !view.hasFocus()) {
                        view.requestFocus();
                    }
                }
                HeadersSupportFragment headersSupportFragment = BrowseSupportFragment.this.mHeadersSupportFragment;
                if (headersSupportFragment != null) {
                    headersSupportFragment.onTransitionEnd();
                    BrowseSupportFragment browseSupportFragment3 = BrowseSupportFragment.this;
                    if (browseSupportFragment3.mShowingHeaders && (verticalGridView = browseSupportFragment3.mHeadersSupportFragment.getVerticalGridView()) != null && !verticalGridView.hasFocus()) {
                        verticalGridView.requestFocus();
                    }
                }
                BrowseSupportFragment.this.updateTitleViewVisibility();
                BrowseSupportFragment browseSupportFragment4 = BrowseSupportFragment.this;
                BrowseTransitionListener browseTransitionListener = browseSupportFragment4.mBrowseTransitionListener;
                if (browseTransitionListener != null) {
                    browseTransitionListener.onHeadersTransitionStop(browseSupportFragment4.mShowingHeaders);
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

    public int getHeadersState() {
        return this.mHeadersState;
    }

    public HeadersSupportFragment getHeadersSupportFragment() {
        return this.mHeadersSupportFragment;
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

    public RowsSupportFragment getRowsSupportFragment() {
        Fragment fragment = this.mMainFragment;
        if (fragment instanceof RowsSupportFragment) {
            return (RowsSupportFragment) fragment;
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
        if (this.mHeadersSupportFragment.isScrolling() || this.mMainFragmentAdapter.isScrolling()) {
            return true;
        }
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context context = getContext();
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

    public HeadersSupportFragment onCreateHeadersSupportFragment() {
        return new HeadersSupportFragment();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        boolean z4;
        int i5;
        FragmentManager childFragmentManager = getChildFragmentManager();
        int i6 = R.id.scale_frame;
        if (childFragmentManager.findFragmentById(i6) == null) {
            this.mHeadersSupportFragment = onCreateHeadersSupportFragment();
            createMainFragment(this.mAdapter, this.mSelectedPosition);
            FragmentTransaction replace = getChildFragmentManager().beginTransaction().replace(R.id.browse_headers_dock, this.mHeadersSupportFragment);
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
            this.mHeadersSupportFragment = (HeadersSupportFragment) getChildFragmentManager().findFragmentById(R.id.browse_headers_dock);
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
        this.mHeadersSupportFragment.setHeadersGone(true ^ this.mCanShowHeaders);
        PresenterSelector presenterSelector = this.mHeaderPresenterSelector;
        if (presenterSelector != null) {
            this.mHeadersSupportFragment.setPresenterSelector(presenterSelector);
        }
        this.mHeadersSupportFragment.setAdapter(this.mAdapter);
        this.mHeadersSupportFragment.setOnHeaderViewSelectedListener(this.mHeaderViewSelectedListener);
        this.mHeadersSupportFragment.setOnHeaderClickedListener(this.mHeaderClickedListener);
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
            this.mHeadersSupportFragment.setBackgroundColor(this.mBrandColor);
        }
        this.mSceneWithHeaders = TransitionHelper.createScene(this.mBrowseFrame, new Runnable() {
            public void run() {
                BrowseSupportFragment.this.showHeaders(true);
            }
        });
        this.mSceneWithoutHeaders = TransitionHelper.createScene(this.mBrowseFrame, new Runnable() {
            public void run() {
                BrowseSupportFragment.this.showHeaders(false);
            }
        });
        this.mSceneAfterEntranceTransition = TransitionHelper.createScene(this.mBrowseFrame, new Runnable() {
            public void run() {
                BrowseSupportFragment.this.setEntranceTransitionEndState();
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
        this.mHeadersSupportFragment = null;
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
        HeadersSupportFragment headersSupportFragment = this.mHeadersSupportFragment;
        if (headersSupportFragment != null) {
            headersSupportFragment.onTransitionEnd();
        }
    }

    /* access modifiers changed from: protected */
    public void onEntranceTransitionPrepare() {
        this.mHeadersSupportFragment.onTransitionPrepare();
        this.mMainFragmentAdapter.setEntranceTransitionState(false);
        this.mMainFragmentAdapter.onTransitionPrepare();
    }

    /* access modifiers changed from: protected */
    public void onEntranceTransitionStart() {
        this.mHeadersSupportFragment.onTransitionStart();
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
        HeadersSupportFragment headersSupportFragment;
        super.onStart();
        this.mHeadersSupportFragment.setAlignment(this.mContainerListAlignTop);
        setMainFragmentAlignment();
        if (this.mCanShowHeaders && this.mShowingHeaders && (headersSupportFragment = this.mHeadersSupportFragment) != null && headersSupportFragment.getView() != null) {
            this.mHeadersSupportFragment.getView().requestFocus();
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
            this.mHeadersSupportFragment.setAdapter(this.mAdapter);
        }
    }

    public void setBrandColor(@ColorInt int i5) {
        this.mBrandColor = i5;
        this.mBrandColorSet = true;
        HeadersSupportFragment headersSupportFragment = this.mHeadersSupportFragment;
        if (headersSupportFragment != null) {
            headersSupportFragment.setBackgroundColor(i5);
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
        HeadersSupportFragment headersSupportFragment = this.mHeadersSupportFragment;
        if (headersSupportFragment != null) {
            headersSupportFragment.setPresenterSelector(presenterSelector);
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
            HeadersSupportFragment headersSupportFragment = this.mHeadersSupportFragment;
            if (headersSupportFragment != null) {
                headersSupportFragment.setHeadersGone(true ^ this.mCanShowHeaders);
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
            HeadersSupportFragment headersSupportFragment = this.mHeadersSupportFragment;
            if (headersSupportFragment != null && this.mMainFragmentAdapter != null) {
                headersSupportFragment.setSelectedPosition(i5, z4);
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
        this.mHeadersSupportFragment.setHeadersEnabled(z4);
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
                    BrowseSupportFragment.this.mHeadersSupportFragment.onTransitionPrepare();
                    BrowseSupportFragment.this.mHeadersSupportFragment.onTransitionStart();
                    BrowseSupportFragment.this.createHeadersTransition();
                    BrowseTransitionListener browseTransitionListener = BrowseSupportFragment.this.mBrowseTransitionListener;
                    if (browseTransitionListener != null) {
                        browseTransitionListener.onHeadersTransitionStart(z4);
                    }
                    if (z4) {
                        obj = BrowseSupportFragment.this.mSceneWithHeaders;
                    } else {
                        obj = BrowseSupportFragment.this.mSceneWithoutHeaders;
                    }
                    TransitionHelper.runTransition(obj, BrowseSupportFragment.this.mHeadersTransition);
                    BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
                    if (!browseSupportFragment.mHeadersBackStackEnabled) {
                        return;
                    }
                    if (!z4) {
                        browseSupportFragment.getFragmentManager().beginTransaction().addToBackStack(BrowseSupportFragment.this.mWithHeadersBackStackName).commit();
                        return;
                    }
                    int i5 = browseSupportFragment.mBackStackChangedListener.mIndexOfHeadersBackStack;
                    if (i5 >= 0) {
                        BrowseSupportFragment.this.getFragmentManager().popBackStackImmediate(browseSupportFragment.getFragmentManager().getBackStackEntryAt(i5).getId(), 1);
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
