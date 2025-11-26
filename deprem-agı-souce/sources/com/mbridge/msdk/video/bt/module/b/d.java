package com.mbridge.msdk.video.bt.module.b;

import android.content.Context;
import com.mbridge.msdk.videocommon.d.c;

public final class d extends b {

    /* renamed from: a  reason: collision with root package name */
    private h f12017a;

    /* renamed from: d  reason: collision with root package name */
    private c f12018d;

    /* renamed from: e  reason: collision with root package name */
    private String f12019e;

    /* renamed from: f  reason: collision with root package name */
    private String f12020f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12021g;

    /* renamed from: h  reason: collision with root package name */
    private Context f12022h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12023i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12024j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f12025k = false;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004c A[Catch:{ Exception -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0052 A[Catch:{ Exception -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d(android.content.Context r4, boolean r5, com.mbridge.msdk.videocommon.d.c r6, com.mbridge.msdk.foundation.entity.CampaignEx r7, com.mbridge.msdk.video.bt.module.b.h r8, java.lang.String r9, java.lang.String r10) {
        /*
            r3 = this;
            r3.<init>()
            r0 = 0
            r3.f12023i = r0
            r3.f12024j = r0
            r3.f12025k = r0
            r3.f12017a = r8
            r3.f12018d = r6
            r3.f12019e = r10
            r3.f12020f = r9
            r3.f12021g = r5
            r3.f12022h = r4
            com.mbridge.msdk.foundation.controller.c r4 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0070 }
            java.lang.String r4 = r4.k()     // Catch:{ Exception -> 0x0070 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0070 }
            r8 = 0
            if (r5 != 0) goto L_0x0041
            com.mbridge.msdk.c.h r5 = com.mbridge.msdk.c.h.a()     // Catch:{ Exception -> 0x0070 }
            com.mbridge.msdk.c.g r4 = r5.b(r4)     // Catch:{ Exception -> 0x0070 }
            if (r4 != 0) goto L_0x0037
            com.mbridge.msdk.c.h.a()     // Catch:{ Exception -> 0x0070 }
            com.mbridge.msdk.c.g r4 = com.mbridge.msdk.c.i.a()     // Catch:{ Exception -> 0x0070 }
        L_0x0037:
            if (r4 == 0) goto L_0x0041
            long r4 = r4.ad()     // Catch:{ Exception -> 0x0070 }
            r1 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r1
            goto L_0x0042
        L_0x0041:
            r4 = r8
        L_0x0042:
            com.mbridge.msdk.videocommon.d.b r10 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x0070 }
            com.mbridge.msdk.videocommon.d.a r10 = r10.b()     // Catch:{ Exception -> 0x0070 }
            if (r10 == 0) goto L_0x0050
            long r8 = r10.f()     // Catch:{ Exception -> 0x0070 }
        L_0x0050:
            if (r7 == 0) goto L_0x0070
            boolean r4 = r7.isSpareOffer(r8, r4)     // Catch:{ Exception -> 0x0070 }
            if (r4 == 0) goto L_0x006a
            r4 = 1
            r7.setSpareOfferFlag(r4)     // Catch:{ Exception -> 0x0070 }
            int r5 = r6.y()     // Catch:{ Exception -> 0x0070 }
            if (r5 != r4) goto L_0x0066
            r7.setCbt(r4)     // Catch:{ Exception -> 0x0070 }
            return
        L_0x0066:
            r7.setCbt(r0)     // Catch:{ Exception -> 0x0070 }
            return
        L_0x006a:
            r7.setSpareOfferFlag(r0)     // Catch:{ Exception -> 0x0070 }
            r7.setCbt(r0)     // Catch:{ Exception -> 0x0070 }
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.b.d.<init>(android.content.Context, boolean, com.mbridge.msdk.videocommon.d.c, com.mbridge.msdk.foundation.entity.CampaignEx, com.mbridge.msdk.video.bt.module.b.h, java.lang.String, java.lang.String):void");
    }

    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar) {
        super.a(cVar);
        h hVar = this.f12017a;
        if (hVar != null && !this.f12023i) {
            this.f12023i = true;
            this.f12013b = true;
            hVar.a(cVar);
            this.f12017a.a(2, this.f12020f, this.f12019e);
        }
    }

    public final void b(String str, String str2) {
        super.b(str, str2);
        h hVar = this.f12017a;
        if (hVar != null) {
            hVar.b(str, str2);
            this.f12017a.a(6, str, str2);
        }
    }

    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, boolean z4, com.mbridge.msdk.videocommon.b.c cVar2) {
        super.a(cVar, z4, cVar2);
        h hVar = this.f12017a;
        if (hVar != null && !this.f12025k) {
            this.f12025k = true;
            hVar.a(7, this.f12020f, this.f12019e);
            this.f12017a.a(cVar, z4, cVar2);
        }
    }

    public final void a(boolean z4, int i5) {
        super.a(z4, i5);
        h hVar = this.f12017a;
        if (hVar != null && !this.f12025k) {
            hVar.a(z4, i5);
        }
    }

    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, String str) {
        super.a(cVar, str);
        h hVar = this.f12017a;
        if (hVar != null && !this.f12024j) {
            this.f12024j = true;
            this.f12014c = true;
            hVar.a(cVar, str);
            this.f12017a.a(4, this.f12020f, this.f12019e);
        }
    }

    public final void a(boolean z4, String str, String str2) {
        super.a(z4, str, str2);
        h hVar = this.f12017a;
        if (hVar != null) {
            hVar.a(z4, str, str2);
        }
    }

    public final void a(String str, String str2) {
        super.a(str, str2);
        h hVar = this.f12017a;
        if (hVar != null) {
            hVar.a(str, str2);
            this.f12017a.a(5, str, str2);
        }
    }
}
