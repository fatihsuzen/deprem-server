package T1;

import android.widget.CompoundButton;
import com.uptodown.core.activities.FileExplorerActivity;

public final /* synthetic */ class F implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f19052a;

    public /* synthetic */ F(FileExplorerActivity fileExplorerActivity) {
        this.f19052a = fileExplorerActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        FileExplorerActivity.o4(this.f19052a, compoundButton, z4);
    }
}
