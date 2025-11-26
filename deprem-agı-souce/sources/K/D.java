package K;

import N.C0722p;
import N.W;
import N.X;
import U.b;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.util.a;
import com.google.android.gms.common.util.i;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;

abstract class D {

    /* renamed from: a  reason: collision with root package name */
    static final B f2672a = new v(z.k("0\u0005È0\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010e\bsù/Qí"));

    /* renamed from: b  reason: collision with root package name */
    static final B f2673b = new w(z.k("0\u0006\u00040\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²­×árÊkì"));

    /* renamed from: c  reason: collision with root package name */
    static final B f2674c = new x(z.k("0\u0004C0\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000ÂàFdJ00"));

    /* renamed from: d  reason: collision with root package name */
    static final B f2675d = new y(z.k("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ¸l}ÓNõ0"));

    /* renamed from: e  reason: collision with root package name */
    private static volatile X f2676e;

    /* renamed from: f  reason: collision with root package name */
    private static final Object f2677f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static Context f2678g;

    static M a(String str, z zVar, boolean z4, boolean z5) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return f(str, zVar, z4, z5);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    static M b(String str, boolean z4, boolean z5, boolean z6) {
        return g(str, z4, false, false, true);
    }

    static /* synthetic */ String c(boolean z4, String str, z zVar) {
        String str2;
        if (z4 || !f(str, zVar, true, false).f2695a) {
            str2 = "not allowed";
        } else {
            str2 = "debug cert rejected";
        }
        MessageDigest b5 = a.b("SHA-256");
        C0722p.k(b5);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", new Object[]{str2, str, i.a(b5.digest(zVar.q0())), Boolean.valueOf(z4), "12451000.false"});
    }

    static synchronized void d(Context context) {
        synchronized (D.class) {
            if (f2678g != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f2678g = context.getApplicationContext();
            }
        }
    }

    static boolean e() {
        boolean z4;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            h();
            z4 = f2676e.e();
        } catch (RemoteException | DynamiteModule.a e5) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e5);
            z4 = false;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return z4;
    }

    private static M f(String str, z zVar, boolean z4, boolean z5) {
        try {
            h();
            C0722p.k(f2678g);
            try {
                if (f2676e.f0(new I(str, zVar, z4, z5), b.q0(f2678g.getPackageManager()))) {
                    return M.b();
                }
                return new K(new u(z4, str, zVar), (L) null);
            } catch (RemoteException e5) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e5);
                return M.d("module call", e5);
            }
        } catch (DynamiteModule.a e6) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e6);
            return M.d("module init: ".concat(String.valueOf(e6.getMessage())), e6);
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [U.a, android.os.IBinder] */
    private static M g(String str, boolean z4, boolean z5, boolean z6, boolean z7) {
        M m5;
        G g5;
        PackageManager.NameNotFoundException nameNotFoundException;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            C0722p.k(f2678g);
            try {
                h();
                E e5 = new E(str, z4, false, b.q0(f2678g), false, true);
                if (z7) {
                    g5 = f2676e.d0(e5);
                } else {
                    g5 = f2676e.i0(e5);
                }
                if (g5.d()) {
                    m5 = M.f(g5.f());
                } else {
                    String c5 = g5.c();
                    if (g5.g() == 4) {
                        nameNotFoundException = new PackageManager.NameNotFoundException();
                    } else {
                        nameNotFoundException = null;
                    }
                    if (c5 == null) {
                        c5 = "error checking package certificate";
                    }
                    m5 = M.g(g5.f(), g5.g(), c5, nameNotFoundException);
                }
            } catch (DynamiteModule.a e6) {
                DynamiteModule.a aVar = e6;
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", aVar);
                m5 = M.d("module init: ".concat(String.valueOf(aVar.getMessage())), aVar);
            }
        } catch (RemoteException e7) {
            RemoteException remoteException = e7;
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", remoteException);
            m5 = M.d("module call", remoteException);
        } catch (Throwable th) {
            Throwable th2 = th;
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th2;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return m5;
    }

    private static void h() {
        if (f2676e == null) {
            C0722p.k(f2678g);
            synchronized (f2677f) {
                try {
                    if (f2676e == null) {
                        f2676e = W.j(DynamiteModule.e(f2678g, DynamiteModule.f4901f, "com.google.android.gms.googlecertificates").d("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
