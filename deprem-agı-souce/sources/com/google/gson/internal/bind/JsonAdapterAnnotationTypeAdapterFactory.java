package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.t;
import com.google.gson.reflect.TypeToken;
import com.google.gson.u;
import g1.C1666b;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class JsonAdapterAnnotationTypeAdapterFactory implements u {

    /* renamed from: c  reason: collision with root package name */
    private static final u f7621c = new DummyTypeAdapterFactory();

    /* renamed from: d  reason: collision with root package name */
    private static final u f7622d = new DummyTypeAdapterFactory();

    /* renamed from: a  reason: collision with root package name */
    private final t f7623a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap f7624b = new ConcurrentHashMap();

    private static class DummyTypeAdapterFactory implements u {
        private DummyTypeAdapterFactory() {
        }

        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            throw new AssertionError("Factory should not be used");
        }
    }

    public JsonAdapterAnnotationTypeAdapterFactory(t tVar) {
        this.f7623a = tVar;
    }

    private static Object b(t tVar, Class cls) {
        return tVar.u(TypeToken.a(cls), true).a();
    }

    private static C1666b c(Class cls) {
        return (C1666b) cls.getAnnotation(C1666b.class);
    }

    private u f(Class cls, u uVar) {
        u uVar2 = (u) this.f7624b.putIfAbsent(cls, uVar);
        if (uVar2 != null) {
            return uVar2;
        }
        return uVar;
    }

    public TypeAdapter a(Gson gson, TypeToken typeToken) {
        C1666b c5 = c(typeToken.c());
        if (c5 == null) {
            return null;
        }
        return d(this.f7623a, gson, typeToken, c5, true);
    }

    /* access modifiers changed from: package-private */
    public TypeAdapter d(t tVar, Gson gson, TypeToken typeToken, C1666b bVar, boolean z4) {
        TypeAdapter typeAdapter;
        Object b5 = b(tVar, bVar.value());
        boolean nullSafe = bVar.nullSafe();
        if (b5 instanceof TypeAdapter) {
            typeAdapter = (TypeAdapter) b5;
        } else if (b5 instanceof u) {
            u uVar = (u) b5;
            if (z4) {
                uVar = f(typeToken.c(), uVar);
            }
            typeAdapter = uVar.a(gson, typeToken);
        } else {
            throw new IllegalArgumentException("Invalid attempt to bind an instance of " + b5.getClass().getName() + " as a @JsonAdapter for " + typeToken.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
        }
        if (typeAdapter == null || !nullSafe) {
            return typeAdapter;
        }
        return typeAdapter.a();
    }

    public boolean e(TypeToken typeToken, u uVar) {
        Objects.requireNonNull(typeToken);
        Objects.requireNonNull(uVar);
        if (uVar == f7621c) {
            return true;
        }
        Class c5 = typeToken.c();
        u uVar2 = (u) this.f7624b.get(c5);
        if (uVar2 == null) {
            C1666b c6 = c(c5);
            if (c6 == null) {
                return false;
            }
            Class value = c6.value();
            if (u.class.isAssignableFrom(value) && f(c5, (u) b(this.f7623a, value)) == uVar) {
                return true;
            }
            return false;
        } else if (uVar2 == uVar) {
            return true;
        } else {
            return false;
        }
    }
}
