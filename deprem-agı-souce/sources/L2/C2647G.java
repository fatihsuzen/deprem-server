package l2;

import android.content.Context;
import android.database.Cursor;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.json.JSONObject;
import z2.C2940B;

/* renamed from: l2.G  reason: case insensitive filesystem */
public final class C2647G {

    /* renamed from: f  reason: collision with root package name */
    public static final a f24762f = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private long f24763a;

    /* renamed from: b  reason: collision with root package name */
    private String f24764b;

    /* renamed from: c  reason: collision with root package name */
    private String f24765c;

    /* renamed from: d  reason: collision with root package name */
    private String f24766d;

    /* renamed from: e  reason: collision with root package name */
    private int f24767e;

    /* renamed from: l2.G$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final void a(Context context) {
            t.e(context, "context");
            C2940B a5 = C2940B.f26458v.a(context);
            a5.a();
            a5.o1();
            a5.m();
        }

        public final C2647G b(JSONObject jSONObject) {
            t.e(jSONObject, "jsonObjectData");
            C2647G g5 = new C2647G();
            g5.h(jSONObject);
            return g5;
        }

        public final C2647G c(Cursor cursor) {
            t.e(cursor, "c");
            C2647G g5 = new C2647G();
            g5.k(cursor.getLong(0));
            g5.l(cursor.getInt(1));
            return g5;
        }

        private a() {
        }
    }

    public C2647G(long j5, String str, String str2, boolean z4) {
        t.e(str, RewardPlus.NAME);
        this.f24763a = j5;
        this.f24764b = str;
        this.f24765c = str2;
        if (z4) {
            this.f24767e = 1;
        } else {
            this.f24767e = 0;
        }
    }

    /* access modifiers changed from: private */
    public final void h(JSONObject jSONObject) {
        if (!jSONObject.isNull("appID")) {
            this.f24763a = jSONObject.optLong("appID");
        }
        if (!jSONObject.isNull(RewardPlus.NAME)) {
            this.f24764b = jSONObject.optString(RewardPlus.NAME);
        }
        if (!jSONObject.isNull("iconURL")) {
            this.f24765c = jSONObject.optString("iconURL");
        }
        if (!jSONObject.isNull("authorName")) {
            this.f24766d = jSONObject.optString("authorName");
        }
    }

    public final long b() {
        return this.f24763a;
    }

    public final String c() {
        return this.f24766d;
    }

    public final int d() {
        return this.f24767e;
    }

    public final String e() {
        return this.f24765c;
    }

    public final String f() {
        return this.f24764b;
    }

    public final void g(Cursor cursor) {
        t.e(cursor, "c");
        this.f24763a = cursor.getLong(0);
        this.f24767e = cursor.getInt(1);
    }

    public final void i(Context context) {
        t.e(context, "context");
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        if (a5.y0(this.f24763a) == null) {
            a5.X0(this);
        }
        a5.m();
    }

    public final void j(Context context) {
        t.e(context, "context");
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        a5.q1(this.f24763a);
        a5.m();
    }

    public final void k(long j5) {
        this.f24763a = j5;
    }

    public final void l(int i5) {
        this.f24767e = i5;
    }

    public final void m(String str) {
        this.f24765c = str;
    }

    public final void n(String str) {
        this.f24764b = str;
    }

    public String toString() {
        return "PreRegister(appID=" + this.f24763a + ", name=" + this.f24764b + ", icon=" + this.f24765c + ", authorName=" + this.f24766d + ", automaticDownload=" + this.f24767e + ')';
    }

    public C2647G() {
    }
}
