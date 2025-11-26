package c4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class e {

    /* renamed from: a  reason: collision with root package name */
    private final Class f20839a;

    /* renamed from: b  reason: collision with root package name */
    private final String f20840b;

    /* renamed from: c  reason: collision with root package name */
    private final Class[] f20841c;

    e(Class cls, String str, Class... clsArr) {
        this.f20839a = cls;
        this.f20840b = str;
        this.f20841c = clsArr;
    }

    private Method a(Class cls) {
        Class cls2;
        String str = this.f20840b;
        if (str == null) {
            return null;
        }
        Method b5 = b(cls, str, this.f20841c);
        if (b5 == null || (cls2 = this.f20839a) == null || cls2.isAssignableFrom(b5.getReturnType())) {
            return b5;
        }
        return null;
    }

    private static Method b(Class cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
                return method;
            } catch (NoSuchMethodException unused) {
                return method;
            }
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }

    public Object c(Object obj, Object... objArr) {
        Method a5 = a(obj.getClass());
        if (a5 != null) {
            try {
                return a5.invoke(obj, objArr);
            } catch (IllegalAccessException e5) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a5);
                assertionError.initCause(e5);
                throw assertionError;
            }
        } else {
            throw new AssertionError("Method " + this.f20840b + " not supported for object " + obj);
        }
    }

    public Object d(Object obj, Object... objArr) {
        Method a5 = a(obj.getClass());
        if (a5 == null) {
            return null;
        }
        try {
            return a5.invoke(obj, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public Object e(Object obj, Object... objArr) {
        try {
            return d(obj, objArr);
        } catch (InvocationTargetException e5) {
            Throwable targetException = e5.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object f(Object obj, Object... objArr) {
        try {
            return c(obj, objArr);
        } catch (InvocationTargetException e5) {
            Throwable targetException = e5.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public boolean g(Object obj) {
        if (a(obj.getClass()) != null) {
            return true;
        }
        return false;
    }
}
