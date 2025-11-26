package H1;

import I1.c;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.util.Collection;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;

public final class q {

    /* renamed from: c  reason: collision with root package name */
    public static final a f2591c = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final b f2592a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f2593b = new Handler(Looper.getMainLooper());

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public interface b {
        void a();

        e getInstance();

        Collection getListeners();
    }

    public q(b bVar) {
        t.e(bVar, "youTubePlayerOwner");
        this.f2592a = bVar;
    }

    private final a l(String str) {
        if (s.E(str, "small", true)) {
            return a.SMALL;
        }
        if (s.E(str, "medium", true)) {
            return a.MEDIUM;
        }
        if (s.E(str, "large", true)) {
            return a.LARGE;
        }
        if (s.E(str, "hd720", true)) {
            return a.HD720;
        }
        if (s.E(str, "hd1080", true)) {
            return a.HD1080;
        }
        if (s.E(str, "highres", true)) {
            return a.HIGH_RES;
        }
        if (s.E(str, MRAIDCommunicatorUtil.STATES_DEFAULT, true)) {
            return a.DEFAULT;
        }
        return a.UNKNOWN;
    }

    private final b m(String str) {
        if (s.E(str, "0.25", true)) {
            return b.RATE_0_25;
        }
        if (s.E(str, "0.5", true)) {
            return b.RATE_0_5;
        }
        if (s.E(str, "0.75", true)) {
            return b.RATE_0_75;
        }
        if (s.E(str, "1", true)) {
            return b.RATE_1;
        }
        if (s.E(str, "1.25", true)) {
            return b.RATE_1_25;
        }
        if (s.E(str, "1.5", true)) {
            return b.RATE_1_5;
        }
        if (s.E(str, "1.75", true)) {
            return b.RATE_1_75;
        }
        if (s.E(str, "2", true)) {
            return b.RATE_2;
        }
        return b.UNKNOWN;
    }

    private final c n(String str) {
        if (s.E(str, "2", true)) {
            return c.INVALID_PARAMETER_IN_REQUEST;
        }
        if (s.E(str, CampaignEx.CLICKMODE_ON, true)) {
            return c.HTML_5_PLAYER;
        }
        if (s.E(str, "100", true)) {
            return c.VIDEO_NOT_FOUND;
        }
        if (s.E(str, "101", true)) {
            return c.VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER;
        }
        if (s.E(str, "150", true)) {
            return c.VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER;
        }
        if (s.E(str, "153", true)) {
            return c.REQUEST_MISSING_HTTP_REFERER;
        }
        return c.UNKNOWN;
    }

    private final d o(String str) {
        if (s.E(str, "UNSTARTED", true)) {
            return d.UNSTARTED;
        }
        if (s.E(str, "ENDED", true)) {
            return d.ENDED;
        }
        if (s.E(str, "PLAYING", true)) {
            return d.PLAYING;
        }
        if (s.E(str, "PAUSED", true)) {
            return d.PAUSED;
        }
        if (s.E(str, "BUFFERING", true)) {
            return d.BUFFERING;
        }
        if (s.E(str, "CUED", true)) {
            return d.VIDEO_CUED;
        }
        return d.UNKNOWN;
    }

    /* access modifiers changed from: private */
    public static final void p(q qVar) {
        for (c a5 : qVar.f2592a.getListeners()) {
            a5.a(qVar.f2592a.getInstance());
        }
    }

    /* access modifiers changed from: private */
    public static final void q(q qVar, c cVar) {
        for (c g5 : qVar.f2592a.getListeners()) {
            g5.g(qVar.f2592a.getInstance(), cVar);
        }
    }

    /* access modifiers changed from: private */
    public static final void r(q qVar, a aVar) {
        for (c i5 : qVar.f2592a.getListeners()) {
            i5.i(qVar.f2592a.getInstance(), aVar);
        }
    }

    /* access modifiers changed from: private */
    public static final void s(q qVar, b bVar) {
        for (c j5 : qVar.f2592a.getListeners()) {
            j5.j(qVar.f2592a.getInstance(), bVar);
        }
    }

    /* access modifiers changed from: private */
    public static final void t(q qVar) {
        for (c d5 : qVar.f2592a.getListeners()) {
            d5.d(qVar.f2592a.getInstance());
        }
    }

    /* access modifiers changed from: private */
    public static final void u(q qVar, d dVar) {
        for (c e5 : qVar.f2592a.getListeners()) {
            e5.e(qVar.f2592a.getInstance(), dVar);
        }
    }

    /* access modifiers changed from: private */
    public static final void v(q qVar, float f5) {
        for (c c5 : qVar.f2592a.getListeners()) {
            c5.c(qVar.f2592a.getInstance(), f5);
        }
    }

    /* access modifiers changed from: private */
    public static final void w(q qVar, float f5) {
        for (c f6 : qVar.f2592a.getListeners()) {
            f6.f(qVar.f2592a.getInstance(), f5);
        }
    }

    /* access modifiers changed from: private */
    public static final void x(q qVar, String str) {
        for (c b5 : qVar.f2592a.getListeners()) {
            b5.b(qVar.f2592a.getInstance(), str);
        }
    }

    /* access modifiers changed from: private */
    public static final void y(q qVar, float f5) {
        for (c h5 : qVar.f2592a.getListeners()) {
            h5.h(qVar.f2592a.getInstance(), f5);
        }
    }

    /* access modifiers changed from: private */
    public static final void z(q qVar) {
        qVar.f2592a.a();
    }

    @JavascriptInterface
    public final boolean sendApiChange() {
        return this.f2593b.post(new l(this));
    }

    @JavascriptInterface
    public final void sendError(String str) {
        t.e(str, CampaignEx.JSON_NATIVE_VIDEO_ERROR);
        this.f2593b.post(new o(this, n(str)));
    }

    @JavascriptInterface
    public final void sendPlaybackQualityChange(String str) {
        t.e(str, "quality");
        this.f2593b.post(new h(this, l(str)));
    }

    @JavascriptInterface
    public final void sendPlaybackRateChange(String str) {
        t.e(str, "rate");
        this.f2593b.post(new j(this, m(str)));
    }

    @JavascriptInterface
    public final boolean sendReady() {
        return this.f2593b.post(new m(this));
    }

    @JavascriptInterface
    public final void sendStateChange(String str) {
        t.e(str, MRAIDCommunicatorUtil.KEY_STATE);
        this.f2593b.post(new p(this, o(str)));
    }

    @JavascriptInterface
    public final void sendVideoCurrentTime(String str) {
        t.e(str, "seconds");
        try {
            this.f2593b.post(new f(this, Float.parseFloat(str)));
        } catch (NumberFormatException e5) {
            e5.printStackTrace();
        }
    }

    @JavascriptInterface
    public final void sendVideoDuration(String str) {
        t.e(str, "seconds");
        try {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.f2593b.post(new i(this, Float.parseFloat(str)));
        } catch (NumberFormatException e5) {
            e5.printStackTrace();
        }
    }

    @JavascriptInterface
    public final boolean sendVideoId(String str) {
        t.e(str, "videoId");
        return this.f2593b.post(new k(this, str));
    }

    @JavascriptInterface
    public final void sendVideoLoadedFraction(String str) {
        t.e(str, "fraction");
        try {
            this.f2593b.post(new n(this, Float.parseFloat(str)));
        } catch (NumberFormatException e5) {
            e5.printStackTrace();
        }
    }

    @JavascriptInterface
    public final boolean sendYouTubeIFrameAPIReady() {
        return this.f2593b.post(new g(this));
    }
}
