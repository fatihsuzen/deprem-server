package x0;

import D0.g;
import java.io.File;
import java.io.IOException;

/* renamed from: x0.y  reason: case insensitive filesystem */
class C1928y {

    /* renamed from: a  reason: collision with root package name */
    private final String f16955a;

    /* renamed from: b  reason: collision with root package name */
    private final g f16956b;

    public C1928y(String str, g gVar) {
        this.f16955a = str;
        this.f16956b = gVar;
    }

    private File b() {
        return this.f16956b.g(this.f16955a);
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e5) {
            u0.g f5 = u0.g.f();
            f5.e("Error creating marker: " + this.f16955a, e5);
            return false;
        }
    }

    public boolean c() {
        return b().exists();
    }

    public boolean d() {
        return b().delete();
    }
}
