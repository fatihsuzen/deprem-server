package B3;

import java.util.Collection;
import java.util.ServiceLoader;
import s3.C2754h;
import w3.J;

/* renamed from: B3.e  reason: case insensitive filesystem */
public abstract class C1985e {

    /* renamed from: a  reason: collision with root package name */
    private static final Collection f17391a;

    static {
        Class<J> cls = J.class;
        f17391a = C2754h.x(C2754h.d(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
    }

    public static final Collection a() {
        return f17391a;
    }

    public static final void b(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }
}
