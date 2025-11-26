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

/* renamed from: h2.y0  reason: case insensitive filesystem */
public final class C2449y0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23679a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23680b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f23681c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23682d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23683e;

    private C2449y0(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, TextView textView, TextView textView2) {
        this.f23679a = relativeLayout;
        this.f23680b = imageView;
        this.f23681c = relativeLayout2;
        this.f23682d = textView;
        this.f23683e = textView2;
    }

    public static C2449y0 a(View view) {
        int i5 = R.id.iv_preference_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_preference_item);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i5 = R.id.tv_preference_item_description;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_preference_item_description);
            if (textView != null) {
                i5 = R.id.tv_preference_item_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_preference_item_title);
                if (textView2 != null) {
                    return new C2449y0(relativeLayout, imageView, relativeLayout, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2449y0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2449y0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.preference_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23679a;
    }
}
