package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.d;
import com.google.gson.i;
import com.google.gson.internal.A;
import com.google.gson.internal.C;
import com.google.gson.internal.D;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.F;
import com.google.gson.internal.t;
import com.google.gson.l;
import com.google.gson.o;
import com.google.gson.q;
import com.google.gson.reflect.TypeToken;
import com.google.gson.u;
import g1.C1666b;
import i1.C1677a;
import j1.C1679a;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory implements u {

    /* renamed from: a  reason: collision with root package name */
    private final t f7642a;

    /* renamed from: b  reason: collision with root package name */
    private final d f7643b;

    /* renamed from: c  reason: collision with root package name */
    private final Excluder f7644c;

    /* renamed from: d  reason: collision with root package name */
    private final JsonAdapterAnnotationTypeAdapterFactory f7645d;

    /* renamed from: e  reason: collision with root package name */
    private final List f7646e;

    public static abstract class Adapter<T, A> extends TypeAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final c f7648a;

        Adapter(c cVar) {
            this.f7648a = cVar;
        }

        public Object b(C1679a aVar) {
            if (aVar.N() == j1.b.NULL) {
                aVar.J();
                return null;
            }
            Object e5 = e();
            Map map = this.f7648a.f7665a;
            try {
                aVar.l();
                while (aVar.x()) {
                    b bVar = (b) map.get(aVar.H());
                    if (bVar == null) {
                        aVar.X();
                    } else {
                        g(e5, aVar, bVar);
                    }
                }
                aVar.q();
                return f(e5);
            } catch (IllegalStateException e6) {
                throw new o((Throwable) e6);
            } catch (IllegalAccessException e7) {
                throw C1677a.e(e7);
            }
        }

        public void d(j1.c cVar, Object obj) {
            if (obj == null) {
                cVar.z();
                return;
            }
            cVar.n();
            try {
                for (b c5 : this.f7648a.f7666b) {
                    c5.c(cVar, obj);
                }
                cVar.q();
            } catch (IllegalAccessException e5) {
                throw C1677a.e(e5);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract Object e();

        /* access modifiers changed from: package-private */
        public abstract Object f(Object obj);

        /* access modifiers changed from: package-private */
        public abstract void g(Object obj, C1679a aVar, b bVar);
    }

    private static final class FieldReflectionAdapter<T> extends Adapter<T, T> {

        /* renamed from: b  reason: collision with root package name */
        private final A f7649b;

        FieldReflectionAdapter(A a5, c cVar) {
            super(cVar);
            this.f7649b = a5;
        }

        /* access modifiers changed from: package-private */
        public Object e() {
            return this.f7649b.a();
        }

        /* access modifiers changed from: package-private */
        public Object f(Object obj) {
            return obj;
        }

        /* access modifiers changed from: package-private */
        public void g(Object obj, C1679a aVar, b bVar) {
            bVar.b(aVar, obj);
        }
    }

    private static final class RecordAdapter<T> extends Adapter<T, Object[]> {

        /* renamed from: e  reason: collision with root package name */
        static final Map f7650e = j();

        /* renamed from: b  reason: collision with root package name */
        private final Constructor f7651b;

        /* renamed from: c  reason: collision with root package name */
        private final Object[] f7652c;

        /* renamed from: d  reason: collision with root package name */
        private final Map f7653d = new HashMap();

        RecordAdapter(Class cls, c cVar, boolean z4) {
            super(cVar);
            Constructor i5 = C1677a.i(cls);
            this.f7651b = i5;
            if (z4) {
                ReflectiveTypeAdapterFactory.c((Object) null, i5);
            } else {
                C1677a.o(i5);
            }
            String[] k5 = C1677a.k(cls);
            for (int i6 = 0; i6 < k5.length; i6++) {
                this.f7653d.put(k5[i6], Integer.valueOf(i6));
            }
            Class[] parameterTypes = this.f7651b.getParameterTypes();
            this.f7652c = new Object[parameterTypes.length];
            for (int i7 = 0; i7 < parameterTypes.length; i7++) {
                this.f7652c[i7] = f7650e.get(parameterTypes[i7]);
            }
        }

        private static Map j() {
            HashMap hashMap = new HashMap();
            hashMap.put(Byte.TYPE, (byte) 0);
            hashMap.put(Short.TYPE, (short) 0);
            hashMap.put(Integer.TYPE, 0);
            hashMap.put(Long.TYPE, 0L);
            hashMap.put(Float.TYPE, Float.valueOf(0.0f));
            hashMap.put(Double.TYPE, Double.valueOf(0.0d));
            hashMap.put(Character.TYPE, 0);
            hashMap.put(Boolean.TYPE, Boolean.FALSE);
            return hashMap;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public Object[] e() {
            return (Object[]) this.f7652c.clone();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public Object f(Object[] objArr) {
            try {
                return this.f7651b.newInstance(objArr);
            } catch (IllegalAccessException e5) {
                throw C1677a.e(e5);
            } catch (IllegalArgumentException | InstantiationException e6) {
                throw new RuntimeException("Failed to invoke constructor '" + C1677a.c(this.f7651b) + "' with args " + Arrays.toString(objArr), e6);
            } catch (InvocationTargetException e7) {
                throw new RuntimeException("Failed to invoke constructor '" + C1677a.c(this.f7651b) + "' with args " + Arrays.toString(objArr), e7.getCause());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public void g(Object[] objArr, C1679a aVar, b bVar) {
            Integer num = (Integer) this.f7653d.get(bVar.f7663c);
            if (num != null) {
                bVar.a(aVar, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + C1677a.c(this.f7651b) + "' for field with name '" + bVar.f7663c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    class a extends b {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f7654d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Method f7655e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ TypeAdapter f7656f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ TypeAdapter f7657g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ boolean f7658h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ boolean f7659i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, Field field, boolean z4, Method method, TypeAdapter typeAdapter, TypeAdapter typeAdapter2, boolean z5, boolean z6) {
            super(str, field);
            this.f7654d = z4;
            this.f7655e = method;
            this.f7656f = typeAdapter;
            this.f7657g = typeAdapter2;
            this.f7658h = z5;
            this.f7659i = z6;
        }

        /* access modifiers changed from: package-private */
        public void a(C1679a aVar, int i5, Object[] objArr) {
            Object b5 = this.f7657g.b(aVar);
            if (b5 != null || !this.f7658h) {
                objArr[i5] = b5;
                return;
            }
            throw new l("null is not allowed as value for record component '" + this.f7663c + "' of primitive type; at path " + aVar.getPath());
        }

        /* access modifiers changed from: package-private */
        public void b(C1679a aVar, Object obj) {
            Object b5 = this.f7657g.b(aVar);
            if (b5 != null || !this.f7658h) {
                if (this.f7654d) {
                    ReflectiveTypeAdapterFactory.c(obj, this.f7662b);
                } else if (this.f7659i) {
                    String g5 = C1677a.g(this.f7662b, false);
                    throw new i("Cannot set value of 'static final' " + g5);
                }
                this.f7662b.set(obj, b5);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(j1.c cVar, Object obj) {
            Object obj2;
            if (this.f7654d) {
                Method method = this.f7655e;
                if (method == null) {
                    ReflectiveTypeAdapterFactory.c(obj, this.f7662b);
                } else {
                    ReflectiveTypeAdapterFactory.c(obj, method);
                }
            }
            Method method2 = this.f7655e;
            if (method2 != null) {
                try {
                    obj2 = method2.invoke(obj, (Object[]) null);
                } catch (InvocationTargetException e5) {
                    String g5 = C1677a.g(this.f7655e, false);
                    throw new i("Accessor " + g5 + " threw exception", e5.getCause());
                }
            } else {
                obj2 = this.f7662b.get(obj);
            }
            if (obj2 != obj) {
                cVar.x(this.f7661a);
                this.f7656f.d(cVar, obj2);
            }
        }
    }

    static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        final String f7661a;

        /* renamed from: b  reason: collision with root package name */
        final Field f7662b;

        /* renamed from: c  reason: collision with root package name */
        final String f7663c;

        protected b(String str, Field field) {
            this.f7661a = str;
            this.f7662b = field;
            this.f7663c = field.getName();
        }

        /* access modifiers changed from: package-private */
        public abstract void a(C1679a aVar, int i5, Object[] objArr);

        /* access modifiers changed from: package-private */
        public abstract void b(C1679a aVar, Object obj);

        /* access modifiers changed from: package-private */
        public abstract void c(j1.c cVar, Object obj);
    }

    private static class c {

        /* renamed from: c  reason: collision with root package name */
        static final c f7664c = new c(Collections.EMPTY_MAP, Collections.EMPTY_LIST);

        /* renamed from: a  reason: collision with root package name */
        final Map f7665a;

        /* renamed from: b  reason: collision with root package name */
        final List f7666b;

        c(Map map, List list) {
            this.f7665a = map;
            this.f7666b = list;
        }
    }

    public ReflectiveTypeAdapterFactory(t tVar, d dVar, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory, List list) {
        this.f7642a = tVar;
        this.f7643b = dVar;
        this.f7644c = excluder;
        this.f7645d = jsonAdapterAnnotationTypeAdapterFactory;
        this.f7646e = list;
    }

    /* access modifiers changed from: private */
    public static void c(Object obj, AccessibleObject accessibleObject) {
        if (Modifier.isStatic(((Member) accessibleObject).getModifiers())) {
            obj = null;
        }
        if (!D.a(accessibleObject, obj)) {
            String g5 = C1677a.g(accessibleObject, true);
            throw new i(g5 + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
        }
    }

    private b d(Gson gson, Field field, Method method, String str, TypeToken typeToken, boolean z4, boolean z5) {
        boolean z6;
        TypeAdapter typeAdapter;
        TypeAdapter typeAdapter2;
        TypeAdapter typeAdapter3;
        boolean a5 = C.a(typeToken.c());
        int modifiers = field.getModifiers();
        boolean z7 = false;
        boolean z8 = true;
        if (!Modifier.isStatic(modifiers) || !Modifier.isFinal(modifiers)) {
            z6 = false;
        } else {
            z6 = false;
            z7 = true;
        }
        C1666b bVar = (C1666b) field.getAnnotation(C1666b.class);
        if (bVar != null) {
            typeAdapter = this.f7645d.d(this.f7642a, gson, typeToken, bVar, false);
        } else {
            typeAdapter = null;
        }
        if (typeAdapter == null) {
            z8 = z6;
        }
        TypeToken typeToken2 = typeToken;
        if (typeAdapter == null) {
            typeAdapter = gson.k(typeToken2);
        }
        TypeAdapter typeAdapter4 = typeAdapter;
        if (z4) {
            if (z8) {
                typeAdapter3 = typeAdapter4;
            } else {
                typeAdapter3 = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter4, typeToken2.d());
            }
            typeAdapter2 = typeAdapter3;
        } else {
            typeAdapter2 = typeAdapter4;
        }
        return new a(str, field, z5, method, typeAdapter2, typeAdapter4, a5, z7);
    }

    private static IllegalArgumentException e(Class cls, String str, Field field, Field field2) {
        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + str + "'; conflict is caused by fields " + C1677a.f(field) + " and " + C1677a.f(field2) + "\nSee " + F.a("duplicate-fields"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00fa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.c f(com.google.gson.Gson r20, com.google.gson.reflect.TypeToken r21, java.lang.Class r22, boolean r23, boolean r24) {
        /*
            r19 = this;
            r0 = r19
            r8 = r22
            boolean r1 = r8.isInterface()
            if (r1 == 0) goto L_0x000d
            com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$c r1 = com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.c.f7664c
            return r1
        L_0x000d:
            java.util.LinkedHashMap r9 = new java.util.LinkedHashMap
            r9.<init>()
            java.util.LinkedHashMap r10 = new java.util.LinkedHashMap
            r10.<init>()
            r11 = r21
            r1 = r23
            r12 = r8
        L_0x001c:
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            if (r12 == r2) goto L_0x0153
            java.lang.reflect.Field[] r13 = r12.getDeclaredFields()
            r14 = 1
            r15 = 0
            if (r12 == r8) goto L_0x003c
            int r2 = r13.length
            if (r2 <= 0) goto L_0x003c
            java.util.List r1 = r0.f7646e
            com.google.gson.q r1 = com.google.gson.internal.D.b(r1, r12)
            com.google.gson.q r2 = com.google.gson.q.BLOCK_ALL
            if (r1 == r2) goto L_0x003e
            com.google.gson.q r2 = com.google.gson.q.BLOCK_INACCESSIBLE
            if (r1 != r2) goto L_0x003b
            r1 = r14
            goto L_0x003c
        L_0x003b:
            r1 = r15
        L_0x003c:
            r7 = r1
            goto L_0x0062
        L_0x003e:
            com.google.gson.i r1 = new com.google.gson.i
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "ReflectionAccessFilter does not permit using reflection for "
            r2.append(r3)
            r2.append(r12)
            java.lang.String r3 = " (supertype of "
            r2.append(r3)
            r2.append(r8)
            java.lang.String r3 = "). Register a TypeAdapter for this type or adjust the access filter."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x0062:
            int r1 = r13.length
            r2 = r15
        L_0x0064:
            if (r2 >= r1) goto L_0x0138
            r3 = r2
            r2 = r13[r3]
            boolean r6 = r0.h(r2, r14)
            boolean r4 = r0.h(r2, r15)
            if (r6 != 0) goto L_0x007e
            if (r4 != 0) goto L_0x007e
            r17 = r1
            r18 = r3
            r16 = r11
            r11 = r15
            goto L_0x012c
        L_0x007e:
            r5 = 0
            if (r24 == 0) goto L_0x00c5
            int r16 = r2.getModifiers()
            boolean r16 = java.lang.reflect.Modifier.isStatic(r16)
            if (r16 == 0) goto L_0x008d
            r14 = r15
            goto L_0x00c6
        L_0x008d:
            java.lang.reflect.Method r5 = i1.C1677a.h(r12, r2)
            if (r7 != 0) goto L_0x0096
            i1.C1677a.o(r5)
        L_0x0096:
            java.lang.Class<g1.c> r14 = g1.c.class
            java.lang.annotation.Annotation r16 = r5.getAnnotation(r14)
            if (r16 == 0) goto L_0x00c5
            java.lang.annotation.Annotation r14 = r2.getAnnotation(r14)
            if (r14 == 0) goto L_0x00a5
            goto L_0x00c5
        L_0x00a5:
            java.lang.String r1 = i1.C1677a.g(r5, r15)
            com.google.gson.i r2 = new com.google.gson.i
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "@SerializedName on "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " is not supported"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>((java.lang.String) r1)
            throw r2
        L_0x00c5:
            r14 = r4
        L_0x00c6:
            if (r7 != 0) goto L_0x00cd
            if (r5 != 0) goto L_0x00cd
            i1.C1677a.o(r2)
        L_0x00cd:
            java.lang.reflect.Type r4 = r11.d()
            java.lang.reflect.Type r15 = r2.getGenericType()
            java.lang.reflect.Type r4 = com.google.gson.internal.u.p(r4, r12, r15)
            java.util.List r15 = r0.g(r2)
            r16 = r11
            r11 = 0
            java.lang.Object r17 = r15.get(r11)
            java.lang.String r17 = (java.lang.String) r17
            com.google.gson.reflect.TypeToken r4 = com.google.gson.reflect.TypeToken.b(r4)
            r18 = r3
            r3 = r5
            r5 = r4
            r4 = r17
            r17 = r1
            r1 = r20
            com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$b r3 = r0.d(r1, r2, r3, r4, r5, r6, r7)
            if (r14 == 0) goto L_0x011a
            java.util.Iterator r0 = r15.iterator()
        L_0x00fe:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x011a
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r9.put(r1, r3)
            com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$b r5 = (com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b) r5
            if (r5 != 0) goto L_0x0113
            goto L_0x00fe
        L_0x0113:
            java.lang.reflect.Field r0 = r5.f7662b
            java.lang.IllegalArgumentException r0 = e(r8, r1, r0, r2)
            throw r0
        L_0x011a:
            if (r6 == 0) goto L_0x012c
            java.lang.Object r0 = r10.put(r4, r3)
            com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$b r0 = (com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b) r0
            if (r0 != 0) goto L_0x0125
            goto L_0x012c
        L_0x0125:
            java.lang.reflect.Field r0 = r0.f7662b
            java.lang.IllegalArgumentException r0 = e(r8, r4, r0, r2)
            throw r0
        L_0x012c:
            int r2 = r18 + 1
            r0 = r19
            r15 = r11
            r11 = r16
            r1 = r17
            r14 = 1
            goto L_0x0064
        L_0x0138:
            r16 = r11
            java.lang.reflect.Type r0 = r16.d()
            java.lang.reflect.Type r1 = r12.getGenericSuperclass()
            java.lang.reflect.Type r0 = com.google.gson.internal.u.p(r0, r12, r1)
            com.google.gson.reflect.TypeToken r11 = com.google.gson.reflect.TypeToken.b(r0)
            java.lang.Class r12 = r11.c()
            r0 = r19
            r1 = r7
            goto L_0x001c
        L_0x0153:
            com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$c r0 = new com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$c
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Collection r2 = r10.values()
            r1.<init>(r2)
            r0.<init>(r9, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.f(com.google.gson.Gson, com.google.gson.reflect.TypeToken, java.lang.Class, boolean, boolean):com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$c");
    }

    private List g(Field field) {
        List list;
        String str;
        g1.c cVar = (g1.c) field.getAnnotation(g1.c.class);
        if (cVar == null) {
            str = this.f7643b.b(field);
            list = this.f7643b.a(field);
        } else {
            String value = cVar.value();
            List asList = Arrays.asList(cVar.alternate());
            str = value;
            list = asList;
        }
        if (list.isEmpty()) {
            return Collections.singletonList(str);
        }
        ArrayList arrayList = new ArrayList(list.size() + 1);
        arrayList.add(str);
        arrayList.addAll(list);
        return arrayList;
    }

    private boolean h(Field field, boolean z4) {
        return !this.f7644c.d(field, z4);
    }

    public TypeAdapter a(Gson gson, TypeToken typeToken) {
        boolean z4;
        Class c5 = typeToken.c();
        if (!Object.class.isAssignableFrom(c5)) {
            return null;
        }
        if (C1677a.l(c5)) {
            return new TypeAdapter() {
                public Object b(C1679a aVar) {
                    aVar.X();
                    return null;
                }

                public void d(j1.c cVar, Object obj) {
                    cVar.z();
                }

                public String toString() {
                    return "AnonymousOrNonStaticLocalClassAdapter";
                }
            };
        }
        q b5 = D.b(this.f7646e, c5);
        if (b5 != q.BLOCK_ALL) {
            if (b5 == q.BLOCK_INACCESSIBLE) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (C1677a.m(c5)) {
                return new RecordAdapter(c5, f(gson, typeToken, c5, z4, true), z4);
            }
            TypeToken typeToken2 = typeToken;
            return new FieldReflectionAdapter(this.f7642a.u(typeToken2, true), f(gson, typeToken2, c5, z4, false));
        }
        throw new i("ReflectionAccessFilter does not permit using reflection for " + c5 + ". Register a TypeAdapter for this type or adjust the access filter.");
    }
}
