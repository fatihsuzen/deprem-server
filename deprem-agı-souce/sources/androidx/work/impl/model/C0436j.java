package androidx.work.impl.model;

import androidx.room.RoomRawQuery;
import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.j  reason: case insensitive filesystem */
public final /* synthetic */ class C0436j implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f657a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RoomRawQuery f658b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RawWorkInfoDao_Impl f659c;

    public /* synthetic */ C0436j(String str, RoomRawQuery roomRawQuery, RawWorkInfoDao_Impl rawWorkInfoDao_Impl) {
        this.f657a = str;
        this.f658b = roomRawQuery;
        this.f659c = rawWorkInfoDao_Impl;
    }

    public final Object invoke(Object obj) {
        return RawWorkInfoDao_Impl.getWorkInfoPojos$lambda$0(this.f657a, this.f658b, this.f659c, (SQLiteConnection) obj);
    }
}
