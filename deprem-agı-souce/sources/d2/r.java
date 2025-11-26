package D2;

import D2.q;
import android.view.View;

public final /* synthetic */ class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q.b f18041a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f18042b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f18043c;

    public /* synthetic */ r(q.b bVar, int i5, String str) {
        this.f18041a = bVar;
        this.f18042b = i5;
        this.f18043c = str;
    }

    public final void onClick(View view) {
        q.b.c(this.f18041a, this.f18042b, this.f18043c, view);
    }
}
