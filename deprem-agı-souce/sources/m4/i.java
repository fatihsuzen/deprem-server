package m4;

import J2.v;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.jvm.internal.t;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final String f25395a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25396b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25397c;

    /* renamed from: d  reason: collision with root package name */
    public final String f25398d;

    /* renamed from: e  reason: collision with root package name */
    public final String f25399e;

    /* renamed from: f  reason: collision with root package name */
    public final String f25400f;

    /* renamed from: g  reason: collision with root package name */
    public final String f25401g;

    /* renamed from: h  reason: collision with root package name */
    public final String f25402h;

    /* renamed from: i  reason: collision with root package name */
    public final e f25403i;

    /* renamed from: j  reason: collision with root package name */
    public final a f25404j;

    public i(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, e eVar, a aVar) {
        t.e(str, CampaignEx.JSON_KEY_TITLE);
        t.e(str2, TtmlNode.TAG_BODY);
        t.e(str3, "settings");
        t.e(str4, "accept");
        t.e(str5, "reject");
        t.e(str6, "consentLink");
        t.e(str7, "privacyPolicyLink");
        t.e(str8, "privacyPolicyLinkText");
        t.e(eVar, "consentOrPayUILabels");
        t.e(aVar, "advancedUILabels");
        this.f25395a = str;
        this.f25396b = str2;
        this.f25397c = str3;
        this.f25398d = str4;
        this.f25399e = str5;
        this.f25400f = str6;
        this.f25401g = str7;
        this.f25402h = str8;
        this.f25403i = eVar;
        this.f25404j = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (t.a(this.f25395a, iVar.f25395a) && t.a(this.f25396b, iVar.f25396b) && t.a(this.f25397c, iVar.f25397c) && t.a(this.f25398d, iVar.f25398d) && t.a(this.f25399e, iVar.f25399e) && t.a(this.f25400f, iVar.f25400f) && t.a(this.f25401g, iVar.f25401g) && t.a(this.f25402h, iVar.f25402h) && t.a(this.f25403i, iVar.f25403i) && t.a(this.f25404j, iVar.f25404j)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int a5 = v.a(this.f25402h, v.a(this.f25401g, v.a(this.f25400f, v.a(this.f25399e, v.a(this.f25398d, v.a(this.f25397c, v.a(this.f25396b, this.f25395a.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31);
        return this.f25404j.hashCode() + ((this.f25403i.hashCode() + a5) * 31);
    }

    public final String toString() {
        return "InitScreen(title=" + this.f25395a + ", body=" + this.f25396b + ", settings=" + this.f25397c + ", accept=" + this.f25398d + ", reject=" + this.f25399e + ", consentLink=" + this.f25400f + ", privacyPolicyLink=" + this.f25401g + ", privacyPolicyLinkText=" + this.f25402h + ", consentOrPayUILabels=" + this.f25403i + ", advancedUILabels=" + this.f25404j + ')';
    }
}
