package z1;

import A1.c;
import A1.f;
import D1.b;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
import u1.d;
import u1.m;
import u1.n;
import x1.g;
import x1.h;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private String f17241a;

    /* renamed from: b  reason: collision with root package name */
    private b f17242b = new b((WebView) null);

    /* renamed from: c  reason: collision with root package name */
    private u1.a f17243c;

    /* renamed from: d  reason: collision with root package name */
    private v1.b f17244d;

    /* renamed from: e  reason: collision with root package name */
    private C0170a f17245e;

    /* renamed from: f  reason: collision with root package name */
    private long f17246f;

    /* renamed from: z1.a$a  reason: collision with other inner class name */
    enum C0170a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public a(String str) {
        a();
        this.f17241a = str;
    }

    public void a() {
        this.f17246f = f.b();
        this.f17245e = C0170a.AD_STATE_IDLE;
    }

    public void b(float f5) {
        h.a().c(w(), this.f17241a, f5);
    }

    /* access modifiers changed from: package-private */
    public void c(WebView webView) {
        this.f17242b = new b(webView);
    }

    public void d(String str) {
        f(str, (JSONObject) null);
    }

    public void e(String str, long j5) {
        C0170a aVar;
        if (j5 >= this.f17246f && this.f17245e != (aVar = C0170a.AD_STATE_NOTVISIBLE)) {
            this.f17245e = aVar;
            h.a().m(w(), this.f17241a, str);
        }
    }

    public void f(String str, JSONObject jSONObject) {
        h.a().e(w(), this.f17241a, str, jSONObject);
    }

    public void g(Date date) {
        if (date != null) {
            JSONObject jSONObject = new JSONObject();
            c.h(jSONObject, CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(date.getTime()));
            h.a().j(w(), jSONObject);
        }
    }

    public void h(JSONObject jSONObject) {
        h.a().n(w(), this.f17241a, jSONObject);
    }

    public void i(u1.a aVar) {
        this.f17243c = aVar;
    }

    public void j(u1.c cVar) {
        h.a().f(w(), this.f17241a, cVar.d());
    }

    public void k(n nVar, d dVar) {
        l(nVar, dVar, (JSONObject) null);
    }

    /* access modifiers changed from: protected */
    public void l(n nVar, d dVar, JSONObject jSONObject) {
        String s5 = nVar.s();
        JSONObject jSONObject2 = new JSONObject();
        c.h(jSONObject2, "environment", MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        c.h(jSONObject2, "adSessionType", dVar.c());
        c.h(jSONObject2, "deviceInfo", A1.b.d());
        c.h(jSONObject2, "deviceCategory", A1.a.a().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        c.h(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        c.h(jSONObject3, "partnerName", dVar.h().b());
        c.h(jSONObject3, "partnerVersion", dVar.h().c());
        c.h(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        c.h(jSONObject4, "libraryVersion", "1.4.13-Mmadbridge");
        c.h(jSONObject4, "appId", g.c().a().getApplicationContext().getPackageName());
        c.h(jSONObject2, MBridgeConstans.DYNAMIC_VIEW_WX_APP, jSONObject4);
        if (dVar.d() != null) {
            c.h(jSONObject2, "contentUrl", dVar.d());
        }
        if (dVar.e() != null) {
            c.h(jSONObject2, "customReferenceData", dVar.e());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (m mVar : dVar.i()) {
            c.h(jSONObject5, mVar.d(), mVar.e());
        }
        h.a().g(w(), s5, jSONObject2, jSONObject5, jSONObject);
    }

    public void m(v1.b bVar) {
        this.f17244d = bVar;
    }

    public void n(boolean z4) {
        String str;
        if (t()) {
            if (z4) {
                str = "foregrounded";
            } else {
                str = "backgrounded";
            }
            h.a().o(w(), this.f17241a, str);
        }
    }

    public void o() {
        this.f17242b.clear();
    }

    public void p(String str, long j5) {
        if (j5 >= this.f17246f) {
            this.f17245e = C0170a.AD_STATE_VISIBLE;
            h.a().m(w(), this.f17241a, str);
        }
    }

    public void q(boolean z4) {
        String str;
        if (t()) {
            if (z4) {
                str = "locked";
            } else {
                str = "unlocked";
            }
            h.a().d(w(), this.f17241a, str);
        }
    }

    public u1.a r() {
        return this.f17243c;
    }

    public v1.b s() {
        return this.f17244d;
    }

    public boolean t() {
        if (this.f17242b.get() != null) {
            return true;
        }
        return false;
    }

    public void u() {
        h.a().b(w(), this.f17241a);
    }

    public void v() {
        h.a().l(w(), this.f17241a);
    }

    public WebView w() {
        return (WebView) this.f17242b.get();
    }

    public void x() {
        h((JSONObject) null);
    }

    public void y() {
    }
}
