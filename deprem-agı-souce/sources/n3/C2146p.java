package N3;

import M3.C2128b;
import kotlin.jvm.internal.t;

/* renamed from: N3.p  reason: case insensitive filesystem */
public final class C2146p extends C2138h {

    /* renamed from: c  reason: collision with root package name */
    private final C2128b f18794c;

    /* renamed from: d  reason: collision with root package name */
    private int f18795d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2146p(C2149t tVar, C2128b bVar) {
        super(tVar);
        t.e(tVar, "writer");
        t.e(bVar, "json");
        this.f18794c = bVar;
    }

    public void b() {
        o(true);
        this.f18795d++;
    }

    public void c() {
        o(false);
        k("\n");
        int i5 = this.f18795d;
        for (int i6 = 0; i6 < i5; i6++) {
            k(this.f18794c.c().n());
        }
    }

    public void d() {
        if (a()) {
            o(false);
        } else {
            c();
        }
    }

    public void p() {
        f(' ');
    }

    public void q() {
        this.f18795d--;
    }
}
