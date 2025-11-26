package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.a  reason: case insensitive filesystem */
public final class C2401a implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f22735a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f22736b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f22737c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f22738d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f22739e;

    private C2401a(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, Toolbar toolbar, TextView textView) {
        this.f22735a = linearLayout;
        this.f22736b = linearLayout2;
        this.f22737c = linearLayout3;
        this.f22738d = toolbar;
        this.f22739e = textView;
    }

    public static C2401a a(View view) {
        int i5 = R.id.ll_advanced_preferences_list;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_advanced_preferences_list);
        if (linearLayout != null) {
            LinearLayout linearLayout2 = (LinearLayout) view;
            i5 = R.id.toolbar_advanced_preferences;
            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_advanced_preferences);
            if (toolbar != null) {
                i5 = R.id.tv_toolbar_title_advanced_preferences;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_title_advanced_preferences);
                if (textView != null) {
                    return new C2401a(linearLayout2, linearLayout, linearLayout2, toolbar, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2401a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2401a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.advanced_preferences_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f22735a;
    }
}
