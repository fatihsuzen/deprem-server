package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.nio.charset.StandardCharsets;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f9735a;

    /* renamed from: b  reason: collision with root package name */
    public int f9736b;

    /* renamed from: c  reason: collision with root package name */
    private char[] f9737c;

    public q(int i5) {
        this(new byte[i5], 0);
    }

    public static int a(String str) {
        int length = str.length();
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int i7 = i5 + 1;
            char charAt = str.charAt(i5);
            if (charAt < 128) {
                i6++;
            } else if (charAt < 2048) {
                i6 += 2;
            } else if (charAt < 55296 || charAt > 57343) {
                i6 += 3;
            } else {
                i5 += 2;
                i6 += 4;
            }
            i5 = i7;
        }
        return i6;
    }

    private long c(int i5) {
        byte[] bArr = this.f9735a;
        long j5 = (((long) bArr[i5]) & 255) | ((((long) bArr[i5 + 1]) & 255) << 8) | ((((long) bArr[i5 + 2]) & 255) << 16) | ((((long) bArr[i5 + 3]) & 255) << 24) | ((((long) bArr[i5 + 4]) & 255) << 32);
        int i6 = i5 + 6;
        return (((long) bArr[i5 + 7]) << 56) | j5 | ((((long) bArr[i5 + 5]) & 255) << 40) | ((255 & ((long) bArr[i6])) << 48);
    }

    public final long b() {
        long c5 = c(this.f9736b);
        this.f9736b += 8;
        return c5;
    }

    public final short d() {
        byte[] bArr = this.f9735a;
        int i5 = this.f9736b;
        int i6 = i5 + 1;
        this.f9736b = i6;
        this.f9736b = i5 + 2;
        return (short) ((bArr[i6] << 8) | (bArr[i5] & 255));
    }

    public q(byte[] bArr, int i5) {
        this.f9737c = null;
        this.f9735a = bArr;
        this.f9736b = i5;
    }

    public final int c() {
        byte[] bArr = this.f9735a;
        int i5 = this.f9736b;
        int i6 = i5 + 1;
        this.f9736b = i6;
        int i7 = i5 + 2;
        this.f9736b = i7;
        byte b5 = ((bArr[i6] & 255) << 8) | (bArr[i5] & 255);
        int i8 = i5 + 3;
        this.f9736b = i8;
        this.f9736b = i5 + 4;
        return (bArr[i8] << 24) | b5 | ((bArr[i7] & 255) << 16);
    }

    public final byte a() {
        byte[] bArr = this.f9735a;
        int i5 = this.f9736b;
        this.f9736b = i5 + 1;
        return bArr[i5];
    }

    public final void b(int i5) {
        byte[] bArr = this.f9735a;
        int i6 = this.f9736b;
        int i7 = i6 + 1;
        this.f9736b = i7;
        bArr[i6] = (byte) i5;
        int i8 = i6 + 2;
        this.f9736b = i8;
        bArr[i7] = (byte) (i5 >> 8);
        int i9 = i6 + 3;
        this.f9736b = i9;
        bArr[i8] = (byte) (i5 >> 16);
        this.f9736b = i6 + 4;
        bArr[i9] = (byte) (i5 >> 24);
    }

    /* access modifiers changed from: package-private */
    public final long a(int i5, int i6) {
        long j5 = 0;
        if (i6 <= 0) {
            return 0;
        }
        int i7 = i6 >> 3;
        int i8 = i6 & 7;
        int i9 = 0;
        int i10 = i5;
        for (int i11 = 0; i11 < i7; i11++) {
            j5 ^= c(i10);
            i10 += 8;
        }
        int i12 = i8 << 3;
        while (i9 < i12) {
            j5 ^= (((long) this.f9735a[i10]) & 255) << i9;
            i9 += 8;
            i10++;
        }
        int i13 = (i5 & 7) << 3;
        return (j5 >>> (64 - i13)) | (j5 << i13);
    }

    public q(byte[] bArr) {
        this(bArr, 0);
    }

    public final String a(int i5) {
        String str;
        if (i5 < 0) {
            return null;
        }
        if (i5 == 0) {
            return "";
        }
        if (i5 > 2048) {
            str = new String(this.f9735a, this.f9736b, i5, StandardCharsets.UTF_8);
        } else {
            char[] cArr = this.f9737c;
            if (cArr == null) {
                if (i5 <= 256) {
                    this.f9737c = new char[256];
                } else {
                    this.f9737c = new char[2048];
                }
            } else if (cArr.length < i5) {
                this.f9737c = new char[2048];
            }
            char[] cArr2 = this.f9737c;
            byte[] bArr = this.f9735a;
            int i6 = this.f9736b;
            int i7 = i6 + i5;
            int i8 = 0;
            while (i6 < i7) {
                int i9 = i6 + 1;
                byte b5 = bArr[i6];
                if (b5 > 0) {
                    cArr2[i8] = (char) b5;
                    i8++;
                    i6 = i9;
                } else if (b5 < -32) {
                    i6 += 2;
                    cArr2[i8] = (char) ((bArr[i9] & 63) | ((b5 & 31) << 6));
                    i8++;
                } else if (b5 < -16) {
                    int i10 = i6 + 2;
                    i6 += 3;
                    cArr2[i8] = (char) (((bArr[i9] & 63) << 6) | ((b5 & 15) << 12) | (bArr[i10] & 63));
                    i8++;
                } else {
                    byte b6 = bArr[i9];
                    int i11 = i6 + 3;
                    byte b7 = bArr[i6 + 2];
                    i6 += 4;
                    byte b8 = ((b6 & 63) << 12) | ((b5 & 7) << 18) | ((b7 & 63) << 6) | (bArr[i11] & 63);
                    int i12 = i8 + 1;
                    cArr2[i8] = (char) ((b8 >>> 10) + 55232);
                    i8 += 2;
                    cArr2[i12] = (char) ((b8 & 1023) + 56320);
                }
            }
            if (i6 <= i7) {
                str = new String(cArr2, 0, i8);
            } else {
                throw new IllegalArgumentException("Invalid String");
            }
        }
        this.f9736b += i5;
        return str;
    }

    public final void b(int i5, int i6) {
        byte[] bArr = this.f9735a;
        bArr[i5] = (byte) i6;
        bArr[i5 + 1] = (byte) (i6 >> 8);
        bArr[i5 + 2] = (byte) (i6 >> 16);
        bArr[i5 + 3] = (byte) (i6 >> 24);
    }

    public final void b(String str) {
        if (str != null && !str.isEmpty()) {
            byte[] bArr = this.f9735a;
            int i5 = this.f9736b;
            int length = str.length();
            int i6 = 0;
            while (i6 < length) {
                int i7 = i6 + 1;
                char charAt = str.charAt(i6);
                if (charAt < 128) {
                    bArr[i5] = (byte) charAt;
                    i5++;
                } else if (charAt < 2048) {
                    int i8 = i5 + 1;
                    bArr[i5] = (byte) ((charAt >>> 6) | PsExtractor.AUDIO_STREAM);
                    i5 += 2;
                    bArr[i8] = (byte) ((charAt & '?') | 128);
                } else if (charAt < 55296 || charAt > 57343) {
                    bArr[i5] = (byte) ((charAt >>> 12) | 224);
                    int i9 = i5 + 2;
                    bArr[i5 + 1] = (byte) (((charAt >>> 6) & 63) | 128);
                    i5 += 3;
                    bArr[i9] = (byte) ((charAt & '?') | 128);
                } else {
                    i6 += 2;
                    int charAt2 = ((charAt << 10) + str.charAt(i7)) - 56613888;
                    bArr[i5] = (byte) ((charAt2 >>> 18) | PsExtractor.VIDEO_STREAM_MASK);
                    bArr[i5 + 1] = (byte) (((charAt2 >>> 12) & 63) | 128);
                    int i10 = i5 + 3;
                    bArr[i5 + 2] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i5 += 4;
                    bArr[i10] = (byte) ((charAt2 & 63) | 128);
                }
                i6 = i7;
            }
            this.f9736b = i5;
        }
    }

    public final void a(byte b5) {
        byte[] bArr = this.f9735a;
        int i5 = this.f9736b;
        this.f9736b = i5 + 1;
        bArr[i5] = b5;
    }

    public final void a(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.f9735a, this.f9736b, length);
            this.f9736b += length;
        }
    }

    public final void a(long j5) {
        a(this.f9736b, j5);
        this.f9736b += 8;
    }

    public final void a(int i5, long j5) {
        byte[] bArr = this.f9735a;
        bArr[i5] = (byte) ((int) j5);
        bArr[i5 + 1] = (byte) ((int) (j5 >> 8));
        bArr[i5 + 2] = (byte) ((int) (j5 >> 16));
        bArr[i5 + 3] = (byte) ((int) (j5 >> 24));
        bArr[i5 + 4] = (byte) ((int) (j5 >> 32));
        bArr[i5 + 5] = (byte) ((int) (j5 >> 40));
        bArr[i5 + 6] = (byte) ((int) (j5 >> 48));
        bArr[i5 + 7] = (byte) ((int) (j5 >> 56));
    }

    public final void a(short s5) {
        byte[] bArr = this.f9735a;
        int i5 = this.f9736b;
        int i6 = i5 + 1;
        this.f9736b = i6;
        bArr[i5] = (byte) s5;
        this.f9736b = i5 + 2;
        bArr[i6] = (byte) (s5 >> 8);
    }
}
