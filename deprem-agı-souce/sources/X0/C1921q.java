package x0;

import A0.F;
import A0.G;
import D0.g;
import F0.j;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import c1.C1044a;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import k0.C1697k;
import k0.C1698l;
import k0.C1699m;
import k0.C1701o;
import u0.C1886a;
import u0.h;
import v0.C1893a;
import x0.C1904B;
import y0.C1938b;
import y0.i;
import z0.C1977f;
import z0.n;

/* renamed from: x0.q  reason: case insensitive filesystem */
class C1921q {

    /* renamed from: t  reason: collision with root package name */
    static final FilenameFilter f16890t = new C1920p();

    /* renamed from: u  reason: collision with root package name */
    private static final Charset f16891u = Charset.forName(C.UTF8_NAME);

    /* renamed from: a  reason: collision with root package name */
    private final Context f16892a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final D f16893b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final C1928y f16894c;

    /* renamed from: d  reason: collision with root package name */
    private final n f16895d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final i f16896e;

    /* renamed from: f  reason: collision with root package name */
    private final I f16897f;

    /* renamed from: g  reason: collision with root package name */
    private final g f16898g;

    /* renamed from: h  reason: collision with root package name */
    private final C1906b f16899h;

    /* renamed from: i  reason: collision with root package name */
    private final C1977f f16900i;

    /* renamed from: j  reason: collision with root package name */
    private final C1886a f16901j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final C1893a f16902k;

    /* renamed from: l  reason: collision with root package name */
    private final C1918n f16903l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final Z f16904m;

    /* renamed from: n  reason: collision with root package name */
    private C1904B f16905n;

    /* renamed from: o  reason: collision with root package name */
    private j f16906o = null;

    /* renamed from: p  reason: collision with root package name */
    final C1699m f16907p = new C1699m();

    /* renamed from: q  reason: collision with root package name */
    final C1699m f16908q = new C1699m();

    /* renamed from: r  reason: collision with root package name */
    final C1699m f16909r = new C1699m();

    /* renamed from: s  reason: collision with root package name */
    final AtomicBoolean f16910s = new AtomicBoolean(false);

    /* renamed from: x0.q$a */
    class a implements C1904B.a {
        a() {
        }

        public void a(j jVar, Thread thread, Throwable th) {
            C1921q.this.G(jVar, thread, th);
        }
    }

    /* renamed from: x0.q$b */
    class b implements Callable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f16912a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Throwable f16913b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Thread f16914c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ j f16915d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f16916e;

        /* renamed from: x0.q$b$a */
        class a implements C1697k {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f16918a;

            a(String str) {
                this.f16918a = str;
            }

            /* renamed from: b */
            public C1698l a(F0.d dVar) {
                String str = null;
                if (dVar == null) {
                    u0.g.f().k("Received null app settings, cannot send reports at crash time.");
                    return C1701o.e((Object) null);
                }
                C1698l l5 = C1921q.this.L();
                Z g5 = C1921q.this.f16904m;
                y0.e eVar = C1921q.this.f16896e.f17084a;
                if (b.this.f16916e) {
                    str = this.f16918a;
                }
                return C1701o.g(l5, g5.y(eVar, str));
            }
        }

        b(long j5, Throwable th, Thread thread, j jVar, boolean z4) {
            this.f16912a = j5;
            this.f16913b = th;
            this.f16914c = thread;
            this.f16915d = jVar;
            this.f16916e = z4;
        }

