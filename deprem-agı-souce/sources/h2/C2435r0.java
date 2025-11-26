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
import com.uptodown.views.FullWidthImageView;

/* renamed from: h2.r0  reason: case insensitive filesystem */
public final class C2435r0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23499a;

    /* renamed from: b  reason: collision with root package name */
    public final FullWidthImageView f23500b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f23501c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f23502d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f23503e;

    /* renamed from: f  reason: collision with root package name */
    public final ProgressBar f23504f;

    /* renamed from: g  reason: collision with root package name */
    public final RelativeLayout f23505g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f23506h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f23507i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f23508j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f23509k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f23510l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f23511m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f23512n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f23513o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f23514p;

    private C2435r0(RelativeLayout relativeLayout, FullWidthImageView fullWidthImageView, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, ProgressBar progressBar, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.f23499a = relativeLayout;
        this.f23500b = fullWidthImageView;
        this.f23501c = imageView;
        this.f23502d = linearLayout;
        this.f23503e = linearLayout2;
        this.f23504f = progressBar;
        this.f23505g = relativeLayout2;
        this.f23506h = textView;
        this.f23507i = textView2;
        this.f23508j = textView3;
        this.f23509k = textView4;
        this.f23510l = textView5;
        this.f23511m = textView6;
        this.f23512n = textView7;
        this.f23513o = textView8;
        this.f23514p = textView9;
    }

    public static C2435r0 a(View view) {
        View view2 = view;
        int i5 = R.id.iv_top_app_feature_organization;
        FullWidthImageView fullWidthImageView = (FullWidthImageView) ViewBindings.findChildViewById(view2, R.id.iv_top_app_feature_organization);
        if (fullWidthImageView != null) {
            i5 = R.id.iv_top_app_logo_organization;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_top_app_logo_organization);
            if (imageView != null) {
                i5 = R.id.ll_progress_top_organization;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_progress_top_organization);
                if (linearLayout != null) {
                    i5 = R.id.ll_top_app_desc_organization;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_top_app_desc_organization);
                    if (linearLayout2 != null) {
                        i5 = R.id.pb_progress_logo_organization;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.pb_progress_logo_organization);
                        if (progressBar != null) {
                            i5 = R.id.rl_logo_organization;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_logo_organization);
                            if (relativeLayout != null) {
                                i5 = R.id.tv_progress_top_organization;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_progress_top_organization);
                                if (textView != null) {
                                    i5 = R.id.tv_top_app_desc_organization;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_top_app_desc_organization);
                                    if (textView2 != null) {
                                        i5 = R.id.tv_top_app_download_organization;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_top_app_download_organization);
                                        if (textView3 != null) {
                                            i5 = R.id.tv_top_app_downloads_counter_organization;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_top_app_downloads_counter_organization);
                                            if (textView4 != null) {
                                                i5 = R.id.tv_top_app_name_organization;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_top_app_name_organization);
                                                if (textView5 != null) {
                                                    i5 = R.id.tv_top_app_status_organization;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_top_app_status_organization);
                                                    if (textView6 != null) {
                                                        i5 = R.id.tv_top_app_title_organization;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_top_app_title_organization);
                                                        if (textView7 != null) {
                                                            i5 = R.id.tv_top_app_valoration_organization;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_top_app_valoration_organization);
                                                            if (textView8 != null) {
                                                                i5 = R.id.tv_verified_top_organization;
                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_verified_top_organization);
                                                                if (textView9 != null) {
                                                                    return new C2435r0((RelativeLayout) view2, fullWidthImageView, imageView, linearLayout, linearLayout2, progressBar, relativeLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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

    public static C2435r0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.organization_main_app_card, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23499a;
    }
}
