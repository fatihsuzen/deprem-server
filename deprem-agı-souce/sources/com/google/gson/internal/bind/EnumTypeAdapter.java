package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.u;
import j1.C1679a;
import j1.b;
import j1.c;
import java.lang.Enum;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter {

    /* renamed from: d  reason: collision with root package name */
    static final u f7617d = new u() {
        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            Class<? super Enum> c5 = typeToken.c();
            Class<Enum> cls = Enum.class;
            if (!cls.isAssignableFrom(c5) || c5 == cls) {
                return null;
            }
            if (!c5.isEnum()) {
                c5 = c5.getSuperclass();
            }
            return new EnumTypeAdapter(c5);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Map f7618a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f7619b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f7620c;

    /* renamed from: e */
    public Enum b(C1679a aVar) {
        if (aVar.N() == b.NULL) {
            aVar.J();
            return null;
        }
        String L4 = aVar.L();
        Enum enumR = (Enum) this.f7618a.get(L4);
        if (enumR == null) {
            return (Enum) this.f7619b.get(L4);
        }
        return enumR;
    }

    /* renamed from: f */
    public void d(c cVar, Enum enumR) {
        String str;
        if (enumR == null) {
            str = null;
        } else {
            str = (String) this.f7620c.get(enumR);
        }
        cVar.P(str);
    }

    private EnumTypeAdapter(Class cls) {
        this.f7618a = new HashMap();
        this.f7619b = new HashMap();
        this.f7620c = new HashMap();
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            int i5 = 0;
            for (Field field : declaredFields) {
                if (field.isEnumConstant()) {
                    declaredFields[i5] = field;
                    i5++;
                }
            }
            Field[] fieldArr = (Field[]) Arrays.copyOf(declaredFields, i5);
            AccessibleObject.setAccessible(fieldArr, true);
            for (Field field2 : fieldArr) {
                Enum enumR = (Enum) field2.get((Object) null);
                String name = enumR.name();
                String str = enumR.toString();
                g1.c cVar = (g1.c) field2.getAnnotation(g1.c.class);
                if (cVar != null) {
                    name = cVar.value();
                    for (String put : cVar.alternate()) {
                        this.f7618a.put(put, enumR);
                    }
                }
                this.f7618a.put(name, enumR);
                this.f7619b.put(str, enumR);
                this.f7620c.put(enumR, name);
            }
        } catch (IllegalAccessException e5) {
            throw new AssertionError(e5);
        }
    }
}
