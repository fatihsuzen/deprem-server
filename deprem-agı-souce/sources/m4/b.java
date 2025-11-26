package m4;

import J2.v;
import R3.m;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;
import kotlin.jvm.internal.t;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f25308a;

    /* renamed from: b  reason: collision with root package name */
    public final List f25309b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25310c;

    /* renamed from: d  reason: collision with root package name */
    public final String f25311d;

    /* renamed from: e  reason: collision with root package name */
    public final String f25312e;

    /* renamed from: f  reason: collision with root package name */
    public final String f25313f;

    public b(String str, String str2, String str3, String str4, String str5, List list) {
        t.e(str, CampaignEx.JSON_KEY_TITLE);
        t.e(list, TtmlNode.TAG_BODY);
        t.e(str2, "deleteDataLinkText");
        t.e(str3, "accessDataLinkText");
        t.e(str4, "privacyPolicyLinkText");
        t.e(str5, "backLabel");
        this.f25308a = str;
        this.f25309b = list;
        this.f25310c = str2;
        this.f25311d = str3;
        this.f25312e = str4;
        this.f25313f = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (t.a(this.f25308a, bVar.f25308a) && t.a(this.f25309b, bVar.f25309b) && t.a(this.f25310c, bVar.f25310c) && t.a(this.f25311d, bVar.f25311d) && t.a(this.f25312e, bVar.f25312e) && t.a(this.f25313f, bVar.f25313f)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f25313f.hashCode() + v.a(this.f25312e, v.a(this.f25311d, v.a(this.f25310c, m.a(this.f25309b, this.f25308a.hashCode() * 31, 31), 31), 31), 31);
    }

    public final String toString() {
        return "CCPAScreen(title=" + this.f25308a + ", body=" + this.f25309b + ", deleteDataLinkText=" + this.f25310c + ", accessDataLinkText=" + this.f25311d + ", privacyPolicyLinkText=" + this.f25312e + ", backLabel=" + this.f25313f + ')';
    }
}
