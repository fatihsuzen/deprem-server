package com.mbridge.msdk.reward.d;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.c.b;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.a.a;
import com.mbridge.msdk.foundation.same.net.d;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.tracker.network.h;
import java.util.List;
import org.json.JSONObject;

public abstract class c extends com.mbridge.msdk.foundation.same.net.c<JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11411a = "c";

    /* renamed from: b  reason: collision with root package name */
    private int f11412b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f11413c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public com.mbridge.msdk.foundation.same.report.d.c f11414d;

    public abstract void a(List<Frame> list);

    public abstract void a(List<h> list, CampaignUnit campaignUnit);

    public abstract void b(int i5, String str, com.mbridge.msdk.foundation.same.report.d.c cVar);

    public void onError(a aVar) {
        String str = f11411a;
        af.b(str, "errorCode = " + aVar.f9304a);
        b bVar = new b(aVar.f9304a, com.mbridge.msdk.foundation.same.net.e.a.a(aVar));
        bVar.a("campaign_request_error", aVar);
        bVar.f(aVar.f9305b);
        this.f11414d.a(bVar);
        b(aVar.f9304a, com.mbridge.msdk.foundation.same.net.e.a.a(aVar), this.f11414d);
    }

    public void onPreExecute() {
        super.onPreExecute();
    }

    public void onSuccess(d<JSONObject> dVar) {
        com.mbridge.msdk.foundation.same.net.d.a aVar;
        CampaignUnit campaignUnit;
        String str;
        super.onSuccess(dVar);
        if (dVar == null || (aVar = dVar.f9310b) == null) {
            return;
        }
        int i5 = this.f11412b;
        if (i5 == 0) {
            final List<h> list = aVar.f9313b;
            final JSONObject jSONObject = (JSONObject) dVar.f9311c;
            final int optInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
            if (1 == optInt) {
                calcRequestTime(System.currentTimeMillis());
                final String optString = jSONObject.optString("version");
                com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() {
                    public final void run() {
                        final CampaignUnit campaignUnit;
                        if ("v5".equals(optString)) {
                            campaignUnit = com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA), c.this.f11413c);
                        } else {
                            campaignUnit = com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA), c.this.f11413c);
                        }
                        com.mbridge.msdk.foundation.same.f.a.c().post(new Runnable() {
                            public final void run() {
                                String str;
                                CampaignUnit campaignUnit = campaignUnit;
                                if (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0) {
                                    CampaignUnit campaignUnit2 = campaignUnit;
                                    if (campaignUnit2 != null) {
                                        str = campaignUnit2.getMsg();
                                    } else {
                                        str = null;
                                    }
                                    if (TextUtils.isEmpty(str)) {
                                        str = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                                    }
                                    AnonymousClass1 r12 = AnonymousClass1.this;
                                    c cVar = c.this;
                                    cVar.b(optInt, str, cVar.f11414d);
                                    return;
                                }
                                campaignUnit.setMetricsData(c.this.f11414d);
                                AnonymousClass1 r02 = AnonymousClass1.this;
                                c.this.a(list, campaignUnit);
                                c.this.saveRequestTime(campaignUnit.getAds().size());
                            }
                        });
                    }
                });
                return;
            }
            a(list, jSONObject, optInt, this.f11414d);
            return;
        }
        if (i5 == 1) {
            List<h> list2 = aVar.f9313b;
            JSONObject jSONObject2 = (JSONObject) dVar.f9311c;
            int optInt2 = jSONObject2.optInt(NotificationCompat.CATEGORY_STATUS);
            if (1 == optInt2) {
                calcRequestTime(System.currentTimeMillis());
                if ("v5".equals(jSONObject2.optString("version"))) {
                    campaignUnit = com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(jSONObject2.optJSONObject(DataSchemeDataSource.SCHEME_DATA), this.f11413c);
                } else {
                    campaignUnit = com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(jSONObject2.optJSONObject(DataSchemeDataSource.SCHEME_DATA), this.f11413c);
                }
                if (campaignUnit == null || campaignUnit.getListFrames() == null || campaignUnit.getListFrames().size() <= 0) {
                    if (campaignUnit != null) {
                        str = campaignUnit.getMsg();
                    } else {
                        str = null;
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = jSONObject2.optString(NotificationCompat.CATEGORY_MESSAGE);
                    }
                    b(optInt2, str, this.f11414d);
                    return;
                }
                List<Frame> listFrames = campaignUnit.getListFrames();
                a(listFrames);
                saveRequestTime(listFrames.size());
                return;
            }
            a(list2, jSONObject2, optInt2, this.f11414d);
        }
    }

    public final void a(String str) {
        this.f11413c = str;
    }

    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar) {
        this.f11414d = cVar;
    }

    private void a(List<h> list, JSONObject jSONObject, int i5, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        b bVar;
        String str = "";
        if (list != null && list.size() > 0) {
            for (h next : list) {
                if (next != null) {
                    String a5 = next.a();
                    if (!TextUtils.isEmpty(a5) && a5.equals("data_res_type")) {
                        str = next.b();
                    }
                }
            }
        }
        String str2 = "errorCode: 3507 errorMessage: data load failed, errorMsg is " + jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
        if (TextUtils.isEmpty(str) || !str.equals("1")) {
            if (i5 == -1) {
                bVar = com.mbridge.msdk.foundation.c.a.b(880017, str2);
            } else {
                bVar = com.mbridge.msdk.foundation.c.a.b(880003, str2);
            }
            if (cVar != null) {
                cVar.a(bVar);
                cVar.b(false);
                if (TextUtils.isEmpty(str2)) {
                    str2 = bVar.b();
                }
            }
            b(i5, str2, cVar);
            return;
        }
        b b5 = com.mbridge.msdk.foundation.c.a.b(880018, str2);
        if (cVar != null) {
            cVar.a(b5);
            cVar.b(true);
            if (TextUtils.isEmpty(str2)) {
                str2 = b5.b();
            }
        }
        b(i5, str2, cVar);
    }
}
