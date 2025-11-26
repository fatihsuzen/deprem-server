package L3;

import H3.b;
import H3.k;
import J3.a;
import J3.f;
import J3.m;
import K3.c;
import K3.d;
import K3.e;
import W2.J;
import W2.x;
import java.util.List;
import kotlin.jvm.internal.t;

public final class b1 implements b {

    /* renamed from: a  reason: collision with root package name */
    private final b f18509a;

    /* renamed from: b  reason: collision with root package name */
    private final b f18510b;

    /* renamed from: c  reason: collision with root package name */
    private final b f18511c;

    /* renamed from: d  reason: collision with root package name */
    private final f f18512d = m.e("kotlin.Triple", new f[0], new a1(this));

    public b1(b bVar, b bVar2, b bVar3) {
        t.e(bVar, "aSerializer");
        t.e(bVar2, "bSerializer");
        t.e(bVar3, "cSerializer");
        this.f18509a = bVar;
        this.f18510b = bVar2;
        this.f18511c = bVar3;
    }

    private final x b(c cVar) {
        c cVar2 = cVar;
        Object c5 = c.a.c(cVar2, getDescriptor(), 0, this.f18509a, (Object) null, 8, (Object) null);
        Object c6 = c.a.c(cVar2, getDescriptor(), 1, this.f18510b, (Object) null, 8, (Object) null);
        Object c7 = c.a.c(cVar2, getDescriptor(), 2, this.f18511c, (Object) null, 8, (Object) null);
        cVar2.endStructure(getDescriptor());
        return new x(c5, c6, c7);
    }

    private final x c(c cVar) {
        c cVar2;
        Object a5 = c1.f18513a;
        Object a6 = c1.f18513a;
        Object a7 = c1.f18513a;
        while (true) {
            int decodeElementIndex = cVar.decodeElementIndex(getDescriptor());
            if (decodeElementIndex != -1) {
                if (decodeElementIndex == 0) {
                    cVar2 = cVar;
                    a5 = c.a.c(cVar2, getDescriptor(), 0, this.f18509a, (Object) null, 8, (Object) null);
                } else if (decodeElementIndex == 1) {
                    cVar2 = cVar;
                    a6 = c.a.c(cVar2, getDescriptor(), 1, this.f18510b, (Object) null, 8, (Object) null);
                } else if (decodeElementIndex == 2) {
                    a7 = c.a.c(cVar, getDescriptor(), 2, this.f18511c, (Object) null, 8, (Object) null);
                } else {
                    throw new k("Unexpected index " + decodeElementIndex);
                }
                cVar = cVar2;
            } else {
                cVar.endStructure(getDescriptor());
                if (a5 == c1.f18513a) {
                    throw new k("Element 'first' is missing");
                } else if (a6 == c1.f18513a) {
                    throw new k("Element 'second' is missing");
                } else if (a7 != c1.f18513a) {
                    return new x(a5, a6, a7);
                } else {
                    throw new k("Element 'third' is missing");
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final J d(b1 b1Var, a aVar) {
        t.e(aVar, "$this$buildClassSerialDescriptor");
        a aVar2 = aVar;
        a.b(aVar2, "first", b1Var.f18509a.getDescriptor(), (List) null, false, 12, (Object) null);
        a.b(aVar2, "second", b1Var.f18510b.getDescriptor(), (List) null, false, 12, (Object) null);
        a.b(aVar2, "third", b1Var.f18511c.getDescriptor(), (List) null, false, 12, (Object) null);
        return J.f19942a;
    }

    /* renamed from: e */
    public x deserialize(e eVar) {
        t.e(eVar, "decoder");
        c beginStructure = eVar.beginStructure(getDescriptor());
        if (beginStructure.decodeSequentially()) {
            return b(beginStructure);
        }
        return c(beginStructure);
    }

    /* renamed from: f */
    public void serialize(K3.f fVar, x xVar) {
        t.e(fVar, "encoder");
        t.e(xVar, "value");
        d beginStructure = fVar.beginStructure(getDescriptor());
        beginStructure.encodeSerializableElement(getDescriptor(), 0, this.f18509a, xVar.a());
        beginStructure.encodeSerializableElement(getDescriptor(), 1, this.f18510b, xVar.b());
        beginStructure.encodeSerializableElement(getDescriptor(), 2, this.f18511c, xVar.c());
        beginStructure.endStructure(getDescriptor());
    }

    public f getDescriptor() {
        return this.f18512d;
    }
}
