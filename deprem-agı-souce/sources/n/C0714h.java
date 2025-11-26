package N;

import K.C0655b;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: N.h  reason: case insensitive filesystem */
public abstract class C0714h {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f3093a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static int f3094b = 9;

    /* renamed from: c  reason: collision with root package name */
    private static q0 f3095c = null;

    /* renamed from: d  reason: collision with root package name */
    static HandlerThread f3096d = null;

    /* renamed from: e  reason: collision with root package name */
    private static Executor f3097e = null;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f3098f = false;

    public static C0714h a(Context context) {
        Looper looper;
        synchronized (f3093a) {
            try {
                if (f3095c == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (f3098f) {
                        looper = b().getLooper();
                    } else {
                        looper = context.getMainLooper();
                    }
                    f3095c = new q0(applicationContext, looper, f3097e);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return f3095c;
    }

    public static HandlerThread b() {
        synchronized (f3093a) {
            try {
                HandlerThread handlerThread = f3096d;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", f3094b);
                f3096d = handlerThread2;
                handlerThread2.start();
                HandlerThread handlerThread3 = f3096d;
                return handlerThread3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract C0655b c(m0 m0Var, ServiceConnection serviceConnection, String str, Executor executor);

    /* access modifiers changed from: protected */
    public abstract void d(m0 m0Var, ServiceConnection serviceConnection, String str);

    public final void e(String str, String str2, int i5, ServiceConnection serviceConnection, String str3, boolean z4) {
        d(new m0(str, str2, 4225, z4), serviceConnection, str3);
    }
}
