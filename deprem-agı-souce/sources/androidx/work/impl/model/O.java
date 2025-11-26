package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import java.util.List;
import k3.l;

public final /* synthetic */ class O implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f597a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f598b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WorkSpecDao_Impl f599c;

    public /* synthetic */ O(String str, List list, WorkSpecDao_Impl workSpecDao_Impl) {
        this.f597a = str;
        this.f598b = list;
        this.f599c = workSpecDao_Impl;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getWorkStatusPojoFlowDataForIds$lambda$11(this.f597a, this.f598b, this.f599c, (SQLiteConnection) obj);
    }
}
