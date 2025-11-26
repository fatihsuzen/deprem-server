package N0;

import K0.b;
import K0.c;
import K0.d;
import K0.e;
import androidx.work.WorkInfo;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;

final class f implements e {

    /* renamed from: f  reason: collision with root package name */
    private static final Charset f3170f = Charset.forName(C.UTF8_NAME);

    /* renamed from: g  reason: collision with root package name */
    private static final c f3171g = c.a("key").b(a.b().c(1).a()).a();

    /* renamed from: h  reason: collision with root package name */
    private static final c f3172h = c.a("value").b(a.b().c(2).a()).a();

    /* renamed from: i  reason: collision with root package name */
    private static final d f3173i = new e();

    /* renamed from: a  reason: collision with root package name */
    private OutputStream f3174a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f3175b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f3176c;

    /* renamed from: d  reason: collision with root package name */
    private final d f3177d;

    /* renamed from: e  reason: collision with root package name */
    private final i f3178e = new i(this);

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3179a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                N0.d$a[] r0 = N0.d.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3179a = r0
                N0.d$a r1 = N0.d.a.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3179a     // Catch:{ NoSuchFieldError -> 0x001d }
                N0.d$a r1 = N0.d.a.SIGNED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3179a     // Catch:{ NoSuchFieldError -> 0x0028 }
                N0.d$a r1 = N0.d.a.FIXED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: N0.f.a.<clinit>():void");
        }
    }

    f(OutputStream outputStream, Map map, Map map2, d dVar) {
        this.f3174a = outputStream;
        this.f3175b = map;
        this.f3176c = map2;
        this.f3177d = dVar;
    }

    public static /* synthetic */ void b(Map.Entry entry, e eVar) {
        eVar.a(f3171g, entry.getKey());
        eVar.a(f3172h, entry.getValue());
    }

    private static ByteBuffer p(int i5) {
        return ByteBuffer.allocate(i5).order(ByteOrder.LITTLE_ENDIAN);
    }

    private long q(d dVar, Object obj) {
        OutputStream outputStream;
        b bVar = new b();
        try {
            outputStream = this.f3174a;
            this.f3174a = bVar;
            dVar.a(obj, this);
            this.f3174a = outputStream;
            long a5 = bVar.a();
            bVar.close();
            return a5;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private f r(d dVar, c cVar, Object obj, boolean z4) {
        long q5 = q(dVar, obj);
        if (z4 && q5 == 0) {
            return this;
        }
        w((v(cVar) << 3) | 2);
        x(q5);
        dVar.a(obj, this);
        return this;
    }

    private f s(K0.f fVar, c cVar, Object obj, boolean z4) {
        this.f3178e.c(cVar, z4);
        fVar.a(obj, this.f3178e);
        return this;
    }

    private static d u(c cVar) {
        d dVar = (d) cVar.c(d.class);
        if (dVar != null) {
            return dVar;
        }
        throw new b("Field has no @Protobuf config");
    }

    private static int v(c cVar) {
        d dVar = (d) cVar.c(d.class);
        if (dVar != null) {
            return dVar.tag();
        }
        throw new b("Field has no @Protobuf config");
    }

    private void w(int i5) {
        while (((long) (i5 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT)) != 0) {
            this.f3174a.write((i5 & 127) | 128);
            i5 >>>= 7;
        }
        this.f3174a.write(i5 & 127);
    }

    private void x(long j5) {
        while ((-128 & j5) != 0) {
            this.f3174a.write((((int) j5) & 127) | 128);
            j5 >>>= 7;
        }
        this.f3174a.write(((int) j5) & 127);
    }

    public e a(c cVar, Object obj) {
        return i(cVar, obj, true);
    }

    public e e(c cVar, double d5) {
        return f(cVar, d5, true);
    }

    /* access modifiers changed from: package-private */
    public e f(c cVar, double d5, boolean z4) {
        if (z4 && d5 == 0.0d) {
            return this;
        }
        w((v(cVar) << 3) | 1);
        this.f3174a.write(p(8).putDouble(d5).array());
        return this;
    }

    /* access modifiers changed from: package-private */
    public e h(c cVar, float f5, boolean z4) {
        if (z4 && f5 == 0.0f) {
            return this;
        }
        w((v(cVar) << 3) | 5);
        this.f3174a.write(p(4).putFloat(f5).array());
        return this;
    }

    /* access modifiers changed from: package-private */
    public e i(c cVar, Object obj, boolean z4) {
        if (obj != null) {
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                if (!z4 || charSequence.length() != 0) {
                    w((v(cVar) << 3) | 2);
                    byte[] bytes = charSequence.toString().getBytes(f3170f);
                    w(bytes.length);
                    this.f3174a.write(bytes);
                    return this;
                }
            } else if (obj instanceof Collection) {
                for (Object i5 : (Collection) obj) {
                    i(cVar, i5, false);
                }
            } else if (obj instanceof Map) {
                for (Map.Entry r5 : ((Map) obj).entrySet()) {
                    r(f3173i, cVar, r5, false);
                }
            } else if (obj instanceof Double) {
                return f(cVar, ((Double) obj).doubleValue(), z4);
            } else {
                if (obj instanceof Float) {
                    return h(cVar, ((Float) obj).floatValue(), z4);
                }
                if (obj instanceof Number) {
                    return m(cVar, ((Number) obj).longValue(), z4);
                }
                if (obj instanceof Boolean) {
                    return o(cVar, ((Boolean) obj).booleanValue(), z4);
                }
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    if (!z4 || bArr.length != 0) {
                        w((v(cVar) << 3) | 2);
                        w(bArr.length);
                        this.f3174a.write(bArr);
                        return this;
                    }
                } else {
                    d dVar = (d) this.f3175b.get(obj.getClass());
                    if (dVar != null) {
                        return r(dVar, cVar, obj, z4);
                    }
                    K0.f fVar = (K0.f) this.f3176c.get(obj.getClass());
                    if (fVar != null) {
                        return s(fVar, cVar, obj, z4);
                    }
                    if (obj instanceof c) {
                        return d(cVar, ((c) obj).getNumber());
                    }
                    if (obj instanceof Enum) {
                        return d(cVar, ((Enum) obj).ordinal());
                    }
                    return r(this.f3177d, cVar, obj, z4);
                }
            }
        }
        return this;
    }

    /* renamed from: j */
    public f d(c cVar, int i5) {
        return k(cVar, i5, true);
    }

    /* access modifiers changed from: package-private */
    public f k(c cVar, int i5, boolean z4) {
        if (!z4 || i5 != 0) {
            d u5 = u(cVar);
            int i6 = a.f3179a[u5.intEncoding().ordinal()];
            if (i6 == 1) {
                w(u5.tag() << 3);
                w(i5);
                return this;
            } else if (i6 == 2) {
                w(u5.tag() << 3);
                w((i5 << 1) ^ (i5 >> 31));
                return this;
            } else if (i6 == 3) {
                w((u5.tag() << 3) | 5);
                this.f3174a.write(p(4).putInt(i5).array());
                return this;
            }
        }
        return this;
    }

    /* renamed from: l */
    public f c(c cVar, long j5) {
        return m(cVar, j5, true);
    }

    /* access modifiers changed from: package-private */
    public f m(c cVar, long j5, boolean z4) {
        if (!z4 || j5 != 0) {
            d u5 = u(cVar);
            int i5 = a.f3179a[u5.intEncoding().ordinal()];
            if (i5 == 1) {
                w(u5.tag() << 3);
                x(j5);
                return this;
            } else if (i5 == 2) {
                w(u5.tag() << 3);
                x((j5 >> 63) ^ (j5 << 1));
                return this;
            } else if (i5 == 3) {
                w((u5.tag() << 3) | 1);
                this.f3174a.write(p(8).putLong(j5).array());
                return this;
            }
        }
        return this;
    }

    /* renamed from: n */
    public f g(c cVar, boolean z4) {
        return o(cVar, z4, true);
    }

    /* access modifiers changed from: package-private */
    public f o(c cVar, boolean z4, boolean z5) {
        return k(cVar, z4 ? 1 : 0, z5);
    }

    /* access modifiers changed from: package-private */
    public f t(Object obj) {
        if (obj == null) {
            return this;
        }
        d dVar = (d) this.f3175b.get(obj.getClass());
        if (dVar != null) {
            dVar.a(obj, this);
            return this;
        }
        throw new b("No encoder for " + obj.getClass());
    }
}
