package x0;

import A0.F;
import D0.e;
import E0.b;
import F0.j;
import G0.d;
import android.app.ApplicationExitInfo;
import android.content.Context;
import j$.util.DesugarCollections;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.Executor;
import k0.C1698l;
import k0.C1701o;
import u0.g;
import y0.i;
import z0.C1974c;
import z0.C1977f;
import z0.n;

public class Z {

    /* renamed from: a  reason: collision with root package name */
    private final C1929z f16834a;

    /* renamed from: b  reason: collision with root package name */
    private final e f16835b;

    /* renamed from: c  reason: collision with root package name */
    private final b f16836c;

    /* renamed from: d  reason: collision with root package name */
    private final C1977f f16837d;

    /* renamed from: e  reason: collision with root package name */
    private final n f16838e;

    /* renamed from: f  reason: collision with root package name */
    private final I f16839f;

    /* renamed from: g  reason: collision with root package name */
    private final i f16840g;

    Z(C1929z zVar, e eVar, b bVar, C1977f fVar, n nVar, I i5, i iVar) {
        this.f16834a = zVar;
        this.f16835b = eVar;
        this.f16836c = bVar;
        this.f16837d = fVar;
        this.f16838e = nVar;
        this.f16839f = i5;
        this.f16840g = iVar;
    }

    public static /* synthetic */ void a(Z z4, F.e.d dVar, C1974c cVar, boolean z5) {
        z4.getClass();
        g.f().b("disk worker: log non-fatal event to persistence");
        z4.f16835b.w(dVar, cVar.b(), z5);
    }

    private F.e.d d(F.e.d dVar, C1977f fVar, n nVar) {
        return e(dVar, fVar, nVar, Collections.EMPTY_MAP);
    }

    private F.e.d e(F.e.d dVar, C1977f fVar, n nVar, Map map) {
        F.e.d.b h5 = dVar.h();
        String c5 = fVar.c();
        if (c5 != null) {
            h5.d(F.e.d.C0036d.a().b(c5).a());
        } else {
            g.f().i("No log data to include with this event.");
        }
        List o5 = o(nVar.e(map));
        List o6 = o(nVar.f());
        if (!o5.isEmpty() || !o6.isEmpty()) {
            h5.b(dVar.b().i().e(o5).g(o6).a());
        }
        return h5.a();
    }

    private F.e.d f(F.e.d dVar, Map map) {
        return g(e(dVar, this.f16837d, this.f16838e, map), this.f16838e);
    }

    private F.e.d g(F.e.d dVar, n nVar) {
        List g5 = nVar.g();
        if (g5.isEmpty()) {
            return dVar;
        }
        F.e.d.b h5 = dVar.h();
        h5.e(F.e.d.f.a().b(g5).a());
        return h5.a();
    }

    private static F.a h(ApplicationExitInfo applicationExitInfo) {
        String str = null;
        try {
            InputStream a5 = applicationExitInfo.getTraceInputStream();
            if (a5 != null) {
                str = i(a5);
            }
        } catch (IOException e5) {
            g f5 = g.f();
            f5.k("Could not get input trace in application exit info: " + applicationExitInfo.toString() + " Error: " + e5);
        }
        return F.a.a().c(applicationExitInfo.getImportance()).e(applicationExitInfo.getProcessName()).g(applicationExitInfo.getReason()).i(applicationExitInfo.getTimestamp()).d(applicationExitInfo.getPid()).f(applicationExitInfo.getPss()).h(applicationExitInfo.getRss()).j(str).a();
    }

