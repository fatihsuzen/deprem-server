package T1;

import android.widget.CompoundButton;
import com.uptodown.core.activities.FileExplorerActivity;
import kotlin.jvm.internal.L;

public final /* synthetic */ class X implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f19102a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ L f19103b;

    public /* synthetic */ X(FileExplorerActivity fileExplorerActivity, L l5) {
        this.f19102a = fileExplorerActivity;
        this.f19103b = l5;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        FileExplorerActivity.Z3(this.f19102a, this.f19103b, compoundButton, z4);
    }
}
