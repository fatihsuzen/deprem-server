package j1;

import com.google.gson.e;
import com.google.gson.r;
import j$.util.Objects;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

public class c implements Closeable, Flushable {

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f15437l = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* renamed from: m  reason: collision with root package name */
    private static final String[] f15438m = new String[128];

    /* renamed from: n  reason: collision with root package name */
    private static final String[] f15439n;

    /* renamed from: a  reason: collision with root package name */
    private final Writer f15440a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f15441b = new int[32];

    /* renamed from: c  reason: collision with root package name */
    private int f15442c = 0;

    /* renamed from: d  reason: collision with root package name */
    private e f15443d;

    /* renamed from: e  reason: collision with root package name */
    private String f15444e;

    /* renamed from: f  reason: collision with root package name */
    private String f15445f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f15446g;

    /* renamed from: h  reason: collision with root package name */
    private r f15447h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f15448i;

    /* renamed from: j  reason: collision with root package name */
    private String f15449j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f15450k;

    static {
        for (int i5 = 0; i5 <= 31; i5++) {
            f15438m[i5] = String.format("\\u%04x", new Object[]{Integer.valueOf(i5)});
        }
        String[] strArr = f15438m;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f15439n = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        C(6);
        this.f15447h = r.LEGACY_STRICT;
        this.f15450k = true;
        Objects.requireNonNull(writer, "out == null");
        this.f15440a = writer;
        G(e.f7573d);
    }

    private c A(int i5, char c5) {
        l();
        C(i5);
        this.f15440a.write(c5);
        return this;
    }

    private int B() {
        int i5 = this.f15442c;
        if (i5 != 0) {
            return this.f15441b[i5 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void C(int i5) {
        int i6 = this.f15442c;
        int[] iArr = this.f15441b;
        if (i6 == iArr.length) {
            this.f15441b = Arrays.copyOf(iArr, i6 * 2);
        }
        int[] iArr2 = this.f15441b;
        int i7 = this.f15442c;
        this.f15442c = i7 + 1;
        iArr2[i7] = i5;
    }

    private void F(int i5) {
        this.f15441b[this.f15442c - 1] = i5;
    }

    private void K(String str) {
        String[] strArr;
        String str2;
        if (this.f15448i) {
            strArr = f15439n;
        } else {
            strArr = f15438m;
        }
        this.f15440a.write(34);
        int length = str.length();
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i5 < i6) {
                this.f15440a.write(str, i5, i6 - i5);
            }
            this.f15440a.write(str2);
            i5 = i6 + 1;
        }
        if (i5 < length) {
            this.f15440a.write(str, i5, length - i5);
        }
        this.f15440a.write(34);
    }

    private void R() {
        if (this.f15449j != null) {
            d();
            K(this.f15449j);
            this.f15449j = null;
        }
    }

    private static boolean a(Class cls) {
        if (cls == Integer.class || cls == Long.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class) {
            return true;
        }
        return false;
    }

    private void d() {
        int B4 = B();
        if (B4 == 5) {
            this.f15440a.write(this.f15445f);
        } else if (B4 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        y();
        F(4);
    }

    private void l() {
        int B4 = B();
        if (B4 == 1) {
            F(2);
            y();
        } else if (B4 == 2) {
            this.f15440a.append(this.f15445f);
            y();
        } else if (B4 != 4) {
            if (B4 != 6) {
                if (B4 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                } else if (this.f15447h != r.LENIENT) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            F(7);
        } else {
            this.f15440a.append(this.f15444e);
            F(5);
        }
    }

    private c o(int i5, int i6, char c5) {
        int B4 = B();
        if (B4 != i6 && B4 != i5) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f15449j == null) {
            this.f15442c--;
            if (B4 == i6) {
                y();
            }
            this.f15440a.write(c5);
            return this;
        } else {
            throw new IllegalStateException("Dangling name: " + this.f15449j);
        }
    }

    private void y() {
        if (!this.f15446g) {
            this.f15440a.write(this.f15443d.b());
            int i5 = this.f15442c;
            for (int i6 = 1; i6 < i5; i6++) {
                this.f15440a.write(this.f15443d.a());
            }
        }
    }

    public final void G(e eVar) {
        boolean z4;
        Objects.requireNonNull(eVar);
        this.f15443d = eVar;
        this.f15445f = ",";
        if (eVar.c()) {
            this.f15444e = ": ";
            if (this.f15443d.b().isEmpty()) {
                this.f15445f = ", ";
            }
        } else {
            this.f15444e = ":";
        }
        if (!this.f15443d.b().isEmpty() || !this.f15443d.a().isEmpty()) {
            z4 = false;
        } else {
            z4 = true;
        }
        this.f15446g = z4;
    }

    public final void H(boolean z4) {
        this.f15448i = z4;
    }

    public final void I(boolean z4) {
        this.f15450k = z4;
    }

    public final void J(r rVar) {
        Objects.requireNonNull(rVar);
        this.f15447h = rVar;
    }

    public c L(double d5) {
        R();
        if (this.f15447h == r.LENIENT || (!Double.isNaN(d5) && !Double.isInfinite(d5))) {
            l();
            this.f15440a.append(Double.toString(d5));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d5);
    }

    public c M(long j5) {
        R();
        l();
        this.f15440a.write(Long.toString(j5));
        return this;
    }

    public c N(Boolean bool) {
        String str;
        if (bool == null) {
            return z();
        }
        R();
        l();
        Writer writer = this.f15440a;
        if (bool.booleanValue()) {
            str = "true";
        } else {
            str = "false";
        }
        writer.write(str);
        return this;
    }

    public c O(Number number) {
        if (number == null) {
            return z();
        }
        R();
        String obj = number.toString();
        Class<?> cls = number.getClass();
        if (!a(cls)) {
            if (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN")) {
                if (this.f15447h != r.LENIENT) {
                    throw new IllegalArgumentException("Numeric values must be finite, but was " + obj);
                }
            } else if (!(cls == Float.class || cls == Double.class || f15437l.matcher(obj).matches())) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + obj);
            }
        }
        l();
        this.f15440a.append(obj);
        return this;
    }

