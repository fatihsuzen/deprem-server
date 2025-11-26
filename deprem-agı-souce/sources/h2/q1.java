package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.util.views.UsernameTextView;

public final class q1 implements ViewBinding {

    /* renamed from: A  reason: collision with root package name */
    public final UsernameTextView f23457A;

    /* renamed from: B  reason: collision with root package name */
    public final UsernameTextView f23458B;

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23459a;

    /* renamed from: b  reason: collision with root package name */
    public final EditText f23460b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f23461c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f23462d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f23463e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f23464f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f23465g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f23466h;

    /* renamed from: i  reason: collision with root package name */
    public final LinearLayout f23467i;

    /* renamed from: j  reason: collision with root package name */
    public final LinearLayout f23468j;

    /* renamed from: k  reason: collision with root package name */
    public final LinearLayout f23469k;

    /* renamed from: l  reason: collision with root package name */
    public final View f23470l;

    /* renamed from: m  reason: collision with root package name */
    public final RadioButton f23471m;

    /* renamed from: n  reason: collision with root package name */
    public final RadioButton f23472n;

    /* renamed from: o  reason: collision with root package name */
    public final RadioButton f23473o;

    /* renamed from: p  reason: collision with root package name */
    public final RadioButton f23474p;

    /* renamed from: q  reason: collision with root package name */
    public final Toolbar f23475q;

    /* renamed from: r  reason: collision with root package name */
    public final TextView f23476r;

    /* renamed from: s  reason: collision with root package name */
    public final TextView f23477s;

    /* renamed from: t  reason: collision with root package name */
    public final TextView f23478t;

    /* renamed from: u  reason: collision with root package name */
    public final TextView f23479u;

    /* renamed from: v  reason: collision with root package name */
    public final TextView f23480v;

    /* renamed from: w  reason: collision with root package name */
    public final TextView f23481w;

    /* renamed from: x  reason: collision with root package name */
    public final TextView f23482x;

    /* renamed from: y  reason: collision with root package name */
    public final UsernameTextView f23483y;

    /* renamed from: z  reason: collision with root package name */
    public final UsernameTextView f23484z;

    private q1(RelativeLayout relativeLayout, EditText editText, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, View view, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, UsernameTextView usernameTextView, UsernameTextView usernameTextView2, UsernameTextView usernameTextView3, UsernameTextView usernameTextView4) {
        this.f23459a = relativeLayout;
        this.f23460b = editText;
        this.f23461c = imageView;
        this.f23462d = imageView2;
        this.f23463e = imageView3;
        this.f23464f = imageView4;
        this.f23465g = linearLayout;
        this.f23466h = linearLayout2;
        this.f23467i = linearLayout3;
        this.f23468j = linearLayout4;
        this.f23469k = linearLayout5;
        this.f23470l = view;
        this.f23471m = radioButton;
        this.f23472n = radioButton2;
        this.f23473o = radioButton3;
        this.f23474p = radioButton4;
        this.f23475q = toolbar;
        this.f23476r = textView;
        this.f23477s = textView2;
        this.f23478t = textView3;
        this.f23479u = textView4;
        this.f23480v = textView5;
        this.f23481w = textView6;
        this.f23482x = textView7;
        this.f23483y = usernameTextView;
        this.f23484z = usernameTextView2;
        this.f23457A = usernameTextView3;
        this.f23458B = usernameTextView4;
    }

