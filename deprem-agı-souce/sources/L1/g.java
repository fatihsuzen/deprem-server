package L1;

import H1.e;
import H1.q;
import H1.s;
import I1.b;
import I1.c;
import J1.a;
import W2.J;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import java.io.InputStream;
import java.util.Collection;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class g extends WebView implements q.b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f2803a;

    /* renamed from: b  reason: collision with root package name */
    private final s f2804b;

    /* renamed from: c  reason: collision with root package name */
    private final j f2805c;

    /* renamed from: d  reason: collision with root package name */
    private l f2806d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2807e;

    /* renamed from: f  reason: collision with root package name */
    private final q f2808f;

    public static final class a extends WebChromeClient {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f2809a;

        a(g gVar) {
            this.f2809a = gVar;
        }

        /* access modifiers changed from: private */
        public static final J b(WebChromeClient.CustomViewCallback customViewCallback) {
            customViewCallback.onCustomViewHidden();
            return J.f19942a;
        }

        public Bitmap getDefaultVideoPoster() {
            Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
            if (defaultVideoPoster != null) {
                return defaultVideoPoster;
            }
            Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
            t.d(createBitmap, "createBitmap(...)");
            return createBitmap;
        }

        public void onHideCustomView() {
            super.onHideCustomView();
            this.f2809a.f2803a.onExitFullscreen();
        }

        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            t.e(customViewCallback, "callback");
            super.onShowCustomView(view, customViewCallback);
            this.f2809a.f2803a.a(view, new f(customViewCallback));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(Context context, b bVar, AttributeSet attributeSet, int i5, int i6, C2633k kVar) {
        this(context, bVar, (i6 & 4) != 0 ? null : attributeSet, (i6 & 8) != 0 ? 0 : i5);
    }

    private final void d(J1.a aVar, String str) {
        String str2;
        String str3 = str;
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setCacheMode(-1);
        addJavascriptInterface(this.f2808f, "YouTubePlayerBridge");
        addJavascriptInterface(this.f2804b, "YouTubePlayerCallbacks");
        InputStream openRawResource = getResources().openRawResource(G1.a.ayp_youtube_player);
        t.d(openRawResource, "openRawResource(...)");
        String a5 = h.a(openRawResource);
        if (str3 != null) {
            str2 = '\'' + str3 + '\'';
        } else {
            str2 = "undefined";
        }
        loadDataWithBaseURL(aVar.a(), t3.s.L(t3.s.L(a5, "<<injectedVideoId>>", str2, false, 4, (Object) null), "<<injectedPlayerVars>>", aVar.toString(), false, 4, (Object) null), "text/html", "utf-8", (String) null);
        setWebChromeClient(new a(this));
    }

    public void a() {
        l lVar = this.f2806d;
        if (lVar == null) {
            t.w("youTubePlayerInitListener");
            lVar = null;
        }
        lVar.invoke(this.f2805c);
    }

    public final boolean c(c cVar) {
        t.e(cVar, "listener");
        return this.f2805c.c(cVar);
    }

    public void destroy() {
        this.f2805c.j();
        super.destroy();
    }

    public final void e(l lVar, J1.a aVar, String str) {
        t.e(lVar, "initListener");
        this.f2806d = lVar;
        if (aVar == null) {
            a.b bVar = J1.a.f2664b;
            Context context = getContext();
            t.d(context, "getContext(...)");
            aVar = bVar.a(context);
        }
        d(aVar, str);
    }

    public final boolean f() {
        return this.f2807e;
    }

    public e getInstance() {
        return this.f2805c;
    }

    public Collection<c> getListeners() {
        return this.f2805c.g();
    }

    public final e getYoutubePlayer$core_release() {
        return this.f2805c;
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i5) {
        if (!this.f2807e || !(i5 == 8 || i5 == 4)) {
            super.onWindowVisibilityChanged(i5);
        }
    }

    public final void setBackgroundPlaybackEnabled$core_release(boolean z4) {
        this.f2807e = z4;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Context context, b bVar, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        t.e(context, "context");
        t.e(bVar, "listener");
        this.f2803a = bVar;
        s sVar = new s();
        this.f2804b = sVar;
        this.f2805c = new j(this, sVar);
        this.f2808f = new q(this);
    }
}
