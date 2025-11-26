package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.q  reason: case insensitive filesystem */
public final class C2433q implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f23449a;

    /* renamed from: b  reason: collision with root package name */
    public final RadioButton f23450b;

    /* renamed from: c  reason: collision with root package name */
    public final RadioButton f23451c;

    /* renamed from: d  reason: collision with root package name */
    public final RadioButton f23452d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23453e;

    private C2433q(CoordinatorLayout coordinatorLayout, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, TextView textView) {
        this.f23449a = coordinatorLayout;
        this.f23450b = radioButton;
        this.f23451c = radioButton2;
        this.f23452d = radioButton3;
        this.f23453e = textView;
    }

    public static C2433q a(View view) {
        int i5 = R.id.rb_disabled;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.rb_disabled);
        if (radioButton != null) {
            i5 = R.id.rb_enabled;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.rb_enabled);
            if (radioButton2 != null) {
                i5 = R.id.rb_follow_system;
                RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.rb_follow_system);
                if (radioButton3 != null) {
                    i5 = R.id.tv_title_dark_mode_options;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_dark_mode_options);
                    if (textView != null) {
                        return new C2433q((CoordinatorLayout) view, radioButton, radioButton2, radioButton3, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2433q c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2433q d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_dark_mode_options, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public CoordinatorLayout getRoot() {
        return this.f23449a;
    }
}
