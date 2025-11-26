package com.mbridge.msdk.newreward.function.c.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.work.WorkRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.a.c.a;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.newreward.function.common.VolleyErrorUtils;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.tracker.network.ac;
import com.mbridge.msdk.tracker.network.ad;
import com.mbridge.msdk.tracker.network.e;
import com.mbridge.msdk.tracker.network.r;
import com.mbridge.msdk.tracker.network.t;
import com.mbridge.msdk.tracker.network.toolbox.f;
import com.mbridge.msdk.tracker.network.u;
import com.mbridge.msdk.tracker.network.w;
import com.mbridge.msdk.tracker.network.y;
import com.mbridge.msdk.tracker.network.z;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends u<JSONObject> implements w.a {

    /* renamed from: a  reason: collision with root package name */
    protected b f10584a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f10585b = c.m().c();

    /* renamed from: c  reason: collision with root package name */
    protected int f10586c;

    /* renamed from: d  reason: collision with root package name */
    protected String f10587d;

    /* renamed from: e  reason: collision with root package name */
    protected String f10588e;

    /* renamed from: f  reason: collision with root package name */
    protected String f10589f;

    /* renamed from: g  reason: collision with root package name */
    private Map<String, String> f10590g;

    /* renamed from: h  reason: collision with root package name */
    private c f10591h;

    /* renamed from: i  reason: collision with root package name */
    private z f10592i;

    /* renamed from: j  reason: collision with root package name */
    private long f10593j;

    /* renamed from: k  reason: collision with root package name */
    private long f10594k;

    /* renamed from: l  reason: collision with root package name */
    private String f10595l;

    /* renamed from: m  reason: collision with root package name */
    private String f10596m;

    /* renamed from: n  reason: collision with root package name */
    private String f10597n;

    /* renamed from: o  reason: collision with root package name */
    private String f10598o;

    /* renamed from: p  reason: collision with root package name */
    private Map<String, String> f10599p;

    /* renamed from: q  reason: collision with root package name */
    private long f10600q;

    /* renamed from: com.mbridge.msdk.newreward.function.c.b.a$a  reason: collision with other inner class name */
    private static final class C0101a implements a.C0098a {

        /* renamed from: a  reason: collision with root package name */
        private final a f10601a;

        /* renamed from: b  reason: collision with root package name */
        private final b f10602b;

        public C0101a(a aVar, b bVar) {
            this.f10601a = aVar;
            this.f10602b = bVar;
        }

        public final void a(String str, long j5) {
            af.a("BaseCampaignRequest", "onTimeout taskID = " + str + ", timeout = " + j5);
            a.a(this.f10601a, this.f10602b, j5);
        }
    }

    public a(int i5, String str, String str2, String str3, long j5, String str4, String str5) {
        super(0, str4, 0, str5);
        this.f10586c = i5;
        this.f10587d = str;
        this.f10588e = str2;
        this.f10589f = str3;
        this.f10595l = UUID.randomUUID().toString();
        this.f10593j = SystemClock.elapsedRealtime();
        this.f10598o = str4;
        this.f10584a = new b(this.f10586c, this.f10587d, this.f10588e, this.f10589f);
        a((w.a) this);
        d(true);
        c(true);
        this.f10600q = j5 <= 0 ? WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS : j5;
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f10595l, this.f10600q, new C0101a(this, this.f10584a));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void a(Object obj) {
        c cVar;
        JSONObject jSONObject = (JSONObject) obj;
        if (MBridgeConstans.DEBUG) {
            af.a("BaseCampaignRequest", "deliverResponse: " + jSONObject);
        }
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f10595l);
        int optInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        if (optInt == 1) {
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject != null) {
                CampaignUnit parseCampaignUnit = com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(optJSONObject, this.f10596m);
                this.f10584a.a(optJSONObject);
                this.f10584a.f(optJSONObject.optString("c"));
                this.f10584a.e(optJSONObject.optString(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B));
                this.f10584a.d(optJSONObject.optString("a"));
                this.f10584a.d(optJSONObject.optInt("template"));
                this.f10584a.a(System.currentTimeMillis());
                this.f10584a.c(this.f10596m);
                this.f10584a.g(optJSONObject.optString(com.mbridge.msdk.foundation.same.a.f9177T));
                this.f10584a.c(1);
                this.f10584a.e(0);
                this.f10584a.a(parseCampaignUnit.getRequestId());
                this.f10584a.a(parseCampaignUnit.getEcppv());
                this.f10584a.i(this.f10598o);
                this.f10584a.a(parseCampaignUnit.getSecondRequestIndex());
                this.f10584a.b(parseCampaignUnit.getSecondShowIndex());
                ArrayList arrayList = new ArrayList();
                MBridgeGlobalCommon.handlerCampaigns(this.f10597n, this.f10584a, parseCampaignUnit.getAds(), arrayList);
                b bVar = this.f10584a;
                if (!(bVar == null || (cVar = this.f10591h) == null)) {
                    try {
                        cVar.a(bVar, this);
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("BaseCampaignRequest", "handlerOnSuccessEvent Exception: ", e5);
                        }
                    }
                }
            } else {
                a(this, this.f10584a, new b(7, "data is null"));
            }
        } else {
            b bVar2 = new b(9);
            bVar2.a(jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, ""));
            bVar2.a(optInt);
            bVar2.c(jSONObject.toString());
            a(this, this.f10584a, bVar2);
        }
        this.f10594k = SystemClock.elapsedRealtime();
    }

    public final void b(String str) {
        c("local_id", str);
        c("ad_type", String.valueOf(this.f10586c));
        this.f10597n = str;
    }

    public final Map<String, String> c() {
        if (this.f10599p == null) {
            this.f10599p = new HashMap();
        }
        this.f10599p.put("Charset", C.UTF8_NAME);
        return this.f10599p;
    }

    public final boolean d() {
        return true;
    }

    public final z b() {
        if (this.f10592i == null) {
            this.f10592i = new e(10000, this.f10600q, 5);
        }
        return this.f10592i;
    }

    public final void b(String str, String str2) {
        if (this.f10599p == null) {
            this.f10599p = new HashMap();
        }
        this.f10599p.put(str, str2);
    }

    public final void a(c cVar) {
        this.f10591h = cVar;
    }

    public final void a(String str, String str2) {
        if (this.f10590g == null) {
            this.f10590g = new HashMap();
        }
        if (!TextUtils.isEmpty(str)) {
            Map<String, String> map = this.f10590g;
            if (str2 == null) {
                str2 = "";
            }
            map.put(str, str2);
        }
    }

    public final void a(String str) {
        this.f10596m = str;
    }

    public final void a(Map<String, String> map) {
        if (this.f10590g == null) {
            this.f10590g = new HashMap();
        }
        if (map != null && map.size() != 0) {
            this.f10590g.putAll(map);
        }
    }

    /* access modifiers changed from: protected */
    public final Map<String, String> a() {
        if (this.f10590g == null) {
            this.f10590g = new HashMap();
        }
        return this.f10590g;
    }

    /* access modifiers changed from: protected */
    public final w<JSONObject> a(r rVar) {
        if (rVar != null) {
            try {
                byte[] bArr = rVar.f11656b;
                if (bArr != null) {
                    if (bArr.length != 0) {
                        return w.a(new JSONObject(new String(bArr, StandardCharsets.UTF_8)), f.a(rVar));
                    }
                }
            } catch (JSONException e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("BaseCampaignRequest", "parseNetworkResponse JSONException: ", e5);
                }
                return w.a(new t(e5));
            } catch (Exception e6) {
                if (MBridgeConstans.DEBUG) {
                    af.b("BaseCampaignRequest", "parseNetworkResponse Exception: ", e6);
                }
                return w.a(new ac((Throwable) e6));
            }
        }
        return w.a(new y());
    }

    public final void a(ad adVar) {
        c cVar;
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f10595l);
        if (MBridgeConstans.DEBUG) {
            af.b("BaseCampaignRequest", "onErrorResponse: " + adVar.getMessage());
        }
        b bVar = this.f10584a;
        if (bVar != null && (cVar = this.f10591h) != null) {
            try {
                cVar.b(bVar, this, VolleyErrorUtils.parseVolleyError(adVar));
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("BaseCampaignRequest", "onError Exception: ", e5);
                }
            }
        }
    }

    private static void a(a aVar, b bVar, b bVar2) {
        c cVar;
        if (aVar != null && bVar != null && (cVar = aVar.f10591h) != null) {
            try {
                cVar.a(bVar, aVar, bVar2);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("BaseCampaignRequest", "handlerOnFailedEvent Exception: ", e5);
                }
            }
        }
    }

    static /* synthetic */ void a(a aVar, b bVar, long j5) {
        c cVar;
        if (aVar != null && bVar != null && (cVar = aVar.f10591h) != null) {
            try {
                b bVar2 = bVar;
                cVar.a(bVar2, aVar, j5, new b(10, "v3 is timeout"));
            } catch (Exception e5) {
                Exception exc = e5;
                if (MBridgeConstans.DEBUG) {
                    af.b("BaseCampaignRequest", "onTimeout Exception: ", exc);
                }
            }
        }
    }
}
