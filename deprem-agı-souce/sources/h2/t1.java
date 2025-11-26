package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.uptodown.R;

public final class t1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23561a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f23562b;

    /* renamed from: c  reason: collision with root package name */
    public final YouTubePlayerView f23563c;

    private t1(RelativeLayout relativeLayout, FrameLayout frameLayout, YouTubePlayerView youTubePlayerView) {
        this.f23561a = relativeLayout;
        this.f23562b = frameLayout;
        this.f23563c = youTubePlayerView;
    }

    public static t1 a(View view) {
        int i5 = R.id.youtube_full_screen;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.youtube_full_screen);
        if (frameLayout != null) {
            i5 = R.id.youtube_view;
            YouTubePlayerView youTubePlayerView = (YouTubePlayerView) ViewBindings.findChildViewById(view, R.id.youtube_view);
            if (youTubePlayerView != null) {
                return new t1((RelativeLayout) view, frameLayout, youTubePlayerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static t1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static t1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.video_youtube, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23561a;
    }
}
