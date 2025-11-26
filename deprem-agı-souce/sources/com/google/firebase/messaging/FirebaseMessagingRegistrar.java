package com.google.firebase.messaging;

import I0.b;
import O0.d;
import Q0.a;
import S0.e;
import Z0.h;
import Z0.i;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import o0.f;
import p.j;
import r0.C1786c;
import r0.F;
import r0.r;

@Keep
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fcm";

    @Keep
    public List<C1786c> getComponents() {
        F a5 = F.a(b.class, j.class);
        return Arrays.asList(new C1786c[]{C1786c.c(FirebaseMessaging.class).h(LIBRARY_NAME).b(r.k(f.class)).b(r.h(a.class)).b(r.i(i.class)).b(r.i(P0.j.class)).b(r.k(e.class)).b(r.j(a5)).b(r.k(d.class)).f(new B(a5)).c().d(), h.b(LIBRARY_NAME, "25.0.1")});
    }
}
