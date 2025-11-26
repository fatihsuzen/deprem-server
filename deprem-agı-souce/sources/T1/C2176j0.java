package T1;

import android.view.View;
import android.widget.CheckBox;
import com.uptodown.core.activities.InstallerActivity;
import java.util.ArrayList;

/* renamed from: T1.j0  reason: case insensitive filesystem */
public final /* synthetic */ class C2176j0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f19145a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckBox f19146b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ArrayList f19147c;

    public /* synthetic */ C2176j0(InstallerActivity installerActivity, CheckBox checkBox, ArrayList arrayList) {
        this.f19145a = installerActivity;
        this.f19146b = checkBox;
        this.f19147c = arrayList;
    }

    public final void onClick(View view) {
        InstallerActivity.n2(this.f19145a, this.f19146b, this.f19147c, view);
    }
}
