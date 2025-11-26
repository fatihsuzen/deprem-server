package i1;

import com.google.gson.i;
import com.google.gson.internal.F;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* renamed from: i1.a  reason: case insensitive filesystem */
public abstract class C1677a {

    /* renamed from: a  reason: collision with root package name */
    private static final b f15382a;

    /* renamed from: i1.a$b */
    private static abstract class b {
        private b() {
        }

        /* access modifiers changed from: package-private */
        public abstract Method a(Class cls, Field field);

        /* access modifiers changed from: package-private */
        public abstract Constructor b(Class cls);

        /* access modifiers changed from: package-private */
        public abstract String[] c(Class cls);

        /* access modifiers changed from: package-private */
        public abstract boolean d(Class cls);
    }

    /* renamed from: i1.a$c */
    private static class c extends b {
        private c() {
            super();
        }

        public Method a(Class cls, Field field) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        /* access modifiers changed from: package-private */
        public Constructor b(Class cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        /* access modifiers changed from: package-private */
        public String[] c(Class cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        /* access modifiers changed from: package-private */
        public boolean d(Class cls) {
            return false;
        }
    }

    /* renamed from: i1.a$d */
    private static class d extends b {

        /* renamed from: a  reason: collision with root package name */
        private final Method f15383a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f15384b;

        /* renamed from: c  reason: collision with root package name */
        private final Method f15385c;

        /* renamed from: d  reason: collision with root package name */
        private final Method f15386d;

        public Method a(Class cls, Field field) {
            try {
                return cls.getMethod(field.getName(), (Class[]) null);
            } catch (ReflectiveOperationException e5) {
                throw C1677a.d(e5);
            }
        }

        public Constructor b(Class cls) {
            try {
                Object[] objArr = (Object[]) this.f15384b.invoke(cls, (Object[]) null);
                Class[] clsArr = new Class[objArr.length];
                for (int i5 = 0; i5 < objArr.length; i5++) {
                    clsArr[i5] = (Class) this.f15386d.invoke(objArr[i5], (Object[]) null);
                }
                return cls.getDeclaredConstructor(clsArr);
            } catch (ReflectiveOperationException e5) {
                throw C1677a.d(e5);
            }
        }

        /* access modifiers changed from: package-private */
        public String[] c(Class cls) {
            try {
                Object[] objArr = (Object[]) this.f15384b.invoke(cls, (Object[]) null);
                String[] strArr = new String[objArr.length];
                for (int i5 = 0; i5 < objArr.length; i5++) {
                    strArr[i5] = (String) this.f15385c.invoke(objArr[i5], (Object[]) null);
                }
                return strArr;
            } catch (ReflectiveOperationException e5) {
                throw C1677a.d(e5);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(Class cls) {
            try {
                return ((Boolean) this.f15383a.invoke(cls, (Object[]) null)).booleanValue();
            } catch (ReflectiveOperationException e5) {
                throw C1677a.d(e5);
            }
        }

        private d() {
            super();
            Class<Class> cls = Class.class;
            this.f15383a = cls.getMethod("isRecord", (Class[]) null);
            this.f15384b = cls.getMethod("getRecordComponents", (Class[]) null);
            Class<?> cls2 = Class.forName("java.lang.reflect.RecordComponent");
            this.f15385c = cls2.getMethod("getName", (Class[]) null);
            this.f15386d = cls2.getMethod("getType", (Class[]) null);
        }
    }

    static {
        b bVar;
        try {
            bVar = new d();
        } catch (ReflectiveOperationException unused) {
            bVar = new c();
        }
        f15382a = bVar;
    }

    private static void b(AccessibleObject accessibleObject, StringBuilder sb) {
        Class[] clsArr;
        sb.append('(');
        if (accessibleObject instanceof Method) {
            clsArr = ((Method) accessibleObject).getParameterTypes();
        } else {
            clsArr = ((Constructor) accessibleObject).getParameterTypes();
        }
        for (int i5 = 0; i5 < clsArr.length; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            sb.append(clsArr[i5].getSimpleName());
        }
        sb.append(')');
    }

    public static String c(Constructor constructor) {
        StringBuilder sb = new StringBuilder(constructor.getDeclaringClass().getName());
        b(constructor, sb);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public static RuntimeException d(ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.13.2). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", reflectiveOperationException);
    }

    public static RuntimeException e(IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException);
    }

    public static String f(Field field) {
        return field.getDeclaringClass().getName() + "#" + field.getName();
    }

    public static String g(AccessibleObject accessibleObject, boolean z4) {
        String str;
        if (accessibleObject instanceof Field) {
            str = "field '" + f((Field) accessibleObject) + "'";
        } else if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            StringBuilder sb = new StringBuilder(method.getName());
            b(method, sb);
            str = "method '" + method.getDeclaringClass().getName() + "#" + sb.toString() + "'";
        } else if (accessibleObject instanceof Constructor) {
            str = "constructor '" + c((Constructor) accessibleObject) + "'";
        } else {
            str = "<unknown AccessibleObject> " + accessibleObject.toString();
        }
        if (!z4 || !Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public static Method h(Class cls, Field field) {
        return f15382a.a(cls, field);
    }

    public static Constructor i(Class cls) {
        return f15382a.b(cls);
    }

    private static String j(Exception exc) {
        String str;
        if (!exc.getClass().getName().equals("java.lang.reflect.InaccessibleObjectException")) {
            return "";
        }
        String message = exc.getMessage();
        if (message == null || !message.contains("to module com.google.gson")) {
            str = "reflection-inaccessible";
        } else {
            str = "reflection-inaccessible-to-module-gson";
        }
        return "\nSee " + F.a(str);
    }

    public static String[] k(Class cls) {
        return f15382a.c(cls);
    }

    public static boolean l(Class cls) {
        if (n(cls)) {
            return false;
        }
        if (cls.isAnonymousClass() || cls.isLocalClass()) {
            return true;
        }
        return false;
    }

    public static boolean m(Class cls) {
        return f15382a.d(cls);
    }

    public static boolean n(Class cls) {
        return Modifier.isStatic(cls.getModifiers());
    }

    public static void o(AccessibleObject accessibleObject) {
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception e5) {
            String g5 = g(accessibleObject, false);
            throw new i("Failed making " + g5 + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type." + j(e5), e5);
        }
    }

    public static String p(Constructor constructor) {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e5) {
            return "Failed making constructor '" + c(constructor) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e5.getMessage() + j(e5);
        }
    }
}
