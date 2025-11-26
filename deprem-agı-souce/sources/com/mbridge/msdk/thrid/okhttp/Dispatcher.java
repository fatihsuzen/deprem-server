package com.mbridge.msdk.thrid.okhttp;

import com.mbridge.msdk.thrid.okhttp.RealCall;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import j$.util.DesugarCollections;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class Dispatcher {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ExecutorService executorService;
    private Runnable idleCallback;
    private int maxRequests = 64;
    private int maxRequestsPerHost = 5;
    private final Deque<RealCall.AsyncCall> readyAsyncCalls = new ArrayDeque();
    private final Deque<RealCall.AsyncCall> runningAsyncCalls = new ArrayDeque();
    private final Deque<RealCall> runningSyncCalls = new ArrayDeque();

    public Dispatcher(ExecutorService executorService2) {
        this.executorService = executorService2;
    }

    private boolean promoteAndExecute() {
        int i5;
        boolean z4;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator<RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    RealCall.AsyncCall next = it.next();
                    if (this.runningAsyncCalls.size() >= this.maxRequests) {
                        break;
                    } else if (runningCallsForHost(next) < this.maxRequestsPerHost) {
                        it.remove();
                        arrayList.add(next);
                        this.runningAsyncCalls.add(next);
                    }
                }
                if (runningCallsCount() > 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
            } finally {
                while (true) {
                }
            }
        }
        int size = arrayList.size();
        for (i5 = 0; i5 < size; i5++) {
            ((RealCall.AsyncCall) arrayList.get(i5)).executeOn(executorService());
        }
        return z4;
    }

    private int runningCallsForHost(RealCall.AsyncCall asyncCall) {
        int i5 = 0;
        for (RealCall.AsyncCall next : this.runningAsyncCalls) {
            if (!next.get().forWebSocket && next.host().equals(asyncCall.host())) {
                i5++;
            }
        }
        return i5;
    }

    public synchronized void cancelAll() {
        try {
            for (RealCall.AsyncCall asyncCall : this.readyAsyncCalls) {
                asyncCall.get().cancel();
            }
            for (RealCall.AsyncCall asyncCall2 : this.runningAsyncCalls) {
                asyncCall2.get().cancel();
            }
            for (RealCall cancel : this.runningSyncCalls) {
                cancel.cancel();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void enqueue(RealCall.AsyncCall asyncCall) {
        synchronized (this) {
            this.readyAsyncCalls.add(asyncCall);
        }
        promoteAndExecute();
    }

    /* access modifiers changed from: package-private */
    public synchronized void executed(RealCall realCall) {
        this.runningSyncCalls.add(realCall);
    }

    public synchronized ExecutorService executorService() {
        try {
            if (this.executorService == null) {
                this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.executorService;
    }

    /* access modifiers changed from: package-private */
    public void finished(RealCall.AsyncCall asyncCall) {
        finished(this.runningAsyncCalls, asyncCall);
    }

    public synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public synchronized List<Call> queuedCalls() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (RealCall.AsyncCall asyncCall : this.readyAsyncCalls) {
                arrayList.add(asyncCall.get());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    public synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    public synchronized List<Call> runningCalls() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            arrayList.addAll(this.runningSyncCalls);
            for (RealCall.AsyncCall asyncCall : this.runningAsyncCalls) {
                arrayList.add(asyncCall.get());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    public synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public synchronized void setIdleCallback(Runnable runnable) {
        this.idleCallback = runnable;
    }

    public void setMaxRequests(int i5) {
        if (i5 >= 1) {
            synchronized (this) {
                this.maxRequests = i5;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException("max < 1: " + i5);
    }

    public void setMaxRequestsPerHost(int i5) {
        if (i5 >= 1) {
            synchronized (this) {
                this.maxRequestsPerHost = i5;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException("max < 1: " + i5);
    }

    /* access modifiers changed from: package-private */
    public void finished(RealCall realCall) {
        finished(this.runningSyncCalls, realCall);
    }

    private <T> void finished(Deque<T> deque, T t5) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t5)) {
                runnable = this.idleCallback;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!promoteAndExecute() && runnable != null) {
            runnable.run();
        }
    }

    public Dispatcher() {
    }
}
