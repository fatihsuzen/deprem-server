package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.p  reason: case insensitive filesystem */
public final class C2431p implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f23421a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f23422b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23423c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23424d;

    private C2431p(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.f23421a = linearLayout;
        this.f23422b = textView;
        this.f23423c = textView2;
        this.f23424d = textView3;
    }

    public static C2431p a(View view) {
        int i5 = R.id.tv_close_dialog_pre_register;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_close_dialog_pre_register);
        if (textView != null) {
            i5 = R.id.tv_description_dialog_pre_register;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_description_dialog_pre_register);
            if (textView2 != null) {
                i5 = R.id.tv_title_dialog_pre_register;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_dialog_pre_register);
                if (textView3 != null) {
                    return new C2431p((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2431p c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2431p d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_coming_soon, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f23421a;
    }
}
