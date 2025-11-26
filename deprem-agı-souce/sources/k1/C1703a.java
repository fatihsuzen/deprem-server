package k1;

import j$.util.Collection;
import j$.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p1.C1752a;
import p1.C1753b;
import p1.C1754c;
import q1.C1760d;
import r1.C1792b;
import r1.C1793c;
import r1.C1795e;
import r1.C1796f;
import r1.C1797g;
import r1.C1798h;
import r1.C1799i;
import r1.C1800j;
import r1.C1801k;
import r1.C1802l;
import r1.C1803m;
import r1.C1804n;
import r1.C1805o;
import r1.C1806p;
import r1.C1807q;
import r1.C1808r;
import r1.C1809s;
import r1.C1810t;
import r1.C1811u;
import r1.C1812v;
import r1.C1813w;
import r1.C1814x;

/* renamed from: k1.a  reason: case insensitive filesystem */
public class C1703a {

    /* renamed from: a  reason: collision with root package name */
    private Map f15513a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private String f15514b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f15515c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f15516d = true;

    public C1703a() {
    }

    public void a(String str) {
        this.f15514b = str;
        this.f15515c = false;
        this.f15516d = false;
    }

    /* access modifiers changed from: protected */
    public Map b(String str) {
        if (str == null || str.isEmpty() || str.startsWith("DB")) {
            HashMap hashMap = new HashMap();
            if (str != null && !str.isEmpty()) {
                String[] split = str.split("~");
                C1793c cVar = new C1793c(split[0]);
                hashMap.put(C1793c.f16392g, cVar);
                List list = (List) cVar.c("SectionIds");
                for (int i5 = 0; i5 < list.size(); i5++) {
                    if (((Integer) list.get(i5)).equals(Integer.valueOf(C1797g.f16398e))) {
                        hashMap.put(C1797g.f16400g, new C1797g(split[i5 + 1]));
                    } else if (((Integer) list.get(i5)).equals(Integer.valueOf(C1796f.f16395e))) {
                        hashMap.put(C1796f.f16397g, new C1796f(split[i5 + 1]));
                    } else if (((Integer) list.get(i5)).equals(Integer.valueOf(C1814x.f16449e))) {
                        hashMap.put(C1814x.f16451g, new C1814x(split[i5 + 1]));
                    } else if (((Integer) list.get(i5)).equals(Integer.valueOf(C1798h.f16401e))) {
                        hashMap.put(C1798h.f16403g, new C1798h(split[i5 + 1]));
                    } else if (((Integer) list.get(i5)).equals(Integer.valueOf(C1805o.f16422e))) {
                        hashMap.put(C1805o.f16424g, new C1805o(split[i5 + 1]));
                    } else if (((Integer) list.get(i5)).equals(Integer.valueOf(C1813w.f16446e))) {
                        hashMap.put(C1813w.f16448g, new C1813w(split[i5 + 1]));
                    } else if (((Integer) list.get(i5)).equals(Integer.valueOf(C1799i.f16404e))) {
                        hashMap.put(C1799i.f16406g, new C1799i(split[i5 + 1]));
                    } else if (((Integer) list.get(i5)).equals(Integer.valueOf(C1812v.f16443e))) {
                        hashMap.put(C1812v.f16445g, new C1812v(split[i5 + 1]));
                    } else if (((Integer) list.get(i5)).equals(Integer.valueOf(C1800j.f16407e))) {
                        hashMap.put(C1800j.f16409g, new C1800j(split[i5 + 1]));
                    } else if (((Integer) list.get(i5)).equals(Integer.valueOf(C1802l.f16413e))) {
                        hashMap.put(C1802l.f16415g, new C1802l(split[i5 + 1]));
                    } else if (((Integer) list.get(i5)).equals(Integer.valueOf(C1804n.f16419e))) {
                        hashMap.put(C1804n.f16421g, new C1804n(split[i5 + 1]));
                    } else if (((Integer) list.get(i5)).equals(Integer.valueOf(C1809s.f16434e))) {
                        hashMap.put(C1809s.f16436g, new C1809s(split[i5 + 1]));
                    } else if (((Integer) list.get(i5)).equals(Integer.valueOf(C1811u.f16440e))) {
                        hashMap.put(C1811u.f16442g, new C1811u(split[i5 + 1]));
                    } else if (((Integer) list.get(i5)).equals(Integer.valueOf(C1801k.f16410e))) {
                        hashMap.put(C1801k.f16412g, new C1801k(split[i5 + 1]));
                    } else if (((Integer) list.get(i5)).equals(Integer.valueOf(C1803m.f16416e))) {
                        hashMap.put(C1803m.f16418g, new C1803m(split[i5 + 1]));
                    } else if (((Integer) list.get(i5)).equals(Integer.valueOf(C1806p.f16425e))) {
                        hashMap.put(C1806p.f16427g, new C1806p(split[i5 + 1]));
                    } else if (((Integer) list.get(i5)).equals(Integer.valueOf(C1807q.f16428e))) {
                        hashMap.put(C1807q.f16430g, new C1807q(split[i5 + 1]));
                    } else if (((Integer) list.get(i5)).equals(Integer.valueOf(C1808r.f16431e))) {
                        hashMap.put(C1808r.f16433g, new C1808r(split[i5 + 1]));
                    } else if (((Integer) list.get(i5)).equals(Integer.valueOf(C1810t.f16437e))) {
                        hashMap.put(C1810t.f16439g, new C1810t(split[i5 + 1]));
                    }
                }
            }
            return hashMap;
        } else if (str.startsWith("C")) {
            HashMap hashMap2 = new HashMap();
            C1797g gVar = new C1797g(str);
            hashMap2.put(C1797g.f16400g, gVar);
            new C1793c().a(C1760d.f15885c, Arrays.asList(new Integer[]{2}));
            hashMap2.put(C1793c.f16392g, gVar);
            return hashMap2;
        } else {
            throw new C1752a("Unable to decode '" + str + "'");
        }
    }

