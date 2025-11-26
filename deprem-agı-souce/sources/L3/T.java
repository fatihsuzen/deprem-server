package L3;

import H3.b;
import J3.f;
import K3.e;
import L3.M;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.jvm.internal.t;

public abstract class T {

    public static final class a implements M {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f18483a;

        a(b bVar) {
            this.f18483a = bVar;
        }

        public b[] childSerializers() {
            return new b[]{this.f18483a};
        }

        public Object deserialize(e eVar) {
            t.e(eVar, "decoder");
            throw new IllegalStateException("unsupported");
        }

        public f getDescriptor() {
            throw new IllegalStateException("unsupported");
        }

        public void serialize(K3.f fVar, Object obj) {
            t.e(fVar, "encoder");
            throw new IllegalStateException("unsupported");
        }

        public b[] typeParametersSerializers() {
            return M.a.a(this);
        }
    }

    public static final f a(String str, b bVar) {
        t.e(str, RewardPlus.NAME);
        t.e(bVar, "primitiveSerializer");
        return new S(str, new a(bVar));
    }
}
