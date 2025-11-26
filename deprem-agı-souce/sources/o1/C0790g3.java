package O1;

import android.view.View;
import com.uptodown.activities.MyDownloads;
import kotlin.jvm.internal.L;

/* renamed from: O1.g3  reason: case insensitive filesystem */
public final /* synthetic */ class C0790g3 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ L f3628a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MyDownloads f3629b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f3630c;

    public /* synthetic */ C0790g3(L l5, MyDownloads myDownloads, int i5) {
        this.f3628a = l5;
        this.f3629b = myDownloads;
        this.f3630c = i5;
    }

    public final void onClick(View view) {
        MyDownloads.l4(this.f3628a, this.f3629b, this.f3630c, view);
    }
}
