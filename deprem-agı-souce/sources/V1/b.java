package v1;

import A1.c;
import A1.g;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;
import u1.n;
import x1.i;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final n f16747a;

    private b(n nVar) {
        this.f16747a = nVar;
    }

    private void e(float f5) {
        if (f5 <= 0.0f) {
            throw new IllegalArgumentException("Invalid Media duration");
        }
    }

    private void f(float f5) {
        if (f5 < 0.0f || f5 > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }

    public static b g(u1.b bVar) {
        n nVar = (n) bVar;
        g.b(bVar, "AdSession is null");
        g.k(nVar);
        g.h(nVar);
        g.g(nVar);
        g.m(nVar);
        b bVar2 = new b(nVar);
        nVar.t().m(bVar2);
        return bVar2;
    }

    public void a(a aVar) {
        g.b(aVar, "InteractionType is null");
        g.f(this.f16747a);
        JSONObject jSONObject = new JSONObject();
        c.h(jSONObject, "interactionType", aVar);
        this.f16747a.t().f("adUserInteraction", jSONObject);
    }

    public void b() {
        g.f(this.f16747a);
        this.f16747a.t().d("bufferFinish");
    }

    public void c() {
        g.f(this.f16747a);
        this.f16747a.t().d("bufferStart");
    }

    public void d() {
        g.f(this.f16747a);
        this.f16747a.t().d(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
    }

    public void h() {
        g.f(this.f16747a);
        this.f16747a.t().d("firstQuartile");
    }

    public void i() {
        g.f(this.f16747a);
        this.f16747a.t().d(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT);
    }

    public void j() {
        g.f(this.f16747a);
        this.f16747a.t().d(CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
    }

    public void k() {
        g.f(this.f16747a);
        this.f16747a.t().d(CampaignEx.JSON_NATIVE_VIDEO_RESUME);
    }

    public void l() {
        g.f(this.f16747a);
        this.f16747a.t().d("skipped");
    }

    public void m(float f5, float f6) {
        e(f5);
        f(f6);
        g.f(this.f16747a);
        JSONObject jSONObject = new JSONObject();
        c.h(jSONObject, TypedValues.TransitionType.S_DURATION, Float.valueOf(f5));
        c.h(jSONObject, "mediaPlayerVolume", Float.valueOf(f6));
        c.h(jSONObject, "deviceVolume", Float.valueOf(i.d().c()));
        this.f16747a.t().f("start", jSONObject);
    }

    public void n() {
        g.f(this.f16747a);
        this.f16747a.t().d("thirdQuartile");
    }

    public void o(float f5) {
        f(f5);
        g.f(this.f16747a);
        JSONObject jSONObject = new JSONObject();
        c.h(jSONObject, "mediaPlayerVolume", Float.valueOf(f5));
        c.h(jSONObject, "deviceVolume", Float.valueOf(i.d().c()));
        this.f16747a.t().f("volumeChange", jSONObject);
    }
}
