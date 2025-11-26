package com.google.firebase.sessions;

import T2.a;
import android.content.Context;
import androidx.datastore.core.DataStore;
import b1.I;
import b3.C2312i;
import com.google.firebase.sessions.b;
import d1.C1625b;
import d1.d;

public final class e implements C1625b {

    /* renamed from: a  reason: collision with root package name */
    private final a f7522a;

    /* renamed from: b  reason: collision with root package name */
    private final a f7523b;

    /* renamed from: c  reason: collision with root package name */
    private final a f7524c;

    public e(a aVar, a aVar2, a aVar3) {
        this.f7522a = aVar;
        this.f7523b = aVar2;
        this.f7524c = aVar3;
    }

    public static e a(a aVar, a aVar2, a aVar3) {
        return new e(aVar, aVar2, aVar3);
    }

    public static DataStore c(Context context, C2312i iVar, I i5) {
        return (DataStore) d.d(b.C0073b.f7517a.m(context, iVar, i5));
    }

    /* renamed from: b */
    public DataStore get() {
        return c((Context) this.f7522a.get(), (C2312i) this.f7523b.get(), (I) this.f7524c.get());
    }
}
