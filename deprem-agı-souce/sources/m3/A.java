package M3;

import H3.b;
import J3.f;
import J3.n;
import K3.e;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;

public final class A implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final A f18653a = new A();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18654b = a.f18655b;

    private static final class a implements f {

        /* renamed from: b  reason: collision with root package name */
        public static final a f18655b = new a();

        /* renamed from: c  reason: collision with root package name */
        private static final String f18656c = "kotlinx.serialization.json.JsonObject";

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ f f18657a = I3.a.k(I3.a.H(Q.f24695a), p.f18692a).getDescriptor();

        private a() {
        }

        public String a() {
            return f18656c;
        }

        public boolean c() {
            return this.f18657a.c();
        }

        public int d(String str) {
            t.e(str, RewardPlus.NAME);
            return this.f18657a.d(str);
        }

        public int e() {
            return this.f18657a.e();
        }

        public String f(int i5) {
            return this.f18657a.f(i5);
        }

        public List g(int i5) {
            return this.f18657a.g(i5);
        }

        public List getAnnotations() {
            return this.f18657a.getAnnotations();
        }

        public n getKind() {
            return this.f18657a.getKind();
        }

        public f h(int i5) {
            return this.f18657a.h(i5);
        }

        public boolean i(int i5) {
            return this.f18657a.i(i5);
        }

        public boolean isInline() {
            return this.f18657a.isInline();
        }
    }

    private A() {
    }

    /* renamed from: a */
    public z deserialize(e eVar) {
        t.e(eVar, "decoder");
        q.g(eVar);
        return new z((Map) I3.a.k(I3.a.H(Q.f24695a), p.f18692a).deserialize(eVar));
    }

    /* renamed from: b */
    public void serialize(K3.f fVar, z zVar) {
        t.e(fVar, "encoder");
        t.e(zVar, "value");
        q.h(fVar);
        I3.a.k(I3.a.H(Q.f24695a), p.f18692a).serialize(fVar, zVar);
    }

    public f getDescriptor() {
        return f18654b;
    }
}
