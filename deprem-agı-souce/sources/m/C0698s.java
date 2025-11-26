package M;

import L.b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import k0.C1699m;

/* renamed from: M.s  reason: case insensitive filesystem */
public final class C0698s {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Map f2936a = DesugarCollections.synchronizedMap(new WeakHashMap());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Map f2937b = DesugarCollections.synchronizedMap(new WeakHashMap());

    private final void h(boolean z4, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f2936a) {
            hashMap = new HashMap(this.f2936a);
        }
        synchronized (this.f2937b) {
            hashMap2 = new HashMap(this.f2937b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z4 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).d(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z4 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((C1699m) entry2.getKey()).d(new b(status));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(BasePendingResult basePendingResult, boolean z4) {
        this.f2936a.put(basePendingResult, Boolean.valueOf(z4));
        basePendingResult.a(new C0697q(this, basePendingResult));
    }

    /* access modifiers changed from: package-private */
    public final void d(C1699m mVar, boolean z4) {
        this.f2937b.put(mVar, Boolean.valueOf(z4));
        mVar.a().c(new r(this, mVar));
    }

    /* access modifiers changed from: package-private */
    public final void e(int i5, String str) {
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i5 == 1) {
            sb.append(" due to service disconnection.");
        } else if (i5 == 3) {
            sb.append(" due to dead object exception.");
        }
        if (str != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(str);
        }
        h(true, new Status(20, sb.toString()));
    }

    public final void f() {
        h(false, C0685e.f2896p);
    }

    /* access modifiers changed from: package-private */
    public final boolean g() {
        if (!this.f2936a.isEmpty() || !this.f2937b.isEmpty()) {
            return true;
        }
        return false;
    }
}
