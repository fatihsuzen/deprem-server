package h2;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class x1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23670a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f23671b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23672c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23673d;

    /* renamed from: e  reason: collision with root package name */
    public final View f23674e;

    private x1(RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, View view) {
        this.f23670a = relativeLayout;
        this.f23671b = textView;
        this.f23672c = textView2;
        this.f23673d = textView3;
        this.f23674e = view;
    }

    public static x1 a(View view) {
        int i5 = R.id.tv_read_more_whats_new;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_read_more_whats_new);
        if (textView != null) {
            i5 = R.id.tv_whats_new;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_whats_new);
            if (textView2 != null) {
                i5 = R.id.tv_whats_new_content;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_whats_new_content);
                if (textView3 != null) {
                    i5 = R.id.v_shadow_whats_new;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.v_shadow_whats_new);
                    if (findChildViewById != null) {
                        return new x1((RelativeLayout) view, textView, textView2, textView3, findChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23670a;
    }
}