    public c P(String str) {
        if (str == null) {
            return z();
        }
        R();
        l();
        K(str);
        return this;
    }

    public c Q(boolean z4) {
        String str;
        R();
        l();
        Writer writer = this.f15440a;
        if (z4) {
            str = "true";
        } else {
            str = "false";
        }
        writer.write(str);
        return this;
    }

    public void close() {
        this.f15440a.close();
        int i5 = this.f15442c;
        if (i5 > 1 || (i5 == 1 && this.f15441b[i5 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f15442c = 0;
    }

    public void flush() {
        if (this.f15442c != 0) {
            this.f15440a.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public c m() {
        R();
        return A(1, '[');
    }

    public c n() {
        R();
        return A(3, '{');
    }

    public c p() {
        return o(1, 2, ']');
    }

    public c q() {
        return o(3, 5, '}');
    }

    public final boolean s() {
        return this.f15450k;
    }

    public final r t() {
        return this.f15447h;
    }

    public final boolean u() {
        return this.f15448i;
    }

    public boolean v() {
        if (this.f15447h == r.LENIENT) {
            return true;
        }
        return false;
    }

    public c x(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f15449j == null) {
            int B4 = B();
            if (B4 == 3 || B4 == 5) {
                this.f15449j = str;
                return this;
            }
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        throw new IllegalStateException("Already wrote a name, expecting a value.");
    }

    public c z() {
        if (this.f15449j != null) {
            if (this.f15450k) {
                R();
            } else {
                this.f15449j = null;
                return this;
            }
        }
        l();
        this.f15440a.write("null");
        return this;
    }
}
