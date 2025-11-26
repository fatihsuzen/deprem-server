package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.util.views.UsernameTextView;

public final class L implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22455a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f22456b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f22457c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f22458d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f22459e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f22460f;

    /* renamed from: g  reason: collision with root package name */
    public final RelativeLayout f22461g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f22462h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f22463i;

    /* renamed from: j  reason: collision with root package name */
    public final UsernameTextView f22464j;

    private L(RelativeLayout relativeLayout, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RelativeLayout relativeLayout2, TextView textView, TextView textView2, UsernameTextView usernameTextView) {
        this.f22455a = relativeLayout;
        this.f22456b = frameLayout;
        this.f22457c = imageView;
        this.f22458d = imageView2;
        this.f22459e = imageView3;
        this.f22460f = imageView4;
        this.f22461g = relativeLayout2;
        this.f22462h = textView;
        this.f22463i = textView2;
        this.f22464j = usernameTextView;
    }

    public static L a(View view) {
        int i5 = R.id.fl_feed_item;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.fl_feed_item);
        if (frameLayout != null) {
            i5 = R.id.iv_avatar_feed_item;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_avatar_feed_item);
            if (imageView != null) {
                i5 = R.id.iv_follow_feed_item;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_follow_feed_item);
                if (imageView2 != null) {
                    i5 = R.id.iv_turbo_mark_feed_item;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_turbo_mark_feed_item);
                    if (imageView3 != null) {
                        i5 = R.id.iv_type_feed_item;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_type_feed_item);
                        if (imageView4 != null) {
                            i5 = R.id.rl_feed_item;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_feed_item);
                            if (relativeLayout != null) {
                                i5 = R.id.tv_action_feed_item;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_action_feed_item);
                                if (textView != null) {
                                    i5 = R.id.tv_timeago_feed_item;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_timeago_feed_item);
                                    if (textView2 != null) {
                                        i5 = R.id.tv_username_feed_item;
                                        UsernameTextView usernameTextView = (UsernameTextView) ViewBindings.findChildViewById(view, R.id.tv_username_feed_item);
                                        if (usernameTextView != null) {
                                            return new L((RelativeLayout) view, frameLayout, imageView, imageView2, imageView3, imageView4, relativeLayout, textView, textView2, usernameTextView);
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

    public static L c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.feed_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22455a;
    }
}
