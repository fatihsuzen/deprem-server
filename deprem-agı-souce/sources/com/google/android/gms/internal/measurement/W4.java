package com.google.android.gms.internal.measurement;

import android.support.v4.media.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class W4 {

    /* renamed from: d  reason: collision with root package name */
    private static final W4 f5199d = new W4(true);

    /* renamed from: a  reason: collision with root package name */
    final Y5 f5200a = new U5();

    /* renamed from: b  reason: collision with root package name */
    private boolean f5201b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5202c;

    private W4() {
    }

    static void c(M4 m42, C1162m6 m6Var, int i5, Object obj) {
        if (m6Var != C1162m6.GROUP) {
            m42.i(i5, m6Var.b());
            C1171n6 n6Var = C1171n6.INT;
            switch (m6Var.ordinal()) {
                case 0:
                    m42.A(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                    return;
                case 1:
                    m42.y(Float.floatToRawIntBits(((Float) obj).floatValue()));
                    return;
                case 2:
                    m42.z(((Long) obj).longValue());
                    return;
                case 3:
                    m42.z(((Long) obj).longValue());
                    return;
                case 4:
                    m42.w(((Integer) obj).intValue());
                    return;
                case 5:
                    m42.A(((Long) obj).longValue());
                    return;
                case 6:
                    m42.y(((Integer) obj).intValue());
                    return;
                case 7:
                    m42.v(((Boolean) obj).booleanValue() ? (byte) 1 : 0);
                    return;
                case 8:
                    if (obj instanceof H4) {
                        m42.r((H4) obj);
                        return;
                    } else {
                        m42.C((String) obj);
                        return;
                    }
                case 9:
                    ((F5) obj).c(m42);
                    return;
                case 10:
                    m42.u((F5) obj);
                    return;
                case 11:
                    if (obj instanceof H4) {
                        m42.r((H4) obj);
                        return;
                    }
                    byte[] bArr = (byte[]) obj;
                    m42.s(bArr, 0, bArr.length);
                    return;
                case 12:
                    m42.x(((Integer) obj).intValue());
                    return;
                case 13:
                    if (obj instanceof C1107g5) {
                        m42.w(((C1107g5) obj).A());
                        return;
                    } else {
                        m42.w(((Integer) obj).intValue());
                        return;
                    }
                case 14:
                    m42.y(((Integer) obj).intValue());
                    return;
                case 15:
                    m42.A(((Long) obj).longValue());
                    return;
                case 16:
                    int intValue = ((Integer) obj).intValue();
                    m42.x((intValue >> 31) ^ (intValue + intValue));
                    return;
                case 17:
                    long longValue = ((Long) obj).longValue();
                    m42.z((longValue >> 63) ^ (longValue + longValue));
                    return;
                default:
                    return;
            }
        } else {
            F5 f5 = (F5) obj;
            C1152l5.d(f5);
            m42.i(i5, 3);
            f5.c(m42);
            m42.i(i5, 4);
        }
    }

    static int d(C1162m6 m6Var, int i5, Object obj) {
        int E4 = M4.E(i5 << 3);
        if (m6Var == C1162m6.GROUP) {
            C1152l5.d((F5) obj);
            E4 += E4;
        }
        return E4 + e(m6Var, obj);
    }

    static int e(C1162m6 m6Var, Object obj) {
        int f5;
        int E4;
        C1162m6 m6Var2 = C1162m6.DOUBLE;
        C1171n6 n6Var = C1171n6.INT;
        switch (m6Var.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                int i5 = M4.f5024d;
                return 8;
            case 1:
                ((Float) obj).getClass();
                int i6 = M4.f5024d;
                return 4;
            case 2:
                return M4.a(((Long) obj).longValue());
            case 3:
                return M4.a(((Long) obj).longValue());
            case 4:
                return M4.a((long) ((Integer) obj).intValue());
            case 5:
                ((Long) obj).getClass();
                int i7 = M4.f5024d;
                return 8;
            case 6:
                ((Integer) obj).getClass();
                int i8 = M4.f5024d;
                return 4;
            case 7:
                ((Boolean) obj).getClass();
                int i9 = M4.f5024d;
                return 1;
            case 8:
                if (obj instanceof H4) {
                    int i10 = M4.f5024d;
                    f5 = ((H4) obj).f();
                    E4 = M4.E(f5);
                    break;
                } else {
                    return M4.b((String) obj);
                }
            case 9:
                return ((F5) obj).a();
            case 10:
                return M4.c((F5) obj);
            case 11:
                if (!(obj instanceof H4)) {
                    int i11 = M4.f5024d;
                    f5 = ((byte[]) obj).length;
                    E4 = M4.E(f5);
                    break;
                } else {
                    int i12 = M4.f5024d;
                    f5 = ((H4) obj).f();
                    E4 = M4.E(f5);
                    break;
                }
            case 12:
                return M4.E(((Integer) obj).intValue());
            case 13:
                if (obj instanceof C1107g5) {
                    return M4.a((long) ((C1107g5) obj).A());
                }
                return M4.a((long) ((Integer) obj).intValue());
            case 14:
                ((Integer) obj).getClass();
                int i13 = M4.f5024d;
                return 4;
            case 15:
                ((Long) obj).getClass();
                int i14 = M4.f5024d;
                return 8;
            case 16:
                int intValue = ((Integer) obj).intValue();
                return M4.E((intValue >> 31) ^ (intValue + intValue));
            case 17:
                long longValue = ((Long) obj).longValue();
                return M4.a((longValue >> 63) ^ (longValue + longValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return E4 + f5;
    }

    private static final void f(V4 v42, Object obj) {
        boolean z4;
        C1162m6 B4 = v42.B();
        byte[] bArr = C1152l5.f5434b;
        obj.getClass();
        C1162m6 m6Var = C1162m6.DOUBLE;
        C1171n6 n6Var = C1171n6.INT;
        switch (B4.a().ordinal()) {
            case 0:
                z4 = obj instanceof Integer;
                break;
            case 1:
                z4 = obj instanceof Long;
                break;
            case 2:
                z4 = obj instanceof Float;
                break;
            case 3:
                z4 = obj instanceof Double;
                break;
            case 4:
                z4 = obj instanceof Boolean;
                break;
            case 5:
                z4 = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof H4) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof C1107g5)) {
                    return;
                }
            case 8:
                if (obj instanceof F5) {
                    return;
                }
                break;
        }
        if (z4) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(v42.A()), v42.B().a(), obj.getClass().getName()}));
    }

    public final void a() {
        if (!this.f5201b) {
            Y5 y5 = this.f5200a;
            int c5 = y5.c();
            for (int i5 = 0; i5 < c5; i5++) {
                Object value = y5.e(i5).getValue();
                if (value instanceof C1089e5) {
                    ((C1089e5) value).o();
                }
            }
            for (Map.Entry value2 : y5.f()) {
                Object value3 = value2.getValue();
                if (value3 instanceof C1089e5) {
                    ((C1089e5) value3).o();
                }
            }
            y5.a();
            this.f5201b = true;
        }
    }

    public final void b(V4 v42, Object obj) {
        if (!v42.C()) {
            f(v42, obj);
        } else if (obj instanceof List) {
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i5 = 0; i5 < size; i5++) {
                Object obj2 = list.get(i5);
                f(v42, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        this.f5200a.put(v42, obj);
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        W4 w4 = new W4();
        Y5 y5 = this.f5200a;
        int c5 = y5.c();
        for (int i5 = 0; i5 < c5; i5++) {
            Map.Entry e5 = y5.e(i5);
            a.a(((V5) e5).a());
            w4.b((V4) null, e5.getValue());
        }
        for (Map.Entry entry : y5.f()) {
            a.a(entry.getKey());
            w4.b((V4) null, entry.getValue());
        }
        w4.f5202c = this.f5202c;
        return w4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof W4)) {
            return false;
        }
        return this.f5200a.equals(((W4) obj).f5200a);
    }

    public final int hashCode() {
        return this.f5200a.hashCode();
    }

    private W4(boolean z4) {
        a();
        a();
    }
}
