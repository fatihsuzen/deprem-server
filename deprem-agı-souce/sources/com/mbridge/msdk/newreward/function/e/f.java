package com.mbridge.msdk.newreward.function.e;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.net.e.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.videocommon.d.a;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private String f10967a = c.m().k();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f10968b;

    /* renamed from: c  reason: collision with root package name */
    private int f10969c;

    /* renamed from: d  reason: collision with root package name */
    private g f10970d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f10971e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public com.mbridge.msdk.videocommon.d.c f10972f;

    public final com.mbridge.msdk.videocommon.d.c b() {
        return this.f10972f;
    }

    public final a a() {
        return this.f10971e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0097, code lost:
        if ((r8.f10971e.i() + r10.d()) <= java.lang.System.currentTimeMillis()) goto L_0x0099;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0054 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058 A[Catch:{ all -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c A[Catch:{ all -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Object r9, com.mbridge.msdk.newreward.a.b.b r10) {
        /*
            r8 = this;
            java.lang.String r0 = "SettingModel"
            java.lang.String r1 = r8.f10968b     // Catch:{ all -> 0x0018 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0020
            boolean r1 = r9 instanceof com.mbridge.msdk.newreward.function.f.d     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0020
            r1 = r9
            com.mbridge.msdk.newreward.function.f.d r1 = (com.mbridge.msdk.newreward.function.f.d) r1     // Catch:{ all -> 0x0018 }
            java.lang.String r1 = r1.b()     // Catch:{ all -> 0x0018 }
            r8.f10968b = r1     // Catch:{ all -> 0x0018 }
            goto L_0x0020
        L_0x0018:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r1)
        L_0x0020:
            com.mbridge.msdk.c.h r1 = com.mbridge.msdk.c.h.a()     // Catch:{ all -> 0x0043 }
            java.lang.String r2 = r8.f10967a     // Catch:{ all -> 0x0043 }
            com.mbridge.msdk.c.g r1 = r1.a(r2)     // Catch:{ all -> 0x0043 }
            r8.f10970d = r1     // Catch:{ all -> 0x0043 }
            com.mbridge.msdk.videocommon.d.b r1 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ all -> 0x0043 }
            com.mbridge.msdk.videocommon.d.a r1 = r1.e()     // Catch:{ all -> 0x0043 }
            r8.f10971e = r1     // Catch:{ all -> 0x0043 }
            if (r1 != 0) goto L_0x0046
            com.mbridge.msdk.videocommon.d.b r1 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ all -> 0x0043 }
            com.mbridge.msdk.videocommon.d.a r1 = r1.c()     // Catch:{ all -> 0x0043 }
            r8.f10971e = r1     // Catch:{ all -> 0x0043 }
            goto L_0x0046
        L_0x0043:
            r9 = move-exception
            goto L_0x00ed
        L_0x0046:
            com.mbridge.msdk.videocommon.d.b r1 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x0054 }
            java.lang.String r2 = r8.f10967a     // Catch:{ Exception -> 0x0054 }
            java.lang.String r3 = r8.f10968b     // Catch:{ Exception -> 0x0054 }
            com.mbridge.msdk.videocommon.d.c r1 = r1.f(r2, r3)     // Catch:{ Exception -> 0x0054 }
            r8.f10972f = r1     // Catch:{ Exception -> 0x0054 }
        L_0x0054:
            com.mbridge.msdk.videocommon.d.c r1 = r8.f10972f     // Catch:{ all -> 0x0043 }
            if (r1 != 0) goto L_0x006c
            com.mbridge.msdk.videocommon.d.b r1 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ all -> 0x0043 }
            int r2 = r8.f10969c     // Catch:{ all -> 0x0043 }
            r3 = 287(0x11f, float:4.02E-43)
            if (r2 != r3) goto L_0x0064
            r2 = 1
            goto L_0x0065
        L_0x0064:
            r2 = 0
        L_0x0065:
            com.mbridge.msdk.videocommon.d.c r1 = r1.b((boolean) r2)     // Catch:{ all -> 0x0043 }
            r8.f10972f = r1     // Catch:{ all -> 0x0043 }
            goto L_0x0077
        L_0x006c:
            com.mbridge.msdk.videocommon.d.b r1 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ all -> 0x0043 }
            java.lang.String r2 = r8.f10968b     // Catch:{ all -> 0x0043 }
            java.lang.String r3 = com.mbridge.msdk.videocommon.d.c.f13043a     // Catch:{ all -> 0x0043 }
            r1.b(r2, r3)     // Catch:{ all -> 0x0043 }
        L_0x0077:
            r10.reqSuccessful(r8)
            boolean r10 = r9 instanceof com.mbridge.msdk.newreward.function.f.d
            if (r10 == 0) goto L_0x00ec
            com.mbridge.msdk.newreward.function.f.d r9 = (com.mbridge.msdk.newreward.function.f.d) r9
            com.mbridge.msdk.videocommon.d.a r10 = r8.f10971e
            java.lang.String r1 = ""
            if (r10 == 0) goto L_0x0099
            long r2 = r10.d()
            long r4 = java.lang.System.currentTimeMillis()
            com.mbridge.msdk.videocommon.d.a r10 = r8.f10971e
            long r6 = r10.i()
            long r6 = r6 + r2
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 > 0) goto L_0x00b5
        L_0x0099:
            com.mbridge.msdk.newreward.a.b.l r10 = new com.mbridge.msdk.newreward.a.b.l     // Catch:{ IOException -> 0x00ad }
            r10.<init>()     // Catch:{ IOException -> 0x00ad }
            com.mbridge.msdk.newreward.function.e.f$1 r2 = new com.mbridge.msdk.newreward.function.e.f$1     // Catch:{ IOException -> 0x00ad }
            r2.<init>()     // Catch:{ IOException -> 0x00ad }
            r10.a(r9, r2)     // Catch:{ IOException -> 0x00ad }
            com.mbridge.msdk.newreward.function.command.f r10 = com.mbridge.msdk.newreward.function.command.f.REPORT_SETTING_REQUEST_START     // Catch:{ IOException -> 0x00ad }
            r2 = 2
            r8.a(r10, r2, r1)     // Catch:{ IOException -> 0x00ad }
            goto L_0x00b5
        L_0x00ad:
            r10 = move-exception
            java.lang.String r10 = r10.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r10)
        L_0x00b5:
            com.mbridge.msdk.videocommon.d.a r10 = r8.f10971e
            if (r10 == 0) goto L_0x00d0
            com.mbridge.msdk.videocommon.d.c r2 = r8.f10972f
            if (r2 == 0) goto L_0x00d0
            long r2 = r10.e()
            long r4 = java.lang.System.currentTimeMillis()
            com.mbridge.msdk.videocommon.d.c r10 = r8.f10972f
            long r6 = r10.x()
            long r6 = r6 + r2
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 > 0) goto L_0x00ec
        L_0x00d0:
            com.mbridge.msdk.newreward.a.b.m r10 = new com.mbridge.msdk.newreward.a.b.m     // Catch:{ IOException -> 0x00e4 }
            r10.<init>()     // Catch:{ IOException -> 0x00e4 }
            com.mbridge.msdk.newreward.function.e.f$2 r2 = new com.mbridge.msdk.newreward.function.e.f$2     // Catch:{ IOException -> 0x00e4 }
            r2.<init>()     // Catch:{ IOException -> 0x00e4 }
            r10.a(r9, r2)     // Catch:{ IOException -> 0x00e4 }
            com.mbridge.msdk.newreward.function.command.f r9 = com.mbridge.msdk.newreward.function.command.f.REPORT_SETTING_REQUEST_START     // Catch:{ IOException -> 0x00e4 }
            r10 = 3
            r8.a(r9, r10, r1)     // Catch:{ IOException -> 0x00e4 }
            goto L_0x00ec
        L_0x00e4:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r9)
        L_0x00ec:
            return
        L_0x00ed:
            com.mbridge.msdk.foundation.c.b r0 = new com.mbridge.msdk.foundation.c.b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "fetch setting fail : "
            r1.append(r2)
            java.lang.String r9 = r9.getMessage()
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r1 = 880000(0xd6d80, float:1.233143E-39)
            r0.<init>(r1, r9)
            r10.reqFailed(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.e.f.a(java.lang.Object, com.mbridge.msdk.newreward.a.b.b):void");
    }

    /* access modifiers changed from: private */
    public void a(com.mbridge.msdk.newreward.function.command.f fVar, int i5, String str) {
        int i6;
        try {
            com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
            e eVar = new e();
            eVar.a("key", "2000112");
            eVar.a("st_net", Integer.valueOf(d.f().f9384s));
            if (fVar == com.mbridge.msdk.newreward.function.command.f.REPORT_SETTING_REQUEST_START) {
                i6 = 3;
            } else if (fVar == com.mbridge.msdk.newreward.function.command.f.REPORT_SETTING_REQUEST_SUCCESS) {
                i6 = 1;
            } else {
                i6 = fVar == com.mbridge.msdk.newreward.function.command.f.REPORT_SETTING_REQUEST_FAIL ? 2 : 0;
            }
            eVar.a("result", Integer.valueOf(i6));
            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(i5));
            eVar.a("url", d.f().f9383r ? d.f().f9349J : d.f().f9348I);
            eVar.a("reason", str);
            cVar.a("2000112", eVar);
            com.mbridge.msdk.foundation.same.report.d.d.a().a("2000112", cVar);
        } catch (Throwable th) {
            af.b("SettingModel", th.getMessage());
        }
    }
}
