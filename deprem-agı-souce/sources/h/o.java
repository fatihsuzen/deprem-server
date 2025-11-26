package H;

import G.b;
import L.f;
import L.g;
import L.h;
import M.C0685e;
import Q.a;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.common.api.Status;

public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    private static final a f2500a = new a("GoogleSignInCommon", new String[0]);

    public static Intent a(Context context, GoogleSignInOptions googleSignInOptions) {
        f2500a.a("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }

    public static Intent b(Context context, GoogleSignInOptions googleSignInOptions) {
        f2500a.a("getFallbackSignInIntent()", new Object[0]);
        Intent a5 = a(context, googleSignInOptions);
        a5.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
        return a5;
    }

    public static Intent c(Context context, GoogleSignInOptions googleSignInOptions) {
        f2500a.a("getNoImplementationSignInIntent()", new Object[0]);
        Intent a5 = a(context, googleSignInOptions);
        a5.setAction("com.google.android.gms.auth.NO_IMPL");
        return a5;
    }

    public static g d(f fVar, Context context, boolean z4) {
        f2500a.a("Signing out", new Object[0]);
        g(context);
        if (z4) {
            return h.b(Status.f4849f, fVar);
        }
        return fVar.a(new k(fVar));
    }

    public static g e(f fVar, Context context, boolean z4) {
        f2500a.a("Revoking access", new Object[0]);
        String e5 = c.b(context).e();
        g(context);
        if (z4) {
            return f.a(e5);
        }
        return fVar.a(new m(fVar));
    }

    public static b f(Intent intent) {
        if (intent == null) {
            return new b((GoogleSignInAccount) null, Status.f4851h);
        }
        Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
        if (googleSignInAccount != null) {
            return new b(googleSignInAccount, Status.f4849f);
        }
        if (status == null) {
            status = Status.f4851h;
        }
        return new b((GoogleSignInAccount) null, status);
    }

    private static void g(Context context) {
        p.a(context).b();
        for (f e5 : f.b()) {
            e5.e();
        }
        C0685e.a();
    }
}
