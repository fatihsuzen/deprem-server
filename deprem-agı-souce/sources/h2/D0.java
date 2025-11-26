package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class D0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f22320a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22321b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f22322c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f22323d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f22324e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f22325f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f22326g;

    private D0(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6) {
        this.f22320a = linearLayout;
        this.f22321b = imageView;
        this.f22322c = imageView2;
        this.f22323d = imageView3;
        this.f22324e = imageView4;
        this.f22325f = imageView5;
        this.f22326g = imageView6;
    }

    public static D0 a(View view) {
        int i5 = R.id.iv_facebook_preferences;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_facebook_preferences);
        if (imageView != null) {
            i5 = R.id.iv_instagram_preferences;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_instagram_preferences);
            if (imageView2 != null) {
                i5 = R.id.iv_linkedin_preferences;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_linkedin_preferences);
                if (imageView3 != null) {
                    i5 = R.id.iv_tiktok_preferences;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_tiktok_preferences);
                    if (imageView4 != null) {
                        i5 = R.id.iv_x_preferences;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_x_preferences);
                        if (imageView5 != null) {
                            i5 = R.id.iv_youtube_preferences;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_youtube_preferences);
                            if (imageView6 != null) {
                                return new D0((LinearLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static D0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static D0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.preferences_socials, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f22320a;
    }
}
