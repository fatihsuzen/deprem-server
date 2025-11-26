package androidx.leanback.app;

import android.app.Fragment;
import android.content.Context;
import androidx.annotation.RequiresApi;

class FragmentUtil {

    @RequiresApi(23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        static Context getContext(Fragment fragment) {
            return fragment.getContext();
        }
    }

    private FragmentUtil() {
    }

    static Context getContext(Fragment fragment) {
        return Api23Impl.getContext(fragment);
    }
}
