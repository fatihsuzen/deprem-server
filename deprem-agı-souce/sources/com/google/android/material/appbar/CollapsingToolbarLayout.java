package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CollapsingToolbarLayout extends FrameLayout {
    private static final int COLLAPSED_TITLE_GRAVITY_AVAILABLE_SPACE = 1;
    private static final int COLLAPSED_TITLE_GRAVITY_ENTIRE_SPACE = 0;
    private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_CollapsingToolbar;
    public static final int TITLE_COLLAPSE_MODE_FADE = 1;
    public static final int TITLE_COLLAPSE_MODE_SCALE = 0;
    private final int collapsedTitleGravityMode;
    @NonNull
    final CollapsingTextHelper collapsingSubtitleHelper;
    private boolean collapsingTitleEnabled;
    @NonNull
    final CollapsingTextHelper collapsingTitleHelper;
    @Nullable
    private Drawable contentScrim;
    int currentOffset;
    private boolean drawCollapsingTitle;
    private View dummyView;
    @NonNull
    final ElevationOverlayProvider elevationOverlayProvider;
    private int expandedMarginBottom;
    private int expandedMarginEnd;
    private int expandedMarginStart;
    private int expandedMarginTop;
    private int expandedTitleSpacing;
    private int extraHeightForTitles;
    private boolean extraMultilineHeightEnabled;
    private int extraMultilineSubtitleHeight;
    private int extraMultilineTitleHeight;
    private boolean forceApplySystemWindowInsetTop;
    @Nullable
    WindowInsetsCompat lastInsets;
    private AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
    private boolean refreshToolbar;
    private int screenOrientation;
    private int scrimAlpha;
    private long scrimAnimationDuration;
    private final TimeInterpolator scrimAnimationFadeInInterpolator;
    private final TimeInterpolator scrimAnimationFadeOutInterpolator;
    private ValueAnimator scrimAnimator;
    private int scrimVisibleHeightTrigger;
    private boolean scrimsAreShown;
    @Nullable
    Drawable statusBarScrim;
    private int titleCollapseMode;
    private final Rect tmpRect;
    @Nullable
    private ViewGroup toolbar;
    @Nullable
    private View toolbarDirectChild;
    private int toolbarId;
    private int topInsetApplied;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CollapsedTitleGravityMode {
    }

    private class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        OffsetUpdateListener() {
        }

        public void onOffsetChanged(AppBarLayout appBarLayout, int i5) {
            int i6;
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.currentOffset = i5;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.lastInsets;
            if (windowInsetsCompat != null) {
                i6 = windowInsetsCompat.getSystemWindowInsetTop();
            } else {
                i6 = 0;
            }
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i7);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ViewOffsetHelper viewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper(childAt);
                int i8 = layoutParams.collapseMode;
                if (i8 == 1) {
                    viewOffsetHelper.setTopAndBottomOffset(MathUtils.clamp(-i5, 0, CollapsingToolbarLayout.this.getMaxOffsetForPinChild(childAt)));
                } else if (i8 == 2) {
                    viewOffsetHelper.setTopAndBottomOffset(Math.round(((float) (-i5)) * layoutParams.parallaxMult));
                }
            }
            CollapsingToolbarLayout.this.updateScrimVisibility();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.statusBarScrim != null && i6 > 0) {
                collapsingToolbarLayout2.postInvalidateOnAnimation();
            }
            int height = CollapsingToolbarLayout.this.getHeight();
            int minimumHeight = (height - CollapsingToolbarLayout.this.getMinimumHeight()) - i6;
            int scrimVisibleHeightTrigger = height - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger();
            int i9 = CollapsingToolbarLayout.this.currentOffset + minimumHeight;
            float f5 = (float) minimumHeight;
            float abs = ((float) Math.abs(i5)) / f5;
            float f6 = ((float) scrimVisibleHeightTrigger) / f5;
            CollapsingToolbarLayout.this.collapsingTitleHelper.setFadeModeStartFraction(Math.min(1.0f, f6));
            CollapsingToolbarLayout.this.collapsingTitleHelper.setCurrentOffsetY(i9);
            CollapsingToolbarLayout.this.collapsingTitleHelper.setExpansionFraction(abs);
            CollapsingToolbarLayout.this.collapsingSubtitleHelper.setFadeModeStartFraction(Math.min(1.0f, f6));
            CollapsingToolbarLayout.this.collapsingSubtitleHelper.setCurrentOffsetY(i9);
            CollapsingToolbarLayout.this.collapsingSubtitleHelper.setExpansionFraction(abs);
        }
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface StaticLayoutBuilderConfigurer extends com.google.android.material.internal.StaticLayoutBuilderConfigurer {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TitleCollapseMode {
    }

    public CollapsingToolbarLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void animateScrim(int i5) {
        TimeInterpolator timeInterpolator;
        ensureToolbar();
        ValueAnimator valueAnimator = this.scrimAnimator;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.scrimAnimator = valueAnimator2;
            if (i5 > this.scrimAlpha) {
                timeInterpolator = this.scrimAnimationFadeInInterpolator;
            } else {
                timeInterpolator = this.scrimAnimationFadeOutInterpolator;
            }
            valueAnimator2.setInterpolator(timeInterpolator);
            this.scrimAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
        } else if (valueAnimator.isRunning()) {
            this.scrimAnimator.cancel();
        }
        this.scrimAnimator.setDuration(this.scrimAnimationDuration);
        this.scrimAnimator.setIntValues(new int[]{this.scrimAlpha, i5});
        this.scrimAnimator.start();
    }

    private TextUtils.TruncateAt convertEllipsizeToTruncateAt(int i5) {
        if (i5 == 0) {
            return TextUtils.TruncateAt.START;
        }
        if (i5 == 1) {
            return TextUtils.TruncateAt.MIDDLE;
        }
        if (i5 != 3) {
            return TextUtils.TruncateAt.END;
        }
        return TextUtils.TruncateAt.MARQUEE;
    }

    private void disableLiftOnScrollIfNeeded(AppBarLayout appBarLayout) {
        if (isTitleCollapseFadeMode()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.view.ViewGroup} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ensureToolbar() {
        /*
            r6 = this;
            boolean r0 = r6.refreshToolbar
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r6.toolbar = r0
            r6.toolbarDirectChild = r0
            int r1 = r6.toolbarId
            r2 = -1
            if (r1 == r2) goto L_0x001f
            android.view.View r1 = r6.findViewById(r1)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r6.toolbar = r1
            if (r1 == 0) goto L_0x001f
            android.view.View r1 = r6.findDirectChild(r1)
            r6.toolbarDirectChild = r1
        L_0x001f:
            android.view.ViewGroup r1 = r6.toolbar
            r2 = 0
            if (r1 != 0) goto L_0x003e
            int r1 = r6.getChildCount()
            r3 = r2
        L_0x0029:
            if (r3 >= r1) goto L_0x003c
            android.view.View r4 = r6.getChildAt(r3)
            boolean r5 = isToolbar(r4)
            if (r5 == 0) goto L_0x0039
            r0 = r4
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x003c
        L_0x0039:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x003c:
            r6.toolbar = r0
        L_0x003e:
            r6.updateDummyView()
            r6.refreshToolbar = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.ensureToolbar():void");
    }

    @NonNull
    private View findDirectChild(@NonNull View view) {
        ViewParent parent = view.getParent();
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view = (View) parent;
            }
            parent = parent.getParent();
        }
        return view;
    }

    @ColorInt
    private int getDefaultContentScrimColorForTitleCollapseFadeMode() {
        ColorStateList colorStateListOrNull = MaterialColors.getColorStateListOrNull(getContext(), R.attr.colorSurfaceContainer);
        if (colorStateListOrNull != null) {
            return colorStateListOrNull.getDefaultColor();
        }
        return this.elevationOverlayProvider.compositeOverlayWithThemeSurfaceColorIfNeeded(getResources().getDimension(R.dimen.design_appbar_elevation));
    }

    private static int getHeightWithMargins(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    @Nullable
    private static CharSequence getToolbarSubtitle(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getSubtitle();
        }
        if (view instanceof android.widget.Toolbar) {
            return ((android.widget.Toolbar) view).getSubtitle();
        }
        return null;
    }

    @Nullable
    private static CharSequence getToolbarTitle(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (view instanceof android.widget.Toolbar) {
            return ((android.widget.Toolbar) view).getTitle();
        }
        return null;
    }

    @NonNull
    static ViewOffsetHelper getViewOffsetHelper(@NonNull View view) {
        int i5 = R.id.view_offset_helper;
        ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper) view.getTag(i5);
        if (viewOffsetHelper != null) {
            return viewOffsetHelper;
        }
        ViewOffsetHelper viewOffsetHelper2 = new ViewOffsetHelper(view);
        view.setTag(i5, viewOffsetHelper2);
        return viewOffsetHelper2;
    }

    private boolean isTitleCollapseFadeMode() {
        if (this.titleCollapseMode == 1) {
            return true;
        }
        return false;
    }

    private static boolean isToolbar(View view) {
        if ((view instanceof Toolbar) || (view instanceof android.widget.Toolbar)) {
            return true;
        }
        return false;
    }

    private boolean isToolbarChild(View view) {
        View view2 = this.toolbarDirectChild;
        if (view2 == null || view2 == this) {
            if (view == this.toolbar) {
                return true;
            }
            return false;
        } else if (view == view2) {
            return true;
        } else {
            return false;
        }
    }

    private void updateCollapsedBounds(boolean z4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        View view = this.toolbarDirectChild;
        if (view == null) {
            view = this.toolbar;
        }
        int maxOffsetForPinChild = getMaxOffsetForPinChild(view);
        DescendantOffsetUtils.getDescendantRect(this, this.dummyView, this.tmpRect);
        ViewGroup viewGroup = this.toolbar;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar2 = (Toolbar) viewGroup;
            i7 = toolbar2.getTitleMarginStart();
            i6 = toolbar2.getTitleMarginEnd();
            i5 = toolbar2.getTitleMarginTop();
            i8 = toolbar2.getTitleMarginBottom();
        } else if (Build.VERSION.SDK_INT < 24 || !(viewGroup instanceof android.widget.Toolbar)) {
            i7 = 0;
            i8 = 0;
            i6 = 0;
            i5 = 0;
        } else {
            android.widget.Toolbar toolbar3 = (android.widget.Toolbar) viewGroup;
            i7 = toolbar3.getTitleMarginStart();
            i6 = toolbar3.getTitleMarginEnd();
            i5 = toolbar3.getTitleMarginTop();
            i8 = toolbar3.getTitleMarginBottom();
        }
        Rect rect = this.tmpRect;
        int i12 = rect.left;
        if (z4) {
            i9 = i6;
        } else {
            i9 = i7;
        }
        int i13 = i12 + i9;
        int i14 = rect.right;
        if (z4) {
            i10 = i7;
        } else {
            i10 = i6;
        }
        int i15 = i14 - i10;
        int i16 = rect.top + maxOffsetForPinChild + i5;
        int i17 = (rect.bottom + maxOffsetForPinChild) - i8;
        int collapsedFullSingleLineHeight = (int) (((float) i17) - this.collapsingSubtitleHelper.getCollapsedFullSingleLineHeight());
        int collapsedFullSingleLineHeight2 = (int) (((float) i16) + this.collapsingTitleHelper.getCollapsedFullSingleLineHeight());
        if (TextUtils.isEmpty(this.collapsingSubtitleHelper.getText())) {
            this.collapsingTitleHelper.setCollapsedBounds(i13, i16, i15, i17);
        } else {
            this.collapsingTitleHelper.setCollapsedBounds(i13, i16, i15, collapsedFullSingleLineHeight);
            this.collapsingSubtitleHelper.setCollapsedBounds(i13, collapsedFullSingleLineHeight2, i15, i17);
        }
        if (this.collapsedTitleGravityMode == 0) {
            DescendantOffsetUtils.getDescendantRect(this, this, this.tmpRect);
            Rect rect2 = this.tmpRect;
            int i18 = rect2.left;
            if (z4) {
                i11 = i6;
            } else {
                i11 = i7;
            }
            int i19 = i18 + i11;
            int i20 = rect2.right;
            if (!z4) {
                i7 = i6;
            }
            int i21 = i20 - i7;
            if (TextUtils.isEmpty(this.collapsingSubtitleHelper.getText())) {
                this.collapsingTitleHelper.setCollapsedBoundsForOffsets(i19, i16, i21, i17);
                return;
            }
            this.collapsingTitleHelper.setCollapsedBoundsForOffsets(i19, i16, i21, collapsedFullSingleLineHeight);
            this.collapsingSubtitleHelper.setCollapsedBoundsForOffsets(i19, collapsedFullSingleLineHeight2, i21, i17);
        }
    }

    private void updateContentDescriptionFromTitle() {
        setContentDescription(getTitle());
    }

    private void updateContentScrimBounds(@NonNull Drawable drawable, int i5, int i6) {
        updateContentScrimBounds(drawable, this.toolbar, i5, i6);
    }

    private void updateDummyView() {
        View view;
        if (!this.collapsingTitleEnabled && (view = this.dummyView) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.dummyView);
            }
        }
        if (this.collapsingTitleEnabled && this.toolbar != null) {
            if (this.dummyView == null) {
                this.dummyView = new View(getContext());
            }
            if (this.dummyView.getParent() == null) {
                this.toolbar.addView(this.dummyView, -1, -1);
            }
        }
    }

    private void updateTextBounds(int i5, int i6, int i7, int i8, boolean z4) {
        View view;
        boolean z5;
        int i9;
        int i10;
        if (this.collapsingTitleEnabled && (view = this.dummyView) != null) {
            boolean z6 = false;
            if (!view.isAttachedToWindow() || this.dummyView.getVisibility() != 0) {
                z5 = false;
            } else {
                z5 = true;
            }
            this.drawCollapsingTitle = z5;
            if (z5 || z4) {
                if (getLayoutDirection() == 1) {
                    z6 = true;
                }
                updateCollapsedBounds(z6);
                if (z6) {
                    i9 = this.expandedMarginEnd;
                } else {
                    i9 = this.expandedMarginStart;
                }
                int i11 = i9;
                int i12 = this.tmpRect.top + this.expandedMarginTop;
                int i13 = i7 - i5;
                if (z6) {
                    i10 = this.expandedMarginStart;
                } else {
                    i10 = this.expandedMarginEnd;
                }
                int i14 = i13 - i10;
                int i15 = (i8 - i6) - this.expandedMarginBottom;
                if (TextUtils.isEmpty(this.collapsingSubtitleHelper.getText())) {
                    this.collapsingTitleHelper.setExpandedBounds(i11, i12, i14, i15);
                    this.collapsingTitleHelper.recalculate(z4);
                    return;
                }
                this.collapsingTitleHelper.setExpandedBounds(i11, i12, i14, (int) ((((float) i15) - (this.collapsingSubtitleHelper.getExpandedTextFullSingleLineHeight() + ((float) this.extraMultilineSubtitleHeight))) - ((float) this.expandedTitleSpacing)), false);
                this.collapsingSubtitleHelper.setExpandedBounds(i11, (int) (((float) i12) + this.collapsingTitleHelper.getExpandedTextFullSingleLineHeight() + ((float) this.extraMultilineTitleHeight) + ((float) this.expandedTitleSpacing)), i14, i15, false);
                this.collapsingTitleHelper.recalculate(z4);
                this.collapsingSubtitleHelper.recalculate(z4);
            }
        }
    }

    private void updateTitleFromToolbarIfNeeded() {
        ViewGroup viewGroup = this.toolbar;
        if (viewGroup != null && this.collapsingTitleEnabled) {
            CharSequence toolbarTitle = getToolbarTitle(viewGroup);
            if (TextUtils.isEmpty(this.collapsingTitleHelper.getText()) && !TextUtils.isEmpty(toolbarTitle)) {
                setTitle(toolbarTitle);
            }
            CharSequence toolbarSubtitle = getToolbarSubtitle(this.toolbar);
            if (TextUtils.isEmpty(this.collapsingSubtitleHelper.getText()) && !TextUtils.isEmpty(toolbarSubtitle)) {
                setSubtitle(toolbarSubtitle);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void draw(@NonNull Canvas canvas) {
        int i5;
        Drawable drawable;
        super.draw(canvas);
        ensureToolbar();
        if (this.toolbar == null && (drawable = this.contentScrim) != null && this.scrimAlpha > 0) {
            drawable.mutate().setAlpha(this.scrimAlpha);
            this.contentScrim.draw(canvas);
        }
        if (this.collapsingTitleEnabled && this.drawCollapsingTitle) {
            if (this.toolbar == null || this.contentScrim == null || this.scrimAlpha <= 0 || !isTitleCollapseFadeMode() || this.collapsingTitleHelper.getExpansionFraction() >= this.collapsingTitleHelper.getFadeModeThresholdFraction()) {
                this.collapsingTitleHelper.draw(canvas);
                this.collapsingSubtitleHelper.draw(canvas);
            } else {
                int save = canvas.save();
                canvas.clipRect(this.contentScrim.getBounds(), Region.Op.DIFFERENCE);
                this.collapsingTitleHelper.draw(canvas);
                this.collapsingSubtitleHelper.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        if (this.statusBarScrim != null && this.scrimAlpha > 0) {
            WindowInsetsCompat windowInsetsCompat = this.lastInsets;
            if (windowInsetsCompat != null) {
                i5 = windowInsetsCompat.getSystemWindowInsetTop();
            } else {
                i5 = 0;
            }
            if (i5 > 0) {
                this.statusBarScrim.setBounds(0, -this.currentOffset, getWidth(), i5 - this.currentOffset);
                this.statusBarScrim.mutate().setAlpha(this.scrimAlpha);
                this.statusBarScrim.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j5) {
        boolean z4;
        if (this.contentScrim == null || this.scrimAlpha <= 0 || !isToolbarChild(view)) {
            z4 = false;
        } else {
            updateContentScrimBounds(this.contentScrim, view, getWidth(), getHeight());
            this.contentScrim.mutate().setAlpha(this.scrimAlpha);
            this.contentScrim.draw(canvas);
            z4 = true;
        }
        if (super.drawChild(canvas, view, j5) || z4) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        boolean z4;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.statusBarScrim;
        if (drawable == null || !drawable.isStateful()) {
            z4 = false;
        } else {
            z4 = drawable.setState(drawableState);
        }
        Drawable drawable2 = this.contentScrim;
        if (drawable2 != null && drawable2.isStateful()) {
            z4 |= drawable2.setState(drawableState);
        }
        CollapsingTextHelper collapsingTextHelper = this.collapsingTitleHelper;
        if (collapsingTextHelper != null) {
            z4 |= collapsingTextHelper.setState(drawableState);
        }
        if (z4) {
            invalidate();
        }
    }

    public float getCollapsedSubtitleTextSize() {
        return this.collapsingSubtitleHelper.getCollapsedTextSize();
    }

    @NonNull
    public Typeface getCollapsedSubtitleTypeface() {
        return this.collapsingSubtitleHelper.getCollapsedTypeface();
    }

    public int getCollapsedTitleGravity() {
        return this.collapsingTitleHelper.getCollapsedTextGravity();
    }

    public float getCollapsedTitleTextSize() {
        return this.collapsingTitleHelper.getCollapsedTextSize();
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.collapsingTitleHelper.getCollapsedTypeface();
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.contentScrim;
    }

    public float getExpandedSubtitleTextSize() {
        return this.collapsingSubtitleHelper.getExpandedTextSize();
    }

    @NonNull
    public Typeface getExpandedSubtitleTypeface() {
        return this.collapsingSubtitleHelper.getExpandedTypeface();
    }

    public int getExpandedTitleGravity() {
        return this.collapsingTitleHelper.getExpandedTextGravity();
    }

    public int getExpandedTitleMarginBottom() {
        return this.expandedMarginBottom;
    }

    public int getExpandedTitleMarginEnd() {
        return this.expandedMarginEnd;
    }

    public int getExpandedTitleMarginStart() {
        return this.expandedMarginStart;
    }

    public int getExpandedTitleMarginTop() {
        return this.expandedMarginTop;
    }

    public int getExpandedTitleSpacing() {
        return this.expandedTitleSpacing;
    }

    public float getExpandedTitleTextSize() {
        return this.collapsingTitleHelper.getExpandedTextSize();
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.collapsingTitleHelper.getExpandedTypeface();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getHyphenationFrequency() {
        return this.collapsingTitleHelper.getHyphenationFrequency();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLineCount() {
        return this.collapsingTitleHelper.getLineCount();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingAdd() {
        return this.collapsingTitleHelper.getLineSpacingAdd();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingMultiplier() {
        return this.collapsingTitleHelper.getLineSpacingMultiplier();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        return this.collapsingTitleHelper.getExpandedMaxLines();
    }

    /* access modifiers changed from: package-private */
    public final int getMaxOffsetForPinChild(@NonNull View view) {
        return ((getHeight() - getViewOffsetHelper(view).getLayoutTop()) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    /* access modifiers changed from: package-private */
    public int getScrimAlpha() {
        return this.scrimAlpha;
    }

    public long getScrimAnimationDuration() {
        return this.scrimAnimationDuration;
    }

    public int getScrimVisibleHeightTrigger() {
        int i5;
        int i6 = this.scrimVisibleHeightTrigger;
        if (i6 >= 0) {
            return i6 + this.topInsetApplied + this.extraMultilineTitleHeight + this.extraMultilineSubtitleHeight + this.extraHeightForTitles;
        }
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        if (windowInsetsCompat != null) {
            i5 = windowInsetsCompat.getSystemWindowInsetTop();
        } else {
            i5 = 0;
        }
        int minimumHeight = getMinimumHeight();
        if (minimumHeight > 0) {
            return Math.min((minimumHeight * 2) + i5, getHeight());
        }
        return getHeight() / 3;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.statusBarScrim;
    }

    @Nullable
    public CharSequence getSubtitle() {
        if (this.collapsingTitleEnabled) {
            return this.collapsingSubtitleHelper.getText();
        }
        return null;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.collapsingTitleEnabled) {
            return this.collapsingTitleHelper.getText();
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.titleCollapseMode;
    }

    @Nullable
    public TimeInterpolator getTitlePositionInterpolator() {
        return this.collapsingTitleHelper.getPositionInterpolator();
    }

    @NonNull
    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.collapsingTitleHelper.getTitleTextEllipsize();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isExtraMultilineHeightEnabled() {
        return this.extraMultilineHeightEnabled;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isForceApplySystemWindowInsetTop() {
        return this.forceApplySystemWindowInsetTop;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.collapsingTitleHelper.isRtlTextDirectionHeuristicsEnabled();
    }

    public boolean isTitleEnabled() {
        return this.collapsingTitleEnabled;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            disableLiftOnScrollIfNeeded(appBarLayout);
            setFitsSystemWindows(appBarLayout.getFitsSystemWindows());
            if (this.onOffsetChangedListener == null) {
                this.onOffsetChangedListener = new OffsetUpdateListener();
            }
            appBarLayout.addOnOffsetChangedListener(this.onOffsetChangedListener);
            requestApplyInsets();
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.collapsingTitleHelper.maybeUpdateFontWeightAdjustment(configuration);
        if (this.screenOrientation != configuration.orientation && this.extraMultilineHeightEnabled && this.collapsingTitleHelper.getExpansionFraction() == 1.0f) {
            ViewParent parent = getParent();
            if (parent instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) parent;
                if (appBarLayout.getPendingAction() == 0) {
                    appBarLayout.setPendingAction(2);
                }
            }
        }
        this.screenOrientation = configuration.orientation;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener2 = this.onOffsetChangedListener;
        if (onOffsetChangedListener2 != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(onOffsetChangedListener2);
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        if (windowInsetsCompat != null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                if (!childAt.getFitsSystemWindows() && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i10 = 0; i10 < childCount2; i10++) {
            getViewOffsetHelper(getChildAt(i10)).onViewLayout();
        }
        updateTextBounds(i5, i6, i7, i8, false);
        updateTitleFromToolbarIfNeeded();
        updateScrimVisibility();
        int childCount3 = getChildCount();
        for (int i11 = 0; i11 < childCount3; i11++) {
            getViewOffsetHelper(getChildAt(i11)).applyOffsets();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int i7;
        CollapsingToolbarLayout collapsingToolbarLayout;
        float f5;
        ensureToolbar();
        super.onMeasure(i5, i6);
        int mode = View.MeasureSpec.getMode(i6);
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        if (windowInsetsCompat != null) {
            i7 = windowInsetsCompat.getSystemWindowInsetTop();
        } else {
            i7 = 0;
        }
        if ((mode == 0 || this.forceApplySystemWindowInsetTop) && i7 > 0) {
            this.topInsetApplied = i7;
            super.onMeasure(i5, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + i7, 1073741824));
        }
        updateTitleFromToolbarIfNeeded();
        if (!this.collapsingTitleEnabled || TextUtils.isEmpty(this.collapsingTitleHelper.getText())) {
            collapsingToolbarLayout = this;
        } else {
            int measuredHeight = getMeasuredHeight();
            collapsingToolbarLayout = this;
            collapsingToolbarLayout.updateTextBounds(0, 0, getMeasuredWidth(), measuredHeight, true);
            float expandedTextFullSingleLineHeight = ((float) (collapsingToolbarLayout.topInsetApplied + collapsingToolbarLayout.expandedMarginTop)) + collapsingToolbarLayout.collapsingTitleHelper.getExpandedTextFullSingleLineHeight();
            if (TextUtils.isEmpty(collapsingToolbarLayout.collapsingSubtitleHelper.getText())) {
                f5 = 0.0f;
            } else {
                f5 = ((float) collapsingToolbarLayout.expandedTitleSpacing) + collapsingToolbarLayout.collapsingSubtitleHelper.getExpandedTextFullSingleLineHeight();
            }
            int i8 = (int) (expandedTextFullSingleLineHeight + f5 + ((float) collapsingToolbarLayout.expandedMarginBottom));
            if (i8 > measuredHeight) {
                collapsingToolbarLayout.extraHeightForTitles = i8 - measuredHeight;
            } else {
                collapsingToolbarLayout.extraHeightForTitles = 0;
            }
            if (collapsingToolbarLayout.extraMultilineHeightEnabled) {
                if (collapsingToolbarLayout.collapsingTitleHelper.getExpandedMaxLines() > 1) {
                    int expandedLineCount = collapsingToolbarLayout.collapsingTitleHelper.getExpandedLineCount();
                    if (expandedLineCount > 1) {
                        collapsingToolbarLayout.extraMultilineTitleHeight = Math.round(collapsingToolbarLayout.collapsingTitleHelper.getExpandedTextFullSingleLineHeight()) * (expandedLineCount - 1);
                    } else {
                        collapsingToolbarLayout.extraMultilineTitleHeight = 0;
                    }
                }
                if (collapsingToolbarLayout.collapsingSubtitleHelper.getExpandedMaxLines() > 1) {
                    int expandedLineCount2 = collapsingToolbarLayout.collapsingSubtitleHelper.getExpandedLineCount();
                    if (expandedLineCount2 > 1) {
                        collapsingToolbarLayout.extraMultilineSubtitleHeight = Math.round(collapsingToolbarLayout.collapsingSubtitleHelper.getExpandedTextFullSingleLineHeight()) * (expandedLineCount2 - 1);
                    } else {
                        collapsingToolbarLayout.extraMultilineSubtitleHeight = 0;
                    }
                }
            }
            int i9 = collapsingToolbarLayout.extraHeightForTitles;
            int i10 = collapsingToolbarLayout.extraMultilineTitleHeight;
            int i11 = collapsingToolbarLayout.extraMultilineSubtitleHeight;
            if (i9 + i10 + i11 > 0) {
                super.onMeasure(i5, View.MeasureSpec.makeMeasureSpec(measuredHeight + i9 + i10 + i11, 1073741824));
            }
        }
        ViewGroup viewGroup = collapsingToolbarLayout.toolbar;
        if (viewGroup != null) {
            View view = collapsingToolbarLayout.toolbarDirectChild;
            if (view == null || view == collapsingToolbarLayout) {
                setMinimumHeight(getHeightWithMargins(viewGroup));
            } else {
                setMinimumHeight(getHeightWithMargins(view));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        Drawable drawable = this.contentScrim;
        if (drawable != null) {
            updateContentScrimBounds(drawable, i5, i6);
        }
    }

    /* access modifiers changed from: package-private */
    public WindowInsetsCompat onWindowInsetChanged(@NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2;
        if (getFitsSystemWindows()) {
            windowInsetsCompat2 = windowInsetsCompat;
        } else {
            windowInsetsCompat2 = null;
        }
        if (!ObjectsCompat.equals(this.lastInsets, windowInsetsCompat2)) {
            this.lastInsets = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    public void setCollapsedSubtitleTextAppearance(@StyleRes int i5) {
        this.collapsingSubtitleHelper.setCollapsedTextAppearance(i5);
    }

    public void setCollapsedSubtitleTextColor(@ColorInt int i5) {
        setCollapsedSubtitleTextColor(ColorStateList.valueOf(i5));
    }

    public void setCollapsedSubtitleTextSize(float f5) {
        this.collapsingSubtitleHelper.setCollapsedTextSize(f5);
    }

    public void setCollapsedSubtitleTypeface(@Nullable Typeface typeface) {
        this.collapsingSubtitleHelper.setCollapsedTypeface(typeface);
    }

    public void setCollapsedTitleGravity(int i5) {
        this.collapsingTitleHelper.setCollapsedTextGravity(i5);
        this.collapsingSubtitleHelper.setCollapsedTextGravity(i5);
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i5) {
        this.collapsingTitleHelper.setCollapsedTextAppearance(i5);
    }

    public void setCollapsedTitleTextColor(@ColorInt int i5) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i5));
    }

    public void setCollapsedTitleTextSize(float f5) {
        this.collapsingTitleHelper.setCollapsedTextSize(f5);
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        this.collapsingTitleHelper.setCollapsedTypeface(typeface);
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.contentScrim;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.contentScrim = drawable3;
            if (drawable3 != null) {
                updateContentScrimBounds(drawable3, getWidth(), getHeight());
                this.contentScrim.setCallback(this);
                this.contentScrim.setAlpha(this.scrimAlpha);
            }
            postInvalidateOnAnimation();
        }
    }

    public void setContentScrimColor(@ColorInt int i5) {
        setContentScrim(new ColorDrawable(i5));
    }

    public void setContentScrimResource(@DrawableRes int i5) {
        setContentScrim(getContext().getDrawable(i5));
    }

    public void setExpandedSubtitleColor(@ColorInt int i5) {
        setExpandedSubtitleTextColor(ColorStateList.valueOf(i5));
    }

    public void setExpandedSubtitleTextAppearance(@StyleRes int i5) {
        this.collapsingSubtitleHelper.setExpandedTextAppearance(i5);
    }

    public void setExpandedSubtitleTextColor(@NonNull ColorStateList colorStateList) {
        this.collapsingSubtitleHelper.setExpandedTextColor(colorStateList);
    }

    public void setExpandedSubtitleTextSize(float f5) {
        this.collapsingSubtitleHelper.setExpandedTextSize(f5);
    }

    public void setExpandedSubtitleTypeface(@Nullable Typeface typeface) {
        this.collapsingSubtitleHelper.setExpandedTypeface(typeface);
    }

    public void setExpandedTitleColor(@ColorInt int i5) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i5));
    }

    public void setExpandedTitleGravity(int i5) {
        this.collapsingTitleHelper.setExpandedTextGravity(i5);
        this.collapsingSubtitleHelper.setExpandedTextGravity(i5);
    }

    public void setExpandedTitleMargin(int i5, int i6, int i7, int i8) {
        this.expandedMarginStart = i5;
        this.expandedMarginTop = i6;
        this.expandedMarginEnd = i7;
        this.expandedMarginBottom = i8;
        requestLayout();
    }

    public void setExpandedTitleMarginBottom(int i5) {
        this.expandedMarginBottom = i5;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i5) {
        this.expandedMarginEnd = i5;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i5) {
        this.expandedMarginStart = i5;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i5) {
        this.expandedMarginTop = i5;
        requestLayout();
    }

    public void setExpandedTitleSpacing(int i5) {
        this.expandedTitleSpacing = i5;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i5) {
        this.collapsingTitleHelper.setExpandedTextAppearance(i5);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.collapsingTitleHelper.setExpandedTextColor(colorStateList);
    }

    public void setExpandedTitleTextSize(float f5) {
        this.collapsingTitleHelper.setExpandedTextSize(f5);
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        this.collapsingTitleHelper.setExpandedTypeface(typeface);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setExtraMultilineHeightEnabled(boolean z4) {
        this.extraMultilineHeightEnabled = z4;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setForceApplySystemWindowInsetTop(boolean z4) {
        this.forceApplySystemWindowInsetTop = z4;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHyphenationFrequency(int i5) {
        this.collapsingTitleHelper.setHyphenationFrequency(i5);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingAdd(float f5) {
        this.collapsingTitleHelper.setLineSpacingAdd(f5);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float f5) {
        this.collapsingTitleHelper.setLineSpacingMultiplier(f5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int i5) {
        this.collapsingTitleHelper.setExpandedMaxLines(i5);
        this.collapsingSubtitleHelper.setExpandedMaxLines(i5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRtlTextDirectionHeuristicsEnabled(boolean z4) {
        this.collapsingTitleHelper.setRtlTextDirectionHeuristicsEnabled(z4);
    }

    /* access modifiers changed from: package-private */
    public void setScrimAlpha(int i5) {
        ViewGroup viewGroup;
        if (i5 != this.scrimAlpha) {
            if (!(this.contentScrim == null || (viewGroup = this.toolbar) == null)) {
                viewGroup.postInvalidateOnAnimation();
            }
            this.scrimAlpha = i5;
            postInvalidateOnAnimation();
        }
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j5) {
        this.scrimAnimationDuration = j5;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i5) {
        if (this.scrimVisibleHeightTrigger != i5) {
            this.scrimVisibleHeightTrigger = i5;
            updateScrimVisibility();
        }
    }

    public void setScrimsShown(boolean z4) {
        setScrimsShown(z4, isLaidOut() && !isInEditMode());
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStaticLayoutBuilderConfigurer(@Nullable StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer) {
        this.collapsingTitleHelper.setStaticLayoutBuilderConfigurer(staticLayoutBuilderConfigurer);
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        boolean z4;
        Drawable drawable2 = this.statusBarScrim;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.statusBarScrim = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.statusBarScrim.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.statusBarScrim, getLayoutDirection());
                Drawable drawable4 = this.statusBarScrim;
                if (getVisibility() == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                drawable4.setVisible(z4, false);
                this.statusBarScrim.setCallback(this);
                this.statusBarScrim.setAlpha(this.scrimAlpha);
            }
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarScrimColor(@ColorInt int i5) {
        setStatusBarScrim(new ColorDrawable(i5));
    }

    public void setStatusBarScrimResource(@DrawableRes int i5) {
        setStatusBarScrim(getContext().getDrawable(i5));
    }

    public void setSubtitle(@Nullable CharSequence charSequence) {
        this.collapsingSubtitleHelper.setText(charSequence);
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.collapsingTitleHelper.setText(charSequence);
        updateContentDescriptionFromTitle();
    }

    public void setTitleCollapseMode(int i5) {
        this.titleCollapseMode = i5;
        boolean isTitleCollapseFadeMode = isTitleCollapseFadeMode();
        this.collapsingTitleHelper.setFadeModeEnabled(isTitleCollapseFadeMode);
        this.collapsingSubtitleHelper.setFadeModeEnabled(isTitleCollapseFadeMode);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            disableLiftOnScrollIfNeeded((AppBarLayout) parent);
        }
        if (isTitleCollapseFadeMode && this.contentScrim == null) {
            setContentScrimColor(getDefaultContentScrimColorForTitleCollapseFadeMode());
        }
    }

    public void setTitleEllipsize(@NonNull TextUtils.TruncateAt truncateAt) {
        this.collapsingTitleHelper.setTitleTextEllipsize(truncateAt);
    }

    public void setTitleEnabled(boolean z4) {
        if (z4 != this.collapsingTitleEnabled) {
            this.collapsingTitleEnabled = z4;
            updateContentDescriptionFromTitle();
            updateDummyView();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.collapsingTitleHelper.setPositionInterpolator(timeInterpolator);
    }

    public void setVisibility(int i5) {
        boolean z4;
        super.setVisibility(i5);
        if (i5 == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Drawable drawable = this.statusBarScrim;
        if (!(drawable == null || drawable.isVisible() == z4)) {
            this.statusBarScrim.setVisible(z4, false);
        }
        Drawable drawable2 = this.contentScrim;
        if (drawable2 != null && drawable2.isVisible() != z4) {
            this.contentScrim.setVisible(z4, false);
        }
    }

    /* access modifiers changed from: package-private */
    public final void updateScrimVisibility() {
        boolean z4;
        if (this.contentScrim != null || this.statusBarScrim != null) {
            if (getHeight() + this.currentOffset < getScrimVisibleHeightTrigger()) {
                z4 = true;
            } else {
                z4 = false;
            }
            setScrimsShown(z4);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        if (super.verifyDrawable(drawable) || drawable == this.contentScrim || drawable == this.statusBarScrim) {
            return true;
        }
        return false;
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.collapsingToolbarLayoutStyle);
    }

    private void updateContentScrimBounds(@NonNull Drawable drawable, @Nullable View view, int i5, int i6) {
        if (isTitleCollapseFadeMode() && view != null && this.collapsingTitleEnabled) {
            i6 = view.getBottom();
        }
        drawable.setBounds(0, 0, i5, i6);
    }

    public void setCollapsedSubtitleTextColor(@NonNull ColorStateList colorStateList) {
        this.collapsingSubtitleHelper.setCollapsedTextColor(colorStateList);
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.collapsingTitleHelper.setCollapsedTextColor(colorStateList);
    }

    public void setScrimsShown(boolean z4, boolean z5) {
        if (this.scrimsAreShown != z4) {
            int i5 = 0;
            if (z5) {
                if (z4) {
                    i5 = 255;
                }
                animateScrim(i5);
            } else {
                if (z4) {
                    i5 = 255;
                }
                setScrimAlpha(i5);
            }
            this.scrimsAreShown = z4;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CollapsingToolbarLayout(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r4 = DEF_STYLE_RES
            android.content.Context r11 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r11, r12, r13, r4)
            r10.<init>(r11, r12, r13)
            r11 = 1
            r10.refreshToolbar = r11
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r10.tmpRect = r0
            r6 = -1
            r10.scrimVisibleHeightTrigger = r6
            r7 = 0
            r10.topInsetApplied = r7
            r10.extraMultilineTitleHeight = r7
            r10.extraMultilineSubtitleHeight = r7
            r10.extraHeightForTitles = r7
            android.content.Context r0 = r10.getContext()
            android.content.res.Resources r1 = r10.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            int r1 = r1.orientation
            r10.screenOrientation = r1
            com.google.android.material.internal.CollapsingTextHelper r8 = new com.google.android.material.internal.CollapsingTextHelper
            r8.<init>(r10)
            r10.collapsingTitleHelper = r8
            android.animation.TimeInterpolator r9 = com.google.android.material.animation.AnimationUtils.DECELERATE_INTERPOLATOR
            r8.setTextSizeInterpolator(r9)
            r8.setRtlTextDirectionHeuristicsEnabled(r7)
            com.google.android.material.elevation.ElevationOverlayProvider r1 = new com.google.android.material.elevation.ElevationOverlayProvider
            r1.<init>(r0)
            r10.elevationOverlayProvider = r1
            int[] r2 = com.google.android.material.R.styleable.CollapsingToolbarLayout
            int[] r5 = new int[r7]
            r1 = r12
            r3 = r13
            android.content.res.TypedArray r12 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r13 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleGravity
            r1 = 8388691(0x800053, float:1.175506E-38)
            int r13 = r12.getInt(r13, r1)
            int r1 = com.google.android.material.R.styleable.CollapsingToolbarLayout_collapsedTitleGravity
            r2 = 8388627(0x800013, float:1.175497E-38)
            int r1 = r12.getInt(r1, r2)
            int r2 = com.google.android.material.R.styleable.CollapsingToolbarLayout_collapsedTitleGravityMode
            int r2 = r12.getInt(r2, r11)
            r10.collapsedTitleGravityMode = r2
            r8.setExpandedTextGravity(r13)
            r8.setCollapsedTextGravity(r1)
            int r2 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleMargin
            int r2 = r12.getDimensionPixelSize(r2, r7)
            r10.expandedMarginBottom = r2
            r10.expandedMarginEnd = r2
            r10.expandedMarginTop = r2
            r10.expandedMarginStart = r2
            int r2 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart
            boolean r3 = r12.hasValue(r2)
            if (r3 == 0) goto L_0x008b
            int r2 = r12.getDimensionPixelSize(r2, r7)
            r10.expandedMarginStart = r2
        L_0x008b:
            int r2 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd
            boolean r3 = r12.hasValue(r2)
            if (r3 == 0) goto L_0x0099
            int r2 = r12.getDimensionPixelSize(r2, r7)
            r10.expandedMarginEnd = r2
        L_0x0099:
            int r2 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop
            boolean r3 = r12.hasValue(r2)
            if (r3 == 0) goto L_0x00a7
            int r2 = r12.getDimensionPixelSize(r2, r7)
            r10.expandedMarginTop = r2
        L_0x00a7:
            int r2 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom
            boolean r3 = r12.hasValue(r2)
            if (r3 == 0) goto L_0x00b5
            int r2 = r12.getDimensionPixelSize(r2, r7)
            r10.expandedMarginBottom = r2
        L_0x00b5:
            int r2 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleSpacing
            boolean r3 = r12.hasValue(r2)
            if (r3 == 0) goto L_0x00c3
            int r2 = r12.getDimensionPixelSize(r2, r7)
            r10.expandedTitleSpacing = r2
        L_0x00c3:
            int r2 = com.google.android.material.R.styleable.CollapsingToolbarLayout_titleEnabled
            boolean r2 = r12.getBoolean(r2, r11)
            r10.collapsingTitleEnabled = r2
            int r2 = com.google.android.material.R.styleable.CollapsingToolbarLayout_title
            java.lang.CharSequence r2 = r12.getText(r2)
            r10.setTitle(r2)
            int r2 = com.google.android.material.R.style.TextAppearance_Design_CollapsingToolbar_Expanded
            r8.setExpandedTextAppearance(r2)
            int r2 = androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title
            r8.setCollapsedTextAppearance(r2)
            int r2 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance
            boolean r3 = r12.hasValue(r2)
            if (r3 == 0) goto L_0x00ed
            int r2 = r12.getResourceId(r2, r7)
            r8.setExpandedTextAppearance(r2)
        L_0x00ed:
            int r2 = com.google.android.material.R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance
            boolean r3 = r12.hasValue(r2)
            if (r3 == 0) goto L_0x00fc
            int r2 = r12.getResourceId(r2, r7)
            r8.setCollapsedTextAppearance(r2)
        L_0x00fc:
            int r2 = com.google.android.material.R.styleable.CollapsingToolbarLayout_titleTextEllipsize
            boolean r3 = r12.hasValue(r2)
            if (r3 == 0) goto L_0x010f
            int r2 = r12.getInt(r2, r6)
            android.text.TextUtils$TruncateAt r2 = r10.convertEllipsizeToTruncateAt(r2)
            r10.setTitleEllipsize(r2)
        L_0x010f:
            int r2 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleTextColor
            boolean r3 = r12.hasValue(r2)
            if (r3 == 0) goto L_0x011e
            android.content.res.ColorStateList r2 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r0, (android.content.res.TypedArray) r12, (int) r2)
            r8.setExpandedTextColor(r2)
        L_0x011e:
            int r2 = com.google.android.material.R.styleable.CollapsingToolbarLayout_collapsedTitleTextColor
            boolean r3 = r12.hasValue(r2)
            if (r3 == 0) goto L_0x012d
            android.content.res.ColorStateList r2 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r0, (android.content.res.TypedArray) r12, (int) r2)
            r8.setCollapsedTextColor(r2)
        L_0x012d:
            int r2 = com.google.android.material.R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger
            int r2 = r12.getDimensionPixelSize(r2, r6)
            r10.scrimVisibleHeightTrigger = r2
            int r2 = com.google.android.material.R.styleable.CollapsingToolbarLayout_titleMaxLines
            boolean r3 = r12.hasValue(r2)
            if (r3 == 0) goto L_0x0145
            int r2 = r12.getInt(r2, r11)
            r8.setExpandedMaxLines(r2)
            goto L_0x0154
        L_0x0145:
            int r2 = com.google.android.material.R.styleable.CollapsingToolbarLayout_maxLines
            boolean r3 = r12.hasValue(r2)
            if (r3 == 0) goto L_0x0154
            int r2 = r12.getInt(r2, r11)
            r8.setExpandedMaxLines(r2)
        L_0x0154:
            int r2 = com.google.android.material.R.styleable.CollapsingToolbarLayout_titlePositionInterpolator
            boolean r3 = r12.hasValue(r2)
            if (r3 == 0) goto L_0x0167
            int r3 = r12.getResourceId(r2, r7)
            android.view.animation.Interpolator r3 = android.view.animation.AnimationUtils.loadInterpolator(r0, r3)
            r8.setPositionInterpolator(r3)
        L_0x0167:
            com.google.android.material.internal.CollapsingTextHelper r3 = new com.google.android.material.internal.CollapsingTextHelper
            r3.<init>(r10)
            r10.collapsingSubtitleHelper = r3
            r3.setTextSizeInterpolator(r9)
            r3.setRtlTextDirectionHeuristicsEnabled(r7)
            int r4 = com.google.android.material.R.styleable.CollapsingToolbarLayout_subtitle
            boolean r5 = r12.hasValue(r4)
            if (r5 == 0) goto L_0x0183
            java.lang.CharSequence r4 = r12.getText(r4)
            r10.setSubtitle(r4)
        L_0x0183:
            r3.setExpandedTextGravity(r13)
            r3.setCollapsedTextGravity(r1)
            int r13 = androidx.appcompat.R.style.TextAppearance_AppCompat_Headline
            r3.setExpandedTextAppearance(r13)
            int r13 = androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Subtitle
            r3.setCollapsedTextAppearance(r13)
            int r13 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedSubtitleTextAppearance
            boolean r1 = r12.hasValue(r13)
            if (r1 == 0) goto L_0x01a2
            int r13 = r12.getResourceId(r13, r7)
            r3.setExpandedTextAppearance(r13)
        L_0x01a2:
            int r13 = com.google.android.material.R.styleable.CollapsingToolbarLayout_collapsedSubtitleTextAppearance
            boolean r1 = r12.hasValue(r13)
            if (r1 == 0) goto L_0x01b1
            int r13 = r12.getResourceId(r13, r7)
            r3.setCollapsedTextAppearance(r13)
        L_0x01b1:
            int r13 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedSubtitleTextColor
            boolean r1 = r12.hasValue(r13)
            if (r1 == 0) goto L_0x01c0
            android.content.res.ColorStateList r13 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r0, (android.content.res.TypedArray) r12, (int) r13)
            r3.setExpandedTextColor(r13)
        L_0x01c0:
            int r13 = com.google.android.material.R.styleable.CollapsingToolbarLayout_collapsedSubtitleTextColor
            boolean r1 = r12.hasValue(r13)
            if (r1 == 0) goto L_0x01cf
            android.content.res.ColorStateList r13 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r0, (android.content.res.TypedArray) r12, (int) r13)
            r3.setCollapsedTextColor(r13)
        L_0x01cf:
            int r13 = com.google.android.material.R.styleable.CollapsingToolbarLayout_subtitleMaxLines
            boolean r1 = r12.hasValue(r13)
            if (r1 == 0) goto L_0x01de
            int r11 = r12.getInt(r13, r11)
            r3.setExpandedMaxLines(r11)
        L_0x01de:
            boolean r11 = r12.hasValue(r2)
            if (r11 == 0) goto L_0x01ef
            int r11 = r12.getResourceId(r2, r7)
            android.view.animation.Interpolator r11 = android.view.animation.AnimationUtils.loadInterpolator(r0, r11)
            r3.setPositionInterpolator(r11)
        L_0x01ef:
            int r11 = com.google.android.material.R.styleable.CollapsingToolbarLayout_scrimAnimationDuration
            r13 = 600(0x258, float:8.41E-43)
            int r11 = r12.getInt(r11, r13)
            long r1 = (long) r11
            r10.scrimAnimationDuration = r1
            int r11 = com.google.android.material.R.attr.motionEasingStandardInterpolator
            android.animation.TimeInterpolator r13 = com.google.android.material.animation.AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR
            android.animation.TimeInterpolator r13 = com.google.android.material.motion.MotionUtils.resolveThemeInterpolator(r0, r11, r13)
            r10.scrimAnimationFadeInInterpolator = r13
            android.animation.TimeInterpolator r13 = com.google.android.material.animation.AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR
            android.animation.TimeInterpolator r11 = com.google.android.material.motion.MotionUtils.resolveThemeInterpolator(r0, r11, r13)
            r10.scrimAnimationFadeOutInterpolator = r11
            int r11 = com.google.android.material.R.styleable.CollapsingToolbarLayout_contentScrim
            android.graphics.drawable.Drawable r11 = r12.getDrawable(r11)
            r10.setContentScrim(r11)
            int r11 = com.google.android.material.R.styleable.CollapsingToolbarLayout_statusBarScrim
            android.graphics.drawable.Drawable r11 = r12.getDrawable(r11)
            r10.setStatusBarScrim(r11)
            int r11 = com.google.android.material.R.styleable.CollapsingToolbarLayout_titleCollapseMode
            int r11 = r12.getInt(r11, r7)
            r10.setTitleCollapseMode(r11)
            int r11 = com.google.android.material.R.styleable.CollapsingToolbarLayout_toolbarId
            int r11 = r12.getResourceId(r11, r6)
            r10.toolbarId = r11
            int r11 = com.google.android.material.R.styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop
            boolean r11 = r12.getBoolean(r11, r7)
            r10.forceApplySystemWindowInsetTop = r11
            int r11 = com.google.android.material.R.styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled
            boolean r11 = r12.getBoolean(r11, r7)
            r10.extraMultilineHeightEnabled = r11
            r12.recycle()
            r10.setWillNotDraw(r7)
            com.google.android.material.appbar.CollapsingToolbarLayout$1 r11 = new com.google.android.material.appbar.CollapsingToolbarLayout$1
            r11.<init>()
            androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;
        private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
        int collapseMode = 0;
        float parallaxMult = 0.5f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.collapseMode = obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            setParallaxMultiplier(obtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public int getCollapseMode() {
            return this.collapseMode;
        }

        public float getParallaxMultiplier() {
            return this.parallaxMult;
        }

        public void setCollapseMode(int i5) {
            this.collapseMode = i5;
        }

        public void setParallaxMultiplier(float f5) {
            this.parallaxMult = f5;
        }

        public LayoutParams(int i5, int i6) {
            super(i5, i6);
        }

        public LayoutParams(int i5, int i6, int i7) {
            super(i5, i6, i7);
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(@NonNull FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super(layoutParams);
            this.collapseMode = layoutParams.collapseMode;
            this.parallaxMult = layoutParams.parallaxMult;
        }
    }
}
