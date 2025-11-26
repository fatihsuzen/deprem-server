package N0;

import K0.d;
import K0.e;
import L0.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final Map f3180a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f3181b;

    /* renamed from: c  reason: collision with root package name */
    private final d f3182c;

    public static final class a implements b {

        /* renamed from: d  reason: collision with root package name */
        private static final d f3183d = new g();

        /* renamed from: a  reason: collision with root package name */
        private final Map f3184a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final Map f3185b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        private d f3186c = f3183d;

        public static /* synthetic */ void b(Object obj, e eVar) {
            throw new K0.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }

        public h c() {
            return new h(new HashMap(this.f3184a), new HashMap(this.f3185b), this.f3186c);
        }

        public a d(L0.a aVar) {
            aVar.a(this);
            return this;
        }

        /* renamed from: e */
        public a a(Class cls, d dVar) {
            this.f3184a.put(cls, dVar);
            this.f3185b.remove(cls);
            return this;
        }
    }

    h(Map map, Map map2, d dVar) {
        this.f3180a = map;
        this.f3181b = map2;
        this.f3182c = dVar;
    }

    public static a a() {
        return new a();
    }

    public void b(Object obj, OutputStream outputStream) {
        new f(outputStream, this.f3180a, this.f3181b, this.f3182c).t(obj);
    }

    public byte[] c(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            b(obj, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
