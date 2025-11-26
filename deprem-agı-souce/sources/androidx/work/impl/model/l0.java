package androidx.work.impl.model;

import androidx.collection.ArrayMap;
import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class l0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkSpecDao_Impl f670a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SQLiteConnection f671b;

    public /* synthetic */ l0(WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        this.f670a = workSpecDao_Impl;
        this.f671b = sQLiteConnection;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.__fetchRelationshipWorkTagAsjavaLangString$lambda$52(this.f670a, this.f671b, (ArrayMap) obj);
    }
}
