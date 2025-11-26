package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.CallSuper;
import kotlin.jvm.internal.t;

public class LifecycleService extends Service implements LifecycleOwner {
    private final ServiceLifecycleDispatcher dispatcher = new ServiceLifecycleDispatcher(this);

    public Lifecycle getLifecycle() {
        return this.dispatcher.getLifecycle();
    }

    @CallSuper
    public IBinder onBind(Intent intent) {
        t.e(intent, "intent");
        this.dispatcher.onServicePreSuperOnBind();
        return null;
    }

    @CallSuper
    public void onCreate() {
        this.dispatcher.onServicePreSuperOnCreate();
        super.onCreate();
    }

    @CallSuper
    public void onDestroy() {
        this.dispatcher.onServicePreSuperOnDestroy();
        super.onDestroy();
    }

    @CallSuper
    public void onStart(Intent intent, int i5) {
        this.dispatcher.onServicePreSuperOnStart();
        super.onStart(intent, i5);
    }

    @CallSuper
    public int onStartCommand(Intent intent, int i5, int i6) {
        return super.onStartCommand(intent, i5, i6);
    }
}
