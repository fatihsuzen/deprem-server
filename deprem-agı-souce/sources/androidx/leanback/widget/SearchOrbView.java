package androidx.leanback.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import androidx.leanback.R;

public class SearchOrbView extends FrameLayout implements View.OnClickListener {
    private boolean mAttachedToWindow;
    private boolean mColorAnimationEnabled;
    private ValueAnimator mColorAnimator;
    private final ArgbEvaluator mColorEvaluator;
    private Colors mColors;
    private final ValueAnimator.AnimatorUpdateListener mFocusUpdateListener;
    private final float mFocusedZ;
    private final float mFocusedZoom;
    private final ImageView mIcon;
    private Drawable mIconDrawable;
    private View.OnClickListener mListener;
    private final int mPulseDurationMs;
    private final View mRootView;
    private final int mScaleDurationMs;
    private final View mSearchOrbView;
    private ValueAnimator mShadowFocusAnimator;
    private final float mUnfocusedZ;
    private final ValueAnimator.AnimatorUpdateListener mUpdateListener;

    public static class Colors {
        private static final float BRIGHTNESS_ALPHA = 0.15f;
        @ColorInt
        public int brightColor;
        @ColorInt
        public int color;
        @ColorInt
        public int iconColor;

        public Colors(@ColorInt int i5) {
            this(i5, i5);
        }

        public static int getBrightColor(int i5) {
            return Color.argb((int) ((((float) Color.alpha(i5)) * 0.85f) + 38.25f), (int) ((((float) Color.red(i5)) * 0.85f) + 38.25f), (int) ((((float) Color.green(i5)) * 0.85f) + 38.25f), (int) ((((float) Color.blue(i5)) * 0.85f) + 38.25f));
        }

        public Colors(@ColorInt int i5, @ColorInt int i6) {
            this(i5, i6, 0);
        }

        public Colors(@ColorInt int i5, @ColorInt int i6, @ColorInt int i7) {
            this.color = i5;
            this.brightColor = i6 == i5 ? getBrightColor(i5) : i6;
            this.iconColor = i7;
        }
    }

    public SearchOrbView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static /* synthetic */ void a(SearchOrbView searchOrbView, ValueAnimator valueAnimator) {
        searchOrbView.getClass();
        searchOrbView.setSearchOrbZ(valueAnimator.getAnimatedFraction());
    }

    public static /* synthetic */ void b(SearchOrbView searchOrbView, ValueAnimator valueAnimator) {
        searchOrbView.getClass();
        searchOrbView.setOrbViewColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    private void startShadowFocusAnimation(boolean z4, int i5) {
        if (this.mShadowFocusAnimator == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.mShadowFocusAnimator = ofFloat;
            ofFloat.addUpdateListener(this.mFocusUpdateListener);
        }
        if (z4) {
            this.mShadowFocusAnimator.start();
        } else {
            this.mShadowFocusAnimator.reverse();
        }
        this.mShadowFocusAnimator.setDuration((long) i5);
    }

    private void updateColorAnimator() {
        ValueAnimator valueAnimator = this.mColorAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.mColorAnimator = null;
        }
        if (this.mColorAnimationEnabled && this.mAttachedToWindow) {
            ValueAnimator ofObject = ValueAnimator.ofObject(this.mColorEvaluator, new Object[]{Integer.valueOf(this.mColors.color), Integer.valueOf(this.mColors.brightColor), Integer.valueOf(this.mColors.color)});
            this.mColorAnimator = ofObject;
            ofObject.setRepeatCount(-1);
            this.mColorAnimator.setDuration((long) (this.mPulseDurationMs * 2));
            this.mColorAnimator.addUpdateListener(this.mUpdateListener);
            this.mColorAnimator.start();
        }
    }

    /* access modifiers changed from: package-private */
    public void animateOnFocus(boolean z4) {
        float f5;
        if (z4) {
            f5 = this.mFocusedZoom;
        } else {
            f5 = 1.0f;
        }
        this.mRootView.animate().scaleX(f5).scaleY(f5).setDuration((long) this.mScaleDurationMs).start();
        startShadowFocusAnimation(z4, this.mScaleDurationMs);
        enableOrbColorAnimation(z4);
    }

    public void enableOrbColorAnimation(boolean z4) {
        this.mColorAnimationEnabled = z4;
        updateColorAnimator();
    }

    /* access modifiers changed from: package-private */
    public float getFocusedZoom() {
        return this.mFocusedZoom;
    }

