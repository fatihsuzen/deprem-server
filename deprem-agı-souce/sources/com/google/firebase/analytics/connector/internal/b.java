package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.mbridge.msdk.MBridgeConstans;
import f0.z;
import m0.i;
import m0.k;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final k f7154a = k.s("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire");

    /* renamed from: b  reason: collision with root package name */
    private static final i f7155b = i.s("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");

    /* renamed from: c  reason: collision with root package name */
    private static final i f7156c = i.r("auto", MBridgeConstans.DYNAMIC_VIEW_WX_APP, "am");

    /* renamed from: d  reason: collision with root package name */
    private static final i f7157d = i.q("_r", "_dbg");

    /* renamed from: e  reason: collision with root package name */
    private static final i f7158e = new i.a().e(z.f15340a).e(z.f15341b).f();

    /* renamed from: f  reason: collision with root package name */
    private static final i f7159f = i.q("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ int f7160g = 0;

    public static boolean a(String str) {
        if (!f7156c.contains(str)) {
            return true;
        }
        return false;
    }

    public static boolean b(String str, Bundle bundle) {
        if (f7155b.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        i iVar = f7157d;
        int size = iVar.size();
        int i5 = 0;
        while (i5 < size) {
            boolean containsKey = bundle.containsKey((String) iVar.get(i5));
            i5++;
            if (containsKey) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(String str) {
        if (!f7154a.contains(str)) {
            return true;
        }
        return false;
    }

    public static boolean d(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            if (str.equals("fcm") || str.equals("frc")) {
                return true;
            }
            return false;
        } else if ("_ln".equals(str2)) {
            if (str.equals("fcm") || str.equals("fiam")) {
                return true;
            }
            return false;
        } else if (f7158e.contains(str2)) {
            return false;
        } else {
            i iVar = f7159f;
            int size = iVar.size();
            int i5 = 0;
            while (i5 < size) {
                boolean matches = str2.matches((String) iVar.get(i5));
                i5++;
                if (matches) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean e(java.lang.String r5, java.lang.String r6, android.os.Bundle r7) {
        /*
            java.lang.String r0 = "_cmp"
            boolean r6 = r0.equals(r6)
            r0 = 1
            if (r6 != 0) goto L_0x000a
            return r0
        L_0x000a:
            boolean r6 = a(r5)
            r1 = 0
            if (r6 != 0) goto L_0x0012
            return r1
        L_0x0012:
            if (r7 != 0) goto L_0x0015
            return r1
        L_0x0015:
            m0.i r6 = f7157d
            int r2 = r6.size()
            r3 = r1
        L_0x001c:
            if (r3 >= r2) goto L_0x002d
            java.lang.Object r4 = r6.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = r7.containsKey(r4)
            int r3 = r3 + 1
            if (r4 == 0) goto L_0x001c
            return r1
        L_0x002d:
            int r6 = r5.hashCode()
            r2 = 101200(0x18b50, float:1.41811E-40)
            r3 = 2
            if (r6 == r2) goto L_0x0056
            r2 = 101230(0x18b6e, float:1.41853E-40)
            if (r6 == r2) goto L_0x004c
            r2 = 3142703(0x2ff42f, float:4.403865E-39)
            if (r6 == r2) goto L_0x0042
            goto L_0x0060
        L_0x0042:
            java.lang.String r6 = "fiam"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0060
            r5 = r3
            goto L_0x0061
        L_0x004c:
            java.lang.String r6 = "fdl"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0060
            r5 = r0
            goto L_0x0061
        L_0x0056:
            java.lang.String r6 = "fcm"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0060
            r5 = r1
            goto L_0x0061
        L_0x0060:
            r5 = -1
        L_0x0061:
            java.lang.String r6 = "_cis"
            if (r5 == 0) goto L_0x0076
            if (r5 == r0) goto L_0x0070
            if (r5 == r3) goto L_0x006a
            return r1
        L_0x006a:
            java.lang.String r5 = "fiam_integration"
            r7.putString(r6, r5)
            return r0
        L_0x0070:
            java.lang.String r5 = "fdl_integration"
            r7.putString(r6, r5)
            return r0
        L_0x0076:
            java.lang.String r5 = "fcm_integration"
            r7.putString(r6, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.analytics.connector.internal.b.e(java.lang.String, java.lang.String, android.os.Bundle):boolean");
    }
}