    public void c(int i5) {
        d((String) C1795e.f16394b.get(Integer.valueOf(i5)));
    }

    public void d(String str) {
        if (!this.f15516d) {
            this.f15513a = b(this.f15514b);
            this.f15515c = false;
            this.f15516d = true;
        }
        if (this.f15513a.containsKey(str)) {
            this.f15513a.remove(str);
            this.f15515c = true;
        }
    }

    public String e() {
        String str = this.f15514b;
        if (str == null || str.isEmpty() || this.f15515c) {
            this.f15514b = f(this.f15513a);
            this.f15515c = false;
            this.f15516d = true;
        }
        return this.f15514b;
    }

    /* access modifiers changed from: protected */
    public String f(Map map) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i5 = 0; i5 < C1795e.f16393a.size(); i5++) {
            String str = (String) C1795e.f16393a.get(i5);
            if (map.containsKey(str)) {
                C1792b bVar = (C1792b) map.get(str);
                arrayList.add(bVar.b());
                arrayList2.add(Integer.valueOf(bVar.getId()));
            }
        }
        C1793c cVar = new C1793c();
        try {
            cVar.a("SectionIds", j());
            arrayList.add(0, cVar.b());
            return (String) Collection.EL.stream(arrayList).collect(Collectors.joining("~"));
        } catch (C1754c e5) {
            throw new C1753b((Exception) e5);
        }
    }

    public C1793c g() {
        if (!this.f15516d) {
            this.f15513a = b(this.f15514b);
            this.f15515c = false;
            this.f15516d = true;
        }
        C1793c cVar = new C1793c();
        try {
            cVar.a("SectionIds", j());
        } catch (C1754c unused) {
        }
        return cVar;
    }

    public C1792b h(int i5) {
        return i((String) C1795e.f16394b.get(Integer.valueOf(i5)));
    }

    public C1792b i(String str) {
        if (!this.f15516d) {
            this.f15513a = b(this.f15514b);
            this.f15515c = false;
            this.f15516d = true;
        }
        if (this.f15513a.containsKey(str)) {
            return (C1792b) this.f15513a.get(str);
        }
        return null;
    }

    public List j() {
        if (!this.f15516d) {
            this.f15513a = b(this.f15514b);
            this.f15515c = false;
            this.f15516d = true;
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < C1795e.f16393a.size(); i5++) {
            String str = (String) C1795e.f16393a.get(i5);
            if (this.f15513a.containsKey(str)) {
                arrayList.add(Integer.valueOf(((C1792b) this.f15513a.get(str)).getId()));
            }
        }
        return arrayList;
    }

    public boolean k(int i5) {
        return l((String) C1795e.f16394b.get(Integer.valueOf(i5)));
    }

    public boolean l(String str) {
        if (!this.f15516d) {
            this.f15513a = b(this.f15514b);
            this.f15515c = false;
            this.f15516d = true;
        }
        return this.f15513a.containsKey(str);
    }

    public void m(String str, String str2, Object obj) {
        C1792b bVar;
        if (!this.f15516d) {
            this.f15513a = b(this.f15514b);
            this.f15515c = false;
            this.f15516d = true;
        }
        if (this.f15513a.containsKey(str)) {
            bVar = (C1792b) this.f15513a.get(str);
        } else if (str.equals(C1796f.f16397g)) {
            bVar = new C1796f();
            this.f15513a.put(C1796f.f16397g, bVar);
        } else if (str.equals(C1797g.f16400g)) {
            bVar = new C1797g();
            this.f15513a.put(C1797g.f16400g, bVar);
        } else if (str.equals(C1814x.f16451g)) {
            bVar = new C1814x();
            this.f15513a.put(C1814x.f16451g, bVar);
        } else if (str.equals(C1805o.f16424g)) {
            bVar = new C1805o();
            this.f15513a.put(C1805o.f16424g, bVar);
        } else if (str.equals(C1798h.f16403g)) {
            bVar = new C1798h();
            this.f15513a.put(C1798h.f16403g, bVar);
        } else if (str.equals(C1813w.f16448g)) {
            bVar = new C1813w();
            this.f15513a.put(C1813w.f16448g, bVar);
        } else if (str.equals(C1799i.f16406g)) {
            bVar = new C1799i();
            this.f15513a.put(C1799i.f16406g, bVar);
        } else if (str.equals(C1812v.f16445g)) {
            bVar = new C1812v();
            this.f15513a.put(C1812v.f16445g, bVar);
        } else if (str.equals(C1800j.f16409g)) {
            bVar = new C1800j();
            this.f15513a.put(C1800j.f16409g, bVar);
        } else if (str.equals(C1802l.f16415g)) {
            bVar = new C1802l();
            this.f15513a.put(C1802l.f16415g, bVar);
        } else if (str.equals(C1804n.f16421g)) {
            bVar = new C1804n();
            this.f15513a.put(C1804n.f16421g, bVar);
        } else if (str.equals(C1809s.f16436g)) {
            bVar = new C1809s();
            this.f15513a.put(C1809s.f16436g, bVar);
        } else if (str.equals(C1811u.f16442g)) {
            bVar = new C1811u();
            this.f15513a.put(C1811u.f16442g, bVar);
        } else if (str.equals(C1801k.f16412g)) {
            bVar = new C1801k();
            this.f15513a.put(C1801k.f16412g, bVar);
        } else if (str.equals(C1803m.f16418g)) {
            bVar = new C1803m();
            this.f15513a.put(C1803m.f16418g, bVar);
        } else if (str.equals(C1806p.f16427g)) {
            bVar = new C1806p();
            this.f15513a.put(C1806p.f16427g, bVar);
        } else if (str.equals(C1807q.f16430g)) {
            bVar = new C1807q();
            this.f15513a.put(C1807q.f16430g, bVar);
        } else if (str.equals(C1808r.f16433g)) {
            bVar = new C1808r();
            this.f15513a.put(C1808r.f16433g, bVar);
        } else if (str.equals(C1810t.f16439g)) {
            bVar = new C1810t();
            this.f15513a.put(C1810t.f16439g, bVar);
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.a(str2, obj);
            this.f15515c = true;
            return;
        }
        throw new C1754c(str + "." + str2 + " not found");
    }

    public C1703a(String str) {
        a(str);
    }
}
