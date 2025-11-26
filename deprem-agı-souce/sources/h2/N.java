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
import com.uptodown.util.views.UsernameTextView;

public final class N implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22519a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22520b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f22521c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f22522d;

    /* renamed from: e  reason: collision with root package name */
    public final RelativeLayout f22523e;

    /* renamed from: f  reason: collision with root package name */
    public final RelativeLayout f22524f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f22525g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f22526h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f22527i;

    /* renamed from: j  reason: collision with root package name */
    public final UsernameTextView f22528j;

    private N(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView, TextView textView2, TextView textView3, UsernameTextView usernameTextView) {
        this.f22519a = relativeLayout;
        this.f22520b = imageView;
        this.f22521c = imageView2;
        this.f22522d = imageView3;
        this.f22523e = relativeLayout2;
        this.f22524f = relativeLayout3;
        this.f22525g = textView;
        this.f22526h = textView2;
        this.f22527i = textView3;
        this.f22528j = usernameTextView;
    }

    public static N a(View view) {
        int i5 = R.id.iv_avatar_feed_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_avatar_feed_item);
        if (imageView != null) {
            i5 = R.id.iv_turbo_mark_feed_item;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_turbo_mark_feed_item);
            if (imageView2 != null) {
                i5 = R.id.iv_type_feed_item;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_type_feed_item);
                if (imageView3 != null) {
                    i5 = R.id.rl_avatar_feed_item;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_avatar_feed_item);
                    if (relativeLayout != null) {
                        i5 = R.id.rl_feed_item;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_feed_item);
                        if (relativeLayout2 != null) {
                            i5 = R.id.tv_action_feed_item;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_action_feed_item);
                            if (textView != null) {
                                i5 = R.id.tv_subscription_feed_item;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subscription_feed_item);
                                if (textView2 != null) {
                                    i5 = R.id.tv_timeago_feed_item;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_timeago_feed_item);
                                    if (textView3 != null) {
                                        i5 = R.id.tv_username_feed_item;
                                        UsernameTextView usernameTextView = (UsernameTextView) ViewBindings.findChildViewById(view, R.id.tv_username_feed_item);
                                        if (usernameTextView != null) {
                                            return new N((RelativeLayout) view, imageView, imageView2, imageView3, relativeLayout, relativeLayout2, textView, textView2, textView3, usernameTextView);
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

    public static N c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.feed_subscription_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22519a;
    }
}
