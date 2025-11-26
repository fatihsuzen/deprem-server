package T1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.core.activities.ConfirmationIntentWrapperActivity;

/* renamed from: T1.b  reason: case insensitive filesystem */
public final /* synthetic */ class C2159b implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfirmationIntentWrapperActivity f19111a;

    public /* synthetic */ C2159b(ConfirmationIntentWrapperActivity confirmationIntentWrapperActivity) {
        this.f19111a = confirmationIntentWrapperActivity;
    }

    public final void onActivityResult(Object obj) {
        ConfirmationIntentWrapperActivity.m(this.f19111a, (ActivityResult) obj);
    }
}
