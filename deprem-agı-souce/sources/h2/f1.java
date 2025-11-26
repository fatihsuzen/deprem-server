package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class f1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23064a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23065b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f23066c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f23067d;

    private f1(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout2) {
        this.f23064a = relativeLayout;
        this.f23065b = imageView;
        this.f23066c = imageView2;
        this.f23067d = relativeLayout2;
    }

    public static f1 a(View view) {
        int i5 = R.id.iv_avatar_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_avatar_item);
        if (imageView != null) {
            i5 = R.id.iv_checked_user_avatar;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_checked_user_avatar);
            if (imageView2 != null) {
                i5 = R.id.rl_shadow_avatar_item;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_shadow_avatar_item);
                if (relativeLayout != null) {
                    return new f1((RelativeLayout) view, imageView, imageView2, relativeLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static f1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.user_avatar, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23064a;
    }
}
