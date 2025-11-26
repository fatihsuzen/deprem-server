package L3;

import H3.b;
import I3.a;
import K3.c;
import K3.d;
import W2.A;
import W2.z;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class e1 extends M0 implements b {

    /* renamed from: c  reason: collision with root package name */
    public static final e1 f18519c = new e1();

    private e1() {
        super(a.u(z.f19980b));
    }

    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((A) obj).v());
    }

    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((A) obj).v());
    }

    public /* bridge */ /* synthetic */ Object r() {
        return A.c(w());
    }

    public /* bridge */ /* synthetic */ void u(d dVar, Object obj, int i5) {
        z(dVar, ((A) obj).v(), i5);
    }

    /* access modifiers changed from: protected */
    public int v(byte[] bArr) {
        t.e(bArr, "$this$collectionSize");
        return A.p(bArr);
    }

    /* access modifiers changed from: protected */
    public byte[] w() {
        return A.f(0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(c cVar, int i5, d1 d1Var, boolean z4) {
        t.e(cVar, "decoder");
        t.e(d1Var, "builder");
        d1Var.e(z.b(cVar.decodeInlineElement(getDescriptor(), i5).decodeByte()));
    }

    /* access modifiers changed from: protected */
    public d1 y(byte[] bArr) {
        t.e(bArr, "$this$toBuilder");
        return new d1(bArr, (C2633k) null);
    }

    /* access modifiers changed from: protected */
    public void z(d dVar, byte[] bArr, int i5) {
        t.e(dVar, "encoder");
        t.e(bArr, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            dVar.encodeInlineElement(getDescriptor(), i6).encodeByte(A.n(bArr, i6));
        }
    }
}
