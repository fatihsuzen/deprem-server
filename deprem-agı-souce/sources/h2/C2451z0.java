package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.z0  reason: case insensitive filesystem */
public final class C2451z0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23696a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f23697b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23698c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23699d;

    private C2451z0(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2) {
        this.f23696a = relativeLayout;
        this.f23697b = relativeLayout2;
        this.f23698c = textView;
        this.f23699d = textView2;
    }

    public static C2451z0 a(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i5 = R.id.tv_preference_list_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_preference_list_description);
        if (textView != null) {
            i5 = R.id.tv_preference_list_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_preference_list_title);
            if (textView2 != null) {
                return new C2451z0(relativeLayout, relativeLayout, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2451z0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2451z0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.preference_list, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23696a;
    }
}
