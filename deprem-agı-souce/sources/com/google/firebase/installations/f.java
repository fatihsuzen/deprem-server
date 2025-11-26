package com.google.firebase.installations;

import T0.d;
import k0.C1699m;

class f implements h {

    /* renamed from: a  reason: collision with root package name */
    final C1699m f7259a;

    public f(C1699m mVar) {
        this.f7259a = mVar;
    }

    public boolean a(d dVar) {
        if (!dVar.l() && !dVar.k() && !dVar.i()) {
            return false;
        }
        this.f7259a.e(dVar.d());
        return true;
    }

    public boolean b(Exception exc) {
        return false;
    }
}
