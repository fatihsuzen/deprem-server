package K3;

import J3.f;
import O3.d;
import kotlin.jvm.internal.t;

public interface c {

    public static final class a {
        public static int a(c cVar, f fVar) {
            t.e(fVar, "descriptor");
            return -1;
        }

        public static boolean b(c cVar) {
            return false;
        }

        public static /* synthetic */ Object c(c cVar, f fVar, int i5, H3.a aVar, Object obj, int i6, Object obj2) {
            if (obj2 == null) {
                if ((i6 & 8) != 0) {
                    obj = null;
                }
                return cVar.decodeSerializableElement(fVar, i5, aVar, obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableElement");
        }
    }

    boolean decodeBooleanElement(f fVar, int i5);

    byte decodeByteElement(f fVar, int i5);

    char decodeCharElement(f fVar, int i5);

    int decodeCollectionSize(f fVar);

    double decodeDoubleElement(f fVar, int i5);

    int decodeElementIndex(f fVar);

    float decodeFloatElement(f fVar, int i5);

    e decodeInlineElement(f fVar, int i5);

    int decodeIntElement(f fVar, int i5);

    long decodeLongElement(f fVar, int i5);

    Object decodeNullableSerializableElement(f fVar, int i5, H3.a aVar, Object obj);

    boolean decodeSequentially();

    Object decodeSerializableElement(f fVar, int i5, H3.a aVar, Object obj);

    short decodeShortElement(f fVar, int i5);

    String decodeStringElement(f fVar, int i5);

    void endStructure(f fVar);

    d getSerializersModule();
}
