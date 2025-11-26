package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.z  reason: case insensitive filesystem */
public final class C2450z implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f23691a;

    /* renamed from: b  reason: collision with root package name */
    public final EditText f23692b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23693c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23694d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23695e;

    private C2450z(LinearLayout linearLayout, EditText editText, TextView textView, TextView textView2, TextView textView3) {
        this.f23691a = linearLayout;
        this.f23692b = editText;
        this.f23693c = textView;
        this.f23694d = textView2;
        this.f23695e = textView3;
    }

    public static C2450z a(View view) {
        int i5 = R.id.et_dialog_rename;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.et_dialog_rename);
        if (editText != null) {
            i5 = R.id.tv_cancel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_cancel);
            if (textView != null) {
                i5 = R.id.tv_ok;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_ok);
                if (textView2 != null) {
                    i5 = R.id.tv_title_dialog_rename;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_dialog_rename);
                    if (textView3 != null) {
                        return new C2450z((LinearLayout) view, editText, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2450z c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2450z d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_rename, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f23691a;
    }
}
