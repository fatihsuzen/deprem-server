package androidx.work.impl.model;

import androidx.collection.ArrayMap;
import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.i  reason: case insensitive filesystem */
public final /* synthetic */ class C0435i implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RawWorkInfoDao_Impl f653a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SQLiteConnection f654b;

    public /* synthetic */ C0435i(RawWorkInfoDao_Impl rawWorkInfoDao_Impl, SQLiteConnection sQLiteConnection) {
        this.f653a = rawWorkInfoDao_Impl;
        this.f654b = sQLiteConnection;
    }

    public final Object invoke(Object obj) {
        return RawWorkInfoDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData$lambda$4(this.f653a, this.f654b, (ArrayMap) obj);
    }
}
