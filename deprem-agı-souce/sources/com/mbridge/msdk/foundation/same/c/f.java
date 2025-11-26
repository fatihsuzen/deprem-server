package com.mbridge.msdk.foundation.same.c;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static ThreadPoolExecutor f9273a;

    public static ThreadPoolExecutor a() {
        if (f9273a == null) {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            f9273a = new ThreadPoolExecutor(availableProcessors, availableProcessors, 10, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new ThreadFactory() {
                public final Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("mb-image-loader-thread");
                    return thread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
        }
        f9273a.allowCoreThreadTimeOut(true);
        return f9273a;
    }
}
