package com.mbridge.msdk.newreward.a.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import java.util.HashMap;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f10409a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, c> f10410b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Handler f10411c;

    /* renamed from: com.mbridge.msdk.newreward.a.c.a$a  reason: collision with other inner class name */
    public interface C0098a {
        void a(String str, long j5);
    }

    private static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f10412a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f10413b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public boolean f10414c;

        public b(String str, long j5) {
            this.f10412a = str;
            this.f10413b = j5;
        }
    }

    public static class c implements Runnable {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final b f10415a;

        /* renamed from: b  reason: collision with root package name */
        private final C0098a f10416b;

        public c(b bVar, C0098a aVar) {
            this.f10415a = bVar;
            this.f10416b = aVar;
        }

        public final void run() {
            C0098a aVar;
            if (MBridgeConstans.DEBUG) {
                af.a("MBridgeTimer", "TimerTask run taskID: " + this.f10415a.f10412a + " isStop: " + this.f10415a.f10414c);
            }
            if (!this.f10415a.f10414c && (aVar = this.f10416b) != null) {
                try {
                    aVar.a(this.f10415a.f10412a, this.f10415a.f10413b);
                } catch (Exception unused) {
                }
            }
        }
    }

    public a() {
        HandlerThread handlerThread = new HandlerThread("MBridgeTimerThread");
        handlerThread.start();
        this.f10411c = new Handler(handlerThread.getLooper());
    }

    public static a a() {
        if (f10409a == null) {
            synchronized (a.class) {
                try {
                    if (f10409a == null) {
                        f10409a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10409a;
    }

    public final void a(String str, long j5, C0098a aVar) {
        if (!TextUtils.isEmpty(str)) {
            if (MBridgeConstans.DEBUG) {
                af.a("MBridgeTimer", "startTimer taskID: " + str + " timeout: " + j5);
            }
            if (!this.f10410b.containsKey(str)) {
                c cVar = new c(new b(str, j5), aVar);
                this.f10410b.put(str, cVar);
                this.f10411c.postDelayed(cVar, j5);
            }
        }
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            c remove = this.f10410b.remove(str);
            if (MBridgeConstans.DEBUG) {
                af.a("MBridgeTimer", "stopTimer taskID: " + str);
            }
            if (remove != null) {
                boolean unused = remove.f10415a.f10414c = true;
                this.f10411c.removeCallbacks(remove);
            }
        }
    }
}
