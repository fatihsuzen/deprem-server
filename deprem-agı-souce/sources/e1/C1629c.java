package e1;

import T2.a;
import android.content.Context;
import d1.C1625b;

/* renamed from: e1.c  reason: case insensitive filesystem */
public final class C1629c implements C1625b {

    /* renamed from: a  reason: collision with root package name */
    private final a f15231a;

    public C1629c(a aVar) {
        this.f15231a = aVar;
    }

    public static C1629c a(a aVar) {
        return new C1629c(aVar);
    }

    public static C1628b c(Context context) {
        return new C1628b(context);
    }

    /* renamed from: b */
    public C1628b get() {
        return c((Context) this.f15231a.get());
    }
}
