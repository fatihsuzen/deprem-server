package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.u;
import j1.C1679a;
import j1.b;
import j1.c;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class ArrayTypeAdapter<E> extends TypeAdapter {

    /* renamed from: c  reason: collision with root package name */
    public static final u f7606c = new u() {
        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            Type d5 = typeToken.d();
            if (!(d5 instanceof GenericArrayType) && (!(d5 instanceof Class) || !((Class) d5).isArray())) {
                return null;
            }
            Type g5 = com.google.gson.internal.u.g(d5);
            return new ArrayTypeAdapter(gson, gson.k(TypeToken.b(g5)), com.google.gson.internal.u.k(g5));
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Class f7607a;

    /* renamed from: b  reason: collision with root package name */
    private final TypeAdapter f7608b;

    public ArrayTypeAdapter(Gson gson, TypeAdapter typeAdapter, Class cls) {
        this.f7608b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.f7607a = cls;
    }

    public Object b(C1679a aVar) {
        if (aVar.N() == b.NULL) {
            aVar.J();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.d();
        while (aVar.x()) {
            arrayList.add(this.f7608b.b(aVar));
        }
        aVar.p();
        int size = arrayList.size();
        if (!this.f7607a.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance(this.f7607a, size));
        }
        Object newInstance = Array.newInstance(this.f7607a, size);
        for (int i5 = 0; i5 < size; i5++) {
            Array.set(newInstance, i5, arrayList.get(i5));
        }
        return newInstance;
    }

    public void d(c cVar, Object obj) {
        if (obj == null) {
            cVar.z();
            return;
        }
        cVar.m();
        int length = Array.getLength(obj);
        for (int i5 = 0; i5 < length; i5++) {
            this.f7608b.d(cVar, Array.get(obj, i5));
        }
        cVar.p();
    }
}
