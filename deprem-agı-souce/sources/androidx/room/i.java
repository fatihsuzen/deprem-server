package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import k3.l;

public final /* synthetic */ class i implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RoomConnectionManager f439a;

    public /* synthetic */ i(RoomConnectionManager roomConnectionManager) {
        this.f439a = roomConnectionManager;
    }

    public final Object invoke(Object obj) {
        return RoomConnectionManager._init_$lambda$1(this.f439a, (SupportSQLiteDatabase) obj);
    }
}
