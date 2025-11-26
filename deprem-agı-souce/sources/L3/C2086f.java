package L3;

import H3.b;
import J3.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;

/* renamed from: L3.f  reason: case insensitive filesystem */
public final class C2086f extends C2121x {

    /* renamed from: b  reason: collision with root package name */
    private final f f18520b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2086f(b bVar) {
        super(bVar);
        t.e(bVar, "element");
        this.f18520b = new C2084e(bVar.getDescriptor());
    }

    public f getDescriptor() {
        return this.f18520b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public ArrayList a() {
        return new ArrayList();
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public int b(ArrayList arrayList) {
        t.e(arrayList, "<this>");
        return arrayList.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public void c(ArrayList arrayList, int i5) {
        t.e(arrayList, "<this>");
        arrayList.ensureCapacity(i5);
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public void n(ArrayList arrayList, int i5, Object obj) {
        t.e(arrayList, "<this>");
        arrayList.add(i5, obj);
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public ArrayList k(List list) {
        ArrayList arrayList;
        t.e(list, "<this>");
        if (list instanceof ArrayList) {
            arrayList = (ArrayList) list;
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            return new ArrayList(list);
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public List l(ArrayList arrayList) {
        t.e(arrayList, "<this>");
        return arrayList;
    }
}
