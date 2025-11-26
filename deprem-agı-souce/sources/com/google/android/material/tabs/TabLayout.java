package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;
    @Dimension(unit = 0)
    static final int DEFAULT_GAP_TEXT_ICON = 8;
    @Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT = 48;
    @Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_TabLayout;
    @Dimension(unit = 0)
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int GRAVITY_START = 2;
    public static final int INDICATOR_ANIMATION_MODE_ELASTIC = 1;
    public static final int INDICATOR_ANIMATION_MODE_FADE = 2;
    public static final int INDICATOR_ANIMATION_MODE_LINEAR = 0;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    private static final int INVALID_WIDTH = -1;
    private static final String LOG_TAG = "TabLayout";
    public static final int MODE_AUTO = 2;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    private static final int SELECTED_INDICATOR_HEIGHT_DEFAULT = -1;
    public static final int TAB_LABEL_VISIBILITY_LABELED = 1;
    public static final int TAB_LABEL_VISIBILITY_UNLABELED = 0;
    @Dimension(unit = 0)
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private static final Pools.Pool<Tab> tabPool = new Pools.SynchronizedPool(16);
    private AdapterChangeListener adapterChangeListener;
    private int contentInsetStart;
    @Nullable
    private BaseOnTabSelectedListener currentVpSelectedListener;
    /* access modifiers changed from: private */
    public final int defaultTabTextAppearance;
    int indicatorPosition;
    boolean inlineLabel;
    int mode;
    private TabLayoutOnPageChangeListener pageChangeListener;
    @Nullable
    private PagerAdapter pagerAdapter;
    private DataSetObserver pagerAdapterObserver;
    private final int requestedTabMaxWidth;
    private final int requestedTabMinWidth;
    private ValueAnimator scrollAnimator;
    private final int scrollableTabMinWidth;
    @Nullable
    private BaseOnTabSelectedListener selectedListener;
    private final ArrayList<BaseOnTabSelectedListener> selectedListeners;
    @Nullable
    private Tab selectedTab;
    /* access modifiers changed from: private */
    public int selectedTabTextAppearance;
    float selectedTabTextSize;
    private boolean setupViewPagerImplicitly;
    @NonNull
    final SlidingTabIndicator slidingTabIndicator;
    final int tabBackgroundResId;
    int tabGravity;
    ColorStateList tabIconTint;
    PorterDuff.Mode tabIconTintMode;
    int tabIndicatorAnimationDuration;
    int tabIndicatorAnimationMode;
    boolean tabIndicatorFullWidth;
    int tabIndicatorGravity;
    int tabIndicatorHeight;
    /* access modifiers changed from: private */
    public TabIndicatorInterpolator tabIndicatorInterpolator;
    /* access modifiers changed from: private */
    public final TimeInterpolator tabIndicatorTimeInterpolator;
    int tabMaxWidth;
    int tabPaddingBottom;
    int tabPaddingEnd;
    int tabPaddingStart;
    int tabPaddingTop;
    ColorStateList tabRippleColorStateList;
    @NonNull
    Drawable tabSelectedIndicator;
    private int tabSelectedIndicatorColor;
    /* access modifiers changed from: private */
    public final int tabTextAppearance;
    ColorStateList tabTextColors;
    float tabTextMultiLineSize;
    float tabTextSize;
    private final Pools.Pool<TabView> tabViewPool;
    private final ArrayList<Tab> tabs;
    boolean unboundedRipple;
    @Nullable
    ViewPager viewPager;
    /* access modifiers changed from: private */
    public int viewPagerScrollState;

    private class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        private boolean autoRefresh;

        AdapterChangeListener() {
        }

        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.viewPager == viewPager) {
                tabLayout.setPagerAdapter(pagerAdapter2, this.autoRefresh);
            }
        }

        /* access modifiers changed from: package-private */
        public void setAutoRefresh(boolean z4) {
            this.autoRefresh = z4;
        }
    }

    @Deprecated
    public interface BaseOnTabSelectedListener<T extends Tab> {
        void onTabReselected(T t5);

        void onTabSelected(T t5);

        void onTabUnselected(T t5);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LabelVisibility {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public interface OnTabSelectedListener extends BaseOnTabSelectedListener<Tab> {
    }

    private class PagerAdapterObserver extends DataSetObserver {
        PagerAdapterObserver() {
        }

        public void onChanged() {
            TabLayout.this.populateFromPagerAdapter();
        }

        public void onInvalidated() {
            TabLayout.this.populateFromPagerAdapter();
        }
    }

    class SlidingTabIndicator extends LinearLayout {
        ValueAnimator indicatorAnimator;
        private int layoutDirection = -1;

        SlidingTabIndicator(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        private void jumpIndicatorToIndicatorPosition() {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.indicatorPosition == -1) {
                tabLayout.indicatorPosition = tabLayout.getSelectedTabPosition();
            }
            jumpIndicatorToPosition(TabLayout.this.indicatorPosition);
        }

        private void jumpIndicatorToPosition(int i5) {
            if (TabLayout.this.viewPagerScrollState == 0 || (TabLayout.this.getTabSelectedIndicator().getBounds().left == -1 && TabLayout.this.getTabSelectedIndicator().getBounds().right == -1)) {
                View childAt = getChildAt(i5);
                TabIndicatorInterpolator access$1500 = TabLayout.this.tabIndicatorInterpolator;
                TabLayout tabLayout = TabLayout.this;
                access$1500.setIndicatorBoundsForTab(tabLayout, childAt, tabLayout.tabSelectedIndicator);
                TabLayout.this.indicatorPosition = i5;
            }
        }

        /* access modifiers changed from: private */
        public void jumpIndicatorToSelectedPosition() {
            jumpIndicatorToPosition(TabLayout.this.getSelectedTabPosition());
        }

        /* access modifiers changed from: private */
        public void tweenIndicatorPosition(View view, View view2, float f5) {
            if (view == null || view.getWidth() <= 0) {
                Drawable drawable = TabLayout.this.tabSelectedIndicator;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.tabSelectedIndicator.getBounds().bottom);
            } else {
                TabIndicatorInterpolator access$1500 = TabLayout.this.tabIndicatorInterpolator;
                TabLayout tabLayout = TabLayout.this;
                access$1500.updateIndicatorForOffset(tabLayout, view, view2, f5, tabLayout.tabSelectedIndicator);
            }
            postInvalidateOnAnimation();
        }

        private void updateOrRecreateIndicatorAnimation(boolean z4, int i5, int i6) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.indicatorPosition != i5) {
                final View childAt = getChildAt(tabLayout.getSelectedTabPosition());
                final View childAt2 = getChildAt(i5);
                if (childAt2 == null) {
                    jumpIndicatorToSelectedPosition();
                    return;
                }
                TabLayout.this.indicatorPosition = i5;
                AnonymousClass1 r5 = new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                        SlidingTabIndicator.this.tweenIndicatorPosition(childAt, childAt2, valueAnimator.getAnimatedFraction());
                    }
                };
                if (z4) {
                    ValueAnimator valueAnimator = new ValueAnimator();
                    this.indicatorAnimator = valueAnimator;
                    valueAnimator.setInterpolator(TabLayout.this.tabIndicatorTimeInterpolator);
                    valueAnimator.setDuration((long) i6);
                    valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
                    valueAnimator.addUpdateListener(r5);
                    valueAnimator.start();
                    return;
                }
                this.indicatorAnimator.removeAllUpdateListeners();
                this.indicatorAnimator.addUpdateListener(r5);
            }
        }

        /* access modifiers changed from: package-private */
        public void animateIndicatorToPosition(int i5, int i6) {
            ValueAnimator valueAnimator = this.indicatorAnimator;
            if (!(valueAnimator == null || !valueAnimator.isRunning() || TabLayout.this.indicatorPosition == i5)) {
                this.indicatorAnimator.cancel();
            }
            updateOrRecreateIndicatorAnimation(true, i5, i6);
        }

        /* access modifiers changed from: package-private */
        public boolean childrenNeedLayout() {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                if (getChildAt(i5).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        public void draw(@NonNull Canvas canvas) {
            int i5;
            int height = TabLayout.this.tabSelectedIndicator.getBounds().height();
            if (height < 0) {
                height = TabLayout.this.tabSelectedIndicator.getIntrinsicHeight();
            }
            int i6 = TabLayout.this.tabIndicatorGravity;
            if (i6 == 0) {
                i5 = getHeight() - height;
                height = getHeight();
            } else if (i6 != 1) {
                i5 = 0;
                if (i6 != 2) {
                    if (i6 != 3) {
                        height = 0;
                    } else {
                        height = getHeight();
                    }
                }
            } else {
                i5 = (getHeight() - height) / 2;
                height = (getHeight() + height) / 2;
            }
            if (TabLayout.this.tabSelectedIndicator.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.tabSelectedIndicator.getBounds();
                TabLayout.this.tabSelectedIndicator.setBounds(bounds.left, i5, bounds.right, height);
                TabLayout.this.tabSelectedIndicator.draw(canvas);
            }
            super.draw(canvas);
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
            super.onLayout(z4, i5, i6, i7, i8);
            ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                jumpIndicatorToIndicatorPosition();
            } else {
                updateOrRecreateIndicatorAnimation(false, TabLayout.this.getSelectedTabPosition(), -1);
            }
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i5, int i6) {
            super.onMeasure(i5, i6);
            if (View.MeasureSpec.getMode(i5) == 1073741824) {
                TabLayout tabLayout = TabLayout.this;
                boolean z4 = true;
                if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                    int childCount = getChildCount();
                    int i7 = 0;
                    for (int i8 = 0; i8 < childCount; i8++) {
                        View childAt = getChildAt(i8);
                        if (childAt.getVisibility() == 0) {
                            i7 = Math.max(i7, childAt.getMeasuredWidth());
                        }
                    }
                    if (i7 > 0) {
                        if (i7 * childCount <= getMeasuredWidth() - (((int) ViewUtils.dpToPx(getContext(), 16)) * 2)) {
                            boolean z5 = false;
                            for (int i9 = 0; i9 < childCount; i9++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i9).getLayoutParams();
                                if (layoutParams.width != i7 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i7;
                                    layoutParams.weight = 0.0f;
                                    z5 = true;
                                }
                            }
                            z4 = z5;
                        } else {
                            TabLayout tabLayout2 = TabLayout.this;
                            tabLayout2.tabGravity = 0;
                            tabLayout2.updateTabViews(false);
                        }
                        if (z4) {
                            super.onMeasure(i5, i6);
                        }
                    }
                }
            }
        }

        public void onRtlPropertiesChanged(int i5) {
            super.onRtlPropertiesChanged(i5);
        }

        /* access modifiers changed from: package-private */
        public void setIndicatorPositionFromTabPosition(int i5, float f5) {
            TabLayout.this.indicatorPosition = Math.round(((float) i5) + f5);
            ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.indicatorAnimator.cancel();
            }
            tweenIndicatorPosition(getChildAt(i5), getChildAt(i5 + 1), f5);
        }

        /* access modifiers changed from: package-private */
        public void setSelectedIndicatorHeight(int i5) {
            Rect bounds = TabLayout.this.tabSelectedIndicator.getBounds();
            TabLayout.this.tabSelectedIndicator.setBounds(bounds.left, 0, bounds.right, i5);
            requestLayout();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabGravity {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabIndicatorAnimationMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabIndicatorGravity {
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private int previousScrollState;
        private int scrollState;
        @NonNull
        private final WeakReference<TabLayout> tabLayoutRef;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.tabLayoutRef = new WeakReference<>(tabLayout);
        }

        public void onPageScrollStateChanged(int i5) {
            this.previousScrollState = this.scrollState;
            this.scrollState = i5;
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null) {
                tabLayout.updateViewPagerScrollState(this.scrollState);
            }
        }

        public void onPageScrolled(int i5, float f5, int i6) {
            boolean z4;
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null) {
                int i7 = this.scrollState;
                boolean z5 = true;
                if (i7 != 2 || this.previousScrollState == 1) {
                    z4 = true;
                } else {
                    z4 = true;
                    z5 = false;
                }
                if (i7 == 2 && this.previousScrollState == 0) {
                    z4 = false;
                }
                tabLayout.setScrollPosition(i5, f5, z5, z4, false);
            }
        }

        public void onPageSelected(int i5) {
            boolean z4;
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i5 && i5 < tabLayout.getTabCount()) {
                int i6 = this.scrollState;
                if (i6 == 0 || (i6 == 2 && this.previousScrollState == 0)) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                tabLayout.selectTab(tabLayout.getTabAt(i5), z4);
            }
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    public final class TabView extends LinearLayout {
        @Nullable
        private View badgeAnchorView;
        @Nullable
        private BadgeDrawable badgeDrawable;
        @Nullable
        private Drawable baseBackgroundDrawable;
        @Nullable
        private ImageView customIconView;
        @Nullable
        private TextView customTextView;
        @Nullable
        private View customView;
        private int defaultMaxLines = 2;
        private ImageView iconView;
        private Tab tab;
        private TextView textView;

        public TabView(@NonNull Context context) {
            super(context);
            updateBackgroundDrawable(context);
            setPaddingRelative(TabLayout.this.tabPaddingStart, TabLayout.this.tabPaddingTop, TabLayout.this.tabPaddingEnd, TabLayout.this.tabPaddingBottom);
            setGravity(17);
            setOrientation(TabLayout.this.inlineLabel ^ true ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND));
        }

        private void addOnLayoutChangeListener(@Nullable final View view) {
            if (view != null) {
                view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    public void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
                        if (view.getVisibility() == 0) {
                            TabView.this.tryUpdateBadgeDrawableBounds(view);
                        }
                    }
                });
            }
        }

        private float approximateLineWidth(@NonNull Layout layout, int i5, float f5) {
            return layout.getLineWidth(i5) * (f5 / layout.getPaint().getTextSize());
        }

        private void clipViewToPaddingForBadge(boolean z4) {
            setClipChildren(z4);
            setClipToPadding(z4);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z4);
                viewGroup.setClipToPadding(z4);
            }
        }

        /* access modifiers changed from: private */
        public void drawBackground(@NonNull Canvas canvas) {
            Drawable drawable = this.baseBackgroundDrawable;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.baseBackgroundDrawable.draw(canvas);
            }
        }

        /* access modifiers changed from: private */
        @Nullable
        public BadgeDrawable getBadge() {
            return this.badgeDrawable;
        }

        /* access modifiers changed from: private */
        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            if (this.badgeDrawable == null) {
                this.badgeDrawable = BadgeDrawable.create(getContext());
            }
            tryUpdateBadgeAnchor();
            BadgeDrawable badgeDrawable2 = this.badgeDrawable;
            if (badgeDrawable2 != null) {
                return badgeDrawable2;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        private boolean hasBadgeDrawable() {
            if (this.badgeDrawable != null) {
                return true;
            }
            return false;
        }

        private void inflateAndAddDefaultIconView() {
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, this, false);
            this.iconView = imageView;
            addView(imageView, 0);
        }

        private void inflateAndAddDefaultTextView() {
            TextView textView2 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, this, false);
            this.textView = textView2;
            addView(textView2);
        }

        /* access modifiers changed from: private */
        public void removeBadge() {
            if (this.badgeAnchorView != null) {
                tryRemoveBadgeFromAnchor();
            }
            this.badgeDrawable = null;
        }

        private void tryAttachBadgeToAnchor(@Nullable View view) {
            if (hasBadgeDrawable() && view != null) {
                clipViewToPaddingForBadge(false);
                BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view, (FrameLayout) null);
                this.badgeAnchorView = view;
            }
        }

        private void tryRemoveBadgeFromAnchor() {
            if (hasBadgeDrawable()) {
                clipViewToPaddingForBadge(true);
                View view = this.badgeAnchorView;
                if (view != null) {
                    BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view);
                    this.badgeAnchorView = null;
                }
            }
        }

        private void tryUpdateBadgeAnchor() {
            Tab tab2;
            Tab tab3;
            if (hasBadgeDrawable()) {
                if (this.customView != null) {
                    tryRemoveBadgeFromAnchor();
                } else if (this.iconView != null && (tab3 = this.tab) != null && tab3.getIcon() != null) {
                    View view = this.badgeAnchorView;
                    ImageView imageView = this.iconView;
                    if (view != imageView) {
                        tryRemoveBadgeFromAnchor();
                        tryAttachBadgeToAnchor(this.iconView);
                        return;
                    }
                    tryUpdateBadgeDrawableBounds(imageView);
                } else if (this.textView == null || (tab2 = this.tab) == null || tab2.getTabLabelVisibility() != 1) {
                    tryRemoveBadgeFromAnchor();
                } else {
                    View view2 = this.badgeAnchorView;
                    TextView textView2 = this.textView;
                    if (view2 != textView2) {
                        tryRemoveBadgeFromAnchor();
                        tryAttachBadgeToAnchor(this.textView);
                        return;
                    }
                    tryUpdateBadgeDrawableBounds(textView2);
                }
            }
        }

        /* access modifiers changed from: private */
        public void tryUpdateBadgeDrawableBounds(@NonNull View view) {
            if (hasBadgeDrawable() && view == this.badgeAnchorView) {
                BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, (FrameLayout) null);
            }
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [android.graphics.drawable.RippleDrawable] */
        /* access modifiers changed from: private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void updateBackgroundDrawable(android.content.Context r6) {
            /*
                r5 = this;
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                int r0 = r0.tabBackgroundResId
                r1 = 0
                if (r0 == 0) goto L_0x001f
                android.graphics.drawable.Drawable r6 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r6, r0)
                r5.baseBackgroundDrawable = r6
                if (r6 == 0) goto L_0x0021
                boolean r6 = r6.isStateful()
                if (r6 == 0) goto L_0x0021
                android.graphics.drawable.Drawable r6 = r5.baseBackgroundDrawable
                int[] r0 = r5.getDrawableState()
                r6.setState(r0)
                goto L_0x0021
            L_0x001f:
                r5.baseBackgroundDrawable = r1
            L_0x0021:
                android.graphics.drawable.GradientDrawable r6 = new android.graphics.drawable.GradientDrawable
                r6.<init>()
                r0 = 0
                r6.setColor(r0)
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r0 = r0.tabRippleColorStateList
                if (r0 == 0) goto L_0x0058
                android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable
                r0.<init>()
                r2 = 925353388(0x3727c5ac, float:1.0E-5)
                r0.setCornerRadius(r2)
                r2 = -1
                r0.setColor(r2)
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r2 = r2.tabRippleColorStateList
                android.content.res.ColorStateList r2 = com.google.android.material.ripple.RippleUtils.convertToRippleDrawableColor(r2)
                android.graphics.drawable.RippleDrawable r3 = new android.graphics.drawable.RippleDrawable
                com.google.android.material.tabs.TabLayout r4 = com.google.android.material.tabs.TabLayout.this
                boolean r4 = r4.unboundedRipple
                if (r4 == 0) goto L_0x0050
                r6 = r1
            L_0x0050:
                if (r4 == 0) goto L_0x0053
                goto L_0x0054
            L_0x0053:
                r1 = r0
            L_0x0054:
                r3.<init>(r2, r6, r1)
                r6 = r3
            L_0x0058:
                r5.setBackground(r6)
                com.google.android.material.tabs.TabLayout r6 = com.google.android.material.tabs.TabLayout.this
                r6.invalidate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.TabView.updateBackgroundDrawable(android.content.Context):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x005d, code lost:
            if (com.google.android.material.tabs.TabLayout.Tab.access$1300(r7.tab) == 1) goto L_0x0061;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void updateTextAndIcon(@androidx.annotation.Nullable android.widget.TextView r8, @androidx.annotation.Nullable android.widget.ImageView r9, boolean r10) {
            /*
                r7 = this;
                com.google.android.material.tabs.TabLayout$Tab r0 = r7.tab
                r1 = 0
                if (r0 == 0) goto L_0x001a
                android.graphics.drawable.Drawable r0 = r0.getIcon()
                if (r0 == 0) goto L_0x001a
                com.google.android.material.tabs.TabLayout$Tab r0 = r7.tab
                android.graphics.drawable.Drawable r0 = r0.getIcon()
                android.graphics.drawable.Drawable r0 = androidx.core.graphics.drawable.DrawableCompat.wrap(r0)
                android.graphics.drawable.Drawable r0 = r0.mutate()
                goto L_0x001b
            L_0x001a:
                r0 = r1
            L_0x001b:
                if (r0 == 0) goto L_0x002d
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r2 = r2.tabIconTint
                r0.setTintList(r2)
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                android.graphics.PorterDuff$Mode r2 = r2.tabIconTintMode
                if (r2 == 0) goto L_0x002d
                r0.setTintMode(r2)
            L_0x002d:
                com.google.android.material.tabs.TabLayout$Tab r2 = r7.tab
                if (r2 == 0) goto L_0x0036
                java.lang.CharSequence r2 = r2.getText()
                goto L_0x0037
            L_0x0036:
                r2 = r1
            L_0x0037:
                r3 = 8
                r4 = 0
                if (r9 == 0) goto L_0x004e
                if (r0 == 0) goto L_0x0048
                r9.setImageDrawable(r0)
                r9.setVisibility(r4)
                r7.setVisibility(r4)
                goto L_0x004e
            L_0x0048:
                r9.setVisibility(r3)
                r9.setImageDrawable(r1)
            L_0x004e:
                boolean r0 = android.text.TextUtils.isEmpty(r2)
                if (r8 == 0) goto L_0x0077
                if (r0 != 0) goto L_0x0060
                com.google.android.material.tabs.TabLayout$Tab r5 = r7.tab
                int r5 = r5.labelVisibilityMode
                r6 = 1
                if (r5 != r6) goto L_0x0060
                goto L_0x0061
            L_0x0060:
                r6 = r4
            L_0x0061:
                if (r0 != 0) goto L_0x0065
                r5 = r2
                goto L_0x0066
            L_0x0065:
                r5 = r1
            L_0x0066:
                r8.setText(r5)
                if (r6 == 0) goto L_0x006d
                r5 = r4
                goto L_0x006e
            L_0x006d:
                r5 = r3
            L_0x006e:
                r8.setVisibility(r5)
                if (r0 != 0) goto L_0x0078
                r7.setVisibility(r4)
                goto L_0x0078
            L_0x0077:
                r6 = r4
            L_0x0078:
                if (r10 == 0) goto L_0x00bc
                if (r9 == 0) goto L_0x00bc
                android.view.ViewGroup$LayoutParams r8 = r9.getLayoutParams()
                android.view.ViewGroup$MarginLayoutParams r8 = (android.view.ViewGroup.MarginLayoutParams) r8
                if (r6 == 0) goto L_0x0094
                int r10 = r9.getVisibility()
                if (r10 != 0) goto L_0x0094
                android.content.Context r10 = r7.getContext()
                float r10 = com.google.android.material.internal.ViewUtils.dpToPx(r10, r3)
                int r10 = (int) r10
                goto L_0x0095
            L_0x0094:
                r10 = r4
            L_0x0095:
                com.google.android.material.tabs.TabLayout r3 = com.google.android.material.tabs.TabLayout.this
                boolean r3 = r3.inlineLabel
                if (r3 == 0) goto L_0x00ad
                int r3 = r8.getMarginEnd()
                if (r10 == r3) goto L_0x00bc
                r8.setMarginEnd(r10)
                r8.bottomMargin = r4
                r9.setLayoutParams(r8)
                r9.requestLayout()
                goto L_0x00bc
            L_0x00ad:
                int r3 = r8.bottomMargin
                if (r10 == r3) goto L_0x00bc
                r8.bottomMargin = r10
                r8.setMarginEnd(r4)
                r9.setLayoutParams(r8)
                r9.requestLayout()
            L_0x00bc:
                com.google.android.material.tabs.TabLayout$Tab r8 = r7.tab
                if (r8 == 0) goto L_0x00c4
                java.lang.CharSequence r1 = r8.contentDesc
            L_0x00c4:
                int r8 = android.os.Build.VERSION.SDK_INT
                r9 = 23
                if (r8 <= r9) goto L_0x00d1
                if (r0 != 0) goto L_0x00cd
                goto L_0x00ce
            L_0x00cd:
                r2 = r1
            L_0x00ce:
                androidx.appcompat.widget.TooltipCompat.setTooltipText(r7, r2)
            L_0x00d1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.TabView.updateTextAndIcon(android.widget.TextView, android.widget.ImageView, boolean):void");
        }

        /* access modifiers changed from: protected */
        public void drawableStateChanged() {
            boolean z4;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.baseBackgroundDrawable;
            if (drawable == null || !drawable.isStateful()) {
                z4 = false;
            } else {
                z4 = this.baseBackgroundDrawable.setState(drawableState);
            }
            if (z4) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        /* access modifiers changed from: package-private */
        public int getContentHeight() {
            View[] viewArr = {this.textView, this.iconView, this.customView};
            int i5 = 0;
            int i6 = 0;
            boolean z4 = false;
            for (int i7 = 0; i7 < 3; i7++) {
                View view = viewArr[i7];
                if (view != null && view.getVisibility() == 0) {
                    if (z4) {
                        i6 = Math.min(i6, view.getTop());
                    } else {
                        i6 = view.getTop();
                    }
                    if (z4) {
                        i5 = Math.max(i5, view.getBottom());
                    } else {
                        i5 = view.getBottom();
                    }
                    z4 = true;
                }
            }
            return i5 - i6;
        }

        /* access modifiers changed from: package-private */
        public int getContentWidth() {
            View[] viewArr = {this.textView, this.iconView, this.customView};
            int i5 = 0;
            int i6 = 0;
            boolean z4 = false;
            for (int i7 = 0; i7 < 3; i7++) {
                View view = viewArr[i7];
                if (view != null && view.getVisibility() == 0) {
                    if (z4) {
                        i6 = Math.min(i6, view.getLeft());
                    } else {
                        i6 = view.getLeft();
                    }
                    if (z4) {
                        i5 = Math.max(i5, view.getRight());
                    } else {
                        i5 = view.getRight();
                    }
                    z4 = true;
                }
            }
            return i5 - i6;
        }

        @Nullable
        public Tab getTab() {
            return this.tab;
        }

        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable2 = this.badgeDrawable;
            if (badgeDrawable2 != null && badgeDrawable2.isVisible()) {
                wrap.setContentDescription(this.badgeDrawable.getContentDescription());
            }
            wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.tab.getPosition(), 1, false, isSelected()));
            if (isSelected()) {
                wrap.setClickable(false);
                wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            wrap.setRoleDescription(getResources().getString(R.string.item_view_role_description));
        }

        public void onMeasure(int i5, int i6) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i5);
            int mode = View.MeasureSpec.getMode(i5);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i5 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.tabMaxWidth, Integer.MIN_VALUE);
            }
            super.onMeasure(i5, i6);
            if (this.textView != null) {
                float f5 = TabLayout.this.tabTextSize;
                if (isSelected() && TabLayout.this.selectedTabTextAppearance != -1) {
                    f5 = TabLayout.this.selectedTabTextSize;
                }
                int i7 = this.defaultMaxLines;
                ImageView imageView = this.iconView;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView2 = this.textView;
                    if (textView2 != null && textView2.getLineCount() > 1) {
                        f5 = TabLayout.this.tabTextMultiLineSize;
                    }
                } else {
                    i7 = 1;
                }
                float textSize = this.textView.getTextSize();
                int lineCount = this.textView.getLineCount();
                int maxLines = this.textView.getMaxLines();
                int i8 = (f5 > textSize ? 1 : (f5 == textSize ? 0 : -1));
                if (i8 == 0 && (maxLines < 0 || i7 == maxLines)) {
                    return;
                }
                if (TabLayout.this.mode != 1 || i8 <= 0 || lineCount != 1 || ((layout = this.textView.getLayout()) != null && approximateLineWidth(layout, 0, f5) <= ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())))) {
                    this.textView.setTextSize(0, f5);
                    this.textView.setMaxLines(i7);
                    super.onMeasure(i5, i6);
                }
            }
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.tab == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.tab.select();
            return true;
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            setTab((Tab) null);
            setSelected(false);
        }

        public void setSelected(boolean z4) {
            isSelected();
            super.setSelected(z4);
            TextView textView2 = this.textView;
            if (textView2 != null) {
                textView2.setSelected(z4);
            }
            ImageView imageView = this.iconView;
            if (imageView != null) {
                imageView.setSelected(z4);
            }
            View view = this.customView;
            if (view != null) {
                view.setSelected(z4);
            }
        }

        /* access modifiers changed from: package-private */
        public void setTab(@Nullable Tab tab2) {
            if (tab2 != this.tab) {
                this.tab = tab2;
                update();
            }
        }

        /* access modifiers changed from: package-private */
        public final void update() {
            boolean z4;
            updateTab();
            Tab tab2 = this.tab;
            if (tab2 == null || !tab2.isSelected()) {
                z4 = false;
            } else {
                z4 = true;
            }
            setSelected(z4);
        }

        /* access modifiers changed from: package-private */
        public final void updateOrientation() {
            setOrientation(TabLayout.this.inlineLabel ^ true ? 1 : 0);
            TextView textView2 = this.customTextView;
            if (textView2 == null && this.customIconView == null) {
                updateTextAndIcon(this.textView, this.iconView, true);
            } else {
                updateTextAndIcon(textView2, this.customIconView, false);
            }
        }

        /* access modifiers changed from: package-private */
        public final void updateTab() {
            View view;
            ViewParent parent;
            Tab tab2 = this.tab;
            if (tab2 != null) {
                view = tab2.getCustomView();
            } else {
                view = null;
            }
            if (view != null) {
                ViewParent parent2 = view.getParent();
                if (parent2 != this) {
                    if (parent2 != null) {
                        ((ViewGroup) parent2).removeView(view);
                    }
                    View view2 = this.customView;
                    if (!(view2 == null || (parent = view2.getParent()) == null)) {
                        ((ViewGroup) parent).removeView(this.customView);
                    }
                    addView(view);
                }
                this.customView = view;
                TextView textView2 = this.textView;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                ImageView imageView = this.iconView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.iconView.setImageDrawable((Drawable) null);
                }
                TextView textView3 = (TextView) view.findViewById(16908308);
                this.customTextView = textView3;
                if (textView3 != null) {
                    this.defaultMaxLines = textView3.getMaxLines();
                }
                this.customIconView = (ImageView) view.findViewById(16908294);
            } else {
                View view3 = this.customView;
                if (view3 != null) {
                    removeView(view3);
                    this.customView = null;
                }
                this.customTextView = null;
                this.customIconView = null;
            }
            if (this.customView == null) {
                if (this.iconView == null) {
                    inflateAndAddDefaultIconView();
                }
                if (this.textView == null) {
                    inflateAndAddDefaultTextView();
                    this.defaultMaxLines = this.textView.getMaxLines();
                }
                TextViewCompat.setTextAppearance(this.textView, TabLayout.this.defaultTabTextAppearance);
                if (!isSelected() || TabLayout.this.selectedTabTextAppearance == -1) {
                    TextViewCompat.setTextAppearance(this.textView, TabLayout.this.tabTextAppearance);
                } else {
                    TextViewCompat.setTextAppearance(this.textView, TabLayout.this.selectedTabTextAppearance);
                }
                ColorStateList colorStateList = TabLayout.this.tabTextColors;
                if (colorStateList != null) {
                    this.textView.setTextColor(colorStateList);
                }
                updateTextAndIcon(this.textView, this.iconView, true);
                tryUpdateBadgeAnchor();
                addOnLayoutChangeListener(this.iconView);
                addOnLayoutChangeListener(this.textView);
            } else {
                TextView textView4 = this.customTextView;
                if (!(textView4 == null && this.customIconView == null)) {
                    updateTextAndIcon(textView4, this.customIconView, false);
                }
            }
            if (tab2 != null && !TextUtils.isEmpty(tab2.contentDesc)) {
                setContentDescription(tab2.contentDesc);
            }
        }
    }

    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final ViewPager viewPager;

        public ViewPagerOnTabSelectedListener(ViewPager viewPager2) {
            this.viewPager = viewPager2;
        }

        public void onTabReselected(Tab tab) {
        }

        public void onTabSelected(@NonNull Tab tab) {
            this.viewPager.setCurrentItem(tab.getPosition());
        }

        public void onTabUnselected(Tab tab) {
        }
    }

    public TabLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void addTabFromItemView(@NonNull TabItem tabItem) {
        Tab newTab = newTab();
        CharSequence charSequence = tabItem.text;
        if (charSequence != null) {
            newTab.setText(charSequence);
        }
        Drawable drawable = tabItem.icon;
        if (drawable != null) {
            newTab.setIcon(drawable);
        }
        int i5 = tabItem.customLayout;
        if (i5 != 0) {
            newTab.setCustomView(i5);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            newTab.setContentDescription(tabItem.getContentDescription());
        }
        addTab(newTab);
    }

    private void addTabView(@NonNull Tab tab) {
        TabView tabView = tab.view;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.slidingTabIndicator.addView(tabView, tab.getPosition(), createLayoutParamsForTabs());
    }

    private void addViewInternal(View view) {
        if (view instanceof TabItem) {
            addTabFromItemView((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void animateToTab(int i5) {
        if (i5 != -1) {
            if (getWindowToken() == null || !isLaidOut() || this.slidingTabIndicator.childrenNeedLayout()) {
                setScrollPosition(i5, 0.0f, true);
                return;
            }
            int scrollX = getScrollX();
            int calculateScrollXForTab = calculateScrollXForTab(i5, 0.0f);
            if (scrollX != calculateScrollXForTab) {
                ensureScrollAnimator();
                this.scrollAnimator.setIntValues(new int[]{scrollX, calculateScrollXForTab});
                this.scrollAnimator.start();
            }
            this.slidingTabIndicator.animateIndicatorToPosition(i5, this.tabIndicatorAnimationDuration);
        }
    }

    private void applyGravityForModeScrollable(int i5) {
        if (i5 == 0) {
            Log.w(LOG_TAG, "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        } else if (i5 == 1) {
            this.slidingTabIndicator.setGravity(1);
            return;
        } else if (i5 != 2) {
            return;
        }
        this.slidingTabIndicator.setGravity(GravityCompat.START);
    }

    private void applyModeAndGravity() {
        int i5;
        int i6 = this.mode;
        if (i6 == 0 || i6 == 2) {
            i5 = Math.max(0, this.contentInsetStart - this.tabPaddingStart);
        } else {
            i5 = 0;
        }
        this.slidingTabIndicator.setPaddingRelative(i5, 0, 0, 0);
        int i7 = this.mode;
        if (i7 == 0) {
            applyGravityForModeScrollable(this.tabGravity);
        } else if (i7 == 1 || i7 == 2) {
            if (this.tabGravity == 2) {
                Log.w(LOG_TAG, "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.slidingTabIndicator.setGravity(1);
        }
        updateTabViews(true);
    }

    private int calculateScrollXForTab(int i5, float f5) {
        View childAt;
        View view;
        int i6 = this.mode;
        int i7 = 0;
        if ((i6 != 0 && i6 != 2) || (childAt = this.slidingTabIndicator.getChildAt(i5)) == null) {
            return 0;
        }
        int i8 = i5 + 1;
        if (i8 < this.slidingTabIndicator.getChildCount()) {
            view = this.slidingTabIndicator.getChildAt(i8);
        } else {
            view = null;
        }
        int width = childAt.getWidth();
        if (view != null) {
            i7 = view.getWidth();
        }
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i9 = (int) (((float) (width + i7)) * 0.5f * f5);
        if (getLayoutDirection() == 0) {
            return left + i9;
        }
        return left - i9;
    }

    private void configureTab(@NonNull Tab tab, int i5) {
        tab.setPosition(i5);
        this.tabs.add(i5, tab);
        int size = this.tabs.size();
        int i6 = -1;
        for (int i7 = i5 + 1; i7 < size; i7++) {
            if (this.tabs.get(i7).getPosition() == this.indicatorPosition) {
                i6 = i7;
            }
            this.tabs.get(i7).setPosition(i7);
        }
        this.indicatorPosition = i6;
    }

    @NonNull
    private static ColorStateList createColorStateList(int i5, int i6) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i6, i5});
    }

    @NonNull
    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(layoutParams);
        return layoutParams;
    }

    @NonNull
    private TabView createTabView(@NonNull Tab tab) {
        TabView tabView;
        Pools.Pool<TabView> pool = this.tabViewPool;
        if (pool != null) {
            tabView = pool.acquire();
        } else {
            tabView = null;
        }
        if (tabView == null) {
            tabView = new TabView(getContext());
        }
        tabView.setTab(tab);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(tab.contentDesc)) {
            tabView.setContentDescription(tab.text);
            return tabView;
        }
        tabView.setContentDescription(tab.contentDesc);
        return tabView;
    }

    private void dispatchTabReselected(@NonNull Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabReselected(tab);
        }
    }

    private void dispatchTabSelected(@NonNull Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabSelected(tab);
        }
    }

    private void dispatchTabUnselected(@NonNull Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabUnselected(tab);
        }
    }

    private void ensureScrollAnimator() {
        if (this.scrollAnimator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.scrollAnimator = valueAnimator;
            valueAnimator.setInterpolator(this.tabIndicatorTimeInterpolator);
            this.scrollAnimator.setDuration((long) this.tabIndicatorAnimationDuration);
            this.scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        int size = this.tabs.size();
        int i5 = 0;
        while (i5 < size) {
            Tab tab = this.tabs.get(i5);
            if (tab == null || tab.getIcon() == null || TextUtils.isEmpty(tab.getText())) {
                i5++;
            } else if (!this.inlineLabel) {
                return 72;
            } else {
                return 48;
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i5 = this.requestedTabMinWidth;
        if (i5 != -1) {
            return i5;
        }
        int i6 = this.mode;
        if (i6 == 0 || i6 == 2) {
            return this.scrollableTabMinWidth;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private boolean isScrollingEnabled() {
        if (getTabMode() == 0 || getTabMode() == 2) {
            return true;
        }
        return false;
    }

    private void removeTabViewAt(int i5) {
        TabView tabView = (TabView) this.slidingTabIndicator.getChildAt(i5);
        this.slidingTabIndicator.removeViewAt(i5);
        if (tabView != null) {
            tabView.reset();
            this.tabViewPool.release(tabView);
        }
        requestLayout();
    }

    private void setSelectedTabView(int i5) {
        boolean z4;
        boolean z5;
        int childCount = this.slidingTabIndicator.getChildCount();
        if (i5 < childCount) {
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = this.slidingTabIndicator.getChildAt(i6);
                boolean z6 = true;
                if ((i6 != i5 || childAt.isSelected()) && (i6 == i5 || !childAt.isSelected())) {
                    if (i6 == i5) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    childAt.setSelected(z5);
                    if (i6 != i5) {
                        z6 = false;
                    }
                    childAt.setActivated(z6);
                } else {
                    if (i6 == i5) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    childAt.setSelected(z4);
                    if (i6 != i5) {
                        z6 = false;
                    }
                    childAt.setActivated(z6);
                    if (childAt instanceof TabView) {
                        ((TabView) childAt).updateTab();
                    }
                }
            }
        }
    }

    private void updateAllTabs() {
        int size = this.tabs.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.tabs.get(i5).updateView();
        }
    }

    private void updateTabViewLayoutParams(@NonNull LinearLayout.LayoutParams layoutParams) {
        if (this.mode == 1 && this.tabGravity == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    public void addOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        addOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void addTab(@NonNull Tab tab) {
        addTab(tab, this.tabs.isEmpty());
    }

    public void addView(View view) {
        addViewInternal(view);
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    /* access modifiers changed from: protected */
    public Tab createTabFromPool() {
        Tab acquire = tabPool.acquire();
        if (acquire == null) {
            return new Tab();
        }
        return acquire;
    }

    public int getSelectedTabPosition() {
        Tab tab = this.selectedTab;
        if (tab != null) {
            return tab.getPosition();
        }
        return -1;
    }

    @Nullable
    public Tab getTabAt(int i5) {
        if (i5 < 0 || i5 >= getTabCount()) {
            return null;
        }
        return this.tabs.get(i5);
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public int getTabIndicatorAnimationMode() {
        return this.tabIndicatorAnimationMode;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    /* access modifiers changed from: package-private */
    public int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    public int getTabMode() {
        return this.mode;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    public boolean hasUnboundedRipple() {
        return this.unboundedRipple;
    }

    public boolean isInlineLabel() {
        return this.inlineLabel;
    }

    public boolean isTabIndicatorFullWidth() {
        return this.tabIndicatorFullWidth;
    }

    @NonNull
    public Tab newTab() {
        Tab createTabFromPool = createTabFromPool();
        createTabFromPool.parent = this;
        createTabFromPool.view = createTabView(createTabFromPool);
        if (createTabFromPool.id != -1) {
            createTabFromPool.view.setId(createTabFromPool.id);
        }
        return createTabFromPool;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
        if (this.viewPager == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                setupWithViewPager((ViewPager) parent, true, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.setupViewPagerImplicitly) {
            setupWithViewPager((ViewPager) null);
            this.setupViewPagerImplicitly = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NonNull Canvas canvas) {
        for (int i5 = 0; i5 < this.slidingTabIndicator.getChildCount(); i5++) {
            View childAt = this.slidingTabIndicator.getChildAt(i5);
            if (childAt instanceof TabView) {
                ((TabView) childAt).drawBackground(canvas);
            }
        }
        super.onDraw(canvas);
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isScrollingEnabled() || !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int round = Math.round(ViewUtils.dpToPx(getContext(), getDefaultHeight()));
        int mode2 = View.MeasureSpec.getMode(i6);
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                i6 = View.MeasureSpec.makeMeasureSpec(round + getPaddingTop() + getPaddingBottom(), 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i6) >= round) {
            getChildAt(0).setMinimumHeight(round);
        }
        int size = View.MeasureSpec.getSize(i5);
        if (View.MeasureSpec.getMode(i5) != 0) {
            int i7 = this.requestedTabMaxWidth;
            if (i7 <= 0) {
                i7 = (int) (((float) size) - ViewUtils.dpToPx(getContext(), 56));
            }
            this.tabMaxWidth = i7;
        }
        super.onMeasure(i5, i6);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i8 = this.mode;
            if (i8 != 0) {
                if (i8 == 1) {
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        return;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i6, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
                } else if (i8 != 2) {
                    return;
                }
            }
            if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                return;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i6, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || isScrollingEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void populateFromPagerAdapter() {
        int currentItem;
        removeAllTabs();
        PagerAdapter pagerAdapter2 = this.pagerAdapter;
        if (pagerAdapter2 != null) {
            int count = pagerAdapter2.getCount();
            for (int i5 = 0; i5 < count; i5++) {
                addTab(newTab().setText(this.pagerAdapter.getPageTitle(i5)), false);
            }
            ViewPager viewPager2 = this.viewPager;
            if (viewPager2 != null && count > 0 && (currentItem = viewPager2.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                selectTab(getTabAt(currentItem));
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean releaseFromTabPool(Tab tab) {
        return tabPool.release(tab);
    }

    public void removeAllTabs() {
        for (int childCount = this.slidingTabIndicator.getChildCount() - 1; childCount >= 0; childCount--) {
            removeTabViewAt(childCount);
        }
        Iterator<Tab> it = this.tabs.iterator();
        while (it.hasNext()) {
            Tab next = it.next();
            it.remove();
            next.reset();
            releaseFromTabPool(next);
        }
        this.selectedTab = null;
    }

    public void removeOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        removeOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void removeTab(@NonNull Tab tab) {
        if (tab.parent == this) {
            removeTabAt(tab.getPosition());
            return;
        }
        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    public void removeTabAt(int i5) {
        int i6;
        Tab tab;
        Tab tab2 = this.selectedTab;
        if (tab2 != null) {
            i6 = tab2.getPosition();
        } else {
            i6 = 0;
        }
        removeTabViewAt(i5);
        Tab remove = this.tabs.remove(i5);
        if (remove != null) {
            remove.reset();
            releaseFromTabPool(remove);
        }
        int size = this.tabs.size();
        int i7 = -1;
        for (int i8 = i5; i8 < size; i8++) {
            if (this.tabs.get(i8).getPosition() == this.indicatorPosition) {
                i7 = i8;
            }
            this.tabs.get(i8).setPosition(i8);
        }
        this.indicatorPosition = i7;
        if (i6 == i5) {
            if (this.tabs.isEmpty()) {
                tab = null;
            } else {
                tab = this.tabs.get(Math.max(0, i5 - 1));
            }
            selectTab(tab);
        }
    }

    public void selectTab(@Nullable Tab tab) {
        selectTab(tab, true);
    }

    public void setElevation(float f5) {
        super.setElevation(f5);
        MaterialShapeUtils.setElevation(this, f5);
    }

    public void setInlineLabel(boolean z4) {
        if (this.inlineLabel != z4) {
            this.inlineLabel = z4;
            for (int i5 = 0; i5 < this.slidingTabIndicator.getChildCount(); i5++) {
                View childAt = this.slidingTabIndicator.getChildAt(i5);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateOrientation();
                }
            }
            applyModeAndGravity();
        }
    }

    public void setInlineLabelResource(@BoolRes int i5) {
        setInlineLabel(getResources().getBoolean(i5));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable OnTabSelectedListener onTabSelectedListener) {
        setOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    /* access modifiers changed from: package-private */
    public void setPagerAdapter(@Nullable PagerAdapter pagerAdapter2, boolean z4) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter3 = this.pagerAdapter;
        if (!(pagerAdapter3 == null || (dataSetObserver = this.pagerAdapterObserver) == null)) {
            pagerAdapter3.unregisterDataSetObserver(dataSetObserver);
        }
        this.pagerAdapter = pagerAdapter2;
        if (z4 && pagerAdapter2 != null) {
            if (this.pagerAdapterObserver == null) {
                this.pagerAdapterObserver = new PagerAdapterObserver();
            }
            pagerAdapter2.registerDataSetObserver(this.pagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    /* access modifiers changed from: package-private */
    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        ensureScrollAnimator();
        this.scrollAnimator.addListener(animatorListener);
    }

    public void setScrollPosition(int i5, float f5, boolean z4) {
        setScrollPosition(i5, f5, z4, true);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable mutate = DrawableCompat.wrap(drawable).mutate();
        this.tabSelectedIndicator = mutate;
        DrawableUtils.setTint(mutate, this.tabSelectedIndicatorColor);
        int i5 = this.tabIndicatorHeight;
        if (i5 == -1) {
            i5 = this.tabSelectedIndicator.getIntrinsicHeight();
        }
        this.slidingTabIndicator.setSelectedIndicatorHeight(i5);
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i5) {
        this.tabSelectedIndicatorColor = i5;
        DrawableUtils.setTint(this.tabSelectedIndicator, i5);
        updateTabViews(false);
    }

    public void setSelectedTabIndicatorGravity(int i5) {
        if (this.tabIndicatorGravity != i5) {
            this.tabIndicatorGravity = i5;
            this.slidingTabIndicator.postInvalidateOnAnimation();
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i5) {
        this.tabIndicatorHeight = i5;
        this.slidingTabIndicator.setSelectedIndicatorHeight(i5);
    }

    public void setTabGravity(int i5) {
        if (this.tabGravity != i5) {
            this.tabGravity = i5;
            applyModeAndGravity();
        }
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.tabIconTint != colorStateList) {
            this.tabIconTint = colorStateList;
            updateAllTabs();
        }
    }

    public void setTabIconTintResource(@ColorRes int i5) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), i5));
    }

    public void setTabIndicatorAnimationMode(int i5) {
        this.tabIndicatorAnimationMode = i5;
        if (i5 == 0) {
            this.tabIndicatorInterpolator = new TabIndicatorInterpolator();
        } else if (i5 == 1) {
            this.tabIndicatorInterpolator = new ElasticTabIndicatorInterpolator();
        } else if (i5 == 2) {
            this.tabIndicatorInterpolator = new FadeTabIndicatorInterpolator();
        } else {
            throw new IllegalArgumentException(i5 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z4) {
        this.tabIndicatorFullWidth = z4;
        this.slidingTabIndicator.jumpIndicatorToSelectedPosition();
        this.slidingTabIndicator.postInvalidateOnAnimation();
    }

    public void setTabMode(int i5) {
        if (i5 != this.mode) {
            this.mode = i5;
            applyModeAndGravity();
        }
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.tabRippleColorStateList != colorStateList) {
            this.tabRippleColorStateList = colorStateList;
            for (int i5 = 0; i5 < this.slidingTabIndicator.getChildCount(); i5++) {
                View childAt = this.slidingTabIndicator.getChildAt(i5);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateBackgroundDrawable(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(@ColorRes int i5) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), i5));
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.tabTextColors != colorStateList) {
            this.tabTextColors = colorStateList;
            updateAllTabs();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter2) {
        setPagerAdapter(pagerAdapter2, false);
    }

    public void setUnboundedRipple(boolean z4) {
        if (this.unboundedRipple != z4) {
            this.unboundedRipple = z4;
            for (int i5 = 0; i5 < this.slidingTabIndicator.getChildCount(); i5++) {
                View childAt = this.slidingTabIndicator.getChildAt(i5);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateBackgroundDrawable(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(@BoolRes int i5) {
        setUnboundedRipple(getResources().getBoolean(i5));
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager2) {
        setupWithViewPager(viewPager2, true);
    }

    public boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() > 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void updateTabViews(boolean z4) {
        for (int i5 = 0; i5 < this.slidingTabIndicator.getChildCount(); i5++) {
            View childAt = this.slidingTabIndicator.getChildAt(i5);
            childAt.setMinimumWidth(getTabMinWidth());
            updateTabViewLayoutParams((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z4) {
                childAt.requestLayout();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void updateViewPagerScrollState(int i5) {
        this.viewPagerScrollState = i5;
    }

    public static class Tab {
        public static final int INVALID_POSITION = -1;
        /* access modifiers changed from: private */
        @Nullable
        public CharSequence contentDesc;
        @Nullable
        private View customView;
        @Nullable
        private Drawable icon;
        /* access modifiers changed from: private */
        public int id = -1;
        /* access modifiers changed from: private */
        public int labelVisibilityMode = 1;
        @Nullable
        public TabLayout parent;
        private int position = -1;
        @Nullable
        private Object tag;
        /* access modifiers changed from: private */
        @Nullable
        public CharSequence text;
        @NonNull
        public TabView view;

        @Nullable
        public BadgeDrawable getBadge() {
            return this.view.getBadge();
        }

        @Nullable
        public CharSequence getContentDescription() {
            TabView tabView = this.view;
            if (tabView == null) {
                return null;
            }
            return tabView.getContentDescription();
        }

        @Nullable
        public View getCustomView() {
            return this.customView;
        }

        @Nullable
        public Drawable getIcon() {
            return this.icon;
        }

        public int getId() {
            return this.id;
        }

        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            return this.view.getOrCreateBadge();
        }

        public int getPosition() {
            return this.position;
        }

        public int getTabLabelVisibility() {
            return this.labelVisibilityMode;
        }

        @Nullable
        public Object getTag() {
            return this.tag;
        }

        @Nullable
        public CharSequence getText() {
            return this.text;
        }

        public boolean isSelected() {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                int selectedTabPosition = tabLayout.getSelectedTabPosition();
                if (selectedTabPosition == -1 || selectedTabPosition != this.position) {
                    return false;
                }
                return true;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void removeBadge() {
            this.view.removeBadge();
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            this.parent = null;
            this.view = null;
            this.tag = null;
            this.icon = null;
            this.id = -1;
            this.text = null;
            this.contentDesc = null;
            this.position = -1;
            this.customView = null;
        }

        public void select() {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                tabLayout.selectTab(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setContentDescription(@StringRes int i5) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setContentDescription(tabLayout.getResources().getText(i5));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setCustomView(@Nullable View view2) {
            this.customView = view2;
            updateView();
            return this;
        }

        @NonNull
        public Tab setIcon(@Nullable Drawable drawable) {
            this.icon = drawable;
            TabLayout tabLayout = this.parent;
            if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                tabLayout.updateTabViews(true);
            }
            updateView();
            return this;
        }

        @NonNull
        public Tab setId(int i5) {
            this.id = i5;
            TabView tabView = this.view;
            if (tabView != null) {
                tabView.setId(i5);
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public void setPosition(int i5) {
            this.position = i5;
        }

        @NonNull
        public Tab setTabLabelVisibility(int i5) {
            this.labelVisibilityMode = i5;
            TabLayout tabLayout = this.parent;
            if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                tabLayout.updateTabViews(true);
            }
            updateView();
            return this;
        }

        @NonNull
        public Tab setTag(@Nullable Object obj) {
            this.tag = obj;
            return this;
        }

        @NonNull
        public Tab setText(@Nullable CharSequence charSequence) {
            if (TextUtils.isEmpty(this.contentDesc) && !TextUtils.isEmpty(charSequence)) {
                this.view.setContentDescription(charSequence);
            }
            this.text = charSequence;
            updateView();
            return this;
        }

        /* access modifiers changed from: package-private */
        public void updateView() {
            TabView tabView = this.view;
            if (tabView != null) {
                tabView.update();
            }
        }

        @NonNull
        public Tab setCustomView(@LayoutRes int i5) {
            return setCustomView(LayoutInflater.from(this.view.getContext()).inflate(i5, this.view, false));
        }

        @NonNull
        public Tab setContentDescription(@Nullable CharSequence charSequence) {
            this.contentDesc = charSequence;
            updateView();
            return this;
        }

        @NonNull
        public Tab setIcon(@DrawableRes int i5) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setIcon(AppCompatResources.getDrawable(tabLayout.getContext(), i5));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setText(@StringRes int i5) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setText(tabLayout.getResources().getText(i5));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    @Deprecated
    public void addOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        if (!this.selectedListeners.contains(baseOnTabSelectedListener)) {
            this.selectedListeners.add(baseOnTabSelectedListener);
        }
    }

    public void addTab(@NonNull Tab tab, int i5) {
        addTab(tab, i5, this.tabs.isEmpty());
    }

    public void addView(View view, int i5) {
        addViewInternal(view);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void removeOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        this.selectedListeners.remove(baseOnTabSelectedListener);
    }

    public void selectTab(@Nullable Tab tab, boolean z4) {
        Tab tab2 = this.selectedTab;
        if (tab2 != tab) {
            int position = tab != null ? tab.getPosition() : -1;
            if (z4) {
                if ((tab2 == null || tab2.getPosition() == -1) && position != -1) {
                    setScrollPosition(position, 0.0f, true);
                } else {
                    animateToTab(position);
                }
                if (position != -1) {
                    setSelectedTabView(position);
                }
            }
            this.selectedTab = tab;
            if (!(tab2 == null || tab2.parent == null)) {
                dispatchTabUnselected(tab2);
            }
            if (tab != null) {
                dispatchTabSelected(tab);
            }
        } else if (tab2 != null) {
            dispatchTabReselected(tab);
            animateToTab(tab.getPosition());
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        BaseOnTabSelectedListener baseOnTabSelectedListener2 = this.selectedListener;
        if (baseOnTabSelectedListener2 != null) {
            removeOnTabSelectedListener(baseOnTabSelectedListener2);
        }
        this.selectedListener = baseOnTabSelectedListener;
        if (baseOnTabSelectedListener != null) {
            addOnTabSelectedListener(baseOnTabSelectedListener);
        }
    }

    public void setScrollPosition(int i5, float f5, boolean z4, boolean z5) {
        setScrollPosition(i5, f5, z4, z5, true);
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager2, boolean z4) {
        setupWithViewPager(viewPager2, z4, false);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TabLayout(@androidx.annotation.NonNull android.content.Context r10, @androidx.annotation.Nullable android.util.AttributeSet r11, int r12) {
        /*
            r9 = this;
            int r4 = DEF_STYLE_RES
            android.content.Context r10 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r10, r11, r12, r4)
            r9.<init>(r10, r11, r12)
            r10 = -1
            r9.indicatorPosition = r10
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r9.tabs = r0
            r9.selectedTabTextAppearance = r10
            r6 = 0
            r9.tabSelectedIndicatorColor = r6
            r0 = 2147483647(0x7fffffff, float:NaN)
            r9.tabMaxWidth = r0
            r9.tabIndicatorHeight = r10
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r9.selectedListeners = r0
            androidx.core.util.Pools$SimplePool r0 = new androidx.core.util.Pools$SimplePool
            r1 = 12
            r0.<init>(r1)
            r9.tabViewPool = r0
            android.content.Context r0 = r9.getContext()
            r9.setHorizontalScrollBarEnabled(r6)
            com.google.android.material.tabs.TabLayout$SlidingTabIndicator r7 = new com.google.android.material.tabs.TabLayout$SlidingTabIndicator
            r7.<init>(r0)
            r9.slidingTabIndicator = r7
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r2 = -2
            r1.<init>(r2, r10)
            super.addView(r7, r6, r1)
            int[] r2 = com.google.android.material.R.styleable.TabLayout
            int r8 = com.google.android.material.R.styleable.TabLayout_tabTextAppearance
            int[] r5 = new int[]{r8}
            r1 = r11
            r3 = r12
            android.content.res.TypedArray r11 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            android.graphics.drawable.Drawable r12 = r9.getBackground()
            android.content.res.ColorStateList r12 = com.google.android.material.drawable.DrawableUtils.getColorStateListOrNull(r12)
            if (r12 == 0) goto L_0x0073
            com.google.android.material.shape.MaterialShapeDrawable r1 = new com.google.android.material.shape.MaterialShapeDrawable
            r1.<init>()
            r1.setFillColor(r12)
            r1.initializeElevationOverlay(r0)
            float r12 = r9.getElevation()
            r1.setElevation(r12)
            r9.setBackground(r1)
        L_0x0073:
            int r12 = com.google.android.material.R.styleable.TabLayout_tabIndicator
            android.graphics.drawable.Drawable r12 = com.google.android.material.resources.MaterialResources.getDrawable(r0, r11, r12)
            r9.setSelectedTabIndicator((android.graphics.drawable.Drawable) r12)
            int r12 = com.google.android.material.R.styleable.TabLayout_tabIndicatorColor
            int r12 = r11.getColor(r12, r6)
            r9.setSelectedTabIndicatorColor(r12)
            int r12 = com.google.android.material.R.styleable.TabLayout_tabIndicatorHeight
            int r12 = r11.getDimensionPixelSize(r12, r10)
            r7.setSelectedIndicatorHeight(r12)
            int r12 = com.google.android.material.R.styleable.TabLayout_tabIndicatorGravity
            int r12 = r11.getInt(r12, r6)
            r9.setSelectedTabIndicatorGravity(r12)
            int r12 = com.google.android.material.R.styleable.TabLayout_tabIndicatorAnimationMode
            int r12 = r11.getInt(r12, r6)
            r9.setTabIndicatorAnimationMode(r12)
            int r12 = com.google.android.material.R.styleable.TabLayout_tabIndicatorFullWidth
            r1 = 1
            boolean r12 = r11.getBoolean(r12, r1)
            r9.setTabIndicatorFullWidth(r12)
            int r12 = com.google.android.material.R.styleable.TabLayout_tabPadding
            int r12 = r11.getDimensionPixelSize(r12, r6)
            r9.tabPaddingBottom = r12
            r9.tabPaddingEnd = r12
            r9.tabPaddingTop = r12
            r9.tabPaddingStart = r12
            int r2 = com.google.android.material.R.styleable.TabLayout_tabPaddingStart
            int r12 = r11.getDimensionPixelSize(r2, r12)
            r9.tabPaddingStart = r12
            int r12 = com.google.android.material.R.styleable.TabLayout_tabPaddingTop
            int r2 = r9.tabPaddingTop
            int r12 = r11.getDimensionPixelSize(r12, r2)
            r9.tabPaddingTop = r12
            int r12 = com.google.android.material.R.styleable.TabLayout_tabPaddingEnd
            int r2 = r9.tabPaddingEnd
            int r12 = r11.getDimensionPixelSize(r12, r2)
            r9.tabPaddingEnd = r12
            int r12 = com.google.android.material.R.styleable.TabLayout_tabPaddingBottom
            int r2 = r9.tabPaddingBottom
            int r12 = r11.getDimensionPixelSize(r12, r2)
            r9.tabPaddingBottom = r12
            boolean r12 = com.google.android.material.internal.ThemeEnforcement.isMaterial3Theme(r0)
            if (r12 == 0) goto L_0x00e9
            int r12 = com.google.android.material.R.attr.textAppearanceTitleSmall
            r9.defaultTabTextAppearance = r12
            goto L_0x00ed
        L_0x00e9:
            int r12 = com.google.android.material.R.attr.textAppearanceButton
            r9.defaultTabTextAppearance = r12
        L_0x00ed:
            int r12 = com.google.android.material.R.style.TextAppearance_Design_Tab
            int r12 = r11.getResourceId(r8, r12)
            r9.tabTextAppearance = r12
            int[] r2 = androidx.appcompat.R.styleable.TextAppearance
            android.content.res.TypedArray r3 = r0.obtainStyledAttributes(r12, r2)
            int r4 = androidx.appcompat.R.styleable.TextAppearance_android_textSize     // Catch:{ all -> 0x020f }
            int r5 = r3.getDimensionPixelSize(r4, r6)     // Catch:{ all -> 0x020f }
            float r5 = (float) r5     // Catch:{ all -> 0x020f }
            r9.tabTextSize = r5     // Catch:{ all -> 0x020f }
            int r5 = androidx.appcompat.R.styleable.TextAppearance_android_textColor     // Catch:{ all -> 0x020f }
            android.content.res.ColorStateList r7 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r0, (android.content.res.TypedArray) r3, (int) r5)     // Catch:{ all -> 0x020f }
            r9.tabTextColors = r7     // Catch:{ all -> 0x020f }
            r3.recycle()
            int r3 = com.google.android.material.R.styleable.TabLayout_tabSelectedTextAppearance
            boolean r7 = r11.hasValue(r3)
            if (r7 == 0) goto L_0x011d
            int r12 = r11.getResourceId(r3, r12)
            r9.selectedTabTextAppearance = r12
        L_0x011d:
            int r12 = r9.selectedTabTextAppearance
            if (r12 == r10) goto L_0x015c
            android.content.res.TypedArray r12 = r0.obtainStyledAttributes(r12, r2)
            float r2 = r9.tabTextSize     // Catch:{ all -> 0x0151 }
            int r2 = (int) r2     // Catch:{ all -> 0x0151 }
            int r2 = r12.getDimensionPixelSize(r4, r2)     // Catch:{ all -> 0x0151 }
            float r2 = (float) r2     // Catch:{ all -> 0x0151 }
            r9.selectedTabTextSize = r2     // Catch:{ all -> 0x0151 }
            android.content.res.ColorStateList r2 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r0, (android.content.res.TypedArray) r12, (int) r5)     // Catch:{ all -> 0x0151 }
            if (r2 == 0) goto L_0x0154
            android.content.res.ColorStateList r3 = r9.tabTextColors     // Catch:{ all -> 0x0151 }
            int r3 = r3.getDefaultColor()     // Catch:{ all -> 0x0151 }
            r4 = 16842913(0x10100a1, float:2.369401E-38)
            int[] r4 = new int[]{r4}     // Catch:{ all -> 0x0151 }
            int r5 = r2.getDefaultColor()     // Catch:{ all -> 0x0151 }
            int r2 = r2.getColorForState(r4, r5)     // Catch:{ all -> 0x0151 }
            android.content.res.ColorStateList r2 = createColorStateList(r3, r2)     // Catch:{ all -> 0x0151 }
            r9.tabTextColors = r2     // Catch:{ all -> 0x0151 }
            goto L_0x0154
        L_0x0151:
            r0 = move-exception
            r10 = r0
            goto L_0x0158
        L_0x0154:
            r12.recycle()
            goto L_0x015c
        L_0x0158:
            r12.recycle()
            throw r10
        L_0x015c:
            int r12 = com.google.android.material.R.styleable.TabLayout_tabTextColor
            boolean r2 = r11.hasValue(r12)
            if (r2 == 0) goto L_0x016a
            android.content.res.ColorStateList r12 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r0, (android.content.res.TypedArray) r11, (int) r12)
            r9.tabTextColors = r12
        L_0x016a:
            int r12 = com.google.android.material.R.styleable.TabLayout_tabSelectedTextColor
            boolean r2 = r11.hasValue(r12)
            if (r2 == 0) goto L_0x0182
            int r12 = r11.getColor(r12, r6)
            android.content.res.ColorStateList r2 = r9.tabTextColors
            int r2 = r2.getDefaultColor()
            android.content.res.ColorStateList r12 = createColorStateList(r2, r12)
            r9.tabTextColors = r12
        L_0x0182:
            int r12 = com.google.android.material.R.styleable.TabLayout_tabIconTint
            android.content.res.ColorStateList r12 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r0, (android.content.res.TypedArray) r11, (int) r12)
            r9.tabIconTint = r12
            int r12 = com.google.android.material.R.styleable.TabLayout_tabIconTintMode
            int r12 = r11.getInt(r12, r10)
            r2 = 0
            android.graphics.PorterDuff$Mode r12 = com.google.android.material.internal.ViewUtils.parseTintMode(r12, r2)
            r9.tabIconTintMode = r12
            int r12 = com.google.android.material.R.styleable.TabLayout_tabRippleColor
            android.content.res.ColorStateList r12 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r0, (android.content.res.TypedArray) r11, (int) r12)
            r9.tabRippleColorStateList = r12
            int r12 = com.google.android.material.R.styleable.TabLayout_tabIndicatorAnimationDuration
            r2 = 300(0x12c, float:4.2E-43)
            int r12 = r11.getInt(r12, r2)
            r9.tabIndicatorAnimationDuration = r12
            int r12 = com.google.android.material.R.attr.motionEasingEmphasizedInterpolator
            android.animation.TimeInterpolator r2 = com.google.android.material.animation.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR
            android.animation.TimeInterpolator r12 = com.google.android.material.motion.MotionUtils.resolveThemeInterpolator(r0, r12, r2)
            r9.tabIndicatorTimeInterpolator = r12
            int r12 = com.google.android.material.R.styleable.TabLayout_tabMinWidth
            int r12 = r11.getDimensionPixelSize(r12, r10)
            r9.requestedTabMinWidth = r12
            int r12 = com.google.android.material.R.styleable.TabLayout_tabMaxWidth
            int r10 = r11.getDimensionPixelSize(r12, r10)
            r9.requestedTabMaxWidth = r10
            int r10 = com.google.android.material.R.styleable.TabLayout_tabBackground
            int r10 = r11.getResourceId(r10, r6)
            r9.tabBackgroundResId = r10
            int r10 = com.google.android.material.R.styleable.TabLayout_tabContentStart
            int r10 = r11.getDimensionPixelSize(r10, r6)
            r9.contentInsetStart = r10
            int r10 = com.google.android.material.R.styleable.TabLayout_tabMode
            int r10 = r11.getInt(r10, r1)
            r9.mode = r10
            int r10 = com.google.android.material.R.styleable.TabLayout_tabGravity
            int r10 = r11.getInt(r10, r6)
            r9.tabGravity = r10
            int r10 = com.google.android.material.R.styleable.TabLayout_tabInlineLabel
            boolean r10 = r11.getBoolean(r10, r6)
            r9.inlineLabel = r10
            int r10 = com.google.android.material.R.styleable.TabLayout_tabUnboundedRipple
            boolean r10 = r11.getBoolean(r10, r6)
            r9.unboundedRipple = r10
            r11.recycle()
            android.content.res.Resources r10 = r9.getResources()
            int r11 = com.google.android.material.R.dimen.design_tab_text_size_2line
            int r11 = r10.getDimensionPixelSize(r11)
            float r11 = (float) r11
            r9.tabTextMultiLineSize = r11
            int r11 = com.google.android.material.R.dimen.design_tab_scrollable_min_width
            int r10 = r10.getDimensionPixelSize(r11)
            r9.scrollableTabMinWidth = r10
            r9.applyModeAndGravity()
            return
        L_0x020f:
            r0 = move-exception
            r10 = r0
            r3.recycle()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void setupWithViewPager(@Nullable ViewPager viewPager2, boolean z4, boolean z5) {
        ViewPager viewPager3 = this.viewPager;
        if (viewPager3 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.pageChangeListener;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager3.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
            }
            AdapterChangeListener adapterChangeListener2 = this.adapterChangeListener;
            if (adapterChangeListener2 != null) {
                this.viewPager.removeOnAdapterChangeListener(adapterChangeListener2);
            }
        }
        BaseOnTabSelectedListener baseOnTabSelectedListener = this.currentVpSelectedListener;
        if (baseOnTabSelectedListener != null) {
            removeOnTabSelectedListener(baseOnTabSelectedListener);
            this.currentVpSelectedListener = null;
        }
        if (viewPager2 != null) {
            this.viewPager = viewPager2;
            if (this.pageChangeListener == null) {
                this.pageChangeListener = new TabLayoutOnPageChangeListener(this);
            }
            this.pageChangeListener.reset();
            viewPager2.addOnPageChangeListener(this.pageChangeListener);
            ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(viewPager2);
            this.currentVpSelectedListener = viewPagerOnTabSelectedListener;
            addOnTabSelectedListener((BaseOnTabSelectedListener) viewPagerOnTabSelectedListener);
            PagerAdapter adapter = viewPager2.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, z4);
            }
            if (this.adapterChangeListener == null) {
                this.adapterChangeListener = new AdapterChangeListener();
            }
            this.adapterChangeListener.setAutoRefresh(z4);
            viewPager2.addOnAdapterChangeListener(this.adapterChangeListener);
            setScrollPosition(viewPager2.getCurrentItem(), 0.0f, true);
        } else {
            this.viewPager = null;
            setPagerAdapter((PagerAdapter) null, false);
        }
        this.setupViewPagerImplicitly = z5;
    }

    public void addTab(@NonNull Tab tab, boolean z4) {
        addTab(tab, this.tabs.size(), z4);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    /* access modifiers changed from: package-private */
    public void setScrollPosition(int i5, float f5, boolean z4, boolean z5, boolean z6) {
        int round = Math.round(((float) i5) + f5);
        if (round >= 0 && round < this.slidingTabIndicator.getChildCount()) {
            if (z5) {
                this.slidingTabIndicator.setIndicatorPositionFromTabPosition(i5, f5);
            }
            ValueAnimator valueAnimator = this.scrollAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.scrollAnimator.cancel();
            }
            int calculateScrollXForTab = calculateScrollXForTab(i5, f5);
            int scrollX = getScrollX();
            boolean z7 = (i5 < getSelectedTabPosition() && calculateScrollXForTab >= scrollX) || (i5 > getSelectedTabPosition() && calculateScrollXForTab <= scrollX) || i5 == getSelectedTabPosition();
            if (getLayoutDirection() == 1) {
                z7 = (i5 < getSelectedTabPosition() && calculateScrollXForTab <= scrollX) || (i5 > getSelectedTabPosition() && calculateScrollXForTab >= scrollX) || i5 == getSelectedTabPosition();
            }
            if (z7 || this.viewPagerScrollState == 1 || z6) {
                if (i5 < 0) {
                    calculateScrollXForTab = 0;
                }
                scrollTo(calculateScrollXForTab, 0);
            }
            if (z4) {
                setSelectedTabView(round);
            }
        }
    }

    public void addTab(@NonNull Tab tab, int i5, boolean z4) {
        if (tab.parent == this) {
            configureTab(tab, i5);
            addTabView(tab);
            if (z4) {
                tab.select();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    public void setTabTextColors(int i5, int i6) {
        setTabTextColors(createColorStateList(i5, i6));
    }

    public void setSelectedTabIndicator(@DrawableRes int i5) {
        if (i5 != 0) {
            setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), i5));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
