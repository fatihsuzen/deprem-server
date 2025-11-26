package e4;

import X2.C2242i;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.work.WorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.jvm.internal.t;
import t3.C2780d;

/* renamed from: e4.e  reason: case insensitive filesystem */
public final class C2356e implements C2358g, C2357f, Cloneable, ByteChannel {

    /* renamed from: a  reason: collision with root package name */
    public U f21556a;

    /* renamed from: b  reason: collision with root package name */
    private long f21557b;

    /* renamed from: e4.e$a */
    public static final class a implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        public C2356e f21558a;

        /* renamed from: b  reason: collision with root package name */
        private U f21559b;

        /* renamed from: c  reason: collision with root package name */
        public long f21560c = -1;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f21561d;

        /* renamed from: e  reason: collision with root package name */
        public int f21562e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f21563f = -1;

        public final void a(U u5) {
            this.f21559b = u5;
        }

        public void close() {
            if (this.f21558a != null) {
                this.f21558a = null;
                a((U) null);
                this.f21560c = -1;
                this.f21561d = null;
                this.f21562e = -1;
                this.f21563f = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }
    }

    /* renamed from: e4.e$c */
    public static final class c extends OutputStream {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2356e f21565a;

        c(C2356e eVar) {
            this.f21565a = eVar;
        }

        public String toString() {
            return this.f21565a + ".outputStream()";
        }

        public void write(int i5) {
            this.f21565a.writeByte(i5);
        }

        public void write(byte[] bArr, int i5, int i6) {
            t.e(bArr, DataSchemeDataSource.SCHEME_DATA);
            this.f21565a.write(bArr, i5, i6);
        }

        public void close() {
        }

        public void flush() {
        }
    }

