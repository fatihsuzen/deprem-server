package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.o  reason: case insensitive filesystem */
public final class C2429o implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f23409a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f23410b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23411c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23412d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23413e;

    private C2429o(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.f23409a = linearLayout;
        this.f23410b = linearLayout2;
        this.f23411c = textView;
        this.f23412d = textView2;
        this.f23413e = textView3;
    }

    public static C2429o a(View view) {
        int i5 = R.id.ll_dialog_cd;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_dialog_cd);
        if (linearLayout != null) {
            i5 = R.id.tv_accept_cd;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_accept_cd);
            if (textView != null) {
                i5 = R.id.tv_changelog_cd;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_changelog_cd);
                if (textView2 != null) {
                    i5 = R.id.tv_title_cd;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_cd);
                    if (textView3 != null) {
                        return new C2429o((LinearLayout) view, linearLayout, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2429o c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_changelog, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f23409a;
    }
}
