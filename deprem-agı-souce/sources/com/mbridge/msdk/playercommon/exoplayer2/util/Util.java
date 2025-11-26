package com.mbridge.msdk.playercommon.exoplayer2.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerLibraryInfo;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import j$.util.DesugarTimeZone;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Util {
    private static final int[] CRC32_BYTES_MSBF = {0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
    public static final String DEVICE;
    public static final String DEVICE_DEBUG_INFO;
    private static final Pattern ESCAPED_CHARACTER_PATTERN = Pattern.compile("%([A-Fa-f0-9]{2})");
    public static final String MANUFACTURER;
    public static final String MODEL;
    public static final int SDK_INT;
    private static final String TAG = "Util";
    private static final Pattern XS_DATE_TIME_PATTERN = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
    private static final Pattern XS_DURATION_PATTERN = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");

    static {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 == 25 && Build.VERSION.CODENAME.charAt(0) == 'O') {
            i5 = 26;
        }
        SDK_INT = i5;
        String str = Build.DEVICE;
        DEVICE = str;
        String str2 = Build.MANUFACTURER;
        MANUFACTURER = str2;
        String str3 = Build.MODEL;
        MODEL = str3;
        DEVICE_DEBUG_INFO = str + ", " + str3 + ", " + str2 + ", " + i5;
    }

    private Util() {
    }

    public static long addWithOverflowDefault(long j5, long j6, long j7) {
        long j8 = j5 + j6;
        return ((j5 ^ j8) & (j6 ^ j8)) < 0 ? j7 : j8;
    }

    public static boolean areEqual(@Nullable Object obj, @Nullable Object obj2) {
        if (obj != null) {
            return obj.equals(obj2);
        }
        if (obj2 == null) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int binarySearchCeil(long[] r4, long r5, boolean r7, boolean r8) {
        /*
            int r0 = java.util.Arrays.binarySearch(r4, r5)
            if (r0 >= 0) goto L_0x0008
            int r5 = ~r0
            goto L_0x001a
        L_0x0008:
            int r1 = r0 + 1
            int r2 = r4.length
            if (r1 >= r2) goto L_0x0015
            r2 = r4[r1]
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0015
            r0 = r1
            goto L_0x0008
        L_0x0015:
            if (r7 == 0) goto L_0x0019
            r5 = r0
            goto L_0x001a
        L_0x0019:
            r5 = r1
        L_0x001a:
            if (r8 == 0) goto L_0x0024
            int r4 = r4.length
            int r4 = r4 + -1
            int r4 = java.lang.Math.min(r4, r5)
            return r4
        L_0x0024:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.util.Util.binarySearchCeil(long[], long, boolean, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0018  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int binarySearchFloor(int[] r3, int r4, boolean r5, boolean r6) {
        /*
            int r0 = java.util.Arrays.binarySearch(r3, r4)
            if (r0 >= 0) goto L_0x000a
            int r0 = r0 + 2
            int r3 = -r0
            goto L_0x0019
        L_0x000a:
            int r1 = r0 + -1
            if (r1 < 0) goto L_0x0014
            r2 = r3[r1]
            if (r2 != r4) goto L_0x0014
            r0 = r1
            goto L_0x000a
        L_0x0014:
            if (r5 == 0) goto L_0x0018
            r3 = r0
            goto L_0x0019
        L_0x0018:
            r3 = r1
        L_0x0019:
            if (r6 == 0) goto L_0x0020
            r4 = 0
            int r3 = java.lang.Math.max(r4, r3)
        L_0x0020:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.util.Util.binarySearchFloor(int[], int, boolean, boolean):int");
    }

    public static int ceilDivide(int i5, int i6) {
        return ((i5 + i6) - 1) / i6;
    }

    public static void closeQuietly(DataSource dataSource) {
        if (dataSource != null) {
            try {
                dataSource.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int compareLong(long j5, long j6) {
        int i5 = (j5 > j6 ? 1 : (j5 == j6 ? 0 : -1));
        if (i5 < 0) {
            return -1;
        }
        return i5 == 0 ? 0 : 1;
    }

    public static int constrainValue(int i5, int i6, int i7) {
        return Math.max(i6, Math.min(i5, i7));
    }

    public static boolean contains(Object[] objArr, Object obj) {
        for (Object areEqual : objArr) {
            if (areEqual(areEqual, obj)) {
                return true;
            }
        }
        return false;
    }

    public static int crc(byte[] bArr, int i5, int i6, int i7) {
        while (i5 < i6) {
            i7 = CRC32_BYTES_MSBF[((i7 >>> 24) ^ (bArr[i5] & 255)) & 255] ^ (i7 << 8);
            i5++;
        }
        return i7;
    }

    public static File createTempDirectory(Context context, String str) throws IOException {
        File createTempFile = createTempFile(context, str);
        createTempFile.delete();
        createTempFile.mkdir();
        return createTempFile;
    }

    public static File createTempFile(Context context, String str) throws IOException {
        return File.createTempFile(str, (String) null, context.getCacheDir());
    }

    public static String escapeFileName(String str) {
        int length = str.length();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            if (shouldEscapeCharacter(str.charAt(i7))) {
                i6++;
            }
        }
        if (i6 == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder((i6 * 2) + length);
        while (i6 > 0) {
            int i8 = i5 + 1;
            char charAt = str.charAt(i5);
            if (shouldEscapeCharacter(charAt)) {
                sb.append('%');
                sb.append(Integer.toHexString(charAt));
                i6--;
            } else {
                sb.append(charAt);
            }
            i5 = i8;
        }
        if (i5 < length) {
            sb.append(str, i5, length);
        }
        return sb.toString();
    }

    public static String formatInvariant(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String fromUtf8Bytes(byte[] bArr) {
        return new String(bArr, Charset.forName(C.UTF8_NAME));
    }

    public static int getAudioContentTypeForStreamType(int i5) {
        if (i5 != 0) {
            return (i5 == 1 || i5 == 2 || i5 == 4 || i5 == 5 || i5 == 8) ? 4 : 2;
        }
        return 1;
    }

    public static int getAudioUsageForStreamType(int i5) {
        if (i5 == 0) {
            return 2;
        }
        if (i5 == 1) {
            return 13;
        }
        if (i5 == 2) {
            return 6;
        }
        int i6 = 4;
        if (i5 != 4) {
            i6 = 5;
            if (i5 != 5) {
                return i5 != 8 ? 1 : 3;
            }
        }
        return i6;
    }

    public static byte[] getBytesFromHexString(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = i5 * 2;
            bArr[i5] = (byte) ((Character.digit(str.charAt(i6), 16) << 4) + Character.digit(str.charAt(i6 + 1), 16));
        }
        return bArr;
    }

    public static String getCodecsOfType(String str, int i5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = split(str.trim(), "(\\s*,\\s*)");
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (i5 == MimeTypes.getTrackTypeOfCodec(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static String getCommaDelimitedSimpleClassNames(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < objArr.length; i5++) {
            sb.append(objArr[i5].getClass().getSimpleName());
            if (i5 < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static int getDefaultBufferSize(int i5) {
        if (i5 == 0) {
            return 16777216;
        }
        if (i5 == 1) {
            return C.DEFAULT_AUDIO_BUFFER_SIZE;
        }
        if (i5 == 2) {
            return C.DEFAULT_VIDEO_BUFFER_SIZE;
        }
        if (i5 == 3 || i5 == 4) {
            return 131072;
        }
        throw new IllegalStateException();
    }

    @TargetApi(16)
    private static void getDisplaySizeV16(Display display, Point point) {
        display.getSize(point);
    }

    @TargetApi(17)
    private static void getDisplaySizeV17(Display display, Point point) {
        display.getRealSize(point);
    }

    @TargetApi(23)
    private static void getDisplaySizeV23(Display display, Point point) {
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
    }

    private static void getDisplaySizeV9(Display display, Point point) {
        point.x = display.getWidth();
        point.y = display.getHeight();
    }

    public static UUID getDrmUuid(String str) {
        String lowerInvariant = toLowerInvariant(str);
        lowerInvariant.getClass();
        char c5 = 65535;
        switch (lowerInvariant.hashCode()) {
            case -1860423953:
                if (lowerInvariant.equals("playready")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1400551171:
                if (lowerInvariant.equals("widevine")) {
                    c5 = 1;
                    break;
                }
                break;
            case 790309106:
                if (lowerInvariant.equals("clearkey")) {
                    c5 = 2;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                return C.PLAYREADY_UUID;
            case 1:
                return C.WIDEVINE_UUID;
            case 2:
                return C.CLEARKEY_UUID;
            default:
                try {
                    return UUID.fromString(str);
                } catch (RuntimeException unused) {
                    return null;
                }
        }
    }

    public static int getIntegerCodeForString(String str) {
        boolean z4;
        int length = str.length();
        if (length <= 4) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4);
        char c5 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            c5 = (c5 << 8) | str.charAt(i5);
        }
        return c5;
    }

    public static long getMediaDurationForPlayoutDuration(long j5, float f5) {
        if (f5 == 1.0f) {
            return j5;
        }
        return Math.round(((double) j5) * ((double) f5));
    }

    public static int getPcmEncoding(int i5) {
        if (i5 == 8) {
            return 3;
        }
        if (i5 == 16) {
            return 2;
        }
        if (i5 != 24) {
            return i5 != 32 ? 0 : 1073741824;
        }
        return Integer.MIN_VALUE;
    }

    public static int getPcmFrameSize(int i5, int i6) {
        if (i5 == Integer.MIN_VALUE) {
            return i6 * 3;
        }
        if (i5 != 1073741824) {
            if (i5 == 2) {
                return i6 * 2;
            }
            if (i5 == 3) {
                return i6;
            }
            if (i5 != 4) {
                throw new IllegalArgumentException();
            }
        }
        return i6 * 4;
    }

    public static Point getPhysicalDisplaySize(Context context) {
        return getPhysicalDisplaySize(context, ((WindowManager) context.getSystemService("window")).getDefaultDisplay());
    }

    public static long getPlayoutDurationForMediaDuration(long j5, float f5) {
        if (f5 == 1.0f) {
            return j5;
        }
        return Math.round(((double) j5) / ((double) f5));
    }

    public static int getStreamTypeForAudioUsage(int i5) {
        if (i5 == 13) {
            return 1;
        }
        switch (i5) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            default:
                return 3;
        }
    }

    public static String getStringForTime(StringBuilder sb, Formatter formatter, long j5) {
        if (j5 == C.TIME_UNSET) {
            j5 = 0;
        }
        long j6 = (j5 + 500) / 1000;
        long j7 = j6 % 60;
        long j8 = (j6 / 60) % 60;
        long j9 = j6 / 3600;
        sb.setLength(0);
        if (j9 > 0) {
            return formatter.format("%d:%02d:%02d", new Object[]{Long.valueOf(j9), Long.valueOf(j8), Long.valueOf(j7)}).toString();
        }
        return formatter.format("%02d:%02d", new Object[]{Long.valueOf(j8), Long.valueOf(j7)}).toString();
    }

    public static String getUserAgent(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "?";
        }
        return str + "/" + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") " + ExoPlayerLibraryInfo.VERSION_SLASHY;
    }

    public static byte[] getUtf8Bytes(String str) {
        return str.getBytes(Charset.forName(C.UTF8_NAME));
    }

    public static int inferContentType(Uri uri, String str) {
        if (TextUtils.isEmpty(str)) {
            return inferContentType(uri);
        }
        return inferContentType("." + str);
    }

    public static boolean isEncodingHighResolutionIntegerPcm(int i5) {
        return i5 == Integer.MIN_VALUE || i5 == 1073741824;
    }

    public static boolean isEncodingPcm(int i5) {
        return i5 == 3 || i5 == 2 || i5 == Integer.MIN_VALUE || i5 == 1073741824 || i5 == 4;
    }

    public static boolean isLinebreak(int i5) {
        return i5 == 10 || i5 == 13;
    }

    public static boolean isLocalFileUri(Uri uri) {
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme) || "file".equals(scheme)) {
            return true;
        }
        return false;
    }

    @TargetApi(23)
    public static boolean maybeRequestReadExternalStoragePermission(Activity activity, Uri... uriArr) {
        return false;
    }

    public static ExecutorService newSingleThreadExecutor(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() {
            public final Thread newThread(@NonNull Runnable runnable) {
                return new Thread(runnable, str);
            }
        });
    }

    @Nullable
    public static String normalizeLanguageCode(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            return new Locale(str).getISO3Language();
        } catch (MissingResourceException unused) {
            return toLowerInvariant(str);
        }
    }

    public static <T> T[] nullSafeArrayCopy(T[] tArr, int i5) {
        boolean z4;
        if (i5 <= tArr.length) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4);
        return Arrays.copyOf(tArr, i5);
    }

    public static long parseXsDateTime(String str) throws ParserException {
        Matcher matcher = XS_DATE_TIME_PATTERN.matcher(str);
        if (matcher.matches()) {
            int i5 = 0;
            if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
                i5 = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
                if ("-".equals(matcher.group(11))) {
                    i5 *= -1;
                }
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(DesugarTimeZone.getTimeZone("GMT"));
            gregorianCalendar.clear();
            gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
            if (!TextUtils.isEmpty(matcher.group(8))) {
                gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
            }
            long timeInMillis = gregorianCalendar.getTimeInMillis();
            if (i5 != 0) {
                return timeInMillis - ((long) (i5 * MBridgeCommon.DEFAULT_LOAD_TIMEOUT));
            }
            return timeInMillis;
        }
        throw new ParserException("Invalid date/time format: " + str);
    }

    public static long parseXsDuration(String str) {
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        Matcher matcher = XS_DURATION_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
        }
        boolean isEmpty = TextUtils.isEmpty(matcher.group(1));
        String group = matcher.group(3);
        double d10 = 0.0d;
        if (group != null) {
            d5 = Double.parseDouble(group) * 3.1556908E7d;
        } else {
            d5 = 0.0d;
        }
        String group2 = matcher.group(5);
        if (group2 != null) {
            d6 = Double.parseDouble(group2) * 2629739.0d;
        } else {
            d6 = 0.0d;
        }
        double d11 = d5 + d6;
        String group3 = matcher.group(7);
        if (group3 != null) {
            d7 = Double.parseDouble(group3) * 86400.0d;
        } else {
            d7 = 0.0d;
        }
        double d12 = d11 + d7;
        String group4 = matcher.group(10);
        if (group4 != null) {
            d8 = Double.parseDouble(group4) * 3600.0d;
        } else {
            d8 = 0.0d;
        }
        double d13 = d12 + d8;
        String group5 = matcher.group(12);
        if (group5 != null) {
            d9 = Double.parseDouble(group5) * 60.0d;
        } else {
            d9 = 0.0d;
        }
        double d14 = d13 + d9;
        String group6 = matcher.group(14);
        if (group6 != null) {
            d10 = Double.parseDouble(group6);
        }
        long j5 = (long) ((d14 + d10) * 1000.0d);
        if (!isEmpty) {
            return -j5;
        }
        return j5;
    }

    public static boolean readBoolean(Parcel parcel) {
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }

    public static void recursiveDelete(File file) {
        if (file.isDirectory()) {
            for (File recursiveDelete : file.listFiles()) {
                recursiveDelete(recursiveDelete);
            }
        }
        file.delete();
    }

    public static <T> void removeRange(List<T> list, int i5, int i6) {
        list.subList(i5, i6).clear();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long resolveSeekPositionUs(long r7, com.mbridge.msdk.playercommon.exoplayer2.SeekParameters r9, long r10, long r12) {
        /*
            com.mbridge.msdk.playercommon.exoplayer2.SeekParameters r0 = com.mbridge.msdk.playercommon.exoplayer2.SeekParameters.EXACT
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0009
            return r7
        L_0x0009:
            long r3 = r9.toleranceBeforeUs
            r5 = -9223372036854775808
            r1 = r7
            long r7 = subtractWithOverflowDefault(r1, r3, r5)
            r0 = r1
            long r2 = r9.toleranceAfterUs
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r2 = addWithOverflowDefault(r0, r2, r4)
            int r9 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            r4 = 0
            r5 = 1
            if (r9 > 0) goto L_0x002a
            int r9 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r9 > 0) goto L_0x002a
            r9 = r5
            goto L_0x002b
        L_0x002a:
            r9 = r4
        L_0x002b:
            int r6 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r6 > 0) goto L_0x0034
            int r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x0034
            r4 = r5
        L_0x0034:
            if (r9 == 0) goto L_0x0049
            if (r4 == 0) goto L_0x0049
            long r7 = r10 - r0
            long r7 = java.lang.Math.abs(r7)
            long r0 = r12 - r0
            long r0 = java.lang.Math.abs(r0)
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 > 0) goto L_0x004e
            goto L_0x004b
        L_0x0049:
            if (r9 == 0) goto L_0x004c
        L_0x004b:
            return r10
        L_0x004c:
            if (r4 == 0) goto L_0x004f
        L_0x004e:
            return r12
        L_0x004f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.util.Util.resolveSeekPositionUs(long, com.mbridge.msdk.playercommon.exoplayer2.SeekParameters, long, long):long");
    }

    public static long scaleLargeTimestamp(long j5, long j6, long j7) {
        int i5 = (j7 > j6 ? 1 : (j7 == j6 ? 0 : -1));
        if (i5 >= 0 && j7 % j6 == 0) {
            return j5 / (j7 / j6);
        }
        if (i5 < 0 && j6 % j7 == 0) {
            return j5 * (j6 / j7);
        }
        return (long) (((double) j5) * (((double) j6) / ((double) j7)));
    }

    public static long[] scaleLargeTimestamps(List<Long> list, long j5, long j6) {
        int size = list.size();
        long[] jArr = new long[size];
        int i5 = (j6 > j5 ? 1 : (j6 == j5 ? 0 : -1));
        int i6 = 0;
        if (i5 >= 0 && j6 % j5 == 0) {
            long j7 = j6 / j5;
            while (i6 < size) {
                jArr[i6] = list.get(i6).longValue() / j7;
                i6++;
            }
        } else if (i5 >= 0 || j5 % j6 != 0) {
            double d5 = ((double) j5) / ((double) j6);
            while (i6 < size) {
                jArr[i6] = (long) (((double) list.get(i6).longValue()) * d5);
                i6++;
            }
        } else {
            long j8 = j5 / j6;
            while (i6 < size) {
                jArr[i6] = list.get(i6).longValue() * j8;
                i6++;
            }
        }
        return jArr;
    }

    public static void scaleLargeTimestampsInPlace(long[] jArr, long j5, long j6) {
        int i5 = (j6 > j5 ? 1 : (j6 == j5 ? 0 : -1));
        int i6 = 0;
        if (i5 >= 0 && j6 % j5 == 0) {
            long j7 = j6 / j5;
            while (i6 < jArr.length) {
                jArr[i6] = jArr[i6] / j7;
                i6++;
            }
        } else if (i5 >= 0 || j5 % j6 != 0) {
            double d5 = ((double) j5) / ((double) j6);
            while (i6 < jArr.length) {
                jArr[i6] = (long) (((double) jArr[i6]) * d5);
                i6++;
            }
        } else {
            long j8 = j5 / j6;
            while (i6 < jArr.length) {
                jArr[i6] = jArr[i6] * j8;
                i6++;
            }
        }
    }

    private static boolean shouldEscapeCharacter(char c5) {
        return c5 == '\"' || c5 == '%' || c5 == '*' || c5 == '/' || c5 == ':' || c5 == '<' || c5 == '\\' || c5 == '|' || c5 == '>' || c5 == '?';
    }

    public static void sneakyThrow(Throwable th) {
        sneakyThrowInternal(th);
    }

    public static String[] split(String str, String str2) {
        return str.split(str2, -1);
    }

    public static String[] splitAtFirst(String str, String str2) {
        return str.split(str2, 2);
    }

    public static ComponentName startForegroundService(Context context, Intent intent) {
        if (SDK_INT >= 26) {
            return context.startForegroundService(intent);
        }
        return context.startService(intent);
    }

    public static long subtractWithOverflowDefault(long j5, long j6, long j7) {
        long j8 = j5 - j6;
        return ((j5 ^ j8) & (j6 ^ j5)) < 0 ? j7 : j8;
    }

    public static int[] toArray(List<Integer> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i5 = 0; i5 < size; i5++) {
            iArr[i5] = list.get(i5).intValue();
        }
        return iArr;
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static String toLowerInvariant(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(Locale.US);
    }

    public static String toUpperInvariant(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(Locale.US);
    }

    public static String unescapeFileName(String str) {
        int length = str.length();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            if (str.charAt(i7) == '%') {
                i6++;
            }
        }
        if (i6 == 0) {
            return str;
        }
        int i8 = length - (i6 * 2);
        StringBuilder sb = new StringBuilder(i8);
        Matcher matcher = ESCAPED_CHARACTER_PATTERN.matcher(str);
        while (i6 > 0 && matcher.find()) {
            sb.append(str, i5, matcher.start());
            sb.append((char) Integer.parseInt(matcher.group(1), 16));
            i5 = matcher.end();
            i6--;
        }
        if (i5 < length) {
            sb.append(str, i5, length);
        }
        if (sb.length() != i8) {
            return null;
        }
        return sb.toString();
    }

    public static void writeBoolean(Parcel parcel, boolean z4) {
        parcel.writeInt(z4 ? 1 : 0);
    }

    public static long ceilDivide(long j5, long j6) {
        return ((j5 + j6) - 1) / j6;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static long constrainValue(long j5, long j6, long j7) {
        return Math.max(j6, Math.min(j5, j7));
    }

    public static String fromUtf8Bytes(byte[] bArr, int i5, int i6) {
        return new String(bArr, i5, i6, Charset.forName(C.UTF8_NAME));
    }

    public static float constrainValue(float f5, float f6, float f7) {
        return Math.max(f6, Math.min(f5, f7));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006e, code lost:
        if (r6.equals("TPM171E") == false) goto L_0x00d6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Point getPhysicalDisplaySize(android.content.Context r6, android.view.Display r7) {
        /*
            java.lang.String r0 = "Util"
            int r1 = SDK_INT
            r2 = 25
            if (r1 >= r2) goto L_0x00d6
            int r1 = r7.getDisplayId()
            if (r1 != 0) goto L_0x00d6
            java.lang.String r1 = MANUFACTURER
            java.lang.String r2 = "Sony"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x0038
            java.lang.String r2 = MODEL
            java.lang.String r3 = "BRAVIA"
            boolean r2 = r2.startsWith(r3)
            if (r2 == 0) goto L_0x0038
            android.content.pm.PackageManager r6 = r6.getPackageManager()
            java.lang.String r2 = "com.sony.dtv.hardware.panel.qfhd"
            boolean r6 = r6.hasSystemFeature(r2)
            if (r6 == 0) goto L_0x0038
            android.graphics.Point r6 = new android.graphics.Point
            r7 = 3840(0xf00, float:5.381E-42)
            r0 = 2160(0x870, float:3.027E-42)
            r6.<init>(r7, r0)
            return r6
        L_0x0038:
            java.lang.String r6 = "NVIDIA"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x004a
            java.lang.String r6 = MODEL
            java.lang.String r2 = "SHIELD"
            boolean r6 = r6.contains(r2)
            if (r6 != 0) goto L_0x0070
        L_0x004a:
            java.lang.String r6 = "philips"
            java.lang.String r1 = toLowerInvariant(r1)
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x00d6
            java.lang.String r6 = MODEL
            java.lang.String r1 = "QM1"
            boolean r1 = r6.startsWith(r1)
            if (r1 != 0) goto L_0x0070
            java.lang.String r1 = "QV151E"
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L_0x0070
            java.lang.String r1 = "TPM171E"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x00d6
        L_0x0070:
            r6 = 0
            r1 = 1
            java.lang.String r2 = "android.os.SystemProperties"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ Exception -> 0x0091 }
            java.lang.String r3 = "get"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0091 }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r6] = r5     // Catch:{ Exception -> 0x0091 }
            java.lang.reflect.Method r3 = r2.getMethod(r3, r4)     // Catch:{ Exception -> 0x0091 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0091 }
            java.lang.String r5 = "sys.display-size"
            r4[r6] = r5     // Catch:{ Exception -> 0x0091 }
            java.lang.Object r2 = r3.invoke(r2, r4)     // Catch:{ Exception -> 0x0091 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0091 }
            goto L_0x0098
        L_0x0091:
            r2 = move-exception
            java.lang.String r3 = "Failed to read sys.display-size"
            android.util.Log.e(r0, r3, r2)
            r2 = 0
        L_0x0098:
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x00d6
            java.lang.String r3 = r2.trim()     // Catch:{ NumberFormatException -> 0x00c2 }
            java.lang.String r4 = "x"
            java.lang.String[] r3 = split(r3, r4)     // Catch:{ NumberFormatException -> 0x00c2 }
            int r4 = r3.length     // Catch:{ NumberFormatException -> 0x00c2 }
            r5 = 2
            if (r4 != r5) goto L_0x00c2
            r6 = r3[r6]     // Catch:{ NumberFormatException -> 0x00c2 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ NumberFormatException -> 0x00c2 }
            r1 = r3[r1]     // Catch:{ NumberFormatException -> 0x00c2 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x00c2 }
            if (r6 <= 0) goto L_0x00c2
            if (r1 <= 0) goto L_0x00c2
            android.graphics.Point r3 = new android.graphics.Point     // Catch:{ NumberFormatException -> 0x00c2 }
            r3.<init>(r6, r1)     // Catch:{ NumberFormatException -> 0x00c2 }
            return r3
        L_0x00c2:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = "Invalid sys.display-size: "
            r6.append(r1)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            android.util.Log.e(r0, r6)
        L_0x00d6:
            android.graphics.Point r6 = new android.graphics.Point
            r6.<init>()
            int r0 = SDK_INT
            r1 = 23
            if (r0 < r1) goto L_0x00e5
            getDisplaySizeV23(r7, r6)
            goto L_0x00f8
        L_0x00e5:
            r1 = 17
            if (r0 < r1) goto L_0x00ed
            getDisplaySizeV17(r7, r6)
            goto L_0x00f8
        L_0x00ed:
            r1 = 16
            if (r0 < r1) goto L_0x00f5
            getDisplaySizeV16(r7, r6)
            goto L_0x00f8
        L_0x00f5:
            getDisplaySizeV9(r7, r6)
        L_0x00f8:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.util.Util.getPhysicalDisplaySize(android.content.Context, android.view.Display):android.graphics.Point");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> int binarySearchCeil(java.util.List<? extends java.lang.Comparable<? super T>> r4, T r5, boolean r6, boolean r7) {
        /*
            int r0 = java.util.Collections.binarySearch(r4, r5)
            if (r0 >= 0) goto L_0x0008
            int r5 = ~r0
            goto L_0x0023
        L_0x0008:
            int r1 = r4.size()
        L_0x000c:
            int r2 = r0 + 1
            if (r2 >= r1) goto L_0x001e
            java.lang.Object r3 = r4.get(r2)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            int r3 = r3.compareTo(r5)
            if (r3 != 0) goto L_0x001e
            r0 = r2
            goto L_0x000c
        L_0x001e:
            if (r6 == 0) goto L_0x0022
            r5 = r0
            goto L_0x0023
        L_0x0022:
            r5 = r2
        L_0x0023:
            if (r7 == 0) goto L_0x0030
            int r4 = r4.size()
            int r4 = r4 + -1
            int r4 = java.lang.Math.min(r4, r5)
            return r4
        L_0x0030:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.util.Util.binarySearchCeil(java.util.List, java.lang.Object, boolean, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int binarySearchFloor(long[] r4, long r5, boolean r7, boolean r8) {
        /*
            int r0 = java.util.Arrays.binarySearch(r4, r5)
            if (r0 >= 0) goto L_0x000a
            int r0 = r0 + 2
            int r4 = -r0
            goto L_0x001b
        L_0x000a:
            int r1 = r0 + -1
            if (r1 < 0) goto L_0x0016
            r2 = r4[r1]
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0016
            r0 = r1
            goto L_0x000a
        L_0x0016:
            if (r7 == 0) goto L_0x001a
            r4 = r0
            goto L_0x001b
        L_0x001a:
            r4 = r1
        L_0x001b:
            if (r8 == 0) goto L_0x0022
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)
        L_0x0022:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.util.Util.binarySearchFloor(long[], long, boolean, boolean):int");
    }

    public static int inferContentType(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return 3;
        }
        return inferContentType(path);
    }

    public static int inferContentType(String str) {
        String lowerInvariant = toLowerInvariant(str);
        if (lowerInvariant.endsWith(".mpd")) {
            return 0;
        }
        if (lowerInvariant.endsWith(".m3u8")) {
            return 2;
        }
        return lowerInvariant.matches(".*\\.ism(l)?(/manifest(\\(.+\\))?)?") ? 1 : 3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> int binarySearchFloor(java.util.List<? extends java.lang.Comparable<? super T>> r3, T r4, boolean r5, boolean r6) {
        /*
            int r0 = java.util.Collections.binarySearch(r3, r4)
            if (r0 >= 0) goto L_0x000a
            int r0 = r0 + 2
            int r3 = -r0
            goto L_0x0021
        L_0x000a:
            int r1 = r0 + -1
            if (r1 < 0) goto L_0x001c
            java.lang.Object r2 = r3.get(r1)
            java.lang.Comparable r2 = (java.lang.Comparable) r2
            int r2 = r2.compareTo(r4)
            if (r2 != 0) goto L_0x001c
            r0 = r1
            goto L_0x000a
        L_0x001c:
            if (r5 == 0) goto L_0x0020
            r3 = r0
            goto L_0x0021
        L_0x0020:
            r3 = r1
        L_0x0021:
            if (r6 == 0) goto L_0x0028
            r4 = 0
            int r3 = java.lang.Math.max(r4, r3)
        L_0x0028:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.util.Util.binarySearchFloor(java.util.List, java.lang.Object, boolean, boolean):int");
    }

    private static <T extends Throwable> void sneakyThrowInternal(Throwable th) throws Throwable {
        throw th;
    }
}
