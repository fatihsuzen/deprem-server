package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

class BenchmarkOperation {

    @RequiresApi(api = 21)
    private static class Api21ContextHelper {
        private Api21ContextHelper() {
        }

        static File getCodeCacheDir(Context context) {
            return context.getCodeCacheDir();
        }
    }

    @RequiresApi(api = 24)
    private static class Api24ContextHelper {
        private Api24ContextHelper() {
        }

        static Context createDeviceProtectedStorageContext(Context context) {
            return context.createDeviceProtectedStorageContext();
        }
    }

    private BenchmarkOperation() {
    }

    static boolean deleteFilesRecursively(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return false;
            }
            boolean z4 = true;
            for (File deleteFilesRecursively : listFiles) {
                if (!deleteFilesRecursively(deleteFilesRecursively) || !z4) {
                    z4 = false;
                } else {
                    z4 = true;
                }
            }
            return z4;
        }
        file.delete();
        return true;
    }

    static void dropShaderCache(@NonNull Context context, @NonNull ProfileInstallReceiver.ResultDiagnostics resultDiagnostics) {
        File file;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 34) {
            file = Api24ContextHelper.createDeviceProtectedStorageContext(context).getCacheDir();
        } else if (i5 >= 24) {
            file = Api21ContextHelper.getCodeCacheDir(Api24ContextHelper.createDeviceProtectedStorageContext(context));
        } else if (i5 == 23) {
            file = Api21ContextHelper.getCodeCacheDir(context);
        } else {
            file = context.getCacheDir();
        }
        if (deleteFilesRecursively(file)) {
            resultDiagnostics.onResultReceived(14, (Object) null);
        } else {
            resultDiagnostics.onResultReceived(15, (Object) null);
        }
    }
}
