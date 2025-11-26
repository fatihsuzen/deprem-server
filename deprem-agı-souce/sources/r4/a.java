package r4;

import T3.k;
import android.app.Application;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import com.google.gson.Gson;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.data.storage.SharedStorage$getVectorPreference$type$1;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.t;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f25721a;

    public a(Application application) {
        t.e(application, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(application);
        t.d(defaultSharedPreferences, "getDefaultSharedPreferences(app)");
        this.f25721a = defaultSharedPreferences;
    }

    public static void d(a aVar, k kVar, k kVar2, k kVar3) {
        aVar.getClass();
        t.e(kVar, "explicitNotice");
        t.e(kVar2, "optOut");
        t.e(kVar3, "coveredTransaction");
        String str = 1 + kVar.f19294a + kVar2.f19294a + kVar3.f19294a;
        aVar.i(b.PRIVACY_STRING, str);
        aVar.i(b.SAVED_PRIVACY_STRING, str);
    }

    public final int a() {
        t.e(b.TCF_GDPR_APPLIES, "preferenceKey");
        return this.f25721a.getInt("IABTCF_gdprApplies", 0);
    }

    public final String b(int i5, int i6) {
        String k5 = k(b.SAVED_PRIVACY_STRING);
        if (k5.length() <= 0) {
            return "";
        }
        String substring = k5.substring(i5, i6);
        t.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final void c(String str, String str2) {
        t.e(str, "preferenceKey");
        t.e(str2, "value");
        SharedPreferences.Editor edit = this.f25721a.edit();
        t.d(edit, "editor");
        edit.putString(str, str2);
        edit.apply();
    }

    public final void e(b bVar) {
        t.e(bVar, "preferenceKey");
        SharedPreferences.Editor edit = this.f25721a.edit();
        t.d(edit, "editor");
        edit.remove(bVar.f25815a);
        edit.apply();
    }

    public final void f(b bVar, int i5) {
        t.e(bVar, "preferenceKey");
        SharedPreferences.Editor edit = this.f25721a.edit();
        t.d(edit, "editor");
        edit.putInt(bVar.f25815a, i5);
        edit.apply();
    }

    public final void g(b bVar, long j5) {
        t.e(bVar, "preferenceKey");
        SharedPreferences.Editor edit = this.f25721a.edit();
        t.d(edit, "editor");
        edit.putLong(bVar.f25815a, j5);
        edit.apply();
    }

    public final void h(b bVar, Vector vector) {
        t.e(bVar, "key");
        t.e(vector, "list");
        String r5 = new Gson().r(vector);
        t.d(r5, "json");
        i(bVar, r5);
    }

    public final void i(b bVar, String str) {
        t.e(bVar, "preferenceKey");
        t.e(str, "value");
        SharedPreferences.Editor edit = this.f25721a.edit();
        t.d(edit, "editor");
        edit.putString(bVar.f25815a, str);
        edit.apply();
    }

    public final void j(b bVar, boolean z4) {
        t.e(bVar, "preferenceKey");
        SharedPreferences.Editor edit = this.f25721a.edit();
        t.d(edit, "editor");
        edit.putBoolean(bVar.f25815a, z4);
        edit.apply();
    }

    public final String k(b bVar) {
        t.e(bVar, "preferenceKey");
        String string = this.f25721a.getString(bVar.f25815a, "");
        if (string == null) {
            return "";
        }
        return string;
    }

    public final Vector l(b bVar) {
        t.e(bVar, "key");
        try {
            return (Vector) new Gson().j(k(bVar), new SharedStorage$getVectorPreference$type$1().d());
        } catch (Exception unused) {
            return null;
        }
    }
}
