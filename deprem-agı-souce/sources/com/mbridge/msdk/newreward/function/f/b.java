package com.mbridge.msdk.newreward.function.f;

import com.mbridge.msdk.foundation.entity.CampaignEx;

public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private final String f10976a = "CN";

    /* renamed from: b  reason: collision with root package name */
    private final String f10977b = "117361";

    /* renamed from: c  reason: collision with root package name */
    private final String f10978c = "92762";

    /* renamed from: d  reason: collision with root package name */
    private final String f10979d = "936dcbdd57fe235fd7cf61c2e93da3c4";

    /* renamed from: e  reason: collision with root package name */
    private CampaignEx f10980e;

    public final void a(CampaignEx campaignEx) {
        this.f10980e = campaignEx;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c2 A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00cf A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x015a A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x015d A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0178 A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0180 A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x019a A[SYNTHETIC, Splitter:B:44:0x019a] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x019e A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01a9 A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01af A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0233 A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0248 A[Catch:{ Exception -> 0x006b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.String> b() {
        /*
            r28 = this;
            r1 = r28
            java.lang.String r2 = "20"
            java.lang.String r3 = "0"
            java.lang.String r4 = "sign"
            java.lang.String r0 = "i_fmd5"
            java.lang.String r5 = "v_fmd5"
            java.lang.String r6 = "tplgp"
            java.lang.String r7 = "rv_tid"
            java.lang.String r8 = "mcc"
            java.lang.String r9 = "ecid"
            java.lang.String r10 = "CN"
            java.lang.String r11 = "1"
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = r1.f10980e
            if (r12 != 0) goto L_0x001e
            r0 = 0
            return r0
        L_0x001e:
            java.util.Map r12 = r1.a()
            com.mbridge.msdk.foundation.same.net.f.e r13 = new com.mbridge.msdk.foundation.same.net.f.e
            r13.<init>(r12)
            com.mbridge.msdk.foundation.controller.c r12 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x006b }
            java.lang.String r12 = r12.k()     // Catch:{ Exception -> 0x006b }
            com.mbridge.msdk.foundation.entity.CampaignEx r14 = r1.f10980e     // Catch:{ Exception -> 0x006b }
            java.lang.String r14 = r14.getCampaignUnitId()     // Catch:{ Exception -> 0x006b }
            com.mbridge.msdk.foundation.entity.CampaignEx r15 = r1.f10980e     // Catch:{ Exception -> 0x006b }
            java.lang.String r15 = r15.getId()     // Catch:{ Exception -> 0x006b }
            r16 = r10
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r1.f10980e     // Catch:{ Exception -> 0x006b }
            java.lang.String r10 = r10.getRequestIdNotice()     // Catch:{ Exception -> 0x006b }
            r17 = r2
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.f10980e     // Catch:{ Exception -> 0x006b }
            r2.getRequestId()     // Catch:{ Exception -> 0x006b }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.f10980e     // Catch:{ Exception -> 0x006b }
            java.lang.String r2 = r2.getendcard_url()     // Catch:{ Exception -> 0x006b }
            r18 = r3
            java.lang.String r3 = "mof_testuid"
            java.lang.String r2 = com.mbridge.msdk.foundation.tools.aq.a(r2, r3)     // Catch:{ Exception -> 0x006b }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x006b }
            if (r3 == 0) goto L_0x006e
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.f10980e     // Catch:{ Exception -> 0x006b }
            java.lang.String r2 = r2.getendcard_url()     // Catch:{ Exception -> 0x006b }
            java.lang.String r3 = "mof_uid"
            java.lang.String r2 = com.mbridge.msdk.foundation.tools.aq.a(r2, r3)     // Catch:{ Exception -> 0x006b }
            goto L_0x006e
        L_0x006b:
            r0 = move-exception
            goto L_0x0267
        L_0x006e:
            boolean r3 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x008d }
            if (r3 != 0) goto L_0x008d
            com.mbridge.msdk.c.h r3 = com.mbridge.msdk.c.h.a()     // Catch:{ Exception -> 0x008d }
            com.mbridge.msdk.c.g r3 = r3.b(r12)     // Catch:{ Exception -> 0x008d }
            if (r3 == 0) goto L_0x008d
            com.mbridge.msdk.c.h r3 = com.mbridge.msdk.c.h.a()     // Catch:{ Exception -> 0x008d }
            com.mbridge.msdk.c.g r3 = r3.b(r12)     // Catch:{ Exception -> 0x008d }
            java.lang.String r3 = r3.r()     // Catch:{ Exception -> 0x008d }
        L_0x008a:
            r19 = r2
            goto L_0x0090
        L_0x008d:
            r3 = r16
            goto L_0x008a
        L_0x0090:
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.f10980e     // Catch:{ Exception -> 0x006b }
            java.lang.String r2 = r2.getendcard_url()     // Catch:{ Exception -> 0x006b }
            java.lang.String r2 = com.mbridge.msdk.foundation.tools.aq.a(r2, r8)     // Catch:{ Exception -> 0x006b }
            r20 = r3
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r1.f10980e     // Catch:{ Exception -> 0x006b }
            java.lang.String r3 = r3.getendcard_url()     // Catch:{ Exception -> 0x006b }
            r21 = r10
            java.lang.String r10 = "mnc"
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.aq.a(r3, r10)     // Catch:{ Exception -> 0x006b }
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r1.f10980e     // Catch:{ Exception -> 0x006b }
            java.lang.String r10 = r10.getendcard_url()     // Catch:{ Exception -> 0x006b }
            java.lang.String r10 = com.mbridge.msdk.foundation.tools.aq.a(r10, r7)     // Catch:{ Exception -> 0x006b }
            r22 = r7
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = r1.f10980e     // Catch:{ Exception -> 0x006b }
            java.lang.String r7 = r7.getendcard_url()     // Catch:{ Exception -> 0x006b }
            boolean r7 = r7.contains(r9)     // Catch:{ Exception -> 0x006b }
            if (r7 == 0) goto L_0x00cf
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = r1.f10980e     // Catch:{ Exception -> 0x006b }
            java.lang.String r7 = r7.getendcard_url()     // Catch:{ Exception -> 0x006b }
            java.lang.String r7 = com.mbridge.msdk.foundation.tools.aq.a(r7, r9)     // Catch:{ Exception -> 0x006b }
        L_0x00cc:
            r23 = r9
            goto L_0x00da
        L_0x00cf:
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = r1.f10980e     // Catch:{ Exception -> 0x006b }
            long r23 = r7.getEcTemplateId()     // Catch:{ Exception -> 0x006b }
            java.lang.String r7 = java.lang.String.valueOf(r23)     // Catch:{ Exception -> 0x006b }
            goto L_0x00cc
        L_0x00da:
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = r1.f10980e     // Catch:{ Exception -> 0x006b }
            java.lang.String r9 = r9.getendcard_url()     // Catch:{ Exception -> 0x006b }
            java.lang.String r9 = com.mbridge.msdk.foundation.tools.aq.a(r9, r6)     // Catch:{ Exception -> 0x006b }
            r24 = r6
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r1.f10980e     // Catch:{ Exception -> 0x006b }
            java.lang.String r6 = r6.getendcard_url()     // Catch:{ Exception -> 0x006b }
            java.lang.String r6 = com.mbridge.msdk.foundation.tools.aq.a(r6, r5)     // Catch:{ Exception -> 0x006b }
            r25 = r5
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = r1.f10980e     // Catch:{ Exception -> 0x006b }
            java.lang.String r5 = r5.getendcard_url()     // Catch:{ Exception -> 0x006b }
            java.lang.String r5 = com.mbridge.msdk.foundation.tools.aq.a(r5, r0)     // Catch:{ Exception -> 0x006b }
            r26 = r0
            java.lang.String r0 = "appid"
            r13.a(r0, r12)     // Catch:{ Exception -> 0x006b }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006b }
            r0.<init>()     // Catch:{ Exception -> 0x006b }
            r0.append(r12)     // Catch:{ Exception -> 0x006b }
            com.mbridge.msdk.foundation.controller.c r12 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x006b }
            java.lang.String r12 = r12.b()     // Catch:{ Exception -> 0x006b }
            r0.append(r12)     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r0)     // Catch:{ Exception -> 0x006b }
            r13.a(r4, r0)     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = "r_id"
            boolean r12 = android.text.TextUtils.isEmpty(r21)     // Catch:{ Exception -> 0x006b }
            r27 = r12
            java.lang.String r12 = ""
            if (r27 == 0) goto L_0x0131
            r27 = r4
            r4 = r12
            goto L_0x0135
        L_0x0131:
            r27 = r4
            r4 = r21
        L_0x0135:
            r13.a(r0, r4)     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = "e"
            java.lang.String[] r4 = new java.lang.String[]{r15}     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = java.util.Arrays.toString(r4)     // Catch:{ Exception -> 0x006b }
            r13.a(r0, r4)     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = "mof_type"
            r13.a(r0, r11)     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = "h5_type"
            r13.a(r0, r11)     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = "mof"
            r13.a(r0, r11)     // Catch:{ Exception -> 0x006b }
            boolean r0 = android.text.TextUtils.isEmpty(r20)     // Catch:{ Exception -> 0x006b }
            if (r0 == 0) goto L_0x015d
            r0 = r16
            goto L_0x015f
        L_0x015d:
            r0 = r20
        L_0x015f:
            java.lang.String r4 = "country_code"
            r13.a(r4, r0)     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = "mof_ver"
            r13.a(r0, r11)     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = "parent_exchange"
            r13.a(r0, r12)     // Catch:{ Exception -> 0x006b }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f10980e     // Catch:{ Exception -> 0x006b }
            int r0 = r0.getAdType()     // Catch:{ Exception -> 0x006b }
            r4 = 94
            if (r0 == r4) goto L_0x0180
            r4 = 287(0x11f, float:4.02E-43)
            if (r0 == r4) goto L_0x017d
            goto L_0x0182
        L_0x017d:
            java.lang.String r12 = "interstitial_video"
            goto L_0x0182
        L_0x0180:
            java.lang.String r12 = "rewarded_video"
        L_0x0182:
            java.lang.String r0 = "parent_ad_type"
            r13.a(r0, r12)     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = "oneId"
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r1.f10980e     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = r4.getReq_ext_data()     // Catch:{ Exception -> 0x006b }
            r13.a(r0, r4)     // Catch:{ Exception -> 0x006b }
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = "parent_template_id"
            if (r0 != 0) goto L_0x019e
            r13.a(r4, r7)     // Catch:{ Exception -> 0x006b }
            goto L_0x01a3
        L_0x019e:
            java.lang.String r0 = "404"
            r13.a(r4, r0)     // Catch:{ Exception -> 0x006b }
        L_0x01a3:
            boolean r0 = android.text.TextUtils.isEmpty(r19)     // Catch:{ Exception -> 0x006b }
            if (r0 == 0) goto L_0x01af
            java.lang.String r0 = "uc_parent_unit"
            r13.a(r0, r14)     // Catch:{ Exception -> 0x006b }
            goto L_0x01b4
        L_0x01af:
            java.lang.String r0 = "parent_unit"
            r13.a(r0, r14)     // Catch:{ Exception -> 0x006b }
        L_0x01b4:
            java.lang.String r0 = "mcn"
            r13.a(r0, r3)     // Catch:{ Exception -> 0x006b }
            r13.a(r8, r2)     // Catch:{ Exception -> 0x006b }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x006b }
            r2.<init>()     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = "crt_cid"
            r2.put(r0, r15)     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r0 = "crt_rid"
            r3 = r21
            r2.put(r0, r3)     // Catch:{ Exception -> 0x01f2 }
            r0 = r22
            r2.put(r0, r10)     // Catch:{ Exception -> 0x01f2 }
            r0 = r23
            r2.put(r0, r7)     // Catch:{ Exception -> 0x01f2 }
            r0 = r24
            r2.put(r0, r9)     // Catch:{ Exception -> 0x01f2 }
            r0 = r25
            r2.put(r0, r6)     // Catch:{ Exception -> 0x01f2 }
            r0 = r26
            r2.put(r0, r5)     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r0 = "h5_t"
            r3 = 1
            r2.put(r0, r3)     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r0 = "mof_t"
            r2.put(r0, r3)     // Catch:{ Exception -> 0x01f2 }
            goto L_0x01f6
        L_0x01f2:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x006b }
        L_0x01f6:
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x006b }
            java.lang.String r2 = "mof_data"
            r13.a(r2, r0)     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = "offer_id"
            r13.a(r0, r15)     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = "offset"
            r2 = r18
            r13.a(r0, r2)     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = "category"
            r13.a(r0, r2)     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = "only_impression"
            r13.a(r0, r11)     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = "ping_mode"
            r13.a(r0, r11)     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = "http_req"
            java.lang.String r2 = "2"
            r13.a(r0, r2)     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = "ad_num"
            r2 = r17
            r13.a(r0, r2)     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = "tnum"
            r13.a(r0, r2)     // Catch:{ Exception -> 0x006b }
            boolean r0 = android.text.TextUtils.isEmpty(r19)     // Catch:{ Exception -> 0x006b }
            if (r0 == 0) goto L_0x0248
            java.lang.String r2 = "117361"
            java.lang.String r0 = "app_id"
            java.lang.String r3 = "92762"
            r13.a(r0, r3)     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = "92762936dcbdd57fe235fd7cf61c2e93da3c4"
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r0)     // Catch:{ Exception -> 0x006b }
            r3 = r27
            r13.a(r3, r0)     // Catch:{ Exception -> 0x006b }
            goto L_0x024a
        L_0x0248:
            r2 = r19
        L_0x024a:
            java.lang.String r0 = "unit_id"
            r13.a(r0, r2)     // Catch:{ Exception -> 0x006b }
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x006b }
            android.content.Context r0 = r0.c()     // Catch:{ Exception -> 0x006b }
            com.mbridge.msdk.foundation.same.net.f.f.a((com.mbridge.msdk.foundation.same.net.f.e) r13, (android.content.Context) r0)     // Catch:{ Exception -> 0x006b }
            com.mbridge.msdk.foundation.same.net.f.f.a(r13)     // Catch:{ Exception -> 0x006b }
            com.mbridge.msdk.foundation.same.net.f.f.c(r13)     // Catch:{ Exception -> 0x006b }
            com.mbridge.msdk.foundation.same.net.f.f.e(r13)     // Catch:{ Exception -> 0x006b }
            com.mbridge.msdk.foundation.same.net.f.f.f(r13)     // Catch:{ Exception -> 0x006b }
            goto L_0x026e
        L_0x0267:
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r2 == 0) goto L_0x026e
            r0.printStackTrace()
        L_0x026e:
            java.util.Map r0 = r13.a()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.f.b.b():java.util.Map");
    }
}
