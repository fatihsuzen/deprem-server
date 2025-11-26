package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

abstract class H5 {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f4960a;

    static {
        char[] cArr = new char[80];
        f4960a = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String a(F5 f5, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        c(f5, sb, 0);
        return sb.toString();
    }

    static void b(StringBuilder sb, int i5, String str, Object obj) {
        if (obj instanceof List) {
            for (Object b5 : (List) obj) {
                b(sb, i5, str, b5);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry b6 : ((Map) obj).entrySet()) {
                b(sb, i5, str, b6);
            }
        } else {
            sb.append(10);
            d(i5, sb);
            if (!str.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Character.toLowerCase(str.charAt(0)));
                for (int i6 = 1; i6 < str.length(); i6++) {
                    char charAt = str.charAt(i6);
                    if (Character.isUpperCase(charAt)) {
                        sb2.append("_");
                    }
                    sb2.append(Character.toLowerCase(charAt));
                }
                str = sb2.toString();
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                H4 h42 = H4.f4958b;
                sb.append(Z5.a(new G4(((String) obj).getBytes(C1152l5.f5433a))));
                sb.append('\"');
            } else if (obj instanceof H4) {
                sb.append(": \"");
                sb.append(Z5.a((H4) obj));
                sb.append('\"');
            } else if (obj instanceof C1089e5) {
                sb.append(" {");
                c((C1089e5) obj, sb, i5 + 2);
                sb.append("\n");
                d(i5, sb);
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                int i7 = i5 + 2;
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                b(sb, i7, "key", entry.getKey());
                b(sb, i7, "value", entry.getValue());
                sb.append("\n");
                d(i5, sb);
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }

    private static void c(F5 f5, StringBuilder sb, int i5) {
        int i6;
        boolean z4;
        Method method;
        Method method2;
        F5 f52 = f5;
        StringBuilder sb2 = sb;
        int i7 = i5;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = f52.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i8 = 0;
        while (true) {
            i6 = 3;
            if (i8 >= length) {
                break;
            }
            Method method3 = declaredMethods[i8];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i8++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i6);
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                b(sb2, i7, substring.substring(0, substring.length() - 4), C1089e5.x(method2, f52, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                b(sb2, i7, substring.substring(0, substring.length() - 3), C1089e5.x(method, f52, new Object[0]));
            } else if (hashSet.contains("set".concat(substring)) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(substring));
                if (method4 != null) {
                    Object x4 = C1089e5.x(method4, f52, new Object[0]);
                    if (method5 == null) {
                        if (x4 instanceof Boolean) {
                            if (!((Boolean) x4).booleanValue()) {
                            }
                        } else if (x4 instanceof Integer) {
                            if (((Integer) x4).intValue() == 0) {
                            }
                        } else if (x4 instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) x4).floatValue()) == 0) {
                            }
                        } else if (!(x4 instanceof Double)) {
                            if (x4 instanceof String) {
                                z4 = x4.equals("");
                            } else if (x4 instanceof H4) {
                                z4 = x4.equals(H4.f4958b);
                            } else if (x4 instanceof F5) {
                                if (x4 == ((F5) x4).d()) {
                                }
                            } else if ((x4 instanceof Enum) && ((Enum) x4).ordinal() == 0) {
                            }
                            if (z4) {
                            }
                        } else if (Double.doubleToRawLongBits(((Double) x4).doubleValue()) == 0) {
                        }
                    } else if (!((Boolean) C1089e5.x(method5, f52, new Object[0])).booleanValue()) {
                    }
                    b(sb2, i7, substring, x4);
                }
            }
            i6 = 3;
        }
        C1072c6 c6Var = ((C1089e5) f52).zzc;
        if (c6Var != null) {
            c6Var.i(sb2, i7);
        }
    }

    private static void d(int i5, StringBuilder sb) {
        while (i5 > 0) {
            int i6 = 80;
            if (i5 <= 80) {
                i6 = i5;
            }
            sb.append(f4960a, 0, i6);
            i5 -= i6;
        }
    }
}
