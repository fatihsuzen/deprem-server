package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.util.HashMap;
import java.util.Map;

public final class ag {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f9617a;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f9618b = new byte[128];

    /* renamed from: c  reason: collision with root package name */
    private static Map<Character, Character> f9619c;

    /* renamed from: d  reason: collision with root package name */
    private static char[] f9620d;

    static {
        char[] cArr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        f9617a = cArr;
        HashMap hashMap = new HashMap();
        f9619c = hashMap;
        hashMap.put('A', 'v');
        f9619c.put('B', 'S');
        f9619c.put('C', 'o');
        f9619c.put('D', 'a');
        f9619c.put('E', 'j');
        f9619c.put('F', 'c');
        f9619c.put('G', '7');
        f9619c.put('H', 'd');
        f9619c.put('I', 'R');
        f9619c.put('J', 'z');
        f9619c.put('K', 'p');
        f9619c.put('L', 'W');
        f9619c.put('M', 'i');
        f9619c.put('N', 'f');
        f9619c.put('O', 'G');
        f9619c.put('P', 'y');
        f9619c.put('Q', 'N');
        f9619c.put('R', 'x');
        f9619c.put('S', 'Z');
        f9619c.put('T', 'n');
        f9619c.put('U', 'V');
        f9619c.put('V', '5');
        f9619c.put('W', 'k');
        f9619c.put('X', '+');
        f9619c.put('Y', 'D');
        f9619c.put('Z', 'H');
        f9619c.put('a', 'L');
        f9619c.put('b', 'Y');
        f9619c.put('c', 'h');
        f9619c.put('d', 'J');
        f9619c.put('e', '4');
        f9619c.put('f', '6');
        f9619c.put('g', 'l');
        f9619c.put('h', 't');
        f9619c.put('i', '0');
        f9619c.put('j', 'U');
        f9619c.put('k', '3');
        f9619c.put('l', 'Q');
        f9619c.put('m', 'r');
        f9619c.put('n', 'g');
        f9619c.put('o', 'E');
        f9619c.put('p', 'u');
        f9619c.put('q', 'q');
        f9619c.put('r', '8');
        f9619c.put('s', 's');
        f9619c.put('t', 'w');
        f9619c.put('u', '/');
        f9619c.put('v', 'X');
        f9619c.put('w', 'M');
        f9619c.put('x', 'e');
        f9619c.put('y', 'B');
        f9619c.put('z', 'A');
        f9619c.put('0', 'T');
        f9619c.put('1', '2');
        f9619c.put('2', 'F');
        f9619c.put('3', 'b');
        f9619c.put('4', '9');
        f9619c.put('5', 'P');
        f9619c.put('6', '1');
        f9619c.put(55, 'O');
        f9619c.put('8', 'I');
        f9619c.put('9', 'K');
        f9619c.put('+', 'm');
        f9619c.put('/', 67);
        f9620d = new char[cArr.length];
        int i5 = 0;
        int i6 = 0;
        while (true) {
            char[] cArr2 = f9617a;
            if (i6 >= cArr2.length) {
                break;
            }
            f9620d[i6] = f9619c.get(Character.valueOf(cArr2[i6])).charValue();
            i6++;
        }
        int i7 = 0;
        while (true) {
            byte[] bArr = f9618b;
            if (i7 >= bArr.length) {
                break;
            }
            bArr[i7] = Byte.MAX_VALUE;
            i7++;
        }
        while (true) {
            char[] cArr3 = f9620d;
            if (i5 < cArr3.length) {
                f9618b[cArr3[i5]] = (byte) i5;
                i5++;
            } else {
                return;
            }
        }
    }

