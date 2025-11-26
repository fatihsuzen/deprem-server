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

public final class P implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22576a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22577b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f22578c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f22579d;

    /* renamed from: e  reason: collision with root package name */
    public final UsernameTextView f22580e;

    private P(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, TextView textView, UsernameTextView usernameTextView) {
        this.f22576a = relativeLayout;
        this.f22577b = imageView;
        this.f22578c = imageView2;
        this.f22579d = textView;
        this.f22580e = usernameTextView;
    }

    public static P a(View view) {
        int i5 = R.id.iv_avatar_follow_list_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_avatar_follow_list_item);
        if (imageView != null) {
            i5 = R.id.iv_turbo_mark_follow_list_item;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_turbo_mark_follow_list_item);
            if (imageView2 != null) {
                i5 = R.id.tv_action_follow_list_item;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_action_follow_list_item);
                if (textView != null) {
                    i5 = R.id.tv_username_follow_list_item;
                    UsernameTextView usernameTextView = (UsernameTextView) ViewBindings.findChildViewById(view, R.id.tv_username_follow_list_item);
                    if (usernameTextView != null) {
                        return new P((RelativeLayout) view, imageView, imageView2, textView, usernameTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static P c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.follow_list_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22576a;
    }
}
