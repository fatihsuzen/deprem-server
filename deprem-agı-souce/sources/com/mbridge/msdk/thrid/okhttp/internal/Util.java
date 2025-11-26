package com.mbridge.msdk.thrid.okhttp.internal;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.thrid.okhttp.Headers;
import com.mbridge.msdk.thrid.okhttp.HttpUrl;
import com.mbridge.msdk.thrid.okhttp.MediaType;
import com.mbridge.msdk.thrid.okhttp.RequestBody;
import com.mbridge.msdk.thrid.okhttp.ResponseBody;
import com.mbridge.msdk.thrid.okhttp.internal.http2.Header;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Source;
import j$.util.DesugarCollections;
import j$.util.DesugarTimeZone;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final RequestBody EMPTY_REQUEST;
    public static final ResponseBody EMPTY_RESPONSE;
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Comparator<String> NATURAL_ORDER = new Comparator<String>() {
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };
    public static final TimeZone UTC = DesugarTimeZone.getTimeZone("GMT");
    private static final Charset UTF_16_BE = Charset.forName("UTF-16BE");
    private static final ByteString UTF_16_BE_BOM = ByteString.decodeHex("feff");
    private static final Charset UTF_16_LE = Charset.forName("UTF-16LE");
    private static final ByteString UTF_16_LE_BOM = ByteString.decodeHex("fffe");
    private static final Charset UTF_32_BE = Charset.forName("UTF-32BE");
    private static final ByteString UTF_32_BE_BOM = ByteString.decodeHex("0000ffff");
    private static final Charset UTF_32_LE = Charset.forName("UTF-32LE");
    private static final ByteString UTF_32_LE_BOM = ByteString.decodeHex("ffff0000");
    public static final Charset UTF_8 = Charset.forName(C.UTF8_NAME);
    private static final ByteString UTF_8_BOM = ByteString.decodeHex("efbbbf");
    private static final Pattern VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    private static final Method addSuppressedExceptionMethod;

    static {
        Class<Throwable> cls = Throwable.class;
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        Method method = null;
        EMPTY_RESPONSE = ResponseBody.create((MediaType) null, bArr);
        EMPTY_REQUEST = RequestBody.create((MediaType) null, bArr);
        try {
            method = cls.getDeclaredMethod("addSuppressed", new Class[]{cls});
        } catch (Exception unused) {
        }
        addSuppressedExceptionMethod = method;
    }

    private Util() {
    }

    public static void addSuppressedIfPossible(Throwable th, Throwable th2) {
        Method method = addSuppressedExceptionMethod;
        if (method != null) {
            try {
                method.invoke(th, new Object[]{th2});
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public static AssertionError assertionError(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    public static Charset bomAwareCharset(BufferedSource bufferedSource, Charset charset) throws IOException {
        ByteString byteString = UTF_8_BOM;
        if (bufferedSource.rangeEquals(0, byteString)) {
            bufferedSource.skip((long) byteString.size());
            return UTF_8;
        }
        ByteString byteString2 = UTF_16_BE_BOM;
        if (bufferedSource.rangeEquals(0, byteString2)) {
            bufferedSource.skip((long) byteString2.size());
            return UTF_16_BE;
        }
        ByteString byteString3 = UTF_16_LE_BOM;
        if (bufferedSource.rangeEquals(0, byteString3)) {
            bufferedSource.skip((long) byteString3.size());
            return UTF_16_LE;
        }
        ByteString byteString4 = UTF_32_BE_BOM;
        if (bufferedSource.rangeEquals(0, byteString4)) {
            bufferedSource.skip((long) byteString4.size());
            return UTF_32_BE;
        }
        ByteString byteString5 = UTF_32_LE_BOM;
        if (!bufferedSource.rangeEquals(0, byteString5)) {
            return charset;
        }
        bufferedSource.skip((long) byteString5.size());
        return UTF_32_LE;
    }

    public static String canonicalizeHost(String str) {
        InetAddress inetAddress;
        if (str.contains(":")) {
            if (!str.startsWith("[") || !str.endsWith("]")) {
                inetAddress = decodeIpv6(str, 0, str.length());
            } else {
                inetAddress = decodeIpv6(str, 1, str.length() - 1);
            }
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                return inet6AddressToAscii(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (!lowerCase.isEmpty() && !containsInvalidHostnameAsciiCodes(lowerCase)) {
                return lowerCase;
            }
            return null;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static int checkDuration(String str, long j5, TimeUnit timeUnit) {
        int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i5 < 0) {
            throw new IllegalArgumentException(str + " < 0");
        } else if (timeUnit != null) {
            long millis = timeUnit.toMillis(j5);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            } else if (millis != 0 || i5 <= 0) {
                return (int) millis;
            } else {
                throw new IllegalArgumentException(str + " too small.");
            }
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    public static void checkOffsetAndCount(long j5, long j6, long j7) {
        if ((j6 | j7) < 0 || j6 > j5 || j5 - j6 < j7) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e5) {
                throw e5;
            } catch (Exception unused) {
            }
        }
    }

    public static String[] concat(String[] strArr, String str) {
        int length = strArr.length;
        String[] strArr2 = new String[(length + 1)];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length] = str;
        return strArr2;
    }

    private static boolean containsInvalidHostnameAsciiCodes(String str) {
        for (int i5 = 0; i5 < str.length(); i5++) {
            char charAt = str.charAt(i5);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int decodeHexDigit(char c5) {
        if (c5 >= '0' && c5 <= '9') {
            return c5 - '0';
        }
        if (c5 >= 'a' && c5 <= 'f') {
            return c5 - 'W';
        }
        if (c5 < 'A' || c5 > 'F') {
            return -1;
        }
        return c5 - '7';
    }

    private static boolean decodeIpv4Suffix(String str, int i5, int i6, byte[] bArr, int i7) {
        int i8 = i7;
        while (i5 < i6) {
            if (i8 == bArr.length) {
                return false;
            }
            if (i8 != i7) {
                if (str.charAt(i5) != '.') {
                    return false;
                }
                i5++;
            }
            int i9 = i5;
            int i10 = 0;
            while (i9 < i6) {
                char charAt = str.charAt(i9);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if ((i10 == 0 && i5 != i9) || (i10 = ((i10 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i9++;
                }
            }
            if (i9 - i5 == 0) {
                return false;
            }
            bArr[i8] = (byte) i10;
            i8++;
            i5 = i9;
        }
        if (i8 != i7 + 4) {
            return false;
        }
        return true;
    }

    private static InetAddress decodeIpv6(String str, int i5, int i6) {
        byte[] bArr = new byte[16];
        int i7 = 0;
        int i8 = -1;
        int i9 = -1;
        while (true) {
            if (i5 >= i6) {
                break;
            } else if (i7 == 16) {
                return null;
            } else {
                int i10 = i5 + 2;
                if (i10 > i6 || !str.regionMatches(i5, "::", 0, 2)) {
                    if (i7 != 0) {
                        if (str.regionMatches(i5, ":", 0, 1)) {
                            i5++;
                        } else if (!str.regionMatches(i5, ".", 0, 1) || !decodeIpv4Suffix(str, i9, i6, bArr, i7 - 2)) {
                            return null;
                        } else {
                            i7 += 2;
                        }
                    }
                    i9 = i5;
                } else if (i8 != -1) {
                    return null;
                } else {
                    i7 += 2;
                    i8 = i7;
                    if (i10 == i6) {
                        break;
                    }
                    i9 = i10;
                }
                int i11 = 0;
                i5 = i9;
                while (i5 < i6) {
                    int decodeHexDigit = decodeHexDigit(str.charAt(i5));
                    if (decodeHexDigit == -1) {
                        break;
                    }
                    i11 = (i11 << 4) + decodeHexDigit;
                    i5++;
                }
                int i12 = i5 - i9;
                if (i12 == 0 || i12 > 4) {
                    return null;
                }
                int i13 = i7 + 1;
                bArr[i7] = (byte) ((i11 >>> 8) & 255);
                i7 += 2;
                bArr[i13] = (byte) (i11 & 255);
            }
        }
        if (i7 != 16) {
            if (i8 == -1) {
                return null;
            }
            int i14 = i7 - i8;
            System.arraycopy(bArr, i8, bArr, 16 - i14, i14);
            Arrays.fill(bArr, i8, (16 - i7) + i8, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    public static int delimiterOffset(String str, int i5, int i6, String str2) {
        while (i5 < i6) {
            if (str2.indexOf(str.charAt(i5)) != -1) {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    public static boolean discard(Source source, int i5, TimeUnit timeUnit) {
        try {
            return skipAll(source, i5, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || !obj.equals(obj2)) {
            return false;
        }
        return true;
    }

    public static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String hostHeader(HttpUrl httpUrl, boolean z4) {
        String str;
        if (httpUrl.host().contains(":")) {
            str = "[" + httpUrl.host() + "]";
        } else {
            str = httpUrl.host();
        }
        if (!z4 && httpUrl.port() == HttpUrl.defaultPort(httpUrl.scheme())) {
            return str;
        }
        return str + ":" + httpUrl.port();
    }

    public static <T> List<T> immutableList(List<T> list) {
        return DesugarCollections.unmodifiableList(new ArrayList(list));
    }

    public static <K, V> Map<K, V> immutableMap(Map<K, V> map) {
        if (map.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        return DesugarCollections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static int indexOf(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (comparator.compare(strArr[i5], str) == 0) {
                return i5;
            }
        }
        return -1;
    }

    public static int indexOfControlOrNonAscii(String str) {
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = str.charAt(i5);
            if (charAt <= 31 || charAt >= 127) {
                return i5;
            }
        }
        return -1;
    }

    private static String inet6AddressToAscii(byte[] bArr) {
        int i5 = -1;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < bArr.length) {
            int i9 = i7;
            while (i9 < 16 && bArr[i9] == 0 && bArr[i9 + 1] == 0) {
                i9 += 2;
            }
            int i10 = i9 - i7;
            if (i10 > i8 && i10 >= 4) {
                i5 = i7;
                i8 = i10;
            }
            i7 = i9 + 2;
        }
        Buffer buffer = new Buffer();
        while (i6 < bArr.length) {
            if (i6 == i5) {
                buffer.writeByte(58);
                i6 += i8;
                if (i6 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i6 > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong((long) (((bArr[i6] & 255) << 8) | (bArr[i6 + 1] & 255)));
                i6 += 2;
            }
        }
        return buffer.readUtf8();
    }

    public static String[] intersect(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i5]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i5++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        if (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) {
            return false;
        }
        return true;
    }

    public static boolean nonEmptyIntersection(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String str : strArr) {
                for (String compare : strArr2) {
                    if (comparator.compare(str, compare) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static X509TrustManager platformTrustManager() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e5) {
            throw assertionError("No System TLS", e5);
        }
    }

    public static boolean skipAll(Source source, int i5, TimeUnit timeUnit) throws IOException {
        long j5;
        long nanoTime = System.nanoTime();
        if (source.timeout().hasDeadline()) {
            j5 = source.timeout().deadlineNanoTime() - nanoTime;
        } else {
            j5 = Long.MAX_VALUE;
        }
        source.timeout().deadlineNanoTime(Math.min(j5, timeUnit.toNanos((long) i5)) + nanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.read(buffer, 8192) != -1) {
                buffer.clear();
            }
            if (j5 == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
                return true;
            }
            source.timeout().deadlineNanoTime(nanoTime + j5);
            return true;
        } catch (InterruptedIOException unused) {
            if (j5 == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
                return false;
            }
            source.timeout().deadlineNanoTime(nanoTime + j5);
            return false;
        } catch (Throwable th) {
            if (j5 == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + j5);
            }
            throw th;
        }
    }

    public static int skipLeadingAsciiWhitespace(String str, int i5, int i6) {
        while (i5 < i6) {
            char charAt = str.charAt(i5);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    public static int skipTrailingAsciiWhitespace(String str, int i5, int i6) {
        for (int i7 = i6 - 1; i7 >= i5; i7--) {
            char charAt = str.charAt(i7);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i7 + 1;
            }
        }
        return i5;
    }

    public static ThreadFactory threadFactory(final String str, final boolean z4) {
        return new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z4);
                return thread;
            }
        };
    }

    public static Headers toHeaders(List<Header> list) {
        Headers.Builder builder = new Headers.Builder();
        for (Header next : list) {
            Internal.instance.addLenient(builder, next.name.utf8(), next.value.utf8());
        }
        return builder.build();
    }

    public static String trimSubstring(String str, int i5, int i6) {
        int skipLeadingAsciiWhitespace = skipLeadingAsciiWhitespace(str, i5, i6);
        return str.substring(skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, i6));
    }

    public static boolean verifyAsIpAddress(String str) {
        return VERIFY_AS_IP_ADDRESS.matcher(str).matches();
    }

    public static int delimiterOffset(String str, int i5, int i6, char c5) {
        while (i5 < i6) {
            if (str.charAt(i5) == c5) {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    public static <T> List<T> immutableList(T... tArr) {
        return DesugarCollections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static void closeQuietly(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e5) {
                if (!isAndroidGetsocknameError(e5)) {
                    throw e5;
                }
            } catch (RuntimeException e6) {
                if (!"bio == null".equals(e6.getMessage())) {
                    throw e6;
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void closeQuietly(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (RuntimeException e5) {
                throw e5;
            } catch (Exception unused) {
            }
        }
    }
}
