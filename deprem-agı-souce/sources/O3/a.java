package O3;

import java.util.List;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public abstract class a {

    /* renamed from: O3.a$a  reason: collision with other inner class name */
    public static final class C0179a extends a {

        /* renamed from: a  reason: collision with root package name */
        private final H3.b f18848a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0179a(H3.b bVar) {
            super((C2633k) null);
            t.e(bVar, "serializer");
            this.f18848a = bVar;
        }

        public H3.b a(List list) {
            t.e(list, "typeArgumentsSerializers");
            return this.f18848a;
        }

        public final H3.b b() {
            return this.f18848a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0179a) || !t.a(((C0179a) obj).f18848a, this.f18848a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f18848a.hashCode();
        }
    }

    public static final class b extends a {

        /* renamed from: a  reason: collision with root package name */
        private final l f18849a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(l lVar) {
            super((C2633k) null);
            t.e(lVar, "provider");
            this.f18849a = lVar;
        }

        public H3.b a(List list) {
            t.e(list, "typeArgumentsSerializers");
            return (H3.b) this.f18849a.invoke(list);
        }

        public final l b() {
            return this.f18849a;
        }
    }

    public /* synthetic */ a(C2633k kVar) {
        this();
    }

    public abstract H3.b a(List list);

    private a() {
    }
}
