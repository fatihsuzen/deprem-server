package L3;

import H3.b;
import I3.a;
import K3.c;
import K3.d;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;

/* renamed from: L3.g0  reason: case insensitive filesystem */
public final class C2089g0 extends M0 implements b {

    /* renamed from: c  reason: collision with root package name */
    public static final C2089g0 f18527c = new C2089g0();

    private C2089g0() {
        super(a.F(v.f24720a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public int e(long[] jArr) {
        t.e(jArr, "<this>");
        return jArr.length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public long[] r() {
        return new long[0];
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(c cVar, int i5, C2087f0 f0Var, boolean z4) {
        t.e(cVar, "decoder");
        t.e(f0Var, "builder");
        f0Var.e(cVar.decodeLongElement(getDescriptor(), i5));
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public C2087f0 k(long[] jArr) {
        t.e(jArr, "<this>");
        return new C2087f0(jArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public void u(d dVar, long[] jArr, int i5) {
        t.e(dVar, "encoder");
        t.e(jArr, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            dVar.encodeLongElement(getDescriptor(), i6, jArr[i6]);
        }
    }
}
