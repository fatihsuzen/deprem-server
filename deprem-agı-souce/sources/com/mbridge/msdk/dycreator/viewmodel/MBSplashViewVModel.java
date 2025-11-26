package com.mbridge.msdk.dycreator.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.dycreator.binding.b;
import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bridge.MBSplashData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.g.c;
import com.mbridge.msdk.dycreator.g.d;
import com.mbridge.msdk.dycreator.g.f;
import com.mbridge.msdk.dycreator.g.h;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.x;

public class MBSplashViewVModel implements BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private d f8712a;

    /* renamed from: b  reason: collision with root package name */
    private c f8713b;

    /* renamed from: c  reason: collision with root package name */
    private f f8714c;

    /* renamed from: d  reason: collision with root package name */
    private h f8715d;

    /* renamed from: e  reason: collision with root package name */
    private DynamicViewBackListener f8716e;

    /* renamed from: f  reason: collision with root package name */
    private DyOption f8717f;

    /* renamed from: com.mbridge.msdk.dycreator.viewmodel.MBSplashViewVModel$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8718a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.mbridge.msdk.dycreator.listener.action.EAction[] r0 = com.mbridge.msdk.dycreator.listener.action.EAction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8718a = r0
                com.mbridge.msdk.dycreator.listener.action.EAction r1 = com.mbridge.msdk.dycreator.listener.action.EAction.DOWNLOAD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8718a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.dycreator.listener.action.EAction r1 = com.mbridge.msdk.dycreator.listener.action.EAction.CLOSE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.viewmodel.MBSplashViewVModel.AnonymousClass1.<clinit>():void");
        }
    }

    public MBSplashViewVModel(DyOption dyOption) {
        String str;
        this.f8717f = dyOption;
        if (dyOption == null || dyOption.getCampaignEx() == null) {
            str = "";
        } else {
            str = dyOption.getCampaignEx().getCampaignUnitId();
        }
        if (!TextUtils.isEmpty(str)) {
            EventBus.getDefault().register(str, (Object) this);
        } else {
            EventBus.getDefault().register(this);
        }
    }

    public void onEventMainThread(SplashResData splashResData) {
        if (this.f8716e != null && splashResData != null) {
            int i5 = AnonymousClass1.f8718a[splashResData.geteAction().ordinal()];
            if (i5 == 1 || i5 == 2) {
                String str = "";
                try {
                    if (!(splashResData.getBaseViewData() == null || splashResData.getBaseViewData().getBindData() == null)) {
                        str = splashResData.getBaseViewData().getBindData().getCampaignUnitId();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        EventBus.getDefault().unregister(str);
                        b.a().b();
                    } else {
                        EventBus.getDefault().unregister((Object) this);
                        b.a().b();
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                    EventBus.getDefault().unregister((Object) this);
                    EventBus.getDefault().release();
                    b.a().b();
                }
            }
            this.f8716e.viewClicked(splashResData);
        }
    }

    public void setClickSubject(c cVar) {
        if (cVar != null) {
            this.f8713b = cVar;
        }
    }

    public void setConcreteSubject(d dVar) {
        if (dVar != null) {
            this.f8712a = dVar;
        }
    }

    public void setDynamicViewBackListener(DynamicViewBackListener dynamicViewBackListener) {
        if (dynamicViewBackListener != null) {
            this.f8716e = dynamicViewBackListener;
        }
    }

    public void setEffectSubject(f fVar) {
        if (fVar != null) {
            this.f8714c = fVar;
        }
    }

    public void setModelDataAndBind() {
        String str;
        String str2;
        MBSplashData mBSplashData = new MBSplashData(this.f8717f);
        Context c5 = com.mbridge.msdk.foundation.controller.c.m().c();
        if (c5 != null) {
            DyOption dyOption = this.f8717f;
            if (dyOption != null) {
                CampaignEx campaignEx = dyOption.getCampaignEx();
                if (campaignEx != null) {
                    mBSplashData.setAdClickText(campaignEx.getAdCall());
                }
                if (this.f8717f.isCanSkip()) {
                    str2 = "mbridge_splash_count_time_can_skip";
                } else {
                    str2 = "mbridge_splash_count_time_can_skip_not";
                }
                mBSplashData.setCountDownText(c5.getResources().getString(x.a(c5, str2, TypedValues.Custom.S_STRING)));
            }
            mBSplashData.setNoticeImage(x.a(c5, "mbridge_splash_notice", "drawable"));
            String t5 = ab.t(c5);
            if (TextUtils.isEmpty(t5) || !t5.contains("zh")) {
                str = "AD";
            } else {
                str = "广告";
            }
            mBSplashData.setLogoText(str);
        }
        d dVar = this.f8712a;
        if (dVar != null) {
            dVar.a(mBSplashData);
        }
        c cVar = this.f8713b;
        if (cVar != null) {
            cVar.a(mBSplashData);
        }
        f fVar = this.f8714c;
        if (fVar != null) {
            fVar.a(mBSplashData);
        }
    }

    public void setReportSubject(h hVar) {
        if (hVar != null) {
            this.f8715d = hVar;
        }
    }
}
