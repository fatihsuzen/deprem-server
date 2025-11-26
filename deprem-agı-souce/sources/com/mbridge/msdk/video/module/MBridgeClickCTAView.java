package com.mbridge.msdk.video.module;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.dynview.e.h;
import com.mbridge.msdk.video.dynview.j.c;
import com.mbridge.msdk.video.module.a.a.e;
import com.mbridge.msdk.video.signal.factory.b;
import org.json.JSONException;
import org.json.JSONObject;

public class MBridgeClickCTAView extends MBridgeClickCTAViewDiff {
    public a ctaClickCallBack;

    /* renamed from: m  reason: collision with root package name */
    private ViewGroup f12305m;

    /* renamed from: n  reason: collision with root package name */
    private ImageView f12306n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f12307o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public TextView f12308p;

    /* renamed from: q  reason: collision with root package name */
    private String f12309q;

    /* renamed from: r  reason: collision with root package name */
    private float f12310r;

    /* renamed from: s  reason: collision with root package name */
    private float f12311s;

    /* renamed from: t  reason: collision with root package name */
    private int f12312t;

    /* renamed from: u  reason: collision with root package name */
    private ObjectAnimator f12313u;

    public interface a {
        void ctaClick();
    }

    public MBridgeClickCTAView(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    public boolean b() {
        this.f12305m = (ViewGroup) findViewById(findID("mbridge_viewgroup_ctaroot"));
        this.f12306n = (ImageView) findViewById(findID("mbridge_iv_appicon"));
        this.f12307o = (TextView) findViewById(findID("mbridge_tv_title"));
        TextView textView = (TextView) findViewById(findID("mbridge_tv_install"));
        this.ctaTv = textView;
        return isNotNULL(this.f12305m, this.f12306n, this.f12307o, textView);
    }

    public void init(Context context) {
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ObjectAnimator objectAnimator = this.f12313u;
        if (objectAnimator != null) {
            try {
                objectAnimator.start();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.f12313u;
        if (objectAnimator != null) {
            try {
                objectAnimator.cancel();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f12310r = motionEvent.getRawX();
        this.f12311s = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.f12312t = configuration.orientation;
    }

    public void preLoadData(b bVar) {
        CampaignEx campaignEx = this.f12294b;
        if (campaignEx != null) {
            if (campaignEx.isDynamicView()) {
                com.mbridge.msdk.video.dynview.b.a().a(new c().b((View) this, this.f12294b), new h() {
                    public final void viewInflaterFail(com.mbridge.msdk.video.dynview.c.a aVar) {
                        af.b(MBridgeBaseView.TAG, "errorMsg:" + aVar.b());
                    }

                    public final void viewInflaterSuccess(com.mbridge.msdk.video.dynview.a aVar) {
                        if (aVar != null) {
                            this.addView(aVar.a());
                            MBridgeClickCTAView mBridgeClickCTAView = MBridgeClickCTAView.this;
                            mBridgeClickCTAView.f12297e = mBridgeClickCTAView.b();
                            MBridgeClickCTAView mBridgeClickCTAView2 = MBridgeClickCTAView.this;
                            TextView unused = mBridgeClickCTAView2.f12308p = (TextView) mBridgeClickCTAView2.findViewById(mBridgeClickCTAView2.findID("mbridge_tv_desc"));
                            MBridgeClickCTAView.this.c();
                        }
                    }
                });
            } else {
                int findLayout = findLayout("mbridge_reward_clickable_cta");
                if (findLayout >= 0) {
                    this.f12295c.inflate(findLayout, this);
                    this.f12297e = b();
                    c();
                    setWrapContent();
                }
            }
            if (this.f12297e) {
                if (com.mbridge.msdk.e.b.a()) {
                    setChinaCTAData();
                }
                this.ctaTv.setText(this.f12294b.getAdCall());
                if (!TextUtils.isEmpty(this.f12294b.getIconUrl())) {
                    com.mbridge.msdk.foundation.same.c.b.a(this.f12293a.getApplicationContext()).a(this.f12294b.getIconUrl(), new e(this.f12306n, this.f12294b, this.f12309q) {
                        public final void onFailedLoad(String str, String str2) {
                            super.onFailedLoad(str, str2);
                            MBridgeClickCTAView.this.a();
                        }
                    });
                } else {
                    a();
                }
                if (this.f12307o != null && !TextUtils.isEmpty(this.f12294b.getAppName())) {
                    this.f12307o.setText(this.f12294b.getAppName());
                }
                if (this.f12308p != null && !TextUtils.isEmpty(this.f12294b.getAppDesc())) {
                    this.f12308p.setText(this.f12294b.getAppDesc());
                }
            }
        }
    }

    public void setCtaClickCallBack(a aVar) {
        this.ctaClickCallBack = aVar;
    }

    public void setObjectAnimator(ObjectAnimator objectAnimator) {
        this.f12313u = objectAnimator;
    }

    public void setUnitId(String str) {
        this.f12309q = str;
    }

    public MBridgeClickCTAView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public final void c() {
        super.c();
        if (this.f12297e) {
            CampaignEx campaignEx = this.f12294b;
            if (campaignEx != null && campaignEx.isDynamicView()) {
                setOnClickListener(new com.mbridge.msdk.widget.a() {
                    /* access modifiers changed from: protected */
                    public final void onNoDoubleClick(View view) {
                        MBridgeClickCTAView mBridgeClickCTAView = MBridgeClickCTAView.this;
                        a aVar = mBridgeClickCTAView.ctaClickCallBack;
                        if (aVar != null) {
                            aVar.ctaClick();
                        } else {
                            MBridgeClickCTAView.b(mBridgeClickCTAView);
                        }
                    }
                });
            }
            this.ctaTv.setOnClickListener(new com.mbridge.msdk.widget.a() {
                /* access modifiers changed from: protected */
                public final void onNoDoubleClick(View view) {
                    MBridgeClickCTAView mBridgeClickCTAView = MBridgeClickCTAView.this;
                    a aVar = mBridgeClickCTAView.ctaClickCallBack;
                    if (aVar != null) {
                        aVar.ctaClick();
                    } else {
                        MBridgeClickCTAView.b(mBridgeClickCTAView);
                    }
                }
            });
            ImageView imageView = this.f12306n;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        ImageView imageView = this.f12306n;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    static /* synthetic */ void b(MBridgeClickCTAView mBridgeClickCTAView) {
        JSONObject jSONObject;
        CampaignEx campaignEx = mBridgeClickCTAView.f12294b;
        if (campaignEx != null && campaignEx.isDynamicView()) {
            try {
                CampaignEx.c rewardTemplateMode = mBridgeClickCTAView.f12294b.getRewardTemplateMode();
                String str = "";
                if (rewardTemplateMode != null) {
                    str = rewardTemplateMode.f() + str;
                }
                i.a(com.mbridge.msdk.foundation.controller.c.m().c(), "cta_click", mBridgeClickCTAView.f12294b.getCampaignUnitId(), mBridgeClickCTAView.f12294b.isBidCampaign(), mBridgeClickCTAView.f12294b.getRequestId(), mBridgeClickCTAView.f12294b.getRequestIdNotice(), mBridgeClickCTAView.f12294b.getId(), str);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.mbridge.msdk.foundation.same.a.f9191j, mBridgeClickCTAView.a(0));
            } catch (JSONException e6) {
                e = e6;
                jSONObject2 = jSONObject;
            }
        } catch (JSONException e7) {
            e = e7;
            e.printStackTrace();
            jSONObject = jSONObject2;
            mBridgeClickCTAView.f12294b.setTriggerClickSource(1);
            mBridgeClickCTAView.f12294b.setClickTempSource(1);
            mBridgeClickCTAView.notifyListener.a(105, jSONObject);
        }
        mBridgeClickCTAView.f12294b.setTriggerClickSource(1);
        mBridgeClickCTAView.f12294b.setClickTempSource(1);
        mBridgeClickCTAView.notifyListener.a(105, jSONObject);
    }
}
