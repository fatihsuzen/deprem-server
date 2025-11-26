package L3;

import H3.b;
import I3.a;
import K3.c;
import K3.d;
import W2.G;
import W2.H;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class n1 extends M0 implements b {

    /* renamed from: c  reason: collision with root package name */
    public static final n1 f18563c = new n1();

    private n1() {
        super(a.x(G.f19937b));
    }

    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((H) obj).v());
    }

    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((H) obj).v());
    }

    public /* bridge */ /* synthetic */ Object r() {
        return H.c(w());
    }

    public /* bridge */ /* synthetic */ void u(d dVar, Object obj, int i5) {
        z(dVar, ((H) obj).v(), i5);
    }

    /* access modifiers changed from: protected */
    public int v(short[] sArr) {
        t.e(sArr, "$this$collectionSize");
        return H.p(sArr);
    }

    /* access modifiers changed from: protected */
    public short[] w() {
        return H.f(0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(c cVar, int i5, m1 m1Var, boolean z4) {
        t.e(cVar, "decoder");
        t.e(m1Var, "builder");
        m1Var.e(G.b(cVar.decodeInlineElement(getDescriptor(), i5).decodeShort()));
    }

    /* access modifiers changed from: protected */
    public m1 y(short[] sArr) {
        t.e(sArr, "$this$toBuilder");
        return new m1(sArr, (C2633k) null);
    }

    /* access modifiers changed from: protected */
    public void z(d dVar, short[] sArr, int i5) {
        t.e(dVar, "encoder");
        t.e(sArr, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            dVar.encodeInlineElement(getDescriptor(), i6).encodeShort(H.n(sArr, i6));
        }
    }
}
