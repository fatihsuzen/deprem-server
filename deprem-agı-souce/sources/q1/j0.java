package Q1;

import android.view.View;
import com.uptodown.activities.preferences.PreferencesActivity;
import java.util.Map;
import kotlin.jvm.internal.J;

public final /* synthetic */ class j0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ J f3958a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map.Entry f3959b;

    public /* synthetic */ j0(J j5, Map.Entry entry) {
        this.f3958a = j5;
        this.f3959b = entry;
    }

    public final void onClick(View view) {
        PreferencesActivity.X3(this.f3958a, this.f3959b, view);
    }
}
