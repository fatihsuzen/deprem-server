package O1;

import android.view.View;
import com.uptodown.activities.MyDownloads;
import kotlin.jvm.internal.L;

/* renamed from: O1.f3  reason: case insensitive filesystem */
public final /* synthetic */ class C0782f3 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ L f3616a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MyDownloads f3617b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f3618c;

    public /* synthetic */ C0782f3(L l5, MyDownloads myDownloads, int i5) {
        this.f3616a = l5;
        this.f3617b = myDownloads;
        this.f3618c = i5;
    }

    public final void onClick(View view) {
        MyDownloads.k4(this.f3616a, this.f3617b, this.f3618c, view);
    }
}
