package J3;

import J3.f;
import L3.B0;
import L3.C2102n;
import L3.I0;
import W2.C2223l;
import W2.m;
import W2.y;
import X2.C2242i;
import X2.C2250q;
import X2.G;
import X2.M;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;
import q3.C2728d;
import q3.C2729e;

public final class i implements f, C2102n {

    /* renamed from: a  reason: collision with root package name */
    private final String f18370a;

    /* renamed from: b  reason: collision with root package name */
    private final n f18371b;

    /* renamed from: c  reason: collision with root package name */
    private final int f18372c;

    /* renamed from: d  reason: collision with root package name */
    private final List f18373d;

    /* renamed from: e  reason: collision with root package name */
    private final Set f18374e;

    /* renamed from: f  reason: collision with root package name */
    private final String[] f18375f;

    /* renamed from: g  reason: collision with root package name */
    private final f[] f18376g;

    /* renamed from: h  reason: collision with root package name */
    private final List[] f18377h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean[] f18378i;

    /* renamed from: j  reason: collision with root package name */
    private final Map f18379j;

    /* renamed from: k  reason: collision with root package name */
    private final f[] f18380k;

    /* renamed from: l  reason: collision with root package name */
    private final C2223l f18381l;

    public i(String str, n nVar, int i5, List list, a aVar) {
        t.e(str, "serialName");
        t.e(nVar, "kind");
        t.e(list, "typeParameters");
        t.e(aVar, "builder");
        this.f18370a = str;
        this.f18371b = nVar;
        this.f18372c = i5;
        this.f18373d = aVar.c();
        this.f18374e = C2250q.l0(aVar.f());
        String[] strArr = (String[]) aVar.f().toArray(new String[0]);
        this.f18375f = strArr;
        this.f18376g = B0.b(aVar.e());
        this.f18377h = (List[]) aVar.d().toArray(new List[0]);
        this.f18378i = C2250q.j0(aVar.g());
        Iterable<G> w02 = C2242i.w0(strArr);
        ArrayList arrayList = new ArrayList(C2250q.p(w02, 10));
        for (G g5 : w02) {
            arrayList.add(y.a(g5.b(), Integer.valueOf(g5.a())));
        }
        this.f18379j = M.r(arrayList);
        this.f18380k = B0.b(list);
        this.f18381l = m.b(new g(this));
    }

    /* access modifiers changed from: private */
    public static final int l(i iVar) {
        return I0.a(iVar, iVar.f18380k);
    }

    private final int m() {
        return ((Number) this.f18381l.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public static final CharSequence n(i iVar, int i5) {
        return iVar.f(i5) + ": " + iVar.h(i5).a();
    }

    public String a() {
        return this.f18370a;
    }

    public Set b() {
        return this.f18374e;
    }

    public boolean c() {
        return f.a.c(this);
    }

    public int d(String str) {
        t.e(str, RewardPlus.NAME);
        Integer num = (Integer) this.f18379j.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public int e() {
        return this.f18372c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        f fVar = (f) obj;
        if (!t.a(a(), fVar.a()) || !Arrays.equals(this.f18380k, ((i) obj).f18380k) || e() != fVar.e()) {
            return false;
        }
        int e5 = e();
        for (int i5 = 0; i5 < e5; i5++) {
            if (!t.a(h(i5).a(), fVar.h(i5).a()) || !t.a(h(i5).getKind(), fVar.h(i5).getKind())) {
                return false;
            }
        }
        return true;
    }

    public String f(int i5) {
        return this.f18375f[i5];
    }

    public List g(int i5) {
        return this.f18377h[i5];
    }

    public List getAnnotations() {
        return this.f18373d;
    }

    public n getKind() {
        return this.f18371b;
    }

    public f h(int i5) {
        return this.f18376g[i5];
    }

    public int hashCode() {
        return m();
    }

    public boolean i(int i5) {
        return this.f18378i[i5];
    }

    public boolean isInline() {
        return f.a.b(this);
    }

    public String toString() {
        C2728d l5 = C2729e.l(0, e());
        return C2250q.V(l5, ", ", a() + '(', ")", 0, (CharSequence) null, new h(this), 24, (Object) null);
    }
}
