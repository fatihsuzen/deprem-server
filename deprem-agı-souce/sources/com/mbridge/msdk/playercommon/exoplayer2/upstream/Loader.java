package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.TraceUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.ExecutorService;

public final class Loader implements LoaderErrorThrower {
    public static final int DONT_RETRY = 2;
    public static final int DONT_RETRY_FATAL = 3;
    public static final int RETRY = 0;
    public static final int RETRY_RESET_ERROR_COUNT = 1;
    /* access modifiers changed from: private */
    public LoadTask<? extends Loadable> currentTask;
    /* access modifiers changed from: private */
    public final ExecutorService downloadExecutorService;
    /* access modifiers changed from: private */
    public IOException fatalError;

    public interface Callback<T extends Loadable> {
        void onLoadCanceled(T t5, long j5, long j6, boolean z4);

        void onLoadCompleted(T t5, long j5, long j6);

        int onLoadError(T t5, long j5, long j6, IOException iOException);
    }

    @SuppressLint({"HandlerLeak"})
    private final class LoadTask<T extends Loadable> extends Handler implements Runnable {
        private static final int MSG_CANCEL = 1;
        private static final int MSG_END_OF_SOURCE = 2;
        private static final int MSG_FATAL_ERROR = 4;
        private static final int MSG_IO_EXCEPTION = 3;
        private static final int MSG_START = 0;
        private static final String TAG = "LoadTask";
        @Nullable
        private Callback<T> callback;
        private volatile boolean canceled;
        private IOException currentError;
        public final int defaultMinRetryCount;
        private int errorCount;
        private volatile Thread executorThread;
        private final T loadable;
        private volatile boolean released;
        private final long startTimeMs;

        public LoadTask(Looper looper, T t5, Callback<T> callback2, int i5, long j5) {
            super(looper);
            this.loadable = t5;
            this.callback = callback2;
            this.defaultMinRetryCount = i5;
            this.startTimeMs = j5;
        }

        private void execute() {
            this.currentError = null;
            Loader.this.downloadExecutorService.execute(Loader.this.currentTask);
        }

        private void finish() {
            LoadTask unused = Loader.this.currentTask = null;
        }

        private long getRetryDelayMillis() {
            return (long) Math.min((this.errorCount - 1) * 1000, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS);
        }

