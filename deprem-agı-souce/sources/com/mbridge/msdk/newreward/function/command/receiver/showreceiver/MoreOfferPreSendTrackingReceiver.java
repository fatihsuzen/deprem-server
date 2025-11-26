package com.mbridge.msdk.newreward.function.command.receiver.showreceiver;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mbridge.apt_anotation.ReceiverAction;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.d;
import com.mbridge.msdk.newreward.function.command.receiver.b;
import com.mbridge.msdk.newreward.player.model.MoreOfferModel;
import com.mbridge.msdk.newreward.player.redirect.MoreOfferRedirectModel;
import java.util.List;
import org.json.JSONObject;

@ReceiverAction(id = "MoreOfferPreSendTrackingReceiver", type = b.class)
public class MoreOfferPreSendTrackingReceiver implements b {

    /* renamed from: a  reason: collision with root package name */
    private e f10828a;

    /* renamed from: b  reason: collision with root package name */
    private CampaignEx f10829b;

    /* renamed from: c  reason: collision with root package name */
    private List<CampaignEx> f10830c;

    /* renamed from: d  reason: collision with root package name */
    private int f10831d;

    /* renamed from: e  reason: collision with root package name */
    private int f10832e;

    /* renamed from: f  reason: collision with root package name */
    private c f10833f;

    /* renamed from: g  reason: collision with root package name */
    private MoreOfferModel f10834g;

    /* renamed from: h  reason: collision with root package name */
    private MoreOfferRedirectModel f10835h;

    /* renamed from: i  reason: collision with root package name */
    private List<Integer> f10836i;

    public final void a(Object obj) {
        e eVar = (e) obj;
        this.f10828a = eVar;
        if (eVar != null) {
            this.f10829b = eVar.U();
            try {
                JSONObject jSONObject = new JSONObject(this.f10829b.getMoreOfferJsonData()).getJSONObject(CampaignEx.ENDCARD_URL);
                if (jSONObject != null) {
                    if (jSONObject.has(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM)) {
                        this.f10831d = jSONObject.getInt(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM);
                    }
                    if (jSONObject.has(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF)) {
                        this.f10832e = jSONObject.getInt(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF);
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
            try {
                c b5 = d.a().b();
                this.f10833f = b5;
                this.f10834g = new MoreOfferModel(b5);
                if (this.f10828a.E() != null) {
                    this.f10836i = this.f10828a.E().f10954a;
                }
                MoreOfferRedirectModel moreOfferRedirectModel = new MoreOfferRedirectModel();
                this.f10835h = moreOfferRedirectModel;
                moreOfferRedirectModel.setContext(com.mbridge.msdk.foundation.controller.c.m().c());
                this.f10835h.setSettingModel(this.f10828a.x());
                if (!(this.f10828a.E() == null || this.f10828a.E().b() == null)) {
                    this.f10830c = this.f10828a.E().b().E();
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        MoreOfferPreSendTrackingReceiver.this.a();
                    }
                });
            } catch (Exception e6) {
                if (MBridgeConstans.DEBUG) {
                    e6.printStackTrace();
                }
            }
        }
    }

    public final void a() {
        if (this.f10831d == 1) {
            try {
                int min = Math.min(this.f10832e, this.f10830c.size());
                for (int i5 = 0; i5 < min; i5++) {
                    this.f10835h.setItemPositionId(i5);
                    if (!this.f10836i.contains(Integer.valueOf(i5))) {
                        this.f10836i.add(Integer.valueOf(i5));
                        if (!(this.f10828a == null || this.f10835h == null)) {
                            String str = "117361";
                            try {
                                CampaignEx campaignEx = this.f10830c.get(i5);
                                String str2 = "";
                                if (campaignEx != null) {
                                    this.f10835h.setCampaignEx(campaignEx);
                                    str2 = aq.a(campaignEx.getendcard_url(), "mof_testuid");
                                    if (TextUtils.isEmpty(str2)) {
                                        str2 = aq.a(campaignEx.getendcard_url(), "mof_uid");
                                    }
                                }
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                this.f10835h.setUnitId(str);
                            } catch (Exception e5) {
                                if (MBridgeConstans.DEBUG) {
                                    e5.printStackTrace();
                                }
                            }
                        }
                        if (i5 == 0) {
                            this.f10834g.eventOnlyImpression(this.f10835h);
                        }
                        this.f10834g.eventImpression(this.f10835h);
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }
}
