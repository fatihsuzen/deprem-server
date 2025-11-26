package L3;

import H3.b;
import I3.a;
import K3.c;
import K3.d;
import kotlin.jvm.internal.C2626d;
import kotlin.jvm.internal.t;

/* renamed from: L3.h  reason: case insensitive filesystem */
public final class C2090h extends M0 implements b {

    /* renamed from: c  reason: collision with root package name */
    public static final C2090h f18530c = new C2090h();

    private C2090h() {
        super(a.z(C2626d.f24705a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public int e(boolean[] zArr) {
        t.e(zArr, "<this>");
        return zArr.length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public boolean[] r() {
        return new boolean[0];
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(c cVar, int i5, C2088g gVar, boolean z4) {
        t.e(cVar, "decoder");
        t.e(gVar, "builder");
        gVar.e(cVar.decodeBooleanElement(getDescriptor(), i5));
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public C2088g k(boolean[] zArr) {
        t.e(zArr, "<this>");
        return new C2088g(zArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public void u(d dVar, boolean[] zArr, int i5) {
        t.e(dVar, "encoder");
        t.e(zArr, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            dVar.encodeBooleanElement(getDescriptor(), i6, zArr[i6]);
        }
    }
}
