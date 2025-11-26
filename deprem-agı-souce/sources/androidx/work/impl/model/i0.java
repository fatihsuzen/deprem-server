package androidx.work.impl.model;

import androidx.collection.ArrayMap;
import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class i0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkSpecDao_Impl f655a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SQLiteConnection f656b;

    public /* synthetic */ i0(WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection) {
        this.f655a = workSpecDao_Impl;
        this.f656b = sQLiteConnection;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData$lambda$53(this.f655a, this.f656b, (ArrayMap) obj);
    }
}
