package H;

import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public interface t extends IInterface {
    void R(Status status);

    void Z(Status status);

    void x(GoogleSignInAccount googleSignInAccount, Status status);
}
