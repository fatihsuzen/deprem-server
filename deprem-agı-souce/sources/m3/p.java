package M3;

import H3.b;
import J3.a;
import J3.d;
import J3.f;
import J3.m;
import K3.e;
import W2.J;
import W2.q;
import java.util.List;
import kotlin.jvm.internal.t;

public final class p implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final p f18692a = new p();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18693b = m.h("kotlinx.serialization.json.JsonElement", d.b.f18358a, new f[0], new j());

    private p() {
    }

    /* access modifiers changed from: private */
    public static final J g(a aVar) {
        t.e(aVar, "$this$buildSerialDescriptor");
        a aVar2 = aVar;
        a.b(aVar2, "JsonPrimitive", q.f(new k()), (List) null, false, 12, (Object) null);
        a aVar3 = aVar2;
        a.b(aVar3, "JsonNull", q.f(new l()), (List) null, false, 12, (Object) null);
        a.b(aVar3, "JsonLiteral", q.f(new m()), (List) null, false, 12, (Object) null);
        a.b(aVar3, "JsonObject", q.f(new n()), (List) null, false, 12, (Object) null);
        a.b(aVar3, "JsonArray", q.f(new o()), (List) null, false, 12, (Object) null);
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final f h() {
        return C.f18658a.getDescriptor();
    }

    /* access modifiers changed from: private */
    public static final f i() {
        return x.f18701a.getDescriptor();
    }

    /* access modifiers changed from: private */
    public static final f j() {
        return t.f18698a.getDescriptor();
    }

    /* access modifiers changed from: private */
    public static final f k() {
        return A.f18653a.getDescriptor();
    }

    /* access modifiers changed from: private */
    public static final f l() {
        return C2130d.f18670a.getDescriptor();
    }

    public f getDescriptor() {
        return f18693b;
    }

    /* renamed from: m */
    public h deserialize(e eVar) {
        t.e(eVar, "decoder");
        return q.d(eVar).b();
    }

    /* renamed from: n */
    public void serialize(K3.f fVar, h hVar) {
        t.e(fVar, "encoder");
        t.e(hVar, "value");
        q.h(fVar);
        if (hVar instanceof B) {
            fVar.encodeSerializableValue(C.f18658a, hVar);
        } else if (hVar instanceof z) {
            fVar.encodeSerializableValue(A.f18653a, hVar);
        } else if (hVar instanceof C2129c) {
            fVar.encodeSerializableValue(C2130d.f18670a, hVar);
        } else {
            throw new q();
        }
    }
}
