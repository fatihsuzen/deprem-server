package com.mbridge.msdk.newreward.function.c.c;

import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;

public abstract class c extends d<String> {

    /* renamed from: b  reason: collision with root package name */
    protected Boolean f10625b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f10626c;

    public c(b bVar, a aVar) {
        super(bVar, aVar);
    }

    public final void a(String str) {
        this.f10626c = str;
    }

    /* access modifiers changed from: protected */
    public abstract boolean a_();

    public final boolean g() {
        return false;
    }

    public final boolean h() {
        Boolean bool = this.f10625b;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean a_ = a_();
        this.f10625b = Boolean.valueOf(a_);
        return a_;
    }

    public final String i() {
        return this.f10626c;
    }

    public final /* bridge */ /* synthetic */ Object a() {
        return this.f10626c;
    }
}
