package J1;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final b f2664b = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f2665a;

    /* renamed from: J1.a$a  reason: collision with other inner class name */
    public static final class C0046a {

        /* renamed from: b  reason: collision with root package name */
        public static final C0047a f2666b = new C0047a((C2633k) null);

        /* renamed from: a  reason: collision with root package name */
        private final JSONObject f2667a = new JSONObject();

        /* renamed from: J1.a$a$a  reason: collision with other inner class name */
        public static final class C0047a {
            public /* synthetic */ C0047a(C2633k kVar) {
                this();
            }

            private C0047a() {
            }
        }

        public C0046a(Context context) {
            t.e(context, "context");
            a("autoplay", 0);
            a(CampaignEx.JSON_NATIVE_VIDEO_MUTE, 0);
            a("controls", 0);
            a("enablejsapi", 1);
            a("fs", 0);
            b(TtmlNode.ATTR_TTS_ORIGIN, "https://" + context.getPackageName());
            a("rel", 0);
            a("iv_load_policy", 3);
            a("cc_load_policy", 0);
        }

        private final void a(String str, int i5) {
            try {
                this.f2667a.put(str, i5);
            } catch (JSONException unused) {
                throw new RuntimeException("Illegal JSON value " + str + ": " + i5);
            }
        }

        private final void b(String str, String str2) {
            try {
                this.f2667a.put(str, str2);
            } catch (JSONException unused) {
                throw new RuntimeException("Illegal JSON value " + str + ": " + str2);
            }
        }

        public final a c() {
            return new a(this.f2667a, (C2633k) null);
        }

        public final C0046a d(int i5) {
            a("cc_load_policy", i5);
            return this;
        }

        public final C0046a e(int i5) {
            a("controls", i5);
            return this;
        }

        public final C0046a f(int i5) {
            a("fs", i5);
            return this;
        }

        public final C0046a g(int i5) {
            a("iv_load_policy", i5);
            return this;
        }

        public final C0046a h(int i5) {
            a("rel", i5);
            return this;
        }
    }

    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        public final a a(Context context) {
            t.e(context, "context");
            return new C0046a(context).e(1).c();
        }

        private b() {
        }
    }

    public /* synthetic */ a(JSONObject jSONObject, C2633k kVar) {
        this(jSONObject);
    }

    public final String a() {
        String string = this.f2665a.getString(TtmlNode.ATTR_TTS_ORIGIN);
        t.d(string, "getString(...)");
        return string;
    }

    public String toString() {
        String jSONObject = this.f2665a.toString();
        t.d(jSONObject, "toString(...)");
        return jSONObject;
    }

    private a(JSONObject jSONObject) {
        this.f2665a = jSONObject;
    }
}
