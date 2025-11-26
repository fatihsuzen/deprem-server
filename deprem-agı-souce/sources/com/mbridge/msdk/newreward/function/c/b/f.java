package com.mbridge.msdk.newreward.function.c.b;

import com.mbridge.msdk.tracker.network.g;
import com.mbridge.msdk.tracker.network.toolbox.b;
import com.mbridge.msdk.tracker.network.toolbox.j;
import com.mbridge.msdk.tracker.network.toolbox.k;
import com.mbridge.msdk.tracker.network.toolbox.n;
import com.mbridge.msdk.tracker.network.u;
import com.mbridge.msdk.tracker.network.v;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile f f10611a;

    /* renamed from: b  reason: collision with root package name */
    private v f10612b;

    private f() {
    }

    public static f a() {
        if (f10611a == null) {
            synchronized (f.class) {
                try {
                    if (f10611a == null) {
                        f10611a = new f();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10611a;
    }

    private v b() {
        if (this.f10612b == null) {
            v a5 = n.a(new b(new k()), new g((Executor) c()), 5, new j());
            this.f10612b = a5;
            a5.a();
        }
        return this.f10612b;
    }

    private static ThreadPoolExecutor c() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 100, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("campaign_response_thread");
                return thread;
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public final void a(a aVar) {
        b().a(aVar);
    }

    public final void a(u<JSONObject> uVar) {
        b().a(uVar);
    }
}
