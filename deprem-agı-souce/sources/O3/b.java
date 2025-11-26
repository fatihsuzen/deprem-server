package O3;

import O3.a;
import W2.q;
import java.util.List;
import java.util.Map;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.S;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class b extends d {

    /* renamed from: a  reason: collision with root package name */
    private final Map f18850a;

    /* renamed from: b  reason: collision with root package name */
    public final Map f18851b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f18852c;

    /* renamed from: d  reason: collision with root package name */
    private final Map f18853d;

    /* renamed from: e  reason: collision with root package name */
    private final Map f18854e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f18855f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Map map, Map map2, Map map3, Map map4, Map map5, boolean z4) {
        super((C2633k) null);
        t.e(map, "class2ContextualFactory");
        t.e(map2, "polyBase2Serializers");
        t.e(map3, "polyBase2DefaultSerializerProvider");
        t.e(map4, "polyBase2NamedSerializers");
        t.e(map5, "polyBase2DefaultDeserializerProvider");
        this.f18850a = map;
        this.f18851b = map2;
        this.f18852c = map3;
        this.f18853d = map4;
        this.f18854e = map5;
        this.f18855f = z4;
    }

    public void a(g gVar) {
        t.e(gVar, "collector");
        for (Map.Entry entry : this.f18850a.entrySet()) {
            C2733c cVar = (C2733c) entry.getKey();
            a aVar = (a) entry.getValue();
            if (aVar instanceof a.C0179a) {
                t.c(cVar, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                H3.b b5 = ((a.C0179a) aVar).b();
                t.c(b5, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                gVar.e(cVar, b5);
            } else if (aVar instanceof a.b) {
                gVar.c(cVar, ((a.b) aVar).b());
            } else {
                throw new q();
            }
        }
        for (Map.Entry entry2 : this.f18851b.entrySet()) {
            C2733c cVar2 = (C2733c) entry2.getKey();
            for (Map.Entry entry3 : ((Map) entry2.getValue()).entrySet()) {
                C2733c cVar3 = (C2733c) entry3.getKey();
                H3.b bVar = (H3.b) entry3.getValue();
                t.c(cVar2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                t.c(cVar3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                t.c(bVar, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                gVar.d(cVar2, cVar3, bVar);
            }
        }
        for (Map.Entry entry4 : this.f18852c.entrySet()) {
            C2733c cVar4 = (C2733c) entry4.getKey();
            l lVar = (l) entry4.getValue();
            t.c(cVar4, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            t.c(lVar, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"value\")] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>");
            gVar.b(cVar4, (l) S.c(lVar, 1));
        }
        for (Map.Entry entry5 : this.f18854e.entrySet()) {
            C2733c cVar5 = (C2733c) entry5.getKey();
            l lVar2 = (l) entry5.getValue();
            t.c(cVar5, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            t.c(lVar2, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"className\")] kotlin.String?, kotlinx.serialization.DeserializationStrategy<kotlin.Any>?>");
            gVar.a(cVar5, (l) S.c(lVar2, 1));
        }
    }

    public H3.b b(C2733c cVar, List list) {
        H3.b bVar;
        t.e(cVar, "kClass");
        t.e(list, "typeArgumentsSerializers");
        a aVar = (a) this.f18850a.get(cVar);
        if (aVar != null) {
            bVar = aVar.a(list);
        } else {
            bVar = null;
        }
        if (bVar instanceof H3.b) {
            return bVar;
        }
        return null;
    }

    public boolean d() {
        return this.f18855f;
    }

    public H3.a e(C2733c cVar, String str) {
        H3.b bVar;
        l lVar;
        t.e(cVar, "baseClass");
        Map map = (Map) this.f18853d.get(cVar);
        if (map != null) {
            bVar = (H3.b) map.get(str);
        } else {
            bVar = null;
        }
        if (!(bVar instanceof H3.b)) {
            bVar = null;
        }
        if (bVar != null) {
            return bVar;
        }
        Object obj = this.f18854e.get(cVar);
        if (S.g(obj, 1)) {
            lVar = (l) obj;
        } else {
            lVar = null;
        }
        if (lVar != null) {
            return (H3.a) lVar.invoke(str);
        }
        return null;
    }

    public H3.l f(C2733c cVar, Object obj) {
        H3.b bVar;
        H3.l lVar;
        l lVar2;
        t.e(cVar, "baseClass");
        t.e(obj, "value");
        if (!cVar.f(obj)) {
            return null;
        }
        Map map = (Map) this.f18851b.get(cVar);
        if (map != null) {
            bVar = (H3.b) map.get(M.b(obj.getClass()));
        } else {
            bVar = null;
        }
        if (bVar instanceof H3.l) {
            lVar = bVar;
        } else {
            lVar = null;
        }
        if (lVar != null) {
            return lVar;
        }
        Object obj2 = this.f18852c.get(cVar);
        if (S.g(obj2, 1)) {
            lVar2 = (l) obj2;
        } else {
            lVar2 = null;
        }
        if (lVar2 != null) {
            return (H3.l) lVar2.invoke(obj);
        }
        return null;
    }
}
