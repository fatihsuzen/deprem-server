package u;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;

public final class d {

    /* renamed from: c  reason: collision with root package name */
    private static final d f16631c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final String f16632a;

    /* renamed from: b  reason: collision with root package name */
    private final List f16633b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f16634a = "";

        /* renamed from: b  reason: collision with root package name */
        private List f16635b = new ArrayList();

        a() {
        }

        public d a() {
            return new d(this.f16634a, DesugarCollections.unmodifiableList(this.f16635b));
        }

        public a b(List list) {
            this.f16635b = list;
            return this;
        }

        public a c(String str) {
            this.f16634a = str;
            return this;
        }
    }

    d(String str, List list) {
        this.f16632a = str;
        this.f16633b = list;
    }

    public static a c() {
        return new a();
    }

    public List a() {
        return this.f16633b;
    }

    public String b() {
        return this.f16632a;
    }
}
