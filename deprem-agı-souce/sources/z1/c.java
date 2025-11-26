package z1;

import A1.f;
import android.os.Handler;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import u1.d;
import u1.m;
import u1.n;
import x1.g;
import x1.h;

public class c extends a {
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public WebView f17251g;

    /* renamed from: h  reason: collision with root package name */
    private Long f17252h = null;

    /* renamed from: i  reason: collision with root package name */
    private final Map f17253i;

    /* renamed from: j  reason: collision with root package name */
    private final String f17254j;

    class a extends WebViewClient {
        a() {
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Log.w("NativeBridge", "WebView renderer gone: " + renderProcessGoneDetail.toString() + "for WebView: " + webView);
            if (c.this.w() == webView) {
                Log.w("NativeBridge", "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
                c.this.c((WebView) null);
            }
            webView.destroy();
            return true;
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WebView f17256a;

        b() {
            this.f17256a = c.this.f17251g;
        }

        public void run() {
            this.f17256a.destroy();
        }
    }

    public c(String str, Map map, String str2) {
        super(str);
        this.f17253i = map;
        this.f17254j = str2;
    }

    /* access modifiers changed from: package-private */
    public void A() {
        WebView webView = new WebView(g.c().a());
        this.f17251g = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f17251g.getSettings().setAllowContentAccess(false);
        this.f17251g.getSettings().setAllowFileAccess(false);
        this.f17251g.setWebViewClient(new a());
        c(this.f17251g);
        h.a().p(this.f17251g, this.f17254j);
        for (String str : this.f17253i.keySet()) {
            h.a().q(this.f17251g, ((m) this.f17253i.get(str)).c().toExternalForm(), str);
        }
        this.f17252h = Long.valueOf(f.b());
    }

    public void k(n nVar, d dVar) {
        JSONObject jSONObject = new JSONObject();
        Map f5 = dVar.f();
        for (String str : f5.keySet()) {
            A1.c.h(jSONObject, str, ((m) f5.get(str)).f());
        }
        l(nVar, dVar, jSONObject);
    }

    public void o() {
        long j5;
        super.o();
        if (this.f17252h == null) {
            j5 = 4000;
        } else {
            j5 = TimeUnit.MILLISECONDS.convert(f.b() - this.f17252h.longValue(), TimeUnit.NANOSECONDS);
        }
        new Handler().postDelayed(new b(), Math.max(4000 - j5, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS));
        this.f17251g = null;
    }

    public void y() {
        super.y();
        A();
    }
}
