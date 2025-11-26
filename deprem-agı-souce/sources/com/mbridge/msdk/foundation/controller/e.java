package com.mbridge.msdk.foundation.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;

public final class e implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private String f8880a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f8881b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f8882c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f8883d = "";

    /* renamed from: e  reason: collision with root package name */
    private int f8884e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f8885f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8886g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8887h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f8888i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f8889j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8890k;

    /* renamed from: l  reason: collision with root package name */
    private a f8891l;

    /* renamed from: m  reason: collision with root package name */
    private final SharedPreferences f8892m;

    public interface a {
        void a();
    }

    public e(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        this.f8892m = defaultSharedPreferences;
        if (defaultSharedPreferences != null) {
            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        }
        if (defaultSharedPreferences != null) {
            this.f8880a = defaultSharedPreferences.getString("IABTCF_TCString", "");
            this.f8884e = defaultSharedPreferences.getInt("IABTCF_gdprApplies", 0);
            a(defaultSharedPreferences.getString("IABTCF_PurposeConsents", ""));
            b(defaultSharedPreferences.getString("IABTCF_VendorConsents", ""));
            c(defaultSharedPreferences.getString("IABTCF_AddtlConsent", ""));
        }
    }

    private void b(String str) {
        this.f8888i = a(str, 867);
        this.f8882c = str;
    }

    private void c(String str) {
        this.f8883d = str;
        if (TextUtils.isEmpty(str)) {
            this.f8889j = true;
        } else if (MBridgeConstans.GOOGLE_ATP_ID == -1) {
            this.f8890k = false;
        } else {
            this.f8890k = true;
            try {
                String[] split = str.split("~");
                if (split.length <= 1) {
                    return;
                }
                if (TextUtils.isEmpty(split[1])) {
                    this.f8889j = false;
                } else {
                    this.f8889j = str.contains(String.valueOf(MBridgeConstans.GOOGLE_ATP_ID));
                }
            } catch (Throwable th) {
                af.b("TCStringManager", th.getMessage());
            }
        }
    }

    private boolean d(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.matches("[01]+");
        }
        return false;
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.f8891l = aVar;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSharedPreferenceChanged(android.content.SharedPreferences r12, java.lang.String r13) {
        /*
            r11 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0082
            int r0 = r13.hashCode()     // Catch:{ all -> 0x0025 }
            r1 = 2
            java.lang.String r2 = "IABTCF_PurposeConsents"
            r3 = 1
            java.lang.String r4 = "IABTCF_gdprApplies"
            r5 = 0
            java.lang.String r6 = "IABTCF_TCString"
            r7 = 4
            java.lang.String r8 = "IABTCF_AddtlConsent"
            r9 = 3
            java.lang.String r10 = "IABTCF_VendorConsents"
            switch(r0) {
                case -2004976699: goto L_0x0040;
                case 83641339: goto L_0x0038;
                case 1218895378: goto L_0x0030;
                case 1342914771: goto L_0x0028;
                case 1450203731: goto L_0x001d;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0048
        L_0x001d:
            boolean r13 = r13.equals(r10)     // Catch:{ all -> 0x0025 }
            if (r13 == 0) goto L_0x0048
            r13 = r9
            goto L_0x0049
        L_0x0025:
            r12 = move-exception
            goto L_0x0083
        L_0x0028:
            boolean r13 = r13.equals(r8)     // Catch:{ all -> 0x0025 }
            if (r13 == 0) goto L_0x0048
            r13 = r7
            goto L_0x0049
        L_0x0030:
            boolean r13 = r13.equals(r6)     // Catch:{ all -> 0x0025 }
            if (r13 == 0) goto L_0x0048
            r13 = r5
            goto L_0x0049
        L_0x0038:
            boolean r13 = r13.equals(r4)     // Catch:{ all -> 0x0025 }
            if (r13 == 0) goto L_0x0048
            r13 = r3
            goto L_0x0049
        L_0x0040:
            boolean r13 = r13.equals(r2)     // Catch:{ all -> 0x0025 }
            if (r13 == 0) goto L_0x0048
            r13 = r1
            goto L_0x0049
        L_0x0048:
            r13 = -1
        L_0x0049:
            java.lang.String r0 = ""
            if (r13 == 0) goto L_0x0075
            if (r13 == r3) goto L_0x006e
            if (r13 == r1) goto L_0x0066
            if (r13 == r9) goto L_0x005e
            if (r13 == r7) goto L_0x0056
            goto L_0x007b
        L_0x0056:
            java.lang.String r12 = r12.getString(r8, r0)     // Catch:{ all -> 0x0025 }
            r11.c(r12)     // Catch:{ all -> 0x0025 }
            goto L_0x007b
        L_0x005e:
            java.lang.String r12 = r12.getString(r10, r0)     // Catch:{ all -> 0x0025 }
            r11.b(r12)     // Catch:{ all -> 0x0025 }
            goto L_0x007b
        L_0x0066:
            java.lang.String r12 = r12.getString(r2, r0)     // Catch:{ all -> 0x0025 }
            r11.a((java.lang.String) r12)     // Catch:{ all -> 0x0025 }
            goto L_0x007b
        L_0x006e:
            int r12 = r12.getInt(r4, r5)     // Catch:{ all -> 0x0025 }
            r11.f8884e = r12     // Catch:{ all -> 0x0025 }
            goto L_0x007b
        L_0x0075:
            java.lang.String r12 = r12.getString(r6, r0)     // Catch:{ all -> 0x0025 }
            r11.f8880a = r12     // Catch:{ all -> 0x0025 }
        L_0x007b:
            com.mbridge.msdk.foundation.controller.e$a r12 = r11.f8891l     // Catch:{ all -> 0x0025 }
            if (r12 == 0) goto L_0x0082
            r12.a()     // Catch:{ all -> 0x0025 }
        L_0x0082:
            return
        L_0x0083:
            java.lang.String r13 = "TCStringManager"
            java.lang.String r12 = r12.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r13, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.controller.e.onSharedPreferenceChanged(android.content.SharedPreferences, java.lang.String):void");
    }

    public final String a() {
        return this.f8880a;
    }

    private void a(String str) {
        this.f8886g = a(str, 1);
        this.f8887h = a(str, 2);
        this.f8881b = str;
    }

    public final boolean b() {
        boolean z4 = true;
        if (this.f8884e == 0) {
            this.f8885f = true;
            return true;
        }
        if (d(this.f8881b) && d(this.f8882c)) {
            if (MBridgeConstans.VERIFY_ATP_CONSENT) {
                boolean z5 = this.f8890k && this.f8889j;
                if ((!this.f8888i && !z5) || !this.f8886g || !this.f8887h) {
                    z4 = false;
                }
                this.f8885f = z4;
                return this.f8885f;
            } else if (!this.f8888i || !this.f8886g || !this.f8887h) {
                z4 = false;
            }
        }
        this.f8885f = z4;
        return this.f8885f;
    }

    private boolean a(String str, int i5) {
        if (!d(str) || i5 > str.length() || i5 < 1 || '1' != str.charAt(i5 - 1)) {
            return false;
        }
        return true;
    }
}
