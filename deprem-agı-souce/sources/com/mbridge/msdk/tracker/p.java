package com.mbridge.msdk.tracker;

import android.util.Log;

final class p implements l {

    /* renamed from: a  reason: collision with root package name */
    private final g f11727a;

    public p(g gVar) {
        this.f11727a = gVar;
    }

    public final void a(e eVar) {
        if (!y.a((Object) this.f11727a)) {
            this.f11727a.a(eVar);
        }
    }

    public final void b(e eVar) {
        if (!y.a((Object) this.f11727a)) {
            try {
                h i5 = eVar.i();
                if (y.b((Object) i5)) {
                    eVar.a(i5.a(eVar));
                }
                this.f11727a.b(eVar);
            } catch (Exception e5) {
                if (a.f11490a) {
                    Log.e("TrackManager", "process event error", e5);
                }
            }
        }
    }

    public final long[] a() {
        if (y.a((Object) this.f11727a)) {
            return new long[]{0, 0};
        }
        return this.f11727a.a();
    }
}
