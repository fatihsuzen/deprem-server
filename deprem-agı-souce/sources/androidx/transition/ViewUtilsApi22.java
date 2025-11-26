package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(22)
class ViewUtilsApi22 extends ViewUtilsApi21 {
    private static boolean sTryHiddenSetLeftTopRightBottom = true;

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void setLeftTopRightBottom(View view, int i5, int i6, int i7, int i8) {
            view.setLeftTopRightBottom(i5, i6, i7, i8);
        }
    }

    ViewUtilsApi22() {
    }

    @SuppressLint({"NewApi"})
    public void setLeftTopRightBottom(@NonNull View view, int i5, int i6, int i7, int i8) {
        if (sTryHiddenSetLeftTopRightBottom) {
            try {
                Api29Impl.setLeftTopRightBottom(view, i5, i6, i7, i8);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSetLeftTopRightBottom = false;
            }
        }
    }
}
