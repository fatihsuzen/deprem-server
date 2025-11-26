package x3;

import android.os.Build;
import b3.C2304a;
import b3.C2312i;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import w3.J;

/* renamed from: x3.b  reason: case insensitive filesystem */
public final class C2914b extends C2304a implements J {
    private volatile Object _preHandler = this;

    public C2914b() {
        super(J.f26239j0);
    }

    private final Method F() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        try {
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", (Class[]) null);
            if (Modifier.isPublic(declaredMethod.getModifiers()) && Modifier.isStatic(declaredMethod.getModifiers())) {
                method = declaredMethod;
            }
        } catch (Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }

    public void B(C2312i iVar, Throwable th) {
        Object obj;
        int i5 = Build.VERSION.SDK_INT;
        if (26 <= i5 && i5 < 28) {
            Method F4 = F();
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
            if (F4 != null) {
                obj = F4.invoke((Object) null, (Object[]) null);
            } else {
                obj = null;
            }
            if (obj instanceof Thread.UncaughtExceptionHandler) {
                uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) obj;
            }
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
        }
    }
}
