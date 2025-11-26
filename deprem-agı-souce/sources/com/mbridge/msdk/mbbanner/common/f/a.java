package com.mbridge.msdk.mbbanner.common.f;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.b;
import com.mbridge.msdk.foundation.same.net.c;
import com.mbridge.msdk.foundation.same.net.d;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.tracker.network.h;
import java.util.List;
import org.json.JSONObject;

public abstract class a extends c<JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10052a = "a";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f10053b = "";

    public abstract void a(int i5, String str);

    public abstract void a(CampaignUnit campaignUnit);

    public void onError(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        String str = f10052a;
        af.c(str, "onFailed errorCode = " + aVar.f9304a);
        a(aVar.f9304a, com.mbridge.msdk.foundation.same.net.e.a.a(aVar));
    }

    public void onSuccess(d<JSONObject> dVar) {
        super.onSuccess(dVar);
        List<h> list = dVar.f9310b.f9313b;
        final JSONObject jSONObject = (JSONObject) dVar.f9311c;
        String str = f10052a;
        af.c(str, "parseLoad content = " + jSONObject);
        final int optInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        if (1 == optInt) {
            calcRequestTime(System.currentTimeMillis());
            final String optString = jSONObject.optString("version");
            com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() {
                public final void run() {
                    final CampaignUnit campaignUnit;
                    if ("v5".equals(optString)) {
                        campaignUnit = b.parseV5CampaignUnit(jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA), a.this.f10053b);
                    } else {
                        campaignUnit = b.parseCampaignUnit(jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA), a.this.f10053b);
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
                                a.this.a(optInt, str);
                                return;
                            }
                            a.this.a(campaignUnit);
                            if (!TextUtils.isEmpty(a.this.f10053b)) {
                                a.this.saveHbState(1);
                            }
                            a.this.saveRequestTime(campaignUnit.getAds().size());
                        }
                    });
                }
            });
            return;
        }
        a(optInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
    }

    public final void a(String str) {
        this.f10053b = str;
    }
}
