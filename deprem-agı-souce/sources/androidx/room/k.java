package androidx.room;

import k3.l;

public final /* synthetic */ class k implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RoomDatabase f441a;

    public /* synthetic */ k(RoomDatabase roomDatabase) {
        this.f441a = roomDatabase;
    }

    public final Object invoke(Object obj) {
        return RoomDatabase.createConnectionManager$lambda$1(this.f441a, (DatabaseConfiguration) obj);
    }
}
