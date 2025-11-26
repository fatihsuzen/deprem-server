package com.mbridge.msdk.click;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.click.a.a;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.e.b;

public final class d extends e {

    /* renamed from: a  reason: collision with root package name */
    JumpLoaderResult f8106a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f8107b = 0;

    /* renamed from: c  reason: collision with root package name */
    private String f8108c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f8109d;

    /* renamed from: e  reason: collision with root package name */
    private f f8110e = null;

    /* renamed from: f  reason: collision with root package name */
    private boolean f8111f = true;

    /* renamed from: g  reason: collision with root package name */
    private b f8112g;

    /* renamed from: h  reason: collision with root package name */
    private n f8113h;

    /* renamed from: i  reason: collision with root package name */
    private Handler f8114i = new Handler(Looper.getMainLooper());

    public d(Context context) {
        this.f8112g = new b(context);
        this.f8113h = new n(context);
    }

    public final void a(String str, CampaignEx campaignEx, f fVar, String str2, boolean z4, boolean z5, int i5) {
        String str3;
        this.f8108c = str2;
        this.f8110e = fVar;
        this.f8106a = null;
        int i6 = i5;
        this.f8109d = i6;
        boolean z6 = false;
        if (campaignEx != null) {
            if (CampaignEx.CLICKMODE_ON.equals(campaignEx.getClick_mode()) || "6".equals(campaignEx.getClick_mode())) {
                z6 = true;
            }
            str3 = campaignEx.getId();
        } else {
            str3 = "";
        }
        String str4 = str3;
        String str5 = str2;
        this.f8113h.a(str5, fVar, z6, str4, str, campaignEx, z4, z5, i6);
    }

    public final void a(String str, CampaignEx campaignEx, f fVar) {
        this.f8108c = new String(campaignEx.getClickURL());
        this.f8110e = fVar;
        this.f8106a = null;
        this.f8113h.a(campaignEx.getClickURL(), fVar, CampaignEx.CLICKMODE_ON.equals(campaignEx.getClick_mode()) || "6".equals(campaignEx.getClick_mode()), campaignEx.getId(), str, campaignEx, true, false, a.f8072j);
    }

    public final void a() {
        this.f8111f = false;
    }
}
