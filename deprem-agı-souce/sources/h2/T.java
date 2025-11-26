package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.uptodown.R;

public final class T implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22636a;

    /* renamed from: b  reason: collision with root package name */
    public final SubsamplingScaleImageView f22637b;

    /* renamed from: c  reason: collision with root package name */
    public final ProgressBar f22638c;

    private T(RelativeLayout relativeLayout, SubsamplingScaleImageView subsamplingScaleImageView, ProgressBar progressBar) {
        this.f22636a = relativeLayout;
        this.f22637b = subsamplingScaleImageView;
        this.f22638c = progressBar;
    }

    public static T a(View view) {
        int i5 = R.id.iv_imagen;
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) ViewBindings.findChildViewById(view, R.id.iv_imagen);
        if (subsamplingScaleImageView != null) {
            i5 = R.id.pb_gallery_item;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.pb_gallery_item);
            if (progressBar != null) {
                return new T((RelativeLayout) view, subsamplingScaleImageView, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static T c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.gallery_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22636a;
    }
}
