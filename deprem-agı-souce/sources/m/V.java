package M;

import N.C0722p;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.a;

public final class V extends Y {

    /* renamed from: b  reason: collision with root package name */
    protected final a f2870b;

    public V(int i5, a aVar) {
        super(i5);
        this.f2870b = (a) C0722p.l(aVar, "Null methods are not runnable.");
    }

    public final void a(Status status) {
        try {
            this.f2870b.o(status);
        } catch (IllegalStateException e5) {
            Log.w("ApiCallRunner", "Exception reporting failure", e5);
        }
    }

    public final void b(Exception exc) {
        String simpleName = exc.getClass().getSimpleName();
        String localizedMessage = exc.getLocalizedMessage();
        try {
            this.f2870b.o(new Status(10, simpleName + ": " + localizedMessage));
        } catch (IllegalStateException e5) {
            Log.w("ApiCallRunner", "Exception reporting failure", e5);
        }
    }

    public final void c(C0670B b5) {
        try {
            this.f2870b.m(b5.v());
        } catch (RuntimeException e5) {
            b(e5);
        }
    }

    public final void d(C0698s sVar, boolean z4) {
        sVar.c(this.f2870b, z4);
    }
}
