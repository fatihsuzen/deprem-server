package O1;

import android.widget.CompoundButton;
import com.uptodown.activities.UserActivity;
import kotlin.jvm.internal.L;

/* renamed from: O1.l6  reason: case insensitive filesystem */
public final /* synthetic */ class C0833l6 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ L f3705a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserActivity f3706b;

    public /* synthetic */ C0833l6(L l5, UserActivity userActivity) {
        this.f3705a = l5;
        this.f3706b = userActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        UserActivity.R3(this.f3705a, this.f3706b, compoundButton, z4);
    }
}
