package androidx.leanback.app;

import android.animation.TimeAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.leanback.R;
import androidx.leanback.app.BrowseFragment;
import androidx.leanback.widget.BaseOnItemViewClickedListener;
import androidx.leanback.widget.BaseOnItemViewSelectedListener;
import androidx.leanback.widget.HorizontalGridView;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.VerticalGridView;
import androidx.leanback.widget.ViewHolderTask;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

@Deprecated
public class RowsFragment extends BaseRowFragment implements BrowseFragment.MainFragmentRowsAdapterProvider, BrowseFragment.MainFragmentAdapterProvider {
    static final int ALIGN_TOP_NOT_SET = Integer.MIN_VALUE;
    static final boolean DEBUG = false;
    static final String TAG = "RowsFragment";
    boolean mAfterEntranceTransition = true;
    private int mAlignedTop = Integer.MIN_VALUE;
    private final ItemBridgeAdapter.AdapterListener mBridgeAdapterListener = new ItemBridgeAdapter.AdapterListener() {
        public void onAddPresenter(Presenter presenter, int i5) {
            ItemBridgeAdapter.AdapterListener adapterListener = RowsFragment.this.mExternalAdapterListener;
            if (adapterListener != null) {
                adapterListener.onAddPresenter(presenter, i5);
            }
        }

        public void onAttachedToWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
            RowsFragment.setRowViewExpanded(viewHolder, RowsFragment.this.mExpand);
            RowPresenter rowPresenter = (RowPresenter) viewHolder.getPresenter();
            RowPresenter.ViewHolder rowViewHolder = rowPresenter.getRowViewHolder(viewHolder.getViewHolder());
            rowPresenter.setEntranceTransitionState(rowViewHolder, RowsFragment.this.mAfterEntranceTransition);
            rowViewHolder.setOnItemViewSelectedListener(RowsFragment.this.mOnItemViewSelectedListener);
            rowViewHolder.setOnItemViewClickedListener(RowsFragment.this.mOnItemViewClickedListener);
            rowPresenter.freeze(rowViewHolder, RowsFragment.this.mFreezeRows);
            ItemBridgeAdapter.AdapterListener adapterListener = RowsFragment.this.mExternalAdapterListener;
            if (adapterListener != null) {
                adapterListener.onAttachedToWindow(viewHolder);
            }
        }

        public void onBind(ItemBridgeAdapter.ViewHolder viewHolder) {
            ItemBridgeAdapter.AdapterListener adapterListener = RowsFragment.this.mExternalAdapterListener;
            if (adapterListener != null) {
                adapterListener.onBind(viewHolder);
            }
        }

        public void onCreate(ItemBridgeAdapter.ViewHolder viewHolder) {
            VerticalGridView verticalGridView = RowsFragment.this.getVerticalGridView();
            if (verticalGridView != null) {
                verticalGridView.setClipChildren(false);
            }
            RowsFragment.this.setupSharedViewPool(viewHolder);
            RowsFragment.this.mViewsCreated = true;
            viewHolder.setExtraObject(new RowViewHolderExtra(viewHolder));
            RowsFragment.setRowViewSelected(viewHolder, false, true);
            ItemBridgeAdapter.AdapterListener adapterListener = RowsFragment.this.mExternalAdapterListener;
            if (adapterListener != null) {
                adapterListener.onCreate(viewHolder);
            }
        }

