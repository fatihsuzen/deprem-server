package com.google.android.gms.measurement.internal;

import N.C0722p;
import com.google.android.gms.internal.measurement.F1;
import com.google.android.gms.internal.measurement.L1;
import j$.util.DesugarCollections;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* renamed from: com.google.android.gms.measurement.internal.c  reason: case insensitive filesystem */
abstract class C1293c {

    /* renamed from: a  reason: collision with root package name */
    final String f6230a;

    /* renamed from: b  reason: collision with root package name */
    final int f6231b;

    /* renamed from: c  reason: collision with root package name */
    Boolean f6232c;

    /* renamed from: d  reason: collision with root package name */
    Boolean f6233d;

    /* renamed from: e  reason: collision with root package name */
    Long f6234e;

    /* renamed from: f  reason: collision with root package name */
    Long f6235f;

    C1293c(String str, int i5) {
        this.f6230a = str;
        this.f6231b = i5;
    }

    private static Boolean d(String str, int i5, boolean z4, String str2, List list, String str3, C1402q2 q2Var) {
        int i6;
        if (i5 == 7) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z4 && i5 != 2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i5 - 1) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                if (true != z4) {
                    i6 = 66;
                } else {
                    i6 = 0;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, i6).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (q2Var != null) {
                        q2Var.r().b("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                if (list == null) {
                    return null;
                }
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    static Boolean e(Boolean bool, boolean z4) {
        boolean z5;
        if (bool == null) {
            return null;
        }
        if (bool.booleanValue() != z4) {
            z5 = true;
        } else {
            z5 = false;
        }
        return Boolean.valueOf(z5);
    }

    static Boolean f(String str, L1 l12, C1402q2 q2Var) {
        String H4;
        List list;
        String str2;
        C0722p.k(l12);
        if (str == null || !l12.F() || l12.O() == 1 || (l12.O() != 7 ? !l12.G() : l12.L() == 0)) {
            return null;
        }
        int O4 = l12.O();
        boolean J4 = l12.J();
        if (J4 || O4 == 2 || O4 == 7) {
            H4 = l12.H();
        } else {
            H4 = l12.H().toUpperCase(Locale.ENGLISH);
        }
        String str3 = H4;
        if (l12.L() == 0) {
            list = null;
        } else {
            List<String> K4 = l12.K();
            if (!J4) {
                ArrayList arrayList = new ArrayList(K4.size());
                for (String upperCase : K4) {
                    arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
                }
                K4 = DesugarCollections.unmodifiableList(arrayList);
            }
            list = K4;
        }
        if (O4 == 2) {
            str2 = str3;
        } else {
            str2 = null;
        }
        return d(str, O4, J4, str3, list, str2, q2Var);
    }

    static Boolean g(long j5, F1 f12) {
        try {
            return j(new BigDecimal(j5), f12, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean h(double d5, F1 f12) {
        try {
            return j(new BigDecimal(d5), f12, Math.ulp(d5));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean i(String str, F1 f12) {
        if (!u6.O(str)) {
            return null;
        }
        try {
            return j(new BigDecimal(str), f12, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean j(BigDecimal bigDecimal, F1 f12, double d5) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        C0722p.k(f12);
        if (f12.F()) {
            boolean z4 = true;
            if (f12.Q() != 1) {
                if (f12.Q() == 5) {
                    if (!f12.K() || !f12.M()) {
                        return null;
                    }
                } else if (!f12.I()) {
                    return null;
                }
                int Q4 = f12.Q();
                if (f12.Q() == 5) {
                    if (u6.O(f12.L()) && u6.O(f12.N())) {
                        try {
                            BigDecimal bigDecimal5 = new BigDecimal(f12.L());
                            bigDecimal3 = new BigDecimal(f12.N());
                            bigDecimal2 = bigDecimal5;
                            bigDecimal4 = null;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return null;
                } else if (!u6.O(f12.J())) {
                    return null;
                } else {
                    try {
                        bigDecimal4 = new BigDecimal(f12.J());
                        bigDecimal2 = null;
                        bigDecimal3 = null;
                    } catch (NumberFormatException unused2) {
                    }
                }
                if (Q4 == 5) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                } else if (bigDecimal4 == null) {
                    return null;
                }
                int i5 = Q4 - 1;
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 != 4 || bigDecimal2 == null) {
                                return null;
                            }
                            if (bigDecimal.compareTo(bigDecimal2) < 0 || bigDecimal.compareTo(bigDecimal3) > 0) {
                                z4 = false;
                            }
                            return Boolean.valueOf(z4);
                        } else if (bigDecimal4 == null) {
                            return null;
                        } else {
                            if (d5 != 0.0d) {
                                if (bigDecimal.compareTo(bigDecimal4.subtract(new BigDecimal(d5).multiply(new BigDecimal(2)))) <= 0 || bigDecimal.compareTo(bigDecimal4.add(new BigDecimal(d5).multiply(new BigDecimal(2)))) >= 0) {
                                    z4 = false;
                                }
                                return Boolean.valueOf(z4);
                            }
                            if (bigDecimal.compareTo(bigDecimal4) != 0) {
                                z4 = false;
                            }
                            return Boolean.valueOf(z4);
                        }
                    } else if (bigDecimal4 == null) {
                        return null;
                    } else {
                        if (bigDecimal.compareTo(bigDecimal4) <= 0) {
                            z4 = false;
                        }
                        return Boolean.valueOf(z4);
                    }
                } else if (bigDecimal4 == null) {
                    return null;
                } else {
                    if (bigDecimal.compareTo(bigDecimal4) >= 0) {
                        z4 = false;
                    }
                    return Boolean.valueOf(z4);
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract int a();

    /* access modifiers changed from: package-private */
    public abstract boolean b();

    /* access modifiers changed from: package-private */
    public abstract boolean c();
}
