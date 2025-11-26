package O1;

import android.view.View;
import com.uptodown.activities.MyApps;
import java.util.HashMap;

/* renamed from: O1.o2  reason: case insensitive filesystem */
public final /* synthetic */ class C0853o2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyApps f3748a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f3749b;

    public /* synthetic */ C0853o2(MyApps myApps, HashMap hashMap) {
        this.f3748a = myApps;
        this.f3749b = hashMap;
    }

    public final void onClick(View view) {
        MyApps.r5(this.f3748a, this.f3749b, view);
    }
}
