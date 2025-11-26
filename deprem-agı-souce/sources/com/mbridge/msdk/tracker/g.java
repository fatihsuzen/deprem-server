package com.mbridge.msdk.tracker;

import java.util.concurrent.atomic.AtomicLong;

final class g implements l {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final c f11506a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final r f11507b;

    /* renamed from: c  reason: collision with root package name */
    private final j f11508c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicLong f11509d = new AtomicLong(0);

    /* renamed from: e  reason: collision with root package name */
    private final long[] f11510e = new long[2];
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public volatile i f11511f;

    public g(c cVar, r rVar, j jVar) {
        this.f11506a = cVar;
        this.f11507b = rVar;
        this.f11508c = jVar;
    }

    public final void b(final e eVar) {
        this.f11508c.b(new Runnable() {
            private void a(i iVar, int i5) {
                while (i5 > 0) {
                    if (g.this.f11506a.a(iVar) > 0) {
                        g.this.f11507b.c();
                        g.this.f11507b.d();
                        g.this.f11507b.a(eVar);
                        return;
                    }
                    i5--;
                }
                i unused = g.this.f11511f = iVar;
            }

            public final void run() {
                i iVar = new i(eVar);
                iVar.a(1);
                iVar.b(0);
                iVar.a(System.currentTimeMillis() + eVar.h());
                if (g.this.f11511f != null) {
                    a(g.this.f11511f, 5);
                    i unused = g.this.f11511f = null;
                }
                a(iVar, 5);
            }
        });
    }

    public final void a(e eVar) {
        long incrementAndGet = this.f11509d.incrementAndGet();
        this.f11510e[0] = System.currentTimeMillis();
        this.f11510e[1] = incrementAndGet;
    }

    public final long[] a() {
        long[] jArr = this.f11510e;
        return jArr.length == 0 ? new long[]{0, 0} : jArr;
    }
}
