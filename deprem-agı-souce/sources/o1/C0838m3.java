package O1;

import android.view.View;
import com.uptodown.activities.MyDownloads;
import java.util.HashMap;

/* renamed from: O1.m3  reason: case insensitive filesystem */
public final /* synthetic */ class C0838m3 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyDownloads f3713a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f3714b;

    public /* synthetic */ C0838m3(MyDownloads myDownloads, HashMap hashMap) {
        this.f3713a = myDownloads;
        this.f3714b = hashMap;
    }

    public final void onClick(View view) {
        MyDownloads.v4(this.f3713a, this.f3714b, view);
    }
}
