package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.Utf8;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.nio.ByteBuffer;

public final class Utf8Safe extends Utf8 {

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i5, int i6) {
            super("Unpaired surrogate at index " + i5 + " of " + i6);
        }
    }

    private static int computeEncodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i5 = 0;
        while (i5 < length && charSequence.charAt(i5) < 128) {
            i5++;
        }
        int i6 = length;
        while (true) {
            if (i5 < length) {
                char charAt = charSequence.charAt(i5);
                if (charAt >= 2048) {
                    i6 += encodedLengthGeneral(charSequence, i5);
                    break;
                }
                i6 += (127 - charAt) >>> 31;
                i5++;
            } else {
                break;
            }
        }
        if (i6 >= length) {
            return i6;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i6) + 4294967296L));
    }

    public static String decodeUtf8Array(byte[] bArr, int i5, int i6) {
        if ((i5 | i6 | ((bArr.length - i5) - i6)) >= 0) {
            int i7 = i5 + i6;
            char[] cArr = new char[i6];
            int i8 = 0;
            while (r9 < i7) {
                byte b5 = bArr[r9];
                if (!Utf8.DecodeUtil.isOneByte(b5)) {
                    break;
                }
                i5 = r9 + 1;
                Utf8.DecodeUtil.handleOneByte(b5, cArr, i8);
                i8++;
            }
            int i9 = i8;
            while (r9 < i7) {
                int i10 = r9 + 1;
                byte b6 = bArr[r9];
                if (Utf8.DecodeUtil.isOneByte(b6)) {
                    int i11 = i9 + 1;
                    Utf8.DecodeUtil.handleOneByte(b6, cArr, i9);
                    while (i10 < i7) {
                        byte b7 = bArr[i10];
                        if (!Utf8.DecodeUtil.isOneByte(b7)) {
                            break;
                        }
                        i10++;
                        Utf8.DecodeUtil.handleOneByte(b7, cArr, i11);
                        i11++;
                    }
                    i9 = i11;
                    r9 = i10;
                } else if (Utf8.DecodeUtil.isTwoBytes(b6)) {
                    if (i10 < i7) {
                        r9 += 2;
                        Utf8.DecodeUtil.handleTwoBytes(b6, bArr[i10], cArr, i9);
                        i9++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (Utf8.DecodeUtil.isThreeBytes(b6)) {
                    if (i10 < i7 - 1) {
                        int i12 = r9 + 2;
                        r9 += 3;
                        Utf8.DecodeUtil.handleThreeBytes(b6, bArr[i10], bArr[i12], cArr, i9);
                        i9++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (i10 < i7 - 2) {
                    byte b8 = bArr[i10];
                    int i13 = r9 + 3;
                    byte b9 = bArr[r9 + 2];
                    r9 += 4;
                    Utf8.DecodeUtil.handleFourBytes(b6, b8, b9, bArr[i13], cArr, i9);
                    i9 += 2;
                } else {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
            }
            return new String(cArr, 0, i9);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i5), Integer.valueOf(i6)}));
    }

    public static String decodeUtf8Buffer(ByteBuffer byteBuffer, int i5, int i6) {
        if ((i5 | i6 | ((byteBuffer.limit() - i5) - i6)) >= 0) {
            int i7 = i5 + i6;
            char[] cArr = new char[i6];
            int i8 = 0;
            while (r9 < i7) {
                byte b5 = byteBuffer.get(r9);
                if (!Utf8.DecodeUtil.isOneByte(b5)) {
                    break;
                }
                i5 = r9 + 1;
                Utf8.DecodeUtil.handleOneByte(b5, cArr, i8);
                i8++;
            }
            int i9 = i8;
            while (r9 < i7) {
                int i10 = r9 + 1;
                byte b6 = byteBuffer.get(r9);
                if (Utf8.DecodeUtil.isOneByte(b6)) {
                    int i11 = i9 + 1;
                    Utf8.DecodeUtil.handleOneByte(b6, cArr, i9);
                    while (i10 < i7) {
                        byte b7 = byteBuffer.get(i10);
                        if (!Utf8.DecodeUtil.isOneByte(b7)) {
                            break;
                        }
                        i10++;
                        Utf8.DecodeUtil.handleOneByte(b7, cArr, i11);
                        i11++;
                    }
                    i9 = i11;
                    r9 = i10;
                } else if (Utf8.DecodeUtil.isTwoBytes(b6)) {
                    if (i10 < i7) {
                        r9 += 2;
                        Utf8.DecodeUtil.handleTwoBytes(b6, byteBuffer.get(i10), cArr, i9);
                        i9++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (Utf8.DecodeUtil.isThreeBytes(b6)) {
                    if (i10 < i7 - 1) {
                        int i12 = r9 + 2;
                        r9 += 3;
                        Utf8.DecodeUtil.handleThreeBytes(b6, byteBuffer.get(i10), byteBuffer.get(i12), cArr, i9);
                        i9++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (i10 < i7 - 2) {
                    byte b8 = byteBuffer.get(i10);
                    int i13 = r9 + 3;
                    byte b9 = byteBuffer.get(r9 + 2);
                    r9 += 4;
                    Utf8.DecodeUtil.handleFourBytes(b6, b8, b9, byteBuffer.get(i13), cArr, i9);
                    i9 += 2;
                } else {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
            }
            return new String(cArr, 0, i9);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i5), Integer.valueOf(i6)}));
    }

    private static int encodeUtf8Array(CharSequence charSequence, byte[] bArr, int i5, int i6) {
        int i7;
        int i8;
        char charAt;
        int length = charSequence.length();
        int i9 = i6 + i5;
        int i10 = 0;
        while (i10 < length && (i8 = i10 + i5) < i9 && (charAt = charSequence.charAt(i10)) < 128) {
            bArr[i8] = (byte) charAt;
            i10++;
        }
        if (i10 == length) {
            return i5 + length;
        }
        int i11 = i5 + i10;
        while (i10 < length) {
            char charAt2 = charSequence.charAt(i10);
            if (charAt2 < 128 && i11 < i9) {
                bArr[i11] = (byte) charAt2;
                i11++;
            } else if (charAt2 < 2048 && i11 <= i9 - 2) {
                int i12 = i11 + 1;
                bArr[i11] = (byte) ((charAt2 >>> 6) | 960);
                i11 += 2;
                bArr[i12] = (byte) ((charAt2 & '?') | 128);
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i11 <= i9 - 3) {
                bArr[i11] = (byte) ((charAt2 >>> 12) | 480);
                int i13 = i11 + 2;
                bArr[i11 + 1] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i11 += 3;
                bArr[i13] = (byte) ((charAt2 & '?') | 128);
            } else if (i11 <= i9 - 4) {
                int i14 = i10 + 1;
                if (i14 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i14);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        bArr[i11] = (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK);
                        bArr[i11 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i15 = i11 + 3;
                        bArr[i11 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i11 += 4;
                        bArr[i15] = (byte) ((codePoint & 63) | 128);
                        i10 = i14;
                    } else {
                        i10 = i14;
                    }
                }
                throw new UnpairedSurrogateException(i10 - 1, length);
            } else if (55296 > charAt2 || charAt2 > 57343 || ((i7 = i10 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i7)))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i11);
            } else {
                throw new UnpairedSurrogateException(i10, length);
            }
            i10++;
        }
        return i11;
    }

    private static void encodeUtf8Buffer(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i5;
        int length = charSequence.length();
        int position = byteBuffer.position();
        int i6 = 0;
        while (i6 < length) {
            try {
                char charAt = charSequence.charAt(i6);
                if (charAt >= 128) {
                    break;
                }
                byteBuffer.put(position + i6, (byte) charAt);
                i6++;
            } catch (IndexOutOfBoundsException unused) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i6) + " at index " + (byteBuffer.position() + Math.max(i6, (position - byteBuffer.position()) + 1)));
            }
        }
        if (i6 == length) {
            byteBuffer.position(position + i6);
            return;
        }
        position += i6;
        while (i6 < length) {
            char charAt2 = charSequence.charAt(i6);
            if (charAt2 < 128) {
                byteBuffer.put(position, (byte) charAt2);
            } else if (charAt2 < 2048) {
                i5 = position + 1;
                try {
                    byteBuffer.put(position, (byte) ((charAt2 >>> 6) | PsExtractor.AUDIO_STREAM));
                    byteBuffer.put(i5, (byte) ((charAt2 & '?') | 128));
                    position = i5;
                } catch (IndexOutOfBoundsException unused2) {
                    position = i5;
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i6) + " at index " + (byteBuffer.position() + Math.max(i6, (position - byteBuffer.position()) + 1)));
                }
            } else if (charAt2 < 55296 || 57343 < charAt2) {
                i5 = position + 1;
                byteBuffer.put(position, (byte) ((charAt2 >>> 12) | 224));
                position += 2;
                byteBuffer.put(i5, (byte) (((charAt2 >>> 6) & 63) | 128));
                byteBuffer.put(position, (byte) ((charAt2 & '?') | 128));
            } else {
                int i7 = i6 + 1;
                if (i7 != length) {
                    try {
                        char charAt3 = charSequence.charAt(i7);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i8 = position + 1;
                            try {
                                byteBuffer.put(position, (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK));
                                int i9 = position + 2;
                                try {
                                    byteBuffer.put(i8, (byte) (((codePoint >>> 12) & 63) | 128));
                                    position += 3;
                                    byteBuffer.put(i9, (byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put(position, (byte) ((codePoint & 63) | 128));
                                    i6 = i7;
                                } catch (IndexOutOfBoundsException unused3) {
                                    i6 = i7;
                                    position = i9;
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i6) + " at index " + (byteBuffer.position() + Math.max(i6, (position - byteBuffer.position()) + 1)));
                                }
                            } catch (IndexOutOfBoundsException unused4) {
                                position = i8;
                                i6 = i7;
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i6) + " at index " + (byteBuffer.position() + Math.max(i6, (position - byteBuffer.position()) + 1)));
                            }
                        } else {
                            i6 = i7;
                        }
                    } catch (IndexOutOfBoundsException unused5) {
                        i6 = i7;
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i6) + " at index " + (byteBuffer.position() + Math.max(i6, (position - byteBuffer.position()) + 1)));
                    }
                }
                throw new UnpairedSurrogateException(i6, length);
            }
            i6++;
            position++;
        }
        byteBuffer.position(position);
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i5) {
        int length = charSequence.length();
        int i6 = 0;
        while (i5 < length) {
            char charAt = charSequence.charAt(i5);
            if (charAt < 2048) {
                i6 += (127 - charAt) >>> 31;
            } else {
                i6 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i5) >= 65536) {
                        i5++;
                    } else {
                        throw new UnpairedSurrogateException(i5, length);
                    }
                }
            }
            i5++;
        }
        return i6;
    }

    public String decodeUtf8(ByteBuffer byteBuffer, int i5, int i6) throws IllegalArgumentException {
        if (byteBuffer.hasArray()) {
            return decodeUtf8Array(byteBuffer.array(), byteBuffer.arrayOffset() + i5, i6);
        }
        return decodeUtf8Buffer(byteBuffer, i5, i6);
    }

    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int arrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(encodeUtf8Array(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
            return;
        }
        encodeUtf8Buffer(charSequence, byteBuffer);
    }

    public int encodedLength(CharSequence charSequence) {
        return computeEncodedLength(charSequence);
    }
}
