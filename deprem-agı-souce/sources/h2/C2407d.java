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

/* renamed from: h2.d  reason: case insensitive filesystem */
public final class C2407d implements ViewBinding {

    /* renamed from: A  reason: collision with root package name */
    public final View f22869A;

    /* renamed from: B  reason: collision with root package name */
    public final View f22870B;

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22871a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22872b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f22873c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f22874d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f22875e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f22876f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f22877g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f22878h;

    /* renamed from: i  reason: collision with root package name */
    public final ProgressBar f22879i;

    /* renamed from: j  reason: collision with root package name */
    public final RelativeLayout f22880j;

    /* renamed from: k  reason: collision with root package name */
    public final RelativeLayout f22881k;

    /* renamed from: l  reason: collision with root package name */
    public final RelativeLayout f22882l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f22883m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f22884n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f22885o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f22886p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f22887q;

    /* renamed from: r  reason: collision with root package name */
    public final TextView f22888r;

    /* renamed from: s  reason: collision with root package name */
    public final TextView f22889s;

    /* renamed from: t  reason: collision with root package name */
    public final TextView f22890t;

    /* renamed from: u  reason: collision with root package name */
    public final TextView f22891u;

    /* renamed from: v  reason: collision with root package name */
    public final TextView f22892v;

    /* renamed from: w  reason: collision with root package name */
    public final TextView f22893w;

    /* renamed from: x  reason: collision with root package name */
    public final TextView f22894x;

    /* renamed from: y  reason: collision with root package name */
    public final TextView f22895y;

    /* renamed from: z  reason: collision with root package name */
    public final TextView f22896z;

    private C2407d(RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, ProgressBar progressBar, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, View view, View view2) {
        this.f22871a = relativeLayout;
        this.f22872b = imageView;
        this.f22873c = linearLayout;
        this.f22874d = linearLayout2;
        this.f22875e = linearLayout3;
        this.f22876f = linearLayout4;
        this.f22877g = linearLayout5;
        this.f22878h = linearLayout6;
        this.f22879i = progressBar;
        this.f22880j = relativeLayout2;
        this.f22881k = relativeLayout3;
        this.f22882l = relativeLayout4;
        this.f22883m = textView;
        this.f22884n = textView2;
        this.f22885o = textView3;
        this.f22886p = textView4;
        this.f22887q = textView5;
        this.f22888r = textView6;
        this.f22889s = textView7;
        this.f22890t = textView8;
        this.f22891u = textView9;
        this.f22892v = textView10;
        this.f22893w = textView11;
        this.f22894x = textView12;
        this.f22895y = textView13;
        this.f22896z = textView14;
        this.f22869A = view;
        this.f22870B = view2;
    }

    public static C2407d a(View view) {
        View view2 = view;
        int i5 = R.id.iv_logo_app_detail;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_logo_app_detail);
        if (imageView != null) {
            i5 = R.id.ll_app_info;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_app_info);
            if (linearLayout != null) {
                i5 = R.id.ll_download_info_app_detail;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_download_info_app_detail);
                if (linearLayout2 != null) {
                    i5 = R.id.ll_downloads_counter_app_detail;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_downloads_counter_app_detail);
                    if (linearLayout3 != null) {
                        i5 = R.id.ll_info_app_detail;
                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_info_app_detail);
                        if (linearLayout4 != null) {
                            i5 = R.id.ll_last_update_app_detail;
                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_last_update_app_detail);
                            if (linearLayout5 != null) {
                                i5 = R.id.ll_valoration_app_detail;
                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_valoration_app_detail);
                                if (linearLayout6 != null) {
                                    i5 = R.id.pb_progress_app_detail;
                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.pb_progress_app_detail);
                                    if (progressBar != null) {
                                        i5 = R.id.rl_head_main_info;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_head_main_info);
                                        if (relativeLayout != null) {
                                            i5 = R.id.rl_logo_app_detail;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_logo_app_detail);
                                            if (relativeLayout2 != null) {
                                                i5 = R.id.rl_valoration_app_detail;
                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_valoration_app_detail);
                                                if (relativeLayout3 != null) {
                                                    i5 = R.id.tv_author_app_detail;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_author_app_detail);
                                                    if (textView != null) {
                                                        i5 = R.id.tv_author_onboard_badge;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_author_onboard_badge);
                                                        if (textView2 != null) {
                                                            i5 = R.id.tv_badge_ranking;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_badge_ranking);
                                                            if (textView3 != null) {
                                                                i5 = R.id.tv_downloads_counter_app_detail;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_downloads_counter_app_detail);
                                                                if (textView4 != null) {
                                                                    i5 = R.id.tv_downloads_label_app_detail;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_downloads_label_app_detail);
                                                                    if (textView5 != null) {
                                                                        i5 = R.id.tv_last_update_app_detail;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_last_update_app_detail);
                                                                        if (textView6 != null) {
                                                                            i5 = R.id.tv_last_update_label_app_detail;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_last_update_label_app_detail);
                                                                            if (textView7 != null) {
                                                                                i5 = R.id.tv_name_app_detail;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_name_app_detail);
                                                                                if (textView8 != null) {
                                                                                    i5 = R.id.tv_phase_app_detail;
                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_phase_app_detail);
                                                                                    if (textView9 != null) {
                                                                                        i5 = R.id.tv_progress_app_detail;
                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_progress_app_detail);
                                                                                        if (textView10 != null) {
                                                                                            i5 = R.id.tv_reviews_counter_app_detail;
                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_reviews_counter_app_detail);
                                                                                            if (textView11 != null) {
                                                                                                i5 = R.id.tv_valoration_app_detail;
                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_valoration_app_detail);
                                                                                                if (textView12 != null) {
                                                                                                    i5 = R.id.tv_verified_app_detail;
                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_verified_app_detail);
                                                                                                    if (textView13 != null) {
                                                                                                        i5 = R.id.tv_version_app_detail;
                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_version_app_detail);
                                                                                                        if (textView14 != null) {
                                                                                                            i5 = R.id.v_separator_downloads_app_detail;
                                                                                                            View findChildViewById = ViewBindings.findChildViewById(view2, R.id.v_separator_downloads_app_detail);
                                                                                                            if (findChildViewById != null) {
                                                                                                                i5 = R.id.v_separator_last_update_app_detail;
                                                                                                                View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.v_separator_last_update_app_detail);
                                                                                                                if (findChildViewById2 != null) {
                                                                                                                    return new C2407d((RelativeLayout) view2, imageView, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, progressBar, relativeLayout, relativeLayout2, relativeLayout3, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, findChildViewById, findChildViewById2);
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
        return this.f22871a;
    }
}