    public final C2359h A() {
        if (size() <= 2147483647L) {
            return B((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    public final C2359h B(int i5) {
        if (i5 == 0) {
            return C2359h.f21567e;
        }
        C2353b.b(size(), 0, (long) i5);
        U u5 = this.f21556a;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            t.b(u5);
            int i9 = u5.f21515c;
            int i10 = u5.f21514b;
            if (i9 != i10) {
                i7 += i9 - i10;
                i8++;
                u5 = u5.f21518f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i8][];
        int[] iArr = new int[(i8 * 2)];
        U u6 = this.f21556a;
        int i11 = 0;
        while (i6 < i5) {
            t.b(u6);
            bArr[i11] = u6.f21513a;
            i6 += u6.f21515c - u6.f21514b;
            iArr[i11] = Math.min(i6, i5);
            iArr[i11 + i8] = u6.f21514b;
            u6.f21516d = true;
            i11++;
            u6 = u6.f21518f;
        }
        return new W(bArr, iArr);
    }

    public final U C(int i5) {
        if (i5 < 1 || i5 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        U u5 = this.f21556a;
        if (u5 == null) {
            U c5 = V.c();
            this.f21556a = c5;
            c5.f21519g = c5;
            c5.f21518f = c5;
            return c5;
        }
        t.b(u5);
        U u6 = u5.f21519g;
        t.b(u6);
        if (u6.f21515c + i5 > 8192 || !u6.f21517e) {
            return u6.c(V.c());
        }
        return u6;
    }

    public C2356e F(C2359h hVar) {
        t.e(hVar, "byteString");
        hVar.M(this, 0, hVar.F());
        return this;
    }

    /* renamed from: G */
    public C2356e write(byte[] bArr) {
        t.e(bArr, "source");
        return write(bArr, 0, bArr.length);
    }

    /* renamed from: H */
    public C2356e write(byte[] bArr, int i5, int i6) {
        t.e(bArr, "source");
        long j5 = (long) i6;
        C2353b.b((long) bArr.length, (long) i5, j5);
        int i7 = i6 + i5;
        while (i5 < i7) {
            U C4 = C(1);
            int min = Math.min(i7 - i5, 8192 - C4.f21515c);
            int i8 = i5 + min;
            C2242i.h(bArr, C4.f21513a, C4.f21515c, i5, i8);
            C4.f21515c += min;
            i5 = i8;
        }
        z(size() + j5);
        return this;
    }

    public long I(Z z4) {
        t.e(z4, "source");
        long j5 = 0;
        while (true) {
            long e5 = z4.e(this, 8192);
            if (e5 == -1) {
                return j5;
            }
            j5 += e5;
        }
    }

    /* renamed from: J */
    public C2356e writeByte(int i5) {
        U C4 = C(1);
        byte[] bArr = C4.f21513a;
        int i6 = C4.f21515c;
        C4.f21515c = i6 + 1;
        bArr[i6] = (byte) i5;
        z(size() + 1);
        return this;
    }

    /* renamed from: K */
    public C2356e writeDecimalLong(long j5) {
        boolean z4;
        int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i5 == 0) {
            return writeByte(48);
        }
        int i6 = 1;
        if (i5 < 0) {
            j5 = -j5;
            if (j5 < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z4 = true;
        } else {
            z4 = false;
        }
        if (j5 < 100000000) {
            if (j5 < WorkRequest.MIN_BACKOFF_MILLIS) {
                if (j5 < 100) {
                    if (j5 >= 10) {
                        i6 = 2;
                    }
                } else if (j5 < 1000) {
                    i6 = 3;
                } else {
                    i6 = 4;
                }
            } else if (j5 < 1000000) {
                if (j5 < 100000) {
                    i6 = 5;
                } else {
                    i6 = 6;
                }
            } else if (j5 < 10000000) {
                i6 = 7;
            } else {
                i6 = 8;
            }
        } else if (j5 < 1000000000000L) {
            if (j5 < 10000000000L) {
                if (j5 < C.NANOS_PER_SECOND) {
                    i6 = 9;
                } else {
                    i6 = 10;
                }
            } else if (j5 < 100000000000L) {
                i6 = 11;
            } else {
                i6 = 12;
            }
        } else if (j5 < 1000000000000000L) {
            if (j5 < 10000000000000L) {
                i6 = 13;
            } else if (j5 < 100000000000000L) {
                i6 = 14;
            } else {
                i6 = 15;
            }
        } else if (j5 < 100000000000000000L) {
            if (j5 < 10000000000000000L) {
                i6 = 16;
            } else {
                i6 = 17;
            }
        } else if (j5 < 1000000000000000000L) {
            i6 = 18;
        } else {
            i6 = 19;
        }
        if (z4) {
            i6++;
        }
        U C4 = C(i6);
        byte[] bArr = C4.f21513a;
        int i7 = C4.f21515c + i6;
        while (j5 != 0) {
            long j6 = (long) 10;
            i7--;
            bArr[i7] = f4.a.a()[(int) (j5 % j6)];
            j5 /= j6;
        }
        if (z4) {
            bArr[i7 - 1] = 45;
        }
        C4.f21515c += i6;
        z(size() + ((long) i6));
        return this;
    }

    /* renamed from: L */
    public C2356e writeHexadecimalUnsignedLong(long j5) {
        if (j5 == 0) {
            return writeByte(48);
        }
        long j6 = (j5 >>> 1) | j5;
        long j7 = j6 | (j6 >>> 2);
        long j8 = j7 | (j7 >>> 4);
        long j9 = j8 | (j8 >>> 8);
        long j10 = j9 | (j9 >>> 16);
        long j11 = j10 | (j10 >>> 32);
        long j12 = j11 - ((j11 >>> 1) & 6148914691236517205L);
        long j13 = ((j12 >>> 2) & 3689348814741910323L) + (j12 & 3689348814741910323L);
        long j14 = ((j13 >>> 4) + j13) & 1085102592571150095L;
        long j15 = j14 + (j14 >>> 8);
        long j16 = j15 + (j15 >>> 16);
        int i5 = (int) ((((j16 & 63) + ((j16 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        U C4 = C(i5);
        byte[] bArr = C4.f21513a;
        int i6 = C4.f21515c;
        for (int i7 = (i6 + i5) - 1; i7 >= i6; i7--) {
            bArr[i7] = f4.a.a()[(int) (15 & j5)];
            j5 >>>= 4;
        }
        C4.f21515c += i5;
        z(size() + ((long) i5));
        return this;
    }

    /* renamed from: M */
    public C2356e writeInt(int i5) {
        U C4 = C(4);
        byte[] bArr = C4.f21513a;
        int i6 = C4.f21515c;
        bArr[i6] = (byte) ((i5 >>> 24) & 255);
        bArr[i6 + 1] = (byte) ((i5 >>> 16) & 255);
        bArr[i6 + 2] = (byte) ((i5 >>> 8) & 255);
        bArr[i6 + 3] = (byte) (i5 & 255);
        C4.f21515c = i6 + 4;
        z(size() + 4);
        return this;
    }

    /* renamed from: N */
    public C2356e writeShort(int i5) {
        U C4 = C(2);
        byte[] bArr = C4.f21513a;
        int i6 = C4.f21515c;
        bArr[i6] = (byte) ((i5 >>> 8) & 255);
        bArr[i6 + 1] = (byte) (i5 & 255);
        C4.f21515c = i6 + 2;
        z(size() + 2);
        return this;
    }

    public C2356e O(String str, int i5, int i6, Charset charset) {
        t.e(str, TypedValues.Custom.S_STRING);
        t.e(charset, "charset");
        if (i5 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i5).toString());
        } else if (i6 < i5) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i6 + " < " + i5).toString());
        } else if (i6 > str.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i6 + " > " + str.length()).toString());
        } else if (t.a(charset, C2780d.f25888b)) {
            return Q(str, i5, i6);
        } else {
            String substring = str.substring(i5, i6);
            t.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            byte[] bytes = substring.getBytes(charset);
            t.d(bytes, "this as java.lang.String).getBytes(charset)");
            return write(bytes, 0, bytes.length);
        }
    }

    /* renamed from: P */
    public C2356e writeUtf8(String str) {
        t.e(str, TypedValues.Custom.S_STRING);
        return Q(str, 0, str.length());
    }

    public C2356e Q(String str, int i5, int i6) {
        char c5;
        char charAt;
        t.e(str, TypedValues.Custom.S_STRING);
        if (i5 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i5).toString());
        } else if (i6 < i5) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i6 + " < " + i5).toString());
        } else if (i6 <= str.length()) {
            while (i5 < i6) {
                char charAt2 = str.charAt(i5);
                if (charAt2 < 128) {
                    U C4 = C(1);
                    byte[] bArr = C4.f21513a;
                    int i7 = C4.f21515c - i5;
                    int min = Math.min(i6, 8192 - i7);
                    int i8 = i5 + 1;
                    bArr[i5 + i7] = (byte) charAt2;
                    while (true) {
                        i5 = i8;
                        if (i5 >= min || (charAt = str.charAt(i5)) >= 128) {
                            int i9 = C4.f21515c;
                            int i10 = (i7 + i5) - i9;
                            C4.f21515c = i9 + i10;
                            z(size() + ((long) i10));
                        } else {
                            i8 = i5 + 1;
                            bArr[i5 + i7] = (byte) charAt;
                        }
                    }
                    int i92 = C4.f21515c;
                    int i102 = (i7 + i5) - i92;
                    C4.f21515c = i92 + i102;
                    z(size() + ((long) i102));
                } else {
                    if (charAt2 < 2048) {
                        U C5 = C(2);
                        byte[] bArr2 = C5.f21513a;
                        int i11 = C5.f21515c;
                        bArr2[i11] = (byte) ((charAt2 >> 6) | PsExtractor.AUDIO_STREAM);
                        bArr2[i11 + 1] = (byte) ((charAt2 & '?') | 128);
                        C5.f21515c = i11 + 2;
                        z(size() + 2);
                    } else if (charAt2 < 55296 || charAt2 > 57343) {
                        U C6 = C(3);
                        byte[] bArr3 = C6.f21513a;
                        int i12 = C6.f21515c;
                        bArr3[i12] = (byte) ((charAt2 >> 12) | 224);
                        bArr3[i12 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                        bArr3[i12 + 2] = (byte) ((charAt2 & '?') | 128);
                        C6.f21515c = i12 + 3;
                        z(size() + 3);
                    } else {
                        int i13 = i5 + 1;
                        if (i13 < i6) {
                            c5 = str.charAt(i13);
                        } else {
                            c5 = 0;
                        }
                        if (charAt2 > 56319 || 56320 > c5 || c5 >= 57344) {
                            writeByte(63);
                            i5 = i13;
                        } else {
                            int i14 = (((charAt2 & 1023) << 10) | (c5 & 1023)) + 0;
                            U C7 = C(4);
                            byte[] bArr4 = C7.f21513a;
                            int i15 = C7.f21515c;
                            bArr4[i15] = (byte) ((i14 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                            bArr4[i15 + 1] = (byte) (((i14 >> 12) & 63) | 128);
                            bArr4[i15 + 2] = (byte) (((i14 >> 6) & 63) | 128);
                            bArr4[i15 + 3] = (byte) ((i14 & 63) | 128);
                            C7.f21515c = i15 + 4;
                            z(size() + 4);
                            i5 += 2;
                        }
                    }
                    i5++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException(("endIndex > string.length: " + i6 + " > " + str.length()).toString());
        }
    }

    public C2356e R(int i5) {
        if (i5 < 128) {
            writeByte(i5);
            return this;
        } else if (i5 < 2048) {
            U C4 = C(2);
            byte[] bArr = C4.f21513a;
            int i6 = C4.f21515c;
            bArr[i6] = (byte) ((i5 >> 6) | PsExtractor.AUDIO_STREAM);
            bArr[i6 + 1] = (byte) ((i5 & 63) | 128);
            C4.f21515c = i6 + 2;
            z(size() + 2);
            return this;
        } else if (55296 <= i5 && i5 < 57344) {
            writeByte(63);
            return this;
        } else if (i5 < 65536) {
            U C5 = C(3);
            byte[] bArr2 = C5.f21513a;
            int i7 = C5.f21515c;
            bArr2[i7] = (byte) ((i5 >> 12) | 224);
            bArr2[i7 + 1] = (byte) (((i5 >> 6) & 63) | 128);
            bArr2[i7 + 2] = (byte) ((i5 & 63) | 128);
            C5.f21515c = i7 + 3;
            z(size() + 3);
            return this;
        } else if (i5 <= 1114111) {
            U C6 = C(4);
            byte[] bArr3 = C6.f21513a;
            int i8 = C6.f21515c;
            bArr3[i8] = (byte) ((i5 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
            bArr3[i8 + 1] = (byte) (((i5 >> 12) & 63) | 128);
            bArr3[i8 + 2] = (byte) (((i5 >> 6) & 63) | 128);
            bArr3[i8 + 3] = (byte) ((i5 & 63) | 128);
            C6.f21515c = i8 + 4;
            z(size() + 4);
            return this;
        } else {
            throw new IllegalArgumentException("Unexpected code point: 0x" + C2353b.i(i5));
        }
    }

    public final void a() {
        skip(size());
    }

    /* renamed from: d */
    public C2356e clone() {
        return n();
    }

    public long e(C2356e eVar, long j5) {
        t.e(eVar, "sink");
        if (j5 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j5).toString());
        } else if (size() == 0) {
            return -1;
        } else {
            if (j5 > size()) {
                j5 = size();
            }
            eVar.f(this, j5);
            return j5;
        }
    }

    /* JADX WARNING: type inference failed for: r19v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = 1
            if (r0 != r1) goto L_0x0008
            return r2
        L_0x0008:
            boolean r3 = r1 instanceof e4.C2356e
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            long r5 = r0.size()
            e4.e r1 = (e4.C2356e) r1
            long r7 = r1.size()
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x001d
            return r4
        L_0x001d:
            long r5 = r0.size()
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x0028
            return r2
        L_0x0028:
            e4.U r3 = r0.f21556a
            kotlin.jvm.internal.t.b(r3)
            e4.U r1 = r1.f21556a
            kotlin.jvm.internal.t.b(r1)
            int r5 = r3.f21514b
            int r6 = r1.f21514b
            r9 = r7
        L_0x0037:
            long r11 = r0.size()
            int r11 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x007e
            int r11 = r3.f21515c
            int r11 = r11 - r5
            int r12 = r1.f21515c
            int r12 = r12 - r6
            int r11 = java.lang.Math.min(r11, r12)
            long r11 = (long) r11
            r13 = r7
        L_0x004b:
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 >= 0) goto L_0x0066
            byte[] r15 = r3.f21513a
            int r16 = r5 + 1
            byte r5 = r15[r5]
            byte[] r15 = r1.f21513a
            int r17 = r6 + 1
            byte r6 = r15[r6]
            if (r5 == r6) goto L_0x005e
            return r4
        L_0x005e:
            r5 = 1
            long r13 = r13 + r5
            r5 = r16
            r6 = r17
            goto L_0x004b
        L_0x0066:
            int r13 = r3.f21515c
            if (r5 != r13) goto L_0x0071
            e4.U r3 = r3.f21518f
            kotlin.jvm.internal.t.b(r3)
            int r5 = r3.f21514b
        L_0x0071:
            int r13 = r1.f21515c
            if (r6 != r13) goto L_0x007c
            e4.U r1 = r1.f21518f
            kotlin.jvm.internal.t.b(r1)
            int r6 = r1.f21514b
        L_0x007c:
            long r9 = r9 + r11
            goto L_0x0037
        L_0x007e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.C2356e.equals(java.lang.Object):boolean");
    }

    public boolean exhausted() {
        if (this.f21557b == 0) {
            return true;
        }
        return false;
    }

    public void f(C2356e eVar, long j5) {
        U u5;
        int i5;
        t.e(eVar, "source");
        if (eVar != this) {
            C2353b.b(eVar.size(), 0, j5);
            while (j5 > 0) {
                U u6 = eVar.f21556a;
                t.b(u6);
                int i6 = u6.f21515c;
                U u7 = eVar.f21556a;
                t.b(u7);
                if (j5 < ((long) (i6 - u7.f21514b))) {
                    U u8 = this.f21556a;
                    if (u8 != null) {
                        t.b(u8);
                        u5 = u8.f21519g;
                    } else {
                        u5 = null;
                    }
                    if (u5 != null && u5.f21517e) {
                        long j6 = ((long) u5.f21515c) + j5;
                        if (u5.f21516d) {
                            i5 = 0;
                        } else {
                            i5 = u5.f21514b;
                        }
                        if (j6 - ((long) i5) <= 8192) {
                            U u9 = eVar.f21556a;
                            t.b(u9);
                            u9.f(u5, (int) j5);
                            eVar.z(eVar.size() - j5);
                            z(size() + j5);
                            return;
                        }
                    }
                    U u10 = eVar.f21556a;
                    t.b(u10);
                    eVar.f21556a = u10.e((int) j5);
                }
                U u11 = eVar.f21556a;
                t.b(u11);
                long j7 = (long) (u11.f21515c - u11.f21514b);
                eVar.f21556a = u11.b();
                U u12 = this.f21556a;
                if (u12 == null) {
                    this.f21556a = u11;
                    u11.f21519g = u11;
                    u11.f21518f = u11;
                } else {
                    t.b(u12);
                    U u13 = u12.f21519g;
                    t.b(u13);
                    u13.c(u11).a();
                }
                eVar.z(eVar.size() - j7);
                z(size() + j7);
                j5 -= j7;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    public int hashCode() {
        U u5 = this.f21556a;
        if (u5 == null) {
            return 0;
        }
        int i5 = 1;
        do {
            int i6 = u5.f21515c;
            for (int i7 = u5.f21514b; i7 < i6; i7++) {
                i5 = (i5 * 31) + u5.f21513a[i7];
            }
            u5 = u5.f21518f;
            t.b(u5);
        } while (u5 != this.f21556a);
        return i5;
    }

    public long indexOf(byte b5, long j5, long j6) {
        U u5;
        long j7;
        int i5;
        long j8 = 0;
        if (0 > j5 || j5 > j6) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j5 + " toIndex=" + j6).toString());
        }
        if (j6 > size()) {
            j6 = size();
        }
        if (j5 == j6 || (u5 = this.f21556a) == null) {
            return -1;
        }
        if (size() - j5 < j5) {
            j7 = size();
            while (j7 > j5) {
                u5 = u5.f21519g;
                t.b(u5);
                j7 -= (long) (u5.f21515c - u5.f21514b);
            }
            while (j7 < j6) {
                byte[] bArr = u5.f21513a;
                int min = (int) Math.min((long) u5.f21515c, (((long) u5.f21514b) + j6) - j7);
                i5 = (int) ((((long) u5.f21514b) + j5) - j7);
                while (i5 < min) {
                    if (bArr[i5] != b5) {
                        i5++;
                    }
                }
                j7 += (long) (u5.f21515c - u5.f21514b);
                u5 = u5.f21518f;
                t.b(u5);
                j5 = j7;
            }
            return -1;
        }
        while (true) {
            long j9 = ((long) (u5.f21515c - u5.f21514b)) + j8;
            if (j9 > j5) {
                break;
            }
            u5 = u5.f21518f;
            t.b(u5);
            j8 = j9;
        }
        while (j7 < j6) {
            byte[] bArr2 = u5.f21513a;
            int min2 = (int) Math.min((long) u5.f21515c, (((long) u5.f21514b) + j6) - j7);
            int i6 = (int) ((((long) u5.f21514b) + j5) - j7);
            while (i5 < min2) {
                if (bArr2[i5] != b5) {
                    i6 = i5 + 1;
                }
            }
            j8 = j7 + ((long) (u5.f21515c - u5.f21514b));
            u5 = u5.f21518f;
            t.b(u5);
            j5 = j8;
        }
        return -1;
        return ((long) (i5 - u5.f21514b)) + j7;
    }

    public InputStream inputStream() {
        return new b(this);
    }

    public boolean isOpen() {
        return true;
    }

    public boolean k(long j5, C2359h hVar) {
        t.e(hVar, "bytes");
        return x(j5, hVar, 0, hVar.F());
    }

    public final long m() {
        long size = size();
        if (size == 0) {
            return 0;
        }
        U u5 = this.f21556a;
        t.b(u5);
        U u6 = u5.f21519g;
        t.b(u6);
        int i5 = u6.f21515c;
        if (i5 >= 8192 || !u6.f21517e) {
            return size;
        }
        return size - ((long) (i5 - u6.f21514b));
    }

    public final C2356e n() {
        C2356e eVar = new C2356e();
        if (size() == 0) {
            return eVar;
        }
        U u5 = this.f21556a;
        t.b(u5);
        U d5 = u5.d();
        eVar.f21556a = d5;
        d5.f21519g = d5;
        d5.f21518f = d5;
        for (U u6 = u5.f21518f; u6 != u5; u6 = u6.f21518f) {
            U u7 = d5.f21519g;
            t.b(u7);
            t.b(u6);
            u7.c(u6.d());
        }
        eVar.z(size());
        return eVar;
    }

    public final C2356e o(C2356e eVar, long j5, long j6) {
        t.e(eVar, "out");
        long j7 = j5;
        long j8 = j6;
        C2353b.b(size(), j7, j8);
        if (j8 != 0) {
            eVar.z(eVar.size() + j8);
            U u5 = this.f21556a;
            while (true) {
                t.b(u5);
                int i5 = u5.f21515c;
                int i6 = u5.f21514b;
                if (j7 < ((long) (i5 - i6))) {
                    break;
                }
                j7 -= (long) (i5 - i6);
                u5 = u5.f21518f;
            }
            U u6 = u5;
            long j9 = j8;
            while (j9 > 0) {
                t.b(u6);
                U d5 = u6.d();
                int i7 = d5.f21514b + ((int) j7);
                d5.f21514b = i7;
                d5.f21515c = Math.min(i7 + ((int) j9), d5.f21515c);
                U u7 = eVar.f21556a;
                if (u7 == null) {
                    d5.f21519g = d5;
                    d5.f21518f = d5;
                    eVar.f21556a = d5;
                } else {
                    t.b(u7);
                    U u8 = u7.f21519g;
                    t.b(u8);
                    u8.c(d5);
                }
                j9 -= (long) (d5.f21515c - d5.f21514b);
                u6 = u6.f21518f;
                j7 = 0;
            }
        }
        return this;
    }

    public OutputStream outputStream() {
        return new c(this);
    }

    public final byte q(long j5) {
        long j6 = j5;
        C2353b.b(size(), j6, 1);
        U u5 = this.f21556a;
        if (u5 == null) {
            t.b((Object) null);
            throw null;
        } else if (size() - j6 < j6) {
            long size = size();
            while (size > j6) {
                u5 = u5.f21519g;
                t.b(u5);
                size -= (long) (u5.f21515c - u5.f21514b);
            }
            t.b(u5);
            return u5.f21513a[(int) ((((long) u5.f21514b) + j6) - size)];
        } else {
            long j7 = 0;
            while (true) {
                long j8 = ((long) (u5.f21515c - u5.f21514b)) + j7;
                if (j8 <= j6) {
                    u5 = u5.f21518f;
                    t.b(u5);
                    j7 = j8;
                } else {
                    t.b(u5);
                    return u5.f21513a[(int) ((((long) u5.f21514b) + j6) - j7)];
                }
            }
        }
    }

    public int read(ByteBuffer byteBuffer) {
        t.e(byteBuffer, "sink");
        U u5 = this.f21556a;
        if (u5 == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), u5.f21515c - u5.f21514b);
        byteBuffer.put(u5.f21513a, u5.f21514b, min);
        int i5 = u5.f21514b + min;
        u5.f21514b = i5;
        this.f21557b -= (long) min;
        if (i5 == u5.f21515c) {
            this.f21556a = u5.b();
            V.b(u5);
        }
        return min;
    }

    public byte readByte() {
        if (size() != 0) {
            U u5 = this.f21556a;
            t.b(u5);
            int i5 = u5.f21514b;
            int i6 = u5.f21515c;
            int i7 = i5 + 1;
            byte b5 = u5.f21513a[i5];
            z(size() - 1);
            if (i7 == i6) {
                this.f21556a = u5.b();
                V.b(u5);
                return b5;
            }
            u5.f21514b = i7;
            return b5;
        }
        throw new EOFException();
    }

    public byte[] readByteArray() {
        return readByteArray(size());
    }

    public C2359h readByteString(long j5) {
        if (j5 < 0 || j5 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j5).toString());
        } else if (size() < j5) {
            throw new EOFException();
        } else if (j5 < 4096) {
            return new C2359h(readByteArray(j5));
        } else {
            C2359h B4 = B((int) j5);
            skip(j5);
            return B4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ab, code lost:
        if (r2 == false) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ad, code lost:
        r14 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00af, code lost:
        r14 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b0, code lost:
        if (r1 >= r14) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b8, code lost:
        if (size() == r17) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ba, code lost:
        if (r2 == false) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bc, code lost:
        r1 = "Expected a digit";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00bf, code lost:
        r1 = "Expected a digit or '-'";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e4, code lost:
        throw new java.lang.NumberFormatException(r1 + " but was 0x" + e4.C2353b.h(q(r17)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ea, code lost:
        throw new java.io.EOFException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00eb, code lost:
        if (r2 == false) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ed, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ef, code lost:
        return -r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readDecimalLong() {
        /*
            r19 = this;
            r0 = r19
            long r1 = r0.size()
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00f0
            r1 = 0
            r5 = -7
            r2 = r1
            r8 = r3
            r6 = r5
            r5 = r2
        L_0x0013:
            e4.U r10 = r0.f21556a
            kotlin.jvm.internal.t.b(r10)
            byte[] r11 = r10.f21513a
            int r12 = r10.f21514b
            int r13 = r10.f21515c
        L_0x001e:
            if (r12 >= r13) goto L_0x0087
            byte r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L_0x0072
            r14 = 57
            if (r15 > r14) goto L_0x0072
            int r14 = 48 - r15
            r16 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r16 < 0) goto L_0x0045
            r17 = r3
            if (r16 != 0) goto L_0x003f
            long r3 = (long) r14
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x003f
            goto L_0x0045
        L_0x003f:
            r3 = 10
            long r8 = r8 * r3
            long r3 = (long) r14
            long r8 = r8 + r3
            goto L_0x007e
        L_0x0045:
            e4.e r1 = new e4.e
            r1.<init>()
            e4.e r1 = r1.writeDecimalLong(r8)
            e4.e r1 = r1.writeByte(r15)
            if (r2 != 0) goto L_0x0057
            r1.readByte()
        L_0x0057:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.readUtf8()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x0072:
            r17 = r3
            r3 = 45
            if (r15 != r3) goto L_0x0085
            if (r1 != 0) goto L_0x0085
            r2 = 1
            long r6 = r6 - r2
            r2 = 1
        L_0x007e:
            int r12 = r12 + 1
            int r1 = r1 + 1
            r3 = r17
            goto L_0x001e
        L_0x0085:
            r5 = 1
            goto L_0x0089
        L_0x0087:
            r17 = r3
        L_0x0089:
            if (r12 != r13) goto L_0x0095
            e4.U r3 = r10.b()
            r0.f21556a = r3
            e4.V.b(r10)
            goto L_0x0097
        L_0x0095:
            r10.f21514b = r12
        L_0x0097:
            if (r5 != 0) goto L_0x00a2
            e4.U r3 = r0.f21556a
            if (r3 != 0) goto L_0x009e
            goto L_0x00a2
        L_0x009e:
            r3 = r17
            goto L_0x0013
        L_0x00a2:
            long r3 = r0.size()
            long r5 = (long) r1
            long r3 = r3 - r5
            r0.z(r3)
            if (r2 == 0) goto L_0x00af
            r14 = 2
            goto L_0x00b0
        L_0x00af:
            r14 = 1
        L_0x00b0:
            if (r1 >= r14) goto L_0x00eb
            long r3 = r0.size()
            int r1 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r1 == 0) goto L_0x00e5
            if (r2 == 0) goto L_0x00bf
            java.lang.String r1 = "Expected a digit"
            goto L_0x00c1
        L_0x00bf:
            java.lang.String r1 = "Expected a digit or '-'"
        L_0x00c1:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = " but was 0x"
            r3.append(r1)
            r4 = r17
            byte r1 = r0.q(r4)
            java.lang.String r1 = e4.C2353b.h(r1)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x00e5:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        L_0x00eb:
            if (r2 == 0) goto L_0x00ee
            return r8
        L_0x00ee:
            long r1 = -r8
            return r1
        L_0x00f0:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.C2356e.readDecimalLong():long");
    }

    public void readFully(byte[] bArr) {
        t.e(bArr, "sink");
        int i5 = 0;
        while (i5 < bArr.length) {
            int read = read(bArr, i5, bArr.length - i5);
            if (read != -1) {
                i5 += read;
            } else {
                throw new EOFException();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0093, code lost:
        if (r8 != r9) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0095, code lost:
        r14.f21556a = r6.b();
        e4.V.b(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009f, code lost:
        r6.f21514b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a1, code lost:
        if (r1 != false) goto L_0x00a7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0078 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readHexadecimalUnsignedLong() {
        /*
            r14 = this;
            long r0 = r14.size()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00b1
            r0 = 0
            r1 = r0
            r4 = r2
        L_0x000d:
            e4.U r6 = r14.f21556a
            kotlin.jvm.internal.t.b(r6)
            byte[] r7 = r6.f21513a
            int r8 = r6.f21514b
            int r9 = r6.f21515c
        L_0x0018:
            if (r8 >= r9) goto L_0x0093
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0027
            r11 = 57
            if (r10 > r11) goto L_0x0027
            int r11 = r10 + -48
            goto L_0x003c
        L_0x0027:
            r11 = 97
            if (r10 < r11) goto L_0x0032
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x0032
            int r11 = r10 + -87
            goto L_0x003c
        L_0x0032:
            r11 = 65
            if (r10 < r11) goto L_0x0074
            r11 = 70
            if (r10 > r11) goto L_0x0074
            int r11 = r10 + -55
        L_0x003c:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x004c
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0018
        L_0x004c:
            e4.e r0 = new e4.e
            r0.<init>()
            e4.e r0 = r0.writeHexadecimalUnsignedLong(r4)
            e4.e r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0074:
            if (r0 == 0) goto L_0x0078
            r1 = 1
            goto L_0x0093
        L_0x0078:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = e4.C2353b.h(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0093:
            if (r8 != r9) goto L_0x009f
            e4.U r7 = r6.b()
            r14.f21556a = r7
            e4.V.b(r6)
            goto L_0x00a1
        L_0x009f:
            r6.f21514b = r8
        L_0x00a1:
            if (r1 != 0) goto L_0x00a7
            e4.U r6 = r14.f21556a
            if (r6 != 0) goto L_0x000d
        L_0x00a7:
            long r1 = r14.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.z(r1)
            return r4
        L_0x00b1:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.C2356e.readHexadecimalUnsignedLong():long");
    }

    public int readInt() {
        if (size() >= 4) {
            U u5 = this.f21556a;
            t.b(u5);
            int i5 = u5.f21514b;
            int i6 = u5.f21515c;
            if (((long) (i6 - i5)) < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = u5.f21513a;
            byte b5 = ((bArr[i5 + 1] & 255) << 16) | ((bArr[i5] & 255) << 24);
            int i7 = i5 + 3;
            int i8 = i5 + 4;
            byte b6 = (bArr[i7] & 255) | b5 | ((bArr[i5 + 2] & 255) << 8);
            z(size() - 4);
            if (i8 == i6) {
                this.f21556a = u5.b();
                V.b(u5);
                return b6;
            }
            u5.f21514b = i8;
            return b6;
        }
        throw new EOFException();
    }

    public int readIntLe() {
        return C2353b.e(readInt());
    }

    public long readLong() {
        if (size() >= 8) {
            U u5 = this.f21556a;
            t.b(u5);
            int i5 = u5.f21514b;
            int i6 = u5.f21515c;
            if (((long) (i6 - i5)) < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            byte[] bArr = u5.f21513a;
            long j5 = ((((long) bArr[i5 + 3]) & 255) << 32) | ((((long) bArr[i5]) & 255) << 56) | ((((long) bArr[i5 + 1]) & 255) << 48) | ((((long) bArr[i5 + 2]) & 255) << 40);
            int i7 = i5 + 7;
            int i8 = i5 + 8;
            long j6 = j5 | ((((long) bArr[i5 + 4]) & 255) << 24) | ((((long) bArr[i5 + 5]) & 255) << 16) | ((((long) bArr[i5 + 6]) & 255) << 8) | (((long) bArr[i7]) & 255);
            z(size() - 8);
            if (i8 == i6) {
                this.f21556a = u5.b();
                V.b(u5);
                return j6;
            }
            u5.f21514b = i8;
            return j6;
        }
        throw new EOFException();
    }

    public long readLongLe() {
        return C2353b.f(readLong());
    }

    public short readShort() {
        if (size() >= 2) {
            U u5 = this.f21556a;
            t.b(u5);
            int i5 = u5.f21514b;
            int i6 = u5.f21515c;
            if (i6 - i5 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = u5.f21513a;
            int i7 = i5 + 1;
            int i8 = i5 + 2;
            byte b5 = (bArr[i7] & 255) | ((bArr[i5] & 255) << 8);
            z(size() - 2);
            if (i8 == i6) {
                this.f21556a = u5.b();
                V.b(u5);
            } else {
                u5.f21514b = i8;
            }
            return (short) b5;
        }
        throw new EOFException();
    }

    public short readShortLe() {
        return C2353b.g(readShort());
    }

    public String readString(long j5, Charset charset) {
        t.e(charset, "charset");
        int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i5 < 0 || j5 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j5).toString());
        } else if (this.f21557b < j5) {
            throw new EOFException();
        } else if (i5 == 0) {
            return "";
        } else {
            U u5 = this.f21556a;
            t.b(u5);
            int i6 = u5.f21514b;
            if (((long) i6) + j5 > ((long) u5.f21515c)) {
                return new String(readByteArray(j5), charset);
            }
            int i7 = (int) j5;
            String str = new String(u5.f21513a, i6, i7, charset);
            int i8 = u5.f21514b + i7;
            u5.f21514b = i8;
            this.f21557b -= j5;
            if (i8 == u5.f21515c) {
                this.f21556a = u5.b();
                V.b(u5);
            }
            return str;
        }
    }

    public String readUtf8() {
        return readString(this.f21557b, C2780d.f25888b);
    }

    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public void require(long j5) {
        if (this.f21557b < j5) {
            throw new EOFException();
        }
    }

    public long s(C2359h hVar) {
        t.e(hVar, "targetBytes");
        return t(hVar, 0);
    }

    public final long size() {
        return this.f21557b;
    }

    public void skip(long j5) {
        while (j5 > 0) {
            U u5 = this.f21556a;
            if (u5 != null) {
                int min = (int) Math.min(j5, (long) (u5.f21515c - u5.f21514b));
                long j6 = (long) min;
                z(size() - j6);
                j5 -= j6;
                int i5 = u5.f21514b + min;
                u5.f21514b = i5;
                if (i5 == u5.f21515c) {
                    this.f21556a = u5.b();
                    V.b(u5);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public long t(C2359h hVar, long j5) {
        long j6;
        int i5;
        int i6;
        int i7;
        t.e(hVar, "targetBytes");
        long j7 = 0;
        if (j5 >= 0) {
            U u5 = this.f21556a;
            if (u5 == null) {
                return -1;
            }
            if (size() - j5 < j5) {
                j6 = size();
                while (j6 > j5) {
                    u5 = u5.f21519g;
                    t.b(u5);
                    j6 -= (long) (u5.f21515c - u5.f21514b);
                }
                if (hVar.F() == 2) {
                    byte h5 = hVar.h(0);
                    byte h6 = hVar.h(1);
                    while (j6 < size()) {
                        byte[] bArr = u5.f21513a;
                        i6 = (int) ((((long) u5.f21514b) + j5) - j6);
                        int i8 = u5.f21515c;
                        while (i6 < i8) {
                            byte b5 = bArr[i6];
                            if (!(b5 == h5 || b5 == h6)) {
                                i6++;
                            }
                        }
                        j6 += (long) (u5.f21515c - u5.f21514b);
                        u5 = u5.f21518f;
                        t.b(u5);
                        j5 = j6;
                    }
                } else {
                    byte[] q5 = hVar.q();
                    while (j6 < size()) {
                        byte[] bArr2 = u5.f21513a;
                        i5 = (int) ((((long) u5.f21514b) + j5) - j6);
                        int i9 = u5.f21515c;
                        while (i5 < i9) {
                            byte b6 = bArr2[i5];
                            for (byte b7 : q5) {
                                if (b6 == b7) {
                                    i7 = u5.f21514b;
                                    return ((long) (i6 - i7)) + j6;
                                }
                            }
                            i5++;
                        }
                        j6 += (long) (u5.f21515c - u5.f21514b);
                        u5 = u5.f21518f;
                        t.b(u5);
                        j5 = j6;
                    }
                }
                return -1;
            }
            while (true) {
                long j8 = ((long) (u5.f21515c - u5.f21514b)) + j7;
                if (j8 > j5) {
                    break;
                }
                u5 = u5.f21518f;
                t.b(u5);
                j7 = j8;
            }
            if (hVar.F() == 2) {
                byte h7 = hVar.h(0);
                byte h8 = hVar.h(1);
                while (j6 < size()) {
                    byte[] bArr3 = u5.f21513a;
                    int i10 = (int) ((((long) u5.f21514b) + j5) - j6);
                    int i11 = u5.f21515c;
                    while (i6 < i11) {
                        byte b8 = bArr3[i6];
                        if (!(b8 == h7 || b8 == h8)) {
                            i10 = i6 + 1;
                        }
                    }
                    j7 = j6 + ((long) (u5.f21515c - u5.f21514b));
                    u5 = u5.f21518f;
                    t.b(u5);
                    j5 = j7;
                }
            } else {
                byte[] q6 = hVar.q();
                while (j6 < size()) {
                    byte[] bArr4 = u5.f21513a;
                    int i12 = (int) ((((long) u5.f21514b) + j5) - j6);
                    int i13 = u5.f21515c;
                    while (i5 < i13) {
                        byte b9 = bArr4[i5];
                        for (byte b10 : q6) {
                            if (b9 == b10) {
                                i7 = u5.f21514b;
                                return ((long) (i6 - i7)) + j6;
                            }
                        }
                        i12 = i5 + 1;
                    }
                    j7 = j6 + ((long) (u5.f21515c - u5.f21514b));
                    u5 = u5.f21518f;
                    t.b(u5);
                    j5 = j7;
                }
            }
            return -1;
            i7 = u5.f21514b;
            return ((long) (i6 - i7)) + j6;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j5).toString());
    }

    public a0 timeout() {
        return a0.f21531e;
    }

    public String toString() {
        return A().toString();
    }

    public boolean x(long j5, C2359h hVar, int i5, int i6) {
        t.e(hVar, "bytes");
        if (j5 < 0 || i5 < 0 || i6 < 0 || size() - j5 < ((long) i6) || hVar.F() - i5 < i6) {
            return false;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            if (q(((long) i7) + j5) != hVar.h(i5 + i7)) {
                return false;
            }
        }
        return true;
    }

    public C2359h y() {
        return readByteString(size());
    }

    public final void z(long j5) {
        this.f21557b = j5;
    }

    /* renamed from: e4.e$b */
    public static final class b extends InputStream {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2356e f21564a;

        b(C2356e eVar) {
            this.f21564a = eVar;
        }

        public int available() {
            return (int) Math.min(this.f21564a.size(), (long) Integer.MAX_VALUE);
        }

        public int read() {
            if (this.f21564a.size() > 0) {
                return this.f21564a.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return this.f21564a + ".inputStream()";
        }

        public int read(byte[] bArr, int i5, int i6) {
            t.e(bArr, "sink");
            return this.f21564a.read(bArr, i5, i6);
        }

        public void close() {
        }
    }

    public byte[] readByteArray(long j5) {
        if (j5 < 0 || j5 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j5).toString());
        } else if (size() >= j5) {
            byte[] bArr = new byte[((int) j5)];
            readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    public String readUtf8(long j5) {
        return readString(j5, C2780d.f25888b);
    }

    public String readUtf8LineStrict(long j5) {
        if (j5 >= 0) {
            long j6 = Long.MAX_VALUE;
            if (j5 != Long.MAX_VALUE) {
                j6 = j5 + 1;
            }
            long j7 = j6;
            long indexOf = indexOf((byte) 10, 0, j7);
            if (indexOf != -1) {
                return f4.a.b(this, indexOf);
            }
            if (j7 < size() && q(j7 - 1) == 13 && q(j7) == 10) {
                return f4.a.b(this, j7);
            }
            C2356e eVar = new C2356e();
            o(eVar, 0, Math.min((long) 32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j5) + " content=" + eVar.y().m() + 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j5).toString());
    }

    public int write(ByteBuffer byteBuffer) {
        t.e(byteBuffer, "source");
        int remaining = byteBuffer.remaining();
        int i5 = remaining;
        while (i5 > 0) {
            U C4 = C(1);
            int min = Math.min(i5, 8192 - C4.f21515c);
            byteBuffer.get(C4.f21513a, C4.f21515c, min);
            i5 -= min;
            C4.f21515c += min;
        }
        this.f21557b += (long) remaining;
        return remaining;
    }

    public int read(byte[] bArr, int i5, int i6) {
        t.e(bArr, "sink");
        C2353b.b((long) bArr.length, (long) i5, (long) i6);
        U u5 = this.f21556a;
        if (u5 == null) {
            return -1;
        }
        int min = Math.min(i6, u5.f21515c - u5.f21514b);
        byte[] bArr2 = u5.f21513a;
        int i7 = u5.f21514b;
        C2242i.h(bArr2, bArr, i5, i7, i7 + min);
        u5.f21514b += min;
        z(size() - ((long) min));
        if (u5.f21514b == u5.f21515c) {
            this.f21556a = u5.b();
            V.b(u5);
        }
        return min;
    }

    public C2356e buffer() {
        return this;
    }

    public void close() {
    }

    public void flush() {
    }

    public C2356e g() {
        return this;
    }

    /* renamed from: p */
    public C2356e emitCompleteSegments() {
        return this;
    }
}
