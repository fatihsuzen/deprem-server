package L3;

import H3.b;
import I3.a;
import K3.c;
import K3.d;
import W2.D;
import W2.E;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class k1 extends M0 implements b {

    /* renamed from: c  reason: collision with root package name */
    public static final k1 f18552c = new k1();

    private k1() {
        super(a.w(D.f19931b));
    }

    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((E) obj).v());
    }

    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((E) obj).v());
    }

    public /* bridge */ /* synthetic */ Object r() {
        return E.c(w());
    }

    public /* bridge */ /* synthetic */ void u(d dVar, Object obj, int i5) {
        z(dVar, ((E) obj).v(), i5);
    }

    /* access modifiers changed from: protected */
    public int v(long[] jArr) {
        t.e(jArr, "$this$collectionSize");
        return E.p(jArr);
    }

    /* access modifiers changed from: protected */
    public long[] w() {
        return E.f(0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(c cVar, int i5, j1 j1Var, boolean z4) {
        t.e(cVar, "decoder");
        t.e(j1Var, "builder");
        j1Var.e(D.b(cVar.decodeInlineElement(getDescriptor(), i5).decodeLong()));
    }

    /* access modifiers changed from: protected */
    public j1 y(long[] jArr) {
        t.e(jArr, "$this$toBuilder");
        return new j1(jArr, (C2633k) null);
    }

    /* access modifiers changed from: protected */
    public void z(d dVar, long[] jArr, int i5) {
        t.e(dVar, "encoder");
        t.e(jArr, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            dVar.encodeInlineElement(getDescriptor(), i6).encodeLong(E.n(jArr, i6));
        }
    }
}
