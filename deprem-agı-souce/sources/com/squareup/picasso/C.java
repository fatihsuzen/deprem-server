package com.squareup.picasso;

import M1.e;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.util.Log;
import e4.C2358g;
import e4.C2359h;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.ThreadFactory;

abstract class C {

    /* renamed from: a  reason: collision with root package name */
    static final StringBuilder f13243a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    private static final C2359h f13244b = C2359h.f("RIFF");

    /* renamed from: c  reason: collision with root package name */
    private static final C2359h f13245c = C2359h.f("WEBP");

    static class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            sendMessageDelayed(obtainMessage(), 1000);
        }
    }

    private static class b extends Thread {
        b(Runnable runnable) {
            super(runnable);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    static class c implements ThreadFactory {
        c() {
        }

        public Thread newThread(Runnable runnable) {
            return new b(runnable);
        }
    }

    static long a(File file) {
        long j5;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j5 = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 50;
        } catch (IllegalArgumentException unused) {
            j5 = 5242880;
        }
        return Math.max(Math.min(j5, 52428800), 5242880);
    }

    static int b(Context context) {
        int i5;
        ActivityManager activityManager = (ActivityManager) o(context, "activity");
        if ((context.getApplicationInfo().flags & 1048576) != 0) {
            i5 = activityManager.getLargeMemoryClass();
        } else {
            i5 = activityManager.getMemoryClass();
        }
        return (int) ((((long) i5) * 1048576) / 7);
    }

    static void c() {
        if (!r()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    static void d() {
        if (r()) {
            throw new IllegalStateException("Method call should not happen from the main thread.");
        }
    }

    static Object e(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    static File f(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    static String g(v vVar) {
        StringBuilder sb = f13243a;
        String h5 = h(vVar, sb);
        sb.setLength(0);
        return h5;
    }

    static String h(v vVar, StringBuilder sb) {
        String str = vVar.f13410f;
        if (str != null) {
            sb.ensureCapacity(str.length() + 50);
            sb.append(vVar.f13410f);
        } else {
            Uri uri = vVar.f13408d;
            if (uri != null) {
                String uri2 = uri.toString();
                sb.ensureCapacity(uri2.length() + 50);
                sb.append(uri2);
            } else {
                sb.ensureCapacity(50);
                sb.append(vVar.f13409e);
            }
        }
        sb.append(10);
        if (vVar.f13418n != 0.0f) {
            sb.append("rotation:");
            sb.append(vVar.f13418n);
            if (vVar.f13421q) {
                sb.append('@');
                sb.append(vVar.f13419o);
                sb.append('x');
                sb.append(vVar.f13420p);
            }
            sb.append(10);
        }
        if (vVar.c()) {
            sb.append("resize:");
            sb.append(vVar.f13412h);
            sb.append('x');
            sb.append(vVar.f13413i);
            sb.append(10);
        }
        if (vVar.f13414j) {
            sb.append("centerCrop:");
            sb.append(vVar.f13415k);
            sb.append(10);
        } else if (vVar.f13416l) {
            sb.append("centerInside");
            sb.append(10);
        }
        List list = vVar.f13411g;
        if (list != null) {
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                sb.append(((e) vVar.f13411g.get(i5)).key());
                sb.append(10);
            }
        }
        return sb.toString();
    }

    static void i(Looper looper) {
        a aVar = new a(looper);
        aVar.sendMessageDelayed(aVar.obtainMessage(), 1000);
    }

    static int j(Bitmap bitmap) {
        int allocationByteCount = bitmap.getAllocationByteCount();
        if (allocationByteCount >= 0) {
            return allocationByteCount;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    static String k(C1587c cVar) {
        return l(cVar, "");
    }

    static String l(C1587c cVar, String str) {
        StringBuilder sb = new StringBuilder(str);
        C1585a h5 = cVar.h();
        if (h5 != null) {
            sb.append(h5.f13248b.d());
        }
        List i5 = cVar.i();
        if (i5 != null) {
            int size = i5.size();
            for (int i6 = 0; i6 < size; i6++) {
                if (i6 > 0 || h5 != null) {
                    sb.append(", ");
                }
                sb.append(((C1585a) i5.get(i6)).f13248b.d());
            }
        }
        return sb.toString();
    }

    static int m(Resources resources, v vVar) {
        Uri uri;
        int i5 = vVar.f13409e;
        if (i5 != 0 || (uri = vVar.f13408d) == null) {
            return i5;
        }
        String authority = uri.getAuthority();
        if (authority != null) {
            List<String> pathSegments = vVar.f13408d.getPathSegments();
            if (pathSegments == null || pathSegments.isEmpty()) {
                throw new FileNotFoundException("No path segments: " + vVar.f13408d);
            } else if (pathSegments.size() == 1) {
                try {
                    return Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Last path segment is not a resource ID: " + vVar.f13408d);
                }
            } else if (pathSegments.size() == 2) {
                return resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + vVar.f13408d);
            }
        } else {
            throw new FileNotFoundException("No package provided: " + vVar.f13408d);
        }
    }

    static Resources n(Context context, v vVar) {
        Uri uri;
        if (vVar.f13409e != 0 || (uri = vVar.f13408d) == null) {
            return context.getResources();
        }
        String authority = uri.getAuthority();
        if (authority != null) {
            try {
                return context.getPackageManager().getResourcesForApplication(authority);
            } catch (PackageManager.NameNotFoundException unused) {
                throw new FileNotFoundException("Unable to obtain resources for package: " + vVar.f13408d);
            }
        } else {
            throw new FileNotFoundException("No package provided: " + vVar.f13408d);
        }
    }

    static Object o(Context context, String str) {
        return context.getSystemService(str);
    }

    static boolean p(Context context, String str) {
        if (context.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        return false;
    }

    static boolean q(Context context) {
        try {
            if (Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0) {
                return true;
            }
            return false;
        } catch (NullPointerException | SecurityException unused) {
        }
    }

    static boolean r() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    static boolean s(C2358g gVar) {
        if (!gVar.k(0, f13244b) || !gVar.k(8, f13245c)) {
            return false;
        }
        return true;
    }

    static void t(String str, String str2, String str3) {
        u(str, str2, str3, "");
    }

    static void u(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{str, str2, str3, str4}));
    }
}
