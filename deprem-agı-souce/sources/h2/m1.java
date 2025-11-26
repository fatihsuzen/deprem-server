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

public final class m1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23367a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f23368b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f23369c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f23370d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f23371e;

    /* renamed from: f  reason: collision with root package name */
    public final Toolbar f23372f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f23373g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f23374h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f23375i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f23376j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f23377k;

    /* renamed from: l  reason: collision with root package name */
    public final View f23378l;

    private m1(RelativeLayout relativeLayout, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view) {
        this.f23367a = relativeLayout;
        this.f23368b = linearLayout;
        this.f23369c = linearLayout2;
        this.f23370d = linearLayout3;
        this.f23371e = linearLayout4;
        this.f23372f = toolbar;
        this.f23373g = textView;
        this.f23374h = textView2;
        this.f23375i = textView3;
        this.f23376j = textView4;
        this.f23377k = textView5;
        this.f23378l = view;
    }

    public static m1 a(View view) {
        int i5 = R.id.ll_avatar_uep;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_avatar_uep);
        if (linearLayout != null) {
            i5 = R.id.ll_logout_uep;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_logout_uep);
            if (linearLayout2 != null) {
                i5 = R.id.ll_password_uep;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_password_uep);
                if (linearLayout3 != null) {
                    i5 = R.id.ll_username_uep;
                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_username_uep);
                    if (linearLayout4 != null) {
                        i5 = R.id.toolbar_uep;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_uep);
                        if (toolbar != null) {
                            i5 = R.id.tv_avatar_uep;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_avatar_uep);
                            if (textView != null) {
                                i5 = R.id.tv_logout_uep;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_logout_uep);
                                if (textView2 != null) {
                                    i5 = R.id.tv_password_uep;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_password_uep);
                                    if (textView3 != null) {
                                        i5 = R.id.tv_title_uep;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_uep);
                                        if (textView4 != null) {
                                            i5 = R.id.tv_username_uep;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_username_uep);
                                            if (textView5 != null) {
                                                i5 = R.id.v_divider_uep;
                                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.v_divider_uep);
                                                if (findChildViewById != null) {
                                                    return new m1((RelativeLayout) view, linearLayout, linearLayout2, linearLayout3, linearLayout4, toolbar, textView, textView2, textView3, textView4, textView5, findChildViewById);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static m1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static m1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.user_edit_profile, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23367a;
    }
}
