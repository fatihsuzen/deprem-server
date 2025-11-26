package L3;

import H3.a;
import H3.b;
import H3.h;
import H3.k;
import H3.l;
import K3.c;
import K3.d;
import K3.e;
import K3.f;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import r3.C2733c;

/* renamed from: L3.b  reason: case insensitive filesystem */
public abstract class C2078b implements b {
    /* access modifiers changed from: private */
    public final Object b(c cVar) {
        return c.a.c(cVar, getDescriptor(), 1, h.a(this, cVar, cVar.decodeStringElement(getDescriptor(), 0)), (Object) null, 8, (Object) null);
    }

    public a c(c cVar, String str) {
        t.e(cVar, "decoder");
        return cVar.getSerializersModule().e(e(), str);
    }

    public l d(f fVar, Object obj) {
        t.e(fVar, "encoder");
        t.e(obj, "value");
        return fVar.getSerializersModule().f(e(), obj);
    }

    public final Object deserialize(e eVar) {
        Object obj;
        t.e(eVar, "decoder");
        J3.f descriptor = getDescriptor();
        c beginStructure = eVar.beginStructure(descriptor);
        L l5 = new L();
        if (beginStructure.decodeSequentially()) {
            obj = b(beginStructure);
        } else {
            Object obj2 = null;
            while (true) {
                int decodeElementIndex = beginStructure.decodeElementIndex(getDescriptor());
                if (decodeElementIndex != -1) {
                    if (decodeElementIndex == 0) {
                        l5.f24690a = beginStructure.decodeStringElement(getDescriptor(), decodeElementIndex);
                    } else if (decodeElementIndex != 1) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Invalid index in polymorphic deserialization of ");
                        String str = (String) l5.f24690a;
                        if (str == null) {
                            str = "unknown class";
                        }
                        sb.append(str);
                        sb.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                        sb.append(decodeElementIndex);
                        throw new k(sb.toString());
                    } else {
                        Object obj3 = l5.f24690a;
                        if (obj3 != null) {
                            l5.f24690a = obj3;
                            obj2 = c.a.c(beginStructure, getDescriptor(), decodeElementIndex, h.a(this, beginStructure, (String) obj3), (Object) null, 8, (Object) null);
                        } else {
                            throw new IllegalArgumentException("Cannot read polymorphic value before its type token");
                        }
                    }
                } else if (obj2 != null) {
                    t.c(obj2, "null cannot be cast to non-null type T of kotlinx.serialization.internal.AbstractPolymorphicSerializer");
                    obj = obj2;
                } else {
                    throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) l5.f24690a)).toString());
                }
            }
        }
        beginStructure.endStructure(descriptor);
        return obj;
    }

    public abstract C2733c e();

    public final void serialize(f fVar, Object obj) {
        t.e(fVar, "encoder");
        t.e(obj, "value");
        l b5 = h.b(this, fVar, obj);
        J3.f descriptor = getDescriptor();
        d beginStructure = fVar.beginStructure(descriptor);
        beginStructure.encodeStringElement(getDescriptor(), 0, b5.getDescriptor().a());
        J3.f descriptor2 = getDescriptor();
        t.c(b5, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        beginStructure.encodeSerializableElement(descriptor2, 1, b5, obj);
        beginStructure.endStructure(descriptor);
    }
}
