package F3;

import B3.D;

public abstract class l {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final int f18131a = G.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, (Object) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final D f18132b = new D("PERMIT");
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final D f18133c = new D("TAKEN");
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final D f18134d = new D("BROKEN");
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final D f18135e = new D("CANCELLED");
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final int f18136f = G.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, (Object) null);

    public static final h a(int i5, int i6) {
        return new k(i5, i6);
    }

    public static /* synthetic */ h b(int i5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        return a(i5, i6);
    }

    /* access modifiers changed from: private */
    public static final m j(long j5, m mVar) {
        return new m(j5, mVar, 0);
    }
}
