package f4;

import e4.C2356e;
import e4.C2364m;
import e4.Z;
import java.io.IOException;
import kotlin.jvm.internal.t;

public final class g extends C2364m {

    /* renamed from: b  reason: collision with root package name */
    private final long f21636b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f21637c;

    /* renamed from: d  reason: collision with root package name */
    private long f21638d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Z z4, long j5, boolean z5) {
        super(z4);
        t.e(z4, "delegate");
        this.f21636b = j5;
        this.f21637c = z5;
    }

    private final void d(C2356e eVar, long j5) {
        C2356e eVar2 = new C2356e();
        eVar2.I(eVar);
        eVar.f(eVar2, j5);
        eVar2.a();
    }

    public long e(C2356e eVar, long j5) {
        t.e(eVar, "sink");
        long j6 = this.f21638d;
        long j7 = this.f21636b;
        if (j6 > j7) {
            j5 = 0;
        } else if (this.f21637c) {
            long j8 = j7 - j6;
            if (j8 == 0) {
                return -1;
            }
            j5 = Math.min(j5, j8);
        }
        long e5 = super.e(eVar, j5);
        int i5 = (e5 > -1 ? 1 : (e5 == -1 ? 0 : -1));
        if (i5 != 0) {
            this.f21638d += e5;
        }
        long j9 = this.f21638d;
        long j10 = this.f21636b;
        if ((j9 >= j10 || i5 != 0) && j9 <= j10) {
            return e5;
        }
        if (e5 > 0 && j9 > j10) {
            d(eVar, eVar.size() - (this.f21638d - this.f21636b));
        }
        throw new IOException("expected " + this.f21636b + " bytes but got " + this.f21638d);
    }
}
