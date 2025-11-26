package O1;

import android.view.View;
import com.uptodown.activities.MyDownloads;
import kotlin.jvm.internal.L;
import l2.C2668q;

/* renamed from: O1.d3  reason: case insensitive filesystem */
public final /* synthetic */ class C0766d3 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ L f3597a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2668q f3598b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MyDownloads f3599c;

    public /* synthetic */ C0766d3(L l5, C2668q qVar, MyDownloads myDownloads) {
        this.f3597a = l5;
        this.f3598b = qVar;
        this.f3599c = myDownloads;
    }

    public final void onClick(View view) {
        MyDownloads.i4(this.f3597a, this.f3598b, this.f3599c, view);
    }
}
