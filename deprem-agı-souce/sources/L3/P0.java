package L3;

import H3.b;
import J3.f;
import X2.C2242i;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2625c;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class P0 extends C2119w {

    /* renamed from: b  reason: collision with root package name */
    private final C2733c f18476b;

    /* renamed from: c  reason: collision with root package name */
    private final f f18477c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public P0(C2733c cVar, b bVar) {
        super(bVar, (C2633k) null);
        t.e(cVar, "kClass");
        t.e(bVar, "eSerializer");
        this.f18476b = cVar;
        this.f18477c = new C2082d(bVar.getDescriptor());
    }

    public f getDescriptor() {
        return this.f18477c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public ArrayList a() {
        return new ArrayList();
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public int b(ArrayList arrayList) {
        t.e(arrayList, "<this>");
        return arrayList.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public void c(ArrayList arrayList, int i5) {
        t.e(arrayList, "<this>");
        arrayList.ensureCapacity(i5);
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public Iterator d(Object[] objArr) {
        t.e(objArr, "<this>");
        return C2625c.a(objArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public int e(Object[] objArr) {
        t.e(objArr, "<this>");
        return objArr.length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public void n(ArrayList arrayList, int i5, Object obj) {
        t.e(arrayList, "<this>");
        arrayList.add(i5, obj);
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public ArrayList k(Object[] objArr) {
        t.e(objArr, "<this>");
        return new ArrayList(C2242i.g(objArr));
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public Object[] l(ArrayList arrayList) {
        t.e(arrayList, "<this>");
        return A0.q(arrayList, this.f18476b);
    }
}
