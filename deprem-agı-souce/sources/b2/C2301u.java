package b2;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.List;
import kotlin.jvm.internal.t;

/* renamed from: b2.u  reason: case insensitive filesystem */
public abstract class C2301u {
    public static final ApplicationInfo a(PackageManager packageManager, String str, int i5) {
        t.e(packageManager, "<this>");
        t.e(str, "packageName");
        if (Build.VERSION.SDK_INT >= 33) {
            ApplicationInfo a5 = packageManager.getApplicationInfo(str, PackageManager.ApplicationInfoFlags.of((long) i5));
            t.b(a5);
            return a5;
        }
        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, i5);
        t.b(applicationInfo);
        return applicationInfo;
    }

    public static final List b(PackageManager packageManager, int i5) {
        t.e(packageManager, "<this>");
        if (Build.VERSION.SDK_INT >= 33) {
            List a5 = packageManager.getInstalledApplications(PackageManager.ApplicationInfoFlags.of((long) i5));
            t.b(a5);
            return a5;
        }
        List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(i5);
        t.b(installedApplications);
        return installedApplications;
    }

    public static final PackageInfo c(PackageManager packageManager, String str, int i5) {
        t.e(packageManager, "<this>");
        t.e(str, "absolutePath");
        if (Build.VERSION.SDK_INT >= 33) {
            return packageManager.getPackageArchiveInfo(str, PackageManager.PackageInfoFlags.of((long) i5));
        }
        return packageManager.getPackageArchiveInfo(str, i5);
    }

    public static final PackageInfo d(PackageManager packageManager, String str, int i5) {
        t.e(packageManager, "<this>");
        t.e(str, "packageName");
        if (Build.VERSION.SDK_INT >= 33) {
            PackageInfo a5 = packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of((long) i5));
            t.b(a5);
            return a5;
        }
        PackageInfo packageInfo = packageManager.getPackageInfo(str, i5);
        t.b(packageInfo);
        return packageInfo;
    }
}