        public final void cancel(boolean z4) {
            this.released = z4;
            this.currentError = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z4) {
                    sendEmptyMessage(1);
                }
            } else {
                this.canceled = true;
                this.loadable.cancelLoad();
                if (this.executorThread != null) {
                    this.executorThread.interrupt();
                }
            }
            if (z4) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.callback.onLoadCanceled(this.loadable, elapsedRealtime, elapsedRealtime - this.startTimeMs, true);
                this.callback = null;
            }
        }

        public final void handleMessage(Message message) {
            if (!this.released) {
                int i5 = message.what;
                if (i5 == 0) {
                    execute();
                } else if (i5 != 4) {
                    finish();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j5 = elapsedRealtime - this.startTimeMs;
                    if (this.canceled) {
                        this.callback.onLoadCanceled(this.loadable, elapsedRealtime, j5, false);
                        return;
                    }
                    int i6 = message.what;
                    int i7 = 1;
                    if (i6 == 1) {
                        this.callback.onLoadCanceled(this.loadable, elapsedRealtime, j5, false);
                    } else if (i6 == 2) {
                        try {
                            this.callback.onLoadCompleted(this.loadable, elapsedRealtime, j5);
                        } catch (RuntimeException e5) {
                            RuntimeException runtimeException = e5;
                            Log.e(TAG, "Unexpected exception handling load completed", runtimeException);
                            IOException unused = Loader.this.fatalError = new UnexpectedLoaderException(runtimeException);
                        }
                    } else if (i6 == 3) {
                        IOException iOException = (IOException) message.obj;
                        this.currentError = iOException;
                        int onLoadError = this.callback.onLoadError(this.loadable, elapsedRealtime, j5, iOException);
                        if (onLoadError == 3) {
                            IOException unused2 = Loader.this.fatalError = this.currentError;
                        } else if (onLoadError != 2) {
                            if (onLoadError != 1) {
                                i7 = 1 + this.errorCount;
                            }
                            this.errorCount = i7;
                            start(getRetryDelayMillis());
                        }
                    }
                } else {
                    throw ((Error) message.obj);
                }
            }
        }

        public final void maybeThrowError(int i5) throws IOException {
            IOException iOException = this.currentError;
            if (iOException != null && this.errorCount > i5) {
                throw iOException;
            }
        }

        public final void run() {
            try {
                this.executorThread = Thread.currentThread();
                if (!this.canceled) {
                    TraceUtil.beginSection("load:" + this.loadable.getClass().getSimpleName());
                    this.loadable.load();
                    TraceUtil.endSection();
                }
                if (!this.released) {
                    sendEmptyMessage(2);
                }
            } catch (IOException e5) {
                if (!this.released) {
                    obtainMessage(3, e5).sendToTarget();
                }
            } catch (InterruptedException unused) {
                Assertions.checkState(this.canceled);
                if (!this.released) {
                    sendEmptyMessage(2);
                }
            } catch (Exception e6) {
                Log.e(TAG, "Unexpected exception loading stream", e6);
                if (!this.released) {
                    obtainMessage(3, new UnexpectedLoaderException(e6)).sendToTarget();
                }
            } catch (OutOfMemoryError e7) {
                Log.e(TAG, "OutOfMemory error loading stream", e7);
                if (!this.released) {
                    obtainMessage(3, new UnexpectedLoaderException(e7)).sendToTarget();
                }
            } catch (Error e8) {
                Log.e(TAG, "Unexpected error loading stream", e8);
                if (!this.released) {
                    obtainMessage(4, e8).sendToTarget();
                }
                throw e8;
            } catch (Throwable th) {
                TraceUtil.endSection();
                throw th;
            }
        }

        public final void start(long j5) {
            boolean z4;
            if (Loader.this.currentTask == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkState(z4);
            LoadTask unused = Loader.this.currentTask = this;
            if (j5 > 0) {
                sendEmptyMessageDelayed(0, j5);
            } else {
                execute();
            }
        }
    }

    public interface Loadable {
        void cancelLoad();

        void load() throws IOException, InterruptedException;
    }

    public interface ReleaseCallback {
        void onLoaderReleased();
    }

    private static final class ReleaseTask implements Runnable {
        private final ReleaseCallback callback;

        public ReleaseTask(ReleaseCallback releaseCallback) {
            this.callback = releaseCallback;
        }

        public final void run() {
            this.callback.onLoaderReleased();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RetryAction {
    }

    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public Loader(String str) {
        this.downloadExecutorService = Util.newSingleThreadExecutor(str);
    }

    public final void cancelLoading() {
        this.currentTask.cancel(false);
    }

    public final boolean isLoading() {
        if (this.currentTask != null) {
            return true;
        }
        return false;
    }

    public final void maybeThrowError() throws IOException {
        maybeThrowError(Integer.MIN_VALUE);
    }

    public final void release() {
        release((ReleaseCallback) null);
    }

    public final <T extends Loadable> long startLoading(T t5, Callback<T> callback, int i5) {
        boolean z4;
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        this.fatalError = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new LoadTask(myLooper, t5, callback, i5, elapsedRealtime).start(0);
        return elapsedRealtime;
    }

    public final void maybeThrowError(int i5) throws IOException {
        IOException iOException = this.fatalError;
        if (iOException == null) {
            LoadTask<? extends Loadable> loadTask = this.currentTask;
            if (loadTask != null) {
                if (i5 == Integer.MIN_VALUE) {
                    i5 = loadTask.defaultMinRetryCount;
                }
                loadTask.maybeThrowError(i5);
                return;
            }
            return;
        }
        throw iOException;
    }

    public final void release(@Nullable ReleaseCallback releaseCallback) {
        LoadTask<? extends Loadable> loadTask = this.currentTask;
        if (loadTask != null) {
            loadTask.cancel(true);
        }
        if (releaseCallback != null) {
            this.downloadExecutorService.execute(new ReleaseTask(releaseCallback));
        }
        this.downloadExecutorService.shutdown();
    }
}
