package l2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.work.WorkManager;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONObject;
import z2.I;

public final class V implements Parcelable {
    public static Parcelable.Creator<V> CREATOR = new a();

    /* renamed from: q  reason: collision with root package name */
    public static final b f24870q = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private String f24871a;

    /* renamed from: b  reason: collision with root package name */
    private String f24872b;

    /* renamed from: c  reason: collision with root package name */
    private String f24873c;

    /* renamed from: d  reason: collision with root package name */
    private String f24874d;

    /* renamed from: e  reason: collision with root package name */
    private String f24875e;

    /* renamed from: f  reason: collision with root package name */
    private long f24876f = -1;

    /* renamed from: g  reason: collision with root package name */
    private String f24877g = "type0";

    /* renamed from: h  reason: collision with root package name */
    private String f24878h;

    /* renamed from: i  reason: collision with root package name */
    private int f24879i;

    /* renamed from: j  reason: collision with root package name */
    private int f24880j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f24881k;

    /* renamed from: l  reason: collision with root package name */
    private int f24882l;

    /* renamed from: m  reason: collision with root package name */
    private String f24883m;

    /* renamed from: n  reason: collision with root package name */
    private String f24884n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f24885o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f24886p;

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public V createFromParcel(Parcel parcel) {
            t.e(parcel, "source");
            return new V(parcel);
        }

