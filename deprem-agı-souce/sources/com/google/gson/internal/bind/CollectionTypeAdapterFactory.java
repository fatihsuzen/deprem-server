package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.A;
import com.google.gson.internal.t;
import com.google.gson.reflect.TypeToken;
import com.google.gson.u;
import j1.C1679a;
import j1.b;
import j1.c;
import java.lang.reflect.Type;
import java.util.Collection;

public final class CollectionTypeAdapterFactory implements u {

    /* renamed from: a  reason: collision with root package name */
    private final t f7609a;

    private static final class Adapter<E> extends TypeAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final TypeAdapter f7610a;

        /* renamed from: b  reason: collision with root package name */
        private final A f7611b;

        Adapter(TypeAdapter typeAdapter, A a5) {
            this.f7610a = typeAdapter;
            this.f7611b = a5;
        }

        /* renamed from: e */
        public Collection b(C1679a aVar) {
            if (aVar.N() == b.NULL) {
                aVar.J();
                return null;
            }
            Collection collection = (Collection) this.f7611b.a();
            aVar.d();
            while (aVar.x()) {
                collection.add(this.f7610a.b(aVar));
            }
            aVar.p();
            return collection;
        }

        /* renamed from: f */
        public void d(c cVar, Collection collection) {
            if (collection == null) {
                cVar.z();
                return;
            }
            cVar.m();
            for (Object d5 : collection) {
                this.f7610a.d(cVar, d5);
            }
            cVar.p();
        }
    }

    public CollectionTypeAdapterFactory(t tVar) {
        this.f7609a = tVar;
    }

    public TypeAdapter a(Gson gson, TypeToken typeToken) {
        Type d5 = typeToken.d();
        Class c5 = typeToken.c();
        if (!Collection.class.isAssignableFrom(c5)) {
            return null;
        }
        Type h5 = com.google.gson.internal.u.h(d5, c5);
        return new Adapter(new TypeAdapterRuntimeTypeWrapper(gson, gson.k(TypeToken.b(h5)), h5), this.f7609a.u(typeToken, false));
    }
}
