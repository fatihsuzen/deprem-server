package androidx.leanback.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.R;
import androidx.leanback.system.Settings;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.ShadowOverlayHelper;
import androidx.recyclerview.widget.RecyclerView;

public class VerticalGridPresenter extends Presenter {
    private static final boolean DEBUG = false;
    private static final String TAG = "GridPresenter";
    private int mFocusZoomFactor;
    private boolean mKeepChildForeground;
    private int mNumColumns;
    private OnItemViewClickedListener mOnItemViewClickedListener;
    private OnItemViewSelectedListener mOnItemViewSelectedListener;
    private boolean mRoundedCornersEnabled;
    private boolean mShadowEnabled;
    ShadowOverlayHelper mShadowOverlayHelper;
    private ItemBridgeAdapter.Wrapper mShadowOverlayWrapper;
    private boolean mUseFocusDimmer;

    class VerticalGridItemBridgeAdapter extends ItemBridgeAdapter {
        VerticalGridItemBridgeAdapter() {
        }

        public void onAttachedToWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
            viewHolder.itemView.setActivated(true);
        }

        public void onBind(final ItemBridgeAdapter.ViewHolder viewHolder) {
            if (VerticalGridPresenter.this.getOnItemViewClickedListener() != null) {
                viewHolder.mHolder.view.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (VerticalGridPresenter.this.getOnItemViewClickedListener() != null) {
                            OnItemViewClickedListener onItemViewClickedListener = VerticalGridPresenter.this.getOnItemViewClickedListener();
                            ItemBridgeAdapter.ViewHolder viewHolder = viewHolder;
                            onItemViewClickedListener.onItemClicked(viewHolder.mHolder, viewHolder.mItem, (RowPresenter.ViewHolder) null, null);
                        }
                    }
                });
            }
        }

        /* access modifiers changed from: protected */
        public void onCreate(ItemBridgeAdapter.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view instanceof ViewGroup) {
                TransitionHelper.setTransitionGroup((ViewGroup) view, true);
            }
            ShadowOverlayHelper shadowOverlayHelper = VerticalGridPresenter.this.mShadowOverlayHelper;
            if (shadowOverlayHelper != null) {
                shadowOverlayHelper.onViewCreated(viewHolder.itemView);
            }
        }

        public void onUnbind(ItemBridgeAdapter.ViewHolder viewHolder) {
            if (VerticalGridPresenter.this.getOnItemViewClickedListener() != null) {
                viewHolder.mHolder.view.setOnClickListener((View.OnClickListener) null);
            }
        }
    }

    public static class ViewHolder extends Presenter.ViewHolder {
        final VerticalGridView mGridView;
        boolean mInitialized;
        ItemBridgeAdapter mItemBridgeAdapter;

        public ViewHolder(VerticalGridView verticalGridView) {
            super(verticalGridView);
            this.mGridView = verticalGridView;
        }

        public VerticalGridView getGridView() {
            return this.mGridView;
        }
    }

    public VerticalGridPresenter() {
        this(3);
    }

    public final boolean areChildRoundedCornersEnabled() {
        return this.mRoundedCornersEnabled;
    }

    /* access modifiers changed from: protected */
    public ViewHolder createGridViewHolder(ViewGroup viewGroup) {
        return new ViewHolder((VerticalGridView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lb_vertical_grid, viewGroup, false).findViewById(R.id.browse_grid));
    }

    /* access modifiers changed from: protected */
    public ShadowOverlayHelper.Options createShadowOverlayOptions() {
        return ShadowOverlayHelper.Options.DEFAULT;
    }

    public final void enableChildRoundedCorners(boolean z4) {
        this.mRoundedCornersEnabled = z4;
    }

    public final int getFocusZoomFactor() {
        return this.mFocusZoomFactor;
    }

    public final boolean getKeepChildForeground() {
        return this.mKeepChildForeground;
    }

    public int getNumberOfColumns() {
        return this.mNumColumns;
    }

    public final OnItemViewClickedListener getOnItemViewClickedListener() {
        return this.mOnItemViewClickedListener;
    }

    public final OnItemViewSelectedListener getOnItemViewSelectedListener() {
        return this.mOnItemViewSelectedListener;
    }

    public final boolean getShadowEnabled() {
        return this.mShadowEnabled;
    }

    /* access modifiers changed from: protected */
    public void initializeGridViewHolder(final ViewHolder viewHolder) {
        if (this.mNumColumns != -1) {
            viewHolder.getGridView().setNumColumns(this.mNumColumns);
            boolean z4 = true;
            viewHolder.mInitialized = true;
            Context context = viewHolder.mGridView.getContext();
            if (this.mShadowOverlayHelper == null) {
                ShadowOverlayHelper build = new ShadowOverlayHelper.Builder().needsOverlay(this.mUseFocusDimmer).needsShadow(needsDefaultShadow()).needsRoundedCorner(areChildRoundedCornersEnabled()).preferZOrder(isUsingZOrder(context)).keepForegroundDrawable(this.mKeepChildForeground).options(createShadowOverlayOptions()).build(context);
                this.mShadowOverlayHelper = build;
                if (build.needsWrapper()) {
                    this.mShadowOverlayWrapper = new ItemBridgeAdapterShadowOverlayWrapper(this.mShadowOverlayHelper);
                }
            }
            viewHolder.mItemBridgeAdapter.setWrapper(this.mShadowOverlayWrapper);
            this.mShadowOverlayHelper.prepareParentForShadow(viewHolder.mGridView);
            VerticalGridView gridView = viewHolder.getGridView();
            if (this.mShadowOverlayHelper.getShadowType() == 3) {
                z4 = false;
            }
            gridView.setFocusDrawingOrderEnabled(z4);
            FocusHighlightHelper.setupBrowseItemFocusHighlight(viewHolder.mItemBridgeAdapter, this.mFocusZoomFactor, this.mUseFocusDimmer);
            viewHolder.getGridView().setOnChildSelectedListener(new OnChildSelectedListener() {
                public void onChildSelected(ViewGroup viewGroup, View view, int i5, long j5) {
                    VerticalGridPresenter.this.selectChildView(viewHolder, view);
                }
            });
            return;
        }
        throw new IllegalStateException("Number of columns must be set");
    }

    public final boolean isFocusDimmerUsed() {
        return this.mUseFocusDimmer;
    }

    public boolean isUsingDefaultShadow() {
        return ShadowOverlayHelper.supportsShadow();
    }

    public boolean isUsingZOrder(Context context) {
        return !Settings.getInstance(context).preferStaticShadows();
    }

    /* access modifiers changed from: package-private */
    public final boolean needsDefaultShadow() {
        if (!isUsingDefaultShadow() || !getShadowEnabled()) {
            return false;
        }
        return true;
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.mItemBridgeAdapter.setAdapter((ObjectAdapter) obj);
        viewHolder2.getGridView().setAdapter(viewHolder2.mItemBridgeAdapter);
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.mItemBridgeAdapter.setAdapter((ObjectAdapter) null);
        viewHolder2.getGridView().setAdapter((RecyclerView.Adapter) null);
    }

    /* access modifiers changed from: package-private */
    public void selectChildView(ViewHolder viewHolder, View view) {
        ItemBridgeAdapter.ViewHolder viewHolder2;
        if (getOnItemViewSelectedListener() != null) {
            if (view == null) {
                viewHolder2 = null;
            } else {
                viewHolder2 = (ItemBridgeAdapter.ViewHolder) viewHolder.getGridView().getChildViewHolder(view);
            }
            if (viewHolder2 == null) {
                getOnItemViewSelectedListener().onItemSelected((Presenter.ViewHolder) null, (Object) null, (RowPresenter.ViewHolder) null, null);
            } else {
                getOnItemViewSelectedListener().onItemSelected(viewHolder2.mHolder, viewHolder2.mItem, (RowPresenter.ViewHolder) null, null);
            }
        }
    }

    public void setEntranceTransitionState(ViewHolder viewHolder, boolean z4) {
        int i5;
        VerticalGridView verticalGridView = viewHolder.mGridView;
        if (z4) {
            i5 = 0;
        } else {
            i5 = 4;
        }
        verticalGridView.setChildrenVisibility(i5);
    }

    public final void setKeepChildForeground(boolean z4) {
        this.mKeepChildForeground = z4;
    }

    public void setNumberOfColumns(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException("Invalid number of columns");
        } else if (this.mNumColumns != i5) {
            this.mNumColumns = i5;
        }
    }

    public final void setOnItemViewClickedListener(OnItemViewClickedListener onItemViewClickedListener) {
        this.mOnItemViewClickedListener = onItemViewClickedListener;
    }

    public final void setOnItemViewSelectedListener(OnItemViewSelectedListener onItemViewSelectedListener) {
        this.mOnItemViewSelectedListener = onItemViewSelectedListener;
    }

    public final void setShadowEnabled(boolean z4) {
        this.mShadowEnabled = z4;
    }

    public VerticalGridPresenter(int i5) {
        this(i5, true);
    }

    public final ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        ViewHolder createGridViewHolder = createGridViewHolder(viewGroup);
        createGridViewHolder.mInitialized = false;
        createGridViewHolder.mItemBridgeAdapter = new VerticalGridItemBridgeAdapter();
        initializeGridViewHolder(createGridViewHolder);
        if (createGridViewHolder.mInitialized) {
            return createGridViewHolder;
        }
        throw new RuntimeException("super.initializeGridViewHolder() must be called");
    }

    public VerticalGridPresenter(int i5, boolean z4) {
        this.mNumColumns = -1;
        this.mShadowEnabled = true;
        this.mKeepChildForeground = true;
        this.mRoundedCornersEnabled = true;
        this.mFocusZoomFactor = i5;
        this.mUseFocusDimmer = z4;
    }
}
