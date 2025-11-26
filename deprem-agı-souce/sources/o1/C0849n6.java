package O1;

import android.content.Context;
import android.widget.CompoundButton;
import com.uptodown.activities.UserActivity;
import kotlin.jvm.internal.L;

/* renamed from: O1.n6  reason: case insensitive filesystem */
public final /* synthetic */ class C0849n6 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ L f3742a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f3743b;

    public /* synthetic */ C0849n6(L l5, Context context) {
        this.f3742a = l5;
        this.f3743b = context;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        UserActivity.T3(this.f3742a, this.f3743b, compoundButton, z4);
    }
}
