package L3;

import H3.b;
import H3.k;
import J3.a;
import J3.f;
import J3.o;
import K3.c;
import K3.e;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.p;
import X2.C2250q;
import java.util.List;
import kotlin.jvm.internal.t;

/* renamed from: L3.v0  reason: case insensitive filesystem */
public final class C2118v0 implements b {

    /* renamed from: a  reason: collision with root package name */
    private final Object f18594a;

    /* renamed from: b  reason: collision with root package name */
    private List f18595b = C2250q.g();

    /* renamed from: c  reason: collision with root package name */
    private final C2223l f18596c;

    public C2118v0(String str, Object obj) {
        t.e(str, "serialName");
        t.e(obj, "objectInstance");
        this.f18594a = obj;
        this.f18596c = m.a(p.PUBLICATION, new C2114t0(str, this));
    }

    /* access modifiers changed from: private */
    public static final f c(String str, C2118v0 v0Var) {
        return J3.m.h(str, o.d.f18393a, new f[0], new C2116u0(v0Var));
    }

    /* access modifiers changed from: private */
    public static final J d(C2118v0 v0Var, a aVar) {
        t.e(aVar, "$this$buildSerialDescriptor");
        aVar.h(v0Var.f18595b);
        return J.f19942a;
    }

    public Object deserialize(e eVar) {
        int decodeElementIndex;
        t.e(eVar, "decoder");
        f descriptor = getDescriptor();
        c beginStructure = eVar.beginStructure(descriptor);
        if (!beginStructure.decodeSequentially() && (decodeElementIndex = beginStructure.decodeElementIndex(getDescriptor())) != -1) {
            throw new k("Unexpected index " + decodeElementIndex);
        }
        J j5 = J.f19942a;
        beginStructure.endStructure(descriptor);
        return this.f18594a;
    }

    public f getDescriptor() {
        return (f) this.f18596c.getValue();
    }

    public void serialize(K3.f fVar, Object obj) {
        t.e(fVar, "encoder");
        t.e(obj, "value");
        fVar.beginStructure(getDescriptor()).endStructure(getDescriptor());
    }
}
