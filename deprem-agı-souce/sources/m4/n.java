package m4;

import J2.v;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.jvm.internal.t;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final String f25466a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25467b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25468c;

    /* renamed from: d  reason: collision with root package name */
    public final String f25469d;

    /* renamed from: e  reason: collision with root package name */
    public final String f25470e;

    /* renamed from: f  reason: collision with root package name */
    public final String f25471f;

    /* renamed from: g  reason: collision with root package name */
    public final String f25472g;

    public n(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        t.e(str, CampaignEx.JSON_KEY_TITLE);
        t.e(str2, "bodyText");
        t.e(str3, "searchBarHint");
        t.e(str4, "partnersLabel");
        t.e(str5, "showAllVendorsMenu");
        t.e(str6, "showIABVendorsMenu");
        t.e(str7, "backLabel");
        this.f25466a = str;
        this.f25467b = str2;
        this.f25468c = str3;
        this.f25469d = str4;
        this.f25470e = str5;
        this.f25471f = str6;
        this.f25472g = str7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (t.a(this.f25466a, nVar.f25466a) && t.a(this.f25467b, nVar.f25467b) && t.a(this.f25468c, nVar.f25468c) && t.a(this.f25469d, nVar.f25469d) && t.a(this.f25470e, nVar.f25470e) && t.a(this.f25471f, nVar.f25471f) && t.a(this.f25472g, nVar.f25472g)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f25472g.hashCode() + v.a(this.f25471f, v.a(this.f25470e, v.a(this.f25469d, v.a(this.f25468c, v.a(this.f25467b, this.f25466a.hashCode() * 31, 31), 31), 31), 31), 31);
    }

    public final String toString() {
        return "PartnerScreen(title=" + this.f25466a + ", bodyText=" + this.f25467b + ", searchBarHint=" + this.f25468c + ", partnersLabel=" + this.f25469d + ", showAllVendorsMenu=" + this.f25470e + ", showIABVendorsMenu=" + this.f25471f + ", backLabel=" + this.f25472g + ')';
    }
}
