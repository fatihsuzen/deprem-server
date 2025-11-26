package x;

import B.C0628a;
import T2.a;
import android.content.Context;
import t.C1876b;
import t.C1878d;
import y.C1935f;
import y.x;
import z.C1952d;

public final class i implements C1876b {

    /* renamed from: a  reason: collision with root package name */
    private final a f16782a;

    /* renamed from: b  reason: collision with root package name */
    private final a f16783b;

    /* renamed from: c  reason: collision with root package name */
    private final a f16784c;

    /* renamed from: d  reason: collision with root package name */
    private final a f16785d;

    public i(a aVar, a aVar2, a aVar3, a aVar4) {
        this.f16782a = aVar;
        this.f16783b = aVar2;
        this.f16784c = aVar3;
        this.f16785d = aVar4;
    }

    public static i a(a aVar, a aVar2, a aVar3, a aVar4) {
        return new i(aVar, aVar2, aVar3, aVar4);
    }

    public static x c(Context context, C1952d dVar, C1935f fVar, C0628a aVar) {
        return (x) C1878d.d(h.a(context, dVar, fVar, aVar));
    }

    /* renamed from: b */
    public x get() {
        return c((Context) this.f16782a.get(), (C1952d) this.f16783b.get(), (C1935f) this.f16784c.get(), (C0628a) this.f16785d.get());
    }
}
