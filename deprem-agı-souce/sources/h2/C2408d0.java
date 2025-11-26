package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.d0  reason: case insensitive filesystem */
public final class C2408d0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22897a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f22898b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f22899c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f22900d;

    /* renamed from: e  reason: collision with root package name */
    public final C2410e0 f22901e;

    /* renamed from: f  reason: collision with root package name */
    public final C2410e0 f22902f;

    /* renamed from: g  reason: collision with root package name */
    public final C2410e0 f22903g;

    /* renamed from: h  reason: collision with root package name */
    public final View f22904h;

    /* renamed from: i  reason: collision with root package name */
    public final Toolbar f22905i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f22906j;

    private C2408d0(RelativeLayout relativeLayout, FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, C2410e0 e0Var, C2410e0 e0Var2, C2410e0 e0Var3, View view, Toolbar toolbar, TextView textView) {
        this.f22897a = relativeLayout;
        this.f22898b = frameLayout;
        this.f22899c = linearLayout;
        this.f22900d = linearLayout2;
        this.f22901e = e0Var;
        this.f22902f = e0Var2;
        this.f22903g = e0Var3;
        this.f22904h = view;
        this.f22905i = toolbar;
        this.f22906j = textView;
    }

    public static C2408d0 a(View view) {
        int i5 = R.id.fl_lists;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.fl_lists);
        if (frameLayout != null) {
            i5 = R.id.ll_floating_categories_lists;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_floating_categories_lists);
            if (linearLayout != null) {
                i5 = R.id.ll_lists;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_lists);
                if (linearLayout2 != null) {
                    i5 = R.id.ll_preregistrations_lists;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.ll_preregistrations_lists);
                    if (findChildViewById != null) {
                        C2410e0 a5 = C2410e0.a(findChildViewById);
                        i5 = R.id.ll_recommended_lists;
                        View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.ll_recommended_lists);
                        if (findChildViewById2 != null) {
                            C2410e0 a6 = C2410e0.a(findChildViewById2);
                            i5 = R.id.ll_wishlist_lists;
                            View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.ll_wishlist_lists);
                            if (findChildViewById3 != null) {
                                C2410e0 a7 = C2410e0.a(findChildViewById3);
                                i5 = R.id.loading_view_lists;
                                View findChildViewById4 = ViewBindings.findChildViewById(view, R.id.loading_view_lists);
                                if (findChildViewById4 != null) {
                                    i5 = R.id.toolbar_lists;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_lists);
                                    if (toolbar != null) {
                                        i5 = R.id.tv_title_lists;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_lists);
                                        if (textView != null) {
                                            return new C2408d0((RelativeLayout) view, frameLayout, linearLayout, linearLayout2, a5, a6, a7, findChildViewById4, toolbar, textView);
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

    public static C2408d0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2408d0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.lists_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22897a;
    }
}
