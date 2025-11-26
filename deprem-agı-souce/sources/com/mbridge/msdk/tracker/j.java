package com.mbridge.msdk.tracker;

import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class j {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f11523a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f11524b;

    private static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f11527a;

        public a(Runnable runnable) {
            this.f11527a = runnable;
        }

        public final void run() {
            if (!y.a((Object) this.f11527a)) {
                try {
                    this.f11527a.run();
                } catch (Exception e5) {
                    if (a.f11490a) {
                        Log.e("TrackManager", "execute error", e5);
                    }
                }
            }
        }
    }

    public j() {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f11523a = new ThreadPoolExecutor(1, 1, 0, timeUnit, new LinkedBlockingQueue(), new ThreadFactory() {
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "MBridgeTrackThread");
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
        this.f11524b = new ThreadPoolExecutor(1, 1, 0, timeUnit, new LinkedBlockingQueue(), new ThreadFactory() {
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "MBridgeTrackDatabaseThread");
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }

    public final void a(Runnable runnable) {
        this.f11523a.execute(new a(runnable));
    }

    public final void b(Runnable runnable) {
        this.f11524b.execute(new a(runnable));
    }
}
