package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.uptodown.R;

public final class H implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f22379a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f22380b;

    private H(TextView textView, TextView textView2) {
        this.f22379a = textView;
        this.f22380b = textView2;
    }

    public static H a(View view) {
        if (view != null) {
            TextView textView = (TextView) view;
            return new H(textView, textView);
        }
        throw new NullPointerException("rootView");
    }

    public static H c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dropdown_option_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public TextView getRoot() {
        return this.f22379a;
    }
}
