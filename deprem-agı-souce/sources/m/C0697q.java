package M;

import L.g;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* renamed from: M.q  reason: case insensitive filesystem */
final class C0697q implements g.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BasePendingResult f2932a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0698s f2933b;

    C0697q(C0698s sVar, BasePendingResult basePendingResult) {
        this.f2933b = sVar;
        this.f2932a = basePendingResult;
    }

    public final void a(Status status) {
        this.f2933b.f2936a.remove(this.f2932a);
    }
}
