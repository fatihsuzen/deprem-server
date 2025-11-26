package com.google.firebase.installations;

import P0.h;
import P0.i;
import S0.e;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import o0.f;
import q0.C1756a;
import q0.b;
import r0.C1786c;
import r0.C1788e;
import r0.F;
import r0.r;
import s0.j;

@Keep
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    public static /* synthetic */ e a(C1788e eVar) {
        return new c((f) eVar.a(f.class), eVar.c(i.class), (ExecutorService) eVar.e(F.a(C1756a.class, ExecutorService.class)), j.a((Executor) eVar.e(F.a(b.class, Executor.class))));
    }

    public List<C1786c> getComponents() {
        return Arrays.asList(new C1786c[]{C1786c.c(e.class).h(LIBRARY_NAME).b(r.k(f.class)).b(r.i(i.class)).b(r.l(F.a(C1756a.class, ExecutorService.class))).b(r.l(F.a(b.class, Executor.class))).f(new S0.f()).d(), h.a(), Z0.h.b(LIBRARY_NAME, "19.0.1")});
    }
}
