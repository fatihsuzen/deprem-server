package androidx.leanback.app;

import android.annotation.SuppressLint;
import android.app.Fragment;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class PermissionHelper {
    private PermissionHelper() {
    }

    @SuppressLint({"ReferencesDeprecated"})
    public static void requestPermissions(Fragment fragment, String[] strArr, int i5) {
        fragment.requestPermissions(strArr, i5);
    }
}
