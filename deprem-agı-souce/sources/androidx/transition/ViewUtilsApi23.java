package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(23)
class ViewUtilsApi23 extends ViewUtilsApi22 {
    private static boolean sTryHiddenSetTransitionVisibility = true;

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void setTransitionVisibility(View view, int i5) {
            view.setTransitionVisibility(i5);
        }
    }

    ViewUtilsApi23() {
    }

    @SuppressLint({"NewApi"})
    public void setTransitionVisibility(@NonNull View view, int i5) {
        if (Build.VERSION.SDK_INT == 28) {
            super.setTransitionVisibility(view, i5);
        } else if (sTryHiddenSetTransitionVisibility) {
            try {
                Api29Impl.setTransitionVisibility(view, i5);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSetTransitionVisibility = false;
            }
        }
    }
}
