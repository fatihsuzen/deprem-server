package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import n0.C1722d;

public final class CallbackToFutureAdapter {

    public static final class Completer<T> {
        private boolean attemptedSetting;
        private ResolvableFuture<Void> cancellationFuture = ResolvableFuture.create();
        SafeFuture<T> future;
        Object tag;

        Completer() {
        }

        private void setCompletedNormally() {
            this.tag = null;
            this.future = null;
            this.cancellationFuture = null;
        }

        public void addCancellationListener(@NonNull Runnable runnable, @NonNull Executor executor) {
            ResolvableFuture<Void> resolvableFuture = this.cancellationFuture;
            if (resolvableFuture != null) {
                resolvableFuture.addListener(runnable, executor);
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            ResolvableFuture<Void> resolvableFuture;
            SafeFuture<T> safeFuture = this.future;
            if (safeFuture != null && !safeFuture.isDone()) {
                safeFuture.setException(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.tag));
            }
            if (!this.attemptedSetting && (resolvableFuture = this.cancellationFuture) != null) {
                resolvableFuture.set(null);
            }
        }

        /* access modifiers changed from: package-private */
        public void fireCancellationListeners() {
            this.tag = null;
            this.future = null;
            this.cancellationFuture.set(null);
        }

        public boolean set(T t5) {
            boolean z4 = true;
            this.attemptedSetting = true;
            SafeFuture<T> safeFuture = this.future;
            if (safeFuture == null || !safeFuture.set(t5)) {
                z4 = false;
            }
            if (z4) {
                setCompletedNormally();
            }
            return z4;
        }

        public boolean setCancelled() {
            boolean z4 = true;
            this.attemptedSetting = true;
            SafeFuture<T> safeFuture = this.future;
            if (safeFuture == null || !safeFuture.cancelWithoutNotifyingCompleter(true)) {
                z4 = false;
            }
            if (z4) {
                setCompletedNormally();
            }
            return z4;
        }

        public boolean setException(@NonNull Throwable th) {
            boolean z4 = true;
            this.attemptedSetting = true;
            SafeFuture<T> safeFuture = this.future;
            if (safeFuture == null || !safeFuture.setException(th)) {
                z4 = false;
            }
            if (z4) {
                setCompletedNormally();
            }
            return z4;
        }
    }

    static final class FutureGarbageCollectedException extends Throwable {
        FutureGarbageCollectedException(String str) {
            super(str);
        }

        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public interface Resolver<T> {
        @Nullable
        Object attachCompleter(@NonNull Completer<T> completer) throws Exception;
    }

    private static final class SafeFuture<T> implements C1722d {
        final WeakReference<Completer<T>> completerWeakReference;
        private final AbstractResolvableFuture<T> delegate = new AbstractResolvableFuture<T>() {
            /* access modifiers changed from: protected */
            public String pendingToString() {
                Completer completer = SafeFuture.this.completerWeakReference.get();
                if (completer == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + completer.tag + "]";
            }
        };

        SafeFuture(Completer<T> completer) {
            this.completerWeakReference = new WeakReference<>(completer);
        }

        public void addListener(@NonNull Runnable runnable, @NonNull Executor executor) {
            this.delegate.addListener(runnable, executor);
        }

        public boolean cancel(boolean z4) {
            Completer completer = this.completerWeakReference.get();
            boolean cancel = this.delegate.cancel(z4);
            if (cancel && completer != null) {
                completer.fireCancellationListeners();
            }
            return cancel;
        }

        /* access modifiers changed from: package-private */
        public boolean cancelWithoutNotifyingCompleter(boolean z4) {
            return this.delegate.cancel(z4);
        }

        public T get() throws InterruptedException, ExecutionException {
            return this.delegate.get();
        }

        public boolean isCancelled() {
            return this.delegate.isCancelled();
        }

        public boolean isDone() {
            return this.delegate.isDone();
        }

        /* access modifiers changed from: package-private */
        public boolean set(T t5) {
            return this.delegate.set(t5);
        }

        /* access modifiers changed from: package-private */
        public boolean setException(Throwable th) {
            return this.delegate.setException(th);
        }

        public String toString() {
            return this.delegate.toString();
        }

        public T get(long j5, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return this.delegate.get(j5, timeUnit);
        }
    }

    private CallbackToFutureAdapter() {
    }

    @NonNull
    public static <T> C1722d getFuture(@NonNull Resolver<T> resolver) {
        Completer completer = new Completer();
        SafeFuture<T> safeFuture = new SafeFuture<>(completer);
        completer.future = safeFuture;
        completer.tag = resolver.getClass();
        try {
            Object attachCompleter = resolver.attachCompleter(completer);
            if (attachCompleter == null) {
                return safeFuture;
            }
            completer.tag = attachCompleter;
            return safeFuture;
        } catch (Exception e5) {
            safeFuture.setException(e5);
            return safeFuture;
        }
    }
}
