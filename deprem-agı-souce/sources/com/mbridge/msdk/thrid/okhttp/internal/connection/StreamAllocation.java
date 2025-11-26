package com.mbridge.msdk.thrid.okhttp.internal.connection;

import com.mbridge.msdk.thrid.okhttp.Address;
import com.mbridge.msdk.thrid.okhttp.Call;
import com.mbridge.msdk.thrid.okhttp.ConnectionPool;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.Interceptor;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import com.mbridge.msdk.thrid.okhttp.Route;
import com.mbridge.msdk.thrid.okhttp.internal.Internal;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.connection.RouteSelector;
import com.mbridge.msdk.thrid.okhttp.internal.http.HttpCodec;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

public final class StreamAllocation {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final Address address;
    public final Call call;
    private final Object callStackTrace;
    private boolean canceled;
    private HttpCodec codec;
    private RealConnection connection;
    private final ConnectionPool connectionPool;
    public final EventListener eventListener;
    private int refusedStreamCount;
    private boolean released;
    private boolean reportedAcquired;
    private Route route;
    private RouteSelector.Selection routeSelection;
    private final RouteSelector routeSelector;

    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
        public final Object callStackTrace;

        StreamAllocationReference(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.callStackTrace = obj;
        }
    }

    public StreamAllocation(ConnectionPool connectionPool2, Address address2, Call call2, EventListener eventListener2, Object obj) {
        this.connectionPool = connectionPool2;
        this.address = address2;
        this.call = call2;
        this.eventListener = eventListener2;
        this.routeSelector = new RouteSelector(address2, routeDatabase(), call2, eventListener2);
        this.callStackTrace = obj;
    }

    private Socket deallocate(boolean z4, boolean z5, boolean z6) {
        Socket socket;
        if (z6) {
            this.codec = null;
        }
        if (z5) {
            this.released = true;
        }
        RealConnection realConnection = this.connection;
        if (realConnection != null) {
            if (z4) {
                realConnection.noNewStreams = true;
            }
            if (this.codec == null && (this.released || realConnection.noNewStreams)) {
                release(realConnection);
                if (this.connection.allocations.isEmpty()) {
                    this.connection.idleAtNanos = System.nanoTime();
                    if (Internal.instance.connectionBecameIdle(this.connectionPool, this.connection)) {
                        socket = this.connection.socket();
                        this.connection = null;
                        return socket;
                    }
                }
                socket = null;
                this.connection = null;
                return socket;
            }
        }
        return null;
    }

    private RealConnection findConnection(int i5, int i6, int i7, int i8, boolean z4) throws IOException {
        RealConnection realConnection;
        Socket releaseIfNoNewStreams;
        RealConnection realConnection2;
        Socket socket;
        boolean z5;
        Route route2;
        boolean z6;
        RealConnection realConnection3;
        RouteSelector.Selection selection;
        synchronized (this.connectionPool) {
            try {
                if (this.released) {
                    throw new IllegalStateException("released");
                } else if (this.codec != null) {
                    throw new IllegalStateException("codec != null");
                } else if (!this.canceled) {
                    realConnection = this.connection;
                    releaseIfNoNewStreams = releaseIfNoNewStreams();
                    realConnection2 = this.connection;
                    socket = null;
                    if (realConnection2 != null) {
                        realConnection = null;
                    } else {
                        realConnection2 = null;
                    }
                    if (!this.reportedAcquired) {
                        realConnection = null;
                    }
                    if (realConnection2 == null) {
                        Internal.instance.get(this.connectionPool, this.address, this, (Route) null);
                        RealConnection realConnection4 = this.connection;
                        if (realConnection4 != null) {
                            z5 = true;
                            realConnection2 = realConnection4;
                            route2 = null;
                        } else {
                            route2 = this.route;
                        }
                    } else {
                        route2 = null;
                    }
                    z5 = false;
                } else {
                    throw new IOException("Canceled");
                }
            } finally {
                Throwable th = th;
            }
        }
        Util.closeQuietly(releaseIfNoNewStreams);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (z5) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
        }
        if (realConnection2 != null) {
            this.route = this.connection.route();
            return realConnection2;
        }
        if (route2 != null || ((selection = this.routeSelection) != null && selection.hasNext())) {
            z6 = false;
        } else {
            this.routeSelection = this.routeSelector.next();
            z6 = true;
        }
        synchronized (this.connectionPool) {
            try {
                if (!this.canceled) {
                    if (z6) {
                        List<Route> all = this.routeSelection.getAll();
                        int size = all.size();
                        int i9 = 0;
                        while (true) {
                            if (i9 >= size) {
                                break;
                            }
                            Route route3 = all.get(i9);
                            Internal.instance.get(this.connectionPool, this.address, this, route3);
                            RealConnection realConnection5 = this.connection;
                            if (realConnection5 != null) {
                                this.route = route3;
                                z5 = true;
                                realConnection2 = realConnection5;
                                break;
                            }
                            i9++;
                        }
                    }
                    if (!z5) {
                        if (route2 == null) {
                            route2 = this.routeSelection.next();
                        }
                        this.route = route2;
                        this.refusedStreamCount = 0;
                        realConnection2 = new RealConnection(this.connectionPool, route2);
                        acquire(realConnection2, false);
                    }
                    realConnection3 = realConnection2;
                } else {
                    throw new IOException("Canceled");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z5) {
            this.eventListener.connectionAcquired(this.call, realConnection3);
            return realConnection3;
        }
        realConnection3.connect(i5, i6, i7, i8, z4, this.call, this.eventListener);
        routeDatabase().connected(realConnection3.route());
        synchronized (this.connectionPool) {
            try {
                this.reportedAcquired = true;
                Internal.instance.put(this.connectionPool, realConnection3);
                if (realConnection3.isMultiplexed()) {
                    socket = Internal.instance.deduplicate(this.connectionPool, this.address, this);
                    realConnection3 = this.connection;
                }
            } catch (Throwable th3) {
                while (true) {
                    throw th3;
                }
            }
        }
        Util.closeQuietly(socket);
        this.eventListener.connectionAcquired(this.call, realConnection3);
        return realConnection3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        if (r0.isHealthy(r10) != false) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection findHealthyConnection(int r5, int r6, int r7, int r8, boolean r9, boolean r10) throws java.io.IOException {
        /*
            r4 = this;
        L_0x0000:
            com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection r0 = r4.findConnection(r5, r6, r7, r8, r9)
            r1 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            com.mbridge.msdk.thrid.okhttp.ConnectionPool r2 = r5.connectionPool
            monitor-enter(r2)
            int r3 = r0.successCount     // Catch:{ all -> 0x0019 }
            if (r3 != 0) goto L_0x001c
            boolean r3 = r0.isMultiplexed()     // Catch:{ all -> 0x0019 }
            if (r3 != 0) goto L_0x001c
            monitor-exit(r2)     // Catch:{ all -> 0x0019 }
            return r0
        L_0x0019:
            r0 = move-exception
            r6 = r0
            goto L_0x002d
        L_0x001c:
            monitor-exit(r2)     // Catch:{ all -> 0x0019 }
            boolean r2 = r0.isHealthy(r10)
            if (r2 != 0) goto L_0x002c
            r4.noNewStreams()
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r1
            goto L_0x0000
        L_0x002c:
            return r0
        L_0x002d:
            monitor-exit(r2)     // Catch:{ all -> 0x0019 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.connection.StreamAllocation.findHealthyConnection(int, int, int, int, boolean, boolean):com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection");
    }

    private Socket releaseIfNoNewStreams() {
        RealConnection realConnection = this.connection;
        if (realConnection == null || !realConnection.noNewStreams) {
            return null;
        }
        return deallocate(false, false, true);
    }

    private RouteDatabase routeDatabase() {
        return Internal.instance.routeDatabase(this.connectionPool);
    }

    public void acquire(RealConnection realConnection, boolean z4) {
        if (this.connection == null) {
            this.connection = realConnection;
            this.reportedAcquired = z4;
            realConnection.allocations.add(new StreamAllocationReference(this, this.callStackTrace));
            return;
        }
        throw new IllegalStateException();
    }

    public void cancel() {
        HttpCodec httpCodec;
        RealConnection realConnection;
        synchronized (this.connectionPool) {
            this.canceled = true;
            httpCodec = this.codec;
            realConnection = this.connection;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    public HttpCodec codec() {
        HttpCodec httpCodec;
        synchronized (this.connectionPool) {
            httpCodec = this.codec;
        }
        return httpCodec;
    }

    public synchronized RealConnection connection() {
        return this.connection;
    }

    public boolean hasMoreRoutes() {
        if (this.route != null) {
            return true;
        }
        RouteSelector.Selection selection = this.routeSelection;
        if ((selection == null || !selection.hasNext()) && !this.routeSelector.hasNext()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: finally extract failed */
    public HttpCodec newStream(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z4) {
        try {
            HttpCodec newCodec = findHealthyConnection(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z4).newCodec(okHttpClient, chain, this);
            synchronized (this.connectionPool) {
                this.codec = newCodec;
            }
            return newCodec;
        } catch (IOException e5) {
            throw new RouteException(e5);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void noNewStreams() {
        RealConnection realConnection;
        Socket deallocate;
        synchronized (this.connectionPool) {
            realConnection = this.connection;
            deallocate = deallocate(true, false, false);
            if (this.connection != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
    }

    public void release() {
        RealConnection realConnection;
        Socket deallocate;
        synchronized (this.connectionPool) {
            realConnection = this.connection;
            deallocate = deallocate(false, true, false);
            if (this.connection != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null) {
            Internal.instance.timeoutExit(this.call, (IOException) null);
            this.eventListener.connectionReleased(this.call, realConnection);
            this.eventListener.callEnd(this.call);
        }
    }

    public Socket releaseAndAcquire(RealConnection realConnection) {
        if (this.codec == null && this.connection.allocations.size() == 1) {
            Socket deallocate = deallocate(true, false, false);
            this.connection = realConnection;
            realConnection.allocations.add(this.connection.allocations.get(0));
            return deallocate;
        }
        throw new IllegalStateException();
    }

    public Route route() {
        return this.route;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0053 A[Catch:{ all -> 0x001c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void streamFailed(java.io.IOException r7) {
        /*
            r6 = this;
            com.mbridge.msdk.thrid.okhttp.ConnectionPool r0 = r6.connectionPool
            monitor-enter(r0)
            boolean r1 = r7 instanceof com.mbridge.msdk.thrid.okhttp.internal.http2.StreamResetException     // Catch:{ all -> 0x001c }
            r2 = 0
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0025
            com.mbridge.msdk.thrid.okhttp.internal.http2.StreamResetException r7 = (com.mbridge.msdk.thrid.okhttp.internal.http2.StreamResetException) r7     // Catch:{ all -> 0x001c }
            com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode r7 = r7.errorCode     // Catch:{ all -> 0x001c }
            com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode r1 = com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x001c }
            if (r7 != r1) goto L_0x001e
            int r7 = r6.refusedStreamCount     // Catch:{ all -> 0x001c }
            int r7 = r7 + r3
            r6.refusedStreamCount = r7     // Catch:{ all -> 0x001c }
            if (r7 <= r3) goto L_0x0048
            r6.route = r2     // Catch:{ all -> 0x001c }
            goto L_0x0046
        L_0x001c:
            r7 = move-exception
            goto L_0x0067
        L_0x001e:
            com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode r1 = com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode.CANCEL     // Catch:{ all -> 0x001c }
            if (r7 == r1) goto L_0x0048
            r6.route = r2     // Catch:{ all -> 0x001c }
            goto L_0x0046
        L_0x0025:
            com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection r1 = r6.connection     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x0048
            boolean r1 = r1.isMultiplexed()     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x0033
            boolean r1 = r7 instanceof com.mbridge.msdk.thrid.okhttp.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x0048
        L_0x0033:
            com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection r1 = r6.connection     // Catch:{ all -> 0x001c }
            int r1 = r1.successCount     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0046
            com.mbridge.msdk.thrid.okhttp.Route r1 = r6.route     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x0044
            if (r7 == 0) goto L_0x0044
            com.mbridge.msdk.thrid.okhttp.internal.connection.RouteSelector r5 = r6.routeSelector     // Catch:{ all -> 0x001c }
            r5.connectFailed(r1, r7)     // Catch:{ all -> 0x001c }
        L_0x0044:
            r6.route = r2     // Catch:{ all -> 0x001c }
        L_0x0046:
            r7 = r3
            goto L_0x0049
        L_0x0048:
            r7 = r4
        L_0x0049:
            com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection r1 = r6.connection     // Catch:{ all -> 0x001c }
            java.net.Socket r7 = r6.deallocate(r7, r4, r3)     // Catch:{ all -> 0x001c }
            com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection r3 = r6.connection     // Catch:{ all -> 0x001c }
            if (r3 != 0) goto L_0x0059
            boolean r3 = r6.reportedAcquired     // Catch:{ all -> 0x001c }
            if (r3 != 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r2 = r1
        L_0x0059:
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            com.mbridge.msdk.thrid.okhttp.internal.Util.closeQuietly((java.net.Socket) r7)
            if (r2 == 0) goto L_0x0066
            com.mbridge.msdk.thrid.okhttp.EventListener r7 = r6.eventListener
            com.mbridge.msdk.thrid.okhttp.Call r0 = r6.call
            r7.connectionReleased(r0, r2)
        L_0x0066:
            return
        L_0x0067:
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.connection.StreamAllocation.streamFailed(java.io.IOException):void");
    }

    public void streamFinished(boolean z4, HttpCodec httpCodec, long j5, IOException iOException) {
        RealConnection realConnection;
        Socket deallocate;
        boolean z5;
        this.eventListener.responseBodyEnd(this.call, j5);
        synchronized (this.connectionPool) {
            if (httpCodec != null) {
                try {
                    if (httpCodec == this.codec) {
                        if (!z4) {
                            this.connection.successCount++;
                        }
                        realConnection = this.connection;
                        deallocate = deallocate(z4, false, true);
                        if (this.connection != null) {
                            realConnection = null;
                        }
                        z5 = this.released;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new IllegalStateException("expected " + this.codec + " but was " + httpCodec);
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (iOException != null) {
            this.eventListener.callFailed(this.call, Internal.instance.timeoutExit(this.call, iOException));
        } else if (z5) {
            Internal.instance.timeoutExit(this.call, (IOException) null);
            this.eventListener.callEnd(this.call);
        }
    }

    public String toString() {
        RealConnection connection2 = connection();
        if (connection2 != null) {
            return connection2.toString();
        }
        return this.address.toString();
    }

    private void release(RealConnection realConnection) {
        int size = realConnection.allocations.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (realConnection.allocations.get(i5).get() == this) {
                realConnection.allocations.remove(i5);
                return;
            }
        }
        throw new IllegalStateException();
    }
}
