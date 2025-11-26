package com.mbridge.msdk.thrid.okhttp;

import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.cache.CacheInterceptor;
import com.mbridge.msdk.thrid.okhttp.internal.connection.ConnectInterceptor;
import com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection;
import com.mbridge.msdk.thrid.okhttp.internal.connection.StreamAllocation;
import com.mbridge.msdk.thrid.okhttp.internal.http.BridgeInterceptor;
import com.mbridge.msdk.thrid.okhttp.internal.http.CallServerInterceptor;
import com.mbridge.msdk.thrid.okhttp.internal.http.HttpCodec;
import com.mbridge.msdk.thrid.okhttp.internal.http.RealInterceptorChain;
import com.mbridge.msdk.thrid.okhttp.internal.http.RetryAndFollowUpInterceptor;
import com.mbridge.msdk.thrid.okhttp.internal.platform.Platform;
import com.mbridge.msdk.thrid.okio.AsyncTimeout;
import com.mbridge.msdk.thrid.okio.Timeout;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

final class RealCall implements Call {
    final OkHttpClient client;
    /* access modifiers changed from: private */
    public EventListener eventListener;
    private boolean executed;
    final boolean forWebSocket;
    final Request originalRequest;
    final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
    final AsyncTimeout timeout;

    final class AsyncCall extends NamedRunnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Callback responseCallback;

        AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.redactedUrl());
            this.responseCallback = callback;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0037 A[Catch:{ all -> 0x0055 }] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0060 A[Catch:{ all -> 0x0055 }] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0080 A[Catch:{ all -> 0x0055 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r5 = this;
                com.mbridge.msdk.thrid.okhttp.RealCall r0 = com.mbridge.msdk.thrid.okhttp.RealCall.this
                com.mbridge.msdk.thrid.okio.AsyncTimeout r0 = r0.timeout
                r0.enter()
                r0 = 0
                com.mbridge.msdk.thrid.okhttp.RealCall r1 = com.mbridge.msdk.thrid.okhttp.RealCall.this     // Catch:{ IOException -> 0x002b, all -> 0x0026 }
                com.mbridge.msdk.thrid.okhttp.Response r0 = r1.getResponseWithInterceptorChain()     // Catch:{ IOException -> 0x002b, all -> 0x0026 }
                r1 = 1
                com.mbridge.msdk.thrid.okhttp.Callback r2 = r5.responseCallback     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
                com.mbridge.msdk.thrid.okhttp.RealCall r3 = com.mbridge.msdk.thrid.okhttp.RealCall.this     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
                r2.onResponse(r3, r0)     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
            L_0x0016:
                com.mbridge.msdk.thrid.okhttp.RealCall r0 = com.mbridge.msdk.thrid.okhttp.RealCall.this
                com.mbridge.msdk.thrid.okhttp.OkHttpClient r0 = r0.client
                com.mbridge.msdk.thrid.okhttp.Dispatcher r0 = r0.dispatcher()
                r0.finished((com.mbridge.msdk.thrid.okhttp.RealCall.AsyncCall) r5)
                return
            L_0x0022:
                r0 = move-exception
                goto L_0x0030
            L_0x0024:
                r0 = move-exception
                goto L_0x0058
            L_0x0026:
                r1 = move-exception
                r4 = r1
                r1 = r0
                r0 = r4
                goto L_0x0030
            L_0x002b:
                r1 = move-exception
                r4 = r1
                r1 = r0
                r0 = r4
                goto L_0x0058
            L_0x0030:
                com.mbridge.msdk.thrid.okhttp.RealCall r2 = com.mbridge.msdk.thrid.okhttp.RealCall.this     // Catch:{ all -> 0x0055 }
                r2.cancel()     // Catch:{ all -> 0x0055 }
                if (r1 != 0) goto L_0x0057
                java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x0055 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0055 }
                r2.<init>()     // Catch:{ all -> 0x0055 }
                java.lang.String r3 = "canceled due to "
                r2.append(r3)     // Catch:{ all -> 0x0055 }
                r2.append(r0)     // Catch:{ all -> 0x0055 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0055 }
                r1.<init>(r2)     // Catch:{ all -> 0x0055 }
                com.mbridge.msdk.thrid.okhttp.Callback r2 = r5.responseCallback     // Catch:{ all -> 0x0055 }
                com.mbridge.msdk.thrid.okhttp.RealCall r3 = com.mbridge.msdk.thrid.okhttp.RealCall.this     // Catch:{ all -> 0x0055 }
                r2.onFailure(r3, r1)     // Catch:{ all -> 0x0055 }
                goto L_0x0057
            L_0x0055:
                r0 = move-exception
                goto L_0x0093
            L_0x0057:
                throw r0     // Catch:{ all -> 0x0055 }
            L_0x0058:
                com.mbridge.msdk.thrid.okhttp.RealCall r2 = com.mbridge.msdk.thrid.okhttp.RealCall.this     // Catch:{ all -> 0x0055 }
                java.io.IOException r0 = r2.timeoutExit(r0)     // Catch:{ all -> 0x0055 }
                if (r1 == 0) goto L_0x0080
                com.mbridge.msdk.thrid.okhttp.internal.platform.Platform r1 = com.mbridge.msdk.thrid.okhttp.internal.platform.Platform.get()     // Catch:{ all -> 0x0055 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0055 }
                r2.<init>()     // Catch:{ all -> 0x0055 }
                java.lang.String r3 = "Callback failure for "
                r2.append(r3)     // Catch:{ all -> 0x0055 }
                com.mbridge.msdk.thrid.okhttp.RealCall r3 = com.mbridge.msdk.thrid.okhttp.RealCall.this     // Catch:{ all -> 0x0055 }
                java.lang.String r3 = r3.toLoggableString()     // Catch:{ all -> 0x0055 }
                r2.append(r3)     // Catch:{ all -> 0x0055 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0055 }
                r3 = 4
                r1.log(r3, r2, r0)     // Catch:{ all -> 0x0055 }
                goto L_0x0016
            L_0x0080:
                com.mbridge.msdk.thrid.okhttp.RealCall r1 = com.mbridge.msdk.thrid.okhttp.RealCall.this     // Catch:{ all -> 0x0055 }
                com.mbridge.msdk.thrid.okhttp.EventListener r1 = r1.eventListener     // Catch:{ all -> 0x0055 }
                com.mbridge.msdk.thrid.okhttp.RealCall r2 = com.mbridge.msdk.thrid.okhttp.RealCall.this     // Catch:{ all -> 0x0055 }
                r1.callFailed(r2, r0)     // Catch:{ all -> 0x0055 }
                com.mbridge.msdk.thrid.okhttp.Callback r1 = r5.responseCallback     // Catch:{ all -> 0x0055 }
                com.mbridge.msdk.thrid.okhttp.RealCall r2 = com.mbridge.msdk.thrid.okhttp.RealCall.this     // Catch:{ all -> 0x0055 }
                r1.onFailure(r2, r0)     // Catch:{ all -> 0x0055 }
                goto L_0x0016
            L_0x0093:
                com.mbridge.msdk.thrid.okhttp.RealCall r1 = com.mbridge.msdk.thrid.okhttp.RealCall.this
                com.mbridge.msdk.thrid.okhttp.OkHttpClient r1 = r1.client
                com.mbridge.msdk.thrid.okhttp.Dispatcher r1 = r1.dispatcher()
                r1.finished((com.mbridge.msdk.thrid.okhttp.RealCall.AsyncCall) r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.RealCall.AsyncCall.execute():void");
        }

        /* access modifiers changed from: package-private */
        public void executeOn(ExecutorService executorService) {
            try {
                executorService.execute(this);
            } catch (RejectedExecutionException e5) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e5);
                RealCall.this.eventListener.callFailed(RealCall.this, interruptedIOException);
                this.responseCallback.onFailure(RealCall.this, interruptedIOException);
                RealCall.this.client.dispatcher().finished(this);
            } catch (Throwable th) {
                RealCall.this.client.dispatcher().finished(this);
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public RealCall get() {
            return RealCall.this;
        }

        /* access modifiers changed from: package-private */
        public String host() {
            return RealCall.this.originalRequest.url().host();
        }

        /* access modifiers changed from: package-private */
        public Request request() {
            return RealCall.this.originalRequest;
        }
    }

    private RealCall(OkHttpClient okHttpClient, Request request, boolean z4) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z4;
        this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(okHttpClient, z4);
        AnonymousClass1 r42 = new AsyncTimeout() {
            /* access modifiers changed from: protected */
            public void timedOut() {
                RealCall.this.cancel();
            }
        };
        this.timeout = r42;
        r42.timeout((long) okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    private void captureCallStackTrace() {
        this.retryAndFollowUpInterceptor.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    static RealCall newRealCall(OkHttpClient okHttpClient, Request request, boolean z4) {
        RealCall realCall = new RealCall(okHttpClient, request, z4);
        realCall.eventListener = okHttpClient.eventListenerFactory().create(realCall);
        return realCall;
    }

    public void cancel() {
        this.retryAndFollowUpInterceptor.cancel();
    }

    public void enqueue(Callback callback) {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        captureCallStackTrace();
        this.eventListener.callStart(this);
        this.client.dispatcher().enqueue(new AsyncCall(callback));
    }

    public Response execute() throws IOException {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        captureCallStackTrace();
        this.timeout.enter();
        this.eventListener.callStart(this);
        try {
            this.client.dispatcher().executed(this);
            Response responseWithInterceptorChain = getResponseWithInterceptorChain();
            if (responseWithInterceptorChain != null) {
                this.client.dispatcher().finished(this);
                return responseWithInterceptorChain;
            }
            throw new IOException("Canceled");
        } catch (IOException e5) {
            IOException timeoutExit = timeoutExit(e5);
            this.eventListener.callFailed(this, timeoutExit);
            throw timeoutExit;
        } catch (Throwable th) {
            this.client.dispatcher().finished(this);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public Response getResponseWithInterceptorChain() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.client.interceptors());
        arrayList.add(this.retryAndFollowUpInterceptor);
        arrayList.add(new BridgeInterceptor(this.client.cookieJar()));
        arrayList.add(new CacheInterceptor(this.client.internalCache()));
        arrayList.add(new ConnectInterceptor(this.client));
        if (!this.forWebSocket) {
            arrayList.addAll(this.client.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.forWebSocket));
        Response proceed = new RealInterceptorChain(arrayList, (StreamAllocation) null, (HttpCodec) null, (RealConnection) null, 0, this.originalRequest, this, this.eventListener, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
        if (!this.retryAndFollowUpInterceptor.isCanceled()) {
            return proceed;
        }
        Util.closeQuietly((Closeable) proceed);
        throw new IOException("Canceled");
    }

    public boolean isCanceled() {
        return this.retryAndFollowUpInterceptor.isCanceled();
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    /* access modifiers changed from: package-private */
    public String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    public Request request() {
        return this.originalRequest;
    }

    /* access modifiers changed from: package-private */
    public StreamAllocation streamAllocation() {
        return this.retryAndFollowUpInterceptor.streamAllocation();
    }

    public Timeout timeout() {
        return this.timeout;
    }

    /* access modifiers changed from: package-private */
    public IOException timeoutExit(IOException iOException) {
        if (!this.timeout.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* access modifiers changed from: package-private */
    public String toLoggableString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (isCanceled()) {
            str = "canceled ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.forWebSocket) {
            str2 = "web socket";
        } else {
            str2 = NotificationCompat.CATEGORY_CALL;
        }
        sb.append(str2);
        sb.append(" to ");
        sb.append(redactedUrl());
        return sb.toString();
    }

    public RealCall clone() {
        return newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }
}
