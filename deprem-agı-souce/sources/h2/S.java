package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.uptodown.R;

public final class S implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22625a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22626b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f22627c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f22628d;

    /* renamed from: e  reason: collision with root package name */
    public final ViewPager f22629e;

    private S(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, TextView textView, ViewPager viewPager) {
        this.f22625a = relativeLayout;
        this.f22626b = imageView;
        this.f22627c = relativeLayout2;
        this.f22628d = textView;
        this.f22629e = viewPager;
    }

    public static S a(View view) {
        int i5 = R.id.iv_back_gallery;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_back_gallery);
        if (imageView != null) {
            i5 = R.id.toolbar_gallery;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.toolbar_gallery);
            if (relativeLayout != null) {
                i5 = R.id.tv_item_count_gallery;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_item_count_gallery);
                if (textView != null) {
                    i5 = R.id.vp_gallery;
                    ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, R.id.vp_gallery);
                    if (viewPager != null) {
                        return new S((RelativeLayout) view, imageView, relativeLayout, textView, viewPager);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static S c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static S d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.gallery, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22625a;
    }
}
