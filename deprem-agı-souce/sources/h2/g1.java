package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class g1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23085a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23086b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f23087c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f23088d;

    /* renamed from: e  reason: collision with root package name */
    public final RelativeLayout f23089e;

    private g1(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout2) {
        this.f23085a = relativeLayout;
        this.f23086b = imageView;
        this.f23087c = imageView2;
        this.f23088d = imageView3;
        this.f23089e = relativeLayout2;
    }

    public static g1 a(View view) {
        int i5 = R.id.iv_avatar_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_avatar_item);
        if (imageView != null) {
            i5 = R.id.iv_checked_user_avatar;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_checked_user_avatar);
            if (imageView2 != null) {
                i5 = R.id.iv_locked_item;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_locked_item);
                if (imageView3 != null) {
                    i5 = R.id.rl_shadow_avatar_item;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_shadow_avatar_item);
                    if (relativeLayout != null) {
                        return new g1((RelativeLayout) view, imageView, imageView2, imageView3, relativeLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static g1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.user_avatar_turbo, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23085a;
    }
}
