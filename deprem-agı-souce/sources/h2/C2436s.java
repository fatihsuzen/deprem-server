package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.s  reason: case insensitive filesystem */
public final class C2436s implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f23525a;

    /* renamed from: b  reason: collision with root package name */
    public final CheckBox f23526b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23527c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23528d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23529e;

    private C2436s(LinearLayout linearLayout, CheckBox checkBox, TextView textView, TextView textView2, TextView textView3) {
        this.f23525a = linearLayout;
        this.f23526b = checkBox;
        this.f23527c = textView;
        this.f23528d = textView2;
        this.f23529e = textView3;
    }

    public static C2436s a(View view) {
        int i5 = R.id.cb_dont_show_again;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.cb_dont_show_again);
        if (checkBox != null) {
            i5 = R.id.tv_cancel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_cancel);
            if (textView != null) {
                i5 = R.id.tv_msg;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_msg);
                if (textView2 != null) {
                    i5 = R.id.tv_ok;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_ok);
                    if (textView3 != null) {
                        return new C2436s((LinearLayout) view, checkBox, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2436s c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2436s d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_generic_accept_cancel, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f23525a;
    }
}
