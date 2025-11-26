package androidx.room;

import java.util.List;
import k3.q;

public final /* synthetic */ class a implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String[] f419a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f420b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f421c;

    public /* synthetic */ a(String[] strArr, List list, int i5) {
        this.f419a = strArr;
        this.f420b = list;
        this.f421c = i5;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return AmbiguousColumnResolver.resolve$lambda$16$lambda$7(this.f419a, this.f420b, this.f421c, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), (List) obj3);
    }
}
