package com.mbridge.msdk.newreward.function.e;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.videocommon.d.a;
import java.util.Map;

public final class c {

    /* renamed from: com.mbridge.msdk.newreward.function.e.c$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10953a;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mbridge.msdk.newreward.function.command.f[] r0 = com.mbridge.msdk.newreward.function.command.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10953a = r0
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_V3_START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10953a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_V3_RES_SUCCESS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10953a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_V3_RES_FAIL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f10953a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_V3_RETRY_START     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f10953a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_V3_RETRY_END     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f10953a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_V3_CAMPAIGN_SUCCESS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f10953a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_VIDEO_CAMPAIGN_SUCCESS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f10953a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_FAILED     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f10953a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_SHOW_START     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f10953a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_START     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f10953a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f10953a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.METRICS_KEY_M_CANDIDATE_DATE     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f10953a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.METRICS_KEY_M_CANDIDATE_DB     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f10953a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_CHECK     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f10953a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_IS_READY_CHECK     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f10953a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_SHOW_FAIL     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.e.c.AnonymousClass1.<clinit>():void");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x027a A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x029c A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x02bf A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02d0 A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02e1 A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02f2 A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0315 A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0066 A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00ab A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c1 A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c4 A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00cf A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e0 A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0114 A[SYNTHETIC, Splitter:B:37:0x0114] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x013d A[SYNTHETIC, Splitter:B:45:0x013d] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x014f A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x017c A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0192 A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01a8 A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01c7 A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01e6 A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x025a A[Catch:{ Exception -> 0x0050 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.mbridge.msdk.newreward.a.e r23, java.util.Map r24, com.mbridge.msdk.newreward.function.command.f r25) {
        /*
            r22 = this;
            r0 = r24
            java.lang.String r1 = "2000125"
            java.lang.String r2 = "m_v3_req_retry_start"
            java.lang.String r3 = "m_v3_req_retry_end"
            java.lang.String r4 = "2000127"
            java.lang.String r5 = "2000048"
            java.lang.String r6 = "2000047"
            java.lang.String r7 = "2000128"
            java.lang.String r8 = "m_download_start"
            java.lang.String r9 = "m_download_end"
            java.lang.String r10 = "m_candidate_data"
            java.lang.String r11 = "m_candidate_db"
            java.lang.String r12 = "campaign"
            java.lang.String r13 = "m_offer_ready"
            if (r23 != 0) goto L_0x0020
            goto L_0x0340
        L_0x0020:
            com.mbridge.msdk.newreward.function.e.a r14 = r23.D()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r15 = ""
            if (r14 == 0) goto L_0x0053
            com.mbridge.msdk.newreward.function.e.a r14 = r23.D()     // Catch:{ Exception -> 0x0050 }
            com.mbridge.msdk.newreward.function.c.a.b r14 = r14.b()     // Catch:{ Exception -> 0x0050 }
            if (r14 == 0) goto L_0x0053
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0050 }
            r14.<init>()     // Catch:{ Exception -> 0x0050 }
            com.mbridge.msdk.newreward.function.e.a r16 = r23.D()     // Catch:{ Exception -> 0x0050 }
            com.mbridge.msdk.newreward.function.c.a.b r16 = r16.b()     // Catch:{ Exception -> 0x0050 }
            r17 = r1
            int r1 = r16.a()     // Catch:{ Exception -> 0x0050 }
            r14.append(r1)     // Catch:{ Exception -> 0x0050 }
            r14.append(r15)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r1 = r14.toString()     // Catch:{ Exception -> 0x0050 }
            goto L_0x0056
        L_0x0050:
            r0 = move-exception
            goto L_0x0339
        L_0x0053:
            r17 = r1
            r1 = r15
        L_0x0056:
            com.mbridge.msdk.foundation.same.report.d.d r14 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0050 }
            r16 = r2
            java.lang.String r2 = r23.G()     // Catch:{ Exception -> 0x0050 }
            com.mbridge.msdk.foundation.same.report.d.c r2 = r14.a((java.lang.String) r2, (java.lang.String) r1)     // Catch:{ Exception -> 0x0050 }
            if (r2 != 0) goto L_0x00ab
            com.mbridge.msdk.foundation.same.report.d.d r2 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r14 = r23.G()     // Catch:{ Exception -> 0x0050 }
            com.mbridge.msdk.foundation.same.report.d.c r2 = r2.a((java.lang.String) r14, (java.lang.String) r15)     // Catch:{ Exception -> 0x0050 }
            if (r2 == 0) goto L_0x0095
            com.mbridge.msdk.foundation.same.report.d.d r14 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0050 }
            java.util.LinkedHashMap r14 = r14.b()     // Catch:{ Exception -> 0x0050 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0050 }
            r15.<init>()     // Catch:{ Exception -> 0x0050 }
            r18 = r3
            java.lang.String r3 = r23.G()     // Catch:{ Exception -> 0x0050 }
            r15.append(r3)     // Catch:{ Exception -> 0x0050 }
            r15.append(r1)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r1 = r15.toString()     // Catch:{ Exception -> 0x0050 }
            r14.put(r1, r2)     // Catch:{ Exception -> 0x0050 }
            goto L_0x00ad
        L_0x0095:
            r18 = r3
            com.mbridge.msdk.foundation.same.report.d.c r2 = new com.mbridge.msdk.foundation.same.report.d.c     // Catch:{ Exception -> 0x0050 }
            r2.<init>()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r1 = r23.G()     // Catch:{ Exception -> 0x0050 }
            r2.c((java.lang.String) r1)     // Catch:{ Exception -> 0x0050 }
            int r1 = r23.h()     // Catch:{ Exception -> 0x0050 }
            r2.b((int) r1)     // Catch:{ Exception -> 0x0050 }
            goto L_0x00ad
        L_0x00ab:
            r18 = r3
        L_0x00ad:
            java.lang.String r1 = r23.H()     // Catch:{ Exception -> 0x0050 }
            r2.d((java.lang.String) r1)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r1 = r23.J()     // Catch:{ Exception -> 0x0050 }
            r2.e((java.lang.String) r1)     // Catch:{ Exception -> 0x0050 }
            boolean r1 = r23.R()     // Catch:{ Exception -> 0x0050 }
            if (r1 == 0) goto L_0x00c4
            java.lang.String r1 = "1"
            goto L_0x00c6
        L_0x00c4:
            java.lang.String r1 = "0"
        L_0x00c6:
            r2.i(r1)     // Catch:{ Exception -> 0x0050 }
            com.mbridge.msdk.newreward.function.e.a r1 = r23.D()     // Catch:{ Exception -> 0x0050 }
            if (r1 == 0) goto L_0x00da
            com.mbridge.msdk.newreward.function.e.a r1 = r23.D()     // Catch:{ Exception -> 0x0050 }
            java.util.List r1 = r1.a()     // Catch:{ Exception -> 0x0050 }
            r2.b((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r1)     // Catch:{ Exception -> 0x0050 }
        L_0x00da:
            com.mbridge.msdk.newreward.function.e.f r1 = r23.x()     // Catch:{ Exception -> 0x0050 }
            if (r1 == 0) goto L_0x0110
            com.mbridge.msdk.newreward.function.e.f r1 = r23.x()     // Catch:{ Exception -> 0x0050 }
            com.mbridge.msdk.videocommon.d.a r1 = r1.a()     // Catch:{ Exception -> 0x0050 }
            if (r1 == 0) goto L_0x00f8
            java.lang.String r3 = r1.b()     // Catch:{ Exception -> 0x0050 }
            r2.h(r3)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r1 = r1.c()     // Catch:{ Exception -> 0x0050 }
            r2.f((java.lang.String) r1)     // Catch:{ Exception -> 0x0050 }
        L_0x00f8:
            com.mbridge.msdk.newreward.function.e.f r1 = r23.x()     // Catch:{ Exception -> 0x0050 }
            com.mbridge.msdk.videocommon.d.c r1 = r1.b()     // Catch:{ Exception -> 0x0050 }
            if (r1 == 0) goto L_0x0110
            java.lang.String r3 = r1.l()     // Catch:{ Exception -> 0x0050 }
            r2.g((java.lang.String) r3)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r1 = r1.k()     // Catch:{ Exception -> 0x0050 }
            r2.n(r1)     // Catch:{ Exception -> 0x0050 }
        L_0x0110:
            java.lang.String r3 = "metrics_data"
            if (r0 == 0) goto L_0x0125
            boolean r14 = r0.containsKey(r3)     // Catch:{ Exception -> 0x0050 }
            if (r14 == 0) goto L_0x0125
            java.lang.Object r14 = r0.get(r3)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r15 = "resource_type"
            java.lang.Object r15 = r0.get(r15)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0127
        L_0x0125:
            r14 = 0
            r15 = 0
        L_0x0127:
            int[] r19 = com.mbridge.msdk.newreward.function.e.c.AnonymousClass1.f10953a     // Catch:{ Exception -> 0x0050 }
            int r20 = r25.ordinal()     // Catch:{ Exception -> 0x0050 }
            r19 = r19[r20]     // Catch:{ Exception -> 0x0050 }
            java.lang.String r1 = "m_load_check"
            r21 = r4
            java.lang.String r4 = "2000126"
            r25 = r4
            r4 = 0
            switch(r19) {
                case 1: goto L_0x0315;
                case 2: goto L_0x02f2;
                case 3: goto L_0x02e1;
                case 4: goto L_0x02d0;
                case 5: goto L_0x02bf;
                case 6: goto L_0x029c;
                case 7: goto L_0x027a;
                case 8: goto L_0x025a;
                case 9: goto L_0x01e6;
                case 10: goto L_0x01c7;
                case 11: goto L_0x01a8;
                case 12: goto L_0x0192;
                case 13: goto L_0x017c;
                case 14: goto L_0x014f;
                case 15: goto L_0x013d;
                default: goto L_0x013b;
            }
        L_0x013b:
            goto L_0x0325
        L_0x013d:
            r2.a((java.lang.String) r13)     // Catch:{ Exception -> 0x0050 }
            com.mbridge.msdk.foundation.same.report.d.e r1 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x0050 }
            r1.<init>()     // Catch:{ Exception -> 0x0050 }
            if (r0 == 0) goto L_0x014a
            r1.a((java.util.Map) r0)     // Catch:{ Exception -> 0x0050 }
        L_0x014a:
            r2.a(r13, r1)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0325
        L_0x014f:
            r2.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0050 }
            if (r0 == 0) goto L_0x0161
            boolean r3 = r0.containsKey(r12)     // Catch:{ Exception -> 0x0050 }
            if (r3 == 0) goto L_0x0161
            java.lang.Object r3 = r0.remove(r12)     // Catch:{ Exception -> 0x0050 }
            com.mbridge.msdk.newreward.function.c.a.b r3 = (com.mbridge.msdk.newreward.function.c.a.b) r3     // Catch:{ Exception -> 0x0050 }
            goto L_0x0162
        L_0x0161:
            r3 = 0
        L_0x0162:
            if (r3 == 0) goto L_0x016d
            java.util.List r3 = r3.E()     // Catch:{ Exception -> 0x0050 }
            if (r3 == 0) goto L_0x016d
            r2.b((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)     // Catch:{ Exception -> 0x0050 }
        L_0x016d:
            com.mbridge.msdk.foundation.same.report.d.e r3 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x0050 }
            r3.<init>()     // Catch:{ Exception -> 0x0050 }
            if (r0 == 0) goto L_0x0177
            r3.a((java.util.Map) r0)     // Catch:{ Exception -> 0x0050 }
        L_0x0177:
            r2.a(r1, r3)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0325
        L_0x017c:
            r2.a((java.lang.String) r11)     // Catch:{ Exception -> 0x0050 }
            if (r0 == 0) goto L_0x0186
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x0050 }
            goto L_0x018b
        L_0x0186:
            com.mbridge.msdk.foundation.same.report.d.e r0 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x0050 }
            r0.<init>()     // Catch:{ Exception -> 0x0050 }
        L_0x018b:
            com.mbridge.msdk.foundation.same.report.d.e r0 = (com.mbridge.msdk.foundation.same.report.d.e) r0     // Catch:{ Exception -> 0x0050 }
            r2.a(r11, r0)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0325
        L_0x0192:
            r2.a((java.lang.String) r10)     // Catch:{ Exception -> 0x0050 }
            if (r0 == 0) goto L_0x019c
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x0050 }
            goto L_0x01a1
        L_0x019c:
            com.mbridge.msdk.foundation.same.report.d.e r0 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x0050 }
            r0.<init>()     // Catch:{ Exception -> 0x0050 }
        L_0x01a1:
            com.mbridge.msdk.foundation.same.report.d.e r0 = (com.mbridge.msdk.foundation.same.report.d.e) r0     // Catch:{ Exception -> 0x0050 }
            r2.a(r10, r0)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0325
        L_0x01a8:
            r2.a((java.lang.String) r9)     // Catch:{ Exception -> 0x0050 }
            com.mbridge.msdk.foundation.same.report.d.e r1 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x0050 }
            r1.<init>()     // Catch:{ Exception -> 0x0050 }
            r1.a((java.util.Map) r0)     // Catch:{ Exception -> 0x0050 }
            if (r0 == 0) goto L_0x01bf
            boolean r0 = r15 instanceof java.lang.Integer     // Catch:{ Exception -> 0x0050 }
            if (r0 == 0) goto L_0x01bf
            java.lang.Integer r15 = (java.lang.Integer) r15     // Catch:{ Exception -> 0x0050 }
            int r4 = r15.intValue()     // Catch:{ Exception -> 0x0050 }
        L_0x01bf:
            r2.a(r9, r1, r4)     // Catch:{ Exception -> 0x0050 }
            r2.a((int) r4)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0325
        L_0x01c7:
            r2.a((java.lang.String) r8)     // Catch:{ Exception -> 0x0050 }
            com.mbridge.msdk.foundation.same.report.d.e r1 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x0050 }
            r1.<init>()     // Catch:{ Exception -> 0x0050 }
            r1.a((java.util.Map) r0)     // Catch:{ Exception -> 0x0050 }
            if (r0 == 0) goto L_0x01de
            boolean r0 = r15 instanceof java.lang.Integer     // Catch:{ Exception -> 0x0050 }
            if (r0 == 0) goto L_0x01de
            java.lang.Integer r15 = (java.lang.Integer) r15     // Catch:{ Exception -> 0x0050 }
            int r4 = r15.intValue()     // Catch:{ Exception -> 0x0050 }
        L_0x01de:
            r2.a(r8, r1, r4)     // Catch:{ Exception -> 0x0050 }
            r2.a((int) r4)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0325
        L_0x01e6:
            com.mbridge.msdk.foundation.same.report.d.e r0 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x0050 }
            r0.<init>()     // Catch:{ Exception -> 0x0050 }
            com.mbridge.msdk.newreward.function.e.a r3 = r23.D()     // Catch:{ Exception -> 0x0050 }
            if (r3 == 0) goto L_0x022a
            com.mbridge.msdk.newreward.function.e.a r3 = r23.D()     // Catch:{ Exception -> 0x0050 }
            com.mbridge.msdk.newreward.function.c.a.b r3 = r3.b()     // Catch:{ Exception -> 0x0050 }
            if (r3 == 0) goto L_0x022a
            com.mbridge.msdk.newreward.function.e.a r3 = r23.D()     // Catch:{ Exception -> 0x0050 }
            com.mbridge.msdk.newreward.function.c.a.b r3 = r3.b()     // Catch:{ Exception -> 0x0050 }
            int r5 = r3.a()     // Catch:{ Exception -> 0x0050 }
            int r6 = r3.b()     // Catch:{ Exception -> 0x0050 }
            java.util.List r8 = r3.E()     // Catch:{ Exception -> 0x0050 }
            if (r8 == 0) goto L_0x022c
            java.util.List r8 = r3.E()     // Catch:{ Exception -> 0x0050 }
            boolean r8 = r8.isEmpty()     // Catch:{ Exception -> 0x0050 }
            if (r8 != 0) goto L_0x022c
            java.util.List r3 = r3.E()     // Catch:{ Exception -> 0x0050 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ Exception -> 0x0050 }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3     // Catch:{ Exception -> 0x0050 }
            int r4 = r3.getFilterCallBackState()     // Catch:{ Exception -> 0x0050 }
            goto L_0x022c
        L_0x022a:
            r5 = r4
            r6 = r5
        L_0x022c:
            boolean r3 = r23.d()     // Catch:{ Exception -> 0x0050 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0050 }
            r0.a(r1, r3)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r1 = "i_s_c_t"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0050 }
            r0.a(r1, r3)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r1 = "r_index"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0050 }
            r0.a(r1, r3)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r1 = "s_show_index"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0050 }
            r0.a(r1, r3)     // Catch:{ Exception -> 0x0050 }
            r2.a(r7, r0)     // Catch:{ Exception -> 0x0050 }
            r2.a((java.lang.String) r7)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0325
        L_0x025a:
            r2.a((java.lang.String) r6)     // Catch:{ Exception -> 0x0050 }
            if (r0 == 0) goto L_0x0262
            r0.remove(r3)     // Catch:{ Exception -> 0x0050 }
        L_0x0262:
            com.mbridge.msdk.foundation.same.report.d.e r1 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x0050 }
            r1.<init>()     // Catch:{ Exception -> 0x0050 }
            r1.a((java.util.Map) r0)     // Catch:{ Exception -> 0x0050 }
            r2.a(r6, r1)     // Catch:{ Exception -> 0x0050 }
            boolean r0 = r14 instanceof com.mbridge.msdk.foundation.c.b     // Catch:{ Exception -> 0x0050 }
            if (r0 == 0) goto L_0x0325
            com.mbridge.msdk.foundation.c.b r14 = (com.mbridge.msdk.foundation.c.b) r14     // Catch:{ Exception -> 0x0050 }
            if (r14 == 0) goto L_0x0325
            r2.a((com.mbridge.msdk.foundation.c.b) r14)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0325
        L_0x027a:
            r2.a((java.lang.String) r5)     // Catch:{ Exception -> 0x0050 }
            boolean r1 = r14 instanceof com.mbridge.msdk.newreward.function.c.a.b     // Catch:{ Exception -> 0x0050 }
            if (r1 == 0) goto L_0x028a
            com.mbridge.msdk.newreward.function.c.a.b r14 = (com.mbridge.msdk.newreward.function.c.a.b) r14     // Catch:{ Exception -> 0x0050 }
            java.util.List r1 = r14.E()     // Catch:{ Exception -> 0x0050 }
            r2.b((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r1)     // Catch:{ Exception -> 0x0050 }
        L_0x028a:
            if (r0 == 0) goto L_0x028f
            r0.remove(r3)     // Catch:{ Exception -> 0x0050 }
        L_0x028f:
            com.mbridge.msdk.foundation.same.report.d.e r1 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x0050 }
            r1.<init>()     // Catch:{ Exception -> 0x0050 }
            r1.a((java.util.Map) r0)     // Catch:{ Exception -> 0x0050 }
            r2.a(r5, r1)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0325
        L_0x029c:
            r1 = r21
            r2.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0050 }
            boolean r4 = r14 instanceof com.mbridge.msdk.newreward.function.c.a.b     // Catch:{ Exception -> 0x0050 }
            if (r4 == 0) goto L_0x02ae
            com.mbridge.msdk.newreward.function.c.a.b r14 = (com.mbridge.msdk.newreward.function.c.a.b) r14     // Catch:{ Exception -> 0x0050 }
            java.util.List r4 = r14.E()     // Catch:{ Exception -> 0x0050 }
            r2.b((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r4)     // Catch:{ Exception -> 0x0050 }
        L_0x02ae:
            if (r0 == 0) goto L_0x02b3
            r0.remove(r3)     // Catch:{ Exception -> 0x0050 }
        L_0x02b3:
            com.mbridge.msdk.foundation.same.report.d.e r3 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x0050 }
            r3.<init>()     // Catch:{ Exception -> 0x0050 }
            r3.a((java.util.Map) r0)     // Catch:{ Exception -> 0x0050 }
            r2.a(r1, r3)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0325
        L_0x02bf:
            r1 = r18
            r2.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0050 }
            com.mbridge.msdk.foundation.same.report.d.e r3 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x0050 }
            r3.<init>()     // Catch:{ Exception -> 0x0050 }
            r3.a((java.util.Map) r0)     // Catch:{ Exception -> 0x0050 }
            r2.a(r1, r3)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0325
        L_0x02d0:
            r1 = r16
            r2.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0050 }
            com.mbridge.msdk.foundation.same.report.d.e r3 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x0050 }
            r3.<init>()     // Catch:{ Exception -> 0x0050 }
            r3.a((java.util.Map) r0)     // Catch:{ Exception -> 0x0050 }
            r2.a(r1, r3)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0325
        L_0x02e1:
            r1 = r25
            r2.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0050 }
            com.mbridge.msdk.foundation.same.report.d.e r3 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x0050 }
            r3.<init>()     // Catch:{ Exception -> 0x0050 }
            r3.a((java.util.Map) r0)     // Catch:{ Exception -> 0x0050 }
            r2.a(r1, r3)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0325
        L_0x02f2:
            r1 = r25
            r2.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0050 }
            boolean r4 = r14 instanceof com.mbridge.msdk.newreward.function.c.a.b     // Catch:{ Exception -> 0x0050 }
            if (r4 == 0) goto L_0x0304
            com.mbridge.msdk.newreward.function.c.a.b r14 = (com.mbridge.msdk.newreward.function.c.a.b) r14     // Catch:{ Exception -> 0x0050 }
            java.util.List r4 = r14.E()     // Catch:{ Exception -> 0x0050 }
            r2.b((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r4)     // Catch:{ Exception -> 0x0050 }
        L_0x0304:
            if (r0 == 0) goto L_0x0309
            r0.remove(r3)     // Catch:{ Exception -> 0x0050 }
        L_0x0309:
            com.mbridge.msdk.foundation.same.report.d.e r3 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x0050 }
            r3.<init>()     // Catch:{ Exception -> 0x0050 }
            r3.a((java.util.Map) r0)     // Catch:{ Exception -> 0x0050 }
            r2.a(r1, r3)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0325
        L_0x0315:
            r1 = r17
            r2.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0050 }
            com.mbridge.msdk.foundation.same.report.d.e r3 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x0050 }
            r3.<init>()     // Catch:{ Exception -> 0x0050 }
            r3.a((java.util.Map) r0)     // Catch:{ Exception -> 0x0050 }
            r2.a(r1, r3)     // Catch:{ Exception -> 0x0050 }
        L_0x0325:
            com.mbridge.msdk.foundation.same.report.d.d r0 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0050 }
            r0.a((com.mbridge.msdk.foundation.same.report.d.c) r2)     // Catch:{ Exception -> 0x0050 }
            com.mbridge.msdk.foundation.same.report.d.d r0 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r1 = r2.c()     // Catch:{ Exception -> 0x0050 }
            r3 = 0
            r0.a((java.lang.String) r1, (com.mbridge.msdk.foundation.same.report.d.c) r2, (com.mbridge.msdk.foundation.same.report.d.a.a) r3)     // Catch:{ Exception -> 0x0050 }
            return
        L_0x0339:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x0340
            r0.printStackTrace()
        L_0x0340:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.e.c.a(com.mbridge.msdk.newreward.a.e, java.util.Map, com.mbridge.msdk.newreward.function.command.f):void");
    }

    public final void a(e eVar, Map<String, String> map, String str) {
        int i5;
        int i6;
        b b5;
        try {
            String str2 = "";
            if (eVar.D() != null) {
                if (eVar.D().b() != null) {
                    str2 = eVar.D().b().a() + str2;
                }
            }
            com.mbridge.msdk.foundation.same.report.d.c a5 = d.a().a(eVar.G(), str2);
            if (a5 == null) {
                a5 = new com.mbridge.msdk.foundation.same.report.d.c();
                a5.c(eVar.G());
                a5.b(eVar.h());
            }
            a5.d(eVar.H());
            a5.e(eVar.J());
            a5.i(eVar.R() ? "1" : "0");
            if (eVar.D() != null) {
                a5.b(eVar.D().a());
            }
            if (eVar.x() != null) {
                a a6 = eVar.x().a();
                if (a6 != null) {
                    a5.h(a6.b());
                    a5.f(a6.c());
                }
                com.mbridge.msdk.videocommon.d.c b6 = eVar.x().b();
                if (b6 != null) {
                    a5.g(b6.l());
                    a5.n(b6.k());
                }
            }
            a5.a(str);
            com.mbridge.msdk.foundation.same.report.d.e eVar2 = new com.mbridge.msdk.foundation.same.report.d.e();
            if (!TextUtils.isEmpty(str) && str.equals("2000130")) {
                int i7 = 0;
                if (eVar.D() == null || eVar.D().b() == null || (b5 = eVar.D().b()) == null) {
                    i5 = 0;
                    i6 = 0;
                } else {
                    int a7 = b5.a();
                    i6 = b5.b();
                    if (b5.E() != null && !b5.E().isEmpty()) {
                        i7 = b5.E().get(0).getFilterCallBackState();
                    }
                    i5 = i7;
                    i7 = a7;
                }
                eVar2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(i7));
                eVar2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(i6));
                eVar2.a(CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(i5));
            }
            eVar2.a((Map) map);
            a5.a(str, eVar2);
            d.a().a(a5);
            d.a().a(a5.c(), a5, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public final void a(com.mbridge.msdk.newreward.b.b bVar, Map map, f fVar) {
        if (bVar != null) {
            try {
                com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
                cVar.c(bVar.b());
                cVar.b(bVar.e());
                cVar.d(bVar.c());
                cVar.i(bVar.f() ? "1" : "0");
                if (bVar.g() != null) {
                    a a5 = bVar.g().a();
                    if (a5 != null) {
                        cVar.h(a5.b());
                        cVar.f(a5.c());
                    }
                    com.mbridge.msdk.videocommon.d.c b5 = bVar.g().b();
                    if (b5 != null) {
                        cVar.g(b5.l());
                        cVar.n(b5.k());
                    }
                }
                int i5 = AnonymousClass1.f10953a[fVar.ordinal()];
                if (i5 == 9) {
                    cVar.a("2000128");
                } else if (i5 == 15) {
                    cVar.a("m_offer_ready");
                    com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                    if (map != null) {
                        eVar.a(map);
                    }
                    cVar.a("m_offer_ready", eVar);
                } else if (i5 == 16) {
                    cVar.a("2000131");
                    com.mbridge.msdk.foundation.same.report.d.e eVar2 = new com.mbridge.msdk.foundation.same.report.d.e();
                    eVar2.a(map);
                    cVar.a("2000131", eVar2);
                }
                d.a().a(cVar);
                d.a().a(cVar.c(), cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }
}
