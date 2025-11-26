package e4;

import e4.C2359h;
import java.util.Arrays;
import kotlin.jvm.internal.t;

/* renamed from: e4.a  reason: case insensitive filesystem */
public abstract class C2352a {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f21528a;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f21529b;

    static {
        C2359h.a aVar = C2359h.f21566d;
        f21528a = aVar.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").i();
        f21529b = aVar.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").i();
    }

    public static final byte[] a(String str) {
        int i5;
        t.e(str, "<this>");
        int length = str.length();
        while (length > 0 && ((r5 = str.charAt(length - 1)) == '=' || r5 == 10 || r5 == 13 || r5 == ' ' || r5 == 9)) {
            length--;
        }
        int i6 = (int) ((((long) length) * 6) / 8);
        byte[] bArr = new byte[i6];
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if ('A' <= charAt && charAt < '[') {
                i5 = charAt - 'A';
            } else if ('a' <= charAt && charAt < '{') {
                i5 = charAt - 'G';
            } else if ('0' <= charAt && charAt < ':') {
                i5 = charAt + 4;
            } else if (charAt == '+' || charAt == '-') {
                i5 = 62;
            } else if (charAt == '/' || charAt == '_') {
                i5 = 63;
            } else {
                if (!(charAt == 10 || charAt == 13 || charAt == ' ' || charAt == 9)) {
                    return null;
                }
            }
            i8 = (i8 << 6) | i5;
            i7++;
            if (i7 % 4 == 0) {
                bArr[i9] = (byte) (i8 >> 16);
                int i11 = i9 + 2;
                bArr[i9 + 1] = (byte) (i8 >> 8);
                i9 += 3;
                bArr[i11] = (byte) i8;
            }
        }
        int i12 = i7 % 4;
        if (i12 == 1) {
            return null;
        }
        if (i12 == 2) {
            bArr[i9] = (byte) ((i8 << 12) >> 16);
            i9++;
        } else if (i12 == 3) {
            int i13 = i8 << 6;
            int i14 = i9 + 1;
            bArr[i9] = (byte) (i13 >> 16);
            i9 += 2;
            bArr[i14] = (byte) (i13 >> 8);
        }
        if (i9 == i6) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, i9);
        t.d(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    public static final String b(byte[] bArr, byte[] bArr2) {
        t.e(bArr, "<this>");
        t.e(bArr2, "map");
        byte[] bArr3 = new byte[(((bArr.length + 2) / 3) * 4)];
        int length = bArr.length - (bArr.length % 3);
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            byte b5 = bArr[i5];
            int i7 = i5 + 2;
            byte b6 = bArr[i5 + 1];
            i5 += 3;
            byte b7 = bArr[i7];
            bArr3[i6] = bArr2[(b5 & 255) >> 2];
            bArr3[i6 + 1] = bArr2[((b5 & 3) << 4) | ((b6 & 255) >> 4)];
            int i8 = i6 + 3;
            bArr3[i6 + 2] = bArr2[((b6 & 15) << 2) | ((b7 & 255) >> 6)];
            i6 += 4;
            bArr3[i8] = bArr2[b7 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b8 = bArr[i5];
            bArr3[i6] = bArr2[(b8 & 255) >> 2];
            bArr3[i6 + 1] = bArr2[(b8 & 3) << 4];
            bArr3[i6 + 2] = 61;
            bArr3[i6 + 3] = 61;
        } else if (length2 == 2) {
            int i9 = i5 + 1;
            byte b9 = bArr[i5];
            byte b10 = bArr[i9];
            bArr3[i6] = bArr2[(b9 & 255) >> 2];
            bArr3[i6 + 1] = bArr2[((b9 & 3) << 4) | ((b10 & 255) >> 4)];
            bArr3[i6 + 2] = bArr2[(b10 & 15) << 2];
            bArr3[i6 + 3] = 61;
        }
        return c0.c(bArr3);
    }

    public static /* synthetic */ String c(byte[] bArr, byte[] bArr2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            bArr2 = f21528a;
        }
        return b(bArr, bArr2);
    }
}
