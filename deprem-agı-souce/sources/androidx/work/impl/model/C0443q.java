package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.q  reason: case insensitive filesystem */
public final /* synthetic */ class C0443q implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f689a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f690b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f691c;

    public /* synthetic */ C0443q(String str, String str2, int i5) {
        this.f689a = str;
        this.f690b = str2;
        this.f691c = i5;
    }

    public final Object invoke(Object obj) {
        return SystemIdInfoDao_Impl.removeSystemIdInfo$lambda$3(this.f689a, this.f690b, this.f691c, (SQLiteConnection) obj);
    }
}
