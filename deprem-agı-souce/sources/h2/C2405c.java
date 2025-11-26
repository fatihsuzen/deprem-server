package h2;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.views.FullWidthImageView;

/* renamed from: h2.c  reason: case insensitive filesystem */
public final class C2405c implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22847a;

    /* renamed from: b  reason: collision with root package name */
    public final FullWidthImageView f22848b;

    private C2405c(RelativeLayout relativeLayout, FullWidthImageView fullWidthImageView) {
        this.f22847a = relativeLayout;
        this.f22848b = fullWidthImageView;
    }

    public static C2405c a(View view) {
        FullWidthImageView fullWidthImageView = (FullWidthImageView) ViewBindings.findChildViewById(view, R.id.iv_feature_app_detail);
        if (fullWidthImageView != null) {
            return new C2405c((RelativeLayout) view, fullWidthImageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.iv_feature_app_detail)));
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22847a;
    }
}
