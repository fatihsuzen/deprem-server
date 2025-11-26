package B1;

import A1.i;
import android.view.View;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;
import u1.n;
import x1.c;
import x1.e;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f2307a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap f2308b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap f2309c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet f2310d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    private final HashSet f2311e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private final HashSet f2312f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    private final HashMap f2313g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private final HashSet f2314h = new HashSet();

    /* renamed from: i  reason: collision with root package name */
    private final Map f2315i = new WeakHashMap();

    /* renamed from: j  reason: collision with root package name */
    private boolean f2316j;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final e f2317a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f2318b = new ArrayList();

        public a(e eVar, String str) {
            this.f2317a = eVar;
            b(str);
        }

        public e a() {
            return this.f2317a;
        }

        public void b(String str) {
            this.f2318b.add(str);
        }

        public ArrayList c() {
            return this.f2318b;
        }
    }

    private Boolean b(View view) {
        if (view.hasWindowFocus()) {
            this.f2315i.remove(view);
            return Boolean.FALSE;
        } else if (this.f2315i.containsKey(view)) {
            return (Boolean) this.f2315i.get(view);
        } else {
            Map map = this.f2315i;
            Boolean bool = Boolean.FALSE;
            map.put(view, bool);
            return bool;
        }
    }

    private String c(View view, boolean z4) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (b(view).booleanValue() && !z4) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String a5 = i.a(view);
            if (a5 != null) {
                return a5;
            }
            hashSet.add(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                view = (View) parent;
            } else {
                view = null;
            }
        }
        this.f2310d.addAll(hashSet);
        return null;
    }

    private void e(n nVar) {
        for (e f5 : nVar.o()) {
            f(f5, nVar);
        }
    }

    private void f(e eVar, n nVar) {
        View view = (View) eVar.c().get();
        if (view != null) {
            a aVar = (a) this.f2308b.get(view);
            if (aVar != null) {
                aVar.b(nVar.s());
            } else {
                this.f2308b.put(view, new a(eVar, nVar.s()));
            }
        }
    }

    public View a(String str) {
        return (View) this.f2309c.get(str);
    }

    public void d() {
        this.f2307a.clear();
        this.f2308b.clear();
        this.f2309c.clear();
        this.f2310d.clear();
        this.f2311e.clear();
        this.f2312f.clear();
        this.f2313g.clear();
        this.f2316j = false;
        this.f2314h.clear();
    }

    public a g(View view) {
        a aVar = (a) this.f2308b.get(view);
        if (aVar != null) {
            this.f2308b.remove(view);
        }
        return aVar;
    }

    public String h(String str) {
        return (String) this.f2313g.get(str);
    }

    public HashSet i() {
        return this.f2312f;
    }

    public String j(View view) {
        if (this.f2307a.size() == 0) {
            return null;
        }
        String str = (String) this.f2307a.get(view);
        if (str != null) {
            this.f2307a.remove(view);
        }
        return str;
    }

    public HashSet k() {
        return this.f2311e;
    }

    public boolean l(String str) {
        return this.f2314h.contains(str);
    }

    public d m(View view) {
        if (this.f2310d.contains(view)) {
            return d.PARENT_VIEW;
        }
        if (this.f2316j) {
            return d.OBSTRUCTION_VIEW;
        }
        return d.UNDERLYING_VIEW;
    }

    public void n() {
        this.f2316j = true;
    }

    public void o() {
        c e5 = c.e();
        if (e5 != null) {
            for (n nVar : e5.a()) {
                View n5 = nVar.n();
                if (nVar.q()) {
                    String s5 = nVar.s();
                    if (n5 != null) {
                        boolean e6 = i.e(n5);
                        if (e6) {
                            this.f2314h.add(s5);
                        }
                        String c5 = c(n5, e6);
                        if (c5 == null) {
                            this.f2311e.add(s5);
                            this.f2307a.put(n5, s5);
                            e(nVar);
                        } else if (c5 != "noWindowFocus") {
                            this.f2312f.add(s5);
                            this.f2309c.put(s5, n5);
                            this.f2313g.put(s5, c5);
                        }
                    } else {
                        this.f2312f.add(s5);
                        this.f2313g.put(s5, "noAdView");
                    }
                }
            }
        }
    }

    public boolean p(View view) {
        if (!this.f2315i.containsKey(view)) {
            return true;
        }
        this.f2315i.put(view, Boolean.TRUE);
        return false;
    }
}
