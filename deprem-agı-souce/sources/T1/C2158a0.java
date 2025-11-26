package T1;

import android.view.View;
import com.uptodown.core.activities.FileExplorerActivity;
import kotlin.jvm.internal.L;

/* renamed from: T1.a0  reason: case insensitive filesystem */
public final /* synthetic */ class C2158a0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ L f19109a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f19110b;

    public /* synthetic */ C2158a0(L l5, FileExplorerActivity fileExplorerActivity) {
        this.f19109a = l5;
        this.f19110b = fileExplorerActivity;
    }

    public final void onClick(View view) {
        FileExplorerActivity.c4(this.f19109a, this.f19110b, view);
    }
}
