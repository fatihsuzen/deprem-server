package T1;

import android.content.DialogInterface;
import com.uptodown.core.activities.InstallerActivity;
import java.io.File;

/* renamed from: T1.q0  reason: case insensitive filesystem */
public final /* synthetic */ class C2190q0 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f19165a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ File f19166b;

    public /* synthetic */ C2190q0(InstallerActivity installerActivity, File file) {
        this.f19165a = installerActivity;
        this.f19166b = file;
    }

    public final void onClick(DialogInterface dialogInterface, int i5) {
        InstallerActivity.A1(this.f19165a, this.f19166b, dialogInterface, i5);
    }
}
