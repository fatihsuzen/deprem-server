package L3;

import H3.b;
import I3.a;
import K3.c;
import K3.d;
import kotlin.jvm.internal.C2635m;
import kotlin.jvm.internal.t;

public final class K extends M0 implements b {

    /* renamed from: c  reason: collision with root package name */
    public static final K f18467c = new K();

    private K() {
        super(a.D(C2635m.f24718a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public int e(float[] fArr) {
        t.e(fArr, "<this>");
        return fArr.length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public float[] r() {
        return new float[0];
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(c cVar, int i5, J j5, boolean z4) {
        t.e(cVar, "decoder");
        t.e(j5, "builder");
        j5.e(cVar.decodeFloatElement(getDescriptor(), i5));
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public J k(float[] fArr) {
        t.e(fArr, "<this>");
        return new J(fArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public void u(d dVar, float[] fArr, int i5) {
        t.e(dVar, "encoder");
        t.e(fArr, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            dVar.encodeFloatElement(getDescriptor(), i6, fArr[i6]);
        }
    }
}
