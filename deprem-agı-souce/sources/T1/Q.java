package T1;

import android.widget.CompoundButton;
import com.uptodown.core.activities.FileExplorerActivity;

public final /* synthetic */ class Q implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f19086a;

    public /* synthetic */ Q(FileExplorerActivity fileExplorerActivity) {
        this.f19086a = fileExplorerActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        FileExplorerActivity.t4(this.f19086a, compoundButton, z4);
    }
}
