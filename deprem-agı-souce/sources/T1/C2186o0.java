package T1;

import android.content.DialogInterface;
import com.uptodown.core.activities.InstallerActivity;
import java.util.ArrayList;

/* renamed from: T1.o0  reason: case insensitive filesystem */
public final /* synthetic */ class C2186o0 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f19159a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f19160b;

    public /* synthetic */ C2186o0(InstallerActivity installerActivity, ArrayList arrayList) {
        this.f19159a = installerActivity;
        this.f19160b = arrayList;
    }

    public final void onClick(DialogInterface dialogInterface, int i5) {
        InstallerActivity.C1(this.f19159a, this.f19160b, dialogInterface, i5);
    }
}
