package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.util.Log;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.t;
import w3.M;
import y3.C2928a;
import z3.B;
import z3.C2972e;
import z3.v;

public final class MultiInstanceInvalidationClient {
    private final Context appContext;
    /* access modifiers changed from: private */
    public int clientId;
    /* access modifiers changed from: private */
    public final M coroutineScope;
    /* access modifiers changed from: private */
    public final v invalidatedTables = B.a(0, 0, C2928a.SUSPEND);
    private final IMultiInstanceInvalidationCallback invalidationCallback;
    /* access modifiers changed from: private */
    public IMultiInstanceInvalidationService invalidationService;
    private final InvalidationTracker invalidationTracker;
    private final String name;
    private final MultiInstanceInvalidationClient$observer$1 observer;
    private final ServiceConnection serviceConnection;
    /* access modifiers changed from: private */
    public final AtomicBoolean stopped = new AtomicBoolean(true);

    public MultiInstanceInvalidationClient(Context context, String str, InvalidationTracker invalidationTracker2) {
        t.e(context, "context");
        t.e(str, RewardPlus.NAME);
        t.e(invalidationTracker2, "invalidationTracker");
        this.name = str;
        this.invalidationTracker = invalidationTracker2;
        this.appContext = context.getApplicationContext();
        this.coroutineScope = invalidationTracker2.getDatabase$room_runtime_release().getCoroutineScope();
        this.observer = new MultiInstanceInvalidationClient$observer$1(this, invalidationTracker2.getTableNames$room_runtime_release());
        this.invalidationCallback = new MultiInstanceInvalidationClient$invalidationCallback$1(this);
        this.serviceConnection = new MultiInstanceInvalidationClient$serviceConnection$1(this);
    }

    /* access modifiers changed from: private */
    public final void registerCallback() {
        try {
            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.invalidationService;
            if (iMultiInstanceInvalidationService != null) {
                this.clientId = iMultiInstanceInvalidationService.registerCallback(this.invalidationCallback, this.name);
            }
        } catch (RemoteException e5) {
            Log.w(Room.LOG_TAG, "Cannot register multi-instance invalidation callback", e5);
        }
    }

    public final C2972e createFlow(String[] strArr) {
        t.e(strArr, "resolvedTableNames");
        return new MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1(this.invalidatedTables, strArr);
    }

    public final InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    public final String getName() {
        return this.name;
    }

    public final void start(Intent intent) {
        t.e(intent, "serviceIntent");
        if (this.stopped.compareAndSet(true, false)) {
            this.appContext.bindService(intent, this.serviceConnection, 1);
            this.invalidationTracker.addRemoteObserver$room_runtime_release(this.observer);
        }
    }

    public final void stop() {
        if (this.stopped.compareAndSet(false, true)) {
            this.invalidationTracker.removeObserver(this.observer);
            try {
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.invalidationService;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.unregisterCallback(this.invalidationCallback, this.clientId);
                }
            } catch (RemoteException e5) {
                Log.w(Room.LOG_TAG, "Cannot unregister multi-instance invalidation callback", e5);
            }
            this.appContext.unbindService(this.serviceConnection);
        }
    }
}
