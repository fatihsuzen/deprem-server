package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.w0  reason: case insensitive filesystem */
public final class C2445w0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f23653a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f23654b;

    private C2445w0(LinearLayout linearLayout, TextView textView) {
        this.f23653a = linearLayout;
        this.f23654b = textView;
    }

    public static C2445w0 a(View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_name_permission_item);
        if (textView != null) {
            return new C2445w0((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tv_name_permission_item)));
    }

    public static C2445w0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2445w0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.permission_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f23653a;
    }
}
