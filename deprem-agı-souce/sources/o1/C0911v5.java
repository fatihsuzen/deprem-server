package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.SearchActivity;

/* renamed from: O1.v5  reason: case insensitive filesystem */
public final /* synthetic */ class C0911v5 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchActivity f3825a;

    public /* synthetic */ C0911v5(SearchActivity searchActivity) {
        this.f3825a = searchActivity;
    }

    public final void onActivityResult(Object obj) {
        SearchActivity.R3(this.f3825a, (ActivityResult) obj);
    }
}
