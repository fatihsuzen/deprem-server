package androidx.graphics.shapes;

import android.graphics.Matrix;
import androidx.collection.FloatFloatPair;

final class Shapes_androidKt$transformed$1 implements PointTransformer {
    final /* synthetic */ Matrix $matrix;
    final /* synthetic */ float[] $tempArray;

    Shapes_androidKt$transformed$1(float[] fArr, Matrix matrix) {
        this.$tempArray = fArr;
        this.$matrix = matrix;
    }

    /* renamed from: transform-XgqJiTY  reason: not valid java name */
    public final long m59transformXgqJiTY(float f5, float f6) {
        float[] fArr = this.$tempArray;
        fArr[0] = f5;
        fArr[1] = f6;
        this.$matrix.mapPoints(fArr);
        float[] fArr2 = this.$tempArray;
        return FloatFloatPair.m3constructorimpl(fArr2[0], fArr2[1]);
    }
}
