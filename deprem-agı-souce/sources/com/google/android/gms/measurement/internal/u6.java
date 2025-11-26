package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.android.gms.internal.measurement.A2;
import com.google.android.gms.internal.measurement.B1;
import com.google.android.gms.internal.measurement.C1051a3;
import com.google.android.gms.internal.measurement.C1056b;
import com.google.android.gms.internal.measurement.C1096f3;
import com.google.android.gms.internal.measurement.C1114h3;
import com.google.android.gms.internal.measurement.C1145k7;
import com.google.android.gms.internal.measurement.C1186p3;
import com.google.android.gms.internal.measurement.C1195q3;
import com.google.android.gms.internal.measurement.C1203r3;
import com.google.android.gms.internal.measurement.C1247w2;
import com.google.android.gms.internal.measurement.C1271z1;
import com.google.android.gms.internal.measurement.C2;
import com.google.android.gms.internal.measurement.E5;
import com.google.android.gms.internal.measurement.F1;
import com.google.android.gms.internal.measurement.H1;
import com.google.android.gms.internal.measurement.H2;
import com.google.android.gms.internal.measurement.K2;
import com.google.android.gms.internal.measurement.L1;
import com.google.android.gms.internal.measurement.M2;
import com.google.android.gms.internal.measurement.N2;
import com.google.android.gms.internal.measurement.O2;
import com.google.android.gms.internal.measurement.R2;
import com.google.android.gms.internal.measurement.R4;
import com.google.android.gms.internal.measurement.S2;
import com.google.android.gms.internal.measurement.Y2;
import com.google.android.gms.internal.measurement.Z2;
import com.google.android.gms.internal.measurement.x7;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import f0.P;
import f0.x;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

public final class u6 extends C1292b6 {
    u6(q6 q6Var) {
        super(q6Var);
    }

