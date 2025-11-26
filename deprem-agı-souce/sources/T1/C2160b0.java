package T1;

import android.widget.CompoundButton;
import com.uptodown.core.activities.FileExplorerActivity;

/* renamed from: T1.b0  reason: case insensitive filesystem */
public final /* synthetic */ class C2160b0 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f19112a;

    public /* synthetic */ C2160b0(FileExplorerActivity fileExplorerActivity) {
        this.f19112a = fileExplorerActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        FileExplorerActivity.x4(this.f19112a, compoundButton, z4);
    }
}
