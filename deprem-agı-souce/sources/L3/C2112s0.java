package L3;

import H3.b;
import J3.f;
import K3.e;
import kotlin.jvm.internal.t;

/* renamed from: L3.s0  reason: case insensitive filesystem */
public final class C2112s0 implements b {

    /* renamed from: a  reason: collision with root package name */
    private final b f18583a;

    /* renamed from: b  reason: collision with root package name */
    private final f f18584b;

    public C2112s0(b bVar) {
        t.e(bVar, "serializer");
        this.f18583a = bVar;
        this.f18584b = new Q0(bVar.getDescriptor());
    }

    public Object deserialize(e eVar) {
        t.e(eVar, "decoder");
        if (eVar.decodeNotNullMark()) {
            return eVar.decodeSerializableValue(this.f18583a);
        }
        return eVar.decodeNull();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2112s0.class != obj.getClass() || !t.a(this.f18583a, ((C2112s0) obj).f18583a)) {
            return false;
        }
        return true;
    }

    public f getDescriptor() {
        return this.f18584b;
    }

    public int hashCode() {
        return this.f18583a.hashCode();
    }

    public void serialize(K3.f fVar, Object obj) {
        t.e(fVar, "encoder");
        if (obj != null) {
            fVar.encodeNotNullMark();
            fVar.encodeSerializableValue(this.f18583a, obj);
            return;
        }
        fVar.encodeNull();
    }
}
