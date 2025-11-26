package H1;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.a;
import android.webkit.JavascriptInterface;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f2597a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap f2598b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicLong f2599c = new AtomicLong(0);

    /* access modifiers changed from: private */
    public static final void b(s sVar, long j5, boolean z4) {
        a.a(sVar.f2598b.remove(Long.valueOf(j5)));
    }

    @JavascriptInterface
    public final void sendBooleanValue(long j5, boolean z4) {
        this.f2597a.post(new r(this, j5, z4));
    }
}
