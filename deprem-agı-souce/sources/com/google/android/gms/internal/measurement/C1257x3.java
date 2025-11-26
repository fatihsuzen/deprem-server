package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.measurement.x3  reason: case insensitive filesystem */
public final class C1257x3 {

    /* renamed from: a  reason: collision with root package name */
    final Map f5622a = new HashMap();

    public final void a(String str, Callable callable) {
        this.f5622a.put(str, callable);
    }
}
