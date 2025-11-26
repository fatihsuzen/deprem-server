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

/* renamed from: h2.D  reason: case insensitive filesystem */
public final class C2400D implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22315a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22316b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f22317c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f22318d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f22319e;

    private C2400D(RelativeLayout relativeLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.f22315a = relativeLayout;
        this.f22316b = imageView;
        this.f22317c = textView;
        this.f22318d = textView2;
        this.f22319e = textView3;
    }

    public static C2400D a(View view) {
        int i5 = R.id.iv_close_dialog_turbo_positives_detected;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_close_dialog_turbo_positives_detected);
        if (imageView != null) {
            i5 = R.id.tv_action_dialog_turbo_positives_detected;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_action_dialog_turbo_positives_detected);
            if (textView != null) {
                i5 = R.id.tv_description_dialog_turbo_positives_detected;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_description_dialog_turbo_positives_detected);
                if (textView2 != null) {
                    i5 = R.id.tv_title_dialog_turbo_positives_detected;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_dialog_turbo_positives_detected);
                    if (textView3 != null) {
                        return new C2400D((RelativeLayout) view, imageView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2400D c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2400D d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_turbo_positives_detected, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22315a;
    }
}
