package com.mbridge.msdk.video.dynview.ordercamp.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import b.w;
import com.mbridge.msdk.dycreator.baseview.MBFrameLayout;
import com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeImageView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeTextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.video.dynview.h.b;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.util.List;
import java.util.Locale;

public final class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private boolean f12240a = false;

    /* renamed from: b  reason: collision with root package name */
    private C0111a f12241b;

    /* renamed from: c  reason: collision with root package name */
    private List<CampaignEx> f12242c;

    /* renamed from: com.mbridge.msdk.video.dynview.ordercamp.a.a$a  reason: collision with other inner class name */
    static class C0111a {

        /* renamed from: a  reason: collision with root package name */
        RelativeLayout f12246a;

        /* renamed from: b  reason: collision with root package name */
        MBRotationView f12247b;

        /* renamed from: c  reason: collision with root package name */
        MBridgeImageView f12248c;

        /* renamed from: d  reason: collision with root package name */
        RoundImageView f12249d;

        /* renamed from: e  reason: collision with root package name */
        TextView f12250e;

        /* renamed from: f  reason: collision with root package name */
        TextView f12251f;

        /* renamed from: g  reason: collision with root package name */
        TextView f12252g;

        /* renamed from: h  reason: collision with root package name */
        TextView f12253h;

        /* renamed from: i  reason: collision with root package name */
        MBridgeLevelLayoutView f12254i;

        /* renamed from: j  reason: collision with root package name */
        ImageView f12255j;

        /* renamed from: k  reason: collision with root package name */
        ImageView f12256k;

        /* renamed from: l  reason: collision with root package name */
        MBCusRoundImageView f12257l;

        /* renamed from: m  reason: collision with root package name */
        MBCusRoundImageView f12258m;

        /* renamed from: n  reason: collision with root package name */
        MBStarLevelLayoutView f12259n;

        /* renamed from: o  reason: collision with root package name */
        MBHeatLevelLayoutView f12260o;

        /* renamed from: p  reason: collision with root package name */
        MBFrameLayout f12261p;

        C0111a() {
        }
    }

    public a(List<CampaignEx> list) {
        this.f12242c = list;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003f A[Catch:{ Exception -> 0x0034 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044 A[Catch:{ Exception -> 0x0034 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View a(int r7) {
        /*
            r6 = this;
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r6.f12242c     // Catch:{ Exception -> 0x0034 }
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0037
            java.lang.Object r0 = r0.get(r7)     // Catch:{ Exception -> 0x0034 }
            if (r0 == 0) goto L_0x0037
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0034 }
            r0.<init>()     // Catch:{ Exception -> 0x0034 }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r6.f12242c     // Catch:{ Exception -> 0x0034 }
            java.lang.Object r2 = r2.get(r7)     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2     // Catch:{ Exception -> 0x0034 }
            int r2 = r2.getMof_tplid()     // Catch:{ Exception -> 0x0034 }
            r0.append(r2)     // Catch:{ Exception -> 0x0034 }
            r0.append(r1)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0034 }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r6.f12242c     // Catch:{ Exception -> 0x0034 }
            java.lang.Object r1 = r1.get(r7)     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = (com.mbridge.msdk.foundation.entity.CampaignEx) r1     // Catch:{ Exception -> 0x0034 }
            java.lang.String r1 = r1.getCMPTEntryUrl()     // Catch:{ Exception -> 0x0034 }
            goto L_0x0039
        L_0x0034:
            r7 = move-exception
            goto L_0x016d
        L_0x0037:
            java.lang.String r0 = "501"
        L_0x0039:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0034 }
            if (r2 == 0) goto L_0x0044
            android.view.View r7 = r6.a()     // Catch:{ Exception -> 0x0034 }
            return r7
        L_0x0044:
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0034 }
            android.content.Context r2 = r2.c()     // Catch:{ Exception -> 0x0034 }
            int r2 = com.mbridge.msdk.foundation.tools.ab.s(r2)     // Catch:{ Exception -> 0x0034 }
            r3 = 0
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.o.a(r3, r0, r1)     // Catch:{ Exception -> 0x0034 }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0034 }
            if (r3 == 0) goto L_0x0060
            android.view.View r7 = r6.a()     // Catch:{ Exception -> 0x0034 }
            return r7
        L_0x0060:
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0034 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0034 }
            r4.<init>()     // Catch:{ Exception -> 0x0034 }
            r4.append(r1)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r5 = java.io.File.separator     // Catch:{ Exception -> 0x0034 }
            r4.append(r5)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r5 = "template_config.json"
            r4.append(r5)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0034 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0034 }
            boolean r4 = r3.isFile()     // Catch:{ Exception -> 0x0034 }
            if (r4 == 0) goto L_0x0168
            boolean r3 = r3.exists()     // Catch:{ Exception -> 0x0034 }
            if (r3 != 0) goto L_0x0089
            goto L_0x0168
        L_0x0089:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0034 }
            r3.<init>()     // Catch:{ Exception -> 0x0034 }
            java.lang.String r4 = "template_"
            r3.append(r4)     // Catch:{ Exception -> 0x0034 }
            r3.append(r0)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r0 = "_"
            r3.append(r0)     // Catch:{ Exception -> 0x0034 }
            r3.append(r2)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r0 = "_item"
            r3.append(r0)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0034 }
            java.util.List r0 = com.mbridge.msdk.foundation.tools.ad.a((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x0034 }
            if (r0 != 0) goto L_0x00b2
            android.view.View r7 = r6.a()     // Catch:{ Exception -> 0x0034 }
            return r7
        L_0x00b2:
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0034 }
            android.content.Context r1 = r1.c()     // Catch:{ Exception -> 0x0034 }
            int r1 = com.mbridge.msdk.foundation.tools.ab.s(r1)     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0034 }
            java.lang.String r2 = r2.k()     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.c.h r3 = com.mbridge.msdk.c.h.a()     // Catch:{ Exception -> 0x0034 }
            r3.b(r2)     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.dycreator.wrapper.DyOption$Builder r2 = new com.mbridge.msdk.dycreator.wrapper.DyOption$Builder     // Catch:{ Exception -> 0x0034 }
            r2.<init>()     // Catch:{ Exception -> 0x0034 }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r6.f12242c     // Catch:{ Exception -> 0x0034 }
            java.lang.Object r3 = r3.get(r7)     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.dycreator.wrapper.DyOption$IViewOptionBuilder r2 = r2.campaignEx(r3)     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.dycreator.wrapper.DyOption$IViewOptionBuilder r0 = r2.fileDirs(r0)     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.dycreator.wrapper.DyAdType r2 = com.mbridge.msdk.dycreator.wrapper.DyAdType.REWARD     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.dycreator.wrapper.DyOption$IViewOptionBuilder r0 = r0.dyAdType(r2)     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.dycreator.wrapper.DyOption$IViewOptionBuilder r0 = r0.orientation(r1)     // Catch:{ Exception -> 0x0034 }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r6.f12242c     // Catch:{ Exception -> 0x0034 }
            java.lang.Object r7 = r1.get(r7)     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = (com.mbridge.msdk.foundation.entity.CampaignEx) r7     // Catch:{ Exception -> 0x0034 }
            java.lang.String r7 = com.mbridge.msdk.foundation.tools.ak.a((com.mbridge.msdk.foundation.entity.CampaignEx) r7)     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.dycreator.wrapper.DyOption$IViewOptionBuilder r7 = r0.adChoiceLink(r7)     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.dycreator.wrapper.DyOption r7 = r7.build()     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator r0 = com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator.getInstance()     // Catch:{ Exception -> 0x0034 }
            android.view.View r7 = r0.createDynamicView(r7)     // Catch:{ Exception -> 0x0034 }
            if (r7 == 0) goto L_0x0177
            r0 = 1
            r6.f12240a = r0     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.video.dynview.ordercamp.a.a$a r0 = new com.mbridge.msdk.video.dynview.ordercamp.a.a$a     // Catch:{ Exception -> 0x0034 }
            r0.<init>()     // Catch:{ Exception -> 0x0034 }
            r6.f12241b = r0     // Catch:{ Exception -> 0x0034 }
            java.lang.String r1 = "mbridge_lv_iv"
            int r1 = r6.c(r1)     // Catch:{ Exception -> 0x0034 }
            android.view.View r1 = r7.findViewById(r1)     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView r1 = (com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView) r1     // Catch:{ Exception -> 0x0034 }
            r0.f12257l = r1     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.video.dynview.ordercamp.a.a$a r0 = r6.f12241b     // Catch:{ Exception -> 0x0034 }
            java.lang.String r1 = "mbridge_lv_iv_burl"
            int r1 = r6.c(r1)     // Catch:{ Exception -> 0x0034 }
            android.view.View r1 = r7.findViewById(r1)     // Catch:{ Exception -> 0x0034 }
            android.widget.ImageView r1 = (android.widget.ImageView) r1     // Catch:{ Exception -> 0x0034 }
            r0.f12256k = r1     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.video.dynview.ordercamp.a.a$a r0 = r6.f12241b     // Catch:{ Exception -> 0x0034 }
            java.lang.String r1 = "mbridge_lv_icon_iv"
            int r1 = r6.c(r1)     // Catch:{ Exception -> 0x0034 }
            android.view.View r1 = r7.findViewById(r1)     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView r1 = (com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView) r1     // Catch:{ Exception -> 0x0034 }
            r0.f12258m = r1     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.video.dynview.ordercamp.a.a$a r0 = r6.f12241b     // Catch:{ Exception -> 0x0034 }
            java.lang.String r1 = "mbridge_lv_sv_starlevel"
            int r1 = r6.c(r1)     // Catch:{ Exception -> 0x0034 }
            android.view.View r1 = r7.findViewById(r1)     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView r1 = (com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView) r1     // Catch:{ Exception -> 0x0034 }
            r0.f12259n = r1     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.video.dynview.ordercamp.a.a$a r0 = r6.f12241b     // Catch:{ Exception -> 0x0034 }
            java.lang.String r1 = "mbridge_lv_ration"
            int r1 = r6.c(r1)     // Catch:{ Exception -> 0x0034 }
            android.view.View r1 = r7.findViewById(r1)     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.dycreator.baseview.MBFrameLayout r1 = (com.mbridge.msdk.dycreator.baseview.MBFrameLayout) r1     // Catch:{ Exception -> 0x0034 }
            r0.f12261p = r1     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.video.dynview.ordercamp.a.a$a r0 = r6.f12241b     // Catch:{ Exception -> 0x0034 }
            r7.setTag(r0)     // Catch:{ Exception -> 0x0034 }
            goto L_0x0177
        L_0x0168:
            android.view.View r7 = r6.a()     // Catch:{ Exception -> 0x0034 }
            return r7
        L_0x016d:
            java.lang.String r0 = "OrderCampAdapter"
            java.lang.String r7 = r7.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r7)
            r7 = 0
        L_0x0177:
            boolean r0 = r6.f12240a
            if (r0 == 0) goto L_0x017c
            goto L_0x0180
        L_0x017c:
            android.view.View r7 = r6.a()
        L_0x0180:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.ordercamp.a.a.a(int):android.view.View");
    }

    private int b(String str) {
        return x.a(c.m().c().getApplicationContext(), str, "id");
    }

    private int c(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.hashCode();
        }
        return -1;
    }

    private int d(String str) {
        if (this.f12240a) {
            return c(str);
        }
        return b(str);
    }

    public final int getCount() {
        List<CampaignEx> list = this.f12242c;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.f12242c.size();
    }

    public final Object getItem(int i5) {
        List<CampaignEx> list = this.f12242c;
        if (list != null) {
            return list.get(i5);
        }
        return null;
    }

    public final long getItemId(int i5) {
        return (long) i5;
    }

    public final View getView(int i5, View view, ViewGroup viewGroup) {
        View view2;
        int i6 = i5;
        if (view == null) {
            try {
                view2 = a(i5);
            } catch (Exception e5) {
                e = e5;
                view2 = view;
                af.b("OrderCampAdapter", e.getMessage());
                return view2;
            }
        } else {
            this.f12241b = (C0111a) view.getTag();
            view2 = view;
        }
        try {
            this.f12241b.f12246a = (RelativeLayout) view2.findViewById(d("mbridge_lv_item_rl"));
            this.f12241b.f12250e = (TextView) view2.findViewById(d("mbridge_lv_title_tv"));
            this.f12241b.f12252g = (TextView) view2.findViewById(d("mbridge_lv_tv_install"));
            this.f12241b.f12260o = (MBHeatLevelLayoutView) view2.findViewById(d("mbridge_lv_sv_heat_level"));
            this.f12241b.f12251f = (TextView) view2.findViewById(d("mbridge_lv_desc_tv"));
            this.f12241b.f12255j = (ImageView) view2.findViewById(d("mbridge_iv_flag"));
            this.f12241b.f12253h = (TextView) view2.findViewById(d("mbridge_order_viewed_tv"));
            double d5 = 5.0d;
            if (this.f12240a) {
                List<CampaignEx> list = this.f12242c;
                if (list != null) {
                    if (this.f12241b != null) {
                        if (list.size() != 0) {
                            MBCusRoundImageView mBCusRoundImageView = this.f12241b.f12257l;
                            if (mBCusRoundImageView != null && w.a(mBCusRoundImageView)) {
                                this.f12241b.f12257l.setCustomBorder(30, 30, 30, 30, 10, -1728053248);
                                a(this.f12241b.f12257l, this.f12242c.get(i6).getImageUrl(), false);
                            }
                            ImageView imageView = this.f12241b.f12256k;
                            if (imageView != null) {
                                a(imageView, this.f12242c.get(i6).getImageUrl(), false);
                            }
                            MBCusRoundImageView mBCusRoundImageView2 = this.f12241b.f12258m;
                            if (mBCusRoundImageView2 != null && w.a(mBCusRoundImageView2)) {
                                this.f12241b.f12258m.setBorder(50, 20, -1);
                                a(this.f12241b.f12258m, this.f12242c.get(i6).getIconUrl(), true);
                            }
                            double rating = this.f12242c.get(i6).getRating();
                            if (rating > 0.0d) {
                                d5 = rating;
                            }
                            MBStarLevelLayoutView mBStarLevelLayoutView = this.f12241b.f12259n;
                            if (mBStarLevelLayoutView != null) {
                                mBStarLevelLayoutView.setRating((int) d5);
                                this.f12241b.f12259n.setOrientation(0);
                            }
                            MBHeatLevelLayoutView mBHeatLevelLayoutView = this.f12241b.f12260o;
                            if (mBHeatLevelLayoutView != null) {
                                mBHeatLevelLayoutView.setHeatCount(this.f12242c.get(i6).getNumberRating());
                            }
                        }
                    }
                }
            } else {
                List<CampaignEx> list2 = this.f12242c;
                if (list2 != null) {
                    if (this.f12241b != null) {
                        if (list2.size() != 0) {
                            MBridgeImageView mBridgeImageView = this.f12241b.f12248c;
                            if (mBridgeImageView != null) {
                                a(mBridgeImageView, this.f12242c.get(i6).getImageUrl(), false);
                            }
                            ImageView imageView2 = this.f12241b.f12256k;
                            if (imageView2 != null) {
                                a(imageView2, this.f12242c.get(i6).getImageUrl(), false);
                            }
                            RoundImageView roundImageView = this.f12241b.f12249d;
                            if (roundImageView != null) {
                                roundImageView.setBorderRadius(25);
                                a(this.f12241b.f12249d, this.f12242c.get(i6).getIconUrl(), true);
                            }
                            double rating2 = this.f12242c.get(i6).getRating();
                            if (rating2 > 0.0d) {
                                d5 = rating2;
                            }
                            MBridgeLevelLayoutView mBridgeLevelLayoutView = this.f12241b.f12254i;
                            if (mBridgeLevelLayoutView != null) {
                                mBridgeLevelLayoutView.setRatingAndUser(d5, this.f12242c.get(i6).getNumberRating());
                                this.f12241b.f12254i.setOrientation(0);
                            }
                            MBRotationView mBRotationView = this.f12241b.f12247b;
                            if (mBRotationView != null) {
                                mBRotationView.setWidthRatio(1.0f);
                                this.f12241b.f12247b.setHeightRatio(1.0f);
                                this.f12241b.f12247b.setAutoscroll(false);
                            }
                            MBridgeImageView mBridgeImageView2 = this.f12241b.f12248c;
                            if (mBridgeImageView2 != null) {
                                mBridgeImageView2.setCustomBorder(30, 30, 30, 30, 10, -1728053248);
                            }
                        }
                    }
                }
            }
            C0111a aVar = this.f12241b;
            if (aVar != null) {
                if (aVar.f12250e != null) {
                    this.f12241b.f12250e.setText(this.f12242c.get(i6).getAppName());
                }
                if (this.f12241b.f12251f != null) {
                    this.f12241b.f12251f.setText(this.f12242c.get(i6).getAppDesc());
                }
                if (this.f12241b.f12252g != null) {
                    String adCall = this.f12242c.get(i6).getAdCall();
                    if (this.f12241b.f12252g instanceof MBridgeTextView) {
                        ((MBridgeTextView) this.f12241b.f12252g).setObjectAnimator(new b().c(this.f12241b.f12252g));
                    }
                    this.f12241b.f12252g.setText(adCall);
                }
                if (this.f12241b.f12255j != null) {
                    try {
                        String language = Locale.getDefault().getLanguage();
                        Context c5 = c.m().c();
                        if (c5 != null) {
                            if (!TextUtils.isEmpty(language)) {
                                if (language.equals("zh")) {
                                    this.f12241b.f12255j.setImageDrawable(c5.getResources().getDrawable(c5.getResources().getIdentifier("mbridge_reward_flag_cn", "drawable", c.m().g())));
                                }
                            }
                            this.f12241b.f12255j.setImageDrawable(c5.getResources().getDrawable(c5.getResources().getIdentifier("mbridge_reward_flag_en", "drawable", c.m().g())));
                        }
                    } catch (Exception e6) {
                        af.b("OrderCampAdapter", e6.getMessage());
                    }
                    ak.a(2, this.f12241b.f12255j, this.f12242c.get(i6), c.m().c(), false, (com.mbridge.msdk.foundation.d.a) null);
                }
                if (this.f12241b.f12253h != null) {
                    try {
                        this.f12241b.f12253h.setText(c.m().c().getResources().getString(c.m().c().getResources().getIdentifier("mbridge_reward_viewed_text_str", TypedValues.Custom.S_STRING, c.m().g())));
                        this.f12241b.f12253h.setVisibility(0);
                    } catch (Exception e7) {
                        af.b("OrderCampAdapter", e7.getMessage());
                    }
                }
            }
        } catch (Exception e8) {
            e = e8;
        }
        return view2;
    }

    private View a() {
        View inflate = LayoutInflater.from(c.m().c()).inflate(a("mbridge_order_layout_item"), (ViewGroup) null);
        C0111a aVar = new C0111a();
        this.f12241b = aVar;
        aVar.f12248c = (MBridgeImageView) inflate.findViewById(b("mbridge_lv_iv"));
        this.f12241b.f12256k = (ImageView) inflate.findViewById(b("mbridge_lv_iv_burl"));
        this.f12241b.f12249d = (RoundImageView) inflate.findViewById(b("mbridge_lv_icon_iv"));
        this.f12241b.f12254i = (MBridgeLevelLayoutView) inflate.findViewById(b("mbridge_lv_sv_starlevel"));
        this.f12241b.f12247b = (MBRotationView) inflate.findViewById(b("mbridge_lv_ration"));
        inflate.setTag(this.f12241b);
        return inflate;
    }

    private void a(final ImageView imageView, String str, final boolean z4) {
        if (imageView != null) {
            if (!TextUtils.isEmpty(str)) {
                com.mbridge.msdk.foundation.same.c.b.a(imageView.getContext()).a(str, new com.mbridge.msdk.foundation.same.c.c() {
                    public final void onFailedLoad(String str, String str2) {
                        if (z4) {
                            imageView.setVisibility(8);
                        }
                    }

                    public final void onSuccessLoad(Bitmap bitmap, String str) {
                        try {
                            if (!bitmap.isRecycled()) {
                                imageView.setImageBitmap(bitmap);
                            }
                        } catch (Throwable th) {
                            af.b("OrderCampAdapter", th.getMessage());
                        }
                    }
                });
            } else if (z4) {
                imageView.setVisibility(8);
            }
        }
    }

    private int a(String str) {
        return x.a(c.m().c().getApplicationContext(), str, TtmlNode.TAG_LAYOUT);
    }
}
