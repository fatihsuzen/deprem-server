package O1;

import android.widget.CompoundButton;
import com.uptodown.activities.UserActivity;
import kotlin.jvm.internal.L;

/* renamed from: O1.m6  reason: case insensitive filesystem */
public final /* synthetic */ class C0841m6 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ L f3719a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserActivity f3720b;

    public /* synthetic */ C0841m6(L l5, UserActivity userActivity) {
        this.f3719a = l5;
        this.f3720b = userActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        UserActivity.S3(this.f3719a, this.f3720b, compoundButton, z4);
    }
}
