package x0;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import u0.g;

public abstract class F {

    class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f16805a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AtomicLong f16806b;

        /* renamed from: x0.F$a$a  reason: collision with other inner class name */
        class C0165a extends C1909e {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Runnable f16807a;

            C0165a(Runnable runnable) {
                this.f16807a = runnable;
            }

            public void a() {
                this.f16807a.run();
            }
        }

        a(String str, AtomicLong atomicLong) {
            this.f16805a = str;
            this.f16806b = atomicLong;
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(new C0165a(runnable));
            newThread.setName(this.f16805a + this.f16806b.getAndIncrement());
            return newThread;
        }
    }

    class b extends C1909e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f16809a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ExecutorService f16810b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f16811c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TimeUnit f16812d;

        b(String str, ExecutorService executorService, long j5, TimeUnit timeUnit) {
            this.f16809a = str;
            this.f16810b = executorService;
            this.f16811c = j5;
            this.f16812d = timeUnit;
        }

        public void a() {
            try {
                g f5 = g.f();
                f5.b("Executing shutdown hook for " + this.f16809a);
                this.f16810b.shutdown();
                if (!this.f16810b.awaitTermination(this.f16811c, this.f16812d)) {
                    g f6 = g.f();
                    f6.b(this.f16809a + " did not shut down in the allocated time. Requesting immediate shutdown.");
                    this.f16810b.shutdownNow();
                }
            } catch (InterruptedException unused) {
                g.f().b(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{this.f16809a}));
                this.f16810b.shutdownNow();
            }
        }
    }

    private static void a(String str, ExecutorService executorService) {
        b(str, executorService, 2, TimeUnit.SECONDS);
    }

    private static void b(String str, ExecutorService executorService, long j5, TimeUnit timeUnit) {
        Runtime runtime = Runtime.getRuntime();
        String str2 = str;
        b bVar = new b(str2, executorService, j5, timeUnit);
        runtime.addShutdownHook(new Thread(bVar, "Crashlytics Shutdown Hook for " + str2));
    }

    public static ExecutorService c(String str) {
        ExecutorService e5 = e(d(str), new ThreadPoolExecutor.DiscardPolicy());
        a(str, e5);
        return e5;
    }

    public static ThreadFactory d(String str) {
        return new a(str, new AtomicLong(1));
    }

    private static ExecutorService e(ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        return Executors.unconfigurableExecutorService(new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory, rejectedExecutionHandler));
    }
}
