package j$.sun.misc;

import j$.util.concurrent.l;
import j$.util.concurrent.q;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import sun.misc.Unsafe;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f1001b;

    /* renamed from: a  reason: collision with root package name */
    public final Unsafe f1002a;

    static {
        Field g5 = g();
        g5.setAccessible(true);
        try {
            f1001b = new a((Unsafe) g5.get((Object) null));
        } catch (IllegalAccessException e5) {
            throw new AssertionError("Couldn't get the Unsafe", e5);
        }
    }

    public a(Unsafe unsafe) {
        this.f1002a = unsafe;
    }

    public static Field g() {
        try {
            return Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException e5) {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) && Unsafe.class.isAssignableFrom(field.getType())) {
                    return field;
                }
            }
            throw new AssertionError("Couldn't find the Unsafe", e5);
        }
    }

    public final int e(q qVar, long j5) {
        while (true) {
            int intVolatile = this.f1002a.getIntVolatile(qVar, j5);
            q qVar2 = qVar;
            long j6 = j5;
            if (this.f1002a.compareAndSwapInt(qVar2, j6, intVolatile, intVolatile - 4)) {
                return intVolatile;
            }
            qVar = qVar2;
            j5 = j6;
        }
    }

    public final long i(Field field) {
        return this.f1002a.objectFieldOffset(field);
    }

    public final long h(Class cls, String str) {
        try {
            return i(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e5) {
            throw new AssertionError("Cannot find field:", e5);
        }
    }

    public final int a(Class cls) {
        return this.f1002a.arrayBaseOffset(cls);
    }

    public final int b(Class cls) {
        return this.f1002a.arrayIndexScale(cls);
    }

    public final Object f(Object obj, long j5) {
        return this.f1002a.getObjectVolatile(obj, j5);
    }

    public final void j(Object obj, long j5, l lVar) {
        this.f1002a.putObjectVolatile(obj, j5, lVar);
    }

    public final boolean c(Object obj, long j5, int i5, int i6) {
        return this.f1002a.compareAndSwapInt(obj, j5, i5, i6);
    }

    public final boolean d(Object obj, long j5, long j6, long j7) {
        return this.f1002a.compareAndSwapLong(obj, j5, j6, j7);
    }
}
