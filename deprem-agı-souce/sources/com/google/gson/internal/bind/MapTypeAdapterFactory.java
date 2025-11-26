package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.h;
import com.google.gson.internal.A;
import com.google.gson.internal.E;
import com.google.gson.internal.t;
import com.google.gson.internal.w;
import com.google.gson.m;
import com.google.gson.o;
import com.google.gson.reflect.TypeToken;
import com.google.gson.u;
import j1.C1679a;
import j1.b;
import j1.c;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public final class MapTypeAdapterFactory implements u {

    /* renamed from: a  reason: collision with root package name */
    private final t f7627a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f7628b;

    private final class Adapter<K, V> extends TypeAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final TypeAdapter f7629a;

        /* renamed from: b  reason: collision with root package name */
        private final TypeAdapter f7630b;

        /* renamed from: c  reason: collision with root package name */
        private final A f7631c;

        Adapter(TypeAdapter typeAdapter, TypeAdapter typeAdapter2, A a5) {
            this.f7629a = typeAdapter;
            this.f7630b = typeAdapter2;
            this.f7631c = a5;
        }

        private String e(h hVar) {
            if (hVar.k()) {
                m f5 = hVar.f();
                if (f5.u()) {
                    return String.valueOf(f5.q());
                }
                if (f5.s()) {
                    return Boolean.toString(f5.o());
                }
                if (f5.v()) {
                    return f5.r();
                }
                throw new AssertionError();
            } else if (hVar.i()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }

        /* renamed from: f */
        public Map b(C1679a aVar) {
            b N4 = aVar.N();
            if (N4 == b.NULL) {
                aVar.J();
                return null;
            }
            Map map = (Map) this.f7631c.a();
            if (N4 == b.BEGIN_ARRAY) {
                aVar.d();
                while (aVar.x()) {
                    aVar.d();
                    Object b5 = this.f7629a.b(aVar);
                    if (map.put(b5, this.f7630b.b(aVar)) == null) {
                        aVar.p();
                    } else {
                        throw new o("duplicate key: " + b5);
                    }
                }
                aVar.p();
                return map;
            }
            aVar.l();
            while (aVar.x()) {
                w.f7781a.a(aVar);
                Object b6 = this.f7629a.b(aVar);
                if (map.put(b6, this.f7630b.b(aVar)) != null) {
                    throw new o("duplicate key: " + b6);
                }
            }
            aVar.q();
            return map;
        }

        /* renamed from: g */
        public void d(c cVar, Map map) {
            boolean z4;
            if (map == null) {
                cVar.z();
            } else if (!MapTypeAdapterFactory.this.f7628b) {
                cVar.n();
                for (Map.Entry entry : map.entrySet()) {
                    cVar.x(String.valueOf(entry.getKey()));
                    this.f7630b.d(cVar, entry.getValue());
                }
                cVar.q();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i5 = 0;
                boolean z5 = false;
                for (Map.Entry entry2 : map.entrySet()) {
                    h c5 = this.f7629a.c(entry2.getKey());
                    arrayList.add(c5);
                    arrayList2.add(entry2.getValue());
                    if (c5.g() || c5.j()) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    z5 |= z4;
                }
                if (z5) {
                    cVar.m();
                    int size = arrayList.size();
                    while (i5 < size) {
                        cVar.m();
                        E.a((h) arrayList.get(i5), cVar);
                        this.f7630b.d(cVar, arrayList2.get(i5));
                        cVar.p();
                        i5++;
                    }
                    cVar.p();
                    return;
                }
                cVar.n();
                int size2 = arrayList.size();
                while (i5 < size2) {
                    cVar.x(e((h) arrayList.get(i5)));
                    this.f7630b.d(cVar, arrayList2.get(i5));
                    i5++;
                }
                cVar.q();
            }
        }
    }

    public MapTypeAdapterFactory(t tVar, boolean z4) {
        this.f7627a = tVar;
        this.f7628b = z4;
    }

    private TypeAdapter b(Gson gson, Type type) {
        if (type == Boolean.TYPE || type == Boolean.class) {
            return TypeAdapters.f7709f;
        }
        return gson.k(TypeToken.b(type));
    }

    public TypeAdapter a(Gson gson, TypeToken typeToken) {
        Type d5 = typeToken.d();
        Class c5 = typeToken.c();
        if (!Map.class.isAssignableFrom(c5)) {
            return null;
        }
        Type[] j5 = com.google.gson.internal.u.j(d5, c5);
        Type type = j5[0];
        Type type2 = j5[1];
        return new Adapter(new TypeAdapterRuntimeTypeWrapper(gson, b(gson, type), type), new TypeAdapterRuntimeTypeWrapper(gson, gson.k(TypeToken.b(type2)), type2), this.f7627a.u(typeToken, false));
    }
}
