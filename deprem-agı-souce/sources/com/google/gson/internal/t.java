package com.google.gson.internal;

import android.support.v4.media.a;
import com.google.gson.i;
import com.google.gson.q;
import com.google.gson.reflect.TypeToken;
import i1.C1677a;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListMap;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    private final Map f7770a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f7771b;

    /* renamed from: c  reason: collision with root package name */
    private final List f7772c;

    public t(Map map, boolean z4, List list) {
        this.f7770a = map;
        this.f7771b = z4;
        this.f7772c = list;
    }

    private static A A(Type type, Class cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new s(type);
        }
        if (cls == EnumMap.class) {
            return new C1578b(type);
        }
        return null;
    }

    private A B(Class cls) {
        if (this.f7771b) {
            return new q(cls);
        }
        String str = "Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
        if (cls.getDeclaredConstructors().length == 0) {
            str = str + " Or adjust your R8 configuration to keep the no-args constructor of the class.";
        }
        return new r(str);
    }

    public static /* synthetic */ Map a() {
        return new ConcurrentHashMap();
    }

    public static /* synthetic */ Collection b() {
        return new ArrayList();
    }

    public static /* synthetic */ Map c() {
        return new LinkedHashMap();
    }

    public static /* synthetic */ Object d(String str) {
        throw new i(str);
    }

    public static /* synthetic */ Object e(Class cls) {
        try {
            return G.f7598a.d(cls);
        } catch (Exception e5) {
            throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e5);
        }
    }

    public static /* synthetic */ Object f(Type type) {
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return new EnumMap((Class) type2);
            }
            throw new i("Invalid EnumMap type: " + type.toString());
        }
        throw new i("Invalid EnumMap type: " + type.toString());
    }

    public static /* synthetic */ Map g() {
        return new ConcurrentSkipListMap();
    }

    public static /* synthetic */ Map h() {
        return new TreeMap();
    }

    public static /* synthetic */ Object i(String str) {
        throw new i(str);
    }

    public static /* synthetic */ Collection j() {
        return new LinkedHashSet();
    }

    public static /* synthetic */ Object k(Type type) {
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return EnumSet.noneOf((Class) type2);
            }
            throw new i("Invalid EnumSet type: " + type.toString());
        }
        throw new i("Invalid EnumSet type: " + type.toString());
    }

    public static /* synthetic */ Object l(String str) {
        throw new i(str);
    }

    public static /* synthetic */ Object m(String str) {
        throw new i(str);
    }

    public static /* synthetic */ Map n() {
        return new y();
    }

    public static /* synthetic */ Object o(String str) {
        throw new i(str);
    }

    public static /* synthetic */ Collection p() {
        return new TreeSet();
    }

    public static /* synthetic */ Object q(Constructor constructor) {
        try {
            return constructor.newInstance((Object[]) null);
        } catch (InstantiationException e5) {
            throw new RuntimeException("Failed to invoke constructor '" + C1677a.c(constructor) + "' with no args", e5);
        } catch (InvocationTargetException e6) {
            throw new RuntimeException("Failed to invoke constructor '" + C1677a.c(constructor) + "' with no args", e6.getCause());
        } catch (IllegalAccessException e7) {
            throw C1677a.e(e7);
        }
    }

    public static /* synthetic */ Collection r() {
        return new ArrayDeque();
    }

    public static /* synthetic */ Object s(String str) {
        throw new i(str);
    }

    static String t(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        } else if (!Modifier.isAbstract(modifiers)) {
            return null;
        } else {
            return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName() + "\nSee " + F.a("r8-abstract-class");
        }
    }

    private static boolean v(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return true;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length != 0 && u.k(actualTypeArguments[0]) == String.class) {
            return true;
        }
        return false;
    }

    private static A w(Class cls) {
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new m();
        }
        if (cls.isAssignableFrom(LinkedHashSet.class)) {
            return new n();
        }
        if (cls.isAssignableFrom(TreeSet.class)) {
            return new o();
        }
        if (cls.isAssignableFrom(ArrayDeque.class)) {
            return new p();
        }
        return null;
    }

    private static A x(Class cls, q qVar) {
        String p5;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor((Class[]) null);
            q qVar2 = q.ALLOW;
            if (qVar != qVar2 && (!D.a(declaredConstructor, (Object) null) || (qVar == q.BLOCK_ALL && !Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return new h("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
            } else if (qVar != qVar2 || (p5 = C1677a.p(declaredConstructor)) == null) {
                return new j(declaredConstructor);
            } else {
                return new i(p5);
            }
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static A y(Type type, Class cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return w(cls);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return z(type, cls);
        }
        return null;
    }

    private static A z(Type type, Class cls) {
        if (cls.isAssignableFrom(y.class) && v(type)) {
            return new C1579c();
        }
        if (cls.isAssignableFrom(LinkedHashMap.class)) {
            return new C1580d();
        }
        if (cls.isAssignableFrom(TreeMap.class)) {
            return new C1581e();
        }
        if (cls.isAssignableFrom(ConcurrentHashMap.class)) {
            return new C1582f();
        }
        if (cls.isAssignableFrom(ConcurrentSkipListMap.class)) {
            return new C1583g();
        }
        return null;
    }

    public String toString() {
        return this.f7770a.toString();
    }

    public A u(TypeToken typeToken, boolean z4) {
        Type d5 = typeToken.d();
        Class c5 = typeToken.c();
        a.a(this.f7770a.get(d5));
        a.a(this.f7770a.get(c5));
        A A4 = A(d5, c5);
        if (A4 != null) {
            return A4;
        }
        q b5 = D.b(this.f7772c, c5);
        A x4 = x(c5, b5);
        if (x4 != null) {
            return x4;
        }
        A y4 = y(d5, c5);
        if (y4 != null) {
            return y4;
        }
        String t5 = t(c5);
        if (t5 != null) {
            return new C1577a(t5);
        }
        if (!z4) {
            return new k("Unable to create instance of " + c5 + "; Register an InstanceCreator or a TypeAdapter for this type.");
        } else if (b5 == q.ALLOW) {
            return B(c5);
        } else {
            return new l("Unable to create instance of " + c5 + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
        }
    }
}
