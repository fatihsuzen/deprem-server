package Z;

import android.os.Build;

abstract class e {
    static boolean a() {
        if (Build.VERSION.SDK_INT >= 33) {
            return true;
        }
        return false;
    }
}
