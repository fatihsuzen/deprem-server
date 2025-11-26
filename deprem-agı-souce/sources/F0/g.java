package F0;

import C0.b;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import k0.C1697k;
import k0.C1698l;
import k0.C1699m;
import k0.C1701o;
import org.json.JSONObject;
import x0.C;
import x0.C1914j;
import x0.D;
import x0.E;
import x0.I;
import x0.a0;
import y0.i;

public class g implements j {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2439a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final k f2440b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final h f2441c;

    /* renamed from: d  reason: collision with root package name */
    private final C f2442d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final a f2443e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final l f2444f;

    /* renamed from: g  reason: collision with root package name */
    private final D f2445g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final AtomicReference f2446h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final AtomicReference f2447i = new AtomicReference(new C1699m());

    class a implements C1697k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f2448a;

        a(i iVar) {
            this.f2448a = iVar;
        }

        /* renamed from: c */
        public C1698l a(Void voidR) {
            JSONObject jSONObject = (JSONObject) this.f2448a.f17087d.c().submit(new f(this)).get();
            if (jSONObject != null) {
                d b5 = g.this.f2441c.b(jSONObject);
                g.this.f2443e.c(b5.f2423c, jSONObject);
                g.this.q(jSONObject, "Loaded settings: ");
                g gVar = g.this;
                boolean unused = gVar.r(gVar.f2440b.f2456f);
                g.this.f2446h.set(b5);
                ((C1699m) g.this.f2447i.get()).e(b5);
            }
            return C1701o.e((Object) null);
        }
    }

    g(Context context, k kVar, C c5, h hVar, a aVar, l lVar, D d5) {
        AtomicReference atomicReference = new AtomicReference();
        this.f2446h = atomicReference;
        this.f2439a = context;
        this.f2440b = kVar;
        this.f2442d = c5;
        this.f2441c = hVar;
        this.f2443e = aVar;
        this.f2444f = lVar;
        this.f2445g = d5;
        atomicReference.set(b.b(c5));
    }

    public static g l(Context context, String str, I i5, b bVar, String str2, String str3, D0.g gVar, D d5) {
        String g5 = i5.g();
        a0 a0Var = new a0();
        h hVar = new h(a0Var);
        a aVar = new a(gVar);
        c cVar = new c(String.format(Locale.US, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", new Object[]{str}), bVar);
        String str4 = str2;
        String str5 = str3;
        return new g(context, new k(str, i5.h(), i5.i(), i5.j(), i5, C1914j.h(C1914j.m(context), str, str5, str4), str5, str4, E.b(g5).c()), a0Var, hVar, aVar, cVar, d5);
    }

    private d m(e eVar) {
        d dVar = null;
        try {
            if (!e.SKIP_CACHE_LOOKUP.equals(eVar)) {
                JSONObject b5 = this.f2443e.b();
                if (b5 != null) {
                    d b6 = this.f2441c.b(b5);
                    if (b6 != null) {
                        q(b5, "Loaded cached settings: ");
                        long a5 = this.f2442d.a();
                        if (!e.IGNORE_CACHE_EXPIRATION.equals(eVar)) {
                            if (b6.a(a5)) {
                                u0.g.f().i("Cached settings have expired.");
                                return null;
                            }
                        }
                        try {
                            u0.g.f().i("Returning cached settings.");
                            return b6;
                        } catch (Exception e5) {
                            e = e5;
                            dVar = b6;
                            u0.g.f().e("Failed to get cached settings", e);
                            return dVar;
                        }
                    } else {
                        u0.g.f().e("Failed to parse cached settings data.", (Throwable) null);
                        return null;
                    }
                } else {
                    u0.g.f().b("No cached settings data found.");
                }
            }
            return null;
        } catch (Exception e6) {
            e = e6;
            u0.g.f().e("Failed to get cached settings", e);
            return dVar;
        }
    }

    private String n() {
        return C1914j.q(this.f2439a).getString("existing_instance_identifier", "");
    }

    /* access modifiers changed from: private */
    public void q(JSONObject jSONObject, String str) {
        u0.g f5 = u0.g.f();
        f5.b(str + jSONObject.toString());
    }

    /* access modifiers changed from: private */
    public boolean r(String str) {
        SharedPreferences.Editor edit = C1914j.q(this.f2439a).edit();
        edit.putString("existing_instance_identifier", str);
        edit.apply();
        return true;
    }

    public C1698l a() {
        return ((C1699m) this.f2447i.get()).a();
    }

    public d b() {
        return (d) this.f2446h.get();
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return !n().equals(this.f2440b.f2456f);
    }

    public C1698l o(e eVar, i iVar) {
        d m5;
        if (k() || (m5 = m(eVar)) == null) {
            d m6 = m(e.IGNORE_CACHE_EXPIRATION);
            if (m6 != null) {
                this.f2446h.set(m6);
                ((C1699m) this.f2447i.get()).e(m6);
            }
            return this.f2445g.k().o(iVar.f17084a, new a(iVar));
        }
        this.f2446h.set(m5);
        ((C1699m) this.f2447i.get()).e(m5);
        return C1701o.e((Object) null);
    }

    public C1698l p(i iVar) {
        return o(e.USE_CACHE, iVar);
    }
}
