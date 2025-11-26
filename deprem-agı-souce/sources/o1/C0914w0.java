package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.ListsActivity;

/* renamed from: O1.w0  reason: case insensitive filesystem */
public final /* synthetic */ class C0914w0 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ListsActivity f3827a;

    public /* synthetic */ C0914w0(ListsActivity listsActivity) {
        this.f3827a = listsActivity;
    }

    public final void onActivityResult(Object obj) {
        ListsActivity.s3(this.f3827a, (ActivityResult) obj);
    }
}
