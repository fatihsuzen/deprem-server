package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class G {

    /* renamed from: a  reason: collision with root package name */
    public static final G f7598a = c();

    class a extends G {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Method f7599b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f7600c;

        a(Method method, Object obj) {
            this.f7599b = method;
            this.f7600c = obj;
        }

        public Object d(Class cls) {
            G.b(cls);
            return this.f7599b.invoke(this.f7600c, new Object[]{cls});
        }
    }

    class b extends G {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Method f7601b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f7602c;

        b(Method method, int i5) {
            this.f7601b = method;
            this.f7602c = i5;
        }

        public Object d(Class cls) {
            G.b(cls);
            return this.f7601b.invoke((Object) null, new Object[]{cls, Integer.valueOf(this.f7602c)});
        }
    }

    class c extends G {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Method f7603b;

        c(Method method) {
            this.f7603b = method;
        }

        public Object d(Class cls) {
            G.b(cls);
            return this.f7603b.invoke((Object) null, new Object[]{cls, Object.class});
        }
    }

    class d extends G {
        d() {
        }

        public Object d(Class cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    /* access modifiers changed from: private */
    public static void b(Class cls) {
        String t5 = t.t(cls);
        if (t5 != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + t5);
        }
    }

    private static G c() {
        Class<ObjectStreamClass> cls = ObjectStreamClass.class;
        Class<Class> cls2 = Class.class;
        try {
            Class<?> cls3 = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls3.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls3.getMethod("allocateInstance", new Class[]{cls2}), declaredField.get((Object) null));
        } catch (Exception unused) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("getConstructorId", new Class[]{cls2});
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke((Object) null, new Object[]{Object.class})).intValue();
                Method declaredMethod2 = cls.getDeclaredMethod("newInstance", new Class[]{cls2, Integer.TYPE});
                declaredMethod2.setAccessible(true);
                return new b(declaredMethod2, intValue);
            } catch (Exception unused2) {
                try {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{cls2, cls2});
                    declaredMethod3.setAccessible(true);
                    return new c(declaredMethod3);
                } catch (Exception unused3) {
                    return new d();
                }
            }
        }
    }

    public abstract Object d(Class cls);
}
