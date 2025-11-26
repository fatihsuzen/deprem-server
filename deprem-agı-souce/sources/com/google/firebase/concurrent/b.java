package com.google.firebase.concurrent;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

class b implements ThreadFactory {

    /* renamed from: e  reason: collision with root package name */
    private static final ThreadFactory f7176e = Executors.defaultThreadFactory();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicLong f7177a = new AtomicLong();

    /* renamed from: b  reason: collision with root package name */
    private final String f7178b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7179c;

    /* renamed from: d  reason: collision with root package name */
    private final StrictMode.ThreadPolicy f7180d;

    b(String str, int i5, StrictMode.ThreadPolicy threadPolicy) {
        this.f7178b = str;
        this.f7179c = i5;
        this.f7180d = threadPolicy;
    }

    public static /* synthetic */ void a(b bVar, Runnable runnable) {
        Process.setThreadPriority(bVar.f7179c);
        StrictMode.ThreadPolicy threadPolicy = bVar.f7180d;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        runnable.run();
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = f7176e.newThread(new a(this, runnable));
        newThread.setName(String.format(Locale.ROOT, "%s Thread #%d", new Object[]{this.f7178b, Long.valueOf(this.f7177a.getAndIncrement())}));
        return newThread;
    }
}
