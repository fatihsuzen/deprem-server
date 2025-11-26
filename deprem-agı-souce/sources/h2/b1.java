package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.util.views.CropImageView;

public final class b1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22841a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22842b;

    /* renamed from: c  reason: collision with root package name */
    public final CropImageView f22843c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f22844d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f22845e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f22846f;

    private b1(RelativeLayout relativeLayout, ImageView imageView, CropImageView cropImageView, TextView textView, TextView textView2, TextView textView3) {
        this.f22841a = relativeLayout;
        this.f22842b = imageView;
        this.f22843c = cropImageView;
        this.f22844d = textView;
        this.f22845e = textView2;
        this.f22846f = textView3;
    }

    public static b1 a(View view) {
        int i5 = R.id.iv_close_turbo_popup;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_close_turbo_popup);
        if (imageView != null) {
            i5 = R.id.iv_turbo_popup_bg;
            CropImageView cropImageView = (CropImageView) ViewBindings.findChildViewById(view, R.id.iv_turbo_popup_bg);
            if (cropImageView != null) {
                i5 = R.id.tv_line2_turbo_popup;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_line2_turbo_popup);
                if (textView != null) {
                    i5 = R.id.tv_turbo_popup;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_turbo_popup);
                    if (textView2 != null) {
                        i5 = R.id.tv_uptodown_turbo_popup;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_uptodown_turbo_popup);
                        if (textView3 != null) {
                            return new b1((RelativeLayout) view, imageView, cropImageView, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static b1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static b1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.uptodown_turbo_popup, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22841a;
    }
}
