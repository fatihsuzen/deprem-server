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

/* renamed from: h2.l  reason: case insensitive filesystem */
public final class C2423l implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23292a;

    /* renamed from: b  reason: collision with root package name */
    public final EditText f23293b;

    /* renamed from: c  reason: collision with root package name */
    public final EditText f23294c;

    /* renamed from: d  reason: collision with root package name */
    public final View f23295d;

    /* renamed from: e  reason: collision with root package name */
    public final Toolbar f23296e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23297f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f23298g;

    private C2423l(RelativeLayout relativeLayout, EditText editText, EditText editText2, View view, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f23292a = relativeLayout;
        this.f23293b = editText;
        this.f23294c = editText2;
        this.f23295d = view;
        this.f23296e = toolbar;
        this.f23297f = textView;
        this.f23298g = textView2;
    }

    public static C2423l a(View view) {
        int i5 = R.id.et_email_contact_us;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.et_email_contact_us);
        if (editText != null) {
            i5 = R.id.et_msg_contact_us;
            EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.et_msg_contact_us);
            if (editText2 != null) {
                i5 = R.id.loading_view_contact_us;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_contact_us);
                if (findChildViewById != null) {
                    i5 = R.id.toolbar_contact_us;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_contact_us);
                    if (toolbar != null) {
                        i5 = R.id.tv_send_contact_us;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_send_contact_us);
                        if (textView != null) {
                            i5 = R.id.tv_title_contact_us;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_contact_us);
                            if (textView2 != null) {
                                return new C2423l((RelativeLayout) view, editText, editText2, findChildViewById, toolbar, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2423l c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2423l d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.contact_us_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23292a;
    }
}
