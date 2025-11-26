package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class T implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f607a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f608b;

    public /* synthetic */ T(String str, String str2) {
        this.f607a = str;
        this.f608b = str2;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.incrementPeriodCount$lambda$40(this.f607a, this.f608b, (SQLiteConnection) obj);
    }
}
