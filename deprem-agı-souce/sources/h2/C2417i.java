package h2;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.i  reason: case insensitive filesystem */
public final class C2417i implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f23210a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f23211b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f23212c;

    /* renamed from: d  reason: collision with root package name */
    public final View f23213d;

    /* renamed from: e  reason: collision with root package name */
    public final View f23214e;

    /* renamed from: f  reason: collision with root package name */
    public final View f23215f;

    /* renamed from: g  reason: collision with root package name */
    public final View f23216g;

    /* renamed from: h  reason: collision with root package name */
    public final View f23217h;

    /* renamed from: i  reason: collision with root package name */
    public final View f23218i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f23219j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f23220k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f23221l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f23222m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f23223n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f23224o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f23225p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f23226q;

    private C2417i(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, View view, View view2, View view3, View view4, View view5, View view6, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.f23210a = linearLayout;
        this.f23211b = linearLayout2;
        this.f23212c = linearLayout3;
        this.f23213d = view;
        this.f23214e = view2;
        this.f23215f = view3;
        this.f23216g = view4;
        this.f23217h = view5;
        this.f23218i = view6;
        this.f23219j = textView;
        this.f23220k = textView2;
        this.f23221l = textView3;
        this.f23222m = textView4;
        this.f23223n = textView5;
        this.f23224o = textView6;
        this.f23225p = textView7;
        this.f23226q = textView8;
    }

    public static C2417i a(View view) {
        View view2 = view;
        LinearLayout linearLayout = (LinearLayout) view2;
        int i5 = R.id.ll_reviews_counter_chart;
        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_reviews_counter_chart);
        if (linearLayout2 != null) {
            i5 = R.id.star1_graphical_value_app_detail;
            View findChildViewById = ViewBindings.findChildViewById(view2, R.id.star1_graphical_value_app_detail);
            if (findChildViewById != null) {
                i5 = R.id.star2_graphical_value_app_detail;
                View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.star2_graphical_value_app_detail);
                if (findChildViewById2 != null) {
                    i5 = R.id.star3_graphical_value_app_detail;
                    View findChildViewById3 = ViewBindings.findChildViewById(view2, R.id.star3_graphical_value_app_detail);
                    if (findChildViewById3 != null) {
                        i5 = R.id.star4_graphical_value_app_detail;
                        View findChildViewById4 = ViewBindings.findChildViewById(view2, R.id.star4_graphical_value_app_detail);
                        if (findChildViewById4 != null) {
                            i5 = R.id.star5_graphical_value_app_detail;
                            View findChildViewById5 = ViewBindings.findChildViewById(view2, R.id.star5_graphical_value_app_detail);
                            if (findChildViewById5 != null) {
                                i5 = R.id.star5_graphical_value_app_detail_background;
                                View findChildViewById6 = ViewBindings.findChildViewById(view2, R.id.star5_graphical_value_app_detail_background);
                                if (findChildViewById6 != null) {
                                    i5 = R.id.tv_chart_1_value;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_chart_1_value);
                                    if (textView != null) {
                                        i5 = R.id.tv_chart_2_value;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_chart_2_value);
                                        if (textView2 != null) {
                                            i5 = R.id.tv_chart_3_value;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_chart_3_value);
                                            if (textView3 != null) {
                                                i5 = R.id.tv_chart_4_value;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_chart_4_value);
                                                if (textView4 != null) {
                                                    i5 = R.id.tv_chart_5_value;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_chart_5_value);
                                                    if (textView5 != null) {
                                                        i5 = R.id.tv_review_rating_app_detail;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_review_rating_app_detail);
                                                        if (textView6 != null) {
                                                            i5 = R.id.tv_reviews_count_app_detail;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_reviews_count_app_detail);
                                                            if (textView7 != null) {
                                                                i5 = R.id.tv_reviews_title_app_detail;
                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_reviews_title_app_detail);
                                                                if (textView8 != null) {
                                                                    return new C2417i(linearLayout, linearLayout, linearLayout2, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
    public LinearLayout getRoot() {
        return this.f23210a;
    }
}
