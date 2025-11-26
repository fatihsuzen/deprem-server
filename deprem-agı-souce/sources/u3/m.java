package U3;

import U3.w;
import V3.c;
import android.support.v4.media.a;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private int f19540a = 64;

    /* renamed from: b  reason: collision with root package name */
    private int f19541b = 5;

    /* renamed from: c  reason: collision with root package name */
    private Runnable f19542c;

    /* renamed from: d  reason: collision with root package name */
    private ExecutorService f19543d;

    /* renamed from: e  reason: collision with root package name */
    private final Deque f19544e = new ArrayDeque();

    /* renamed from: f  reason: collision with root package name */
    private final Deque f19545f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    private final Deque f19546g = new ArrayDeque();

    private void d(Deque deque, Object obj, boolean z4) {
        int f5;
        Runnable runnable;
        synchronized (this) {
            try {
                if (deque.remove(obj)) {
                    if (z4) {
                        e();
                    }
                    f5 = f();
                    runnable = this.f19542c;
                } else {
                    throw new AssertionError("Call wasn't in-flight!");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (f5 == 0 && runnable != null) {
            runnable.run();
        }
    }

    private void e() {
        if (this.f19545f.size() < this.f19540a && !this.f19544e.isEmpty()) {
            Iterator it = this.f19544e.iterator();
            while (it.hasNext()) {
                a.a(it.next());
                if (g((w.a) null) < this.f19541b) {
                    it.remove();
                    this.f19545f.add((Object) null);
                    b().execute((Runnable) null);
                }
                if (this.f19545f.size() >= this.f19540a) {
                    return;
                }
            }
        }
    }

    private int g(w.a aVar) {
        Iterator it = this.f19545f.iterator();
        if (!it.hasNext()) {
            return 0;
        }
        a.a(it.next());
        throw null;
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(w wVar) {
        this.f19546g.add(wVar);
    }

    public synchronized ExecutorService b() {
        try {
            if (this.f19543d == null) {
                this.f19543d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.B("OkHttp Dispatcher", false));
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f19543d;
    }

    /* access modifiers changed from: package-private */
    public void c(w wVar) {
        d(this.f19546g, wVar, false);
    }

    public synchronized int f() {
        return this.f19545f.size() + this.f19546g.size();
    }
}
