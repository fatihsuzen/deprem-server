package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import j1.C1679a;
import j1.c;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final Gson f7677a;

    /* renamed from: b  reason: collision with root package name */
    private final TypeAdapter f7678b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f7679c;

    TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter typeAdapter, Type type) {
        this.f7677a = gson;
        this.f7678b = typeAdapter;
        this.f7679c = type;
    }

    private static Type e(Type type, Object obj) {
        if (obj == null) {
            return type;
        }
        if ((type instanceof Class) || (type instanceof TypeVariable)) {
            return obj.getClass();
        }
        return type;
    }

    private static boolean f(TypeAdapter typeAdapter) {
        TypeAdapter e5;
        while ((typeAdapter instanceof SerializationDelegatingTypeAdapter) && (e5 = ((SerializationDelegatingTypeAdapter) typeAdapter).e()) != typeAdapter) {
            typeAdapter = e5;
        }
        return typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter;
    }

    public Object b(C1679a aVar) {
        return this.f7678b.b(aVar);
    }

    public void d(c cVar, Object obj) {
        TypeAdapter typeAdapter = this.f7678b;
        Type e5 = e(this.f7679c, obj);
        if (e5 != this.f7679c) {
            typeAdapter = this.f7677a.k(TypeToken.b(e5));
            if ((typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter) && !f(this.f7678b)) {
                typeAdapter = this.f7678b;
            }
        }
        typeAdapter.d(cVar, obj);
    }
}