    public static q1 a(View view) {
        View view2 = view;
        int i5 = R.id.et_username_edit;
        EditText editText = (EditText) ViewBindings.findChildViewById(view2, R.id.et_username_edit);
        if (editText != null) {
            i5 = R.id.iv_lock_username_type_1;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_lock_username_type_1);
            if (imageView != null) {
                i5 = R.id.iv_lock_username_type_2;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_lock_username_type_2);
                if (imageView2 != null) {
                    i5 = R.id.iv_lock_username_type_3;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_lock_username_type_3);
                    if (imageView3 != null) {
                        i5 = R.id.iv_turbo_avatar_title_user_edit;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_turbo_avatar_title_user_edit);
                        if (imageView4 != null) {
                            i5 = R.id.ll_turbo_separator_user_edit;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_turbo_separator_user_edit);
                            if (linearLayout != null) {
                                i5 = R.id.ll_turbo_type_1;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_turbo_type_1);
                                if (linearLayout2 != null) {
                                    i5 = R.id.ll_turbo_type_2;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_turbo_type_2);
                                    if (linearLayout3 != null) {
                                        i5 = R.id.ll_turbo_type_3;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_turbo_type_3);
                                        if (linearLayout4 != null) {
                                            i5 = R.id.ll_turbo_username_type_user_edit;
                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_turbo_username_type_user_edit);
                                            if (linearLayout5 != null) {
                                                i5 = R.id.loading_view_username_edit;
                                                View findChildViewById = ViewBindings.findChildViewById(view2, R.id.loading_view_username_edit);
                                                if (findChildViewById != null) {
                                                    i5 = R.id.rb_turbo_type_0;
                                                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view2, R.id.rb_turbo_type_0);
                                                    if (radioButton != null) {
                                                        i5 = R.id.rb_turbo_type_1;
                                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view2, R.id.rb_turbo_type_1);
                                                        if (radioButton2 != null) {
                                                            i5 = R.id.rb_turbo_type_2;
                                                            RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view2, R.id.rb_turbo_type_2);
                                                            if (radioButton3 != null) {
                                                                i5 = R.id.rb_turbo_type_3;
                                                                RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view2, R.id.rb_turbo_type_3);
                                                                if (radioButton4 != null) {
                                                                    i5 = R.id.toolbar_username_edit;
                                                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar_username_edit);
                                                                    if (toolbar != null) {
                                                                        i5 = R.id.tv_max_chars_user_edit;
                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_max_chars_user_edit);
                                                                        if (textView != null) {
                                                                            i5 = R.id.tv_min_chars_user_edit;
                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_min_chars_user_edit);
                                                                            if (textView2 != null) {
                                                                                i5 = R.id.tv_title_toolbar_username_edit;
                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_title_toolbar_username_edit);
                                                                                if (textView3 != null) {
                                                                                    i5 = R.id.tv_turbo_username_styles_locked_user_edit;
                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_turbo_username_styles_locked_user_edit);
                                                                                    if (textView4 != null) {
                                                                                        i5 = R.id.tv_turbo_username_title_user_edit;
                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_turbo_username_title_user_edit);
                                                                                        if (textView5 != null) {
                                                                                            i5 = R.id.tv_type_chars_user_edit;
                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_type_chars_user_edit);
                                                                                            if (textView6 != null) {
                                                                                                i5 = R.id.tv_username_edit_change;
                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_username_edit_change);
                                                                                                if (textView7 != null) {
                                                                                                    i5 = R.id.tv_username_type_0;
                                                                                                    UsernameTextView usernameTextView = (UsernameTextView) ViewBindings.findChildViewById(view2, R.id.tv_username_type_0);
                                                                                                    if (usernameTextView != null) {
                                                                                                        i5 = R.id.tv_username_type_1;
                                                                                                        UsernameTextView usernameTextView2 = (UsernameTextView) ViewBindings.findChildViewById(view2, R.id.tv_username_type_1);
                                                                                                        if (usernameTextView2 != null) {
                                                                                                            i5 = R.id.tv_username_type_2;
                                                                                                            UsernameTextView usernameTextView3 = (UsernameTextView) ViewBindings.findChildViewById(view2, R.id.tv_username_type_2);
                                                                                                            if (usernameTextView3 != null) {
                                                                                                                i5 = R.id.tv_username_type_3;
                                                                                                                UsernameTextView usernameTextView4 = (UsernameTextView) ViewBindings.findChildViewById(view2, R.id.tv_username_type_3);
                                                                                                                if (usernameTextView4 != null) {
                                                                                                                    return new q1((RelativeLayout) view2, editText, imageView, imageView2, imageView3, imageView4, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, findChildViewById, radioButton, radioButton2, radioButton3, radioButton4, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7, usernameTextView, usernameTextView2, usernameTextView3, usernameTextView4);
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

    public static q1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static q1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.username_edit, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23459a;
    }
}
