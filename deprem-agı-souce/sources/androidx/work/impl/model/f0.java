package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import java.util.List;
import k3.l;

public final /* synthetic */ class f0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f642a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f643b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WorkSpecDao_Impl f644c;

    public /* synthetic */ f0(String str, List list, WorkSpecDao_Impl workSpecDao_Impl) {
        this.f642a = str;
        this.f643b = list;
        this.f644c = workSpecDao_Impl;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getWorkStatusPojoLiveDataForIds$lambda$10(this.f642a, this.f643b, this.f644c, (SQLiteConnection) obj);
    }
}
