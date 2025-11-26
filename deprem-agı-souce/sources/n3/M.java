package N3;

import H3.l;
import K3.b;
import M3.C2128b;
import M3.f;
import M3.r;
import O3.d;
import kotlin.jvm.internal.t;

public final class M extends b implements r {

    /* renamed from: a  reason: collision with root package name */
    private final C2138h f18753a;

    /* renamed from: b  reason: collision with root package name */
    private final C2128b f18754b;

    /* renamed from: c  reason: collision with root package name */
    private final U f18755c;

    /* renamed from: d  reason: collision with root package name */
    private final r[] f18756d;

    /* renamed from: e  reason: collision with root package name */
    private final d f18757e;

    /* renamed from: f  reason: collision with root package name */
    private final f f18758f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f18759g;

    /* renamed from: h  reason: collision with root package name */
    private String f18760h;

    /* renamed from: i  reason: collision with root package name */
    private String f18761i;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18762a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                N3.U[] r0 = N3.U.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                N3.U r1 = N3.U.LIST     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                N3.U r1 = N3.U.MAP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                N3.U r1 = N3.U.POLY_OBJ     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f18762a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: N3.M.a.<clinit>():void");
        }
    }

    public M(C2138h hVar, C2128b bVar, U u5, r[] rVarArr) {
        t.e(hVar, "composer");
        t.e(bVar, "json");
        t.e(u5, "mode");
        this.f18753a = hVar;
        this.f18754b = bVar;
        this.f18755c = u5;
        this.f18756d = rVarArr;
        this.f18757e = a().d();
        this.f18758f = a().c();
        int ordinal = u5.ordinal();
        if (rVarArr != null) {
            r rVar = rVarArr[ordinal];
            if (rVar != null || rVar != this) {
                rVarArr[ordinal] = this;
            }
        }
    }

    private final void b(String str, String str2) {
        this.f18753a.c();
        encodeString(str);
        this.f18753a.f(':');
        this.f18753a.p();
        encodeString(str2);
    }

    public C2128b a() {
        return this.f18754b;
    }

    public K3.d beginStructure(J3.f fVar) {
        r rVar;
        t.e(fVar, "descriptor");
        U b5 = V.b(a(), fVar);
        char c5 = b5.f18773a;
        if (c5 != 0) {
            this.f18753a.f(c5);
            this.f18753a.b();
        }
        String str = this.f18760h;
        if (str != null) {
            String str2 = this.f18761i;
            if (str2 == null) {
                str2 = fVar.a();
            }
            b(str, str2);
            this.f18760h = null;
            this.f18761i = null;
        }
        if (this.f18755c == b5) {
            return this;
        }
        r[] rVarArr = this.f18756d;
        if (rVarArr == null || (rVar = rVarArr[b5.ordinal()]) == null) {
            return new M(this.f18753a, a(), b5, this.f18756d);
        }
        return rVar;
    }

    public void encodeBoolean(boolean z4) {
        if (this.f18759g) {
            encodeString(String.valueOf(z4));
        } else {
            this.f18753a.m(z4);
        }
    }

    public void encodeByte(byte b5) {
        if (this.f18759g) {
            encodeString(String.valueOf(b5));
        } else {
            this.f18753a.e(b5);
        }
    }

    public void encodeChar(char c5) {
        encodeString(String.valueOf(c5));
    }

    public void encodeDouble(double d5) {
        if (this.f18759g) {
            encodeString(String.valueOf(d5));
        } else {
            this.f18753a.g(d5);
        }
        if (this.f18758f.b()) {
            return;
        }
        if (Double.isInfinite(d5) || Double.isNaN(d5)) {
            throw z.b(Double.valueOf(d5), this.f18753a.f18790a.toString());
        }
    }

    public boolean encodeElement(J3.f fVar, int i5) {
        t.e(fVar, "descriptor");
        int i6 = a.f18762a[this.f18755c.ordinal()];
        if (i6 != 1) {
            boolean z4 = false;
            if (i6 != 2) {
                if (i6 != 3) {
                    if (!this.f18753a.a()) {
                        this.f18753a.f(',');
                    }
                    this.f18753a.c();
                    encodeString(B.h(fVar, a(), i5));
                    this.f18753a.f(':');
                    this.f18753a.p();
                } else {
                    if (i5 == 0) {
                        this.f18759g = true;
                    }
                    if (i5 == 1) {
                        this.f18753a.f(',');
                        this.f18753a.p();
                        this.f18759g = false;
                    }
                }
            } else if (!this.f18753a.a()) {
                if (i5 % 2 == 0) {
                    this.f18753a.f(',');
                    this.f18753a.c();
                    z4 = true;
                } else {
                    this.f18753a.f(':');
                    this.f18753a.p();
                }
                this.f18759g = z4;
            } else {
                this.f18759g = true;
                this.f18753a.c();
            }
        } else {
            if (!this.f18753a.a()) {
                this.f18753a.f(',');
            }
            this.f18753a.c();
        }
        return true;
    }

    public void encodeEnum(J3.f fVar, int i5) {
        t.e(fVar, "enumDescriptor");
        encodeString(fVar.f(i5));
    }

    public void encodeFloat(float f5) {
        if (this.f18759g) {
            encodeString(String.valueOf(f5));
        } else {
            this.f18753a.h(f5);
        }
        if (this.f18758f.b()) {
            return;
        }
        if (Float.isInfinite(f5) || Float.isNaN(f5)) {
            throw z.b(Float.valueOf(f5), this.f18753a.f18790a.toString());
        }
    }

    public K3.f encodeInline(J3.f fVar) {
        t.e(fVar, "descriptor");
        if (N.b(fVar)) {
            C2138h hVar = this.f18753a;
            if (!(hVar instanceof C2145o)) {
                hVar = new C2145o(hVar.f18790a, this.f18759g);
            }
            return new M(hVar, a(), this.f18755c, (r[]) null);
        } else if (N.a(fVar)) {
            C2138h hVar2 = this.f18753a;
            if (!(hVar2 instanceof C2139i)) {
                hVar2 = new C2139i(hVar2.f18790a, this.f18759g);
            }
            return new M(hVar2, a(), this.f18755c, (r[]) null);
        } else if (this.f18760h == null) {
            return super.encodeInline(fVar);
        } else {
            this.f18761i = fVar.a();
            return this;
        }
    }

    public void encodeInt(int i5) {
        if (this.f18759g) {
            encodeString(String.valueOf(i5));
        } else {
            this.f18753a.i(i5);
        }
    }

    public void encodeLong(long j5) {
        if (this.f18759g) {
            encodeString(String.valueOf(j5));
        } else {
            this.f18753a.j(j5);
        }
    }

    public void encodeNull() {
        this.f18753a.k("null");
    }

    public void encodeNullableSerializableElement(J3.f fVar, int i5, l lVar, Object obj) {
        t.e(fVar, "descriptor");
        t.e(lVar, "serializer");
        if (obj != null || this.f18758f.j()) {
            super.encodeNullableSerializableElement(fVar, i5, lVar, obj);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005f, code lost:
        if (kotlin.jvm.internal.t.a(r1, J3.o.d.f18393a) == false) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0029, code lost:
        if (a().c().f() != M3.C2127a.NONE) goto L_0x0061;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encodeSerializableValue(H3.l r4, java.lang.Object r5) {
        /*
            r3 = this;
            java.lang.String r0 = "serializer"
            kotlin.jvm.internal.t.e(r4, r0)
            M3.b r0 = r3.a()
            M3.f r0 = r0.c()
            boolean r0 = r0.p()
            if (r0 == 0) goto L_0x0017
            r4.serialize(r3, r5)
            return
        L_0x0017:
            boolean r0 = r4 instanceof L3.C2078b
            if (r0 == 0) goto L_0x002c
            M3.b r1 = r3.a()
            M3.f r1 = r1.c()
            M3.a r1 = r1.f()
            M3.a r2 = M3.C2127a.NONE
            if (r1 == r2) goto L_0x0074
            goto L_0x0061
        L_0x002c:
            M3.b r1 = r3.a()
            M3.f r1 = r1.c()
            M3.a r1 = r1.f()
            int[] r2 = N3.K.a.f18742a
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 1
            if (r1 == r2) goto L_0x0074
            r2 = 2
            if (r1 == r2) goto L_0x0074
            r2 = 3
            if (r1 != r2) goto L_0x006e
            J3.f r1 = r4.getDescriptor()
            J3.n r1 = r1.getKind()
            J3.o$a r2 = J3.o.a.f18390a
            boolean r2 = kotlin.jvm.internal.t.a(r1, r2)
            if (r2 != 0) goto L_0x0061
            J3.o$d r2 = J3.o.d.f18393a
            boolean r1 = kotlin.jvm.internal.t.a(r1, r2)
            if (r1 == 0) goto L_0x0074
        L_0x0061:
            J3.f r1 = r4.getDescriptor()
            M3.b r2 = r3.a()
            java.lang.String r1 = N3.K.c(r1, r2)
            goto L_0x0075
        L_0x006e:
            W2.q r4 = new W2.q
            r4.<init>()
            throw r4
        L_0x0074:
            r1 = 0
        L_0x0075:
            if (r0 == 0) goto L_0x00bb
            r0 = r4
            L3.b r0 = (L3.C2078b) r0
            if (r5 == 0) goto L_0x0097
            H3.l r0 = H3.h.b(r0, r3, r5)
            if (r1 == 0) goto L_0x0085
            N3.K.d(r4, r0, r1)
        L_0x0085:
            J3.f r4 = r0.getDescriptor()
            J3.n r4 = r4.getKind()
            N3.K.b(r4)
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.encodePolymorphically>"
            kotlin.jvm.internal.t.c(r0, r4)
            r4 = r0
            goto L_0x00bb
        L_0x0097:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Value for serializer "
            r4.append(r5)
            J3.f r5 = r0.getDescriptor()
            r4.append(r5)
            java.lang.String r5 = " should always be non-null. Please report issue to the kotlinx.serialization tracker."
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        L_0x00bb:
            if (r1 == 0) goto L_0x00c9
            J3.f r0 = r4.getDescriptor()
            java.lang.String r0 = r0.a()
            r3.f18760h = r1
            r3.f18761i = r0
        L_0x00c9:
            r4.serialize(r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.M.encodeSerializableValue(H3.l, java.lang.Object):void");
    }

    public void encodeShort(short s5) {
        if (this.f18759g) {
            encodeString(String.valueOf(s5));
        } else {
            this.f18753a.l(s5);
        }
    }

    public void encodeString(String str) {
        t.e(str, "value");
        this.f18753a.n(str);
    }

    public void endStructure(J3.f fVar) {
        t.e(fVar, "descriptor");
        if (this.f18755c.f18774b != 0) {
            this.f18753a.q();
            this.f18753a.d();
            this.f18753a.f(this.f18755c.f18774b);
        }
    }

    public d getSerializersModule() {
        return this.f18757e;
    }

    public boolean shouldEncodeElementDefault(J3.f fVar, int i5) {
        t.e(fVar, "descriptor");
        return this.f18758f.i();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public M(C2149t tVar, C2128b bVar, U u5, r[] rVarArr) {
        this(C2147q.a(tVar, bVar), bVar, u5, rVarArr);
        t.e(tVar, "output");
        t.e(bVar, "json");
        t.e(u5, "mode");
        t.e(rVarArr, "modeReuseCache");
    }
}
