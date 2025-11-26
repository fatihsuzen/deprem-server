package com.mbridge.msdk.tracker.network;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final BlockingQueue<u<?>> f11604a;

    /* renamed from: b  reason: collision with root package name */
    private final n f11605b;

    /* renamed from: c  reason: collision with root package name */
    private final b f11606c;

    /* renamed from: d  reason: collision with root package name */
    private final x f11607d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f11608e = false;

    public o(BlockingQueue<u<?>> blockingQueue, n nVar, b bVar, x xVar) {
        this.f11604a = blockingQueue;
        this.f11605b = nVar;
        this.f11606c = bVar;
        this.f11607d = xVar;
    }

    public final void run() {
        u take;
        Process.setThreadPriority(10);
        while (true) {
            try {
                take = this.f11604a.take();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                take.b(3);
                try {
                    if (take.n()) {
                        take.c("network-discard-cancelled");
                        take.y();
                    } else {
                        TrafficStats.setThreadStatsTag(take.j());
                        r a5 = this.f11605b.a(take);
                        if (!a5.f11659e || !take.x()) {
                            w a6 = take.a(a5);
                            if (take.r() && a6.f11721b != null) {
                                this.f11606c.a(take.l(), a6.f11721b);
                            }
                            take.w();
                            this.f11607d.a((u<?>) take, (w<?>) a6);
                            take.a((w<?>) a6);
                        } else {
                            take.c("not-modified");
                            take.y();
                        }
                    }
                } catch (ad e5) {
                    e5.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.f11607d.a((u<?>) take, e5);
                    take.y();
                } catch (Exception e6) {
                    ae.a(e6, "Unhandled exception %s", e6.toString());
                    ac acVar = new ac((Throwable) e6);
                    acVar.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.f11607d.a((u<?>) take, (ad) acVar);
                    take.y();
                }
                take.b(4);
            } catch (InterruptedException unused) {
                if (this.f11608e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                ae.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            } catch (Throwable th) {
                take.b(4);
                throw th;
            }
        }
    }
}
