package X0;

import com.google.firebase.messaging.K;

public final class b {

    /* renamed from: b  reason: collision with root package name */
    private static final b f4478b = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final a f4479a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private a f4480a = null;

        a() {
        }

        public b a() {
            return new b(this.f4480a);
        }

        public a b(a aVar) {
            this.f4480a = aVar;
            return this;
        }
    }

    b(a aVar) {
        this.f4479a = aVar;
    }

    public static a b() {
        return new a();
    }

    public a a() {
        return this.f4479a;
    }

    public byte[] c() {
        return K.a(this);
    }
}
