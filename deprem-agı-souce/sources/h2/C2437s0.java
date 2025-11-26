package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.s0  reason: case insensitive filesystem */
public final class C2437s0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f23530a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f23531b;

    private C2437s0(LinearLayout linearLayout, RecyclerView recyclerView) {
        this.f23530a = linearLayout;
        this.f23531b = recyclerView;
    }

    public static C2437s0 a(View view) {
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_top_downloads_organization);
        if (recyclerView != null) {
            return new C2437s0((LinearLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.rv_top_downloads_organization)));
    }

    public static C2437s0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.organization_top_download_rv, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f23530a;
    }
}
