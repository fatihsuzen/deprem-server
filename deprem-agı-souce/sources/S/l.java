package s;

import T2.a;
import android.content.Context;
import t.C1876b;

public final class l implements C1876b {

    /* renamed from: a  reason: collision with root package name */
    private final a f16478a;

    /* renamed from: b  reason: collision with root package name */
    private final a f16479b;

    public l(a aVar, a aVar2) {
        this.f16478a = aVar;
        this.f16479b = aVar2;
    }

    public static l a(a aVar, a aVar2) {
        return new l(aVar, aVar2);
    }

    public static k c(Context context, Object obj) {
        return new k(context, (i) obj);
    }

    /* renamed from: b */
    public k get() {
        return c((Context) this.f16478a.get(), this.f16479b.get());
    }
}
