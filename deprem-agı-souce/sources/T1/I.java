package T1;

import android.view.View;
import com.uptodown.core.activities.FileExplorerActivity;
import kotlin.jvm.internal.L;

public final /* synthetic */ class I implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ L f19063a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f19064b;

    public /* synthetic */ I(L l5, FileExplorerActivity fileExplorerActivity) {
        this.f19063a = l5;
        this.f19064b = fileExplorerActivity;
    }

    public final void onClick(View view) {
        FileExplorerActivity.T3(this.f19063a, this.f19064b, view);
    }
}