    private static int a(char[] cArr, byte[] bArr, int i5) {
        try {
            char c5 = cArr[3];
            boolean z4 = c5 == '=' ? true : true;
            char c6 = cArr[2];
            if (c6 == '=') {
                z4 = true;
            }
            byte[] bArr2 = f9618b;
            byte b5 = bArr2[cArr[0]];
            byte b6 = bArr2[cArr[1]];
            byte b7 = bArr2[c6];
            byte b8 = bArr2[c5];
            if (z4) {
                bArr[i5] = (byte) (((b6 >> 4) & 3) | ((b5 << 2) & 252));
                return 1;
            } else if (z4) {
                bArr[i5] = (byte) ((3 & (b6 >> 4)) | ((b5 << 2) & 252));
                bArr[i5 + 1] = (byte) (((b6 << 4) & PsExtractor.VIDEO_STREAM_MASK) | ((b7 >> 2) & 15));
                return 2;
            } else if (z4) {
                bArr[i5] = (byte) (((b5 << 2) & 252) | ((b6 >> 4) & 3));
                bArr[i5 + 1] = (byte) (((b6 << 4) & PsExtractor.VIDEO_STREAM_MASK) | ((b7 >> 2) & 15));
                bArr[i5 + 2] = (byte) (((b7 << 6) & 192) | (b8 & 63));
                return 3;
            } else {
                throw new RuntimeException("Internal Error");
            }
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String b(String str) {
        byte[] bytes = str.getBytes();
        return a(bytes, 0, bytes.length);
    }

    private static byte[] c(String str) {
        int i5;
        try {
            int length = str.length();
            int i6 = 259;
            if (length < 259) {
                i6 = length;
            }
            char[] cArr = new char[i6];
            int i7 = ((length >> 2) * 3) + 3;
            byte[] bArr = new byte[i7];
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i8 < length) {
                int i11 = i8 + 256;
                if (i11 <= length) {
                    str.getChars(i8, i11, cArr, i10);
                    i5 = i10 + 256;
                } else {
                    str.getChars(i8, length, cArr, i10);
                    i5 = (length - i8) + i10;
                }
                int i12 = i10;
                while (i10 < i5) {
                    char c5 = cArr[i10];
                    if (c5 != '=') {
                        byte[] bArr2 = f9618b;
                        if (c5 < bArr2.length) {
                            if (bArr2[c5] == Byte.MAX_VALUE) {
                            }
                        }
                        i10++;
                    }
                    int i13 = i12 + 1;
                    cArr[i12] = c5;
                    if (i13 == 4) {
                        i9 += a(cArr, bArr, i9);
                        i12 = 0;
                    } else {
                        i12 = i13;
                    }
                    i10++;
                }
                i8 = i11;
                i10 = i12;
            }
            if (i9 == i7) {
                return bArr;
            }
            byte[] bArr3 = new byte[i9];
            System.arraycopy(bArr, 0, bArr3, 0, i9);
            return bArr3;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(String str) {
        byte[] c5 = c(str);
        if (c5 == null || c5.length <= 0) {
            return null;
        }
        return new String(c5);
    }

    private static String a(byte[] bArr, int i5, int i6) {
        if (i6 <= 0) {
            return "";
        }
        try {
            char[] cArr = new char[(((i6 / 3) << 2) + 4)];
            int i7 = 0;
            while (i6 >= 3) {
                int i8 = ((bArr[i5] & 255) << 16) + ((bArr[i5 + 1] & 255) << 8) + (bArr[i5 + 2] & 255);
                char[] cArr2 = f9620d;
                cArr[i7] = cArr2[i8 >> 18];
                cArr[i7 + 1] = cArr2[(i8 >> 12) & 63];
                int i9 = i7 + 3;
                cArr[i7 + 2] = cArr2[(i8 >> 6) & 63];
                i7 += 4;
                cArr[i9] = cArr2[i8 & 63];
                i5 += 3;
                i6 -= 3;
            }
            if (i6 == 1) {
                byte b5 = bArr[i5] & 255;
                char[] cArr3 = f9620d;
                cArr[i7] = cArr3[b5 >> 2];
                cArr[i7 + 1] = cArr3[(b5 << 4) & 63];
                int i10 = i7 + 3;
                cArr[i7 + 2] = '=';
                i7 += 4;
                cArr[i10] = '=';
            } else if (i6 == 2) {
                int i11 = ((bArr[i5] & 255) << 8) + (bArr[i5 + 1] & 255);
                char[] cArr4 = f9620d;
                cArr[i7] = cArr4[i11 >> 10];
                cArr[i7 + 1] = cArr4[(i11 >> 4) & 63];
                int i12 = i7 + 3;
                cArr[i7 + 2] = cArr4[(i11 << 2) & 63];
                i7 += 4;
                cArr[i12] = '=';
            }
            return new String(cArr, 0, i7);
        } catch (Exception unused) {
            return null;
        }
    }
}
