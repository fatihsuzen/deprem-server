package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class ByteString implements Serializable, Comparable<ByteString> {
    public static final ByteString EMPTY = of(new byte[0]);
    static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final long serialVersionUID = 1;
    final byte[] data;
    transient int hashCode;
    transient String utf8;

    ByteString(byte[] bArr) {
        this.data = bArr;
    }

    static int codePointIndexToCharIndex(String str, int i5) {
        int length = str.length();
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            if (i7 == i5) {
                return i6;
            }
            int codePointAt = str.codePointAt(i6);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i7++;
            i6 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    @Nullable
    public static ByteString decodeBase64(String str) {
        if (str != null) {
            byte[] decode = Base64.decode(str);
            if (decode != null) {
                return new ByteString(decode);
            }
            return null;
        }
        throw new IllegalArgumentException("base64 == null");
    }

    public static ByteString decodeHex(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i5 = 0; i5 < length; i5++) {
                int i6 = i5 * 2;
                bArr[i5] = (byte) ((decodeHexDigit(str.charAt(i6)) << 4) + decodeHexDigit(str.charAt(i6 + 1)));
            }
            return of(bArr);
        } else {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
    }

    private static int decodeHexDigit(char c5) {
        if (c5 >= '0' && c5 <= '9') {
            return c5 - '0';
        }
        if (c5 >= 'a' && c5 <= 'f') {
            return c5 - 'W';
        }
        if (c5 >= 'A' && c5 <= 'F') {
            return c5 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c5);
    }

    private ByteString digest(String str) {
        try {
            return of(MessageDigest.getInstance(str).digest(this.data));
        } catch (NoSuchAlgorithmException e5) {
            throw new AssertionError(e5);
        }
    }

    public static ByteString encodeString(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        } else if (charset != null) {
            return new ByteString(str.getBytes(charset));
        } else {
            throw new IllegalArgumentException("charset == null");
        }
    }

    public static ByteString encodeUtf8(String str) {
        if (str != null) {
            ByteString byteString = new ByteString(str.getBytes(Util.UTF_8));
            byteString.utf8 = str;
            return byteString;
        }
        throw new IllegalArgumentException("s == null");
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            return of(instance.doFinal(this.data));
        } catch (NoSuchAlgorithmException e5) {
            throw new AssertionError(e5);
        } catch (InvalidKeyException e6) {
            throw new IllegalArgumentException(e6);
        }
    }

    public static ByteString of(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static ByteString read(InputStream inputStream, int i5) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (i5 >= 0) {
            byte[] bArr = new byte[i5];
            int i6 = 0;
            while (i6 < i5) {
                int read = inputStream.read(bArr, i6, i5 - i6);
                if (read != -1) {
                    i6 += read;
                } else {
                    throw new EOFException();
                }
            }
            return new ByteString(bArr);
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + i5);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString read = read(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = ByteString.class.getDeclaredField(DataSchemeDataSource.SCHEME_DATA);
            declaredField.setAccessible(true);
            declaredField.set(this, read.data);
        } catch (NoSuchFieldException unused) {
            throw new AssertionError();
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
    }

    public String base64() {
        return Base64.encode(this.data);
    }

    public String base64Url() {
        return Base64.encodeUrl(this.data);
    }

    public final boolean endsWith(ByteString byteString) {
        return rangeEquals(size() - byteString.size(), byteString, 0, byteString.size());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int size = byteString.size();
            byte[] bArr = this.data;
            if (size != bArr.length || !byteString.rangeEquals(0, bArr, 0, bArr.length)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public byte getByte(int i5) {
        return this.data[i5];
    }

    public int hashCode() {
        int i5 = this.hashCode;
        if (i5 != 0) {
            return i5;
        }
        int hashCode2 = Arrays.hashCode(this.data);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public String hex() {
        byte[] bArr = this.data;
        char[] cArr = new char[(bArr.length * 2)];
        int i5 = 0;
        for (byte b5 : bArr) {
            int i6 = i5 + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i5] = cArr2[(b5 >> 4) & 15];
            i5 += 2;
            cArr[i6] = cArr2[b5 & 15];
        }
        return new String(cArr);
    }

    public ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    public final int indexOf(ByteString byteString) {
        return indexOf(byteString.internalArray(), 0);
    }

    /* access modifiers changed from: package-private */
    public byte[] internalArray() {
        return this.data;
    }

    public final int lastIndexOf(ByteString byteString) {
        return lastIndexOf(byteString.internalArray(), size());
    }

    public ByteString md5() {
        return digest(SameMD5.TAG);
    }

    public boolean rangeEquals(int i5, ByteString byteString, int i6, int i7) {
        return byteString.rangeEquals(i6, this.data, i5, i7);
    }

    public ByteString sha1() {
        return digest("SHA-1");
    }

    public ByteString sha256() {
        return digest("SHA-256");
    }

    public ByteString sha512() {
        return digest("SHA-512");
    }

    public int size() {
        return this.data.length;
    }

    public final boolean startsWith(ByteString byteString) {
        return rangeEquals(0, byteString, 0, byteString.size());
    }

    public String string(Charset charset) {
        if (charset != null) {
            return new String(this.data, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public ByteString substring(int i5) {
        return substring(i5, this.data.length);
    }

    public ByteString toAsciiLowercase() {
        int i5 = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i5 >= bArr.length) {
                return this;
            }
            byte b5 = bArr[i5];
            if (b5 < 65 || b5 > 90) {
                i5++;
            } else {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i5] = (byte) (b5 + 32);
                for (int i6 = i5 + 1; i6 < bArr2.length; i6++) {
                    byte b6 = bArr2[i6];
                    if (b6 >= 65 && b6 <= 90) {
                        bArr2[i6] = (byte) (b6 + 32);
                    }
                }
                return new ByteString(bArr2);
            }
        }
    }

    public ByteString toAsciiUppercase() {
        int i5 = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i5 >= bArr.length) {
                return this;
            }
            byte b5 = bArr[i5];
            if (b5 < 97 || b5 > 122) {
                i5++;
            } else {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i5] = (byte) (b5 - 32);
                for (int i6 = i5 + 1; i6 < bArr2.length; i6++) {
                    byte b6 = bArr2[i6];
                    if (b6 >= 97 && b6 <= 122) {
                        bArr2[i6] = (byte) (b6 - 32);
                    }
                }
                return new ByteString(bArr2);
            }
        }
    }

    public byte[] toByteArray() {
        return (byte[]) this.data.clone();
    }

    public String toString() {
        if (this.data.length == 0) {
            return "[size=0]";
        }
        String utf82 = utf8();
        int codePointIndexToCharIndex = codePointIndexToCharIndex(utf82, 64);
        if (codePointIndexToCharIndex != -1) {
            String replace = utf82.substring(0, codePointIndexToCharIndex).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (codePointIndexToCharIndex < utf82.length()) {
                return "[size=" + this.data.length + " text=" + replace + "…]";
            }
            return "[text=" + replace + "]";
        } else if (this.data.length <= 64) {
            return "[hex=" + hex() + "]";
        } else {
            return "[size=" + this.data.length + " hex=" + substring(0, 64).hex() + "…]";
        }
    }

    public String utf8() {
        String str = this.utf8;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.data, Util.UTF_8);
        this.utf8 = str2;
        return str2;
    }

    public void write(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            outputStream.write(this.data);
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    public int compareTo(ByteString byteString) {
        int size = size();
        int size2 = byteString.size();
        int min = Math.min(size, size2);
        for (int i5 = 0; i5 < min; i5++) {
            byte b5 = getByte(i5) & 255;
            byte b6 = byteString.getByte(i5) & 255;
            if (b5 != b6) {
                return b5 < b6 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public final boolean endsWith(byte[] bArr) {
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    public final int indexOf(ByteString byteString, int i5) {
        return indexOf(byteString.internalArray(), i5);
    }

    public final int lastIndexOf(ByteString byteString, int i5) {
        return lastIndexOf(byteString.internalArray(), i5);
    }

    public boolean rangeEquals(int i5, byte[] bArr, int i6, int i7) {
        if (i5 < 0) {
            return false;
        }
        byte[] bArr2 = this.data;
        return i5 <= bArr2.length - i7 && i6 >= 0 && i6 <= bArr.length - i7 && Util.arrayRangeEquals(bArr2, i5, bArr, i6, i7);
    }

    public final boolean startsWith(byte[] bArr) {
        return rangeEquals(0, bArr, 0, bArr.length);
    }

    public ByteString substring(int i5, int i6) {
        if (i5 >= 0) {
            byte[] bArr = this.data;
            if (i6 <= bArr.length) {
                int i7 = i6 - i5;
                if (i7 < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (i5 == 0 && i6 == bArr.length) {
                    return this;
                } else {
                    byte[] bArr2 = new byte[i7];
                    System.arraycopy(bArr, i5, bArr2, 0, i7);
                    return new ByteString(bArr2);
                }
            } else {
                throw new IllegalArgumentException("endIndex > length(" + this.data.length + ")");
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    public static ByteString of(byte[] bArr, int i5, int i6) {
        if (bArr != null) {
            Util.checkOffsetAndCount((long) bArr.length, (long) i5, (long) i6);
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i5, bArr2, 0, i6);
            return new ByteString(bArr2);
        }
        throw new IllegalArgumentException("data == null");
    }

    public final int indexOf(byte[] bArr) {
        return indexOf(bArr, 0);
    }

    public final int lastIndexOf(byte[] bArr) {
        return lastIndexOf(bArr, size());
    }

    /* access modifiers changed from: package-private */
    public void write(Buffer buffer) {
        byte[] bArr = this.data;
        buffer.write(bArr, 0, bArr.length);
    }

    public int indexOf(byte[] bArr, int i5) {
        int length = this.data.length - bArr.length;
        for (int max = Math.max(i5, 0); max <= length; max++) {
            if (Util.arrayRangeEquals(this.data, max, bArr, 0, bArr.length)) {
                return max;
            }
        }
        return -1;
    }

    public int lastIndexOf(byte[] bArr, int i5) {
        for (int min = Math.min(i5, this.data.length - bArr.length); min >= 0; min--) {
            if (Util.arrayRangeEquals(this.data, min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public static ByteString of(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }
        throw new IllegalArgumentException("data == null");
    }
}
