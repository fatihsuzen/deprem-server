package S1;

import T1.C2194t;
import T1.S0;
import U1.C2201a;
import W2.J;
import W2.u;
import X1.C2229f;
import Y1.C2257a;
import Y1.C2259c;
import Y1.C2260d;
import Z1.C2261a;
import Z1.C2263c;
import Z1.h;
import Z1.i;
import a2.C2264a;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.Uri;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.provider.Settings;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.app.NotificationCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.multidex.MultiDexApplication;
import androidx.work.PeriodicWorkRequest;
import b2.C2285e;
import b2.C2290j;
import b2.C2291k;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.File;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2625c;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;

public abstract class k extends MultiDexApplication {
    /* access modifiers changed from: private */

    /* renamed from: A  reason: collision with root package name */
    public static String f30A;
    /* access modifiers changed from: private */

    /* renamed from: B  reason: collision with root package name */
    public static String f31B;

    /* renamed from: g  reason: collision with root package name */
    public static final a f32g = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static Activity f33h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static Y1.e f34i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static int f35j;

    /* renamed from: k  reason: collision with root package name */
    public static Context f36k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static boolean f37l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static boolean f38m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public static int f39n;

    /* renamed from: o  reason: collision with root package name */
    public static String f40o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public static ResultReceiver f41p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static String f42q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public static C2257a f43r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public static C2259c f44s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public static Typeface f45t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public static Typeface f46u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public static h f47v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public static C2263c f48w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public static boolean f49x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public static String f50y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public static String f51z;

    /* renamed from: a  reason: collision with root package name */
    private ResultReceiver f52a = new C2264a((Handler) null);

    /* renamed from: b  reason: collision with root package name */
    private AtomicBoolean f53b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private AtomicBoolean f54c = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f55d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    private i f56e = S();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public NsdManager.RegistrationListener f57f = new c(this);

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final boolean A(Context context) {
            t.e(context, "context");
            Configuration configuration = context.getResources().getConfiguration();
            if ((configuration.screenLayout & 15) < 3 || configuration.smallestScreenWidthDp < 600) {
                return false;
            }
            return true;
        }

        public final void B(String str, long j5, String str2, long j6) {
            t.e(str, "packageName");
            t.e(str2, RewardPlus.NAME);
            k.f43r = new C2257a();
            C2257a b5 = k.f43r;
            if (b5 != null) {
                b5.f(str, j5, str2, j6);
            }
        }

        public final void C(String str, int i5) {
            t.e(str, "filename");
            F(new C2259c());
            C2259c j5 = j();
            if (j5 != null) {
                j5.c(str, i5);
            }
        }

        public final void D(Activity activity) {
            k.f33h = activity;
        }

        public final void E(Context context) {
            t.e(context, "<set-?>");
            k.f36k = context;
        }

        public final void F(C2259c cVar) {
            k.f44s = cVar;
        }

        public final void G(boolean z4) {
            k.f38m = z4;
        }

        public final void H(String str) {
            k.f50y = str;
        }

        public final void I(String str) {
            k.f51z = str;
        }

        public final void J(Y1.e eVar) {
            k.f34i = eVar;
        }

        public final void K(int i5) {
            k.f35j = i5;
        }

        public final void L(h hVar) {
            k.f47v = hVar;
        }

        public final void M(String str) {
            t.e(str, "<set-?>");
            k.f40o = str;
        }

        public final void N(int i5) {
            k.f39n = i5;
        }

        public final void O(C2263c cVar) {
            k.f48w = cVar;
        }

        public final void P(boolean z4) {
            k.f49x = z4;
        }

        public final void Q(String str) {
            k.f31B = str;
        }

        public final void R(String str) {
            k.f30A = str;
        }

        public final void S(String str) {
            k.f42q = str;
        }

        public final void T(ResultReceiver resultReceiver) {
            k.f41p = resultReceiver;
        }

        public final void U(boolean z4) {
            k.f37l = z4;
        }

        public final void V(int i5) {
            C2259c j5 = j();
            if (j5 != null) {
                j5.d(i5);
            }
        }

