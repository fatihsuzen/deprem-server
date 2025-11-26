package L3;

import H3.b;
import I3.a;
import K3.c;
import K3.d;
import kotlin.jvm.internal.O;
import kotlin.jvm.internal.t;

public final class U0 extends M0 implements b {

    /* renamed from: c  reason: collision with root package name */
    public static final U0 f18488c = new U0();

    private U0() {
        super(a.G(O.f24693a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public int e(short[] sArr) {
        t.e(sArr, "<this>");
        return sArr.length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public short[] r() {
        return new short[0];
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(c cVar, int i5, T0 t02, boolean z4) {
        t.e(cVar, "decoder");
        t.e(t02, "builder");
        t02.e(cVar.decodeShortElement(getDescriptor(), i5));
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public T0 k(short[] sArr) {
        t.e(sArr, "<this>");
        return new T0(sArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public void u(d dVar, short[] sArr, int i5) {
        t.e(dVar, "encoder");
        t.e(sArr, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            dVar.encodeShortElement(getDescriptor(), i6, sArr[i6]);
        }
    }
}
