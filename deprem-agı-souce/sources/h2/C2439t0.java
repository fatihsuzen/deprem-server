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

/* renamed from: h2.t0  reason: case insensitive filesystem */
public final class C2439t0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23553a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23554b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f23555c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23556d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23557e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23558f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f23559g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f23560h;

    private C2439t0(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.f23553a = relativeLayout;
        this.f23554b = imageView;
        this.f23555c = relativeLayout2;
        this.f23556d = textView;
        this.f23557e = textView2;
        this.f23558f = textView3;
        this.f23559g = textView4;
        this.f23560h = textView5;
    }

    public static C2439t0 a(View view) {
        int i5 = R.id.iv_top_app_logo_organization;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_top_app_logo_organization);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i5 = R.id.tv_top_app_desc_organization;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_top_app_desc_organization);
            if (textView != null) {
                i5 = R.id.tv_top_app_downloads_counter_organization;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_top_app_downloads_counter_organization);
                if (textView2 != null) {
                    i5 = R.id.tv_top_app_name_organization;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_top_app_name_organization);
                    if (textView3 != null) {
                        i5 = R.id.tv_top_app_status_organization;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_top_app_status_organization);
                        if (textView4 != null) {
                            i5 = R.id.tv_top_app_valoration_organization;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_top_app_valoration_organization);
                            if (textView5 != null) {
                                return new C2439t0(relativeLayout, imageView, relativeLayout, textView, textView2, textView3, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2439t0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.organization_top_item_card, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23553a;
    }
}
