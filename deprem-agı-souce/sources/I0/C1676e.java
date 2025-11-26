package i0;

import K.C0655b;
import Z.b;
import Z.c;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* renamed from: i0.e  reason: case insensitive filesystem */
public abstract class C1676e extends b implements f {
    public C1676e() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean q0(int i5, Parcel parcel, Parcel parcel2, int i6) {
        switch (i5) {
            case 3:
                C0655b bVar = (C0655b) c.a(parcel, C0655b.CREATOR);
                C1673b bVar2 = (C1673b) c.a(parcel, C1673b.CREATOR);
                c.b(parcel);
                break;
            case 4:
                Status status = (Status) c.a(parcel, Status.CREATOR);
                c.b(parcel);
                break;
            case 6:
                Status status2 = (Status) c.a(parcel, Status.CREATOR);
                c.b(parcel);
                break;
            case 7:
                Status status3 = (Status) c.a(parcel, Status.CREATOR);
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) c.a(parcel, GoogleSignInAccount.CREATOR);
                c.b(parcel);
                break;
            case 8:
                c.b(parcel);
                c0((l) c.a(parcel, l.CREATOR));
                break;
            case 9:
                h hVar = (h) c.a(parcel, h.CREATOR);
                c.b(parcel);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
