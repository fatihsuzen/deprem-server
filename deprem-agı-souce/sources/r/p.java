package r;

import android.util.Base64;
import p.f;
import r.d;

public abstract class p {

    public static abstract class a {
        public abstract p a();

        public abstract a b(String str);

        public abstract a c(byte[] bArr);

        public abstract a d(f fVar);
    }

    public static a a() {
        return new d.b().d(f.DEFAULT);
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract f d();

    public boolean e() {
        if (c() != null) {
            return true;
        }
        return false;
    }

    public p f(f fVar) {
        return a().b(b()).d(fVar).c(c()).a();
    }

    public final String toString() {
        String str;
        String b5 = b();
        f d5 = d();
        if (c() == null) {
            str = "";
        } else {
            str = Base64.encodeToString(c(), 2);
        }
        return String.format("TransportContext(%s, %s, %s)", new Object[]{b5, d5, str});
    }
}
