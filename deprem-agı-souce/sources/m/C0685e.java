package M;

import K.C0655b;
import K.C0660g;
import L.e;
import N.C0714h;
import N.C0719m;
import N.C0723q;
import N.C0725t;
import N.C0726u;
import N.C0727v;
import N.G;
import N.r;
import Z.i;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.collection.ArraySet;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.a;
import com.google.android.gms.common.util.h;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import k0.C1698l;
import k0.C1699m;

/* renamed from: M.e  reason: case insensitive filesystem */
public class C0685e implements Handler.Callback {

    /* renamed from: p  reason: collision with root package name */
    public static final Status f2896p = new Status(4, "Sign-out occurred while this API call was in progress.");
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static final Status f2897q = new Status(4, "The user must be signed in to make this API call.");
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public static final Object f2898r = new Object();

    /* renamed from: s  reason: collision with root package name */
    private static C0685e f2899s;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public long f2900a = WorkRequest.MIN_BACKOFF_MILLIS;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f2901b = false;

    /* renamed from: c  reason: collision with root package name */
    private C0725t f2902c;

    /* renamed from: d  reason: collision with root package name */
    private C0727v f2903d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Context f2904e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final C0660g f2905f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final G f2906g;

    /* renamed from: h  reason: collision with root package name */
    private final AtomicInteger f2907h = new AtomicInteger(1);

    /* renamed from: i  reason: collision with root package name */
    private final AtomicInteger f2908i = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final Map f2909j = new ConcurrentHashMap(5, 0.75f, 1);
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public C0699t f2910k = null;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final Set f2911l = new ArraySet();

    /* renamed from: m  reason: collision with root package name */
    private final Set f2912m = new ArraySet();
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final Handler f2913n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public volatile boolean f2914o = true;

    private C0685e(Context context, Looper looper, C0660g gVar) {
        this.f2904e = context;
        i iVar = new i(looper, this);
        this.f2913n = iVar;
        this.f2905f = gVar;
        this.f2906g = new G(gVar);
        if (h.a(context)) {
            this.f2914o = false;
        }
        iVar.sendMessage(iVar.obtainMessage(6));
    }

