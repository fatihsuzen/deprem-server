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

public final class l implements a {

    private static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final com.mbridge.msdk.foundation.c.b f10389a;

        /* renamed from: b  reason: collision with root package name */
        private final b f10390b;

        public a(com.mbridge.msdk.foundation.c.b bVar, b bVar2) {
            this.f10389a = bVar;
            this.f10390b = bVar2;
        }

        public final void run() {
            com.mbridge.msdk.foundation.c.b bVar;
            b bVar2 = this.f10390b;
            if (bVar2 != null && (bVar = this.f10389a) != null) {
                bVar2.reqFailed(bVar);
            }
        }
    }

    private static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private JSONObject f10391a;

        /* renamed from: b  reason: collision with root package name */
        private final b f10392b;

        public b(JSONObject jSONObject, b bVar) {
            this.f10391a = jSONObject;
            this.f10392b = bVar;
        }

        public final void run() {
            com.mbridge.msdk.videocommon.d.a aVar;
            if (this.f10392b != null && this.f10391a != null) {
                try {
                    String k5 = com.mbridge.msdk.foundation.controller.c.m().k();
                    if (ak.a(this.f10391a)) {
                        JSONObject optJSONObject = this.f10391a.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                        this.f10391a = optJSONObject;
                        if (optJSONObject != null) {
                            if (optJSONObject.optInt("vtag_status", 0) == 1) {
                                String g5 = com.mbridge.msdk.videocommon.d.b.a().g(k5);
                                if (!TextUtils.isEmpty(g5)) {
                                    this.f10391a = h.a().a(new JSONObject(g5), this.f10391a);
                                }
                            }
                            this.f10391a.put("current_time", System.currentTimeMillis());
                            com.mbridge.msdk.videocommon.d.b.a().c(k5, this.f10391a.toString());
                            aVar = com.mbridge.msdk.videocommon.d.a.a(this.f10391a.toString());
                            this.f10392b.reqSuccessful(aVar);
                        }
                    } else {
                        com.mbridge.msdk.videocommon.d.b.a().f(k5);
                    }
                    aVar = null;
                    this.f10392b.reqSuccessful(aVar);
                } catch (Throwable th) {
                    af.b("ReqRewardSettingService", th.getMessage());
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
            dVar.b(com.mbridge.msdk.newreward.function.c.b.h.f10613a);
            if (!com.mbridge.msdk.videocommon.d.b.a().d()) {
                com.mbridge.msdk.videocommon.d.b.a().a(true);
                try {
                    com.mbridge.msdk.videocommon.d.a e5 = com.mbridge.msdk.videocommon.d.b.a().e();
                    if (e5 == null) {
                        str2 = "";
                    } else {
                        str2 = e5.a();
                    }
                    dVar.b(str2);
                } catch (Throwable th) {
                    af.b("ReqRewardSettingService", th.getMessage());
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
                        e.a().a(com.mbridge.msdk.foundation.same.net.e.d.f().f9377l, com.mbridge.msdk.foundation.same.net.e.d.f().f9381p, jSONObject.toString(), true, new c(bVar));
                        return;
                    }
                    com.mbridge.msdk.newreward.function.c.b.h hVar = new com.mbridge.msdk.newreward.function.c.b.h(str);
                    hVar.a(dVar.c());
                    hVar.a((com.mbridge.msdk.newreward.function.c.b.e) new c(bVar));
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
                } catch (Exception e6) {
                    throw new IOException(e6);
                }
            }
        } else {
            throw new IOException("ReqRewardSettingService doReq: params is null");
        }
    }

    private static final class c implements com.mbridge.msdk.foundation.same.net.b<JSONObject>, com.mbridge.msdk.newreward.function.c.b.e {

        /* renamed from: a  reason: collision with root package name */
        private final b f10393a;

        public c(b bVar) {
            this.f10393a = bVar;
        }

        public final void a(JSONObject jSONObject, u<JSONObject> uVar) {
            com.mbridge.msdk.videocommon.d.b.a().a(false);
            MBridgeTaskManager.commonExecute(new b(jSONObject, this.f10393a));
        }

        public final void onError(com.mbridge.msdk.foundation.same.net.a.a aVar) {
            com.mbridge.msdk.videocommon.d.b.a().a(false);
            MBridgeTaskManager.commonExecute(new a(new com.mbridge.msdk.foundation.c.b(880002, aVar.getMessage()), this.f10393a));
        }

        public final void onSuccess(com.mbridge.msdk.foundation.same.net.d<JSONObject> dVar) {
            com.mbridge.msdk.videocommon.d.b.a().a(false);
            MBridgeTaskManager.commonExecute(new b((JSONObject) dVar.f9311c, this.f10393a));
        }

        public final void a(u<JSONObject> uVar, com.mbridge.msdk.newreward.function.c.b.d dVar) {
            com.mbridge.msdk.videocommon.d.b.a().a(false);
            MBridgeTaskManager.commonExecute(new a(new com.mbridge.msdk.foundation.c.b(880002, dVar.a()), this.f10393a));
        }
    }
}
