package z;

import T2.a;
import android.content.Context;
import t.C1876b;

public final class X implements C1876b {

    /* renamed from: a  reason: collision with root package name */
    private final a f17130a;

    /* renamed from: b  reason: collision with root package name */
    private final a f17131b;

    /* renamed from: c  reason: collision with root package name */
    private final a f17132c;

    public X(a aVar, a aVar2, a aVar3) {
        this.f17130a = aVar;
        this.f17131b = aVar2;
        this.f17132c = aVar3;
    }

    public static X a(a aVar, a aVar2, a aVar3) {
        return new X(aVar, aVar2, aVar3);
    }

    public static W c(Context context, String str, int i5) {
        return new W(context, str, i5);
    }

    /* renamed from: b */
    public W get() {
        return c((Context) this.f17130a.get(), (String) this.f17131b.get(), ((Integer) this.f17132c.get()).intValue());
    }
}
