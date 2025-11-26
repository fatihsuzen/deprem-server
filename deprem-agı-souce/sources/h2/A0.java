package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class A0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22257a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f22258b;

    /* renamed from: c  reason: collision with root package name */
    public final SwitchCompat f22259c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f22260d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f22261e;

    private A0(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, SwitchCompat switchCompat, TextView textView, TextView textView2) {
        this.f22257a = relativeLayout;
        this.f22258b = relativeLayout2;
        this.f22259c = switchCompat;
        this.f22260d = textView;
        this.f22261e = textView2;
    }

    public static A0 a(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i5 = R.id.sc_preference_switch;
        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, R.id.sc_preference_switch);
        if (switchCompat != null) {
            i5 = R.id.tv_preference_switch_description;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_preference_switch_description);
            if (textView != null) {
                i5 = R.id.tv_preference_switch_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_preference_switch_title);
                if (textView2 != null) {
                    return new A0(relativeLayout, relativeLayout, switchCompat, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static A0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static A0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.preference_switch, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22257a;
    }
}
