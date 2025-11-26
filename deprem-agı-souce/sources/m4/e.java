package m4;

import J2.v;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f25332a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25333b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25334c;

    /* renamed from: d  reason: collision with root package name */
    public final String f25335d;

    /* renamed from: e  reason: collision with root package name */
    public final String f25336e;

    /* renamed from: f  reason: collision with root package name */
    public final List f25337f;

    public e(String str, String str2, String str3, String str4, String str5, List list) {
        t.e(str, "initScreenSettingsButton");
        t.e(str2, "action1Label");
        t.e(str3, "action2Label");
        t.e(str4, "privacyBody");
        t.e(str5, "privacyHeader");
        t.e(list, "customFooterLink");
        this.f25332a = str;
        this.f25333b = str2;
        this.f25334c = str3;
        this.f25335d = str4;
        this.f25336e = str5;
        this.f25337f = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (t.a(this.f25332a, eVar.f25332a) && t.a(this.f25333b, eVar.f25333b) && t.a(this.f25334c, eVar.f25334c) && t.a(this.f25335d, eVar.f25335d) && t.a(this.f25336e, eVar.f25336e) && t.a(this.f25337f, eVar.f25337f)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f25337f.hashCode() + v.a(this.f25336e, v.a(this.f25335d, v.a(this.f25334c, v.a(this.f25333b, this.f25332a.hashCode() * 31, 31), 31), 31), 31);
    }

    public final String toString() {
        return "ConsentOrPayUILabels(initScreenSettingsButton=" + this.f25332a + ", action1Label=" + this.f25333b + ", action2Label=" + this.f25334c + ", privacyBody=" + this.f25335d + ", privacyHeader=" + this.f25336e + ", customFooterLink=" + this.f25337f + ')';
    }

    public /* synthetic */ e() {
        this("", "", "", "", "", new ArrayList());
    }
}
