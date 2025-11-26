package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class a1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f22750a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f22751b;

    private a1(LinearLayout linearLayout, RecyclerView recyclerView) {
        this.f22750a = linearLayout;
        this.f22751b = recyclerView;
    }

    public static a1 a(View view) {
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recycler_view);
        if (recyclerView != null) {
            return new a1((LinearLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.recycler_view)));
    }

    public static a1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.uptodown_dropdown_menu, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f22750a;
    }
}
