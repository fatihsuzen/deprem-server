package L3;

import H3.b;
import I3.a;
import K3.c;
import K3.d;
import kotlin.jvm.internal.C2634l;
import kotlin.jvm.internal.t;

public final class B extends M0 implements b {

    /* renamed from: c  reason: collision with root package name */
    public static final B f18426c = new B();

    private B() {
        super(a.C(C2634l.f24717a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public int e(double[] dArr) {
        t.e(dArr, "<this>");
        return dArr.length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public double[] r() {
        return new double[0];
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(c cVar, int i5, A a5, boolean z4) {
        t.e(cVar, "decoder");
        t.e(a5, "builder");
        a5.e(cVar.decodeDoubleElement(getDescriptor(), i5));
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public A k(double[] dArr) {
        t.e(dArr, "<this>");
        return new A(dArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public void u(d dVar, double[] dArr, int i5) {
        t.e(dVar, "encoder");
        t.e(dArr, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            dVar.encodeDoubleElement(getDescriptor(), i6, dArr[i6]);
        }
    }
}
