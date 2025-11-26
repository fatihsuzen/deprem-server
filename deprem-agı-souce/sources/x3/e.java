package X3;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class e extends RuntimeException {

    /* renamed from: b  reason: collision with root package name */
    private static final Method f20091b;

    /* renamed from: a  reason: collision with root package name */
    private IOException f20092a;

    static {
        Method method;
        Class<Throwable> cls = Throwable.class;
        try {
            method = cls.getDeclaredMethod("addSuppressed", new Class[]{cls});
        } catch (Exception unused) {
            method = null;
        }
        f20091b = method;
    }

    public e(IOException iOException) {
        super(iOException);
        this.f20092a = iOException;
    }

    private void b(IOException iOException, IOException iOException2) {
        Method method = f20091b;
        if (method != null) {
            try {
                method.invoke(iOException, new Object[]{iOException2});
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public void a(IOException iOException) {
        b(iOException, this.f20092a);
        this.f20092a = iOException;
    }

    public IOException c() {
        return this.f20092a;
    }
}
