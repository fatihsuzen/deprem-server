package m4;

import J2.v;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.jvm.internal.t;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final String f25405a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25406b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25407c;

    /* renamed from: d  reason: collision with root package name */
    public final String f25408d;

    /* renamed from: e  reason: collision with root package name */
    public final String f25409e;

    /* renamed from: f  reason: collision with root package name */
    public final String f25410f;

    /* renamed from: g  reason: collision with root package name */
    public final String f25411g;

    /* renamed from: h  reason: collision with root package name */
    public final String f25412h;

    /* renamed from: i  reason: collision with root package name */
    public final String f25413i;

    /* renamed from: j  reason: collision with root package name */
    public final String f25414j;

    /* renamed from: k  reason: collision with root package name */
    public final String f25415k;

    public j(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        t.e(str, CampaignEx.JSON_KEY_TITLE);
        t.e(str2, TtmlNode.TAG_BODY);
        t.e(str3, "objected");
        t.e(str4, "accept");
        t.e(str5, "objectAllButton");
        t.e(str6, "searchBarHint");
        t.e(str7, "purposesLabel");
        t.e(str8, "partnersLabel");
        t.e(str9, "showAllVendorsMenu");
        t.e(str10, "showIABVendorsMenu");
        t.e(str11, "backLabel");
        this.f25405a = str;
        this.f25406b = str2;
        this.f25407c = str3;
        this.f25408d = str4;
        this.f25409e = str5;
        this.f25410f = str6;
        this.f25411g = str7;
        this.f25412h = str8;
        this.f25413i = str9;
        this.f25414j = str10;
        this.f25415k = str11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (t.a(this.f25405a, jVar.f25405a) && t.a(this.f25406b, jVar.f25406b) && t.a(this.f25407c, jVar.f25407c) && t.a(this.f25408d, jVar.f25408d) && t.a(this.f25409e, jVar.f25409e) && t.a(this.f25410f, jVar.f25410f) && t.a(this.f25411g, jVar.f25411g) && t.a(this.f25412h, jVar.f25412h) && t.a(this.f25413i, jVar.f25413i) && t.a(this.f25414j, jVar.f25414j) && t.a(this.f25415k, jVar.f25415k)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f25415k.hashCode() + v.a(this.f25414j, v.a(this.f25413i, v.a(this.f25412h, v.a(this.f25411g, v.a(this.f25410f, v.a(this.f25409e, v.a(this.f25408d, v.a(this.f25407c, v.a(this.f25406b, this.f25405a.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        return "LegInterestScreen(title=" + this.f25405a + ", body=" + this.f25406b + ", objected=" + this.f25407c + ", accept=" + this.f25408d + ", objectAllButton=" + this.f25409e + ", searchBarHint=" + this.f25410f + ", purposesLabel=" + this.f25411g + ", partnersLabel=" + this.f25412h + ", showAllVendorsMenu=" + this.f25413i + ", showIABVendorsMenu=" + this.f25414j + ", backLabel=" + this.f25415k + ')';
    }
}
