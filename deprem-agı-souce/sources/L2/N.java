package l2;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.uptodown.UptodownApp;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.json.JSONObject;
import t3.s;

public final class N {

    /* renamed from: e  reason: collision with root package name */
    public static final a f24809e = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f24810a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24811b;

    /* renamed from: c  reason: collision with root package name */
    private int f24812c = -1;

    /* renamed from: d  reason: collision with root package name */
    private long f24813d = System.currentTimeMillis();

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public N(String str, String str2) {
        t.e(str, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        t.e(str2, "json");
        this.f24810a = str;
        this.f24811b = str2;
    }

    private final int f() {
        if (UptodownApp.f13477F.K()) {
            return MBridgeCommon.DEFAULT_LOAD_TIMEOUT;
        }
        if (s.E(this.f24810a, "new_releases", true) || s.E(this.f24810a, "last_updates", true)) {
            return 600000;
        }
        return 1800000;
    }

    public final boolean a() {
        if (System.currentTimeMillis() - this.f24813d < ((long) f())) {
            return true;
        }
        return false;
    }

    public final String b() {
        return this.f24811b;
    }

    public final M c() {
        M m5 = new M();
        m5.i(this.f24811b);
        m5.k(200);
        m5.j(new JSONObject(this.f24811b));
        return m5;
    }

    public final long d() {
        return this.f24813d;
    }

    public final String e() {
        return this.f24810a;
    }

    public final void g(int i5) {
        this.f24812c = i5;
    }

    public final void h(long j5) {
        this.f24813d = j5;
    }
}
