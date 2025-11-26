package com.google.firebase.installations;

import T0.d;
import k0.C1699m;

class e implements h {

    /* renamed from: a  reason: collision with root package name */
    private final i f7257a;

    /* renamed from: b  reason: collision with root package name */
    private final C1699m f7258b;

    public e(i iVar, C1699m mVar) {
        this.f7257a = iVar;
        this.f7258b = mVar;
    }

    public boolean a(d dVar) {
        if (!dVar.k() || this.f7257a.f(dVar)) {
            return false;
        }
        this.f7258b.c(g.a().b(dVar.b()).d(dVar.c()).c(dVar.h()).a());
        return true;
    }

    public boolean b(Exception exc) {
        this.f7258b.d(exc);
        return true;
    }
}
