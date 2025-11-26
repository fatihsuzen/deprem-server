package r1;

import j$.util.Collection;
import j$.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: r1.e  reason: case insensitive filesystem */
public abstract class C1795e {

    /* renamed from: a  reason: collision with root package name */
    public static List f16393a = ((List) Collection.EL.stream(new ArrayList(f16394b.keySet())).sorted().map(new C1794d()).collect(Collectors.toList()));

    /* renamed from: b  reason: collision with root package name */
    public static Map f16394b;

    static {
        HashMap hashMap = new HashMap();
        f16394b = hashMap;
        hashMap.put(Integer.valueOf(C1797g.f16398e), C1797g.f16400g);
        f16394b.put(Integer.valueOf(C1796f.f16395e), C1796f.f16397g);
        f16394b.put(Integer.valueOf(C1814x.f16449e), C1814x.f16451g);
        f16394b.put(Integer.valueOf(C1805o.f16422e), C1805o.f16424g);
        f16394b.put(Integer.valueOf(C1798h.f16401e), C1798h.f16403g);
        f16394b.put(Integer.valueOf(C1813w.f16446e), C1813w.f16448g);
        f16394b.put(Integer.valueOf(C1799i.f16404e), C1799i.f16406g);
        f16394b.put(Integer.valueOf(C1812v.f16443e), C1812v.f16445g);
        f16394b.put(Integer.valueOf(C1800j.f16407e), C1800j.f16409g);
        f16394b.put(Integer.valueOf(C1802l.f16413e), C1802l.f16415g);
        f16394b.put(Integer.valueOf(C1804n.f16419e), C1804n.f16421g);
        f16394b.put(Integer.valueOf(C1809s.f16434e), C1809s.f16436g);
        f16394b.put(Integer.valueOf(C1811u.f16440e), C1811u.f16442g);
        f16394b.put(Integer.valueOf(C1801k.f16410e), C1801k.f16412g);
        f16394b.put(Integer.valueOf(C1803m.f16416e), C1803m.f16418g);
        f16394b.put(Integer.valueOf(C1806p.f16425e), C1806p.f16427g);
        f16394b.put(Integer.valueOf(C1807q.f16428e), C1807q.f16430g);
        f16394b.put(Integer.valueOf(C1808r.f16431e), C1808r.f16433g);
        f16394b.put(Integer.valueOf(C1810t.f16437e), C1810t.f16439g);
    }

    public static /* synthetic */ String a(Integer num) {
        return (String) f16394b.get(num);
    }
}
