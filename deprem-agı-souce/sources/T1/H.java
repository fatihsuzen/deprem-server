package T1;

import android.view.View;
import android.widget.EditText;
import com.uptodown.core.activities.FileExplorerActivity;
import java.util.ArrayList;
import kotlin.jvm.internal.L;

public final /* synthetic */ class H implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f19056a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f19057b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f19058c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ArrayList f19059d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ L f19060e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity.C2340x f19061f;

    public /* synthetic */ H(EditText editText, ArrayList arrayList, FileExplorerActivity fileExplorerActivity, ArrayList arrayList2, L l5, FileExplorerActivity.C2340x xVar) {
        this.f19056a = editText;
        this.f19057b = arrayList;
        this.f19058c = fileExplorerActivity;
        this.f19059d = arrayList2;
        this.f19060e = l5;
        this.f19061f = xVar;
    }

    public final void onClick(View view) {
        FileExplorerActivity.S3(this.f19056a, this.f19057b, this.f19058c, this.f19059d, this.f19060e, this.f19061f, view);
    }
}
