package androidx.activity;

import android.view.View;
import androidx.annotation.RequiresApi;

@RequiresApi(19)
public final class Api19Impl {
    public static final Api19Impl INSTANCE = new Api19Impl();

    private Api19Impl() {
    }

    public final boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }
}
