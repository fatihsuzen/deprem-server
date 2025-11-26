package com.google.firebase.analytics.connector.internal;

import O0.d;
import Z0.h;
import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import o0.f;
import p0.C1748a;
import r0.C1786c;
import r0.r;

@Keep
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    @SuppressLint({"MissingPermission"})
    @Keep
    @NonNull
    public List<C1786c> getComponents() {
        return Arrays.asList(new C1786c[]{C1786c.c(C1748a.class).b(r.k(f.class)).b(r.k(Context.class)).b(r.k(d.class)).f(a.f7153a).e().d(), h.b("fire-analytics", "23.0.0")});
    }
}
