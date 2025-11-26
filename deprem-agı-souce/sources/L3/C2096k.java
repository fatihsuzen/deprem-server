package L3;

import H3.b;
import I3.a;
import K3.c;
import K3.d;
import kotlin.jvm.internal.C2627e;
import kotlin.jvm.internal.t;

/* renamed from: L3.k  reason: case insensitive filesystem */
public final class C2096k extends M0 implements b {

    /* renamed from: c  reason: collision with root package name */
    public static final C2096k f18547c = new C2096k();

    private C2096k() {
        super(a.A(C2627e.f24706a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public int e(byte[] bArr) {
        t.e(bArr, "<this>");
        return bArr.length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public byte[] r() {
        return new byte[0];
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(c cVar, int i5, C2094j jVar, boolean z4) {
        t.e(cVar, "decoder");
        t.e(jVar, "builder");
        jVar.e(cVar.decodeByteElement(getDescriptor(), i5));
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public C2094j k(byte[] bArr) {
        t.e(bArr, "<this>");
        return new C2094j(bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public void u(d dVar, byte[] bArr, int i5) {
        t.e(dVar, "encoder");
        t.e(bArr, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            dVar.encodeByteElement(getDescriptor(), i6, bArr[i6]);
        }
    }
}
