package B1;

import A1.f;
import A1.i;
import B1.b;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import u1.n;
import x1.j;
import y1.a;

public class a implements a.C0167a {

    /* renamed from: i  reason: collision with root package name */
    private static a f2293i = new a();

    /* renamed from: j  reason: collision with root package name */
    private static Handler f2294j = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static Handler f2295k = null;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final Runnable f2296l = new b();
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final Runnable f2297m = new c();

    /* renamed from: a  reason: collision with root package name */
    private List f2298a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private int f2299b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2300c = false;

    /* renamed from: d  reason: collision with root package name */
    private final List f2301d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private y1.b f2302e = new y1.b();

    /* renamed from: f  reason: collision with root package name */
    private b f2303f = new b();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public c f2304g = new c(new C1.c());

    /* renamed from: h  reason: collision with root package name */
    private long f2305h;

    /* renamed from: B1.a$a  reason: collision with other inner class name */
    class C0041a implements Runnable {
        C0041a() {
        }

        public void run() {
            a.this.f2304g.c();
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            a.p().u();
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            if (a.f2295k != null) {
                a.f2295k.post(a.f2296l);
                a.f2295k.postDelayed(a.f2297m, 200);
            }
        }
    }

    a() {
    }

    private void d(long j5) {
        if (this.f2298a.size() > 0) {
            Iterator it = this.f2298a.iterator();
            if (it.hasNext()) {
                android.support.v4.media.a.a(it.next());
                TimeUnit.NANOSECONDS.toMillis(j5);
                throw null;
            }
        }
    }

    private void e(View view, y1.a aVar, JSONObject jSONObject, d dVar, boolean z4) {
        boolean z5;
        if (dVar == d.PARENT_VIEW) {
            z5 = true;
        } else {
            z5 = false;
        }
        aVar.a(view, jSONObject, this, z5, z4);
    }

    private void f(String str, View view, JSONObject jSONObject) {
        y1.a b5 = this.f2302e.b();
        String h5 = this.f2303f.h(str);
        if (h5 != null) {
            JSONObject a5 = b5.a(view);
            A1.c.g(a5, str);
            A1.c.o(a5, h5);
            A1.c.i(jSONObject, a5);
        }
    }

    private boolean g(View view, JSONObject jSONObject) {
        b.a g5 = this.f2303f.g(view);
        if (g5 == null) {
            return false;
        }
        A1.c.e(jSONObject, g5);
        return true;
    }

    private boolean j(View view, JSONObject jSONObject) {
        String j5 = this.f2303f.j(view);
        if (j5 == null) {
            return false;
        }
        A1.c.g(jSONObject, j5);
        A1.c.f(jSONObject, Boolean.valueOf(this.f2303f.p(view)));
        A1.c.n(jSONObject, Boolean.valueOf(this.f2303f.l(j5)));
        this.f2303f.n();
        return true;
    }

    private void l() {
        d(f.b() - this.f2305h);
    }

    private void m() {
        this.f2299b = 0;
        this.f2301d.clear();
        this.f2300c = false;
        Iterator it = x1.c.e().a().iterator();
        while (true) {
            if (it.hasNext()) {
                if (((n) it.next()).p()) {
                    this.f2300c = true;
                    break;
                }
            } else {
                break;
            }
        }
        this.f2305h = f.b();
    }

    public static a p() {
        return f2293i;
    }

    private void r() {
        if (f2295k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f2295k = handler;
            handler.post(f2296l);
            f2295k.postDelayed(f2297m, 200);
        }
    }

    private void t() {
        Handler handler = f2295k;
        if (handler != null) {
            handler.removeCallbacks(f2297m);
            f2295k = null;
        }
    }

    /* access modifiers changed from: private */
    public void u() {
        m();
        n();
        l();
        j.f().a();
    }

    public void a(View view, y1.a aVar, JSONObject jSONObject, boolean z4) {
        d m5;
        a aVar2;
        boolean z5;
        if (i.f(view) && (m5 = this.f2303f.m(view)) != d.UNDERLYING_VIEW) {
            JSONObject a5 = aVar.a(view);
            A1.c.i(jSONObject, a5);
            if (!j(view, a5)) {
                boolean g5 = g(view, a5);
                if (z4 || g5) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (this.f2300c && m5 == d.OBSTRUCTION_VIEW && !z5) {
                    this.f2301d.add(new D1.a(view));
                }
                aVar2 = this;
                aVar2.e(view, aVar, a5, m5, z5);
            } else {
                aVar2 = this;
            }
            aVar2.f2299b++;
        }
    }

    /* access modifiers changed from: package-private */
    public void n() {
        a aVar;
        this.f2303f.o();
        long b5 = f.b();
        y1.a a5 = this.f2302e.a();
        if (this.f2303f.i().size() > 0) {
            Iterator it = this.f2303f.i().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                JSONObject a6 = a5.a((View) null);
                f(str, this.f2303f.a(str), a6);
                A1.c.m(a6);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                this.f2304g.b(a6, hashSet, b5);
            }
        }
        if (this.f2303f.k().size() > 0) {
            JSONObject a7 = a5.a((View) null);
            aVar = this;
            aVar.e((View) null, a5, a7, d.PARENT_VIEW, false);
            A1.c.m(a7);
            aVar.f2304g.d(a7, aVar.f2303f.k(), b5);
            if (aVar.f2300c) {
                for (n j5 : x1.c.e().a()) {
                    j5.j(aVar.f2301d);
                }
            }
        } else {
            aVar = this;
            aVar.f2304g.c();
        }
        aVar.f2303f.d();
    }

    public void o() {
        t();
    }

    public void q() {
        r();
    }

    public void s() {
        o();
        this.f2298a.clear();
        f2294j.post(new C0041a());
    }
}
