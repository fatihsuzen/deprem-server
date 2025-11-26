package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import java.util.List;
import k3.l;

public final /* synthetic */ class A implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f738a;

    public /* synthetic */ A(List list) {
        this.f738a = list;
    }

    public final Object invoke(Object obj) {
        return StatusRunnable.forStringIds$lambda$0(this.f738a, (WorkDatabase) obj);
    }
}
