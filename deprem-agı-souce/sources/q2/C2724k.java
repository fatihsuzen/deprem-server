package q2;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.jvm.internal.t;
import t3.C2777a;

/* renamed from: q2.k  reason: case insensitive filesystem */
public final class C2724k {

    /* renamed from: a  reason: collision with root package name */
    public static final C2724k f25689a = new C2724k();

    public final String a(Context context, String str) {
        t.e(context, "context");
        t.e(str, "packageName");
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                return context.getPackageManager().getInstallSourceInfo(str).getInstallingPackageName();
            }
            return context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public final String b(PackageManager packageManager, String str) {
        boolean z4;
        t.e(packageManager, "pm");
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                t.b(str);
                SigningInfo a5 = C2716c.a(packageManager, str, 134217728).signingInfo;
                if (a5.hasPastSigningCertificates()) {
                    Signature[] a6 = a5.getSigningCertificateHistory();
                    t.d(a6, "signingInfo.signingCertificateHistory");
                    if (a6.length == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z4) {
                        C2715b bVar = C2715b.f25683a;
                        byte[] byteArray = a5.getSigningCertificateHistory()[0].toByteArray();
                        t.d(byteArray, "signingInfo.signingCerti…eHistory[0].toByteArray()");
                        return bVar.a(byteArray);
                    }
                }
                Signature[] a7 = a5.getApkContentsSigners();
                if (a7 == null) {
                    return null;
                }
                if (a7.length == 0) {
                    return null;
                }
                C2715b bVar2 = C2715b.f25683a;
                byte[] byteArray2 = a7[0].toByteArray();
                t.d(byteArray2, "signatures[0].toByteArray()");
                return bVar2.a(byteArray2);
            }
            t.b(str);
            Signature[] signatureArr = C2716c.a(packageManager, str, 64).signatures;
            if (signatureArr == null) {
                return null;
            }
            if (signatureArr.length == 0) {
                return null;
            }
            C2715b bVar3 = C2715b.f25683a;
            byte[] byteArray3 = signatureArr[0].toByteArray();
            t.d(byteArray3, "signatures[0].toByteArray()");
            return bVar3.a(byteArray3);
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public final String c(String str) {
        t.e(str, MimeTypes.BASE_TYPE_TEXT);
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            Charset forName = Charset.forName(C.UTF8_NAME);
            t.d(forName, "forName(...)");
            byte[] bytes = str.getBytes(forName);
            t.d(bytes, "getBytes(...)");
            byte[] digest = instance.digest(bytes);
            StringBuilder sb = new StringBuilder();
            t.d(digest, "bytes");
            for (byte b5 : digest) {
                String num = Integer.toString((b5 & 255) + 256, C2777a.a(16));
                t.d(num, "toString(...)");
                String substring = num.substring(1);
                t.d(substring, "substring(...)");
                sb.append(substring);
            }
            String sb2 = sb.toString();
            t.d(sb2, "sb.toString()");
            return sb2;
        } catch (Exception e5) {
            e5.printStackTrace();
            return "";
        }
    }

    public final long d(Context context) {
        t.e(context, "context");
        try {
            PackageManager packageManager = context.getPackageManager();
            t.d(packageManager, "context.packageManager");
            String packageName = context.getPackageName();
            t.d(packageName, "context.packageName");
            return e(C2716c.a(packageManager, packageName, 0));
        } catch (PackageManager.NameNotFoundException e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public final long e(PackageInfo packageInfo) {
        t.e(packageInfo, "pi");
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return (long) packageInfo.versionCode;
    }

    public final String f(Context context) {
        t.e(context, "context");
        try {
            PackageManager packageManager = context.getPackageManager();
            t.d(packageManager, "context.packageManager");
            String packageName = context.getPackageName();
            t.d(packageName, "context.packageName");
            return C2716c.a(packageManager, packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public final boolean g(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo;
        if (packageInfo != null) {
            applicationInfo = packageInfo.applicationInfo;
        } else {
            applicationInfo = null;
        }
        if (applicationInfo == null || (packageInfo.applicationInfo.flags & TsExtractor.TS_STREAM_TYPE_AC3) == 0) {
            return false;
        }
        return true;
    }
}
