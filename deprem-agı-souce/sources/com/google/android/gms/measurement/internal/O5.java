package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.os.Bundle;
import android.text.TextUtils;
import f0.w;
import j$.util.Objects;
import java.util.HashMap;
import java.util.Map;
import m0.i;

public final class O5 {

    /* renamed from: a  reason: collision with root package name */
    private final Map f6012a;

    O5(Map map) {
        HashMap hashMap = new HashMap();
        this.f6012a = hashMap;
        hashMap.putAll(map);
    }

    private final Bundle f() {
        int g5;
        String str;
        String str2;
        Map map = this.f6012a;
        if ("1".equals(map.get("GoogleConsent")) && (g5 = g()) >= 0) {
            String str3 = (String) map.get("PurposeConsents");
            if (!TextUtils.isEmpty(str3)) {
                Bundle bundle = new Bundle();
                String str4 = "denied";
                if (str3.length() > 0) {
                    String str5 = w.AD_STORAGE.f15331a;
                    if (str3.charAt(0) == '1') {
                        str2 = "granted";
                    } else {
                        str2 = str4;
                    }
                    bundle.putString(str5, str2);
                }
                if (str3.length() > 3) {
                    String str6 = w.AD_PERSONALIZATION.f15331a;
                    if (str3.charAt(2) == '1' && str3.charAt(3) == '1') {
                        str = "granted";
                    } else {
                        str = str4;
                    }
                    bundle.putString(str6, str);
                }
                if (str3.length() > 6 && g5 >= 4) {
                    String str7 = w.AD_USER_DATA.f15331a;
                    if (str3.charAt(0) == '1' && str3.charAt(6) == '1') {
                        str4 = "granted";
                    }
                    bundle.putString(str7, str4);
                }
                return bundle;
            }
        }
        return Bundle.EMPTY;
    }

