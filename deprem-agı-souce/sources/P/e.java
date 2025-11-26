package P;

import K.C0657d;
import M.C0684d;
import M.C0691k;
import N.C0710d;
import N.C0713g;
import N.C0728w;
import Z.d;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public final class e extends C0713g {

    /* renamed from: I  reason: collision with root package name */
    private final C0728w f3869I;

    public e(Context context, Looper looper, C0710d dVar, C0728w wVar, C0684d dVar2, C0691k kVar) {
        super(context, looper, (int) SubsamplingScaleImageView.ORIENTATION_270, dVar, dVar2, kVar);
        this.f3869I = wVar;
    }

    /* access modifiers changed from: protected */
    public final Bundle A() {
        return this.f3869I.b();
    }

    /* access modifiers changed from: protected */
    public final String E() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    /* access modifiers changed from: protected */
    public final String F() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    /* access modifiers changed from: protected */
    public final boolean I() {
        return true;
    }

    public final int k() {
        return 203400000;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        if (queryLocalInterface instanceof a) {
            return (a) queryLocalInterface;
        }
        return new a(iBinder);
    }

    public final C0657d[] v() {
        return d.f4495b;
    }
}
