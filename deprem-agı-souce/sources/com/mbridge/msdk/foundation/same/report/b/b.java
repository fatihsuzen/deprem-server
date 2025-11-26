package com.mbridge.msdk.foundation.same.report.b;

import android.annotation.TargetApi;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

public class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f9421a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Handler f9422b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private volatile a f9423c;

    /* renamed from: d  reason: collision with root package name */
    private a f9424d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f9425e = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private long f9427b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public boolean f9428c;

        /* renamed from: d  reason: collision with root package name */
        private long f9429d;

        private a() {
            this.f9427b = SystemClock.uptimeMillis();
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            this.f9428c = false;
            this.f9429d = SystemClock.uptimeMillis();
            b.this.f9422b.postAtFrontOfQueue(this);
        }

        public final void run() {
            synchronized (b.this) {
                this.f9428c = true;
                this.f9427b = SystemClock.uptimeMillis();
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return !this.f9428c || this.f9427b - this.f9429d >= ((long) b.this.f9425e);
        }
    }

    private b() {
        super("AnrMonitor-Thread");
    }

    @TargetApi(16)
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            if (isInterrupted() || (this.f9423c != null && !this.f9423c.f9428c)) {
                try {
                    Thread.sleep((long) this.f9425e);
                } catch (Exception unused) {
                }
            } else {
                synchronized (this) {
                    try {
                        if (this.f9423c == null) {
                            this.f9423c = new a();
                        }
                        this.f9423c.b();
                        long j5 = (long) this.f9425e;
                        long uptimeMillis = SystemClock.uptimeMillis();
                        while (j5 > 0) {
                            wait(j5);
                            j5 = ((long) this.f9425e) - (SystemClock.uptimeMillis() - uptimeMillis);
                        }
                        if (!this.f9423c.a()) {
                            a aVar = this.f9424d;
                            if (aVar != null) {
                                aVar.a();
                            }
                        } else if (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger() && this.f9424d != null) {
                            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
                            this.f9424d.a(c.a(stackTrace), stackTrace);
                        }
                    } catch (InterruptedException e5) {
                        Log.w("AnrMonitor", e5.toString());
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            }
        }
    }

    public static b a() {
        if (f9421a == null) {
            synchronized (b.class) {
                try {
                    if (f9421a == null) {
                        f9421a = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f9421a;
    }

    public final b a(int i5, a aVar) {
        this.f9425e = i5;
        this.f9424d = aVar;
        return this;
    }
}
