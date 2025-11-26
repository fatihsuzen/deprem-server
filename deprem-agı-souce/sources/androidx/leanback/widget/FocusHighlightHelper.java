package androidx.leanback.widget;

import android.animation.TimeAnimator;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.leanback.R;
import androidx.leanback.graphics.ColorOverlayDimmer;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.RowHeaderPresenter;
import androidx.recyclerview.widget.RecyclerView;

public class FocusHighlightHelper {

    static class BrowseItemFocusHighlight implements FocusHighlightHandler {
        private static final int DURATION_MS = 150;
        private int mScaleIndex;
        private final boolean mUseDimmer;

        BrowseItemFocusHighlight(int i5, boolean z4) {
            if (FocusHighlightHelper.isValidZoomIndex(i5)) {
                this.mScaleIndex = i5;
                this.mUseDimmer = z4;
                return;
            }
            throw new IllegalArgumentException("Unhandled zoom index");
        }

        private FocusAnimator getOrCreateAnimator(View view) {
            int i5 = R.id.lb_focus_animator;
            FocusAnimator focusAnimator = (FocusAnimator) view.getTag(i5);
            if (focusAnimator != null) {
                return focusAnimator;
            }
            FocusAnimator focusAnimator2 = new FocusAnimator(view, getScale(view.getResources()), this.mUseDimmer, DURATION_MS);
            view.setTag(i5, focusAnimator2);
            return focusAnimator2;
        }

        private float getScale(Resources resources) {
            int i5 = this.mScaleIndex;
            if (i5 == 0) {
                return 1.0f;
            }
            return resources.getFraction(FocusHighlightHelper.getResId(i5), 1, 1);
        }

        public void onInitializeView(View view) {
            getOrCreateAnimator(view).animateFocus(false, true);
        }

        public void onItemFocused(View view, boolean z4) {
            view.setSelected(z4);
            getOrCreateAnimator(view).animateFocus(z4, false);
        }
    }

    static class FocusAnimator implements TimeAnimator.TimeListener {
        private final TimeAnimator mAnimator;
        private final ColorOverlayDimmer mDimmer;
        private final int mDuration;
        private float mFocusLevel = 0.0f;
        private float mFocusLevelDelta;
        private float mFocusLevelStart;
        private final Interpolator mInterpolator;
        private final float mScaleDiff;
        private final View mView;
        private final ShadowOverlayContainer mWrapper;

        FocusAnimator(View view, float f5, boolean z4, int i5) {
            TimeAnimator timeAnimator = new TimeAnimator();
            this.mAnimator = timeAnimator;
            this.mInterpolator = new AccelerateDecelerateInterpolator();
            this.mView = view;
            this.mDuration = i5;
            this.mScaleDiff = f5 - 1.0f;
            if (view instanceof ShadowOverlayContainer) {
                this.mWrapper = (ShadowOverlayContainer) view;
            } else {
                this.mWrapper = null;
            }
            timeAnimator.setTimeListener(this);
            if (z4) {
                this.mDimmer = ColorOverlayDimmer.createDefault(view.getContext());
            } else {
                this.mDimmer = null;
            }
        }

        /* access modifiers changed from: package-private */
        public void animateFocus(boolean z4, boolean z5) {
            float f5;
            endAnimation();
            if (z4) {
                f5 = 1.0f;
            } else {
                f5 = 0.0f;
            }
            if (z5) {
                setFocusLevel(f5);
                return;
            }
            float f6 = this.mFocusLevel;
            if (f6 != f5) {
                this.mFocusLevelStart = f6;
                this.mFocusLevelDelta = f5 - f6;
                this.mAnimator.start();
            }
        }

        /* access modifiers changed from: package-private */
        public void endAnimation() {
            this.mAnimator.end();
        }

        /* access modifiers changed from: package-private */
        public float getFocusLevel() {
            return this.mFocusLevel;
        }

        public void onTimeUpdate(TimeAnimator timeAnimator, long j5, long j6) {
            float f5;
            int i5 = this.mDuration;
            if (j5 >= ((long) i5)) {
                this.mAnimator.end();
                f5 = 1.0f;
            } else {
                f5 = (float) (((double) j5) / ((double) i5));
            }
            Interpolator interpolator = this.mInterpolator;
            if (interpolator != null) {
                f5 = interpolator.getInterpolation(f5);
            }
            setFocusLevel(this.mFocusLevelStart + (f5 * this.mFocusLevelDelta));
        }

