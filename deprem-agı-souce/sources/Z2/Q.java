package z2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Debug;
import kotlin.jvm.internal.t;
import t3.s;

public final class Q {

    /* renamed from: a  reason: collision with root package name */
    private final Context f26519a;

    public Q(Context context) {
        t.e(context, "context");
        this.f26519a = context;
    }

    private final boolean a() {
        if ((this.f26519a.getApplicationInfo().flags & 2) != 0) {
            return true;
        }
        return false;
    }

    private final boolean c() {
        C2954m mVar = new C2954m();
        PackageManager packageManager = this.f26519a.getPackageManager();
        t.d(packageManager, "getPackageManager(...)");
        String packageName = this.f26519a.getPackageName();
        t.d(packageName, "getPackageName(...)");
        return s.E(mVar.k(packageManager, packageName), "822b9ca12b534ebcf426632221d951bfc60eb08f9f0cf2839c321b0685c2e8a4", true);
    }

    public final boolean b() {
        if (c() && !a() && !Debug.isDebuggerConnected() && !Debug.waitingForDebugger()) {
            return false;
        }
        return true;
    }
}
