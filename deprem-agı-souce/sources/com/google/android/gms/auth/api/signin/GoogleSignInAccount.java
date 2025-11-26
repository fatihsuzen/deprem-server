package com.google.android.gms.auth.api.signin;

import G.c;
import N.C0722p;
import O.C0732a;
import O.C0734c;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class GoogleSignInAccount extends C0732a implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new c();

    /* renamed from: n  reason: collision with root package name */
    public static final d f4788n = g.b();

    /* renamed from: a  reason: collision with root package name */
    final int f4789a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4790b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4791c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4792d;

    /* renamed from: e  reason: collision with root package name */
    private final String f4793e;

    /* renamed from: f  reason: collision with root package name */
    private final Uri f4794f;

    /* renamed from: g  reason: collision with root package name */
    private String f4795g;

    /* renamed from: h  reason: collision with root package name */
    private final long f4796h;

    /* renamed from: i  reason: collision with root package name */
    private final String f4797i;

    /* renamed from: j  reason: collision with root package name */
    final List f4798j;

    /* renamed from: k  reason: collision with root package name */
    private final String f4799k;

    /* renamed from: l  reason: collision with root package name */
    private final String f4800l;

    /* renamed from: m  reason: collision with root package name */
    private final Set f4801m = new HashSet();

    GoogleSignInAccount(int i5, String str, String str2, String str3, String str4, Uri uri, String str5, long j5, String str6, List list, String str7, String str8) {
        this.f4789a = i5;
        this.f4790b = str;
        this.f4791c = str2;
        this.f4792d = str3;
        this.f4793e = str4;
        this.f4794f = uri;
        this.f4795g = str5;
        this.f4796h = j5;
        this.f4797i = str6;
        this.f4798j = list;
        this.f4799k = str7;
        this.f4800l = str8;
    }

    public static GoogleSignInAccount o(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l5, String str7, Set set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, (String) null, l5.longValue(), C0722p.e(str7), new ArrayList((Collection) C0722p.k(set)), str5, str6);
    }

    public static GoogleSignInAccount p(String str) {
        Uri uri;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        if (!TextUtils.isEmpty(optString)) {
            uri = Uri.parse(optString);
        } else {
            uri = null;
        }
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i5 = 0; i5 < length; i5++) {
            hashSet.add(new Scope(jSONArray.getString(i5)));
        }
        String optString2 = jSONObject.optString("id");
        if (jSONObject.has("tokenId")) {
            str2 = jSONObject.optString("tokenId");
        } else {
            str2 = null;
        }
        if (jSONObject.has(NotificationCompat.CATEGORY_EMAIL)) {
            str3 = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
        } else {
            str3 = null;
        }
        if (jSONObject.has("displayName")) {
            str4 = jSONObject.optString("displayName");
        } else {
            str4 = null;
        }
        if (jSONObject.has("givenName")) {
            str5 = jSONObject.optString("givenName");
        } else {
            str5 = null;
        }
        if (jSONObject.has("familyName")) {
            str6 = jSONObject.optString("familyName");
        } else {
            str6 = null;
        }
        GoogleSignInAccount o5 = o(optString2, str2, str3, str4, str5, str6, uri, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        if (jSONObject.has("serverAuthCode")) {
            str7 = jSONObject.optString("serverAuthCode");
        }
        o5.f4795g = str7;
        return o5;
    }

    public String c() {
        return this.f4793e;
    }

    public String d() {
        return this.f4792d;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (!googleSignInAccount.f4797i.equals(this.f4797i) || !googleSignInAccount.l().equals(l())) {
            return false;
        }
        return true;
    }

    public String f() {
        return this.f4800l;
    }

    public String g() {
        return this.f4799k;
    }

    public int hashCode() {
        return ((this.f4797i.hashCode() + 527) * 31) + l().hashCode();
    }

    public String i() {
        return this.f4790b;
    }

    public String j() {
        return this.f4791c;
    }

    public Uri k() {
        return this.f4794f;
    }

    public Set l() {
        HashSet hashSet = new HashSet(this.f4798j);
        hashSet.addAll(this.f4801m);
        return hashSet;
    }

    public String n() {
        return this.f4795g;
    }

    public final String q() {
        return this.f4797i;
    }

    public final String r() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (i() != null) {
                jSONObject.put("id", i());
            }
            if (j() != null) {
                jSONObject.put("tokenId", j());
            }
            if (d() != null) {
                jSONObject.put(NotificationCompat.CATEGORY_EMAIL, d());
            }
            if (c() != null) {
                jSONObject.put("displayName", c());
            }
            if (g() != null) {
                jSONObject.put("givenName", g());
            }
            if (f() != null) {
                jSONObject.put("familyName", f());
            }
            Uri k5 = k();
            if (k5 != null) {
                jSONObject.put("photoUrl", k5.toString());
            }
            if (n() != null) {
                jSONObject.put("serverAuthCode", n());
            }
            jSONObject.put("expirationTime", this.f4796h);
            jSONObject.put("obfuscatedIdentifier", this.f4797i);
            JSONArray jSONArray = new JSONArray();
            List list = this.f4798j;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, c.f2469a);
            for (Scope c5 : scopeArr) {
                jSONArray.put(c5.c());
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove("serverAuthCode");
            return jSONObject.toString();
        } catch (JSONException e5) {
            throw new RuntimeException(e5);
        }
    }

    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = C0734c.a(parcel);
        C0734c.j(parcel, 1, this.f4789a);
        C0734c.p(parcel, 2, i(), false);
        C0734c.p(parcel, 3, j(), false);
        C0734c.p(parcel, 4, d(), false);
        C0734c.p(parcel, 5, c(), false);
        C0734c.o(parcel, 6, k(), i5, false);
        C0734c.p(parcel, 7, n(), false);
        C0734c.m(parcel, 8, this.f4796h);
        C0734c.p(parcel, 9, this.f4797i, false);
        C0734c.s(parcel, 10, this.f4798j, false);
        C0734c.p(parcel, 11, g(), false);
        C0734c.p(parcel, 12, f(), false);
        C0734c.b(parcel, a5);
    }
}
