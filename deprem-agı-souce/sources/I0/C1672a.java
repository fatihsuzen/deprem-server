package i0;

import H.c;
import K.C0655b;
import K.C0665l;
import N.C0709c;
import N.C0710d;
import N.C0713g;
import N.C0722p;
import N.M;
import N.O;
import android.accounts.Account;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import h0.e;

/* renamed from: i0.a  reason: case insensitive filesystem */
public class C1672a extends C0713g implements e {

    /* renamed from: M  reason: collision with root package name */
    public static final /* synthetic */ int f15367M = 0;

    /* renamed from: I  reason: collision with root package name */
    private final boolean f15368I = true;

    /* renamed from: J  reason: collision with root package name */
    private final C0710d f15369J;

    /* renamed from: K  reason: collision with root package name */
    private final Bundle f15370K;

    /* renamed from: L  reason: collision with root package name */
    private final Integer f15371L;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1672a(android.content.Context r8, android.os.Looper r9, boolean r10, N.C0710d r11, android.os.Bundle r12, L.f.a r13, L.f.b r14) {
        /*
            r7 = this;
            r3 = 44
            r0 = r7
            r1 = r8
            r2 = r9
            r4 = r11
            r5 = r13
            r6 = r14
            r0.<init>((android.content.Context) r1, (android.os.Looper) r2, (int) r3, (N.C0710d) r4, (L.f.a) r5, (L.f.b) r6)
            r8 = 1
            r0.f15368I = r8
            r0.f15369J = r4
            r0.f15370K = r12
            java.lang.Integer r8 = r4.i()
            r0.f15371L = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.C1672a.<init>(android.content.Context, android.os.Looper, boolean, N.d, android.os.Bundle, L.f$a, L.f$b):void");
    }

    public static Bundle m0(C0710d dVar) {
        dVar.h();
        Integer i5 = dVar.i();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", dVar.a());
        if (i5 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", i5.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", (String) null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public final Bundle A() {
        if (!y().getPackageName().equals(this.f15369J.f())) {
            this.f15370K.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f15369J.f());
        }
        return this.f15370K;
    }

    /* access modifiers changed from: protected */
    public final String E() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    public final String F() {
        return "com.google.android.gms.signin.service.START";
    }

    public final void a(f fVar) {
        GoogleSignInAccount googleSignInAccount;
        C0722p.l(fVar, "Expecting a valid ISignInCallbacks");
        try {
            Account c5 = this.f15369J.c();
            if ("<<default account>>".equals(c5.name)) {
                googleSignInAccount = c.b(y()).c();
            } else {
                googleSignInAccount = null;
            }
            ((g) D()).q0(new j(1, new M(c5, ((Integer) C0722p.k(this.f15371L)).intValue(), googleSignInAccount)), fVar);
        } catch (RemoteException e5) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                fVar.c0(new l(1, new C0655b(8, (PendingIntent) null), (O) null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e5);
            }
        }
    }

    public final int k() {
        return C0665l.f2721a;
    }

    public final boolean o() {
        return this.f15368I;
    }

    public final void p() {
        e(new C0709c.d());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof g) {
            return (g) queryLocalInterface;
        }
        return new g(iBinder);
    }
}
