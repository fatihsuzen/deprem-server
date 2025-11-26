package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okhttp.Headers;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.http2.Header;
import com.mbridge.msdk.thrid.okio.AsyncTimeout;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.Sink;
import com.mbridge.msdk.thrid.okio.Source;
import com.mbridge.msdk.thrid.okio.Timeout;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public final class Http2Stream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long bytesLeftInWriteWindow;
    final Http2Connection connection;
    ErrorCode errorCode;
    private boolean hasResponseHeaders;
    /* access modifiers changed from: private */
    public Header.Listener headersListener;
    /* access modifiers changed from: private */
    public final Deque<Headers> headersQueue;
    final int id;
    final StreamTimeout readTimeout;
    final FramingSink sink;
    private final FramingSource source;
    long unacknowledgedBytesRead = 0;
    final StreamTimeout writeTimeout;

    final class FramingSink implements Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long EMIT_BUFFER_SIZE = 16384;
        boolean closed;
        boolean finished;
        private final Buffer sendBuffer = new Buffer();

        FramingSink() {
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r0.writeTimeout.exitAndThrowIfTimedOut();
            r12.this$0.checkOutNotClosed();
            r10 = java.lang.Math.min(r12.this$0.bytesLeftInWriteWindow, r12.sendBuffer.size());
            r0 = r12.this$0;
            r0.bytesLeftInWriteWindow -= r10;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void emitFrame(boolean r13) throws java.io.IOException {
            /*
                r12 = this;
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r1 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this
                monitor-enter(r1)
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x007b }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream$StreamTimeout r0 = r0.writeTimeout     // Catch:{ all -> 0x007b }
                r0.enter()     // Catch:{ all -> 0x007b }
            L_0x000a:
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0024 }
                long r2 = r0.bytesLeftInWriteWindow     // Catch:{ all -> 0x0024 }
                r4 = 0
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 > 0) goto L_0x0027
                boolean r2 = r12.finished     // Catch:{ all -> 0x0024 }
                if (r2 != 0) goto L_0x0027
                boolean r2 = r12.closed     // Catch:{ all -> 0x0024 }
                if (r2 != 0) goto L_0x0027
                com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode r2 = r0.errorCode     // Catch:{ all -> 0x0024 }
                if (r2 != 0) goto L_0x0027
                r0.waitForIo()     // Catch:{ all -> 0x0024 }
                goto L_0x000a
            L_0x0024:
                r0 = move-exception
                r13 = r0
                goto L_0x007e
            L_0x0027:
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream$StreamTimeout r0 = r0.writeTimeout     // Catch:{ all -> 0x007b }
                r0.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x007b }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x007b }
                r0.checkOutNotClosed()     // Catch:{ all -> 0x007b }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x007b }
                long r2 = r0.bytesLeftInWriteWindow     // Catch:{ all -> 0x007b }
                com.mbridge.msdk.thrid.okio.Buffer r0 = r12.sendBuffer     // Catch:{ all -> 0x007b }
                long r4 = r0.size()     // Catch:{ all -> 0x007b }
                long r10 = java.lang.Math.min(r2, r4)     // Catch:{ all -> 0x007b }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x007b }
                long r2 = r0.bytesLeftInWriteWindow     // Catch:{ all -> 0x007b }
                long r2 = r2 - r10
                r0.bytesLeftInWriteWindow = r2     // Catch:{ all -> 0x007b }
                monitor-exit(r1)     // Catch:{ all -> 0x007b }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream$StreamTimeout r0 = r0.writeTimeout
                r0.enter()
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0061 }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r6 = r0.connection     // Catch:{ all -> 0x0061 }
                int r7 = r0.id     // Catch:{ all -> 0x0061 }
                if (r13 == 0) goto L_0x0064
                com.mbridge.msdk.thrid.okio.Buffer r13 = r12.sendBuffer     // Catch:{ all -> 0x0061 }
                long r0 = r13.size()     // Catch:{ all -> 0x0061 }
                int r13 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r13 != 0) goto L_0x0064
                r13 = 1
            L_0x005f:
                r8 = r13
                goto L_0x0066
            L_0x0061:
                r0 = move-exception
                r13 = r0
                goto L_0x0073
            L_0x0064:
                r13 = 0
                goto L_0x005f
            L_0x0066:
                com.mbridge.msdk.thrid.okio.Buffer r9 = r12.sendBuffer     // Catch:{ all -> 0x0061 }
                r6.writeData(r7, r8, r9, r10)     // Catch:{ all -> 0x0061 }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r13 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream$StreamTimeout r13 = r13.writeTimeout
                r13.exitAndThrowIfTimedOut()
                return
            L_0x0073:
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream$StreamTimeout r0 = r0.writeTimeout
                r0.exitAndThrowIfTimedOut()
                throw r13
            L_0x007b:
                r0 = move-exception
                r13 = r0
                goto L_0x0086
            L_0x007e:
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x007b }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream$StreamTimeout r0 = r0.writeTimeout     // Catch:{ all -> 0x007b }
                r0.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x007b }
                throw r13     // Catch:{ all -> 0x007b }
            L_0x0086:
                monitor-exit(r1)     // Catch:{ all -> 0x007b }
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.FramingSink.emitFrame(boolean):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
            if (r8.this$0.sink.finished != false) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
            if (r8.sendBuffer.size() <= 0) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
            if (r8.sendBuffer.size() <= 0) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
            emitFrame(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
            r0 = r8.this$0;
            r0.connection.writeData(r0.id, true, (com.mbridge.msdk.thrid.okio.Buffer) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
            r2 = r8.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r8.closed = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
            r8.this$0.connection.flush();
            r8.this$0.cancelStreamIfNecessary();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r8 = this;
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r1 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this
                monitor-enter(r1)
                boolean r0 = r8.closed     // Catch:{ all -> 0x0009 }
                if (r0 == 0) goto L_0x000b
                monitor-exit(r1)     // Catch:{ all -> 0x0009 }
                return
            L_0x0009:
                r0 = move-exception
                goto L_0x0052
            L_0x000b:
                monitor-exit(r1)     // Catch:{ all -> 0x0009 }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream$FramingSink r0 = r0.sink
                boolean r0 = r0.finished
                r1 = 1
                if (r0 != 0) goto L_0x003c
                com.mbridge.msdk.thrid.okio.Buffer r0 = r8.sendBuffer
                long r2 = r0.size()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x002f
            L_0x0021:
                com.mbridge.msdk.thrid.okio.Buffer r0 = r8.sendBuffer
                long r2 = r0.size()
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x003c
                r8.emitFrame(r1)
                goto L_0x0021
            L_0x002f:
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r2 = r0.connection
                int r3 = r0.id
                r5 = 0
                r6 = 0
                r4 = 1
                r2.writeData(r3, r4, r5, r6)
            L_0x003c:
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r2 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this
                monitor-enter(r2)
                r8.closed = r1     // Catch:{ all -> 0x004f }
                monitor-exit(r2)     // Catch:{ all -> 0x004f }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r0 = r0.connection
                r0.flush()
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this
                r0.cancelStreamIfNecessary()
                return
            L_0x004f:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x004f }
                throw r0
            L_0x0052:
                monitor-exit(r1)     // Catch:{ all -> 0x0009 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.FramingSink.close():void");
        }

        public void flush() throws IOException {
            synchronized (Http2Stream.this) {
                Http2Stream.this.checkOutNotClosed();
            }
            while (this.sendBuffer.size() > 0) {
                emitFrame(false);
                Http2Stream.this.connection.flush();
            }
        }

        public Timeout timeout() {
            return Http2Stream.this.writeTimeout;
        }

        public void write(Buffer buffer, long j5) throws IOException {
            this.sendBuffer.write(buffer, j5);
            while (this.sendBuffer.size() >= EMIT_BUFFER_SIZE) {
                emitFrame(false);
            }
        }
    }

    private final class FramingSource implements Source {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        boolean closed;
        boolean finished;
        private final long maxByteCount;
        private final Buffer readBuffer = new Buffer();
        private final Buffer receiveBuffer = new Buffer();

        FramingSource(long j5) {
            this.maxByteCount = j5;
        }

        private void updateConnectionFlowControl(long j5) {
            Http2Stream.this.connection.updateConnectionFlowControl(j5);
        }

        public void close() throws IOException {
            long size;
            Header.Listener listener;
            ArrayList arrayList;
            synchronized (Http2Stream.this) {
                try {
                    this.closed = true;
                    size = this.readBuffer.size();
                    this.readBuffer.clear();
                    if (Http2Stream.this.headersQueue.isEmpty() || Http2Stream.this.headersListener == null) {
                        arrayList = null;
                        listener = null;
                    } else {
                        arrayList = new ArrayList(Http2Stream.this.headersQueue);
                        Http2Stream.this.headersQueue.clear();
                        listener = Http2Stream.this.headersListener;
                    }
                    Http2Stream.this.notifyAll();
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (size > 0) {
                updateConnectionFlowControl(size);
            }
            Http2Stream.this.cancelStreamIfNecessary();
            if (listener != null) {
                int size2 = arrayList.size();
                int i5 = 0;
                while (i5 < size2) {
                    Object obj = arrayList.get(i5);
                    i5++;
                    listener.onHeaders((Headers) obj);
                }
            }
        }

        /* JADX INFO: finally extract failed */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.mbridge.msdk.thrid.okhttp.Headers} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long read(com.mbridge.msdk.thrid.okio.Buffer r18, long r19) throws java.io.IOException {
            /*
                r17 = this;
                r1 = r17
                r2 = r19
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 < 0) goto L_0x00e9
            L_0x000a:
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r6 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this
                monitor-enter(r6)
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x00b1 }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream$StreamTimeout r0 = r0.readTimeout     // Catch:{ all -> 0x00b1 }
                r0.enter()     // Catch:{ all -> 0x00b1 }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x004c }
                com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode r7 = r0.errorCode     // Catch:{ all -> 0x004c }
                if (r7 == 0) goto L_0x001b
                goto L_0x001c
            L_0x001b:
                r7 = 0
            L_0x001c:
                boolean r9 = r1.closed     // Catch:{ all -> 0x004c }
                if (r9 != 0) goto L_0x00d7
                java.util.Deque r0 = r0.headersQueue     // Catch:{ all -> 0x004c }
                boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x004c }
                if (r0 != 0) goto L_0x004f
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x004c }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Header$Listener r0 = r0.headersListener     // Catch:{ all -> 0x004c }
                if (r0 == 0) goto L_0x004f
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x004c }
                java.util.Deque r0 = r0.headersQueue     // Catch:{ all -> 0x004c }
                java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x004c }
                r8 = r0
                com.mbridge.msdk.thrid.okhttp.Headers r8 = (com.mbridge.msdk.thrid.okhttp.Headers) r8     // Catch:{ all -> 0x004c }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x004c }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Header$Listener r0 = r0.headersListener     // Catch:{ all -> 0x004c }
                r12 = r18
                r10 = -1
                r15 = -1
                goto L_0x00b5
            L_0x004c:
                r0 = move-exception
                goto L_0x00df
            L_0x004f:
                com.mbridge.msdk.thrid.okio.Buffer r0 = r1.readBuffer     // Catch:{ all -> 0x004c }
                long r10 = r0.size()     // Catch:{ all -> 0x004c }
                int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x0098
                com.mbridge.msdk.thrid.okio.Buffer r0 = r1.readBuffer     // Catch:{ all -> 0x004c }
                long r10 = r0.size()     // Catch:{ all -> 0x004c }
                long r10 = java.lang.Math.min(r2, r10)     // Catch:{ all -> 0x004c }
                r12 = r18
                long r10 = r0.read(r12, r10)     // Catch:{ all -> 0x004c }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x004c }
                long r13 = r0.unacknowledgedBytesRead     // Catch:{ all -> 0x004c }
                long r13 = r13 + r10
                r0.unacknowledgedBytesRead = r13     // Catch:{ all -> 0x004c }
                if (r7 != 0) goto L_0x0093
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r0 = r0.connection     // Catch:{ all -> 0x004c }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Settings r0 = r0.okHttpSettings     // Catch:{ all -> 0x004c }
                int r0 = r0.getInitialWindowSize()     // Catch:{ all -> 0x004c }
                int r0 = r0 / 2
                r15 = -1
                long r8 = (long) r0     // Catch:{ all -> 0x004c }
                int r0 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
                if (r0 < 0) goto L_0x0095
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x004c }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r8 = r0.connection     // Catch:{ all -> 0x004c }
                int r9 = r0.id     // Catch:{ all -> 0x004c }
                long r13 = r0.unacknowledgedBytesRead     // Catch:{ all -> 0x004c }
                r8.writeWindowUpdateLater(r9, r13)     // Catch:{ all -> 0x004c }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x004c }
                r0.unacknowledgedBytesRead = r4     // Catch:{ all -> 0x004c }
                goto L_0x0095
            L_0x0093:
                r15 = -1
            L_0x0095:
                r0 = 0
                r8 = 0
                goto L_0x00b5
            L_0x0098:
                r12 = r18
                r15 = -1
                boolean r0 = r1.finished     // Catch:{ all -> 0x004c }
                if (r0 != 0) goto L_0x00b3
                if (r7 != 0) goto L_0x00b3
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x004c }
                r0.waitForIo()     // Catch:{ all -> 0x004c }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x00b1 }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream$StreamTimeout r0 = r0.readTimeout     // Catch:{ all -> 0x00b1 }
                r0.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x00b1 }
                monitor-exit(r6)     // Catch:{ all -> 0x00b1 }
                goto L_0x000a
            L_0x00b1:
                r0 = move-exception
                goto L_0x00e7
            L_0x00b3:
                r10 = r15
                goto L_0x0095
            L_0x00b5:
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r9 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x00b1 }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream$StreamTimeout r9 = r9.readTimeout     // Catch:{ all -> 0x00b1 }
                r9.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x00b1 }
                monitor-exit(r6)     // Catch:{ all -> 0x00b1 }
                if (r8 == 0) goto L_0x00c6
                if (r0 == 0) goto L_0x00c6
                r0.onHeaders(r8)
                goto L_0x000a
            L_0x00c6:
                int r0 = (r10 > r15 ? 1 : (r10 == r15 ? 0 : -1))
                if (r0 == 0) goto L_0x00ce
                r1.updateConnectionFlowControl(r10)
                return r10
            L_0x00ce:
                if (r7 != 0) goto L_0x00d1
                return r15
            L_0x00d1:
                com.mbridge.msdk.thrid.okhttp.internal.http2.StreamResetException r0 = new com.mbridge.msdk.thrid.okhttp.internal.http2.StreamResetException
                r0.<init>(r7)
                throw r0
            L_0x00d7:
                java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x004c }
                java.lang.String r2 = "stream closed"
                r0.<init>(r2)     // Catch:{ all -> 0x004c }
                throw r0     // Catch:{ all -> 0x004c }
            L_0x00df:
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r2 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.this     // Catch:{ all -> 0x00b1 }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream$StreamTimeout r2 = r2.readTimeout     // Catch:{ all -> 0x00b1 }
                r2.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x00b1 }
                throw r0     // Catch:{ all -> 0x00b1 }
            L_0x00e7:
                monitor-exit(r6)     // Catch:{ all -> 0x00b1 }
                throw r0
            L_0x00e9:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "byteCount < 0: "
                r4.append(r5)
                r4.append(r2)
                java.lang.String r2 = r4.toString()
                r0.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.FramingSource.read(com.mbridge.msdk.thrid.okio.Buffer, long):long");
        }

        /* access modifiers changed from: package-private */
        public void receive(BufferedSource bufferedSource, long j5) throws IOException {
            boolean z4;
            boolean z5;
            boolean z6;
            long j6;
            while (j5 > 0) {
                synchronized (Http2Stream.this) {
                    z4 = this.finished;
                    z5 = false;
                    if (this.readBuffer.size() + j5 > this.maxByteCount) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                }
                if (z6) {
                    bufferedSource.skip(j5);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z4) {
                    bufferedSource.skip(j5);
                    return;
                } else {
                    long read = bufferedSource.read(this.receiveBuffer, j5);
                    if (read != -1) {
                        j5 -= read;
                        synchronized (Http2Stream.this) {
                            try {
                                if (this.closed) {
                                    j6 = this.receiveBuffer.size();
                                    this.receiveBuffer.clear();
                                } else {
                                    if (this.readBuffer.size() == 0) {
                                        z5 = true;
                                    }
                                    this.readBuffer.writeAll(this.receiveBuffer);
                                    if (z5) {
                                        Http2Stream.this.notifyAll();
                                    }
                                    j6 = 0;
                                }
                            } catch (Throwable th) {
                                while (true) {
                                    throw th;
                                }
                            }
                        }
                        if (j6 > 0) {
                            updateConnectionFlowControl(j6);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        public Timeout timeout() {
            return Http2Stream.this.readTimeout;
        }
    }

    class StreamTimeout extends AsyncTimeout {
        StreamTimeout() {
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException((IOException) null);
            }
        }

        /* access modifiers changed from: protected */
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* access modifiers changed from: protected */
        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
            Http2Stream.this.connection.sendDegradedPingLater();
        }
    }

    Http2Stream(int i5, Http2Connection http2Connection, boolean z4, boolean z5, Headers headers) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.headersQueue = arrayDeque;
        this.readTimeout = new StreamTimeout();
        this.writeTimeout = new StreamTimeout();
        this.errorCode = null;
        if (http2Connection != null) {
            this.id = i5;
            this.connection = http2Connection;
            this.bytesLeftInWriteWindow = (long) http2Connection.peerSettings.getInitialWindowSize();
            FramingSource framingSource = new FramingSource((long) http2Connection.okHttpSettings.getInitialWindowSize());
            this.source = framingSource;
            FramingSink framingSink = new FramingSink();
            this.sink = framingSink;
            framingSource.finished = z5;
            framingSink.finished = z4;
            if (headers != null) {
                arrayDeque.add(headers);
            }
            if (isLocallyInitiated() && headers != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            } else if (!isLocallyInitiated() && headers == null) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            throw new NullPointerException("connection == null");
        }
    }

    private boolean closeInternal(ErrorCode errorCode2) {
        synchronized (this) {
            try {
                if (this.errorCode != null) {
                    return false;
                }
                if (this.source.finished && this.sink.finished) {
                    return false;
                }
                this.errorCode = errorCode2;
                notifyAll();
                this.connection.removeStream(this.id);
                return true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void addBytesToWriteWindow(long j5) {
        this.bytesLeftInWriteWindow += j5;
        if (j5 > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    public void cancelStreamIfNecessary() throws IOException {
        boolean z4;
        boolean isOpen;
        synchronized (this) {
            try {
                FramingSource framingSource = this.source;
                if (!framingSource.finished && framingSource.closed) {
                    FramingSink framingSink = this.sink;
                    if (!framingSink.finished) {
                        if (framingSink.closed) {
                        }
                    }
                    z4 = true;
                    isOpen = isOpen();
                }
                z4 = false;
                isOpen = isOpen();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (z4) {
            close(ErrorCode.CANCEL);
        } else if (!isOpen) {
            this.connection.removeStream(this.id);
        }
    }

    /* access modifiers changed from: package-private */
    public void checkOutNotClosed() throws IOException {
        FramingSink framingSink = this.sink;
        if (framingSink.closed) {
            throw new IOException("stream closed");
        } else if (framingSink.finished) {
            throw new IOException("stream finished");
        } else if (this.errorCode != null) {
            throw new StreamResetException(this.errorCode);
        }
    }

    public void close(ErrorCode errorCode2) throws IOException {
        if (closeInternal(errorCode2)) {
            this.connection.writeSynReset(this.id, errorCode2);
        }
    }

    public void closeLater(ErrorCode errorCode2) {
        if (closeInternal(errorCode2)) {
            this.connection.writeSynResetLater(this.id, errorCode2);
        }
    }

    public Http2Connection getConnection() {
        return this.connection;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public int getId() {
        return this.id;
    }

    public Sink getSink() {
        synchronized (this) {
            try {
                if (!this.hasResponseHeaders) {
                    if (!isLocallyInitiated()) {
                        throw new IllegalStateException("reply before requesting the sink");
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return this.sink;
    }

    public Source getSource() {
        return this.source;
    }

    public boolean isLocallyInitiated() {
        boolean z4;
        if ((this.id & 1) == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.connection.client == z4) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0026, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean isOpen() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode r0 = r3.errorCode     // Catch:{ all -> 0x0013 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r3)
            return r1
        L_0x0008:
            com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream$FramingSource r0 = r3.source     // Catch:{ all -> 0x0013 }
            boolean r2 = r0.finished     // Catch:{ all -> 0x0013 }
            if (r2 != 0) goto L_0x0015
            boolean r0 = r0.closed     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0025
            goto L_0x0015
        L_0x0013:
            r0 = move-exception
            goto L_0x0028
        L_0x0015:
            com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream$FramingSink r0 = r3.sink     // Catch:{ all -> 0x0013 }
            boolean r2 = r0.finished     // Catch:{ all -> 0x0013 }
            if (r2 != 0) goto L_0x001f
            boolean r0 = r0.closed     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0025
        L_0x001f:
            boolean r0 = r3.hasResponseHeaders     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0025
            monitor-exit(r3)
            return r1
        L_0x0025:
            monitor-exit(r3)
            r0 = 1
            return r0
        L_0x0028:
            monitor-exit(r3)     // Catch:{ all -> 0x0013 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream.isOpen():boolean");
    }

    public Timeout readTimeout() {
        return this.readTimeout;
    }

    /* access modifiers changed from: package-private */
    public void receiveData(BufferedSource bufferedSource, int i5) throws IOException {
        this.source.receive(bufferedSource, (long) i5);
    }

    /* access modifiers changed from: package-private */
    public void receiveFin() {
        boolean isOpen;
        synchronized (this) {
            this.source.finished = true;
            isOpen = isOpen();
            notifyAll();
        }
        if (!isOpen) {
            this.connection.removeStream(this.id);
        }
    }

    /* access modifiers changed from: package-private */
    public void receiveHeaders(List<Header> list) {
        boolean isOpen;
        synchronized (this) {
            this.hasResponseHeaders = true;
            this.headersQueue.add(Util.toHeaders(list));
            isOpen = isOpen();
            notifyAll();
        }
        if (!isOpen) {
            this.connection.removeStream(this.id);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void receiveRstStream(ErrorCode errorCode2) {
        if (this.errorCode == null) {
            this.errorCode = errorCode2;
            notifyAll();
        }
    }

    public synchronized void setHeadersListener(Header.Listener listener) {
        this.headersListener = listener;
        if (!this.headersQueue.isEmpty() && listener != null) {
            notifyAll();
        }
    }

    /* JADX INFO: finally extract failed */
    public synchronized Headers takeHeaders() throws IOException {
        this.readTimeout.enter();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            try {
                waitForIo();
            } catch (Throwable th) {
                this.readTimeout.exitAndThrowIfTimedOut();
                throw th;
            }
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (!this.headersQueue.isEmpty()) {
        } else {
            throw new StreamResetException(this.errorCode);
        }
        return this.headersQueue.removeFirst();
    }

    /* access modifiers changed from: package-private */
    public void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public void writeHeaders(List<Header> list, boolean z4) throws IOException {
        boolean z5;
        boolean z6;
        boolean z7;
        if (list != null) {
            synchronized (this) {
                z5 = true;
                try {
                    this.hasResponseHeaders = true;
                    if (!z4) {
                        this.sink.finished = true;
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = z6;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (!z6) {
                synchronized (this.connection) {
                    if (this.connection.bytesLeftInWriteWindow != 0) {
                        z5 = false;
                    }
                }
                z6 = z5;
            }
            this.connection.writeSynReply(this.id, z7, list);
            if (z6) {
                this.connection.flush();
                return;
            }
            return;
        }
        throw new NullPointerException("headers == null");
    }

    public Timeout writeTimeout() {
        return this.writeTimeout;
    }
}
