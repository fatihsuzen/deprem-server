package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import java.util.List;
import k3.l;

public final /* synthetic */ class r0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f698a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f699b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WorkSpecDao_Impl f700c;

    public /* synthetic */ r0(String str, List list, WorkSpecDao_Impl workSpecDao_Impl) {
        this.f698a = str;
        this.f699b = list;
        this.f700c = workSpecDao_Impl;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getWorkStatusPojoForIds$lambda$9(this.f698a, this.f699b, this.f700c, (SQLiteConnection) obj);
    }
}
