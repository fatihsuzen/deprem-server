package androidx.room;

import androidx.room.CoroutinesRoom;
import androidx.sqlite.SQLiteConnection;
import java.util.concurrent.Callable;
import k3.l;

public final /* synthetic */ class e implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Callable f435a;

    public /* synthetic */ e(Callable callable) {
        this.f435a = callable;
    }

    public final Object invoke(Object obj) {
        return CoroutinesRoom.Companion.createFlow$lambda$1(this.f435a, (SQLiteConnection) obj);
    }
}
