package com.google.gson.internal;

import android.support.v4.media.a;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.u;
import g1.C1665a;
import g1.d;
import g1.e;
import i1.C1677a;
import j1.C1679a;
import j1.c;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Excluder implements u, Cloneable {

    /* renamed from: g  reason: collision with root package name */
    public static final Excluder f7585g = new Excluder();

    /* renamed from: a  reason: collision with root package name */
    private double f7586a = -1.0d;

    /* renamed from: b  reason: collision with root package name */
    private int f7587b = 136;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7588c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7589d;

    /* renamed from: e  reason: collision with root package name */
    private List f7590e;

    /* renamed from: f  reason: collision with root package name */
    private List f7591f;

    public Excluder() {
        List list = Collections.EMPTY_LIST;
        this.f7590e = list;
        this.f7591f = list;
    }

    private static boolean e(Class cls) {
        if (!cls.isMemberClass() || C1677a.n(cls)) {
            return false;
        }
        return true;
    }

    private boolean f(d dVar) {
        if (dVar == null) {
            return true;
        }
        if (this.f7586a >= dVar.value()) {
            return true;
        }
        return false;
    }

    private boolean g(e eVar) {
        if (eVar == null) {
            return true;
        }
        if (this.f7586a < eVar.value()) {
            return true;
        }
        return false;
    }

    private boolean h(d dVar, e eVar) {
        if (!f(dVar) || !g(eVar)) {
            return false;
        }
        return true;
    }

    public TypeAdapter a(Gson gson, TypeToken typeToken) {
        Class c5 = typeToken.c();
        final boolean c6 = c(c5, true);
        final boolean c7 = c(c5, false);
        if (!c6 && !c7) {
            return null;
        }
        final Gson gson2 = gson;
        final TypeToken typeToken2 = typeToken;
        return new TypeAdapter() {

            /* renamed from: a  reason: collision with root package name */
            private volatile TypeAdapter f7592a;

            private TypeAdapter e() {
                TypeAdapter typeAdapter = this.f7592a;
                if (typeAdapter != null) {
                    return typeAdapter;
                }
                TypeAdapter m5 = gson2.m(Excluder.this, typeToken2);
                this.f7592a = m5;
                return m5;
            }

            public Object b(C1679a aVar) {
                if (!c7) {
                    return e().b(aVar);
                }
                aVar.X();
                return null;
            }

            public void d(c cVar, Object obj) {
                if (c6) {
                    cVar.z();
                } else {
                    e().d(cVar, obj);
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e5) {
            throw new AssertionError(e5);
        }
    }

    public boolean c(Class cls, boolean z4) {
        List list;
        if (this.f7586a != -1.0d && !h((d) cls.getAnnotation(d.class), (e) cls.getAnnotation(e.class))) {
            return true;
        }
        if (!this.f7588c && e(cls)) {
            return true;
        }
        if (!z4 && !Enum.class.isAssignableFrom(cls) && C1677a.l(cls)) {
            return true;
        }
        if (z4) {
            list = this.f7590e;
        } else {
            list = this.f7591f;
        }
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return false;
        }
        a.a(it.next());
        throw null;
    }

    public boolean d(Field field, boolean z4) {
        List list;
        C1665a aVar;
        if ((this.f7587b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f7586a != -1.0d && !h((d) field.getAnnotation(d.class), (e) field.getAnnotation(e.class))) || field.isSynthetic()) {
            return true;
        }
        if ((this.f7589d && ((aVar = (C1665a) field.getAnnotation(C1665a.class)) == null || (!z4 ? !aVar.deserialize() : !aVar.serialize()))) || c(field.getType(), z4)) {
            return true;
        }
        if (z4) {
            list = this.f7590e;
        } else {
            list = this.f7591f;
        }
        if (list.isEmpty()) {
            return false;
        }
        new com.google.gson.a(field);
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return false;
        }
        a.a(it.next());
        throw null;
    }
}
