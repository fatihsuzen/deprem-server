package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.os.UserManagerCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executors;
import n0.C1722d;

public final class PackageManagerCompat {
    @SuppressLint({"ActionValue"})
    public static final String ACTION_PERMISSION_REVOCATION_SETTINGS = "android.intent.action.AUTO_REVOKE_PERMISSIONS";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String LOG_TAG = "PackageManagerCompat";

    @RequiresApi(30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        static boolean areUnusedAppRestrictionsEnabled(@NonNull Context context) {
            return !context.getPackageManager().isAutoRevokeWhitelisted();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface UnusedAppRestrictionsStatus {
    }

    private PackageManagerCompat() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean areUnusedAppRestrictionsAvailable(@NonNull PackageManager packageManager) {
        boolean z4;
        boolean z5;
        boolean z6;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (i5 < 30) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getPermissionRevocationVerifierApp(packageManager) != null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z4 || (z5 && z6)) {
            return true;
        }
        return false;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String getPermissionRevocationVerifierApp(@NonNull PackageManager packageManager) {
        String str = null;
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(new Intent(ACTION_PERMISSION_REVOCATION_SETTINGS).setData(Uri.fromParts("package", "com.example", (String) null)), 0)) {
            String str2 = resolveInfo.activityInfo.packageName;
            if (packageManager.checkPermission("android.permission.PACKAGE_VERIFICATION_AGENT", str2) == 0) {
                if (str != null) {
                    return str;
                }
                str = str2;
            }
        }
        return str;
    }

    @NonNull
    public static C1722d getUnusedAppRestrictionsStatus(@NonNull Context context) {
        ResolvableFuture create = ResolvableFuture.create();
        if (!UserManagerCompat.isUserUnlocked(context)) {
            create.set(0);
            Log.e(LOG_TAG, "User is in locked direct boot mode");
            return create;
        } else if (!areUnusedAppRestrictionsAvailable(context.getPackageManager())) {
            create.set(1);
            return create;
        } else {
            int i5 = context.getApplicationInfo().targetSdkVersion;
            if (i5 < 30) {
                create.set(0);
                Log.e(LOG_TAG, "Target SDK version below API 30");
                return create;
            }
            int i6 = Build.VERSION.SDK_INT;
            int i7 = 2;
            int i8 = 4;
            if (i6 >= 31) {
                if (Api30Impl.areUnusedAppRestrictionsEnabled(context)) {
                    if (i5 >= 31) {
                        i8 = 5;
                    }
                    create.set(Integer.valueOf(i8));
                    return create;
                }
                create.set(2);
                return create;
            } else if (i6 == 30) {
                if (Api30Impl.areUnusedAppRestrictionsEnabled(context)) {
                    i7 = 4;
                }
                create.set(Integer.valueOf(i7));
                return create;
            } else {
                UnusedAppRestrictionsBackportServiceConnection unusedAppRestrictionsBackportServiceConnection = new UnusedAppRestrictionsBackportServiceConnection(context);
                create.addListener(new v(unusedAppRestrictionsBackportServiceConnection), Executors.newSingleThreadExecutor());
                unusedAppRestrictionsBackportServiceConnection.connectAndFetchResult(create);
                return create;
            }
        }
    }
}
