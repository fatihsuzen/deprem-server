package com.mbridge.msdk.foundation.same.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static ThreadPoolExecutor f9291a;

    /* renamed from: b  reason: collision with root package name */
    private static ThreadPoolExecutor f9292b;

    /* renamed from: c  reason: collision with root package name */
    private static Handler f9293c;

    /* renamed from: d  reason: collision with root package name */
    private static ThreadPoolExecutor f9294d;

    /* renamed from: e  reason: collision with root package name */
    private static ThreadPoolExecutor f9295e;

    /* renamed from: f  reason: collision with root package name */
    private static ThreadPoolExecutor f9296f;

    /* renamed from: com.mbridge.msdk.foundation.same.f.a$a  reason: collision with other inner class name */
    private static class C0088a extends Handler {
        public C0088a() {
            super(Looper.getMainLooper());
        }

        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
        }
    }

    public static ThreadPoolExecutor a() {
        if (f9292b == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(10), new ThreadFactory() {
                public final Thread newThread(@NonNull Runnable runnable) {
                    Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                    newThread.setName("BitmapThreadPool");
                    return newThread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
            f9292b = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return f9292b;
    }

    public static ThreadPoolExecutor b() {
        if (f9291a == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 25, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(100), new ThreadFactory() {
                public final Thread newThread(@NonNull Runnable runnable) {
                    Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                    newThread.setName("CommonThreadPool");
                    return newThread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
            f9291a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return f9291a;
    }

    public static Handler c() {
        if (f9293c == null) {
            f9293c = new C0088a();
        }
        return f9293c;
    }

    public static ThreadPoolExecutor d() {
        if (f9294d == null) {
            f9294d = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1), new ThreadFactory() {
                public final Thread newThread(@NonNull Runnable runnable) {
                    Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                    newThread.setName("NwtThreadPool");
                    return newThread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
        }
        return f9294d;
    }

    public static ThreadPoolExecutor e() {
        if (f9295e == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 15, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(100), new ThreadFactory() {
                public final Thread newThread(@NonNull Runnable runnable) {
                    Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                    newThread.setName("ReportThreadPool");
                    return newThread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
            f9295e = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return f9295e;
    }

    public static ThreadPoolExecutor f() {
        if (f9296f == null) {
            AnonymousClass5 r8 = new ThreadFactory() {
                public final Thread newThread(@NonNull Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("rv-load-tread");
                    return thread;
                }
            };
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(availableProcessors, availableProcessors * 2, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(30), r8, new ThreadPoolExecutor.DiscardPolicy());
            f9296f = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return f9296f;
    }
}
