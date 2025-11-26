package com.mbridge.msdk.thrid.okhttp;

import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection;
import com.mbridge.msdk.thrid.okhttp.internal.connection.RouteDatabase;
import com.mbridge.msdk.thrid.okhttp.internal.connection.StreamAllocation;
import com.mbridge.msdk.thrid.okhttp.internal.platform.Platform;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ConnectionPool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Executor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
    private final Runnable cleanupRunnable;
    boolean cleanupRunning;
    private final Deque<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    final RouteDatabase routeDatabase;

    public ConnectionPool() {
        this(5, 5, TimeUnit.MINUTES);
    }

    private int pruneAndGetAllocationCount(RealConnection realConnection, long j5) {
        List<Reference<StreamAllocation>> list = realConnection.allocations;
        int i5 = 0;
        while (i5 < list.size()) {
            Reference reference = list.get(i5);
            if (reference.get() != null) {
                i5++;
            } else {
                Platform.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((StreamAllocation.StreamAllocationReference) reference).callStackTrace);
                list.remove(i5);
                realConnection.noNewStreams = true;
                if (list.isEmpty()) {
                    realConnection.idleAtNanos = j5 - this.keepAliveDurationNs;
                    return 0;
                }
            }
        }
        return list.size();
    }

    /* access modifiers changed from: package-private */
    public long cleanup(long j5) {
        synchronized (this) {
            try {
                RealConnection realConnection = null;
                long j6 = Long.MIN_VALUE;
                int i5 = 0;
                int i6 = 0;
                for (RealConnection next : this.connections) {
                    if (pruneAndGetAllocationCount(next, j5) > 0) {
                        i6++;
                    } else {
                        i5++;
                        long j7 = j5 - next.idleAtNanos;
                        if (j7 > j6) {
                            realConnection = next;
                            j6 = j7;
                        }
                    }
                }
                long j8 = this.keepAliveDurationNs;
                if (j6 < j8) {
                    if (i5 <= this.maxIdleConnections) {
                        if (i5 > 0) {
                            long j9 = j8 - j6;
                            return j9;
                        } else if (i6 > 0) {
                            return j8;
                        } else {
                            this.cleanupRunning = false;
                            return -1;
                        }
                    }
                }
                this.connections.remove(realConnection);
                Util.closeQuietly(realConnection.socket());
                return 0;
            } finally {
                while (true) {
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean connectionBecameIdle(RealConnection realConnection) {
        if (realConnection.noNewStreams || this.maxIdleConnections == 0) {
            this.connections.remove(realConnection);
            return true;
        }
        notifyAll();
        return false;
    }

    public synchronized int connectionCount() {
        return this.connections.size();
    }

    /* access modifiers changed from: package-private */
    public Socket deduplicate(Address address, StreamAllocation streamAllocation) {
        for (RealConnection next : this.connections) {
            if (next.isEligible(address, (Route) null) && next.isMultiplexed() && next != streamAllocation.connection()) {
                return streamAllocation.releaseAndAcquire(next);
            }
        }
        return null;
    }

    public void evictAll() {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator<RealConnection> it = this.connections.iterator();
                while (it.hasNext()) {
                    RealConnection next = it.next();
                    if (next.allocations.isEmpty()) {
                        next.noNewStreams = true;
                        arrayList.add(next);
                        it.remove();
                    }
                }
            } finally {
                while (true) {
                }
            }
        }
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            Util.closeQuietly(((RealConnection) obj).socket());
        }
    }

    /* access modifiers changed from: package-private */
    public RealConnection get(Address address, StreamAllocation streamAllocation, Route route) {
        for (RealConnection next : this.connections) {
            if (next.isEligible(address, route)) {
                streamAllocation.acquire(next, true);
                return next;
            }
        }
        return null;
    }

    public synchronized int idleConnectionCount() {
        int i5;
        i5 = 0;
        for (RealConnection realConnection : this.connections) {
            if (realConnection.allocations.isEmpty()) {
                i5++;
            }
        }
        return i5;
    }

    /* access modifiers changed from: package-private */
    public void put(RealConnection realConnection) {
        if (!this.cleanupRunning) {
            this.cleanupRunning = true;
            executor.execute(this.cleanupRunnable);
        }
        this.connections.add(realConnection);
    }

    public ConnectionPool(int i5, long j5, TimeUnit timeUnit) {
        this.cleanupRunnable = new Runnable() {
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r6 = this;
                L_0x0000:
                    com.mbridge.msdk.thrid.okhttp.ConnectionPool r0 = com.mbridge.msdk.thrid.okhttp.ConnectionPool.this
                    long r1 = java.lang.System.nanoTime()
                    long r0 = r0.cleanup(r1)
                    r2 = -1
                    int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r2 != 0) goto L_0x0011
                    return
                L_0x0011:
                    r2 = 0
                    int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r2 <= 0) goto L_0x0000
                    r2 = 1000000(0xf4240, double:4.940656E-318)
                    long r4 = r0 / r2
                    long r2 = r2 * r4
                    long r0 = r0 - r2
                    com.mbridge.msdk.thrid.okhttp.ConnectionPool r2 = com.mbridge.msdk.thrid.okhttp.ConnectionPool.this
                    monitor-enter(r2)
                    com.mbridge.msdk.thrid.okhttp.ConnectionPool r3 = com.mbridge.msdk.thrid.okhttp.ConnectionPool.this     // Catch:{ InterruptedException -> 0x002a }
                    int r0 = (int) r0     // Catch:{ InterruptedException -> 0x002a }
                    r3.wait(r4, r0)     // Catch:{ InterruptedException -> 0x002a }
                    goto L_0x002a
                L_0x0028:
                    r0 = move-exception
                    goto L_0x002c
                L_0x002a:
                    monitor-exit(r2)     // Catch:{ all -> 0x0028 }
                    goto L_0x0000
                L_0x002c:
                    monitor-exit(r2)     // Catch:{ all -> 0x0028 }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.ConnectionPool.AnonymousClass1.run():void");
            }
        };
        this.connections = new ArrayDeque();
        this.routeDatabase = new RouteDatabase();
        this.maxIdleConnections = i5;
        this.keepAliveDurationNs = timeUnit.toNanos(j5);
        if (j5 <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j5);
        }
    }
}