    private static final String A(boolean z4, boolean z5, boolean z6) {
        StringBuilder sb = new StringBuilder();
        if (z4) {
            sb.append("Dynamic ");
        }
        if (z5) {
            sb.append("Sequence ");
        }
        if (z6) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private static final Object B(S2 s22) {
        if (s22.H()) {
            return s22.I();
        }
        if (s22.J()) {
            return Long.valueOf(s22.K());
        }
        if (s22.N()) {
            return Double.valueOf(s22.O());
        }
        if (s22.Q() > 0) {
            return Y(s22.P());
        }
        return null;
    }

    private static final void C(Uri.Builder builder, String[] strArr, Bundle bundle, Set set) {
        for (String split : strArr) {
            String[] split2 = split.split(",");
            String str = split2[0];
            String str2 = split2[split2.length - 1];
            String string = bundle.getString(str);
            if (string != null) {
                z(builder, str2, string, set);
            }
        }
    }

    private static final void D(StringBuilder sb, int i5, String str, C1096f3 f3Var) {
        Integer num;
        Integer num2;
        Long l5;
        if (f3Var != null) {
            y(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            if (f3Var.I() != 0) {
                y(sb, 4);
                sb.append("results: ");
                int i6 = 0;
                for (Long l6 : f3Var.H()) {
                    int i7 = i6 + 1;
                    if (i6 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l6);
                    i6 = i7;
                }
                sb.append(10);
            }
            if (f3Var.G() != 0) {
                y(sb, 4);
                sb.append("status: ");
                int i8 = 0;
                for (Long l7 : f3Var.F()) {
                    int i9 = i8 + 1;
                    if (i8 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l7);
                    i8 = i9;
                }
                sb.append(10);
            }
            if (f3Var.K() != 0) {
                y(sb, 4);
                sb.append("dynamic_filter_timestamps: {");
                int i10 = 0;
                for (M2 m22 : f3Var.J()) {
                    int i11 = i10 + 1;
                    if (i10 != 0) {
                        sb.append(", ");
                    }
                    if (m22.F()) {
                        num2 = Integer.valueOf(m22.G());
                    } else {
                        num2 = null;
                    }
                    sb.append(num2);
                    sb.append(":");
                    if (m22.H()) {
                        l5 = Long.valueOf(m22.I());
                    } else {
                        l5 = null;
                    }
                    sb.append(l5);
                    i10 = i11;
                }
                sb.append("}\n");
            }
            if (f3Var.M() != 0) {
                y(sb, 4);
                sb.append("sequence_filter_timestamps: {");
                int i12 = 0;
                for (C1114h3 h3Var : f3Var.L()) {
                    int i13 = i12 + 1;
                    if (i12 != 0) {
                        sb.append(", ");
                    }
                    if (h3Var.F()) {
                        num = Integer.valueOf(h3Var.G());
                    } else {
                        num = null;
                    }
                    sb.append(num);
                    sb.append(": [");
                    int i14 = 0;
                    for (Long longValue : h3Var.H()) {
                        long longValue2 = longValue.longValue();
                        int i15 = i14 + 1;
                        if (i14 != 0) {
                            sb.append(", ");
                        }
                        sb.append(longValue2);
                        i14 = i15;
                    }
                    sb.append("]");
                    i12 = i13;
                }
                sb.append("}\n");
            }
            y(sb, 3);
            sb.append("}\n");
        }
    }

    private static final void E(StringBuilder sb, int i5, String str, Object obj) {
        if (obj != null) {
            y(sb, i5 + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    private static final void F(StringBuilder sb, int i5, String str, F1 f12) {
        String str2;
        if (f12 != null) {
            y(sb, i5);
            sb.append(str);
            sb.append(" {\n");
            if (f12.F()) {
                int Q4 = f12.Q();
                if (Q4 == 1) {
                    str2 = "UNKNOWN_COMPARISON_TYPE";
                } else if (Q4 == 2) {
                    str2 = "LESS_THAN";
                } else if (Q4 == 3) {
                    str2 = "GREATER_THAN";
                } else if (Q4 != 4) {
                    str2 = "BETWEEN";
                } else {
                    str2 = "EQUAL";
                }
                E(sb, i5, "comparison_type", str2);
            }
            if (f12.G()) {
                E(sb, i5, "match_as_float", Boolean.valueOf(f12.H()));
            }
            if (f12.I()) {
                E(sb, i5, "comparison_value", f12.J());
            }
            if (f12.K()) {
                E(sb, i5, "min_comparison_value", f12.L());
            }
            if (f12.M()) {
                E(sb, i5, "max_comparison_value", f12.N());
            }
            y(sb, i5);
            sb.append("}\n");
        }
    }

    static boolean O(String str) {
        if (str == null || !str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") || str.length() > 310) {
            return false;
        }
        return true;
    }

    static boolean P(List list, int i5) {
        if (i5 >= list.size() * 64) {
            return false;
        }
        if (((1 << (i5 % 64)) & ((Long) list.get(i5 / 64)).longValue()) != 0) {
            return true;
        }
        return false;
    }

    static List Q(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i5 = 0; i5 < length; i5++) {
            long j5 = 0;
            for (int i6 = 0; i6 < 64; i6++) {
                int i7 = (i5 * 64) + i6;
                if (i7 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i7)) {
                    j5 |= 1 << i6;
                }
            }
            arrayList.add(Long.valueOf(j5));
        }
        return arrayList;
    }

    static E5 W(E5 e5, byte[] bArr) {
        R4 a5 = R4.a();
        if (a5 != null) {
            return e5.l(bArr, a5);
        }
        return e5.v(bArr);
    }

    static int X(Z2 z22, String str) {
        for (int i5 = 0; i5 < z22.V0(); i5++) {
            if (str.equals(z22.W0(i5).H())) {
                return i5;
            }
        }
        return -1;
    }

    static Bundle[] Y(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            S2 s22 = (S2) it.next();
            if (s22 != null) {
                Bundle bundle = new Bundle();
                for (S2 s23 : s22.P()) {
                    if (s23.H()) {
                        bundle.putString(s23.G(), s23.I());
                    } else if (s23.J()) {
                        bundle.putLong(s23.G(), s23.K());
                    } else if (s23.N()) {
                        bundle.putDouble(s23.G(), s23.O());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    static final void o(N2 n22, String str, Object obj) {
        List r5 = n22.r();
        int i5 = 0;
        while (true) {
            if (i5 >= r5.size()) {
                i5 = -1;
                break;
            } else if (str.equals(((S2) r5.get(i5)).G())) {
                break;
            } else {
                i5++;
            }
        }
        R2 R4 = S2.R();
        R4.s(str);
        R4.y(((Long) obj).longValue());
        if (i5 >= 0) {
            n22.x(i5, R4);
        } else {
            n22.z(R4);
        }
    }

    static final boolean p(G g5, B6 b6) {
        C0722p.k(g5);
        C0722p.k(b6);
        if (TextUtils.isEmpty(b6.f5766b)) {
            return false;
        }
        return true;
    }

    static final Bundle q(List list) {
        Bundle bundle = new Bundle();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            S2 s22 = (S2) it.next();
            String G4 = s22.G();
            if (s22.N()) {
                bundle.putDouble(G4, s22.O());
            } else if (s22.L()) {
                bundle.putFloat(G4, s22.M());
            } else if (s22.H()) {
                bundle.putString(G4, s22.I());
            } else if (s22.J()) {
                bundle.putLong(G4, s22.K());
            }
        }
        return bundle;
    }

    static final S2 r(O2 o22, String str) {
        for (S2 s22 : o22.F()) {
            if (s22.G().equals(str)) {
                return s22;
            }
        }
        return null;
    }

    static final Map s(O2 o22, String... strArr) {
        Object B4;
        HashMap hashMap = new HashMap();
        for (S2 s22 : o22.F()) {
            if (Arrays.asList(strArr).contains(s22.G()) && (B4 = B(s22)) != null) {
                hashMap.put(s22.G(), B4);
            }
        }
        return hashMap;
    }

    static final Map t(O2 o22, String str) {
        Object B4;
        HashMap hashMap = new HashMap();
        for (S2 s22 : o22.F()) {
            if (s22.G().startsWith("gad_") && (B4 = B(s22)) != null) {
                hashMap.put(s22.G(), B4);
            }
        }
        return hashMap;
    }

    static final Object u(O2 o22, String str) {
        S2 r5 = r(o22, str);
        if (r5 == null) {
            return null;
        }
        return B(r5);
    }

    static final Object v(O2 o22, String str, Object obj) {
        Object u5 = u(o22, str);
        if (u5 == null) {
            return obj;
        }
        return u5;
    }

    private final void w(StringBuilder sb, int i5, List list) {
        String str;
        String str2;
        Long l5;
        if (list != null) {
            int i6 = i5 + 1;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                S2 s22 = (S2) it.next();
                if (s22 != null) {
                    y(sb, i6);
                    sb.append("param {\n");
                    Double d5 = null;
                    if (s22.F()) {
                        str = this.f5730a.D().b(s22.G());
                    } else {
                        str = null;
                    }
                    E(sb, i6, RewardPlus.NAME, str);
                    if (s22.H()) {
                        str2 = s22.I();
                    } else {
                        str2 = null;
                    }
                    E(sb, i6, "string_value", str2);
                    if (s22.J()) {
                        l5 = Long.valueOf(s22.K());
                    } else {
                        l5 = null;
                    }
                    E(sb, i6, "int_value", l5);
                    if (s22.N()) {
                        d5 = Double.valueOf(s22.O());
                    }
                    E(sb, i6, "double_value", d5);
                    if (s22.Q() > 0) {
                        w(sb, i6, s22.P());
                    }
                    y(sb, i6);
                    sb.append("}\n");
                }
            }
        }
    }

    private final void x(StringBuilder sb, int i5, B1 b12) {
        String str;
        if (b12 != null) {
            y(sb, i5);
            sb.append("filter {\n");
            if (b12.J()) {
                E(sb, i5, "complement", Boolean.valueOf(b12.K()));
            }
            if (b12.L()) {
                E(sb, i5, "param_name", this.f5730a.D().b(b12.M()));
            }
            if (b12.F()) {
                int i6 = i5 + 1;
                L1 G4 = b12.G();
                if (G4 != null) {
                    y(sb, i6);
                    sb.append("string_filter {\n");
                    if (G4.F()) {
                        switch (G4.O()) {
                            case 1:
                                str = "UNKNOWN_MATCH_TYPE";
                                break;
                            case 2:
                                str = "REGEXP";
                                break;
                            case 3:
                                str = "BEGINS_WITH";
                                break;
                            case 4:
                                str = "ENDS_WITH";
                                break;
                            case 5:
                                str = "PARTIAL";
                                break;
                            case 6:
                                str = "EXACT";
                                break;
                            default:
                                str = "IN_LIST";
                                break;
                        }
                        E(sb, i6, "match_type", str);
                    }
                    if (G4.G()) {
                        E(sb, i6, "expression", G4.H());
                    }
                    if (G4.I()) {
                        E(sb, i6, "case_sensitive", Boolean.valueOf(G4.J()));
                    }
                    if (G4.L() > 0) {
                        y(sb, i5 + 2);
                        sb.append("expression_list {\n");
                        for (String append : G4.K()) {
                            y(sb, i5 + 3);
                            sb.append(append);
                            sb.append("\n");
                        }
                        sb.append("}\n");
                    }
                    y(sb, i6);
                    sb.append("}\n");
                }
            }
            if (b12.H()) {
                F(sb, i5 + 1, "number_filter", b12.I());
            }
            y(sb, i5);
            sb.append("}\n");
        }
    }

    private static final void y(StringBuilder sb, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            sb.append("  ");
        }
    }

    private static final void z(Uri.Builder builder, String str, String str2, Set set) {
        if (!set.contains(str) && !TextUtils.isEmpty(str2)) {
            builder.appendQueryParameter(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void G(C1195q3 q3Var, Object obj) {
        C0722p.k(obj);
        q3Var.w();
        q3Var.y();
        q3Var.A();
        if (obj instanceof String) {
            q3Var.t((String) obj);
        } else if (obj instanceof Long) {
            q3Var.x(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            q3Var.z(((Double) obj).doubleValue());
        } else {
            this.f5730a.a().o().b("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* access modifiers changed from: package-private */
    public final void H(R2 r22, Object obj) {
        C0722p.k(obj);
        r22.x();
        r22.z();
        r22.B();
        r22.F();
        if (obj instanceof String) {
            r22.w((String) obj);
        } else if (obj instanceof Long) {
            r22.y(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            r22.A(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            ArrayList arrayList = new ArrayList();
            for (Bundle bundle : (Bundle[]) obj) {
                if (bundle != null) {
                    R2 R4 = S2.R();
                    for (String next : bundle.keySet()) {
                        R2 R5 = S2.R();
                        R5.s(next);
                        Object obj2 = bundle.get(next);
                        if (obj2 instanceof Long) {
                            R5.y(((Long) obj2).longValue());
                        } else if (obj2 instanceof String) {
                            R5.w((String) obj2);
                        } else if (obj2 instanceof Double) {
                            R5.A(((Double) obj2).doubleValue());
                        }
                        R4.D(R5);
                    }
                    if (R4.C() > 0) {
                        arrayList.add((S2) R4.o());
                    }
                }
            }
            r22.E(arrayList);
        } else {
            this.f5730a.a().o().b("Ignoring invalid (type) event param value", obj);
        }
    }

    /* access modifiers changed from: package-private */
    public final S5 I(String str, Z2 z22, N2 n22, String str2) {
        int indexOf;
        String str3 = str;
        C1145k7.a();
        X2 x22 = this.f5730a;
        if (!x22.w().H(str3, C1304d2.f6293Q0)) {
            return null;
        }
        long currentTimeMillis = x22.f().currentTimeMillis();
        Set a5 = P.a(x22.w().C(str3, C1304d2.f6367v0).split(","));
        q6 q6Var = this.f6129b;
        C1308d6 C02 = q6Var.C0();
        String x4 = C02.f6129b.D0().x(str3);
        Uri.Builder builder = new Uri.Builder();
        X2 x23 = C02.f5730a;
        builder.scheme(x23.w().C(str3, C1304d2.f6353o0));
        if (!TextUtils.isEmpty(x4)) {
            String C4 = x23.w().C(str3, C1304d2.f6355p0);
            StringBuilder sb = new StringBuilder(String.valueOf(x4).length() + 1 + String.valueOf(C4).length());
            sb.append(x4);
            sb.append(".");
            sb.append(C4);
            builder.authority(sb.toString());
        } else {
            builder.authority(x23.w().C(str3, C1304d2.f6355p0));
        }
        builder.path(x23.w().C(str3, C1304d2.f6357q0));
        z(builder, "gmp_app_id", z22.n0(), a5);
        x22.w().A();
        z(builder, "gmp_version", String.valueOf(133005), a5);
        String O4 = z22.O();
        C1371m w4 = x22.w();
        C1296c2 c2Var = C1304d2.f6299T0;
        if (w4.H(str3, c2Var) && q6Var.D0().N(str3)) {
            O4 = "";
        }
        z(builder, "app_instance_id", O4, a5);
        z(builder, "rdid", z22.I(), a5);
        z(builder, "bundle_id", z22.D(), a5);
        String D4 = n22.D();
        String a6 = x.a(D4);
        if (true != TextUtils.isEmpty(a6)) {
            D4 = a6;
        }
        z(builder, "app_event_name", D4, a5);
        z(builder, "app_version", String.valueOf(z22.t0()), a5);
        String w5 = z22.w();
        if (x22.w().H(str3, c2Var) && q6Var.D0().K(str3) && !TextUtils.isEmpty(w5) && (indexOf = w5.indexOf(".")) != -1) {
            w5 = w5.substring(0, indexOf);
        }
        z(builder, "os_version", w5, a5);
        z(builder, CampaignEx.JSON_KEY_TIMESTAMP, String.valueOf(n22.G()), a5);
        String str4 = "1";
        if (z22.L()) {
            z(builder, "lat", str4, a5);
        }
        z(builder, "privacy_sandbox_version", String.valueOf(z22.a0()), a5);
        z(builder, "trigger_uri_source", str4, a5);
        z(builder, "trigger_uri_timestamp", String.valueOf(currentTimeMillis), a5);
        z(builder, "request_uuid", str2, a5);
        List<S2> r5 = n22.r();
        Bundle bundle = new Bundle();
        for (S2 s22 : r5) {
            String G4 = s22.G();
            if (s22.N()) {
                bundle.putString(G4, String.valueOf(s22.O()));
            } else if (s22.L()) {
                bundle.putString(G4, String.valueOf(s22.M()));
            } else if (s22.H()) {
                bundle.putString(G4, s22.I());
            } else if (s22.J()) {
                bundle.putString(G4, String.valueOf(s22.K()));
            }
        }
        C(builder, x22.w().C(str3, C1304d2.f6365u0).split("\\|"), bundle, a5);
        List<C1203r3> U02 = z22.U0();
        Bundle bundle2 = new Bundle();
        for (C1203r3 r3Var : U02) {
            String H4 = r3Var.H();
            if (r3Var.O()) {
                bundle2.putString(H4, String.valueOf(r3Var.P()));
            } else if (r3Var.M()) {
                bundle2.putString(H4, String.valueOf(r3Var.N()));
            } else if (r3Var.I()) {
                bundle2.putString(H4, r3Var.J());
            } else if (r3Var.K()) {
                bundle2.putString(H4, String.valueOf(r3Var.L()));
            }
        }
        C(builder, x22.w().C(str3, C1304d2.f6363t0).split("\\|"), bundle2, a5);
        if (true != z22.W()) {
            str4 = "0";
        }
        z(builder, "dma", str4, a5);
        if (!z22.Y().isEmpty()) {
            z(builder, "dma_cps", z22.Y(), a5);
        }
        if (z22.e0()) {
            C1247w2 f02 = z22.f0();
            if (!f02.Q().isEmpty()) {
                z(builder, "dl_gclid", f02.Q(), a5);
            }
            if (!f02.S().isEmpty()) {
                z(builder, "dl_gbraid", f02.S(), a5);
            }
            if (!f02.U().isEmpty()) {
                z(builder, "dl_gs", f02.U(), a5);
            }
            if (f02.W() > 0) {
                z(builder, "dl_ss_ts", String.valueOf(f02.W()), a5);
            }
            if (!f02.Y().isEmpty()) {
                z(builder, "mr_gclid", f02.Y(), a5);
            }
            if (!f02.a0().isEmpty()) {
                z(builder, "mr_gbraid", f02.a0(), a5);
            }
            if (!f02.c0().isEmpty()) {
                z(builder, "mr_gs", f02.c0(), a5);
            }
            if (f02.e0() > 0) {
                z(builder, "mr_click_ts", String.valueOf(f02.e0()), a5);
            }
        }
        return new S5(builder.build().toString(), currentTimeMillis, 1);
    }

    /* access modifiers changed from: package-private */
    public final O2 J(B b5) {
        N2 P4 = O2.P();
        P4.J(b5.f5748e);
        E e5 = b5.f5749f;
        D d5 = new D(e5);
        while (d5.hasNext()) {
            String a5 = d5.next();
            R2 R4 = S2.R();
            R4.s(a5);
            Object c5 = e5.c(a5);
            C0722p.k(c5);
            H(R4, c5);
            P4.z(R4);
        }
        String str = b5.f5746c;
        if (!TextUtils.isEmpty(str) && e5.c("_o") == null) {
            R2 R5 = S2.R();
            R5.s("_o");
            R5.w(str);
            P4.y((S2) R5.o());
        }
        return (O2) P4.o();
    }

    /* access modifiers changed from: package-private */
    public final String K(Y2 y22) {
        String str;
        String str2;
        String str3;
        String str4;
        A2 Z02;
        if (y22 == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (y22.K()) {
            E(sb, 0, "upload_subdomain", y22.L());
        }
        if (y22.I()) {
            E(sb, 0, "sgtm_join_id", y22.J());
        }
        for (C1051a3 a3Var : y22.F()) {
            if (a3Var != null) {
                y(sb, 1);
                sb.append("bundle {\n");
                if (a3Var.f0()) {
                    E(sb, 1, "protocol_version", Integer.valueOf(a3Var.g1()));
                }
                x7.a();
                X2 x22 = this.f5730a;
                if (x22.w().H(a3Var.F(), C1304d2.f6287N0) && a3Var.M0()) {
                    E(sb, 1, "session_stitching_token", a3Var.N0());
                }
                E(sb, 1, "platform", a3Var.A2());
                if (a3Var.H()) {
                    E(sb, 1, "gmp_version", Long.valueOf(a3Var.I()));
                }
                if (a3Var.J()) {
                    E(sb, 1, "uploading_gmp_version", Long.valueOf(a3Var.K()));
                }
                if (a3Var.I0()) {
                    E(sb, 1, "dynamite_version", Long.valueOf(a3Var.J0()));
                }
                if (a3Var.b0()) {
                    E(sb, 1, "config_version", Long.valueOf(a3Var.c0()));
                }
                E(sb, 1, "gmp_app_id", a3Var.U());
                E(sb, 1, MBridgeConstans.APP_ID, a3Var.F());
                E(sb, 1, "app_version", a3Var.G());
                if (a3Var.Z()) {
                    E(sb, 1, "app_version_major", Integer.valueOf(a3Var.a0()));
                }
                E(sb, 1, "firebase_instance_id", a3Var.Y());
                if (a3Var.P()) {
                    E(sb, 1, "dev_cert_hash", Long.valueOf(a3Var.Q()));
                }
                E(sb, 1, "app_store", a3Var.G2());
                if (a3Var.q2()) {
                    E(sb, 1, "upload_timestamp_millis", Long.valueOf(a3Var.r2()));
                }
                if (a3Var.s2()) {
                    E(sb, 1, "start_timestamp_millis", Long.valueOf(a3Var.t2()));
                }
                if (a3Var.u2()) {
                    E(sb, 1, "end_timestamp_millis", Long.valueOf(a3Var.v2()));
                }
                if (a3Var.w2()) {
                    E(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(a3Var.x2()));
                }
                if (a3Var.y2()) {
                    E(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(a3Var.z2()));
                }
                E(sb, 1, "app_instance_id", a3Var.O());
                E(sb, 1, "resettable_device_id", a3Var.L());
                E(sb, 1, "ds_id", a3Var.e0());
                if (a3Var.M()) {
                    E(sb, 1, "limited_ad_tracking", Boolean.valueOf(a3Var.N()));
                }
                E(sb, 1, "os_version", a3Var.B2());
                E(sb, 1, "device_model", a3Var.C2());
                E(sb, 1, "user_default_language", a3Var.D2());
                if (a3Var.E2()) {
                    E(sb, 1, "time_zone_offset_minutes", Integer.valueOf(a3Var.F2()));
                }
                if (a3Var.R()) {
                    E(sb, 1, "bundle_sequential_index", Integer.valueOf(a3Var.S()));
                }
                if (a3Var.a1()) {
                    E(sb, 1, "delivery_index", Integer.valueOf(a3Var.b1()));
                }
                if (a3Var.V()) {
                    E(sb, 1, "service_upload", Boolean.valueOf(a3Var.W()));
                }
                E(sb, 1, "health_monitor", a3Var.T());
                if (a3Var.G0()) {
                    E(sb, 1, "retry_counter", Integer.valueOf(a3Var.H0()));
                }
                if (a3Var.K0()) {
                    E(sb, 1, "consent_signals", a3Var.L0());
                }
                if (a3Var.T0()) {
                    E(sb, 1, "is_dma_region", Boolean.valueOf(a3Var.U0()));
                }
                if (a3Var.V0()) {
                    E(sb, 1, "core_platform_services", a3Var.W0());
                }
                if (a3Var.R0()) {
                    E(sb, 1, "consent_diagnostics", a3Var.S0());
                }
                if (a3Var.O0()) {
                    E(sb, 1, "target_os_version", Long.valueOf(a3Var.P0()));
                }
                C1145k7.a();
                if (x22.w().H(a3Var.F(), C1304d2.f6293Q0)) {
                    E(sb, 1, "ad_services_version", Integer.valueOf(a3Var.X0()));
                    if (a3Var.Y0() && (Z02 = a3Var.Z0()) != null) {
                        y(sb, 2);
                        sb.append("attribution_eligibility_status {\n");
                        E(sb, 2, "eligible", Boolean.valueOf(Z02.F()));
                        E(sb, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(Z02.G()));
                        E(sb, 2, "pre_r", Boolean.valueOf(Z02.H()));
                        E(sb, 2, "r_extensions_too_old", Boolean.valueOf(Z02.I()));
                        E(sb, 2, "adservices_extension_too_old", Boolean.valueOf(Z02.J()));
                        E(sb, 2, "ad_storage_not_allowed", Boolean.valueOf(Z02.K()));
                        E(sb, 2, "measurement_manager_disabled", Boolean.valueOf(Z02.L()));
                        y(sb, 2);
                        sb.append("}\n");
                    }
                }
                if (a3Var.c1()) {
                    C1247w2 d12 = a3Var.d1();
                    y(sb, 2);
                    sb.append("ad_campaign_info {\n");
                    if (d12.P()) {
                        E(sb, 2, "deep_link_gclid", d12.Q());
                    }
                    if (d12.R()) {
                        E(sb, 2, "deep_link_gbraid", d12.S());
                    }
                    if (d12.T()) {
                        E(sb, 2, "deep_link_gad_source", d12.U());
                    }
                    if (d12.V()) {
                        E(sb, 2, "deep_link_session_millis", Long.valueOf(d12.W()));
                    }
                    if (d12.X()) {
                        E(sb, 2, "market_referrer_gclid", d12.Y());
                    }
                    if (d12.Z()) {
                        E(sb, 2, "market_referrer_gbraid", d12.a0());
                    }
                    if (d12.b0()) {
                        E(sb, 2, "market_referrer_gad_source", d12.c0());
                    }
                    if (d12.d0()) {
                        E(sb, 2, "market_referrer_click_millis", Long.valueOf(d12.e0()));
                    }
                    y(sb, 2);
                    sb.append("}\n");
                }
                if (a3Var.g0()) {
                    E(sb, 1, "batching_timestamp_millis", Long.valueOf(a3Var.h0()));
                }
                if (a3Var.e1()) {
                    C1186p3 f12 = a3Var.f1();
                    y(sb, 2);
                    sb.append("sgtm_diagnostics {\n");
                    int K4 = f12.K();
                    if (K4 != 1) {
                        str3 = K4 != 2 ? K4 != 3 ? K4 != 4 ? "SDK_SERVICE_UPLOAD" : "PACKAGE_SERVICE_UPLOAD" : "SDK_CLIENT_UPLOAD" : "GA_UPLOAD";
                    } else {
                        str3 = "UPLOAD_TYPE_UNKNOWN";
                    }
                    E(sb, 2, "upload_type", str3);
                    E(sb, 2, "client_upload_eligibility", f12.F().name());
                    int L4 = f12.L();
                    if (L4 != 1) {
                        str4 = L4 != 2 ? L4 != 3 ? L4 != 4 ? L4 != 5 ? "NON_PLAY_MISSING_SGTM_SERVER_URL" : "MISSING_SGTM_PROXY_INFO" : "MISSING_SGTM_SETTINGS" : "NOT_IN_ROLLOUT" : "SERVICE_UPLOAD_ELIGIBLE";
                    } else {
                        str4 = "SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN";
                    }
                    E(sb, 2, "service_upload_eligibility", str4);
                    y(sb, 2);
                    sb.append("}\n");
                }
                if (a3Var.i0()) {
                    K2 j02 = a3Var.j0();
                    y(sb, 2);
                    sb.append("consent_info_extra {\n");
                    for (H2 h22 : j02.F()) {
                        y(sb, 3);
                        sb.append("limited_data_modes {\n");
                        int H4 = h22.H();
                        if (H4 != 1) {
                            str = H4 != 2 ? H4 != 3 ? H4 != 4 ? "AD_PERSONALIZATION" : "AD_USER_DATA" : "ANALYTICS_STORAGE" : "AD_STORAGE";
                        } else {
                            str = "CONSENT_TYPE_UNSPECIFIED";
                        }
                        E(sb, 3, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, str);
                        int I4 = h22.I();
                        if (I4 != 1) {
                            str2 = I4 != 2 ? "NO_DATA_MODE" : "LIMITED_MODE";
                        } else {
                            str2 = "NOT_LIMITED";
                        }
                        E(sb, 3, "mode", str2);
                        y(sb, 3);
                        sb.append("}\n");
                    }
                    y(sb, 2);
                    sb.append("}\n");
                }
                List<C1203r3> n22 = a3Var.n2();
                if (n22 != null) {
                    for (C1203r3 r3Var : n22) {
                        if (r3Var != null) {
                            y(sb, 2);
                            sb.append("user_property {\n");
                            Double d5 = null;
                            E(sb, 2, "set_timestamp_millis", r3Var.F() ? Long.valueOf(r3Var.G()) : null);
                            E(sb, 2, RewardPlus.NAME, x22.D().c(r3Var.H()));
                            E(sb, 2, "string_value", r3Var.J());
                            E(sb, 2, "int_value", r3Var.K() ? Long.valueOf(r3Var.L()) : null);
                            if (r3Var.O()) {
                                d5 = Double.valueOf(r3Var.P());
                            }
                            E(sb, 2, "double_value", d5);
                            y(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<C2> X4 = a3Var.X();
                if (X4 != null) {
                    for (C2 c22 : X4) {
                        if (c22 != null) {
                            y(sb, 2);
                            sb.append("audience_membership {\n");
                            if (c22.F()) {
                                E(sb, 2, "audience_id", Integer.valueOf(c22.G()));
                            }
                            if (c22.K()) {
                                E(sb, 2, "new_audience", Boolean.valueOf(c22.L()));
                            }
                            D(sb, 2, "current_data", c22.H());
                            if (c22.I()) {
                                D(sb, 2, "previous_data", c22.J());
                            }
                            y(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<O2> h23 = a3Var.h2();
                if (h23 != null) {
                    for (O2 o22 : h23) {
                        if (o22 != null) {
                            y(sb, 2);
                            sb.append("event {\n");
                            E(sb, 2, RewardPlus.NAME, x22.D().a(o22.I()));
                            if (o22.J()) {
                                E(sb, 2, "timestamp_millis", Long.valueOf(o22.K()));
                            }
                            if (o22.L()) {
                                E(sb, 2, "previous_timestamp_millis", Long.valueOf(o22.M()));
                            }
                            if (o22.N()) {
                                E(sb, 2, "count", Integer.valueOf(o22.O()));
                            }
                            if (o22.G() != 0) {
                                w(sb, 2, o22.F());
                            }
                            y(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                y(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("} // End-of-batch\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String L(C1271z1 z1Var) {
        if (z1Var == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (z1Var.F()) {
            E(sb, 0, "filter_id", Integer.valueOf(z1Var.G()));
        }
        E(sb, 0, "event_name", this.f5730a.D().a(z1Var.H()));
        String A4 = A(z1Var.N(), z1Var.O(), z1Var.Q());
        if (!A4.isEmpty()) {
            E(sb, 0, "filter_type", A4);
        }
        if (z1Var.L()) {
            F(sb, 1, "event_count_filter", z1Var.M());
        }
        if (z1Var.J() > 0) {
            sb.append("  filters {\n");
            for (B1 x4 : z1Var.I()) {
                x(sb, 2, x4);
            }
        }
        y(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String M(H1 h12) {
        if (h12 == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (h12.F()) {
            E(sb, 0, "filter_id", Integer.valueOf(h12.G()));
        }
        E(sb, 0, "property_name", this.f5730a.D().c(h12.H()));
        String A4 = A(h12.J(), h12.K(), h12.M());
        if (!A4.isEmpty()) {
            E(sb, 0, "filter_type", A4);
        }
        x(sb, 1, h12.I());
        sb.append("}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r4.f5730a.a().o().a("Failed to load parcelable from buffer");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Parcelable N(byte[] r5, android.os.Parcelable.Creator r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.os.Parcel r1 = android.os.Parcel.obtain()
            int r2 = r5.length     // Catch:{ a -> 0x001a }
            r3 = 0
            r1.unmarshall(r5, r3, r2)     // Catch:{ a -> 0x001a }
            r1.setDataPosition(r3)     // Catch:{ a -> 0x001a }
            java.lang.Object r5 = r6.createFromParcel(r1)     // Catch:{ a -> 0x001a }
            android.os.Parcelable r5 = (android.os.Parcelable) r5     // Catch:{ a -> 0x001a }
            r0 = r5
            goto L_0x0029
        L_0x0018:
            r5 = move-exception
            goto L_0x002d
        L_0x001a:
            com.google.android.gms.measurement.internal.X2 r5 = r4.f5730a     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.q2 r5 = r5.a()     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.o2 r5 = r5.o()     // Catch:{ all -> 0x0018 }
            java.lang.String r6 = "Failed to load parcelable from buffer"
            r5.a(r6)     // Catch:{ all -> 0x0018 }
        L_0x0029:
            r1.recycle()
            return r0
        L_0x002d:
            r1.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.u6.N(byte[], android.os.Parcelable$Creator):android.os.Parcelable");
    }

    /* access modifiers changed from: package-private */
    public final List R(List list, List list2) {
        int i5;
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                this.f5730a.a().r().b("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    this.f5730a.a().r().c("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i6 = size2;
            i5 = size;
            size = i6;
            if (size >= 0 && ((Long) arrayList.get(size)).longValue() == 0) {
                size2 = size - 1;
            }
        }
        return arrayList.subList(0, i5);
    }

    /* access modifiers changed from: package-private */
    public final boolean S(long j5, long j6) {
        if (j5 == 0 || j6 <= 0 || Math.abs(this.f5730a.f().currentTimeMillis() - j5) > j6) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final long T(byte[] bArr) {
        C0722p.k(bArr);
        X2 x22 = this.f5730a;
        x22.C().h();
        MessageDigest C4 = z6.C();
        if (C4 != null) {
            return z6.D(C4.digest(bArr));
        }
        x22.a().o().a("Failed to get MD5");
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final long U(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return T(str.getBytes(Charset.forName(C.UTF8_NAME)));
    }

    /* access modifiers changed from: package-private */
    public final byte[] V(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e5) {
            this.f5730a.a().o().b("Failed to gzip content", e5);
            throw e5;
        }
    }

    /* access modifiers changed from: package-private */
    public final Map Z(Bundle bundle, boolean z4) {
        HashMap hashMap = new HashMap();
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            boolean z5 = obj instanceof Parcelable[];
            if (z5 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z4) {
                    ArrayList arrayList = new ArrayList();
                    if (z5) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(Z((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        for (int i5 = 0; i5 < size; i5++) {
                            Object obj2 = arrayList2.get(i5);
                            if (obj2 instanceof Bundle) {
                                arrayList.add(Z((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(Z((Bundle) obj, false));
                    }
                    hashMap.put(next, arrayList);
                }
            } else if (obj != null) {
                hashMap.put(next, obj);
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public final boolean l() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final G m(C1056b bVar) {
        String str;
        Object obj;
        Bundle n5 = n(bVar.f(), true);
        if (!n5.containsKey("_o") || (obj = n5.get("_o")) == null) {
            str = MBridgeConstans.DYNAMIC_VIEW_WX_APP;
        } else {
            str = obj.toString();
        }
        String str2 = str;
        String b5 = x.b(bVar.b());
        if (b5 == null) {
            b5 = bVar.b();
        }
        return new G(b5, new E(n5), str2, bVar.a());
    }

    /* access modifiers changed from: package-private */
    public final Bundle n(Map map, boolean z4) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, (String) null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z4) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    arrayList2.add(n((Map) arrayList.get(i5), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }
}