    public static String i(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
                    byteArrayOutputStream.close();
                    bufferedInputStream.close();
                    return byteArrayOutputStream2;
                }
            }
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
        throw th;
    }

    public static Z j(Context context, I i5, D0.g gVar, C1906b bVar, C1977f fVar, n nVar, d dVar, j jVar, N n5, C1918n nVar2, i iVar) {
        return new Z(new C1929z(context, i5, bVar, dVar, jVar), new e(gVar, jVar, nVar2), b.b(context, jVar, n5), fVar, nVar, i5, iVar);
    }

    private C1903A k(C1903A a5) {
        if (a5.b().h() != null && a5.b().g() != null) {
            return a5;
        }
        H d5 = this.f16839f.d(true);
        return C1903A.a(a5.b().t(d5.b()).s(d5.a()), a5.d(), a5.c());
    }

    private ApplicationExitInfo n(String str, List list) {
        long q5 = this.f16835b.q(str);
        for (Object a5 : list) {
            ApplicationExitInfo a6 = androidx.work.impl.utils.j.a(a5);
            if (a6.getTimestamp() < q5) {
                return null;
            }
            if (a6.getReason() == 6) {
                return a6;
            }
        }
        return null;
    }

    private static List o(Map map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(F.c.a().b((String) entry.getKey()).c((String) entry.getValue()).a());
        }
        Collections.sort(arrayList, new Y());
        return DesugarCollections.unmodifiableList(arrayList);
    }

    /* access modifiers changed from: private */
    public boolean s(C1698l lVar) {
        if (lVar.n()) {
            C1903A a5 = (C1903A) lVar.j();
            g f5 = g.f();
            f5.b("Crashlytics report successfully enqueued to DataTransport: " + a5.d());
            File c5 = a5.c();
            if (c5.delete()) {
                g f6 = g.f();
                f6.b("Deleted report file: " + c5.getPath());
                return true;
            }
            g f7 = g.f();
            f7.k("Crashlytics could not delete report file: " + c5.getPath());
            return true;
        }
        g.f().l("Crashlytics report could not be enqueued to DataTransport", lVar.i());
        return false;
    }

    private void t(Throwable th, Thread thread, String str, C1974c cVar, boolean z4) {
        boolean equals = str.equals("crash");
        boolean z5 = z4;
        F.e.d f5 = f(this.f16834a.d(th, thread, str, cVar.c(), 4, 8, z5), cVar.a());
        if (!z5) {
            this.f16840g.f17085b.d(new W(this, f5, cVar, equals));
        } else {
            this.f16835b.w(f5, cVar.b(), equals);
        }
    }

    public void l(String str, List list, F.a aVar) {
        g.f().b("SessionReportingCoordinator#finalizeSessionWithNativeEvent");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            F.d.b b5 = ((L) it.next()).b();
            if (b5 != null) {
                arrayList.add(b5);
            }
        }
        this.f16835b.l(str, F.d.a().b(DesugarCollections.unmodifiableList(arrayList)).a(), aVar);
    }

    public void m(long j5, String str) {
        this.f16835b.k(str, j5);
    }

    public boolean p() {
        return this.f16835b.r();
    }

    public SortedSet q() {
        return this.f16835b.p();
    }

    public void r(String str, long j5) {
        this.f16835b.x(this.f16834a.e(str, j5));
    }

    public void u(Throwable th, Thread thread, String str, long j5) {
        g f5 = g.f();
        f5.i("Persisting fatal event for session " + str);
        t(th, thread, "crash", new C1974c(str, j5), true);
    }

    public void v(String str, List list, C1977f fVar, n nVar) {
        ApplicationExitInfo n5 = n(str, list);
        if (n5 == null) {
            g f5 = g.f();
            f5.i("No relevant ApplicationExitInfo occurred during session: " + str);
            return;
        }
        F.e.d c5 = this.f16834a.c(h(n5));
        g f6 = g.f();
        f6.b("Persisting anr for session " + str);
        this.f16835b.w(g(d(c5, fVar, nVar), nVar), str, true);
    }

    public void w() {
        this.f16835b.i();
    }

    public C1698l x(Executor executor) {
        return y(executor, (String) null);
    }

    public C1698l y(Executor executor, String str) {
        boolean z4;
        List<C1903A> u5 = this.f16835b.u();
        ArrayList arrayList = new ArrayList();
        for (C1903A a5 : u5) {
            if (str == null || str.equals(a5.d())) {
                b bVar = this.f16836c;
                C1903A k5 = k(a5);
                if (str != null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                arrayList.add(bVar.c(k5, z4).g(executor, new X(this)));
            }
        }
        return C1701o.f(arrayList);
    }
}
