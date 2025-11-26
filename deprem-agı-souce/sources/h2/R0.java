package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class R0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22620a;

    /* renamed from: b  reason: collision with root package name */
    public final S0 f22621b;

    /* renamed from: c  reason: collision with root package name */
    public final View f22622c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f22623d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f22624e;

    private R0(RelativeLayout relativeLayout, S0 s02, View view, RecyclerView recyclerView, TextView textView) {
        this.f22620a = relativeLayout;
        this.f22621b = s02;
        this.f22622c = view;
        this.f22623d = recyclerView;
        this.f22624e = textView;
    }

    public static R0 a(View view) {
        int i5 = R.id.include_search_bar;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.include_search_bar);
        if (findChildViewById != null) {
            S0 a5 = S0.a(findChildViewById);
            i5 = R.id.loading_view_search;
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.loading_view_search);
            if (findChildViewById2 != null) {
                i5 = R.id.rv_search_activity;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_search_activity);
                if (recyclerView != null) {
                    i5 = R.id.tv_msg_search_activity;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_msg_search_activity);
                    if (textView != null) {
                        return new R0((RelativeLayout) view, a5, findChildViewById2, recyclerView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static R0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static R0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.search_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22620a;
    }
}
