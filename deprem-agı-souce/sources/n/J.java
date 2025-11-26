package N;

import L.g;
import N.C0721o;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.TimeUnit;
import k0.C1699m;

final class J implements g.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f2989a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1699m f2990b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0721o.a f2991c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ L f2992d;

    J(g gVar, C1699m mVar, C0721o.a aVar, L l5) {
        this.f2989a = gVar;
        this.f2990b = mVar;
        this.f2991c = aVar;
        this.f2992d = l5;
    }

    public final void a(Status status) {
        if (status.i()) {
            this.f2990b.c(this.f2991c.a(this.f2989a.b(0, TimeUnit.MILLISECONDS)));
            return;
        }
        this.f2990b.b(C0708b.a(status));
    }
}
