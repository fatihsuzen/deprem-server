package T1;

import android.content.DialogInterface;
import com.uptodown.core.activities.InstallerActivity;
import java.io.File;

/* renamed from: T1.p0  reason: case insensitive filesystem */
public final /* synthetic */ class C2188p0 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f19162a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ File f19163b;

    public /* synthetic */ C2188p0(InstallerActivity installerActivity, File file) {
        this.f19162a = installerActivity;
        this.f19163b = file;
    }

    public final void onClick(DialogInterface dialogInterface, int i5) {
        InstallerActivity.z1(this.f19162a, this.f19163b, dialogInterface, i5);
    }
}
