package androidx.work.impl.model;

import androidx.room.RoomRawQuery;
import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.l  reason: case insensitive filesystem */
public final /* synthetic */ class C0438l implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f667a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RoomRawQuery f668b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RawWorkInfoDao_Impl f669c;

    public /* synthetic */ C0438l(String str, RoomRawQuery roomRawQuery, RawWorkInfoDao_Impl rawWorkInfoDao_Impl) {
        this.f667a = str;
        this.f668b = roomRawQuery;
        this.f669c = rawWorkInfoDao_Impl;
    }

    public final Object invoke(Object obj) {
        return RawWorkInfoDao_Impl.getWorkInfoPojosLiveData$lambda$1(this.f667a, this.f668b, this.f669c, (SQLiteConnection) obj);
    }
}
