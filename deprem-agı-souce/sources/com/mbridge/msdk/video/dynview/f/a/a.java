package com.mbridge.msdk.video.dynview.f.a;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.b;
import com.mbridge.msdk.foundation.same.net.c;
import com.mbridge.msdk.foundation.same.net.d;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.tracker.network.h;
import java.util.List;
import org.json.JSONObject;

public abstract class a extends c<JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    private int f12087a;

    /* renamed from: b  reason: collision with root package name */
    private String f12088b;

    public abstract void a(int i5, String str);

    public abstract void a(List<h> list, CampaignUnit campaignUnit);

    public void onError(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        a(aVar.f9304a, com.mbridge.msdk.foundation.same.net.e.a.a(aVar));
    }

    public void onPreExecute() {
        super.onPreExecute();
    }

    public void onSuccess(d<JSONObject> dVar) {
        com.mbridge.msdk.foundation.same.net.d.a aVar;
        CampaignUnit campaignUnit;
        String str;
        super.onSuccess(dVar);
        if (dVar != null && (aVar = dVar.f9310b) != null && this.f12087a == 0) {
            List<h> list = aVar.f9313b;
            JSONObject jSONObject = (JSONObject) dVar.f9311c;
            int optInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
            if (1 == optInt) {
                calcRequestTime(System.currentTimeMillis());
                if ("v5".equals(jSONObject.optString("version"))) {
                    campaignUnit = b.parseV5CampaignUnit(jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA), this.f12088b);
                } else {
                    campaignUnit = b.parseCampaignUnit(jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA), this.f12088b);
                }
                if (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0) {
                    if (campaignUnit != null) {
                        str = campaignUnit.getMsg();
                    } else {
                        str = null;
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                    }
                    a(optInt, str);
                    return;
                }
                a(list, campaignUnit);
                saveRequestTime(campaignUnit.getAds().size());
                return;
            }
            a(optInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
        }
    }
}
