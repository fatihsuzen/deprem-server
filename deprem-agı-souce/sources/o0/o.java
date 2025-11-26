package o0;

import N.C0720n;
import N.C0722p;
import N.C0724s;
import android.content.Context;
import android.text.TextUtils;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    private final String f15653a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15654b;

    /* renamed from: c  reason: collision with root package name */
    private final String f15655c;

    /* renamed from: d  reason: collision with root package name */
    private final String f15656d;

    /* renamed from: e  reason: collision with root package name */
    private final String f15657e;

    /* renamed from: f  reason: collision with root package name */
    private final String f15658f;

    /* renamed from: g  reason: collision with root package name */
    private final String f15659g;

    private o(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0722p.o(!com.google.android.gms.common.util.o.a(str), "ApplicationId must be set.");
        this.f15654b = str;
        this.f15653a = str2;
        this.f15655c = str3;
        this.f15656d = str4;
        this.f15657e = str5;
        this.f15658f = str6;
        this.f15659g = str7;
    }

    public static o a(Context context) {
        C0724s sVar = new C0724s(context);
        String a5 = sVar.a("google_app_id");
        if (TextUtils.isEmpty(a5)) {
            return null;
        }
        return new o(a5, sVar.a("google_api_key"), sVar.a("firebase_database_url"), sVar.a("ga_trackingId"), sVar.a("gcm_defaultSenderId"), sVar.a("google_storage_bucket"), sVar.a("project_id"));
    }

    public String b() {
        return this.f15653a;
    }

    public String c() {
        return this.f15654b;
    }

    public String d() {
        return this.f15657e;
    }

    public String e() {
        return this.f15659g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (!C0720n.a(this.f15654b, oVar.f15654b) || !C0720n.a(this.f15653a, oVar.f15653a) || !C0720n.a(this.f15655c, oVar.f15655c) || !C0720n.a(this.f15656d, oVar.f15656d) || !C0720n.a(this.f15657e, oVar.f15657e) || !C0720n.a(this.f15658f, oVar.f15658f) || !C0720n.a(this.f15659g, oVar.f15659g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return C0720n.b(this.f15654b, this.f15653a, this.f15655c, this.f15656d, this.f15657e, this.f15658f, this.f15659g);
    }

    public String toString() {
        return C0720n.c(this).a("applicationId", this.f15654b).a("apiKey", this.f15653a).a("databaseUrl", this.f15655c).a("gcmSenderId", this.f15657e).a("storageBucket", this.f15658f).a("projectId", this.f15659g).toString();
    }
}
