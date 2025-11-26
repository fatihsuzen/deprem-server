package com.mbridge.msdk.foundation.download.core;

import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DefaultExecutorSupplier implements ExecutorSupplier {
    private int DEFAULT_MAX_NUM_THREADS = 10;
    private final ThreadPoolExecutor backgroundExecutor;
    private final ThreadPoolExecutor downloadResultExecutor;
    private final DownloadExecutor networkExecutor;

    DefaultExecutorSupplier() {
        g a5 = h.a().a(c.m().k());
        if (a5 != null) {
            int S4 = a5.S();
            this.DEFAULT_MAX_NUM_THREADS = S4;
            if (S4 <= 0) {
                this.DEFAULT_MAX_NUM_THREADS = 10;
            }
        }
        DownloadExecutor downloadExecutor = new DownloadExecutor(this.DEFAULT_MAX_NUM_THREADS, new PriorityThreadFactory(10), new ThreadPoolExecutor.DiscardPolicy());
        this.networkExecutor = downloadExecutor;
        if (this.DEFAULT_MAX_NUM_THREADS > 0) {
            downloadExecutor.allowCoreThreadTimeOut(true);
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10, timeUnit, new LinkedBlockingQueue(), new PriorityThreadFactory(10), new ThreadPoolExecutor.DiscardPolicy());
        this.backgroundExecutor = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 10, timeUnit, new LinkedBlockingQueue(), new PriorityThreadFactory(10), new ThreadPoolExecutor.DiscardPolicy());
        this.downloadResultExecutor = threadPoolExecutor2;
        threadPoolExecutor2.allowCoreThreadTimeOut(true);
    }

    public ExecutorService getBackgroundTasks() {
        return this.backgroundExecutor;
    }

    public ExecutorService getDownloadResultTasks() {
        return this.downloadResultExecutor;
    }

    public DownloadExecutor getDownloadTasks() {
        return this.networkExecutor;
    }

    public ExecutorService getLruCacheThreadTasks() {
        return this.backgroundExecutor;
    }
}
