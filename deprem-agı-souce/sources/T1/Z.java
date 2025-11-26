package T1;

import android.view.View;
import com.uptodown.core.activities.FileExplorerActivity;
import kotlin.jvm.internal.L;

public final /* synthetic */ class Z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f19105a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f19106b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ L f19107c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity.C2342z f19108d;

    public /* synthetic */ Z(Object obj, FileExplorerActivity fileExplorerActivity, L l5, FileExplorerActivity.C2342z zVar) {
        this.f19105a = obj;
        this.f19106b = fileExplorerActivity;
        this.f19107c = l5;
        this.f19108d = zVar;
    }

    public final void onClick(View view) {
        FileExplorerActivity.b4(this.f19105a, this.f19106b, this.f19107c, this.f19108d, view);
    }
}
