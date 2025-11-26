package q2;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import kotlin.jvm.internal.t;

/* renamed from: q2.c  reason: case insensitive filesystem */
public abstract class C2716c {
    public static final PackageInfo a(PackageManager packageManager, String str, int i5) {
        t.e(packageManager, "<this>");
        t.e(str, "packageName");
        if (Build.VERSION.SDK_INT >= 33) {
            PackageInfo a5 = packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of((long) i5));
            t.d(a5, "{\n        getPackageInfo…of(flags.toLong()))\n    }");
            return a5;
        }
        PackageInfo packageInfo = packageManager.getPackageInfo(str, i5);
        t.d(packageInfo, "{\n        getPackageInfo(packageName, flags)\n    }");
        return packageInfo;
    }
}
