package com.mbridge.msdk.video.dynview.moffer;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.video.dynview.e.g;
import com.mbridge.msdk.video.dynview.h.b;
import com.mbridge.msdk.video.module.MBridgeNativeEndCardView;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f12229a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, SoftReference<MOfferModel>> f12230b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private int f12231c = 500;

    private a() {
    }

    public static a a() {
        a aVar;
        if (f12229a != null) {
            return f12229a;
        }
        synchronized (a.class) {
            try {
                if (f12229a == null) {
                    f12229a = new a();
                }
                aVar = f12229a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public final void b() {
        MOfferModel mOfferModel;
        try {
            Map<String, SoftReference<MOfferModel>> map = this.f12230b;
            if (map != null) {
                for (SoftReference next : map.values()) {
                    if (!(next == null || (mOfferModel = (MOfferModel) next.get()) == null)) {
                        mOfferModel.mofDestroy();
                    }
                }
                this.f12230b.clear();
            }
        } catch (Exception e5) {
            af.b("MOfferEnergize", e5.getMessage());
        }
    }

    private int b(String str) {
        return x.a(c.m().c(), str, "id");
    }

    public final void a(final ViewGroup viewGroup, String str, com.mbridge.msdk.video.module.a.a aVar) {
        if (viewGroup != null && aVar != null && this.f12230b != null && !TextUtils.isEmpty(str) && this.f12230b.containsKey(str)) {
            SoftReference softReference = this.f12230b.get(str);
            final MOfferModel mOfferModel = (softReference == null || softReference.get() == null) ? null : (MOfferModel) softReference.get();
            if (mOfferModel != null) {
                mOfferModel.setMoreOfferListener(new g() {
                    public final void a(ViewGroup viewGroup, CampaignUnit campaignUnit) {
                        ViewGroup viewGroup2;
                        if (viewGroup != null && (viewGroup2 = viewGroup) != null) {
                            try {
                                a.a(a.this, mOfferModel, viewGroup2, viewGroup, campaignUnit);
                            } catch (Exception e5) {
                                af.b("MOfferEnergize", e5.getMessage());
                            }
                        }
                    }

                    public final void a(int i5, String str) {
                        af.b("MOfferEnergize", str);
                    }
                }, aVar);
                mOfferModel.showView();
            }
        }
    }

    public final void a(CampaignEx campaignEx, int i5) {
        if (campaignEx != null) {
            String str = campaignEx.getRequestId() + "_" + campaignEx.getId();
            if (this.f12230b == null) {
                this.f12230b = new ConcurrentHashMap();
            }
            if (!this.f12230b.containsKey(str)) {
                try {
                    MOfferModel mOfferModel = new MOfferModel();
                    mOfferModel.setFromType(i5);
                    SoftReference softReference = new SoftReference(mOfferModel);
                    if (softReference.get() != null) {
                        this.f12230b.put(str, softReference);
                        ((MOfferModel) softReference.get()).buildMofferAd(campaignEx);
                    }
                } catch (Exception e5) {
                    af.b("MOfferEnergize", e5.getMessage());
                }
            }
        }
    }

    public final void a(CampaignEx campaignEx, final ViewGroup viewGroup, com.mbridge.msdk.video.module.a.a aVar, int i5) {
        if (campaignEx != null) {
            String str = campaignEx.getRequestId() + "_" + campaignEx.getId();
            if (this.f12230b == null) {
                this.f12230b = new ConcurrentHashMap();
            }
            try {
                MOfferModel mOfferModel = new MOfferModel();
                mOfferModel.setFromType(i5);
                SoftReference softReference = new SoftReference(mOfferModel);
                if (softReference.get() != null) {
                    this.f12230b.put(str, softReference);
                    final MOfferModel mOfferModel2 = (MOfferModel) softReference.get();
                    mOfferModel2.setMoreOfferListener(new g() {
                        public final void a(int i5, String str) {
                        }

                        public final void a(ViewGroup viewGroup, CampaignUnit campaignUnit) {
                            if (viewGroup != null && campaignUnit != null) {
                                try {
                                    a.a(a.this, mOfferModel2, viewGroup, viewGroup, campaignUnit);
                                } catch (Exception e5) {
                                    af.b("MOfferEnergize", e5.getMessage());
                                }
                            }
                        }
                    }, aVar);
                    mOfferModel2.setIsRetry(true);
                    mOfferModel2.buildMofferAd(campaignEx);
                }
            } catch (Exception e5) {
                af.b("MOfferEnergize", e5.getMessage());
            }
        }
    }

    public final boolean a(String str) {
        if (this.f12230b == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f12230b.containsKey(str);
    }

    static /* synthetic */ void a(a aVar, MOfferModel mOfferModel, ViewGroup viewGroup, ViewGroup viewGroup2, CampaignUnit campaignUnit) {
        RelativeLayout relativeLayout;
        int i5;
        RelativeLayout relativeLayout2;
        TextView textView;
        ImageView imageView;
        ImageView imageView2;
        a aVar2 = aVar;
        final MOfferModel mOfferModel2 = mOfferModel;
        ViewGroup viewGroup3 = viewGroup;
        ViewGroup viewGroup4 = viewGroup2;
        CampaignUnit campaignUnit2 = campaignUnit;
        if (mOfferModel2 != null && viewGroup3 != null && viewGroup4 != null && campaignUnit2 != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup4.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            }
            RelativeLayout.LayoutParams layoutParams2 = layoutParams;
            layoutParams2.addRule(12, -1);
            int a5 = ak.a(c.m().c(), 5.0f);
            layoutParams2.setMargins(a5, a5, a5, a5);
            if (viewGroup4.getBackground() == null) {
                try {
                    Drawable drawable = c.m().c().getResources().getDrawable(x.a(c.m().c(), "mbridge_reward_more_offer_default_bg", "drawable"));
                    if (drawable != null) {
                        View findViewById = viewGroup4.findViewById(aVar2.b("mbridge_moreoffer_hls"));
                        if (findViewById != null) {
                            findViewById.setBackground(drawable);
                        }
                    }
                } catch (Exception e5) {
                    af.b("MOfferEnergize", e5.getMessage());
                }
            }
            viewGroup4.setLayoutParams(layoutParams2);
            ViewGroup viewGroup5 = (ViewGroup) viewGroup4.getParent();
            if (viewGroup5 != null) {
                viewGroup5.removeAllViews();
            }
            if (mOfferModel2.getECParentTemplateCode() == 1302) {
                try {
                    if (mOfferModel2.getmMainOfferCampaignEx() == null || mOfferModel2.getmMainOfferCampaignEx().getRewardTemplateMode() == null) {
                        i5 = 1;
                    } else {
                        i5 = mOfferModel2.getmMainOfferCampaignEx().getRewardTemplateMode().b();
                        if (i5 == 0) {
                            i5 = ab.s(c.m().c());
                        }
                    }
                    if (i5 != 1 && (viewGroup3 instanceof MBridgeNativeEndCardView)) {
                        if (((MBridgeNativeEndCardView) viewGroup3).isDyXmlSuccess()) {
                            imageView2 = (ImageView) viewGroup3.findViewById(-1803557032);
                        } else {
                            imageView2 = (ImageView) viewGroup3.findViewById(aVar2.b("mbridge_iv_adbanner"));
                        }
                        int g5 = ak.g(c.m().c()) - ak.a(c.m().c(), 220.0f);
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
                        layoutParams3.height = g5;
                        layoutParams3.width = (g5 * 16) / 9;
                        imageView2.setLayoutParams(layoutParams3);
                    }
                    if (viewGroup3 instanceof MBridgeNativeEndCardView) {
                        if (((MBridgeNativeEndCardView) viewGroup3).isDyXmlSuccess()) {
                            relativeLayout2 = (RelativeLayout) viewGroup3.findViewById(-1642631508);
                            imageView = (ImageView) viewGroup3.findViewById(389008949);
                            textView = (TextView) viewGroup3.findViewById(1561614848);
                        } else {
                            relativeLayout2 = (RelativeLayout) viewGroup3.findViewById(aVar2.b("mbridge_native_ec_layout"));
                            imageView = (ImageView) viewGroup3.findViewById(aVar2.b("mbridge_iv_flag"));
                            textView = (TextView) viewGroup3.findViewById(aVar2.b("mbridge_tv_flag"));
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(imageView);
                        arrayList.add(textView);
                        new b().a(arrayList, 0, ak.a(c.m().c(), 100.0f), (long) aVar2.f12231c);
                    } else {
                        relativeLayout2 = null;
                    }
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) viewGroup4.getLayoutParams();
                    layoutParams4.setMargins(0, 0, 0, 0);
                    viewGroup4.setLayoutParams(layoutParams4);
                    if (relativeLayout2 != null) {
                        relativeLayout2.addView(viewGroup4);
                    }
                } catch (Exception e6) {
                    if (MBridgeConstans.DEBUG) {
                        e6.printStackTrace();
                    }
                }
            } else {
                try {
                    if (viewGroup3 instanceof MBridgeNativeEndCardView) {
                        if (((MBridgeNativeEndCardView) viewGroup3).isDyXmlSuccess()) {
                            relativeLayout = (RelativeLayout) viewGroup3.findViewById(-1642631508);
                        } else {
                            relativeLayout = (RelativeLayout) viewGroup3.findViewById(aVar2.b("mbridge_native_ec_layout"));
                        }
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(relativeLayout);
                        new b().a(arrayList2, 0, ak.a(c.m().c(), 100.0f), (long) aVar2.f12231c);
                    }
                    RelativeLayout relativeLayout3 = (RelativeLayout) viewGroup3.findViewById(aVar2.b("mbridge_reward_moreoffer_layout"));
                    if (relativeLayout3 == null) {
                        relativeLayout3 = (RelativeLayout) viewGroup3.findViewById(-82036151);
                    }
                    if (relativeLayout3 == null) {
                        viewGroup.addView(viewGroup2);
                    } else if (viewGroup3.isShown()) {
                        relativeLayout3.setVisibility(0);
                        relativeLayout3.addView(viewGroup4);
                    }
                } catch (Exception e7) {
                    af.b("MOfferEnergize", e7.getMessage());
                }
            }
            new b().a(viewGroup4, 0, ak.f(c.m().c()), 0, ak.a(c.m().c(), 100.0f), 0);
            if (viewGroup3 instanceof MBridgeNativeEndCardView) {
                ((MBridgeNativeEndCardView) viewGroup3).setMoreOfferCampaignUnit(campaignUnit2);
            }
            viewGroup3.postDelayed(new Runnable() {
                public final void run() {
                    MOfferModel mOfferModel = mOfferModel2;
                    if (mOfferModel != null) {
                        mOfferModel.checkViewVisiableState();
                    }
                }
            }, (long) (aVar2.f12231c + 500));
        }
    }
}
