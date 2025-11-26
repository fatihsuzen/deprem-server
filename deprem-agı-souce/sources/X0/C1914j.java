package x0;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import u0.g;

/* renamed from: x0.j  reason: case insensitive filesystem */
public abstract class C1914j {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f16868a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: x0.j$a */
    enum a {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;
        

        /* renamed from: k  reason: collision with root package name */
        private static final Map f16879k = null;

        static {
            a aVar;
            a aVar2;
            a aVar3;
            a aVar4;
            HashMap hashMap = new HashMap(4);
            f16879k = hashMap;
            hashMap.put("armeabi-v7a", aVar3);
            hashMap.put("armeabi", aVar2);
            hashMap.put("arm64-v8a", aVar4);
            hashMap.put("x86", aVar);
        }

        static a b() {
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(str)) {
                g.f().i("Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            a aVar = (a) f16879k.get(str.toLowerCase(Locale.US));
            if (aVar == null) {
                return UNKNOWN;
            }
            return aVar;
        }
    }

    public static String A(String str) {
        return s(str, "SHA-1");
    }

    public static String B(InputStream inputStream) {
        String str;
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        try {
            if (useDelimiter.hasNext()) {
                str = useDelimiter.next();
            } else {
                str = "";
            }
            useDelimiter.close();
            return str;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static long a(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static synchronized long b(Context context) {
        long j5;
        synchronized (C1914j.class) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            j5 = memoryInfo.totalMem;
        }
        return j5;
    }

    public static long c(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = (long) statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (blockSize * ((long) statFs.getAvailableBlocks()));
    }

    public static boolean d(Context context) {
        if (!e(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    public static boolean e(Context context, String str) {
        if (context.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        return false;
    }

    public static void f(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e5) {
                g.f().e(str, e5);
            }
        }
    }

    public static void g(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e5) {
                throw e5;
            } catch (Exception unused) {
            }
        }
    }

    public static String h(String... strArr) {
        if (!(strArr == null || strArr.length == 0)) {
            ArrayList arrayList = new ArrayList();
            int i5 = 0;
            for (String str : strArr) {
                if (str != null) {
                    arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
                }
            }
            Collections.sort(arrayList);
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                sb.append((String) obj);
            }
            String sb2 = sb.toString();
            if (sb2.length() > 0) {
                return A(sb2);
            }
        }
        return null;
    }

    public static boolean i(Context context, String str, boolean z4) {
        Resources resources;
        if (!(context == null || (resources = context.getResources()) == null)) {
            int p5 = p(context, str, "bool");
            if (p5 > 0) {
                return resources.getBoolean(p5);
            }
            int p6 = p(context, str, TypedValues.Custom.S_STRING);
            if (p6 > 0) {
                return Boolean.parseBoolean(context.getString(p6));
            }
        }
        return z4;
    }

    public static List j(Context context) {
        ArrayList arrayList = new ArrayList();
        int p5 = p(context, "com.google.firebase.crashlytics.build_ids_lib", "array");
        int p6 = p(context, "com.google.firebase.crashlytics.build_ids_arch", "array");
        int p7 = p(context, "com.google.firebase.crashlytics.build_ids_build_id", "array");
        if (p5 == 0 || p6 == 0 || p7 == 0) {
            g.f().b(String.format("Could not find resources: %d %d %d", new Object[]{Integer.valueOf(p5), Integer.valueOf(p6), Integer.valueOf(p7)}));
            return arrayList;
        }
        String[] stringArray = context.getResources().getStringArray(p5);
        String[] stringArray2 = context.getResources().getStringArray(p6);
        String[] stringArray3 = context.getResources().getStringArray(p7);
        if (stringArray.length == stringArray3.length && stringArray2.length == stringArray3.length) {
            for (int i5 = 0; i5 < stringArray3.length; i5++) {
                arrayList.add(new C1911g(stringArray[i5], stringArray2[i5], stringArray3[i5]));
            }
            return arrayList;
        }
        g.f().b(String.format("Lengths did not match: %d %d %d", new Object[]{Integer.valueOf(stringArray.length), Integer.valueOf(stringArray2.length), Integer.valueOf(stringArray3.length)}));
        return arrayList;
    }

    public static int k() {
        return a.b().ordinal();
    }

    public static int l() {
        boolean x4 = x();
        if (y()) {
            x4 |= true;
        }
        return w() ? x4 | true ? 1 : 0 : x4 ? 1 : 0;
    }

    public static String m(Context context) {
        int p5 = p(context, "com.google.firebase.crashlytics.mapping_file_id", TypedValues.Custom.S_STRING);
        if (p5 == 0) {
            p5 = p(context, "com.crashlytics.android.build_id", TypedValues.Custom.S_STRING);
        }
        if (p5 != 0) {
            return context.getResources().getString(p5);
        }
        return null;
    }

    public static boolean n(Context context) {
        if (!x() && ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null) {
            return true;
        }
        return false;
    }

    public static String o(Context context) {
        int i5 = context.getApplicationContext().getApplicationInfo().icon;
        if (i5 <= 0) {
            return context.getPackageName();
        }
        try {
            String resourcePackageName = context.getResources().getResourcePackageName(i5);
            if ("android".equals(resourcePackageName)) {
                return context.getPackageName();
            }
            return resourcePackageName;
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }

    public static int p(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, o(context));
    }

    public static SharedPreferences q(Context context) {
        return context.getSharedPreferences("com.google.firebase.crashlytics", 0);
    }

    public static String r(Context context) {
        int p5 = p(context, "com.google.firebase.crashlytics.version_control_info", TypedValues.Custom.S_STRING);
        if (p5 == 0) {
            return null;
        }
        return context.getResources().getString(p5);
    }

    private static String s(String str, String str2) {
        return t(str.getBytes(), str2);
    }

    private static String t(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return u(instance.digest());
        } catch (NoSuchAlgorithmException e5) {
            g f5 = g.f();
            f5.e("Could not create hashing algorithm: " + str + ", returning empty string.", e5);
            return "";
        }
    }

    public static String u(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i5 = 0; i5 < bArr.length; i5++) {
            byte b5 = bArr[i5];
            int i6 = i5 * 2;
            char[] cArr2 = f16868a;
            cArr[i6] = cArr2[(b5 & 255) >>> 4];
            cArr[i6 + 1] = cArr2[b5 & 15];
        }
        return new String(cArr);
    }

    public static boolean v(Context context) {
        if ((context.getApplicationInfo().flags & 2) != 0) {
            return true;
        }
        return false;
    }

    public static boolean w() {
        if (Debug.isDebuggerConnected() || Debug.waitingForDebugger()) {
            return true;
        }
        return false;
    }

    public static boolean x() {
        if (Build.PRODUCT.contains("sdk")) {
            return true;
        }
        String str = Build.HARDWARE;
        if (str.contains("goldfish") || str.contains("ranchu")) {
            return true;
        }
        return false;
    }

    public static boolean y() {
        boolean x4 = x();
        String str = Build.TAGS;
        if ((!x4 && str != null && str.contains("test-keys")) || new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        File file = new File("/system/xbin/su");
        if (x4 || !file.exists()) {
            return false;
        }
        return true;
    }

    public static boolean z(String str, String str2) {
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }
}
