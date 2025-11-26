package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.PluralsRes;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.XmlRes;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.Locale;

@OptIn(markerClass = {ExperimentalBadgeUtils.class})
public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    public static final int BADGE_CONTENT_NOT_TRUNCATED = -2;
    public static final int BADGE_FIXED_EDGE_END = 1;
    public static final int BADGE_FIXED_EDGE_START = 0;
    static final int BADGE_RADIUS_NOT_SPECIFIED = -1;
    @Deprecated
    public static final int BOTTOM_END = 8388693;
    @Deprecated
    public static final int BOTTOM_START = 8388691;
    static final String DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX = "+";
    static final String DEFAULT_EXCEED_MAX_BADGE_TEXT_SUFFIX = "…";
    @StyleRes
    private static final int DEFAULT_STYLE = R.style.Widget_MaterialComponents_Badge;
    @AttrRes
    private static final int DEFAULT_THEME_ATTR = R.attr.badgeStyle;
    private static final float FONT_SCALE_THRESHOLD = 0.3f;
    static final int OFFSET_ALIGNMENT_MODE_EDGE = 0;
    static final int OFFSET_ALIGNMENT_MODE_LEGACY = 1;
    private static final String TAG = "Badge";
    public static final int TOP_END = 8388661;
    public static final int TOP_START = 8388659;
    @Nullable
    private WeakReference<View> anchorViewRef;
    @NonNull
    private final Rect badgeBounds = new Rect();
    private float badgeCenterX;
    private float badgeCenterY;
    @NonNull
    private final WeakReference<Context> contextRef;
    private float cornerRadius;
    @Nullable
    private WeakReference<FrameLayout> customBadgeParentRef;
    private float halfBadgeHeight;
    private float halfBadgeWidth;
    private int maxBadgeNumber;
    @NonNull
    private final MaterialShapeDrawable shapeDrawable;
    @NonNull
    private final BadgeState state;
    @NonNull
    private final TextDrawableHelper textDrawableHelper;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeGravity {
    }

    private BadgeDrawable(@NonNull Context context, @XmlRes int i5, @AttrRes int i6, @StyleRes int i7, @Nullable BadgeState.State state2) {
        int i8;
        int i9;
        this.contextRef = new WeakReference<>(context);
        ThemeEnforcement.checkMaterialTheme(context);
        TextDrawableHelper textDrawableHelper2 = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper2;
        textDrawableHelper2.getTextPaint().setTextAlign(Paint.Align.CENTER);
        Context context2 = context;
        BadgeState badgeState = new BadgeState(context2, i5, i6, i7, state2);
        this.state = badgeState;
        if (hasBadgeContent()) {
            i8 = badgeState.getBadgeWithTextShapeAppearanceResId();
        } else {
            i8 = badgeState.getBadgeShapeAppearanceResId();
        }
        if (hasBadgeContent()) {
            i9 = badgeState.getBadgeWithTextShapeAppearanceOverlayResId();
        } else {
            i9 = badgeState.getBadgeShapeAppearanceOverlayResId();
        }
        this.shapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(context2, i8, i9).build());
        restoreState();
    }

    private void autoAdjustWithinGrandparentBounds(@NonNull View view) {
        ViewParent customBadgeParent = getCustomBadgeParent();
        if (customBadgeParent == null) {
            customBadgeParent = view.getParent();
        }
        if ((customBadgeParent instanceof View) && (customBadgeParent.getParent() instanceof View)) {
            autoAdjustWithinViewBounds(view, (View) customBadgeParent.getParent());
        }
    }

    private void autoAdjustWithinViewBounds(@NonNull View view, @Nullable View view2) {
        float f5;
        float f6;
        boolean z4;
        ViewParent customBadgeParent = getCustomBadgeParent();
        if (customBadgeParent == null) {
            float y4 = view.getY();
            f6 = view.getX();
            float f7 = y4;
            customBadgeParent = view.getParent();
            f5 = f7;
        } else {
            f5 = 0.0f;
            f6 = 0.0f;
        }
        while (true) {
            z4 = customBadgeParent instanceof View;
            if (!z4 || customBadgeParent == view2) {
                break;
            }
            ViewParent parent = customBadgeParent.getParent();
            if (!(parent instanceof ViewGroup) || ((ViewGroup) parent).getClipChildren()) {
                break;
            }
            View view3 = (View) customBadgeParent;
            f5 += view3.getY();
            f6 += view3.getX();
            customBadgeParent = customBadgeParent.getParent();
        }
        if (z4) {
            float topCutOff = getTopCutOff(f5);
            float leftCutOff = getLeftCutOff(f6);
            View view4 = (View) customBadgeParent;
            float bottomCutOff = getBottomCutOff((float) view4.getHeight(), f5);
            float rightCutoff = getRightCutoff((float) view4.getWidth(), f6);
            if (topCutOff < 0.0f) {
                this.badgeCenterY += Math.abs(topCutOff);
            }
            if (leftCutOff < 0.0f) {
                this.badgeCenterX += Math.abs(leftCutOff);
            }
            if (bottomCutOff > 0.0f) {
                this.badgeCenterY -= Math.abs(bottomCutOff);
            }
            if (rightCutoff > 0.0f) {
                this.badgeCenterX -= Math.abs(rightCutoff);
            }
        }
    }

    private void calculateCenterAndBounds(@NonNull Rect rect, @NonNull View view) {
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        if (hasBadgeContent()) {
            f5 = this.state.badgeWithTextRadius;
        } else {
            f5 = this.state.badgeRadius;
        }
        this.cornerRadius = f5;
        if (f5 != -1.0f) {
            this.halfBadgeWidth = f5;
            this.halfBadgeHeight = f5;
        } else {
            if (hasBadgeContent()) {
                f8 = this.state.badgeWithTextWidth;
            } else {
                f8 = this.state.badgeWidth;
            }
            this.halfBadgeWidth = (float) Math.round(f8 / 2.0f);
            if (hasBadgeContent()) {
                f9 = this.state.badgeWithTextHeight;
            } else {
                f9 = this.state.badgeHeight;
            }
            this.halfBadgeHeight = (float) Math.round(f9 / 2.0f);
        }
        if (hasBadgeContent()) {
            String badgeContent = getBadgeContent();
            this.halfBadgeWidth = Math.max(this.halfBadgeWidth, (this.textDrawableHelper.getTextWidth(badgeContent) / 2.0f) + ((float) this.state.getBadgeHorizontalPadding()));
            float max = Math.max(this.halfBadgeHeight, (this.textDrawableHelper.getTextHeight(badgeContent) / 2.0f) + ((float) this.state.getBadgeVerticalPadding()));
            this.halfBadgeHeight = max;
            this.halfBadgeWidth = Math.max(this.halfBadgeWidth, max);
        }
        int totalVerticalOffsetForState = getTotalVerticalOffsetForState();
        int badgeGravity = this.state.getBadgeGravity();
        if (badgeGravity == 8388691 || badgeGravity == 8388693) {
            this.badgeCenterY = (float) (rect.bottom - totalVerticalOffsetForState);
        } else {
            this.badgeCenterY = (float) (rect.top + totalVerticalOffsetForState);
        }
        int totalHorizontalOffsetForState = getTotalHorizontalOffsetForState();
        int badgeGravity2 = this.state.getBadgeGravity();
        if (badgeGravity2 == 8388659 || badgeGravity2 == 8388691) {
            if (this.state.badgeFixedEdge == 0) {
                if (view.getLayoutDirection() == 0) {
                    f6 = (((float) rect.left) + this.halfBadgeWidth) - ((this.halfBadgeHeight * 2.0f) - ((float) totalHorizontalOffsetForState));
                } else {
                    f6 = (((float) rect.right) - this.halfBadgeWidth) + ((this.halfBadgeHeight * 2.0f) - ((float) totalHorizontalOffsetForState));
                }
            } else if (view.getLayoutDirection() == 0) {
                f6 = (((float) rect.left) - this.halfBadgeWidth) + ((float) totalHorizontalOffsetForState);
            } else {
                f6 = (((float) rect.right) + this.halfBadgeWidth) - ((float) totalHorizontalOffsetForState);
            }
            this.badgeCenterX = f6;
        } else {
            if (this.state.badgeFixedEdge == 0) {
                if (view.getLayoutDirection() == 0) {
                    f7 = (((float) rect.right) + this.halfBadgeWidth) - ((float) totalHorizontalOffsetForState);
                } else {
                    f7 = (((float) rect.left) - this.halfBadgeWidth) + ((float) totalHorizontalOffsetForState);
                }
            } else if (view.getLayoutDirection() == 0) {
                f7 = (((float) rect.right) - this.halfBadgeWidth) + ((this.halfBadgeHeight * 2.0f) - ((float) totalHorizontalOffsetForState));
            } else {
                f7 = (((float) rect.left) + this.halfBadgeWidth) - ((this.halfBadgeHeight * 2.0f) - ((float) totalHorizontalOffsetForState));
            }
            this.badgeCenterX = f7;
        }
        if (this.state.isAutoAdjustedToGrandparentBounds()) {
            autoAdjustWithinGrandparentBounds(view);
        } else {
            autoAdjustWithinViewBounds(view, (View) null);
        }
    }

    @NonNull
    public static BadgeDrawable create(@NonNull Context context) {
        return new BadgeDrawable(context, 0, DEFAULT_THEME_ATTR, DEFAULT_STYLE, (BadgeState.State) null);
    }

    @NonNull
    public static BadgeDrawable createFromResource(@NonNull Context context, @XmlRes int i5) {
        return new BadgeDrawable(context, i5, DEFAULT_THEME_ATTR, DEFAULT_STYLE, (BadgeState.State) null);
    }

    @NonNull
    static BadgeDrawable createFromSavedState(@NonNull Context context, @NonNull BadgeState.State state2) {
        return new BadgeDrawable(context, 0, DEFAULT_THEME_ATTR, DEFAULT_STYLE, state2);
    }

    private void drawBadgeContent(Canvas canvas) {
        int round;
        String badgeContent = getBadgeContent();
        if (badgeContent != null) {
            Rect rect = new Rect();
            this.textDrawableHelper.getTextPaint().getTextBounds(badgeContent, 0, badgeContent.length(), rect);
            float exactCenterY = this.badgeCenterY - rect.exactCenterY();
            float f5 = this.badgeCenterX;
            if (rect.bottom <= 0) {
                round = (int) exactCenterY;
            } else {
                round = Math.round(exactCenterY);
            }
            canvas.drawText(badgeContent, f5, (float) round, this.textDrawableHelper.getTextPaint());
        }
    }

    @Nullable
    private String getBadgeContent() {
        if (hasText()) {
            return getTextBadgeText();
        }
        if (hasNumber()) {
            return getNumberBadgeText();
        }
        return null;
    }

    private float getBottomCutOff(float f5, float f6) {
        return ((this.badgeCenterY + this.halfBadgeHeight) - f5) + f6;
    }

    private CharSequence getEmptyContentDescription() {
        return this.state.getContentDescriptionNumberless();
    }

    private float getLeftCutOff(float f5) {
        return (this.badgeCenterX - this.halfBadgeWidth) + f5;
    }

    @NonNull
    private String getNumberBadgeText() {
        if (this.maxBadgeNumber == -2 || getNumber() <= this.maxBadgeNumber) {
            return NumberFormat.getInstance(this.state.getNumberLocale()).format((long) getNumber());
        }
        Context context = this.contextRef.get();
        if (context == null) {
            return "";
        }
        return String.format(this.state.getNumberLocale(), context.getString(R.string.mtrl_exceed_max_badge_number_suffix), new Object[]{Integer.valueOf(this.maxBadgeNumber), DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX});
    }

    @Nullable
    private String getNumberContentDescription() {
        Context context;
        if (this.state.getContentDescriptionQuantityStrings() == 0 || (context = this.contextRef.get()) == null) {
            return null;
        }
        if (this.maxBadgeNumber == -2 || getNumber() <= this.maxBadgeNumber) {
            return context.getResources().getQuantityString(this.state.getContentDescriptionQuantityStrings(), getNumber(), new Object[]{Integer.valueOf(getNumber())});
        }
        return context.getString(this.state.getContentDescriptionExceedsMaxBadgeNumberStringResource(), new Object[]{Integer.valueOf(this.maxBadgeNumber)});
    }

    private float getRightCutoff(float f5, float f6) {
        return ((this.badgeCenterX + this.halfBadgeWidth) - f5) + f6;
    }

    @Nullable
    private String getTextBadgeText() {
        String text = getText();
        int maxCharacterCount = getMaxCharacterCount();
        if (maxCharacterCount == -2 || text == null || text.length() <= maxCharacterCount) {
            return text;
        }
        Context context = this.contextRef.get();
        if (context == null) {
            return "";
        }
        String substring = text.substring(0, maxCharacterCount - 1);
        return String.format(context.getString(R.string.m3_exceed_max_badge_text_suffix), new Object[]{substring, DEFAULT_EXCEED_MAX_BADGE_TEXT_SUFFIX});
    }

    @Nullable
    private CharSequence getTextContentDescription() {
        CharSequence contentDescriptionForText = this.state.getContentDescriptionForText();
        if (contentDescriptionForText != null) {
            return contentDescriptionForText;
        }
        return getText();
    }

    private float getTopCutOff(float f5) {
        return (this.badgeCenterY - this.halfBadgeHeight) + f5;
    }

    private int getTotalHorizontalOffsetForState() {
        int i5;
        int i6;
        if (hasBadgeContent()) {
            i5 = this.state.getHorizontalOffsetWithText();
        } else {
            i5 = this.state.getHorizontalOffsetWithoutText();
        }
        if (this.state.offsetAlignmentMode == 1) {
            if (hasBadgeContent()) {
                i6 = this.state.horizontalInsetWithText;
            } else {
                i6 = this.state.horizontalInset;
            }
            i5 += i6;
        }
        return i5 + this.state.getAdditionalHorizontalOffset();
    }

    private int getTotalVerticalOffsetForState() {
        int verticalOffsetWithoutText = this.state.getVerticalOffsetWithoutText();
        if (hasBadgeContent()) {
            verticalOffsetWithoutText = this.state.getVerticalOffsetWithText();
            Context context = this.contextRef.get();
            if (context != null) {
                verticalOffsetWithoutText = AnimationUtils.lerp(verticalOffsetWithoutText, verticalOffsetWithoutText - this.state.getLargeFontVerticalOffsetAdjustment(), AnimationUtils.lerp(0.0f, 1.0f, FONT_SCALE_THRESHOLD, 1.0f, MaterialResources.getFontScale(context) - 1.0f));
            }
        }
        if (this.state.offsetAlignmentMode == 0) {
            verticalOffsetWithoutText -= Math.round(this.halfBadgeHeight);
        }
        return verticalOffsetWithoutText + this.state.getAdditionalVerticalOffset();
    }

    private boolean hasBadgeContent() {
        if (hasText() || hasNumber()) {
            return true;
        }
        return false;
    }

    private void onAlphaUpdated() {
        this.textDrawableHelper.getTextPaint().setAlpha(getAlpha());
        invalidateSelf();
    }

    private void onBackgroundColorUpdated() {
        ColorStateList valueOf = ColorStateList.valueOf(this.state.getBackgroundColor());
        if (this.shapeDrawable.getFillColor() != valueOf) {
            this.shapeDrawable.setFillColor(valueOf);
            invalidateSelf();
        }
    }

    private void onBadgeContentUpdated() {
        this.textDrawableHelper.setTextSizeDirty(true);
        onBadgeShapeAppearanceUpdated();
        updateCenterAndBounds();
        invalidateSelf();
    }

    private void onBadgeGravityUpdated() {
        FrameLayout frameLayout;
        WeakReference<View> weakReference = this.anchorViewRef;
        if (weakReference != null && weakReference.get() != null) {
            View view = this.anchorViewRef.get();
            WeakReference<FrameLayout> weakReference2 = this.customBadgeParentRef;
            if (weakReference2 != null) {
                frameLayout = weakReference2.get();
            } else {
                frameLayout = null;
            }
            updateBadgeCoordinates(view, frameLayout);
        }
    }

    private void onBadgeShapeAppearanceUpdated() {
        int i5;
        int i6;
        Context context = this.contextRef.get();
        if (context != null) {
            MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
            if (hasBadgeContent()) {
                i5 = this.state.getBadgeWithTextShapeAppearanceResId();
            } else {
                i5 = this.state.getBadgeShapeAppearanceResId();
            }
            if (hasBadgeContent()) {
                i6 = this.state.getBadgeWithTextShapeAppearanceOverlayResId();
            } else {
                i6 = this.state.getBadgeShapeAppearanceOverlayResId();
            }
            materialShapeDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder(context, i5, i6).build());
            invalidateSelf();
        }
    }

    private void onBadgeTextAppearanceUpdated() {
        TextAppearance textAppearance;
        Context context = this.contextRef.get();
        if (context != null && this.textDrawableHelper.getTextAppearance() != (textAppearance = new TextAppearance(context, this.state.getTextAppearanceResId()))) {
            this.textDrawableHelper.setTextAppearance(textAppearance, context);
            onBadgeTextColorUpdated();
            updateCenterAndBounds();
            invalidateSelf();
        }
    }

    private void onBadgeTextColorUpdated() {
        this.textDrawableHelper.getTextPaint().setColor(this.state.getBadgeTextColor());
        invalidateSelf();
    }

    private void onMaxBadgeLengthUpdated() {
        updateMaxBadgeNumber();
        this.textDrawableHelper.setTextSizeDirty(true);
        updateCenterAndBounds();
        invalidateSelf();
    }

    private void onNumberUpdated() {
        if (!hasText()) {
            onBadgeContentUpdated();
        }
    }

    private void onTextUpdated() {
        onBadgeContentUpdated();
    }

    private void onVisibilityUpdated() {
        setVisible(this.state.isVisible(), false);
    }

    private void restoreState() {
        onBadgeShapeAppearanceUpdated();
        onBadgeTextAppearanceUpdated();
        onMaxBadgeLengthUpdated();
        onBadgeContentUpdated();
        onAlphaUpdated();
        onBackgroundColorUpdated();
        onBadgeTextColorUpdated();
        onBadgeGravityUpdated();
        updateCenterAndBounds();
        onVisibilityUpdated();
    }

    private static void updateAnchorParentToNotClip(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void updateCenterAndBounds() {
        View view;
        Context context = this.contextRef.get();
        WeakReference<View> weakReference = this.anchorViewRef;
        ViewGroup viewGroup = null;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.badgeBounds);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<FrameLayout> weakReference2 = this.customBadgeParentRef;
            if (weakReference2 != null) {
                viewGroup = weakReference2.get();
            }
            if (viewGroup != null) {
                viewGroup.offsetDescendantRectToMyCoords(view, rect2);
            }
            calculateCenterAndBounds(rect2, view);
            BadgeUtils.updateBadgeBounds(this.badgeBounds, this.badgeCenterX, this.badgeCenterY, this.halfBadgeWidth, this.halfBadgeHeight);
            float f5 = this.cornerRadius;
            if (f5 != -1.0f) {
                this.shapeDrawable.setCornerSize(f5);
            }
            if (!rect.equals(this.badgeBounds)) {
                this.shapeDrawable.setBounds(this.badgeBounds);
            }
        }
    }

    private void updateMaxBadgeNumber() {
        if (getMaxCharacterCount() != -2) {
            this.maxBadgeNumber = ((int) Math.pow(10.0d, ((double) getMaxCharacterCount()) - 1.0d)) - 1;
        } else {
            this.maxBadgeNumber = getMaxNumber();
        }
    }

    public void clearNumber() {
        if (this.state.hasNumber()) {
            this.state.clearNumber();
            onNumberUpdated();
        }
    }

    public void clearText() {
        if (this.state.hasText()) {
            this.state.clearText();
            onTextUpdated();
        }
    }

    public void draw(@NonNull Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.shapeDrawable.draw(canvas);
            if (hasBadgeContent()) {
                drawBadgeContent(canvas);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getAdditionalHorizontalOffset() {
        return this.state.getAdditionalHorizontalOffset();
    }

    /* access modifiers changed from: package-private */
    @Px
    public int getAdditionalVerticalOffset() {
        return this.state.getAdditionalVerticalOffset();
    }

    public int getAlpha() {
        return this.state.getAlpha();
    }

    @ColorInt
    public int getBackgroundColor() {
        return this.shapeDrawable.getFillColor().getDefaultColor();
    }

    public int getBadgeGravity() {
        return this.state.getBadgeGravity();
    }

    @NonNull
    public Locale getBadgeNumberLocale() {
        return this.state.getNumberLocale();
    }

    @ColorInt
    public int getBadgeTextColor() {
        return this.textDrawableHelper.getTextPaint().getColor();
    }

    @Nullable
    public CharSequence getContentDescription() {
        if (!isVisible()) {
            return null;
        }
        if (hasText()) {
            return getTextContentDescription();
        }
        if (hasNumber()) {
            return getNumberContentDescription();
        }
        return getEmptyContentDescription();
    }

    @Nullable
    public FrameLayout getCustomBadgeParent() {
        WeakReference<FrameLayout> weakReference = this.customBadgeParentRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getHorizontalOffset() {
        return this.state.getHorizontalOffsetWithoutText();
    }

    @Px
    public int getHorizontalOffsetWithText() {
        return this.state.getHorizontalOffsetWithText();
    }

    @Px
    public int getHorizontalOffsetWithoutText() {
        return this.state.getHorizontalOffsetWithoutText();
    }

    @Px
    public int getHorizontalPadding() {
        return this.state.getBadgeHorizontalPadding();
    }

    public int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    public int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    @Px
    public int getLargeFontVerticalOffsetAdjustment() {
        return this.state.getLargeFontVerticalOffsetAdjustment();
    }

    public int getMaxCharacterCount() {
        return this.state.getMaxCharacterCount();
    }

    public int getMaxNumber() {
        return this.state.getMaxNumber();
    }

    public int getNumber() {
        if (this.state.hasNumber()) {
            return this.state.getNumber();
        }
        return 0;
    }

    public int getOpacity() {
        return -3;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public BadgeState.State getSavedState() {
        return this.state.getOverridingState();
    }

    @Nullable
    public String getText() {
        return this.state.getText();
    }

    public int getVerticalOffset() {
        return this.state.getVerticalOffsetWithoutText();
    }

    @Px
    public int getVerticalOffsetWithText() {
        return this.state.getVerticalOffsetWithText();
    }

    @Px
    public int getVerticalOffsetWithoutText() {
        return this.state.getVerticalOffsetWithoutText();
    }

    @Px
    public int getVerticalPadding() {
        return this.state.getBadgeVerticalPadding();
    }

    public boolean hasNumber() {
        if (this.state.hasText() || !this.state.hasNumber()) {
            return false;
        }
        return true;
    }

    public boolean hasText() {
        return this.state.hasText();
    }

    public boolean isStateful() {
        return false;
    }

    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onTextSizeChange() {
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void setAdditionalHorizontalOffset(int i5) {
        this.state.setAdditionalHorizontalOffset(i5);
        updateCenterAndBounds();
    }

    /* access modifiers changed from: package-private */
    public void setAdditionalVerticalOffset(@Px int i5) {
        this.state.setAdditionalVerticalOffset(i5);
        updateCenterAndBounds();
    }

    public void setAlpha(int i5) {
        this.state.setAlpha(i5);
        onAlphaUpdated();
    }

    @Deprecated
    public void setAutoAdjustToWithinGrandparentBounds(boolean z4) {
        if (this.state.isAutoAdjustedToGrandparentBounds() != z4) {
            this.state.setAutoAdjustToGrandparentBounds(z4);
            WeakReference<View> weakReference = this.anchorViewRef;
            if (weakReference != null && weakReference.get() != null) {
                autoAdjustWithinGrandparentBounds(this.anchorViewRef.get());
            }
        }
    }

    public void setBackgroundColor(@ColorInt int i5) {
        this.state.setBackgroundColor(i5);
        onBackgroundColorUpdated();
    }

    public void setBadgeFixedEdge(int i5) {
        BadgeState badgeState = this.state;
        if (badgeState.badgeFixedEdge != i5) {
            badgeState.badgeFixedEdge = i5;
            updateCenterAndBounds();
        }
    }

    public void setBadgeGravity(int i5) {
        if (i5 == 8388691 || i5 == 8388693) {
            Log.w(TAG, "Bottom badge gravities are deprecated; please use a top gravity instead.");
        }
        if (this.state.getBadgeGravity() != i5) {
            this.state.setBadgeGravity(i5);
            onBadgeGravityUpdated();
        }
    }

    public void setBadgeNumberLocale(@NonNull Locale locale) {
        if (!locale.equals(this.state.getNumberLocale())) {
            this.state.setNumberLocale(locale);
            invalidateSelf();
        }
    }

    public void setBadgeTextColor(@ColorInt int i5) {
        if (this.textDrawableHelper.getTextPaint().getColor() != i5) {
            this.state.setBadgeTextColor(i5);
            onBadgeTextColorUpdated();
        }
    }

    public void setBadgeWithTextShapeAppearance(@StyleRes int i5) {
        this.state.setBadgeWithTextShapeAppearanceResId(i5);
        onBadgeShapeAppearanceUpdated();
    }

    public void setBadgeWithTextShapeAppearanceOverlay(@StyleRes int i5) {
        this.state.setBadgeWithTextShapeAppearanceOverlayResId(i5);
        onBadgeShapeAppearanceUpdated();
    }

    public void setBadgeWithoutTextShapeAppearance(@StyleRes int i5) {
        this.state.setBadgeShapeAppearanceResId(i5);
        onBadgeShapeAppearanceUpdated();
    }

    public void setBadgeWithoutTextShapeAppearanceOverlay(@StyleRes int i5) {
        this.state.setBadgeShapeAppearanceOverlayResId(i5);
        onBadgeShapeAppearanceUpdated();
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(@StringRes int i5) {
        this.state.setContentDescriptionExceedsMaxBadgeNumberStringResource(i5);
    }

    public void setContentDescriptionForText(@Nullable CharSequence charSequence) {
        this.state.setContentDescriptionForText(charSequence);
    }

    public void setContentDescriptionNumberless(CharSequence charSequence) {
        this.state.setContentDescriptionNumberless(charSequence);
    }

    public void setContentDescriptionQuantityStringsResource(@PluralsRes int i5) {
        this.state.setContentDescriptionQuantityStringsResource(i5);
    }

    public void setHorizontalOffset(int i5) {
        setHorizontalOffsetWithoutText(i5);
        setHorizontalOffsetWithText(i5);
    }

    public void setHorizontalOffsetWithText(@Px int i5) {
        this.state.setHorizontalOffsetWithText(i5);
        updateCenterAndBounds();
    }

    public void setHorizontalOffsetWithoutText(@Px int i5) {
        this.state.setHorizontalOffsetWithoutText(i5);
        updateCenterAndBounds();
    }

    public void setHorizontalPadding(@Px int i5) {
        if (i5 != this.state.getBadgeHorizontalPadding()) {
            this.state.setBadgeHorizontalPadding(i5);
            updateCenterAndBounds();
        }
    }

    public void setLargeFontVerticalOffsetAdjustment(@Px int i5) {
        this.state.setLargeFontVerticalOffsetAdjustment(i5);
        updateCenterAndBounds();
    }

    public void setMaxCharacterCount(int i5) {
        if (this.state.getMaxCharacterCount() != i5) {
            this.state.setMaxCharacterCount(i5);
            onMaxBadgeLengthUpdated();
        }
    }

    public void setMaxNumber(int i5) {
        if (this.state.getMaxNumber() != i5) {
            this.state.setMaxNumber(i5);
            onMaxBadgeLengthUpdated();
        }
    }

    public void setNumber(int i5) {
        int max = Math.max(0, i5);
        if (this.state.getNumber() != max) {
            this.state.setNumber(max);
            onNumberUpdated();
        }
    }

    public void setText(@Nullable String str) {
        if (!TextUtils.equals(this.state.getText(), str)) {
            this.state.setText(str);
            onTextUpdated();
        }
    }

    public void setTextAppearance(@StyleRes int i5) {
        this.state.setTextAppearanceResId(i5);
        onBadgeTextAppearanceUpdated();
    }

    public void setVerticalOffset(int i5) {
        setVerticalOffsetWithoutText(i5);
        setVerticalOffsetWithText(i5);
    }

    public void setVerticalOffsetWithText(@Px int i5) {
        this.state.setVerticalOffsetWithText(i5);
        updateCenterAndBounds();
    }

    public void setVerticalOffsetWithoutText(@Px int i5) {
        this.state.setVerticalOffsetWithoutText(i5);
        updateCenterAndBounds();
    }

    public void setVerticalPadding(@Px int i5) {
        if (i5 != this.state.getBadgeVerticalPadding()) {
            this.state.setBadgeVerticalPadding(i5);
            updateCenterAndBounds();
        }
    }

    public void setVisible(boolean z4) {
        this.state.setVisible(z4);
        onVisibilityUpdated();
    }

    @Deprecated
    public void updateBadgeCoordinates(@NonNull View view, @Nullable ViewGroup viewGroup) {
        if (viewGroup instanceof FrameLayout) {
            updateBadgeCoordinates(view, (FrameLayout) viewGroup);
            return;
        }
        throw new IllegalArgumentException("customBadgeParent must be a FrameLayout");
    }

    public void updateBadgeCoordinates(@NonNull View view) {
        updateBadgeCoordinates(view, (FrameLayout) null);
    }

    public void updateBadgeCoordinates(@NonNull View view, @Nullable FrameLayout frameLayout) {
        this.anchorViewRef = new WeakReference<>(view);
        this.customBadgeParentRef = new WeakReference<>(frameLayout);
        updateAnchorParentToNotClip(view);
        updateCenterAndBounds();
        invalidateSelf();
    }
}
