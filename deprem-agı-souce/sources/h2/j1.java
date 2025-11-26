package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class j1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23254a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23255b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f23256c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f23257d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f23258e;

    /* renamed from: f  reason: collision with root package name */
    public final View f23259f;

    /* renamed from: g  reason: collision with root package name */
    public final RadioButton f23260g;

    /* renamed from: h  reason: collision with root package name */
    public final RadioButton f23261h;

    /* renamed from: i  reason: collision with root package name */
    public final RadioGroup f23262i;

    /* renamed from: j  reason: collision with root package name */
    public final RecyclerView f23263j;

    /* renamed from: k  reason: collision with root package name */
    public final Toolbar f23264k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f23265l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f23266m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f23267n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f23268o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f23269p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f23270q;

    /* renamed from: r  reason: collision with root package name */
    public final TextView f23271r;

    /* renamed from: s  reason: collision with root package name */
    public final TextView f23272s;

    /* renamed from: t  reason: collision with root package name */
    public final TextView f23273t;

    /* renamed from: u  reason: collision with root package name */
    public final TextView f23274u;

    /* renamed from: v  reason: collision with root package name */
    public final TextView f23275v;

    /* renamed from: w  reason: collision with root package name */
    public final TextView f23276w;

    /* renamed from: x  reason: collision with root package name */
    public final TextView f23277x;

    /* renamed from: y  reason: collision with root package name */
    public final TextView f23278y;

    private j1(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, View view, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14) {
        this.f23254a = relativeLayout;
        this.f23255b = imageView;
        this.f23256c = imageView2;
        this.f23257d = imageView3;
        this.f23258e = linearLayout;
        this.f23259f = view;
        this.f23260g = radioButton;
        this.f23261h = radioButton2;
        this.f23262i = radioGroup;
        this.f23263j = recyclerView;
        this.f23264k = toolbar;
        this.f23265l = textView;
        this.f23266m = textView2;
        this.f23267n = textView3;
        this.f23268o = textView4;
        this.f23269p = textView5;
        this.f23270q = textView6;
        this.f23271r = textView7;
        this.f23272s = textView8;
        this.f23273t = textView9;
        this.f23274u = textView10;
        this.f23275v = textView11;
        this.f23276w = textView12;
        this.f23277x = textView13;
        this.f23278y = textView14;
    }

    public static j1 a(View view) {
        View view2 = view;
        int i5 = R.id.iv_edit_device_name_user_device_details;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_edit_device_name_user_device_details);
        if (imageView != null) {
            i5 = R.id.iv_filters_user_apps_details;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_filters_user_apps_details);
            if (imageView2 != null) {
                i5 = R.id.iv_uptodown_protect_value_user_device_details;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_uptodown_protect_value_user_device_details);
                if (imageView3 != null) {
                    i5 = R.id.ll_device_details;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_device_details);
                    if (linearLayout != null) {
                        i5 = R.id.loading_view_user_device_details;
                        View findChildViewById = ViewBindings.findChildViewById(view2, R.id.loading_view_user_device_details);
                        if (findChildViewById != null) {
                            i5 = R.id.rb_installed_apps_user_device_details;
                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view2, R.id.rb_installed_apps_user_device_details);
                            if (radioButton != null) {
                                i5 = R.id.rb_not_installed_apps_user_device_details;
                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view2, R.id.rb_not_installed_apps_user_device_details);
                                if (radioButton2 != null) {
                                    i5 = R.id.rg_filter_apps_user_device_details;
                                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view2, R.id.rg_filter_apps_user_device_details);
                                    if (radioGroup != null) {
                                        i5 = R.id.rv_user_apps_device_details;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.rv_user_apps_device_details);
                                        if (recyclerView != null) {
                                            i5 = R.id.toolbar_user_device_details;
                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar_user_device_details);
                                            if (toolbar != null) {
                                                i5 = R.id.tv_brand_label_user_device_details;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_brand_label_user_device_details);
                                                if (textView != null) {
                                                    i5 = R.id.tv_brand_value_user_device_details;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_brand_value_user_device_details);
                                                    if (textView2 != null) {
                                                        i5 = R.id.tv_device_apps_user_device_details;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_device_apps_user_device_details);
                                                        if (textView3 != null) {
                                                            i5 = R.id.tv_device_name_user_device_details;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_device_name_user_device_details);
                                                            if (textView4 != null) {
                                                                i5 = R.id.tv_last_time_used_label_user_device_details;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_last_time_used_label_user_device_details);
                                                                if (textView5 != null) {
                                                                    i5 = R.id.tv_last_time_used_value_user_device_details;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_last_time_used_value_user_device_details);
                                                                    if (textView6 != null) {
                                                                        i5 = R.id.tv_model_label_user_device_details;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_model_label_user_device_details);
                                                                        if (textView7 != null) {
                                                                            i5 = R.id.tv_model_value_user_device_details;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_model_value_user_device_details);
                                                                            if (textView8 != null) {
                                                                                i5 = R.id.tv_no_items_device_details;
                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_no_items_device_details);
                                                                                if (textView9 != null) {
                                                                                    i5 = R.id.tv_platform_label_user_device_details;
                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_platform_label_user_device_details);
                                                                                    if (textView10 != null) {
                                                                                        i5 = R.id.tv_platform_value_user_device_details;
                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_platform_value_user_device_details);
                                                                                        if (textView11 != null) {
                                                                                            i5 = R.id.tv_unlink_device_user_device_details;
                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_unlink_device_user_device_details);
                                                                                            if (textView12 != null) {
                                                                                                i5 = R.id.tv_uptodown_protect_label_user_device_details;
                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_uptodown_protect_label_user_device_details);
                                                                                                if (textView13 != null) {
                                                                                                    i5 = R.id.tv_user_device_details;
                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_user_device_details);
                                                                                                    if (textView14 != null) {
                                                                                                        return new j1((RelativeLayout) view2, imageView, imageView2, imageView3, linearLayout, findChildViewById, radioButton, radioButton2, radioGroup, recyclerView, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14);
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

    public static j1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static j1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.user_device_details_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23254a;
    }
}
