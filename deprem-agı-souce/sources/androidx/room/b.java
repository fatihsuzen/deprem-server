package androidx.room;

import java.util.List;
import k3.l;

public final /* synthetic */ class b implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f422a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f423b;

    public /* synthetic */ b(List list, int i5) {
        this.f422a = list;
        this.f423b = i5;
    }

    public final Object invoke(Object obj) {
        return AmbiguousColumnResolver.resolve$lambda$16$lambda$15(this.f422a, this.f423b, (List) obj);
    }
}
