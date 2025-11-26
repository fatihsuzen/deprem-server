package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class F0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22362a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22363b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f22364c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f22365d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f22366e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f22367f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f22368g;

    private F0(RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.f22362a = relativeLayout;
        this.f22363b = imageView;
        this.f22364c = linearLayout;
        this.f22365d = relativeLayout2;
        this.f22366e = textView;
        this.f22367f = textView2;
        this.f22368g = textView3;
    }

    public static F0 a(View view) {
        int i5 = R.id.iv_icon_upcoming_release_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_icon_upcoming_release_item);
        if (imageView != null) {
            i5 = R.id.ll_upcoming_release;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_upcoming_release);
            if (linearLayout != null) {
                i5 = R.id.rl_container_upcoming_release_item;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_container_upcoming_release_item);
                if (relativeLayout != null) {
                    i5 = R.id.tv_action_upcoming_release_item;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_action_upcoming_release_item);
                    if (textView != null) {
                        i5 = R.id.tv_author_upcoming_release_item;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_author_upcoming_release_item);
                        if (textView2 != null) {
                            i5 = R.id.tv_name_upcoming_release_item;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_name_upcoming_release_item);
                            if (textView3 != null) {
                                return new F0((RelativeLayout) view, imageView, linearLayout, relativeLayout, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static F0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.preregistration_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22362a;
    }
}
