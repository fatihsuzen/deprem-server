package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Callable;

@Deprecated
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SelfDestructiveThread {
    private static final int MSG_DESTRUCTION = 0;
    private static final int MSG_INVOKE_RUNNABLE = 1;
    private Handler.Callback mCallback = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            int i5 = message.what;
            if (i5 == 0) {
                SelfDestructiveThread.this.onDestruction();
                return true;
            } else if (i5 != 1) {
                return true;
            } else {
                SelfDestructiveThread.this.onInvokeRunnable((Runnable) message.obj);
                return true;
            }
        }
    };
    private final int mDestructAfterMillisec;
    @GuardedBy("mLock")
    private int mGeneration;
    @GuardedBy("mLock")
    private Handler mHandler;
    private final Object mLock = new Object();
    private final int mPriority;
    @GuardedBy("mLock")
    private HandlerThread mThread;
    private final String mThreadName;

    public interface ReplyCallback<T> {
        void onReply(T t5);
    }

    public SelfDestructiveThread(String str, int i5, int i6) {
        this.mThreadName = str;
        this.mPriority = i5;
        this.mDestructAfterMillisec = i6;
        this.mGeneration = 0;
    }

    private void post(Runnable runnable) {
        synchronized (this.mLock) {
            try {
                if (this.mThread == null) {
                    HandlerThread handlerThread = new HandlerThread(this.mThreadName, this.mPriority);
                    this.mThread = handlerThread;
                    handlerThread.start();
                    this.mHandler = new Handler(this.mThread.getLooper(), this.mCallback);
                    this.mGeneration++;
                }
                this.mHandler.removeMessages(0);
                Handler handler = this.mHandler;
                handler.sendMessage(handler.obtainMessage(1, runnable));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    public int getGeneration() {
        int i5;
        synchronized (this.mLock) {
            i5 = this.mGeneration;
        }
        return i5;
    }

    @VisibleForTesting
    public boolean isRunning() {
        boolean z4;
        synchronized (this.mLock) {
            if (this.mThread != null) {
                z4 = true;
            } else {
                z4 = false;
            }
        }
        return z4;
    }

    /* access modifiers changed from: package-private */
    public void onDestruction() {
        synchronized (this.mLock) {
            try {
                if (!this.mHandler.hasMessages(1)) {
                    this.mThread.quit();
                    this.mThread = null;
                    this.mHandler = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onInvokeRunnable(Runnable runnable) {
        runnable.run();
        synchronized (this.mLock) {
            this.mHandler.removeMessages(0);
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(0), (long) this.mDestructAfterMillisec);
        }
    }

    public <T> void postAndReply(final Callable<T> callable, final ReplyCallback<T> replyCallback) {
        final Handler create = CalleeHandler.create();
        post(new Runnable() {
            public void run() {
                final Object obj;
                try {
                    obj = callable.call();
                } catch (Exception unused) {
                    obj = null;
                }
                create.post(new Runnable() {
                    public void run() {
                        replyCallback.onReply(obj);
                    }
                });
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:11|12|13|14|(4:26|16|17|18)(1:19)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0043 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T postAndWait(java.util.concurrent.Callable<T> r10, int r11) throws java.lang.InterruptedException {
        /*
            r9 = this;
            java.util.concurrent.locks.ReentrantLock r4 = new java.util.concurrent.locks.ReentrantLock
            r4.<init>()
            java.util.concurrent.locks.Condition r6 = r4.newCondition()
            java.util.concurrent.atomic.AtomicReference r2 = new java.util.concurrent.atomic.AtomicReference
            r2.<init>()
            java.util.concurrent.atomic.AtomicBoolean r5 = new java.util.concurrent.atomic.AtomicBoolean
            r0 = 1
            r5.<init>(r0)
            androidx.core.provider.SelfDestructiveThread$3 r0 = new androidx.core.provider.SelfDestructiveThread$3
            r1 = r9
            r3 = r10
            r0.<init>(r2, r3, r4, r5, r6)
            r9.post(r0)
            r4.lock()
            boolean r10 = r5.get()     // Catch:{ all -> 0x002f }
            if (r10 != 0) goto L_0x0032
            java.lang.Object r10 = r2.get()     // Catch:{ all -> 0x002f }
            r4.unlock()
            return r10
        L_0x002f:
            r0 = move-exception
            r10 = r0
            goto L_0x005a
        L_0x0032:
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x002f }
            long r7 = (long) r11     // Catch:{ all -> 0x002f }
            long r10 = r10.toNanos(r7)     // Catch:{ all -> 0x002f }
        L_0x0039:
            long r10 = r6.awaitNanos(r10)     // Catch:{ InterruptedException -> 0x003d }
        L_0x003d:
            boolean r0 = r5.get()     // Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x004b
            java.lang.Object r10 = r2.get()     // Catch:{ all -> 0x002f }
            r4.unlock()
            return r10
        L_0x004b:
            r7 = 0
            int r0 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x0052
            goto L_0x0039
        L_0x0052:
            java.lang.InterruptedException r10 = new java.lang.InterruptedException     // Catch:{ all -> 0x002f }
            java.lang.String r11 = "timeout"
            r10.<init>(r11)     // Catch:{ all -> 0x002f }
            throw r10     // Catch:{ all -> 0x002f }
        L_0x005a:
            r4.unlock()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.SelfDestructiveThread.postAndWait(java.util.concurrent.Callable, int):java.lang.Object");
    }
}
