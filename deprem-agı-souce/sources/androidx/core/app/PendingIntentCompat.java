package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CountDownLatch;

public final class PendingIntentCompat {

    @RequiresApi(23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static void send(@NonNull PendingIntent pendingIntent, @NonNull Context context, int i5, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler, @Nullable String str, @Nullable Bundle bundle) throws PendingIntent.CanceledException {
            pendingIntent.send(context, i5, intent, onFinished, handler, str, bundle);
        }
    }

    @RequiresApi(26)
    private static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static PendingIntent getForegroundService(Context context, int i5, Intent intent, int i6) {
            return PendingIntent.getForegroundService(context, i5, intent, i6);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private static class GatedCallback implements Closeable {
        @Nullable
        private PendingIntent.OnFinished mCallback;
        private final CountDownLatch mComplete = new CountDownLatch(1);
        private boolean mSuccess;

        GatedCallback(@Nullable PendingIntent.OnFinished onFinished) {
            this.mCallback = onFinished;
            this.mSuccess = false;
        }

        /* access modifiers changed from: private */
        public void onSendFinished(PendingIntent pendingIntent, Intent intent, int i5, String str, Bundle bundle) {
            boolean z4 = false;
            while (true) {
                try {
                    this.mComplete.await();
                    break;
                } catch (InterruptedException unused) {
                    z4 = true;
                    pendingIntent = pendingIntent;
                    intent = intent;
                    i5 = i5;
                    str = str;
                    bundle = bundle;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    if (z4) {
                        Thread.currentThread().interrupt();
                    }
                    throw th2;
                }
            }
            if (z4) {
                Thread.currentThread().interrupt();
            }
            PendingIntent.OnFinished onFinished = this.mCallback;
            if (onFinished != null) {
                onFinished.onSendFinished(pendingIntent, intent, i5, str, bundle);
                this.mCallback = null;
            }
        }

        public void close() {
            if (!this.mSuccess) {
                this.mCallback = null;
            }
            this.mComplete.countDown();
        }

        public void complete() {
            this.mSuccess = true;
        }

        @Nullable
        public PendingIntent.OnFinished getCallback() {
            if (this.mCallback == null) {
                return null;
            }
            return new p(this);
        }
    }

    private PendingIntentCompat() {
    }

    private static int addMutabilityFlags(boolean z4, int i5) {
        int i6;
        if (!z4) {
            i6 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        } else if (Build.VERSION.SDK_INT < 31) {
            return i5;
        } else {
            i6 = 33554432;
        }
        return i6 | i5;
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i5, @SuppressLint({"ArrayReturn"}) @NonNull Intent[] intentArr, int i6, @Nullable Bundle bundle, boolean z4) {
        return PendingIntent.getActivities(context, i5, intentArr, addMutabilityFlags(z4, i6), bundle);
    }

    @Nullable
    public static PendingIntent getActivity(@NonNull Context context, int i5, @NonNull Intent intent, int i6, boolean z4) {
        return PendingIntent.getActivity(context, i5, intent, addMutabilityFlags(z4, i6));
    }

    @Nullable
    public static PendingIntent getBroadcast(@NonNull Context context, int i5, @NonNull Intent intent, int i6, boolean z4) {
        return PendingIntent.getBroadcast(context, i5, intent, addMutabilityFlags(z4, i6));
    }

    @RequiresApi(26)
    @NonNull
    public static PendingIntent getForegroundService(@NonNull Context context, int i5, @NonNull Intent intent, int i6, boolean z4) {
        return Api26Impl.getForegroundService(context, i5, intent, addMutabilityFlags(z4, i6));
    }

    @Nullable
    public static PendingIntent getService(@NonNull Context context, int i5, @NonNull Intent intent, int i6, boolean z4) {
        return PendingIntent.getService(context, i5, intent, addMutabilityFlags(z4, i6));
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent pendingIntent, int i5, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler) throws PendingIntent.CanceledException {
        GatedCallback gatedCallback = new GatedCallback(onFinished);
        try {
            pendingIntent.send(i5, gatedCallback.getCallback(), handler);
            gatedCallback.complete();
            gatedCallback.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i5, @SuppressLint({"ArrayReturn"}) @NonNull Intent[] intentArr, int i6, boolean z4) {
        return PendingIntent.getActivities(context, i5, intentArr, addMutabilityFlags(z4, i6));
    }

    @Nullable
    public static PendingIntent getActivity(@NonNull Context context, int i5, @NonNull Intent intent, int i6, @Nullable Bundle bundle, boolean z4) {
        return PendingIntent.getActivity(context, i5, intent, addMutabilityFlags(z4, i6), bundle);
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent pendingIntent, @SuppressLint({"ContextFirst"}) @NonNull Context context, int i5, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler) throws PendingIntent.CanceledException {
        send(pendingIntent, context, i5, intent, onFinished, handler, (String) null, (Bundle) null);
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent pendingIntent, @SuppressLint({"ContextFirst"}) @NonNull Context context, int i5, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler, @Nullable String str, @Nullable Bundle bundle) throws PendingIntent.CanceledException {
        Throwable th;
        GatedCallback gatedCallback = new GatedCallback(onFinished);
        try {
            Api23Impl.send(pendingIntent, context, i5, intent, onFinished, handler, str, bundle);
            gatedCallback.complete();
            gatedCallback.close();
            return;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }
}
