package X2;

import W2.A;
import W2.C;
import W2.E;
import W2.H;
import W2.J;
import Z2.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.t;
import q3.C2729e;

/* renamed from: X2.k  reason: case insensitive filesystem */
abstract class C2244k extends C2243j {
    public static boolean d(Object[] objArr, Object[] objArr2) {
        if (objArr == objArr2) {
            return true;
        }
        if (objArr == null || objArr2 == null || objArr.length != objArr2.length) {
            return false;
        }
        int length = objArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            Object[] objArr3 = objArr[i5];
            Object[] objArr4 = objArr2[i5];
            if (objArr3 != objArr4) {
                if (objArr3 == null || objArr4 == null) {
                    return false;
                }
                if (!(objArr3 instanceof Object[]) || !(objArr4 instanceof Object[])) {
                    if (!(objArr3 instanceof byte[]) || !(objArr4 instanceof byte[])) {
                        if (!(objArr3 instanceof short[]) || !(objArr4 instanceof short[])) {
                            if (!(objArr3 instanceof int[]) || !(objArr4 instanceof int[])) {
                                if (!(objArr3 instanceof long[]) || !(objArr4 instanceof long[])) {
                                    if (!(objArr3 instanceof float[]) || !(objArr4 instanceof float[])) {
                                        if (!(objArr3 instanceof double[]) || !(objArr4 instanceof double[])) {
                                            if (!(objArr3 instanceof char[]) || !(objArr4 instanceof char[])) {
                                                if (!(objArr3 instanceof boolean[]) || !(objArr4 instanceof boolean[])) {
                                                    if (!(objArr3 instanceof A) || !(objArr4 instanceof A)) {
                                                        if (!(objArr3 instanceof H) || !(objArr4 instanceof H)) {
                                                            if (!(objArr3 instanceof C) || !(objArr4 instanceof C)) {
                                                                if (!(objArr3 instanceof E) || !(objArr4 instanceof E)) {
                                                                    if (!t.a(objArr3, objArr4)) {
                                                                        return false;
                                                                    }
                                                                } else if (!a.d(((E) objArr3).v(), ((E) objArr4).v())) {
                                                                    return false;
                                                                }
                                                            } else if (!a.b(((C) objArr3).v(), ((C) objArr4).v())) {
                                                                return false;
                                                            }
                                                        } else if (!a.a(((H) objArr3).v(), ((H) objArr4).v())) {
                                                            return false;
                                                        }
                                                    } else if (!a.c(((A) objArr3).v(), ((A) objArr4).v())) {
                                                        return false;
                                                    }
                                                } else if (!Arrays.equals((boolean[]) objArr3, (boolean[]) objArr4)) {
                                                    return false;
                                                }
                                            } else if (!Arrays.equals((char[]) objArr3, (char[]) objArr4)) {
                                                return false;
                                            }
                                        } else if (!Arrays.equals((double[]) objArr3, (double[]) objArr4)) {
                                            return false;
                                        }
                                    } else if (!Arrays.equals((float[]) objArr3, (float[]) objArr4)) {
                                        return false;
                                    }
                                } else if (!Arrays.equals((long[]) objArr3, (long[]) objArr4)) {
                                    return false;
                                }
                            } else if (!Arrays.equals((int[]) objArr3, (int[]) objArr4)) {
                                return false;
                            }
                        } else if (!Arrays.equals((short[]) objArr3, (short[]) objArr4)) {
                            return false;
                        }
                    } else if (!Arrays.equals((byte[]) objArr3, (byte[]) objArr4)) {
                        return false;
                    }
                } else if (!d(objArr3, objArr4)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String e(Object[] objArr) {
        if (objArr == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder((C2729e.e(objArr.length, 429496729) * 5) + 2);
        f(objArr, sb, new ArrayList());
        return sb.toString();
    }

    private static final void f(Object[] objArr, StringBuilder sb, List list) {
        if (list.contains(objArr)) {
            sb.append("[...]");
            return;
        }
        list.add(objArr);
        sb.append('[');
        int length = objArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (i5 != 0) {
                sb.append(", ");
            }
            Object[] objArr2 = objArr[i5];
            if (objArr2 == null) {
                sb.append("null");
            } else if (objArr2 instanceof Object[]) {
                f(objArr2, sb, list);
                J j5 = J.f19942a;
            } else if (objArr2 instanceof byte[]) {
                String arrays = Arrays.toString((byte[]) objArr2);
                t.d(arrays, "toString(...)");
                sb.append(arrays);
            } else if (objArr2 instanceof short[]) {
                String arrays2 = Arrays.toString((short[]) objArr2);
                t.d(arrays2, "toString(...)");
                sb.append(arrays2);
            } else if (objArr2 instanceof int[]) {
                String arrays3 = Arrays.toString((int[]) objArr2);
                t.d(arrays3, "toString(...)");
                sb.append(arrays3);
            } else if (objArr2 instanceof long[]) {
                String arrays4 = Arrays.toString((long[]) objArr2);
                t.d(arrays4, "toString(...)");
                sb.append(arrays4);
            } else if (objArr2 instanceof float[]) {
                String arrays5 = Arrays.toString((float[]) objArr2);
                t.d(arrays5, "toString(...)");
                sb.append(arrays5);
            } else if (objArr2 instanceof double[]) {
                String arrays6 = Arrays.toString((double[]) objArr2);
                t.d(arrays6, "toString(...)");
                sb.append(arrays6);
            } else if (objArr2 instanceof char[]) {
                String arrays7 = Arrays.toString((char[]) objArr2);
                t.d(arrays7, "toString(...)");
                sb.append(arrays7);
            } else if (objArr2 instanceof boolean[]) {
                String arrays8 = Arrays.toString((boolean[]) objArr2);
                t.d(arrays8, "toString(...)");
                sb.append(arrays8);
            } else if (objArr2 instanceof A) {
                sb.append(a.e(((A) objArr2).v()));
            } else if (objArr2 instanceof H) {
                sb.append(a.g(((H) objArr2).v()));
            } else if (objArr2 instanceof C) {
                sb.append(a.f(((C) objArr2).v()));
            } else if (objArr2 instanceof E) {
                sb.append(a.h(((E) objArr2).v()));
            } else {
                sb.append(objArr2.toString());
            }
        }
        sb.append(']');
        list.remove(C2251s.i(list));
    }
}
