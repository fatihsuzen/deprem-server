package androidx.room;

import androidx.sqlite.SQLiteStatement;
import k3.l;

public final /* synthetic */ class m implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f443a;

    public /* synthetic */ m(l lVar) {
        this.f443a = lVar;
    }

    public final Object invoke(Object obj) {
        return RoomRawQuery.bindingFunction$lambda$1(this.f443a, (SQLiteStatement) obj);
    }
}
