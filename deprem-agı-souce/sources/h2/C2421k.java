package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.uptodown.R;

/* renamed from: h2.k  reason: case insensitive filesystem */
public final class C2421k implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f23279a;

    private C2421k(TextView textView) {
        this.f23279a = textView;
    }

    public static C2421k a(View view) {
        if (view != null) {
            return new C2421k((TextView) view);
        }
        throw new NullPointerException("rootView");
    }

    public static C2421k c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2421k d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.chip_floating_category, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public TextView getRoot() {
        return this.f23279a;
    }
}
