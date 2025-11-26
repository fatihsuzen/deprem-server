package L3;

import H3.b;
import J3.a;
import J3.f;
import J3.m;
import W2.J;
import W2.s;
import W2.y;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: L3.x0  reason: case insensitive filesystem */
public final class C2122x0 extends Z {

    /* renamed from: c  reason: collision with root package name */
    private final f f18600c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2122x0(b bVar, b bVar2) {
        super(bVar, bVar2, (C2633k) null);
        t.e(bVar, "keySerializer");
        t.e(bVar2, "valueSerializer");
        this.f18600c = m.e("kotlin.Pair", new f[0], new C2120w0(bVar, bVar2));
    }

    /* access modifiers changed from: private */
    public static final J g(b bVar, b bVar2, a aVar) {
        t.e(aVar, "$this$buildClassSerialDescriptor");
        a aVar2 = aVar;
        a.b(aVar2, "first", bVar.getDescriptor(), (List) null, false, 12, (Object) null);
        a.b(aVar2, "second", bVar2.getDescriptor(), (List) null, false, 12, (Object) null);
        return J.f19942a;
    }

    public f getDescriptor() {
        return this.f18600c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public Object a(s sVar) {
        t.e(sVar, "<this>");
        return sVar.c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public Object c(s sVar) {
        t.e(sVar, "<this>");
        return sVar.d();
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public s e(Object obj, Object obj2) {
        return y.a(obj, obj2);
    }
}
