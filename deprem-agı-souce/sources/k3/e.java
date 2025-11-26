package K3;

import J3.f;
import kotlin.jvm.internal.t;

public interface e {

    public static final class a {
        public static Object a(e eVar, H3.a aVar) {
            t.e(aVar, "deserializer");
            if (aVar.getDescriptor().c() || eVar.decodeNotNullMark()) {
                return eVar.decodeSerializableValue(aVar);
            }
            return eVar.decodeNull();
        }

        public static Object b(e eVar, H3.a aVar) {
            t.e(aVar, "deserializer");
            return aVar.deserialize(eVar);
        }
    }

    c beginStructure(f fVar);

    boolean decodeBoolean();

    byte decodeByte();

    char decodeChar();

    double decodeDouble();

    int decodeEnum(f fVar);

    float decodeFloat();

    e decodeInline(f fVar);

    int decodeInt();

    long decodeLong();

    boolean decodeNotNullMark();

    Void decodeNull();

    Object decodeSerializableValue(H3.a aVar);

    short decodeShort();

    String decodeString();
}
