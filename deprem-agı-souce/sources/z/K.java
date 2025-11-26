package z;

import android.database.sqlite.SQLiteDatabase;
import z.M;

public final /* synthetic */ class K implements M.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ M f17100a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f17101b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f17102c;

    public /* synthetic */ K(M m5, String str, String str2) {
        this.f17100a = m5;
        this.f17101b = str;
        this.f17102c = str2;
    }

    public final Object apply(Object obj) {
        return M.u(this.f17100a, this.f17101b, this.f17102c, (SQLiteDatabase) obj);
    }
}
