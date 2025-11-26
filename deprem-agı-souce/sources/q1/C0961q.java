package Q1;

import android.view.View;
import com.uptodown.activities.preferences.AdvancedPreferencesActivity;

/* renamed from: Q1.q  reason: case insensitive filesystem */
public final /* synthetic */ class C0961q implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdvancedPreferencesActivity f3974a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f3975b;

    public /* synthetic */ C0961q(AdvancedPreferencesActivity advancedPreferencesActivity, String str) {
        this.f3974a = advancedPreferencesActivity;
        this.f3975b = str;
    }

    public final boolean onLongClick(View view) {
        return AdvancedPreferencesActivity.J3(this.f3974a, this.f3975b, view);
    }
}
