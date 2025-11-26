package b1;

import M3.C2128b;
import W2.J;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.Serializer;
import b3.C2308e;
import h3.C2452a;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;

public final class I implements Serializer {

    /* renamed from: a  reason: collision with root package name */
    private final Q f4537a;

    public I(Q q5) {
        t.e(q5, "sessionGenerator");
        this.f4537a = q5;
    }

    /* renamed from: a */
    public H getDefaultValue() {
        return new H(this.f4537a.a((K) null), (Z) null, (Map) null, 6, (C2633k) null);
    }

    /* renamed from: b */
    public Object writeTo(H h5, OutputStream outputStream, C2308e eVar) {
        outputStream.write(s.B(C2128b.f18665d.b(H.Companion.serializer(), h5)));
        return J.f19942a;
    }

    public Object readFrom(InputStream inputStream, C2308e eVar) {
        try {
            C2128b.a aVar = C2128b.f18665d;
            String A4 = s.A(C2452a.c(inputStream));
            aVar.d();
            return (H) aVar.a(H.Companion.serializer(), A4);
        } catch (Exception e5) {
            throw new CorruptionException("Cannot parse session data", e5);
        }
    }
}
