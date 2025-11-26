package com.mbridge.msdk.newreward.function.c.b;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.tracker.network.ac;
import com.mbridge.msdk.tracker.network.ad;
import com.mbridge.msdk.tracker.network.r;
import com.mbridge.msdk.tracker.network.toolbox.f;
import com.mbridge.msdk.tracker.network.u;
import com.mbridge.msdk.tracker.network.w;
import com.mbridge.msdk.tracker.network.y;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h extends u<JSONObject> implements w.a {

    /* renamed from: a  reason: collision with root package name */
    public static int f10613a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f10614b = 1;

    /* renamed from: c  reason: collision with root package name */
    private e f10615c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, String> f10616d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f10617e;

    public h(String str) {
        super(0, str, 0, "setting");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        e eVar = this.f10615c;
        if (eVar != null) {
            if (jSONObject == null) {
                try {
                    eVar.a((u<JSONObject>) this, new d(-1));
                } catch (Exception e5) {
                    af.b("RewardSettingRequest", "onError Exception: ", e5);
                }
            } else {
                eVar.a(jSONObject, (u<JSONObject>) this);
            }
        }
    }

    public final Map<String, String> c() {
        Map<String, String> map = this.f10617e;
        if (map == null) {
            HashMap hashMap = new HashMap();
            this.f10617e = hashMap;
            return hashMap;
        }
        map.put("Charset", C.UTF8_NAME);
        return this.f10617e;
    }

    public final boolean d() {
        return true;
    }

    public final void a(e eVar) {
        this.f10615c = eVar;
    }

    public final void a(Map<String, String> map) {
        if (this.f10616d == null) {
            this.f10616d = new HashMap<>();
        }
        if (map != null && !map.isEmpty()) {
            this.f10616d.putAll(map);
        }
    }

    /* access modifiers changed from: protected */
    public final Map<String, String> a() {
        if (this.f10616d == null) {
            this.f10616d = new HashMap<>();
        }
        return this.f10616d;
    }

    /* access modifiers changed from: protected */
    public final w<JSONObject> a(r rVar) {
        if (rVar != null) {
            try {
                byte[] bArr = rVar.f11656b;
                if (bArr != null) {
                    if (bArr.length != 0) {
                        return w.a(new JSONObject(new String(bArr, f.a(rVar.f11657c))), f.a(rVar));
                    }
                }
            } catch (UnsupportedEncodingException e5) {
                af.b("RewardSettingRequest", "parseNetworkResponse UnsupportedEncodingException: ", e5);
                return w.a(new com.mbridge.msdk.tracker.network.f(e5));
            } catch (Exception e6) {
                af.b("RewardSettingRequest", "parseNetworkResponse Exception: ", e6);
                return w.a(new ac((Throwable) e6));
            }
        }
        return w.a(new y());
    }

    public final void a(String str, String str2) {
        if (this.f10617e == null) {
            this.f10617e = new HashMap();
        }
        this.f10617e.put(str, str2);
    }

    public final void a(ad adVar) {
        this.f10615c.a((u<JSONObject>) this, new d(-1, adVar.getMessage()));
    }
}
