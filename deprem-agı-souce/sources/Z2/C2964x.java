package z2;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.preferences.a;
import kotlin.jvm.internal.t;
import l2.M;
import l2.V;
import org.json.JSONObject;

/* renamed from: z2.x  reason: case insensitive filesystem */
public final class C2964x extends AbstractAccountAuthenticator {

    /* renamed from: a  reason: collision with root package name */
    private final Context f26563a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2964x(Context context) {
        super(context);
        t.e(context, "mContext");
        this.f26563a = context;
    }

    public Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) {
        Intent intent = new Intent(this.f26563a, LoginActivity.class);
        intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("intent", intent);
        return bundle2;
    }

    public Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) {
        t.e(accountAuthenticatorResponse, "response");
        t.e(account, "account");
        t.e(bundle, "options");
        return null;
    }

    public Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
        t.e(accountAuthenticatorResponse, "response");
        t.e(str, "accountType");
        return null;
    }

    public Bundle getAccountRemovalAllowed(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account) {
        t.e(accountAuthenticatorResponse, "response");
        t.e(account, "account");
        Bundle accountRemovalAllowed = super.getAccountRemovalAllowed(accountAuthenticatorResponse, account);
        if (accountRemovalAllowed != null && accountRemovalAllowed.containsKey("booleanResult") && !accountRemovalAllowed.containsKey("intent") && accountRemovalAllowed.getBoolean("booleanResult")) {
            V.f24870q.c(this.f26563a);
        }
        t.b(accountRemovalAllowed);
        return accountRemovalAllowed;
    }

    public Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        String password;
        t.e(accountAuthenticatorResponse, "response");
        t.e(account, "account");
        t.e(str, "authTokenType");
        t.e(bundle, "options");
        AccountManager accountManager = AccountManager.get(this.f26563a);
        String peekAuthToken = accountManager.peekAuthToken(account, str);
        if (TextUtils.isEmpty(peekAuthToken) && (password = accountManager.getPassword(account)) != null) {
            String str2 = account.name;
            t.d(str2, RewardPlus.NAME);
            M P02 = new Z(this.f26563a).P0(str2, password);
            if (!P02.b() && P02.e() != null) {
                JSONObject e5 = P02.e();
                t.b(e5);
                JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                if (optJSONObject != null) {
                    V v5 = new V();
                    v5.g(this.f26563a, optJSONObject);
                    if (v5.j() != null) {
                        String j5 = v5.j();
                        t.b(j5);
                        if (j5.length() > 0) {
                            v5.s(this.f26563a);
                        }
                    }
                    String L4 = a.f15150a.L(this.f26563a);
                    if (L4 == null || L4.length() == 0) {
                        V.f24870q.c(this.f26563a);
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(peekAuthToken)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("authAccount", account.name);
            bundle2.putString("accountType", account.type);
            bundle2.putString("authtoken", peekAuthToken);
            return bundle2;
        }
        Intent intent = new Intent(this.f26563a, LoginActivity.class);
        intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
        Bundle bundle3 = new Bundle();
        bundle3.putParcelable("intent", intent);
        return bundle3;
    }

    public String getAuthTokenLabel(String str) {
        t.e(str, "authTokenType");
        return "Uptodown login";
    }

    public Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) {
        t.e(accountAuthenticatorResponse, "response");
        t.e(account, "account");
        t.e(strArr, "features");
        return null;
    }

    public Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        t.e(accountAuthenticatorResponse, "response");
        t.e(account, "account");
        t.e(str, "authTokenType");
        t.e(bundle, "options");
        return null;
    }
}
