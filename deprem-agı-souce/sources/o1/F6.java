package O1;

import com.uptodown.activities.UserDeviceDetailsActivity;
import h2.C2450z;
import l2.X;

public final /* synthetic */ class F6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ X f3256a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2450z f3257b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UserDeviceDetailsActivity f3258c;

    public /* synthetic */ F6(X x4, C2450z zVar, UserDeviceDetailsActivity userDeviceDetailsActivity) {
        this.f3256a = x4;
        this.f3257b = zVar;
        this.f3258c = userDeviceDetailsActivity;
    }

    public final void run() {
        UserDeviceDetailsActivity.y3(this.f3256a, this.f3257b, this.f3258c);
    }
}