    private final int g() {
        try {
            String str = (String) this.f6012a.get("PolicyVersion");
            if (!TextUtils.isEmpty(str)) {
                return Integer.parseInt(str);
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        StringBuilder sb = new StringBuilder();
        i iVar = Q5.f6046a;
        int size = iVar.size();
        for (int i5 = 0; i5 < size; i5++) {
            String str = (String) iVar.get(i5);
            Map map = this.f6012a;
            if (map.containsKey(str)) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(str);
                sb.append("=");
                sb.append((String) map.get(str));
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004c, code lost:
        if ("1".equals(r2.get("EnableAdvertiserConsentMode")) != false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0029, code lost:
        if ("1".equals(r2.get("EnableAdvertiserConsentMode")) != false) goto L_0x004e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle b() {
        /*
            r9 = this;
            com.google.android.gms.measurement.internal.c2 r0 = com.google.android.gms.measurement.internal.C1304d2.f6314a1
            r1 = 0
            java.lang.Object r2 = r0.b(r1)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            java.lang.String r3 = "EnableAdvertiserConsentMode"
            java.lang.String r4 = "gdprApplies"
            java.lang.String r5 = "1"
            if (r2 == 0) goto L_0x002c
            java.util.Map r2 = r9.f6012a
            java.lang.Object r4 = r2.get(r4)
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x00df
            java.lang.Object r2 = r2.get(r3)
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x00df
            goto L_0x004e
        L_0x002c:
            java.util.Map r2 = r9.f6012a
            java.lang.String r6 = "GoogleConsent"
            java.lang.Object r6 = r2.get(r6)
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x00df
            java.lang.Object r4 = r2.get(r4)
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x00df
            java.lang.Object r2 = r2.get(r3)
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x00df
        L_0x004e:
            java.lang.Object r0 = r0.b(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00da
            java.util.Map r0 = r9.f6012a
            java.lang.String r1 = "Version"
            java.lang.Object r1 = r0.get(r1)
            if (r1 != 0) goto L_0x0069
            android.os.Bundle r0 = r9.f()
            return r0
        L_0x0069:
            int r1 = r9.g()
            if (r1 >= 0) goto L_0x0071
            goto L_0x00df
        L_0x0071:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            f0.w r2 = f0.w.AD_STORAGE
            java.lang.String r2 = r2.f15331a
            java.lang.String r3 = "AuthorizePurpose1"
            java.lang.Object r4 = r0.get(r3)
            boolean r4 = j$.util.Objects.equals(r4, r5)
            java.lang.String r6 = "granted"
            java.lang.String r7 = "denied"
            r8 = 1
            if (r8 == r4) goto L_0x008d
            r4 = r7
            goto L_0x008e
        L_0x008d:
            r4 = r6
        L_0x008e:
            r1.putString(r2, r4)
            f0.w r2 = f0.w.AD_PERSONALIZATION
            java.lang.String r2 = r2.f15331a
            java.lang.String r4 = "AuthorizePurpose3"
            java.lang.Object r4 = r0.get(r4)
            boolean r4 = j$.util.Objects.equals(r4, r5)
            if (r4 == 0) goto L_0x00af
            java.lang.String r4 = "AuthorizePurpose4"
            java.lang.Object r4 = r0.get(r4)
            boolean r4 = j$.util.Objects.equals(r4, r5)
            if (r4 == 0) goto L_0x00af
            r4 = r6
            goto L_0x00b0
        L_0x00af:
            r4 = r7
        L_0x00b0:
            r1.putString(r2, r4)
            int r2 = r9.g()
            r4 = 4
            if (r2 < r4) goto L_0x00d9
            f0.w r2 = f0.w.AD_USER_DATA
            java.lang.String r2 = r2.f15331a
            java.lang.Object r3 = r0.get(r3)
            boolean r3 = j$.util.Objects.equals(r3, r5)
            if (r3 == 0) goto L_0x00d5
            java.lang.String r3 = "AuthorizePurpose7"
            java.lang.Object r0 = r0.get(r3)
            boolean r0 = j$.util.Objects.equals(r0, r5)
            if (r0 == 0) goto L_0x00d5
            goto L_0x00d6
        L_0x00d5:
            r6 = r7
        L_0x00d6:
            r1.putString(r2, r6)
        L_0x00d9:
            return r1
        L_0x00da:
            android.os.Bundle r0 = r9.f()
            return r0
        L_0x00df:
            android.os.Bundle r0 = android.os.Bundle.EMPTY
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.O5.b():android.os.Bundle");
    }

    public final String c() {
        String str = (String) this.f6012a.get("PurposeDiagnostics");
        if (TextUtils.isEmpty(str)) {
            return "200000";
        }
        return str;
    }

    public final String d(O5 o5) {
        String str;
        Map map = o5.f6012a;
        String str2 = "0";
        if (map.isEmpty() || ((String) map.get("Version")) != null) {
            str = str2;
        } else {
            str = "1";
        }
        Bundle b5 = b();
        Bundle b6 = o5.b();
        if (b5.size() != b6.size() || !Objects.equals(b5.getString("ad_storage"), b6.getString("ad_storage")) || !Objects.equals(b5.getString("ad_personalization"), b6.getString("ad_personalization")) || !Objects.equals(b5.getString("ad_user_data"), b6.getString("ad_user_data"))) {
            str2 = "1";
        }
        return str.concat(str2);
    }

    public final String e() {
        int i5;
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        int i6 = -1;
        try {
            String str = (String) this.f6012a.get("CmpSdkID");
            if (!TextUtils.isEmpty(str)) {
                i6 = Integer.parseInt(str);
            }
        } catch (NumberFormatException unused) {
        }
        if (i6 < 0 || i6 > 4095) {
            sb.append("00");
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i6 >> 6));
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i6 & 63));
        }
        int g5 = g();
        if (g5 < 0 || g5 > 63) {
            sb.append("0");
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(g5));
        }
        C0722p.a(true);
        Map map = this.f6012a;
        if (true != "1".equals(map.get("gdprApplies"))) {
            i5 = 0;
        } else {
            i5 = 2;
        }
        boolean equals = "1".equals(map.get("EnableAdvertiserConsentMode"));
        int i7 = i5 | 4;
        if (equals) {
            i7 = i5 | 12;
        }
        sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i7));
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof O5)) {
            return false;
        }
        return a().equalsIgnoreCase(((O5) obj).a());
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final String toString() {
        return a();
    }
}