        /* access modifiers changed from: package-private */
        public void setFocusLevel(float f5) {
            this.mFocusLevel = f5;
            float f6 = (this.mScaleDiff * f5) + 1.0f;
            this.mView.setScaleX(f6);
            this.mView.setScaleY(f6);
            ShadowOverlayContainer shadowOverlayContainer = this.mWrapper;
            if (shadowOverlayContainer != null) {
                shadowOverlayContainer.setShadowFocusLevel(f5);
            } else {
                ShadowOverlayHelper.setNoneWrapperShadowFocusLevel(this.mView, f5);
            }
            ColorOverlayDimmer colorOverlayDimmer = this.mDimmer;
            if (colorOverlayDimmer != null) {
                colorOverlayDimmer.setActiveLevel(f5);
                int color = this.mDimmer.getPaint().getColor();
                ShadowOverlayContainer shadowOverlayContainer2 = this.mWrapper;
                if (shadowOverlayContainer2 != null) {
                    shadowOverlayContainer2.setOverlayColor(color);
                } else {
                    ShadowOverlayHelper.setNoneWrapperOverlayColor(this.mView, color);
                }
            }
        }
    }

    static class HeaderItemFocusHighlight implements FocusHighlightHandler {
        private int mDuration;
        private boolean mInitialized;
        private float mSelectScale;

        static class HeaderFocusAnimator extends FocusAnimator {
            ItemBridgeAdapter.ViewHolder mViewHolder;

            HeaderFocusAnimator(View view, float f5, int i5) {
                super(view, f5, false, i5);
                ViewParent parent = view.getParent();
                while (parent != null && !(parent instanceof RecyclerView)) {
                    parent = parent.getParent();
                }
                if (parent != null) {
                    this.mViewHolder = (ItemBridgeAdapter.ViewHolder) ((RecyclerView) parent).getChildViewHolder(view);
                }
            }

            /* access modifiers changed from: package-private */
            public void setFocusLevel(float f5) {
                Presenter presenter = this.mViewHolder.getPresenter();
                if (presenter instanceof RowHeaderPresenter) {
                    ((RowHeaderPresenter) presenter).setSelectLevel((RowHeaderPresenter.ViewHolder) this.mViewHolder.getViewHolder(), f5);
                }
                super.setFocusLevel(f5);
            }
        }

        HeaderItemFocusHighlight() {
        }

        private void viewFocused(View view, boolean z4) {
            lazyInit(view);
            view.setSelected(z4);
            int i5 = R.id.lb_focus_animator;
            FocusAnimator focusAnimator = (FocusAnimator) view.getTag(i5);
            if (focusAnimator == null) {
                focusAnimator = new HeaderFocusAnimator(view, this.mSelectScale, this.mDuration);
                view.setTag(i5, focusAnimator);
            }
            focusAnimator.animateFocus(z4, false);
        }

        /* access modifiers changed from: package-private */
        public void lazyInit(View view) {
            if (!this.mInitialized) {
                Resources resources = view.getResources();
                TypedValue typedValue = new TypedValue();
                resources.getValue(R.dimen.lb_browse_header_select_scale, typedValue, true);
                this.mSelectScale = typedValue.getFloat();
                resources.getValue(R.dimen.lb_browse_header_select_duration, typedValue, true);
                this.mDuration = typedValue.data;
                this.mInitialized = true;
            }
        }

        public void onInitializeView(View view) {
        }

        public void onItemFocused(View view, boolean z4) {
            viewFocused(view, z4);
        }
    }

    static int getResId(int i5) {
        if (i5 == 1) {
            return R.fraction.lb_focus_zoom_factor_small;
        }
        if (i5 == 2) {
            return R.fraction.lb_focus_zoom_factor_medium;
        }
        if (i5 == 3) {
            return R.fraction.lb_focus_zoom_factor_large;
        }
        if (i5 != 4) {
            return 0;
        }
        return R.fraction.lb_focus_zoom_factor_xsmall;
    }

    static boolean isValidZoomIndex(int i5) {
        if (i5 == 0 || getResId(i5) > 0) {
            return true;
        }
        return false;
    }

    public static void setupBrowseItemFocusHighlight(ItemBridgeAdapter itemBridgeAdapter, int i5, boolean z4) {
        if (i5 != 0 || z4) {
            itemBridgeAdapter.setFocusHighlight(new BrowseItemFocusHighlight(i5, z4));
        } else {
            itemBridgeAdapter.setFocusHighlight((FocusHighlightHandler) null);
        }
    }

    @Deprecated
    public static void setupHeaderItemFocusHighlight(VerticalGridView verticalGridView) {
        setupHeaderItemFocusHighlight(verticalGridView, true);
    }

    @Deprecated
    public static void setupHeaderItemFocusHighlight(VerticalGridView verticalGridView, boolean z4) {
        if (verticalGridView != null && (verticalGridView.getAdapter() instanceof ItemBridgeAdapter)) {
            ((ItemBridgeAdapter) verticalGridView.getAdapter()).setFocusHighlight(z4 ? new HeaderItemFocusHighlight() : null);
        }
    }

    public static void setupHeaderItemFocusHighlight(ItemBridgeAdapter itemBridgeAdapter) {
        setupHeaderItemFocusHighlight(itemBridgeAdapter, true);
    }

    public static void setupHeaderItemFocusHighlight(ItemBridgeAdapter itemBridgeAdapter, boolean z4) {
        itemBridgeAdapter.setFocusHighlight(z4 ? new HeaderItemFocusHighlight() : null);
    }
}
