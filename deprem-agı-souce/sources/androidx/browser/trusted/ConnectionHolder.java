package androidx.browser.trusted;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.trusted.b;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.List;
import n0.C1722d;

class ConnectionHolder implements ServiceConnection {
    private static final int STATE_AWAITING_CONNECTION = 0;
    private static final int STATE_CANCELLED = 3;
    private static final int STATE_CONNECTED = 1;
    private static final int STATE_DISCONNECTED = 2;
    @Nullable
    private Exception mCancellationException;
    @NonNull
    private final Runnable mCloseRunnable;
    @NonNull
    private List<CallbackToFutureAdapter.Completer<TrustedWebActivityServiceConnection>> mCompleters;
    @Nullable
    private TrustedWebActivityServiceConnection mService;
    private int mState;
    @NonNull
    private final WrapperFactory mWrapperFactory;

    static class WrapperFactory {
        WrapperFactory() {
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public TrustedWebActivityServiceConnection create(ComponentName componentName, IBinder iBinder) {
            return new TrustedWebActivityServiceConnection(b.a.asInterface(iBinder), componentName);
        }
    }

    @MainThread
    ConnectionHolder(@NonNull Runnable runnable) {
        this(runnable, new WrapperFactory());
    }

    public static /* synthetic */ Object a(ConnectionHolder connectionHolder, CallbackToFutureAdapter.Completer completer) {
        int i5 = connectionHolder.mState;
        if (i5 == 0) {
            connectionHolder.mCompleters.add(completer);
        } else if (i5 == 1) {
            TrustedWebActivityServiceConnection trustedWebActivityServiceConnection = connectionHolder.mService;
            if (trustedWebActivityServiceConnection != null) {
                completer.set(trustedWebActivityServiceConnection);
            } else {
                throw new IllegalStateException("ConnectionHolder state is incorrect.");
            }
        } else if (i5 == 2) {
            throw new IllegalStateException("Service has been disconnected.");
        } else if (i5 != 3) {
            throw new IllegalStateException("Connection state is invalid");
        } else {
            throw connectionHolder.mCancellationException;
        }
        return "ConnectionHolder, state = " + connectionHolder.mState;
    }

    @MainThread
    public void cancel(@NonNull Exception exc) {
        for (CallbackToFutureAdapter.Completer<TrustedWebActivityServiceConnection> exception : this.mCompleters) {
            exception.setException(exc);
        }
        this.mCompleters.clear();
        this.mCloseRunnable.run();
        this.mState = 3;
        this.mCancellationException = exc;
    }

    @MainThread
    @NonNull
    public C1722d getServiceWrapper() {
        return CallbackToFutureAdapter.getFuture(new a(this));
    }

    @MainThread
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.mService = this.mWrapperFactory.create(componentName, iBinder);
        for (CallbackToFutureAdapter.Completer<TrustedWebActivityServiceConnection> completer : this.mCompleters) {
            completer.set(this.mService);
        }
        this.mCompleters.clear();
        this.mState = 1;
    }

    @MainThread
    public void onServiceDisconnected(ComponentName componentName) {
        this.mService = null;
        this.mCloseRunnable.run();
        this.mState = 2;
    }

    @MainThread
    ConnectionHolder(@NonNull Runnable runnable, @NonNull WrapperFactory wrapperFactory) {
        this.mState = 0;
        this.mCompleters = new ArrayList();
        this.mCloseRunnable = runnable;
        this.mWrapperFactory = wrapperFactory;
    }
}
