package M;

import L.b;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import k0.C1699m;

abstract class U extends C0678J {

    /* renamed from: b  reason: collision with root package name */
    protected final C1699m f2869b;

    public U(int i5, C1699m mVar) {
        super(i5);
        this.f2869b = mVar;
    }

    public final void a(Status status) {
        this.f2869b.d(new b(status));
    }

    public final void b(Exception exc) {
        this.f2869b.d(exc);
    }

    public final void c(C0670B b5) {
        try {
            h(b5);
        } catch (DeadObjectException e5) {
            a(Y.e(e5));
            throw e5;
        } catch (RemoteException e6) {
            a(Y.e(e6));
        } catch (RuntimeException e7) {
            this.f2869b.d(e7);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void h(C0670B b5);
}
