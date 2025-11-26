package com.mbridge.msdk.newreward.a.b;

import android.os.SystemClock;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.foundation.same.net.e.d;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.c.b.f;
import com.mbridge.msdk.newreward.function.c.b.i;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeTaskManager;
import java.io.IOException;
import java.util.Map;

public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private final e f10340a;

    private static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.c.a.b f10341a;

        /* renamed from: b  reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.c.b.b f10342b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f10343c;

        /* renamed from: d  reason: collision with root package name */
        private final int f10344d;

        /* renamed from: e  reason: collision with root package name */
        private final b f10345e;

        /* renamed from: f  reason: collision with root package name */
        private final String f10346f;

        public a(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.b.b bVar2, boolean z4, int i5, b bVar3, String str) {
            this.f10341a = bVar;
            this.f10342b = bVar2;
            this.f10343c = z4;
            this.f10344d = i5;
            this.f10345e = bVar3;
            this.f10346f = str;
        }

        /* JADX WARNING: Removed duplicated region for block: B:41:0x00ba A[Catch:{ Exception -> 0x003d }] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00c3 A[Catch:{ Exception -> 0x003d }] */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00d1  */
        /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private com.mbridge.msdk.foundation.c.b a(int r11) {
            /*
                r10 = this;
                java.lang.String r0 = "load exception with no mCampaignRequestError"
                r1 = 0
                r2 = 0
                r3 = 880002(0xd6d82, float:1.233145E-39)
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f10342b     // Catch:{ Exception -> 0x003d }
                if (r4 == 0) goto L_0x00cf
                int r4 = r4.c()     // Catch:{ Exception -> 0x003d }
                r5 = 9
                r6 = 880003(0xd6d83, float:1.233147E-39)
                java.lang.String r7 = ""
                if (r4 != r5) goto L_0x0040
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f10342b     // Catch:{ Exception -> 0x003d }
                int r2 = r4.a()     // Catch:{ Exception -> 0x003d }
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f10342b     // Catch:{ Exception -> 0x003d }
                java.lang.String r0 = r4.b()     // Catch:{ Exception -> 0x003d }
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f10342b     // Catch:{ Exception -> 0x003d }
                int r3 = r4.c()     // Catch:{ Exception -> 0x003d }
                r4 = -1
                if (r3 != r4) goto L_0x0031
                r3 = 880017(0xd6d91, float:1.233166E-39)
                goto L_0x0032
            L_0x0031:
                r3 = r6
            L_0x0032:
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f10342b     // Catch:{ Exception -> 0x003d }
                java.lang.String r4 = r4.f()     // Catch:{ Exception -> 0x003d }
                r5 = 1
                r9 = r7
                r7 = r4
            L_0x003b:
                r4 = r9
                goto L_0x0092
            L_0x003d:
                r11 = move-exception
                goto L_0x00cc
            L_0x0040:
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f10342b     // Catch:{ Exception -> 0x003d }
                int r4 = r4.c()     // Catch:{ Exception -> 0x003d }
                r5 = 10
                if (r4 != r5) goto L_0x005c
                r4 = 880023(0xd6d97, float:1.233175E-39)
                com.mbridge.msdk.newreward.function.c.b.b r5 = r10.f10342b     // Catch:{ Exception -> 0x0058 }
                java.lang.String r0 = r5.d()     // Catch:{ Exception -> 0x0058 }
                r5 = r2
                r2 = r4
                r3 = r2
            L_0x0056:
                r4 = r7
                goto L_0x0092
            L_0x0058:
                r11 = move-exception
                r2 = r4
                goto L_0x00cc
            L_0x005c:
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f10342b     // Catch:{ Exception -> 0x003d }
                int r4 = r4.c()     // Catch:{ Exception -> 0x003d }
                switch(r4) {
                    case 1: goto L_0x006a;
                    case 2: goto L_0x0069;
                    case 3: goto L_0x006a;
                    case 4: goto L_0x006a;
                    case 5: goto L_0x006a;
                    case 6: goto L_0x0065;
                    case 7: goto L_0x0069;
                    case 8: goto L_0x006a;
                    default: goto L_0x0065;
                }     // Catch:{ Exception -> 0x003d }
            L_0x0065:
                r3 = 880020(0xd6d94, float:1.23317E-39)
                goto L_0x006a
            L_0x0069:
                r3 = r6
            L_0x006a:
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f10342b     // Catch:{ Exception -> 0x003d }
                com.mbridge.msdk.tracker.network.ad r4 = r4.e()     // Catch:{ Exception -> 0x003d }
                if (r4 == 0) goto L_0x0090
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f10342b     // Catch:{ Exception -> 0x003d }
                com.mbridge.msdk.tracker.network.ad r4 = r4.e()     // Catch:{ Exception -> 0x003d }
                int r4 = r4.b()     // Catch:{ Exception -> 0x003d }
                com.mbridge.msdk.newreward.function.c.b.b r5 = r10.f10342b     // Catch:{ Exception -> 0x0058 }
                com.mbridge.msdk.tracker.network.ad r5 = r5.e()     // Catch:{ Exception -> 0x0058 }
                java.lang.String r0 = r5.c()     // Catch:{ Exception -> 0x0058 }
                com.mbridge.msdk.newreward.function.c.b.b r5 = r10.f10342b     // Catch:{ Exception -> 0x0058 }
                java.lang.String r5 = r5.d()     // Catch:{ Exception -> 0x0058 }
                r9 = r5
                r5 = r2
                r2 = r4
                goto L_0x003b
            L_0x0090:
                r5 = r2
                goto L_0x0056
            L_0x0092:
                com.mbridge.msdk.foundation.c.b r1 = com.mbridge.msdk.foundation.c.a.a(r2, r3, r0)     // Catch:{ Exception -> 0x003d }
                java.lang.String r6 = "can_retry"
                boolean r8 = r10.f10343c     // Catch:{ Exception -> 0x003d }
                java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ Exception -> 0x003d }
                r1.a(r6, r8)     // Catch:{ Exception -> 0x003d }
                java.lang.String r6 = "campaign_request_error_type"
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x003d }
                r1.a(r6, r11)     // Catch:{ Exception -> 0x003d }
                java.lang.String r11 = "campaign_request_error"
                com.mbridge.msdk.newreward.function.c.b.b r6 = r10.f10342b     // Catch:{ Exception -> 0x003d }
                r1.a(r11, r6)     // Catch:{ Exception -> 0x003d }
                r1.b((boolean) r5)     // Catch:{ Exception -> 0x003d }
                boolean r11 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x003d }
                if (r11 != 0) goto L_0x00bd
                r1.e(r7)     // Catch:{ Exception -> 0x003d }
            L_0x00bd:
                boolean r11 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x003d }
                if (r11 != 0) goto L_0x00c6
                r1.f(r4)     // Catch:{ Exception -> 0x003d }
            L_0x00c6:
                java.lang.String r11 = r10.f10346f     // Catch:{ Exception -> 0x003d }
                r1.d(r11)     // Catch:{ Exception -> 0x003d }
                goto L_0x00cf
            L_0x00cc:
                r11.printStackTrace()
            L_0x00cf:
                if (r1 != 0) goto L_0x00d5
                com.mbridge.msdk.foundation.c.b r1 = com.mbridge.msdk.foundation.c.a.a(r2, r3, r0)
            L_0x00d5:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.a.b.c.a.a(int):com.mbridge.msdk.foundation.c.b");
        }

        public final void run() {
            b bVar = this.f10345e;
            if (bVar != null && this.f10342b != null) {
                try {
                    bVar.reqFailed(a(this.f10344d));
                } catch (Exception e5) {
                    af.b("ReqCampaignService", "run: ", e5);
                }
            }
        }
    }

    private static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.c.a.b f10347a;

        /* renamed from: b  reason: collision with root package name */
        private final b f10348b;

        public b(com.mbridge.msdk.newreward.function.c.a.b bVar, b bVar2) {
            this.f10347a = bVar;
            this.f10348b = bVar2;
        }

        public final void run() {
            com.mbridge.msdk.newreward.function.c.a.b bVar;
            b bVar2 = this.f10348b;
            if (bVar2 != null && (bVar = this.f10347a) != null) {
                try {
                    bVar2.reqSuccessful(bVar);
                } catch (Exception e5) {
                    af.b("ReqCampaignService", "run: ", e5);
                }
            }
        }
    }

    /* renamed from: com.mbridge.msdk.newreward.a.b.c$c  reason: collision with other inner class name */
    private static class C0097c implements com.mbridge.msdk.newreward.function.c.b.c {

        /* renamed from: a  reason: collision with root package name */
        private final b f10349a;

        public C0097c(b bVar) {
            this.f10349a = bVar;
        }

        public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar) {
            MBridgeTaskManager.commonExecute(new b(bVar, this.f10349a));
        }

        public final void b(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar, com.mbridge.msdk.newreward.function.c.b.b bVar2) {
            MBridgeTaskManager.commonExecute(new a(bVar, bVar2, true, 401, this.f10349a, aVar.k()));
        }

        public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar, com.mbridge.msdk.newreward.function.c.b.b bVar2) {
            MBridgeTaskManager.commonExecute(new a(bVar, bVar2, false, 402, this.f10349a, aVar.k()));
        }

        public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar, long j5, com.mbridge.msdk.newreward.function.c.b.b bVar2) {
            MBridgeTaskManager.commonExecute(new a(bVar, bVar2, false, MBridgeCommon.CampaignState.STATE_LOAD_FAILED_TIMEOUT, this.f10349a, aVar.k()));
        }
    }

    public c(e eVar) {
        this.f10340a = eVar;
    }

    public final void a(Object obj, b bVar) throws IOException {
        int i5;
        int d5;
        if (obj != null) {
            try {
                long p5 = this.f10340a.p();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (p5 <= 0) {
                    this.f10340a.c(elapsedRealtime);
                    p5 = elapsedRealtime;
                }
                com.mbridge.msdk.newreward.function.f.e eVar = (com.mbridge.msdk.newreward.function.f.e) obj;
                int b5 = eVar.b();
                String c5 = eVar.c();
                String d6 = eVar.d();
                String e5 = eVar.e();
                Map<String, String> f5 = eVar.f();
                i iVar = new i(b5, c5, d6, Math.max(((long) this.f10340a.P()) - (elapsedRealtime - p5), 0), e5);
                iVar.a(f5);
                iVar.b(this.f10340a.G());
                iVar.a((com.mbridge.msdk.newreward.function.c.b.c) new C0097c(bVar));
                byte[] p6 = iVar.p();
                if (p6 != null) {
                    i5 = p6.length;
                } else {
                    i5 = 0;
                }
                iVar.a(com.mbridge.msdk.foundation.same.net.f.e.f9401h, String.valueOf(i5));
                if (p6 != null && (d5 = d.f().d()) > 0 && i5 > d5) {
                    iVar.a(1);
                    iVar.b("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
                }
                f.a().a((com.mbridge.msdk.newreward.function.c.b.a) iVar);
            } catch (Exception e6) {
                throw new IOException(e6);
            }
        } else {
            throw new IOException("ReqCampaignService doReq: params is null");
        }
    }
}
