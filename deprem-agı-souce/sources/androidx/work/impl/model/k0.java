package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class k0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f666a;

    public /* synthetic */ k0(String str) {
        this.f666a = str;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getRunningWork$lambda$33(this.f666a, (SQLiteConnection) obj);
    }
}
