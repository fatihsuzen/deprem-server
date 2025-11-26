package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class w0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f719a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f720b;

    public /* synthetic */ w0(String str, String str2) {
        this.f719a = str;
        this.f720b = str2;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getScheduleRequestedAtLiveData$lambda$23(this.f719a, this.f720b, (SQLiteConnection) obj);
    }
}
