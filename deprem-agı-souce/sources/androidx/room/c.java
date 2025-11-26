package androidx.room;

import java.util.List;
import k3.l;
import kotlin.jvm.internal.L;

public final /* synthetic */ class c implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ L f424a;

    public /* synthetic */ c(L l5) {
        this.f424a = l5;
    }

    public final Object invoke(Object obj) {
        return AmbiguousColumnResolver.resolve$lambda$19(this.f424a, (List) obj);
    }
}
