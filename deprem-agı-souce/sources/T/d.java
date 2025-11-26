package T;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.util.k;

public class d {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f4351a;

    public d(Context context) {
        this.f4351a = context;
    }

    public int a(String str) {
        return this.f4351a.checkCallingOrSelfPermission(str);
    }

    public int b(String str, String str2) {
        return this.f4351a.getPackageManager().checkPermission(str, str2);
    }

    public ApplicationInfo c(String str, int i5) {
        return this.f4351a.getPackageManager().getApplicationInfo(str, i5);
    }

    public CharSequence d(String str) {
        Context context = this.f4351a;
        return context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(str, 0));
    }

    public PackageInfo e(String str, int i5) {
        return this.f4351a.getPackageManager().getPackageInfo(str, i5);
    }

    public boolean f() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return b.a(this.f4351a);
        }
        if (!k.e() || (nameForUid = this.f4351a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f4351a.getPackageManager().isInstantApp(nameForUid);
    }

    public final boolean g(int i5, String str) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) this.f4351a.getSystemService("appops");
            if (appOpsManager != null) {
                appOpsManager.checkPackage(i5, str);
                return true;
            }
            throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
        } catch (SecurityException unused) {
            return false;
        }
    }
}