        public final Context a(Context context) {
            t.e(context, "context");
            String f5 = new C2201a(context).f();
            if (f5 == null) {
                return context;
            }
            return C2285e.f20689a.a(context, new Locale(f5));
        }

        public final void b() {
            c((String) null);
        }

        public final void c(String str) {
            File[] listFiles = new C2290j().g(h()).listFiles();
            if (listFiles != null) {
                Iterator a5 = C2625c.a(listFiles);
                while (a5.hasNext()) {
                    File file = (File) a5.next();
                    if (!s.E(file.getAbsolutePath(), str, true) && file.lastModified() < System.currentTimeMillis() - ((long) 3600000)) {
                        C2291k kVar = new C2291k();
                        t.b(file);
                        kVar.a(file);
                    }
                }
            }
        }

        public final void d(Context context, EditText editText) {
            IBinder iBinder;
            t.e(context, "<this>");
            Object systemService = context.getSystemService("input_method");
            t.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (editText != null) {
                iBinder = editText.getWindowToken();
            } else {
                iBinder = null;
            }
            inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
        }

        public final void e() {
            k.f43r = null;
        }

        public final void f() {
            F((C2259c) null);
        }

        public final Activity g() {
            return k.f33h;
        }

        public final Context h() {
            Context context = k.f36k;
            if (context != null) {
                return context;
            }
            t.w("appContext");
            return null;
        }

        public final C2257a i() {
            if (k.f43r == null) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            C2257a b5 = k.f43r;
            t.b(b5);
            if (currentTimeMillis - b5.d() > PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
                k.f43r = null;
            }
            return k.f43r;
        }

        public final C2259c j() {
            return k.f44s;
        }

        public final String k() {
            return k.f50y;
        }

        public final String l() {
            return k.f51z;
        }

        public final Y1.e m() {
            return k.f34i;
        }

        public final int n() {
            return k.f35j;
        }

        public final h o() {
            return k.f47v;
        }

        public final String p() {
            String str = k.f40o;
            if (str != null) {
                return str;
            }
            t.w("myNsdServiceName");
            return null;
        }

        public final int q() {
            return k.f39n;
        }

        public final C2263c r() {
            return k.f48w;
        }

        public final boolean s() {
            return k.f49x;
        }

        public final String t() {
            return k.f31B;
        }

        public final String u() {
            return k.f30A;
        }

        public final ResultReceiver v() {
            return k.f41p;
        }

        public final Typeface w() {
            return k.f45t;
        }

        public final Typeface x() {
            return k.f46u;
        }

        public final boolean y() {
            return k.f38m;
        }

        public final boolean z() {
            return k.f37l;
        }

