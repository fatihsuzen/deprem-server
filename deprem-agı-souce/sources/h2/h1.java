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

public final class h1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23204a;

    /* renamed from: b  reason: collision with root package name */
    public final View f23205b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f23206c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f23207d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23208e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23209f;

    private h1(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f23204a = relativeLayout;
        this.f23205b = view;
        this.f23206c = recyclerView;
        this.f23207d = toolbar;
        this.f23208e = textView;
        this.f23209f = textView2;
    }

    public static h1 a(View view) {
        int i5 = R.id.loading_view_user_comments;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_user_comments);
        if (findChildViewById != null) {
            i5 = R.id.rv_user_comments;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_user_comments);
            if (recyclerView != null) {
                i5 = R.id.toolbar_user_comments;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_user_comments);
                if (toolbar != null) {
                    i5 = R.id.tv_error_user_comments;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_error_user_comments);
                    if (textView != null) {
                        i5 = R.id.tv_toolbar_title_user_comments;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_title_user_comments);
                        if (textView2 != null) {
                            return new h1((RelativeLayout) view, findChildViewById, recyclerView, toolbar, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static h1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static h1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.user_comments_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23204a;
    }
}
