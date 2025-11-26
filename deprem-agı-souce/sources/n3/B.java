package N3;

import H3.k;
import J3.f;
import J3.n;
import J3.o;
import M3.C2128b;
import M3.D;
import M3.u;
import M3.v;
import N3.C2148s;
import X2.C2250q;
import X2.M;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.t;

public abstract class B {

    /* renamed from: a  reason: collision with root package name */
    private static final C2148s.a f18708a = new C2148s.a();

    /* renamed from: b  reason: collision with root package name */
    private static final C2148s.a f18709b = new C2148s.a();

    private static final Map b(f fVar, C2128b bVar) {
        String str;
        String[] names;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean d5 = d(bVar, fVar);
        m(fVar, bVar);
        int e5 = fVar.e();
        for (int i5 = 0; i5 < e5; i5++) {
            ArrayList arrayList = new ArrayList();
            for (Object next : fVar.g(i5)) {
                if (next instanceof u) {
                    arrayList.add(next);
                }
            }
            u uVar = (u) C2250q.f0(arrayList);
            if (!(uVar == null || (names = uVar.names()) == null)) {
                for (String str2 : names) {
                    if (d5) {
                        str2 = str2.toLowerCase(Locale.ROOT);
                        t.d(str2, "toLowerCase(...)");
                    }
                    c(linkedHashMap, fVar, str2, i5);
                }
            }
            if (d5) {
                str = fVar.f(i5).toLowerCase(Locale.ROOT);
                t.d(str, "toLowerCase(...)");
            } else {
                str = null;
            }
            if (str != null) {
                c(linkedHashMap, fVar, str, i5);
            }
        }
        if (linkedHashMap.isEmpty()) {
            return M.h();
        }
        return linkedHashMap;
    }

    private static final void c(Map map, f fVar, String str, int i5) {
        String str2;
        if (t.a(fVar.getKind(), n.b.f18389a)) {
            str2 = "enum value";
        } else {
            str2 = "property";
        }
        if (!map.containsKey(str)) {
            map.put(str, Integer.valueOf(i5));
            return;
        }
        throw new y("The suggested name '" + str + "' for " + str2 + ' ' + fVar.f(i5) + " is already one of the names for " + str2 + ' ' + fVar.f(((Number) M.i(map, str)).intValue()) + " in " + fVar);
    }

    private static final boolean d(C2128b bVar, f fVar) {
        if (!bVar.c().h() || !t.a(fVar.getKind(), n.b.f18389a)) {
            return false;
        }
        return true;
    }

    public static final Map e(C2128b bVar, f fVar) {
        t.e(bVar, "<this>");
        t.e(fVar, "descriptor");
        return (Map) D.a(bVar).b(fVar, f18708a, new A(fVar, bVar));
    }

    /* access modifiers changed from: private */
    public static final Map f(f fVar, C2128b bVar) {
        return b(fVar, bVar);
    }

    public static final C2148s.a g() {
        return f18708a;
    }

    public static final String h(f fVar, C2128b bVar, int i5) {
        t.e(fVar, "<this>");
        t.e(bVar, "json");
        m(fVar, bVar);
        return fVar.f(i5);
    }

    public static final int i(f fVar, C2128b bVar, String str) {
        t.e(fVar, "<this>");
        t.e(bVar, "json");
        t.e(str, RewardPlus.NAME);
        if (d(bVar, fVar)) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            t.d(lowerCase, "toLowerCase(...)");
            return l(fVar, bVar, lowerCase);
        }
        m(fVar, bVar);
        int d5 = fVar.d(str);
        if (d5 == -3 && bVar.c().o()) {
            return l(fVar, bVar, str);
        }
        return d5;
    }

    public static final int j(f fVar, C2128b bVar, String str, String str2) {
        t.e(fVar, "<this>");
        t.e(bVar, "json");
        t.e(str, RewardPlus.NAME);
        t.e(str2, "suffix");
        int i5 = i(fVar, bVar, str);
        if (i5 != -3) {
            return i5;
        }
        throw new k(fVar.a() + " does not contain element with name '" + str + '\'' + str2);
    }

    public static /* synthetic */ int k(f fVar, C2128b bVar, String str, String str2, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            str2 = "";
        }
        return j(fVar, bVar, str, str2);
    }

    private static final int l(f fVar, C2128b bVar, String str) {
        Integer num = (Integer) e(bVar, fVar).get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final v m(f fVar, C2128b bVar) {
        t.e(fVar, "<this>");
        t.e(bVar, "json");
        if (t.a(fVar.getKind(), o.a.f18390a)) {
            bVar.c().l();
        }
        return null;
    }
}
