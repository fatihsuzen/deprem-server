package com.mbridge.msdk.video.dynview.j;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.p;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.e.d;
import com.mbridge.msdk.video.dynview.e.e;
import com.mbridge.msdk.video.dynview.g.a;
import com.mbridge.msdk.video.dynview.i.c.b;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a {

    /* renamed from: j  reason: collision with root package name */
    private static boolean f12139j = false;

    /* renamed from: a  reason: collision with root package name */
    public com.mbridge.msdk.video.dynview.d.a f12140a = new com.mbridge.msdk.video.dynview.d.a() {
        public final void a() {
            if (a.this.f12150l && a.this.f12141b != null) {
                a.this.f12141b.a((long) (a.this.f12151m * 1000), a.this.f12149k);
                boolean unused = a.this.f12150l = false;
            }
        }

        public final void b() {
            if (a.this.f12141b != null) {
                a.this.f12141b.b();
                boolean unused = a.this.f12150l = true;
            }
        }

        public final void c() {
            if (a.this.f12141b != null) {
                a.this.f12141b.b();
                boolean unused = a.this.f12150l = true;
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b f12141b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Bitmap> f12142c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f12143d;

    /* renamed from: e  reason: collision with root package name */
    private String f12144e = "#FFFFFFFF";

    /* renamed from: f  reason: collision with root package name */
    private String f12145f = "#60000000";
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f12146g = "#FF5F5F5F";

    /* renamed from: h  reason: collision with root package name */
    private String f12147h = "#90ECECEC";
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public volatile long f12148i = 0;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public com.mbridge.msdk.video.dynview.i.c.a f12149k = null;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public boolean f12150l = false;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public int f12151m = 0;

    public final void c(c cVar, View view, final Map map, e eVar) {
        try {
            if (this.f12142c == null) {
                this.f12142c = new HashMap();
            }
            final List<CampaignEx> g5 = cVar.g();
            if (view.getContext() == null) {
                eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_CONTEXT);
                return;
            }
            if (map != null && map.containsKey("is_dy_success")) {
                f12139j = ((Boolean) map.get("is_dy_success")).booleanValue();
            }
            for (CampaignEx next : g5) {
                if (next != null) {
                    next.setECTemplateRenderSucc(f12139j);
                }
            }
            ListView listView = (ListView) view.findViewById(a(f12139j, "mbridge_order_view_lv"));
            GridView gridView = (GridView) view.findViewById(a(f12139j, "mbridge_order_view_h_lv"));
            ImageView imageView = (ImageView) view.findViewById(a(f12139j, "mbridge_order_view_iv_close"));
            com.mbridge.msdk.video.dynview.ordercamp.a.a aVar = new com.mbridge.msdk.video.dynview.ordercamp.a.a(g5);
            if (cVar.e() == 1) {
                if (listView != null) {
                    try {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) listView.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.height = -1;
                            int a5 = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 10.0f);
                            int c5 = (int) ((cVar.c() - ((float) ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 720.0f))) / 2.0f);
                            layoutParams.setMargins(a5, c5, a5, c5);
                            listView.setLayoutParams(layoutParams);
                        }
                    } catch (Exception e5) {
                        af.b("DataEnergizeWrapper", e5.getMessage());
                    }
                    listView.setAdapter(aVar);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public final void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
                            a.a(a.this, map, g5, i5);
                        }
                    });
                }
            } else if (gridView != null) {
                int d5 = (int) cVar.d();
                int size = d5 / g5.size();
                int i5 = size / 9;
                int i6 = i5 / 2;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gridView.getLayoutParams();
                layoutParams2.width = d5 - (i5 * 2);
                gridView.setLayoutParams(layoutParams2);
                gridView.setColumnWidth((size - i5) - (i6 / 2));
                gridView.setHorizontalSpacing(i6);
                gridView.setStretchMode(0);
                gridView.setNumColumns(g5.size());
                gridView.setAdapter(aVar);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
                        a.a(a.this, map, g5, i5);
                    }
                });
            }
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        a.a(a.this, map);
                    }
                });
            }
            if (eVar != null) {
                eVar.a(view, (List<View>) null);
            }
        } catch (Exception unused) {
            if (eVar != null) {
                eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
            }
        }
    }

    public final void b(c cVar, View view, Map map, e eVar) {
        View view2 = view;
        Map map2 = map;
        e eVar2 = eVar;
        if (eVar2 != null) {
            if (cVar == null) {
                eVar2.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
                return;
            }
            if (map2 != null && map2.containsKey("is_dy_success")) {
                f12139j = ((Boolean) map2.get("is_dy_success")).booleanValue();
            }
            boolean z4 = f12139j;
            LinearLayout linearLayout = z4 ? (LinearLayout) view2.findViewById(a(z4, "mbridge_reward_heat_mllv")) : null;
            ImageView imageView = (ImageView) view2.findViewById(a(f12139j, "mbridge_reward_icon_riv"));
            TextView textView = (TextView) view2.findViewById(a(f12139j, "mbridge_reward_title_tv"));
            LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(a(f12139j, "mbridge_reward_stars_mllv"));
            TextView textView2 = (TextView) view2.findViewById(a(f12139j, "mbridge_reward_click_tv"));
            ImageView imageView2 = (ImageView) view2.findViewById(a(f12139j, "mbridge_videoview_bg"));
            TextView textView3 = (TextView) view2.findViewById(a(f12139j, "mbridge_reward_desc_tv"));
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(a(f12139j, "mbridge_reward_bottom_layout"));
            ArrayList arrayList = new ArrayList();
            List<CampaignEx> g5 = cVar.g();
            if (g5 == null || g5.size() <= 0) {
                eVar2.a(com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL);
                return;
            }
            CampaignEx campaignEx = g5.get(0);
            if (campaignEx != null) {
                if (imageView != null) {
                    if (!f12139j) {
                        ((RoundImageView) imageView).setBorderRadius(10);
                    } else if (imageView instanceof MBCusRoundImageView) {
                        ((MBCusRoundImageView) imageView).setCustomBorder(30, 30, 30, 30, 10, -1);
                    }
                    a(campaignEx.getIconUrl(), imageView);
                }
                if (textView != null) {
                    textView.setText(campaignEx.getAppName());
                }
                if (textView3 != null) {
                    textView3.setText(campaignEx.getAppDesc());
                }
                if (linearLayout2 != null) {
                    double rating = campaignEx.getRating();
                    if (rating <= 0.0d) {
                        rating = 5.0d;
                    }
                    if (f12139j) {
                        if (linearLayout2 instanceof MBStarLevelLayoutView) {
                            MBStarLevelLayoutView mBStarLevelLayoutView = (MBStarLevelLayoutView) linearLayout2;
                            mBStarLevelLayoutView.setRating((int) rating);
                            mBStarLevelLayoutView.setOrientation(0);
                        }
                        if (linearLayout instanceof MBHeatLevelLayoutView) {
                            ((MBHeatLevelLayoutView) linearLayout).setHeatCount(campaignEx.getNumberRating());
                        }
                    } else {
                        ((MBridgeLevelLayoutView) linearLayout2).setRatingAndUser(rating, campaignEx.getNumberRating());
                    }
                }
                if (textView2 != null) {
                    textView2.setText(campaignEx.getAdCall());
                }
                int i5 = cVar.i();
                if (i5 == 102 || i5 == 202 || i5 == 302) {
                    if (textView2 != null) {
                        arrayList.add(textView2);
                    }
                } else if (i5 == 802) {
                    if (imageView != null) {
                        arrayList.add(imageView);
                    }
                    if (textView2 != null) {
                        arrayList.add(textView2);
                    }
                    a(imageView2, campaignEx.getImageUrl(), i5);
                } else if (i5 != 902) {
                    if (i5 != 904) {
                        if (i5 == 5002010) {
                            if (!cVar.k() || relativeLayout == null || relativeLayout.getVisibility() != 0) {
                                if (imageView != null) {
                                    arrayList.add(imageView);
                                }
                                if (textView2 != null) {
                                    arrayList.add(textView2);
                                }
                            } else {
                                arrayList.add(relativeLayout);
                            }
                        }
                    } else if (cVar.k()) {
                        arrayList.add(view2);
                    }
                } else if (TextUtils.isEmpty(cVar.o()) || !cVar.o().equals("dsp") || !TextUtils.isEmpty(campaignEx.getClickURL())) {
                    arrayList.add(view2);
                }
                eVar2.a(view2, arrayList);
                return;
            }
            eVar2.a(com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x03e9  */
    /* JADX WARNING: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02e6  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x03b6  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x03ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.mbridge.msdk.video.dynview.c r36, android.view.View r37, java.util.Map r38, com.mbridge.msdk.video.dynview.e.e r39) {
        /*
            r35 = this;
            r1 = r35
            r6 = r36
            r7 = r37
            r5 = r38
            r8 = r39
            java.util.Map<java.lang.String, android.graphics.Bitmap> r0 = r1.f12142c
            if (r0 != 0) goto L_0x0015
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1.f12142c = r0
        L_0x0015:
            java.util.List r0 = r6.g()
            if (r7 != 0) goto L_0x0021
            com.mbridge.msdk.video.dynview.c.a r0 = com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_ROOTVIEW
            r8.a(r0)
            return
        L_0x0021:
            android.content.Context r9 = r7.getContext()
            if (r9 != 0) goto L_0x002d
            com.mbridge.msdk.video.dynview.c.a r0 = com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_CONTEXT
            r8.a(r0)
            return
        L_0x002d:
            r10 = 1
            r2 = 0
            if (r0 == 0) goto L_0x004f
            int r3 = r0.size()
            if (r3 <= r10) goto L_0x004f
            java.lang.Object r3 = r0.get(r2)
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3
            int r4 = com.mbridge.msdk.foundation.same.report.d.a.f9444a
            r3.setShowIndex(r4)
            java.lang.Object r4 = r0.get(r10)
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = (com.mbridge.msdk.foundation.entity.CampaignEx) r4
            int r12 = com.mbridge.msdk.foundation.same.report.d.a.f9445b
            r4.setShowIndex(r12)
            r15 = r3
            goto L_0x0051
        L_0x004f:
            r4 = 0
            r15 = 0
        L_0x0051:
            if (r15 != 0) goto L_0x005b
            if (r8 == 0) goto L_0x005b
            com.mbridge.msdk.video.dynview.c.a r0 = com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL
            r8.a(r0)
            return
        L_0x005b:
            if (r4 != 0) goto L_0x0065
            if (r8 == 0) goto L_0x0065
            com.mbridge.msdk.video.dynview.c.a r0 = com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL
            r8.a(r0)
            return
        L_0x0065:
            java.lang.String r3 = "is_dy_success"
            if (r5 == 0) goto L_0x007b
            boolean r12 = r5.containsKey(r3)
            if (r12 == 0) goto L_0x007b
            java.lang.Object r12 = r5.get(r3)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            f12139j = r12
        L_0x007b:
            boolean r12 = f12139j
            java.lang.String r13 = "mbridge_top_item_rl"
            int r12 = r1.a((boolean) r12, (java.lang.String) r13)
            android.view.View r12 = r7.findViewById(r12)
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            boolean r13 = f12139j
            java.lang.String r14 = "mbridge_top_iv"
            int r13 = r1.a((boolean) r13, (java.lang.String) r14)
            android.view.View r13 = r7.findViewById(r13)
            r16 = r13
            com.mbridge.msdk.dycreator.baseview.cusview.MBridgeImageView r16 = (com.mbridge.msdk.dycreator.baseview.cusview.MBridgeImageView) r16
            boolean r13 = f12139j
            java.lang.String r14 = "mbridge_top_ration"
            int r13 = r1.a((boolean) r13, (java.lang.String) r14)
            android.view.View r13 = r7.findViewById(r13)
            com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView r13 = (com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView) r13
            boolean r14 = f12139j
            java.lang.String r11 = "mbridge_top_title_tv"
            int r11 = r1.a((boolean) r14, (java.lang.String) r11)
            android.view.View r11 = r7.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            boolean r14 = f12139j
            java.lang.String r2 = "mbridge_bottom_item_rl"
            int r2 = r1.a((boolean) r14, (java.lang.String) r2)
            android.view.View r2 = r7.findViewById(r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            boolean r14 = f12139j
            java.lang.String r10 = "mbridge_bottom_ration"
            int r10 = r1.a((boolean) r14, (java.lang.String) r10)
            android.view.View r10 = r7.findViewById(r10)
            com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView r10 = (com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView) r10
            boolean r14 = f12139j
            r23 = r4
            java.lang.String r4 = "mbridge_bottom_iv"
            int r4 = r1.a((boolean) r14, (java.lang.String) r4)
            android.view.View r4 = r7.findViewById(r4)
            r24 = r4
            com.mbridge.msdk.dycreator.baseview.cusview.MBridgeImageView r24 = (com.mbridge.msdk.dycreator.baseview.cusview.MBridgeImageView) r24
            boolean r4 = f12139j
            java.lang.String r14 = "mbridge_bottom_icon_iv"
            java.lang.String r8 = "mbridge_top_icon_iv"
            if (r4 == 0) goto L_0x010a
            int r4 = r1.a((boolean) r4, (java.lang.String) r8)
            android.view.View r4 = r7.findViewById(r4)
            com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView r4 = (com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView) r4
            boolean r8 = f12139j
            int r8 = r1.a((boolean) r8, (java.lang.String) r14)
            android.view.View r8 = r7.findViewById(r8)
            com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView r8 = (com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView) r8
            r31 = r9
            r14 = 0
            r9 = r8
            r8 = r4
            r4 = 0
        L_0x0107:
            r32 = r15
            goto L_0x0126
        L_0x010a:
            int r4 = r1.a((boolean) r4, (java.lang.String) r8)
            android.view.View r4 = r7.findViewById(r4)
            com.mbridge.msdk.videocommon.view.RoundImageView r4 = (com.mbridge.msdk.videocommon.view.RoundImageView) r4
            boolean r8 = f12139j
            int r8 = r1.a((boolean) r8, (java.lang.String) r14)
            android.view.View r8 = r7.findViewById(r8)
            com.mbridge.msdk.videocommon.view.RoundImageView r8 = (com.mbridge.msdk.videocommon.view.RoundImageView) r8
            r14 = r8
            r31 = r9
            r8 = 0
            r9 = 0
            goto L_0x0107
        L_0x0126:
            boolean r15 = f12139j
            r33 = r3
            java.lang.String r3 = "mbridge_bottom_title_tv"
            int r3 = r1.a((boolean) r15, (java.lang.String) r3)
            android.view.View r3 = r7.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            boolean r15 = f12139j
            r34 = r3
            java.lang.String r3 = "mbridge_reward_choice_one_like_iv"
            int r3 = r1.a((boolean) r15, (java.lang.String) r3)
            android.view.View r3 = r7.findViewById(r3)
            r15 = r3
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            if (r12 == 0) goto L_0x0151
            com.mbridge.msdk.video.dynview.j.a$4 r3 = new com.mbridge.msdk.video.dynview.j.a$4
            r3.<init>(r5, r0)
            r12.setOnClickListener(r3)
        L_0x0151:
            if (r16 == 0) goto L_0x01e0
            r21 = 10
            r22 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r17 = 20
            r18 = 20
            r19 = 0
            r20 = 0
            r16.setCustomBorder(r17, r18, r19, r20, r21, r22)
            r12 = r16
            java.lang.String r3 = r32.getImageUrl()
            r1.a((java.lang.String) r3, (android.widget.ImageView) r12, (com.mbridge.msdk.video.dynview.c) r6, (android.view.View) r7)
            if (r13 == 0) goto L_0x01e0
            boolean r3 = r32.getCanStart2C1Anim()
            if (r3 == 0) goto L_0x01cf
            java.lang.String r3 = r32.getIconUrl()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x01be
            android.widget.ImageView r3 = new android.widget.ImageView
            android.content.Context r12 = r6.a()
            r3.<init>(r12)
            android.widget.FrameLayout$LayoutParams r12 = new android.widget.FrameLayout$LayoutParams
            r18 = r15
            android.content.Context r15 = r6.a()
            r19 = r9
            r9 = 1128792064(0x43480000, float:200.0)
            int r15 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r15, (float) r9)
            r9 = -1
            r12.<init>(r9, r15)
            r3.setLayoutParams(r12)
            android.widget.ImageView$ScaleType r9 = android.widget.ImageView.ScaleType.CENTER_CROP
            r3.setScaleType(r9)
            r13.addView(r3)
            java.lang.String r9 = r32.getIconUrl()
            r1.a((java.lang.String) r9, (android.widget.ImageView) r3)
            r3 = 1055286886(0x3ee66666, float:0.45)
            r13.setWidthRatio(r3)
            r3 = 1063675494(0x3f666666, float:0.9)
            r13.setHeightRatio(r3)
            r3 = 1
            r13.setAutoscroll(r3)
        L_0x01bc:
            r9 = 0
            goto L_0x01e5
        L_0x01be:
            r19 = r9
            r18 = r15
            r3 = 1065353216(0x3f800000, float:1.0)
            r13.setWidthRatio(r3)
            r13.setHeightRatio(r3)
            r9 = 0
            r13.setAutoscroll(r9)
            goto L_0x01e5
        L_0x01cf:
            r19 = r9
            r18 = r15
            r3 = 1065353216(0x3f800000, float:1.0)
            r9 = 0
            r13.setWidthRatio(r3)
            r13.setHeightRatio(r3)
            r13.setAutoscroll(r9)
            goto L_0x01e5
        L_0x01e0:
            r19 = r9
            r18 = r15
            goto L_0x01bc
        L_0x01e5:
            if (r4 == 0) goto L_0x01f1
            r4.setType(r9)
            java.lang.String r3 = r32.getIconUrl()
            r1.a((java.lang.String) r3, (android.widget.ImageView) r4)
        L_0x01f1:
            if (r8 == 0) goto L_0x01fa
            java.lang.String r3 = r32.getIconUrl()
            r1.a((java.lang.String) r3, (android.widget.ImageView) r8)
        L_0x01fa:
            if (r11 == 0) goto L_0x0213
            java.lang.String r3 = r32.getAppName()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x020e
            java.lang.String r3 = r32.getAppName()
            r11.setText(r3)
            goto L_0x0213
        L_0x020e:
            r3 = 8
            r11.setVisibility(r3)
        L_0x0213:
            if (r2 == 0) goto L_0x021d
            com.mbridge.msdk.video.dynview.j.a$5 r3 = new com.mbridge.msdk.video.dynview.j.a$5
            r3.<init>(r5, r0)
            r2.setOnClickListener(r3)
        L_0x021d:
            if (r24 == 0) goto L_0x0284
            r29 = 10
            r30 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r25 = 20
            r26 = 20
            r27 = 0
            r28 = 0
            r24.setCustomBorder(r25, r26, r27, r28, r29, r30)
            r4 = r24
            java.lang.String r0 = r23.getImageUrl()
            r1.a((java.lang.String) r0, (android.widget.ImageView) r4, (com.mbridge.msdk.video.dynview.c) r6, (android.view.View) r7)
            if (r10 == 0) goto L_0x0284
            boolean r0 = r23.getCanStart2C1Anim()
            if (r0 == 0) goto L_0x0293
            java.lang.String r0 = r23.getIconUrl()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0286
            android.widget.ImageView r0 = new android.widget.ImageView
            android.content.Context r2 = r6.a()
            r0.<init>(r2)
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            android.content.Context r3 = r6.a()
            r9 = 1128792064(0x43480000, float:200.0)
            int r3 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r3, (float) r9)
            r9 = -1
            r2.<init>(r9, r3)
            r0.setLayoutParams(r2)
            android.widget.ImageView$ScaleType r2 = android.widget.ImageView.ScaleType.CENTER_CROP
            r0.setScaleType(r2)
            r10.addView(r0)
            java.lang.String r2 = r23.getIconUrl()
            r1.a((java.lang.String) r2, (android.widget.ImageView) r0)
            r3 = 1055286886(0x3ee66666, float:0.45)
            r10.setWidthRatio(r3)
            r3 = 1063675494(0x3f666666, float:0.9)
            r10.setHeightRatio(r3)
            r3 = 1
            r10.setAutoscroll(r3)
        L_0x0284:
            r9 = 0
            goto L_0x029f
        L_0x0286:
            r3 = 1065353216(0x3f800000, float:1.0)
            r10.setWidthRatio(r3)
            r10.setHeightRatio(r3)
            r9 = 0
            r10.setAutoscroll(r9)
            goto L_0x029f
        L_0x0293:
            r3 = 1065353216(0x3f800000, float:1.0)
            r9 = 0
            r10.setWidthRatio(r3)
            r10.setHeightRatio(r3)
            r10.setAutoscroll(r9)
        L_0x029f:
            if (r14 == 0) goto L_0x02ab
            r14.setType(r9)
            java.lang.String r0 = r23.getIconUrl()
            r1.a((java.lang.String) r0, (android.widget.ImageView) r14)
        L_0x02ab:
            if (r19 == 0) goto L_0x02b6
            java.lang.String r0 = r23.getIconUrl()
            r8 = r19
            r1.a((java.lang.String) r0, (android.widget.ImageView) r8)
        L_0x02b6:
            if (r34 == 0) goto L_0x02c1
            java.lang.String r0 = r23.getAppName()
            r3 = r34
            r3.setText(r0)
        L_0x02c1:
            java.lang.String r0 = r32.getCMPTEntryUrl()
            r6.e()
            java.lang.String r2 = "cltp"
            java.lang.String r2 = com.mbridge.msdk.foundation.tools.aq.a(r0, r2)
            java.lang.String r3 = "xt"
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.aq.a(r0, r3)
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            r8 = 0
            if (r0 != 0) goto L_0x02e1
            long r10 = java.lang.Long.parseLong(r2)
            goto L_0x02e2
        L_0x02e1:
            r10 = r8
        L_0x02e2:
            int r0 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x03b6
            if (r5 == 0) goto L_0x02fc
            r0 = r33
            boolean r2 = r5.containsKey(r0)
            if (r2 == 0) goto L_0x02fc
            java.lang.Object r0 = r5.get(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            f12139j = r0
        L_0x02fc:
            boolean r0 = f12139j
            java.lang.String r2 = "mbridge_choice_one_countdown_tv"
            int r0 = r1.a((boolean) r0, (java.lang.String) r2)
            android.view.View r0 = r7.findViewById(r0)
            r2 = r0
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x037e
            r0 = 1093664768(0x41300000, float:11.0)
            r2.setTextSize(r0)
            java.lang.String r0 = r1.f12144e
            int r0 = android.graphics.Color.parseColor(r0)
            r2.setTextColor(r0)
            java.lang.String r0 = r1.f12145f
            android.graphics.drawable.GradientDrawable r4 = new android.graphics.drawable.GradientDrawable
            r4.<init>()
            int r8 = android.graphics.Color.parseColor(r0)
            r4.setColor(r8)
            android.content.Context r8 = r2.getContext()
            r9 = 12
            float r9 = (float) r9
            int r8 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r8, (float) r9)
            float r8 = (float) r8
            r4.setCornerRadius(r8)
            android.content.Context r8 = r2.getContext()
            r9 = 1
            float r12 = (float) r9
            int r8 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r8, (float) r12)
            int r0 = android.graphics.Color.parseColor(r0)
            r4.setStroke(r8, r0)
            r2.setBackground(r4)
            r9 = 0
            r2.setVisibility(r9)
            com.mbridge.msdk.video.dynview.j.a$11 r0 = new com.mbridge.msdk.video.dynview.j.a$11
            r15 = r32
            r0.<init>(r15, r5)
            r2.setOnClickListener(r0)
            com.mbridge.msdk.video.dynview.j.a$2 r0 = new com.mbridge.msdk.video.dynview.j.a$2
            r4 = r15
            r0.<init>(r2, r3, r4, r5)
            r1.f12149k = r0
            com.mbridge.msdk.video.dynview.i.c.b r0 = new com.mbridge.msdk.video.dynview.i.c.b
            r0.<init>()
            r2 = 1000(0x3e8, double:4.94E-321)
            long r10 = r10 * r2
            com.mbridge.msdk.video.dynview.i.c.b r0 = r0.b(r10)
            com.mbridge.msdk.video.dynview.i.c.b r0 = r0.a((long) r2)
            com.mbridge.msdk.video.dynview.i.c.a r2 = r1.f12149k
            com.mbridge.msdk.video.dynview.i.c.b r0 = r0.a((com.mbridge.msdk.video.dynview.i.c.a) r2)
            r1.f12141b = r0
            r0.a()
            goto L_0x0380
        L_0x037e:
            r15 = r32
        L_0x0380:
            boolean r0 = f12139j
            java.lang.String r2 = "mbridge_iv_link"
            int r0 = r1.a((boolean) r0, (java.lang.String) r2)
            android.view.View r0 = r7.findViewById(r0)
            r14 = r0
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            com.mbridge.msdk.foundation.entity.CampaignEx$a r0 = r15.getAdchoice()
            if (r0 == 0) goto L_0x039e
            com.mbridge.msdk.foundation.entity.CampaignEx$a r0 = r15.getAdchoice()
            java.lang.String r2 = ""
            r0.b(r2)
        L_0x039e:
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r16 = r0.c()
            com.mbridge.msdk.video.dynview.j.a$3 r0 = new com.mbridge.msdk.video.dynview.j.a$3
            r0.<init>()
            r13 = 4
            r17 = 0
            r3 = r18
            r18 = r0
            com.mbridge.msdk.foundation.tools.ak.a(r13, r14, r15, r16, r17, r18)
            goto L_0x03b8
        L_0x03b6:
            r3 = r18
        L_0x03b8:
            if (r3 == 0) goto L_0x03e7
            int r0 = r6.e()
            java.lang.String r2 = "drawable"
            r9 = 1
            if (r0 != r9) goto L_0x03d5
            r0 = r31
            java.lang.String r4 = com.mbridge.msdk.video.dynview.i.a.a((android.content.Context) r0, (int) r9)
            android.content.Context r0 = r0.getApplicationContext()
            int r0 = com.mbridge.msdk.foundation.tools.x.a(r0, r4, r2)
            r3.setImageResource(r0)
            goto L_0x03e7
        L_0x03d5:
            r0 = r31
            r4 = 2
            java.lang.String r4 = com.mbridge.msdk.video.dynview.i.a.a((android.content.Context) r0, (int) r4)
            android.content.Context r0 = r0.getApplicationContext()
            int r0 = com.mbridge.msdk.foundation.tools.x.a(r0, r4, r2)
            r3.setImageResource(r0)
        L_0x03e7:
            if (r39 == 0) goto L_0x03ef
            r8 = r39
            r0 = 0
            r8.a(r7, r0)
        L_0x03ef:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.j.a.a(com.mbridge.msdk.video.dynview.c, android.view.View, java.util.Map, com.mbridge.msdk.video.dynview.e.e):void");
    }

    private void b() {
        com.mbridge.msdk.video.dynview.i.a.a.a().b();
        b bVar = this.f12141b;
        if (bVar != null) {
            bVar.b();
            this.f12141b = null;
        }
        com.mbridge.msdk.video.dynview.b.a.a().f12040a = null;
        if (this.f12140a != null) {
            this.f12140a = null;
        }
        Map<String, Bitmap> map = this.f12142c;
        if (map != null) {
            if (map.entrySet() != null) {
                try {
                    Iterator<Map.Entry<String, Bitmap>> it = this.f12142c.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry next = it.next();
                        if (!(next == null || next.getValue() == null || ((Bitmap) next.getValue()).isRecycled())) {
                            ((Bitmap) next.getValue()).recycle();
                        }
                        it.remove();
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            this.f12142c.clear();
        }
    }

    static /* synthetic */ void b(a aVar, Map map) {
        if (map != null) {
            try {
                if (map.containsKey("choice_one_callback") && (map.get("choice_one_callback") instanceof d)) {
                    ((d) map.get("choice_one_callback")).countDownClick();
                    aVar.b();
                }
            } catch (Exception e5) {
                af.b("DataEnergizeWrapper", e5.getMessage());
            }
        }
    }

    public final void a(c cVar, View view, e eVar) {
        if (eVar != null) {
            if (cVar == null) {
                eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
                return;
            }
            try {
                ImageView imageView = (ImageView) view.findViewById(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_iv_adbanner_bg", "id"));
                if (imageView != null) {
                    imageView.setBackgroundColor(Color.parseColor(this.f12147h));
                }
                ImageView imageView2 = (ImageView) view.findViewById(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_iv_adbanner", "id"));
                if (imageView2 != null) {
                    imageView2.setBackgroundColor(Color.parseColor(this.f12147h));
                }
                eVar.a(view, new ArrayList());
            } catch (Exception e5) {
                af.a("DataEnergizeWrapper", e5.getMessage());
                eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
            }
        }
    }

    private void a(String str, ImageView imageView) {
        if (!TextUtils.isEmpty(str) && imageView != null) {
            a(imageView, str, -1);
        }
    }

    private void a(final ImageView imageView, String str, final int i5) {
        if (!TextUtils.isEmpty(str) && imageView != null) {
            com.mbridge.msdk.foundation.same.c.b.a(imageView.getContext()).a(str, new com.mbridge.msdk.foundation.same.c.c() {
                public final void onFailedLoad(String str, String str2) {
                    try {
                        int a5 = x.a(imageView.getContext(), "mbridge_icon_play_bg", "drawable");
                        imageView.setBackgroundColor(Color.parseColor(a.this.f12146g));
                        imageView.setImageResource(a5);
                        imageView.setScaleType(ImageView.ScaleType.CENTER);
                    } catch (Exception e5) {
                        af.a("DataEnergizeWrapper", e5.getMessage());
                    }
                }

                public final void onSuccessLoad(final Bitmap bitmap, String str) {
                    if (bitmap == null || bitmap.isRecycled()) {
                        int a5 = x.a(imageView.getContext(), "mbridge_icon_play_bg", "drawable");
                        imageView.setBackgroundColor(Color.parseColor(a.this.f12146g));
                        imageView.setImageResource(a5);
                        imageView.setScaleType(ImageView.ScaleType.CENTER);
                        return;
                    }
                    int i5 = i5;
                    if (i5 == 501 || i5 == 802) {
                        com.mbridge.msdk.foundation.same.f.a.a().execute(new Runnable() {
                            public final void run() {
                                try {
                                    final Bitmap a5 = p.a(bitmap, 10);
                                    imageView.post(new Runnable() {
                                        public final void run() {
                                            imageView.setImageBitmap(a5);
                                        }
                                    });
                                } catch (Exception e5) {
                                    af.b("DataEnergizeWrapper", e5.getMessage());
                                }
                            }
                        });
                        return;
                    }
                    imageView.setImageBitmap(bitmap);
                }
            });
        }
    }

    private void a(String str, ImageView imageView, c cVar, View view) {
        final String str2 = str;
        final ImageView imageView2 = imageView;
        final c cVar2 = cVar;
        final View view2 = view;
        com.mbridge.msdk.foundation.same.c.b.a(imageView.getContext()).a(str2, new com.mbridge.msdk.foundation.same.c.c() {
            public final void onFailedLoad(String str, String str2) {
            }

            public final void onSuccessLoad(Bitmap bitmap, String str) {
                ImageView imageView;
                if (bitmap != null && !bitmap.isRecycled() && (imageView = imageView2) != null) {
                    imageView.setImageBitmap(bitmap);
                    if (a.this.f12142c != null) {
                        a.this.f12142c.put(SameMD5.getMD5(str2), bitmap);
                        a.a(a.this, cVar2, view2);
                    }
                }
            }
        });
        try {
            Bitmap a5 = a();
            if (a5 != null && !a5.isRecycled()) {
                a(cVar2, view2);
            }
        } catch (Exception e5) {
            af.b("DataEnergizeWrapper", e5.getMessage());
        }
    }

    private int a(boolean z4, String str) {
        if (!z4) {
            return x.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, "id");
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                return str.hashCode();
            }
            return -1;
        } catch (Exception e5) {
            af.b("DataEnergizeWrapper", e5.getMessage());
            return -1;
        }
    }

    private Bitmap a() {
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_4444);
            bitmap.eraseColor(Color.parseColor(this.f12147h));
            return bitmap;
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
            return bitmap;
        }
    }

    private void a(c cVar, View view) {
        a.C0110a a5 = com.mbridge.msdk.video.dynview.g.a.a();
        a5.a(cVar.e()).a(true);
        if (cVar.e() != 2) {
            a5.a(cVar.d()).b(cVar.c());
        } else if (cVar.d() > cVar.c()) {
            a5.a(cVar.d()).b(cVar.c());
        } else {
            a5.a(cVar.c()).b(cVar.d());
        }
        if (view.getBackground() == null) {
            view.setBackground(a5.a());
        }
    }

    static /* synthetic */ void a(a aVar, Map map, List list, int i5) {
        if (map != null && list != null && list.size() > 1) {
            if (map.containsKey("choice_one_callback") && (map.get("choice_one_callback") instanceof d)) {
                d dVar = (d) map.get("choice_one_callback");
                if (dVar != null) {
                    dVar.itemClick((CampaignEx) list.get(i5));
                    try {
                        CampaignEx campaignEx = (CampaignEx) list.get(i5);
                        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                        eVar.a(CampaignEx.JSON_NATIVE_VIDEO_CLICK, "0");
                        eVar.a("time", Long.valueOf(aVar.f12148i));
                        eVar.a("choose_cid", campaignEx.getId());
                        eVar.a("position", Integer.valueOf(i5));
                        eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "choseFromTwoSelect");
                        com.mbridge.msdk.video.module.b.a.a("2000103", campaignEx, eVar);
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            e5.printStackTrace();
                        }
                    }
                }
                aVar.b();
            } else if (map.containsKey("order_view_callback") && (map.get("order_view_callback") instanceof com.mbridge.msdk.video.dynview.e.c)) {
                com.mbridge.msdk.video.dynview.e.c cVar = (com.mbridge.msdk.video.dynview.e.c) map.get("order_view_callback");
                if (cVar != null) {
                    cVar.a((CampaignEx) list.get(i5), i5);
                }
                aVar.b();
            }
        }
    }

    static /* synthetic */ void a(a aVar, Map map) {
        if (map != null) {
            try {
                if (map.containsKey("order_view_callback") && (map.get("order_view_callback") instanceof com.mbridge.msdk.video.dynview.e.c)) {
                    ((com.mbridge.msdk.video.dynview.e.c) map.get("order_view_callback")).a();
                    aVar.b();
                }
            } catch (Exception e5) {
                af.b("DataEnergizeWrapper", e5.getMessage());
            }
        }
    }

    static /* synthetic */ void a(a aVar, c cVar, View view) {
        Map<String, Bitmap> map = aVar.f12142c;
        if (map != null && map.size() > 1) {
            new com.mbridge.msdk.video.dynview.h.b();
            Map<String, Bitmap> map2 = aVar.f12142c;
            if (view != null) {
                com.mbridge.msdk.video.dynview.i.a.a.a().a(map2, cVar, view);
            }
        }
    }
}
