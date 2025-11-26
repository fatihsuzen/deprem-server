package androidx.datastore.preferences.protobuf;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    static final int COMPLETE = 0;
    static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor;

    private static class DecodeUtil {
        private DecodeUtil() {
        }

        /* access modifiers changed from: private */
        public static void handleFourBytes(byte b5, byte b6, byte b7, byte b8, char[] cArr, int i5) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(b6) || (((b5 << 28) + (b6 + 112)) >> 30) != 0 || isNotTrailingByte(b7) || isNotTrailingByte(b8)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            int trailingByteValue = ((b5 & 7) << 18) | (trailingByteValue(b6) << 12) | (trailingByteValue(b7) << 6) | trailingByteValue(b8);
            cArr[i5] = highSurrogate(trailingByteValue);
            cArr[i5 + 1] = lowSurrogate(trailingByteValue);
        }

        /* access modifiers changed from: private */
        public static void handleOneByte(byte b5, char[] cArr, int i5) {
            cArr[i5] = (char) b5;
        }

        /* access modifiers changed from: private */
        public static void handleThreeBytes(byte b5, byte b6, byte b7, char[] cArr, int i5) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(b6) || ((b5 == -32 && b6 < -96) || ((b5 == -19 && b6 >= -96) || isNotTrailingByte(b7)))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i5] = (char) (((b5 & 15) << 12) | (trailingByteValue(b6) << 6) | trailingByteValue(b7));
        }

        /* access modifiers changed from: private */
        public static void handleTwoBytes(byte b5, byte b6, char[] cArr, int i5) throws InvalidProtocolBufferException {
            if (b5 < -62 || isNotTrailingByte(b6)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i5] = (char) (((b5 & 31) << 6) | trailingByteValue(b6));
        }

        private static char highSurrogate(int i5) {
            return (char) ((i5 >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte b5) {
            return b5 > -65;
        }

        /* access modifiers changed from: private */
        public static boolean isOneByte(byte b5) {
            return b5 >= 0;
        }

        /* access modifiers changed from: private */
        public static boolean isThreeBytes(byte b5) {
            return b5 < -16;
        }

        /* access modifiers changed from: private */
        public static boolean isTwoBytes(byte b5) {
            return b5 < -32;
        }

        private static char lowSurrogate(int i5) {
            return (char) ((i5 & 1023) + 56320);
        }

        private static int trailingByteValue(byte b5) {
            return b5 & 63;
        }
    }

    static abstract class Processor {
        Processor() {
        }

        /* access modifiers changed from: package-private */
        public final String decodeUtf8(ByteBuffer byteBuffer, int i5, int i6) throws InvalidProtocolBufferException {
            if (byteBuffer.hasArray()) {
                return decodeUtf8(byteBuffer.array(), byteBuffer.arrayOffset() + i5, i6);
            } else if (byteBuffer.isDirect()) {
                return decodeUtf8Direct(byteBuffer, i5, i6);
            } else {
                return decodeUtf8Default(byteBuffer, i5, i6);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract String decodeUtf8(byte[] bArr, int i5, int i6) throws InvalidProtocolBufferException;

        /* access modifiers changed from: package-private */
        public final String decodeUtf8Default(ByteBuffer byteBuffer, int i5, int i6) throws InvalidProtocolBufferException {
            if ((i5 | i6 | ((byteBuffer.limit() - i5) - i6)) >= 0) {
                int i7 = i5 + i6;
                char[] cArr = new char[i6];
                int i8 = 0;
                while (r10 < i7) {
                    byte b5 = byteBuffer.get(r10);
                    if (!DecodeUtil.isOneByte(b5)) {
                        break;
                    }
                    i5 = r10 + 1;
                    DecodeUtil.handleOneByte(b5, cArr, i8);
                    i8++;
                }
                int i9 = i8;
                while (r10 < i7) {
                    int i10 = r10 + 1;
                    byte b6 = byteBuffer.get(r10);
                    if (DecodeUtil.isOneByte(b6)) {
                        int i11 = i9 + 1;
                        DecodeUtil.handleOneByte(b6, cArr, i9);
                        while (i10 < i7) {
                            byte b7 = byteBuffer.get(i10);
                            if (!DecodeUtil.isOneByte(b7)) {
                                break;
                            }
                            i10++;
                            DecodeUtil.handleOneByte(b7, cArr, i11);
                            i11++;
                        }
                        i9 = i11;
                        r10 = i10;
                    } else if (DecodeUtil.isTwoBytes(b6)) {
                        if (i10 < i7) {
                            r10 += 2;
                            DecodeUtil.handleTwoBytes(b6, byteBuffer.get(i10), cArr, i9);
                            i9++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (DecodeUtil.isThreeBytes(b6)) {
                        if (i10 < i7 - 1) {
                            int i12 = r10 + 2;
                            r10 += 3;
                            DecodeUtil.handleThreeBytes(b6, byteBuffer.get(i10), byteBuffer.get(i12), cArr, i9);
                            i9++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (i10 < i7 - 2) {
                        byte b8 = byteBuffer.get(i10);
                        int i13 = r10 + 3;
                        byte b9 = byteBuffer.get(r10 + 2);
                        r10 += 4;
                        DecodeUtil.handleFourBytes(b6, b8, b9, byteBuffer.get(i13), cArr, i9);
                        i9 += 2;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                }
                return new String(cArr, 0, i9);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i5), Integer.valueOf(i6)}));
        }

        /* access modifiers changed from: package-private */
        public abstract String decodeUtf8Direct(ByteBuffer byteBuffer, int i5, int i6) throws InvalidProtocolBufferException;

        /* access modifiers changed from: package-private */
        public abstract int encodeUtf8(String str, byte[] bArr, int i5, int i6);

        /* access modifiers changed from: package-private */
        public final void encodeUtf8(String str, ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                Java8Compatibility.position(byteBuffer, Utf8.encode(str, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
            } else if (byteBuffer.isDirect()) {
                encodeUtf8Direct(str, byteBuffer);
            } else {
                encodeUtf8Default(str, byteBuffer);
            }
        }

        /* access modifiers changed from: package-private */
        public final void encodeUtf8Default(String str, ByteBuffer byteBuffer) {
            int i5;
            int length = str.length();
            int position = byteBuffer.position();
            int i6 = 0;
            while (i6 < length) {
                try {
                    char charAt = str.charAt(i6);
                    if (charAt >= 128) {
                        break;
                    }
                    byteBuffer.put(position + i6, (byte) charAt);
                    i6++;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(i6) + " at index " + (byteBuffer.position() + Math.max(i6, (position - byteBuffer.position()) + 1)));
                }
            }
            if (i6 == length) {
                Java8Compatibility.position(byteBuffer, position + i6);
                return;
            }
            position += i6;
            while (i6 < length) {
                char charAt2 = str.charAt(i6);
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
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(i6) + " at index " + (byteBuffer.position() + Math.max(i6, (position - byteBuffer.position()) + 1)));
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
                            char charAt3 = str.charAt(i7);
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
                                        throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(i6) + " at index " + (byteBuffer.position() + Math.max(i6, (position - byteBuffer.position()) + 1)));
                                    }
                                } catch (IndexOutOfBoundsException unused4) {
                                    position = i8;
                                    i6 = i7;
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(i6) + " at index " + (byteBuffer.position() + Math.max(i6, (position - byteBuffer.position()) + 1)));
                                }
                            } else {
                                i6 = i7;
                            }
                        } catch (IndexOutOfBoundsException unused5) {
                            i6 = i7;
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(i6) + " at index " + (byteBuffer.position() + Math.max(i6, (position - byteBuffer.position()) + 1)));
                        }
                    }
                    throw new UnpairedSurrogateException(i6, length);
                }
                i6++;
                position++;
            }
            Java8Compatibility.position(byteBuffer, position);
        }

        /* access modifiers changed from: package-private */
        public abstract void encodeUtf8Direct(String str, ByteBuffer byteBuffer);

        /* access modifiers changed from: package-private */
        public final boolean isValidUtf8(byte[] bArr, int i5, int i6) {
            return partialIsValidUtf8(0, bArr, i5, i6) == 0;
        }

        /* access modifiers changed from: package-private */
        public final int partialIsValidUtf8(int i5, ByteBuffer byteBuffer, int i6, int i7) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                return partialIsValidUtf8(i5, byteBuffer.array(), i6 + arrayOffset, arrayOffset + i7);
            } else if (byteBuffer.isDirect()) {
                return partialIsValidUtf8Direct(i5, byteBuffer, i6, i7);
            } else {
                return partialIsValidUtf8Default(i5, byteBuffer, i6, i7);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract int partialIsValidUtf8(int i5, byte[] bArr, int i6, int i7);

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x004c, code lost:
            if (r8.get(r9) > -65) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x008f, code lost:
            if (r8.get(r7) > -65) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
            if (r8.get(r9) > -65) goto L_0x001d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int partialIsValidUtf8Default(int r7, java.nio.ByteBuffer r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L_0x0092
                if (r9 < r10) goto L_0x0005
                return r7
            L_0x0005:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L_0x001e
                r7 = -62
                if (r0 < r7) goto L_0x001d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L_0x001a
                goto L_0x001d
            L_0x001a:
                r9 = r7
                goto L_0x0092
            L_0x001d:
                return r2
            L_0x001e:
                r4 = -16
                if (r0 >= r4) goto L_0x004f
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L_0x0038
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L_0x0035
                int r7 = androidx.datastore.preferences.protobuf.Utf8.incompleteStateFor(r0, r9)
                return r7
            L_0x0035:
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x0038:
                if (r7 > r3) goto L_0x004e
                r4 = -96
                if (r0 != r1) goto L_0x0040
                if (r7 < r4) goto L_0x004e
            L_0x0040:
                r1 = -19
                if (r0 != r1) goto L_0x0046
                if (r7 >= r4) goto L_0x004e
            L_0x0046:
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L_0x001a
            L_0x004e:
                return r2
            L_0x004f:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L_0x0064
                int r7 = r9 + 1
                byte r1 = r8.get(r9)
                if (r7 < r10) goto L_0x0062
                int r7 = androidx.datastore.preferences.protobuf.Utf8.incompleteStateFor(r0, r1)
                return r7
            L_0x0062:
                r9 = 0
                goto L_0x006a
            L_0x0064:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x006a:
                if (r9 != 0) goto L_0x007c
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r9 < r10) goto L_0x0079
                int r7 = androidx.datastore.preferences.protobuf.Utf8.incompleteStateFor((int) r0, (int) r1, (int) r7)
                return r7
            L_0x0079:
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x007c:
                if (r1 > r3) goto L_0x0091
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L_0x0091
                if (r9 > r3) goto L_0x0091
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r7 <= r3) goto L_0x0092
            L_0x0091:
                return r2
            L_0x0092:
                int r7 = partialIsValidUtf8(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.Processor.partialIsValidUtf8Default(int, java.nio.ByteBuffer, int, int):int");
        }

        /* access modifiers changed from: package-private */
        public abstract int partialIsValidUtf8Direct(int i5, ByteBuffer byteBuffer, int i6, int i7);

        /* access modifiers changed from: package-private */
        public final boolean isValidUtf8(ByteBuffer byteBuffer, int i5, int i6) {
            return partialIsValidUtf8(0, byteBuffer, i5, i6) == 0;
        }

        private static int partialIsValidUtf8(ByteBuffer byteBuffer, int i5, int i6) {
            int access$200 = i5 + Utf8.estimateConsecutiveAscii(byteBuffer, i5, i6);
            while (access$200 < i6) {
                int i7 = access$200 + 1;
                byte b5 = byteBuffer.get(access$200);
                if (b5 >= 0) {
                    access$200 = i7;
                } else if (b5 < -32) {
                    if (i7 >= i6) {
                        return b5;
                    }
                    if (b5 < -62 || byteBuffer.get(i7) > -65) {
                        return -1;
                    }
                    access$200 += 2;
                } else if (b5 < -16) {
                    if (i7 >= i6 - 1) {
                        return Utf8.incompleteStateFor(byteBuffer, b5, i7, i6 - i7);
                    }
                    int i8 = access$200 + 2;
                    byte b6 = byteBuffer.get(i7);
                    if (b6 > -65 || ((b5 == -32 && b6 < -96) || ((b5 == -19 && b6 >= -96) || byteBuffer.get(i8) > -65))) {
                        return -1;
                    }
                    access$200 += 3;
                } else if (i7 >= i6 - 2) {
                    return Utf8.incompleteStateFor(byteBuffer, b5, i7, i6 - i7);
                } else {
                    int i9 = access$200 + 2;
                    byte b7 = byteBuffer.get(i7);
                    if (b7 <= -65 && (((b5 << 28) + (b7 + 112)) >> 30) == 0) {
                        int i10 = access$200 + 3;
                        if (byteBuffer.get(i9) <= -65) {
                            access$200 += 4;
                            if (byteBuffer.get(i10) > -65) {
                            }
                        }
                    }
                    return -1;
                }
            }
            return 0;
        }
    }

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i5, int i6) {
            super("Unpaired surrogate at index " + i5 + " of " + i6);
        }
    }

    static {
        Processor processor2;
        if (!UnsafeProcessor.isAvailable() || Android.isOnAndroidDevice()) {
            processor2 = new SafeProcessor();
        } else {
            processor2 = new UnsafeProcessor();
        }
        processor = processor2;
    }

    private Utf8() {
    }

    static String decodeUtf8(ByteBuffer byteBuffer, int i5, int i6) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(byteBuffer, i5, i6);
    }

    static int encode(String str, byte[] bArr, int i5, int i6) {
        return processor.encodeUtf8(str, bArr, i5, i6);
    }

    static void encodeUtf8(String str, ByteBuffer byteBuffer) {
        processor.encodeUtf8(str, byteBuffer);
    }

    static int encodedLength(String str) {
        int length = str.length();
        int i5 = 0;
        while (i5 < length && str.charAt(i5) < 128) {
            i5++;
        }
        int i6 = length;
        while (true) {
            if (i5 < length) {
                char charAt = str.charAt(i5);
                if (charAt >= 2048) {
                    i6 += encodedLengthGeneral(str, i5);
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

    private static int encodedLengthGeneral(String str, int i5) {
        int length = str.length();
        int i6 = 0;
        while (i5 < length) {
            char charAt = str.charAt(i5);
            if (charAt < 2048) {
                i6 += (127 - charAt) >>> 31;
            } else {
                i6 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(str, i5) >= 65536) {
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

    /* access modifiers changed from: private */
    public static int estimateConsecutiveAscii(ByteBuffer byteBuffer, int i5, int i6) {
        int i7 = i6 - 7;
        int i8 = i5;
        while (i8 < i7 && (byteBuffer.getLong(i8) & -9187201950435737472L) == 0) {
            i8 += 8;
        }
        return i8 - i5;
    }

    /* access modifiers changed from: private */
    public static int incompleteStateFor(int i5) {
        if (i5 > -12) {
            return -1;
        }
        return i5;
    }

    static boolean isValidUtf8(byte[] bArr) {
        return processor.isValidUtf8(bArr, 0, bArr.length);
    }

    static int partialIsValidUtf8(int i5, byte[] bArr, int i6, int i7) {
        return processor.partialIsValidUtf8(i5, bArr, i6, i7);
    }

    static String decodeUtf8(byte[] bArr, int i5, int i6) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(bArr, i5, i6);
    }

    /* access modifiers changed from: private */
    public static int incompleteStateFor(int i5, int i6) {
        if (i5 > -12 || i6 > -65) {
            return -1;
        }
        return i5 ^ (i6 << 8);
    }

    static boolean isValidUtf8(byte[] bArr, int i5, int i6) {
        return processor.isValidUtf8(bArr, i5, i6);
    }

    static int partialIsValidUtf8(int i5, ByteBuffer byteBuffer, int i6, int i7) {
        return processor.partialIsValidUtf8(i5, byteBuffer, i6, i7);
    }

    static final class UnsafeProcessor extends Processor {
        UnsafeProcessor() {
        }

        static boolean isAvailable() {
            if (!UnsafeUtil.hasUnsafeArrayOperations() || !UnsafeUtil.hasUnsafeByteBufferOperations()) {
                return false;
            }
            return true;
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bArr, long j5, int i5) {
            int i6 = 0;
            if (i5 < 16) {
                return 0;
            }
            int i7 = 8 - (((int) j5) & 7);
            while (i6 < i7) {
                long j6 = 1 + j5;
                if (UnsafeUtil.getByte(bArr, j5) < 0) {
                    return i6;
                }
                i6++;
                j5 = j6;
            }
            while (true) {
                int i8 = i6 + 8;
                if (i8 <= i5 && (UnsafeUtil.getLong((Object) bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j5) & -9187201950435737472L) == 0) {
                    j5 += 8;
                    i6 = i8;
                }
            }
            while (i6 < i5) {
                long j7 = j5 + 1;
                if (UnsafeUtil.getByte(bArr, j5) < 0) {
                    return i6;
                }
                i6++;
                j5 = j7;
            }
            return i5;
        }

        private static int unsafeIncompleteStateFor(byte[] bArr, int i5, long j5, int i6) {
            if (i6 == 0) {
                return Utf8.incompleteStateFor(i5);
            }
            if (i6 == 1) {
                return Utf8.incompleteStateFor(i5, UnsafeUtil.getByte(bArr, j5));
            }
            if (i6 == 2) {
                return Utf8.incompleteStateFor(i5, (int) UnsafeUtil.getByte(bArr, j5), (int) UnsafeUtil.getByte(bArr, j5 + 1));
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public String decodeUtf8(byte[] bArr, int i5, int i6) throws InvalidProtocolBufferException {
            Charset charset = Internal.UTF_8;
            String str = new String(bArr, i5, i6, charset);
            if (str.indexOf(65533) < 0 || Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i5, i6 + i5))) {
                return str;
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        /* access modifiers changed from: package-private */
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i5, int i6) throws InvalidProtocolBufferException {
            long j5;
            int i7;
            int i8 = i5;
            int i9 = i6;
            if ((i8 | i9 | ((byteBuffer.limit() - i8) - i9)) >= 0) {
                long addressOffset = UnsafeUtil.addressOffset(byteBuffer) + ((long) i8);
                long j6 = ((long) i9) + addressOffset;
                char[] cArr = new char[i9];
                int i10 = 0;
                while (j5 < j6) {
                    byte b5 = UnsafeUtil.getByte(j5);
                    if (!DecodeUtil.isOneByte(b5)) {
                        break;
                    }
                    addressOffset = j5 + 1;
                    DecodeUtil.handleOneByte(b5, cArr, i10);
                    i10++;
                }
                int i11 = i10;
                while (j5 < j6) {
                    long j7 = j5 + 1;
                    byte b6 = UnsafeUtil.getByte(j5);
                    if (DecodeUtil.isOneByte(b6)) {
                        i7 = i11 + 1;
                        DecodeUtil.handleOneByte(b6, cArr, i11);
                        while (j7 < j6) {
                            byte b7 = UnsafeUtil.getByte(j7);
                            if (!DecodeUtil.isOneByte(b7)) {
                                break;
                            }
                            j7++;
                            DecodeUtil.handleOneByte(b7, cArr, i7);
                            i7++;
                        }
                        j5 = j7;
                    } else if (DecodeUtil.isTwoBytes(b6)) {
                        if (j7 < j6) {
                            j5 += 2;
                            DecodeUtil.handleTwoBytes(b6, UnsafeUtil.getByte(j7), cArr, i11);
                            i11++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (DecodeUtil.isThreeBytes(b6)) {
                        if (j7 < j6 - 1) {
                            long j8 = 2 + j5;
                            j5 += 3;
                            i7 = i11 + 1;
                            DecodeUtil.handleThreeBytes(b6, UnsafeUtil.getByte(j7), UnsafeUtil.getByte(j8), cArr, i11);
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (j7 < j6 - 2) {
                        long j9 = j5 + 3;
                        j5 += 4;
                        DecodeUtil.handleFourBytes(b6, UnsafeUtil.getByte(j7), UnsafeUtil.getByte(2 + j5), UnsafeUtil.getByte(j9), cArr, i11);
                        i11 += 2;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i11 = i7;
                }
                return new String(cArr, 0, i11);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i8), Integer.valueOf(i9)}));
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:38:0x00ef, LOOP_START, PHI: r2 r4 r6 r11 
          PHI: (r2v3 int) = (r2v2 int), (r2v5 int) binds: [B:10:0x002f, B:38:0x00ef] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r4v3 long) = (r4v2 long), (r4v4 long) binds: [B:10:0x002f, B:38:0x00ef] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r6v2 long) = (r6v1 long), (r6v3 long) binds: [B:10:0x002f, B:38:0x00ef] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r11v3 long) = (r11v2 long), (r11v4 long) binds: [B:10:0x002f, B:38:0x00ef] A[DONT_GENERATE, DONT_INLINE]] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int encodeUtf8(java.lang.String r24, byte[] r25, int r26, int r27) {
            /*
                r23 = this;
                r0 = r24
                r1 = r25
                r2 = r26
                r3 = r27
                long r4 = (long) r2
                long r6 = (long) r3
                long r6 = r6 + r4
                int r8 = r0.length()
                java.lang.String r9 = " at index "
                java.lang.String r10 = "Failed writing "
                if (r8 > r3) goto L_0x0135
                int r11 = r1.length
                int r11 = r11 - r3
                if (r11 < r2) goto L_0x0135
                r2 = 0
            L_0x001a:
                r11 = 1
                r3 = 128(0x80, float:1.794E-43)
                if (r2 >= r8) goto L_0x002f
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x002f
                long r11 = r11 + r4
                byte r3 = (byte) r13
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r4, (byte) r3)
                int r2 = r2 + 1
                r4 = r11
                goto L_0x001a
            L_0x002f:
                if (r2 != r8) goto L_0x0033
                int r0 = (int) r4
                return r0
            L_0x0033:
                if (r2 >= r8) goto L_0x0133
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x004c
                int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r14 >= 0) goto L_0x004c
                long r14 = r4 + r11
                byte r13 = (byte) r13
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r4, (byte) r13)
                r19 = r6
                r26 = r11
                r4 = r14
                goto L_0x00ef
            L_0x004c:
                r14 = 2048(0x800, float:2.87E-42)
                r15 = 2
                if (r13 >= r14) goto L_0x0070
                long r17 = r6 - r15
                int r14 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
                if (r14 > 0) goto L_0x0070
                r26 = r11
                long r11 = r4 + r26
                int r14 = r13 >>> 6
                r14 = r14 | 960(0x3c0, float:1.345E-42)
                byte r14 = (byte) r14
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r4, (byte) r14)
                long r4 = r4 + r15
                r13 = r13 & 63
                r13 = r13 | r3
                byte r13 = (byte) r13
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r11, (byte) r13)
                r19 = r6
                goto L_0x00ef
            L_0x0070:
                r26 = r11
                r11 = 57343(0xdfff, float:8.0355E-41)
                r12 = 55296(0xd800, float:7.7486E-41)
                r17 = 3
                if (r13 < r12) goto L_0x0082
                if (r11 >= r13) goto L_0x007f
                goto L_0x0082
            L_0x007f:
                r19 = r6
                goto L_0x00a9
            L_0x0082:
                long r19 = r6 - r17
                int r14 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
                if (r14 > 0) goto L_0x007f
                long r11 = r4 + r26
                int r14 = r13 >>> 12
                r14 = r14 | 480(0x1e0, float:6.73E-43)
                byte r14 = (byte) r14
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r4, (byte) r14)
                r19 = r6
                long r6 = r4 + r15
                int r14 = r13 >>> 6
                r14 = r14 & 63
                r14 = r14 | r3
                byte r14 = (byte) r14
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r11, (byte) r14)
                long r4 = r4 + r17
                r11 = r13 & 63
                r11 = r11 | r3
                byte r11 = (byte) r11
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r6, (byte) r11)
                goto L_0x00ef
            L_0x00a9:
                r6 = 4
                long r21 = r19 - r6
                int r14 = (r4 > r21 ? 1 : (r4 == r21 ? 0 : -1))
                if (r14 > 0) goto L_0x0100
                int r11 = r2 + 1
                if (r11 == r8) goto L_0x00f8
                char r2 = r0.charAt(r11)
                boolean r12 = java.lang.Character.isSurrogatePair(r13, r2)
                if (r12 == 0) goto L_0x00f7
                int r2 = java.lang.Character.toCodePoint(r13, r2)
                long r12 = r4 + r26
                int r14 = r2 >>> 18
                r14 = r14 | 240(0xf0, float:3.36E-43)
                byte r14 = (byte) r14
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r4, (byte) r14)
                r21 = r6
                long r6 = r4 + r15
                int r14 = r2 >>> 12
                r14 = r14 & 63
                r14 = r14 | r3
                byte r14 = (byte) r14
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r12, (byte) r14)
                long r12 = r4 + r17
                int r14 = r2 >>> 6
                r14 = r14 & 63
                r14 = r14 | r3
                byte r14 = (byte) r14
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r6, (byte) r14)
                long r4 = r4 + r21
                r2 = r2 & 63
                r2 = r2 | r3
                byte r2 = (byte) r2
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r12, (byte) r2)
                r2 = r11
            L_0x00ef:
                int r2 = r2 + 1
                r11 = r26
                r6 = r19
                goto L_0x0033
            L_0x00f7:
                r2 = r11
            L_0x00f8:
                androidx.datastore.preferences.protobuf.Utf8$UnpairedSurrogateException r0 = new androidx.datastore.preferences.protobuf.Utf8$UnpairedSurrogateException
                int r2 = r2 + -1
                r0.<init>(r2, r8)
                throw r0
            L_0x0100:
                if (r12 > r13) goto L_0x0118
                if (r13 > r11) goto L_0x0118
                int r1 = r2 + 1
                if (r1 == r8) goto L_0x0112
                char r0 = r0.charAt(r1)
                boolean r0 = java.lang.Character.isSurrogatePair(r13, r0)
                if (r0 != 0) goto L_0x0118
            L_0x0112:
                androidx.datastore.preferences.protobuf.Utf8$UnpairedSurrogateException r0 = new androidx.datastore.preferences.protobuf.Utf8$UnpairedSurrogateException
                r0.<init>(r2, r8)
                throw r0
            L_0x0118:
                java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r10)
                r1.append(r13)
                r1.append(r9)
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0133:
                int r0 = (int) r4
                return r0
            L_0x0135:
                java.lang.ArrayIndexOutOfBoundsException r1 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r10)
                int r8 = r8 + -1
                char r0 = r0.charAt(r8)
                r4.append(r0)
                r4.append(r9)
                int r0 = r2 + r3
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r1.<init>(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.UnsafeProcessor.encodeUtf8(java.lang.String, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0041 A[LOOP:1: B:11:0x0041->B:37:0x0110, LOOP_START, PHI: r2 r4 r6 r9 r12 r14 
          PHI: (r2v2 long) = (r2v0 long), (r2v4 long) binds: [B:8:0x0039, B:37:0x0110] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r4v4 long) = (r4v3 long), (r4v6 long) binds: [B:8:0x0039, B:37:0x0110] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r6v3 long) = (r6v2 long), (r6v4 long) binds: [B:8:0x0039, B:37:0x0110] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r9v4 int) = (r9v3 int), (r9v6 int) binds: [B:8:0x0039, B:37:0x0110] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r12v1 long) = (r12v0 long), (r12v2 long) binds: [B:8:0x0039, B:37:0x0110] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r14v1 char) = (r14v0 char), (r14v2 char) binds: [B:8:0x0039, B:37:0x0110] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x003b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void encodeUtf8Direct(java.lang.String r27, java.nio.ByteBuffer r28) {
            /*
                r26 = this;
                r0 = r27
                r1 = r28
                long r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.addressOffset(r1)
                int r4 = r1.position()
                long r4 = (long) r4
                long r4 = r4 + r2
                int r6 = r1.limit()
                long r6 = (long) r6
                long r6 = r6 + r2
                int r8 = r0.length()
                long r9 = (long) r8
                long r11 = r6 - r4
                int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                java.lang.String r10 = " at index "
                java.lang.String r11 = "Failed writing "
                if (r9 > 0) goto L_0x0160
                r9 = 0
            L_0x0024:
                r12 = 1
                r14 = 128(0x80, float:1.794E-43)
                if (r9 >= r8) goto L_0x0039
                char r15 = r0.charAt(r9)
                if (r15 >= r14) goto L_0x0039
                long r12 = r12 + r4
                byte r14 = (byte) r15
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte(r4, r14)
                int r9 = r9 + 1
                r4 = r12
                goto L_0x0024
            L_0x0039:
                if (r9 != r8) goto L_0x0041
                long r4 = r4 - r2
                int r0 = (int) r4
                androidx.datastore.preferences.protobuf.Java8Compatibility.position(r1, r0)
                return
            L_0x0041:
                if (r9 >= r8) goto L_0x0157
                char r15 = r0.charAt(r9)
                if (r15 >= r14) goto L_0x005e
                int r16 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r16 >= 0) goto L_0x005e
                long r16 = r4 + r12
                byte r15 = (byte) r15
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte(r4, r15)
                r22 = r2
                r24 = r6
                r2 = r14
                r4 = r16
                r16 = r12
                goto L_0x0110
            L_0x005e:
                r16 = r12
                r12 = 2048(0x800, float:2.87E-42)
                r18 = 2
                if (r15 >= r12) goto L_0x0089
                long r12 = r6 - r18
                int r12 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
                if (r12 > 0) goto L_0x0089
                long r12 = r4 + r16
                int r14 = r15 >>> 6
                r14 = r14 | 960(0x3c0, float:1.345E-42)
                byte r14 = (byte) r14
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte(r4, r14)
                long r4 = r4 + r18
                r14 = r15 & 63
                r15 = 128(0x80, float:1.794E-43)
                r14 = r14 | r15
                byte r14 = (byte) r14
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte(r12, r14)
                r22 = r2
                r24 = r6
            L_0x0085:
                r2 = 128(0x80, float:1.794E-43)
                goto L_0x0110
            L_0x0089:
                r12 = 57343(0xdfff, float:8.0355E-41)
                r13 = 55296(0xd800, float:7.7486E-41)
                r20 = 3
                if (r15 < r13) goto L_0x009b
                if (r12 >= r15) goto L_0x0096
                goto L_0x009b
            L_0x0096:
                r22 = r2
                r24 = r6
                goto L_0x00c7
            L_0x009b:
                long r22 = r6 - r20
                int r14 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
                if (r14 > 0) goto L_0x0096
                long r12 = r4 + r16
                int r14 = r15 >>> 12
                r14 = r14 | 480(0x1e0, float:6.73E-43)
                byte r14 = (byte) r14
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte(r4, r14)
                r22 = r2
                long r2 = r4 + r18
                int r14 = r15 >>> 6
                r14 = r14 & 63
                r24 = r6
                r6 = 128(0x80, float:1.794E-43)
                r7 = r14 | 128(0x80, float:1.794E-43)
                byte r7 = (byte) r7
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte(r12, r7)
                long r4 = r4 + r20
                r7 = r15 & 63
                r7 = r7 | r6
                byte r6 = (byte) r7
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte(r2, r6)
                goto L_0x0085
            L_0x00c7:
                r2 = 4
                long r6 = r24 - r2
                int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r6 > 0) goto L_0x0124
                int r6 = r9 + 1
                if (r6 == r8) goto L_0x011c
                char r7 = r0.charAt(r6)
                boolean r9 = java.lang.Character.isSurrogatePair(r15, r7)
                if (r9 == 0) goto L_0x011b
                int r7 = java.lang.Character.toCodePoint(r15, r7)
                long r12 = r4 + r16
                int r9 = r7 >>> 18
                r9 = r9 | 240(0xf0, float:3.36E-43)
                byte r9 = (byte) r9
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte(r4, r9)
                long r14 = r4 + r18
                int r9 = r7 >>> 12
                r9 = r9 & 63
                r18 = r2
                r2 = 128(0x80, float:1.794E-43)
                r3 = r9 | 128(0x80, float:1.794E-43)
                byte r3 = (byte) r3
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte(r12, r3)
                long r12 = r4 + r20
                int r3 = r7 >>> 6
                r3 = r3 & 63
                r3 = r3 | r2
                byte r3 = (byte) r3
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte(r14, r3)
                long r4 = r4 + r18
                r3 = r7 & 63
                r3 = r3 | r2
                byte r3 = (byte) r3
                androidx.datastore.preferences.protobuf.UnsafeUtil.putByte(r12, r3)
                r9 = r6
            L_0x0110:
                int r9 = r9 + 1
                r14 = r2
                r12 = r16
                r2 = r22
                r6 = r24
                goto L_0x0041
            L_0x011b:
                r9 = r6
            L_0x011c:
                androidx.datastore.preferences.protobuf.Utf8$UnpairedSurrogateException r0 = new androidx.datastore.preferences.protobuf.Utf8$UnpairedSurrogateException
                int r9 = r9 + -1
                r0.<init>(r9, r8)
                throw r0
            L_0x0124:
                if (r13 > r15) goto L_0x013c
                if (r15 > r12) goto L_0x013c
                int r1 = r9 + 1
                if (r1 == r8) goto L_0x0136
                char r0 = r0.charAt(r1)
                boolean r0 = java.lang.Character.isSurrogatePair(r15, r0)
                if (r0 != 0) goto L_0x013c
            L_0x0136:
                androidx.datastore.preferences.protobuf.Utf8$UnpairedSurrogateException r0 = new androidx.datastore.preferences.protobuf.Utf8$UnpairedSurrogateException
                r0.<init>(r9, r8)
                throw r0
            L_0x013c:
                java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r11)
                r1.append(r15)
                r1.append(r10)
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0157:
                r22 = r2
                long r4 = r4 - r22
                int r0 = (int) r4
                androidx.datastore.preferences.protobuf.Java8Compatibility.position(r1, r0)
                return
            L_0x0160:
                java.lang.ArrayIndexOutOfBoundsException r2 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r11)
                int r8 = r8 + -1
                char r0 = r0.charAt(r8)
                r3.append(r0)
                r3.append(r10)
                int r0 = r1.limit()
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                r2.<init>(r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.UnsafeProcessor.encodeUtf8Direct(java.lang.String, java.nio.ByteBuffer):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0059, code lost:
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r13, r2) > -65) goto L_0x005e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x009e, code lost:
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r13, r2) > -65) goto L_0x00a0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int partialIsValidUtf8(int r12, byte[] r13, int r14, int r15) {
            /*
                r11 = this;
                r0 = r14 | r15
                int r1 = r13.length
                int r1 = r1 - r15
                r0 = r0 | r1
                r1 = 0
                if (r0 < 0) goto L_0x00a8
                long r2 = (long) r14
                long r14 = (long) r15
                if (r12 == 0) goto L_0x00a1
                int r0 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
                if (r0 < 0) goto L_0x0011
                return r12
            L_0x0011:
                byte r0 = (byte) r12
                r4 = -32
                r5 = -1
                r6 = -65
                r7 = 1
                if (r0 >= r4) goto L_0x002b
                r12 = -62
                if (r0 < r12) goto L_0x002a
                long r7 = r7 + r2
                byte r12 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte((byte[]) r13, (long) r2)
                if (r12 <= r6) goto L_0x0027
                goto L_0x002a
            L_0x0027:
                r2 = r7
                goto L_0x00a1
            L_0x002a:
                return r5
            L_0x002b:
                r9 = -16
                if (r0 >= r9) goto L_0x005f
                int r12 = r12 >> 8
                int r12 = ~r12
                byte r12 = (byte) r12
                if (r12 != 0) goto L_0x0045
                long r9 = r2 + r7
                byte r12 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte((byte[]) r13, (long) r2)
                int r1 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r1 < 0) goto L_0x0044
                int r12 = androidx.datastore.preferences.protobuf.Utf8.incompleteStateFor(r0, r12)
                return r12
            L_0x0044:
                r2 = r9
            L_0x0045:
                if (r12 > r6) goto L_0x005e
                r1 = -96
                if (r0 != r4) goto L_0x004d
                if (r12 < r1) goto L_0x005e
            L_0x004d:
                r4 = -19
                if (r0 != r4) goto L_0x0053
                if (r12 >= r1) goto L_0x005e
            L_0x0053:
                long r0 = r2 + r7
                byte r12 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte((byte[]) r13, (long) r2)
                if (r12 <= r6) goto L_0x005c
                goto L_0x005e
            L_0x005c:
                r2 = r0
                goto L_0x00a1
            L_0x005e:
                return r5
            L_0x005f:
                int r4 = r12 >> 8
                int r4 = ~r4
                byte r4 = (byte) r4
                if (r4 != 0) goto L_0x0076
                long r9 = r2 + r7
                byte r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte((byte[]) r13, (long) r2)
                int r12 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r12 < 0) goto L_0x0074
                int r12 = androidx.datastore.preferences.protobuf.Utf8.incompleteStateFor(r0, r4)
                return r12
            L_0x0074:
                r2 = r9
                goto L_0x0079
            L_0x0076:
                int r12 = r12 >> 16
                byte r1 = (byte) r12
            L_0x0079:
                if (r1 != 0) goto L_0x008b
                long r9 = r2 + r7
                byte r1 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte((byte[]) r13, (long) r2)
                int r12 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r12 < 0) goto L_0x008a
                int r12 = androidx.datastore.preferences.protobuf.Utf8.incompleteStateFor((int) r0, (int) r4, (int) r1)
                return r12
            L_0x008a:
                r2 = r9
            L_0x008b:
                if (r4 > r6) goto L_0x00a0
                int r12 = r0 << 28
                int r4 = r4 + 112
                int r12 = r12 + r4
                int r12 = r12 >> 30
                if (r12 != 0) goto L_0x00a0
                if (r1 > r6) goto L_0x00a0
                long r0 = r2 + r7
                byte r12 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte((byte[]) r13, (long) r2)
                if (r12 <= r6) goto L_0x005c
            L_0x00a0:
                return r5
            L_0x00a1:
                long r14 = r14 - r2
                int r12 = (int) r14
                int r12 = partialIsValidUtf8(r13, r2, r12)
                return r12
            L_0x00a8:
                java.lang.ArrayIndexOutOfBoundsException r12 = new java.lang.ArrayIndexOutOfBoundsException
                int r13 = r13.length
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
                java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
                r0 = 3
                java.lang.Object[] r0 = new java.lang.Object[r0]
                r0[r1] = r13
                r13 = 1
                r0[r13] = r14
                r13 = 2
                r0[r13] = r15
                java.lang.String r13 = "Array length=%d, index=%d, limit=%d"
                java.lang.String r13 = java.lang.String.format(r13, r0)
                r12.<init>(r13)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0063, code lost:
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r2) > -65) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a8, code lost:
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r2) > -65) goto L_0x00aa;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int partialIsValidUtf8Direct(int r11, java.nio.ByteBuffer r12, int r13, int r14) {
            /*
                r10 = this;
                r0 = r13 | r14
                int r1 = r12.limit()
                int r1 = r1 - r14
                r0 = r0 | r1
                r1 = 0
                if (r0 < 0) goto L_0x00b2
                long r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.addressOffset(r12)
                long r4 = (long) r13
                long r2 = r2 + r4
                int r14 = r14 - r13
                long r12 = (long) r14
                long r12 = r12 + r2
                if (r11 == 0) goto L_0x00ab
                int r14 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
                if (r14 < 0) goto L_0x001b
                return r11
            L_0x001b:
                byte r14 = (byte) r11
                r0 = -32
                r4 = -1
                r5 = -65
                r6 = 1
                if (r14 >= r0) goto L_0x0035
                r11 = -62
                if (r14 < r11) goto L_0x0034
                long r6 = r6 + r2
                byte r11 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r2)
                if (r11 <= r5) goto L_0x0031
                goto L_0x0034
            L_0x0031:
                r2 = r6
                goto L_0x00ab
            L_0x0034:
                return r4
            L_0x0035:
                r8 = -16
                if (r14 >= r8) goto L_0x0069
                int r11 = r11 >> 8
                int r11 = ~r11
                byte r11 = (byte) r11
                if (r11 != 0) goto L_0x004f
                long r8 = r2 + r6
                byte r11 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r2)
                int r1 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r1 < 0) goto L_0x004e
                int r11 = androidx.datastore.preferences.protobuf.Utf8.incompleteStateFor(r14, r11)
                return r11
            L_0x004e:
                r2 = r8
            L_0x004f:
                if (r11 > r5) goto L_0x0068
                r1 = -96
                if (r14 != r0) goto L_0x0057
                if (r11 < r1) goto L_0x0068
            L_0x0057:
                r0 = -19
                if (r14 != r0) goto L_0x005d
                if (r11 >= r1) goto L_0x0068
            L_0x005d:
                long r0 = r2 + r6
                byte r11 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r2)
                if (r11 <= r5) goto L_0x0066
                goto L_0x0068
            L_0x0066:
                r2 = r0
                goto L_0x00ab
            L_0x0068:
                return r4
            L_0x0069:
                int r0 = r11 >> 8
                int r0 = ~r0
                byte r0 = (byte) r0
                if (r0 != 0) goto L_0x0080
                long r8 = r2 + r6
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r2)
                int r11 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r11 < 0) goto L_0x007e
                int r11 = androidx.datastore.preferences.protobuf.Utf8.incompleteStateFor(r14, r0)
                return r11
            L_0x007e:
                r2 = r8
                goto L_0x0083
            L_0x0080:
                int r11 = r11 >> 16
                byte r1 = (byte) r11
            L_0x0083:
                if (r1 != 0) goto L_0x0095
                long r8 = r2 + r6
                byte r1 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r2)
                int r11 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r11 < 0) goto L_0x0094
                int r11 = androidx.datastore.preferences.protobuf.Utf8.incompleteStateFor((int) r14, (int) r0, (int) r1)
                return r11
            L_0x0094:
                r2 = r8
            L_0x0095:
                if (r0 > r5) goto L_0x00aa
                int r11 = r14 << 28
                int r0 = r0 + 112
                int r11 = r11 + r0
                int r11 = r11 >> 30
                if (r11 != 0) goto L_0x00aa
                if (r1 > r5) goto L_0x00aa
                long r0 = r2 + r6
                byte r11 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r2)
                if (r11 <= r5) goto L_0x0066
            L_0x00aa:
                return r4
            L_0x00ab:
                long r12 = r12 - r2
                int r11 = (int) r12
                int r11 = partialIsValidUtf8(r2, r11)
                return r11
            L_0x00b2:
                java.lang.ArrayIndexOutOfBoundsException r11 = new java.lang.ArrayIndexOutOfBoundsException
                int r12 = r12.limit()
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
                r0 = 3
                java.lang.Object[] r0 = new java.lang.Object[r0]
                r0[r1] = r12
                r12 = 1
                r0[r12] = r13
                r12 = 2
                r0[r12] = r14
                java.lang.String r12 = "buffer limit=%d, index=%d, limit=%d"
                java.lang.String r12 = java.lang.String.format(r12, r0)
                r11.<init>(r12)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8Direct(int, java.nio.ByteBuffer, int, int):int");
        }

        private static int unsafeEstimateConsecutiveAscii(long j5, int i5) {
            if (i5 < 16) {
                return 0;
            }
            int i6 = (int) ((-j5) & 7);
            int i7 = i6;
            while (i7 > 0) {
                long j6 = 1 + j5;
                if (UnsafeUtil.getByte(j5) < 0) {
                    return i6 - i7;
                }
                i7--;
                j5 = j6;
            }
            int i8 = i5 - i6;
            while (i8 >= 8 && (UnsafeUtil.getLong(j5) & -9187201950435737472L) == 0) {
                j5 += 8;
                i8 -= 8;
            }
            return i5 - i8;
        }

        private static int unsafeIncompleteStateFor(long j5, int i5, int i6) {
            if (i6 == 0) {
                return Utf8.incompleteStateFor(i5);
            }
            if (i6 == 1) {
                return Utf8.incompleteStateFor(i5, UnsafeUtil.getByte(j5));
            }
            if (i6 == 2) {
                return Utf8.incompleteStateFor(i5, (int) UnsafeUtil.getByte(j5), (int) UnsafeUtil.getByte(j5 + 1));
            }
            throw new AssertionError();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0064, code lost:
            return -1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int partialIsValidUtf8(byte[] r10, long r11, int r13) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r10, r11, r13)
                int r13 = r13 - r0
                long r0 = (long) r0
                long r11 = r11 + r0
            L_0x0007:
                r0 = 0
                r1 = r0
            L_0x0009:
                r2 = 1
                if (r13 <= 0) goto L_0x001a
                long r4 = r11 + r2
                byte r1 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte((byte[]) r10, (long) r11)
                if (r1 < 0) goto L_0x0019
                int r13 = r13 + -1
                r11 = r4
                goto L_0x0009
            L_0x0019:
                r11 = r4
            L_0x001a:
                if (r13 != 0) goto L_0x001d
                return r0
            L_0x001d:
                int r0 = r13 + -1
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L_0x003a
                if (r0 != 0) goto L_0x0029
                return r1
            L_0x0029:
                int r13 = r13 + -2
                r0 = -62
                if (r1 < r0) goto L_0x0039
                long r2 = r2 + r11
                byte r11 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte((byte[]) r10, (long) r11)
                if (r11 <= r6) goto L_0x0037
                goto L_0x0039
            L_0x0037:
                r11 = r2
                goto L_0x0007
            L_0x0039:
                return r5
            L_0x003a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L_0x0065
                r7 = 2
                if (r0 >= r7) goto L_0x0048
                int r10 = unsafeIncompleteStateFor(r10, r1, r11, r0)
                return r10
            L_0x0048:
                int r13 = r13 + -3
                long r2 = r2 + r11
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte((byte[]) r10, (long) r11)
                if (r0 > r6) goto L_0x0064
                r7 = -96
                if (r1 != r4) goto L_0x0057
                if (r0 < r7) goto L_0x0064
            L_0x0057:
                r4 = -19
                if (r1 != r4) goto L_0x005d
                if (r0 >= r7) goto L_0x0064
            L_0x005d:
                long r11 = r11 + r8
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte((byte[]) r10, (long) r2)
                if (r0 <= r6) goto L_0x0007
            L_0x0064:
                return r5
            L_0x0065:
                r4 = 3
                if (r0 >= r4) goto L_0x006d
                int r10 = unsafeIncompleteStateFor(r10, r1, r11, r0)
                return r10
            L_0x006d:
                int r13 = r13 + -4
                long r2 = r2 + r11
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte((byte[]) r10, (long) r11)
                if (r0 > r6) goto L_0x008f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L_0x008f
                long r8 = r8 + r11
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte((byte[]) r10, (long) r2)
                if (r0 > r6) goto L_0x008f
                r0 = 3
                long r11 = r11 + r0
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte((byte[]) r10, (long) r8)
                if (r0 <= r6) goto L_0x0007
            L_0x008f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(byte[], long, int):int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0064, code lost:
            return -1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int partialIsValidUtf8(long r10, int r12) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r10, r12)
                long r1 = (long) r0
                long r10 = r10 + r1
                int r12 = r12 - r0
            L_0x0007:
                r0 = 0
                r1 = r0
            L_0x0009:
                r2 = 1
                if (r12 <= 0) goto L_0x001a
                long r4 = r10 + r2
                byte r1 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r10)
                if (r1 < 0) goto L_0x0019
                int r12 = r12 + -1
                r10 = r4
                goto L_0x0009
            L_0x0019:
                r10 = r4
            L_0x001a:
                if (r12 != 0) goto L_0x001d
                return r0
            L_0x001d:
                int r0 = r12 + -1
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L_0x003a
                if (r0 != 0) goto L_0x0029
                return r1
            L_0x0029:
                int r12 = r12 + -2
                r0 = -62
                if (r1 < r0) goto L_0x0039
                long r2 = r2 + r10
                byte r10 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r10)
                if (r10 <= r6) goto L_0x0037
                goto L_0x0039
            L_0x0037:
                r10 = r2
                goto L_0x0007
            L_0x0039:
                return r5
            L_0x003a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L_0x0065
                r7 = 2
                if (r0 >= r7) goto L_0x0048
                int r10 = unsafeIncompleteStateFor(r10, r1, r0)
                return r10
            L_0x0048:
                int r12 = r12 + -3
                long r2 = r2 + r10
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r10)
                if (r0 > r6) goto L_0x0064
                r7 = -96
                if (r1 != r4) goto L_0x0057
                if (r0 < r7) goto L_0x0064
            L_0x0057:
                r4 = -19
                if (r1 != r4) goto L_0x005d
                if (r0 >= r7) goto L_0x0064
            L_0x005d:
                long r10 = r10 + r8
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r2)
                if (r0 <= r6) goto L_0x0007
            L_0x0064:
                return r5
            L_0x0065:
                r4 = 3
                if (r0 >= r4) goto L_0x006d
                int r10 = unsafeIncompleteStateFor(r10, r1, r0)
                return r10
            L_0x006d:
                int r12 = r12 + -4
                long r2 = r2 + r10
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r10)
                if (r0 > r6) goto L_0x008f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L_0x008f
                long r8 = r8 + r10
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r2)
                if (r0 > r6) goto L_0x008f
                r0 = 3
                long r10 = r10 + r0
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r8)
                if (r0 <= r6) goto L_0x0007
            L_0x008f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(long, int):int");
        }
    }

    /* access modifiers changed from: private */
    public static int incompleteStateFor(int i5, int i6, int i7) {
        if (i5 > -12 || i6 > -65 || i7 > -65) {
            return -1;
        }
        return (i5 ^ (i6 << 8)) ^ (i7 << 16);
    }

    static boolean isValidUtf8(ByteBuffer byteBuffer) {
        return processor.isValidUtf8(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    /* access modifiers changed from: private */
    public static int incompleteStateFor(byte[] bArr, int i5, int i6) {
        byte b5 = bArr[i5 - 1];
        int i7 = i6 - i5;
        if (i7 == 0) {
            return incompleteStateFor(b5);
        }
        if (i7 == 1) {
            return incompleteStateFor(b5, bArr[i5]);
        }
        if (i7 == 2) {
            return incompleteStateFor((int) b5, (int) bArr[i5], (int) bArr[i5 + 1]);
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    public static int incompleteStateFor(ByteBuffer byteBuffer, int i5, int i6, int i7) {
        if (i7 == 0) {
            return incompleteStateFor(i5);
        }
        if (i7 == 1) {
            return incompleteStateFor(i5, byteBuffer.get(i6));
        }
        if (i7 == 2) {
            return incompleteStateFor(i5, (int) byteBuffer.get(i6), (int) byteBuffer.get(i6 + 1));
        }
        throw new AssertionError();
    }

    static final class SafeProcessor extends Processor {
        SafeProcessor() {
        }

        private static int partialIsValidUtf8NonAscii(byte[] bArr, int i5, int i6) {
            while (i5 < i6) {
                int i7 = i5 + 1;
                byte b5 = bArr[i5];
                if (b5 >= 0) {
                    i5 = i7;
                } else if (b5 < -32) {
                    if (i7 >= i6) {
                        return b5;
                    }
                    if (b5 >= -62) {
                        i5 += 2;
                        if (bArr[i7] > -65) {
                        }
                    }
                    return -1;
                } else if (b5 < -16) {
                    if (i7 >= i6 - 1) {
                        return Utf8.incompleteStateFor(bArr, i7, i6);
                    }
                    int i8 = i5 + 2;
                    byte b6 = bArr[i7];
                    if (b6 <= -65 && ((b5 != -32 || b6 >= -96) && (b5 != -19 || b6 < -96))) {
                        i5 += 3;
                        if (bArr[i8] > -65) {
                        }
                    }
                    return -1;
                } else if (i7 >= i6 - 2) {
                    return Utf8.incompleteStateFor(bArr, i7, i6);
                } else {
                    int i9 = i5 + 2;
                    byte b7 = bArr[i7];
                    if (b7 <= -65 && (((b5 << 28) + (b7 + 112)) >> 30) == 0) {
                        int i10 = i5 + 3;
                        if (bArr[i9] <= -65) {
                            i5 += 4;
                            if (bArr[i10] > -65) {
                            }
                        }
                    }
                    return -1;
                }
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public String decodeUtf8(byte[] bArr, int i5, int i6) throws InvalidProtocolBufferException {
            if ((i5 | i6 | ((bArr.length - i5) - i6)) >= 0) {
                int i7 = i5 + i6;
                char[] cArr = new char[i6];
                int i8 = 0;
                while (r10 < i7) {
                    byte b5 = bArr[r10];
                    if (!DecodeUtil.isOneByte(b5)) {
                        break;
                    }
                    i5 = r10 + 1;
                    DecodeUtil.handleOneByte(b5, cArr, i8);
                    i8++;
                }
                int i9 = i8;
                while (r10 < i7) {
                    int i10 = r10 + 1;
                    byte b6 = bArr[r10];
                    if (DecodeUtil.isOneByte(b6)) {
                        int i11 = i9 + 1;
                        DecodeUtil.handleOneByte(b6, cArr, i9);
                        while (i10 < i7) {
                            byte b7 = bArr[i10];
                            if (!DecodeUtil.isOneByte(b7)) {
                                break;
                            }
                            i10++;
                            DecodeUtil.handleOneByte(b7, cArr, i11);
                            i11++;
                        }
                        i9 = i11;
                        r10 = i10;
                    } else if (DecodeUtil.isTwoBytes(b6)) {
                        if (i10 < i7) {
                            r10 += 2;
                            DecodeUtil.handleTwoBytes(b6, bArr[i10], cArr, i9);
                            i9++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (DecodeUtil.isThreeBytes(b6)) {
                        if (i10 < i7 - 1) {
                            int i12 = r10 + 2;
                            r10 += 3;
                            DecodeUtil.handleThreeBytes(b6, bArr[i10], bArr[i12], cArr, i9);
                            i9++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (i10 < i7 - 2) {
                        byte b8 = bArr[i10];
                        int i13 = r10 + 3;
                        byte b9 = bArr[r10 + 2];
                        r10 += 4;
                        DecodeUtil.handleFourBytes(b6, b8, b9, bArr[i13], cArr, i9);
                        i9 += 2;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                }
                return new String(cArr, 0, i9);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i5), Integer.valueOf(i6)}));
        }

        /* access modifiers changed from: package-private */
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i5, int i6) throws InvalidProtocolBufferException {
            return decodeUtf8Default(byteBuffer, i5, i6);
        }

        /* access modifiers changed from: package-private */
        public int encodeUtf8(String str, byte[] bArr, int i5, int i6) {
            int i7;
            int i8;
            char charAt;
            int length = str.length();
            int i9 = i6 + i5;
            int i10 = 0;
            while (i10 < length && (i8 = i10 + i5) < i9 && (charAt = str.charAt(i10)) < 128) {
                bArr[i8] = (byte) charAt;
                i10++;
            }
            if (i10 == length) {
                return i5 + length;
            }
            int i11 = i5 + i10;
            while (i10 < length) {
                char charAt2 = str.charAt(i10);
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
                    if (i14 != str.length()) {
                        char charAt3 = str.charAt(i14);
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
                } else if (55296 > charAt2 || charAt2 > 57343 || ((i7 = i10 + 1) != str.length() && Character.isSurrogatePair(charAt2, str.charAt(i7)))) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i11);
                } else {
                    throw new UnpairedSurrogateException(i10, length);
                }
                i10++;
            }
            return i11;
        }

        /* access modifiers changed from: package-private */
        public void encodeUtf8Direct(String str, ByteBuffer byteBuffer) {
            encodeUtf8Default(str, byteBuffer);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
            if (r8[r9] > -65) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0083, code lost:
            if (r8[r7] > -65) goto L_0x0085;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
            if (r8[r9] > -65) goto L_0x001b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int partialIsValidUtf8(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L_0x0086
                if (r9 < r10) goto L_0x0005
                return r7
            L_0x0005:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L_0x001c
                r7 = -62
                if (r0 < r7) goto L_0x001b
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r9 <= r3) goto L_0x0018
                goto L_0x001b
            L_0x0018:
                r9 = r7
                goto L_0x0086
            L_0x001b:
                return r2
            L_0x001c:
                r4 = -16
                if (r0 >= r4) goto L_0x0049
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L_0x0034
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r7 < r10) goto L_0x0031
                int r7 = androidx.datastore.preferences.protobuf.Utf8.incompleteStateFor(r0, r9)
                return r7
            L_0x0031:
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x0034:
                if (r7 > r3) goto L_0x0048
                r4 = -96
                if (r0 != r1) goto L_0x003c
                if (r7 < r4) goto L_0x0048
            L_0x003c:
                r1 = -19
                if (r0 != r1) goto L_0x0042
                if (r7 >= r4) goto L_0x0048
            L_0x0042:
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r9 <= r3) goto L_0x0018
            L_0x0048:
                return r2
            L_0x0049:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L_0x005c
                int r7 = r9 + 1
                byte r1 = r8[r9]
                if (r7 < r10) goto L_0x005a
                int r7 = androidx.datastore.preferences.protobuf.Utf8.incompleteStateFor(r0, r1)
                return r7
            L_0x005a:
                r9 = 0
                goto L_0x0062
            L_0x005c:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x0062:
                if (r9 != 0) goto L_0x0072
                int r9 = r7 + 1
                byte r7 = r8[r7]
                if (r9 < r10) goto L_0x006f
                int r7 = androidx.datastore.preferences.protobuf.Utf8.incompleteStateFor((int) r0, (int) r1, (int) r7)
                return r7
            L_0x006f:
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x0072:
                if (r1 > r3) goto L_0x0085
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L_0x0085
                if (r9 > r3) goto L_0x0085
                int r9 = r7 + 1
                byte r7 = r8[r7]
                if (r7 <= r3) goto L_0x0086
            L_0x0085:
                return r2
            L_0x0086:
                int r7 = partialIsValidUtf8(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.SafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        public int partialIsValidUtf8Direct(int i5, ByteBuffer byteBuffer, int i6, int i7) {
            return partialIsValidUtf8Default(i5, byteBuffer, i6, i7);
        }

        private static int partialIsValidUtf8(byte[] bArr, int i5, int i6) {
            while (i5 < i6 && bArr[i5] >= 0) {
                i5++;
            }
            if (i5 >= i6) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bArr, i5, i6);
        }
    }
}
