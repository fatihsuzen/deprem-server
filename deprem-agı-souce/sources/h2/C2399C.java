package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.C  reason: case insensitive filesystem */
public final class C2399C implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f22279a;

    /* renamed from: b  reason: collision with root package name */
    public final RadioGroup f22280b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f22281c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f22282d;

    private C2399C(LinearLayout linearLayout, RadioGroup radioGroup, TextView textView, TextView textView2) {
        this.f22279a = linearLayout;
        this.f22280b = radioGroup;
        this.f22281c = textView;
        this.f22282d = textView2;
    }

    public static C2399C a(View view) {
        int i5 = R.id.rg_dso;
        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, R.id.rg_dso);
        if (radioGroup != null) {
            i5 = R.id.tv_accept_dso;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_accept_dso);
            if (textView != null) {
                i5 = R.id.tv_title_dso;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_dso);
                if (textView2 != null) {
                    return new C2399C((LinearLayout) view, radioGroup, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2399C c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2399C d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_settings_options, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f22279a;
    }
}
