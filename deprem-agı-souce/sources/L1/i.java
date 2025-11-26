package L1;

import android.webkit.WebView;
import java.util.List;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebView f2810a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2811b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f2812c;

    public /* synthetic */ i(WebView webView, String str, List list) {
        this.f2810a = webView;
        this.f2811b = str;
        this.f2812c = list;
    }

    public final void run() {
        j.i(this.f2810a, this.f2811b, this.f2812c);
    }
}
