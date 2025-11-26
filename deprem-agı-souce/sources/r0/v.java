package r0;

import O0.a;
import O0.b;
import O0.c;
import O0.d;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;

class v implements d, c {

    /* renamed from: a  reason: collision with root package name */
    private final Map f16378a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private Queue f16379b = new ArrayDeque();

    /* renamed from: c  reason: collision with root package name */
    private final Executor f16380c;

    v(Executor executor) {
        this.f16380c = executor;
    }

    private synchronized Set e(a aVar) {
        throw null;
    }

    public synchronized void a(Class cls, Executor executor, b bVar) {
        try {
            E.b(cls);
            E.b(bVar);
            E.b(executor);
            if (!this.f16378a.containsKey(cls)) {
                this.f16378a.put(cls, new ConcurrentHashMap());
            }
            ((ConcurrentHashMap) this.f16378a.get(cls)).put(bVar, executor);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public void b(Class cls, b bVar) {
        a(cls, this.f16380c, bVar);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        Queue<Object> queue;
        synchronized (this) {
            try {
                queue = this.f16379b;
                if (queue != null) {
                    this.f16379b = null;
                } else {
                    queue = null;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (queue != null) {
            for (Object a5 : queue) {
                android.support.v4.media.a.a(a5);
                f((a) null);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0010, code lost:
        r0 = e(r5).iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        if (r0.hasNext() == false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        r1 = (java.util.Map.Entry) r0.next();
        ((java.util.concurrent.Executor) r1.getValue()).execute(new r0.u(r1, r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(O0.a r5) {
        /*
            r4 = this;
            r0.E.b(r5)
            monitor-enter(r4)
            java.util.Queue r0 = r4.f16379b     // Catch:{ all -> 0x000d }
            if (r0 == 0) goto L_0x000f
            r0.add(r5)     // Catch:{ all -> 0x000d }
            monitor-exit(r4)     // Catch:{ all -> 0x000d }
            return
        L_0x000d:
            r5 = move-exception
            goto L_0x0034
        L_0x000f:
            monitor-exit(r4)     // Catch:{ all -> 0x000d }
            java.util.Set r0 = r4.e(r5)
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0033
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getValue()
            java.util.concurrent.Executor r2 = (java.util.concurrent.Executor) r2
            r0.u r3 = new r0.u
            r3.<init>(r1, r5)
            r2.execute(r3)
            goto L_0x0018
        L_0x0033:
            return
        L_0x0034:
            monitor-exit(r4)     // Catch:{ all -> 0x000d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: r0.v.f(O0.a):void");
    }
}
