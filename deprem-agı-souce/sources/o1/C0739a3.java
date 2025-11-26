package O1;

import android.view.View;
import com.uptodown.activities.MyDownloads;
import kotlin.jvm.internal.L;
import l2.C2668q;

/* renamed from: O1.a3  reason: case insensitive filesystem */
public final /* synthetic */ class C0739a3 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ L f3563a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2668q f3564b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MyDownloads f3565c;

    public /* synthetic */ C0739a3(L l5, C2668q qVar, MyDownloads myDownloads) {
        this.f3563a = l5;
        this.f3564b = qVar;
        this.f3565c = myDownloads;
    }

    public final void onClick(View view) {
        MyDownloads.m4(this.f3563a, this.f3564b, this.f3565c, view);
    }
}
