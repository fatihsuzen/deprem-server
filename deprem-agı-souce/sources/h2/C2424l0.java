package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.l0  reason: case insensitive filesystem */
public final class C2424l0 implements ViewBinding {

    /* renamed from: A  reason: collision with root package name */
    public final TextView f23299A;

    /* renamed from: B  reason: collision with root package name */
    public final TextView f23300B;

    /* renamed from: C  reason: collision with root package name */
    public final TextView f23301C;

    /* renamed from: D  reason: collision with root package name */
    public final View f23302D;

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23303a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23304b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f23305c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f23306d;

    /* renamed from: e  reason: collision with root package name */
    public final View f23307e;

    /* renamed from: f  reason: collision with root package name */
    public final NestedScrollView f23308f;

    /* renamed from: g  reason: collision with root package name */
    public final Toolbar f23309g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f23310h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f23311i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f23312j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f23313k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f23314l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f23315m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f23316n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f23317o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f23318p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f23319q;

    /* renamed from: r  reason: collision with root package name */
    public final TextView f23320r;

    /* renamed from: s  reason: collision with root package name */
    public final TextView f23321s;

    /* renamed from: t  reason: collision with root package name */
    public final TextView f23322t;

    /* renamed from: u  reason: collision with root package name */
    public final TextView f23323u;

    /* renamed from: v  reason: collision with root package name */
    public final TextView f23324v;

    /* renamed from: w  reason: collision with root package name */
    public final TextView f23325w;

    /* renamed from: x  reason: collision with root package name */
    public final TextView f23326x;

    /* renamed from: y  reason: collision with root package name */
    public final TextView f23327y;

    /* renamed from: z  reason: collision with root package name */
    public final TextView f23328z;

    private C2424l0(RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, View view, NestedScrollView nestedScrollView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, View view2) {
        this.f23303a = relativeLayout;
        this.f23304b = imageView;
        this.f23305c = linearLayout;
        this.f23306d = linearLayout2;
        this.f23307e = view;
        this.f23308f = nestedScrollView;
        this.f23309g = toolbar;
        this.f23310h = textView;
        this.f23311i = textView2;
        this.f23312j = textView3;
        this.f23313k = textView4;
        this.f23314l = textView5;
        this.f23315m = textView6;
        this.f23316n = textView7;
        this.f23317o = textView8;
        this.f23318p = textView9;
        this.f23319q = textView10;
        this.f23320r = textView11;
        this.f23321s = textView12;
        this.f23322t = textView13;
        this.f23323u = textView14;
        this.f23324v = textView15;
        this.f23325w = textView16;
        this.f23326x = textView17;
        this.f23327y = textView18;
        this.f23328z = textView19;
        this.f23299A = textView20;
        this.f23300B = textView21;
        this.f23301C = textView22;
        this.f23302D = view2;
    }

    public static C2424l0 a(View view) {
        View view2 = view;
        int i5 = R.id.iv_user_avatar_my_stats;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_user_avatar_my_stats);
        if (imageView != null) {
            i5 = R.id.ll_header_my_stats;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_header_my_stats);
            if (linearLayout != null) {
                i5 = R.id.ll_installation_box_my_stats;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_installation_box_my_stats);
                if (linearLayout2 != null) {
                    i5 = R.id.loading_view_my_stats;
                    View findChildViewById = ViewBindings.findChildViewById(view2, R.id.loading_view_my_stats);
                    if (findChildViewById != null) {
                        i5 = R.id.nsv_my_stats;
                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, R.id.nsv_my_stats);
                        if (nestedScrollView != null) {
                            i5 = R.id.toolbar_my_stats;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar_my_stats);
                            if (toolbar != null) {
                                i5 = R.id.tv_data_collected_label_my_stats;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_data_collected_label_my_stats);
                                if (textView != null) {
                                    i5 = R.id.tv_installations_label_my_stats;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_installations_label_my_stats);
                                    if (textView2 != null) {
                                        i5 = R.id.tv_installations_value_my_stats;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_installations_value_my_stats);
                                        if (textView3 != null) {
                                            i5 = R.id.tv_likes_given_label_my_stats;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_likes_given_label_my_stats);
                                            if (textView4 != null) {
                                                i5 = R.id.tv_likes_given_value_my_stats;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_likes_given_value_my_stats);
                                                if (textView5 != null) {
                                                    i5 = R.id.tv_likes_label_my_stats;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_likes_label_my_stats);
                                                    if (textView6 != null) {
                                                        i5 = R.id.tv_likes_value_my_stats;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_likes_value_my_stats);
                                                        if (textView7 != null) {
                                                            i5 = R.id.tv_preregistrations_given_label_my_stats;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_preregistrations_given_label_my_stats);
                                                            if (textView8 != null) {
                                                                i5 = R.id.tv_preregistrations_given_value_my_stats;
                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_preregistrations_given_value_my_stats);
                                                                if (textView9 != null) {
                                                                    i5 = R.id.tv_replies_given_label_my_stats;
                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_replies_given_label_my_stats);
                                                                    if (textView10 != null) {
                                                                        i5 = R.id.tv_replies_given_value_my_stats;
                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_replies_given_value_my_stats);
                                                                        if (textView11 != null) {
                                                                            i5 = R.id.tv_replies_label_my_stats;
                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_replies_label_my_stats);
                                                                            if (textView12 != null) {
                                                                                i5 = R.id.tv_replies_value_my_stats;
                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_replies_value_my_stats);
                                                                                if (textView13 != null) {
                                                                                    i5 = R.id.tv_reviews_label_my_stats;
                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_reviews_label_my_stats);
                                                                                    if (textView14 != null) {
                                                                                        i5 = R.id.tv_reviews_value_my_stats;
                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_reviews_value_my_stats);
                                                                                        if (textView15 != null) {
                                                                                            i5 = R.id.tv_time_my_stats;
                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_time_my_stats);
                                                                                            if (textView16 != null) {
                                                                                                i5 = R.id.tv_toolbar_my_stats;
                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_toolbar_my_stats);
                                                                                                if (textView17 != null) {
                                                                                                    i5 = R.id.tv_total_downloads_title_my_stats;
                                                                                                    TextView textView18 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_total_downloads_title_my_stats);
                                                                                                    if (textView18 != null) {
                                                                                                        i5 = R.id.tv_total_downloads_value_my_stats;
                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_total_downloads_value_my_stats);
                                                                                                        if (textView19 != null) {
                                                                                                            i5 = R.id.tv_updates_label_my_stats;
                                                                                                            TextView textView20 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_updates_label_my_stats);
                                                                                                            if (textView20 != null) {
                                                                                                                i5 = R.id.tv_updates_value_my_stats;
                                                                                                                TextView textView21 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_updates_value_my_stats);
                                                                                                                if (textView21 != null) {
                                                                                                                    i5 = R.id.tv_usetime_my_stats;
                                                                                                                    TextView textView22 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_usetime_my_stats);
                                                                                                                    if (textView22 != null) {
                                                                                                                        i5 = R.id.v_bg_my_stats;
                                                                                                                        View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.v_bg_my_stats);
                                                                                                                        if (findChildViewById2 != null) {
                                                                                                                            return new C2424l0((RelativeLayout) view2, imageView, linearLayout, linearLayout2, findChildViewById, nestedScrollView, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, findChildViewById2);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i5)));
    }

    public static C2424l0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2424l0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.my_stats_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23303a;
    }
}
