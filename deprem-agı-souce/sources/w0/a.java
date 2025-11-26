package W0;

import O0.c;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.ContextCompat;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4423a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f4424b;

    /* renamed from: c  reason: collision with root package name */
    private final c f4425c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4426d = c();

    public a(Context context, String str, c cVar) {
        Context a5 = a(context);
        this.f4423a = a5;
        this.f4424b = a5.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f4425c = cVar;
    }

    private static Context a(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return context;
        }
        return ContextCompat.createDeviceProtectedStorageContext(context);
    }

    private boolean c() {
        if (this.f4424b.contains("firebase_data_collection_default_enabled")) {
            return this.f4424b.getBoolean("firebase_data_collection_default_enabled", true);
        }
        return d();
    }

    private boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.f4423a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f4423a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public synchronized boolean b() {
        return this.f4426d;
    }
}
