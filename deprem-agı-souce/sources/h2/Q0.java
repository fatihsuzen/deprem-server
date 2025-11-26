package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class Q0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22612a;

    /* renamed from: b  reason: collision with root package name */
    public final View f22613b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f22614c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f22615d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f22616e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f22617f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f22618g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f22619h;

    private Q0(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f22612a = relativeLayout;
        this.f22613b = view;
        this.f22614c = recyclerView;
        this.f22615d = toolbar;
        this.f22616e = textView;
        this.f22617f = textView2;
        this.f22618g = textView3;
        this.f22619h = textView4;
    }

    public static Q0 a(View view) {
        int i5 = R.id.loading_view_rollback;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_rollback);
        if (findChildViewById != null) {
            i5 = R.id.recyclerview;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recyclerview);
            if (recyclerView != null) {
                i5 = R.id.toolbar_rollback;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_rollback);
                if (toolbar != null) {
                    i5 = R.id.tv_gdpr_button_rollback;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_gdpr_button_rollback);
                    if (textView != null) {
                        i5 = R.id.tv_no_items;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_items);
                        if (textView2 != null) {
                            i5 = R.id.tv_subtitle_rollback;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subtitle_rollback);
                            if (textView3 != null) {
                                i5 = R.id.tv_title_rollback;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_rollback);
                                if (textView4 != null) {
                                    return new Q0((RelativeLayout) view, findChildViewById, recyclerView, toolbar, textView, textView2, textView3, textView4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static Q0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static Q0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.rollback_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22612a;
    }
}
