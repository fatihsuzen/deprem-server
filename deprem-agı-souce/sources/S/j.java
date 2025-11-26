package s;

import B.C0628a;
import T2.a;
import android.content.Context;
import t.C1876b;

public final class j implements C1876b {

    /* renamed from: a  reason: collision with root package name */
    private final a f16470a;

    /* renamed from: b  reason: collision with root package name */
    private final a f16471b;

    /* renamed from: c  reason: collision with root package name */
    private final a f16472c;

    public j(a aVar, a aVar2, a aVar3) {
        this.f16470a = aVar;
        this.f16471b = aVar2;
        this.f16472c = aVar3;
    }

    public static j a(a aVar, a aVar2, a aVar3) {
        return new j(aVar, aVar2, aVar3);
    }

    public static i c(Context context, C0628a aVar, C0628a aVar2) {
        return new i(context, aVar, aVar2);
    }

    /* renamed from: b */
    public i get() {
        return c((Context) this.f16470a.get(), (C0628a) this.f16471b.get(), (C0628a) this.f16472c.get());
    }
}
