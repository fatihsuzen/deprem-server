package T1;

import android.content.DialogInterface;
import com.uptodown.core.activities.InstallerActivity;
import java.util.ArrayList;

/* renamed from: T1.n0  reason: case insensitive filesystem */
public final /* synthetic */ class C2184n0 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f19156a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f19157b;

    public /* synthetic */ C2184n0(InstallerActivity installerActivity, ArrayList arrayList) {
        this.f19156a = installerActivity;
        this.f19157b = arrayList;
    }

    public final void onClick(DialogInterface dialogInterface, int i5) {
        InstallerActivity.B1(this.f19156a, this.f19157b, dialogInterface, i5);
    }
}
