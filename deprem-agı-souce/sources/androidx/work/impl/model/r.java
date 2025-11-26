package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class r implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f695a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f696b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f697c;

    public /* synthetic */ r(String str, String str2, int i5) {
        this.f695a = str;
        this.f696b = str2;
        this.f697c = i5;
    }

    public final Object invoke(Object obj) {
        return SystemIdInfoDao_Impl.getSystemIdInfo$lambda$1(this.f695a, this.f696b, this.f697c, (SQLiteConnection) obj);
    }
}
