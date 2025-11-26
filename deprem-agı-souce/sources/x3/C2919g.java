package x3;

import W2.t;
import W2.u;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import kotlin.jvm.internal.C2633k;

/* renamed from: x3.g  reason: case insensitive filesystem */
public abstract class C2919g {

    /* renamed from: a  reason: collision with root package name */
    public static final C2918f f26339a;
    private static volatile Choreographer choreographer;

    static {
        Object obj;
        C2918f fVar = null;
        try {
            t.a aVar = t.f19966b;
            obj = t.b(new C2917e(a(Looper.getMainLooper(), true), (String) null, 2, (C2633k) null));
        } catch (Throwable th) {
            t.a aVar2 = t.f19966b;
            obj = t.b(u.a(th));
        }
        if (!t.g(obj)) {
            fVar = obj;
        }
        f26339a = fVar;
    }

    public static final Handler a(Looper looper, boolean z4) {
        if (!z4) {
            return new Handler(looper);
        }
        Class<Looper> cls = Looper.class;
        Class<Handler> cls2 = Handler.class;
        if (Build.VERSION.SDK_INT >= 28) {
            Object invoke = cls2.getDeclaredMethod("createAsync", new Class[]{cls}).invoke((Object) null, new Object[]{looper});
            kotlin.jvm.internal.t.c(invoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) invoke;
        }
        try {
            return cls2.getDeclaredConstructor(new Class[]{cls, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}
