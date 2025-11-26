package L3;

import H3.b;
import J3.f;
import K3.d;
import K3.e;
import java.util.Iterator;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public abstract class M0 extends C2119w {

    /* renamed from: b  reason: collision with root package name */
    private final f f18471b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public M0(b bVar) {
        super(bVar, (C2633k) null);
        t.e(bVar, "primitiveSerializer");
        this.f18471b = new L0(bVar.getDescriptor());
    }

    /* access modifiers changed from: protected */
    public final Iterator d(Object obj) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead");
    }

    public final Object deserialize(e eVar) {
        t.e(eVar, "decoder");
        return f(eVar, (Object) null);
    }

    public final f getDescriptor() {
        return this.f18471b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public final K0 a() {
        return (K0) k(r());
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public final int b(K0 k02) {
        t.e(k02, "<this>");
        return k02.d();
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public final void c(K0 k02, int i5) {
        t.e(k02, "<this>");
        k02.b(i5);
    }

    /* access modifiers changed from: protected */
    public abstract Object r();

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public final void n(K0 k02, int i5, Object obj) {
        t.e(k02, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead");
    }

    public final void serialize(K3.f fVar, Object obj) {
        t.e(fVar, "encoder");
        int e5 = e(obj);
        f fVar2 = this.f18471b;
        d beginCollection = fVar.beginCollection(fVar2, e5);
        u(beginCollection, obj, e5);
        beginCollection.endStructure(fVar2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public final Object l(K0 k02) {
        t.e(k02, "<this>");
        return k02.a();
    }

    /* access modifiers changed from: protected */
    public abstract void u(d dVar, Object obj, int i5);
}
