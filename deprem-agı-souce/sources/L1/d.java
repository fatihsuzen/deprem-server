package L1;

import H1.e;
import K1.d;
import K1.h;
import W2.J;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import k3.C2616a;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class d extends e {

    /* renamed from: a  reason: collision with root package name */
    private final g f2792a;

    /* renamed from: b  reason: collision with root package name */
    private final K1.d f2793b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final h f2794c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2795d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public C2616a f2796e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Set f2797f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2798g;

    public static final class a extends I1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f2799a;

        a(d dVar) {
            this.f2799a = dVar;
        }

        public void e(e eVar, H1.d dVar) {
            t.e(eVar, "youTubePlayer");
            t.e(dVar, MRAIDCommunicatorUtil.KEY_STATE);
            if (dVar == H1.d.PLAYING && !this.f2799a.m()) {
                eVar.pause();
            }
        }
    }

    public static final class b extends I1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f2800a;

        b(d dVar) {
            this.f2800a = dVar;
        }

        public void d(e eVar) {
            t.e(eVar, "youTubePlayer");
            this.f2800a.setYouTubePlayerReady$core_release(true);
            Iterator it = this.f2800a.f2797f.iterator();
            if (!it.hasNext()) {
                this.f2800a.f2797f.clear();
                eVar.a(this);
                return;
            }
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(Context context, I1.b bVar, AttributeSet attributeSet, int i5, int i6, C2633k kVar) {
        this(context, bVar, (i6 & 4) != 0 ? null : attributeSet, (i6 & 8) != 0 ? 0 : i5);
    }

    /* access modifiers changed from: private */
    public static final J j() {
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J k(d dVar, J1.a aVar, String str, I1.c cVar) {
        dVar.f2792a.e(new c(cVar), aVar, str);
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J l(I1.c cVar, e eVar) {
        t.e(eVar, "it");
        eVar.c(cVar);
        return J.f19942a;
    }

    public final View g(int i5) {
        removeViews(1, getChildCount() - 1);
        View inflate = View.inflate(getContext(), i5, this);
        t.d(inflate, "inflate(...)");
        return inflate;
    }

    public final boolean getCanPlay$core_release() {
        return this.f2798g;
    }

    public final g getWebViewYouTubePlayer$core_release() {
        return this.f2792a;
    }

    public final void h(I1.c cVar, boolean z4, J1.a aVar) {
        t.e(cVar, "youTubePlayerListener");
        t.e(aVar, "playerOptions");
        i(cVar, z4, aVar, (String) null);
    }

    public final void i(I1.c cVar, boolean z4, J1.a aVar, String str) {
        t.e(cVar, "youTubePlayerListener");
        t.e(aVar, "playerOptions");
        if (!this.f2795d) {
            if (z4) {
                this.f2793b.i();
            }
            b bVar = new b(this, aVar, str, cVar);
            this.f2796e = bVar;
            if (!z4) {
                bVar.invoke();
                return;
            }
            return;
        }
        throw new IllegalStateException("This YouTubePlayerView has already been initialized.");
    }

    public final boolean m() {
        if (this.f2798g || this.f2792a.f()) {
            return true;
        }
        return false;
    }

    public final boolean n() {
        return this.f2795d;
    }

    public final void o() {
        this.f2794c.k();
        this.f2798g = true;
    }

    public final void p() {
        this.f2792a.getYoutubePlayer$core_release().pause();
        this.f2794c.l();
        this.f2798g = false;
    }

    public final void q() {
        this.f2793b.c();
        removeView(this.f2792a);
        this.f2792a.removeAllViews();
        this.f2792a.destroy();
    }

    public final void setCustomPlayerUi(View view) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        removeViews(1, getChildCount() - 1);
        addView(view);
    }

    public final void setYouTubePlayerReady$core_release(boolean z4) {
        this.f2795d = z4;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context, I1.b bVar, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        t.e(context, "context");
        t.e(bVar, "listener");
        Context context2 = context;
        g gVar = new g(context2, bVar, (AttributeSet) null, 0, 12, (C2633k) null);
        this.f2792a = gVar;
        Context applicationContext = context2.getApplicationContext();
        t.d(applicationContext, "getApplicationContext(...)");
        K1.d dVar = new K1.d(applicationContext);
        this.f2793b = dVar;
        h hVar = new h();
        this.f2794c = hVar;
        this.f2796e = new a();
        this.f2797f = new LinkedHashSet();
        this.f2798g = true;
        addView(gVar, new FrameLayout.LayoutParams(-1, -1));
        gVar.c(hVar);
        gVar.c(new a(this));
        gVar.c(new b(this));
        dVar.h().add(new c(this));
    }

    public static final class c implements d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f2801a;

        c(d dVar) {
            this.f2801a = dVar;
        }

        public void a() {
            if (!this.f2801a.n()) {
                this.f2801a.f2796e.invoke();
            } else {
                this.f2801a.f2794c.m(this.f2801a.getWebViewYouTubePlayer$core_release().getYoutubePlayer$core_release());
            }
        }

        public void b() {
        }
    }
}
