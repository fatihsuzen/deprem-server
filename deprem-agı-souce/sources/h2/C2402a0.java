package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.a0  reason: case insensitive filesystem */
public final class C2402a0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22740a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f22741b;

    /* renamed from: c  reason: collision with root package name */
    public final Toolbar f22742c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f22743d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f22744e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f22745f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f22746g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f22747h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f22748i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f22749j;

    private C2402a0(RelativeLayout relativeLayout, LinearLayout linearLayout, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.f22740a = relativeLayout;
        this.f22741b = linearLayout;
        this.f22742c = toolbar;
        this.f22743d = textView;
        this.f22744e = textView2;
        this.f22745f = textView3;
        this.f22746g = textView4;
        this.f22747h = textView5;
        this.f22748i = textView6;
        this.f22749j = textView7;
    }

    public static C2402a0 a(View view) {
        int i5 = R.id.ll_dev_on_board_information_activity;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_dev_on_board_information_activity);
        if (linearLayout != null) {
            i5 = R.id.tb_information_activity;
            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.tb_information_activity);
            if (toolbar != null) {
                i5 = R.id.tv_badge_information_activity;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_badge_information_activity);
                if (textView != null) {
                    i5 = R.id.tv_description_information_activity;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_description_information_activity);
                    if (textView2 != null) {
                        i5 = R.id.tv_first_information_activity;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_first_information_activity);
                        if (textView3 != null) {
                            i5 = R.id.tv_more_info_information_activity;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_more_info_information_activity);
                            if (textView4 != null) {
                                i5 = R.id.tv_second_information_activity;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_second_information_activity);
                                if (textView5 != null) {
                                    i5 = R.id.tv_third_information_activity;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_third_information_activity);
                                    if (textView6 != null) {
                                        i5 = R.id.tv_title_information_activity;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_information_activity);
                                        if (textView7 != null) {
                                            return new C2402a0((RelativeLayout) view, linearLayout, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7);
                                        }
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

    public static C2402a0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2402a0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.information_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22740a;
    }
}
