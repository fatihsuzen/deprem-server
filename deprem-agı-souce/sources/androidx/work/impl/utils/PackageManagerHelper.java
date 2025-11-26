package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.work.Logger;

public class PackageManagerHelper {
    private static final String TAG = Logger.tagWithPrefix("PackageManagerHelper");

    private PackageManagerHelper() {
    }

    private static int getComponentEnabledSetting(Context context, String str) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, str));
    }

    private static boolean isComponentEnabled(int i5, boolean z4) {
        return i5 == 0 ? z4 : i5 == 1;
    }

    public static boolean isComponentExplicitlyEnabled(Context context, Class<?> cls) {
        return isComponentEnabled(getComponentEnabledSetting(context, cls.getName()), false);
    }

    public static void setComponentEnabled(Context context, Class<?> cls, boolean z4) {
        int i5;
        String str;
        String str2 = "disabled";
        try {
            if (z4 == isComponentEnabled(getComponentEnabledSetting(context, cls.getName()), false)) {
                Logger.get().debug(TAG, "Skipping component enablement for " + cls.getName());
                return;
            }
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, cls.getName());
            if (z4) {
                i5 = 1;
            } else {
                i5 = 2;
            }
            packageManager.setComponentEnabledSetting(componentName, i5, 1);
            Logger logger = Logger.get();
            String str3 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append(" ");
            if (z4) {
                str = "enabled";
            } else {
                str = str2;
            }
            sb.append(str);
            logger.debug(str3, sb.toString());
        } catch (Exception e5) {
            Logger logger2 = Logger.get();
            String str4 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append("could not be ");
            if (z4) {
                str2 = "enabled";
            }
            sb2.append(str2);
            logger2.debug(str4, sb2.toString(), e5);
        }
    }

    public static boolean isComponentExplicitlyEnabled(Context context, String str) {
        return getComponentEnabledSetting(context, str) == 1;
    }
}
