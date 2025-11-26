package M0;

import K0.b;
import K0.c;
import K0.d;
import K0.f;
import K0.g;
import android.util.Base64;
import android.util.JsonWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

final class e implements K0.e, g {

    /* renamed from: a  reason: collision with root package name */
    private e f2957a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2958b = true;

    /* renamed from: c  reason: collision with root package name */
    private final JsonWriter f2959c;

    /* renamed from: d  reason: collision with root package name */
    private final Map f2960d;

    /* renamed from: e  reason: collision with root package name */
    private final Map f2961e;

    /* renamed from: f  reason: collision with root package name */
    private final d f2962f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f2963g;

    e(Writer writer, Map map, Map map2, d dVar, boolean z4) {
        this.f2959c = new JsonWriter(writer);
        this.f2960d = map;
        this.f2961e = map2;
        this.f2962f = dVar;
        this.f2963g = z4;
    }

    private boolean t(Object obj) {
        if (obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number)) {
            return true;
        }
        return false;
    }

    private e w(String str, Object obj) {
        y();
        this.f2959c.name(str);
        if (obj != null) {
            return k(obj, false);
        }
        this.f2959c.nullValue();
        return this;
    }

    private e x(String str, Object obj) {
        if (obj == null) {
            return this;
        }
        y();
        this.f2959c.name(str);
        return k(obj, false);
    }

    private void y() {
        if (this.f2958b) {
            e eVar = this.f2957a;
            if (eVar != null) {
                eVar.y();
                this.f2957a.f2958b = false;
                this.f2957a = null;
                this.f2959c.endObject();
                return;
            }
            return;
        }
        throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
    }

    public K0.e a(c cVar, Object obj) {
        return p(cVar.b(), obj);
    }

    public K0.e c(c cVar, long j5) {
        return o(cVar.b(), j5);
    }

    public K0.e d(c cVar, int i5) {
        return n(cVar.b(), i5);
    }

    public K0.e e(c cVar, double d5) {
        return m(cVar.b(), d5);
    }

    public K0.e g(c cVar, boolean z4) {
        return q(cVar.b(), z4);
    }

    public e h(double d5) {
        y();
        this.f2959c.value(d5);
        return this;
    }

    public e i(int i5) {
        y();
        this.f2959c.value((long) i5);
        return this;
    }

    public e j(long j5) {
        y();
        this.f2959c.value(j5);
        return this;
    }

    /* access modifiers changed from: package-private */
    public e k(Object obj, boolean z4) {
        Class<?> cls;
        int i5 = 0;
        if (z4 && t(obj)) {
            if (obj == null) {
                cls = null;
            } else {
                cls = obj.getClass();
            }
            throw new b(String.format("%s cannot be encoded inline", new Object[]{cls}));
        } else if (obj == null) {
            this.f2959c.nullValue();
            return this;
        } else if (obj instanceof Number) {
            this.f2959c.value((Number) obj);
            return this;
        } else if (obj.getClass().isArray()) {
            if (obj instanceof byte[]) {
                return s((byte[]) obj);
            }
            this.f2959c.beginArray();
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int length = iArr.length;
                while (i5 < length) {
                    this.f2959c.value((long) iArr[i5]);
                    i5++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length2 = jArr.length;
                while (i5 < length2) {
                    j(jArr[i5]);
                    i5++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length3 = dArr.length;
                while (i5 < length3) {
                    this.f2959c.value(dArr[i5]);
                    i5++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length4 = zArr.length;
                while (i5 < length4) {
                    this.f2959c.value(zArr[i5]);
                    i5++;
                }
            } else if (obj instanceof Number[]) {
                for (Number k5 : (Number[]) obj) {
                    k(k5, false);
                }
            } else {
                for (Object k6 : (Object[]) obj) {
                    k(k6, false);
                }
            }
            this.f2959c.endArray();
            return this;
        } else if (obj instanceof Collection) {
            this.f2959c.beginArray();
            for (Object k7 : (Collection) obj) {
                k(k7, false);
            }
            this.f2959c.endArray();
            return this;
        } else if (obj instanceof Map) {
            this.f2959c.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                try {
                    p((String) key, entry.getValue());
                } catch (ClassCastException e5) {
                    throw new b(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", new Object[]{key, key.getClass()}), e5);
                }
            }
            this.f2959c.endObject();
            return this;
        } else {
            d dVar = (d) this.f2960d.get(obj.getClass());
            if (dVar != null) {
                return v(dVar, obj, z4);
            }
            f fVar = (f) this.f2961e.get(obj.getClass());
            if (fVar != null) {
                fVar.a(obj, this);
                return this;
            } else if (!(obj instanceof Enum)) {
                return v(this.f2962f, obj, z4);
            } else {
                if (obj instanceof f) {
                    i(((f) obj).getNumber());
                    return this;
                }
                b(((Enum) obj).name());
                return this;
            }
        }
    }

    /* renamed from: l */
    public e b(String str) {
        y();
        this.f2959c.value(str);
        return this;
    }

    public e m(String str, double d5) {
        y();
        this.f2959c.name(str);
        return h(d5);
    }

    public e n(String str, int i5) {
        y();
        this.f2959c.name(str);
        return i(i5);
    }

    public e o(String str, long j5) {
        y();
        this.f2959c.name(str);
        return j(j5);
    }

    public e p(String str, Object obj) {
        if (this.f2963g) {
            return x(str, obj);
        }
        return w(str, obj);
    }

    public e q(String str, boolean z4) {
        y();
        this.f2959c.name(str);
        return f(z4);
    }

    /* renamed from: r */
    public e f(boolean z4) {
        y();
        this.f2959c.value(z4);
        return this;
    }

    public e s(byte[] bArr) {
        y();
        if (bArr == null) {
            this.f2959c.nullValue();
            return this;
        }
        this.f2959c.value(Base64.encodeToString(bArr, 2));
        return this;
    }

    /* access modifiers changed from: package-private */
    public void u() {
        y();
        this.f2959c.flush();
    }

    /* access modifiers changed from: package-private */
    public e v(d dVar, Object obj, boolean z4) {
        if (!z4) {
            this.f2959c.beginObject();
        }
        dVar.a(obj, this);
        if (!z4) {
            this.f2959c.endObject();
        }
        return this;
    }
}
