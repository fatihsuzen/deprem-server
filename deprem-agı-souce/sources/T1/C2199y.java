package T1;

import android.widget.CompoundButton;
import com.uptodown.core.activities.FileExplorerActivity;

/* renamed from: T1.y  reason: case insensitive filesystem */
public final /* synthetic */ class C2199y implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f19198a;

    public /* synthetic */ C2199y(FileExplorerActivity fileExplorerActivity) {
        this.f19198a = fileExplorerActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        FileExplorerActivity.k4(this.f19198a, compoundButton, z4);
    }
}
