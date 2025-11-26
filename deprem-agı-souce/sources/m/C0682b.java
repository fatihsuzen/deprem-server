package M;

import L.C0668a;
import N.C0720n;

/* renamed from: M.b  reason: case insensitive filesystem */
public final class C0682b {

    /* renamed from: a  reason: collision with root package name */
    private final int f2879a;

    /* renamed from: b  reason: collision with root package name */
    private final C0668a f2880b;

    /* renamed from: c  reason: collision with root package name */
    private final C0668a.d f2881c;

    /* renamed from: d  reason: collision with root package name */
    private final String f2882d;

    private C0682b(C0668a aVar, C0668a.d dVar, String str) {
        this.f2880b = aVar;
        this.f2881c = dVar;
        this.f2882d = str;
        this.f2879a = C0720n.b(aVar, dVar, str);
    }

    public static C0682b a(C0668a aVar, C0668a.d dVar, String str) {
        return new C0682b(aVar, dVar, str);
    }

    public final String b() {
        return this.f2880b.c();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0682b)) {
            return false;
        }
        C0682b bVar = (C0682b) obj;
        if (!C0720n.a(this.f2880b, bVar.f2880b) || !C0720n.a(this.f2881c, bVar.f2881c) || !C0720n.a(this.f2882d, bVar.f2882d)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f2879a;
    }
}
