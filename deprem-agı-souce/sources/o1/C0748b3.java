package O1;

import android.view.View;
import com.uptodown.activities.MyDownloads;
import kotlin.jvm.internal.L;

/* renamed from: O1.b3  reason: case insensitive filesystem */
public final /* synthetic */ class C0748b3 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyDownloads f3577a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f3578b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ L f3579c;

    public /* synthetic */ C0748b3(MyDownloads myDownloads, int i5, L l5) {
        this.f3577a = myDownloads;
        this.f3578b = i5;
        this.f3579c = l5;
    }

    public final void onClick(View view) {
        MyDownloads.g4(this.f3577a, this.f3578b, this.f3579c, view);
    }
}
