package e1;

import T2.a;
import b1.C1017b;
import b3.C2312i;
import d1.C1625b;

/* renamed from: e1.f  reason: case insensitive filesystem */
public final class C1632f implements C1625b {

    /* renamed from: a  reason: collision with root package name */
    private final a f15259a;

    /* renamed from: b  reason: collision with root package name */
    private final a f15260b;

    public C1632f(a aVar, a aVar2) {
        this.f15259a = aVar;
        this.f15260b = aVar2;
    }

    public static C1632f a(a aVar, a aVar2) {
        return new C1632f(aVar, aVar2);
    }

    public static C1631e c(C1017b bVar, C2312i iVar) {
        return new C1631e(bVar, iVar);
    }

    /* renamed from: b */
    public C1631e get() {
        return c((C1017b) this.f15259a.get(), (C2312i) this.f15260b.get());
    }
}
