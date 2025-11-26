package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class X0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22702a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22703b;

    /* renamed from: c  reason: collision with root package name */
    public final View f22704c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f22705d;

    /* renamed from: e  reason: collision with root package name */
    public final Toolbar f22706e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f22707f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f22708g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f22709h;

    private X0(RelativeLayout relativeLayout, ImageView imageView, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3) {
        this.f22702a = relativeLayout;
        this.f22703b = imageView;
        this.f22704c = view;
        this.f22705d = recyclerView;
        this.f22706e = toolbar;
        this.f22707f = textView;
        this.f22708g = textView2;
        this.f22709h = textView3;
    }

    public static X0 a(View view) {
        int i5 = R.id.iv_fav_top_by_cat;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_fav_top_by_cat);
        if (imageView != null) {
            i5 = R.id.loading_view_top_by_cat_fragment;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_top_by_cat_fragment);
            if (findChildViewById != null) {
                i5 = R.id.recyclerview_top_cat;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recyclerview_top_cat);
                if (recyclerView != null) {
                    i5 = R.id.toolbar_top_by_cat;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_top_by_cat);
                    if (toolbar != null) {
                        i5 = R.id.tv_no_data_top_cat;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_data_top_cat);
                        if (textView != null) {
                            i5 = R.id.tv_reload_top_by_category_fragment;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_reload_top_by_category_fragment);
                            if (textView2 != null) {
                                i5 = R.id.tv_toolbar_title_top_by_cat;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_title_top_by_cat);
                                if (textView3 != null) {
                                    return new X0((RelativeLayout) view, imageView, findChildViewById, recyclerView, toolbar, textView, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static X0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static X0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.top_by_category_fragment, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22702a;
    }
}
