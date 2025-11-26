package z0;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: z0.h  reason: case insensitive filesystem */
class C1979h implements Closeable {

    /* renamed from: g  reason: collision with root package name */
    private static final Logger f17197g = Logger.getLogger(C1979h.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RandomAccessFile f17198a;

    /* renamed from: b  reason: collision with root package name */
    int f17199b;

    /* renamed from: c  reason: collision with root package name */
    private int f17200c;

    /* renamed from: d  reason: collision with root package name */
    private b f17201d;

    /* renamed from: e  reason: collision with root package name */
    private b f17202e;

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f17203f = new byte[16];

    /* renamed from: z0.h$a */
    class a implements d {

        /* renamed from: a  reason: collision with root package name */
        boolean f17204a = true;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ StringBuilder f17205b;

        a(StringBuilder sb) {
            this.f17205b = sb;
        }

        public void a(InputStream inputStream, int i5) {
            if (this.f17204a) {
                this.f17204a = false;
            } else {
                this.f17205b.append(", ");
            }
            this.f17205b.append(i5);
        }
    }

    /* renamed from: z0.h$b */
    static class b {

        /* renamed from: c  reason: collision with root package name */
        static final b f17207c = new b(0, 0);

        /* renamed from: a  reason: collision with root package name */
        final int f17208a;

        /* renamed from: b  reason: collision with root package name */
        final int f17209b;

        b(int i5, int i6) {
            this.f17208a = i5;
            this.f17209b = i6;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f17208a + ", length = " + this.f17209b + "]";
        }
    }

    /* renamed from: z0.h$c */
    private final class c extends InputStream {

        /* renamed from: a  reason: collision with root package name */
        private int f17210a;

        /* renamed from: b  reason: collision with root package name */
        private int f17211b;

        /* synthetic */ c(C1979h hVar, b bVar, a aVar) {
            this(bVar);
        }

        public int read(byte[] bArr, int i5, int i6) {
            Object unused = C1979h.v(bArr, "buffer");
            if ((i5 | i6) < 0 || i6 > bArr.length - i5) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i7 = this.f17211b;
            if (i7 <= 0) {
                return -1;
            }
            if (i6 > i7) {
                i6 = i7;
            }
            C1979h.this.F(this.f17210a, bArr, i5, i6);
            this.f17210a = C1979h.this.J(this.f17210a + i6);
            this.f17211b -= i6;
            return i6;
        }

        private c(b bVar) {
            this.f17210a = C1979h.this.J(bVar.f17208a + 4);
            this.f17211b = bVar.f17209b;
        }

        public int read() {
            if (this.f17211b == 0) {
                return -1;
            }
            C1979h.this.f17198a.seek((long) this.f17210a);
            int read = C1979h.this.f17198a.read();
            this.f17210a = C1979h.this.J(this.f17210a + 1);
            this.f17211b--;
            return read;
        }
    }

    /* renamed from: z0.h$d */
    public interface d {
        void a(InputStream inputStream, int i5);
    }

    public C1979h(File file) {
        if (!file.exists()) {
            t(file);
        }
        this.f17198a = x(file);
        z();
    }

    private static int A(byte[] bArr, int i5) {
        return ((bArr[i5] & 255) << 24) + ((bArr[i5 + 1] & 255) << 16) + ((bArr[i5 + 2] & 255) << 8) + (bArr[i5 + 3] & 255);
    }

    private int B() {
        return this.f17199b - I();
    }

    /* access modifiers changed from: private */
    public void F(int i5, byte[] bArr, int i6, int i7) {
        int J4 = J(i5);
        int i8 = J4 + i7;
        int i9 = this.f17199b;
        if (i8 <= i9) {
            this.f17198a.seek((long) J4);
            this.f17198a.readFully(bArr, i6, i7);
            return;
        }
        int i10 = i9 - J4;
        this.f17198a.seek((long) J4);
        this.f17198a.readFully(bArr, i6, i10);
        this.f17198a.seek(16);
        this.f17198a.readFully(bArr, i6 + i10, i7 - i10);
    }

    private void G(int i5, byte[] bArr, int i6, int i7) {
        int J4 = J(i5);
        int i8 = J4 + i7;
        int i9 = this.f17199b;
        if (i8 <= i9) {
            this.f17198a.seek((long) J4);
            this.f17198a.write(bArr, i6, i7);
            return;
        }
        int i10 = i9 - J4;
        this.f17198a.seek((long) J4);
        this.f17198a.write(bArr, i6, i10);
        this.f17198a.seek(16);
        this.f17198a.write(bArr, i6 + i10, i7 - i10);
    }

    private void H(int i5) {
        this.f17198a.setLength((long) i5);
        this.f17198a.getChannel().force(true);
    }

    /* access modifiers changed from: private */
    public int J(int i5) {
        int i6 = this.f17199b;
        if (i5 < i6) {
            return i5;
        }
        return (i5 + 16) - i6;
    }

    private void K(int i5, int i6, int i7, int i8) {
        M(this.f17203f, i5, i6, i7, i8);
        this.f17198a.seek(0);
        this.f17198a.write(this.f17203f);
    }

    private static void L(byte[] bArr, int i5, int i6) {
        bArr[i5] = (byte) (i6 >> 24);
        bArr[i5 + 1] = (byte) (i6 >> 16);
        bArr[i5 + 2] = (byte) (i6 >> 8);
        bArr[i5 + 3] = (byte) i6;
    }

    private static void M(byte[] bArr, int... iArr) {
        int i5 = 0;
        for (int L4 : iArr) {
            L(bArr, i5, L4);
            i5 += 4;
        }
    }

    private void q(int i5) {
        int i6 = i5 + 4;
        int B4 = B();
        if (B4 < i6) {
            int i7 = this.f17199b;
            do {
                B4 += i7;
                i7 <<= 1;
            } while (B4 < i6);
            H(i7);
            b bVar = this.f17202e;
            int J4 = J(bVar.f17208a + 4 + bVar.f17209b);
            if (J4 < this.f17201d.f17208a) {
                FileChannel channel = this.f17198a.getChannel();
                channel.position((long) this.f17199b);
                long j5 = (long) (J4 - 4);
                if (channel.transferTo(16, j5, channel) != j5) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            int i8 = this.f17202e.f17208a;
            int i9 = this.f17201d.f17208a;
            if (i8 < i9) {
                int i10 = (this.f17199b + i8) - 16;
                K(i7, this.f17200c, i9, i10);
                this.f17202e = new b(i10, this.f17202e.f17209b);
            } else {
                K(i7, this.f17200c, i9, i8);
            }
            this.f17199b = i7;
        }
    }

    /* JADX INFO: finally extract failed */
    private static void t(File file) {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile x4 = x(file2);
        try {
            x4.setLength(4096);
            x4.seek(0);
            byte[] bArr = new byte[16];
            M(bArr, 4096, 0, 0, 0);
            x4.write(bArr);
            x4.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            x4.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static Object v(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    private static RandomAccessFile x(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    private b y(int i5) {
        if (i5 == 0) {
            return b.f17207c;
        }
        this.f17198a.seek((long) i5);
        return new b(i5, this.f17198a.readInt());
    }

    private void z() {
        this.f17198a.seek(0);
        this.f17198a.readFully(this.f17203f);
        int A4 = A(this.f17203f, 0);
        this.f17199b = A4;
        if (((long) A4) <= this.f17198a.length()) {
            this.f17200c = A(this.f17203f, 4);
            int A5 = A(this.f17203f, 8);
            int A6 = A(this.f17203f, 12);
            this.f17201d = y(A5);
            this.f17202e = y(A6);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f17199b + ", Actual length: " + this.f17198a.length());
    }

    public synchronized void C() {
        try {
            if (u()) {
                throw new NoSuchElementException();
            } else if (this.f17200c == 1) {
                p();
            } else {
                b bVar = this.f17201d;
                int J4 = J(bVar.f17208a + 4 + bVar.f17209b);
                F(J4, this.f17203f, 0, 4);
                int A4 = A(this.f17203f, 0);
                K(this.f17199b, this.f17200c - 1, J4, this.f17202e.f17208a);
                this.f17200c--;
                this.f17201d = new b(J4, A4);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public int I() {
        if (this.f17200c == 0) {
            return 16;
        }
        b bVar = this.f17202e;
        int i5 = bVar.f17208a;
        int i6 = this.f17201d.f17208a;
        if (i5 >= i6) {
            return (i5 - i6) + 4 + bVar.f17209b + 16;
        }
        return (((i5 + 4) + bVar.f17209b) + this.f17199b) - i6;
    }

    public synchronized void close() {
        this.f17198a.close();
    }

    public void n(byte[] bArr) {
        o(bArr, 0, bArr.length);
    }

    public synchronized void o(byte[] bArr, int i5, int i6) {
        int i7;
        int i8;
        try {
            v(bArr, "buffer");
            if ((i5 | i6) < 0 || i6 > bArr.length - i5) {
                throw new IndexOutOfBoundsException();
            }
            q(i6);
            boolean u5 = u();
            if (u5) {
                i7 = 16;
            } else {
                b bVar = this.f17202e;
                i7 = J(bVar.f17208a + 4 + bVar.f17209b);
            }
            b bVar2 = new b(i7, i6);
            L(this.f17203f, 0, i6);
            G(bVar2.f17208a, this.f17203f, 0, 4);
            G(bVar2.f17208a + 4, bArr, i5, i6);
            if (u5) {
                i8 = bVar2.f17208a;
            } else {
                i8 = this.f17201d.f17208a;
            }
            K(this.f17199b, this.f17200c + 1, i8, bVar2.f17208a);
            this.f17202e = bVar2;
            this.f17200c++;
            if (u5) {
                this.f17201d = bVar2;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void p() {
        try {
            K(4096, 0, 0, 0);
            this.f17200c = 0;
            b bVar = b.f17207c;
            this.f17201d = bVar;
            this.f17202e = bVar;
            if (this.f17199b > 4096) {
                H(4096);
            }
            this.f17199b = 4096;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public synchronized void s(d dVar) {
        int i5 = this.f17201d.f17208a;
        for (int i6 = 0; i6 < this.f17200c; i6++) {
            b y4 = y(i5);
            dVar.a(new c(this, y4, (a) null), y4.f17209b);
            i5 = J(y4.f17208a + 4 + y4.f17209b);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f17199b);
        sb.append(", size=");
        sb.append(this.f17200c);
        sb.append(", first=");
        sb.append(this.f17201d);
        sb.append(", last=");
        sb.append(this.f17202e);
        sb.append(", element lengths=[");
        try {
            s(new a(sb));
        } catch (IOException e5) {
            f17197g.log(Level.WARNING, "read error", e5);
        }
        sb.append("]]");
        return sb.toString();
    }

    public synchronized boolean u() {
        boolean z4;
        if (this.f17200c == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        return z4;
    }
}
