package J;

import android.os.IBinder;
import android.os.RemoteException;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x f2648a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IBinder f2649b;

    public /* synthetic */ q(x xVar, IBinder iBinder) {
        this.f2648a = xVar;
        this.f2649b = iBinder;
    }

    public final void run() {
        x xVar = this.f2648a;
        IBinder iBinder = this.f2649b;
        synchronized (xVar) {
            if (iBinder == null) {
                xVar.a(0, "Null service connection");
                return;
            }
            try {
                xVar.f2658c = new y(iBinder);
                xVar.f2656a = 2;
                xVar.c();
            } catch (RemoteException e5) {
                xVar.a(0, e5.getMessage());
            }
        }
    }
}
