package com.mbridge.msdk.video.module.a.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.d;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.same.f.a;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;

public class e implements c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public CampaignEx f12573a;

    /* renamed from: b  reason: collision with root package name */
    protected ImageView f12574b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f12575c;

    public e(ImageView imageView) {
        this.f12574b = imageView;
    }

    public void onFailedLoad(final String str, String str2) {
        AnonymousClass1 r32 = new Runnable() {
            public final void run() {
                try {
                    o a5 = o.a((f) g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                    if (e.this.f12573a == null) {
                        af.a("ImageLoaderListener", "campaign is null");
                        return;
                    }
                    n nVar = new n();
                    nVar.a("2000044");
                    nVar.a(ab.m(com.mbridge.msdk.foundation.controller.c.m().c()));
                    nVar.e(e.this.f12573a.getId());
                    nVar.p(e.this.f12573a.getImageUrl());
                    nVar.f(e.this.f12573a.getRequestId());
                    nVar.g(e.this.f12573a.getRequestIdNotice());
                    nVar.c(e.this.f12575c);
                    nVar.h(str);
                    a5.a(nVar);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        };
        d.a();
        a.b().execute(r32);
        af.b("ImageLoaderListener", "desc:" + str);
    }

    public void onSuccessLoad(Bitmap bitmap, String str) {
        if (bitmap == null) {
            try {
                af.b("ImageLoaderListener", "bitmap=null");
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        } else if (this.f12574b != null && !bitmap.isRecycled()) {
            this.f12574b.setImageBitmap(bitmap);
            this.f12574b.setVisibility(0);
        }
    }

    public e(ImageView imageView, CampaignEx campaignEx, String str) {
        this.f12574b = imageView;
        this.f12573a = campaignEx;
        this.f12575c = str;
    }
}
