package S1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.core.activities.InstallerActivity;
import java.io.File;
import kotlin.jvm.internal.t;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final Context f29a;

    public j(Context context) {
        t.e(context, "context");
        this.f29a = context;
    }

    public static /* synthetic */ void e(j jVar, Uri uri, String str, boolean z4, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str = null;
        }
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        if ((i5 & 8) != 0) {
            z5 = false;
        }
        jVar.b(uri, str, z4, z5);
    }

    public static /* synthetic */ void f(j jVar, File file, String str, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str = null;
        }
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        jVar.c(file, str, z4);
    }

    public static /* synthetic */ void g(j jVar, String str, String str2, boolean z4, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = null;
        }
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        if ((i5 & 8) != 0) {
            z5 = false;
        }
        jVar.d(str, str2, z4, z5);
    }

    public final void a(File file, String str, boolean z4) {
        t.e(file, "file");
        String absolutePath = file.getAbsolutePath();
        t.d(absolutePath, "getAbsolutePath(...)");
        d(absolutePath, str, z4, true);
    }

    public final void b(Uri uri, String str, boolean z4, boolean z5) {
        t.e(uri, "uri");
        Intent intent = new Intent(this.f29a, InstallerActivity.class);
        intent.setData(uri);
        intent.putExtra("requireUserAction", z4);
        intent.putExtra("backgroundInstallation", z5);
        intent.addFlags(268435456);
        if (!(str == null || str.length() == 0)) {
            intent.putExtra("newFeatures", str);
        }
        this.f29a.startActivity(intent);
    }

    public final void c(File file, String str, boolean z4) {
        t.e(file, "file");
        String absolutePath = file.getAbsolutePath();
        t.d(absolutePath, "getAbsolutePath(...)");
        g(this, absolutePath, str, z4, false, 8, (Object) null);
    }

    public final void d(String str, String str2, boolean z4, boolean z5) {
        t.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        Intent intent = new Intent(this.f29a, InstallerActivity.class);
        intent.putExtra("realPath", str);
        intent.putExtra("requireUserAction", z4);
        intent.putExtra("backgroundInstallation", z5);
        intent.addFlags(268435456);
        if (!(str2 == null || str2.length() == 0)) {
            intent.putExtra("newFeatures", str2);
        }
        this.f29a.startActivity(intent);
    }

    public final void h(String str) {
        t.e(str, "packageName");
        Intent intent = new Intent("android.intent.action.DELETE", Uri.parse("package:" + str));
        intent.addFlags(268435456);
        this.f29a.startActivity(intent);
    }
}
