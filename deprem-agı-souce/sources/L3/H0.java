package L3;

import H3.b;
import J3.f;
import J3.n;
import J3.o;
import W2.C2223l;
import W2.m;
import W2.p;
import X2.C2250q;
import X2.M;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import q3.C2728d;
import q3.C2729e;

public class H0 implements f, C2102n {

    /* renamed from: a  reason: collision with root package name */
    private final String f18449a;

    /* renamed from: b  reason: collision with root package name */
    private final M f18450b;

    /* renamed from: c  reason: collision with root package name */
    private final int f18451c;

    /* renamed from: d  reason: collision with root package name */
    private int f18452d;

    /* renamed from: e  reason: collision with root package name */
    private final String[] f18453e;

    /* renamed from: f  reason: collision with root package name */
    private final List[] f18454f;

    /* renamed from: g  reason: collision with root package name */
    private List f18455g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean[] f18456h;

    /* renamed from: i  reason: collision with root package name */
    private Map f18457i;

    /* renamed from: j  reason: collision with root package name */
    private final C2223l f18458j;

    /* renamed from: k  reason: collision with root package name */
    private final C2223l f18459k;

    /* renamed from: l  reason: collision with root package name */
    private final C2223l f18460l;

    public H0(String str, M m5, int i5) {
        t.e(str, "serialName");
        this.f18449a = str;
        this.f18450b = m5;
        this.f18451c = i5;
        this.f18452d = -1;
        String[] strArr = new String[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            strArr[i6] = "[UNINITIALIZED]";
        }
        this.f18453e = strArr;
        int i7 = this.f18451c;
        this.f18454f = new List[i7];
        this.f18456h = new boolean[i7];
        this.f18457i = M.h();
        p pVar = p.PUBLICATION;
        this.f18458j = m.a(pVar, new E0(this));
        this.f18459k = m.a(pVar, new F0(this));
        this.f18460l = m.a(pVar, new G0(this));
    }

    /* access modifiers changed from: private */
    public static final int n(H0 h02) {
        return I0.a(h02, h02.t());
    }

    public static /* synthetic */ void p(H0 h02, String str, boolean z4, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 2) != 0) {
                z4 = false;
            }
            h02.o(str, z4);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addElement");
    }

    private final Map q() {
        HashMap hashMap = new HashMap();
        int length = this.f18453e.length;
        for (int i5 = 0; i5 < length; i5++) {
            hashMap.put(this.f18453e[i5], Integer.valueOf(i5));
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public static final b[] r(H0 h02) {
        b[] childSerializers;
        M m5 = h02.f18450b;
        if (m5 == null || (childSerializers = m5.childSerializers()) == null) {
            return J0.f18466a;
        }
        return childSerializers;
    }

    private final b[] s() {
        return (b[]) this.f18458j.getValue();
    }

    private final int u() {
        return ((Number) this.f18460l.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public static final CharSequence v(H0 h02, int i5) {
        return h02.f(i5) + ": " + h02.h(i5).a();
    }

    /* access modifiers changed from: private */
    public static final f[] w(H0 h02) {
        ArrayList arrayList;
        b[] typeParametersSerializers;
        M m5 = h02.f18450b;
        if (m5 == null || (typeParametersSerializers = m5.typeParametersSerializers()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(typeParametersSerializers.length);
            for (b descriptor : typeParametersSerializers) {
                arrayList.add(descriptor.getDescriptor());
            }
        }
        return B0.b(arrayList);
    }

    public String a() {
        return this.f18449a;
    }

    public Set b() {
        return this.f18457i.keySet();
    }

    public boolean c() {
        return f.a.c(this);
    }

    public int d(String str) {
        t.e(str, RewardPlus.NAME);
        Integer num = (Integer) this.f18457i.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public final int e() {
        return this.f18451c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof H0)) {
            return false;
        }
        f fVar = (f) obj;
        if (!t.a(a(), fVar.a()) || !Arrays.equals(t(), ((H0) obj).t()) || e() != fVar.e()) {
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
        return this.f18453e[i5];
    }

    public List g(int i5) {
        List list = this.f18454f[i5];
        if (list == null) {
            return C2250q.g();
        }
        return list;
    }

    public List getAnnotations() {
        List list = this.f18455g;
        if (list == null) {
            return C2250q.g();
        }
        return list;
    }

    public n getKind() {
        return o.a.f18390a;
    }

    public f h(int i5) {
        return s()[i5].getDescriptor();
    }

    public int hashCode() {
        return u();
    }

    public boolean i(int i5) {
        return this.f18456h[i5];
    }

    public boolean isInline() {
        return f.a.b(this);
    }

    public final void o(String str, boolean z4) {
        t.e(str, RewardPlus.NAME);
        String[] strArr = this.f18453e;
        int i5 = this.f18452d + 1;
        this.f18452d = i5;
        strArr[i5] = str;
        this.f18456h[i5] = z4;
        this.f18454f[i5] = null;
        if (i5 == this.f18451c - 1) {
            this.f18457i = q();
        }
    }

    public final f[] t() {
        return (f[]) this.f18459k.getValue();
    }

    public String toString() {
        C2728d l5 = C2729e.l(0, this.f18451c);
        return C2250q.V(l5, ", ", a() + '(', ")", 0, (CharSequence) null, new D0(this), 24, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ H0(String str, M m5, int i5, int i6, C2633k kVar) {
        this(str, (i6 & 2) != 0 ? null : m5, i5);
    }
}
