package M;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract class Y {

    /* renamed from: a  reason: collision with root package name */
    public final int f2874a;

    public Y(int i5) {
        this.f2874a = i5;
    }

    static /* bridge */ /* synthetic */ Status e(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void a(Status status);

    public abstract void b(Exception exc);

    public abstract void c(C0670B b5);

    public abstract void d(C0698s sVar, boolean z4);
}
