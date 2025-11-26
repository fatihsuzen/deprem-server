package L3;

import H3.b;
import I3.a;
import K3.c;
import K3.d;
import kotlin.jvm.internal.C2629g;
import kotlin.jvm.internal.t;

/* renamed from: L3.q  reason: case insensitive filesystem */
public final class C2108q extends M0 implements b {

    /* renamed from: c  reason: collision with root package name */
    public static final C2108q f18573c = new C2108q();

    private C2108q() {
        super(a.B(C2629g.f24708a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public int e(char[] cArr) {
        t.e(cArr, "<this>");
        return cArr.length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public char[] r() {
        return new char[0];
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(c cVar, int i5, C2106p pVar, boolean z4) {
        t.e(cVar, "decoder");
        t.e(pVar, "builder");
        pVar.e(cVar.decodeCharElement(getDescriptor(), i5));
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public C2106p k(char[] cArr) {
        t.e(cArr, "<this>");
        return new C2106p(cArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public void u(d dVar, char[] cArr, int i5) {
        t.e(dVar, "encoder");
        t.e(cArr, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            dVar.encodeCharElement(getDescriptor(), i6, cArr[i6]);
        }
    }
}
