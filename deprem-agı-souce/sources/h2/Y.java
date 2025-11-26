package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class Y implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f22710a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22711b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f22712c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f22713d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f22714e;

    private Y(LinearLayout linearLayout, ImageView imageView, RelativeLayout relativeLayout, RecyclerView recyclerView, TextView textView) {
        this.f22710a = linearLayout;
        this.f22711b = imageView;
        this.f22712c = relativeLayout;
        this.f22713d = recyclerView;
        this.f22714e = textView;
    }

    public static Y a(View view) {
        int i5 = R.id.iv_more_home_recycler_view_top;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_more_home_recycler_view_top);
        if (imageView != null) {
            i5 = R.id.rl_title_home_recycler_view_top;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_title_home_recycler_view_top);
            if (relativeLayout != null) {
                i5 = R.id.rv_home_recycler_view_top;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_home_recycler_view_top);
                if (recyclerView != null) {
                    i5 = R.id.tv_title_home_recycler_view_top;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_home_recycler_view_top);
                    if (textView != null) {
                        return new Y((LinearLayout) view, imageView, relativeLayout, recyclerView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static Y c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static Y d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.home_recycler_view_top, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f22710a;
    }
}
