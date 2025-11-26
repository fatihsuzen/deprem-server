package h2;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class v1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23636a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f23637b;

    /* renamed from: c  reason: collision with root package name */
    public final ProgressBar f23638c;

    /* renamed from: d  reason: collision with root package name */
    public final ProgressBar f23639d;

    /* renamed from: e  reason: collision with root package name */
    public final RelativeLayout f23640e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23641f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f23642g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f23643h;

    private v1(RelativeLayout relativeLayout, LinearLayout linearLayout, ProgressBar progressBar, ProgressBar progressBar2, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.f23636a = relativeLayout;
        this.f23637b = linearLayout;
        this.f23638c = progressBar;
        this.f23639d = progressBar2;
        this.f23640e = relativeLayout2;
        this.f23641f = textView;
        this.f23642g = textView2;
        this.f23643h = textView3;
    }

    public static v1 a(View view) {
        int i5 = R.id.ll_pb_fus;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_pb_fus);
        if (linearLayout != null) {
            i5 = R.id.pb_enough_storage;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.pb_enough_storage);
            if (progressBar != null) {
                i5 = R.id.pb_not_storage;
                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, R.id.pb_not_storage);
                if (progressBar2 != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view;
                    i5 = R.id.tv_no_storage_action;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_storage_action);
                    if (textView != null) {
                        i5 = R.id.tv_not_storage;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_not_storage);
                        if (textView2 != null) {
                            i5 = R.id.tv_not_storage_text;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_not_storage_text);
                            if (textView3 != null) {
                                return new v1(relativeLayout, linearLayout, progressBar, progressBar2, relativeLayout, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23636a;
    }
}