        /* renamed from: a */
        public C1698l call() {
            long c5 = C1921q.E(this.f16912a);
            String d5 = C1921q.this.A();
            if (d5 == null) {
                u0.g.f().d("Tried to write a fatal exception while no session was open.");
                return C1701o.e((Object) null);
            }
            C1921q.this.f16894c.a();
            C1921q.this.f16904m.u(this.f16913b, this.f16914c, d5, c5);
            C1921q.this.v(this.f16912a);
            C1921q.this.s(this.f16915d);
            C1921q.this.u(new C1913i().c(), Boolean.valueOf(this.f16916e));
            if (!C1921q.this.f16893b.d()) {
                return C1701o.e((Object) null);
            }
            return this.f16915d.a().o(C1921q.this.f16896e.f17084a, new a(d5));
        }
    }

    /* renamed from: x0.q$c */
    class c implements C1697k {
        c() {
        }

        /* renamed from: b */
        public C1698l a(Void voidR) {
            return C1701o.e(Boolean.TRUE);
        }
    }

    /* renamed from: x0.q$d */
    class d implements C1697k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1698l f16921a;

        /* renamed from: x0.q$d$a */
        class a implements C1697k {
            a() {
            }

            /* renamed from: b */
            public C1698l a(F0.d dVar) {
                if (dVar == null) {
                    u0.g.f().k("Received null app settings at app startup. Cannot send cached reports");
                    return C1701o.e((Object) null);
                }
                C1698l unused = C1921q.this.L();
                C1921q.this.f16904m.x(C1921q.this.f16896e.f17084a);
                C1921q.this.f16909r.e((Object) null);
                return C1701o.e((Object) null);
            }
        }

        d(C1698l lVar) {
            this.f16921a = lVar;
        }

        /* renamed from: b */
        public C1698l a(Boolean bool) {
            if (!bool.booleanValue()) {
                u0.g.f().i("Deleting cached crash reports...");
                C1921q.q(C1921q.this.J());
                C1921q.this.f16904m.w();
                C1921q.this.f16909r.e((Object) null);
                return C1701o.e((Object) null);
            }
            u0.g.f().b("Sending cached crash reports...");
            C1921q.this.f16893b.c(bool.booleanValue());
            return this.f16921a.o(C1921q.this.f16896e.f17084a, new a());
        }
    }

    /* renamed from: x0.q$e */
    class e implements Callable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f16924a;

        e(long j5) {
            this.f16924a = j5;
        }

        /* renamed from: a */
        public Void call() {
            Bundle bundle = new Bundle();
            bundle.putInt("fatal", 1);
            bundle.putLong(CampaignEx.JSON_KEY_TIMESTAMP, this.f16924a);
            C1921q.this.f16902k.a("_ae", bundle);
            return null;
        }
    }

    C1921q(Context context, I i5, D d5, g gVar, C1928y yVar, C1906b bVar, n nVar, C1977f fVar, Z z4, C1886a aVar, C1893a aVar2, C1918n nVar2, i iVar) {
        this.f16892a = context;
        this.f16897f = i5;
        this.f16893b = d5;
        this.f16898g = gVar;
        this.f16894c = yVar;
        this.f16899h = bVar;
        this.f16895d = nVar;
        this.f16900i = fVar;
        this.f16901j = aVar;
        this.f16902k = aVar2;
        this.f16903l = nVar2;
        this.f16904m = z4;
        this.f16896e = iVar;
    }

    /* access modifiers changed from: private */
    public String A() {
        SortedSet q5 = this.f16904m.q();
        if (!q5.isEmpty()) {
            return (String) q5.first();
        }
        return null;
    }

    private static long B() {
        return E(System.currentTimeMillis());
    }

    static List C(h hVar, String str, g gVar, byte[] bArr) {
        File q5 = gVar.q(str, "user-data");
        File q6 = gVar.q(str, "keys");
        File q7 = gVar.q(str, "rollouts-state");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1912h("logs_file", "logs", bArr));
        arrayList.add(new G("crash_meta_file", TtmlNode.TAG_METADATA, hVar.g()));
        arrayList.add(new G("session_meta_file", "session", hVar.f()));
        arrayList.add(new G("app_meta_file", MBridgeConstans.DYNAMIC_VIEW_WX_APP, hVar.a()));
        arrayList.add(new G("device_meta_file", "device", hVar.c()));
        arrayList.add(new G("os_meta_file", "os", hVar.b()));
        arrayList.add(N(hVar));
        arrayList.add(new G("user_meta_file", "user", q5));
        arrayList.add(new G("keys_file", "keys", q6));
        arrayList.add(new G("rollouts_file", "rollouts", q7));
        return arrayList;
    }

    private InputStream D(String str) {
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader != null) {
            return classLoader.getResourceAsStream(str);
        }
        u0.g.f().k("Couldn't get Class Loader");
        return null;
    }

    /* access modifiers changed from: private */
    public static long E(long j5) {
        return j5 / 1000;
    }

    private C1698l K(long j5) {
        if (z()) {
            u0.g.f().k("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return C1701o.e((Object) null);
        }
        u0.g.f().b("Logging app exception event to Firebase Analytics");
        return C1701o.c(new ScheduledThreadPoolExecutor(1), new e(j5));
    }

    /* access modifiers changed from: private */
    public C1698l L() {
        ArrayList arrayList = new ArrayList();
        for (File file : J()) {
            try {
                arrayList.add(K(Long.parseLong(file.getName().substring(3))));
            } catch (NumberFormatException unused) {
                u0.g f5 = u0.g.f();
                f5.k("Could not parse app exception timestamp from file " + file.getName());
            }
            file.delete();
        }
        return C1701o.f(arrayList);
    }

    private static boolean M(String str, File file, F.a aVar) {
        if (file == null || !file.exists()) {
            u0.g f5 = u0.g.f();
            f5.k("No minidump data found for session " + str);
        }
        if (aVar == null) {
            u0.g f6 = u0.g.f();
            f6.g("No Tombstones data found for session " + str);
        }
        if ((file == null || !file.exists()) && aVar == null) {
            return true;
        }
        return false;
    }

    private static L N(h hVar) {
        File e5 = hVar.e();
        if (e5 != null && e5.exists()) {
            return new G("minidump_file", "minidump", e5);
        }
        return new C1912h("minidump_file", "minidump", new byte[]{0});
    }

    private static byte[] P(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private C1698l T() {
        if (this.f16893b.d()) {
            u0.g.f().b("Automatic data collection is enabled. Allowing upload.");
            this.f16907p.e(Boolean.FALSE);
            return C1701o.e(Boolean.TRUE);
        }
        u0.g.f().b("Automatic data collection is disabled.");
        u0.g.f().i("Notifying that unsent reports are available.");
        this.f16907p.e(Boolean.TRUE);
        C1698l p5 = this.f16893b.j().p(new c());
        u0.g.f().b("Waiting for send/deleteUnsentReports to be called.");
        return C1938b.b(p5, this.f16908q.a());
    }

    private void U(String str) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30) {
            List a5 = ((ActivityManager) this.f16892a.getSystemService("activity")).getHistoricalProcessExitReasons((String) null, 0, 0);
            if (a5.size() != 0) {
                this.f16904m.v(str, a5, new C1977f(this.f16898g, str), n.i(str, this.f16898g, this.f16896e));
                return;
            }
            u0.g f5 = u0.g.f();
            f5.i("No ApplicationExitInfo available. Session: " + str);
            return;
        }
        u0.g f6 = u0.g.f();
        f6.i("ANR feature enabled, but device is API " + i5);
    }

    private static G.a n(I i5, C1906b bVar) {
        return G.a.b(i5.f(), bVar.f16846f, bVar.f16847g, i5.a().c(), E.b(bVar.f16844d).c(), bVar.f16848h);
    }

    private static G.b o(Context context) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return G.b.c(C1914j.k(), Build.MODEL, Runtime.getRuntime().availableProcessors(), C1914j.b(context), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()), C1914j.x(), C1914j.l(), Build.MANUFACTURER, Build.PRODUCT);
    }

    private static G.c p() {
        return G.c.a(Build.VERSION.RELEASE, Build.VERSION.CODENAME, C1914j.y());
    }

    /* access modifiers changed from: private */
    public static void q(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [boolean, int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void t(boolean r4, F0.j r5, boolean r6) {
        /*
            r3 = this;
            y0.i.c()
            java.util.ArrayList r0 = new java.util.ArrayList
            x0.Z r1 = r3.f16904m
            java.util.SortedSet r1 = r1.q()
            r0.<init>(r1)
            int r1 = r0.size()
            if (r1 > r4) goto L_0x001e
            u0.g r4 = u0.g.f()
            java.lang.String r5 = "No open sessions to be closed."
            r4.i(r5)
            return
        L_0x001e:
            java.lang.Object r1 = r0.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            if (r6 == 0) goto L_0x0034
            F0.d r5 = r5.b()
            F0.d$a r5 = r5.f2422b
            boolean r5 = r5.f2430b
            if (r5 == 0) goto L_0x0034
            r3.U(r1)
            goto L_0x003d
        L_0x0034:
            u0.g r5 = u0.g.f()
            java.lang.String r2 = "ANR feature disabled."
            r5.i(r2)
        L_0x003d:
            if (r6 == 0) goto L_0x004a
            u0.a r5 = r3.f16901j
            boolean r5 = r5.c(r1)
            if (r5 == 0) goto L_0x004a
            r3.x(r1)
        L_0x004a:
            if (r4 == 0) goto L_0x0054
            r4 = 0
            java.lang.Object r4 = r0.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x005b
        L_0x0054:
            x0.n r4 = r3.f16903l
            r5 = 0
            r4.e(r5)
            r4 = r5
        L_0x005b:
            x0.Z r5 = r3.f16904m
            long r0 = B()
            r5.m(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x0.C1921q.t(boolean, F0.j, boolean):void");
    }

    /* access modifiers changed from: private */
    public void u(String str, Boolean bool) {
        long B4 = B();
        u0.g f5 = u0.g.f();
        f5.b("Opening a new session with ID " + str);
        String format = String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{C1927x.k()});
        G.a n5 = n(this.f16897f, this.f16899h);
        G.c p5 = p();
        G.b o5 = o(this.f16892a);
        G.a aVar = n5;
        C1886a aVar2 = this.f16901j;
        G b5 = G.b(aVar, p5, o5);
        String str2 = str;
        aVar2.d(str2, format, B4, b5);
        if (bool.booleanValue() && str2 != null) {
            this.f16895d.l(str2);
        }
        this.f16900i.e(str2);
        this.f16903l.e(str2);
        this.f16904m.r(str2, B4);
    }

    /* access modifiers changed from: private */
    public void v(long j5) {
        try {
            g gVar = this.f16898g;
            if (!gVar.g(".ae" + j5).createNewFile()) {
                throw new IOException("Create new file failed.");
            }
        } catch (IOException e5) {
            u0.g.f().l("Could not create app exception marker file.", e5);
        }
    }

    private void x(String str) {
        u0.g f5 = u0.g.f();
        f5.i("Finalizing native report for session " + str);
        h a5 = this.f16901j.a(str);
        File e5 = a5.e();
        F.a d5 = a5.d();
        if (M(str, e5, d5)) {
            u0.g.f().k("No native core present");
            return;
        }
        long lastModified = e5.lastModified();
        C1977f fVar = new C1977f(this.f16898g, str);
        File k5 = this.f16898g.k(str);
        if (!k5.isDirectory()) {
            u0.g.f().k("Couldn't create directory to store native session files, aborting.");
            return;
        }
        v(lastModified);
        List C4 = C(a5, str, this.f16898g, fVar.b());
        M.b(k5, C4);
        u0.g.f().b("CrashlyticsController#finalizePreviousNativeSession");
        this.f16904m.l(str, C4, d5);
        fVar.a();
    }

    private static boolean z() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public String F() {
        String r5 = C1914j.r(this.f16892a);
        if (r5 != null) {
            u0.g.f().b("Read version control info from string resource");
            return Base64.encodeToString(r5.getBytes(f16891u), 0);
        }
        InputStream D4 = D("META-INF/version-control-info.textproto");
        if (D4 != null) {
            try {
                u0.g.f().b("Read version control info from file");
                String encodeToString = Base64.encodeToString(P(D4), 0);
                D4.close();
                return encodeToString;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            if (D4 != null) {
                D4.close();
            }
            u0.g.f().g("No version control information found");
            return null;
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public void G(j jVar, Thread thread, Throwable th) {
        H(jVar, thread, th, false);
    }

    /* access modifiers changed from: package-private */
    public synchronized void H(j jVar, Thread thread, Throwable th, boolean z4) {
        Throwable th2;
        try {
            u0.g f5 = u0.g.f();
            f5.b("Handling uncaught exception \"" + th + "\" from thread " + thread.getName());
            if (!z4) {
                try {
                    C1044a.b();
                } catch (Throwable th3) {
                    th2 = th3;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            boolean z5 = z4;
            try {
                C1698l e5 = this.f16896e.f17084a.e(new b(currentTimeMillis, th, thread, jVar, z5));
                if (!z5) {
                    c0.b(e5);
                }
            } catch (TimeoutException unused) {
                u0.g.f().d("Cannot send reports. Timed out while fetching settings.");
            } catch (Exception e6) {
                u0.g.f().e("Error handling uncaught exception", e6);
            } catch (Throwable th4) {
                th = th4;
                th2 = th;
                throw th2;
            }
        } catch (Throwable th5) {
            th = th5;
            th2 = th;
            throw th2;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean I() {
        C1904B b5 = this.f16905n;
        if (b5 == null || !b5.a()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public List J() {
        return this.f16898g.h(f16890t);
    }

    /* access modifiers changed from: package-private */
    public void O(String str) {
        this.f16896e.f17084a.d(new C1919o(this, str));
    }

    /* access modifiers changed from: package-private */
    public void Q() {
        try {
            String F4 = F();
            if (F4 != null) {
                R("com.crashlytics.version-control-info", F4);
                u0.g.f().g("Saved version control info");
            }
        } catch (IOException e5) {
            u0.g.f().l("Unable to save version control info", e5);
        }
    }

    /* access modifiers changed from: package-private */
    public void R(String str, String str2) {
        try {
            this.f16895d.k(str, str2);
        } catch (IllegalArgumentException e5) {
            Context context = this.f16892a;
            if (context == null || !C1914j.v(context)) {
                u0.g.f().d("Attempting to set custom attribute with null key, ignoring.");
                return;
            }
            throw e5;
        }
    }

    /* access modifiers changed from: package-private */
    public void S(C1698l lVar) {
        if (!this.f16904m.p()) {
            u0.g.f().i("No crash reports are available to be sent.");
            this.f16907p.e(Boolean.FALSE);
            return;
        }
        u0.g.f().i("Crash reports are available to be sent.");
        T().o(this.f16896e.f17084a, new d(lVar));
    }

    /* access modifiers changed from: package-private */
    public void V(long j5, String str) {
        if (!I()) {
            this.f16900i.g(j5, str);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        i.c();
        if (!this.f16894c.c()) {
            String A4 = A();
            if (A4 == null || !this.f16901j.c(A4)) {
                return false;
            }
            return true;
        }
        u0.g.f().i("Found previous crash marker.");
        this.f16894c.d();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void s(j jVar) {
        t(false, jVar, false);
    }

    /* access modifiers changed from: package-private */
    public void w(String str, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, j jVar) {
        this.f16906o = jVar;
        O(str);
        C1904B b5 = new C1904B(new a(), jVar, uncaughtExceptionHandler, this.f16901j);
        this.f16905n = b5;
        Thread.setDefaultUncaughtExceptionHandler(b5);
    }

    /* access modifiers changed from: package-private */
    public boolean y(j jVar) {
        i.c();
        if (I()) {
            u0.g.f().k("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        u0.g.f().i("Finalizing previously open sessions.");
        try {
            t(true, jVar, true);
            u0.g.f().i("Closed all previously open sessions.");
            return true;
        } catch (Exception e5) {
            u0.g.f().e("Unable to finalize previously open sessions.", e5);
            return false;
        }
    }
}
