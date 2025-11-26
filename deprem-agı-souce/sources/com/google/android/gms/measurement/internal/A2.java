package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.C1145k7;
import j$.util.Objects;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class A2 {

    /* renamed from: a  reason: collision with root package name */
    private final String f5726a;

    /* renamed from: b  reason: collision with root package name */
    private final Bundle f5727b = new Bundle();

    /* renamed from: c  reason: collision with root package name */
    private Bundle f5728c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ E2 f5729d;

    public A2(E2 e22, String str, Bundle bundle) {
        Objects.requireNonNull(e22);
        this.f5729d = e22;
        C0722p.e(str);
        this.f5726a = str;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:59|60|71) */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r15.f5729d.f5730a.a().o().a("Error reading value from SharedPreferences. Value dropped");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x0124 */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x011c A[Catch:{ NumberFormatException | JSONException -> 0x0124 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle a() {
        /*
            r15 = this;
            android.os.Bundle r0 = r15.f5728c
            if (r0 == 0) goto L_0x0006
            goto L_0x0155
        L_0x0006:
            com.google.android.gms.measurement.internal.E2 r0 = r15.f5729d
            java.lang.String r1 = r15.f5726a
            android.content.SharedPreferences r2 = r0.p()
            r3 = 0
            java.lang.String r1 = r2.getString(r1, r3)
            if (r1 == 0) goto L_0x014d
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ JSONException -> 0x013c }
            r2.<init>()     // Catch:{ JSONException -> 0x013c }
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ JSONException -> 0x013c }
            r4.<init>(r1)     // Catch:{ JSONException -> 0x013c }
            r1 = 0
            r5 = r1
        L_0x0021:
            int r6 = r4.length()     // Catch:{ JSONException -> 0x013c }
            if (r5 >= r6) goto L_0x0139
            org.json.JSONObject r6 = r4.getJSONObject(r5)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            java.lang.String r7 = "n"
            java.lang.String r7 = r6.getString(r7)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            java.lang.String r8 = "t"
            java.lang.String r8 = r6.getString(r8)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            int r9 = r8.hashCode()     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            r10 = 100
            r11 = 2
            r12 = 3
            r13 = 4
            r14 = 1
            if (r9 == r10) goto L_0x007c
            r10 = 108(0x6c, float:1.51E-43)
            if (r9 == r10) goto L_0x0072
            r10 = 115(0x73, float:1.61E-43)
            if (r9 == r10) goto L_0x0068
            r10 = 3352(0xd18, float:4.697E-42)
            if (r9 == r10) goto L_0x005e
            r10 = 3445(0xd75, float:4.827E-42)
            if (r9 == r10) goto L_0x0054
            goto L_0x0086
        L_0x0054:
            java.lang.String r9 = "la"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0086
            r9 = r13
            goto L_0x0087
        L_0x005e:
            java.lang.String r9 = "ia"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0086
            r9 = r12
            goto L_0x0087
        L_0x0068:
            java.lang.String r9 = "s"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0086
            r9 = r1
            goto L_0x0087
        L_0x0072:
            java.lang.String r9 = "l"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0086
            r9 = r11
            goto L_0x0087
        L_0x007c:
            java.lang.String r9 = "d"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0086
            r9 = r14
            goto L_0x0087
        L_0x0086:
            r9 = -1
        L_0x0087:
            java.lang.String r10 = "v"
            if (r9 == 0) goto L_0x011c
            if (r9 == r14) goto L_0x0110
            if (r9 == r11) goto L_0x0104
            if (r9 == r12) goto L_0x00d4
            if (r9 == r13) goto L_0x00a4
            com.google.android.gms.measurement.internal.X2 r6 = r0.f5730a     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            com.google.android.gms.measurement.internal.q2 r6 = r6.a()     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            com.google.android.gms.measurement.internal.o2 r6 = r6.o()     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            java.lang.String r7 = "Unrecognized persisted bundle type. Type"
            r6.b(r7, r8)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            goto L_0x0135
        L_0x00a4:
            com.google.android.gms.internal.measurement.C1145k7.a()     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            com.google.android.gms.measurement.internal.X2 r8 = r0.f5730a     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            com.google.android.gms.measurement.internal.m r8 = r8.w()     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            com.google.android.gms.measurement.internal.c2 r9 = com.google.android.gms.measurement.internal.C1304d2.f6295R0     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            boolean r8 = r8.H(r3, r9)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            if (r8 == 0) goto L_0x0135
            org.json.JSONArray r8 = new org.json.JSONArray     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            java.lang.String r6 = r6.getString(r10)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            r8.<init>(r6)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            int r6 = r8.length()     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            long[] r9 = new long[r6]     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            r10 = r1
        L_0x00c5:
            if (r10 >= r6) goto L_0x00d0
            long r11 = r8.optLong(r10)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            r9[r10] = r11     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            int r10 = r10 + 1
            goto L_0x00c5
        L_0x00d0:
            r2.putLongArray(r7, r9)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            goto L_0x0135
        L_0x00d4:
            com.google.android.gms.internal.measurement.C1145k7.a()     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            com.google.android.gms.measurement.internal.X2 r8 = r0.f5730a     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            com.google.android.gms.measurement.internal.m r8 = r8.w()     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            com.google.android.gms.measurement.internal.c2 r9 = com.google.android.gms.measurement.internal.C1304d2.f6295R0     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            boolean r8 = r8.H(r3, r9)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            if (r8 == 0) goto L_0x0135
            org.json.JSONArray r8 = new org.json.JSONArray     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            java.lang.String r6 = r6.getString(r10)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            r8.<init>(r6)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            int r6 = r8.length()     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            int[] r9 = new int[r6]     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            r10 = r1
        L_0x00f5:
            if (r10 >= r6) goto L_0x0100
            int r11 = r8.optInt(r10)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            r9[r10] = r11     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            int r10 = r10 + 1
            goto L_0x00f5
        L_0x0100:
            r2.putIntArray(r7, r9)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            goto L_0x0135
        L_0x0104:
            java.lang.String r6 = r6.getString(r10)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            long r8 = java.lang.Long.parseLong(r6)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            r2.putLong(r7, r8)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            goto L_0x0135
        L_0x0110:
            java.lang.String r6 = r6.getString(r10)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            double r8 = java.lang.Double.parseDouble(r6)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            r2.putDouble(r7, r8)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            goto L_0x0135
        L_0x011c:
            java.lang.String r6 = r6.getString(r10)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            r2.putString(r7, r6)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            goto L_0x0135
        L_0x0124:
            com.google.android.gms.measurement.internal.E2 r6 = r15.f5729d     // Catch:{ JSONException -> 0x013c }
            com.google.android.gms.measurement.internal.X2 r6 = r6.f5730a     // Catch:{ JSONException -> 0x013c }
            com.google.android.gms.measurement.internal.q2 r6 = r6.a()     // Catch:{ JSONException -> 0x013c }
            com.google.android.gms.measurement.internal.o2 r6 = r6.o()     // Catch:{ JSONException -> 0x013c }
            java.lang.String r7 = "Error reading value from SharedPreferences. Value dropped"
            r6.a(r7)     // Catch:{ JSONException -> 0x013c }
        L_0x0135:
            int r5 = r5 + 1
            goto L_0x0021
        L_0x0139:
            r15.f5728c = r2     // Catch:{ JSONException -> 0x013c }
            goto L_0x014d
        L_0x013c:
            com.google.android.gms.measurement.internal.E2 r0 = r15.f5729d
            com.google.android.gms.measurement.internal.X2 r0 = r0.f5730a
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()
            java.lang.String r1 = "Error loading bundle from SharedPreferences. Values will be lost"
            r0.a(r1)
        L_0x014d:
            android.os.Bundle r0 = r15.f5728c
            if (r0 != 0) goto L_0x0155
            android.os.Bundle r0 = r15.f5727b
            r15.f5728c = r0
        L_0x0155:
            android.os.Bundle r0 = new android.os.Bundle
            android.os.Bundle r1 = r15.f5728c
            java.lang.Object r1 = N.C0722p.k(r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.A2.a():android.os.Bundle");
    }

    public final void b(Bundle bundle) {
        Bundle bundle2;
        Bundle bundle3 = bundle;
        if (bundle3 == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = new Bundle(bundle3);
        }
        E2 e22 = this.f5729d;
        SharedPreferences.Editor edit = e22.p().edit();
        if (bundle2.size() == 0) {
            edit.remove(this.f5726a);
        } else {
            String str = this.f5726a;
            JSONArray jSONArray = new JSONArray();
            for (String next : bundle2.keySet()) {
                Object obj = bundle2.get(next);
                if (obj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("n", next);
                        C1145k7.a();
                        X2 x22 = e22.f5730a;
                        X2 x23 = x22;
                        if (!x22.w().H((String) null, C1304d2.f6295R0)) {
                            jSONObject.put("v", obj.toString());
                            if (obj instanceof String) {
                                jSONObject.put("t", "s");
                            } else if (obj instanceof Long) {
                                jSONObject.put("t", "l");
                            } else if (obj instanceof Double) {
                                jSONObject.put("t", "d");
                            } else {
                                x23.a().o().b("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                            }
                        } else if (obj instanceof String) {
                            jSONObject.put("v", obj.toString());
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("v", obj.toString());
                            jSONObject.put("t", "l");
                        } else if (obj instanceof int[]) {
                            jSONObject.put("v", Arrays.toString((int[]) obj));
                            jSONObject.put("t", "ia");
                        } else if (obj instanceof long[]) {
                            jSONObject.put("v", Arrays.toString((long[]) obj));
                            jSONObject.put("t", "la");
                        } else if (obj instanceof Double) {
                            jSONObject.put("v", obj.toString());
                            jSONObject.put("t", "d");
                        } else {
                            x23.a().o().b("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException e5) {
                        this.f5729d.f5730a.a().o().b("Cannot serialize bundle value to SharedPreferences", e5);
                    }
                }
            }
            edit.putString(str, jSONArray.toString());
        }
        edit.apply();
        this.f5728c = bundle2;
    }
}
