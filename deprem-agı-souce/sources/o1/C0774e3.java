package O1;

import android.view.View;
import com.uptodown.activities.MyDownloads;
import kotlin.jvm.internal.L;
import l2.C2668q;

/* renamed from: O1.e3  reason: case insensitive filesystem */
public final /* synthetic */ class C0774e3 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ L f3606a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MyDownloads f3607b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C2668q f3608c;

    public /* synthetic */ C0774e3(L l5, MyDownloads myDownloads, C2668q qVar) {
        this.f3606a = l5;
        this.f3607b = myDownloads;
        this.f3608c = qVar;
    }

    public final void onClick(View view) {
        MyDownloads.j4(this.f3606a, this.f3607b, this.f3608c, view);
    }
}
