package o0;

import M.C0683c;
import N.C0720n;
import N.C0722p;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import com.google.android.gms.common.util.k;
import com.google.android.gms.common.util.n;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.provider.FirebaseInitProvider;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import f1.C1663b;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import r0.C1786c;
import r0.C1790g;
import r0.o;
import r0.x;
import s0.l;

public class f {
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final Object f15638k = new Object();

    /* renamed from: l  reason: collision with root package name */
    static final Map f15639l = new ArrayMap();

    /* renamed from: a  reason: collision with root package name */
    private final Context f15640a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15641b;

    /* renamed from: c  reason: collision with root package name */
    private final o f15642c;

    /* renamed from: d  reason: collision with root package name */
    private final o f15643d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f15644e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f15645f = new AtomicBoolean();

    /* renamed from: g  reason: collision with root package name */
    private final x f15646g;

    /* renamed from: h  reason: collision with root package name */
    private final R0.b f15647h;

    /* renamed from: i  reason: collision with root package name */
    private final List f15648i = new CopyOnWriteArrayList();

    /* renamed from: j  reason: collision with root package name */
    private final List f15649j = new CopyOnWriteArrayList();

    public interface a {
        void a(boolean z4);
    }

    private static class b implements C0683c.a {

        /* renamed from: a  reason: collision with root package name */
        private static AtomicReference f15650a = new AtomicReference();

        private b() {
        }

        /* access modifiers changed from: private */
        public static void c(Context context) {
            if (k.a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f15650a.get() == null) {
                    b bVar = new b();
                    if (androidx.lifecycle.a.a(f15650a, (Object) null, bVar)) {
                        C0683c.c(application);
                        C0683c.b().a(bVar);
                    }
                }
            }
        }

        public void a(boolean z4) {
            synchronized (f.f15638k) {
                try {
                    ArrayList arrayList = new ArrayList(f.f15639l.values());
                    int size = arrayList.size();
                    int i5 = 0;
                    while (i5 < size) {
                        Object obj = arrayList.get(i5);
                        i5++;
                        f fVar = (f) obj;
                        if (fVar.f15644e.get()) {
                            fVar.w(z4);
                        }
                    }
                } finally {
                }
            }
        }
    }

    private static class c extends BroadcastReceiver {

        /* renamed from: b  reason: collision with root package name */
        private static AtomicReference f15651b = new AtomicReference();

        /* renamed from: a  reason: collision with root package name */
        private final Context f15652a;

        public c(Context context) {
            this.f15652a = context;
        }

        /* access modifiers changed from: private */
        public static void b(Context context) {
            if (f15651b.get() == null) {
                c cVar = new c(context);
                if (androidx.lifecycle.a.a(f15651b, (Object) null, cVar)) {
                    context.registerReceiver(cVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f15652a.unregisterReceiver(this);
        }

        public void onReceive(Context context, Intent intent) {
            synchronized (f.f15638k) {
                try {
                    for (f d5 : f.f15639l.values()) {
                        d5.p();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            c();
        }
    }

    protected f(Context context, String str, o oVar) {
        this.f15640a = (Context) C0722p.k(context);
        this.f15641b = C0722p.e(str);
        this.f15642c = (o) C0722p.k(oVar);
        p b5 = FirebaseInitProvider.b();
        f1.c.b("Firebase");
        f1.c.b("ComponentDiscovery");
        List b6 = C1790g.c(context, ComponentDiscoveryService.class).b();
        f1.c.a();
        f1.c.b("Runtime");
        o.b f5 = o.m(l.INSTANCE).d(b6).c(new FirebaseCommonRegistrar()).c(new ExecutorsRegistrar()).b(C1786c.q(context, Context.class, new Class[0])).b(C1786c.q(this, f.class, new Class[0])).b(C1786c.q(oVar, o.class, new Class[0])).f(new C1663b());
        if (UserManagerCompat.isUserUnlocked(context) && FirebaseInitProvider.c()) {
            f5.b(C1786c.q(b5, p.class, new Class[0]));
        }
        o e5 = f5.e();
        this.f15643d = e5;
        f1.c.a();
        this.f15646g = new x(new C1731d(this, context));
        this.f15647h = e5.c(P0.f.class);
        g(new e(this));
        f1.c.a();
    }

    public static /* synthetic */ void a(f fVar, boolean z4) {
        if (!z4) {
            ((P0.f) fVar.f15647h.get()).h();
        } else {
            fVar.getClass();
        }
    }

    public static /* synthetic */ W0.a b(f fVar, Context context) {
        return new W0.a(context, fVar.o(), (O0.c) fVar.f15643d.a(O0.c.class));
    }

    private void i() {
        C0722p.o(!this.f15645f.get(), "FirebaseApp was deleted");
    }

    public static f l() {
        f fVar;
        synchronized (f15638k) {
            try {
                fVar = (f) f15639l.get("[DEFAULT]");
                if (fVar != null) {
                    ((P0.f) fVar.f15647h.get()).h();
                } else {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + n.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    /* access modifiers changed from: private */
    public void p() {
        if (!UserManagerCompat.isUserUnlocked(this.f15640a)) {
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + m());
            c.b(this.f15640a);
            return;
        }
        Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + m());
        this.f15643d.p(u());
        ((P0.f) this.f15647h.get()).h();
    }

    public static f q(Context context) {
        synchronized (f15638k) {
            try {
                if (f15639l.containsKey("[DEFAULT]")) {
                    f l5 = l();
                    return l5;
                }
                o a5 = o.a(context);
                if (a5 == null) {
                    Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                f r5 = r(context, a5);
                return r5;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static f r(Context context, o oVar) {
        return s(context, oVar, "[DEFAULT]");
    }

    public static f s(Context context, o oVar, String str) {
        f fVar;
        b.c(context);
        String v5 = v(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f15638k) {
            Map map = f15639l;
            C0722p.o(!map.containsKey(v5), "FirebaseApp name " + v5 + " already exists!");
            C0722p.l(context, "Application context cannot be null.");
            fVar = new f(context, v5, oVar);
            map.put(v5, fVar);
        }
        fVar.p();
        return fVar;
    }

    private static String v(String str) {
        return str.trim();
    }

    /* access modifiers changed from: private */
    public void w(boolean z4) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (a a5 : this.f15648i) {
            a5.a(z4);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        return this.f15641b.equals(((f) obj).m());
    }

    public void g(a aVar) {
        i();
        if (this.f15644e.get() && C0683c.b().d()) {
            aVar.a(true);
        }
        this.f15648i.add(aVar);
    }

    public void h(g gVar) {
        i();
        C0722p.k(gVar);
        this.f15649j.add(gVar);
    }

    public int hashCode() {
        return this.f15641b.hashCode();
    }

    public Object j(Class cls) {
        i();
        return this.f15643d.a(cls);
    }

    public Context k() {
        i();
        return this.f15640a;
    }

    public String m() {
        i();
        return this.f15641b;
    }

    public o n() {
        i();
        return this.f15642c;
    }

    public String o() {
        return com.google.android.gms.common.util.c.a(m().getBytes(Charset.defaultCharset())) + "+" + com.google.android.gms.common.util.c.a(n().c().getBytes(Charset.defaultCharset()));
    }

    public boolean t() {
        i();
        return ((W0.a) this.f15646g.get()).b();
    }

    public String toString() {
        return C0720n.c(this).a(RewardPlus.NAME, this.f15641b).a("options", this.f15642c).toString();
    }

    public boolean u() {
        return "[DEFAULT]".equals(m());
    }
}
