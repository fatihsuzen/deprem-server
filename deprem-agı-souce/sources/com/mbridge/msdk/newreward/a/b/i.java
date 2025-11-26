package com.mbridge.msdk.newreward.a.b;

import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.c.b.c;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;

public final class i implements a {

    /* renamed from: a  reason: collision with root package name */
    private final e f10379a;

    public i(e eVar) {
        this.f10379a = eVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:36|37) */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r6 = com.mbridge.msdk.foundation.same.net.e.d.f().f9352M;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00dc */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Object r21, com.mbridge.msdk.newreward.a.b.b r22) throws java.io.IOException {
        /*
            r20 = this;
            r1 = r20
            r2 = r22
            java.lang.String r0 = "mcd"
            java.lang.String r3 = "oneId"
            r4 = 880001(0xd6d81, float:1.233144E-39)
            if (r21 != 0) goto L_0x001a
            if (r2 == 0) goto L_0x0155
            com.mbridge.msdk.foundation.c.b r0 = new com.mbridge.msdk.foundation.c.b
            java.lang.String r3 = "ReqMoreOfferService doReq: params is null"
            r0.<init>(r4, r3)
            r2.reqFailed(r0)
            return
        L_0x001a:
            com.mbridge.msdk.newreward.a.e r5 = r1.f10379a     // Catch:{ Exception -> 0x0031 }
            long r5 = r5.p()     // Catch:{ Exception -> 0x0031 }
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0031 }
            r9 = 0
            int r11 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r11 > 0) goto L_0x0034
            com.mbridge.msdk.newreward.a.e r5 = r1.f10379a     // Catch:{ Exception -> 0x0031 }
            r5.c((long) r7)     // Catch:{ Exception -> 0x0031 }
            r5 = r7
            goto L_0x0034
        L_0x0031:
            r0 = move-exception
            goto L_0x0136
        L_0x0034:
            r11 = r21
            com.mbridge.msdk.newreward.function.f.b r11 = (com.mbridge.msdk.newreward.function.f.b) r11     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.newreward.a.e r12 = r1.f10379a     // Catch:{ Exception -> 0x0031 }
            int r14 = r12.h()     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.newreward.a.e r12 = r1.f10379a     // Catch:{ Exception -> 0x0031 }
            java.lang.String r15 = r12.C()     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.newreward.a.e r12 = r1.f10379a     // Catch:{ Exception -> 0x0031 }
            java.lang.String r16 = r12.H()     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.newreward.a.e r12 = r1.f10379a     // Catch:{ Exception -> 0x0031 }
            int r12 = r12.P()     // Catch:{ Exception -> 0x0031 }
            long r12 = (long) r12     // Catch:{ Exception -> 0x0031 }
            long r7 = r7 - r5
            long r12 = r12 - r7
            java.util.Map r5 = r11.b()     // Catch:{ Exception -> 0x0031 }
            if (r5 == 0) goto L_0x012b
            boolean r6 = r5.isEmpty()     // Catch:{ Exception -> 0x0031 }
            if (r6 == 0) goto L_0x0061
            goto L_0x012b
        L_0x0061:
            com.mbridge.msdk.foundation.same.net.e.d r6 = com.mbridge.msdk.foundation.same.net.e.d.f()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r6 = r6.f9352M     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.newreward.a.e r7 = r1.f10379a     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.newreward.function.e.a r7 = r7.D()     // Catch:{ Exception -> 0x0031 }
            r8 = 0
            if (r7 == 0) goto L_0x00d9
            com.mbridge.msdk.newreward.a.e r7 = r1.f10379a     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.newreward.function.e.a r7 = r7.D()     // Catch:{ Exception -> 0x0031 }
            java.util.List r7 = r7.a()     // Catch:{ Exception -> 0x0031 }
            if (r7 == 0) goto L_0x00d9
            boolean r11 = r7.isEmpty()     // Catch:{ Exception -> 0x0031 }
            if (r11 != 0) goto L_0x00d9
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x00dc }
            java.lang.Object r7 = r7.get(r8)     // Catch:{ Exception -> 0x00dc }
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = (com.mbridge.msdk.foundation.entity.CampaignEx) r7     // Catch:{ Exception -> 0x00dc }
            java.lang.String r7 = r7.getReq_ext_data()     // Catch:{ Exception -> 0x00dc }
            r11.<init>(r7)     // Catch:{ Exception -> 0x00dc }
            java.lang.String r7 = "mof_domain"
            java.lang.String r7 = r11.optString(r7)     // Catch:{ Exception -> 0x00dc }
            boolean r17 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x00dc }
            if (r17 != 0) goto L_0x00ae
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00dc }
            r6.<init>()     // Catch:{ Exception -> 0x00dc }
            r6.append(r7)     // Catch:{ Exception -> 0x00dc }
            java.lang.String r7 = "/openapi/ad/v3"
            r6.append(r7)     // Catch:{ Exception -> 0x00dc }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00dc }
        L_0x00ae:
            java.lang.String r7 = "parent_id"
            java.lang.String r7 = r11.optString(r7)     // Catch:{ Exception -> 0x00dc }
            boolean r17 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x00dc }
            if (r17 != 0) goto L_0x00bf
            java.lang.String r8 = "mof_parent_id"
            r5.put(r8, r7)     // Catch:{ Exception -> 0x00dc }
        L_0x00bf:
            java.lang.String r7 = r11.optString(r3)     // Catch:{ Exception -> 0x00dc }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x00dc }
            if (r8 != 0) goto L_0x00cc
            r5.put(r3, r7)     // Catch:{ Exception -> 0x00dc }
        L_0x00cc:
            java.lang.String r3 = r11.optString(r0)     // Catch:{ Exception -> 0x00dc }
            boolean r7 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00dc }
            if (r7 != 0) goto L_0x00d9
            r5.put(r0, r3)     // Catch:{ Exception -> 0x00dc }
        L_0x00d9:
            r19 = r6
            goto L_0x00e3
        L_0x00dc:
            com.mbridge.msdk.foundation.same.net.e.d r0 = com.mbridge.msdk.foundation.same.net.e.d.f()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r6 = r0.f9352M     // Catch:{ Exception -> 0x0031 }
            goto L_0x00d9
        L_0x00e3:
            com.mbridge.msdk.newreward.function.c.b.g r0 = new com.mbridge.msdk.newreward.function.c.b.g     // Catch:{ Exception -> 0x0031 }
            long r17 = java.lang.Math.max(r12, r9)     // Catch:{ Exception -> 0x0031 }
            r13 = r0
            r13.<init>(r14, r15, r16, r17, r19)     // Catch:{ Exception -> 0x0031 }
            r13.a((java.util.Map<java.lang.String, java.lang.String>) r5)     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.newreward.a.b.i$a r0 = new com.mbridge.msdk.newreward.a.b.i$a     // Catch:{ Exception -> 0x0031 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0031 }
            r13.a((com.mbridge.msdk.newreward.function.c.b.c) r0)     // Catch:{ Exception -> 0x0031 }
            byte[] r0 = r13.p()     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0100
            int r8 = r0.length     // Catch:{ Exception -> 0x0031 }
            goto L_0x0101
        L_0x0100:
            r8 = 0
        L_0x0101:
            java.lang.String r3 = com.mbridge.msdk.foundation.same.net.f.e.f9401h     // Catch:{ Exception -> 0x0031 }
            java.lang.String r5 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x0031 }
            r13.a(r3, r5)     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0123
            com.mbridge.msdk.foundation.same.net.e.d r0 = com.mbridge.msdk.foundation.same.net.e.d.f()     // Catch:{ Exception -> 0x0031 }
            int r0 = r0.d()     // Catch:{ Exception -> 0x0031 }
            if (r0 <= 0) goto L_0x0123
            if (r8 <= r0) goto L_0x0123
            r0 = 1
            r13.a((int) r0)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r0 = "Content-Type"
            java.lang.String r3 = "application/x-www-form-urlencoded"
            r13.b(r0, r3)     // Catch:{ Exception -> 0x0031 }
        L_0x0123:
            com.mbridge.msdk.newreward.function.c.b.f r0 = com.mbridge.msdk.newreward.function.c.b.f.a()     // Catch:{ Exception -> 0x0031 }
            r0.a((com.mbridge.msdk.newreward.function.c.b.a) r13)     // Catch:{ Exception -> 0x0031 }
            goto L_0x0155
        L_0x012b:
            com.mbridge.msdk.foundation.c.b r0 = new com.mbridge.msdk.foundation.c.b     // Catch:{ Exception -> 0x0031 }
            java.lang.String r3 = "ReqMoreOfferService doReq: MoreOfferReqParameters is null"
            r0.<init>(r4, r3)     // Catch:{ Exception -> 0x0031 }
            r2.reqFailed(r0)     // Catch:{ Exception -> 0x0031 }
            return
        L_0x0136:
            if (r2 == 0) goto L_0x0155
            com.mbridge.msdk.foundation.c.b r3 = new com.mbridge.msdk.foundation.c.b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "ReqMoreOfferService doReq: parse "
            r5.append(r6)
            java.lang.String r0 = r0.getMessage()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r3.<init>(r4, r0)
            r2.reqFailed(r3)
        L_0x0155:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.a.b.i.a(java.lang.Object, com.mbridge.msdk.newreward.a.b.b):void");
    }

    private static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final b f10380a;

        public a(b bVar) {
            this.f10380a = bVar;
        }

        public final void a(b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar) {
            b bVar2 = this.f10380a;
            if (bVar2 != null) {
                bVar2.reqSuccessful(bVar);
            }
        }

        public final void b(b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar, com.mbridge.msdk.newreward.function.c.b.b bVar2) {
            if (this.f10380a != null) {
                this.f10380a.reqFailed(a(bVar2, 401, aVar.k()));
            }
        }

        public final void a(b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar, com.mbridge.msdk.newreward.function.c.b.b bVar2) {
            if (this.f10380a != null) {
                this.f10380a.reqFailed(a(bVar2, 402, aVar.k()));
            }
        }

        public final void a(b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar, long j5, com.mbridge.msdk.newreward.function.c.b.b bVar2) {
            if (this.f10380a != null) {
                this.f10380a.reqFailed(a(bVar2, (int) MBridgeCommon.CampaignState.STATE_LOAD_FAILED_TIMEOUT, aVar.k()));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:41:0x0095 A[Catch:{ Exception -> 0x0033 }] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x009e A[Catch:{ Exception -> 0x0033 }] */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00aa  */
        /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private com.mbridge.msdk.foundation.c.b a(com.mbridge.msdk.newreward.function.c.b.b r10, int r11, java.lang.String r12) {
            /*
                r9 = this;
                r0 = 0
                r1 = 0
                r2 = 880002(0xd6d82, float:1.233145E-39)
                java.lang.String r3 = "load exception with no mCampaignRequestError"
                if (r10 == 0) goto L_0x00a8
                int r4 = r10.c()     // Catch:{ Exception -> 0x0033 }
                r5 = 9
                r6 = 880003(0xd6d83, float:1.233147E-39)
                java.lang.String r7 = ""
                if (r4 != r5) goto L_0x0036
                int r1 = r10.a()     // Catch:{ Exception -> 0x0033 }
                java.lang.String r3 = r10.b()     // Catch:{ Exception -> 0x0033 }
                int r2 = r10.c()     // Catch:{ Exception -> 0x0033 }
                r4 = -1
                if (r2 != r4) goto L_0x0029
                r2 = 880017(0xd6d91, float:1.233166E-39)
                goto L_0x002a
            L_0x0029:
                r2 = r6
            L_0x002a:
                java.lang.String r4 = r10.f()     // Catch:{ Exception -> 0x0033 }
                r5 = 1
                r8 = r7
                r7 = r4
            L_0x0031:
                r4 = r8
                goto L_0x007a
            L_0x0033:
                r10 = move-exception
                goto L_0x00a5
            L_0x0036:
                int r4 = r10.c()     // Catch:{ Exception -> 0x0033 }
                r5 = 10
                if (r4 != r5) goto L_0x004d
                r4 = 880023(0xd6d97, float:1.233175E-39)
                java.lang.String r3 = r10.d()     // Catch:{ Exception -> 0x004a }
                r5 = r1
                r1 = r4
                r2 = r1
            L_0x0048:
                r4 = r7
                goto L_0x007a
            L_0x004a:
                r10 = move-exception
                r1 = r4
                goto L_0x00a5
            L_0x004d:
                int r4 = r10.c()     // Catch:{ Exception -> 0x0033 }
                switch(r4) {
                    case 0: goto L_0x0057;
                    case 1: goto L_0x005a;
                    case 2: goto L_0x005a;
                    case 3: goto L_0x005a;
                    case 4: goto L_0x005a;
                    case 5: goto L_0x0057;
                    case 6: goto L_0x0055;
                    case 7: goto L_0x0055;
                    default: goto L_0x0054;
                }     // Catch:{ Exception -> 0x0033 }
            L_0x0054:
                goto L_0x005a
            L_0x0055:
                r2 = r6
                goto L_0x005a
            L_0x0057:
                r2 = 880020(0xd6d94, float:1.23317E-39)
            L_0x005a:
                com.mbridge.msdk.tracker.network.ad r4 = r10.e()     // Catch:{ Exception -> 0x0033 }
                if (r4 == 0) goto L_0x0078
                com.mbridge.msdk.tracker.network.ad r4 = r10.e()     // Catch:{ Exception -> 0x0033 }
                int r4 = r4.b()     // Catch:{ Exception -> 0x0033 }
                com.mbridge.msdk.tracker.network.ad r5 = r10.e()     // Catch:{ Exception -> 0x004a }
                java.lang.String r3 = r5.c()     // Catch:{ Exception -> 0x004a }
                java.lang.String r5 = r10.d()     // Catch:{ Exception -> 0x004a }
                r8 = r5
                r5 = r1
                r1 = r4
                goto L_0x0031
            L_0x0078:
                r5 = r1
                goto L_0x0048
            L_0x007a:
                com.mbridge.msdk.foundation.c.b r0 = com.mbridge.msdk.foundation.c.a.a(r1, r2, r3)     // Catch:{ Exception -> 0x0033 }
                java.lang.String r6 = "campaign_request_error_type"
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x0033 }
                r0.a(r6, r11)     // Catch:{ Exception -> 0x0033 }
                java.lang.String r11 = "campaign_request_error"
                r0.a(r11, r10)     // Catch:{ Exception -> 0x0033 }
                r0.b((boolean) r5)     // Catch:{ Exception -> 0x0033 }
                boolean r10 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0033 }
                if (r10 != 0) goto L_0x0098
                r0.e(r7)     // Catch:{ Exception -> 0x0033 }
            L_0x0098:
                boolean r10 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0033 }
                if (r10 != 0) goto L_0x00a1
                r0.f(r4)     // Catch:{ Exception -> 0x0033 }
            L_0x00a1:
                r0.d(r12)     // Catch:{ Exception -> 0x0033 }
                goto L_0x00a8
            L_0x00a5:
                r10.printStackTrace()
            L_0x00a8:
                if (r0 != 0) goto L_0x00ae
                com.mbridge.msdk.foundation.c.b r0 = com.mbridge.msdk.foundation.c.a.a(r1, r2, r3)
            L_0x00ae:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.a.b.i.a.a(com.mbridge.msdk.newreward.function.c.b.b, int, java.lang.String):com.mbridge.msdk.foundation.c.b");
        }
    }
}