        public void onDetachedFromWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
            ItemBridgeAdapter.ViewHolder viewHolder2 = RowsFragment.this.mSelectedViewHolder;
            if (viewHolder2 == viewHolder) {
                RowsFragment.setRowViewSelected(viewHolder2, false, true);
                RowsFragment.this.mSelectedViewHolder = null;
            }
            RowPresenter.ViewHolder rowViewHolder = ((RowPresenter) viewHolder.getPresenter()).getRowViewHolder(viewHolder.getViewHolder());
            rowViewHolder.setOnItemViewSelectedListener((BaseOnItemViewSelectedListener) null);
            rowViewHolder.setOnItemViewClickedListener((BaseOnItemViewClickedListener) null);
            ItemBridgeAdapter.AdapterListener adapterListener = RowsFragment.this.mExternalAdapterListener;
            if (adapterListener != null) {
                adapterListener.onDetachedFromWindow(viewHolder);
            }
        }

        public void onUnbind(ItemBridgeAdapter.ViewHolder viewHolder) {
            RowsFragment.setRowViewSelected(viewHolder, false, true);
            ItemBridgeAdapter.AdapterListener adapterListener = RowsFragment.this.mExternalAdapterListener;
            if (adapterListener != null) {
                adapterListener.onUnbind(viewHolder);
            }
        }
    };
    boolean mExpand = true;
    ItemBridgeAdapter.AdapterListener mExternalAdapterListener;
    boolean mFreezeRows;
    private MainFragmentAdapter mMainFragmentAdapter;
    private MainFragmentRowsAdapter mMainFragmentRowsAdapter;
    BaseOnItemViewClickedListener mOnItemViewClickedListener;
    BaseOnItemViewSelectedListener mOnItemViewSelectedListener;
    private ArrayList<Presenter> mPresenterMapper;
    private RecyclerView.RecycledViewPool mRecycledViewPool;
    ItemBridgeAdapter.ViewHolder mSelectedViewHolder;
    private int mSubPosition;
    boolean mViewsCreated;

    public static class MainFragmentAdapter extends BrowseFragment.MainFragmentAdapter<RowsFragment> {
        public MainFragmentAdapter(RowsFragment rowsFragment) {
            super(rowsFragment);
            setScalingEnabled(true);
        }

        public boolean isScrolling() {
            return ((RowsFragment) getFragment()).isScrolling();
        }

        public void onTransitionEnd() {
            ((RowsFragment) getFragment()).onTransitionEnd();
        }

        public boolean onTransitionPrepare() {
            return ((RowsFragment) getFragment()).onTransitionPrepare();
        }

        public void onTransitionStart() {
            ((RowsFragment) getFragment()).onTransitionStart();
        }

        public void setAlignment(int i5) {
            ((RowsFragment) getFragment()).setAlignment(i5);
        }

        public void setEntranceTransitionState(boolean z4) {
            ((RowsFragment) getFragment()).setEntranceTransitionState(z4);
        }

        public void setExpand(boolean z4) {
            ((RowsFragment) getFragment()).setExpand(z4);
        }
    }

    @Deprecated
    public static class MainFragmentRowsAdapter extends BrowseFragment.MainFragmentRowsAdapter<RowsFragment> {
        public MainFragmentRowsAdapter(RowsFragment rowsFragment) {
            super(rowsFragment);
        }

        public RowPresenter.ViewHolder findRowViewHolderByPosition(int i5) {
            return ((RowsFragment) getFragment()).findRowViewHolderByPosition(i5);
        }

        public int getSelectedPosition() {
            return ((RowsFragment) getFragment()).getSelectedPosition();
        }

        public void setAdapter(ObjectAdapter objectAdapter) {
            ((RowsFragment) getFragment()).setAdapter(objectAdapter);
        }

        public void setOnItemViewClickedListener(OnItemViewClickedListener onItemViewClickedListener) {
            ((RowsFragment) getFragment()).setOnItemViewClickedListener(onItemViewClickedListener);
        }

        public void setOnItemViewSelectedListener(OnItemViewSelectedListener onItemViewSelectedListener) {
            ((RowsFragment) getFragment()).setOnItemViewSelectedListener(onItemViewSelectedListener);
        }

        public void setSelectedPosition(int i5, boolean z4, Presenter.ViewHolderTask viewHolderTask) {
            ((RowsFragment) getFragment()).setSelectedPosition(i5, z4, viewHolderTask);
        }

        public void setSelectedPosition(int i5, boolean z4) {
            ((RowsFragment) getFragment()).setSelectedPosition(i5, z4);
        }
    }

    static final class RowViewHolderExtra implements TimeAnimator.TimeListener {
        static final Interpolator sSelectAnimatorInterpolator = new DecelerateInterpolator(2.0f);
        final RowPresenter mRowPresenter;
        final Presenter.ViewHolder mRowViewHolder;
        final TimeAnimator mSelectAnimator;
        final int mSelectAnimatorDurationInUse;
        final Interpolator mSelectAnimatorInterpolatorInUse = sSelectAnimatorInterpolator;
        float mSelectLevelAnimDelta;
        float mSelectLevelAnimStart;

        RowViewHolderExtra(ItemBridgeAdapter.ViewHolder viewHolder) {
            TimeAnimator timeAnimator = new TimeAnimator();
            this.mSelectAnimator = timeAnimator;
            this.mRowPresenter = (RowPresenter) viewHolder.getPresenter();
            this.mRowViewHolder = viewHolder.getViewHolder();
            timeAnimator.setTimeListener(this);
            this.mSelectAnimatorDurationInUse = viewHolder.itemView.getResources().getInteger(R.integer.lb_browse_rows_anim_duration);
        }

        /* access modifiers changed from: package-private */
        public void animateSelect(boolean z4, boolean z5) {
            float f5;
            this.mSelectAnimator.end();
            if (z4) {
                f5 = 1.0f;
            } else {
                f5 = 0.0f;
            }
            if (z5) {
                this.mRowPresenter.setSelectLevel(this.mRowViewHolder, f5);
            } else if (this.mRowPresenter.getSelectLevel(this.mRowViewHolder) != f5) {
                float selectLevel = this.mRowPresenter.getSelectLevel(this.mRowViewHolder);
                this.mSelectLevelAnimStart = selectLevel;
                this.mSelectLevelAnimDelta = f5 - selectLevel;
                this.mSelectAnimator.start();
            }
        }

        public void onTimeUpdate(TimeAnimator timeAnimator, long j5, long j6) {
            if (this.mSelectAnimator.isRunning()) {
                updateSelect(j5, j6);
            }
        }

        /* access modifiers changed from: package-private */
        public void updateSelect(long j5, long j6) {
            float f5;
            int i5 = this.mSelectAnimatorDurationInUse;
            if (j5 >= ((long) i5)) {
                this.mSelectAnimator.end();
                f5 = 1.0f;
            } else {
                f5 = (float) (((double) j5) / ((double) i5));
            }
            Interpolator interpolator = this.mSelectAnimatorInterpolatorInUse;
            if (interpolator != null) {
                f5 = interpolator.getInterpolation(f5);
            }
            this.mRowPresenter.setSelectLevel(this.mRowViewHolder, this.mSelectLevelAnimStart + (f5 * this.mSelectLevelAnimDelta));
        }
    }

    private void freezeRows(boolean z4) {
        this.mFreezeRows = z4;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            int childCount = verticalGridView.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i5));
                RowPresenter rowPresenter = (RowPresenter) viewHolder.getPresenter();
                rowPresenter.freeze(rowPresenter.getRowViewHolder(viewHolder.getViewHolder()), z4);
            }
        }
    }

    static void setRowViewExpanded(ItemBridgeAdapter.ViewHolder viewHolder, boolean z4) {
        ((RowPresenter) viewHolder.getPresenter()).setRowViewExpanded(viewHolder.getViewHolder(), z4);
    }

    static void setRowViewSelected(ItemBridgeAdapter.ViewHolder viewHolder, boolean z4, boolean z5) {
        ((RowViewHolderExtra) viewHolder.getExtraObject()).animateSelect(z4, z5);
        ((RowPresenter) viewHolder.getPresenter()).setRowViewSelected(viewHolder.getViewHolder(), z4);
    }

    @Deprecated
    public void enableRowScaling(boolean z4) {
    }

    /* access modifiers changed from: protected */
    public VerticalGridView findGridViewFromRoot(View view) {
        return (VerticalGridView) view.findViewById(R.id.container_list);
    }

    public RowPresenter.ViewHolder findRowViewHolderByPosition(int i5) {
        VerticalGridView verticalGridView = this.mVerticalGridView;
        if (verticalGridView == null) {
            return null;
        }
        return getRowViewHolder((ItemBridgeAdapter.ViewHolder) verticalGridView.findViewHolderForAdapterPosition(i5));
    }

    /* access modifiers changed from: package-private */
    public int getLayoutResourceId() {
        return R.layout.lb_rows_fragment;
    }

    public BrowseFragment.MainFragmentAdapter getMainFragmentAdapter() {
        if (this.mMainFragmentAdapter == null) {
            this.mMainFragmentAdapter = new MainFragmentAdapter(this);
        }
        return this.mMainFragmentAdapter;
    }

    public BrowseFragment.MainFragmentRowsAdapter getMainFragmentRowsAdapter() {
        if (this.mMainFragmentRowsAdapter == null) {
            this.mMainFragmentRowsAdapter = new MainFragmentRowsAdapter(this);
        }
        return this.mMainFragmentRowsAdapter;
    }

    public BaseOnItemViewClickedListener getOnItemViewClickedListener() {
        return this.mOnItemViewClickedListener;
    }

    public BaseOnItemViewSelectedListener getOnItemViewSelectedListener() {
        return this.mOnItemViewSelectedListener;
    }

    public RowPresenter.ViewHolder getRowViewHolder(int i5) {
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView == null) {
            return null;
        }
        return getRowViewHolder((ItemBridgeAdapter.ViewHolder) verticalGridView.findViewHolderForAdapterPosition(i5));
    }

    public /* bridge */ /* synthetic */ int getSelectedPosition() {
        return super.getSelectedPosition();
    }

    public boolean isScrolling() {
        if (getVerticalGridView() == null || getVerticalGridView().getScrollState() == 0) {
            return false;
        }
        return true;
    }

    public /* bridge */ /* synthetic */ View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroyView() {
        this.mViewsCreated = false;
        this.mSelectedViewHolder = null;
        this.mRecycledViewPool = null;
        super.onDestroyView();
    }

    /* access modifiers changed from: package-private */
    public void onRowSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i5, int i6) {
        ItemBridgeAdapter.ViewHolder viewHolder2 = this.mSelectedViewHolder;
        boolean z4 = true;
        if (!(viewHolder2 == viewHolder && this.mSubPosition == i6)) {
            this.mSubPosition = i6;
            if (viewHolder2 != null) {
                setRowViewSelected(viewHolder2, false, false);
            }
            ItemBridgeAdapter.ViewHolder viewHolder3 = (ItemBridgeAdapter.ViewHolder) viewHolder;
            this.mSelectedViewHolder = viewHolder3;
            if (viewHolder3 != null) {
                setRowViewSelected(viewHolder3, true, false);
            }
        }
        MainFragmentAdapter mainFragmentAdapter = this.mMainFragmentAdapter;
        if (mainFragmentAdapter != null) {
            BrowseFragment.FragmentHost fragmentHost = mainFragmentAdapter.getFragmentHost();
            if (i5 > 0) {
                z4 = false;
            }
            fragmentHost.showTitleView(z4);
        }
    }

    public /* bridge */ /* synthetic */ void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onTransitionEnd() {
        super.onTransitionEnd();
        freezeRows(false);
    }

    public boolean onTransitionPrepare() {
        boolean onTransitionPrepare = super.onTransitionPrepare();
        if (onTransitionPrepare) {
            freezeRows(true);
        }
        return onTransitionPrepare;
    }

    public /* bridge */ /* synthetic */ void onTransitionStart() {
        super.onTransitionStart();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getVerticalGridView().setItemAlignmentViewId(R.id.row_content);
        getVerticalGridView().setSaveChildrenPolicy(2);
        setAlignment(this.mAlignedTop);
        this.mRecycledViewPool = null;
        this.mPresenterMapper = null;
        MainFragmentAdapter mainFragmentAdapter = this.mMainFragmentAdapter;
        if (mainFragmentAdapter != null) {
            mainFragmentAdapter.getFragmentHost().notifyViewCreated(this.mMainFragmentAdapter);
        }
    }

    public void setAlignment(int i5) {
        if (i5 != Integer.MIN_VALUE) {
            this.mAlignedTop = i5;
            VerticalGridView verticalGridView = getVerticalGridView();
            if (verticalGridView != null) {
                verticalGridView.setItemAlignmentOffset(0);
                verticalGridView.setItemAlignmentOffsetPercent(-1.0f);
                verticalGridView.setItemAlignmentOffsetWithPadding(true);
                verticalGridView.setWindowAlignmentOffset(this.mAlignedTop);
                verticalGridView.setWindowAlignmentOffsetPercent(-1.0f);
                verticalGridView.setWindowAlignment(0);
            }
        }
    }

    public void setEntranceTransitionState(boolean z4) {
        this.mAfterEntranceTransition = z4;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            int childCount = verticalGridView.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i5));
                RowPresenter rowPresenter = (RowPresenter) viewHolder.getPresenter();
                rowPresenter.setEntranceTransitionState(rowPresenter.getRowViewHolder(viewHolder.getViewHolder()), this.mAfterEntranceTransition);
            }
        }
    }

    public void setExpand(boolean z4) {
        this.mExpand = z4;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            int childCount = verticalGridView.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                setRowViewExpanded((ItemBridgeAdapter.ViewHolder) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i5)), this.mExpand);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setExternalAdapterListener(ItemBridgeAdapter.AdapterListener adapterListener) {
        this.mExternalAdapterListener = adapterListener;
    }

    public void setOnItemViewClickedListener(BaseOnItemViewClickedListener baseOnItemViewClickedListener) {
        this.mOnItemViewClickedListener = baseOnItemViewClickedListener;
        if (this.mViewsCreated) {
            throw new IllegalStateException("Item clicked listener must be set before views are created");
        }
    }

    public void setOnItemViewSelectedListener(BaseOnItemViewSelectedListener baseOnItemViewSelectedListener) {
        this.mOnItemViewSelectedListener = baseOnItemViewSelectedListener;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            int childCount = verticalGridView.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                getRowViewHolder((ItemBridgeAdapter.ViewHolder) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i5))).setOnItemViewSelectedListener(this.mOnItemViewSelectedListener);
            }
        }
    }

    public /* bridge */ /* synthetic */ void setSelectedPosition(int i5) {
        super.setSelectedPosition(i5);
    }

    /* access modifiers changed from: package-private */
    public void setupSharedViewPool(ItemBridgeAdapter.ViewHolder viewHolder) {
        RowPresenter.ViewHolder rowViewHolder = ((RowPresenter) viewHolder.getPresenter()).getRowViewHolder(viewHolder.getViewHolder());
        if (rowViewHolder instanceof ListRowPresenter.ViewHolder) {
            ListRowPresenter.ViewHolder viewHolder2 = (ListRowPresenter.ViewHolder) rowViewHolder;
            HorizontalGridView gridView = viewHolder2.getGridView();
            RecyclerView.RecycledViewPool recycledViewPool = this.mRecycledViewPool;
            if (recycledViewPool == null) {
                this.mRecycledViewPool = gridView.getRecycledViewPool();
            } else {
                gridView.setRecycledViewPool(recycledViewPool);
            }
            ItemBridgeAdapter bridgeAdapter = viewHolder2.getBridgeAdapter();
            ArrayList<Presenter> arrayList = this.mPresenterMapper;
            if (arrayList == null) {
                this.mPresenterMapper = bridgeAdapter.getPresenterMapper();
            } else {
                bridgeAdapter.setPresenterMapper(arrayList);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void updateAdapter() {
        super.updateAdapter();
        this.mSelectedViewHolder = null;
        this.mViewsCreated = false;
        ItemBridgeAdapter bridgeAdapter = getBridgeAdapter();
        if (bridgeAdapter != null) {
            bridgeAdapter.setAdapterListener(this.mBridgeAdapterListener);
        }
    }

    public /* bridge */ /* synthetic */ void setSelectedPosition(int i5, boolean z4) {
        super.setSelectedPosition(i5, z4);
    }

    public void setSelectedPosition(int i5, boolean z4, final Presenter.ViewHolderTask viewHolderTask) {
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            AnonymousClass2 r12 = viewHolderTask != null ? new ViewHolderTask() {
                public void run(final RecyclerView.ViewHolder viewHolder) {
                    viewHolder.itemView.post(new Runnable() {
                        public void run() {
                            viewHolderTask.run(RowsFragment.getRowViewHolder((ItemBridgeAdapter.ViewHolder) viewHolder));
                        }
                    });
                }
            } : null;
            if (z4) {
                verticalGridView.setSelectedPositionSmooth(i5, r12);
            } else {
                verticalGridView.setSelectedPosition(i5, (ViewHolderTask) r12);
            }
        }
    }

    static RowPresenter.ViewHolder getRowViewHolder(ItemBridgeAdapter.ViewHolder viewHolder) {
        if (viewHolder == null) {
            return null;
        }
        return ((RowPresenter) viewHolder.getPresenter()).getRowViewHolder(viewHolder.getViewHolder());
    }
}
