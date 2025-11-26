package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.e  reason: case insensitive filesystem */
public final class C2409e implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22951a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22952b;

    /* renamed from: c  reason: collision with root package name */
    public final View f22953c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f22954d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f22955e;

    /* renamed from: f  reason: collision with root package name */
    public final Toolbar f22956f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f22957g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f22958h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f22959i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f22960j;

    private C2409e(RelativeLayout relativeLayout, ImageView imageView, View view, RelativeLayout relativeLayout2, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f22951a = relativeLayout;
        this.f22952b = imageView;
        this.f22953c = view;
        this.f22954d = relativeLayout2;
        this.f22955e = recyclerView;
        this.f22956f = toolbar;
        this.f22957g = textView;
        this.f22958h = textView2;
        this.f22959i = textView3;
        this.f22960j = textView4;
    }

    public static C2409e a(View view) {
        int i5 = R.id.iv_logo_afa;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_logo_afa);
        if (imageView != null) {
            i5 = R.id.loading_view_app_files;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_app_files);
            if (findChildViewById != null) {
                i5 = R.id.rl_header_afa;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_header_afa);
                if (relativeLayout != null) {
                    i5 = R.id.rv_app_files;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_app_files);
                    if (recyclerView != null) {
                        i5 = R.id.toolbar_afa;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_afa);
                        if (toolbar != null) {
                            i5 = R.id.tv_app_name_afa;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_app_name_afa);
                            if (textView != null) {
                                i5 = R.id.tv_date_afa;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_date_afa);
                                if (textView2 != null) {
                                    i5 = R.id.tv_no_data_afa;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_data_afa);
                                    if (textView3 != null) {
                                        i5 = R.id.tv_toolbar_title_afa;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_title_afa);
                                        if (textView4 != null) {
                                            return new C2409e((RelativeLayout) view, imageView, findChildViewById, relativeLayout, recyclerView, toolbar, textView, textView2, textView3, textView4);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2409e c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2409e d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.app_files_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22951a;
    }
}
