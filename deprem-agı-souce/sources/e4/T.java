package e4;

import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.t;
import t3.C2777a;

public final class T implements C2358g {

    /* renamed from: a  reason: collision with root package name */
    public final Z f21508a;

    /* renamed from: b  reason: collision with root package name */
    public final C2356e f21509b = new C2356e();

    /* renamed from: c  reason: collision with root package name */
    public boolean f21510c;

    public T(Z z4) {
        t.e(z4, "source");
        this.f21508a = z4;
    }

    public boolean a(long j5, C2359h hVar, int i5, int i6) {
        t.e(hVar, "bytes");
        if (this.f21510c) {
            throw new IllegalStateException("closed");
        } else if (j5 < 0 || i5 < 0 || i6 < 0 || hVar.F() - i5 < i6) {
            return false;
        } else {
            for (int i7 = 0; i7 < i6; i7++) {
                long j6 = ((long) i7) + j5;
                if (!request(1 + j6) || this.f21509b.q(j6) != hVar.h(i5 + i7)) {
                    return false;
                }
            }
            return true;
        }
    }

    public C2356e buffer() {
        return this.f21509b;
    }

    public void close() {
        if (!this.f21510c) {
            this.f21510c = true;
            this.f21508a.close();
            this.f21509b.a();
        }
    }

