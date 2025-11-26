package N3;

import J3.d;
import J3.f;
import J3.n;
import K3.c;
import L3.X;
import M3.B;
import M3.C2128b;
import M3.D;
import M3.h;
import M3.i;
import M3.w;
import M3.z;
import X2.M;
import X2.T;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

class G extends C2133c {

    /* renamed from: g  reason: collision with root package name */
    private final z f18717g;

    /* renamed from: h  reason: collision with root package name */
    private final f f18718h;

    /* renamed from: i  reason: collision with root package name */
    private int f18719i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f18720j;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ G(C2128b bVar, z zVar, String str, f fVar, int i5, C2633k kVar) {
        this(bVar, zVar, (i5 & 4) != 0 ? null : str, (i5 & 8) != 0 ? null : fVar);
    }

    private final boolean W(f fVar, int i5) {
        boolean z4;
        if (a().c().j() || fVar.i(i5) || !fVar.h(i5).c()) {
            z4 = false;
        } else {
            z4 = true;
        }
        this.f18720j = z4;
        return z4;
    }

    private final boolean X(f fVar, int i5, String str) {
        B b5;
        boolean z4;
        C2128b a5 = a();
        boolean i6 = fVar.i(i5);
        f h5 = fVar.h(i5);
        if (i6 && !h5.c() && (F(str) instanceof w)) {
            return true;
        }
        if (!t.a(h5.getKind(), n.b.f18389a) || (h5.c() && (F(str) instanceof w))) {
            return false;
        }
        h F4 = F(str);
        String str2 = null;
        if (F4 instanceof B) {
            b5 = (B) F4;
        } else {
            b5 = null;
        }
        if (b5 != null) {
            str2 = i.d(b5);
        }
        if (str2 == null) {
            return false;
        }
        int i7 = B.i(h5, a5, str2);
        if (a5.c().j() || !h5.c()) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (i7 != -3 || (!i6 && !z4)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public h F(String str) {
        t.e(str, "tag");
        return (h) M.i(T(), str);
    }

    /* renamed from: Y */
    public z T() {
        return this.f18717g;
    }

    public c beginStructure(f fVar) {
        t.e(fVar, "descriptor");
        if (fVar != this.f18718h) {
            return super.beginStructure(fVar);
        }
        C2128b a5 = a();
        h G4 = G();
        String a6 = this.f18718h.a();
        if (G4 instanceof z) {
            return new G(a5, (z) G4, S(), this.f18718h);
        }
        throw z.e(-1, "Expected " + kotlin.jvm.internal.M.b(z.class).c() + ", but had " + kotlin.jvm.internal.M.b(G4.getClass()).c() + " as the serialized body of " + a6 + " at element: " + C(), G4.toString());
    }

    public int decodeElementIndex(f fVar) {
        t.e(fVar, "descriptor");
        while (this.f18719i < fVar.e()) {
            int i5 = this.f18719i;
            this.f18719i = i5 + 1;
            String A4 = t(fVar, i5);
            int i6 = this.f18719i - 1;
            this.f18720j = false;
            if ((T().containsKey(A4) || W(fVar, i6)) && (!this.f18782f.g() || !X(fVar, i6, A4))) {
                return i6;
            }
        }
        return -1;
    }

    public boolean decodeNotNullMark() {
        if (this.f18720j || !super.decodeNotNullMark()) {
            return false;
        }
        return true;
    }

    public void endStructure(f fVar) {
        Set set;
        Set set2;
        t.e(fVar, "descriptor");
        if (!this.f18782f.k() && !(fVar.getKind() instanceof d)) {
            B.m(fVar, a());
            if (!this.f18782f.o()) {
                set = X.a(fVar);
            } else {
                Set a5 = X.a(fVar);
                Map map = (Map) D.a(a()).a(fVar, B.g());
                if (map != null) {
                    set2 = map.keySet();
                } else {
                    set2 = null;
                }
                if (set2 == null) {
                    set2 = T.d();
                }
                set = T.h(a5, set2);
            }
            for (String str : T().keySet()) {
                if (!set.contains(str) && !t.a(str, S())) {
                    throw z.f(str, T().toString());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public String z(f fVar, int i5) {
        Object obj;
        t.e(fVar, "descriptor");
        B.m(fVar, a());
        String f5 = fVar.f(i5);
        if (!this.f18782f.o() || T().keySet().contains(f5)) {
            return f5;
        }
        Map e5 = B.e(a(), fVar);
        Iterator it = T().keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Integer num = (Integer) e5.get((String) obj);
            if (num != null && num.intValue() == i5) {
                break;
            }
        }
        String str = (String) obj;
        if (str != null) {
            return str;
        }
        return f5;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public G(C2128b bVar, z zVar, String str, f fVar) {
        super(bVar, zVar, str, (C2633k) null);
        t.e(bVar, "json");
        t.e(zVar, "value");
        this.f18717g = zVar;
        this.f18718h = fVar;
    }
}
