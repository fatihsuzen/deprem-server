package O1;

import android.content.Context;
import android.view.View;
import com.uptodown.activities.UserActivity;
import kotlin.jvm.internal.L;

/* renamed from: O1.o6  reason: case insensitive filesystem */
public final /* synthetic */ class C0857o6 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserActivity f3755a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f3756b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ L f3757c;

    public /* synthetic */ C0857o6(UserActivity userActivity, Context context, L l5) {
        this.f3755a = userActivity;
        this.f3756b = context;
        this.f3757c = l5;
    }

    public final void onClick(View view) {
        UserActivity.V3(this.f3755a, this.f3756b, this.f3757c, view);
    }
}
