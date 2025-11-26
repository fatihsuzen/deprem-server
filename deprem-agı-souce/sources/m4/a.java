package m4;

import J2.v;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f25303a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25304b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25305c;

    /* renamed from: d  reason: collision with root package name */
    public final String f25306d;

    /* renamed from: e  reason: collision with root package name */
    public final List f25307e;

    public a(String str, String str2, String str3, String str4, List list) {
        t.e(str, "initScreenSettingsButton");
        t.e(str2, "initScreenRejectButton");
        t.e(str3, "privacyBody");
        t.e(str4, "privacyHeader");
        t.e(list, "customFooterLink");
        this.f25303a = str;
        this.f25304b = str2;
        this.f25305c = str3;
        this.f25306d = str4;
        this.f25307e = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (t.a(this.f25303a, aVar.f25303a) && t.a(this.f25304b, aVar.f25304b) && t.a(this.f25305c, aVar.f25305c) && t.a(this.f25306d, aVar.f25306d) && t.a(this.f25307e, aVar.f25307e)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f25307e.hashCode() + v.a(this.f25306d, v.a(this.f25305c, v.a(this.f25304b, this.f25303a.hashCode() * 31, 31), 31), 31);
    }

    public final String toString() {
        return "AdvancedUILabels(initScreenSettingsButton=" + this.f25303a + ", initScreenRejectButton=" + this.f25304b + ", privacyBody=" + this.f25305c + ", privacyHeader=" + this.f25306d + ", customFooterLink=" + this.f25307e + ')';
    }

    public /* synthetic */ a() {
        this("", "", "", "", new ArrayList());
    }
}
