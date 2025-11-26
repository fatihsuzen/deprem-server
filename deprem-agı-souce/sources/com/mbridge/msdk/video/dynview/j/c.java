package com.mbridge.msdk.video.dynview.j;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.i.a;
import com.mbridge.msdk.videocommon.d.b;
import java.util.ArrayList;
import java.util.List;

public final class c {
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.video.dynview.c a(android.content.Context r13, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r14) {
        /*
            r12 = this;
            r0 = 0
            if (r14 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x004a }
            android.content.Context r1 = r1.c()     // Catch:{ Exception -> 0x004a }
            int r1 = com.mbridge.msdk.foundation.tools.ak.f((android.content.Context) r1)     // Catch:{ Exception -> 0x004a }
            float r1 = (float) r1     // Catch:{ Exception -> 0x004a }
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x004a }
            android.content.Context r2 = r2.c()     // Catch:{ Exception -> 0x004a }
            int r2 = com.mbridge.msdk.foundation.tools.ak.e((android.content.Context) r2)     // Catch:{ Exception -> 0x004a }
            float r2 = (float) r2     // Catch:{ Exception -> 0x004a }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x004a }
            r3.<init>()     // Catch:{ Exception -> 0x004a }
            int r4 = r14.size()     // Catch:{ Exception -> 0x004a }
            java.lang.String r5 = ""
            r6 = 1
            r7 = 0
            if (r4 <= 0) goto L_0x006d
            java.lang.Object r4 = r14.get(r7)     // Catch:{ Exception -> 0x004a }
            if (r4 == 0) goto L_0x006d
            java.lang.Object r4 = r14.get(r7)     // Catch:{ Exception -> 0x004a }
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = (com.mbridge.msdk.foundation.entity.CampaignEx) r4     // Catch:{ Exception -> 0x004a }
            if (r4 == 0) goto L_0x004d
            com.mbridge.msdk.foundation.entity.CampaignEx$c r8 = r4.getRewardTemplateMode()     // Catch:{ Exception -> 0x004a }
            if (r8 == 0) goto L_0x004d
            com.mbridge.msdk.foundation.entity.CampaignEx$c r4 = r4.getRewardTemplateMode()     // Catch:{ Exception -> 0x004a }
            int r4 = r4.b()     // Catch:{ Exception -> 0x004a }
            goto L_0x004e
        L_0x004a:
            r13 = move-exception
            goto L_0x00f6
        L_0x004d:
            r4 = r6
        L_0x004e:
            java.lang.Object r8 = r14.get(r7)     // Catch:{ Exception -> 0x004a }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = (com.mbridge.msdk.foundation.entity.CampaignEx) r8     // Catch:{ Exception -> 0x004a }
            int r8 = r8.getMof_tplid()     // Catch:{ Exception -> 0x004a }
            java.lang.Object r9 = r14.get(r7)     // Catch:{ Exception -> 0x004a }
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = (com.mbridge.msdk.foundation.entity.CampaignEx) r9     // Catch:{ Exception -> 0x004a }
            java.lang.String r9 = r9.getMof_template_url()     // Catch:{ Exception -> 0x004a }
            java.lang.Object r10 = r14.get(r7)     // Catch:{ Exception -> 0x004a }
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = (com.mbridge.msdk.foundation.entity.CampaignEx) r10     // Catch:{ Exception -> 0x004a }
            int r10 = r10.getDynamicTempCode()     // Catch:{ Exception -> 0x004a }
            goto L_0x0071
        L_0x006d:
            r9 = r5
            r4 = r6
            r8 = r7
            r10 = r8
        L_0x0071:
            if (r8 == 0) goto L_0x00a9
            boolean r11 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x004a }
            if (r11 != 0) goto L_0x00a9
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004a }
            r3.<init>()     // Catch:{ Exception -> 0x004a }
            r3.append(r8)     // Catch:{ Exception -> 0x004a }
            r3.append(r5)     // Catch:{ Exception -> 0x004a }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x004a }
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.o.a(r7, r3, r9)     // Catch:{ Exception -> 0x004a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004a }
            r5.<init>()     // Catch:{ Exception -> 0x004a }
            java.lang.String r7 = "template_"
            r5.append(r7)     // Catch:{ Exception -> 0x004a }
            r5.append(r8)     // Catch:{ Exception -> 0x004a }
            java.lang.String r7 = "_"
            r5.append(r7)     // Catch:{ Exception -> 0x004a }
            r5.append(r4)     // Catch:{ Exception -> 0x004a }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x004a }
            java.util.List r3 = com.mbridge.msdk.foundation.tools.ad.a((java.lang.String) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x004a }
        L_0x00a9:
            java.lang.String r5 = "mbridge_same_choice_one_layout_portrait"
            if (r4 == r6) goto L_0x00c4
            java.lang.String r7 = "mbridge_same_choice_one_layout_landscape"
            r9 = 2
            if (r4 == r9) goto L_0x00c3
            android.content.res.Resources r4 = r13.getResources()     // Catch:{ Exception -> 0x004a }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ Exception -> 0x004a }
            int r4 = r4.orientation     // Catch:{ Exception -> 0x004a }
            if (r4 != r9) goto L_0x00c1
            r5 = r7
            r4 = r9
            goto L_0x00c4
        L_0x00c1:
            r4 = r6
            goto L_0x00c4
        L_0x00c3:
            r5 = r7
        L_0x00c4:
            com.mbridge.msdk.video.dynview.c$a r7 = new com.mbridge.msdk.video.dynview.c$a     // Catch:{ Exception -> 0x004a }
            r7.<init>()     // Catch:{ Exception -> 0x004a }
            com.mbridge.msdk.video.dynview.c$b r13 = r7.a((android.content.Context) r13)     // Catch:{ Exception -> 0x004a }
            com.mbridge.msdk.video.dynview.c$b r13 = r13.a((java.lang.String) r5)     // Catch:{ Exception -> 0x004a }
            com.mbridge.msdk.video.dynview.c$b r13 = r13.a((int) r6)     // Catch:{ Exception -> 0x004a }
            com.mbridge.msdk.video.dynview.c$b r13 = r13.a((float) r2)     // Catch:{ Exception -> 0x004a }
            com.mbridge.msdk.video.dynview.c$b r13 = r13.b((float) r1)     // Catch:{ Exception -> 0x004a }
            com.mbridge.msdk.video.dynview.c$b r13 = r13.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r14)     // Catch:{ Exception -> 0x004a }
            com.mbridge.msdk.video.dynview.c$b r13 = r13.b((int) r4)     // Catch:{ Exception -> 0x004a }
            com.mbridge.msdk.video.dynview.c$b r13 = r13.b((java.util.List<java.lang.String>) r3)     // Catch:{ Exception -> 0x004a }
            com.mbridge.msdk.video.dynview.c$b r13 = r13.e(r10)     // Catch:{ Exception -> 0x004a }
            com.mbridge.msdk.video.dynview.c$b r13 = r13.d(r8)     // Catch:{ Exception -> 0x004a }
            com.mbridge.msdk.video.dynview.c r13 = r13.a()     // Catch:{ Exception -> 0x004a }
            return r13
        L_0x00f6:
            java.lang.String r14 = "ViewOptionWrapper"
            java.lang.String r13 = r13.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r14, r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.j.c.a(android.content.Context, java.util.List):com.mbridge.msdk.video.dynview.c");
    }

    public final com.mbridge.msdk.video.dynview.c b(View view, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        try {
            int i5 = 0;
            com.mbridge.msdk.videocommon.d.c a5 = b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), campaignEx.getCampaignUnitId(), false);
            if (a5 != null) {
                i5 = a5.g();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(campaignEx);
            return new c.a().a("mbridge_reward_layer_floor_bottom").a(3).a((List<CampaignEx>) arrayList).a(view.getContext()).a(view).c(i5).b(ab.s(view.getContext())).a();
        } catch (Exception e5) {
            af.b("ViewOptionWrapper", e5.getMessage());
            return null;
        }
    }

    public final com.mbridge.msdk.video.dynview.c b(Context context, List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    float f5 = (float) ak.f(com.mbridge.msdk.foundation.controller.c.m().c());
                    float e5 = (float) ak.e(com.mbridge.msdk.foundation.controller.c.m().c());
                    List arrayList = new ArrayList();
                    int dynamicTempCode = list.get(0).getDynamicTempCode();
                    int mof_tplid = list.get(0).getMof_tplid();
                    String mof_template_url = list.get(0).getMof_template_url();
                    int s5 = ab.s(context);
                    if (mof_tplid != 0 && !TextUtils.isEmpty(mof_template_url)) {
                        String a5 = o.a(0, mof_tplid + "", mof_template_url);
                        arrayList = ad.a(a5, "template_" + mof_tplid + "_" + s5);
                    }
                    return new c.a().a(s5 == 1 ? "mbridge_order_layout_list_portrait" : "mbridge_order_layout_list_landscape").a(5).a(context).a(e5).b(f5).a(list).b(s5).b((List<String>) arrayList).e(dynamicTempCode).d(mof_tplid).a();
                }
            } catch (Exception e6) {
                af.b("ViewOptionWrapper", e6.getMessage());
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0058 A[Catch:{ Exception -> 0x0027 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009d A[Catch:{ Exception -> 0x0027 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.video.dynview.c a(android.view.View r12, com.mbridge.msdk.foundation.entity.CampaignEx r13) {
        /*
            r11 = this;
            r0 = 0
            if (r13 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0027 }
            r1.<init>()     // Catch:{ Exception -> 0x0027 }
            java.lang.String r2 = r13.getCampaignUnitId()     // Catch:{ Exception -> 0x0027 }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r3 = r13.getRewardTemplateMode()     // Catch:{ Exception -> 0x0027 }
            java.lang.String r4 = ""
            r5 = 0
            if (r3 == 0) goto L_0x002a
            com.mbridge.msdk.foundation.entity.CampaignEx$c r3 = r13.getRewardTemplateMode()     // Catch:{ Exception -> 0x0027 }
            int r3 = r3.f()     // Catch:{ Exception -> 0x0027 }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r6 = r13.getRewardTemplateMode()     // Catch:{ Exception -> 0x0027 }
            java.lang.String r6 = r6.e()     // Catch:{ Exception -> 0x0027 }
            goto L_0x002c
        L_0x0027:
            r12 = move-exception
            goto L_0x00f8
        L_0x002a:
            r6 = r4
            r3 = r5
        L_0x002c:
            java.lang.String r7 = "ia_tp"
            r8 = -5
            int r7 = com.mbridge.msdk.foundation.tools.ak.a((java.lang.String) r6, (java.lang.String) r7, (int) r8)     // Catch:{ Exception -> 0x0027 }
            if (r3 == 0) goto L_0x0050
            r8 = 102(0x66, float:1.43E-43)
            if (r3 == r8) goto L_0x0050
            r8 = 202(0xca, float:2.83E-43)
            if (r3 != r8) goto L_0x003e
            goto L_0x0050
        L_0x003e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0027 }
            r8.<init>()     // Catch:{ Exception -> 0x0027 }
            java.lang.String r9 = "mbridge_reward_layer_floor_"
            r8.append(r9)     // Catch:{ Exception -> 0x0027 }
            r8.append(r3)     // Catch:{ Exception -> 0x0027 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0027 }
            goto L_0x0052
        L_0x0050:
            java.lang.String r8 = "mbridge_reward_layer_floor"
        L_0x0052:
            boolean r9 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0027 }
            if (r9 != 0) goto L_0x0081
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0027 }
            r1.<init>()     // Catch:{ Exception -> 0x0027 }
            r1.append(r3)     // Catch:{ Exception -> 0x0027 }
            r1.append(r4)     // Catch:{ Exception -> 0x0027 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0027 }
            r4 = 1
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.o.a(r4, r1, r6)     // Catch:{ Exception -> 0x0027 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0027 }
            r4.<init>()     // Catch:{ Exception -> 0x0027 }
            java.lang.String r9 = "template_"
            r4.append(r9)     // Catch:{ Exception -> 0x0027 }
            r4.append(r3)     // Catch:{ Exception -> 0x0027 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0027 }
            java.util.List r1 = com.mbridge.msdk.foundation.tools.ad.a((java.lang.String) r1, (java.lang.String) r4)     // Catch:{ Exception -> 0x0027 }
        L_0x0081:
            boolean r4 = com.mbridge.msdk.video.dynview.i.a.a((java.lang.String) r6)     // Catch:{ Exception -> 0x0027 }
            java.lang.String r9 = "whs_chn"
            java.lang.String r6 = com.mbridge.msdk.video.dynview.i.a.a((java.lang.String) r6, (java.lang.String) r9)     // Catch:{ Exception -> 0x0027 }
            com.mbridge.msdk.videocommon.d.b r9 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x0027 }
            com.mbridge.msdk.foundation.controller.c r10 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0027 }
            java.lang.String r10 = r10.k()     // Catch:{ Exception -> 0x0027 }
            com.mbridge.msdk.videocommon.d.c r2 = r9.a((java.lang.String) r10, (java.lang.String) r2, (boolean) r5)     // Catch:{ Exception -> 0x0027 }
            if (r2 == 0) goto L_0x00a1
            int r5 = r2.g()     // Catch:{ Exception -> 0x0027 }
        L_0x00a1:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0027 }
            r2.<init>()     // Catch:{ Exception -> 0x0027 }
            r2.add(r13)     // Catch:{ Exception -> 0x0027 }
            com.mbridge.msdk.video.dynview.c$a r9 = new com.mbridge.msdk.video.dynview.c$a     // Catch:{ Exception -> 0x0027 }
            r9.<init>()     // Catch:{ Exception -> 0x0027 }
            com.mbridge.msdk.video.dynview.c$b r8 = r9.a((java.lang.String) r8)     // Catch:{ Exception -> 0x0027 }
            r9 = 2
            com.mbridge.msdk.video.dynview.c$b r8 = r8.a((int) r9)     // Catch:{ Exception -> 0x0027 }
            com.mbridge.msdk.video.dynview.c$b r2 = r8.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r2)     // Catch:{ Exception -> 0x0027 }
            android.content.Context r8 = r12.getContext()     // Catch:{ Exception -> 0x0027 }
            com.mbridge.msdk.video.dynview.c$b r2 = r2.a((android.content.Context) r8)     // Catch:{ Exception -> 0x0027 }
            com.mbridge.msdk.video.dynview.c$b r2 = r2.a((android.view.View) r12)     // Catch:{ Exception -> 0x0027 }
            com.mbridge.msdk.video.dynview.c$b r2 = r2.c((int) r5)     // Catch:{ Exception -> 0x0027 }
            com.mbridge.msdk.video.dynview.c$b r2 = r2.f(r7)     // Catch:{ Exception -> 0x0027 }
            android.content.Context r12 = r12.getContext()     // Catch:{ Exception -> 0x0027 }
            int r12 = com.mbridge.msdk.foundation.tools.ab.s(r12)     // Catch:{ Exception -> 0x0027 }
            com.mbridge.msdk.video.dynview.c$b r12 = r2.b((int) r12)     // Catch:{ Exception -> 0x0027 }
            com.mbridge.msdk.video.dynview.c$b r12 = r12.d(r3)     // Catch:{ Exception -> 0x0027 }
            com.mbridge.msdk.video.dynview.c$b r12 = r12.a((boolean) r4)     // Catch:{ Exception -> 0x0027 }
            com.mbridge.msdk.video.dynview.c$b r12 = r12.c((java.lang.String) r6)     // Catch:{ Exception -> 0x0027 }
            com.mbridge.msdk.video.dynview.c$b r12 = r12.b((java.util.List<java.lang.String>) r1)     // Catch:{ Exception -> 0x0027 }
            int r13 = r13.getDynamicTempCode()     // Catch:{ Exception -> 0x0027 }
            com.mbridge.msdk.video.dynview.c$b r12 = r12.e(r13)     // Catch:{ Exception -> 0x0027 }
            com.mbridge.msdk.video.dynview.c r12 = r12.a()     // Catch:{ Exception -> 0x0027 }
            return r12
        L_0x00f8:
            java.lang.String r13 = "ViewOptionWrapper"
            java.lang.String r12 = r12.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r13, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.j.c.a(android.view.View, com.mbridge.msdk.foundation.entity.CampaignEx):com.mbridge.msdk.video.dynview.c");
    }

    public final com.mbridge.msdk.video.dynview.c b(Context context, CampaignEx campaignEx, int i5, String str) {
        if (campaignEx == null) {
            return null;
        }
        try {
            long ecTemplateId = campaignEx.getEcTemplateId();
            int s5 = ab.s(context);
            int a5 = ak.a(campaignEx.getendcard_url(), "n_logo", 1);
            String str2 = s5 == 1 ? "mbridge_reward_endcard_native_half_portrait" : "mbridge_reward_endcard_native_half_landscape";
            String str3 = "template_" + str + s5 + "_" + ecTemplateId + "_half";
            List arrayList = new ArrayList();
            if (!TextUtils.isEmpty(campaignEx.getendcard_url())) {
                arrayList = ad.a(o.a(2, i5 + "", campaignEx.getendcard_url()), str3);
            }
            return new c.a().a(str2).a(4).a(context).b(ab.s(context)).b((List<String>) arrayList).e(campaignEx.getDynamicTempCode()).d(i5).b(str).g(a5).a();
        } catch (Exception e5) {
            af.b("ViewOptionWrapper", e5.getMessage());
            return null;
        }
    }

    public final com.mbridge.msdk.video.dynview.c a(Context context, CampaignEx campaignEx, int i5, String str) {
        String str2;
        String str3;
        StringBuilder sb;
        if (campaignEx == null) {
            return null;
        }
        try {
            long ecTemplateId = campaignEx.getEcTemplateId();
            int s5 = ab.s(context);
            int a5 = ak.a(campaignEx.getendcard_url(), "n_logo", 1);
            if (ecTemplateId == 1302) {
                if (s5 == 1) {
                    sb = new StringBuilder();
                    sb.append("mbridge_reward_end_card_layout_portrait_");
                    sb.append(ecTemplateId);
                } else {
                    sb = new StringBuilder();
                    sb.append("mbridge_reward_end_card_layout_landscape_");
                    sb.append(ecTemplateId);
                }
                str2 = sb.toString();
                str3 = "template_" + str + s5 + "_" + ecTemplateId;
            } else {
                str2 = s5 == 1 ? "mbridge_reward_end_card_layout_portrait" : "mbridge_reward_end_card_layout_landscape";
                str3 = "template_" + str + s5;
            }
            List arrayList = new ArrayList();
            if (!TextUtils.isEmpty(campaignEx.getendcard_url())) {
                arrayList = ad.a(o.a(2, i5 + "", campaignEx.getendcard_url()), str3);
            }
            return new c.a().a(str2).a(4).a(context).b(ab.s(context)).b((List<String>) arrayList).e(campaignEx.getDynamicTempCode()).d(i5).b(str).g(a5).a();
        } catch (Exception e5) {
            af.b("ViewOptionWrapper", e5.getMessage());
            return null;
        }
    }

    public final com.mbridge.msdk.video.dynview.c a(View view, CampaignEx campaignEx, boolean z4) {
        String str;
        int i5;
        String str2;
        if (campaignEx == null) {
            return null;
        }
        try {
            List arrayList = new ArrayList();
            String campaignUnitId = campaignEx.getCampaignUnitId();
            int i6 = 0;
            if (campaignEx.getRewardTemplateMode() != null) {
                i5 = campaignEx.getRewardTemplateMode().f();
                str = campaignEx.getRewardTemplateMode().e();
            } else {
                str = "";
                i5 = 0;
            }
            int a5 = ak.a(str, "ia_tp", -5);
            if (z4) {
                if (!(i5 == 0 || i5 == 102)) {
                    if (i5 != 202) {
                        str2 = "mbridge_reward_layer_floor_" + i5;
                    }
                }
                str2 = "mbridge_reward_layer_floor";
            } else {
                str2 = "mbridge_reward_videoview_item";
            }
            if (!TextUtils.isEmpty(str)) {
                arrayList = ad.a(o.a(1, i5 + "", str), "template_" + i5);
            }
            boolean a6 = a.a(str);
            String a7 = a.a(str, "whs_chn");
            com.mbridge.msdk.videocommon.d.c a8 = b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), campaignUnitId, false);
            if (a8 != null) {
                i6 = a8.g();
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(campaignEx);
            return new c.a().a(str2).a(2).a((List<CampaignEx>) arrayList2).a(view.getContext()).a(view).c(i6).f(a5).b(ab.s(view.getContext())).d(i5).a(a6).c(a7).b((List<String>) arrayList).e(campaignEx.getDynamicTempCode()).a();
        } catch (Exception e5) {
            af.b("ViewOptionWrapper", e5.getMessage());
            return null;
        }
    }
}
