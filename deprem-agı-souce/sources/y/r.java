package y;

import A.C0620b;
import B.C0628a;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import p.C1745c;
import r.h;
import r.i;
import r.p;
import s.e;
import s.f;
import s.g;
import s.m;
import u.C1883a;
import u.C1885c;
import v.C1892a;
import z.C1951c;
import z.C1952d;
import z.C1959k;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17045a;

    /* renamed from: b  reason: collision with root package name */
    private final e f17046b;

    /* renamed from: c  reason: collision with root package name */
    private final C1952d f17047c;

    /* renamed from: d  reason: collision with root package name */
    private final x f17048d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f17049e;

    /* renamed from: f  reason: collision with root package name */
    private final C0620b f17050f;

    /* renamed from: g  reason: collision with root package name */
    private final C0628a f17051g;

    /* renamed from: h  reason: collision with root package name */
    private final C0628a f17052h;

    /* renamed from: i  reason: collision with root package name */
    private final C1951c f17053i;

    public r(Context context, e eVar, C1952d dVar, x xVar, Executor executor, C0620b bVar, C0628a aVar, C0628a aVar2, C1951c cVar) {
        this.f17045a = context;
        this.f17046b = eVar;
        this.f17047c = dVar;
        this.f17048d = xVar;
        this.f17049e = executor;
        this.f17050f = bVar;
        this.f17051g = aVar;
        this.f17052h = aVar2;
        this.f17053i = cVar;
    }

    public static /* synthetic */ Object b(r rVar, Iterable iterable, p pVar, long j5) {
        rVar.f17047c.D(iterable);
        rVar.f17047c.w(pVar, rVar.f17051g.a() + j5);
        return null;
    }

    public static /* synthetic */ Object h(r rVar, Map map) {
        rVar.getClass();
        for (Map.Entry entry : map.entrySet()) {
            rVar.f17053i.d((long) ((Integer) entry.getValue()).intValue(), C1885c.b.INVALID_PAYLOD, (String) entry.getKey());
        }
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r3.f17048d.b(r4, r5 + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        r6.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        r6.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void i(y.r r3, r.p r4, int r5, java.lang.Runnable r6) {
        /*
            r3.getClass()
            A.b r0 = r3.f17050f     // Catch:{ a -> 0x002c }
            z.d r1 = r3.f17047c     // Catch:{ a -> 0x002c }
            j$.util.Objects.requireNonNull(r1)     // Catch:{ a -> 0x002c }
            y.i r2 = new y.i     // Catch:{ a -> 0x002c }
            r2.<init>(r1)     // Catch:{ a -> 0x002c }
            r0.m(r2)     // Catch:{ a -> 0x002c }
            boolean r0 = r3.k()     // Catch:{ a -> 0x002c }
            if (r0 != 0) goto L_0x0025
            A.b r0 = r3.f17050f     // Catch:{ a -> 0x002c }
            y.j r1 = new y.j     // Catch:{ a -> 0x002c }
            r1.<init>(r3, r4, r5)     // Catch:{ a -> 0x002c }
            r0.m(r1)     // Catch:{ a -> 0x002c }
            goto L_0x0028
        L_0x0023:
            r3 = move-exception
            goto L_0x0037
        L_0x0025:
            r3.l(r4, r5)     // Catch:{ a -> 0x002c }
        L_0x0028:
            r6.run()
            return
        L_0x002c:
            y.x r3 = r3.f17048d     // Catch:{ all -> 0x0023 }
            int r5 = r5 + 1
            r3.b(r4, r5)     // Catch:{ all -> 0x0023 }
            r6.run()
            return
        L_0x0037:
            r6.run()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: y.r.i(y.r, r.p, int, java.lang.Runnable):void");
    }

    public i j(m mVar) {
        C0620b bVar = this.f17050f;
        C1951c cVar = this.f17053i;
        Objects.requireNonNull(cVar);
        return mVar.b(i.a().i(this.f17051g.a()).o(this.f17052h.a()).n("GDT_CLIENT_METRICS").h(new h(C1745c.b("proto"), ((C1883a) bVar.m(new h(cVar))).f())).d());
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f17045a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public g l(p pVar, int i5) {
        g a5;
        m mVar = this.f17046b.get(pVar.b());
        g e5 = g.e(0);
        long j5 = 0;
        while (((Boolean) this.f17050f.m(new k(this, pVar))).booleanValue()) {
            Iterable<C1959k> iterable = (Iterable) this.f17050f.m(new l(this, pVar));
            if (!iterable.iterator().hasNext()) {
                return e5;
            }
            if (mVar == null) {
                C1892a.b("Uploader", "Unknown backend for %s, deleting event batch for it...", pVar);
                a5 = g.a();
            } else {
                ArrayList arrayList = new ArrayList();
                for (C1959k b5 : iterable) {
                    arrayList.add(b5.b());
                }
                if (pVar.e()) {
                    arrayList.add(j(mVar));
                }
                a5 = mVar.a(f.a().b(arrayList).c(pVar.c()).a());
            }
            e5 = a5;
            if (e5.c() == g.a.TRANSIENT_ERROR) {
                p pVar2 = pVar;
                this.f17050f.m(new m(this, iterable, pVar2, j5));
                this.f17048d.a(pVar2, i5 + 1, true);
                return e5;
            }
            p pVar3 = pVar;
            this.f17050f.m(new n(this, iterable));
            if (e5.c() == g.a.OK) {
                long max = Math.max(j5, e5.b());
                if (pVar3.e()) {
                    this.f17050f.m(new o(this));
                }
                j5 = max;
            } else if (e5.c() == g.a.INVALID_PAYLOAD) {
                HashMap hashMap = new HashMap();
                for (C1959k b6 : iterable) {
                    String n5 = b6.b().n();
                    if (!hashMap.containsKey(n5)) {
                        hashMap.put(n5, 1);
                    } else {
                        hashMap.put(n5, Integer.valueOf(((Integer) hashMap.get(n5)).intValue() + 1));
                    }
                }
                this.f17050f.m(new p(this, hashMap));
            }
            pVar = pVar3;
        }
        this.f17050f.m(new q(this, pVar, j5));
        return e5;
    }

    public void m(p pVar, int i5, Runnable runnable) {
        this.f17049e.execute(new C1936g(this, pVar, i5, runnable));
    }
}
