package H;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public final class p {

    /* renamed from: d  reason: collision with root package name */
    private static p f2501d;

    /* renamed from: a  reason: collision with root package name */
    final c f2502a;

    /* renamed from: b  reason: collision with root package name */
    GoogleSignInAccount f2503b;

    /* renamed from: c  reason: collision with root package name */
    GoogleSignInOptions f2504c;

    private p(Context context) {
        c b5 = c.b(context);
        this.f2502a = b5;
        this.f2503b = b5.c();
        this.f2504c = b5.d();
    }

    public static synchronized p a(Context context) {
        p d5;
        synchronized (p.class) {
            d5 = d(context.getApplicationContext());
        }
        return d5;
    }

    private static synchronized p d(Context context) {
        synchronized (p.class) {
            p pVar = f2501d;
            if (pVar != null) {
                return pVar;
            }
            p pVar2 = new p(context);
            f2501d = pVar2;
            return pVar2;
        }
    }

    public final synchronized void b() {
        this.f2502a.a();
        this.f2503b = null;
        this.f2504c = null;
    }

    public final synchronized void c(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.f2502a.f(googleSignInAccount, googleSignInOptions);
        this.f2503b = googleSignInAccount;
        this.f2504c = googleSignInOptions;
    }
}
