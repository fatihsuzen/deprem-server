package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.a0  reason: case insensitive filesystem */
public final /* synthetic */ class C0426a0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f622a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f623b;

    public /* synthetic */ C0426a0(String str, String str2) {
        this.f622a = str;
        this.f623b = str2;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getInputsFromPrerequisites$lambda$18(this.f622a, this.f623b, (SQLiteConnection) obj);
    }
}
