package z0;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;
import u0.g;
import x0.C1914j;
import z0.C1979h;

/* renamed from: z0.i  reason: case insensitive filesystem */
class C1980i implements C1975d {

    /* renamed from: d  reason: collision with root package name */
    private static final Charset f17213d = Charset.forName(C.UTF8_NAME);

    /* renamed from: a  reason: collision with root package name */
    private final File f17214a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17215b;

    /* renamed from: c  reason: collision with root package name */
    private C1979h f17216c;

    /* renamed from: z0.i$a */
    class a implements C1979h.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ byte[] f17217a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int[] f17218b;

        a(byte[] bArr, int[] iArr) {
            this.f17217a = bArr;
            this.f17218b = iArr;
        }

        public void a(InputStream inputStream, int i5) {
            try {
                inputStream.read(this.f17217a, this.f17218b[0], i5);
                int[] iArr = this.f17218b;
                iArr[0] = iArr[0] + i5;
            } finally {
                inputStream.close();
            }
        }
    }

    /* renamed from: z0.i$b */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f17220a;

        /* renamed from: b  reason: collision with root package name */
        public final int f17221b;

        b(byte[] bArr, int i5) {
            this.f17220a = bArr;
            this.f17221b = i5;
        }
    }

    C1980i(File file, int i5) {
        this.f17214a = file;
        this.f17215b = i5;
    }

    private void f(long j5, String str) {
        if (this.f17216c != null) {
            if (str == null) {
                str = "null";
            }
            try {
                int i5 = this.f17215b / 4;
                if (str.length() > i5) {
                    str = "..." + str.substring(str.length() - i5);
                }
                this.f17216c.n(String.format(Locale.US, "%d %s%n", new Object[]{Long.valueOf(j5), str.replaceAll("\r", " ").replaceAll("\n", " ")}).getBytes(f17213d));
                while (!this.f17216c.u() && this.f17216c.I() > this.f17215b) {
                    this.f17216c.C();
                }
            } catch (IOException e5) {
                g.f().e("There was a problem writing to the Crashlytics log.", e5);
            }
        }
    }

    private b g() {
        if (!this.f17214a.exists()) {
            return null;
        }
        h();
        C1979h hVar = this.f17216c;
        if (hVar == null) {
            return null;
        }
        int[] iArr = {0};
        byte[] bArr = new byte[hVar.I()];
        try {
            this.f17216c.s(new a(bArr, iArr));
        } catch (IOException e5) {
            g.f().e("A problem occurred while reading the Crashlytics log file.", e5);
        }
        return new b(bArr, iArr[0]);
    }

    private void h() {
        if (this.f17216c == null) {
            try {
                this.f17216c = new C1979h(this.f17214a);
            } catch (IOException e5) {
                g f5 = g.f();
                f5.e("Could not open log file: " + this.f17214a, e5);
            }
        }
    }

    public void a() {
        C1914j.f(this.f17216c, "There was a problem closing the Crashlytics log file.");
        this.f17216c = null;
    }

    public String b() {
        byte[] c5 = c();
        if (c5 != null) {
            return new String(c5, f17213d);
        }
        return null;
    }

    public byte[] c() {
        b g5 = g();
        if (g5 == null) {
            return null;
        }
        int i5 = g5.f17221b;
        byte[] bArr = new byte[i5];
        System.arraycopy(g5.f17220a, 0, bArr, 0, i5);
        return bArr;
    }

    public void d() {
        a();
        this.f17214a.delete();
    }

    public void e(long j5, String str) {
        h();
        f(j5, str);
    }
}
