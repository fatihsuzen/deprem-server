package K;

import N.C0722p;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: K.a  reason: case insensitive filesystem */
public class C0654a implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    boolean f2699a = false;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue f2700b = new LinkedBlockingQueue();

    public IBinder a(long j5, TimeUnit timeUnit) {
        C0722p.j("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (!this.f2699a) {
            this.f2699a = true;
            IBinder iBinder = (IBinder) this.f2700b.poll(j5, timeUnit);
            if (iBinder != null) {
                return iBinder;
            }
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f2700b.add(iBinder);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
