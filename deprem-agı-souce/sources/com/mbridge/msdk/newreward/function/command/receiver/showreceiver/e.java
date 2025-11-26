package com.mbridge.msdk.newreward.function.command.receiver.showreceiver;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.function.command.b;
import com.mbridge.msdk.newreward.function.command.receiver.a;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.util.List;
import java.util.Map;

public final class e implements a {

    /* renamed from: a  reason: collision with root package name */
    List<CampaignEx> f10850a;

    /* renamed from: b  reason: collision with root package name */
    CampaignEx f10851b;

    /* renamed from: c  reason: collision with root package name */
    String f10852c;

    public final void a(b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        Map map = (Map) bVar.b();
        this.f10850a = ((com.mbridge.msdk.newreward.function.c.a.b) map.get("more_offer_campaign")).E();
        CampaignEx campaignEx = (CampaignEx) map.get("campaign");
        this.f10851b = campaignEx;
        if (campaignEx != null) {
            this.f10852c = aq.a(campaignEx.getendcard_url(), "mof_textmod");
        }
        List<CampaignEx> list = this.f10850a;
        if (list == null || list.isEmpty()) {
            bVar2.reqFailed(new com.mbridge.msdk.foundation.c.b(-1, ""));
            return;
        }
        List<CampaignEx> list2 = this.f10850a;
        LinearLayout linearLayout = new LinearLayout(c.m().c());
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        for (CampaignEx next : list2) {
            View view = null;
            View inflate = LayoutInflater.from(c.m().c()).inflate(x.a(c.m().c(), "mbridge_reward_end_card_more_offer_item", TtmlNode.TAG_LAYOUT), (ViewGroup) null, false);
            int a5 = x.a(c.m().c(), "mbridge_reward_end_card_item_iv", "id");
            if (inflate != null) {
                RoundImageView roundImageView = (RoundImageView) inflate.findViewById(a5);
                if (roundImageView != null) {
                    roundImageView.setImageDrawable((Drawable) null);
                }
                TextView textView = (TextView) inflate.findViewById(x.a(c.m().c(), "mbridge_reward_end_card_item_title_tv", "id"));
                if (!TextUtils.isEmpty(next.getAppName())) {
                    if (TextUtils.isEmpty(this.f10852c) || !this.f10852c.equals("1")) {
                        textView.setVisibility(8);
                    } else {
                        textView.setText(next.getAppName());
                    }
                }
                view = inflate;
            }
            if (view != null) {
                linearLayout.addView(view);
            }
        }
        bVar2.reqSuccessful(linearLayout);
    }
}
