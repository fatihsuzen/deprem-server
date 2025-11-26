package l2;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: l2.D  reason: case insensitive filesystem */
public final class C2644D {

    /* renamed from: a  reason: collision with root package name */
    private long f24744a;

    /* renamed from: b  reason: collision with root package name */
    private String f24745b;

    /* renamed from: c  reason: collision with root package name */
    private String f24746c;

    /* renamed from: d  reason: collision with root package name */
    private String f24747d;

    /* renamed from: e  reason: collision with root package name */
    private String f24748e;

    /* renamed from: f  reason: collision with root package name */
    private String f24749f;

    /* renamed from: g  reason: collision with root package name */
    private String f24750g;

    /* renamed from: h  reason: collision with root package name */
    private String f24751h;

    /* renamed from: i  reason: collision with root package name */
    private String f24752i;

    /* renamed from: j  reason: collision with root package name */
    private long f24753j;

    /* renamed from: k  reason: collision with root package name */
    private C2657f f24754k;

    /* renamed from: l  reason: collision with root package name */
    private ArrayList f24755l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private ArrayList f24756m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private ArrayList f24757n = new ArrayList();

    public final String a() {
        return this.f24752i;
    }

    public final ArrayList b() {
        return this.f24756m;
    }

    public final String c() {
        return this.f24750g;
    }

    public final String d() {
        if (this.f24750g == null) {
            return null;
        }
        return this.f24750g + UptodownApp.f13477F.o() + ":webp";
    }

    public final String e() {
        return this.f24751h;
    }

    public final String f() {
        if (this.f24751h == null) {
            return null;
        }
        return this.f24751h + UptodownApp.f13477F.q() + ":webp";
    }

    public final ArrayList g() {
        return this.f24755l;
    }

    public final String h() {
        return this.f24748e;
    }

    public final C2657f i() {
        return this.f24754k;
    }

    public final ArrayList j() {
        return this.f24757n;
    }

    public final String k() {
        return this.f24745b;
    }

    public final String l() {
        return this.f24749f;
    }

    public final String m() {
        return this.f24747d;
    }

    public final String n() {
        return this.f24746c;
    }

    public final ArrayList o(JSONArray jSONArray) {
        t.e(jSONArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i5 = 0; i5 < length; i5++) {
            C2657f fVar = new C2657f();
            JSONObject optJSONObject = jSONArray.optJSONObject(i5);
            t.b(optJSONObject);
            C2657f.b(fVar, optJSONObject, (Context) null, 2, (Object) null);
            arrayList.add(fVar);
        }
        return arrayList;
    }

    public final void p(JSONObject jSONObject) {
        t.e(jSONObject, "jsonObject");
        JSONObject optJSONObject = jSONObject.optJSONObject("info");
        if (optJSONObject != null) {
            if (!optJSONObject.isNull(RewardPlus.NAME)) {
                this.f24745b = optJSONObject.optString(RewardPlus.NAME);
            }
            if (!optJSONObject.isNull("webpage")) {
                this.f24746c = optJSONObject.optString("webpage");
            }
            if (!optJSONObject.isNull("twitter")) {
                this.f24747d = optJSONObject.optString("twitter");
            }
            if (!optJSONObject.isNull("instagram")) {
                this.f24748e = optJSONObject.optString("instagram");
            }
            if (!optJSONObject.isNull("tiktok")) {
                this.f24749f = optJSONObject.optString("tiktok");
            }
            if (!optJSONObject.isNull("feature")) {
                this.f24750g = optJSONObject.optString("feature");
            }
            if (!optJSONObject.isNull(RewardPlus.ICON)) {
                this.f24751h = optJSONObject.optString(RewardPlus.ICON);
            }
            if (!optJSONObject.isNull("mainAppID")) {
                this.f24753j = optJSONObject.optLong("mainAppID");
            }
            if (!optJSONObject.isNull("organizationID")) {
                this.f24744a = optJSONObject.optLong("organizationID");
            }
            if (!optJSONObject.isNull("bio")) {
                this.f24752i = optJSONObject.optString("bio");
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mainApp");
        if (optJSONObject2 != null) {
            C2657f fVar = new C2657f();
            C2657f.b(fVar, optJSONObject2, (Context) null, 2, (Object) null);
            this.f24754k = fVar;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("importantApps");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i5 = 0; i5 < length; i5++) {
                C2657f fVar2 = new C2657f();
                JSONObject optJSONObject3 = optJSONArray.optJSONObject(i5);
                t.b(optJSONObject3);
                C2657f.b(fVar2, optJSONObject3, (Context) null, 2, (Object) null);
                arrayList.add(fVar2);
            }
            if (!arrayList.isEmpty()) {
                this.f24755l = arrayList;
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("carouselApps");
        if (optJSONArray2 != null) {
            ArrayList arrayList2 = new ArrayList();
            int length2 = optJSONArray2.length();
            for (int i6 = 0; i6 < length2; i6++) {
                C2657f fVar3 = new C2657f();
                JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i6);
                t.b(optJSONObject4);
                C2657f.b(fVar3, optJSONObject4, (Context) null, 2, (Object) null);
                arrayList2.add(fVar3);
            }
            if (!arrayList2.isEmpty()) {
                this.f24756m = arrayList2;
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("apps");
        if (optJSONArray3 != null) {
            ArrayList arrayList3 = new ArrayList();
            int length3 = optJSONArray3.length();
            for (int i7 = 0; i7 < length3; i7++) {
                C2657f fVar4 = new C2657f();
                JSONObject optJSONObject5 = optJSONArray3.optJSONObject(i7);
                t.b(optJSONObject5);
                C2657f.b(fVar4, optJSONObject5, (Context) null, 2, (Object) null);
                arrayList3.add(fVar4);
            }
            if (!arrayList3.isEmpty()) {
                this.f24757n = arrayList3;
            }
        }
    }

    public final void q(ArrayList arrayList) {
        t.e(arrayList, "<set-?>");
        this.f24757n = arrayList;
    }
}
