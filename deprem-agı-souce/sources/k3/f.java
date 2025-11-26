package K3;

import H3.l;
import O3.d;
import kotlin.jvm.internal.t;

public interface f {
    d beginCollection(J3.f fVar, int i5);

    d beginStructure(J3.f fVar);

    void encodeBoolean(boolean z4);

    void encodeByte(byte b5);

    void encodeChar(char c5);

    void encodeDouble(double d5);

    void encodeEnum(J3.f fVar, int i5);

    void encodeFloat(float f5);

    f encodeInline(J3.f fVar);

    void encodeInt(int i5);

    void encodeLong(long j5);

    void encodeNotNullMark();

    void encodeNull();

    void encodeSerializableValue(l lVar, Object obj);

    void encodeShort(short s5);

    void encodeString(String str);

    d getSerializersModule();

    public static final class a {
        public static d a(f fVar, J3.f fVar2, int i5) {
            t.e(fVar2, "descriptor");
            return fVar.beginStructure(fVar2);
        }

        public static void c(f fVar, l lVar, Object obj) {
            t.e(lVar, "serializer");
            if (lVar.getDescriptor().c()) {
                fVar.encodeSerializableValue(lVar, obj);
            } else if (obj == null) {
                fVar.encodeNull();
            } else {
                fVar.encodeNotNullMark();
                fVar.encodeSerializableValue(lVar, obj);
            }
        }

        public static void d(f fVar, l lVar, Object obj) {
            t.e(lVar, "serializer");
            lVar.serialize(fVar, obj);
        }

        public static void b(f fVar) {
        }
    }
}
