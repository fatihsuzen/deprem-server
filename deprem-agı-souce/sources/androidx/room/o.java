package androidx.room;

import androidx.sqlite.SQLiteStatement;
import k3.l;

public final /* synthetic */ class o implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RoomSQLiteQuery f444a;

    public /* synthetic */ o(RoomSQLiteQuery roomSQLiteQuery) {
        this.f444a = roomSQLiteQuery;
    }

    public final Object invoke(Object obj) {
        return RoomSQLiteQuery.toRoomRawQuery$lambda$1(this.f444a, (SQLiteStatement) obj);
    }
}
