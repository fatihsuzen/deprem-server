package G;

import L.j;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public class b implements j {

    /* renamed from: a  reason: collision with root package name */
    private final Status f2467a;

    /* renamed from: b  reason: collision with root package name */
    private final GoogleSignInAccount f2468b;

    public b(GoogleSignInAccount googleSignInAccount, Status status) {
        this.f2468b = googleSignInAccount;
        this.f2467a = status;
    }

    public GoogleSignInAccount a() {
        return this.f2468b;
    }

    public Status getStatus() {
        return this.f2467a;
    }
}
