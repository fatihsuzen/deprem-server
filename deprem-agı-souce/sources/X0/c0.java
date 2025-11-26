package x0;

import android.os.Looper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import k0.C1698l;

public abstract class c0 {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f16853a = F.c("awaitEvenIfOnMainThread task continuation executor");

    public static Object b(C1698l lVar) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        lVar.g(f16853a, new b0(countDownLatch));
        if (Looper.getMainLooper() == Looper.myLooper()) {
            countDownLatch.await(3000, TimeUnit.MILLISECONDS);
        } else {
            countDownLatch.await(4000, TimeUnit.MILLISECONDS);
        }
        if (lVar.n()) {
            return lVar.j();
        }
        if (lVar.l()) {
            throw new CancellationException("Task is already canceled");
        } else if (lVar.m()) {
            throw new IllegalStateException(lVar.i());
        } else {
            throw new TimeoutException();
        }
    }

    public static boolean c(CountDownLatch countDownLatch, long j5, TimeUnit timeUnit) {
        long nanos;
        boolean await;
        boolean z4 = false;
        try {
            nanos = timeUnit.toNanos(j5);
            while (true) {
                await = countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
                break;
            }
            if (z4) {
                Thread.currentThread().interrupt();
            }
            return await;
        } catch (InterruptedException unused) {
            z4 = true;
            nanos = (System.nanoTime() + nanos) - System.nanoTime();
        } catch (Throwable th) {
            if (z4) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }
}
