package com.mbridge.msdk.newreward.function.c.c;

import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;

public final class w extends q {

    /* renamed from: a  reason: collision with root package name */
    private final b f10657a;

    /* renamed from: b  reason: collision with root package name */
    private final a f10658b;

    /* renamed from: c  reason: collision with root package name */
    private final l f10659c;

    public w(b bVar, a aVar, l lVar) {
        this.f10657a = bVar;
        this.f10658b = aVar;
        this.f10659c = lVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0091 A[SYNTHETIC, Splitter:B:22:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009b A[SYNTHETIC, Splitter:B:29:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00aa A[SYNTHETIC, Splitter:B:35:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r5, com.mbridge.msdk.newreward.function.c.c.x r6) {
        /*
            r4 = this;
            com.mbridge.msdk.newreward.function.c.a.a r5 = r4.f10658b
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = r5.h()
            java.lang.String r0 = r5.getMraid()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0021
            if (r6 == 0) goto L_0x00a7
            com.mbridge.msdk.newreward.function.c.a.b r5 = r4.f10657a
            com.mbridge.msdk.newreward.function.c.a.a r0 = r4.f10658b
            r6.a(r5, r0, r4)
            com.mbridge.msdk.newreward.function.c.a.b r5 = r4.f10657a
            com.mbridge.msdk.newreward.function.c.a.a r0 = r4.f10658b
            r6.b(r5, r0, r4)
            return
        L_0x0021:
            com.mbridge.msdk.foundation.same.b.c r0 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML
            java.lang.String r0 = com.mbridge.msdk.foundation.same.b.e.a((com.mbridge.msdk.foundation.same.b.c) r0)
            java.lang.String r1 = r5.getMraid()
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r1)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x003d
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.String r1 = java.lang.String.valueOf(r1)
        L_0x003d:
            java.lang.String r2 = ".html"
            java.lang.String r1 = r1.concat(r2)
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x008f }
            r3.<init>(r0, r1)     // Catch:{ Exception -> 0x008f }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x008f }
            r0.<init>(r3)     // Catch:{ Exception -> 0x008f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            r1.<init>()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            java.lang.String r2 = "<script>"
            r1.append(r2)     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            com.mbridge.msdk.c.b.a r2 = com.mbridge.msdk.c.b.a.a()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            java.lang.String r2 = r2.b()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            r1.append(r2)     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            java.lang.String r2 = "</script>"
            r1.append(r2)     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            java.lang.String r2 = r5.getMraid()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            r1.append(r2)     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            byte[] r1 = r1.getBytes()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            r0.write(r1)     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            r0.flush()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            java.lang.String r1 = r3.getAbsolutePath()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            r5.setMraid(r1)     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            r0.close()     // Catch:{ Exception -> 0x009e }
            goto L_0x009e
        L_0x0088:
            r5 = move-exception
            r2 = r0
            goto L_0x00a8
        L_0x008b:
            r2 = r0
            goto L_0x008f
        L_0x008d:
            r5 = move-exception
            goto L_0x00a8
        L_0x008f:
            if (r2 == 0) goto L_0x0094
            r2.close()     // Catch:{ IOException -> 0x0094 }
        L_0x0094:
            java.lang.String r0 = ""
            r5.setMraid(r0)     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x009e
            r2.close()     // Catch:{ Exception -> 0x009e }
        L_0x009e:
            if (r6 == 0) goto L_0x00a7
            com.mbridge.msdk.newreward.function.c.a.b r5 = r4.f10657a
            com.mbridge.msdk.newreward.function.c.a.a r0 = r4.f10658b
            r6.b(r5, r0, r4)
        L_0x00a7:
            return
        L_0x00a8:
            if (r2 == 0) goto L_0x00ad
            r2.close()     // Catch:{ Exception -> 0x00ad }
        L_0x00ad:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.c.c.w.a(int, com.mbridge.msdk.newreward.function.c.c.x):void");
    }
}
