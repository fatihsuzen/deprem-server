package androidx.work.impl.model;

import androidx.collection.ArrayMap;
import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.m  reason: case insensitive filesystem */
public final /* synthetic */ class C0439m implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RawWorkInfoDao_Impl f672a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SQLiteConnection f673b;

    public /* synthetic */ C0439m(RawWorkInfoDao_Impl rawWorkInfoDao_Impl, SQLiteConnection sQLiteConnection) {
        this.f672a = rawWorkInfoDao_Impl;
        this.f673b = sQLiteConnection;
    }

    public final Object invoke(Object obj) {
        return RawWorkInfoDao_Impl.__fetchRelationshipWorkTagAsjavaLangString$lambda$3(this.f672a, this.f673b, (ArrayMap) obj);
    }
}
