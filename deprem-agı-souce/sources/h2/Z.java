package h2;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class Z implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f22718a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f22719b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f22720c;

    private Z(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView) {
        this.f22718a = linearLayout;
        this.f22719b = linearLayout2;
        this.f22720c = textView;
    }

    public static Z a(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_external_download_box);
        if (textView != null) {
            return new Z(linearLayout, linearLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tv_external_download_box)));
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f22718a;
    }
}
