package x0;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import k0.C1698l;
import k0.C1699m;
import o0.f;
import u0.g;
import y0.C1938b;

public class D {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f16791a;

    /* renamed from: b  reason: collision with root package name */
    private final f f16792b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f16793c;

    /* renamed from: d  reason: collision with root package name */
    C1699m f16794d = new C1699m();

    /* renamed from: e  reason: collision with root package name */
    boolean f16795e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16796f = false;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f16797g;

    /* renamed from: h  reason: collision with root package name */
    private final C1699m f16798h = new C1699m();

    public D(f fVar) {
        Object obj = new Object();
        this.f16793c = obj;
        Context k5 = fVar.k();
        this.f16792b = fVar;
        this.f16791a = C1914j.q(k5);
        Boolean b5 = b();
        this.f16797g = b5 == null ? a(k5) : b5;
        synchronized (obj) {
            try {
                if (d()) {
                    this.f16794d.e((Object) null);
                    this.f16795e = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private Boolean a(Context context) {
        Boolean g5 = g(context);
        if (g5 == null) {
            this.f16796f = false;
            return null;
        }
        this.f16796f = true;
        return Boolean.valueOf(Boolean.TRUE.equals(g5));
    }

    private Boolean b() {
        if (!this.f16791a.contains("firebase_crashlytics_collection_enabled")) {
            return null;
        }
        this.f16796f = false;
        return Boolean.valueOf(this.f16791a.getBoolean("firebase_crashlytics_collection_enabled", true));
    }

    private boolean e() {
        try {
            return this.f16792b.t();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    private void f(boolean z4) {
        String str;
        String str2;
        if (z4) {
            str = "ENABLED";
        } else {
            str = "DISABLED";
        }
        if (this.f16797g == null) {
            str2 = "global Firebase setting";
        } else if (this.f16796f) {
            str2 = "firebase_crashlytics_collection_enabled manifest flag";
        } else {
            str2 = "API";
        }
        g.f().b(String.format("Crashlytics automatic data collection %s by %s.", new Object[]{str, str2}));
    }

    private static Boolean g(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_crashlytics_collection_enabled")) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
        } catch (PackageManager.NameNotFoundException e5) {
            g.f().e("Could not read data collection permission from manifest", e5);
            return null;
        }
    }

    private static void i(SharedPreferences sharedPreferences, Boolean bool) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (bool != null) {
            edit.putBoolean("firebase_crashlytics_collection_enabled", bool.booleanValue());
        } else {
            edit.remove("firebase_crashlytics_collection_enabled");
        }
        edit.apply();
    }

    public void c(boolean z4) {
        if (z4) {
            this.f16798h.e((Object) null);
            return;
        }
        throw new IllegalStateException("An invalid data collection token was used.");
    }

    public synchronized boolean d() {
        boolean z4;
        try {
            Boolean bool = this.f16797g;
            if (bool != null) {
                z4 = bool.booleanValue();
            } else {
                z4 = e();
            }
            f(z4);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return z4;
    }

    public synchronized void h(Boolean bool) {
        Boolean bool2;
        if (bool != null) {
            try {
                this.f16796f = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            bool2 = bool;
        } else {
            bool2 = a(this.f16792b.k());
        }
        this.f16797g = bool2;
        i(this.f16791a, bool);
        synchronized (this.f16793c) {
            if (d()) {
                if (!this.f16795e) {
                    this.f16794d.e((Object) null);
                    this.f16795e = true;
                }
            } else if (this.f16795e) {
                this.f16794d = new C1699m();
                this.f16795e = false;
            }
        }
    }

    public C1698l j() {
        C1698l a5;
        synchronized (this.f16793c) {
            a5 = this.f16794d.a();
        }
        return a5;
    }

    public C1698l k() {
        return C1938b.b(this.f16798h.a(), j());
    }
}
