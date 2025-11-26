package com.mbridge.msdk.foundation.same.b;

import java.util.ArrayList;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f9227a;

    /* renamed from: b  reason: collision with root package name */
    private String f9228b;

    /* renamed from: c  reason: collision with root package name */
    private a f9229c;

    /* renamed from: d  reason: collision with root package name */
    private c f9230d;

    public final void a(c cVar, String str) {
        a aVar = new a();
        aVar.f9230d = cVar;
        aVar.f9228b = str;
        a(aVar);
    }

    public final String b() {
        return this.f9228b;
    }

    public final a c() {
        return this.f9229c;
    }

    public final c d() {
        return this.f9230d;
    }

    private void a(a aVar) {
        if (this.f9227a == null) {
            this.f9227a = new ArrayList();
        }
        aVar.f9229c = this;
        this.f9227a.add(aVar);
    }

    public final void a(List<a> list) {
        if (list != null && list.size() != 0) {
            for (a a5 : list) {
                a(a5);
            }
        }
    }

    public final List<a> a() {
        return this.f9227a;
    }

    public final void a(String str) {
        this.f9228b = str;
    }

    public final void a(c cVar) {
        this.f9230d = cVar;
    }
}
