package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class E implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f22327a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22328b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f22329c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f22330d;

    /* renamed from: e  reason: collision with root package name */
    public final RelativeLayout f22331e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f22332f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f22333g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f22334h;

    private E(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.f22327a = linearLayout;
        this.f22328b = imageView;
        this.f22329c = imageView2;
        this.f22330d = relativeLayout;
        this.f22331e = relativeLayout2;
        this.f22332f = textView;
        this.f22333g = textView2;
        this.f22334h = textView3;
    }

    public static E a(View view) {
        int i5 = R.id.iv_recommended_option;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_recommended_option);
        if (imageView != null) {
            i5 = R.id.iv_wishlist_option;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_wishlist_option);
            if (imageView2 != null) {
                i5 = R.id.ll_recommended_option;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.ll_recommended_option);
                if (relativeLayout != null) {
                    i5 = R.id.ll_wishlist_option;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.ll_wishlist_option);
                    if (relativeLayout2 != null) {
                        i5 = R.id.tv_recommended_option;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_recommended_option);
                        if (textView != null) {
                            i5 = R.id.tv_title_dialog_rename;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_dialog_rename);
                            if (textView2 != null) {
                                i5 = R.id.tv_wishlist_option;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_wishlist_option);
                                if (textView3 != null) {
                                    return new E((LinearLayout) view, imageView, imageView2, relativeLayout, relativeLayout2, textView, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static E c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static E d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_user_list_selector, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f22327a;
    }
}
