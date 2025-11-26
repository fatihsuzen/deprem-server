package com.mbridge.msdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.d.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.net.e.d;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.out.Campaign;

public class MBAdChoice extends MBImageView {

    /* renamed from: a  reason: collision with root package name */
    private final Context f13202a;

    /* renamed from: b  reason: collision with root package name */
    private String f13203b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f13204c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f13205d = "";

    /* renamed from: e  reason: collision with root package name */
    private CampaignEx f13206e;

    /* renamed from: f  reason: collision with root package name */
    private a f13207f;

    public MBAdChoice(Context context) {
        super(context);
        this.f13202a = context;
        a();
    }

    private void a() {
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        setClickable(true);
    }

    public boolean performClick() {
        if (this.f13207f == null) {
            this.f13207f = new a() {
                public final void close() {
                }

                public final void showed() {
                }

                public final void summit(String str) {
                }
            };
        }
        ak.a(this.f13206e, this.f13207f, 4, "");
        return true;
    }

    public void setCampaign(Campaign campaign) {
        boolean z4;
        if (campaign instanceof CampaignEx) {
            CampaignEx campaignEx = (CampaignEx) campaign;
            this.f13206e = campaignEx;
            g b5 = h.a().b(c.m().k());
            this.f13206e = campaignEx;
            if (campaignEx != null) {
                String privacyUrl = campaignEx.getPrivacyUrl();
                this.f13204c = privacyUrl;
                if (TextUtils.isEmpty(privacyUrl)) {
                    CampaignEx.a adchoice = campaignEx.getAdchoice();
                    if (adchoice != null) {
                        this.f13204c = adchoice.c();
                    }
                    if (TextUtils.isEmpty(this.f13204c) && b5 != null) {
                        this.f13204c = b5.j();
                    }
                    if (TextUtils.isEmpty(this.f13204c)) {
                        this.f13204c = d.f().f9371f;
                    }
                }
            } else if (b5 != null) {
                this.f13204c = b5.j();
            }
            this.f13206e = campaignEx;
            if (campaignEx != null) {
                CampaignEx.a adchoice2 = campaignEx.getAdchoice();
                if (adchoice2 != null) {
                    this.f13203b = adchoice2.b();
                }
                if (TextUtils.isEmpty(this.f13203b) && b5 != null) {
                    this.f13203b = b5.i();
                }
            } else if (b5 != null) {
                this.f13203b = b5.i();
            }
            this.f13206e = campaignEx;
            if (campaignEx != null) {
                CampaignEx.a adchoice3 = campaignEx.getAdchoice();
                if (adchoice3 != null) {
                    this.f13205d = adchoice3.d();
                }
                if (TextUtils.isEmpty(this.f13205d) && b5 != null) {
                    this.f13205d = b5.k();
                }
            } else if (b5 != null) {
                this.f13205d = b5.k();
            }
            if (TextUtils.isEmpty(this.f13203b) || TextUtils.isEmpty(this.f13204c) || TextUtils.isEmpty(this.f13205d)) {
                z4 = false;
            } else {
                z4 = true;
            }
            setImageUrl(this.f13203b);
            if (z4 && this.f13202a != null) {
                b.a(c.m().c()).a(this.f13203b, new com.mbridge.msdk.foundation.same.c.c() {
                    public final void onFailedLoad(String str, String str2) {
                    }

                    public final void onSuccessLoad(Bitmap bitmap, String str) {
                        MBAdChoice.this.setImageBitmap(bitmap);
                    }
                });
                return;
            }
            return;
        }
        this.f13206e = null;
    }

    public void setFeedbackDialogEventListener(a aVar) {
        this.f13207f = aVar;
    }

    public MBAdChoice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13202a = context;
        a();
    }

    public MBAdChoice(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f13202a = context;
        a();
    }
}
