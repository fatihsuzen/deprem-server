package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.w  reason: case insensitive filesystem */
public final class C2444w implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f23644a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f23645b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23646c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23647d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23648e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23649f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f23650g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f23651h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f23652i;

    private C2444w(LinearLayout linearLayout, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.f23644a = linearLayout;
        this.f23645b = relativeLayout;
        this.f23646c = textView;
        this.f23647d = textView2;
        this.f23648e = textView3;
        this.f23649f = textView4;
        this.f23650g = textView5;
        this.f23651h = textView6;
        this.f23652i = textView7;
    }

    public static C2444w a(View view) {
        int i5 = R.id.rl_result_scan;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_result_scan);
        if (relativeLayout != null) {
            i5 = R.id.tv_cancel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_cancel);
            if (textView != null) {
                i5 = R.id.tv_install;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_install);
                if (textView2 != null) {
                    i5 = R.id.tv_last_scan_results;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_last_scan_results);
                    if (textView3 != null) {
                        i5 = R.id.tv_msg;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_msg);
                        if (textView4 != null) {
                            i5 = R.id.tv_msg_results;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_msg_results);
                            if (textView5 != null) {
                                i5 = R.id.tv_positives_results;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_positives_results);
                                if (textView6 != null) {
                                    i5 = R.id.tv_title_dialog_turbo_positives_detected;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_dialog_turbo_positives_detected);
                                    if (textView7 != null) {
                                        return new C2444w((LinearLayout) view, relativeLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2444w c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2444w d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_positives_detected, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f23644a;
    }
}
