package Y0;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final a f4486a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f4487b;

    /* renamed from: Y0.b$b  reason: collision with other inner class name */
    private static class C0064b implements a {
        private C0064b() {
        }

        public ExecutorService a(ThreadFactory threadFactory, c cVar) {
            return b(1, threadFactory, cVar);
        }

        public ExecutorService b(int i5, ThreadFactory threadFactory, c cVar) {
            int i6 = i5;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i6, i5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return Executors.unconfigurableExecutorService(threadPoolExecutor);
        }
    }

    static {
        C0064b bVar = new C0064b();
        f4486a = bVar;
        f4487b = bVar;
    }

    public static a a() {
        return f4487b;
    }
}
