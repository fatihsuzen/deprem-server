package com.mbridge.msdk.newreward.function.h;

import android.text.TextUtils;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.newreward.function.common.MBridgeTaskManager;
import java.net.URL;
import org.json.JSONObject;

public final class c {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String path = new URL(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1);
        } catch (Exception unused) {
            return str;
        }
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ak.i(str);
    }

    public static boolean c(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String[] split2 = str.split("_");
            if (split2.length < 4) {
                return false;
            }
            String str2 = split2[3];
            if (TextUtils.isEmpty(str2) || (split = z.a(str2).split("\\|")) == null || split.length == 0) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public static double d(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0.0d;
        }
        try {
            String[] split = str.split("_");
            if (split.length < 4) {
                return 0.0d;
            }
            String str2 = split[3];
            if (TextUtils.isEmpty(str2)) {
                return 0.0d;
            }
            String[] split2 = z.a(str2).split("\\|");
            if (split2.length > 0) {
                return Double.parseDouble(split2[0]);
            }
            return 0.0d;
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002e */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0033 A[SYNTHETIC, Splitter:B:18:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003d A[SYNTHETIC, Splitter:B:24:0x003d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x002e }
            r3.<init>(r5)     // Catch:{ Exception -> 0x002e }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
            int r2 = r3.read(r5)     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
        L_0x0014:
            if (r2 <= 0) goto L_0x0028
            java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
            r4.<init>(r5, r1, r2)     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
            r0.append(r4)     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
            int r2 = r3.read(r5)     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
            goto L_0x0014
        L_0x0023:
            r5 = move-exception
            r2 = r3
            goto L_0x003b
        L_0x0026:
            r2 = r3
            goto L_0x002e
        L_0x0028:
            r3.close()     // Catch:{ Exception -> 0x0036 }
            goto L_0x0036
        L_0x002c:
            r5 = move-exception
            goto L_0x003b
        L_0x002e:
            r0.setLength(r1)     // Catch:{ all -> 0x002c }
            if (r2 == 0) goto L_0x0036
            r2.close()     // Catch:{ Exception -> 0x0036 }
        L_0x0036:
            java.lang.String r5 = r0.toString()
            return r5
        L_0x003b:
            if (r2 == 0) goto L_0x0040
            r2.close()     // Catch:{ Exception -> 0x0040 }
        L_0x0040:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.h.c.a(java.io.File):java.lang.String");
    }

    public static void a(final String str, final int i5, final int i6, final int i7) {
        MBridgeTaskManager.commonExecute(new Runnable() {
            public final void run() {
                int i5;
                try {
                    JSONObject jSONObject = new JSONObject();
                    int i6 = 1;
                    jSONObject.put("ivRewardEnable", 1);
                    if (i5 == a.f9165H) {
                        i5 = 0;
                    } else {
                        i5 = 1;
                    }
                    jSONObject.put("ivRewardMode", i5);
                    if (i6 == a.f9167J) {
                        i6 = 0;
                    }
                    jSONObject.put("ivRewardPlayValueMode", i6);
                    jSONObject.put("ivRewardPlayValue", i7);
                    h.a().f(str, jSONObject.toString());
                } catch (Exception unused) {
                }
            }
        });
    }
}
