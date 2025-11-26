package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class e1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22969a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22970b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f22971c;

    /* renamed from: d  reason: collision with root package name */
    public final View f22972d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f22973e;

    /* renamed from: f  reason: collision with root package name */
    public final RecyclerView f22974f;

    /* renamed from: g  reason: collision with root package name */
    public final Toolbar f22975g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f22976h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f22977i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f22978j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f22979k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f22980l;

    private e1(RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, View view, RecyclerView recyclerView, RecyclerView recyclerView2, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.f22969a = relativeLayout;
        this.f22970b = imageView;
        this.f22971c = linearLayout;
        this.f22972d = view;
        this.f22973e = recyclerView;
        this.f22974f = recyclerView2;
        this.f22975g = toolbar;
        this.f22976h = textView;
        this.f22977i = textView2;
        this.f22978j = textView3;
        this.f22979k = textView4;
        this.f22980l = textView5;
    }

    public static e1 a(View view) {
        int i5 = R.id.iv_turbo_avatar_title_avatar_activity;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_turbo_avatar_title_avatar_activity);
        if (imageView != null) {
            i5 = R.id.ll_turbo_separator_avatar_activity;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_turbo_separator_avatar_activity);
            if (linearLayout != null) {
                i5 = R.id.loading_view_avatar;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_avatar);
                if (findChildViewById != null) {
                    i5 = R.id.rv_avatar_activity;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_avatar_activity);
                    if (recyclerView != null) {
                        i5 = R.id.rv_turbo_avatar_activity;
                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_turbo_avatar_activity);
                        if (recyclerView2 != null) {
                            i5 = R.id.toolbar_avatar_activity;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_avatar_activity);
                            if (toolbar != null) {
                                i5 = R.id.tv_avatars_title_avatar_activity;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_avatars_title_avatar_activity);
                                if (textView != null) {
                                    i5 = R.id.tv_save_avatar_activity;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_save_avatar_activity);
                                    if (textView2 != null) {
                                        i5 = R.id.tv_title_avatar_activity;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_avatar_activity);
                                        if (textView3 != null) {
                                            i5 = R.id.tv_toolbar_title_avatar_activity;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_title_avatar_activity);
                                            if (textView4 != null) {
                                                i5 = R.id.tv_turbo_avatar_title_avatar_activity;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_turbo_avatar_title_avatar_activity);
                                                if (textView5 != null) {
                                                    return new e1((RelativeLayout) view, imageView, linearLayout, findChildViewById, recyclerView, recyclerView2, toolbar, textView, textView2, textView3, textView4, textView5);
                                                }
                                            }
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

    public static e1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static e1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.user_avatar_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22969a;
    }
}
