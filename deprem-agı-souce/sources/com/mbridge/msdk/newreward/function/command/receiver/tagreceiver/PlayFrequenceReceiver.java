package com.mbridge.msdk.newreward.function.command.receiver.tagreceiver;

import android.text.TextUtils;
import com.mbridge.apt_anotation.ReceiverAction;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.receiver.b;

@ReceiverAction(id = "PlayFrequenceReceiver", type = b.class)
public class PlayFrequenceReceiver implements b {

    /* renamed from: a  reason: collision with root package name */
    e f10876a;

    /* renamed from: b  reason: collision with root package name */
    CampaignEx f10877b;

    public final void a(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            this.f10876a = eVar;
            this.f10877b = eVar.U();
        }
        if (this.f10876a != null) {
            if (this.f10877b != null) {
                new Thread(new Runnable() {
                    public final void run() {
                        try {
                            if (PlayFrequenceReceiver.this.f10877b != null) {
                                j.a((f) g.a(c.m().c())).a(PlayFrequenceReceiver.this.f10877b.getId());
                            }
                        } catch (Throwable th) {
                            if (MBridgeConstans.DEBUG) {
                                th.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
            CampaignEx campaignEx = this.f10877b;
            if (campaignEx != null) {
                try {
                    if (com.mbridge.msdk.foundation.same.a.b.f9220j != null && !TextUtils.isEmpty(campaignEx.getId())) {
                        com.mbridge.msdk.foundation.same.a.b.a(this.f10877b.getCampaignUnitId(), this.f10877b, "reward");
                    }
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        e5.printStackTrace();
                    }
                }
            }
        }
    }
}
