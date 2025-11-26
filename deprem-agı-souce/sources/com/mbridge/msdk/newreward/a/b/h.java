package com.mbridge.msdk.newreward.a.b;

import android.content.Context;
import android.graphics.Bitmap;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.c.c;
import java.io.IOException;
import java.util.List;

public final class h implements a {

    private static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.c.a.a f10377a;

        /* renamed from: b  reason: collision with root package name */
        private final b f10378b;

        public a(com.mbridge.msdk.newreward.function.c.a.a aVar, b bVar) {
            this.f10377a = aVar;
            this.f10378b = bVar;
        }

        public final void onFailedLoad(String str, String str2) {
            if (this.f10378b != null && this.f10377a.i().y()) {
                this.f10378b.reqSuccessful(this.f10377a);
            }
        }

        public final void onSuccessLoad(Bitmap bitmap, String str) {
            if (this.f10378b != null && this.f10377a.i().y()) {
                this.f10378b.reqSuccessful(this.f10377a);
            }
        }
    }

    public final void a(Object obj, b bVar) throws IOException {
        List<CampaignEx.c.a> a5;
        com.mbridge.msdk.newreward.function.c.a.a aVar = (com.mbridge.msdk.newreward.function.c.a.a) obj;
        CampaignEx h5 = aVar.h();
        String imageUrl = h5.getImageUrl();
        Context c5 = com.mbridge.msdk.foundation.controller.c.m().c();
        b.a(c5).a(imageUrl, new a(aVar, bVar));
        b.a(c5).a(h5.getIconUrl(), new a(aVar, bVar));
        CampaignEx.c rewardTemplateMode = h5.getRewardTemplateMode();
        if (rewardTemplateMode != null && (a5 = rewardTemplateMode.a()) != null) {
            for (CampaignEx.c.a aVar2 : a5) {
                List<String> list = aVar2.f9019a;
                if (list != null) {
                    for (String a6 : list) {
                        b.a(c5).a(a6, new a(aVar, bVar));
                    }
                }
            }
        }
    }
}
