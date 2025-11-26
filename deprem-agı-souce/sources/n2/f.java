package N2;

import J2.j;
import J2.k;
import L2.e;
import W2.J;
import X2.C2250q;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k3.p;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

public final class f extends u implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ L f18705a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(L l5) {
        super(2);
        this.f18705a = l5;
    }

    public final Object invoke(Object obj, Object obj2) {
        int i5;
        int i6;
        String str;
        int i7;
        int i8;
        String str2 = (String) obj;
        Set set = (Set) obj2;
        t.e(str2, "hash");
        t.e(set, "vendorIds");
        k a5 = j.a(str2);
        L l5 = this.f18705a;
        String str3 = (String) l5.f24690a;
        Integer valueOf = Integer.valueOf(a5.f18283a);
        Map map = e.f18404a;
        L2.f fVar = L2.f.PURPOSE_ID;
        t.e(fVar, "key");
        Map map2 = e.f18405b;
        Integer num = (Integer) map2.get(fVar);
        int i9 = 0;
        if (num == null) {
            i5 = 0;
        } else {
            i5 = num.intValue();
        }
        l5.f24690a = t.n(str3, d.b(valueOf, i5));
        L l6 = this.f18705a;
        String str4 = (String) l6.f24690a;
        Integer valueOf2 = Integer.valueOf(a5.f18284b.f18293a);
        L2.f fVar2 = L2.f.RESTRICTION_TYPE;
        t.e(fVar2, "key");
        Integer num2 = (Integer) map2.get(fVar2);
        if (num2 == null) {
            i6 = 0;
        } else {
            i6 = num2.intValue();
        }
        l6.f24690a = t.n(str4, d.b(valueOf2, i6));
        List g02 = C2250q.g0(set);
        int size = g02.size();
        String str5 = "";
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < size) {
            int i13 = i10 + 1;
            int intValue = ((Number) g02.get(i10)).intValue();
            if (i12 == 0) {
                i11++;
                i12 = intValue;
            }
            boolean z4 = true;
            if (i10 == g02.size() - 1 || ((Number) g02.get(i13)).intValue() > intValue + 1) {
                if (intValue == i12) {
                    z4 = false;
                }
                if (z4) {
                    str = "1";
                } else {
                    str = "0";
                }
                String n5 = t.n(str5, str);
                Integer valueOf3 = Integer.valueOf(i12);
                Map map3 = e.f18404a;
                L2.f fVar3 = L2.f.VENDOR_ID;
                t.e(fVar3, "key");
                Map map4 = e.f18405b;
                Integer num3 = (Integer) map4.get(fVar3);
                if (num3 == null) {
                    i7 = 0;
                } else {
                    i7 = num3.intValue();
                }
                str5 = t.n(n5, d.b(valueOf3, i7));
                if (z4) {
                    Integer valueOf4 = Integer.valueOf(intValue);
                    t.e(fVar3, "key");
                    Integer num4 = (Integer) map4.get(fVar3);
                    if (num4 == null) {
                        i8 = 0;
                    } else {
                        i8 = num4.intValue();
                    }
                    str5 = t.n(str5, d.b(valueOf4, i8));
                }
                i10 = i13;
                i12 = 0;
            } else {
                i10 = i13;
            }
        }
        L l7 = this.f18705a;
        String str6 = (String) l7.f24690a;
        Integer valueOf5 = Integer.valueOf(i11);
        Map map5 = e.f18404a;
        L2.f fVar4 = L2.f.NUM_ENTRIES;
        t.e(fVar4, "key");
        Integer num5 = (Integer) e.f18405b.get(fVar4);
        if (num5 != null) {
            i9 = num5.intValue();
        }
        l7.f24690a = t.n(str6, d.b(valueOf5, i9));
        L l8 = this.f18705a;
        l8.f24690a = t.n((String) l8.f24690a, str5);
        return J.f19942a;
    }
}