    public long e(C2356e eVar, long j5) {
        t.e(eVar, "sink");
        if (j5 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j5).toString());
        } else if (this.f21510c) {
            throw new IllegalStateException("closed");
        } else if (this.f21509b.size() == 0 && this.f21508a.e(this.f21509b, 8192) == -1) {
            return -1;
        } else {
            return this.f21509b.e(eVar, Math.min(j5, this.f21509b.size()));
        }
    }

    public boolean exhausted() {
        if (this.f21510c) {
            throw new IllegalStateException("closed");
        } else if (!this.f21509b.exhausted() || this.f21508a.e(this.f21509b, 8192) != -1) {
            return false;
        } else {
            return true;
        }
    }

    public C2356e g() {
        return this.f21509b;
    }

    public long indexOf(byte b5) {
        return indexOf(b5, 0, Long.MAX_VALUE);
    }

    public InputStream inputStream() {
        return new a(this);
    }

    public boolean isOpen() {
        return !this.f21510c;
    }

    public boolean k(long j5, C2359h hVar) {
        t.e(hVar, "bytes");
        return a(j5, hVar, 0, hVar.F());
    }

    public int read(ByteBuffer byteBuffer) {
        t.e(byteBuffer, "sink");
        if (this.f21509b.size() == 0 && this.f21508a.e(this.f21509b, 8192) == -1) {
            return -1;
        }
        return this.f21509b.read(byteBuffer);
    }

    public byte readByte() {
        require(1);
        return this.f21509b.readByte();
    }

    public byte[] readByteArray() {
        this.f21509b.I(this.f21508a);
        return this.f21509b.readByteArray();
    }

    public C2359h readByteString(long j5) {
        require(j5);
        return this.f21509b.readByteString(j5);
    }

    public long readDecimalLong() {
        int i5;
        require(1);
        long j5 = 0;
        while (true) {
            long j6 = j5 + 1;
            if (!request(j6)) {
                break;
            }
            byte q5 = this.f21509b.q(j5);
            if ((q5 >= 48 && q5 <= 57) || (j5 == 0 && q5 == 45)) {
                j5 = j6;
            } else if (i5 == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Expected a digit or '-' but was 0x");
                String num = Integer.toString(q5, C2777a.a(C2777a.a(16)));
                t.d(num, "toString(this, checkRadix(radix))");
                sb.append(num);
                throw new NumberFormatException(sb.toString());
            }
        }
        return this.f21509b.readDecimalLong();
    }

    public void readFully(byte[] bArr) {
        t.e(bArr, "sink");
        try {
            require((long) bArr.length);
            this.f21509b.readFully(bArr);
        } catch (EOFException e5) {
            int i5 = 0;
            while (this.f21509b.size() > 0) {
                C2356e eVar = this.f21509b;
                int read = eVar.read(bArr, i5, (int) eVar.size());
                if (read != -1) {
                    i5 += read;
                } else {
                    throw new AssertionError();
                }
            }
            throw e5;
        }
    }

    public long readHexadecimalUnsignedLong() {
        require(1);
        int i5 = 0;
        while (true) {
            int i6 = i5 + 1;
            if (!request((long) i6)) {
                break;
            }
            byte q5 = this.f21509b.q((long) i5);
            if ((q5 >= 48 && q5 <= 57) || ((q5 >= 97 && q5 <= 102) || (q5 >= 65 && q5 <= 70))) {
                i5 = i6;
            } else if (i5 == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Expected leading [0-9a-fA-F] character but was 0x");
                String num = Integer.toString(q5, C2777a.a(C2777a.a(16)));
                t.d(num, "toString(this, checkRadix(radix))");
                sb.append(num);
                throw new NumberFormatException(sb.toString());
            }
        }
        return this.f21509b.readHexadecimalUnsignedLong();
    }

    public int readInt() {
        require(4);
        return this.f21509b.readInt();
    }

    public int readIntLe() {
        require(4);
        return this.f21509b.readIntLe();
    }

    public long readLongLe() {
        require(8);
        return this.f21509b.readLongLe();
    }

    public short readShort() {
        require(2);
        return this.f21509b.readShort();
    }

    public short readShortLe() {
        require(2);
        return this.f21509b.readShortLe();
    }

    public String readUtf8(long j5) {
        require(j5);
        return this.f21509b.readUtf8(j5);
    }

    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public boolean request(long j5) {
        if (j5 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j5).toString());
        } else if (!this.f21510c) {
            while (this.f21509b.size() < j5) {
                if (this.f21508a.e(this.f21509b, 8192) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public void require(long j5) {
        if (!request(j5)) {
            throw new EOFException();
        }
    }

    public void skip(long j5) {
        if (!this.f21510c) {
            while (j5 > 0) {
                if (this.f21509b.size() == 0 && this.f21508a.e(this.f21509b, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j5, this.f21509b.size());
                this.f21509b.skip(min);
                j5 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public a0 timeout() {
        return this.f21508a.timeout();
    }

    public String toString() {
        return "buffer(" + this.f21508a + ')';
    }

    public long indexOf(byte b5, long j5, long j6) {
        if (this.f21510c) {
            throw new IllegalStateException("closed");
        } else if (0 > j5 || j5 > j6) {
            throw new IllegalArgumentException(("fromIndex=" + j5 + " toIndex=" + j6).toString());
        } else {
            long j7 = j5;
            while (j7 < j6) {
                byte b6 = b5;
                long j8 = j6;
                long indexOf = this.f21509b.indexOf(b6, j7, j8);
                if (indexOf == -1) {
                    long size = this.f21509b.size();
                    if (size >= j8 || this.f21508a.e(this.f21509b, 8192) == -1) {
                        break;
                    }
                    j7 = Math.max(j7, size);
                    b5 = b6;
                    j6 = j8;
                } else {
                    return indexOf;
                }
            }
            return -1;
        }
    }

    public String readUtf8LineStrict(long j5) {
        if (j5 >= 0) {
            long j6 = j5 == Long.MAX_VALUE ? Long.MAX_VALUE : j5 + 1;
            long indexOf = indexOf((byte) 10, 0, j6);
            if (indexOf != -1) {
                return f4.a.b(this.f21509b, indexOf);
            }
            if (j6 < Long.MAX_VALUE && request(j6) && this.f21509b.q(j6 - 1) == 13 && request(j6 + 1) && this.f21509b.q(j6) == 10) {
                return f4.a.b(this.f21509b, j6);
            }
            C2356e eVar = new C2356e();
            C2356e eVar2 = this.f21509b;
            eVar2.o(eVar, 0, Math.min((long) 32, eVar2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f21509b.size(), j5) + " content=" + eVar.y().m() + 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j5).toString());
    }

    public byte[] readByteArray(long j5) {
        require(j5);
        return this.f21509b.readByteArray(j5);
    }

    public static final class a extends InputStream {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ T f21511a;

        a(T t5) {
            this.f21511a = t5;
        }

        public int available() {
            T t5 = this.f21511a;
            if (!t5.f21510c) {
                return (int) Math.min(t5.f21509b.size(), (long) Integer.MAX_VALUE);
            }
            throw new IOException("closed");
        }

        public void close() {
            this.f21511a.close();
        }

        public int read() {
            T t5 = this.f21511a;
            if (!t5.f21510c) {
                if (t5.f21509b.size() == 0) {
                    T t6 = this.f21511a;
                    if (t6.f21508a.e(t6.f21509b, 8192) == -1) {
                        return -1;
                    }
                }
                return this.f21511a.f21509b.readByte() & 255;
            }
            throw new IOException("closed");
        }

        public String toString() {
            return this.f21511a + ".inputStream()";
        }

        public int read(byte[] bArr, int i5, int i6) {
            t.e(bArr, DataSchemeDataSource.SCHEME_DATA);
            if (!this.f21511a.f21510c) {
                C2353b.b((long) bArr.length, (long) i5, (long) i6);
                if (this.f21511a.f21509b.size() == 0) {
                    T t5 = this.f21511a;
                    if (t5.f21508a.e(t5.f21509b, 8192) == -1) {
                        return -1;
                    }
                }
                return this.f21511a.f21509b.read(bArr, i5, i6);
            }
            throw new IOException("closed");
        }
    }
}
