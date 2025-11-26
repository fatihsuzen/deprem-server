package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.graphics.ColorOverlayDimmer;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowHeaderPresenter;

public abstract class RowPresenter extends Presenter {
    public static final int SYNC_ACTIVATED_CUSTOM = 0;
    public static final int SYNC_ACTIVATED_TO_EXPANDED = 1;
    public static final int SYNC_ACTIVATED_TO_EXPANDED_AND_SELECTED = 3;
    public static final int SYNC_ACTIVATED_TO_SELECTED = 2;
    private RowHeaderPresenter mHeaderPresenter;
    boolean mSelectEffectEnabled = true;
    int mSyncActivatePolicy = 1;

    static class ContainerViewHolder extends Presenter.ViewHolder {
        final ViewHolder mRowViewHolder;

        public ContainerViewHolder(RowContainerView rowContainerView, ViewHolder viewHolder) {
            super(rowContainerView);
            rowContainerView.addRowView(viewHolder.view);
            RowHeaderPresenter.ViewHolder viewHolder2 = viewHolder.mHeaderViewHolder;
            if (viewHolder2 != null) {
                rowContainerView.addHeaderView(viewHolder2.view);
            }
            this.mRowViewHolder = viewHolder;
            viewHolder.mContainerViewHolder = this;
        }
    }

    public static class ViewHolder extends Presenter.ViewHolder {
        private static final int ACTIVATED = 1;
        private static final int ACTIVATED_NOT_ASSIGNED = 0;
        private static final int NOT_ACTIVATED = 2;
        int mActivated = 0;
        protected final ColorOverlayDimmer mColorDimmer;
        ContainerViewHolder mContainerViewHolder;
        boolean mExpanded;
        RowHeaderPresenter.ViewHolder mHeaderViewHolder;
        boolean mInitialzed;
        private BaseOnItemViewClickedListener mOnItemViewClickedListener;
        BaseOnItemViewSelectedListener mOnItemViewSelectedListener;
        private View.OnKeyListener mOnKeyListener;
        Row mRow;
        Object mRowObject;
        float mSelectLevel = 0.0f;
        boolean mSelected;

        public ViewHolder(View view) {
            super(view);
            this.mColorDimmer = ColorOverlayDimmer.createDefault(view.getContext());
        }

        public final RowHeaderPresenter.ViewHolder getHeaderViewHolder() {
            return this.mHeaderViewHolder;
        }

        public final BaseOnItemViewClickedListener getOnItemViewClickedListener() {
            return this.mOnItemViewClickedListener;
        }

        public final BaseOnItemViewSelectedListener getOnItemViewSelectedListener() {
            return this.mOnItemViewSelectedListener;
        }

        public View.OnKeyListener getOnKeyListener() {
            return this.mOnKeyListener;
        }

        public final Row getRow() {
            return this.mRow;
        }

        public final Object getRowObject() {
            return this.mRowObject;
        }

        public final float getSelectLevel() {
            return this.mSelectLevel;
        }

        public Object getSelectedItem() {
            return null;
        }

        public Presenter.ViewHolder getSelectedItemViewHolder() {
            return null;
        }

        public final boolean isExpanded() {
            return this.mExpanded;
        }

        public final boolean isSelected() {
            return this.mSelected;
        }

        public final void setActivated(boolean z4) {
            int i5;
            if (z4) {
                i5 = 1;
            } else {
                i5 = 2;
            }
            this.mActivated = i5;
        }

        public final void setOnItemViewClickedListener(BaseOnItemViewClickedListener baseOnItemViewClickedListener) {
            this.mOnItemViewClickedListener = baseOnItemViewClickedListener;
        }

        public final void setOnItemViewSelectedListener(BaseOnItemViewSelectedListener baseOnItemViewSelectedListener) {
            this.mOnItemViewSelectedListener = baseOnItemViewSelectedListener;
        }

        public void setOnKeyListener(View.OnKeyListener onKeyListener) {
            this.mOnKeyListener = onKeyListener;
        }

        public final void syncActivatedStatus(View view) {
            int i5 = this.mActivated;
            if (i5 == 1) {
                view.setActivated(true);
            } else if (i5 == 2) {
                view.setActivated(false);
            }
        }
    }

    public RowPresenter() {
        RowHeaderPresenter rowHeaderPresenter = new RowHeaderPresenter();
        this.mHeaderPresenter = rowHeaderPresenter;
        rowHeaderPresenter.setNullItemVisibilityGone(true);
    }

