package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public abstract class Utf8 {
    private static Utf8 DEFAULT;

    static class DecodeUtil {
        DecodeUtil() {
        }

        static void handleFourBytes(byte b5, byte b6, byte b7, byte b8, char[] cArr, int i5) throws IllegalArgumentException {
            if (isNotTrailingByte(b6) || (((b5 << 28) + (b6 + 112)) >> 30) != 0 || isNotTrailingByte(b7) || isNotTrailingByte(b8)) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            int trailingByteValue = ((b5 & 7) << 18) | (trailingByteValue(b6) << 12) | (trailingByteValue(b7) << 6) | trailingByteValue(b8);
            cArr[i5] = highSurrogate(trailingByteValue);
            cArr[i5 + 1] = lowSurrogate(trailingByteValue);
        }

        static void handleOneByte(byte b5, char[] cArr, int i5) {
            cArr[i5] = (char) b5;
        }

        static void handleThreeBytes(byte b5, byte b6, byte b7, char[] cArr, int i5) throws IllegalArgumentException {
            if (isNotTrailingByte(b6) || ((b5 == -32 && b6 < -96) || ((b5 == -19 && b6 >= -96) || isNotTrailingByte(b7)))) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            cArr[i5] = (char) (((b5 & 15) << 12) | (trailingByteValue(b6) << 6) | trailingByteValue(b7));
        }

        static void handleTwoBytes(byte b5, byte b6, char[] cArr, int i5) throws IllegalArgumentException {
            if (b5 < -62) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
            } else if (!isNotTrailingByte(b6)) {
                cArr[i5] = (char) (((b5 & 31) << 6) | trailingByteValue(b6));
            } else {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
            }
        }

        private static char highSurrogate(int i5) {
            return (char) ((i5 >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte b5) {
            return b5 > -65;
        }

        static boolean isOneByte(byte b5) {
            return b5 >= 0;
        }

        static boolean isThreeBytes(byte b5) {
            return b5 < -16;
        }

        static boolean isTwoBytes(byte b5) {
            return b5 < -32;
        }

        private static char lowSurrogate(int i5) {
            return (char) ((i5 & 1023) + 56320);
        }

        private static int trailingByteValue(byte b5) {
            return b5 & 63;
        }
    }

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i5, int i6) {
            super("Unpaired surrogate at index " + i5 + " of " + i6);
        }
    }

    public static Utf8 getDefault() {
        if (DEFAULT == null) {
            DEFAULT = new Utf8Safe();
        }
        return DEFAULT;
    }

    public static void setDefault(Utf8 utf8) {
        DEFAULT = utf8;
    }

    public abstract String decodeUtf8(ByteBuffer byteBuffer, int i5, int i6);

    public abstract void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer);

    public abstract int encodedLength(CharSequence charSequence);
}
