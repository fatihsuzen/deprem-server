package M;

import K.C0657d;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import k0.C1699m;

public final class W extends C0678J {

    /* renamed from: b  reason: collision with root package name */
    private final C0696p f2871b;

    /* renamed from: c  reason: collision with root package name */
    private final C1699m f2872c;

    /* renamed from: d  reason: collision with root package name */
    private final C0694n f2873d;

    public W(int i5, C0696p pVar, C1699m mVar, C0694n nVar) {
        super(i5);
        this.f2872c = mVar;
        this.f2871b = pVar;
        this.f2873d = nVar;
        if (i5 == 2 && pVar.c()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    public final void a(Status status) {
        this.f2872c.d(this.f2873d.a(status));
    }

    public final void b(Exception exc) {
        this.f2872c.d(exc);
    }

    public final void c(C0670B b5) {
        try {
            this.f2871b.b(b5.v(), this.f2872c);
        } catch (DeadObjectException e5) {
            throw e5;
        } catch (RemoteException e6) {
            a(Y.e(e6));
        } catch (RuntimeException e7) {
            this.f2872c.d(e7);
        }
    }

    public final void d(C0698s sVar, boolean z4) {
        sVar.d(this.f2872c, z4);
    }

    public final boolean f(C0670B b5) {
        return this.f2871b.c();
    }

    public final C0657d[] g(C0670B b5) {
        return this.f2871b.e();
    }
}
