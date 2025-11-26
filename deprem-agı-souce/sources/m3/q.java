package M3;

import J3.f;
import J3.n;
import K3.e;
import W2.C2223l;
import W2.m;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;
import k3.C2616a;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;

public abstract class q {

    public static final class a implements f {

        /* renamed from: a  reason: collision with root package name */
        private final C2223l f18694a;

        a(C2616a aVar) {
            this.f18694a = m.b(aVar);
        }

        private final f b() {
            return (f) this.f18694a.getValue();
        }

        public String a() {
            return b().a();
        }

        public boolean c() {
            return f.a.c(this);
        }

        public int d(String str) {
            t.e(str, RewardPlus.NAME);
            return b().d(str);
        }

        public int e() {
            return b().e();
        }

        public String f(int i5) {
            return b().f(i5);
        }

        public List g(int i5) {
            return b().g(i5);
        }

        public List getAnnotations() {
            return f.a.a(this);
        }

        public n getKind() {
            return b().getKind();
        }

        public f h(int i5) {
            return b().h(i5);
        }

        public boolean i(int i5) {
            return b().i(i5);
        }

        public boolean isInline() {
            return f.a.b(this);
        }
    }

    public static final g d(e eVar) {
        g gVar;
        t.e(eVar, "<this>");
        if (eVar instanceof g) {
            gVar = (g) eVar;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            return gVar;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + M.b(eVar.getClass()));
    }

    public static final r e(K3.f fVar) {
        r rVar;
        t.e(fVar, "<this>");
        if (fVar instanceof r) {
            rVar = (r) fVar;
        } else {
            rVar = null;
        }
        if (rVar != null) {
            return rVar;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + M.b(fVar.getClass()));
    }

    /* access modifiers changed from: private */
    public static final f f(C2616a aVar) {
        return new a(aVar);
    }

    /* access modifiers changed from: private */
    public static final void g(e eVar) {
        d(eVar);
    }

    /* access modifiers changed from: private */
    public static final void h(K3.f fVar) {
        e(fVar);
    }
}
