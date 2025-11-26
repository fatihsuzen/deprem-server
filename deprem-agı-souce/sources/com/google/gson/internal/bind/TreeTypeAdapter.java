package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.g;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;
import com.google.gson.u;
import j1.C1679a;
import j1.c;

public final class TreeTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {

    /* renamed from: a  reason: collision with root package name */
    final Gson f7667a;

    /* renamed from: b  reason: collision with root package name */
    private final TypeToken f7668b;

    /* renamed from: c  reason: collision with root package name */
    private final u f7669c;

    /* renamed from: d  reason: collision with root package name */
    private final b f7670d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f7671e;

    /* renamed from: f  reason: collision with root package name */
    private volatile TypeAdapter f7672f;

    private static final class SingleTypeFactory implements u {

        /* renamed from: a  reason: collision with root package name */
        private final TypeToken f7673a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f7674b;

        /* renamed from: c  reason: collision with root package name */
        private final Class f7675c;

        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            boolean z4;
            TypeToken typeToken2 = this.f7673a;
            if (typeToken2 == null) {
                z4 = this.f7675c.isAssignableFrom(typeToken.c());
            } else if (typeToken2.equals(typeToken) || (this.f7674b && this.f7673a.d() == typeToken.c())) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                return null;
            }
            return new TreeTypeAdapter((n) null, (g) null, gson, typeToken, this);
        }
    }

    private final class b {
        private b() {
        }
    }

    public TreeTypeAdapter(n nVar, g gVar, Gson gson, TypeToken typeToken, u uVar, boolean z4) {
        this.f7670d = new b();
        this.f7667a = gson;
        this.f7668b = typeToken;
        this.f7669c = uVar;
        this.f7671e = z4;
    }

    private TypeAdapter f() {
        TypeAdapter typeAdapter = this.f7672f;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter m5 = this.f7667a.m(this.f7669c, this.f7668b);
        this.f7672f = m5;
        return m5;
    }

    public Object b(C1679a aVar) {
        return f().b(aVar);
    }

    public void d(c cVar, Object obj) {
        f().d(cVar, obj);
    }

    public TypeAdapter e() {
        return f();
    }

    public TreeTypeAdapter(n nVar, g gVar, Gson gson, TypeToken typeToken, u uVar) {
        this(nVar, gVar, gson, typeToken, uVar, true);
    }
}
