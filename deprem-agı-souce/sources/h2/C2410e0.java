package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.e0  reason: case insensitive filesystem */
public final class C2410e0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f22961a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22962b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f22963c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f22964d;

    /* renamed from: e  reason: collision with root package name */
    public final ProgressBar f22965e;

    /* renamed from: f  reason: collision with root package name */
    public final RelativeLayout f22966f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f22967g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f22968h;

    private C2410e0(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2, ProgressBar progressBar, RelativeLayout relativeLayout, TextView textView, TextView textView2) {
        this.f22961a = linearLayout;
        this.f22962b = imageView;
        this.f22963c = imageView2;
        this.f22964d = linearLayout2;
        this.f22965e = progressBar;
        this.f22966f = relativeLayout;
        this.f22967g = textView;
        this.f22968h = textView2;
    }

    public static C2410e0 a(View view) {
        int i5 = R.id.iv_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_item);
        if (imageView != null) {
            i5 = R.id.iv_see_more_list;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_see_more_list);
            if (imageView2 != null) {
                i5 = R.id.ll_apps_container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_apps_container);
                if (linearLayout != null) {
                    i5 = R.id.loading_view_list;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.loading_view_list);
                    if (progressBar != null) {
                        i5 = R.id.rl_apps_container;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_apps_container);
                        if (relativeLayout != null) {
                            i5 = R.id.tv_app_count;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_app_count);
                            if (textView != null) {
                                i5 = R.id.tv_list_title;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_list_title);
                                if (textView2 != null) {
                                    return new C2410e0((LinearLayout) view, imageView, imageView2, linearLayout, progressBar, relativeLayout, textView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2410e0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2410e0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.lists_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f22961a;
    }
}
