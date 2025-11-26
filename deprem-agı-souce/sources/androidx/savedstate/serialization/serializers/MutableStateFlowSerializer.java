package androidx.savedstate.serialization.serializers;

import H3.b;
import J3.e;
import J3.f;
import J3.m;
import J3.n;
import kotlin.jvm.internal.t;
import z3.F;
import z3.w;

public final class MutableStateFlowSerializer<T> implements b {
    private final f descriptor;
    private final b valueSerializer;

    public MutableStateFlowSerializer(b bVar) {
        f fVar;
        t.e(bVar, "valueSerializer");
        this.valueSerializer = bVar;
        n kind = bVar.getDescriptor().getKind();
        if (kind instanceof e) {
            fVar = m.c("kotlinx.coroutines.flow.MutableStateFlow", (e) kind);
        } else {
            fVar = m.d("kotlinx.coroutines.flow.MutableStateFlow", bVar.getDescriptor());
        }
        this.descriptor = fVar;
    }

    public static /* synthetic */ void getDescriptor$annotations() {
    }

    public f getDescriptor() {
        return this.descriptor;
    }

    public w deserialize(K3.e eVar) {
        t.e(eVar, "decoder");
        return F.a(eVar.decodeSerializableValue(this.valueSerializer));
    }

    public void serialize(K3.f fVar, w wVar) {
        t.e(fVar, "encoder");
        t.e(wVar, "value");
        fVar.encodeSerializableValue(this.valueSerializer, wVar.getValue());
    }
}
