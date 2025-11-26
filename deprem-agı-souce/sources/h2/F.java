package h2;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class F implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22344a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22345b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f22346c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f22347d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f22348e;

    /* renamed from: f  reason: collision with root package name */
    public final ProgressBar f22349f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f22350g;

    /* renamed from: h  reason: collision with root package name */
    public final RelativeLayout f22351h;

    /* renamed from: i  reason: collision with root package name */
    public final RelativeLayout f22352i;

    /* renamed from: j  reason: collision with root package name */
    public final RelativeLayout f22353j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f22354k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f22355l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f22356m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f22357n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f22358o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f22359p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f22360q;

    /* renamed from: r  reason: collision with root package name */
    public final TextView f22361r;

    private F(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ProgressBar progressBar, LinearLayout linearLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.f22344a = relativeLayout;
        this.f22345b = imageView;
        this.f22346c = imageView2;
        this.f22347d = imageView3;
        this.f22348e = imageView4;
        this.f22349f = progressBar;
        this.f22350g = linearLayout;
        this.f22351h = relativeLayout2;
        this.f22352i = relativeLayout3;
        this.f22353j = relativeLayout4;
        this.f22354k = textView;
        this.f22355l = textView2;
        this.f22356m = textView3;
        this.f22357n = textView4;
        this.f22358o = textView5;
        this.f22359p = textView6;
        this.f22360q = textView7;
        this.f22361r = textView8;
    }

    public static F a(View view) {
        View view2 = view;
        int i5 = R.id.iv_cancel_downloading;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_cancel_downloading);
        if (imageView != null) {
            i5 = R.id.iv_deactivated;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_deactivated);
            if (imageView2 != null) {
                i5 = R.id.iv_resume_downloading;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_resume_downloading);
                if (imageView3 != null) {
                    i5 = R.id.iv_status_pre_register;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_status_pre_register);
                    if (imageView4 != null) {
                        i5 = R.id.pb_download_button;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.pb_download_button);
                        if (progressBar != null) {
                            i5 = R.id.rl_deactivated;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.rl_deactivated);
                            if (linearLayout != null) {
                                i5 = R.id.rl_status_downloading;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_status_downloading);
                                if (relativeLayout != null) {
                                    i5 = R.id.rl_status_loading;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_status_loading);
                                    if (relativeLayout2 != null) {
                                        i5 = R.id.rl_status_pre_register;
                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_status_pre_register);
                                        if (relativeLayout3 != null) {
                                            i5 = R.id.tv_deactivated;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_deactivated);
                                            if (textView != null) {
                                                i5 = R.id.tv_enqueue_download;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_enqueue_download);
                                                if (textView2 != null) {
                                                    i5 = R.id.tv_open_download_button;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_open_download_button);
                                                    if (textView3 != null) {
                                                        i5 = R.id.tv_percentage_downloaded;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_percentage_downloaded);
                                                        if (textView4 != null) {
                                                            i5 = R.id.tv_size_downloaded;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_size_downloaded);
                                                            if (textView5 != null) {
                                                                i5 = R.id.tv_size_total;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_size_total);
                                                                if (textView6 != null) {
                                                                    i5 = R.id.tv_status_download;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_status_download);
                                                                    if (textView7 != null) {
                                                                        i5 = R.id.tv_status_pre_register;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_status_pre_register);
                                                                        if (textView8 != null) {
                                                                            return new F((RelativeLayout) view2, imageView, imageView2, imageView3, imageView4, progressBar, linearLayout, relativeLayout, relativeLayout2, relativeLayout3, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i5)));
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22344a;
    }
}
