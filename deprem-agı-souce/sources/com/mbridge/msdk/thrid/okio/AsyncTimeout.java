package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class AsyncTimeout extends Timeout {
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    @Nullable
    static AsyncTimeout head;
    private boolean inQueue;
    @Nullable
    private AsyncTimeout next;
    private long timeoutAt;

    private static final class Watchdog extends Thread {
        Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r1.timedOut();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<com.mbridge.msdk.thrid.okio.AsyncTimeout> r0 = com.mbridge.msdk.thrid.okio.AsyncTimeout.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                com.mbridge.msdk.thrid.okio.AsyncTimeout r1 = com.mbridge.msdk.thrid.okio.AsyncTimeout.awaitTimeout()     // Catch:{ all -> 0x000b }
                if (r1 != 0) goto L_0x000d
                monitor-exit(r0)     // Catch:{ all -> 0x000b }
                goto L_0x0000
            L_0x000b:
                r1 = move-exception
                goto L_0x001b
            L_0x000d:
                com.mbridge.msdk.thrid.okio.AsyncTimeout r2 = com.mbridge.msdk.thrid.okio.AsyncTimeout.head     // Catch:{ all -> 0x000b }
                if (r1 != r2) goto L_0x0016
                r1 = 0
                com.mbridge.msdk.thrid.okio.AsyncTimeout.head = r1     // Catch:{ all -> 0x000b }
                monitor-exit(r0)     // Catch:{ all -> 0x000b }
                return
            L_0x0016:
                monitor-exit(r0)     // Catch:{ all -> 0x000b }
                r1.timedOut()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x001b:
                monitor-exit(r0)     // Catch:{ all -> 0x000b }
                throw r1     // Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okio.AsyncTimeout.Watchdog.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    @Nullable
    static AsyncTimeout awaitTimeout() throws InterruptedException {
        AsyncTimeout asyncTimeout = head.next;
        Class<AsyncTimeout> cls = AsyncTimeout.class;
        if (asyncTimeout == null) {
            long nanoTime = System.nanoTime();
            cls.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next != null || System.nanoTime() - nanoTime < IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return head;
        }
        long remainingNanos = asyncTimeout.remainingNanos(System.nanoTime());
        if (remainingNanos > 0) {
            long j5 = remainingNanos / 1000000;
            cls.wait(j5, (int) (remainingNanos - (1000000 * j5)));
            return null;
        }
        head.next = asyncTimeout.next;
        asyncTimeout.next = null;
        return asyncTimeout;
    }

    private static synchronized boolean cancelScheduledTimeout(AsyncTimeout asyncTimeout) {
        synchronized (AsyncTimeout.class) {
            AsyncTimeout asyncTimeout2 = head;
            while (asyncTimeout2 != null) {
                AsyncTimeout asyncTimeout3 = asyncTimeout2.next;
                if (asyncTimeout3 == asyncTimeout) {
                    asyncTimeout2.next = asyncTimeout.next;
                    asyncTimeout.next = null;
                    return false;
                }
                asyncTimeout2 = asyncTimeout3;
            }
            return true;
        }
    }

    private long remainingNanos(long j5) {
        return this.timeoutAt - j5;
    }

    private static synchronized void scheduleTimeout(AsyncTimeout asyncTimeout, long j5, boolean z4) {
        synchronized (AsyncTimeout.class) {
            try {
                if (head == null) {
                    head = new AsyncTimeout();
                    new Watchdog().start();
                }
                long nanoTime = System.nanoTime();
                int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
                if (i5 != 0 && z4) {
                    asyncTimeout.timeoutAt = Math.min(j5, asyncTimeout.deadlineNanoTime() - nanoTime) + nanoTime;
                } else if (i5 != 0) {
                    asyncTimeout.timeoutAt = j5 + nanoTime;
                } else if (z4) {
                    asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
                } else {
                    throw new AssertionError();
                }
                long remainingNanos = asyncTimeout.remainingNanos(nanoTime);
                AsyncTimeout asyncTimeout2 = head;
                while (true) {
                    AsyncTimeout asyncTimeout3 = asyncTimeout2.next;
                    if (asyncTimeout3 == null) {
                        break;
                    } else if (remainingNanos < asyncTimeout3.remainingNanos(nanoTime)) {
                        break;
                    } else {
                        asyncTimeout2 = asyncTimeout2.next;
                    }
                }
                asyncTimeout.next = asyncTimeout2.next;
                asyncTimeout2.next = asyncTimeout;
                if (asyncTimeout2 == head) {
                    AsyncTimeout.class.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void enter() {
        if (!this.inQueue) {
            long timeoutNanos = timeoutNanos();
            boolean hasDeadline = hasDeadline();
            if (timeoutNanos != 0 || hasDeadline) {
                this.inQueue = true;
                scheduleTimeout(this, timeoutNanos, hasDeadline);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    /* access modifiers changed from: protected */
    public IOException newTimeoutException(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink sink(final Sink sink) {
        return new Sink() {
            public void close() throws IOException {
                AsyncTimeout.this.enter();
                try {
                    sink.close();
                    AsyncTimeout.this.exit(true);
                } catch (IOException e5) {
                    throw AsyncTimeout.this.exit(e5);
                } catch (Throwable th) {
                    AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            public void flush() throws IOException {
                AsyncTimeout.this.enter();
                try {
                    sink.flush();
                    AsyncTimeout.this.exit(true);
                } catch (IOException e5) {
                    throw AsyncTimeout.this.exit(e5);
                } catch (Throwable th) {
                    AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            public Timeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sink + ")";
            }

            public void write(Buffer buffer, long j5) throws IOException {
                Util.checkOffsetAndCount(buffer.size, 0, j5);
                while (true) {
                    long j6 = 0;
                    if (j5 > 0) {
                        Segment segment = buffer.head;
                        while (true) {
                            if (j6 >= 65536) {
                                break;
                            }
                            j6 += (long) (segment.limit - segment.pos);
                            if (j6 >= j5) {
                                j6 = j5;
                                break;
                            }
                            segment = segment.next;
                        }
                        AsyncTimeout.this.enter();
                        try {
                            sink.write(buffer, j6);
                            j5 -= j6;
                            AsyncTimeout.this.exit(true);
                        } catch (IOException e5) {
                            throw AsyncTimeout.this.exit(e5);
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            AsyncTimeout.this.exit(false);
                            throw th2;
                        }
                    } else {
                        return;
                    }
                }
            }
        };
    }

    public final Source source(final Source source) {
        return new Source() {
            public void close() throws IOException {
                try {
                    source.close();
                    AsyncTimeout.this.exit(true);
                } catch (IOException e5) {
                    throw AsyncTimeout.this.exit(e5);
                } catch (Throwable th) {
                    AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            public long read(Buffer buffer, long j5) throws IOException {
                AsyncTimeout.this.enter();
                try {
                    long read = source.read(buffer, j5);
                    AsyncTimeout.this.exit(true);
                    return read;
                } catch (IOException e5) {
                    throw AsyncTimeout.this.exit(e5);
                } catch (Throwable th) {
                    AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            public Timeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + source + ")";
            }
        };
    }

    /* access modifiers changed from: protected */
    public void timedOut() {
    }

    /* access modifiers changed from: package-private */
    public final void exit(boolean z4) throws IOException {
        if (exit() && z4) {
            throw newTimeoutException((IOException) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final IOException exit(IOException iOException) throws IOException {
        if (!exit()) {
            return iOException;
        }
        return newTimeoutException(iOException);
    }
}
