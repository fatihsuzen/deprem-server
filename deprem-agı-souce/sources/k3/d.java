package K3;

import H3.l;
import J3.f;
import kotlin.jvm.internal.t;

public interface d {

    public static final class a {
        public static boolean a(d dVar, f fVar, int i5) {
            t.e(fVar, "descriptor");
            return true;
        }
    }

    void encodeBooleanElement(f fVar, int i5, boolean z4);

    void encodeByteElement(f fVar, int i5, byte b5);

    void encodeCharElement(f fVar, int i5, char c5);

    void encodeDoubleElement(f fVar, int i5, double d5);

    void encodeFloatElement(f fVar, int i5, float f5);

    f encodeInlineElement(f fVar, int i5);

    void encodeIntElement(f fVar, int i5, int i6);

    void encodeLongElement(f fVar, int i5, long j5);

    void encodeNullableSerializableElement(f fVar, int i5, l lVar, Object obj);

    void encodeSerializableElement(f fVar, int i5, l lVar, Object obj);

    void encodeShortElement(f fVar, int i5, short s5);

    void encodeStringElement(f fVar, int i5, String str);

    void endStructure(f fVar);

    boolean shouldEncodeElementDefault(f fVar, int i5);
}
