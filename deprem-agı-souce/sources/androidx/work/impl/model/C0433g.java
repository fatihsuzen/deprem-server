package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.g  reason: case insensitive filesystem */
public final /* synthetic */ class C0433g implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f645a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f646b;

    public /* synthetic */ C0433g(String str, String str2) {
        this.f645a = str;
        this.f646b = str2;
    }

    public final Object invoke(Object obj) {
        return PreferenceDao_Impl.getObservableLongValue$lambda$2(this.f645a, this.f646b, (SQLiteConnection) obj);
    }
}
