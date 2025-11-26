package L;

import K.C0657d;
import L.f;
import M.C0684d;
import M.C0691k;
import N.C0709c;
import N.C0710d;
import N.C0716j;
import N.C0722p;
import android.content.Context;
import android.os.Looper;
import java.util.Set;

/* renamed from: L.a  reason: case insensitive filesystem */
public final class C0668a {

    /* renamed from: a  reason: collision with root package name */
    private final C0048a f2765a;

    /* renamed from: b  reason: collision with root package name */
    private final g f2766b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2767c;

    /* renamed from: L.a$a  reason: collision with other inner class name */
    public static abstract class C0048a extends e {
        public f a(Context context, Looper looper, C0710d dVar, Object obj, f.a aVar, f.b bVar) {
            return b(context, looper, dVar, obj, aVar, bVar);
        }

        public f b(Context context, Looper looper, C0710d dVar, Object obj, C0684d dVar2, C0691k kVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* renamed from: L.a$b */
    public interface b {
    }

    /* renamed from: L.a$c */
    public static class c {
    }

    /* renamed from: L.a$d */
    public interface d {
    }

    /* renamed from: L.a$e */
    public static abstract class e {
    }

    /* renamed from: L.a$f */
    public interface f extends b {
        void b();

        Set c();

        void d(String str);

        void e(C0709c.C0050c cVar);

        boolean f();

        String g();

        boolean h();

        void i(C0709c.e eVar);

        boolean j();

        int k();

        void l(C0716j jVar, Set set);

        C0657d[] m();

        String n();

        boolean o();
    }

    /* renamed from: L.a$g */
    public static final class g extends c {
    }

    public C0668a(String str, C0048a aVar, g gVar) {
        C0722p.l(aVar, "Cannot construct an Api with a null ClientBuilder");
        C0722p.l(gVar, "Cannot construct an Api with a null ClientKey");
        this.f2767c = str;
        this.f2765a = aVar;
        this.f2766b = gVar;
    }

    public final C0048a a() {
        return this.f2765a;
    }

    public final c b() {
        return this.f2766b;
    }

    public final String c() {
        return this.f2767c;
    }
}
