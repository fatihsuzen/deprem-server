package com.mbridge.msdk.dycreator.baseview.rewardpopview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class MBGradientAndShadowTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private int f8579a = AcquireRewardPopViewConst.DEFAULT_COLOR_FFFBED;

    /* renamed from: b  reason: collision with root package name */
    private int f8580b = AcquireRewardPopViewConst.DEFAULT_COLOR_FFBD6F;

    /* renamed from: c  reason: collision with root package name */
    private int f8581c = AcquireRewardPopViewConst.DEFAULT_COLOR_EC7501;

    /* renamed from: d  reason: collision with root package name */
    private int f8582d = 40;

    /* renamed from: e  reason: collision with root package name */
    private LinearGradient f8583e;
    public float mShadowDx = 1.5f;
    public float mShadowDy = 1.8f;
    public float mShadowRadius = 3.0f;

    public static class GradientAndShadowParameters {
        public int gradientEndColor;
        public int gradientStartColor;
        public int shadowColor;
        public float shadowDx = 1.5f;
        public float shadowDy = 1.8f;
        public float shadowRadius = 3.0f;
        public int textSize = 40;
    }

    public MBGradientAndShadowTextView(Context context) {
        super(context);
        a();
    }

    private void a() {
        setTextSize((float) this.f8582d);
        setTypeface(Typeface.defaultFromStyle(3));
        this.f8583e = new LinearGradient(0.0f, 0.0f, 0.0f, getTextSize(), this.f8579a, this.f8580b, Shader.TileMode.CLAMP);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        getPaint().setShader((Shader) null);
        getPaint().setShadowLayer(3.0f, 1.5f, 1.8f, this.f8581c);
        super.onDraw(canvas);
        getPaint().clearShadowLayer();
        getPaint().setShader(this.f8583e);
        super.onDraw(canvas);
    }

    public MBGradientAndShadowTextView(Context context, GradientAndShadowParameters gradientAndShadowParameters) {
        super(context);
        if (gradientAndShadowParameters != null) {
            this.f8579a = gradientAndShadowParameters.gradientStartColor;
            this.f8580b = gradientAndShadowParameters.gradientEndColor;
            this.f8581c = gradientAndShadowParameters.shadowColor;
            this.f8582d = gradientAndShadowParameters.textSize;
            this.mShadowRadius = gradientAndShadowParameters.shadowRadius;
            this.mShadowDx = gradientAndShadowParameters.shadowDx;
            this.mShadowDy = gradientAndShadowParameters.shadowDy;
        }
        a();
    }

    public MBGradientAndShadowTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBGradientAndShadowTextView(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }

    @RequiresApi(api = 21)
    public MBGradientAndShadowTextView(Context context, @Nullable AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
    }
}
