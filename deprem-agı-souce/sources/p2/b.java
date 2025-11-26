package p2;

import android.content.Context;
import android.content.pm.PackageManager;
import kotlin.jvm.internal.t;
import org.json.JSONObject;
import q2.C2724k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f25673a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25674b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25675c;

    /* renamed from: d  reason: collision with root package name */
    public final String f25676d;

    /* renamed from: e  reason: collision with root package name */
    public final String f25677e = "117";

    public b(Context context) {
        t.e(context, "context");
        String packageName = context.getPackageName();
        t.d(packageName, "context.packageName");
        this.f25673a = packageName;
        C2724k kVar = C2724k.f25689a;
        PackageManager packageManager = context.getPackageManager();
        t.d(packageManager, "context.packageManager");
        this.f25674b = kVar.b(packageManager, packageName);
        this.f25675c = String.valueOf(kVar.d(context));
        this.f25676d = kVar.f(context);
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("packagename", this.f25673a);
        String str = this.f25676d;
        if (str != null) {
            jSONObject.put("version", str);
        }
        jSONObject.put("uptodownSDKVersion", this.f25677e);
        jSONObject.put("versionCode", this.f25675c);
        String str2 = this.f25674b;
        if (str2 != null) {
            jSONObject.put("md5Signature", str2);
        }
        return jSONObject;
    }
}
