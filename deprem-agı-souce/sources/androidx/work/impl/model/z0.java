package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class z0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f728a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f729b;

    public /* synthetic */ z0(String str, String str2) {
        this.f728a = str;
        this.f729b = str2;
    }

    public final Object invoke(Object obj) {
        return WorkTagDao_Impl.getTagsForWorkSpecId$lambda$2(this.f728a, this.f729b, (SQLiteConnection) obj);
    }
}
