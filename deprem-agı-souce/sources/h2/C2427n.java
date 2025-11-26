package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.n  reason: case insensitive filesystem */
public final class C2427n implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23379a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f23380b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f23381c;

    /* renamed from: d  reason: collision with root package name */
    public final ProgressBar f23382d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23383e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23384f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f23385g;

    private C2427n(RelativeLayout relativeLayout, LinearLayout linearLayout, LinearLayout linearLayout2, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3) {
        this.f23379a = relativeLayout;
        this.f23380b = linearLayout;
        this.f23381c = linearLayout2;
        this.f23382d = progressBar;
        this.f23383e = textView;
        this.f23384f = textView2;
        this.f23385g = textView3;
    }

    public static C2427n a(View view) {
        int i5 = R.id.ll_content_deep_link_availables;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_content_deep_link_availables);
        if (linearLayout != null) {
            i5 = R.id.ll_deep_link_availables;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_deep_link_availables);
            if (linearLayout2 != null) {
                i5 = R.id.pb_loaging_deep_links;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.pb_loaging_deep_links);
                if (progressBar != null) {
                    i5 = R.id.tv_cancel_deep_link_availables;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_cancel_deep_link_availables);
                    if (textView != null) {
                        i5 = R.id.tv_download_deep_link_availables;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_download_deep_link_availables);
                        if (textView2 != null) {
                            i5 = R.id.tv_title_deep_link_availables;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_deep_link_availables);
                            if (textView3 != null) {
                                return new C2427n((RelativeLayout) view, linearLayout, linearLayout2, progressBar, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2427n c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2427n d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.deep_links_availables_popup, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23379a;
    }
}
