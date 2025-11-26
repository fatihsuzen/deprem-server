package T3;

import J2.v;
import P3.b;
import P3.k;
import R3.m;
import X2.C2250q;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.t;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f19270a;

    /* renamed from: b  reason: collision with root package name */
    public final String f19271b;

    /* renamed from: c  reason: collision with root package name */
    public final String f19272c;

    /* renamed from: d  reason: collision with root package name */
    public final String f19273d;

    /* renamed from: e  reason: collision with root package name */
    public final String f19274e;

    /* renamed from: f  reason: collision with root package name */
    public final List f19275f;

    /* renamed from: g  reason: collision with root package name */
    public final List f19276g;

    public g(int i5, String str, String str2, String str3, String str4, ArrayList arrayList, ArrayList arrayList2) {
        t.e(str, "pCode");
        t.e(str2, RewardPlus.NAME);
        t.e(str3, "description");
        t.e(str4, "privacyPolicyUrl");
        t.e(arrayList, "nonIabPurposeConsentIds");
        t.e(arrayList2, "nonIabPurposeLegitimateInterestIds");
        this.f19270a = i5;
        this.f19271b = str;
        this.f19272c = str2;
        this.f19273d = str3;
        this.f19274e = str4;
        this.f19275f = arrayList;
        this.f19276g = arrayList2;
    }

    public final k a() {
        return new k(this.f19270a, this.f19272c, this.f19273d, C2250q.q0(this.f19275f), C2250q.q0(this.f19276g), (Set) null, (Set) null, (Set) null, (Set) null, this.f19274e, (String) null, (P3.g) null, 0, false, false, (Boolean) null, (Set) null, (b) null, (LinkedHashSet) null, (String) null, 914912);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f19270a == gVar.f19270a && t.a(this.f19271b, gVar.f19271b) && t.a(this.f19272c, gVar.f19272c) && t.a(this.f19273d, gVar.f19273d) && t.a(this.f19274e, gVar.f19274e) && t.a(this.f19275f, gVar.f19275f) && t.a(this.f19276g, gVar.f19276g)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f19276g.hashCode() + m.a(this.f19275f, v.a(this.f19274e, v.a(this.f19273d, v.a(this.f19272c, v.a(this.f19271b, this.f19270a * 31, 31), 31), 31), 31), 31);
    }

    public final String toString() {
        return "NonIABVendor(vendorId=" + this.f19270a + ", pCode=" + this.f19271b + ", name=" + this.f19272c + ", description=" + this.f19273d + ", privacyPolicyUrl=" + this.f19274e + ", nonIabPurposeConsentIds=" + this.f19275f + ", nonIabPurposeLegitimateInterestIds=" + this.f19276g + ')';
    }
}
