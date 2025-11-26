package M3;

import H3.b;
import J3.f;
import J3.n;
import K3.e;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;
import kotlin.jvm.internal.t;

/* renamed from: M3.d  reason: case insensitive filesystem */
public final class C2130d implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final C2130d f18670a = new C2130d();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18671b = a.f18672b;

    /* renamed from: M3.d$a */
    private static final class a implements f {

        /* renamed from: b  reason: collision with root package name */
        public static final a f18672b = new a();

        /* renamed from: c  reason: collision with root package name */
        private static final String f18673c = "kotlinx.serialization.json.JsonArray";

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ f f18674a = I3.a.h(p.f18692a).getDescriptor();

        private a() {
        }

        public String a() {
            return f18673c;
        }

        public boolean c() {
            return this.f18674a.c();
        }

        public int d(String str) {
            t.e(str, RewardPlus.NAME);
            return this.f18674a.d(str);
        }

        public int e() {
            return this.f18674a.e();
        }

        public String f(int i5) {
            return this.f18674a.f(i5);
        }

        public List g(int i5) {
            return this.f18674a.g(i5);
        }

        public List getAnnotations() {
            return this.f18674a.getAnnotations();
        }

        public n getKind() {
            return this.f18674a.getKind();
        }

        public f h(int i5) {
            return this.f18674a.h(i5);
        }

        public boolean i(int i5) {
            return this.f18674a.i(i5);
        }

        public boolean isInline() {
            return this.f18674a.isInline();
        }
    }

    private C2130d() {
    }

    /* renamed from: a */
    public C2129c deserialize(e eVar) {
        t.e(eVar, "decoder");
        q.g(eVar);
        return new C2129c((List) I3.a.h(p.f18692a).deserialize(eVar));
    }

    /* renamed from: b */
    public void serialize(K3.f fVar, C2129c cVar) {
        t.e(fVar, "encoder");
        t.e(cVar, "value");
        q.h(fVar);
        I3.a.h(p.f18692a).serialize(fVar, cVar);
    }

    public f getDescriptor() {
        return f18671b;
    }
}
