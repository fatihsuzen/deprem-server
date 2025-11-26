package h2;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class B0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22274a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f22275b;

    /* renamed from: c  reason: collision with root package name */
    public final SwitchCompat f22276c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f22277d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f22278e;

    private B0(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, SwitchCompat switchCompat, TextView textView, TextView textView2) {
        this.f22274a = relativeLayout;
        this.f22275b = relativeLayout2;
        this.f22276c = switchCompat;
        this.f22277d = textView;
        this.f22278e = textView2;
    }

    public static B0 a(View view) {
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
                    return new B0(relativeLayout, relativeLayout, switchCompat, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22274a;
    }
}
