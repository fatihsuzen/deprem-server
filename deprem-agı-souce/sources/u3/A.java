package U3;

import V3.c;
import e4.C2356e;
import e4.C2358g;
import java.io.Closeable;

public abstract class A implements Closeable {

    class a extends A {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f19306a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2358g f19307b;

        a(t tVar, long j5, C2358g gVar) {
            this.f19306a = j5;
            this.f19307b = gVar;
        }

        public long a() {
            return this.f19306a;
        }

        public C2358g m() {
            return this.f19307b;
        }
    }

    public static A d(t tVar, long j5, C2358g gVar) {
        if (gVar != null) {
            return new a(tVar, j5, gVar);
        }
        throw new NullPointerException("source == null");
    }

    public static A l(t tVar, byte[] bArr) {
        return d(tVar, (long) bArr.length, new C2356e().write(bArr));
    }

    public abstract long a();

    public void close() {
        c.d(m());
    }

    public abstract C2358g m();
}
