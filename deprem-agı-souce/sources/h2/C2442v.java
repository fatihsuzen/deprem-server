package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.v  reason: case insensitive filesystem */
public final class C2442v implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23620a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23621b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f23622c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23623d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23624e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23625f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f23626g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f23627h;

    /* renamed from: i  reason: collision with root package name */
    public final View f23628i;

    private C2442v(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view) {
        this.f23620a = relativeLayout;
        this.f23621b = imageView;
        this.f23622c = relativeLayout2;
        this.f23623d = textView;
        this.f23624e = textView2;
        this.f23625f = textView3;
        this.f23626g = textView4;
        this.f23627h = textView5;
        this.f23628i = view;
    }

    public static C2442v a(View view) {
        int i5 = R.id.iv_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_icon);
        if (imageView != null) {
            i5 = R.id.rl_header;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_header);
            if (relativeLayout != null) {
                i5 = R.id.tv_app_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_app_name);
                if (textView != null) {
                    i5 = R.id.tv_open_app_details_positive;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_open_app_details_positive);
                    if (textView2 != null) {
                        i5 = R.id.tv_rollback_positive;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_rollback_positive);
                        if (textView3 != null) {
                            i5 = R.id.tv_uninstall_positive;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_uninstall_positive);
                            if (textView4 != null) {
                                i5 = R.id.tv_virus_report_positive;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_virus_report_positive);
                                if (textView5 != null) {
                                    i5 = R.id.v_outside_header;
                                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.v_outside_header);
                                    if (findChildViewById != null) {
                                        return new C2442v((RelativeLayout) view, imageView, relativeLayout, textView, textView2, textView3, textView4, textView5, findChildViewById);
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

    public static C2442v c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2442v d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_positive_selected, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23620a;
    }
}
