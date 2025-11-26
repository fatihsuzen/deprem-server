package h2;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.views.InstantAutoCompleteTextView;

public final class S0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22630a;

    /* renamed from: b  reason: collision with root package name */
    public final InstantAutoCompleteTextView f22631b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f22632c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f22633d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f22634e;

    /* renamed from: f  reason: collision with root package name */
    public final RelativeLayout f22635f;

    private S0(RelativeLayout relativeLayout, InstantAutoCompleteTextView instantAutoCompleteTextView, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout2) {
        this.f22630a = relativeLayout;
        this.f22631b = instantAutoCompleteTextView;
        this.f22632c = imageView;
        this.f22633d = imageView2;
        this.f22634e = imageView3;
        this.f22635f = relativeLayout2;
    }

    public static S0 a(View view) {
        int i5 = R.id.actv_search_bar;
        InstantAutoCompleteTextView instantAutoCompleteTextView = (InstantAutoCompleteTextView) ViewBindings.findChildViewById(view, R.id.actv_search_bar);
        if (instantAutoCompleteTextView != null) {
            i5 = R.id.iv_back_search_bar;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_back_search_bar);
            if (imageView != null) {
                i5 = R.id.iv_delete_search_bar;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_delete_search_bar);
                if (imageView2 != null) {
                    i5 = R.id.iv_voice_search_bar;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_voice_search_bar);
                    if (imageView3 != null) {
                        i5 = R.id.rl_options_search_bar;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_options_search_bar);
                        if (relativeLayout != null) {
                            return new S0((RelativeLayout) view, instantAutoCompleteTextView, imageView, imageView2, imageView3, relativeLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22630a;
    }
}
