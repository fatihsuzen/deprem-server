package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.internal.F;
import com.google.gson.internal.x;
import com.google.gson.internal.z;
import com.google.gson.o;
import com.google.gson.reflect.TypeToken;
import com.google.gson.u;
import j1.C1679a;
import j1.b;
import j1.c;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public abstract class TypeAdapters {

    /* renamed from: A  reason: collision with root package name */
    public static final TypeAdapter f7680A = new TypeAdapter() {
        /* renamed from: e */
        public BigInteger b(C1679a aVar) {
            if (aVar.N() == b.NULL) {
                aVar.J();
                return null;
            }
            String L4 = aVar.L();
            try {
                return z.c(L4);
            } catch (NumberFormatException e5) {
                throw new o("Failed parsing '" + L4 + "' as BigInteger; at path " + aVar.u(), e5);
            }
        }

        /* renamed from: f */
        public void d(c cVar, BigInteger bigInteger) {
            cVar.O(bigInteger);
        }
    };

    /* renamed from: B  reason: collision with root package name */
    public static final TypeAdapter f7681B = new TypeAdapter() {
        /* renamed from: e */
        public x b(C1679a aVar) {
            if (aVar.N() != b.NULL) {
                return new x(aVar.L());
            }
            aVar.J();
            return null;
        }

        /* renamed from: f */
        public void d(c cVar, x xVar) {
            cVar.O(xVar);
        }
    };

    /* renamed from: C  reason: collision with root package name */
    public static final u f7682C;

    /* renamed from: D  reason: collision with root package name */
    public static final TypeAdapter f7683D;

    /* renamed from: E  reason: collision with root package name */
    public static final u f7684E;

    /* renamed from: F  reason: collision with root package name */
    public static final TypeAdapter f7685F;

    /* renamed from: G  reason: collision with root package name */
    public static final u f7686G;

    /* renamed from: H  reason: collision with root package name */
    public static final TypeAdapter f7687H;

    /* renamed from: I  reason: collision with root package name */
    public static final u f7688I;

    /* renamed from: J  reason: collision with root package name */
    public static final TypeAdapter f7689J;

    /* renamed from: K  reason: collision with root package name */
    public static final u f7690K;

    /* renamed from: L  reason: collision with root package name */
    public static final TypeAdapter f7691L;

    /* renamed from: M  reason: collision with root package name */
    public static final u f7692M;

    /* renamed from: N  reason: collision with root package name */
    public static final TypeAdapter f7693N;

    /* renamed from: O  reason: collision with root package name */
    public static final u f7694O;

    /* renamed from: P  reason: collision with root package name */
    public static final TypeAdapter f7695P;

    /* renamed from: Q  reason: collision with root package name */
    public static final u f7696Q;

    /* renamed from: R  reason: collision with root package name */
    public static final TypeAdapter f7697R;

    /* renamed from: S  reason: collision with root package name */
    public static final u f7698S;

    /* renamed from: T  reason: collision with root package name */
    public static final TypeAdapter f7699T;

    /* renamed from: U  reason: collision with root package name */
    public static final u f7700U;

    /* renamed from: V  reason: collision with root package name */
    public static final TypeAdapter f7701V;

    /* renamed from: W  reason: collision with root package name */
    public static final u f7702W;

    /* renamed from: X  reason: collision with root package name */
    public static final u f7703X = EnumTypeAdapter.f7617d;

    /* renamed from: a  reason: collision with root package name */
    public static final TypeAdapter f7704a;

    /* renamed from: b  reason: collision with root package name */
    public static final u f7705b;

    /* renamed from: c  reason: collision with root package name */
    public static final TypeAdapter f7706c;

    /* renamed from: d  reason: collision with root package name */
    public static final u f7707d;

    /* renamed from: e  reason: collision with root package name */
    public static final TypeAdapter f7708e;

    /* renamed from: f  reason: collision with root package name */
    public static final TypeAdapter f7709f = new TypeAdapter() {
        /* renamed from: e */
        public Boolean b(C1679a aVar) {
            if (aVar.N() != b.NULL) {
                return Boolean.valueOf(aVar.L());
            }
            aVar.J();
            return null;
        }

        /* renamed from: f */
        public void d(c cVar, Boolean bool) {
            String str;
            if (bool == null) {
                str = "null";
            } else {
                str = bool.toString();
            }
            cVar.P(str);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static final u f7710g;

    /* renamed from: h  reason: collision with root package name */
    public static final TypeAdapter f7711h;

    /* renamed from: i  reason: collision with root package name */
    public static final u f7712i;

    /* renamed from: j  reason: collision with root package name */
    public static final TypeAdapter f7713j;

    /* renamed from: k  reason: collision with root package name */
    public static final u f7714k;

    /* renamed from: l  reason: collision with root package name */
    public static final TypeAdapter f7715l;

    /* renamed from: m  reason: collision with root package name */
    public static final u f7716m;

    /* renamed from: n  reason: collision with root package name */
    public static final TypeAdapter f7717n;

    /* renamed from: o  reason: collision with root package name */
    public static final u f7718o;

    /* renamed from: p  reason: collision with root package name */
    public static final TypeAdapter f7719p;

    /* renamed from: q  reason: collision with root package name */
    public static final u f7720q;

    /* renamed from: r  reason: collision with root package name */
    public static final TypeAdapter f7721r;

    /* renamed from: s  reason: collision with root package name */
    public static final u f7722s;

    /* renamed from: t  reason: collision with root package name */
    public static final TypeAdapter f7723t = new TypeAdapter() {
        /* renamed from: e */
        public Number b(C1679a aVar) {
            if (aVar.N() == b.NULL) {
                aVar.J();
                return null;
            }
            try {
                return Long.valueOf(aVar.G());
            } catch (NumberFormatException e5) {
                throw new o((Throwable) e5);
            }
        }

        /* renamed from: f */
        public void d(c cVar, Number number) {
            if (number == null) {
                cVar.z();
            } else {
                cVar.M(number.longValue());
            }
        }
    };

    /* renamed from: u  reason: collision with root package name */
    public static final TypeAdapter f7724u = new TypeAdapter() {
        /* renamed from: e */
        public Number b(C1679a aVar) {
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
            if (!(number instanceof Float)) {
                number = Float.valueOf(number.floatValue());
            }
            cVar.O(number);
        }
    };

    /* renamed from: v  reason: collision with root package name */
    public static final TypeAdapter f7725v = new TypeAdapter() {
        /* renamed from: e */
        public Number b(C1679a aVar) {
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
            } else {
                cVar.L(number.doubleValue());
            }
        }
    };

    /* renamed from: w  reason: collision with root package name */
    public static final TypeAdapter f7726w;

    /* renamed from: x  reason: collision with root package name */
    public static final u f7727x;

    /* renamed from: y  reason: collision with root package name */
    public static final TypeAdapter f7728y;

    /* renamed from: z  reason: collision with root package name */
    public static final TypeAdapter f7729z = new TypeAdapter() {
        /* renamed from: e */
        public BigDecimal b(C1679a aVar) {
            if (aVar.N() == b.NULL) {
                aVar.J();
                return null;
            }
            String L4 = aVar.L();
            try {
                return z.b(L4);
            } catch (NumberFormatException e5) {
                throw new o("Failed parsing '" + L4 + "' as BigDecimal; at path " + aVar.u(), e5);
            }
        }

        /* renamed from: f */
        public void d(c cVar, BigDecimal bigDecimal) {
            cVar.O(bigDecimal);
        }
    };

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$28  reason: invalid class name */
    class AnonymousClass28 implements u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TypeToken f7730a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TypeAdapter f7731b;

        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            if (typeToken.equals(this.f7730a)) {
                return this.f7731b;
            }
            return null;
        }
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7744a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                j1.b[] r0 = j1.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7744a = r0
                j1.b r1 = j1.b.NUMBER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7744a     // Catch:{ NoSuchFieldError -> 0x001d }
                j1.b r1 = j1.b.STRING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7744a     // Catch:{ NoSuchFieldError -> 0x0028 }
                j1.b r1 = j1.b.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.TypeAdapters.a.<clinit>():void");
        }
    }

    static {
        TypeAdapter a5 = new TypeAdapter() {
            /* renamed from: e */
            public Class b(C1679a aVar) {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?\nSee " + F.a("java-lang-class-unsupported"));
            }

            /* renamed from: f */
            public void d(c cVar, Class cls) {
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?\nSee " + F.a("java-lang-class-unsupported"));
            }
        }.a();
        f7704a = a5;
        f7705b = a(Class.class, a5);
        TypeAdapter a6 = new TypeAdapter() {
            /* renamed from: e */
            public BitSet b(C1679a aVar) {
                BitSet bitSet = new BitSet();
                aVar.d();
                b N4 = aVar.N();
                int i5 = 0;
                while (N4 != b.END_ARRAY) {
                    int i6 = a.f7744a[N4.ordinal()];
                    boolean z4 = true;
                    if (i6 == 1 || i6 == 2) {
                        int F4 = aVar.F();
                        if (F4 == 0) {
                            z4 = false;
                        } else if (F4 != 1) {
                            throw new o("Invalid bitset value " + F4 + ", expected 0 or 1; at path " + aVar.u());
                        }
                    } else if (i6 == 3) {
                        z4 = aVar.B();
                    } else {
                        throw new o("Invalid bitset value type: " + N4 + "; at path " + aVar.getPath());
                    }
                    if (z4) {
                        bitSet.set(i5);
                    }
                    i5++;
                    N4 = aVar.N();
                }
                aVar.p();
                return bitSet;
            }

            /* renamed from: f */
            public void d(c cVar, BitSet bitSet) {
                cVar.m();
                int length = bitSet.length();
                for (int i5 = 0; i5 < length; i5++) {
                    cVar.M(bitSet.get(i5) ? 1 : 0);
                }
                cVar.p();
            }
        }.a();
        f7706c = a6;
        f7707d = a(BitSet.class, a6);
        AnonymousClass3 r02 = new TypeAdapter() {
            /* renamed from: e */
            public Boolean b(C1679a aVar) {
                b N4 = aVar.N();
                if (N4 == b.NULL) {
                    aVar.J();
                    return null;
                } else if (N4 == b.STRING) {
                    return Boolean.valueOf(Boolean.parseBoolean(aVar.L()));
                } else {
                    return Boolean.valueOf(aVar.B());
                }
            }

            /* renamed from: f */
            public void d(c cVar, Boolean bool) {
                cVar.N(bool);
            }
        };
        f7708e = r02;
        f7710g = b(Boolean.TYPE, Boolean.class, r02);
        AnonymousClass5 r03 = new TypeAdapter() {
            /* renamed from: e */
            public Number b(C1679a aVar) {
                if (aVar.N() == b.NULL) {
                    aVar.J();
                    return null;
                }
                try {
                    int F4 = aVar.F();
                    if (F4 <= 255 && F4 >= -128) {
                        return Byte.valueOf((byte) F4);
                    }
                    throw new o("Lossy conversion from " + F4 + " to byte; at path " + aVar.u());
                } catch (NumberFormatException e5) {
                    throw new o((Throwable) e5);
                }
            }

            /* renamed from: f */
            public void d(c cVar, Number number) {
                if (number == null) {
                    cVar.z();
                } else {
                    cVar.M((long) number.byteValue());
                }
            }
        };
        f7711h = r03;
        f7712i = b(Byte.TYPE, Byte.class, r03);
        AnonymousClass6 r04 = new TypeAdapter() {
            /* renamed from: e */
            public Number b(C1679a aVar) {
                if (aVar.N() == b.NULL) {
                    aVar.J();
                    return null;
                }
                try {
                    int F4 = aVar.F();
                    if (F4 <= 65535 && F4 >= -32768) {
                        return Short.valueOf((short) F4);
                    }
                    throw new o("Lossy conversion from " + F4 + " to short; at path " + aVar.u());
                } catch (NumberFormatException e5) {
                    throw new o((Throwable) e5);
                }
            }

            /* renamed from: f */
            public void d(c cVar, Number number) {
                if (number == null) {
                    cVar.z();
                } else {
                    cVar.M((long) number.shortValue());
                }
            }
        };
        f7713j = r04;
        f7714k = b(Short.TYPE, Short.class, r04);
        AnonymousClass7 r05 = new TypeAdapter() {
            /* renamed from: e */
            public Number b(C1679a aVar) {
                if (aVar.N() == b.NULL) {
                    aVar.J();
                    return null;
                }
                try {
                    return Integer.valueOf(aVar.F());
                } catch (NumberFormatException e5) {
                    throw new o((Throwable) e5);
                }
            }

            /* renamed from: f */
            public void d(c cVar, Number number) {
                if (number == null) {
                    cVar.z();
                } else {
                    cVar.M((long) number.intValue());
                }
            }
        };
        f7715l = r05;
        f7716m = b(Integer.TYPE, Integer.class, r05);
        TypeAdapter a7 = new TypeAdapter() {
            /* renamed from: e */
            public AtomicInteger b(C1679a aVar) {
                try {
                    return new AtomicInteger(aVar.F());
                } catch (NumberFormatException e5) {
                    throw new o((Throwable) e5);
                }
            }

            /* renamed from: f */
            public void d(c cVar, AtomicInteger atomicInteger) {
                cVar.M((long) atomicInteger.get());
            }
        }.a();
        f7717n = a7;
        f7718o = a(AtomicInteger.class, a7);
        TypeAdapter a8 = new TypeAdapter() {
            /* renamed from: e */
            public AtomicBoolean b(C1679a aVar) {
                return new AtomicBoolean(aVar.B());
            }

            /* renamed from: f */
            public void d(c cVar, AtomicBoolean atomicBoolean) {
                cVar.Q(atomicBoolean.get());
            }
        }.a();
        f7719p = a8;
        f7720q = a(AtomicBoolean.class, a8);
        TypeAdapter a9 = new TypeAdapter() {
            /* renamed from: e */
            public AtomicIntegerArray b(C1679a aVar) {
                ArrayList arrayList = new ArrayList();
                aVar.d();
                while (aVar.x()) {
                    try {
                        arrayList.add(Integer.valueOf(aVar.F()));
                    } catch (NumberFormatException e5) {
                        throw new o((Throwable) e5);
                    }
                }
                aVar.p();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i5 = 0; i5 < size; i5++) {
                    atomicIntegerArray.set(i5, ((Integer) arrayList.get(i5)).intValue());
                }
                return atomicIntegerArray;
            }

            /* renamed from: f */
            public void d(c cVar, AtomicIntegerArray atomicIntegerArray) {
                cVar.m();
                int length = atomicIntegerArray.length();
                for (int i5 = 0; i5 < length; i5++) {
                    cVar.M((long) atomicIntegerArray.get(i5));
                }
                cVar.p();
            }
        }.a();
        f7721r = a9;
        f7722s = a(AtomicIntegerArray.class, a9);
        AnonymousClass14 r06 = new TypeAdapter() {
            /* renamed from: e */
            public Character b(C1679a aVar) {
                if (aVar.N() == b.NULL) {
                    aVar.J();
                    return null;
                }
                String L4 = aVar.L();
                if (L4.length() == 1) {
                    return Character.valueOf(L4.charAt(0));
                }
                throw new o("Expecting character, got: " + L4 + "; at " + aVar.u());
            }

            /* renamed from: f */
            public void d(c cVar, Character ch) {
                String str;
                if (ch == null) {
                    str = null;
                } else {
                    str = String.valueOf(ch);
                }
                cVar.P(str);
            }
        };
        f7726w = r06;
        f7727x = b(Character.TYPE, Character.class, r06);
        AnonymousClass15 r07 = new TypeAdapter() {
            /* renamed from: e */
            public String b(C1679a aVar) {
                b N4 = aVar.N();
                if (N4 == b.NULL) {
                    aVar.J();
                    return null;
                } else if (N4 == b.BOOLEAN) {
                    return Boolean.toString(aVar.B());
                } else {
                    return aVar.L();
                }
            }

            /* renamed from: f */
            public void d(c cVar, String str) {
                cVar.P(str);
            }
        };
        f7728y = r07;
        f7682C = a(String.class, r07);
        AnonymousClass19 r08 = new TypeAdapter() {
            /* renamed from: e */
            public StringBuilder b(C1679a aVar) {
                if (aVar.N() != b.NULL) {
                    return new StringBuilder(aVar.L());
                }
                aVar.J();
                return null;
            }

            /* renamed from: f */
            public void d(c cVar, StringBuilder sb) {
                String str;
                if (sb == null) {
                    str = null;
                } else {
                    str = sb.toString();
                }
                cVar.P(str);
            }
        };
        f7683D = r08;
        f7684E = a(StringBuilder.class, r08);
        AnonymousClass20 r09 = new TypeAdapter() {
            /* renamed from: e */
            public StringBuffer b(C1679a aVar) {
                if (aVar.N() != b.NULL) {
                    return new StringBuffer(aVar.L());
                }
                aVar.J();
                return null;
            }

            /* renamed from: f */
            public void d(c cVar, StringBuffer stringBuffer) {
                String str;
                if (stringBuffer == null) {
                    str = null;
                } else {
                    str = stringBuffer.toString();
                }
                cVar.P(str);
            }
        };
        f7685F = r09;
        f7686G = a(StringBuffer.class, r09);
        AnonymousClass21 r010 = new TypeAdapter() {
            /* renamed from: e */
            public URL b(C1679a aVar) {
                if (aVar.N() == b.NULL) {
                    aVar.J();
                    return null;
                }
                String L4 = aVar.L();
                if (L4.equals("null")) {
                    return null;
                }
                return new URL(L4);
            }

            /* renamed from: f */
            public void d(c cVar, URL url) {
                String str;
                if (url == null) {
                    str = null;
                } else {
                    str = url.toExternalForm();
                }
                cVar.P(str);
            }
        };
        f7687H = r010;
        f7688I = a(URL.class, r010);
        AnonymousClass22 r011 = new TypeAdapter() {
            /* renamed from: e */
            public URI b(C1679a aVar) {
                if (aVar.N() == b.NULL) {
                    aVar.J();
                    return null;
                }
                try {
                    String L4 = aVar.L();
                    if (L4.equals("null")) {
                        return null;
                    }
                    return new URI(L4);
                } catch (URISyntaxException e5) {
                    throw new i((Throwable) e5);
                }
            }

            /* renamed from: f */
            public void d(c cVar, URI uri) {
                String str;
                if (uri == null) {
                    str = null;
                } else {
                    str = uri.toASCIIString();
                }
                cVar.P(str);
            }
        };
        f7689J = r011;
        f7690K = a(URI.class, r011);
        AnonymousClass23 r012 = new TypeAdapter() {
            /* renamed from: e */
            public InetAddress b(C1679a aVar) {
                if (aVar.N() != b.NULL) {
                    return InetAddress.getByName(aVar.L());
                }
                aVar.J();
                return null;
            }

            /* renamed from: f */
            public void d(c cVar, InetAddress inetAddress) {
                String str;
                if (inetAddress == null) {
                    str = null;
                } else {
                    str = inetAddress.getHostAddress();
                }
                cVar.P(str);
            }
        };
        f7691L = r012;
        f7692M = d(InetAddress.class, r012);
        AnonymousClass24 r013 = new TypeAdapter() {
            /* renamed from: e */
            public UUID b(C1679a aVar) {
                if (aVar.N() == b.NULL) {
                    aVar.J();
                    return null;
                }
                String L4 = aVar.L();
                try {
                    return UUID.fromString(L4);
                } catch (IllegalArgumentException e5) {
                    throw new o("Failed parsing '" + L4 + "' as UUID; at path " + aVar.u(), e5);
                }
            }

            /* renamed from: f */
            public void d(c cVar, UUID uuid) {
                String str;
                if (uuid == null) {
                    str = null;
                } else {
                    str = uuid.toString();
                }
                cVar.P(str);
            }
        };
        f7693N = r013;
        f7694O = a(UUID.class, r013);
        TypeAdapter a10 = new TypeAdapter() {
            /* renamed from: e */
            public Currency b(C1679a aVar) {
                String L4 = aVar.L();
                try {
                    return Currency.getInstance(L4);
                } catch (IllegalArgumentException e5) {
                    throw new o("Failed parsing '" + L4 + "' as Currency; at path " + aVar.u(), e5);
                }
            }

            /* renamed from: f */
            public void d(c cVar, Currency currency) {
                cVar.P(currency.getCurrencyCode());
            }
        }.a();
        f7695P = a10;
        f7696Q = a(Currency.class, a10);
        AnonymousClass26 r014 = new TypeAdapter() {
            /* renamed from: e */
            public Calendar b(C1679a aVar) {
                if (aVar.N() == b.NULL) {
                    aVar.J();
                    return null;
                }
                aVar.l();
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                while (aVar.N() != b.END_OBJECT) {
                    String H4 = aVar.H();
                    int F4 = aVar.F();
                    H4.getClass();
                    char c5 = 65535;
                    switch (H4.hashCode()) {
                        case -1181204563:
                            if (H4.equals("dayOfMonth")) {
                                c5 = 0;
                                break;
                            }
                            break;
                        case -1074026988:
                            if (H4.equals("minute")) {
                                c5 = 1;
                                break;
                            }
                            break;
                        case -906279820:
                            if (H4.equals("second")) {
                                c5 = 2;
                                break;
                            }
                            break;
                        case 3704893:
                            if (H4.equals("year")) {
                                c5 = 3;
                                break;
                            }
                            break;
                        case 104080000:
                            if (H4.equals("month")) {
                                c5 = 4;
                                break;
                            }
                            break;
                        case 985252545:
                            if (H4.equals("hourOfDay")) {
                                c5 = 5;
                                break;
                            }
                            break;
                    }
                    switch (c5) {
                        case 0:
                            i7 = F4;
                            break;
                        case 1:
                            i9 = F4;
                            break;
                        case 2:
                            i10 = F4;
                            break;
                        case 3:
                            i5 = F4;
                            break;
                        case 4:
                            i6 = F4;
                            break;
                        case 5:
                            i8 = F4;
                            break;
                    }
                }
                aVar.q();
                return new GregorianCalendar(i5, i6, i7, i8, i9, i10);
            }

            /* renamed from: f */
            public void d(c cVar, Calendar calendar) {
                if (calendar == null) {
                    cVar.z();
                    return;
                }
                cVar.n();
                cVar.x("year");
                cVar.M((long) calendar.get(1));
                cVar.x("month");
                cVar.M((long) calendar.get(2));
                cVar.x("dayOfMonth");
                cVar.M((long) calendar.get(5));
                cVar.x("hourOfDay");
                cVar.M((long) calendar.get(11));
                cVar.x("minute");
                cVar.M((long) calendar.get(12));
                cVar.x("second");
                cVar.M((long) calendar.get(13));
                cVar.q();
            }
        };
        f7697R = r014;
        f7698S = c(Calendar.class, GregorianCalendar.class, r014);
        AnonymousClass27 r015 = new TypeAdapter() {
            /* renamed from: e */
            public Locale b(C1679a aVar) {
                String str;
                String str2;
                String str3 = null;
                if (aVar.N() == b.NULL) {
                    aVar.J();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(aVar.L(), "_");
                if (stringTokenizer.hasMoreElements()) {
                    str = stringTokenizer.nextToken();
                } else {
                    str = null;
                }
                if (stringTokenizer.hasMoreElements()) {
                    str2 = stringTokenizer.nextToken();
                } else {
                    str2 = null;
                }
                if (stringTokenizer.hasMoreElements()) {
                    str3 = stringTokenizer.nextToken();
                }
                if (str2 == null && str3 == null) {
                    return new Locale(str);
                }
                if (str3 == null) {
                    return new Locale(str, str2);
                }
                return new Locale(str, str2, str3);
            }

            /* renamed from: f */
            public void d(c cVar, Locale locale) {
                String str;
                if (locale == null) {
                    str = null;
                } else {
                    str = locale.toString();
                }
                cVar.P(str);
            }
        };
        f7699T = r015;
        f7700U = a(Locale.class, r015);
        JsonElementTypeAdapter jsonElementTypeAdapter = JsonElementTypeAdapter.f7625a;
        f7701V = jsonElementTypeAdapter;
        f7702W = d(h.class, jsonElementTypeAdapter);
    }

    public static u a(final Class cls, final TypeAdapter typeAdapter) {
        return new u() {
            public TypeAdapter a(Gson gson, TypeToken typeToken) {
                if (typeToken.c() == cls) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static u b(final Class cls, final Class cls2, final TypeAdapter typeAdapter) {
        return new u() {
            public TypeAdapter a(Gson gson, TypeToken typeToken) {
                Class c5 = typeToken.c();
                if (c5 == cls || c5 == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static u c(final Class cls, final Class cls2, final TypeAdapter typeAdapter) {
        return new u() {
            public TypeAdapter a(Gson gson, TypeToken typeToken) {
                Class c5 = typeToken.c();
                if (c5 == cls || c5 == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static u d(final Class cls, final TypeAdapter typeAdapter) {
        return new u() {
            public TypeAdapter a(Gson gson, TypeToken typeToken) {
                final Class c5 = typeToken.c();
                if (!cls.isAssignableFrom(c5)) {
                    return null;
                }
                return new TypeAdapter() {
                    public Object b(C1679a aVar) {
                        Object b5 = typeAdapter.b(aVar);
                        if (b5 == null || c5.isInstance(b5)) {
                            return b5;
                        }
                        throw new o("Expected a " + c5.getName() + " but was " + b5.getClass().getName() + "; at path " + aVar.u());
                    }

                    public void d(c cVar, Object obj) {
                        typeAdapter.d(cVar, obj);
                    }
                };
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }
}
