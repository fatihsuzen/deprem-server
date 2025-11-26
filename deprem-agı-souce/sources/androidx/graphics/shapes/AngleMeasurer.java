package androidx.graphics.shapes;

import kotlin.jvm.internal.t;

public final class AngleMeasurer implements Measurer {
    private final float centerX;
    private final float centerY;

    public AngleMeasurer(float f5, float f6) {
        this.centerX = f5;
        this.centerY = f6;
    }

    /* access modifiers changed from: private */
    public static final float findCubicCutPoint$lambda$1(Cubic cubic, AngleMeasurer angleMeasurer, float f5, float f6, float f7) {
        t.e(cubic, "$c");
        t.e(angleMeasurer, "this$0");
        long r02 = cubic.m27pointOnCurveOOQOV4g$graphics_shapes_release(f7);
        return Math.abs(Utils.positiveModulo(Utils.angle(PointKt.m39getXDnnuFBc(r02) - angleMeasurer.centerX, PointKt.m40getYDnnuFBc(r02) - angleMeasurer.centerY) - f5, Utils.getTwoPi()) - f6);
    }

    public float findCubicCutPoint(Cubic cubic, float f5) {
        t.e(cubic, "c");
        return Utils.findMinimum(0.0f, 1.0f, 1.0E-5f, new a(cubic, this, Utils.angle(cubic.getAnchor0X() - this.centerX, cubic.getAnchor0Y() - this.centerY), f5));
    }

    public final float getCenterX() {
        return this.centerX;
    }

    public final float getCenterY() {
        return this.centerY;
    }

    public float measureCubic(Cubic cubic) {
        t.e(cubic, "c");
        float positiveModulo = Utils.positiveModulo(Utils.angle(cubic.getAnchor1X() - this.centerX, cubic.getAnchor1Y() - this.centerY) - Utils.angle(cubic.getAnchor0X() - this.centerX, cubic.getAnchor0Y() - this.centerY), Utils.getTwoPi());
        if (positiveModulo > Utils.getTwoPi() - 1.0E-4f) {
            return 0.0f;
        }
        return positiveModulo;
    }
}
