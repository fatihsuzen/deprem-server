package T1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.core.activities.FileExplorerActivity;

/* renamed from: T1.z  reason: case insensitive filesystem */
public final /* synthetic */ class C2200z implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f19200a;

    public /* synthetic */ C2200z(FileExplorerActivity fileExplorerActivity) {
        this.f19200a = fileExplorerActivity;
    }

    public final void onActivityResult(Object obj) {
        FileExplorerActivity.L4(this.f19200a, (ActivityResult) obj);
    }
}
