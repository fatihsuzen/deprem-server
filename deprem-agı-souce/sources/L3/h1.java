package L3;

import H3.b;
import I3.a;
import K3.c;
import K3.d;
import W2.B;
import W2.C;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class h1 extends M0 implements b {

    /* renamed from: c  reason: collision with root package name */
    public static final h1 f18533c = new h1();

    private h1() {
        super(a.v(B.f19926b));
    }

    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((C) obj).v());
    }

    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((C) obj).v());
    }

    public /* bridge */ /* synthetic */ Object r() {
        return C.c(w());
    }

    public /* bridge */ /* synthetic */ void u(d dVar, Object obj, int i5) {
        z(dVar, ((C) obj).v(), i5);
    }

    /* access modifiers changed from: protected */
    public int v(int[] iArr) {
        t.e(iArr, "$this$collectionSize");
        return C.p(iArr);
    }

    /* access modifiers changed from: protected */
    public int[] w() {
        return C.f(0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(c cVar, int i5, g1 g1Var, boolean z4) {
        t.e(cVar, "decoder");
        t.e(g1Var, "builder");
        g1Var.e(B.b(cVar.decodeInlineElement(getDescriptor(), i5).decodeInt()));
    }

    /* access modifiers changed from: protected */
    public g1 y(int[] iArr) {
        t.e(iArr, "$this$toBuilder");
        return new g1(iArr, (C2633k) null);
    }

    /* access modifiers changed from: protected */
    public void z(d dVar, int[] iArr, int i5) {
        t.e(dVar, "encoder");
        t.e(iArr, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            dVar.encodeInlineElement(getDescriptor(), i6).encodeInt(C.n(iArr, i6));
        }
    }
}
