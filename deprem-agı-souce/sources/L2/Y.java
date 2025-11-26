package l2;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONObject;

public final class Y {

    /* renamed from: k  reason: collision with root package name */
    public static final a f24916k = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private long f24917a = -1;

    /* renamed from: b  reason: collision with root package name */
    private String f24918b;

    /* renamed from: c  reason: collision with root package name */
    private String f24919c;

    /* renamed from: d  reason: collision with root package name */
    private String f24920d;

    /* renamed from: e  reason: collision with root package name */
    private String f24921e;

    /* renamed from: f  reason: collision with root package name */
    private long f24922f = -1;

    /* renamed from: g  reason: collision with root package name */
    private String f24923g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList f24924h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private String f24925i;

    /* renamed from: j  reason: collision with root package name */
    private long f24926j = -1;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final Y a(JSONObject jSONObject) {
            t.e(jSONObject, "jsonObject");
            Y y4 = new Y();
            if (!jSONObject.isNull("appID")) {
                y4.m(jSONObject.optLong("appID"));
            }
            if (!jSONObject.isNull(RewardPlus.NAME)) {
                y4.q(jSONObject.optString(RewardPlus.NAME));
            }
            if (!jSONObject.isNull(RewardPlus.ICON)) {
                y4.p(jSONObject.optString(RewardPlus.ICON));
            }
            if (!jSONObject.isNull("packagename")) {
                y4.r(jSONObject.optString("packagename"));
            }
            if (!jSONObject.isNull("wishlistAdded")) {
                y4.u(jSONObject.optString("wishlistAdded"));
            }
            if (!jSONObject.isNull("platformID")) {
                y4.s(jSONObject.optLong("platformID"));
            }
            if (!jSONObject.isNull("downloadStatus")) {
                y4.n(jSONObject.optString("downloadStatus"));
            }
            if (!jSONObject.isNull("url")) {
                y4.t(jSONObject.optString("url"));
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("floatingCategories");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i5 = 0; i5 < length; i5++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                    C2660i iVar = new C2660i(0, (String) null, (String) null, 7, (C2633k) null);
                    t.b(optJSONObject);
                    iVar.p(optJSONObject);
                    y4.c().add(iVar);
                }
            }
            return y4;
        }

        private a() {
        }
    }

    public final long a() {
        return this.f24917a;
    }

    public final String b() {
        return this.f24923g;
    }

    public final ArrayList c() {
        return this.f24924h;
    }

    public final String d() {
        return this.f24919c;
    }

    public final String e() {
        if (this.f24919c == null) {
            return null;
        }
        return this.f24919c + UptodownApp.f13477F.r() + ":webp";
    }

    public final String f() {
        return this.f24918b;
    }

    public final String g() {
        return this.f24920d;
    }

    public final String h() {
        return this.f24925i;
    }

    public final String i() {
        return this.f24921e;
    }

    public final boolean j() {
        if (this.f24922f == 13) {
            return true;
        }
        return false;
    }

    public final boolean k() {
        if (this.f24922f == 3) {
            return true;
        }
        return false;
    }

    public final boolean l() {
        if (this.f24922f == 1) {
            return true;
        }
        return false;
    }

    public final void m(long j5) {
        this.f24917a = j5;
    }

    public final void n(String str) {
        this.f24923g = str;
    }

    public final void o(long j5) {
        this.f24926j = j5;
    }

    public final void p(String str) {
        this.f24919c = str;
    }

    public final void q(String str) {
        this.f24918b = str;
    }

    public final void r(String str) {
        this.f24920d = str;
    }

    public final void s(long j5) {
        this.f24922f = j5;
    }

    public final void t(String str) {
        this.f24925i = str;
    }

    public String toString() {
        return "UserListItem(programId=" + this.f24917a + ", name=" + this.f24918b + ", icon=" + this.f24919c + ", packagename=" + this.f24920d + ')';
    }

    public final void u(String str) {
        this.f24921e = str;
    }
}
