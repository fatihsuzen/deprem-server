package U1;

import X1.C2224a;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import androidx.documentfile.provider.DocumentFile;
import b2.C2278J;
import b2.C2290j;
import b2.C2302v;
import java.io.File;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;

/* renamed from: U1.a  reason: case insensitive filesystem */
public final class C2201a {

    /* renamed from: b  reason: collision with root package name */
    public static final C0180a f19301b = new C0180a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f19302a;

    /* renamed from: U1.a$a  reason: collision with other inner class name */
    public static final class C0180a {
        public /* synthetic */ C0180a(C2633k kVar) {
            this();
        }

        private C0180a() {
        }
    }

    public C2201a(Context context) {
        t.e(context, "context");
        this.f19302a = context;
    }

    private final void B(String str, boolean z4) {
        try {
            SharedPreferences.Editor edit = this.f19302a.getSharedPreferences("CoreSettings", 0).edit();
            edit.putBoolean(str, z4);
            edit.apply();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private final void M(String str, String str2) {
        try {
            SharedPreferences.Editor edit = this.f19302a.getSharedPreferences("CoreSettings", 0).edit();
            edit.putString(str, str2);
            edit.apply();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private final boolean e(String str, boolean z4) {
        try {
            SharedPreferences sharedPreferences = this.f19302a.getSharedPreferences("CoreSettings", 0);
            if (sharedPreferences.contains(str)) {
                return sharedPreferences.getBoolean(str, z4);
            }
        } catch (Exception unused) {
        }
        return z4;
    }

    private final String g(String str, String str2) {
        try {
            SharedPreferences sharedPreferences = this.f19302a.getSharedPreferences("CoreSettings", 0);
            if (sharedPreferences.contains(str)) {
                return sharedPreferences.getString(str, str2);
            }
        } catch (Exception unused) {
        }
        return str2;
    }

    static /* synthetic */ String h(C2201a aVar, String str, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = null;
        }
        return aVar.g(str, str2);
    }

    public final void A(String str) {
        M("outputdir", str);
    }

    public final void C(boolean z4) {
        B("device_rooted", z4);
        if (!z4) {
            O(false);
            D(false);
        }
    }

    public final void D(boolean z4) {
        B("install_apk_as_root_system", z4);
    }

    public final void E(String str) {
        M("language", str);
    }

    public final void F(boolean z4) {
        B("notification_permission_request", z4);
    }

    public final void G(boolean z4) {
        B("sdcard_as_backup_storage", z4);
    }

    public final void H(boolean z4) {
        B("storage_sdcard", z4);
    }

    public final void I(boolean z4) {
        B("search_apk_worker_active", z4);
    }

    public final void J(boolean z4) {
        B("show_hidden_files", z4);
    }

    public final void K(boolean z4) {
        B("show_installation_details", z4);
    }

    public final void L(boolean z4) {
        B("warn_installed", z4);
    }

    public final void N(boolean z4) {
        B("system_app", z4);
    }

    public final void O(boolean z4) {
        B("user_asked_for_show_permissions", z4);
    }

    public final boolean P() {
        return e("warn_installed", true);
    }

    public final void a() {
        boolean z4;
        boolean e5 = new C2278J(this.f19302a, (C2224a) null).e();
        if (e5 || Build.VERSION.SDK_INT > 29) {
            z4 = false;
        } else {
            z4 = C2302v.f20755a.d();
        }
        C(z4);
        N(e5);
    }

    public final String b() {
        String g5 = g("xapk_extension", ".xapk");
        if (g5 == null || s.P(g5, ".", false, 2, (Object) null)) {
            return g5;
        }
        return '.' + g5;
    }

    public final Object c() {
        String h5 = h(this, "outputdir", (String) null, 2, (Object) null);
        if (h5 != null) {
            if (o()) {
                Uri n5 = new C2290j().n(this.f19302a);
                if (n5 != null) {
                    DocumentFile fromTreeUri = DocumentFile.fromTreeUri(this.f19302a, n5);
                    if (fromTreeUri != null) {
                        for (String str : s.G0(h5, new String[]{"/"}, false, 0, 6, (Object) null)) {
                            DocumentFile findFile = fromTreeUri.findFile(str);
                            if (findFile == null) {
                                fromTreeUri = fromTreeUri.createDirectory(str);
                                if (fromTreeUri == null) {
                                    break;
                                }
                            } else {
                                fromTreeUri = findFile;
                            }
                        }
                    }
                    if (fromTreeUri != null && fromTreeUri.exists()) {
                        return fromTreeUri;
                    }
                }
                G(false);
            }
            File file = new File(h5);
            if (file.exists() || file.mkdirs()) {
                return file;
            }
        }
        File c5 = new C2290j().c(this.f19302a);
        if (c5 == null) {
            return null;
        }
        A(c5.getAbsolutePath());
        return c5;
    }

    public final String d() {
        String h5 = h(this, "outputdir", (String) null, 2, (Object) null);
        if (h5 != null) {
            return h5;
        }
        File c5 = new C2290j().c(this.f19302a);
        if (c5 == null) {
            return null;
        }
        String absolutePath = c5.getAbsolutePath();
        A(absolutePath);
        return absolutePath;
    }

    public final String f() {
        return h(this, "language", (String) null, 2, (Object) null);
    }

    public final boolean i() {
        return e("app_name_included", true);
    }

    public final boolean j() {
        return e("packagename_included", false);
    }

    public final boolean k() {
        return e("versioncode_included", true);
    }

    public final boolean l() {
        return e("versionname_included", false);
    }

    public final boolean m() {
        return e("device_rooted", false);
    }

    public final boolean n() {
        return e("install_apk_as_root_system", false);
    }

    public final boolean o() {
        return e("sdcard_as_backup_storage", false);
    }

    public final boolean p() {
        return e("storage_sdcard", false);
    }

    public final boolean q() {
        return e("search_apk_worker_active", true);
    }

    public final boolean r() {
        return e("show_hidden_files", false);
    }

    public final boolean s() {
        return e("show_installation_details", false);
    }

    public final boolean t() {
        return e("system_app", false);
    }

    public final boolean u() {
        return e("user_asked_for_show_permissions", false);
    }

    public final void v(boolean z4) {
        B("app_name_included", z4);
    }

    public final void w(boolean z4) {
        B("packagename_included", z4);
    }

    public final void x(boolean z4) {
        B("versioncode_included", z4);
    }

    public final void y(boolean z4) {
        B("versionname_included", z4);
    }

    public final void z(String str) {
        t.e(str, "value");
        M("xapk_extension", str);
    }
}
