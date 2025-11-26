package H;

import N.C0722p;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class c {

    /* renamed from: c  reason: collision with root package name */
    private static final Lock f2488c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    private static c f2489d;

    /* renamed from: a  reason: collision with root package name */
    private final Lock f2490a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f2491b;

    c(Context context) {
        this.f2491b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static c b(Context context) {
        C0722p.k(context);
        Lock lock = f2488c;
        lock.lock();
        try {
            if (f2489d == null) {
                f2489d = new c(context.getApplicationContext());
            }
            c cVar = f2489d;
            lock.unlock();
            return cVar;
        } catch (Throwable th) {
            f2488c.unlock();
            throw th;
        }
    }

    private static final String i(String str, String str2) {
        return str + ":" + str2;
    }

    public void a() {
        this.f2490a.lock();
        try {
            this.f2491b.edit().clear().apply();
        } finally {
            this.f2490a.unlock();
        }
    }

    public GoogleSignInAccount c() {
        String g5;
        String g6 = g("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(g6) && (g5 = g(i("googleSignInAccount", g6))) != null) {
            try {
                return GoogleSignInAccount.p(g5);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public GoogleSignInOptions d() {
        String g5;
        String g6 = g("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(g6) && (g5 = g(i("googleSignInOptions", g6))) != null) {
            try {
                return GoogleSignInOptions.o(g5);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public String e() {
        return g("refreshToken");
    }

    public void f(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        C0722p.k(googleSignInAccount);
        C0722p.k(googleSignInOptions);
        h("defaultGoogleSignInAccount", googleSignInAccount.q());
        C0722p.k(googleSignInAccount);
        C0722p.k(googleSignInOptions);
        String q5 = googleSignInAccount.q();
        h(i("googleSignInAccount", q5), googleSignInAccount.r());
        h(i("googleSignInOptions", q5), googleSignInOptions.s());
    }

    /* access modifiers changed from: protected */
    public final String g(String str) {
        this.f2490a.lock();
        try {
            return this.f2491b.getString(str, (String) null);
        } finally {
            this.f2490a.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public final void h(String str, String str2) {
        this.f2490a.lock();
        try {
            this.f2491b.edit().putString(str, str2).apply();
        } finally {
            this.f2490a.unlock();
        }
    }
}
