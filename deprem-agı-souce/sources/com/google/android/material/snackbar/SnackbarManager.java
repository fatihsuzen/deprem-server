package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

class SnackbarManager {
    private static final int LONG_DURATION_MS = 2750;
    static final int MSG_TIMEOUT = 0;
    private static final int SHORT_DURATION_MS = 1500;
    private static SnackbarManager snackbarManager;
    @Nullable
    private SnackbarRecord currentSnackbar;
    @NonNull
    private final Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return false;
            }
            SnackbarManager.this.handleTimeout((SnackbarRecord) message.obj);
            return true;
        }
    });
    @NonNull
    private final Object lock = new Object();
    @Nullable
    private SnackbarRecord nextSnackbar;

    interface Callback {
        void dismiss(int i5);

        void show();
    }

    private static class SnackbarRecord {
        @NonNull
        final WeakReference<Callback> callback;
        int duration;
        boolean paused;

        SnackbarRecord(int i5, Callback callback2) {
            this.callback = new WeakReference<>(callback2);
            this.duration = i5;
        }

        /* access modifiers changed from: package-private */
        public boolean isSnackbar(@Nullable Callback callback2) {
            if (callback2 == null || this.callback.get() != callback2) {
                return false;
            }
            return true;
        }
    }

    private SnackbarManager() {
    }

    private boolean cancelSnackbarLocked(@NonNull SnackbarRecord snackbarRecord, int i5) {
        Callback callback = snackbarRecord.callback.get();
        if (callback == null) {
            return false;
        }
        this.handler.removeCallbacksAndMessages(snackbarRecord);
        callback.dismiss(i5);
        return true;
    }

    static SnackbarManager getInstance() {
        if (snackbarManager == null) {
            snackbarManager = new SnackbarManager();
        }
        return snackbarManager;
    }

    private boolean isCurrentSnackbarLocked(Callback callback) {
        SnackbarRecord snackbarRecord = this.currentSnackbar;
        if (snackbarRecord == null || !snackbarRecord.isSnackbar(callback)) {
            return false;
        }
        return true;
    }

    private boolean isNextSnackbarLocked(Callback callback) {
        SnackbarRecord snackbarRecord = this.nextSnackbar;
        if (snackbarRecord == null || !snackbarRecord.isSnackbar(callback)) {
            return false;
        }
        return true;
    }

    private void scheduleTimeoutLocked(@NonNull SnackbarRecord snackbarRecord) {
        int i5 = snackbarRecord.duration;
        if (i5 != -2) {
            if (i5 <= 0) {
                if (i5 == -1) {
                    i5 = SHORT_DURATION_MS;
                } else {
                    i5 = LONG_DURATION_MS;
                }
            }
            this.handler.removeCallbacksAndMessages(snackbarRecord);
            Handler handler2 = this.handler;
            handler2.sendMessageDelayed(Message.obtain(handler2, 0, snackbarRecord), (long) i5);
        }
    }

    private void showNextSnackbarLocked() {
        SnackbarRecord snackbarRecord = this.nextSnackbar;
        if (snackbarRecord != null) {
            this.currentSnackbar = snackbarRecord;
            this.nextSnackbar = null;
            Callback callback = snackbarRecord.callback.get();
            if (callback != null) {
                callback.show();
            } else {
                this.currentSnackbar = null;
            }
        }
    }

    public void dismiss(Callback callback, int i5) {
        synchronized (this.lock) {
            try {
                if (isCurrentSnackbarLocked(callback)) {
                    cancelSnackbarLocked(this.currentSnackbar, i5);
                } else if (isNextSnackbarLocked(callback)) {
                    cancelSnackbarLocked(this.nextSnackbar, i5);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void handleTimeout(@NonNull SnackbarRecord snackbarRecord) {
        synchronized (this.lock) {
            try {
                if (this.currentSnackbar != snackbarRecord) {
                    if (this.nextSnackbar == snackbarRecord) {
                    }
                }
                cancelSnackbarLocked(snackbarRecord, 2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean isCurrent(Callback callback) {
        boolean isCurrentSnackbarLocked;
        synchronized (this.lock) {
            isCurrentSnackbarLocked = isCurrentSnackbarLocked(callback);
        }
        return isCurrentSnackbarLocked;
    }

    public boolean isCurrentOrNext(Callback callback) {
        boolean z4;
        synchronized (this.lock) {
            try {
                if (!isCurrentSnackbarLocked(callback)) {
                    if (!isNextSnackbarLocked(callback)) {
                        z4 = false;
                    }
                }
                z4 = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z4;
    }

    public void onDismissed(Callback callback) {
        synchronized (this.lock) {
            try {
                if (isCurrentSnackbarLocked(callback)) {
                    this.currentSnackbar = null;
                    if (this.nextSnackbar != null) {
                        showNextSnackbarLocked();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onShown(Callback callback) {
        synchronized (this.lock) {
            try {
                if (isCurrentSnackbarLocked(callback)) {
                    scheduleTimeoutLocked(this.currentSnackbar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void pauseTimeout(Callback callback) {
        synchronized (this.lock) {
            try {
                if (isCurrentSnackbarLocked(callback)) {
                    SnackbarRecord snackbarRecord = this.currentSnackbar;
                    if (!snackbarRecord.paused) {
                        snackbarRecord.paused = true;
                        this.handler.removeCallbacksAndMessages(snackbarRecord);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void restoreTimeoutIfPaused(Callback callback) {
        synchronized (this.lock) {
            try {
                if (isCurrentSnackbarLocked(callback)) {
                    SnackbarRecord snackbarRecord = this.currentSnackbar;
                    if (snackbarRecord.paused) {
                        snackbarRecord.paused = false;
                        scheduleTimeoutLocked(snackbarRecord);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void show(int i5, Callback callback) {
        synchronized (this.lock) {
            try {
                if (isCurrentSnackbarLocked(callback)) {
                    SnackbarRecord snackbarRecord = this.currentSnackbar;
                    snackbarRecord.duration = i5;
                    this.handler.removeCallbacksAndMessages(snackbarRecord);
                    scheduleTimeoutLocked(this.currentSnackbar);
                    return;
                }
                if (isNextSnackbarLocked(callback)) {
                    this.nextSnackbar.duration = i5;
                } else {
                    this.nextSnackbar = new SnackbarRecord(i5, callback);
                }
                SnackbarRecord snackbarRecord2 = this.currentSnackbar;
                if (snackbarRecord2 == null || !cancelSnackbarLocked(snackbarRecord2, 4)) {
                    this.currentSnackbar = null;
                    showNextSnackbarLocked();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
