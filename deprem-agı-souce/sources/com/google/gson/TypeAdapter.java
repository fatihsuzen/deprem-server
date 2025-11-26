package com.google.gson;

import j1.C1679a;
import j1.b;
import j1.c;
import java.io.IOException;

public abstract class TypeAdapter {

    private final class NullSafeTypeAdapter extends TypeAdapter {
        private NullSafeTypeAdapter() {
        }

        public Object b(C1679a aVar) {
            if (aVar.N() != b.NULL) {
                return TypeAdapter.this.b(aVar);
            }
            aVar.J();
            return null;
        }

        public void d(c cVar, Object obj) {
            if (obj == null) {
                cVar.z();
            } else {
                TypeAdapter.this.d(cVar, obj);
            }
        }

        public String toString() {
            return "NullSafeTypeAdapter[" + TypeAdapter.this + "]";
        }
    }

    public final TypeAdapter a() {
        if (!(this instanceof NullSafeTypeAdapter)) {
            return new NullSafeTypeAdapter();
        }
        return this;
    }

    public abstract Object b(C1679a aVar);

    public final h c(Object obj) {
        try {
            com.google.gson.internal.bind.a aVar = new com.google.gson.internal.bind.a();
            d(aVar, obj);
            return aVar.S();
        } catch (IOException e5) {
            throw new i((Throwable) e5);
        }
    }

    public abstract void d(c cVar, Object obj);
}