    /* access modifiers changed from: package-private */
    public int getLayoutResourceId() {
        return R.layout.lb_search_orb;
    }

    @ColorInt
    public int getOrbColor() {
        return this.mColors.color;
    }

    public Colors getOrbColors() {
        return this.mColors;
    }

    public Drawable getOrbIcon() {
        return this.mIconDrawable;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttachedToWindow = true;
        updateColorAnimator();
    }

    public void onClick(View view) {
        View.OnClickListener onClickListener = this.mListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.mAttachedToWindow = false;
        updateColorAnimator();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z4, int i5, Rect rect) {
        super.onFocusChanged(z4, i5, rect);
        animateOnFocus(z4);
    }

    /* access modifiers changed from: package-private */
    public void scaleOrbViewOnly(float f5) {
        this.mSearchOrbView.setScaleX(f5);
        this.mSearchOrbView.setScaleY(f5);
    }

    public void setOnOrbClickedListener(View.OnClickListener onClickListener) {
        this.mListener = onClickListener;
    }

    public void setOrbColor(int i5) {
        setOrbColors(new Colors(i5, i5, 0));
    }

    public void setOrbColors(Colors colors) {
        this.mColors = colors;
        this.mIcon.setColorFilter(colors.iconColor);
        if (this.mColorAnimator == null) {
            setOrbViewColor(this.mColors.color);
        } else {
            enableOrbColorAnimation(true);
        }
    }

    public void setOrbIcon(Drawable drawable) {
        this.mIconDrawable = drawable;
        this.mIcon.setImageDrawable(drawable);
    }

    /* access modifiers changed from: package-private */
    public void setOrbViewColor(int i5) {
        if (this.mSearchOrbView.getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) this.mSearchOrbView.getBackground()).setColor(i5);
        }
    }

    /* access modifiers changed from: package-private */
    public void setSearchOrbZ(float f5) {
        View view = this.mSearchOrbView;
        float f6 = this.mUnfocusedZ;
        ViewCompat.setZ(view, f6 + (f5 * (this.mFocusedZ - f6)));
    }

    public SearchOrbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchOrbViewStyle);
    }

    @Deprecated
    public void setOrbColor(@ColorInt int i5, @ColorInt int i6) {
        setOrbColors(new Colors(i5, i6, 0));
    }

    @SuppressLint({"CustomViewStyleable"})
    public SearchOrbView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mColorEvaluator = new ArgbEvaluator();
        this.mUpdateListener = new a(this);
        this.mFocusUpdateListener = new b(this);
        Resources resources = context.getResources();
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(getLayoutResourceId(), this, true);
        this.mRootView = inflate;
        this.mSearchOrbView = inflate.findViewById(R.id.search_orb);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.icon);
        this.mIcon = imageView;
        this.mFocusedZoom = context.getResources().getFraction(R.fraction.lb_search_orb_focused_zoom, 1, 1);
        this.mPulseDurationMs = context.getResources().getInteger(R.integer.lb_search_orb_pulse_duration_ms);
        this.mScaleDurationMs = context.getResources().getInteger(R.integer.lb_search_orb_scale_duration_ms);
        float dimensionPixelSize = (float) context.getResources().getDimensionPixelSize(R.dimen.lb_search_orb_focused_z);
        this.mFocusedZ = dimensionPixelSize;
        this.mUnfocusedZ = (float) context.getResources().getDimensionPixelSize(R.dimen.lb_search_orb_unfocused_z);
        int[] iArr = R.styleable.lbSearchOrbView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i5, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, i5, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.lbSearchOrbView_searchOrbIcon);
        setOrbIcon(drawable == null ? resources.getDrawable(R.drawable.lb_ic_in_app_search) : drawable);
        int color = obtainStyledAttributes.getColor(R.styleable.lbSearchOrbView_searchOrbColor, resources.getColor(R.color.lb_default_search_color));
        setOrbColors(new Colors(color, obtainStyledAttributes.getColor(R.styleable.lbSearchOrbView_searchOrbBrightColor, color), obtainStyledAttributes.getColor(R.styleable.lbSearchOrbView_searchOrbIconColor, 0)));
        obtainStyledAttributes.recycle();
        setFocusable(true);
        setClipChildren(false);
        setOnClickListener(this);
        setSoundEffectsEnabled(false);
        setSearchOrbZ(0.0f);
        ViewCompat.setZ(imageView, dimensionPixelSize);
    }
}
