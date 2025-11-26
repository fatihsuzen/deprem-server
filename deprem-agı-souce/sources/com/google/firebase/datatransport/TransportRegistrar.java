package com.google.firebase.datatransport;

import I0.a;
import I0.b;
import I0.c;
import I0.d;
import I0.e;
import Z0.h;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import p.j;
import r0.C1786c;
import r0.F;
import r0.r;

@Keep
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    @NonNull
    public List<C1786c> getComponents() {
        Class<j> cls = j.class;
        Class<Context> cls2 = Context.class;
        return Arrays.asList(new C1786c[]{C1786c.c(cls).h(LIBRARY_NAME).b(r.k(cls2)).f(new c()).d(), C1786c.e(F.a(a.class, cls)).b(r.k(cls2)).f(new d()).d(), C1786c.e(F.a(b.class, cls)).b(r.k(cls2)).f(new e()).d(), h.b(LIBRARY_NAME, "19.0.0")});
    }
}
