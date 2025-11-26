package androidx.work.impl.model;

import androidx.room.RoomRawQuery;
import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.k  reason: case insensitive filesystem */
public final /* synthetic */ class C0437k implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f663a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RoomRawQuery f664b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RawWorkInfoDao_Impl f665c;

    public /* synthetic */ C0437k(String str, RoomRawQuery roomRawQuery, RawWorkInfoDao_Impl rawWorkInfoDao_Impl) {
        this.f663a = str;
        this.f664b = roomRawQuery;
        this.f665c = rawWorkInfoDao_Impl;
    }

    public final Object invoke(Object obj) {
        return RawWorkInfoDao_Impl.getWorkInfoPojosFlow$lambda$2(this.f663a, this.f664b, this.f665c, (SQLiteConnection) obj);
    }
}
