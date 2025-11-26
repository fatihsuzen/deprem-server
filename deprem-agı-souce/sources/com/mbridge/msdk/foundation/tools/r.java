package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.FastKV;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    static volatile Executor f9738a;

    /* renamed from: b  reason: collision with root package name */
    static FastKV.b f9739b = new FastKV.b() {
        public final void a(String str, Exception exc) {
            if (MBridgeConstans.DEBUG) {
                af.b("FastKVConfig", str, exc);
            }
        }

        public final void b(String str, Exception exc) {
            if (MBridgeConstans.DEBUG) {
                af.c("FastKVConfig", str, exc);
            }
        }

        public final void a(String str, String str2) {
            if (MBridgeConstans.DEBUG) {
                af.c("FastKVConfig", str + " " + str2);
            }
        }
    };

    private r() {
    }

    static Executor a() {
        if (f9738a == null) {
            synchronized (r.class) {
                try {
                    if (f9738a == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
                            public final Thread newThread(Runnable runnable) {
                                return new Thread(runnable, "mb-sp-handler");
                            }
                        }, new ThreadPoolExecutor.DiscardPolicy());
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        f9738a = threadPoolExecutor;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f9738a;
    }
}
