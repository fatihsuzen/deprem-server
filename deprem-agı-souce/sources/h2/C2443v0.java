package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.v0  reason: case insensitive filesystem */
public final class C2443v0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23629a;

    /* renamed from: b  reason: collision with root package name */
    public final EditText f23630b;

    /* renamed from: c  reason: collision with root package name */
    public final EditText f23631c;

    /* renamed from: d  reason: collision with root package name */
    public final View f23632d;

    /* renamed from: e  reason: collision with root package name */
    public final Toolbar f23633e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23634f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f23635g;

    private C2443v0(RelativeLayout relativeLayout, EditText editText, EditText editText2, View view, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f23629a = relativeLayout;
        this.f23630b = editText;
        this.f23631c = editText2;
        this.f23632d = view;
        this.f23633e = toolbar;
        this.f23634f = textView;
        this.f23635g = textView2;
    }

    public static C2443v0 a(View view) {
        int i5 = R.id.et_email_confirm_pass_recovery;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.et_email_confirm_pass_recovery);
        if (editText != null) {
            i5 = R.id.et_email_pass_recovery;
            EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.et_email_pass_recovery);
            if (editText2 != null) {
                i5 = R.id.loading_view_password_recovery;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_password_recovery);
                if (findChildViewById != null) {
                    i5 = R.id.toolbar_password_recovery;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_password_recovery);
                    if (toolbar != null) {
                        i5 = R.id.tv_recover;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_recover);
                        if (textView != null) {
                            i5 = R.id.tv_title_toolbar_password_recovery;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_toolbar_password_recovery);
                            if (textView2 != null) {
                                return new C2443v0((RelativeLayout) view, editText, editText2, findChildViewById, toolbar, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2443v0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2443v0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.password_recovery, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23629a;
    }
}
