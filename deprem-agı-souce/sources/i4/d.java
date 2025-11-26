package i4;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import g4.b;
import g4.c;
import g4.e;

public class d {

    /* renamed from: h  reason: collision with root package name */
    protected static final String f24508h = b.i(d.class);

    /* renamed from: a  reason: collision with root package name */
    private final e f24509a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f24510b;

    /* renamed from: c  reason: collision with root package name */
    private final PackageManager f24511c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedPreferences f24512d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f24513e;

    /* renamed from: f  reason: collision with root package name */
    private String f24514f;

    /* renamed from: g  reason: collision with root package name */
    private final PackageInfo f24515g;

    public interface a {

        /* renamed from: i4.d$a$a  reason: collision with other inner class name */
        public static class C0246a implements a {
            public boolean a() {
                return false;
            }

            public String b() {
                return null;
            }
        }

        boolean a();

        String b();
    }

    public d(e eVar) {
        this(eVar, b(eVar.c().c()));
    }

    private static PackageInfo b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e5) {
            p4.a.b(f24508h).d(e5);
            throw new RuntimeException(e5);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(boolean z4, g4.d dVar, a aVar) {
        if (z4) {
            try {
                Thread.sleep(3000);
            } catch (Exception e5) {
                p4.a.b("ContentValues").d(e5);
            }
        }
        g(dVar, aVar);
    }

    private void g(g4.d dVar, a aVar) {
        String string;
        String str = f24508h;
        p4.a.b(str).a("Tracking app download...", new Object[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("http://");
        sb.append(this.f24515g.packageName);
        sb.append(":");
        sb.append(c());
        String b5 = aVar.b();
        if (b5 != null) {
            sb.append("/");
            sb.append(b5);
        }
        String installerPackageName = this.f24511c.getInstallerPackageName(this.f24515g.packageName);
        if (installerPackageName != null && installerPackageName.length() > 200) {
            installerPackageName = installerPackageName.substring(0, 200);
        }
        if (!(installerPackageName == null || !installerPackageName.equals("com.android.vending") || (string = this.f24509a.c().g().getString("referrer.extras", (String) null)) == null)) {
            installerPackageName = installerPackageName + "/?" + string;
        }
        if (installerPackageName != null) {
            installerPackageName = "http://" + installerPackageName;
        }
        this.f24509a.k(dVar.c(c.EVENT_CATEGORY, "Application").c(c.EVENT_ACTION, "downloaded").c(c.ACTION_NAME, "application/downloaded").c(c.URL_PATH, "/application/downloaded").c(c.DOWNLOAD, sb.toString()).c(c.REFERRER, installerPackageName));
        p4.a.b(str).a("... app download tracked.", new Object[0]);
    }

    public String c() {
        String str = this.f24514f;
        if (str != null) {
            return str;
        }
        return Integer.toString(this.f24515g.versionCode);
    }

    public void e(String str) {
        this.f24514f = str;
    }

    public void f(g4.d dVar, a aVar) {
        boolean z4;
        if (!this.f24513e || !"com.android.vending".equals(this.f24511c.getInstallerPackageName(this.f24515g.packageName))) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4) {
            p4.a.b(f24508h).a("Google Play is install source, deferring tracking.", new Object[0]);
        }
        Thread thread = new Thread(new c(this, z4, dVar, aVar));
        if (z4 || aVar.a()) {
            thread.start();
        } else {
            thread.run();
        }
    }

    public void h(g4.d dVar, a aVar) {
        String str = "downloaded:" + this.f24515g.packageName + ":" + c();
        synchronized (this.f24510b) {
            try {
                if (!this.f24512d.getBoolean(str, false)) {
                    this.f24512d.edit().putBoolean(str, true).apply();
                    f(dVar, aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public d(e eVar, PackageInfo packageInfo) {
        this.f24510b = new Object();
        this.f24509a = eVar;
        Context c5 = eVar.c().c();
        this.f24512d = eVar.g();
        this.f24511c = eVar.c().c().getPackageManager();
        this.f24515g = packageInfo;
        this.f24513e = packageInfo.packageName.equals(c5.getPackageName());
    }
}
