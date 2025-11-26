package Y1;

import android.os.Build;
import b2.C2286f;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.File;
import kotlin.jvm.internal.t;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: Y1.d  reason: case insensitive filesystem */
public final class C2260d {

    /* renamed from: a  reason: collision with root package name */
    private File f20130a;

    /* renamed from: b  reason: collision with root package name */
    private String f20131b;

    /* renamed from: c  reason: collision with root package name */
    private String f20132c;

    /* renamed from: d  reason: collision with root package name */
    private String f20133d;

    /* renamed from: e  reason: collision with root package name */
    private long f20134e;

    /* renamed from: f  reason: collision with root package name */
    private String f20135f;

    private final void b(JSONObject jSONObject) {
        try {
            if (!jSONObject.isNull(RewardPlus.NAME)) {
                this.f20131b = jSONObject.getString(RewardPlus.NAME);
            }
            if (!jSONObject.isNull("sha256")) {
                this.f20132c = jSONObject.getString("sha256");
            }
            if (!jSONObject.isNull(RewardPlus.ICON)) {
                this.f20133d = jSONObject.getString(RewardPlus.ICON);
            }
            if (!jSONObject.isNull("size")) {
                this.f20134e = jSONObject.getLong("size");
            }
            if (!jSONObject.isNull("senderDeviceName")) {
                this.f20135f = jSONObject.getString("senderDeviceName");
            }
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
    }

    public final void a(File file) {
        t.e(file, "f");
        this.f20130a = file;
        this.f20131b = file.getName();
        this.f20132c = C2286f.f20690a.e(file.getAbsolutePath());
        this.f20134e = file.length();
        this.f20135f = Build.MANUFACTURER + ' ' + Build.MODEL;
    }

    public final void c(String str) {
        t.e(str, "json");
        b(new JSONObject(str));
    }

    public final File d() {
        return this.f20130a;
    }

    public final String e() {
        return this.f20131b;
    }

    public final String f() {
        return this.f20135f;
    }

    public final String g() {
        return this.f20132c;
    }

    public final long h() {
        return this.f20134e;
    }

    public final String i() {
        try {
            JSONObject jSONObject = new JSONObject();
            String str = this.f20131b;
            if (str != null) {
                jSONObject.put(RewardPlus.NAME, str);
            }
            String str2 = this.f20132c;
            if (str2 != null) {
                jSONObject.put("sha256", str2);
            }
            String str3 = this.f20133d;
            if (str3 != null) {
                jSONObject.put(RewardPlus.ICON, str3);
            }
            long j5 = this.f20134e;
            if (j5 > 0) {
                jSONObject.put("size", j5);
            }
            String str4 = this.f20135f;
            if (str4 != null) {
                jSONObject.put("senderDeviceName", str4);
            }
            return jSONObject.toString(2);
        } catch (JSONException e5) {
            e5.printStackTrace();
            return null;
        }
    }
}
