package K3;

import H3.k;
import H3.l;
import J3.f;
import K3.d;
import K3.f;
import L3.C2107p0;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;

public abstract class b implements f, d {
    public d beginCollection(f fVar, int i5) {
        return f.a.a(this, fVar, i5);
    }

    public d beginStructure(J3.f fVar) {
        t.e(fVar, "descriptor");
        return this;
    }

    public abstract void encodeBoolean(boolean z4);

    public final void encodeBooleanElement(J3.f fVar, int i5, boolean z4) {
        t.e(fVar, "descriptor");
        if (encodeElement(fVar, i5)) {
            encodeBoolean(z4);
        }
    }

    public abstract void encodeByte(byte b5);

    public final void encodeByteElement(J3.f fVar, int i5, byte b5) {
        t.e(fVar, "descriptor");
        if (encodeElement(fVar, i5)) {
            encodeByte(b5);
        }
    }

    public abstract void encodeChar(char c5);

    public final void encodeCharElement(J3.f fVar, int i5, char c5) {
        t.e(fVar, "descriptor");
        if (encodeElement(fVar, i5)) {
            encodeChar(c5);
        }
    }

    public abstract void encodeDouble(double d5);

    public final void encodeDoubleElement(J3.f fVar, int i5, double d5) {
        t.e(fVar, "descriptor");
        if (encodeElement(fVar, i5)) {
            encodeDouble(d5);
        }
    }

    public boolean encodeElement(J3.f fVar, int i5) {
        t.e(fVar, "descriptor");
        return true;
    }

    public abstract void encodeFloat(float f5);

    public final void encodeFloatElement(J3.f fVar, int i5, float f5) {
        t.e(fVar, "descriptor");
        if (encodeElement(fVar, i5)) {
            encodeFloat(f5);
        }
    }

    public f encodeInline(J3.f fVar) {
        t.e(fVar, "descriptor");
        return this;
    }

    public final f encodeInlineElement(J3.f fVar, int i5) {
        t.e(fVar, "descriptor");
        if (encodeElement(fVar, i5)) {
            return encodeInline(fVar.h(i5));
        }
        return C2107p0.f18569a;
    }

    public abstract void encodeInt(int i5);

    public final void encodeIntElement(J3.f fVar, int i5, int i6) {
        t.e(fVar, "descriptor");
        if (encodeElement(fVar, i5)) {
            encodeInt(i6);
        }
    }

    public abstract void encodeLong(long j5);

    public final void encodeLongElement(J3.f fVar, int i5, long j5) {
        t.e(fVar, "descriptor");
        if (encodeElement(fVar, i5)) {
            encodeLong(j5);
        }
    }

    public void encodeNotNullMark() {
        f.a.b(this);
    }

    public <T> void encodeNullableSerializableElement(J3.f fVar, int i5, l lVar, T t5) {
        t.e(fVar, "descriptor");
        t.e(lVar, "serializer");
        if (encodeElement(fVar, i5)) {
            encodeNullableSerializableValue(lVar, t5);
        }
    }

    public <T> void encodeNullableSerializableValue(l lVar, T t5) {
        f.a.c(this, lVar, t5);
    }

    public <T> void encodeSerializableElement(J3.f fVar, int i5, l lVar, T t5) {
        t.e(fVar, "descriptor");
        t.e(lVar, "serializer");
        if (encodeElement(fVar, i5)) {
            encodeSerializableValue(lVar, t5);
        }
    }

    public void encodeSerializableValue(l lVar, Object obj) {
        f.a.d(this, lVar, obj);
    }

    public abstract void encodeShort(short s5);

    public final void encodeShortElement(J3.f fVar, int i5, short s5) {
        t.e(fVar, "descriptor");
        if (encodeElement(fVar, i5)) {
            encodeShort(s5);
        }
    }

    public abstract void encodeString(String str);

    public final void encodeStringElement(J3.f fVar, int i5, String str) {
        t.e(fVar, "descriptor");
        t.e(str, "value");
        if (encodeElement(fVar, i5)) {
            encodeString(str);
        }
    }

    public void encodeValue(Object obj) {
        t.e(obj, "value");
        throw new k("Non-serializable " + M.b(obj.getClass()) + " is not supported by " + M.b(getClass()) + " encoder");
    }

    public void endStructure(J3.f fVar) {
        t.e(fVar, "descriptor");
    }

    public boolean shouldEncodeElementDefault(J3.f fVar, int i5) {
        return d.a.a(this, fVar, i5);
    }
}
