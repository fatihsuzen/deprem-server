package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import androidx.room.IMultiInstanceInvalidationService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.t;

@ExperimentalRoomApi
public final class MultiInstanceInvalidationService extends Service {
    private final IMultiInstanceInvalidationService.Stub binder = new MultiInstanceInvalidationService$binder$1(this);
    private final RemoteCallbackList<IMultiInstanceInvalidationCallback> callbackList = new MultiInstanceInvalidationService$callbackList$1(this);
    private final Map<Integer, String> clientNames = new LinkedHashMap();
    private int maxClientId;

    public final RemoteCallbackList<IMultiInstanceInvalidationCallback> getCallbackList$room_runtime_release() {
        return this.callbackList;
    }

    public final Map<Integer, String> getClientNames$room_runtime_release() {
        return this.clientNames;
    }

    public final int getMaxClientId$room_runtime_release() {
        return this.maxClientId;
    }

    public IBinder onBind(Intent intent) {
        t.e(intent, "intent");
        return this.binder;
    }

    public final void setMaxClientId$room_runtime_release(int i5) {
        this.maxClientId = i5;
    }
}
