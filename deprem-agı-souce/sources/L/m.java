package L;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

final class m extends BasePendingResult {

    /* renamed from: n  reason: collision with root package name */
    private final j f2786n;

    public m(f fVar, j jVar) {
        super(fVar);
        this.f2786n = jVar;
    }

    /* access modifiers changed from: protected */
    public final j c(Status status) {
        return this.f2786n;
    }
}
