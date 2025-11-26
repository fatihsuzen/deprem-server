package androidx.core.content.res;

import androidx.annotation.NonNull;

final class ViewingConditions {
    static final ViewingConditions DEFAULT = make(CamUtils.WHITE_POINT_D65, (float) ((((double) CamUtils.yFromLStar(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    private final float mAw;
    private final float mC;
    private final float mFl;
    private final float mFlRoot;
    private final float mN;
    private final float mNbb;
    private final float mNc;
    private final float mNcb;
    private final float[] mRgbD;
    private final float mZ;

    private ViewingConditions(float f5, float f6, float f7, float f8, float f9, float f10, float[] fArr, float f11, float f12, float f13) {
        this.mN = f5;
        this.mAw = f6;
        this.mNbb = f7;
        this.mNcb = f8;
        this.mC = f9;
        this.mNc = f10;
        this.mRgbD = fArr;
        this.mFl = f11;
        this.mFlRoot = f12;
        this.mZ = f13;
    }

    @NonNull
    static ViewingConditions make(@NonNull float[] fArr, float f5, float f6, float f7, boolean z4) {
        float lerp;
        float f8;
        float f9 = f5;
        float[][] fArr2 = CamUtils.XYZ_TO_CAM16RGB;
        float f10 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f11 = fArr[1];
        float f12 = fArr[2];
        float f13 = (fArr3[0] * f10) + (fArr3[1] * f11) + (fArr3[2] * f12);
        float[] fArr4 = fArr2[1];
        float f14 = (fArr4[0] * f10) + (fArr4[1] * f11) + (fArr4[2] * f12);
        float[] fArr5 = fArr2[2];
        float f15 = (f10 * fArr5[0]) + (f11 * fArr5[1]) + (f12 * fArr5[2]);
        float f16 = (f7 / 10.0f) + 0.8f;
        if (((double) f16) >= 0.9d) {
            lerp = CamUtils.lerp(0.59f, 0.69f, (f16 - 0.9f) * 10.0f);
        } else {
            lerp = CamUtils.lerp(0.525f, 0.59f, (f16 - 0.8f) * 10.0f);
        }
        float f17 = lerp;
        if (z4) {
            f8 = 1.0f;
        } else {
            f8 = (1.0f - (((float) Math.exp((double) (((-f9) - 42.0f) / 92.0f))) * 0.2777778f)) * f16;
        }
        double d5 = (double) f8;
        if (d5 > 1.0d) {
            f8 = 1.0f;
        } else if (d5 < 0.0d) {
            f8 = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f13) * f8) + 1.0f) - f8, (((100.0f / f14) * f8) + 1.0f) - f8, (((100.0f / f15) * f8) + 1.0f) - f8};
        float f18 = 1.0f / ((5.0f * f9) + 1.0f);
        float f19 = f18 * f18 * f18 * f18;
        float f20 = 1.0f - f19;
        float cbrt = (f19 * f9) + (0.1f * f20 * f20 * ((float) Math.cbrt(((double) f9) * 5.0d)));
        float yFromLStar = CamUtils.yFromLStar(f6) / fArr[1];
        double d6 = (double) yFromLStar;
        float sqrt = ((float) Math.sqrt(d6)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d6, 0.2d));
        float[] fArr7 = {(float) Math.pow(((double) ((fArr6[0] * cbrt) * f13)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[1] * cbrt) * f14)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[2] * cbrt) * f15)) / 100.0d, 0.42d)};
        float f21 = fArr7[0];
        float f22 = (f21 * 400.0f) / (f21 + 27.13f);
        float f23 = fArr7[1];
        float f24 = (f23 * 400.0f) / (f23 + 27.13f);
        float f25 = fArr7[2];
        float[] fArr8 = {f22, f24, (400.0f * f25) / (f25 + 27.13f)};
        return new ViewingConditions(yFromLStar, ((fArr8[0] * 2.0f) + fArr8[1] + (fArr8[2] * 0.05f)) * pow, pow, pow, f17, f16, fArr6, cbrt, (float) Math.pow((double) cbrt, 0.25d), sqrt);
    }

    /* access modifiers changed from: package-private */
    public float getAw() {
        return this.mAw;
    }

    /* access modifiers changed from: package-private */
    public float getC() {
        return this.mC;
    }

    /* access modifiers changed from: package-private */
    public float getFl() {
        return this.mFl;
    }

    /* access modifiers changed from: package-private */
    public float getFlRoot() {
        return this.mFlRoot;
    }

    /* access modifiers changed from: package-private */
    public float getN() {
        return this.mN;
    }

    /* access modifiers changed from: package-private */
    public float getNbb() {
        return this.mNbb;
    }

    /* access modifiers changed from: package-private */
    public float getNc() {
        return this.mNc;
    }

    /* access modifiers changed from: package-private */
    public float getNcb() {
        return this.mNcb;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public float[] getRgbD() {
        return this.mRgbD;
    }

    /* access modifiers changed from: package-private */
    public float getZ() {
        return this.mZ;
    }
}
