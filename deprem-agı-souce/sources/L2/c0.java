package l2;

import android.widget.RelativeLayout;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class c0 {

    /* renamed from: c  reason: collision with root package name */
    public static final a f24964c = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private int f24965a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f24966b;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public final int a() {
        return this.f24965a;
    }

    public final String b() {
        switch (this.f24965a) {
            case 1:
                return "welcome";
            case 2:
                return "deeplink";
            case 3:
                return "continue";
            case 4:
                return "permissions";
            case 5:
                return "login";
            case 6:
                return "kill";
            default:
                return "null";
        }
    }

    public final RelativeLayout c() {
        RelativeLayout relativeLayout = this.f24966b;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        t.w(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        return null;
    }

    public final void d(int i5) {
        this.f24965a = i5;
    }

    public final void e(RelativeLayout relativeLayout) {
        t.e(relativeLayout, "<set-?>");
        this.f24966b = relativeLayout;
    }
}
