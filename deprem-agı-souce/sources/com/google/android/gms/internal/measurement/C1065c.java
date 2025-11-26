package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.c  reason: case insensitive filesystem */
public final class C1065c {

    /* renamed from: a  reason: collision with root package name */
    private C1056b f5313a;

    /* renamed from: b  reason: collision with root package name */
    private C1056b f5314b;

    /* renamed from: c  reason: collision with root package name */
    private final List f5315c;

    public C1065c() {
        this.f5313a = new C1056b("", 0, (Map) null);
        this.f5314b = new C1056b("", 0, (Map) null);
        this.f5315c = new ArrayList();
    }

    public final C1056b a() {
        return this.f5313a;
    }

    public final void b(C1056b bVar) {
        this.f5313a = bVar;
        this.f5314b = bVar.clone();
        this.f5315c.clear();
    }

    public final C1056b c() {
        return this.f5314b;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        C1065c cVar = new C1065c(this.f5313a.clone());
        for (C1056b g5 : this.f5315c) {
            cVar.f5315c.add(g5.clone());
        }
        return cVar;
    }

    public final void d(C1056b bVar) {
        this.f5314b = bVar;
    }

    public final void e(String str, long j5, Map map) {
        HashMap hashMap = new HashMap();
        for (String str2 : map.keySet()) {
            hashMap.put(str2, C1056b.h(str2, this.f5313a.e(str2), map.get(str2)));
        }
        this.f5315c.add(new C1056b(str, j5, hashMap));
    }

    public final List f() {
        return this.f5315c;
    }

    public C1065c(C1056b bVar) {
        this.f5313a = bVar;
        this.f5314b = bVar.clone();
        this.f5315c = new ArrayList();
    }
}
