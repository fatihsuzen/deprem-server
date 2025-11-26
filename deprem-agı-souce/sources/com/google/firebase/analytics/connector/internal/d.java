package com.google.firebase.analytics.connector.internal;

import e0.C1626a;
import java.util.HashSet;
import java.util.Set;
import p0.C1748a;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    final Set f7162a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private final C1748a.b f7163b;

    /* renamed from: c  reason: collision with root package name */
    private final C1626a f7164c;

    /* renamed from: d  reason: collision with root package name */
    private final c f7165d;

    public d(C1626a aVar, C1748a.b bVar) {
        this.f7163b = bVar;
        this.f7164c = aVar;
        c cVar = new c(this);
        this.f7165d = cVar;
        aVar.b(cVar);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ C1748a.b a() {
        return this.f7163b;
    }
}
