package e4;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.t;

public final class S implements C2357f {

    /* renamed from: a  reason: collision with root package name */
    public final X f21504a;

    /* renamed from: b  reason: collision with root package name */
    public final C2356e f21505b = new C2356e();

    /* renamed from: c  reason: collision with root package name */
    public boolean f21506c;

    public S(X x4) {
        t.e(x4, "sink");
        this.f21504a = x4;
    }

    public C2356e buffer() {
        return this.f21505b;
    }

    public void close() {
        if (!this.f21506c) {
            try {
                if (this.f21505b.size() > 0) {
                    X x4 = this.f21504a;
                    C2356e eVar = this.f21505b;
                    x4.f(eVar, eVar.size());
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f21504a.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            this.f21506c = true;
            if (th != null) {
                throw th;
            }
        }
    }

    public C2357f emitCompleteSegments() {
        if (!this.f21506c) {
            long m5 = this.f21505b.m();
            if (m5 > 0) {
                this.f21504a.f(this.f21505b, m5);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public void f(C2356e eVar, long j5) {
        t.e(eVar, "source");
        if (!this.f21506c) {
            this.f21505b.f(eVar, j5);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public void flush() {
        if (!this.f21506c) {
            if (this.f21505b.size() > 0) {
                X x4 = this.f21504a;
                C2356e eVar = this.f21505b;
                x4.f(eVar, eVar.size());
            }
            this.f21504a.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public boolean isOpen() {
        return !this.f21506c;
    }

    public OutputStream outputStream() {
        return new a(this);
    }

    public a0 timeout() {
        return this.f21504a.timeout();
    }

    public String toString() {
        return "buffer(" + this.f21504a + ')';
    }

    public int write(ByteBuffer byteBuffer) {
        t.e(byteBuffer, "source");
        if (!this.f21506c) {
            int write = this.f21505b.write(byteBuffer);
            emitCompleteSegments();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    public C2357f writeByte(int i5) {
        if (!this.f21506c) {
            this.f21505b.writeByte(i5);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public C2357f writeDecimalLong(long j5) {
        if (!this.f21506c) {
            this.f21505b.writeDecimalLong(j5);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public C2357f writeHexadecimalUnsignedLong(long j5) {
        if (!this.f21506c) {
            this.f21505b.writeHexadecimalUnsignedLong(j5);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public C2357f writeInt(int i5) {
        if (!this.f21506c) {
            this.f21505b.writeInt(i5);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public C2357f writeShort(int i5) {
        if (!this.f21506c) {
            this.f21505b.writeShort(i5);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public C2357f writeUtf8(String str) {
        t.e(str, TypedValues.Custom.S_STRING);
        if (!this.f21506c) {
            this.f21505b.writeUtf8(str);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public static final class a extends OutputStream {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ S f21507a;

        a(S s5) {
            this.f21507a = s5;
        }

        public void close() {
            this.f21507a.close();
        }

        public void flush() {
            S s5 = this.f21507a;
            if (!s5.f21506c) {
                s5.flush();
            }
        }

        public String toString() {
            return this.f21507a + ".outputStream()";
        }

        public void write(int i5) {
            S s5 = this.f21507a;
            if (!s5.f21506c) {
                s5.f21505b.writeByte((byte) i5);
                this.f21507a.emitCompleteSegments();
                return;
            }
            throw new IOException("closed");
        }

        public void write(byte[] bArr, int i5, int i6) {
            t.e(bArr, DataSchemeDataSource.SCHEME_DATA);
            S s5 = this.f21507a;
            if (!s5.f21506c) {
                s5.f21505b.write(bArr, i5, i6);
                this.f21507a.emitCompleteSegments();
                return;
            }
            throw new IOException("closed");
        }
    }

    public C2357f write(byte[] bArr) {
        t.e(bArr, "source");
        if (!this.f21506c) {
            this.f21505b.write(bArr);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public C2357f write(byte[] bArr, int i5, int i6) {
        t.e(bArr, "source");
        if (!this.f21506c) {
            this.f21505b.write(bArr, i5, i6);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }
}
