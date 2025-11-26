package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class J0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22433a;

    /* renamed from: b  reason: collision with root package name */
    public final View f22434b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f22435c;

    /* renamed from: d  reason: collision with root package name */
    public final SwitchCompat f22436d;

    /* renamed from: e  reason: collision with root package name */
    public final Toolbar f22437e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f22438f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f22439g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f22440h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f22441i;

    private J0(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, SwitchCompat switchCompat, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f22433a = relativeLayout;
        this.f22434b = view;
        this.f22435c = recyclerView;
        this.f22436d = switchCompat;
        this.f22437e = toolbar;
        this.f22438f = textView;
        this.f22439g = textView2;
        this.f22440h = textView3;
        this.f22441i = textView4;
    }

    public static J0 a(View view) {
        int i5 = R.id.loading_view_recommended;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_recommended);
        if (findChildViewById != null) {
            i5 = R.id.rv_recommended;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_recommended);
            if (recyclerView != null) {
                i5 = R.id.s_list_state_recommended;
                SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, R.id.s_list_state_recommended);
                if (switchCompat != null) {
                    i5 = R.id.toolbar_recommended;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_recommended);
                    if (toolbar != null) {
                        i5 = R.id.tv_explore_recommended;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_explore_recommended);
                        if (textView != null) {
                            i5 = R.id.tv_list_state_recommended;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_list_state_recommended);
                            if (textView2 != null) {
                                i5 = R.id.tv_no_items_recommended;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_items_recommended);
                                if (textView3 != null) {
                                    i5 = R.id.tv_title_recommended;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_recommended);
                                    if (textView4 != null) {
                                        return new J0((RelativeLayout) view, findChildViewById, recyclerView, switchCompat, toolbar, textView, textView2, textView3, textView4);
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

    public static J0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static J0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.recommended_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22433a;
    }
}
