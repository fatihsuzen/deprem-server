package u2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import k2.C2601k;
import kotlin.jvm.internal.t;
import l2.C2657f;
import y2.C2922c;

/* renamed from: u2.b  reason: case insensitive filesystem */
public final class C2793b extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    private final C2601k f25968a;

    /* renamed from: b  reason: collision with root package name */
    private C2922c f25969b;

    public C2793b(C2601k kVar) {
        this.f25968a = kVar;
    }

    public final void a(Context context, C2657f fVar) {
        t.e(context, "context");
        C2922c cVar = this.f25969b;
        if (cVar != null) {
            t.b(cVar);
            cVar.d(context, fVar);
        }
    }

    public final void b(int i5) {
        C2922c cVar = this.f25969b;
        if (cVar != null) {
            t.b(cVar);
            cVar.h(i5);
        }
    }

    public final void c(boolean z4) {
        C2922c cVar = this.f25969b;
        if (cVar != null) {
            t.b(cVar);
            cVar.i(z4);
        }
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        t.e(viewHolder, "viewHolder");
        if (obj != null) {
            C2922c cVar = (C2922c) viewHolder;
            this.f25969b = cVar;
            t.b(cVar);
            Context context = viewHolder.view.getContext();
            t.d(context, "getContext(...)");
            cVar.c(context, (C2657f) obj, 0, this.f25968a);
        }
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        t.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_app_detail, viewGroup, false);
        t.b(inflate);
        return new C2922c(inflate);
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        t.e(viewHolder, "viewHolder");
    }
}
