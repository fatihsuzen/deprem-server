package e1;

import M3.C2128b;
import W2.J;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.Serializer;
import b3.C2308e;
import h3.C2452a;
import java.io.InputStream;
import java.io.OutputStream;
import t3.s;

public final class i implements Serializer {

    /* renamed from: a  reason: collision with root package name */
    public static final i f15272a = new i();

    /* renamed from: b  reason: collision with root package name */
    private static final h f15273b = new h((Boolean) null, (Double) null, (Integer) null, (Integer) null, (Long) null);

    private i() {
    }

    /* renamed from: a */
    public h getDefaultValue() {
        return f15273b;
    }

    /* renamed from: b */
    public Object writeTo(h hVar, OutputStream outputStream, C2308e eVar) {
        outputStream.write(s.B(C2128b.f18665d.b(h.Companion.serializer(), hVar)));
        return J.f19942a;
    }

    public Object readFrom(InputStream inputStream, C2308e eVar) {
        try {
            C2128b.a aVar = C2128b.f18665d;
            String A4 = s.A(C2452a.c(inputStream));
            aVar.d();
            return (h) aVar.a(h.Companion.serializer(), A4);
        } catch (Exception e5) {
            throw new CorruptionException("Cannot parse session configs", e5);
        }
    }
}
