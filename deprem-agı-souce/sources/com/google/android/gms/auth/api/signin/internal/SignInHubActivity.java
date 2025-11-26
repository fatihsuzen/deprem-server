package com.google.android.gms.auth.api.signin.internal;

import H.p;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;

@KeepName
public class SignInHubActivity extends FragmentActivity {

    /* renamed from: f  reason: collision with root package name */
    private static boolean f4837f = false;

    /* renamed from: a  reason: collision with root package name */
    private boolean f4838a = false;

    /* renamed from: b  reason: collision with root package name */
    private SignInConfiguration f4839b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4840c;

    /* renamed from: d  reason: collision with root package name */
    private int f4841d;

    /* renamed from: e  reason: collision with root package name */
    private Intent f4842e;

    private final void n(String str) {
        Intent intent = new Intent(str);
        if (str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
            intent.setPackage("com.google.android.gms");
        } else {
            intent.setPackage(getPackageName());
        }
        intent.putExtra("config", this.f4839b);
        try {
            startActivityForResult(intent, 40962);
        } catch (ActivityNotFoundException unused) {
            this.f4838a = true;
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            p(17);
        }
    }

    private final void o() {
        getSupportLoaderManager().initLoader(0, (Bundle) null, new a(this, (byte[]) null));
        f4837f = false;
    }

    private final void p(int i5) {
        Status status = new Status(i5);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        f4837f = false;
    }

    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int l() {
        return this.f4841d;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Intent m() {
        return this.f4842e;
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i5, int i6, Intent intent) {
        if (!this.f4838a) {
            setResult(0);
            if (i5 == 40962) {
                if (intent != null) {
                    SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
                    if (signInAccount != null && signInAccount.c() != null) {
                        GoogleSignInAccount c5 = signInAccount.c();
                        if (c5 == null) {
                            Log.e("AuthSignInClient", "Google account is null");
                            p(12500);
                            return;
                        }
                        p.a(this).c(this.f4839b.c(), c5);
                        intent.removeExtra("signInAccount");
                        intent.putExtra("googleSignInAccount", c5);
                        this.f4840c = true;
                        this.f4841d = i6;
                        this.f4842e = intent;
                        o();
                        return;
                    } else if (intent.hasExtra("errorCode")) {
                        int intExtra = intent.getIntExtra("errorCode", 8);
                        if (intExtra == 13) {
                            intExtra = 12501;
                        }
                        p(intExtra);
                        return;
                    }
                }
                p(8);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        if (action == null) {
            Log.e("AuthSignInClient", "Null action");
            p(12500);
        } else if (action.equals("com.google.android.gms.auth.NO_IMPL")) {
            Log.e("AuthSignInClient", "Action not implemented");
            p(12500);
        } else if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") || action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            Bundle bundleExtra = intent.getBundleExtra("config");
            if (bundleExtra == null) {
                Log.e("AuthSignInClient", "Activity started with no configuration.");
                setResult(0);
                finish();
                return;
            }
            SignInConfiguration signInConfiguration = (SignInConfiguration) bundleExtra.getParcelable("config");
            if (signInConfiguration == null) {
                Log.e("AuthSignInClient", "Activity started with invalid configuration.");
                setResult(0);
                finish();
                return;
            }
            this.f4839b = signInConfiguration;
            if (bundle != null) {
                boolean z4 = bundle.getBoolean("signingInGoogleApiClients");
                this.f4840c = z4;
                if (z4) {
                    this.f4841d = bundle.getInt("signInResultCode");
                    Intent intent2 = (Intent) bundle.getParcelable("signInResultData");
                    if (intent2 == null) {
                        Log.e("AuthSignInClient", "Sign in result data cannot be null");
                        setResult(0);
                        finish();
                        return;
                    }
                    this.f4842e = intent2;
                    o();
                }
            } else if (f4837f) {
                setResult(0);
                p(12502);
            } else {
                f4837f = true;
                n(action);
            }
        } else {
            Log.e("AuthSignInClient", "Unknown action: ".concat(String.valueOf(intent.getAction())));
            finish();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        f4837f = false;
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.f4840c);
        if (this.f4840c) {
            bundle.putInt("signInResultCode", this.f4841d);
            bundle.putParcelable("signInResultData", this.f4842e);
        }
    }
}
