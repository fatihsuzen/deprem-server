package com.squareup.picasso;

import M1.c;
import U3.C2204c;
import U3.e;
import U3.u;
import U3.x;
import U3.z;
import android.content.Context;
import java.io.File;

public final class r implements c {

    /* renamed from: a  reason: collision with root package name */
    final e.a f13353a;

    /* renamed from: b  reason: collision with root package name */
    private final C2204c f13354b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13355c;

    public r(Context context) {
        this(C.f(context));
    }

    public z a(x xVar) {
        return this.f13353a.a(xVar).execute();
    }

    public r(File file) {
        this(file, C.a(file));
    }

    public r(File file, long j5) {
        this(new u.b().b(new C2204c(file, j5)).a());
        this.f13355c = false;
    }

    public r(u uVar) {
        this.f13355c = true;
        this.f13353a = uVar;
        this.f13354b = uVar.c();
    }
}
