package com.mbridge.msdk.newreward.a.b;

import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.function.c.b.f;
import com.mbridge.msdk.newreward.function.common.MBridgeTaskManager;
import com.mbridge.msdk.newreward.function.f.d;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.tracker.network.u;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m implements a {

    /* renamed from: a  reason: collision with root package name */
    private String f10394a;

    private static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final com.mbridge.msdk.foundation.c.b f10395a;

        /* renamed from: b  reason: collision with root package name */
        private final b f10396b;

        public a(com.mbridge.msdk.foundation.c.b bVar, b bVar2) {
            this.f10395a = bVar;
            this.f10396b = bVar2;
        }

        public final void run() {
            com.mbridge.msdk.foundation.c.b bVar;
            b bVar2 = this.f10396b;
            if (bVar2 != null && (bVar = this.f10395a) != null) {
                bVar2.reqFailed(bVar);
            }
        }
    }

    private static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final String f10399a;

        /* renamed from: b  reason: collision with root package name */
        private JSONObject f10400b;

        /* renamed from: c  reason: collision with root package name */
        private final b f10401c;

        public c(String str, JSONObject jSONObject, b bVar) {
            this.f10399a = str;
            this.f10400b = jSONObject;
            this.f10401c = bVar;
        }

        public final void run() {
            com.mbridge.msdk.videocommon.d.c cVar;
            if (this.f10401c != null && this.f10400b != null) {
                try {
                    String k5 = com.mbridge.msdk.foundation.controller.c.m().k();
                    if (ak.a(this.f10400b)) {
                        JSONObject optJSONObject = this.f10400b.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                        this.f10400b = optJSONObject;
                        if (optJSONObject != null) {
                            if (optJSONObject.optInt("vtag_status", 0) == 1) {
                                String e5 = com.mbridge.msdk.videocommon.d.b.a().e(k5, this.f10399a);
                                if (!TextUtils.isEmpty(e5)) {
                                    this.f10400b = h.a().a(new JSONObject(e5), this.f10400b);
                                }
                            }
                            if (com.mbridge.msdk.videocommon.d.b.e(this.f10400b.toString())) {
                                this.f10400b.put("current_time", System.currentTimeMillis());
                                com.mbridge.msdk.videocommon.d.b.a().a(k5, this.f10399a, this.f10400b.toString());
                            }
                            cVar = com.mbridge.msdk.videocommon.d.c.c(this.f10400b.toString());
                            this.f10401c.reqSuccessful(cVar);
                        }
                    } else {
                        com.mbridge.msdk.videocommon.d.b.a().d(k5, this.f10399a);
                    }
                    cVar = null;
                    this.f10401c.reqSuccessful(cVar);
                } catch (Throwable th) {
                    af.b("ReqRewardUnitSettingService", th.getMessage());
                }
            }
        }
    }

    public final void a(Object obj, b bVar) throws IOException {
        String str;
        int i5;
        int d5;
        String str2;
        if (obj != null) {
            d dVar = (d) obj;
            String k5 = com.mbridge.msdk.foundation.controller.c.m().k();
            this.f10394a = dVar.b();
            dVar.b(com.mbridge.msdk.newreward.function.c.b.h.f10614b);
            if (!com.mbridge.msdk.videocommon.d.b.a().d(this.f10394a)) {
                com.mbridge.msdk.videocommon.d.b.a().a(this.f10394a);
                try {
                    com.mbridge.msdk.videocommon.d.c f5 = com.mbridge.msdk.videocommon.d.b.a().f(k5, this.f10394a);
                    if (f5 == null) {
                        str2 = "";
                    } else {
                        str2 = f5.j();
                    }
                    dVar.b(str2);
                } catch (Throwable th) {
                    af.b("ReqRewardUnitSettingService", th.getMessage());
                }
                try {
                    if (com.mbridge.msdk.foundation.same.net.e.d.f().f9383r) {
                        str = com.mbridge.msdk.foundation.same.net.e.d.f().f9349J;
                    } else {
                        str = com.mbridge.msdk.foundation.same.net.e.d.f().f9348I;
                    }
                    if (com.mbridge.msdk.foundation.same.net.e.d.f().f9383r) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("uri", str);
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, dVar.d());
                        e.a().a(com.mbridge.msdk.foundation.same.net.e.d.f().f9377l, com.mbridge.msdk.foundation.same.net.e.d.f().f9381p, jSONObject.toString(), true, new b(this.f10394a, bVar));
                        return;
                    }
                    com.mbridge.msdk.newreward.function.c.b.h hVar = new com.mbridge.msdk.newreward.function.c.b.h(str);
                    hVar.a(dVar.c());
                    hVar.a((com.mbridge.msdk.newreward.function.c.b.e) new b(this.f10394a, bVar));
                    byte[] p5 = hVar.p();
                    if (p5 != null) {
                        i5 = p5.length;
                    } else {
                        i5 = 0;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(com.mbridge.msdk.foundation.same.net.f.e.f9401h, String.valueOf(i5));
                    hVar.a((Map<String, String>) hashMap);
                    if (p5 != null && (d5 = com.mbridge.msdk.foundation.same.net.e.d.f().d()) > 0 && i5 > d5) {
                        hVar.a(1);
                        hVar.a("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
                    }
                    f.a().a((u<JSONObject>) hVar);
                } catch (Exception e5) {
                    throw new IOException(e5);
                }
            }
        } else {
            throw new IOException("ReqRewardUnitSettingService doReq: params is null");
        }
    }

    private static final class b implements com.mbridge.msdk.foundation.same.net.b<JSONObject>, com.mbridge.msdk.newreward.function.c.b.e {

        /* renamed from: a  reason: collision with root package name */
        private final String f10397a;

        /* renamed from: b  reason: collision with root package name */
        private final b f10398b;

        public b(String str, b bVar) {
            this.f10397a = str;
            this.f10398b = bVar;
        }

        public final void a(JSONObject jSONObject, u<JSONObject> uVar) {
            com.mbridge.msdk.videocommon.d.b.a().b(this.f10397a);
            MBridgeTaskManager.commonExecute(new c(this.f10397a, jSONObject, this.f10398b));
        }

        public final void onError(com.mbridge.msdk.foundation.same.net.a.a aVar) {
            com.mbridge.msdk.videocommon.d.b.a().b(this.f10397a);
            MBridgeTaskManager.commonExecute(new a(new com.mbridge.msdk.foundation.c.b(880002, aVar.getMessage()), this.f10398b));
        }

        public final void onSuccess(com.mbridge.msdk.foundation.same.net.d<JSONObject> dVar) {
            com.mbridge.msdk.videocommon.d.b.a().b(this.f10397a);
            MBridgeTaskManager.commonExecute(new c(this.f10397a, (JSONObject) dVar.f9311c, this.f10398b));
        }

        public final void a(u<JSONObject> uVar, com.mbridge.msdk.newreward.function.c.b.d dVar) {
            com.mbridge.msdk.videocommon.d.b.a().b(this.f10397a);
            MBridgeTaskManager.commonExecute(new a(new com.mbridge.msdk.foundation.c.b(880002, dVar.a()), this.f10398b));
        }
    }
}
