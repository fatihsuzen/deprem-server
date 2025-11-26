package h2;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

public final class o1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f23420a;

    private o1(TextView textView) {
        this.f23420a = textView;
    }

    public static o1 a(View view) {
        if (view != null) {
            return new o1((TextView) view);
        }
        throw new NullPointerException("rootView");
    }

    /* renamed from: b */
    public TextView getRoot() {
        return this.f23420a;
    }
}
