package D;

import android.net.Uri;
import java.util.Map;

/* renamed from: D.b  reason: case insensitive filesystem */
final class C0636b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Map f2350a;

    C0636b(C0635a aVar, Map map) {
        this.f2350a = map;
    }

    public final void run() {
        Map map = this.f2350a;
        Uri.Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String str : map.keySet()) {
            buildUpon.appendQueryParameter(str, (String) map.get(str));
        }
        d.a(buildUpon.build().toString());
    }
}
