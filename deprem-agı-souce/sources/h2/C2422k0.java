package h2;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.k0  reason: case insensitive filesystem */
public final class C2422k0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23280a;

    /* renamed from: b  reason: collision with root package name */
    public final G f23281b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f23282c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23283d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23284e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23285f;

    private C2422k0(RelativeLayout relativeLayout, G g5, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.f23280a = relativeLayout;
        this.f23281b = g5;
        this.f23282c = relativeLayout2;
        this.f23283d = textView;
        this.f23284e = textView2;
        this.f23285f = textView3;
    }

    public static C2422k0 a(View view) {
        int i5 = R.id.ll_order_my_downloads;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.ll_order_my_downloads);
        if (findChildViewById != null) {
            G a5 = G.a(findChildViewById);
            i5 = R.id.rl_my_downloads_selector;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_my_downloads_selector);
            if (relativeLayout != null) {
                i5 = R.id.tv_delete_all_downloads;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_delete_all_downloads);
                if (textView != null) {
                    i5 = R.id.tv_delete_selected_downloads;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_delete_selected_downloads);
                    if (textView2 != null) {
                        i5 = R.id.tv_label_selected_items;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_label_selected_items);
                        if (textView3 != null) {
                            return new C2422k0((RelativeLayout) view, a5, relativeLayout, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23280a;
    }
}
