package l2;

import com.uptodown.UptodownApp;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.json.JSONObject;

/* renamed from: l2.h  reason: case insensitive filesystem */
public final class C2659h {

    /* renamed from: f  reason: collision with root package name */
    public static final a f25088f = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private long f25089a;

    /* renamed from: b  reason: collision with root package name */
    private String f25090b;

    /* renamed from: c  reason: collision with root package name */
    private int f25091c;

    /* renamed from: d  reason: collision with root package name */
    private String f25092d;

    /* renamed from: e  reason: collision with root package name */
    private int f25093e;

    /* renamed from: l2.h$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final C2659h a(JSONObject jSONObject) {
            t.e(jSONObject, "jsonObjectData");
            C2659h hVar = new C2659h();
            hVar.f(jSONObject);
            return hVar;
        }

        private a() {
        }
    }

    /* access modifiers changed from: private */
    public final void f(JSONObject jSONObject) {
        if (!jSONObject.isNull("id")) {
            this.f25089a = jSONObject.optLong("id");
        }
        if (!jSONObject.isNull("sha256")) {
            this.f25090b = jSONObject.optString("sha256");
        }
        if (!jSONObject.isNull("active")) {
            this.f25091c = jSONObject.optInt("active");
        }
        if (!jSONObject.isNull("url")) {
            this.f25092d = jSONObject.optString("url");
        }
        if (!jSONObject.isNull("isTurbo")) {
            this.f25093e = jSONObject.optInt("isTurbo");
        }
    }

    public final int b() {
        return this.f25091c;
    }

    public final String c() {
        if (this.f25092d == null) {
            return null;
        }
        return this.f25092d + UptodownApp.f13477F.q() + ":webp";
    }

    public final long d() {
        return this.f25089a;
    }

    public final String e() {
        return this.f25092d;
    }
}
