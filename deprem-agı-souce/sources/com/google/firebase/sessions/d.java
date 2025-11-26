package com.google.firebase.sessions;

import T2.a;
import android.content.Context;
import androidx.datastore.core.DataStore;
import b3.C2312i;
import com.google.firebase.sessions.b;
import d1.C1625b;

public final class d implements C1625b {

    /* renamed from: a  reason: collision with root package name */
    private final a f7520a;

    /* renamed from: b  reason: collision with root package name */
    private final a f7521b;

    public d(a aVar, a aVar2) {
        this.f7520a = aVar;
        this.f7521b = aVar2;
    }

    public static d a(a aVar, a aVar2) {
        return new d(aVar, aVar2);
    }

    public static DataStore c(Context context, C2312i iVar) {
        return (DataStore) d1.d.d(b.C0073b.f7517a.j(context, iVar));
    }

    /* renamed from: b */
    public DataStore get() {
        return c((Context) this.f7520a.get(), (C2312i) this.f7521b.get());
    }
}