    private void updateActivateStatus(ViewHolder viewHolder, View view) {
        int i5 = this.mSyncActivatePolicy;
        boolean z4 = true;
        if (i5 == 1) {
            viewHolder.setActivated(viewHolder.isExpanded());
        } else if (i5 == 2) {
            viewHolder.setActivated(viewHolder.isSelected());
        } else if (i5 == 3) {
            if (!viewHolder.isExpanded() || !viewHolder.isSelected()) {
                z4 = false;
            }
            viewHolder.setActivated(z4);
        }
        viewHolder.syncActivatedStatus(view);
    }

    private void updateHeaderViewVisibility(ViewHolder viewHolder) {
        if (this.mHeaderPresenter != null && viewHolder.mHeaderViewHolder != null) {
            ((RowContainerView) viewHolder.mContainerViewHolder.view).showHeader(viewHolder.isExpanded());
        }
    }

    /* access modifiers changed from: protected */
    public abstract ViewHolder createRowViewHolder(ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public void dispatchItemSelectedListener(ViewHolder viewHolder, boolean z4) {
        BaseOnItemViewSelectedListener baseOnItemViewSelectedListener;
        if (z4 && (baseOnItemViewSelectedListener = viewHolder.mOnItemViewSelectedListener) != null) {
            baseOnItemViewSelectedListener.onItemSelected((Presenter.ViewHolder) null, (Object) null, viewHolder, viewHolder.getRowObject());
        }
    }

    public void freeze(ViewHolder viewHolder, boolean z4) {
    }

    public final RowHeaderPresenter getHeaderPresenter() {
        return this.mHeaderPresenter;
    }

    public final ViewHolder getRowViewHolder(Presenter.ViewHolder viewHolder) {
        if (viewHolder instanceof ContainerViewHolder) {
            return ((ContainerViewHolder) viewHolder).mRowViewHolder;
        }
        return (ViewHolder) viewHolder;
    }

    public final boolean getSelectEffectEnabled() {
        return this.mSelectEffectEnabled;
    }

    public final float getSelectLevel(Presenter.ViewHolder viewHolder) {
        return getRowViewHolder(viewHolder).mSelectLevel;
    }

    public final int getSyncActivatePolicy() {
        return this.mSyncActivatePolicy;
    }

    /* access modifiers changed from: protected */
    public void initializeRowViewHolder(ViewHolder viewHolder) {
        viewHolder.mInitialzed = true;
        if (!isClippingChildren()) {
            View view = viewHolder.view;
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(false);
            }
            ContainerViewHolder containerViewHolder = viewHolder.mContainerViewHolder;
            if (containerViewHolder != null) {
                ((ViewGroup) containerViewHolder.view).setClipChildren(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isClippingChildren() {
        return false;
    }

    public boolean isUsingDefaultSelectEffect() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean needsDefaultSelectEffect() {
        if (!isUsingDefaultSelectEffect() || !getSelectEffectEnabled()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean needsRowContainerView() {
        if (this.mHeaderPresenter != null || needsDefaultSelectEffect()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onBindRowViewHolder(ViewHolder viewHolder, Object obj) {
        Row row;
        viewHolder.mRowObject = obj;
        if (obj instanceof Row) {
            row = (Row) obj;
        } else {
            row = null;
        }
        viewHolder.mRow = row;
        if (viewHolder.mHeaderViewHolder != null && viewHolder.getRow() != null) {
            this.mHeaderPresenter.onBindViewHolder(viewHolder.mHeaderViewHolder, obj);
        }
    }

    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        onBindRowViewHolder(getRowViewHolder(viewHolder), obj);
    }

    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        Presenter.ViewHolder viewHolder;
        ViewHolder createRowViewHolder = createRowViewHolder(viewGroup);
        createRowViewHolder.mInitialzed = false;
        if (needsRowContainerView()) {
            RowContainerView rowContainerView = new RowContainerView(viewGroup.getContext());
            RowHeaderPresenter rowHeaderPresenter = this.mHeaderPresenter;
            if (rowHeaderPresenter != null) {
                createRowViewHolder.mHeaderViewHolder = (RowHeaderPresenter.ViewHolder) rowHeaderPresenter.onCreateViewHolder((ViewGroup) createRowViewHolder.view);
            }
            viewHolder = new ContainerViewHolder(rowContainerView, createRowViewHolder);
        } else {
            viewHolder = createRowViewHolder;
        }
        initializeRowViewHolder(createRowViewHolder);
        if (createRowViewHolder.mInitialzed) {
            return viewHolder;
        }
        throw new RuntimeException("super.initializeRowViewHolder() must be called");
    }

    /* access modifiers changed from: protected */
    public void onRowViewAttachedToWindow(ViewHolder viewHolder) {
        RowHeaderPresenter.ViewHolder viewHolder2 = viewHolder.mHeaderViewHolder;
        if (viewHolder2 != null) {
            this.mHeaderPresenter.onViewAttachedToWindow(viewHolder2);
        }
    }

    /* access modifiers changed from: protected */
    public void onRowViewDetachedFromWindow(ViewHolder viewHolder) {
        RowHeaderPresenter.ViewHolder viewHolder2 = viewHolder.mHeaderViewHolder;
        if (viewHolder2 != null) {
            this.mHeaderPresenter.onViewDetachedFromWindow(viewHolder2);
        }
        Presenter.cancelAnimationsRecursive(viewHolder.view);
    }

    /* access modifiers changed from: protected */
    public void onRowViewExpanded(ViewHolder viewHolder, boolean z4) {
        updateHeaderViewVisibility(viewHolder);
        updateActivateStatus(viewHolder, viewHolder.view);
    }

    /* access modifiers changed from: protected */
    public void onRowViewSelected(ViewHolder viewHolder, boolean z4) {
        dispatchItemSelectedListener(viewHolder, z4);
        updateHeaderViewVisibility(viewHolder);
        updateActivateStatus(viewHolder, viewHolder.view);
    }

    /* access modifiers changed from: protected */
    public void onSelectLevelChanged(ViewHolder viewHolder) {
        if (getSelectEffectEnabled()) {
            viewHolder.mColorDimmer.setActiveLevel(viewHolder.mSelectLevel);
            RowHeaderPresenter.ViewHolder viewHolder2 = viewHolder.mHeaderViewHolder;
            if (viewHolder2 != null) {
                this.mHeaderPresenter.setSelectLevel(viewHolder2, viewHolder.mSelectLevel);
            }
            if (isUsingDefaultSelectEffect()) {
                ((RowContainerView) viewHolder.mContainerViewHolder.view).setForegroundColor(viewHolder.mColorDimmer.getPaint().getColor());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onUnbindRowViewHolder(ViewHolder viewHolder) {
        RowHeaderPresenter.ViewHolder viewHolder2 = viewHolder.mHeaderViewHolder;
        if (viewHolder2 != null) {
            this.mHeaderPresenter.onUnbindViewHolder(viewHolder2);
        }
        viewHolder.mRow = null;
        viewHolder.mRowObject = null;
    }

    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        onUnbindRowViewHolder(getRowViewHolder(viewHolder));
    }

    public final void onViewAttachedToWindow(Presenter.ViewHolder viewHolder) {
        onRowViewAttachedToWindow(getRowViewHolder(viewHolder));
    }

    public final void onViewDetachedFromWindow(Presenter.ViewHolder viewHolder) {
        onRowViewDetachedFromWindow(getRowViewHolder(viewHolder));
    }

    public void setEntranceTransitionState(ViewHolder viewHolder, boolean z4) {
        int i5;
        RowHeaderPresenter.ViewHolder viewHolder2 = viewHolder.mHeaderViewHolder;
        if (viewHolder2 != null && viewHolder2.view.getVisibility() != 8) {
            View view = viewHolder.mHeaderViewHolder.view;
            if (z4) {
                i5 = 0;
            } else {
                i5 = 4;
            }
            view.setVisibility(i5);
        }
    }

    public final void setHeaderPresenter(RowHeaderPresenter rowHeaderPresenter) {
        this.mHeaderPresenter = rowHeaderPresenter;
    }

    public final void setRowViewExpanded(Presenter.ViewHolder viewHolder, boolean z4) {
        ViewHolder rowViewHolder = getRowViewHolder(viewHolder);
        rowViewHolder.mExpanded = z4;
        onRowViewExpanded(rowViewHolder, z4);
    }

    public final void setRowViewSelected(Presenter.ViewHolder viewHolder, boolean z4) {
        ViewHolder rowViewHolder = getRowViewHolder(viewHolder);
        rowViewHolder.mSelected = z4;
        onRowViewSelected(rowViewHolder, z4);
    }

    public final void setSelectEffectEnabled(boolean z4) {
        this.mSelectEffectEnabled = z4;
    }

    public final void setSelectLevel(Presenter.ViewHolder viewHolder, float f5) {
        ViewHolder rowViewHolder = getRowViewHolder(viewHolder);
        rowViewHolder.mSelectLevel = f5;
        onSelectLevelChanged(rowViewHolder);
    }

    public final void setSyncActivatePolicy(int i5) {
        this.mSyncActivatePolicy = i5;
    }
}
