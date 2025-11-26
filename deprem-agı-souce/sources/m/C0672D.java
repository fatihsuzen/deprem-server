package M;

import K.C0657d;
import N.C0720n;

/* renamed from: M.D  reason: case insensitive filesystem */
final class C0672D {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final C0682b f2832a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C0657d f2833b;

    /* synthetic */ C0672D(C0682b bVar, C0657d dVar, C0671C c5) {
        this.f2832a = bVar;
        this.f2833b = dVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof C0672D)) {
            C0672D d5 = (C0672D) obj;
            if (!C0720n.a(this.f2832a, d5.f2832a) || !C0720n.a(this.f2833b, d5.f2833b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return C0720n.b(this.f2832a, this.f2833b);
    }

    public final String toString() {
        return C0720n.c(this).a("key", this.f2832a).a("feature", this.f2833b).toString();
    }
}
