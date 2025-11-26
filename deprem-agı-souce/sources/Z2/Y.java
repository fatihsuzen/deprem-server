package z2;

import android.content.Context;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import com.mbridge.msdk.out.SDKInitStatusListener;
import com.mbridge.msdk.system.MBridgeSDKImpl;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.V;

public final class Y {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26526a = new a((C2633k) null);

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    private final void c(MBridgeSDK mBridgeSDK, Context context) {
        mBridgeSDK.init(mBridgeSDK.getMBConfigurationMap("288115", "7e5347690cfae30d311f1b31465c33f6"), context, (SDKInitStatusListener) new b());
    }

    public final void a(Context context, boolean z4) {
        t.e(context, "context");
        MBridgeSDKImpl mBridgeSDK = MBridgeSDKFactory.getMBridgeSDK();
        t.d(mBridgeSDK, "getMBridgeSDK(...)");
        mBridgeSDK.setConsentStatus(context, z4 ? 1 : 0);
    }

    public final void b(boolean z4) {
        MBridgeSDKImpl mBridgeSDK = MBridgeSDKFactory.getMBridgeSDK();
        t.d(mBridgeSDK, "getMBridgeSDK(...)");
        mBridgeSDK.setDoNotTrackStatus(z4);
    }

    public final void d(Context context) {
        t.e(context, "context");
        V h5 = V.f24870q.h(context);
        if (h5 == null || !h5.q()) {
            MBridgeSDKImpl mBridgeSDK = MBridgeSDKFactory.getMBridgeSDK();
            t.d(mBridgeSDK, "getMBridgeSDK(...)");
            c(mBridgeSDK, context);
        }
    }

    public static final class b implements SDKInitStatusListener {
        b() {
        }

        public void onInitFail(String str) {
            t.e(str, "errorMsg");
        }

        public void onInitSuccess() {
        }
    }
}
