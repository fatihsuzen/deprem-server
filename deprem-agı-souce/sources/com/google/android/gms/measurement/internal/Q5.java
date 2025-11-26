package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.C1187p4;
import com.google.android.gms.internal.measurement.C1196q4;
import java.util.Map;
import m0.i;
import m0.j;
import m0.k;

public abstract class Q5 {

    /* renamed from: a  reason: collision with root package name */
    static final i f6046a = i.t("Version", "GoogleConsent", "VendorConsent", "VendorLegitimateInterest", "gdprApplies", "EnableAdvertiserConsentMode", "PolicyVersion", "PurposeConsents", "PurposeOneTreatment", "Purpose1", "Purpose3", "Purpose4", "Purpose7", "CmpSdkID", "PublisherCC", "PublisherRestrictions1", "PublisherRestrictions3", "PublisherRestrictions4", "PublisherRestrictions7", "AuthorizePurpose1", "AuthorizePurpose3", "AuthorizePurpose4", "AuthorizePurpose7", "PurposeDiagnostics");

    static String a(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "");
        } catch (ClassCastException unused) {
            return "";
        }
    }

    static int b(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    static final boolean c(C1187p4 p4Var, j jVar, j jVar2, k kVar, char[] cArr, int i5, int i6, int i7, int i8, int i9, String str, String str2, String str3, boolean z4, boolean z5, boolean z6) {
        int i10;
        int i11;
        char c5;
        String str4;
        k kVar2;
        P5 p5;
        int e5 = e(p4Var, jVar, jVar2, kVar, cArr, i5, i6, i7, i8, i9, str, str2, str3, z4, z5, true);
        if (e5 > 0) {
            i10 = i7;
            if (i10 == 1) {
                i11 = i6;
                if (i11 != 1) {
                    i10 = 1;
                } else {
                    i11 = 1;
                    i10 = 1;
                }
            } else {
                i11 = i6;
            }
            cArr[e5] = '2';
        } else {
            i11 = i6;
            i10 = i7;
        }
        C1187p4 p4Var2 = p4Var;
        j jVar3 = jVar;
        int i12 = e5;
        if (i(p4Var2, jVar3, jVar2, kVar, cArr, i5, i11, i10, i8, i9, str, str2, str3, z4, z5, true) == C1196q4.PURPOSE_RESTRICTION_NOT_ALLOWED) {
            c5 = '3';
        } else {
            int i13 = i9;
            if (p4Var2 == C1187p4.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
                kVar2 = kVar;
                str4 = str;
                if (i13 == 1) {
                    if (kVar2.contains(str4)) {
                        if (i12 > 0 && cArr[i12] != '2') {
                            cArr[i12] = '1';
                        }
                        return true;
                    }
                    i13 = 1;
                }
            } else {
                kVar2 = kVar;
                str4 = str;
            }
            if (jVar3.containsKey(p4Var2) && (p5 = (P5) jVar3.get(p4Var2)) != null) {
                int ordinal = p5.ordinal();
                if (ordinal != 0) {
                    if (ordinal != 1) {
                        if (ordinal != 2) {
                            if (ordinal == 3) {
                                if (i(p4Var2, jVar3, jVar2, kVar2, cArr, i5, i11, i10, i8, i13, str4, str2, str3, z4, z5, true) == C1196q4.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                                    return g(p4Var, jVar, jVar2, kVar, cArr, i5, i11, i10, i8, i13, str, str2, str3, z4, z5, true);
                                }
                                return h(p4Var, jVar, jVar2, kVar, cArr, i5, i11, i10, i8, i13, str, str2, str3, z4, z5, true);
                            }
                        } else if (i(p4Var, jVar, jVar2, kVar, cArr, i5, i11, i10, i8, i13, str, str2, str3, z4, z5, true) == C1196q4.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                            return h(p4Var, jVar, jVar2, kVar, cArr, i5, i11, i10, i8, i13, str, str2, str3, z4, z5, true);
                        } else {
                            return g(p4Var, jVar, jVar2, kVar, cArr, i5, i11, i10, i8, i13, str, str2, str3, z4, z5, true);
                        }
                    } else if (i(p4Var, jVar, jVar2, kVar, cArr, i5, i11, i10, i8, i13, str, str2, str3, z4, z5, true) != C1196q4.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                        return h(p4Var, jVar, jVar2, kVar, cArr, i5, i11, i10, i8, i13, str, str2, str3, z4, z5, true);
                    }
                } else if (i(p4Var, jVar, jVar2, kVar, cArr, i5, i11, i10, i8, i13, str, str2, str3, z4, z5, true) != C1196q4.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                    return g(p4Var, jVar, jVar2, kVar, cArr, i5, i11, i10, i8, i13, str, str2, str3, z4, z5, true);
                }
                c5 = '8';
            }
            c5 = '0';
        }
        if (i12 <= 0 || cArr[i12] == '2') {
            return false;
        }
        cArr[i12] = c5;
        return false;
    }

    public static final Map d(j jVar, j jVar2, k kVar, char[] cArr, int i5, int i6, int i7, int i8, int i9, String str, String str2, String str3, boolean z4, boolean z5, boolean z6) {
        String str4;
        String str5;
        String str6;
        String str7;
        int A4;
        int i10;
        int i11;
        int i12;
        String str8;
        String str9;
        String str10;
        j jVar3 = jVar2;
        if (!z6) {
            return j.i();
        }
        C1187p4 p4Var = C1187p4.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
        C1196q4 q4Var = (C1196q4) jVar3.get(p4Var);
        C1187p4 p4Var2 = C1187p4.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE;
        C1196q4 q4Var2 = (C1196q4) jVar3.get(p4Var2);
        C1187p4 p4Var3 = C1187p4.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS;
        C1196q4 q4Var3 = (C1196q4) jVar3.get(p4Var3);
        C1187p4 p4Var4 = C1187p4.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE;
        C1196q4 q4Var4 = (C1196q4) jVar3.get(p4Var4);
        String str11 = "1";
        boolean z7 = z4;
        j.a f5 = j.a().f("Version", "2").f("VendorConsent", true != z7 ? "0" : str11);
        boolean z8 = z5;
        if (true != z8) {
            str4 = "0";
        } else {
            str4 = str11;
        }
        j.a f6 = f5.f("VendorLegitimateInterest", str4);
        int i13 = i7;
        if (i13 != 1) {
            str5 = "0";
        } else {
            str5 = str11;
        }
        j.a f7 = f6.f("gdprApplies", str5);
        int i14 = i6;
        if (i14 != 1) {
            str6 = "0";
        } else {
            str6 = str11;
        }
        j.a f8 = f7.f("EnableAdvertiserConsentMode", str6).f("PolicyVersion", String.valueOf(i8)).f("CmpSdkID", String.valueOf(i5));
        int i15 = i9;
        if (i15 != 1) {
            str7 = "0";
        } else {
            str7 = str11;
        }
        C1196q4 q4Var5 = q4Var;
        j.a f9 = f8.f("PurposeOneTreatment", str7);
        String str12 = str;
        j.a f10 = f9.f("PublisherCC", str12);
        if (q4Var5 != null) {
            A4 = q4Var5.A();
        } else {
            A4 = C1196q4.PURPOSE_RESTRICTION_UNDEFINED.A();
        }
        C1187p4 p4Var5 = p4Var;
        j.a f11 = f10.f("PublisherRestrictions1", String.valueOf(A4));
        if (q4Var2 != null) {
            i10 = q4Var2.A();
        } else {
            i10 = C1196q4.PURPOSE_RESTRICTION_UNDEFINED.A();
        }
        j.a f12 = f11.f("PublisherRestrictions3", String.valueOf(i10));
        if (q4Var3 != null) {
            i11 = q4Var3.A();
        } else {
            i11 = C1196q4.PURPOSE_RESTRICTION_UNDEFINED.A();
        }
        j.a f13 = f12.f("PublisherRestrictions4", String.valueOf(i11));
        if (q4Var4 != null) {
            i12 = q4Var4.A();
        } else {
            i12 = C1196q4.PURPOSE_RESTRICTION_UNDEFINED.A();
        }
        j.a f14 = f13.f("PublisherRestrictions7", String.valueOf(i12));
        C1187p4 p4Var6 = p4Var5;
        k kVar2 = kVar;
        int i16 = i5;
        int i17 = i8;
        C1187p4 p4Var7 = p4Var2;
        C1187p4 p4Var8 = p4Var3;
        C1187p4 p4Var9 = p4Var4;
        int i18 = i13;
        int i19 = i14;
        String str13 = str12;
        j jVar4 = jVar;
        char[] cArr2 = cArr;
        String str14 = str2;
        String str15 = str3;
        String f15 = f(p4Var6, jVar4, jVar3, kVar2, cArr2, i16, i19, i18, i17, i15, str13, str14, str15, z7, z8, true);
        C1187p4 p4Var10 = p4Var6;
        j jVar5 = jVar2;
        int i20 = i6;
        int i21 = i7;
        int i22 = i9;
        String str16 = str;
        boolean z9 = z4;
        boolean z10 = z5;
        C1187p4 p4Var11 = p4Var7;
        String f16 = f(p4Var11, jVar4, jVar5, kVar2, cArr2, i16, i20, i21, i17, i22, str16, str14, str15, z9, z10, true);
        C1187p4 p4Var12 = p4Var11;
        C1187p4 p4Var13 = p4Var8;
        String f17 = f(p4Var13, jVar4, jVar5, kVar2, cArr2, i16, i20, i21, i17, i22, str16, str14, str15, z9, z10, true);
        C1187p4 p4Var14 = p4Var13;
        j.a i23 = f14.i(j.j("Purpose1", f15, "Purpose3", f16, "Purpose4", f17, "Purpose7", f(p4Var9, jVar4, jVar5, kVar2, cArr2, i16, i20, i21, i17, i22, str16, str14, str15, z9, z10, true)));
        if (true != c(p4Var10, jVar, jVar2, kVar, cArr, i5, i6, i7, i8, i22, str16, str14, str15, z9, z10, true)) {
            str8 = "0";
        } else {
            str8 = str11;
        }
        j.a aVar = i23;
        if (true != c(p4Var12, jVar, jVar2, kVar, cArr, i5, i6, i7, i8, i9, str, str2, str3, z4, z5, true)) {
            str9 = "0";
        } else {
            str9 = str11;
        }
        if (true != c(p4Var14, jVar, jVar2, kVar, cArr, i5, i6, i7, i8, i9, str, str2, str3, z4, z5, true)) {
            str10 = "0";
        } else {
            str10 = str11;
        }
        if (true != c(p4Var9, jVar, jVar2, kVar, cArr, i5, i6, i7, i8, i9, str, str2, str3, z4, z5, true)) {
            str11 = "0";
        }
        return aVar.i(j.k("AuthorizePurpose1", str8, "AuthorizePurpose3", str9, "AuthorizePurpose4", str10, "AuthorizePurpose7", str11, "PurposeDiagnostics", new String(cArr))).c();
    }

    private static final int e(C1187p4 p4Var, j jVar, j jVar2, k kVar, char[] cArr, int i5, int i6, int i7, int i8, int i9, String str, String str2, String str3, boolean z4, boolean z5, boolean z6) {
        if (p4Var == C1187p4.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
            return 1;
        }
        if (p4Var == C1187p4.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE) {
            return 2;
        }
        if (p4Var == C1187p4.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS) {
            return 3;
        }
        if (p4Var == C1187p4.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE) {
            return 4;
        }
        return -1;
    }

    private static final String f(C1187p4 p4Var, j jVar, j jVar2, k kVar, char[] cArr, int i5, int i6, int i7, int i8, int i9, String str, String str2, String str3, boolean z4, boolean z5, boolean z6) {
        String str4;
        String str5 = "0";
        if (TextUtils.isEmpty(str2) || str2.length() < p4Var.A()) {
            str4 = str5;
        } else {
            str4 = String.valueOf(str2.charAt(p4Var.A() - 1));
        }
        if (!TextUtils.isEmpty(str3) && str3.length() >= p4Var.A()) {
            str5 = String.valueOf(str3.charAt(p4Var.A() - 1));
        }
        return String.valueOf(str4).concat(String.valueOf(str5));
    }

    private static final boolean g(C1187p4 p4Var, j jVar, j jVar2, k kVar, char[] cArr, int i5, int i6, int i7, int i8, int i9, String str, String str2, String str3, boolean z4, boolean z5, boolean z6) {
        char c5;
        int e5 = e(p4Var, jVar, jVar2, kVar, cArr, i5, i6, i7, i8, i9, str, str2, str3, z4, z5, true);
        boolean z7 = false;
        if (!z4) {
            c5 = '4';
        } else if (str2.length() < p4Var.A()) {
            c5 = '0';
        } else {
            char charAt = str2.charAt(p4Var.A() - 1);
            char c6 = '1';
            if (charAt == '1') {
                z7 = true;
            }
            if (e5 > 0 && cArr[e5] != '2') {
                if (charAt != '1') {
                    c6 = '6';
                }
                cArr[e5] = c6;
            }
            return z7;
        }
        if (e5 > 0 && cArr[e5] != '2') {
            cArr[e5] = c5;
        }
        return false;
    }

    private static final boolean h(C1187p4 p4Var, j jVar, j jVar2, k kVar, char[] cArr, int i5, int i6, int i7, int i8, int i9, String str, String str2, String str3, boolean z4, boolean z5, boolean z6) {
        char c5;
        int e5 = e(p4Var, jVar, jVar2, kVar, cArr, i5, i6, i7, i8, i9, str, str2, str3, z4, z5, true);
        boolean z7 = false;
        if (!z5) {
            c5 = '5';
        } else if (str3.length() < p4Var.A()) {
            c5 = '0';
        } else {
            char charAt = str3.charAt(p4Var.A() - 1);
            char c6 = '1';
            if (charAt == '1') {
                z7 = true;
            }
            if (e5 > 0 && cArr[e5] != '2') {
                if (charAt != '1') {
                    c6 = '7';
                }
                cArr[e5] = c6;
            }
            return z7;
        }
        if (e5 > 0 && cArr[e5] != '2') {
            cArr[e5] = c5;
        }
        return false;
    }

    private static final C1196q4 i(C1187p4 p4Var, j jVar, j jVar2, k kVar, char[] cArr, int i5, int i6, int i7, int i8, int i9, String str, String str2, String str3, boolean z4, boolean z5, boolean z6) {
        return (C1196q4) jVar2.getOrDefault(p4Var, C1196q4.PURPOSE_RESTRICTION_UNDEFINED);
    }
}
