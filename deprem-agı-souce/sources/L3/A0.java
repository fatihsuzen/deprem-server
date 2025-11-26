package L3;

import H3.b;
import H3.d;
import H3.g;
import H3.j;
import I3.a;
import W2.A;
import W2.B;
import W2.C;
import W2.C2219h;
import W2.D;
import W2.E;
import W2.G;
import W2.H;
import W2.J;
import W2.z;
import X2.M;
import j3.C2582a;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.C2626d;
import kotlin.jvm.internal.C2627e;
import kotlin.jvm.internal.C2629g;
import kotlin.jvm.internal.C2634l;
import kotlin.jvm.internal.C2635m;
import kotlin.jvm.internal.C2640s;
import kotlin.jvm.internal.O;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import r3.C2733c;
import u3.C2795a;
import v3.C2803a;

public abstract class A0 {
    private static final Object a(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get((Object) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final b b(C2733c cVar) {
        t.e(cVar, "<this>");
        return d(cVar, new b[0]);
    }

    public static final b c(Class cls, b... bVarArr) {
        t.e(cls, "<this>");
        t.e(bVarArr, "args");
        if (cls.isEnum() && m(cls)) {
            return e(cls);
        }
        b k5 = k(cls, (b[]) Arrays.copyOf(bVarArr, bVarArr.length));
        if (k5 != null) {
            return k5;
        }
        b h5 = h(cls);
        if (h5 != null) {
            return h5;
        }
        b f5 = f(cls, (b[]) Arrays.copyOf(bVarArr, bVarArr.length));
        if (f5 != null) {
            return f5;
        }
        if (n(cls)) {
            return new g(C2582a.c(cls));
        }
        return null;
    }

    public static final b d(C2733c cVar, b... bVarArr) {
        t.e(cVar, "<this>");
        t.e(bVarArr, "args");
        return c(C2582a.a(cVar), (b[]) Arrays.copyOf(bVarArr, bVarArr.length));
    }

    private static final b e(Class cls) {
        Object[] enumConstants = cls.getEnumConstants();
        String canonicalName = cls.getCanonicalName();
        t.d(canonicalName, "getCanonicalName(...)");
        t.c(enumConstants, "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
        return new I(canonicalName, (Enum[]) enumConstants);
    }

    private static final b f(Class cls, b... bVarArr) {
        Object obj;
        Field field;
        b j5;
        Object g5 = g(cls);
        if (g5 != null && (j5 = j(g5, (b[]) Arrays.copyOf(bVarArr, bVarArr.length))) != null) {
            return j5;
        }
        try {
            Class[] declaredClasses = cls.getDeclaredClasses();
            t.d(declaredClasses, "getDeclaredClasses(...)");
            int length = declaredClasses.length;
            int i5 = 0;
            Class cls2 = null;
            boolean z4 = false;
            while (true) {
                if (i5 < length) {
                    Class cls3 = declaredClasses[i5];
                    if (t.a(cls3.getSimpleName(), "$serializer")) {
                        if (z4) {
                            break;
                        }
                        z4 = true;
                        cls2 = cls3;
                    }
                    i5++;
                } else if (!z4) {
                }
            }
            cls2 = null;
            if (cls2 == null || (field = cls2.getField("INSTANCE")) == null) {
                obj = null;
            } else {
                obj = field.get((Object) null);
            }
            if (obj instanceof b) {
                return (b) obj;
            }
        } catch (NoSuchFieldException unused) {
        }
        return null;
    }

    private static final Object g(Class cls) {
        Class cls2;
        Class[] declaredClasses = cls.getDeclaredClasses();
        t.d(declaredClasses, "getDeclaredClasses(...)");
        int length = declaredClasses.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                cls2 = null;
                break;
            }
            cls2 = declaredClasses[i5];
            if (cls2.getAnnotation(C2103n0.class) != null) {
                break;
            }
            i5++;
        }
        if (cls2 == null) {
            return null;
        }
        String simpleName = cls2.getSimpleName();
        t.d(simpleName, "getSimpleName(...)");
        return a(cls, simpleName);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        if (r5 == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009d, code lost:
        if (r4 == false) goto L_0x0096;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final H3.b h(java.lang.Class r11) {
        /*
            java.lang.String r0 = r11.getCanonicalName()
            r1 = 0
            if (r0 == 0) goto L_0x00ae
            java.lang.String r2 = "java."
            r3 = 0
            r4 = 2
            boolean r2 = t3.s.P(r0, r2, r3, r4, r1)
            if (r2 != 0) goto L_0x00ae
            java.lang.String r2 = "kotlin."
            boolean r0 = t3.s.P(r0, r2, r3, r4, r1)
            if (r0 == 0) goto L_0x001b
            goto L_0x00ae
        L_0x001b:
            java.lang.reflect.Field[] r0 = r11.getDeclaredFields()
            java.lang.String r2 = "getDeclaredFields(...)"
            kotlin.jvm.internal.t.d(r0, r2)
            int r2 = r0.length
            r6 = r1
            r4 = r3
            r5 = r4
        L_0x0028:
            r7 = 1
            if (r4 >= r2) goto L_0x0056
            r8 = r0[r4]
            java.lang.String r9 = r8.getName()
            java.lang.String r10 = "INSTANCE"
            boolean r9 = kotlin.jvm.internal.t.a(r9, r10)
            if (r9 == 0) goto L_0x0053
            java.lang.Class r9 = r8.getType()
            boolean r9 = kotlin.jvm.internal.t.a(r9, r11)
            if (r9 == 0) goto L_0x0053
            int r9 = r8.getModifiers()
            boolean r9 = java.lang.reflect.Modifier.isStatic(r9)
            if (r9 == 0) goto L_0x0053
            if (r5 == 0) goto L_0x0051
        L_0x004f:
            r6 = r1
            goto L_0x0059
        L_0x0051:
            r5 = r7
            r6 = r8
        L_0x0053:
            int r4 = r4 + 1
            goto L_0x0028
        L_0x0056:
            if (r5 != 0) goto L_0x0059
            goto L_0x004f
        L_0x0059:
            if (r6 != 0) goto L_0x005c
            return r1
        L_0x005c:
            java.lang.Object r0 = r6.get(r1)
            java.lang.reflect.Method[] r11 = r11.getMethods()
            java.lang.String r2 = "getMethods(...)"
            kotlin.jvm.internal.t.d(r11, r2)
            int r2 = r11.length
            r5 = r1
            r4 = r3
        L_0x006c:
            if (r3 >= r2) goto L_0x009d
            r6 = r11[r3]
            java.lang.String r8 = r6.getName()
            java.lang.String r9 = "serializer"
            boolean r8 = kotlin.jvm.internal.t.a(r8, r9)
            if (r8 == 0) goto L_0x009a
            java.lang.Class[] r8 = r6.getParameterTypes()
            java.lang.String r9 = "getParameterTypes(...)"
            kotlin.jvm.internal.t.d(r8, r9)
            int r8 = r8.length
            if (r8 != 0) goto L_0x009a
            java.lang.Class r8 = r6.getReturnType()
            java.lang.Class<H3.b> r9 = H3.b.class
            boolean r8 = kotlin.jvm.internal.t.a(r8, r9)
            if (r8 == 0) goto L_0x009a
            if (r4 == 0) goto L_0x0098
        L_0x0096:
            r5 = r1
            goto L_0x00a0
        L_0x0098:
            r5 = r6
            r4 = r7
        L_0x009a:
            int r3 = r3 + 1
            goto L_0x006c
        L_0x009d:
            if (r4 != 0) goto L_0x00a0
            goto L_0x0096
        L_0x00a0:
            if (r5 != 0) goto L_0x00a3
            return r1
        L_0x00a3:
            java.lang.Object r11 = r5.invoke(r0, r1)
            boolean r0 = r11 instanceof H3.b
            if (r0 == 0) goto L_0x00ae
            H3.b r11 = (H3.b) r11
            return r11
        L_0x00ae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: L3.A0.h(java.lang.Class):H3.b");
    }

    public static final Map i() {
        Map c5 = M.c();
        c5.put(kotlin.jvm.internal.M.b(String.class), a.H(Q.f24695a));
        c5.put(kotlin.jvm.internal.M.b(Character.TYPE), a.B(C2629g.f24708a));
        c5.put(kotlin.jvm.internal.M.b(char[].class), a.d());
        c5.put(kotlin.jvm.internal.M.b(Double.TYPE), a.C(C2634l.f24717a));
        c5.put(kotlin.jvm.internal.M.b(double[].class), a.e());
        c5.put(kotlin.jvm.internal.M.b(Float.TYPE), a.D(C2635m.f24718a));
        c5.put(kotlin.jvm.internal.M.b(float[].class), a.f());
        c5.put(kotlin.jvm.internal.M.b(Long.TYPE), a.F(v.f24720a));
        c5.put(kotlin.jvm.internal.M.b(long[].class), a.i());
        c5.put(kotlin.jvm.internal.M.b(D.class), a.w(D.f19931b));
        c5.put(kotlin.jvm.internal.M.b(Integer.TYPE), a.E(C2640s.f24719a));
        c5.put(kotlin.jvm.internal.M.b(int[].class), a.g());
        c5.put(kotlin.jvm.internal.M.b(B.class), a.v(B.f19926b));
        c5.put(kotlin.jvm.internal.M.b(Short.TYPE), a.G(O.f24693a));
        c5.put(kotlin.jvm.internal.M.b(short[].class), a.n());
        c5.put(kotlin.jvm.internal.M.b(G.class), a.x(G.f19937b));
        c5.put(kotlin.jvm.internal.M.b(Byte.TYPE), a.A(C2627e.f24706a));
        c5.put(kotlin.jvm.internal.M.b(byte[].class), a.c());
        c5.put(kotlin.jvm.internal.M.b(z.class), a.u(z.f19980b));
        c5.put(kotlin.jvm.internal.M.b(Boolean.TYPE), a.z(C2626d.f24705a));
        c5.put(kotlin.jvm.internal.M.b(boolean[].class), a.b());
        c5.put(kotlin.jvm.internal.M.b(J.class), a.y(J.f19942a));
        c5.put(kotlin.jvm.internal.M.b(Void.class), a.l());
        try {
            c5.put(kotlin.jvm.internal.M.b(C2795a.class), a.I(C2795a.f25994b));
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        try {
            c5.put(kotlin.jvm.internal.M.b(E.class), a.r());
        } catch (ClassNotFoundException | NoClassDefFoundError unused2) {
        }
        try {
            c5.put(kotlin.jvm.internal.M.b(C.class), a.q());
        } catch (ClassNotFoundException | NoClassDefFoundError unused3) {
        }
        try {
            c5.put(kotlin.jvm.internal.M.b(H.class), a.s());
        } catch (ClassNotFoundException | NoClassDefFoundError unused4) {
        }
        try {
            c5.put(kotlin.jvm.internal.M.b(A.class), a.p());
        } catch (ClassNotFoundException | NoClassDefFoundError unused5) {
        }
        try {
            c5.put(kotlin.jvm.internal.M.b(C2803a.class), a.J(C2803a.f26045c));
        } catch (ClassNotFoundException | NoClassDefFoundError unused6) {
        }
        return M.b(c5);
    }

    private static final b j(Object obj, b... bVarArr) {
        Class[] clsArr;
        try {
            if (bVarArr.length == 0) {
                clsArr = new Class[0];
            } else {
                int length = bVarArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i5 = 0; i5 < length; i5++) {
                    clsArr2[i5] = b.class;
                }
                clsArr = clsArr2;
            }
            Object invoke = obj.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(clsArr, clsArr.length)).invoke(obj, Arrays.copyOf(bVarArr, bVarArr.length));
            if (invoke instanceof b) {
                return (b) invoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e5) {
            Throwable cause = e5.getCause();
            if (cause != null) {
                String message = cause.getMessage();
                if (message == null) {
                    message = e5.getMessage();
                }
                throw new InvocationTargetException(cause, message);
            }
            throw e5;
        }
    }

    private static final b k(Class cls, b... bVarArr) {
        Object a5 = a(cls, "Companion");
        if (a5 == null) {
            return null;
        }
        return j(a5, (b[]) Arrays.copyOf(bVarArr, bVarArr.length));
    }

    public static final boolean l(C2733c cVar) {
        t.e(cVar, "<this>");
        return C2582a.a(cVar).isInterface();
    }

    private static final boolean m(Class cls) {
        if (cls.getAnnotation(j.class) == null && cls.getAnnotation(d.class) == null) {
            return true;
        }
        return false;
    }

    private static final boolean n(Class cls) {
        if (cls.getAnnotation(d.class) != null) {
            return true;
        }
        j jVar = (j) cls.getAnnotation(j.class);
        if (jVar == null || !t.a(kotlin.jvm.internal.M.b(jVar.with()), kotlin.jvm.internal.M.b(g.class))) {
            return false;
        }
        return true;
    }

    public static final boolean o(C2733c cVar) {
        t.e(cVar, "rootClass");
        return C2582a.a(cVar).isArray();
    }

    public static final Void p(C2733c cVar) {
        t.e(cVar, "<this>");
        B0.f(cVar);
        throw new C2219h();
    }

    public static final Object[] q(ArrayList arrayList, C2733c cVar) {
        t.e(arrayList, "<this>");
        t.e(cVar, "eClass");
        Object newInstance = Array.newInstance(C2582a.a(cVar), arrayList.size());
        t.c(newInstance, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        Object[] array = arrayList.toArray((Object[]) newInstance);
        t.d(array, "toArray(...)");
        return array;
    }
}
