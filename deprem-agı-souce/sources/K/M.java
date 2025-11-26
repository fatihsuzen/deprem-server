package K;

import android.util.Log;

class M {

    /* renamed from: e  reason: collision with root package name */
    private static final M f2694e = new M(true, 3, 1, (String) null, (Throwable) null);

    /* renamed from: a  reason: collision with root package name */
    final boolean f2695a;

    /* renamed from: b  reason: collision with root package name */
    final String f2696b;

    /* renamed from: c  reason: collision with root package name */
    final Throwable f2697c;

    /* renamed from: d  reason: collision with root package name */
    final int f2698d;

    private M(boolean z4, int i5, int i6, String str, Throwable th) {
        this.f2695a = z4;
        this.f2698d = i5;
        this.f2696b = str;
        this.f2697c = th;
    }

    static M b() {
        return f2694e;
    }

    static M c(String str) {
        return new M(false, 1, 5, str, (Throwable) null);
    }

    static M d(String str, Throwable th) {
        return new M(false, 1, 5, str, th);
    }

    static M f(int i5) {
        return new M(true, i5, 1, (String) null, (Throwable) null);
    }

    static M g(int i5, int i6, String str, Throwable th) {
        return new M(false, i5, i6, str, th);
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return this.f2696b;
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        if (!this.f2695a && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.f2697c != null) {
                Log.d("GoogleCertificatesRslt", a(), this.f2697c);
            } else {
                Log.d("GoogleCertificatesRslt", a());
            }
        }
    }

    /* synthetic */ M(boolean z4, int i5, int i6, String str, Throwable th, L l5) {
        this(false, 1, 5, (String) null, (Throwable) null);
    }
}
