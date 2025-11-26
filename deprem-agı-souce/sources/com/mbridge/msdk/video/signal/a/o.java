package com.mbridge.msdk.video.signal.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.i;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.videocommon.d.b;
import com.mbridge.msdk.videocommon.d.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class o extends p {

    /* renamed from: a  reason: collision with root package name */
    private Activity f12675a;

    /* renamed from: b  reason: collision with root package name */
    private MBridgeContainerView f12676b;

    public o(Activity activity, MBridgeContainerView mBridgeContainerView) {
        this.f12675a = activity;
        this.f12676b = mBridgeContainerView;
    }

    public final String a() {
        c cVar;
        if (this.f12676b == null) {
            super.a();
        } else {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f12676b.getCampaign());
                String unitID = this.f12676b.getUnitID();
                if (b.a() == null) {
                    cVar = null;
                } else {
                    cVar = b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), unitID);
                }
                JSONObject jSONObject = new JSONObject();
                if (cVar != null) {
                    jSONObject = cVar.E();
                }
                af.a("JSRewardVideoV1", "getEndScreenInfo success campaign = " + this.f12676b.getCampaign());
                return a(arrayList, unitID, "MAL_16.8.61,3.0.1", jSONObject);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.a();
    }

    public final void b(String str) {
        super.b(str);
        try {
            if (this.f12675a != null && !TextUtils.isEmpty(str)) {
                if (str.equals("landscape")) {
                    this.f12675a.setRequestedOrientation(0);
                } else if (str.equals("portrait")) {
                    this.f12675a.setRequestedOrientation(1);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void c(String str) {
        MBridgeContainerView mBridgeContainerView;
        super.c(str);
        try {
            if (this.f12675a != null && !TextUtils.isEmpty(str) && (mBridgeContainerView = this.f12676b) != null) {
                mBridgeContainerView.handlerPlayableException(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void notifyCloseBtn(int i5) {
        super.notifyCloseBtn(i5);
        MBridgeContainerView mBridgeContainerView = this.f12676b;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.notifyCloseBtn(i5);
        }
    }

    public final void toggleCloseBtn(int i5) {
        super.toggleCloseBtn(i5);
        MBridgeContainerView mBridgeContainerView = this.f12676b;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.toggleCloseBtn(i5);
        }
    }

    public final void a(String str) {
        MBridgeContainerView mBridgeContainerView;
        super.a(str);
        try {
            if (this.f12675a != null && !TextUtils.isEmpty(str) && str.equals(CampaignEx.JSON_NATIVE_VIDEO_CLICK) && (mBridgeContainerView = this.f12676b) != null) {
                mBridgeContainerView.triggerCloseBtn(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private String a(List<CampaignEx> list, String str, String str2, JSONObject jSONObject) {
        if (list == null) {
            return null;
        }
        try {
            if (list.size() <= 0) {
                return null;
            }
            JSONArray parseCamplistToJson = CampaignEx.parseCamplistToJson(list);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("campaignList", parseCamplistToJson);
            jSONObject2.put("device", new i(com.mbridge.msdk.foundation.controller.c.m().c()).a());
            jSONObject2.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            jSONObject2.put("sdk_info", str2);
            jSONObject2.put("unitSetting", jSONObject);
            if (h.a() != null) {
                String g5 = h.a().g(com.mbridge.msdk.foundation.controller.c.m().k());
                if (!TextUtils.isEmpty(g5)) {
                    JSONObject jSONObject3 = new JSONObject(g5);
                    try {
                        Context c5 = com.mbridge.msdk.foundation.controller.c.m().c();
                        String obj = an.a(c5, "MBridge_ConfirmTitle" + str, "").toString();
                        String obj2 = an.a(c5, "MBridge_ConfirmContent" + str, "").toString();
                        String obj3 = an.a(c5, "MBridge_CancelText" + str, "").toString();
                        String obj4 = an.a(c5, "MBridge_ConfirmText" + str, "").toString();
                        if (!TextUtils.isEmpty(obj)) {
                            jSONObject3.put("confirm_title", obj);
                        }
                        if (!TextUtils.isEmpty(obj2)) {
                            jSONObject3.put("confirm_description", obj2);
                        }
                        if (!TextUtils.isEmpty(obj3)) {
                            jSONObject3.put("confirm_t", obj3);
                        }
                        if (!TextUtils.isEmpty(obj4)) {
                            jSONObject3.put("confirm_c_play", obj4);
                        }
                        if (!TextUtils.isEmpty(obj4)) {
                            jSONObject3.put("confirm_c_rv", obj4);
                        }
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    String c6 = h.a().c(str);
                    if (!TextUtils.isEmpty(c6)) {
                        jSONObject3.put("ivreward", new JSONObject(c6));
                    }
                    jSONObject2.put("appSetting", jSONObject3);
                }
            }
            return jSONObject2.toString();
        } catch (JSONException e6) {
            throw new RuntimeException(e6);
        } catch (Exception e7) {
            e7.printStackTrace();
            return null;
        }
    }
}
