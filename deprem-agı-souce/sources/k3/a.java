package K3;

import H3.k;
import J3.f;
import K3.c;
import K3.e;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;

public abstract class a implements e, c {
    public static /* synthetic */ Object decodeSerializableValue$default(a aVar, H3.a aVar2, Object obj, int i5, Object obj2) {
        if (obj2 == null) {
            if ((i5 & 2) != 0) {
                obj = null;
            }
            return aVar.decodeSerializableValue(aVar2, obj);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableValue");
    }

    public c beginStructure(f fVar) {
        t.e(fVar, "descriptor");
        return this;
    }

    public boolean decodeBoolean() {
        Object decodeValue = decodeValue();
        t.c(decodeValue, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) decodeValue).booleanValue();
    }

    public final boolean decodeBooleanElement(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return decodeBoolean();
    }

    public byte decodeByte() {
        Object decodeValue = decodeValue();
        t.c(decodeValue, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) decodeValue).byteValue();
    }

    public final byte decodeByteElement(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return decodeByte();
    }

    public char decodeChar() {
        Object decodeValue = decodeValue();
        t.c(decodeValue, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) decodeValue).charValue();
    }

    public final char decodeCharElement(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return decodeChar();
    }

    public int decodeCollectionSize(f fVar) {
        return c.a.a(this, fVar);
    }

    public double decodeDouble() {
        Object decodeValue = decodeValue();
        t.c(decodeValue, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) decodeValue).doubleValue();
    }

    public final double decodeDoubleElement(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return decodeDouble();
    }

    public int decodeEnum(f fVar) {
        t.e(fVar, "enumDescriptor");
        Object decodeValue = decodeValue();
        t.c(decodeValue, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) decodeValue).intValue();
    }

    public float decodeFloat() {
        Object decodeValue = decodeValue();
        t.c(decodeValue, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) decodeValue).floatValue();
    }

    public final float decodeFloatElement(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return decodeFloat();
    }

    public e decodeInline(f fVar) {
        t.e(fVar, "descriptor");
        return this;
    }

    public e decodeInlineElement(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return decodeInline(fVar.h(i5));
    }

    public int decodeInt() {
        Object decodeValue = decodeValue();
        t.c(decodeValue, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) decodeValue).intValue();
    }

    public final int decodeIntElement(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return decodeInt();
    }

    public long decodeLong() {
        Object decodeValue = decodeValue();
        t.c(decodeValue, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) decodeValue).longValue();
    }

    public final long decodeLongElement(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return decodeLong();
    }

    public boolean decodeNotNullMark() {
        return true;
    }

    public Void decodeNull() {
        return null;
    }

    public final <T> T decodeNullableSerializableElement(f fVar, int i5, H3.a aVar, T t5) {
        t.e(fVar, "descriptor");
        t.e(aVar, "deserializer");
        if (aVar.getDescriptor().c() || decodeNotNullMark()) {
            return decodeSerializableValue(aVar, t5);
        }
        return decodeNull();
    }

    public <T> T decodeNullableSerializableValue(H3.a aVar) {
        return e.a.a(this, aVar);
    }

    public boolean decodeSequentially() {
        return c.a.b(this);
    }

    public <T> T decodeSerializableElement(f fVar, int i5, H3.a aVar, T t5) {
        t.e(fVar, "descriptor");
        t.e(aVar, "deserializer");
        return decodeSerializableValue(aVar, t5);
    }

    public <T> T decodeSerializableValue(H3.a aVar) {
        return e.a.b(this, aVar);
    }

    public short decodeShort() {
        Object decodeValue = decodeValue();
        t.c(decodeValue, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) decodeValue).shortValue();
    }

    public final short decodeShortElement(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return decodeShort();
    }

    public String decodeString() {
        Object decodeValue = decodeValue();
        t.c(decodeValue, "null cannot be cast to non-null type kotlin.String");
        return (String) decodeValue;
    }

    public final String decodeStringElement(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return decodeString();
    }

    public Object decodeValue() {
        throw new k(M.b(getClass()) + " can't retrieve untyped values");
    }

    public void endStructure(f fVar) {
        t.e(fVar, "descriptor");
    }

    public <T> T decodeSerializableValue(H3.a aVar, T t5) {
        t.e(aVar, "deserializer");
        return decodeSerializableValue(aVar);
    }
}
