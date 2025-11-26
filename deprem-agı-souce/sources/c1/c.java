package C1;

import C1.b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private final BlockingQueue f2337a;

    /* renamed from: b  reason: collision with root package name */
    private final ThreadPoolExecutor f2338b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayDeque f2339c = new ArrayDeque();

    /* renamed from: d  reason: collision with root package name */
    private b f2340d = null;

    public c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f2337a = linkedBlockingQueue;
        this.f2338b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void b() {
        b bVar = (b) this.f2339c.poll();
        this.f2340d = bVar;
        if (bVar != null) {
            bVar.c(this.f2338b);
        }
    }

    public void a(b bVar) {
        this.f2340d = null;
        b();
    }

    public void c(b bVar) {
        bVar.a(this);
        this.f2339c.add(bVar);
        if (this.f2340d == null) {
            b();
        }
    }
}
