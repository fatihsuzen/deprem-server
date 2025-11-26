package com.google.gson;

import com.google.gson.internal.E;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.a;
import com.google.gson.internal.t;
import com.google.gson.internal.x;
import com.google.gson.reflect.TypeToken;
import j$.util.DesugarCollections;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import j1.C1679a;
import j1.b;
import j1.c;
import j1.d;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class Gson {

    /* renamed from: A  reason: collision with root package name */
    static final e f7527A = e.f7573d;

    /* renamed from: B  reason: collision with root package name */
    static final String f7528B = null;

    /* renamed from: C  reason: collision with root package name */
    static final d f7529C = b.IDENTITY;

    /* renamed from: D  reason: collision with root package name */
    static final t f7530D = s.DOUBLE;

    /* renamed from: E  reason: collision with root package name */
    static final t f7531E = s.LAZILY_PARSED_NUMBER;

    /* renamed from: z  reason: collision with root package name */
    static final r f7532z = null;

    /* renamed from: a  reason: collision with root package name */
    private final ThreadLocal f7533a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap f7534b;

    /* renamed from: c  reason: collision with root package name */
    private final t f7535c;

    /* renamed from: d  reason: collision with root package name */
    private final JsonAdapterAnnotationTypeAdapterFactory f7536d;

    /* renamed from: e  reason: collision with root package name */
    final List f7537e;

    /* renamed from: f  reason: collision with root package name */
    final Excluder f7538f;

    /* renamed from: g  reason: collision with root package name */
    final d f7539g;

    /* renamed from: h  reason: collision with root package name */
    final Map f7540h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f7541i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f7542j;

    /* renamed from: k  reason: collision with root package name */
    final boolean f7543k;

    /* renamed from: l  reason: collision with root package name */
    final boolean f7544l;

    /* renamed from: m  reason: collision with root package name */
    final e f7545m;

    /* renamed from: n  reason: collision with root package name */
    final r f7546n;

    /* renamed from: o  reason: collision with root package name */
    final boolean f7547o;

    /* renamed from: p  reason: collision with root package name */
    final boolean f7548p;

    /* renamed from: q  reason: collision with root package name */
    final String f7549q;

    /* renamed from: r  reason: collision with root package name */
    final int f7550r;

    /* renamed from: s  reason: collision with root package name */
    final int f7551s;

    /* renamed from: t  reason: collision with root package name */
    final p f7552t;

    /* renamed from: u  reason: collision with root package name */
    final List f7553u;

    /* renamed from: v  reason: collision with root package name */
    final List f7554v;

    /* renamed from: w  reason: collision with root package name */
    final t f7555w;

    /* renamed from: x  reason: collision with root package name */
    final t f7556x;

    /* renamed from: y  reason: collision with root package name */
    final List f7557y;

    static class FutureTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {

        /* renamed from: a  reason: collision with root package name */
        private TypeAdapter f7562a = null;

        FutureTypeAdapter() {
        }

        private TypeAdapter f() {
            TypeAdapter typeAdapter = this.f7562a;
            if (typeAdapter != null) {
                return typeAdapter;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
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

        public void g(TypeAdapter typeAdapter) {
            if (this.f7562a == null) {
                this.f7562a = typeAdapter;
                return;
            }
            throw new AssertionError("Delegate is already set");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Gson() {
        /*
            r22 = this;
            com.google.gson.internal.Excluder r1 = com.google.gson.internal.Excluder.f7585g
            com.google.gson.d r2 = f7529C
            java.util.Map r3 = java.util.Collections.EMPTY_MAP
            com.google.gson.e r8 = f7527A
            com.google.gson.r r9 = f7532z
            com.google.gson.p r12 = com.google.gson.p.DEFAULT
            java.lang.String r13 = f7528B
            java.util.List r16 = java.util.Collections.EMPTY_LIST
            com.google.gson.t r19 = f7530D
            com.google.gson.t r20 = f7531E
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 1
            r10 = 0
            r11 = 1
            r14 = 2
            r15 = 2
            r17 = r16
            r18 = r16
            r21 = r16
            r0 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.Gson.<init>():void");
    }

    private static void a(Object obj, C1679a aVar) {
        if (obj != null) {
            try {
                if (aVar.N() != b.END_DOCUMENT) {
                    throw new o("JSON document was not fully consumed.");
                }
            } catch (d e5) {
                throw new o((Throwable) e5);
            } catch (IOException e6) {
                throw new i((Throwable) e6);
            }
        }
    }

    private static TypeAdapter b(final TypeAdapter typeAdapter) {
        return new TypeAdapter() {
            /* renamed from: e */
            public AtomicLong b(C1679a aVar) {
                return new AtomicLong(((Number) TypeAdapter.this.b(aVar)).longValue());
            }

            /* renamed from: f */
            public void d(c cVar, AtomicLong atomicLong) {
                TypeAdapter.this.d(cVar, Long.valueOf(atomicLong.get()));
            }
        }.a();
    }

    private static TypeAdapter c(final TypeAdapter typeAdapter) {
        return new TypeAdapter() {
            /* renamed from: e */
            public AtomicLongArray b(C1679a aVar) {
                ArrayList arrayList = new ArrayList();
                aVar.d();
                while (aVar.x()) {
                    arrayList.add(Long.valueOf(((Number) TypeAdapter.this.b(aVar)).longValue()));
                }
                aVar.p();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i5 = 0; i5 < size; i5++) {
                    atomicLongArray.set(i5, ((Long) arrayList.get(i5)).longValue());
                }
                return atomicLongArray;
            }

            /* renamed from: f */
            public void d(c cVar, AtomicLongArray atomicLongArray) {
                cVar.m();
                int length = atomicLongArray.length();
                for (int i5 = 0; i5 < length; i5++) {
                    TypeAdapter.this.d(cVar, Long.valueOf(atomicLongArray.get(i5)));
                }
                cVar.p();
            }
        }.a();
    }

    static void d(double d5) {
        if (Double.isNaN(d5) || Double.isInfinite(d5)) {
            throw new IllegalArgumentException(d5 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private TypeAdapter e(boolean z4) {
        if (z4) {
            return TypeAdapters.f7725v;
        }
        return new TypeAdapter() {
            /* renamed from: e */
            public Double b(C1679a aVar) {
                if (aVar.N() != b.NULL) {
                    return Double.valueOf(aVar.C());
                }
                aVar.J();
                return null;
            }

            /* renamed from: f */
            public void d(c cVar, Number number) {
                if (number == null) {
                    cVar.z();
                    return;
                }
                double doubleValue = number.doubleValue();
                Gson.d(doubleValue);
                cVar.L(doubleValue);
            }
        };
    }

    private TypeAdapter f(boolean z4) {
        if (z4) {
            return TypeAdapters.f7724u;
        }
        return new TypeAdapter() {
            /* renamed from: e */
            public Float b(C1679a aVar) {
                if (aVar.N() != b.NULL) {
                    return Float.valueOf((float) aVar.C());
                }
                aVar.J();
                return null;
            }

            /* renamed from: f */
            public void d(c cVar, Number number) {
                if (number == null) {
                    cVar.z();
                    return;
                }
                float floatValue = number.floatValue();
                Gson.d((double) floatValue);
                if (!(number instanceof Float)) {
                    number = Float.valueOf(floatValue);
                }
                cVar.O(number);
            }
        };
    }

    private static TypeAdapter n(p pVar) {
        if (pVar == p.DEFAULT) {
            return TypeAdapters.f7723t;
        }
        return new TypeAdapter() {
            /* renamed from: e */
            public Number b(C1679a aVar) {
                if (aVar.N() != b.NULL) {
                    return Long.valueOf(aVar.G());
                }
                aVar.J();
                return null;
            }

            /* renamed from: f */
            public void d(c cVar, Number number) {
                if (number == null) {
                    cVar.z();
                } else {
                    cVar.P(number.toString());
                }
            }
        };
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0092, code lost:
        throw new java.lang.AssertionError("AssertionError (GSON 2.13.2): " + r9.getMessage(), r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0098, code lost:
        throw new com.google.gson.o((java.lang.Throwable) r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009e, code lost:
        throw new com.google.gson.o((java.lang.Throwable) r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009f, code lost:
        r9 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a0, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a3, code lost:
        r8.S(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a7, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ad, code lost:
        throw new com.google.gson.o((java.lang.Throwable) r9);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006c A[ExcHandler: AssertionError (r9v5 'e' java.lang.AssertionError A[CUSTOM_DECLARE]), Splitter:B:6:0x0019] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006e A[ExcHandler: IOException (r9v4 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:6:0x0019] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070 A[ExcHandler: IllegalStateException (r9v3 'e' java.lang.IllegalStateException A[CUSTOM_DECLARE]), Splitter:B:6:0x0019] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a8 A[SYNTHETIC, Splitter:B:36:0x00a8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object g(j1.C1679a r8, com.google.gson.reflect.TypeToken r9) {
        /*
            r7 = this;
            com.google.gson.r r0 = r8.v()
            com.google.gson.r r1 = r7.f7546n
            if (r1 == 0) goto L_0x000c
            r8.S(r1)
            goto L_0x0019
        L_0x000c:
            com.google.gson.r r1 = r8.v()
            com.google.gson.r r2 = com.google.gson.r.LEGACY_STRICT
            if (r1 != r2) goto L_0x0019
            com.google.gson.r r1 = com.google.gson.r.LENIENT
            r8.S(r1)
        L_0x0019:
            r8.N()     // Catch:{ EOFException -> 0x009f, IllegalStateException -> 0x0070, IOException -> 0x006e, AssertionError -> 0x006c }
            r1 = 0
            com.google.gson.TypeAdapter r2 = r7.k(r9)     // Catch:{ EOFException -> 0x0072, IllegalStateException -> 0x0070, IOException -> 0x006e, AssertionError -> 0x006c }
            java.lang.Object r3 = r2.b(r8)     // Catch:{ EOFException -> 0x0072, IllegalStateException -> 0x0070, IOException -> 0x006e, AssertionError -> 0x006c }
            java.lang.Class r4 = r9.c()     // Catch:{ EOFException -> 0x0072, IllegalStateException -> 0x0070, IOException -> 0x006e, AssertionError -> 0x006c }
            java.lang.Class r4 = com.google.gson.internal.C.b(r4)     // Catch:{ EOFException -> 0x0072, IllegalStateException -> 0x0070, IOException -> 0x006e, AssertionError -> 0x006c }
            if (r3 == 0) goto L_0x0074
            boolean r4 = r4.isInstance(r3)     // Catch:{ EOFException -> 0x0072, IllegalStateException -> 0x0070, IOException -> 0x006e, AssertionError -> 0x006c }
            if (r4 == 0) goto L_0x0036
            goto L_0x0074
        L_0x0036:
            java.lang.ClassCastException r4 = new java.lang.ClassCastException     // Catch:{ EOFException -> 0x0072, IllegalStateException -> 0x0070, IOException -> 0x006e, AssertionError -> 0x006c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x0072, IllegalStateException -> 0x0070, IOException -> 0x006e, AssertionError -> 0x006c }
            r5.<init>()     // Catch:{ EOFException -> 0x0072, IllegalStateException -> 0x0070, IOException -> 0x006e, AssertionError -> 0x006c }
            java.lang.String r6 = "Type adapter '"
            r5.append(r6)     // Catch:{ EOFException -> 0x0072, IllegalStateException -> 0x0070, IOException -> 0x006e, AssertionError -> 0x006c }
            r5.append(r2)     // Catch:{ EOFException -> 0x0072, IllegalStateException -> 0x0070, IOException -> 0x006e, AssertionError -> 0x006c }
            java.lang.String r2 = "' returned wrong type; requested "
            r5.append(r2)     // Catch:{ EOFException -> 0x0072, IllegalStateException -> 0x0070, IOException -> 0x006e, AssertionError -> 0x006c }
            java.lang.Class r9 = r9.c()     // Catch:{ EOFException -> 0x0072, IllegalStateException -> 0x0070, IOException -> 0x006e, AssertionError -> 0x006c }
            r5.append(r9)     // Catch:{ EOFException -> 0x0072, IllegalStateException -> 0x0070, IOException -> 0x006e, AssertionError -> 0x006c }
            java.lang.String r9 = " but got instance of "
            r5.append(r9)     // Catch:{ EOFException -> 0x0072, IllegalStateException -> 0x0070, IOException -> 0x006e, AssertionError -> 0x006c }
            java.lang.Class r9 = r3.getClass()     // Catch:{ EOFException -> 0x0072, IllegalStateException -> 0x0070, IOException -> 0x006e, AssertionError -> 0x006c }
            r5.append(r9)     // Catch:{ EOFException -> 0x0072, IllegalStateException -> 0x0070, IOException -> 0x006e, AssertionError -> 0x006c }
            java.lang.String r9 = "\nVerify that the adapter was registered for the correct type."
            r5.append(r9)     // Catch:{ EOFException -> 0x0072, IllegalStateException -> 0x0070, IOException -> 0x006e, AssertionError -> 0x006c }
            java.lang.String r9 = r5.toString()     // Catch:{ EOFException -> 0x0072, IllegalStateException -> 0x0070, IOException -> 0x006e, AssertionError -> 0x006c }
            r4.<init>(r9)     // Catch:{ EOFException -> 0x0072, IllegalStateException -> 0x0070, IOException -> 0x006e, AssertionError -> 0x006c }
            throw r4     // Catch:{ EOFException -> 0x0072, IllegalStateException -> 0x0070, IOException -> 0x006e, AssertionError -> 0x006c }
        L_0x006a:
            r9 = move-exception
            goto L_0x00ae
        L_0x006c:
            r9 = move-exception
            goto L_0x0078
        L_0x006e:
            r9 = move-exception
            goto L_0x0093
        L_0x0070:
            r9 = move-exception
            goto L_0x0099
        L_0x0072:
            r9 = move-exception
            goto L_0x00a1
        L_0x0074:
            r8.S(r0)
            return r3
        L_0x0078:
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch:{ all -> 0x006a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006a }
            r2.<init>()     // Catch:{ all -> 0x006a }
            java.lang.String r3 = "AssertionError (GSON 2.13.2): "
            r2.append(r3)     // Catch:{ all -> 0x006a }
            java.lang.String r3 = r9.getMessage()     // Catch:{ all -> 0x006a }
            r2.append(r3)     // Catch:{ all -> 0x006a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x006a }
            r1.<init>(r2, r9)     // Catch:{ all -> 0x006a }
            throw r1     // Catch:{ all -> 0x006a }
        L_0x0093:
            com.google.gson.o r1 = new com.google.gson.o     // Catch:{ all -> 0x006a }
            r1.<init>((java.lang.Throwable) r9)     // Catch:{ all -> 0x006a }
            throw r1     // Catch:{ all -> 0x006a }
        L_0x0099:
            com.google.gson.o r1 = new com.google.gson.o     // Catch:{ all -> 0x006a }
            r1.<init>((java.lang.Throwable) r9)     // Catch:{ all -> 0x006a }
            throw r1     // Catch:{ all -> 0x006a }
        L_0x009f:
            r9 = move-exception
            r1 = 1
        L_0x00a1:
            if (r1 == 0) goto L_0x00a8
            r8.S(r0)
            r8 = 0
            return r8
        L_0x00a8:
            com.google.gson.o r1 = new com.google.gson.o     // Catch:{ all -> 0x006a }
            r1.<init>((java.lang.Throwable) r9)     // Catch:{ all -> 0x006a }
            throw r1     // Catch:{ all -> 0x006a }
        L_0x00ae:
            r8.S(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.Gson.g(j1.a, com.google.gson.reflect.TypeToken):java.lang.Object");
    }

    public Object h(Reader reader, TypeToken typeToken) {
        C1679a o5 = o(reader);
        Object g5 = g(o5, typeToken);
        a(g5, o5);
        return g5;
    }

    public Object i(String str, TypeToken typeToken) {
        if (str == null) {
            return null;
        }
        return h(new StringReader(str), typeToken);
    }

    public Object j(String str, Type type) {
        return i(str, TypeToken.b(type));
    }

    public TypeAdapter k(TypeToken typeToken) {
        boolean z4;
        Objects.requireNonNull(typeToken, "type must not be null");
        TypeAdapter typeAdapter = (TypeAdapter) this.f7534b.get(typeToken);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        Map map = (Map) this.f7533a.get();
        if (map == null) {
            map = new HashMap();
            this.f7533a.set(map);
            z4 = true;
        } else {
            TypeAdapter typeAdapter2 = (TypeAdapter) map.get(typeToken);
            if (typeAdapter2 != null) {
                return typeAdapter2;
            }
            z4 = false;
        }
        try {
            FutureTypeAdapter futureTypeAdapter = new FutureTypeAdapter();
            map.put(typeToken, futureTypeAdapter);
            Iterator it = this.f7537e.iterator();
            TypeAdapter typeAdapter3 = null;
            while (true) {
                if (it.hasNext()) {
                    typeAdapter3 = ((u) it.next()).a(this, typeToken);
                    if (typeAdapter3 != null) {
                        futureTypeAdapter.g(typeAdapter3);
                        map.put(typeToken, typeAdapter3);
                        break;
                    }
                } else {
                    break;
                }
            }
            if (typeAdapter3 != null) {
                if (z4) {
                    this.f7534b.putAll(map);
                }
                return typeAdapter3;
            }
            throw new IllegalArgumentException("GSON (2.13.2) cannot handle " + typeToken);
        } finally {
            if (z4) {
                this.f7533a.remove();
            }
        }
    }

    public TypeAdapter l(Class cls) {
        return k(TypeToken.a(cls));
    }

    public TypeAdapter m(u uVar, TypeToken typeToken) {
        Objects.requireNonNull(uVar, "skipPast must not be null");
        Objects.requireNonNull(typeToken, "type must not be null");
        if (this.f7536d.e(typeToken, uVar)) {
            uVar = this.f7536d;
        }
        boolean z4 = false;
        for (u uVar2 : this.f7537e) {
            if (z4) {
                TypeAdapter a5 = uVar2.a(this, typeToken);
                if (a5 != null) {
                    return a5;
                }
            } else if (uVar2 == uVar) {
                z4 = true;
            }
        }
        if (!z4) {
            return k(typeToken);
        }
        throw new IllegalArgumentException("GSON cannot serialize or deserialize " + typeToken);
    }

    public C1679a o(Reader reader) {
        C1679a aVar = new C1679a(reader);
        r rVar = this.f7546n;
        if (rVar == null) {
            rVar = r.LEGACY_STRICT;
        }
        aVar.S(rVar);
        return aVar;
    }

    public c p(Writer writer) {
        if (this.f7543k) {
            writer.write(")]}'\n");
        }
        c cVar = new c(writer);
        cVar.G(this.f7545m);
        cVar.H(this.f7544l);
        r rVar = this.f7546n;
        if (rVar == null) {
            rVar = r.LEGACY_STRICT;
        }
        cVar.J(rVar);
        cVar.I(this.f7541i);
        return cVar;
    }

    public String q(h hVar) {
        StringBuilder sb = new StringBuilder();
        u(hVar, sb);
        return sb.toString();
    }

    public String r(Object obj) {
        if (obj == null) {
            return q(j.f7809a);
        }
        return s(obj, obj.getClass());
    }

    public String s(Object obj, Type type) {
        StringBuilder sb = new StringBuilder();
        w(obj, type, sb);
        return sb.toString();
    }

    public void t(h hVar, c cVar) {
        r t5 = cVar.t();
        boolean u5 = cVar.u();
        boolean s5 = cVar.s();
        cVar.H(this.f7544l);
        cVar.I(this.f7541i);
        r rVar = this.f7546n;
        if (rVar != null) {
            cVar.J(rVar);
        } else if (cVar.t() == r.LEGACY_STRICT) {
            cVar.J(r.LENIENT);
        }
        try {
            E.a(hVar, cVar);
            cVar.J(t5);
            cVar.H(u5);
            cVar.I(s5);
        } catch (IOException e5) {
            throw new i((Throwable) e5);
        } catch (AssertionError e6) {
            throw new AssertionError("AssertionError (GSON 2.13.2): " + e6.getMessage(), e6);
        } catch (Throwable th) {
            cVar.J(t5);
            cVar.H(u5);
            cVar.I(s5);
            throw th;
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f7541i + ",factories:" + this.f7537e + ",instanceCreators:" + this.f7535c + "}";
    }

    public void u(h hVar, Appendable appendable) {
        try {
            t(hVar, p(E.b(appendable)));
        } catch (IOException e5) {
            throw new i((Throwable) e5);
        }
    }

    public void v(Object obj, Type type, c cVar) {
        TypeAdapter k5 = k(TypeToken.b(type));
        r t5 = cVar.t();
        r rVar = this.f7546n;
        if (rVar != null) {
            cVar.J(rVar);
        } else if (cVar.t() == r.LEGACY_STRICT) {
            cVar.J(r.LENIENT);
        }
        boolean u5 = cVar.u();
        boolean s5 = cVar.s();
        cVar.H(this.f7544l);
        cVar.I(this.f7541i);
        try {
            k5.d(cVar, obj);
            cVar.J(t5);
            cVar.H(u5);
            cVar.I(s5);
        } catch (IOException e5) {
            throw new i((Throwable) e5);
        } catch (AssertionError e6) {
            throw new AssertionError("AssertionError (GSON 2.13.2): " + e6.getMessage(), e6);
        } catch (Throwable th) {
            cVar.J(t5);
            cVar.H(u5);
            cVar.I(s5);
            throw th;
        }
    }

    public void w(Object obj, Type type, Appendable appendable) {
        try {
            v(obj, type, p(E.b(appendable)));
        } catch (IOException e5) {
            throw new i((Throwable) e5);
        }
    }

    Gson(Excluder excluder, d dVar, Map map, boolean z4, boolean z5, boolean z6, boolean z7, e eVar, r rVar, boolean z8, boolean z9, p pVar, String str, int i5, int i6, List list, List list2, List list3, t tVar, t tVar2, List list4) {
        boolean z10 = z8;
        boolean z11 = z9;
        List list5 = list4;
        this.f7533a = new ThreadLocal();
        this.f7534b = new ConcurrentHashMap();
        this.f7538f = excluder;
        this.f7539g = dVar;
        this.f7540h = map;
        t tVar3 = new t(map, z11, list5);
        this.f7535c = tVar3;
        this.f7541i = z4;
        this.f7542j = z5;
        this.f7543k = z6;
        this.f7544l = z7;
        this.f7545m = eVar;
        this.f7546n = rVar;
        this.f7547o = z10;
        this.f7548p = z11;
        p pVar2 = pVar;
        this.f7552t = pVar2;
        this.f7549q = str;
        this.f7550r = i5;
        this.f7551s = i6;
        this.f7553u = list;
        this.f7554v = list2;
        t tVar4 = tVar;
        this.f7555w = tVar4;
        t tVar5 = tVar2;
        this.f7556x = tVar5;
        this.f7557y = list5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.f7702W);
        arrayList.add(ObjectTypeAdapter.e(tVar4));
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.f7682C);
        arrayList.add(TypeAdapters.f7716m);
        arrayList.add(TypeAdapters.f7710g);
        arrayList.add(TypeAdapters.f7712i);
        arrayList.add(TypeAdapters.f7714k);
        TypeAdapter n5 = n(pVar2);
        arrayList.add(TypeAdapters.b(Long.TYPE, Long.class, n5));
        TypeAdapter e5 = e(z10);
        arrayList.add(TypeAdapters.b(Double.TYPE, Double.class, e5));
        TypeAdapter f5 = f(z10);
        arrayList.add(TypeAdapters.b(Float.TYPE, Float.class, f5));
        arrayList.add(NumberTypeAdapter.e(tVar5));
        arrayList.add(TypeAdapters.f7718o);
        arrayList.add(TypeAdapters.f7720q);
        arrayList.add(TypeAdapters.a(AtomicLong.class, b(n5)));
        arrayList.add(TypeAdapters.a(AtomicLongArray.class, c(n5)));
        arrayList.add(TypeAdapters.f7722s);
        arrayList.add(TypeAdapters.f7727x);
        arrayList.add(TypeAdapters.f7684E);
        arrayList.add(TypeAdapters.f7686G);
        arrayList.add(TypeAdapters.a(BigDecimal.class, TypeAdapters.f7729z));
        arrayList.add(TypeAdapters.a(BigInteger.class, TypeAdapters.f7680A));
        arrayList.add(TypeAdapters.a(x.class, TypeAdapters.f7681B));
        arrayList.add(TypeAdapters.f7688I);
        arrayList.add(TypeAdapters.f7690K);
        arrayList.add(TypeAdapters.f7694O);
        arrayList.add(TypeAdapters.f7696Q);
        arrayList.add(TypeAdapters.f7700U);
        arrayList.add(TypeAdapters.f7692M);
        arrayList.add(TypeAdapters.f7707d);
        arrayList.add(DefaultDateTypeAdapter.f7612c);
        arrayList.add(TypeAdapters.f7698S);
        if (a.f7764a) {
            arrayList.add(a.f7768e);
            arrayList.add(a.f7767d);
            arrayList.add(a.f7769f);
        }
        arrayList.add(ArrayTypeAdapter.f7606c);
        arrayList.add(TypeAdapters.f7705b);
        arrayList.add(new CollectionTypeAdapterFactory(tVar3));
        arrayList.add(new MapTypeAdapterFactory(tVar3, z5));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(tVar3);
        this.f7536d = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.f7703X);
        t tVar6 = tVar3;
        arrayList.add(new ReflectiveTypeAdapterFactory(tVar6, dVar, excluder, jsonAdapterAnnotationTypeAdapterFactory, list5));
        this.f7537e = DesugarCollections.unmodifiableList(arrayList);
    }
}
