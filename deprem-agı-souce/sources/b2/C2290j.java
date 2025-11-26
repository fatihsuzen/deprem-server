package b2;

import S1.i;
import U1.C2201a;
import android.content.Context;
import android.content.UriPermission;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.system.StructStatVfs;
import android.webkit.MimeTypeMap;
import androidx.documentfile.provider.DocumentFile;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.io.File;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.t;
import t3.p;
import t3.s;

/* renamed from: b2.j  reason: case insensitive filesystem */
public final class C2290j {
    private final File d(Context context) {
        C2201a aVar = new C2201a(context);
        if (!aVar.p()) {
            return context.getExternalFilesDir((String) null);
        }
        File[] externalFilesDirs = context.getExternalFilesDirs((String) null);
        if (externalFilesDirs.length > 1) {
            return externalFilesDirs[1];
        }
        File externalFilesDir = context.getExternalFilesDir((String) null);
        aVar.H(false);
        aVar.G(false);
        return externalFilesDir;
    }

    public final File a(Context context, String str) {
        t.e(context, "context");
        t.e(str, "subdirName");
        File file = new File(d(context), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final String b(ApplicationInfo applicationInfo, String str, PackageManager packageManager) {
        t.e(applicationInfo, "applicationInfo");
        t.e(str, "realPath");
        t.e(packageManager, "pm");
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        return packageManager.getApplicationLabel(applicationInfo).toString();
    }

    public final File c(Context context) {
        File file;
        t.e(context, "context");
        C2201a aVar = new C2201a(context);
        if (aVar.p()) {
            File[] externalFilesDirs = context.getExternalFilesDirs((String) null);
            if (externalFilesDirs.length > 1) {
                file = externalFilesDirs[1];
            } else {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                aVar.H(false);
                aVar.G(false);
                file = externalStorageDirectory;
            }
        } else {
            file = Environment.getExternalStorageDirectory();
        }
        if (file == null) {
            return context.getExternalFilesDir((String) null);
        }
        File file2 = new File(file.getAbsolutePath() + '/' + context.getResources().getString(i.app_name) + "/Backups");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public final File e() {
        return new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/obb/");
    }

    public final File f(Context context) {
        t.e(context, "context");
        File file = new File(context.getExternalFilesDir((String) null), "received");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final File g(Context context) {
        t.e(context, "context");
        File file = new File(context.getExternalFilesDir((String) null), "tmp");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final Drawable h(Context context, String str) {
        ApplicationInfo applicationInfo;
        t.e(context, "context");
        t.e(str, "filePath");
        PackageManager packageManager = context.getPackageManager();
        t.d(packageManager, "getPackageManager(...)");
        PackageInfo c5 = C2301u.c(packageManager, str, 128);
        if (c5 != null) {
            applicationInfo = c5.applicationInfo;
        } else {
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo2 = c5.applicationInfo;
        t.b(applicationInfo2);
        applicationInfo2.sourceDir = str;
        ApplicationInfo applicationInfo3 = c5.applicationInfo;
        t.b(applicationInfo3);
        applicationInfo3.publicSourceDir = str;
        ApplicationInfo applicationInfo4 = c5.applicationInfo;
        t.b(applicationInfo4);
        return applicationInfo4.loadIcon(context.getPackageManager());
    }

    public final String i(String str) {
        String str2;
        t.e(str, "fileName");
        String str3 = str;
        String str4 = str3;
        if (s.f0(str3, ".", 0, false, 6, (Object) null) > 0) {
            str2 = str4.substring(s.l0(str4, ".", 0, false, 6, (Object) null) + 1);
            t.d(str2, "substring(...)");
        } else {
            str2 = "";
        }
        if (s.E(str2, "xapk", true)) {
            return "application/xapk-package-archive";
        }
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        Locale locale = Locale.getDefault();
        t.d(locale, "getDefault(...)");
        String lowerCase = str2.toLowerCase(locale);
        t.d(lowerCase, "toLowerCase(...)");
        String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension == null) {
            return "application/octet-stream";
        }
        return mimeTypeFromExtension;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String j(android.net.Uri r9, android.app.Activity r10) {
        /*
            r8 = this;
            java.lang.String r0 = "contentUri"
            kotlin.jvm.internal.t.e(r9, r0)
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.t.e(r10, r0)
            r1 = 0
            android.content.ContentResolver r2 = r10.getContentResolver()     // Catch:{ Exception -> 0x004f, all -> 0x004c }
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            r3 = r9
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x002e }
            if (r9 == 0) goto L_0x0031
            java.lang.String r10 = "_display_name"
            int r10 = r9.getColumnIndex(r10)     // Catch:{ Exception -> 0x002e }
            r9.moveToFirst()     // Catch:{ Exception -> 0x002e }
            java.lang.String r1 = r9.getString(r10)     // Catch:{ Exception -> 0x002e }
            r9.close()     // Catch:{ Exception -> 0x002e }
            goto L_0x0031
        L_0x002b:
            r0 = move-exception
        L_0x002c:
            r9 = r0
            goto L_0x006f
        L_0x002e:
            r0 = move-exception
        L_0x002f:
            r9 = r0
            goto L_0x0052
        L_0x0031:
            if (r1 != 0) goto L_0x004b
            java.lang.String r9 = r3.getPath()
            if (r9 == 0) goto L_0x004b
            java.lang.String r9 = r3.getPath()
            kotlin.jvm.internal.t.b(r9)
            boolean r9 = r8.o(r9)
            if (r9 == 0) goto L_0x004b
            java.lang.String r9 = r3.getLastPathSegment()
            return r9
        L_0x004b:
            return r1
        L_0x004c:
            r0 = move-exception
            r3 = r9
            goto L_0x002c
        L_0x004f:
            r0 = move-exception
            r3 = r9
            goto L_0x002f
        L_0x0052:
            r9.printStackTrace()     // Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x006e
            java.lang.String r9 = r3.getPath()
            if (r9 == 0) goto L_0x006e
            java.lang.String r9 = r3.getPath()
            kotlin.jvm.internal.t.b(r9)
            boolean r9 = r8.o(r9)
            if (r9 == 0) goto L_0x006e
            java.lang.String r1 = r3.getLastPathSegment()
        L_0x006e:
            return r1
        L_0x006f:
            if (r1 != 0) goto L_0x0087
            java.lang.String r10 = r3.getPath()
            if (r10 == 0) goto L_0x0087
            java.lang.String r10 = r3.getPath()
            kotlin.jvm.internal.t.b(r10)
            boolean r10 = r8.o(r10)
            if (r10 == 0) goto L_0x0087
            r3.getLastPathSegment()
        L_0x0087:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.C2290j.j(android.net.Uri, android.app.Activity):java.lang.String");
    }

    public final long k(Context context, Uri uri) {
        t.e(context, "context");
        t.e(uri, "uri");
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, CampaignEx.JSON_KEY_AD_R);
            if (openFileDescriptor == null) {
                return 0;
            }
            StructStatVfs fstatvfs = Os.fstatvfs(openFileDescriptor.getFileDescriptor());
            long j5 = fstatvfs.f_bsize * fstatvfs.f_bavail;
            openFileDescriptor.close();
            return j5;
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public final long l(Context context, DocumentFile documentFile) {
        t.e(context, "context");
        t.e(documentFile, "documentFile");
        Uri uri = documentFile.getUri();
        t.d(uri, "getUri(...)");
        return k(context, uri);
    }

    public final long m(PackageInfo packageInfo) {
        t.e(packageInfo, "pi");
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return (long) packageInfo.versionCode;
    }

    public final Uri n(Context context) {
        t.e(context, "context");
        List<UriPermission> persistedUriPermissions = context.getContentResolver().getPersistedUriPermissions();
        t.d(persistedUriPermissions, "getPersistedUriPermissions(...)");
        for (UriPermission next : persistedUriPermissions) {
            Uri uri = next.getUri();
            t.d(uri, "getUri(...)");
            if (q(uri)) {
                return next.getUri();
            }
        }
        return null;
    }

    public final boolean o(String str) {
        t.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        if (s.D(str, ".apk", false, 2, (Object) null) || C2279K.f20490b.a(str)) {
            return true;
        }
        return false;
    }

    public final boolean p(Context context, String str) {
        t.e(context, "context");
        t.e(str, "packagename");
        try {
            int applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting(str);
            if (applicationEnabledSetting == 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4) {
                return true;
            }
            return false;
        } catch (Exception e5) {
            e5.printStackTrace();
            return false;
        } catch (Error e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public final boolean q(Uri uri) {
        t.e(uri, "uri");
        String path = uri.getPath();
        String str = "[ABCDEF[0-9]]" + "[ABCDEF[0-9]]" + "[ABCDEF[0-9]]" + "[ABCDEF[0-9]]";
        String str2 = ".*\\b" + str + '-' + str + ":.*";
        if (path != null) {
            return new p(str2).g(path);
        }
        return false;
    }

    public final boolean r(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo;
        if (packageInfo != null) {
            applicationInfo = packageInfo.applicationInfo;
        } else {
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            return false;
        }
        ApplicationInfo applicationInfo2 = packageInfo.applicationInfo;
        t.b(applicationInfo2);
        if ((applicationInfo2.flags & TsExtractor.TS_STREAM_TYPE_AC3) != 0) {
            return true;
        }
        return false;
    }

    public final boolean s() {
        String str = Build.BRAND;
        String str2 = Build.MANUFACTURER;
        if (s.E(str, "Xiaomi", true) || s.E(str2, "Xiaomi", true) || s.E(str, "Poco", true)) {
            return true;
        }
        return false;
    }
}
