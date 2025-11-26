package kotlin.jvm.internal;

import W2.y;
import X2.C2250q;
import X2.M;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import j3.C2582a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import k3.C2616a;
import k3.C2617b;
import k3.C2618c;
import k3.C2619d;
import k3.C2620e;
import k3.C2621f;
import k3.g;
import k3.h;
import k3.i;
import k3.j;
import k3.k;
import k3.l;
import k3.m;
import k3.n;
import k3.o;
import k3.p;
import k3.q;
import k3.r;
import k3.t;
import k3.u;
import k3.v;
import k3.w;
import r3.C2733c;
import t3.s;

/* renamed from: kotlin.jvm.internal.i  reason: case insensitive filesystem */
public final class C2631i implements C2733c, C2630h {

    /* renamed from: b  reason: collision with root package name */
    public static final a f24709b = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final Map f24710c;

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap f24711d;

    /* renamed from: e  reason: collision with root package name */
    private static final HashMap f24712e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap f24713f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final Map f24714g;

    /* renamed from: a  reason: collision with root package name */
    private final Class f24715a;

    /* renamed from: kotlin.jvm.internal.i$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final String a(Class cls) {
            String str;
            t.e(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                if (componentType.isPrimitive() && (str = (String) C2631i.f24713f.get(componentType.getName())) != null) {
                    str2 = str + "Array";
                }
                if (str2 == null) {
                    return "kotlin.Array";
                }
                return str2;
            }
            String str3 = (String) C2631i.f24713f.get(cls.getName());
            if (str3 == null) {
                return cls.getCanonicalName();
            }
            return str3;
        }

        public final String b(Class cls) {
            String str;
            t.e(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass()) {
                return null;
            }
            if (cls.isLocalClass()) {
                String simpleName = cls.getSimpleName();
                Method enclosingMethod = cls.getEnclosingMethod();
                if (enclosingMethod != null) {
                    t.b(simpleName);
                    String O02 = s.O0(simpleName, enclosingMethod.getName() + '$', (String) null, 2, (Object) null);
                    if (O02 != null) {
                        return O02;
                    }
                }
                Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
                if (enclosingConstructor != null) {
                    t.b(simpleName);
                    return s.O0(simpleName, enclosingConstructor.getName() + '$', (String) null, 2, (Object) null);
                }
                t.b(simpleName);
                return s.N0(simpleName, '$', (String) null, 2, (Object) null);
            } else if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                if (componentType.isPrimitive() && (str = (String) C2631i.f24714g.get(componentType.getName())) != null) {
                    str2 = str + "Array";
                }
                if (str2 == null) {
                    return "Array";
                }
                return str2;
            } else {
                String str3 = (String) C2631i.f24714g.get(cls.getName());
                if (str3 == null) {
                    return cls.getSimpleName();
                }
                return str3;
            }
        }

        public final boolean c(Object obj, Class cls) {
            t.e(cls, "jClass");
            Map j5 = C2631i.f24710c;
            t.c(j5, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) j5.get(cls);
            if (num != null) {
                return S.g(obj, num.intValue());
            }
            if (cls.isPrimitive()) {
                cls = C2582a.b(C2582a.c(cls));
            }
            return cls.isInstance(obj);
        }

        private a() {
        }
    }

    static {
        int i5 = 0;
        Iterable j5 = C2250q.j(C2616a.class, l.class, p.class, q.class, r.class, k3.s.class, t.class, u.class, v.class, w.class, C2617b.class, C2618c.class, C2619d.class, C2620e.class, C2621f.class, g.class, h.class, i.class, j.class, k.class, m.class, n.class, o.class);
        ArrayList arrayList = new ArrayList(C2250q.p(j5, 10));
        for (Object next : j5) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                C2250q.o();
            }
            arrayList.add(y.a((Class) next, Integer.valueOf(i5)));
            i5 = i6;
        }
        f24710c = M.r(arrayList);
        HashMap hashMap = new HashMap();
        hashMap.put(TypedValues.Custom.S_BOOLEAN, "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put(TypedValues.Custom.S_FLOAT, "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f24711d = hashMap;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f24712e = hashMap2;
        HashMap hashMap3 = new HashMap();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        t.d(values, "<get-values>(...)");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            t.b(str);
            sb.append(s.Q0(str, '.', (String) null, 2, (Object) null));
            sb.append("CompanionObject");
            String sb2 = sb.toString();
            W2.s a5 = y.a(sb2, str + ".Companion");
            hashMap3.put(a5.c(), a5.d());
        }
        for (Map.Entry entry : f24710c.entrySet()) {
            int intValue = ((Number) entry.getValue()).intValue();
            String name = ((Class) entry.getKey()).getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        f24713f = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(M.e(hashMap3.size()));
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            Object key = entry2.getKey();
            String str2 = (String) entry2.getValue();
            t.b(str2);
            linkedHashMap.put(key, s.Q0(str2, '.', (String) null, 2, (Object) null));
        }
        f24714g = linkedHashMap;
    }

    public C2631i(Class cls) {
        t.e(cls, "jClass");
        this.f24715a = cls;
    }

    public String a() {
        return f24709b.a(g());
    }

    public String c() {
        return f24709b.b(g());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2631i) || !t.a(C2582a.b(this), C2582a.b((C2733c) obj))) {
            return false;
        }
        return true;
    }

    public boolean f(Object obj) {
        return f24709b.c(obj, g());
    }

    public Class g() {
        return this.f24715a;
    }

    public int hashCode() {
        return C2582a.b(this).hashCode();
    }

    public String toString() {
        return g() + " (Kotlin reflection is not available)";
    }
}
