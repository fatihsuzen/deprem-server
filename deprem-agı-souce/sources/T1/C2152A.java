package T1;

import android.view.View;
import android.widget.EditText;
import com.uptodown.core.activities.FileExplorerActivity;

/* renamed from: T1.A  reason: case insensitive filesystem */
public final /* synthetic */ class C2152A implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f19042a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f19043b;

    public /* synthetic */ C2152A(EditText editText, FileExplorerActivity fileExplorerActivity) {
        this.f19042a = editText;
        this.f19043b = fileExplorerActivity;
    }

    public final void onClick(View view) {
        FileExplorerActivity.V3(this.f19042a, this.f19043b, view);
    }
}
