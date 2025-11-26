package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.f0  reason: case insensitive filesystem */
public final class C2412f0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23058a;

    /* renamed from: b  reason: collision with root package name */
    public final View f23059b;

    /* renamed from: c  reason: collision with root package name */
    public final C2414g0 f23060c;

    /* renamed from: d  reason: collision with root package name */
    public final W0 f23061d;

    /* renamed from: e  reason: collision with root package name */
    public final Toolbar f23062e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23063f;

    private C2412f0(RelativeLayout relativeLayout, View view, C2414g0 g0Var, W0 w02, Toolbar toolbar, TextView textView) {
        this.f23058a = relativeLayout;
        this.f23059b = view;
        this.f23060c = g0Var;
        this.f23061d = w02;
        this.f23062e = toolbar;
        this.f23063f = textView;
    }

    public static C2412f0 a(View view) {
        int i5 = R.id.loading_view_login;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_login);
        if (findChildViewById != null) {
            i5 = R.id.login_form;
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.login_form);
            if (findChildViewById2 != null) {
                C2414g0 a5 = C2414g0.a(findChildViewById2);
                i5 = R.id.sign_up_form;
                View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.sign_up_form);
                if (findChildViewById3 != null) {
                    W0 a6 = W0.a(findChildViewById3);
                    i5 = R.id.toolbar_login;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_login);
                    if (toolbar != null) {
                        i5 = R.id.tv_title_toolbar_login;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_toolbar_login);
                        if (textView != null) {
                            return new C2412f0((RelativeLayout) view, findChildViewById, a5, a6, toolbar, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2412f0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2412f0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.login_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23058a;
    }
}