    public static void a() {
        synchronized (f2898r) {
            try {
                C0685e eVar = f2899s;
                if (eVar != null) {
                    eVar.f2908i.incrementAndGet();
                    Handler handler = eVar.f2913n;
                    handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public static Status g(C0682b bVar, C0655b bVar2) {
        String b5 = bVar.b();
        String valueOf = String.valueOf(bVar2);
        return new Status(bVar2, "API: " + b5 + " is not available on this device. Connection failed with: " + valueOf);
    }

    private final C0670B h(e eVar) {
        Map map = this.f2909j;
        C0682b g5 = eVar.g();
        C0670B b5 = (C0670B) map.get(g5);
        if (b5 == null) {
            b5 = new C0670B(this, eVar);
            this.f2909j.put(g5, b5);
        }
        if (b5.a()) {
            this.f2912m.add(g5);
        }
        b5.E();
        return b5;
    }

    private final C0727v i() {
        if (this.f2903d == null) {
            this.f2903d = C0726u.a(this.f2904e);
        }
        return this.f2903d;
    }

    private final void j() {
        C0725t tVar = this.f2902c;
        if (tVar != null) {
            if (tVar.c() > 0 || e()) {
                i().a(tVar);
            }
            this.f2902c = null;
        }
    }

    private final void k(C1699m mVar, int i5, e eVar) {
        C0679K b5;
        if (i5 != 0 && (b5 = C0679K.b(this, i5, eVar.g())) != null) {
            C1698l a5 = mVar.a();
            Handler handler = this.f2913n;
            handler.getClass();
            a5.b(new C0701v(handler), b5);
        }
    }

    public static C0685e u(Context context) {
        C0685e eVar;
        synchronized (f2898r) {
            try {
                if (f2899s == null) {
                    f2899s = new C0685e(context.getApplicationContext(), C0714h.b().getLooper(), C0660g.n());
                }
                eVar = f2899s;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    public final void A(e eVar, int i5, a aVar) {
        this.f2913n.sendMessage(this.f2913n.obtainMessage(4, new M(new V(i5, aVar), this.f2908i.get(), eVar)));
    }

    public final void B(e eVar, int i5, C0696p pVar, C1699m mVar, C0694n nVar) {
        k(mVar, pVar.d(), eVar);
        this.f2913n.sendMessage(this.f2913n.obtainMessage(4, new M(new W(i5, pVar, mVar, nVar), this.f2908i.get(), eVar)));
    }

    /* access modifiers changed from: package-private */
    public final void C(C0719m mVar, int i5, long j5, int i6) {
        this.f2913n.sendMessage(this.f2913n.obtainMessage(18, new C0680L(mVar, i5, j5, i6)));
    }

    public final void D(C0655b bVar, int i5) {
        if (!f(bVar, i5)) {
            Handler handler = this.f2913n;
            handler.sendMessage(handler.obtainMessage(5, i5, 0, bVar));
        }
    }

    public final void E() {
        Handler handler = this.f2913n;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void F(e eVar) {
        Handler handler = this.f2913n;
        handler.sendMessage(handler.obtainMessage(7, eVar));
    }

    public final void b(C0699t tVar) {
        synchronized (f2898r) {
            try {
                if (this.f2910k != tVar) {
                    this.f2910k = tVar;
                    this.f2911l.clear();
                }
                this.f2911l.addAll(tVar.t());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(C0699t tVar) {
        synchronized (f2898r) {
            try {
                if (this.f2910k == tVar) {
                    this.f2910k = null;
                    this.f2911l.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean e() {
        if (this.f2901b) {
            return false;
        }
        r a5 = C0723q.b().a();
        if (a5 != null && !a5.f()) {
            return false;
        }
        int a6 = this.f2906g.a(this.f2904e, 203400000);
        if (a6 == -1 || a6 == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean f(C0655b bVar, int i5) {
        return this.f2905f.x(this.f2904e, bVar, i5);
    }

    public final boolean handleMessage(Message message) {
        int i5 = message.what;
        long j5 = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        C0670B b5 = null;
        switch (i5) {
            case 1:
                if (true == ((Boolean) message.obj).booleanValue()) {
                    j5 = WorkRequest.MIN_BACKOFF_MILLIS;
                }
                this.f2900a = j5;
                this.f2913n.removeMessages(12);
                for (C0682b obtainMessage : this.f2909j.keySet()) {
                    Handler handler = this.f2913n;
                    handler.sendMessageDelayed(handler.obtainMessage(12, obtainMessage), this.f2900a);
                }
                break;
            case 2:
                android.support.v4.media.a.a(message.obj);
                throw null;
            case 3:
                for (C0670B b6 : this.f2909j.values()) {
                    b6.D();
                    b6.E();
                }
                break;
            case 4:
            case 8:
            case 13:
                M m5 = (M) message.obj;
                C0670B b7 = (C0670B) this.f2909j.get(m5.f2856c.g());
                if (b7 == null) {
                    b7 = h(m5.f2856c);
                }
                if (b7.a() && this.f2908i.get() != m5.f2855b) {
                    m5.f2854a.a(f2896p);
                    b7.K();
                    break;
                } else {
                    b7.F(m5.f2854a);
                    break;
                }
            case 5:
                int i6 = message.arg1;
                C0655b bVar = (C0655b) message.obj;
                Iterator it = this.f2909j.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        C0670B b8 = (C0670B) it.next();
                        if (b8.s() == i6) {
                            b5 = b8;
                        }
                    }
                }
                if (b5 != null) {
                    if (bVar.c() != 13) {
                        b5.e(g(b5.f2821k, bVar));
                        break;
                    } else {
                        String e5 = this.f2905f.e(bVar.c());
                        String d5 = bVar.d();
                        b5.e(new Status(17, "Error resolution was canceled by the user, original error message: " + e5 + ": " + d5));
                        break;
                    }
                } else {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i6 + " while trying to fail enqueued calls.", new Exception());
                    break;
                }
            case 6:
                if (this.f2904e.getApplicationContext() instanceof Application) {
                    C0683c.c((Application) this.f2904e.getApplicationContext());
                    C0683c.b().a(new C0702w(this));
                    if (!C0683c.b().e(true)) {
                        this.f2900a = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
                        break;
                    }
                }
                break;
            case 7:
                h((e) message.obj);
                break;
            case 9:
                if (this.f2909j.containsKey(message.obj)) {
                    ((C0670B) this.f2909j.get(message.obj)).J();
                    break;
                }
                break;
            case 10:
                for (C0682b remove : this.f2912m) {
                    C0670B b9 = (C0670B) this.f2909j.remove(remove);
                    if (b9 != null) {
                        b9.K();
                    }
                }
                this.f2912m.clear();
                break;
            case 11:
                if (this.f2909j.containsKey(message.obj)) {
                    ((C0670B) this.f2909j.get(message.obj)).L();
                    break;
                }
                break;
            case 12:
                if (this.f2909j.containsKey(message.obj)) {
                    ((C0670B) this.f2909j.get(message.obj)).b();
                    break;
                }
                break;
            case 14:
                android.support.v4.media.a.a(message.obj);
                throw null;
            case 15:
                C0672D d6 = (C0672D) message.obj;
                if (this.f2909j.containsKey(d6.f2832a)) {
                    C0670B.B((C0670B) this.f2909j.get(d6.f2832a), d6);
                    break;
                }
                break;
            case 16:
                C0672D d7 = (C0672D) message.obj;
                if (this.f2909j.containsKey(d7.f2832a)) {
                    C0670B.C((C0670B) this.f2909j.get(d7.f2832a), d7);
                    break;
                }
                break;
            case 17:
                j();
                break;
            case 18:
                C0680L l5 = (C0680L) message.obj;
                if (l5.f2852c != 0) {
                    C0725t tVar = this.f2902c;
                    if (tVar != null) {
                        List d8 = tVar.d();
                        if (tVar.c() != l5.f2851b || (d8 != null && d8.size() >= l5.f2853d)) {
                            this.f2913n.removeMessages(17);
                            j();
                        } else {
                            this.f2902c.f(l5.f2850a);
                        }
                    }
                    if (this.f2902c == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(l5.f2850a);
                        this.f2902c = new C0725t(l5.f2851b, arrayList);
                        Handler handler2 = this.f2913n;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), l5.f2852c);
                        break;
                    }
                } else {
                    i().a(new C0725t(l5.f2851b, Arrays.asList(new C0719m[]{l5.f2850a})));
                    break;
                }
                break;
            case 19:
                this.f2901b = false;
                break;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i5);
                return false;
        }
        return true;
    }

    public final int l() {
        return this.f2907h.getAndIncrement();
    }

    /* access modifiers changed from: package-private */
    public final C0670B t(C0682b bVar) {
        return (C0670B) this.f2909j.get(bVar);
    }
}
