package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TypefaceUtils;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;
    @Nullable
    private static final Paint DEBUG_DRAW_PAINT = null;
    private static final String ELLIPSIS_NORMAL = "…";
    private static final float FADE_MODE_THRESHOLD_FRACTION_RELATIVE = 0.5f;
    private static final int ONE_LINE = 1;
    public static final int SEMITRANSPARENT_MAGENTA = 1090453759;
    private static final String TAG = "CollapsingTextHelper";
    private boolean alignBaselineAtBottom;
    private boolean boundsChanged;
    @NonNull
    private final Rect collapsedBounds;
    @Nullable
    private Rect collapsedBoundsForPlacement;
    private float collapsedDrawX;
    private float collapsedDrawY;
    private CancelableFontCallback collapsedFontCallback;
    private int collapsedHeight = -1;
    private float collapsedLetterSpacing;
    private int collapsedMaxLines = 1;
    private ColorStateList collapsedShadowColor;
    private float collapsedShadowDx;
    private float collapsedShadowDy;
    private float collapsedShadowRadius;
    private float collapsedTextBlend;
    private ColorStateList collapsedTextColor;
    private int collapsedTextGravity = 16;
    private float collapsedTextSize = 15.0f;
    private float collapsedTextWidth;
    private Typeface collapsedTypeface;
    private Typeface collapsedTypefaceBold;
    private Typeface collapsedTypefaceDefault;
    @NonNull
    private final RectF currentBounds;
    private float currentDrawX;
    private float currentDrawY;
    private float currentLetterSpacing;
    private int currentMaxLines;
    private int currentOffsetY;
    private int currentShadowColor;
    private float currentShadowDx;
    private float currentShadowDy;
    private float currentShadowRadius;
    private float currentTextSize;
    private Typeface currentTypeface;
    @NonNull
    private final Rect expandedBounds;
    private float expandedDrawX;
    private float expandedDrawY;
    private CancelableFontCallback expandedFontCallback;
    private float expandedFraction;
    private int expandedHeight = -1;
    private float expandedLetterSpacing;
    private int expandedLineCount;
    private int expandedMaxLines = 1;
    private ColorStateList expandedShadowColor;
    private float expandedShadowDx;
    private float expandedShadowDy;
    private float expandedShadowRadius;
    private float expandedTextBlend;
    private ColorStateList expandedTextColor;
    private int expandedTextGravity = 16;
    private float expandedTextSize = 15.0f;
    private Typeface expandedTypeface;
    private Typeface expandedTypefaceBold;
    private Typeface expandedTypefaceDefault;
    private boolean fadeModeEnabled;
    private float fadeModeStartFraction;
    private float fadeModeThresholdFraction;
    private int hyphenationFrequency = StaticLayoutBuilderCompat.DEFAULT_HYPHENATION_FREQUENCY;
    private boolean isRtl;
    private boolean isRtlTextDirectionHeuristicsEnabled = true;
    private float lineSpacingAdd = 0.0f;
    private float lineSpacingMultiplier = 1.0f;
    private TimeInterpolator positionInterpolator;
    private float scale;
    private int[] state;
    @Nullable
    private StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer;
    @Nullable
    private CharSequence text;
    private StaticLayout textLayout;
    @NonNull
    private final TextPaint textPaint;
    private TimeInterpolator textSizeInterpolator;
    @Nullable
    private CharSequence textToDraw;
    private CharSequence textToDrawCollapsed;
    private TextUtils.TruncateAt titleTextEllipsize = TextUtils.TruncateAt.END;
    @NonNull
    private final TextPaint tmpPaint;
    private final View view;

    public CollapsingTextHelper(View view2) {
        this.view = view2;
        TextPaint textPaint2 = new TextPaint(TsExtractor.TS_STREAM_TYPE_AC3);
        this.textPaint = textPaint2;
        this.tmpPaint = new TextPaint(textPaint2);
        this.collapsedBounds = new Rect();
        this.expandedBounds = new Rect();
        this.currentBounds = new RectF();
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
        maybeUpdateFontWeightAdjustment(view2.getContext().getResources().getConfiguration());
    }

    @ColorInt
    private static int blendARGB(@ColorInt int i5, @ColorInt int i6, @FloatRange(from = 0.0d, to = 1.0d) float f5) {
        float f6 = 1.0f - f5;
        return Color.argb(Math.round((((float) Color.alpha(i5)) * f6) + (((float) Color.alpha(i6)) * f5)), Math.round((((float) Color.red(i5)) * f6) + (((float) Color.red(i6)) * f5)), Math.round((((float) Color.green(i5)) * f6) + (((float) Color.green(i6)) * f5)), Math.round((((float) Color.blue(i5)) * f6) + (((float) Color.blue(i6)) * f5)));
    }

    private void calculateBaseOffsets(boolean z4) {
        float f5;
        float f6;
        int i5;
        CharSequence charSequence;
        calculateUsingTextSize(1.0f, z4);
        if (!(this.textToDraw == null || this.textLayout == null)) {
            if (shouldTruncateCollapsedToSingleLine()) {
                charSequence = TextUtils.ellipsize(this.textToDraw, this.textPaint, (float) this.textLayout.getWidth(), this.titleTextEllipsize);
            } else {
                charSequence = this.textToDraw;
            }
            this.textToDrawCollapsed = charSequence;
        }
        CharSequence charSequence2 = this.textToDrawCollapsed;
        float f7 = 0.0f;
        if (charSequence2 != null) {
            this.collapsedTextWidth = measureTextWidth(this.textPaint, charSequence2);
        } else {
            this.collapsedTextWidth = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.collapsedTextGravity, this.isRtl ? 1 : 0);
        Rect rect = this.collapsedBoundsForPlacement;
        if (rect == null) {
            rect = this.collapsedBounds;
        }
        int i6 = absoluteGravity & 112;
        if (i6 == 48) {
            this.collapsedDrawY = (float) rect.top;
        } else if (i6 != 80) {
            this.collapsedDrawY = ((float) rect.centerY()) - ((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f);
        } else {
            this.collapsedDrawY = ((float) rect.bottom) + this.textPaint.ascent();
        }
        int i7 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i7 == 1) {
            this.collapsedDrawX = ((float) rect.centerX()) - (this.collapsedTextWidth / 2.0f);
        } else if (i7 != 5) {
            this.collapsedDrawX = (float) rect.left;
        } else {
            this.collapsedDrawX = ((float) rect.right) - this.collapsedTextWidth;
        }
        if (this.collapsedTextWidth <= ((float) this.collapsedBounds.width())) {
            float f8 = this.collapsedDrawX;
            float max = f8 + Math.max(0.0f, ((float) this.collapsedBounds.left) - f8);
            this.collapsedDrawX = max;
            this.collapsedDrawX = max + Math.min(0.0f, ((float) this.collapsedBounds.right) - (this.collapsedTextWidth + max));
        }
        if (getCollapsedFullSingleLineHeight() <= ((float) this.collapsedBounds.height())) {
            float f9 = this.collapsedDrawY;
            float max2 = f9 + Math.max(0.0f, ((float) this.collapsedBounds.top) - f9);
            this.collapsedDrawY = max2;
            this.collapsedDrawY = max2 + Math.min(0.0f, ((float) this.collapsedBounds.bottom) - (getCollapsedTextHeight() + max2));
        }
        calculateUsingTextSize(0.0f, z4);
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout != null) {
            f5 = (float) staticLayout.getHeight();
        } else {
            f5 = 0.0f;
        }
        StaticLayout staticLayout2 = this.textLayout;
        if (staticLayout2 == null || this.expandedMaxLines <= 1) {
            CharSequence charSequence3 = this.textToDraw;
            if (charSequence3 != null) {
                f6 = measureTextWidth(this.textPaint, charSequence3);
            } else {
                f6 = 0.0f;
            }
        } else {
            f6 = (float) staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.textLayout;
        if (staticLayout3 != null) {
            i5 = staticLayout3.getLineCount();
        } else {
            i5 = 0;
        }
        this.expandedLineCount = i5;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0);
        int i8 = absoluteGravity2 & 112;
        if (i8 == 48) {
            this.expandedDrawY = (float) this.expandedBounds.top;
        } else if (i8 != 80) {
            this.expandedDrawY = ((float) this.expandedBounds.centerY()) - (f5 / 2.0f);
        } else {
            float f10 = ((float) this.expandedBounds.bottom) - f5;
            if (this.alignBaselineAtBottom) {
                f7 = this.textPaint.descent();
            }
            this.expandedDrawY = f10 + f7;
        }
        int i9 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i9 == 1) {
            this.expandedDrawX = ((float) this.expandedBounds.centerX()) - (f6 / 2.0f);
        } else if (i9 != 5) {
            this.expandedDrawX = (float) this.expandedBounds.left;
        } else {
            this.expandedDrawX = ((float) this.expandedBounds.right) - f6;
        }
        setInterpolatedTextSize(this.expandedFraction);
    }

    private void calculateCurrentOffsets() {
        calculateOffsets(this.expandedFraction);
    }

    private float calculateFadeModeTextAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f5) {
        float f6 = this.fadeModeThresholdFraction;
        if (f5 <= f6) {
            return AnimationUtils.lerp(1.0f, 0.0f, this.fadeModeStartFraction, f6, f5);
        }
        return AnimationUtils.lerp(0.0f, 1.0f, f6, 1.0f, f5);
    }

    private float calculateFadeModeThresholdFraction() {
        float f5 = this.fadeModeStartFraction;
        return f5 + ((1.0f - f5) * 0.5f);
    }

    private boolean calculateIsRtl(@NonNull CharSequence charSequence) {
        boolean isDefaultIsRtl = isDefaultIsRtl();
        if (this.isRtlTextDirectionHeuristicsEnabled) {
            return isTextDirectionHeuristicsIsRtl(charSequence, isDefaultIsRtl);
        }
        return isDefaultIsRtl;
    }

    private void calculateOffsets(float f5) {
        float f6;
        interpolateBounds(f5);
        if (!this.fadeModeEnabled) {
            this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f5, this.positionInterpolator);
            this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f5, this.positionInterpolator);
            setInterpolatedTextSize(f5);
            f6 = f5;
        } else if (f5 < this.fadeModeThresholdFraction) {
            this.currentDrawX = this.expandedDrawX;
            this.currentDrawY = this.expandedDrawY;
            setInterpolatedTextSize(0.0f);
            f6 = 0.0f;
        } else {
            this.currentDrawX = this.collapsedDrawX;
            this.currentDrawY = this.collapsedDrawY - ((float) Math.max(0, this.currentOffsetY));
            setInterpolatedTextSize(1.0f);
            f6 = 1.0f;
        }
        TimeInterpolator timeInterpolator = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        setCollapsedTextBlend(1.0f - lerp(0.0f, 1.0f, 1.0f - f5, timeInterpolator));
        setExpandedTextBlend(lerp(1.0f, 0.0f, f5, timeInterpolator));
        if (this.collapsedTextColor != this.expandedTextColor) {
            this.textPaint.setColor(blendARGB(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), f6));
        } else {
            this.textPaint.setColor(getCurrentCollapsedTextColor());
        }
        float f7 = this.collapsedLetterSpacing;
        float f8 = this.expandedLetterSpacing;
        if (f7 != f8) {
            this.textPaint.setLetterSpacing(lerp(f8, f7, f5, timeInterpolator));
        } else {
            this.textPaint.setLetterSpacing(f7);
        }
        this.currentShadowRadius = lerp(this.expandedShadowRadius, this.collapsedShadowRadius, f5, (TimeInterpolator) null);
        this.currentShadowDx = lerp(this.expandedShadowDx, this.collapsedShadowDx, f5, (TimeInterpolator) null);
        this.currentShadowDy = lerp(this.expandedShadowDy, this.collapsedShadowDy, f5, (TimeInterpolator) null);
        int blendARGB = blendARGB(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), f5);
        this.currentShadowColor = blendARGB;
        this.textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, blendARGB);
        if (this.fadeModeEnabled) {
            this.textPaint.setAlpha((int) (calculateFadeModeTextAlpha(f5) * ((float) this.textPaint.getAlpha())));
            if (Build.VERSION.SDK_INT >= 31) {
                TextPaint textPaint2 = this.textPaint;
                textPaint2.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, MaterialColors.compositeARGBWithAlpha(this.currentShadowColor, textPaint2.getAlpha()));
            }
        }
        this.view.postInvalidateOnAnimation();
    }

    private void calculateUsingTextSize(float f5) {
        calculateUsingTextSize(f5, false);
    }

    private StaticLayout createStaticLayout(int i5, TextPaint textPaint2, CharSequence charSequence, float f5, boolean z4) {
        StaticLayout staticLayout;
        Layout.Alignment alignment;
        if (i5 == 1) {
            try {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e5) {
                Log.e(TAG, e5.getCause().getMessage(), e5);
                staticLayout = null;
            }
        } else {
            alignment = getMultilineTextLayoutAlignment();
        }
        staticLayout = StaticLayoutBuilderCompat.obtain(charSequence, textPaint2, (int) f5).setEllipsize(this.titleTextEllipsize).setIsRtl(z4).setAlignment(alignment).setIncludePad(false).setMaxLines(i5).setLineSpacing(this.lineSpacingAdd, this.lineSpacingMultiplier).setHyphenationFrequency(this.hyphenationFrequency).setStaticLayoutBuilderConfigurer(this.staticLayoutBuilderConfigurer).build();
        return (StaticLayout) Preconditions.checkNotNull(staticLayout);
    }

    private void drawMultilineTransition(@NonNull Canvas canvas, float f5, float f6) {
        int alpha = this.textPaint.getAlpha();
        canvas.translate(f5, f6);
        if (!this.fadeModeEnabled) {
            this.textPaint.setAlpha((int) (this.expandedTextBlend * ((float) alpha)));
            if (Build.VERSION.SDK_INT >= 31) {
                TextPaint textPaint2 = this.textPaint;
                textPaint2.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, MaterialColors.compositeARGBWithAlpha(this.currentShadowColor, textPaint2.getAlpha()));
            }
            this.textLayout.draw(canvas);
        }
        if (!this.fadeModeEnabled) {
            this.textPaint.setAlpha((int) (this.collapsedTextBlend * ((float) alpha)));
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 31) {
            TextPaint textPaint3 = this.textPaint;
            textPaint3.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, MaterialColors.compositeARGBWithAlpha(this.currentShadowColor, textPaint3.getAlpha()));
        }
        int lineBaseline = this.textLayout.getLineBaseline(0);
        CharSequence charSequence = this.textToDrawCollapsed;
        float f7 = (float) lineBaseline;
        Canvas canvas2 = canvas;
        canvas2.drawText(charSequence, 0, charSequence.length(), 0.0f, f7, this.textPaint);
        if (i5 >= 31) {
            this.textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, this.currentShadowColor);
        }
        if (!this.fadeModeEnabled) {
            String trim = this.textToDrawCollapsed.toString().trim();
            if (trim.endsWith(ELLIPSIS_NORMAL)) {
                trim = trim.substring(0, trim.length() - 1);
            }
            String str = trim;
            this.textPaint.setAlpha(alpha);
            canvas.drawText(str, 0, Math.min(this.textLayout.getLineEnd(0), str.length()), 0.0f, f7, this.textPaint);
        }
    }

    private float getCollapsedTextLeftBound(int i5, int i6) {
        if (i6 == 17 || (i6 & 7) == 1) {
            return (((float) i5) / 2.0f) - (this.collapsedTextWidth / 2.0f);
        }
        if ((i6 & GravityCompat.END) == 8388613 || (i6 & 5) == 5) {
            if (this.isRtl) {
                return (float) this.collapsedBounds.left;
            }
            return ((float) this.collapsedBounds.right) - this.collapsedTextWidth;
        } else if (this.isRtl) {
            return ((float) this.collapsedBounds.right) - this.collapsedTextWidth;
        } else {
            return (float) this.collapsedBounds.left;
        }
    }

    private float getCollapsedTextRightBound(@NonNull RectF rectF, int i5, int i6) {
        if (i6 == 17 || (i6 & 7) == 1) {
            return (((float) i5) / 2.0f) + (this.collapsedTextWidth / 2.0f);
        }
        if ((i6 & GravityCompat.END) == 8388613 || (i6 & 5) == 5) {
            if (this.isRtl) {
                return rectF.left + this.collapsedTextWidth;
            }
            return (float) this.collapsedBounds.right;
        } else if (this.isRtl) {
            return (float) this.collapsedBounds.right;
        } else {
            return rectF.left + this.collapsedTextWidth;
        }
    }

    @ColorInt
    private int getCurrentColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.state;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    @ColorInt
    private int getCurrentExpandedTextColor() {
        return getCurrentColor(this.expandedTextColor);
    }

    private Layout.Alignment getMultilineTextLayoutAlignment() {
        int absoluteGravity = Gravity.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0) & 7;
        if (absoluteGravity == 1) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (absoluteGravity != 5) {
            if (this.isRtl) {
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        } else if (this.isRtl) {
            return Layout.Alignment.ALIGN_NORMAL;
        } else {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    private void getTextPaintCollapsed(@NonNull TextPaint textPaint2) {
        textPaint2.setTextSize(this.collapsedTextSize);
        textPaint2.setTypeface(this.collapsedTypeface);
        textPaint2.setLetterSpacing(this.collapsedLetterSpacing);
    }

    private void getTextPaintExpanded(@NonNull TextPaint textPaint2) {
        textPaint2.setTextSize(this.expandedTextSize);
        textPaint2.setTypeface(this.expandedTypeface);
        textPaint2.setLetterSpacing(this.expandedLetterSpacing);
    }

    private void interpolateBounds(float f5) {
        Rect rect;
        if (this.fadeModeEnabled) {
            RectF rectF = this.currentBounds;
            if (f5 < this.fadeModeThresholdFraction) {
                rect = this.expandedBounds;
            } else {
                rect = this.collapsedBounds;
            }
            rectF.set(rect);
            return;
        }
        this.currentBounds.left = lerp((float) this.expandedBounds.left, (float) this.collapsedBounds.left, f5, this.positionInterpolator);
        this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, f5, this.positionInterpolator);
        this.currentBounds.right = lerp((float) this.expandedBounds.right, (float) this.collapsedBounds.right, f5, this.positionInterpolator);
        this.currentBounds.bottom = lerp((float) this.expandedBounds.bottom, (float) this.collapsedBounds.bottom, f5, this.positionInterpolator);
    }

    private static boolean isClose(float f5, float f6) {
        if (Math.abs(f5 - f6) < 1.0E-5f) {
            return true;
        }
        return false;
    }

    private boolean isDefaultIsRtl() {
        if (this.view.getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    private boolean isTextDirectionHeuristicsIsRtl(@NonNull CharSequence charSequence, boolean z4) {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat;
        if (z4) {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
        } else {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        }
        return textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }

    private static float lerp(float f5, float f6, float f7, @Nullable TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f7 = timeInterpolator.getInterpolation(f7);
        }
        return AnimationUtils.lerp(f5, f6, f7);
    }

    private float measureTextWidth(TextPaint textPaint2, CharSequence charSequence) {
        return textPaint2.measureText(charSequence, 0, charSequence.length());
    }

    private static boolean rectEquals(@NonNull Rect rect, int i5, int i6, int i7, int i8) {
        if (rect.left == i5 && rect.top == i6 && rect.right == i7 && rect.bottom == i8) {
            return true;
        }
        return false;
    }

    private void setCollapsedTextBlend(float f5) {
        this.collapsedTextBlend = f5;
        this.view.postInvalidateOnAnimation();
    }

    private boolean setCollapsedTypefaceInternal(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        if (this.collapsedTypefaceDefault == typeface) {
            return false;
        }
        this.collapsedTypefaceDefault = typeface;
        Typeface maybeCopyWithFontWeightAdjustment = TypefaceUtils.maybeCopyWithFontWeightAdjustment(this.view.getContext().getResources().getConfiguration(), typeface);
        this.collapsedTypefaceBold = maybeCopyWithFontWeightAdjustment;
        if (maybeCopyWithFontWeightAdjustment == null) {
            maybeCopyWithFontWeightAdjustment = this.collapsedTypefaceDefault;
        }
        this.collapsedTypeface = maybeCopyWithFontWeightAdjustment;
        return true;
    }

    private void setExpandedTextBlend(float f5) {
        this.expandedTextBlend = f5;
        this.view.postInvalidateOnAnimation();
    }

    private boolean setExpandedTypefaceInternal(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.expandedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        if (this.expandedTypefaceDefault == typeface) {
            return false;
        }
        this.expandedTypefaceDefault = typeface;
        Typeface maybeCopyWithFontWeightAdjustment = TypefaceUtils.maybeCopyWithFontWeightAdjustment(this.view.getContext().getResources().getConfiguration(), typeface);
        this.expandedTypefaceBold = maybeCopyWithFontWeightAdjustment;
        if (maybeCopyWithFontWeightAdjustment == null) {
            maybeCopyWithFontWeightAdjustment = this.expandedTypefaceDefault;
        }
        this.expandedTypeface = maybeCopyWithFontWeightAdjustment;
        return true;
    }

    private void setInterpolatedTextSize(float f5) {
        calculateUsingTextSize(f5);
        this.view.postInvalidateOnAnimation();
    }

    private boolean shouldDrawMultiline() {
        if (this.expandedMaxLines <= 1 && this.collapsedMaxLines <= 1) {
            return false;
        }
        if (!this.isRtl || this.fadeModeEnabled) {
            return true;
        }
        return false;
    }

    private boolean shouldTruncateCollapsedToSingleLine() {
        if (this.collapsedMaxLines == 1) {
            return true;
        }
        return false;
    }

    public void draw(@NonNull Canvas canvas) {
        int save = canvas.save();
        if (this.textToDraw != null && this.currentBounds.width() > 0.0f && this.currentBounds.height() > 0.0f) {
            this.textPaint.setTextSize(this.currentTextSize);
            float f5 = this.currentDrawX;
            float f6 = this.currentDrawY;
            float f7 = this.scale;
            if (f7 != 1.0f && !this.fadeModeEnabled) {
                canvas.scale(f7, f7, f5, f6);
            }
            if (!shouldDrawMultiline() || !shouldTruncateCollapsedToSingleLine() || (this.fadeModeEnabled && this.expandedFraction <= this.fadeModeThresholdFraction)) {
                canvas.translate(f5, f6);
                this.textLayout.draw(canvas);
            } else {
                drawMultilineTransition(canvas, this.currentDrawX - ((float) this.textLayout.getLineStart(0)), f6);
            }
            canvas.restoreToCount(save);
        }
    }

    public float getCollapsedFullSingleLineHeight() {
        getTextPaintCollapsed(this.tmpPaint);
        return (-this.tmpPaint.ascent()) + this.tmpPaint.descent();
    }

    public float getCollapsedSingleLineHeight() {
        getTextPaintCollapsed(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public void getCollapsedTextBottomTextBounds(@NonNull RectF rectF, int i5, int i6) {
        this.isRtl = calculateIsRtl(this.text);
        rectF.left = Math.max(getCollapsedTextLeftBound(i5, i6), (float) this.collapsedBounds.left);
        rectF.top = (float) this.collapsedBounds.top;
        rectF.right = Math.min(getCollapsedTextRightBound(rectF, i5, i6), (float) this.collapsedBounds.right);
        rectF.bottom = ((float) this.collapsedBounds.top) + getCollapsedTextHeight();
        if (this.textLayout != null && !shouldTruncateCollapsedToSingleLine()) {
            StaticLayout staticLayout = this.textLayout;
            float lineWidth = staticLayout.getLineWidth(staticLayout.getLineCount() - 1) * (this.collapsedTextSize / this.expandedTextSize);
            if (this.isRtl) {
                rectF.left = rectF.right - lineWidth;
            } else {
                rectF.right = rectF.left + lineWidth;
            }
        }
    }

    public ColorStateList getCollapsedTextColor() {
        return this.collapsedTextColor;
    }

    public int getCollapsedTextGravity() {
        return this.collapsedTextGravity;
    }

    public float getCollapsedTextHeight() {
        int i5 = this.collapsedHeight;
        if (i5 != -1) {
            return (float) i5;
        }
        return getCollapsedSingleLineHeight();
    }

    public float getCollapsedTextSize() {
        return this.collapsedTextSize;
    }

    public Typeface getCollapsedTypeface() {
        Typeface typeface = this.collapsedTypeface;
        if (typeface != null) {
            return typeface;
        }
        return Typeface.DEFAULT;
    }

    @ColorInt
    public int getCurrentCollapsedTextColor() {
        return getCurrentColor(this.collapsedTextColor);
    }

    public int getExpandedLineCount() {
        return this.expandedLineCount;
    }

    public int getExpandedMaxLines() {
        return this.expandedMaxLines;
    }

    public ColorStateList getExpandedTextColor() {
        return this.expandedTextColor;
    }

    public float getExpandedTextFullSingleLineHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return (-this.tmpPaint.ascent()) + this.tmpPaint.descent();
    }

    public int getExpandedTextGravity() {
        return this.expandedTextGravity;
    }

    public float getExpandedTextHeight() {
        int i5 = this.expandedHeight;
        if (i5 != -1) {
            return (float) i5;
        }
        return getExpandedTextSingleLineHeight();
    }

    public float getExpandedTextSingleLineHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getExpandedTextSize() {
        return this.expandedTextSize;
    }

    public Typeface getExpandedTypeface() {
        Typeface typeface = this.expandedTypeface;
        if (typeface != null) {
            return typeface;
        }
        return Typeface.DEFAULT;
    }

    public float getExpansionFraction() {
        return this.expandedFraction;
    }

    public float getFadeModeThresholdFraction() {
        return this.fadeModeThresholdFraction;
    }

    @RequiresApi(23)
    public int getHyphenationFrequency() {
        return this.hyphenationFrequency;
    }

    public int getLineCount() {
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    @RequiresApi(23)
    public float getLineSpacingAdd() {
        return this.textLayout.getSpacingAdd();
    }

    @RequiresApi(23)
    public float getLineSpacingMultiplier() {
        return this.textLayout.getSpacingMultiplier();
    }

    @Nullable
    public TimeInterpolator getPositionInterpolator() {
        return this.positionInterpolator;
    }

    @Nullable
    public CharSequence getText() {
        return this.text;
    }

    @NonNull
    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.titleTextEllipsize;
    }

    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.isRtlTextDirectionHeuristicsEnabled;
    }

    public final boolean isStateful() {
        ColorStateList colorStateList = this.collapsedTextColor;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.expandedTextColor;
        if (colorStateList2 == null || !colorStateList2.isStateful()) {
            return false;
        }
        return true;
    }

    public void maybeUpdateFontWeightAdjustment(@NonNull Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.collapsedTypefaceDefault;
            if (typeface != null) {
                this.collapsedTypefaceBold = TypefaceUtils.maybeCopyWithFontWeightAdjustment(configuration, typeface);
            }
            Typeface typeface2 = this.expandedTypefaceDefault;
            if (typeface2 != null) {
                this.expandedTypefaceBold = TypefaceUtils.maybeCopyWithFontWeightAdjustment(configuration, typeface2);
            }
            Typeface typeface3 = this.collapsedTypefaceBold;
            if (typeface3 == null) {
                typeface3 = this.collapsedTypefaceDefault;
            }
            this.collapsedTypeface = typeface3;
            Typeface typeface4 = this.expandedTypefaceBold;
            if (typeface4 == null) {
                typeface4 = this.expandedTypefaceDefault;
            }
            this.expandedTypeface = typeface4;
            recalculate(true);
        }
    }

    public void recalculate() {
        recalculate(false);
    }

    public void setCollapsedAndExpandedTextColor(@Nullable ColorStateList colorStateList) {
        if (this.collapsedTextColor != colorStateList || this.expandedTextColor != colorStateList) {
            this.collapsedTextColor = colorStateList;
            this.expandedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setCollapsedBounds(int i5, int i6, int i7, int i8) {
        if (!rectEquals(this.collapsedBounds, i5, i6, i7, i8)) {
            this.collapsedBounds.set(i5, i6, i7, i8);
            this.boundsChanged = true;
        }
    }

    public void setCollapsedBoundsForOffsets(int i5, int i6, int i7, int i8) {
        if (this.collapsedBoundsForPlacement == null) {
            this.collapsedBoundsForPlacement = new Rect(i5, i6, i7, i8);
            this.boundsChanged = true;
        }
        if (!rectEquals(this.collapsedBoundsForPlacement, i5, i6, i7, i8)) {
            this.collapsedBoundsForPlacement.set(i5, i6, i7, i8);
            this.boundsChanged = true;
        }
    }

    public void setCollapsedMaxLines(int i5) {
        if (i5 != this.collapsedMaxLines) {
            this.collapsedMaxLines = i5;
            recalculate();
        }
    }

    public void setCollapsedTextAppearance(int i5) {
        TextAppearance textAppearance = new TextAppearance(this.view.getContext(), i5);
        if (textAppearance.getTextColor() != null) {
            this.collapsedTextColor = textAppearance.getTextColor();
        }
        if (textAppearance.getTextSize() != 0.0f) {
            this.collapsedTextSize = textAppearance.getTextSize();
        }
        ColorStateList colorStateList = textAppearance.shadowColor;
        if (colorStateList != null) {
            this.collapsedShadowColor = colorStateList;
        }
        this.collapsedShadowDx = textAppearance.shadowDx;
        this.collapsedShadowDy = textAppearance.shadowDy;
        this.collapsedShadowRadius = textAppearance.shadowRadius;
        this.collapsedLetterSpacing = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        this.collapsedFontCallback = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() {
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setCollapsedTypeface(typeface);
            }
        }, textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.view.getContext(), this.collapsedFontCallback);
        recalculate();
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.collapsedTextColor != colorStateList) {
            this.collapsedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setCollapsedTextGravity(int i5) {
        if (this.collapsedTextGravity != i5) {
            this.collapsedTextGravity = i5;
            recalculate();
        }
    }

    public void setCollapsedTextSize(float f5) {
        if (this.collapsedTextSize != f5) {
            this.collapsedTextSize = f5;
            recalculate();
        }
    }

    public void setCollapsedTypeface(Typeface typeface) {
        if (setCollapsedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setCurrentOffsetY(int i5) {
        this.currentOffsetY = i5;
    }

    public void setExpandedBounds(int i5, int i6, int i7, int i8, boolean z4) {
        if (!rectEquals(this.expandedBounds, i5, i6, i7, i8) || z4 != this.alignBaselineAtBottom) {
            this.expandedBounds.set(i5, i6, i7, i8);
            this.boundsChanged = true;
            this.alignBaselineAtBottom = z4;
        }
    }

    public void setExpandedLetterSpacing(float f5) {
        if (this.expandedLetterSpacing != f5) {
            this.expandedLetterSpacing = f5;
            recalculate();
        }
    }

    public void setExpandedMaxLines(int i5) {
        if (i5 != this.expandedMaxLines) {
            this.expandedMaxLines = i5;
            recalculate();
        }
    }

    public void setExpandedTextAppearance(int i5) {
        TextAppearance textAppearance = new TextAppearance(this.view.getContext(), i5);
        if (textAppearance.getTextColor() != null) {
            this.expandedTextColor = textAppearance.getTextColor();
        }
        if (textAppearance.getTextSize() != 0.0f) {
            this.expandedTextSize = textAppearance.getTextSize();
        }
        ColorStateList colorStateList = textAppearance.shadowColor;
        if (colorStateList != null) {
            this.expandedShadowColor = colorStateList;
        }
        this.expandedShadowDx = textAppearance.shadowDx;
        this.expandedShadowDy = textAppearance.shadowDy;
        this.expandedShadowRadius = textAppearance.shadowRadius;
        this.expandedLetterSpacing = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = this.expandedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        this.expandedFontCallback = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() {
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setExpandedTypeface(typeface);
            }
        }, textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.view.getContext(), this.expandedFontCallback);
        recalculate();
    }

    public void setExpandedTextColor(ColorStateList colorStateList) {
        if (this.expandedTextColor != colorStateList) {
            this.expandedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setExpandedTextGravity(int i5) {
        if (this.expandedTextGravity != i5) {
            this.expandedTextGravity = i5;
            recalculate();
        }
    }

    public void setExpandedTextSize(float f5) {
        if (this.expandedTextSize != f5) {
            this.expandedTextSize = f5;
            recalculate();
        }
    }

    public void setExpandedTypeface(Typeface typeface) {
        if (setExpandedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setExpansionFraction(float f5) {
        float clamp = MathUtils.clamp(f5, 0.0f, 1.0f);
        if (clamp != this.expandedFraction) {
            this.expandedFraction = clamp;
            calculateCurrentOffsets();
        }
    }

    public void setFadeModeEnabled(boolean z4) {
        this.fadeModeEnabled = z4;
    }

    public void setFadeModeStartFraction(float f5) {
        this.fadeModeStartFraction = f5;
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
    }

    @RequiresApi(23)
    public void setHyphenationFrequency(int i5) {
        this.hyphenationFrequency = i5;
    }

    @RequiresApi(23)
    public void setLineSpacingAdd(float f5) {
        this.lineSpacingAdd = f5;
    }

    @RequiresApi(23)
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float f5) {
        this.lineSpacingMultiplier = f5;
    }

    public void setPositionInterpolator(TimeInterpolator timeInterpolator) {
        this.positionInterpolator = timeInterpolator;
        recalculate();
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z4) {
        this.isRtlTextDirectionHeuristicsEnabled = z4;
    }

    public final boolean setState(int[] iArr) {
        this.state = iArr;
        if (!isStateful()) {
            return false;
        }
        recalculate();
        return true;
    }

    @RequiresApi(23)
    public void setStaticLayoutBuilderConfigurer(@Nullable StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer2) {
        if (this.staticLayoutBuilderConfigurer != staticLayoutBuilderConfigurer2) {
            this.staticLayoutBuilderConfigurer = staticLayoutBuilderConfigurer2;
            recalculate(true);
        }
    }

    public void setText(@Nullable CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.text, charSequence)) {
            this.text = charSequence;
            this.textToDraw = null;
            recalculate();
        }
    }

    public void setTextSizeInterpolator(TimeInterpolator timeInterpolator) {
        this.textSizeInterpolator = timeInterpolator;
        recalculate();
    }

    public void setTitleTextEllipsize(@NonNull TextUtils.TruncateAt truncateAt) {
        this.titleTextEllipsize = truncateAt;
        recalculate();
    }

    public void setTypefaces(Typeface typeface) {
        boolean collapsedTypefaceInternal = setCollapsedTypefaceInternal(typeface);
        boolean expandedTypefaceInternal = setExpandedTypefaceInternal(typeface);
        if (collapsedTypefaceInternal || expandedTypefaceInternal) {
            recalculate();
        }
    }

    public void updateTextHeights(int i5) {
        getTextPaintCollapsed(this.tmpPaint);
        float f5 = (float) i5;
        this.collapsedHeight = createStaticLayout(this.collapsedMaxLines, this.tmpPaint, this.text, f5 * (this.collapsedTextSize / this.expandedTextSize), this.isRtl).getHeight();
        getTextPaintExpanded(this.tmpPaint);
        this.expandedHeight = createStaticLayout(this.expandedMaxLines, this.tmpPaint, this.text, f5, this.isRtl).getHeight();
    }

    private void calculateUsingTextSize(float f5, boolean z4) {
        float f6;
        Typeface typeface;
        float f7;
        float f8;
        if (this.text != null) {
            float width = (float) this.collapsedBounds.width();
            float width2 = (float) this.expandedBounds.width();
            float f9 = 1.0f;
            if (isClose(f5, 1.0f)) {
                f6 = shouldTruncateCollapsedToSingleLine() ? this.collapsedTextSize : this.expandedTextSize;
                f7 = shouldTruncateCollapsedToSingleLine() ? this.collapsedLetterSpacing : this.expandedLetterSpacing;
                if (shouldTruncateCollapsedToSingleLine()) {
                    f8 = 1.0f;
                } else {
                    f8 = lerp(this.expandedTextSize, this.collapsedTextSize, f5, this.textSizeInterpolator) / this.expandedTextSize;
                }
                this.scale = f8;
                if (!shouldTruncateCollapsedToSingleLine()) {
                    width = width2;
                }
                typeface = this.collapsedTypeface;
                width2 = width;
            } else {
                float f10 = this.expandedTextSize;
                float f11 = this.expandedLetterSpacing;
                typeface = this.expandedTypeface;
                if (isClose(f5, 0.0f)) {
                    this.scale = 1.0f;
                } else {
                    this.scale = lerp(this.expandedTextSize, this.collapsedTextSize, f5, this.textSizeInterpolator) / this.expandedTextSize;
                }
                float f12 = this.collapsedTextSize / this.expandedTextSize;
                float f13 = width2 * f12;
                if (!z4 && !this.fadeModeEnabled && f13 > width && shouldTruncateCollapsedToSingleLine()) {
                    width2 = Math.min(width / f12, width2);
                }
                f6 = f10;
                f7 = f11;
            }
            int i5 = f5 < 0.5f ? this.expandedMaxLines : this.collapsedMaxLines;
            boolean z5 = false;
            if (width2 > 0.0f) {
                boolean z6 = this.currentTextSize != f6;
                boolean z7 = this.currentLetterSpacing != f7;
                boolean z8 = this.currentTypeface != typeface;
                StaticLayout staticLayout = this.textLayout;
                boolean z9 = z6 || z7 || (staticLayout != null && (width2 > ((float) staticLayout.getWidth()) ? 1 : (width2 == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z8 || (this.currentMaxLines != i5) || this.boundsChanged;
                this.currentTextSize = f6;
                this.currentLetterSpacing = f7;
                this.currentTypeface = typeface;
                this.boundsChanged = false;
                this.currentMaxLines = i5;
                TextPaint textPaint2 = this.textPaint;
                if (this.scale != 1.0f) {
                    z5 = true;
                }
                textPaint2.setLinearText(z5);
                z5 = z9;
            }
            if (this.textToDraw == null || z5) {
                this.textPaint.setTextSize(this.currentTextSize);
                this.textPaint.setTypeface(this.currentTypeface);
                this.textPaint.setLetterSpacing(this.currentLetterSpacing);
                this.isRtl = calculateIsRtl(this.text);
                int i6 = shouldDrawMultiline() ? i5 : 1;
                TextPaint textPaint3 = this.textPaint;
                CharSequence charSequence = this.text;
                if (!shouldTruncateCollapsedToSingleLine()) {
                    f9 = this.scale;
                }
                StaticLayout createStaticLayout = createStaticLayout(i6, textPaint3, charSequence, width2 * f9, this.isRtl);
                this.textLayout = createStaticLayout;
                this.textToDraw = createStaticLayout.getText();
            }
        }
    }

    public void recalculate(boolean z4) {
        if ((this.view.getHeight() > 0 && this.view.getWidth() > 0) || z4) {
            calculateBaseOffsets(z4);
            calculateCurrentOffsets();
        }
    }

    public void setCollapsedBounds(@NonNull Rect rect) {
        setCollapsedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setExpandedBounds(int i5, int i6, int i7, int i8) {
        setExpandedBounds(i5, i6, i7, i8, true);
    }

    public void setExpandedBounds(@NonNull Rect rect) {
        setExpandedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }
}
