package l2;

import java.util.ArrayList;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: l2.u  reason: case insensitive filesystem */
public final class C2671u {

    /* renamed from: e  reason: collision with root package name */
    public static final a f25197e = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private int f25198a;

    /* renamed from: b  reason: collision with root package name */
    private String f25199b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f25200c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private int f25201d;

    /* renamed from: l2.u$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final C2671u a(JSONObject jSONObject) {
            JSONArray optJSONArray;
            t.e(jSONObject, "jsonObject");
            C2671u uVar = new C2671u();
            if (!jSONObject.isNull("categoryID")) {
                uVar.f(jSONObject.optInt("categoryID"));
            }
            if (!jSONObject.isNull("categoryName")) {
                uVar.g(jSONObject.optString("categoryName"));
            }
            if (!jSONObject.isNull("categoryIcons") && (optJSONArray = jSONObject.optJSONArray("categoryIcons")) != null) {
                int length = optJSONArray.length();
                for (int i5 = 0; i5 < length; i5++) {
                    uVar.c().add(optJSONArray.optString(i5));
                }
            }
            if (!jSONObject.isNull("categoryAppsCount")) {
                uVar.e(jSONObject.optInt("categoryAppsCount"));
            }
            return uVar;
        }

        private a() {
        }
    }

    public final int a() {
        return this.f25201d;
    }

    public final int b() {
        return this.f25198a;
    }

    public final ArrayList c() {
        return this.f25200c;
    }

    public final String d() {
        return this.f25199b;
    }

    public final void e(int i5) {
        this.f25201d = i5;
    }

    public final void f(int i5) {
        this.f25198a = i5;
    }

    public final void g(String str) {
        this.f25199b = str;
    }
}
