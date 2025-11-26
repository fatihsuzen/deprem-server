package androidx.graphics.shapes;

import W2.s;
import W2.y;
import androidx.collection.MutableFloatList;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class DoubleMapper {
    public static final Companion Companion = new Companion((C2633k) null);
    public static final DoubleMapper Identity;
    private final MutableFloatList sourceValues;
    private final MutableFloatList targetValues;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Float valueOf = Float.valueOf(0.0f);
        s a5 = y.a(valueOf, valueOf);
        Float valueOf2 = Float.valueOf(0.5f);
        Identity = new DoubleMapper(a5, y.a(valueOf2, valueOf2));
    }

    public DoubleMapper(s... sVarArr) {
        t.e(sVarArr, "mappings");
        this.sourceValues = new MutableFloatList(sVarArr.length);
        this.targetValues = new MutableFloatList(sVarArr.length);
        int length = sVarArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            this.sourceValues.add(((Number) sVarArr[i5].c()).floatValue());
            this.targetValues.add(((Number) sVarArr[i5].d()).floatValue());
        }
        FloatMappingKt.validateProgress(this.sourceValues);
        FloatMappingKt.validateProgress(this.targetValues);
    }

    public final float map(float f5) {
        return FloatMappingKt.linearMap(this.sourceValues, this.targetValues, f5);
    }

    public final float mapBack(float f5) {
        return FloatMappingKt.linearMap(this.targetValues, this.sourceValues, f5);
    }
}
