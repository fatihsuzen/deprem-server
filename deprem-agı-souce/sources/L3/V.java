package L3;

import H3.b;
import I3.a;
import K3.c;
import K3.d;
import kotlin.jvm.internal.C2640s;
import kotlin.jvm.internal.t;

public final class V extends M0 implements b {

    /* renamed from: c  reason: collision with root package name */
    public static final V f18489c = new V();

    private V() {
        super(a.E(C2640s.f24719a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public int e(int[] iArr) {
        t.e(iArr, "<this>");
        return iArr.length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public int[] r() {
        return new int[0];
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(c cVar, int i5, U u5, boolean z4) {
        t.e(cVar, "decoder");
        t.e(u5, "builder");
        u5.e(cVar.decodeIntElement(getDescriptor(), i5));
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public U k(int[] iArr) {
        t.e(iArr, "<this>");
        return new U(iArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public void u(d dVar, int[] iArr, int i5) {
        t.e(dVar, "encoder");
        t.e(iArr, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            dVar.encodeIntElement(getDescriptor(), i6, iArr[i6]);
        }
    }
}
