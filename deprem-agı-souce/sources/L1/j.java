package L1;

import H1.e;
import H1.s;
import I1.c;
import W2.J;
import X2.C2250q;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import k3.l;
import kotlin.jvm.internal.t;

final class j implements e {

    /* renamed from: a  reason: collision with root package name */
    private final WebView f2813a;

    /* renamed from: b  reason: collision with root package name */
    private final s f2814b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f2815c = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    private final Object f2816d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private final Set f2817e = new LinkedHashSet();

    public j(WebView webView, s sVar) {
        t.e(webView, "webView");
        t.e(sVar, "callbacks");
        this.f2813a = webView;
        this.f2814b = sVar;
    }

    private final void h(WebView webView, String str, Object... objArr) {
        String str2;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (String str3 : objArr) {
            if (str3 instanceof String) {
                str2 = '\'' + str3 + '\'';
            } else {
                str2 = str3.toString();
            }
            arrayList.add(str2);
        }
        this.f2815c.post(new i(webView, str, arrayList));
    }

    /* access modifiers changed from: private */
    public static final void i(WebView webView, String str, List list) {
        webView.loadUrl("javascript:" + str + '(' + C2250q.V(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null) + ')');
    }

    public boolean a(c cVar) {
        boolean remove;
        t.e(cVar, "listener");
        synchronized (this.f2816d) {
            remove = this.f2817e.remove(cVar);
        }
        return remove;
    }

    public void b(String str, float f5) {
        t.e(str, "videoId");
        h(this.f2813a, "cueVideo", str, Float.valueOf(f5));
    }

    public boolean c(c cVar) {
        boolean add;
        t.e(cVar, "listener");
        synchronized (this.f2816d) {
            add = this.f2817e.add(cVar);
        }
        return add;
    }

    public void d(String str, float f5) {
        t.e(str, "videoId");
        h(this.f2813a, "loadVideo", str, Float.valueOf(f5));
    }

    public void e() {
        h(this.f2813a, CampaignEx.JSON_NATIVE_VIDEO_MUTE, new Object[0]);
    }

    public final Collection g() {
        List n02;
        synchronized (this.f2816d) {
            n02 = C2250q.n0(this.f2817e);
        }
        return n02;
    }

    public final void j() {
        synchronized (this.f2816d) {
            this.f2817e.clear();
            J j5 = J.f19942a;
        }
        this.f2815c.removeCallbacksAndMessages((Object) null);
    }

    public void pause() {
        h(this.f2813a, "pauseVideo", new Object[0]);
    }

    public void play() {
        h(this.f2813a, "playVideo", new Object[0]);
    }
}
