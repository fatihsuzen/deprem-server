package T1;

import android.widget.CompoundButton;
import com.uptodown.core.activities.FileExplorerActivity;

public final /* synthetic */ class Y implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f19104a;

    public /* synthetic */ Y(FileExplorerActivity fileExplorerActivity) {
        this.f19104a = fileExplorerActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        FileExplorerActivity.a4(this.f19104a, compoundButton, z4);
    }
}
