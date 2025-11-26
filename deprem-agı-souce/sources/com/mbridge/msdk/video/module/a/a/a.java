package com.mbridge.msdk.video.module.a.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.click.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;

public class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private Activity f12568a;

    /* renamed from: b  reason: collision with root package name */
    private CampaignEx f12569b;

    public a(Activity activity, CampaignEx campaignEx) {
        this.f12568a = activity;
        this.f12569b = campaignEx;
    }

    public void a(int i5, Object obj) {
        super.a(i5, obj);
        if (i5 == 106 && this.f12568a != null && this.f12569b != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                String a5 = c.a(this.f12569b.getClickURL(), "-999", "-999");
                if (!TextUtils.isEmpty(a5)) {
                    intent.setData(Uri.parse(a5));
                    this.f12568a.startActivity(intent);
                }
            } catch (Throwable th) {
                af.b("NotifyListener", th.getMessage(), th);
            }
            this.f12568a.finish();
        }
    }
}
