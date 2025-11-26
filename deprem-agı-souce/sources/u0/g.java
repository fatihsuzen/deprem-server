package u0;

import android.util.Log;

public class g {

    /* renamed from: c  reason: collision with root package name */
    static final g f16660c = new g("FirebaseCrashlytics");

    /* renamed from: a  reason: collision with root package name */
    private final String f16661a;

    /* renamed from: b  reason: collision with root package name */
    private int f16662b = 4;

    public g(String str) {
        this.f16661a = str;
    }

    private boolean a(int i5) {
        if (this.f16662b <= i5 || Log.isLoggable(this.f16661a, i5)) {
            return true;
        }
        return false;
    }

    public static g f() {
        return f16660c;
    }

    public void b(String str) {
        c(str, (Throwable) null);
    }

    public void c(String str, Throwable th) {
        if (a(3)) {
            Log.d(this.f16661a, str, th);
        }
    }

    public void d(String str) {
        e(str, (Throwable) null);
    }

    public void e(String str, Throwable th) {
        if (a(6)) {
            Log.e(this.f16661a, str, th);
        }
    }

    public void g(String str) {
        h(str, (Throwable) null);
    }

    public void h(String str, Throwable th) {
        if (a(4)) {
            Log.i(this.f16661a, str, th);
        }
    }

    public void i(String str) {
        j(str, (Throwable) null);
    }

    public void j(String str, Throwable th) {
        if (a(2)) {
            Log.v(this.f16661a, str, th);
        }
    }

    public void k(String str) {
        l(str, (Throwable) null);
    }

    public void l(String str, Throwable th) {
        if (a(5)) {
            Log.w(this.f16661a, str, th);
        }
    }
}
