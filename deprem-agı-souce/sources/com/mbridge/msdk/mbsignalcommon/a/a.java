package com.mbridge.msdk.mbsignalcommon.a;

import android.util.Base64;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f10082c = "a";

    /* renamed from: a  reason: collision with root package name */
    int f10083a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f10084b = 1;

    /* renamed from: com.mbridge.msdk.mbsignalcommon.a.a$a  reason: collision with other inner class name */
    private static final class C0093a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static a f10085a = new a();
    }

    public static a a() {
        return C0093a.f10085a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0156, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        com.mbridge.msdk.foundation.tools.af.a(f10082c, r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0168, code lost:
        com.mbridge.msdk.foundation.tools.af.a(f10082c, r0.getMessage());
        a(r1.f10084b, "exception: " + r0.getMessage(), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0097, code lost:
        r7 = r3.optJSONObject(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:2:0x000c, B:96:0x0131] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009d A[Catch:{ all -> 0x0156, all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a2 A[Catch:{ all -> 0x0156, all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ac A[Catch:{ all -> 0x0156, all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b1 A[Catch:{ all -> 0x0156, all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00bb A[Catch:{ all -> 0x0156, all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c0 A[Catch:{ all -> 0x0156, all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ca A[Catch:{ all -> 0x0156, all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00cf A[Catch:{ all -> 0x0156, all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d9 A[Catch:{ all -> 0x0156, all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00de A[Catch:{ all -> 0x0156, all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e8 A[Catch:{ all -> 0x0156, all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ed A[Catch:{ all -> 0x0156, all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f7 A[Catch:{ all -> 0x0156, all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00fc A[Catch:{ all -> 0x0156, all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0107 A[Catch:{ all -> 0x0156, all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x010c A[Catch:{ all -> 0x0156, all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0117 A[Catch:{ all -> 0x0156, all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x011e A[Catch:{ all -> 0x0156, all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x012a A[Catch:{ all -> 0x0156, all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x013b A[Catch:{ all -> 0x0156, all -> 0x0012 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Object r18, java.lang.String r19, org.json.JSONArray r20, int r21) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r0 = r19
            r3 = r20
            java.lang.String r4 = "called reporter failed, params empty"
            if (r3 != 0) goto L_0x0015
            int r0 = r1.f10084b     // Catch:{ all -> 0x0012 }
            r1.a(r0, r4, r2)     // Catch:{ all -> 0x0012 }
            return
        L_0x0012:
            r0 = move-exception
            goto L_0x0168
        L_0x0015:
            int r5 = r3.length()     // Catch:{ all -> 0x0012 }
            if (r5 != 0) goto L_0x0021
            int r0 = r1.f10084b     // Catch:{ all -> 0x0012 }
            r1.a(r0, r4, r2)     // Catch:{ all -> 0x0012 }
            return
        L_0x0021:
            java.lang.String r4 = "reportMessageR"
            boolean r4 = r4.equalsIgnoreCase(r0)     // Catch:{ all -> 0x0012 }
            r6 = 0
            r7 = 1
            java.lang.String r8 = "value"
            if (r4 == 0) goto L_0x007d
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ all -> 0x0012 }
            r0.<init>()     // Catch:{ all -> 0x0012 }
        L_0x0032:
            int r4 = r5 + -1
            java.lang.String r9 = "="
            java.lang.String r10 = "key"
            if (r6 >= r4) goto L_0x0059
            org.json.JSONObject r4 = r3.optJSONObject(r6)     // Catch:{ all -> 0x0012 }
            if (r4 == 0) goto L_0x0056
            java.lang.String r10 = r4.optString(r10)     // Catch:{ all -> 0x0012 }
            r0.append(r10)     // Catch:{ all -> 0x0012 }
            r0.append(r9)     // Catch:{ all -> 0x0012 }
            java.lang.Object r4 = r4.opt(r8)     // Catch:{ all -> 0x0012 }
            r0.append(r4)     // Catch:{ all -> 0x0012 }
            java.lang.String r4 = "&"
            r0.append(r4)     // Catch:{ all -> 0x0012 }
        L_0x0056:
            int r6 = r6 + 1
            goto L_0x0032
        L_0x0059:
            org.json.JSONObject r3 = r3.optJSONObject(r4)     // Catch:{ all -> 0x0012 }
            if (r3 == 0) goto L_0x0070
            java.lang.String r4 = r3.optString(r10)     // Catch:{ all -> 0x0012 }
            r0.append(r4)     // Catch:{ all -> 0x0012 }
            r0.append(r9)     // Catch:{ all -> 0x0012 }
            java.lang.Object r3 = r3.opt(r8)     // Catch:{ all -> 0x0012 }
            r0.append(r3)     // Catch:{ all -> 0x0012 }
        L_0x0070:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0012 }
            com.mbridge.msdk.foundation.same.report.d.d r3 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ all -> 0x0012 }
            r3.c(r0)     // Catch:{ all -> 0x0012 }
            goto L_0x0160
        L_0x007d:
            java.lang.String r4 = "reportMessageD"
            boolean r0 = r4.equalsIgnoreCase(r0)     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0160
            java.lang.String r0 = ""
            if (r5 <= 0) goto L_0x0094
            org.json.JSONObject r4 = r3.optJSONObject(r6)     // Catch:{ all -> 0x0012 }
            if (r4 == 0) goto L_0x0094
            java.lang.String r4 = r4.getString(r8)     // Catch:{ all -> 0x0012 }
            goto L_0x0095
        L_0x0094:
            r4 = r0
        L_0x0095:
            if (r5 <= r7) goto L_0x00a2
            org.json.JSONObject r7 = r3.optJSONObject(r7)     // Catch:{ all -> 0x0012 }
            if (r7 == 0) goto L_0x00a2
            int r7 = r7.getInt(r8)     // Catch:{ all -> 0x0012 }
            goto L_0x00a3
        L_0x00a2:
            r7 = -1
        L_0x00a3:
            r9 = 2
            if (r5 <= r9) goto L_0x00b1
            org.json.JSONObject r9 = r3.optJSONObject(r9)     // Catch:{ all -> 0x0012 }
            if (r9 == 0) goto L_0x00b1
            int r9 = r9.getInt(r8)     // Catch:{ all -> 0x0012 }
            goto L_0x00b2
        L_0x00b1:
            r9 = -1
        L_0x00b2:
            r10 = 3
            if (r5 <= r10) goto L_0x00c0
            org.json.JSONObject r10 = r3.optJSONObject(r10)     // Catch:{ all -> 0x0012 }
            if (r10 == 0) goto L_0x00c0
            int r10 = r10.getInt(r8)     // Catch:{ all -> 0x0012 }
            goto L_0x00c1
        L_0x00c0:
            r10 = -1
        L_0x00c1:
            r11 = 4
            if (r5 <= r11) goto L_0x00cf
            org.json.JSONObject r11 = r3.optJSONObject(r11)     // Catch:{ all -> 0x0012 }
            if (r11 == 0) goto L_0x00cf
            int r11 = r11.getInt(r8)     // Catch:{ all -> 0x0012 }
            goto L_0x00d0
        L_0x00cf:
            r11 = -1
        L_0x00d0:
            r12 = 5
            if (r5 <= r12) goto L_0x00de
            org.json.JSONObject r12 = r3.optJSONObject(r12)     // Catch:{ all -> 0x0012 }
            if (r12 == 0) goto L_0x00de
            java.lang.String r12 = r12.getString(r8)     // Catch:{ all -> 0x0012 }
            goto L_0x00df
        L_0x00de:
            r12 = r0
        L_0x00df:
            r13 = 6
            if (r5 <= r13) goto L_0x00ed
            org.json.JSONObject r13 = r3.optJSONObject(r13)     // Catch:{ all -> 0x0012 }
            if (r13 == 0) goto L_0x00ed
            java.lang.String r13 = r13.getString(r8)     // Catch:{ all -> 0x0012 }
            goto L_0x00ee
        L_0x00ed:
            r13 = r0
        L_0x00ee:
            r14 = 7
            if (r5 <= r14) goto L_0x00fc
            org.json.JSONObject r14 = r3.optJSONObject(r14)     // Catch:{ all -> 0x0012 }
            if (r14 == 0) goto L_0x00fc
            int r14 = r14.getInt(r8)     // Catch:{ all -> 0x0012 }
            goto L_0x00fd
        L_0x00fc:
            r14 = -1
        L_0x00fd:
            r15 = 8
            if (r5 <= r15) goto L_0x010c
            org.json.JSONObject r15 = r3.optJSONObject(r15)     // Catch:{ all -> 0x0012 }
            if (r15 == 0) goto L_0x010c
            java.lang.String r15 = r15.getString(r8)     // Catch:{ all -> 0x0012 }
            goto L_0x010d
        L_0x010c:
            r15 = r0
        L_0x010d:
            r6 = 9
            if (r5 <= r6) goto L_0x011e
            org.json.JSONObject r6 = r3.optJSONObject(r6)     // Catch:{ all -> 0x0012 }
            if (r6 == 0) goto L_0x011e
            int r6 = r6.getInt(r8)     // Catch:{ all -> 0x0012 }
        L_0x011b:
            r19 = r0
            goto L_0x0120
        L_0x011e:
            r6 = -1
            goto L_0x011b
        L_0x0120:
            r0 = 10
            if (r5 <= r0) goto L_0x012f
            org.json.JSONObject r0 = r3.optJSONObject(r0)     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x012f
            java.lang.String r0 = r0.getString(r8)     // Catch:{ all -> 0x0012 }
            goto L_0x0131
        L_0x012f:
            r0 = r19
        L_0x0131:
            com.mbridge.msdk.foundation.controller.c r3 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0156 }
            android.content.Context r16 = r3.c()     // Catch:{ all -> 0x0156 }
            if (r16 == 0) goto L_0x0160
            com.mbridge.msdk.foundation.entity.n r3 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ all -> 0x0156 }
            r5 = r7
            r7 = r10
            r8 = r11
            r10 = r13
            r11 = r14
            r14 = r0
            r13 = r6
            r6 = r9
            r9 = r12
            r12 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0156 }
            com.mbridge.msdk.foundation.db.g r0 = com.mbridge.msdk.foundation.db.g.a((android.content.Context) r16)     // Catch:{ all -> 0x0156 }
            com.mbridge.msdk.foundation.db.o r0 = com.mbridge.msdk.foundation.db.o.a((com.mbridge.msdk.foundation.db.f) r0)     // Catch:{ all -> 0x0156 }
            r0.a((com.mbridge.msdk.foundation.entity.n) r3)     // Catch:{ all -> 0x0156 }
            goto L_0x0160
        L_0x0156:
            r0 = move-exception
            java.lang.String r3 = f10082c     // Catch:{ all -> 0x0012 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0012 }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r3, (java.lang.String) r0)     // Catch:{ all -> 0x0012 }
        L_0x0160:
            int r0 = r1.f10083a     // Catch:{ all -> 0x0012 }
            java.lang.String r3 = "called reporter success"
            r1.a(r0, r3, r2)     // Catch:{ all -> 0x0012 }
            goto L_0x018b
        L_0x0168:
            java.lang.String r3 = f10082c
            java.lang.String r4 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r3, (java.lang.String) r4)
            int r3 = r1.f10084b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "exception: "
            r4.append(r5)
            java.lang.String r0 = r0.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r1.a(r3, r0, r2)
        L_0x018b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbsignalcommon.a.a.a(java.lang.Object, java.lang.String, org.json.JSONArray, int):void");
    }

    private void a(int i5, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i5);
            jSONObject.put("message", str);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e5) {
            af.a(f10082c, e5.getMessage());
        } catch (Throwable th) {
            af.a(f10082c, th.getMessage());
        }
    }
}
