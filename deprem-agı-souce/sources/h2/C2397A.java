package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.A  reason: case insensitive filesystem */
public final class C2397A implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f22251a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f22252b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f22253c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f22254d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f22255e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f22256f;

    private C2397A(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.f22251a = linearLayout;
        this.f22252b = textView;
        this.f22253c = textView2;
        this.f22254d = textView3;
        this.f22255e = textView4;
        this.f22256f = textView5;
    }

    public static C2397A a(View view) {
        int i5 = R.id.tv_cancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_cancel);
        if (textView != null) {
            i5 = R.id.tv_missed_features;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_missed_features);
            if (textView2 != null) {
                i5 = R.id.tv_msg;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_msg);
                if (textView3 != null) {
                    i5 = R.id.tv_ok;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_ok);
                    if (textView4 != null) {
                        i5 = R.id.tv_title;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                        if (textView5 != null) {
                            return new C2397A((LinearLayout) view, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2397A c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2397A d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_required_features_missed, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f22251a;
    }
}
