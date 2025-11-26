package H;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.a;
import com.google.android.gms.auth.api.signin.b;
import com.google.android.gms.common.util.p;

public final class v extends q {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2505a;

    public v(Context context) {
        this.f2505a = context;
    }

    private final void j() {
        if (!p.a(this.f2505a, Binder.getCallingUid())) {
            int callingUid = Binder.getCallingUid();
            StringBuilder sb = new StringBuilder(String.valueOf(callingUid).length() + 41);
            sb.append("Calling UID ");
            sb.append(callingUid);
            sb.append(" is not Google Play services.");
            throw new SecurityException(sb.toString());
        }
    }

    public final void q() {
        j();
        Context context = this.f2505a;
        c b5 = c.b(context);
        GoogleSignInAccount c5 = b5.c();
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.f4802l;
        if (c5 != null) {
            googleSignInOptions = b5.d();
        }
        b a5 = a.a(context, googleSignInOptions);
        if (c5 != null) {
            a5.r();
        } else {
            a5.s();
        }
    }

    public final void u() {
        j();
        p.a(this.f2505a).b();
    }
}
