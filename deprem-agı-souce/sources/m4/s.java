package m4;

import J2.v;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.jvm.internal.t;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public final String f25490a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25491b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25492c;

    /* renamed from: d  reason: collision with root package name */
    public final String f25493d;

    /* renamed from: e  reason: collision with root package name */
    public final String f25494e;

    /* renamed from: f  reason: collision with root package name */
    public final String f25495f;

    public s(String str, String str2, String str3, String str4, String str5, String str6) {
        t.e(str, CampaignEx.JSON_KEY_TITLE);
        t.e(str2, "legalDescriptionTextLabel");
        t.e(str3, "agreeToAllButton");
        t.e(str4, "searchBarHint");
        t.e(str5, "closeLabel");
        t.e(str6, "backLabel");
        this.f25490a = str;
        this.f25491b = str2;
        this.f25492c = str3;
        this.f25493d = str4;
        this.f25494e = str5;
        this.f25495f = str6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        if (t.a(this.f25490a, sVar.f25490a) && t.a(this.f25491b, sVar.f25491b) && t.a(this.f25492c, sVar.f25492c) && t.a(this.f25493d, sVar.f25493d) && t.a(this.f25494e, sVar.f25494e) && t.a(this.f25495f, sVar.f25495f)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f25495f.hashCode() + v.a(this.f25494e, v.a(this.f25493d, v.a(this.f25492c, v.a(this.f25491b, this.f25490a.hashCode() * 31, 31), 31), 31), 31);
    }

    public final String toString() {
        return "StacksScreen(title=" + this.f25490a + ", legalDescriptionTextLabel=" + this.f25491b + ", agreeToAllButton=" + this.f25492c + ", searchBarHint=" + this.f25493d + ", closeLabel=" + this.f25494e + ", backLabel=" + this.f25495f + ')';
    }
}
