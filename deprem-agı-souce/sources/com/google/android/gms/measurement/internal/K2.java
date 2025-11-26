package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.T5;
import j$.util.Objects;
import java.util.Map;

final class K2 implements T5 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f5947a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ P2 f5948b;

    K2(P2 p22, String str) {
        this.f5947a = str;
        Objects.requireNonNull(p22);
        this.f5948b = p22;
    }

    public final String a(String str) {
        Map map = (Map) this.f5948b.p().get(this.f5947a);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
