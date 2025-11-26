package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class J implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22421a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22422b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f22423c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f22424d;

    /* renamed from: e  reason: collision with root package name */
    public final View f22425e;

    /* renamed from: f  reason: collision with root package name */
    public final RelativeLayout f22426f;

    /* renamed from: g  reason: collision with root package name */
    public final RecyclerView f22427g;

    /* renamed from: h  reason: collision with root package name */
    public final SwipeRefreshLayout f22428h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f22429i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f22430j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f22431k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f22432l;

    private J(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, View view, RelativeLayout relativeLayout2, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f22421a = relativeLayout;
        this.f22422b = imageView;
        this.f22423c = imageView2;
        this.f22424d = linearLayout;
        this.f22425e = view;
        this.f22426f = relativeLayout2;
        this.f22427g = recyclerView;
        this.f22428h = swipeRefreshLayout;
        this.f22429i = textView;
        this.f22430j = textView2;
        this.f22431k = textView3;
        this.f22432l = textView4;
    }

    public static J a(View view) {
        int i5 = R.id.iv_avatar_user_ff;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_avatar_user_ff);
        if (imageView != null) {
            i5 = R.id.iv_badge_user_ff;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_badge_user_ff);
            if (imageView2 != null) {
                i5 = R.id.ll_login_ff;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_login_ff);
                if (linearLayout != null) {
                    i5 = R.id.loading_view_feed;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_feed);
                    if (findChildViewById != null) {
                        i5 = R.id.rl_avatar_user_ff;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_avatar_user_ff);
                        if (relativeLayout != null) {
                            i5 = R.id.rv_feed;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_feed);
                            if (recyclerView != null) {
                                i5 = R.id.srl_feed;
                                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view, R.id.srl_feed);
                                if (swipeRefreshLayout != null) {
                                    i5 = R.id.tv_login_email_ff;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_login_email_ff);
                                    if (textView != null) {
                                        i5 = R.id.tv_login_google_ff;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_login_google_ff);
                                        if (textView2 != null) {
                                            i5 = R.id.tv_no_data_feed;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_data_feed);
                                            if (textView3 != null) {
                                                i5 = R.id.tv_title_ff;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_ff);
                                                if (textView4 != null) {
                                                    return new J((RelativeLayout) view, imageView, imageView2, linearLayout, findChildViewById, relativeLayout, recyclerView, swipeRefreshLayout, textView, textView2, textView3, textView4);
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

    public static J c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static J d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.feed_fragment, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22421a;
    }
}
