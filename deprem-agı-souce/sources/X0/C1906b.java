package x0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import java.util.List;
import u0.C1891f;

/* renamed from: x0.b  reason: case insensitive filesystem */
public class C1906b {

    /* renamed from: a  reason: collision with root package name */
    public final String f16841a;

    /* renamed from: b  reason: collision with root package name */
    public final String f16842b;

    /* renamed from: c  reason: collision with root package name */
    public final List f16843c;

    /* renamed from: d  reason: collision with root package name */
    public final String f16844d;

    /* renamed from: e  reason: collision with root package name */
    public final String f16845e;

    /* renamed from: f  reason: collision with root package name */
    public final String f16846f;

    /* renamed from: g  reason: collision with root package name */
    public final String f16847g;

    /* renamed from: h  reason: collision with root package name */
    public final C1891f f16848h;

    public C1906b(String str, String str2, List list, String str3, String str4, String str5, String str6, C1891f fVar) {
        this.f16841a = str;
        this.f16842b = str2;
        this.f16843c = list;
        this.f16844d = str3;
        this.f16845e = str4;
        this.f16846f = str5;
        this.f16847g = str6;
        this.f16848h = fVar;
    }

    public static C1906b a(Context context, I i5, String str, String str2, List list, C1891f fVar) {
        String packageName = context.getPackageName();
        String g5 = i5.g();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String b5 = b(packageInfo);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new C1906b(str, str2, list, g5, packageName, b5, str3, fVar);
    }

    private static String b(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Long.toString(packageInfo.getLongVersionCode());
        }
        return Integer.toString(packageInfo.versionCode);
    }
}
