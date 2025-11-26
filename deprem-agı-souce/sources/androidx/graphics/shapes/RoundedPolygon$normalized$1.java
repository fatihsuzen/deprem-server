package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;

final class RoundedPolygon$normalized$1 implements PointTransformer {
    final /* synthetic */ float $offsetX;
    final /* synthetic */ float $offsetY;
    final /* synthetic */ float $side;

    RoundedPolygon$normalized$1(float f5, float f6, float f7) {
        this.$offsetX = f5;
        this.$side = f6;
        this.$offsetY = f7;
    }

    /* renamed from: transform-XgqJiTY  reason: not valid java name */
    public final long m58transformXgqJiTY(float f5, float f6) {
        float f7 = f5 + this.$offsetX;
        float f8 = this.$side;
        return FloatFloatPair.m3constructorimpl(f7 / f8, (f6 + this.$offsetY) / f8);
    }
}
