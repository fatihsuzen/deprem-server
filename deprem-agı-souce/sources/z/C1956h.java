package z;

import T2.a;
import android.content.Context;
import t.C1876b;
import t.C1878d;

/* renamed from: z.h  reason: case insensitive filesystem */
public final class C1956h implements C1876b {

    /* renamed from: a  reason: collision with root package name */
    private final a f17148a;

    public C1956h(a aVar) {
        this.f17148a = aVar;
    }

    public static C1956h a(a aVar) {
        return new C1956h(aVar);
    }

    public static String c(Context context) {
        return (String) C1878d.d(C1954f.b(context));
    }

    /* renamed from: b */
    public String get() {
        return c((Context) this.f17148a.get());
    }
}