        private a() {
        }
    }

    public static final class c implements NsdManager.RegistrationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f59a;

        c(k kVar) {
            this.f59a = kVar;
        }

        public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i5) {
            t.e(nsdServiceInfo, "nsdServiceInfo");
            this.f59a.U("onRegistrationFailed");
            this.f59a.X();
        }

        public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
            t.e(nsdServiceInfo, "nsdServiceInfo");
            k.f32g.M(nsdServiceInfo.getServiceName());
            this.f59a.f55d.set(true);
        }

        public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
            t.e(nsdServiceInfo, "nsdServiceInfo");
            this.f59a.a0();
        }

        public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i5) {
            t.e(nsdServiceInfo, "nsdServiceInfo");
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f60a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DocumentFile f61b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f62c;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f63a;

            a(C2308e eVar) {
                super(2, eVar);
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f63a == 0) {
                    u.b(obj);
                    a aVar = k.f32g;
                    if (aVar.g() != null && (aVar.g() instanceof S0)) {
                        Activity g5 = aVar.g();
                        t.c(g5, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                        ((S0) g5).u1(true);
                    }
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f64a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ L f65b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ k f66c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(L l5, k kVar, C2308e eVar) {
                super(2, eVar);
                this.f65b = l5;
                this.f66c = kVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f65b, this.f66c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f64a == 0) {
                    u.b(obj);
                    Object obj2 = this.f65b.f24690a;
                    if (obj2 != null) {
                        this.f66c.Z((File) obj2);
                    }
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(DocumentFile documentFile, k kVar, C2308e eVar) {
            super(2, eVar);
            this.f61b = documentFile;
            this.f62c = kVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f61b, this.f62c, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b0, code lost:
            if (w3.C2872g.g(r11, r1, r10) == r0) goto L_0x00b2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b2, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
            if (w3.C2872g.g(r11, r1, r10) == r0) goto L_0x00b2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r10.f60a
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L_0x0020
                if (r1 == r3) goto L_0x001c
                if (r1 != r2) goto L_0x0014
                W2.u.b(r11)
                goto L_0x00b3
            L_0x0014:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x001c:
                W2.u.b(r11)
                goto L_0x0036
            L_0x0020:
                W2.u.b(r11)
                w3.I0 r11 = w3.C2865c0.c()
                S1.k$d$a r1 = new S1.k$d$a
                r1.<init>(r4)
                r10.f60a = r3
                java.lang.Object r11 = w3.C2872g.g(r11, r1, r10)
                if (r11 != r0) goto L_0x0036
                goto L_0x00b2
            L_0x0036:
                S1.k$a r11 = S1.k.f32g
                android.content.Context r1 = r11.h()
                android.content.ContentResolver r1 = r1.getContentResolver()
                if (r1 == 0) goto L_0x004d
                androidx.documentfile.provider.DocumentFile r3 = r10.f61b
                android.net.Uri r3 = r3.getUri()
                java.io.InputStream r1 = r1.openInputStream(r3)
                goto L_0x004e
            L_0x004d:
                r1 = r4
            L_0x004e:
                kotlin.jvm.internal.L r3 = new kotlin.jvm.internal.L
                r3.<init>()
                if (r1 == 0) goto L_0x009f
                r5 = 8192(0x2000, float:1.14794E-41)
                byte[] r6 = new byte[r5]
                kotlin.jvm.internal.J r7 = new kotlin.jvm.internal.J
                r7.<init>()
                b2.j r8 = new b2.j
                r8.<init>()
                android.content.Context r11 = r11.h()
                java.io.File r11 = r8.g(r11)
                androidx.documentfile.provider.DocumentFile r8 = r10.f61b
                java.lang.String r8 = r8.getName()
                if (r8 == 0) goto L_0x009c
                java.io.File r8 = new java.io.File
                androidx.documentfile.provider.DocumentFile r9 = r10.f61b
                java.lang.String r9 = r9.getName()
                kotlin.jvm.internal.t.b(r9)
                r8.<init>(r11, r9)
                r3.f24690a = r8
                java.io.FileOutputStream r11 = new java.io.FileOutputStream
                java.lang.Object r8 = r3.f24690a
                java.io.File r8 = (java.io.File) r8
                r11.<init>(r8)
            L_0x008c:
                r8 = 0
                int r9 = r1.read(r6, r8, r5)
                r7.f24688a = r9
                if (r9 <= 0) goto L_0x0099
                r11.write(r6, r8, r9)
                goto L_0x008c
            L_0x0099:
                r11.close()
            L_0x009c:
                r1.close()
            L_0x009f:
                w3.I0 r11 = w3.C2865c0.c()
                S1.k$d$b r1 = new S1.k$d$b
                S1.k r5 = r10.f62c
                r1.<init>(r3, r5, r4)
                r10.f60a = r2
                java.lang.Object r11 = w3.C2872g.g(r11, r1, r10)
                if (r11 != r0) goto L_0x00b3
            L_0x00b2:
                return r0
            L_0x00b3:
                W2.J r11 = W2.J.f19942a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: S1.k.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f67a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k f68b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DocumentFile f69c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(k kVar, DocumentFile documentFile, C2308e eVar) {
            super(2, eVar);
            this.f68b = kVar;
            this.f69c = documentFile;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f68b, this.f69c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f67a;
            if (i5 == 0) {
                u.b(obj);
                k kVar = this.f68b;
                DocumentFile documentFile = this.f69c;
                this.f67a = 1;
                if (kVar.V(documentFile, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class f implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f70a;

        f(k kVar) {
            this.f70a = kVar;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            t.e(activity, "activity");
            if (activity instanceof S0) {
                a aVar = k.f32g;
                aVar.N(aVar.q() + 1);
                if (aVar.q() == 1) {
                    this.f70a.T(activity);
                }
            }
        }

        public void onActivityDestroyed(Activity activity) {
            t.e(activity, "activity");
            if (activity instanceof S0) {
                a aVar = k.f32g;
                if (aVar.q() > 0) {
                    aVar.N(aVar.q() - 1);
                }
                if (aVar.q() == 0) {
                    this.f70a.W();
                    aVar.L((h) null);
                    aVar.O((C2263c) null);
                }
            }
        }

        public void onActivityPaused(Activity activity) {
            t.e(activity, "activity");
            k.f32g.D((Activity) null);
        }

        public void onActivityResumed(Activity activity) {
            t.e(activity, "activity");
            k.f32g.D(activity);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            t.e(activity, "activity");
            t.e(bundle, "outState");
        }

        public void onActivityStarted(Activity activity) {
            t.e(activity, "activity");
        }

        public void onActivityStopped(Activity activity) {
            t.e(activity, "activity");
        }
    }

    private final i S() {
        return new b(this);
    }

    /* access modifiers changed from: private */
    public final Object V(DocumentFile documentFile, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new d(documentFile, this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    private final void c0() {
        AssetManager assetManager;
        try {
            assetManager = getAssets();
        } catch (Exception e5) {
            e5.printStackTrace();
            assetManager = null;
        }
        if (assetManager != null) {
            f45t = Typeface.createFromAsset(assetManager, "fonts/Geomanist-Medium.ttf");
            f46u = Typeface.createFromAsset(assetManager, "fonts/Geomanist-Regular.ttf");
            return;
        }
        Typeface typeface = Typeface.DEFAULT;
        f45t = typeface;
        f46u = typeface;
    }

    private final void d0() {
        registerActivityLifecycleCallbacks(new f(this));
    }

    /* access modifiers changed from: private */
    public final void e0() {
        NsdManager f5;
        try {
            h hVar = f47v;
            if (hVar != null && (f5 = hVar.f()) != null) {
                f5.unregisterService(this.f57f);
            }
        } catch (Exception unused) {
        }
    }

    public void N(Uri uri, C2229f fVar, C2194t tVar) {
        t.e(uri, "uri");
        t.e(fVar, "listener");
        t.e(tVar, "coreBaseActivity");
        fVar.a();
    }

    public void O(File file, C2229f fVar, C2194t tVar) {
        t.e(file, "file");
        t.e(fVar, "listener");
        t.e(tVar, "coreBaseActivity");
        fVar.a();
    }

    public final void P() {
        if (!this.f55d.get() && this.f53b.compareAndSet(true, false)) {
            T(f32g.h());
        }
    }

    public final AtomicBoolean Q() {
        return this.f54c;
    }

    public final ResultReceiver R() {
        return this.f52a;
    }

    public final void T(Context context) {
        t.e(context, "context");
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        a aVar = f32g;
        h.a aVar2 = h.f20257h;
        t.b(string);
        aVar.M(aVar2.b(string));
        if (f47v == null) {
            f47v = new h(context, this.f56e);
        }
        f48w = new C2263c(this.f56e, context);
    }

    public abstract void U(String str);

    public final void W() {
        e0();
        C2263c cVar = f48w;
        if (cVar != null) {
            cVar.r();
        }
        h hVar = f47v;
        if (hVar != null) {
            hVar.j();
        }
    }

    public final void X() {
        if (this.f53b.compareAndSet(false, true)) {
            W();
        }
    }

    public final void Y(DocumentFile documentFile) {
        t.e(documentFile, "docfile");
        C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new e(this, documentFile, (C2308e) null), 3, (Object) null);
    }

    public final void Z(File file) {
        t.e(file, "file");
        C2260d dVar = new C2260d();
        dVar.a(file);
        C2263c cVar = f48w;
        t.b(cVar);
        cVar.q(dVar);
    }

    public final void a0() {
        if (this.f53b.get()) {
            this.f55d.set(false);
        }
        if (!this.f54c.get() && this.f53b.compareAndSet(true, false)) {
            T(f32g.h());
        }
    }

    public final void b0(ResultReceiver resultReceiver) {
        t.e(resultReceiver, "<set-?>");
        this.f52a = resultReceiver;
    }

    public void onCreate() {
        super.onCreate();
        d0();
        a aVar = f32g;
        Context applicationContext = getApplicationContext();
        t.d(applicationContext, "getApplicationContext(...)");
        aVar.E(aVar.a(applicationContext));
        c0();
    }

    public static final class b implements i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f58a;

        b(k kVar) {
            this.f58a = kVar;
        }

        public void a() {
            C2263c r5 = k.f32g.r();
            if (r5 != null) {
                r5.c();
            }
        }

        public void b() {
            this.f58a.U("onReadResponseFailed");
            this.f58a.X();
        }

        public void c() {
            this.f58a.U("onConnectionToServerFailed");
            this.f58a.X();
        }

        public void d(String str) {
            C2263c r5;
            Z1.d i5;
            t.e(str, "remoteSocketAddress");
            a aVar = k.f32g;
            C2263c r6 = aVar.r();
            t.b(r6);
            if (r6.k()) {
                if (aVar.g() != null && (aVar.g() instanceof S0)) {
                    Activity g5 = aVar.g();
                    t.c(g5, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                    ((S0) g5).b1();
                }
            } else if (aVar.o() != null && (r5 = aVar.r()) != null && (i5 = r5.i()) != null) {
                i5.l();
            }
        }

        public void e() {
            this.f58a.U("onDiscoveryServicesFailed");
        }

        public void f(int i5) {
            this.f58a.e0();
            a aVar = k.f32g;
            h o5 = aVar.o();
            if (o5 != null) {
                o5.i(i5, this.f58a.f57f);
            }
            h o6 = aVar.o();
            if (o6 != null) {
                o6.d();
            }
        }

        public void g() {
            this.f58a.Q().set(false);
            this.f58a.P();
        }

        public void i() {
            this.f58a.U("onRegistrationFailed");
            this.f58a.X();
        }

        public void j() {
            this.f58a.U("onReadResponseClosed");
            this.f58a.X();
        }

        public void k(C2260d dVar) {
            t.e(dVar, "fti");
            C2263c r5 = k.f32g.r();
            t.b(r5);
            r5.i().m(dVar);
        }

        public void l() {
            a aVar = k.f32g;
            if (aVar.g() == null || !(aVar.g() instanceof S0)) {
                aVar.P(true);
            } else {
                Activity g5 = aVar.g();
                t.c(g5, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                ((S0) g5).X0();
            }
            C2263c r5 = aVar.r();
            t.b(r5);
            r5.i().l();
        }

        public void m(String str) {
            t.e(str, NotificationCompat.CATEGORY_MESSAGE);
            k kVar = this.f58a;
            kVar.U("onReceivingFileError: " + str);
            a aVar = k.f32g;
            if (aVar.g() == null || !(aVar.g() instanceof S0)) {
                aVar.Q(str);
            } else {
                Activity g5 = aVar.g();
                t.c(g5, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                ((S0) g5).c1(str);
            }
            this.f58a.X();
        }

        public void n(int i5) {
            a aVar = k.f32g;
            if (aVar.g() != null && (aVar.g() instanceof S0)) {
                Activity g5 = aVar.g();
                t.c(g5, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                ((S0) g5).y1(i5);
            }
        }

        public void o(int i5) {
            a aVar = k.f32g;
            if (aVar.g() != null && (aVar.g() instanceof S0)) {
                Activity g5 = aVar.g();
                t.c(g5, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                ((S0) g5).y1(i5);
            }
        }

        public void p(String str) {
            t.e(str, NotificationCompat.CATEGORY_MESSAGE);
            this.f58a.U(str);
            this.f58a.X();
        }

        public void q(C2260d dVar) {
            C2263c r5;
            C2261a h5;
            t.e(dVar, "fti");
            if (dVar.d() != null && (r5 = k.f32g.r()) != null && (h5 = r5.h()) != null) {
                File d5 = dVar.d();
                t.b(d5);
                h5.f(d5);
            }
        }

        public void s(String str) {
            NsdServiceInfo nsdServiceInfo;
            t.e(str, "serviceName");
            a aVar = k.f32g;
            C2263c r5 = aVar.r();
            t.b(r5);
            if (!r5.k()) {
                h o5 = aVar.o();
                t.b(o5);
                Iterator it = o5.g().iterator();
                t.d(it, "iterator(...)");
                while (true) {
                    if (!it.hasNext()) {
                        nsdServiceInfo = null;
                        break;
                    }
                    Object next = it.next();
                    t.d(next, "next(...)");
                    nsdServiceInfo = (NsdServiceInfo) next;
                    if (s.E(str, nsdServiceInfo.getServiceName(), true)) {
                        break;
                    }
                }
                if (nsdServiceInfo != null) {
                    h o6 = k.f32g.o();
                    t.b(o6);
                    o6.k(nsdServiceInfo);
                    return;
                }
                this.f58a.X();
                a aVar2 = k.f32g;
                if (aVar2.g() != null && (aVar2.g() instanceof S0)) {
                    Activity g5 = aVar2.g();
                    t.c(g5, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                    String string = aVar2.h().getString(i.error_nsd_service_not_found, new Object[]{h.f20257h.c(str)});
                    t.d(string, "getString(...)");
                    ((S0) g5).c1(string);
                }
            }
        }

        public void t() {
            this.f58a.Q().set(true);
        }

        public void u(File file) {
            t.e(file, "file");
            a aVar = k.f32g;
            if (aVar.g() != null && (aVar.g() instanceof S0)) {
                Activity g5 = aVar.g();
                t.c(g5, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                ((S0) g5).w1();
            }
        }

        public void v(C2260d dVar) {
            t.e(dVar, "fti");
            a aVar = k.f32g;
            if (aVar.g() != null && (aVar.g() instanceof S0)) {
                Activity g5 = aVar.g();
                t.c(g5, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                ((S0) g5).P0(dVar);
            }
        }

        public void w() {
            C2263c r5 = k.f32g.r();
            t.b(r5);
            r5.i().l();
        }

        public void x(String str) {
            t.e(str, NotificationCompat.CATEGORY_MESSAGE);
            k kVar = this.f58a;
            kVar.U("onSendFileFailed: " + str);
            this.f58a.X();
            a aVar = k.f32g;
            if (aVar.g() == null || !(aVar.g() instanceof S0)) {
                aVar.R(str);
                return;
            }
            Activity g5 = aVar.g();
            t.c(g5, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
            ((S0) g5).h1(str);
        }

        public void y(String str, String str2) {
            C2261a h5;
            t.e(str, "filename");
            t.e(str2, "result");
            a aVar = k.f32g;
            if (aVar.g() == null || !(aVar.g() instanceof S0)) {
                aVar.H(str);
                aVar.I(str2);
            } else {
                Activity g5 = aVar.g();
                t.c(g5, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                ((S0) g5).V0(str, str2);
            }
            C2263c r5 = aVar.r();
            if (r5 != null && (h5 = r5.h()) != null) {
                h5.e();
            }
        }

        public void z(NsdServiceInfo nsdServiceInfo) {
            t.e(nsdServiceInfo, "nsdServiceInfo");
            a aVar = k.f32g;
            C2263c r5 = aVar.r();
            if (r5 != null) {
                r5.p();
            }
            if (aVar.g() != null && (aVar.g() instanceof S0)) {
                Activity g5 = aVar.g();
                t.c(g5, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                ((S0) g5).f1(nsdServiceInfo);
            }
        }

        public void h() {
        }

        public void r() {
        }
    }
}
