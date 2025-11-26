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

public final class O implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22546a;

    /* renamed from: b  reason: collision with root package name */
    public final View f22547b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f22548c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f22549d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f22550e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f22551f;

    private O(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f22546a = relativeLayout;
        this.f22547b = view;
        this.f22548c = recyclerView;
        this.f22549d = toolbar;
        this.f22550e = textView;
        this.f22551f = textView2;
    }

    public static O a(View view) {
        int i5 = R.id.loading_view_follow_list;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_follow_list);
        if (findChildViewById != null) {
            i5 = R.id.rv_follow_list;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_follow_list);
            if (recyclerView != null) {
                i5 = R.id.toolbar_follow_list;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_follow_list);
                if (toolbar != null) {
                    i5 = R.id.tv_no_data_follow_list;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_data_follow_list);
                    if (textView != null) {
                        i5 = R.id.tv_toolbar_follow_list;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_follow_list);
                        if (textView2 != null) {
                            return new O((RelativeLayout) view, findChildViewById, recyclerView, toolbar, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static O c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static O d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.follow_list_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22546a;
    }
}
