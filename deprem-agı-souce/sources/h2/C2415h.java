package h2;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.h  reason: case insensitive filesystem */
public final class C2415h implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23090a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23091b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f23092c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f23093d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f23094e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f23095f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f23096g;

    /* renamed from: h  reason: collision with root package name */
    public final RelativeLayout f23097h;

    /* renamed from: i  reason: collision with root package name */
    public final RelativeLayout f23098i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f23099j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f23100k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f23101l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f23102m;

    private C2415h(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f23090a = relativeLayout;
        this.f23091b = imageView;
        this.f23092c = imageView2;
        this.f23093d = imageView3;
        this.f23094e = imageView4;
        this.f23095f = imageView5;
        this.f23096g = linearLayout;
        this.f23097h = relativeLayout2;
        this.f23098i = relativeLayout3;
        this.f23099j = textView;
        this.f23100k = textView2;
        this.f23101l = textView3;
        this.f23102m = textView4;
    }

    public static C2415h a(View view) {
        View view2 = view;
        int i5 = R.id.iv_deactivated;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_deactivated);
        if (imageView != null) {
            i5 = R.id.iv_download_remote;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_download_remote);
            if (imageView2 != null) {
                i5 = R.id.iv_uninstall;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_uninstall);
                if (imageView3 != null) {
                    i5 = R.id.iv_virustotal;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_virustotal);
                    if (imageView4 != null) {
                        i5 = R.id.iv_wishlist;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_wishlist);
                        if (imageView5 != null) {
                            i5 = R.id.rl_deactivated;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.rl_deactivated);
                            if (linearLayout != null) {
                                i5 = R.id.rl_download_cancel;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_download_cancel);
                                if (relativeLayout != null) {
                                    i5 = R.id.rl_status_loading;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_status_loading);
                                    if (relativeLayout2 != null) {
                                        i5 = R.id.tv_deactivated;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_deactivated);
                                        if (textView != null) {
                                            i5 = R.id.tv_download_cancel;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_download_cancel);
                                            if (textView2 != null) {
                                                i5 = R.id.tv_open;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_open);
                                                if (textView3 != null) {
                                                    i5 = R.id.tv_pause;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_pause);
                                                    if (textView4 != null) {
                                                        return new C2415h((RelativeLayout) view2, imageView, imageView2, imageView3, imageView4, imageView5, linearLayout, relativeLayout, relativeLayout2, textView, textView2, textView3, textView4);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i5)));
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23090a;
    }
}
