package com.mbridge.msdk.playercommon.exoplayer2.decoder;

import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.OutputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.lang.Exception;
import java.util.ArrayDeque;

public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends OutputBuffer, E extends Exception> implements Decoder<I, O, E> {
    private int availableInputBufferCount;
    private final I[] availableInputBuffers;
    private int availableOutputBufferCount;
    private final O[] availableOutputBuffers;
    private final Thread decodeThread;
    private I dequeuedInputBuffer;
    private E exception;
    private boolean flushed;
    private final Object lock = new Object();
    private final ArrayDeque<I> queuedInputBuffers = new ArrayDeque<>();
    private final ArrayDeque<O> queuedOutputBuffers = new ArrayDeque<>();
    private boolean released;
    private int skippedOutputBufferCount;

    protected SimpleDecoder(I[] iArr, O[] oArr) {
        this.availableInputBuffers = iArr;
        this.availableInputBufferCount = iArr.length;
        for (int i5 = 0; i5 < this.availableInputBufferCount; i5++) {
            this.availableInputBuffers[i5] = createInputBuffer();
        }
        this.availableOutputBuffers = oArr;
        this.availableOutputBufferCount = oArr.length;
        for (int i6 = 0; i6 < this.availableOutputBufferCount; i6++) {
            this.availableOutputBuffers[i6] = createOutputBuffer();
        }
        AnonymousClass1 r42 = new Thread() {
            public void run() {
                SimpleDecoder.this.run();
            }
        };
        this.decodeThread = r42;
        r42.start();
    }

    private boolean canDecodeBuffer() {
        if (this.queuedInputBuffers.isEmpty() || this.availableOutputBufferCount <= 0) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        if (r1.isEndOfStream() == false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        r3.addFlag(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
        if (r1.isDecodeOnly() == false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
        r3.addFlag(Integer.MIN_VALUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r6.exception = decode(r1, r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        r6.exception = createUnexpectedDecodeException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005c, code lost:
        r6.exception = createUnexpectedDecodeException(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean decode() throws java.lang.InterruptedException {
        /*
            r6 = this;
            java.lang.Object r0 = r6.lock
            monitor-enter(r0)
        L_0x0003:
            boolean r1 = r6.released     // Catch:{ all -> 0x0013 }
            if (r1 != 0) goto L_0x0016
            boolean r1 = r6.canDecodeBuffer()     // Catch:{ all -> 0x0013 }
            if (r1 != 0) goto L_0x0016
            java.lang.Object r1 = r6.lock     // Catch:{ all -> 0x0013 }
            r1.wait()     // Catch:{ all -> 0x0013 }
            goto L_0x0003
        L_0x0013:
            r1 = move-exception
            goto L_0x009c
        L_0x0016:
            boolean r1 = r6.released     // Catch:{ all -> 0x0013 }
            r2 = 0
            if (r1 == 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            return r2
        L_0x001d:
            java.util.ArrayDeque<I> r1 = r6.queuedInputBuffers     // Catch:{ all -> 0x0013 }
            java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x0013 }
            com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer r1 = (com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer) r1     // Catch:{ all -> 0x0013 }
            O[] r3 = r6.availableOutputBuffers     // Catch:{ all -> 0x0013 }
            int r4 = r6.availableOutputBufferCount     // Catch:{ all -> 0x0013 }
            r5 = 1
            int r4 = r4 - r5
            r6.availableOutputBufferCount = r4     // Catch:{ all -> 0x0013 }
            r3 = r3[r4]     // Catch:{ all -> 0x0013 }
            boolean r4 = r6.flushed     // Catch:{ all -> 0x0013 }
            r6.flushed = r2     // Catch:{ all -> 0x0013 }
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            boolean r0 = r1.isEndOfStream()
            if (r0 == 0) goto L_0x003f
            r0 = 4
            r3.addFlag(r0)
            goto L_0x006e
        L_0x003f:
            boolean r0 = r1.isDecodeOnly()
            if (r0 == 0) goto L_0x004a
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r3.addFlag(r0)
        L_0x004a:
            java.lang.Exception r0 = r6.decode(r1, r3, r4)     // Catch:{ RuntimeException -> 0x0053, OutOfMemoryError -> 0x0051 }
            r6.exception = r0     // Catch:{ RuntimeException -> 0x0053, OutOfMemoryError -> 0x0051 }
            goto L_0x0062
        L_0x0051:
            r0 = move-exception
            goto L_0x0055
        L_0x0053:
            r0 = move-exception
            goto L_0x005c
        L_0x0055:
            java.lang.Exception r0 = r6.createUnexpectedDecodeException(r0)
            r6.exception = r0
            goto L_0x0062
        L_0x005c:
            java.lang.Exception r0 = r6.createUnexpectedDecodeException(r0)
            r6.exception = r0
        L_0x0062:
            E r0 = r6.exception
            if (r0 == 0) goto L_0x006e
            java.lang.Object r0 = r6.lock
            monitor-enter(r0)
            monitor-exit(r0)     // Catch:{ all -> 0x006b }
            return r2
        L_0x006b:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006b }
            throw r1
        L_0x006e:
            java.lang.Object r4 = r6.lock
            monitor-enter(r4)
            boolean r0 = r6.flushed     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x007b
            r6.releaseOutputBufferInternal(r3)     // Catch:{ all -> 0x0079 }
            goto L_0x0095
        L_0x0079:
            r0 = move-exception
            goto L_0x009a
        L_0x007b:
            boolean r0 = r3.isDecodeOnly()     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x008a
            int r0 = r6.skippedOutputBufferCount     // Catch:{ all -> 0x0079 }
            int r0 = r0 + r5
            r6.skippedOutputBufferCount = r0     // Catch:{ all -> 0x0079 }
            r6.releaseOutputBufferInternal(r3)     // Catch:{ all -> 0x0079 }
            goto L_0x0095
        L_0x008a:
            int r0 = r6.skippedOutputBufferCount     // Catch:{ all -> 0x0079 }
            r3.skippedOutputBufferCount = r0     // Catch:{ all -> 0x0079 }
            r6.skippedOutputBufferCount = r2     // Catch:{ all -> 0x0079 }
            java.util.ArrayDeque<O> r0 = r6.queuedOutputBuffers     // Catch:{ all -> 0x0079 }
            r0.addLast(r3)     // Catch:{ all -> 0x0079 }
        L_0x0095:
            r6.releaseInputBufferInternal(r1)     // Catch:{ all -> 0x0079 }
            monitor-exit(r4)     // Catch:{ all -> 0x0079 }
            return r5
        L_0x009a:
            monitor-exit(r4)     // Catch:{ all -> 0x0079 }
            throw r0
        L_0x009c:
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.decoder.SimpleDecoder.decode():boolean");
    }

    private void maybeNotifyDecodeLoop() {
        if (canDecodeBuffer()) {
            this.lock.notify();
        }
    }

    private void maybeThrowException() throws Exception {
        E e5 = this.exception;
        if (e5 != null) {
            throw e5;
        }
    }

    private void releaseInputBufferInternal(I i5) {
        i5.clear();
        I[] iArr = this.availableInputBuffers;
        int i6 = this.availableInputBufferCount;
        this.availableInputBufferCount = i6 + 1;
        iArr[i6] = i5;
    }

    private void releaseOutputBufferInternal(O o5) {
        o5.clear();
        O[] oArr = this.availableOutputBuffers;
        int i5 = this.availableOutputBufferCount;
        this.availableOutputBufferCount = i5 + 1;
        oArr[i5] = o5;
    }

    /* access modifiers changed from: private */
    public void run() {
        do {
            try {
            } catch (InterruptedException e5) {
                throw new IllegalStateException(e5);
            }
        } while (decode());
    }

    /* access modifiers changed from: protected */
    public abstract I createInputBuffer();

    /* access modifiers changed from: protected */
    public abstract O createOutputBuffer();

    /* access modifiers changed from: protected */
    public abstract E createUnexpectedDecodeException(Throwable th);

    /* access modifiers changed from: protected */
    public abstract E decode(I i5, O o5, boolean z4);

    public final void flush() {
        synchronized (this.lock) {
            try {
                this.flushed = true;
                this.skippedOutputBufferCount = 0;
                I i5 = this.dequeuedInputBuffer;
                if (i5 != null) {
                    releaseInputBufferInternal(i5);
                    this.dequeuedInputBuffer = null;
                }
                while (!this.queuedInputBuffers.isEmpty()) {
                    releaseInputBufferInternal((DecoderInputBuffer) this.queuedInputBuffers.removeFirst());
                }
                while (!this.queuedOutputBuffers.isEmpty()) {
                    releaseOutputBufferInternal((OutputBuffer) this.queuedOutputBuffers.removeFirst());
                }
            } finally {
            }
        }
    }

    public void release() {
        synchronized (this.lock) {
            this.released = true;
            this.lock.notify();
        }
        try {
            this.decodeThread.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    /* access modifiers changed from: protected */
    public void releaseOutputBuffer(O o5) {
        synchronized (this.lock) {
            releaseOutputBufferInternal(o5);
            maybeNotifyDecodeLoop();
        }
    }

    /* access modifiers changed from: protected */
    public final void setInitialInputBufferSize(int i5) {
        boolean z4;
        if (this.availableInputBufferCount == this.availableInputBuffers.length) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        for (I ensureSpaceForWrite : this.availableInputBuffers) {
            ensureSpaceForWrite.ensureSpaceForWrite(i5);
        }
    }

    public final I dequeueInputBuffer() throws Exception {
        I i5;
        synchronized (this.lock) {
            maybeThrowException();
            Assertions.checkState(this.dequeuedInputBuffer == null);
            int i6 = this.availableInputBufferCount;
            if (i6 == 0) {
                i5 = null;
            } else {
                I[] iArr = this.availableInputBuffers;
                int i7 = i6 - 1;
                this.availableInputBufferCount = i7;
                i5 = iArr[i7];
            }
            this.dequeuedInputBuffer = i5;
        }
        return i5;
    }

    public final O dequeueOutputBuffer() throws Exception {
        synchronized (this.lock) {
            try {
                maybeThrowException();
                if (this.queuedOutputBuffers.isEmpty()) {
                    return null;
                }
                O o5 = (OutputBuffer) this.queuedOutputBuffers.removeFirst();
                return o5;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void queueInputBuffer(I i5) throws Exception {
        synchronized (this.lock) {
            maybeThrowException();
            Assertions.checkArgument(i5 == this.dequeuedInputBuffer);
            this.queuedInputBuffers.addLast(i5);
            maybeNotifyDecodeLoop();
            this.dequeuedInputBuffer = null;
        }
    }
}
