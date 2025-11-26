package h2;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class I0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f22413a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22414b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f22415c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f22416d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f22417e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f22418f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f22419g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f22420h;

    private I0(LinearLayout linearLayout, ImageView imageView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3) {
        this.f22413a = linearLayout;
        this.f22414b = imageView;
        this.f22415c = relativeLayout;
        this.f22416d = relativeLayout2;
        this.f22417e = recyclerView;
        this.f22418f = textView;
        this.f22419g = textView2;
        this.f22420h = textView3;
    }

    public static I0 a(View view) {
        int i5 = R.id.iv_more_public_profile_top;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_more_public_profile_top);
        if (imageView != null) {
            i5 = R.id.rl_no_items_public_profile_top;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_no_items_public_profile_top);
            if (relativeLayout != null) {
                i5 = R.id.rl_title_public_profile_top;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_title_public_profile_top);
                if (relativeLayout2 != null) {
                    i5 = R.id.rv_public_profile_top;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_public_profile_top);
                    if (recyclerView != null) {
                        i5 = R.id.tv_explore_public_profile_top;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_explore_public_profile_top);
                        if (textView != null) {
                            i5 = R.id.tv_no_items_public_profile_top;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_items_public_profile_top);
                            if (textView2 != null) {
                                i5 = R.id.tv_title_public_profile_top;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_public_profile_top);
                                if (textView3 != null) {
                                    return new I0((LinearLayout) view, imageView, relativeLayout, relativeLayout2, recyclerView, textView, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f22413a;
    }
}