        /* renamed from: b */
        public V[] newArray(int i5) {
            return new V[i5];
        }
    }

    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        private final V a(JSONObject jSONObject) {
            boolean z4;
            V v5 = new V();
            if (!jSONObject.isNull("userID")) {
                v5.y(jSONObject.optString("userID"));
            }
            if (!jSONObject.isNull("username")) {
                v5.z(jSONObject.optString("username"));
            }
            if (!jSONObject.isNull("avatarURL")) {
                v5.u(jSONObject.optString("avatarURL"));
            }
            boolean z5 = false;
            if (!jSONObject.isNull("isTurbo")) {
                if (jSONObject.optInt("isTurbo") == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                v5.C(z4);
            }
            if (!jSONObject.isNull("usernameFormat")) {
                v5.D(jSONObject.optString("usernameFormat"));
            }
            if (!jSONObject.isNull("isAuthorVerified")) {
                if (jSONObject.optInt("isAuthorVerified") == 1) {
                    z5 = true;
                }
                v5.t(z5);
            }
            if (!jSONObject.isNull("following")) {
                v5.x(jSONObject.optInt("following"));
            }
            return v5;
        }

        public final void b(Context context) {
            t.e(context, "context");
            c(context);
            com.uptodown.activities.preferences.a.f15150a.s1(context, (String) null);
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.T("PreRegisterWorker", context)) {
                WorkManager.Companion.getInstance(context).cancelAllWorkByTag("PreRegisterWorker");
            }
            if (aVar.T("GetUserDataWorker", context)) {
                WorkManager.Companion.getInstance(context).cancelAllWorkByTag("GetUserDataWorker");
            }
            C2647G.f24762f.a(context);
            new I().f(context);
        }

        public final void c(Context context) {
            t.e(context, "context");
            SharedPreferences.Editor edit = context.getSharedPreferences("SharedPreferencesUser", 0).edit();
            edit.remove("user_id");
            edit.remove("user_email");
            edit.remove("user_name");
            edit.remove("user_picture");
            edit.remove("registered_timestamp");
            edit.remove("is_turbo");
            edit.remove("username_format");
            edit.remove("background_image");
            edit.apply();
            com.uptodown.activities.preferences.a.f15150a.u1(context, false);
        }

        public final String d(String str) {
            if (str == null) {
                return null;
            }
            return str + UptodownApp.f13477F.q() + ":webp";
        }

        public final String e(String str) {
            if (str == null) {
                return null;
            }
            return str + UptodownApp.f13477F.r() + ":webp";
        }

        public final String f(String str) {
            if (str == null) {
                return null;
            }
            return str + UptodownApp.f13477F.j() + ":webp";
        }

        public final ArrayList g(JSONArray jSONArray) {
            t.e(jSONArray, "jsonArray");
            ArrayList arrayList = new ArrayList();
            try {
                int length = jSONArray.length();
                for (int i5 = 0; i5 < length; i5++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i5);
                    t.d(optJSONObject, "optJSONObject(...)");
                    arrayList.add(a(optJSONObject));
                }
                return arrayList;
            } catch (Exception e5) {
                e5.printStackTrace();
                return arrayList;
            }
        }

        public final V h(Context context) {
            V v5;
            t.e(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("SharedPreferencesUser", 0);
            if (sharedPreferences.contains("user_id")) {
                v5 = new V();
                v5.y(sharedPreferences.getString("user_id", (String) null));
            } else {
                v5 = null;
            }
            if (sharedPreferences.contains("user_email")) {
                if (v5 == null) {
                    v5 = new V();
                }
                v5.w(sharedPreferences.getString("user_email", (String) null));
            }
            if (sharedPreferences.contains("user_name")) {
                if (v5 == null) {
                    v5 = new V();
                }
                v5.z(sharedPreferences.getString("user_name", (String) null));
            }
            if (v5 != null) {
                if (sharedPreferences.contains("user_picture")) {
                    v5.u(sharedPreferences.getString("user_picture", (String) null));
                }
                if (sharedPreferences.contains("registered_timestamp")) {
                    v5.A(sharedPreferences.getLong("registered_timestamp", -1));
                }
                if (sharedPreferences.contains("is_turbo")) {
                    v5.B(sharedPreferences.getString("is_turbo", (String) null));
                }
                if (sharedPreferences.contains("username_format")) {
                    v5.D(sharedPreferences.getString("username_format", "type0"));
                }
                if (sharedPreferences.contains("background_image")) {
                    v5.v(sharedPreferences.getString("background_image", (String) null));
                }
            }
            return v5;
        }

        private b() {
        }
    }

    public V() {
    }

    public final void A(long j5) {
        this.f24876f = j5;
    }

    public final void B(String str) {
        this.f24884n = str;
    }

    public final void C(boolean z4) {
        this.f24885o = z4;
    }

    public final void D(String str) {
        this.f24877g = str;
    }

    public final String a() {
        return this.f24873c;
    }

    public final String b() {
        if (this.f24873c == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str = this.f24873c;
        t.b(str);
        sb.append(str);
        sb.append(UptodownApp.f13477F.i());
        sb.append(":webp");
        return sb.toString();
    }

    public final String c() {
        return f24870q.f(this.f24873c);
    }

    public final String d() {
        return this.f24878h;
    }

    public int describeContents() {
        return hashCode();
    }

    public final int e() {
        return this.f24881k;
    }

    public final int f() {
        return this.f24882l;
    }

    public final void g(Context context, JSONObject jSONObject) {
        t.e(context, "context");
        t.e(jSONObject, "jsonObject");
        JSONObject optJSONObject = jSONObject.optJSONObject("udata");
        if (optJSONObject != null) {
            if (!optJSONObject.isNull("id")) {
                this.f24871a = optJSONObject.optString("id");
            }
            if (!optJSONObject.isNull("username")) {
                this.f24874d = optJSONObject.optString("username");
            }
            if (!optJSONObject.isNull("avatar")) {
                this.f24873c = optJSONObject.optString("avatar");
            }
            if (!optJSONObject.isNull("registeredTimestamp")) {
                this.f24876f = optJSONObject.optLong("registeredTimestamp");
            }
            if (!optJSONObject.isNull("usernameFormat")) {
                this.f24877g = optJSONObject.optString("usernameFormat");
            }
            if (!optJSONObject.isNull("backgroundImage")) {
                this.f24878h = optJSONObject.optString("backgroundImage");
            }
        }
        if (!jSONObject.isNull("utoken")) {
            com.uptodown.activities.preferences.a.f15150a.s1(context, jSONObject.optString("utoken"));
        } else {
            f24870q.c(context);
        }
        if (!jSONObject.isNull("turboToken")) {
            this.f24884n = jSONObject.optString("turboToken");
        }
    }

    public final String h() {
        return this.f24872b;
    }

    public final int i() {
        return this.f24880j;
    }

    public final String j() {
        return this.f24871a;
    }

    public final String k() {
        return this.f24874d;
    }

    public final String l() {
        return this.f24883m;
    }

    public final int m() {
        return this.f24879i;
    }

    public final void n(JSONObject jSONObject) {
        t.e(jSONObject, "jsonObject");
        if (!jSONObject.isNull("userID")) {
            this.f24871a = jSONObject.optString("userID");
        }
        if (!jSONObject.isNull("username")) {
            this.f24874d = jSONObject.optString("username");
        }
        if (!jSONObject.isNull("registeredTimeAgo")) {
            this.f24883m = jSONObject.optString("registeredTimeAgo");
        }
        if (!jSONObject.isNull("avatar")) {
            this.f24873c = jSONObject.optString("avatar");
        }
        if (!jSONObject.isNull("isTurbo")) {
            boolean z4 = true;
            if (jSONObject.optInt("isTurbo") != 1) {
                z4 = false;
            }
            this.f24885o = z4;
        }
        if (!jSONObject.isNull("usernameFormat")) {
            this.f24877g = jSONObject.optString("usernameFormat");
        }
        if (!jSONObject.isNull("reviewsCount")) {
            this.f24879i = jSONObject.optInt("reviewsCount");
        }
        if (!jSONObject.isNull("backgroundImage")) {
            this.f24878h = jSONObject.optString("backgroundImage");
        }
        if (!jSONObject.isNull("following")) {
            this.f24880j = jSONObject.optInt("following");
        }
        if (!jSONObject.isNull("countFollowers")) {
            this.f24881k = jSONObject.optInt("countFollowers");
        }
        if (!jSONObject.isNull("countFollowings")) {
            this.f24882l = jSONObject.optInt("countFollowings");
        }
    }

    public final String o() {
        return this.f24877g;
    }

    public final boolean p(Context context) {
        t.e(context, "context");
        if (com.uptodown.activities.preferences.a.f15150a.L(context) != null) {
            return true;
        }
        return false;
    }

    public final boolean q() {
        String str = this.f24884n;
        if ((str == null || str.length() == 0) && !this.f24885o) {
            return false;
        }
        return true;
    }

    public final boolean r() {
        return this.f24885o;
    }

    public final void s(Context context) {
        t.e(context, "context");
        SharedPreferences.Editor edit = context.getSharedPreferences("SharedPreferencesUser", 0).edit();
        edit.putString("user_id", this.f24871a);
        edit.putString("user_email", this.f24872b);
        edit.putString("user_picture", this.f24873c);
        edit.putString("user_name", this.f24874d);
        edit.putLong("registered_timestamp", this.f24876f);
        edit.putString("is_turbo", this.f24884n);
        edit.putString("username_format", this.f24877g);
        edit.putString("background_image", this.f24878h);
        edit.apply();
    }

    public final void t(boolean z4) {
        this.f24886p = z4;
    }

    public final void u(String str) {
        this.f24873c = str;
    }

    public final void v(String str) {
        this.f24878h = str;
    }

    public final void w(String str) {
        this.f24872b = str;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeString(this.f24871a);
        parcel.writeString(this.f24872b);
        parcel.writeString(this.f24873c);
        parcel.writeString(this.f24874d);
        parcel.writeString(this.f24875e);
        parcel.writeString(this.f24884n);
        parcel.writeString(this.f24877g);
        parcel.writeLong(this.f24876f);
        parcel.writeString(this.f24878h);
        if (this.f24885o) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.f24879i);
        parcel.writeString(this.f24883m);
        parcel.writeInt(this.f24880j);
        parcel.writeInt(this.f24881k);
        parcel.writeInt(this.f24882l);
        if (this.f24885o) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
        }
    }

    public final void x(int i5) {
        this.f24880j = i5;
    }

    public final void y(String str) {
        this.f24871a = str;
    }

    public final void z(String str) {
        this.f24874d = str;
    }

    public V(Parcel parcel) {
        t.e(parcel, "source");
        this.f24871a = parcel.readString();
        this.f24872b = parcel.readString();
        this.f24873c = parcel.readString();
        this.f24874d = parcel.readString();
        this.f24875e = parcel.readString();
        this.f24884n = parcel.readString();
        this.f24877g = parcel.readString();
        this.f24876f = parcel.readLong();
        this.f24878h = parcel.readString();
        boolean z4 = false;
        this.f24885o = parcel.readInt() == 1;
        this.f24879i = parcel.readInt();
        this.f24883m = parcel.readString();
        this.f24880j = parcel.readInt();
        this.f24881k = parcel.readInt();
        this.f24882l = parcel.readInt();
        this.f24886p = parcel.readInt() == 1 ? true : z4;
    }
}
