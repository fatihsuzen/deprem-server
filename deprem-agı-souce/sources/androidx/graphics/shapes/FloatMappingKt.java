package androidx.graphics.shapes;

import X2.C2250q;
import X2.J;
import androidx.collection.FloatList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.t;
import q3.C2728d;
import q3.C2729e;

public final class FloatMappingKt {
    public static final float linearMap(FloatList floatList, FloatList floatList2, float f5) {
        float f6;
        t.e(floatList, "xValues");
        t.e(floatList2, "yValues");
        if (0.0f > f5 || f5 > 1.0f) {
            throw new IllegalArgumentException(("Invalid progress: " + f5).toString());
        }
        Iterator it = C2729e.l(0, floatList._size).iterator();
        while (it.hasNext()) {
            int nextInt = ((J) it).nextInt();
            int i5 = nextInt + 1;
            if (progressInRange(f5, floatList.get(nextInt), floatList.get(i5 % floatList.getSize()))) {
                int size = i5 % floatList.getSize();
                float positiveModulo = Utils.positiveModulo(floatList.get(size) - floatList.get(nextInt), 1.0f);
                float positiveModulo2 = Utils.positiveModulo(floatList2.get(size) - floatList2.get(nextInt), 1.0f);
                if (positiveModulo < 0.001f) {
                    f6 = 0.5f;
                } else {
                    f6 = Utils.positiveModulo(f5 - floatList.get(nextInt), 1.0f) / positiveModulo;
                }
                return Utils.positiveModulo(floatList2.get(nextInt) + (positiveModulo2 * f6), 1.0f);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static final boolean progressInRange(float f5, float f6, float f7) {
        return f7 >= f6 ? f6 <= f5 && f5 <= f7 : f5 >= f6 || f5 <= f7;
    }

    public static final void validateProgress(FloatList floatList) {
        int i5;
        t.e(floatList, TtmlNode.TAG_P);
        Boolean bool = Boolean.TRUE;
        float[] fArr = floatList.content;
        int i6 = floatList._size;
        boolean z4 = false;
        int i7 = 0;
        while (true) {
            boolean z5 = true;
            if (i7 >= i6) {
                break;
            }
            float f5 = fArr[i7];
            if (!bool.booleanValue() || 0.0f > f5 || f5 > 1.0f) {
                z5 = false;
            }
            bool = Boolean.valueOf(z5);
            i7++;
        }
        if (bool.booleanValue()) {
            C2728d l5 = C2729e.l(1, floatList.getSize());
            if (!(l5 instanceof Collection) || !((Collection) l5).isEmpty()) {
                Iterator it = l5.iterator();
                i5 = 0;
                while (it.hasNext()) {
                    int nextInt = ((J) it).nextInt();
                    if (floatList.get(nextInt) < floatList.get(nextInt - 1) && (i5 = i5 + 1) < 0) {
                        C2250q.n();
                    }
                }
            } else {
                i5 = 0;
            }
            if (i5 <= 1) {
                z4 = true;
            }
            if (!z4) {
                throw new IllegalArgumentException(("FloatMapping - Progress wraps more than once: " + FloatList.joinToString$default(floatList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, 31, (Object) null)).toString());
            }
            return;
        }
        FloatList floatList2 = floatList;
        throw new IllegalArgumentException(("FloatMapping - Progress outside of range: " + FloatList.joinToString$default(floatList2, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, 31, (Object) null)).toString());
    }
}
