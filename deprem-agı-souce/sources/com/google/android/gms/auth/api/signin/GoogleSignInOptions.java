package com.google.android.gms.auth.api.signin;

import G.d;
import H.C0641a;
import H.C0642b;
import L.C0668a;
import N.C0722p;
import O.C0732a;
import O.C0734c;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class GoogleSignInOptions extends C0732a implements C0668a.d, ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new e();

    /* renamed from: l  reason: collision with root package name */
    public static final GoogleSignInOptions f4802l;

    /* renamed from: m  reason: collision with root package name */
    public static final GoogleSignInOptions f4803m;

    /* renamed from: n  reason: collision with root package name */
    public static final Scope f4804n = new Scope("profile");

    /* renamed from: o  reason: collision with root package name */
    public static final Scope f4805o = new Scope(NotificationCompat.CATEGORY_EMAIL);

    /* renamed from: p  reason: collision with root package name */
    public static final Scope f4806p = new Scope("openid");

    /* renamed from: q  reason: collision with root package name */
    public static final Scope f4807q;

    /* renamed from: r  reason: collision with root package name */
    public static final Scope f4808r = new Scope("https://www.googleapis.com/auth/games");

    /* renamed from: s  reason: collision with root package name */
    private static final Comparator f4809s = new d();

    /* renamed from: a  reason: collision with root package name */
    final int f4810a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f4811b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Account f4812c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f4813d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final boolean f4814e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final boolean f4815f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f4816g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f4817h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ArrayList f4818i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public String f4819j;

    /* renamed from: k  reason: collision with root package name */
    private Map f4820k;

    static {
        Scope scope = new Scope("https://www.googleapis.com/auth/games_lite");
        f4807q = scope;
        a aVar = new a();
        aVar.c();
        aVar.e();
        f4802l = aVar.a();
        a aVar2 = new a();
        aVar2.f(scope, new Scope[0]);
        f4803m = aVar2.a();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* synthetic */ GoogleSignInOptions(int r1, java.util.ArrayList r2, android.accounts.Account r3, boolean r4, boolean r5, boolean r6, java.lang.String r7, java.lang.String r8, java.util.Map r9, java.lang.String r10, G.d r11) {
        /*
            r0 = this;
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = 3
            r1 = r0
            r1.<init>((int) r2, (java.util.ArrayList) r3, (android.accounts.Account) r4, (boolean) r5, (boolean) r6, (boolean) r7, (java.lang.String) r8, (java.lang.String) r9, (java.util.Map) r10, (java.lang.String) r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.<init>(int, java.util.ArrayList, android.accounts.Account, boolean, boolean, boolean, java.lang.String, java.lang.String, java.util.Map, java.lang.String, G.d):void");
    }

    public static GoogleSignInOptions o(String str) {
        String str2;
        Account account;
        String str3;
        String str4 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i5 = 0; i5 < length; i5++) {
            hashSet.add(new Scope(jSONArray.getString(i5)));
        }
        if (jSONObject.has("accountName")) {
            str2 = jSONObject.optString("accountName");
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            account = new Account(str2, "com.google");
        } else {
            account = null;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        boolean z4 = jSONObject.getBoolean("idTokenRequested");
        boolean z5 = jSONObject.getBoolean("serverAuthRequested");
        boolean z6 = jSONObject.getBoolean("forceCodeForRefreshToken");
        if (jSONObject.has("serverClientId")) {
            str3 = jSONObject.optString("serverClientId");
        } else {
            str3 = null;
        }
        if (jSONObject.has("hostedDomain")) {
            str4 = jSONObject.optString("hostedDomain");
        }
        return new GoogleSignInOptions(3, arrayList, account, z4, z5, z6, str3, str4, (Map) new HashMap(), (String) null);
    }

    /* access modifiers changed from: private */
    public static Map z(List list) {
        HashMap hashMap = new HashMap();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C0641a aVar = (C0641a) it.next();
                hashMap.put(Integer.valueOf(aVar.c()), aVar);
            }
        }
        return hashMap;
    }

    public Account c() {
        return this.f4812c;
    }

    public ArrayList d() {
        return this.f4818i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (r1.equals(r4.c()) != false) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch:{ ClassCastException -> 0x0090 }
            java.util.ArrayList r1 = r3.f4818i     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.isEmpty()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 == 0) goto L_0x0090
            java.util.ArrayList r1 = r4.f4818i     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.isEmpty()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x0018
            goto L_0x0090
        L_0x0018:
            java.util.ArrayList r1 = r3.f4811b     // Catch:{ ClassCastException -> 0x0090 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0090 }
            java.util.ArrayList r2 = r4.g()     // Catch:{ ClassCastException -> 0x0090 }
            int r2 = r2.size()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            java.util.ArrayList r1 = r3.f4811b     // Catch:{ ClassCastException -> 0x0090 }
            java.util.ArrayList r2 = r4.g()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.containsAll(r2)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x0035
            goto L_0x0090
        L_0x0035:
            android.accounts.Account r1 = r3.f4812c     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x0040
            android.accounts.Account r1 = r4.c()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x0090
            goto L_0x004a
        L_0x0040:
            android.accounts.Account r2 = r4.c()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 == 0) goto L_0x0090
        L_0x004a:
            java.lang.String r1 = r3.f4816g     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 == 0) goto L_0x005d
            java.lang.String r1 = r4.i()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 == 0) goto L_0x0090
            goto L_0x006a
        L_0x005d:
            java.lang.String r1 = r3.f4816g     // Catch:{ ClassCastException -> 0x0090 }
            java.lang.String r2 = r4.i()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x006a
            goto L_0x0090
        L_0x006a:
            boolean r1 = r3.f4815f     // Catch:{ ClassCastException -> 0x0090 }
            boolean r2 = r4.j()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            boolean r1 = r3.f4813d     // Catch:{ ClassCastException -> 0x0090 }
            boolean r2 = r4.k()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            boolean r1 = r3.f4814e     // Catch:{ ClassCastException -> 0x0090 }
            boolean r2 = r4.l()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            java.lang.String r1 = r3.f4819j     // Catch:{ ClassCastException -> 0x0090 }
            java.lang.String r4 = r4.f()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r4 = android.text.TextUtils.equals(r1, r4)     // Catch:{ ClassCastException -> 0x0090 }
            if (r4 == 0) goto L_0x0090
            r4 = 1
            return r4
        L_0x0090:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public String f() {
        return this.f4819j;
    }

    public ArrayList g() {
        return new ArrayList(this.f4811b);
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f4811b;
        int size = arrayList2.size();
        for (int i5 = 0; i5 < size; i5++) {
            arrayList.add(((Scope) arrayList2.get(i5)).c());
        }
        Collections.sort(arrayList);
        C0642b bVar = new C0642b();
        bVar.a(arrayList);
        bVar.a(this.f4812c);
        bVar.a(this.f4816g);
        bVar.c(this.f4815f);
        bVar.c(this.f4813d);
        bVar.c(this.f4814e);
        bVar.a(this.f4819j);
        return bVar.b();
    }

    public String i() {
        return this.f4816g;
    }

    public boolean j() {
        return this.f4815f;
    }

    public boolean k() {
        return this.f4813d;
    }

    public boolean l() {
        return this.f4814e;
    }

    public final String s() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f4811b, f4809s);
            ArrayList arrayList = this.f4811b;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                jSONArray.put(((Scope) obj).c());
            }
            jSONObject.put("scopes", jSONArray);
            Account account = this.f4812c;
            if (account != null) {
                jSONObject.put("accountName", account.name);
            }
            jSONObject.put("idTokenRequested", this.f4813d);
            jSONObject.put("forceCodeForRefreshToken", this.f4815f);
            jSONObject.put("serverAuthRequested", this.f4814e);
            if (!TextUtils.isEmpty(this.f4816g)) {
                jSONObject.put("serverClientId", this.f4816g);
            }
            if (!TextUtils.isEmpty(this.f4817h)) {
                jSONObject.put("hostedDomain", this.f4817h);
            }
            return jSONObject.toString();
        } catch (JSONException e5) {
            throw new RuntimeException(e5);
        }
    }

    public void writeToParcel(Parcel parcel, int i5) {
        int i6 = this.f4810a;
        int a5 = C0734c.a(parcel);
        C0734c.j(parcel, 1, i6);
        C0734c.s(parcel, 2, g(), false);
        C0734c.o(parcel, 3, c(), i5, false);
        C0734c.c(parcel, 4, k());
        C0734c.c(parcel, 5, l());
        C0734c.c(parcel, 6, j());
        C0734c.p(parcel, 7, i(), false);
        C0734c.p(parcel, 8, this.f4817h, false);
        C0734c.s(parcel, 9, d(), false);
        C0734c.p(parcel, 10, f(), false);
        C0734c.b(parcel, a5);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Set f4821a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        private boolean f4822b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f4823c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f4824d;

        /* renamed from: e  reason: collision with root package name */
        private String f4825e;

        /* renamed from: f  reason: collision with root package name */
        private Account f4826f;

        /* renamed from: g  reason: collision with root package name */
        private String f4827g;

        /* renamed from: h  reason: collision with root package name */
        private Map f4828h = new HashMap();

        /* renamed from: i  reason: collision with root package name */
        private String f4829i;

        public a() {
        }

        private final String h(String str) {
            C0722p.e(str);
            String str2 = this.f4825e;
            boolean z4 = true;
            if (str2 != null && !str2.equals(str)) {
                z4 = false;
            }
            C0722p.b(z4, "two different server client ids provided");
            return str;
        }

        public GoogleSignInOptions a() {
            if (this.f4821a.contains(GoogleSignInOptions.f4808r)) {
                Set set = this.f4821a;
                Scope scope = GoogleSignInOptions.f4807q;
                if (set.contains(scope)) {
                    this.f4821a.remove(scope);
                }
            }
            if (this.f4824d && (this.f4826f == null || !this.f4821a.isEmpty())) {
                c();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.f4821a), this.f4826f, this.f4824d, this.f4822b, this.f4823c, this.f4825e, this.f4827g, this.f4828h, this.f4829i, (d) null);
        }

        public a b() {
            this.f4821a.add(GoogleSignInOptions.f4805o);
            return this;
        }

        public a c() {
            this.f4821a.add(GoogleSignInOptions.f4806p);
            return this;
        }

        public a d(String str) {
            this.f4824d = true;
            h(str);
            this.f4825e = str;
            return this;
        }

        public a e() {
            this.f4821a.add(GoogleSignInOptions.f4804n);
            return this;
        }

        public a f(Scope scope, Scope... scopeArr) {
            this.f4821a.add(scope);
            this.f4821a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public a g(String str) {
            this.f4829i = str;
            return this;
        }

        public a(GoogleSignInOptions googleSignInOptions) {
            C0722p.k(googleSignInOptions);
            this.f4821a = new HashSet(googleSignInOptions.f4811b);
            this.f4822b = googleSignInOptions.f4814e;
            this.f4823c = googleSignInOptions.f4815f;
            this.f4824d = googleSignInOptions.f4813d;
            this.f4825e = googleSignInOptions.f4816g;
            this.f4826f = googleSignInOptions.f4812c;
            this.f4827g = googleSignInOptions.f4817h;
            this.f4828h = GoogleSignInOptions.z(googleSignInOptions.f4818i);
            this.f4829i = googleSignInOptions.f4819j;
        }
    }

    GoogleSignInOptions(int i5, ArrayList arrayList, Account account, boolean z4, boolean z5, boolean z6, String str, String str2, ArrayList arrayList2, String str3) {
        this(i5, arrayList, account, z4, z5, z6, str, str2, z(arrayList2), str3);
    }

    private GoogleSignInOptions(int i5, ArrayList arrayList, Account account, boolean z4, boolean z5, boolean z6, String str, String str2, Map map, String str3) {
        this.f4810a = i5;
        this.f4811b = arrayList;
        this.f4812c = account;
        this.f4813d = z4;
        this.f4814e = z5;
        this.f4815f = z6;
        this.f4816g = str;
        this.f4817h = str2;
        this.f4818i = new ArrayList(map.values());
        this.f4820k = map;
        this.f4819j = str3;
    }
}
