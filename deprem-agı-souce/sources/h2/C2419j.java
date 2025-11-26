package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.j  reason: case insensitive filesystem */
public final class C2419j implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f23243a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f23244b;

    private C2419j(LinearLayout linearLayout, TextView textView) {
        this.f23243a = linearLayout;
        this.f23244b = textView;
    }

    public static C2419j a(View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_checking_device);
        if (textView != null) {
            return new C2419j((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tv_checking_device)));
    }

    public static C2419j c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2419j d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.checking_compatibility, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f23243a;
    }
}
