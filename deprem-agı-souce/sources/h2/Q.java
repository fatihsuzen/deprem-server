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

public final class Q implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22606a;

    /* renamed from: b  reason: collision with root package name */
    public final v1 f22607b;

    /* renamed from: c  reason: collision with root package name */
    public final View f22608c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f22609d;

    /* renamed from: e  reason: collision with root package name */
    public final Toolbar f22610e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f22611f;

    private Q(RelativeLayout relativeLayout, v1 v1Var, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView) {
        this.f22606a = relativeLayout;
        this.f22607b = v1Var;
        this.f22608c = view;
        this.f22609d = recyclerView;
        this.f22610e = toolbar;
        this.f22611f = textView;
    }

    public static Q a(View view) {
        int i5 = R.id.header_fus;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.header_fus);
        if (findChildViewById != null) {
            v1 a5 = v1.a(findChildViewById);
            i5 = R.id.loading_view_fus;
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.loading_view_fus);
            if (findChildViewById2 != null) {
                i5 = R.id.rv_fus;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_fus);
                if (recyclerView != null) {
                    i5 = R.id.toolbar_fus;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_fus);
                    if (toolbar != null) {
                        i5 = R.id.tv_toolbar_title_fus;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_title_fus);
                        if (textView != null) {
                            return new Q((RelativeLayout) view, a5, findChildViewById2, recyclerView, toolbar, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static Q c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static Q d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.free_up_space_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22606a;
    }
}
