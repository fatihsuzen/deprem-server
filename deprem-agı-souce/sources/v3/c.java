package V3;

import U3.A;
import U3.r;
import U3.t;
import U3.y;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import e4.C2356e;
import e4.C2359h;
import e4.Z;
import j$.util.DesugarCollections;
import j$.util.DesugarTimeZone;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f19699a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f19700b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    public static final A f19701c;

    /* renamed from: d  reason: collision with root package name */
    public static final y f19702d;

    /* renamed from: e  reason: collision with root package name */
    private static final C2359h f19703e = C2359h.d("efbbbf");

    /* renamed from: f  reason: collision with root package name */
    private static final C2359h f19704f = C2359h.d("feff");

    /* renamed from: g  reason: collision with root package name */
    private static final C2359h f19705g = C2359h.d("fffe");

    /* renamed from: h  reason: collision with root package name */
    private static final C2359h f19706h = C2359h.d("0000ffff");

    /* renamed from: i  reason: collision with root package name */
    private static final C2359h f19707i = C2359h.d("ffff0000");

    /* renamed from: j  reason: collision with root package name */
    public static final Charset f19708j = Charset.forName(C.UTF8_NAME);

    /* renamed from: k  reason: collision with root package name */
    public static final Charset f19709k = Charset.forName("ISO-8859-1");

    /* renamed from: l  reason: collision with root package name */
    private static final Charset f19710l = Charset.forName("UTF-16BE");

    /* renamed from: m  reason: collision with root package name */
    private static final Charset f19711m = Charset.forName("UTF-16LE");

    /* renamed from: n  reason: collision with root package name */
    private static final Charset f19712n = Charset.forName("UTF-32BE");

    /* renamed from: o  reason: collision with root package name */
    private static final Charset f19713o = Charset.forName("UTF-32LE");

    /* renamed from: p  reason: collision with root package name */
    public static final TimeZone f19714p = DesugarTimeZone.getTimeZone("GMT");

    /* renamed from: q  reason: collision with root package name */
    public static final Comparator f19715q = new a();

    /* renamed from: r  reason: collision with root package name */
    private static final Pattern f19716r = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    class a implements Comparator {
        a() {
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f19717a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f19718b;

        b(String str, boolean z4) {
            this.f19717a = str;
            this.f19718b = z4;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f19717a);
            thread.setDaemon(this.f19718b);
            return thread;
        }
    }

    static {
        byte[] bArr = new byte[0];
        f19699a = bArr;
        f19701c = A.l((t) null, bArr);
        f19702d = y.c((t) null, bArr);
    }

    public static int A(String str, int i5, int i6) {
        for (int i7 = i6 - 1; i7 >= i5; i7--) {
            char charAt = str.charAt(i7);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i7 + 1;
            }
        }
        return i5;
    }

    public static ThreadFactory B(String str, boolean z4) {
        return new b(str, z4);
    }

    public static String C(String str, int i5, int i6) {
        int z4 = z(str, i5, i6);
        return str.substring(z4, A(str, z4, i6));
    }

    public static boolean D(String str) {
        return f19716r.matcher(str).matches();
    }

    public static AssertionError a(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    public static String b(String str) {
        InetAddress inetAddress;
        if (str.contains(":")) {
            if (!str.startsWith("[") || !str.endsWith("]")) {
                inetAddress = j(str, 0, str.length());
            } else {
                inetAddress = j(str, 1, str.length() - 1);
            }
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                return u(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (!lowerCase.isEmpty() && !g(lowerCase)) {
                return lowerCase;
            }
            return null;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static void c(long j5, long j6, long j7) {
        if ((j6 | j7) < 0 || j6 > j5 || j5 - j6 < j7) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e5) {
                throw e5;
            } catch (Exception unused) {
            }
        }
    }

    public static void e(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e5) {
                if (!w(e5)) {
                    throw e5;
                }
            } catch (RuntimeException e6) {
                throw e6;
            } catch (Exception unused) {
            }
        }
    }

    public static String[] f(String[] strArr, String str) {
        int length = strArr.length;
        String[] strArr2 = new String[(length + 1)];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length] = str;
        return strArr2;
    }

    private static boolean g(String str) {
        for (int i5 = 0; i5 < str.length(); i5++) {
            char charAt = str.charAt(i5);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int h(char c5) {
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

    private static boolean i(String str, int i5, int i6, byte[] bArr, int i7) {
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

    private static InetAddress j(String str, int i5, int i6) {
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
                        } else if (!str.regionMatches(i5, ".", 0, 1) || !i(str, i9, i6, bArr, i7 - 2)) {
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
                    int h5 = h(str.charAt(i5));
                    if (h5 == -1) {
                        break;
                    }
                    i11 = (i11 << 4) + h5;
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

    public static int k(String str, int i5, int i6, char c5) {
        while (i5 < i6) {
            if (str.charAt(i5) == c5) {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    public static int l(String str, int i5, int i6, String str2) {
        while (i5 < i6) {
            if (str2.indexOf(str.charAt(i5)) != -1) {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    public static boolean m(Z z4, int i5, TimeUnit timeUnit) {
        try {
            return y(z4, i5, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean n(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || !obj.equals(obj2)) {
            return false;
        }
        return true;
    }

    public static String o(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String p(r rVar, boolean z4) {
        String str;
        if (rVar.k().contains(":")) {
            str = "[" + rVar.k() + "]";
        } else {
            str = rVar.k();
        }
        if (!z4 && rVar.w() == r.d(rVar.A())) {
            return str;
        }
        return str + ":" + rVar.w();
    }

    public static List q(List list) {
        return DesugarCollections.unmodifiableList(new ArrayList(list));
    }

    public static List r(Object... objArr) {
        return DesugarCollections.unmodifiableList(Arrays.asList((Object[]) objArr.clone()));
    }

    public static int s(Comparator comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (comparator.compare(strArr[i5], str) == 0) {
                return i5;
            }
        }
        return -1;
    }

    public static int t(String str) {
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = str.charAt(i5);
            if (charAt <= 31 || charAt >= 127) {
                return i5;
            }
        }
        return -1;
    }

    private static String u(byte[] bArr) {
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
        C2356e eVar = new C2356e();
        while (i6 < bArr.length) {
            if (i6 == i5) {
                eVar.writeByte(58);
                i6 += i8;
                if (i6 == 16) {
                    eVar.writeByte(58);
                }
            } else {
                if (i6 > 0) {
                    eVar.writeByte(58);
                }
                eVar.writeHexadecimalUnsignedLong((long) (((bArr[i6] & 255) << 8) | (bArr[i6 + 1] & 255)));
                i6 += 2;
            }
        }
        return eVar.readUtf8();
    }

    public static String[] v(Comparator comparator, String[] strArr, String[] strArr2) {
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

    public static boolean w(AssertionError assertionError) {
        if (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) {
            return false;
        }
        return true;
    }

    public static boolean x(Comparator comparator, String[] strArr, String[] strArr2) {
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

    public static boolean y(Z z4, int i5, TimeUnit timeUnit) {
        long j5;
        long nanoTime = System.nanoTime();
        if (z4.timeout().e()) {
            j5 = z4.timeout().c() - nanoTime;
        } else {
            j5 = Long.MAX_VALUE;
        }
        z4.timeout().d(Math.min(j5, timeUnit.toNanos((long) i5)) + nanoTime);
        try {
            C2356e eVar = new C2356e();
            while (z4.e(eVar, 8192) != -1) {
                eVar.a();
            }
            if (j5 == Long.MAX_VALUE) {
                z4.timeout().a();
                return true;
            }
            z4.timeout().d(nanoTime + j5);
            return true;
        } catch (InterruptedIOException unused) {
            if (j5 == Long.MAX_VALUE) {
                z4.timeout().a();
                return false;
            }
            z4.timeout().d(nanoTime + j5);
            return false;
        } catch (Throwable th) {
            if (j5 == Long.MAX_VALUE) {
                z4.timeout().a();
            } else {
                z4.timeout().d(nanoTime + j5);
            }
            throw th;
        }
    }

    public static int z(String str, int i5, int i6) {
        while (i5 < i6) {
            char charAt = str.charAt(i5);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i5;
            }
            i5++;
        }
        return i6;
    }
}
