package androidx.graphics.shapes;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class MutableCubic extends Cubic {
    public MutableCubic() {
        super((float[]) null, 1, (C2633k) null);
    }

    private final void transformOnePoint(PointTransformer pointTransformer, int i5) {
        int i6 = i5 + 1;
        long r02 = pointTransformer.m48transformXgqJiTY(getPoints$graphics_shapes_release()[i5], getPoints$graphics_shapes_release()[i6]);
        getPoints$graphics_shapes_release()[i5] = Float.intBitsToFloat((int) (r02 >> 32));
        getPoints$graphics_shapes_release()[i6] = Float.intBitsToFloat((int) (r02 & 4294967295L));
    }

    public final void interpolate(Cubic cubic, Cubic cubic2, float f5) {
        t.e(cubic, "c1");
        t.e(cubic2, "c2");
        for (int i5 = 0; i5 < 8; i5++) {
            getPoints$graphics_shapes_release()[i5] = Utils.interpolate(cubic.getPoints$graphics_shapes_release()[i5], cubic2.getPoints$graphics_shapes_release()[i5], f5);
        }
    }

    public final void transform(PointTransformer pointTransformer) {
        t.e(pointTransformer, "f");
        transformOnePoint(pointTransformer, 0);
        transformOnePoint(pointTransformer, 2);
        transformOnePoint(pointTransformer, 4);
        transformOnePoint(pointTransformer, 6);
    }
}
