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

/* renamed from: h2.o0  reason: case insensitive filesystem */
public final class C2430o0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23414a;

    /* renamed from: b  reason: collision with root package name */
    public final View f23415b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f23416c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f23417d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23418e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23419f;

    private C2430o0(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f23414a = relativeLayout;
        this.f23415b = view;
        this.f23416c = recyclerView;
        this.f23417d = toolbar;
        this.f23418e = textView;
        this.f23419f = textView2;
    }

    public static C2430o0 a(View view) {
        int i5 = R.id.loading_view_old_versions;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_old_versions);
        if (findChildViewById != null) {
            i5 = R.id.rv_old_versions;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_old_versions);
            if (recyclerView != null) {
                i5 = R.id.toolbar_old_versions;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_old_versions);
                if (toolbar != null) {
                    i5 = R.id.tv_no_data_old_version;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_data_old_version);
                    if (textView != null) {
                        i5 = R.id.tv_toolbar_old_versions;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_old_versions);
                        if (textView2 != null) {
                            return new C2430o0((RelativeLayout) view, findChildViewById, recyclerView, toolbar, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2430o0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2430o0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.old_versions_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23414a;
    }
}
