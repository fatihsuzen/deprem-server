package u2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import kotlin.jvm.internal.t;
import l2.C2643C;
import l2.C2655d;
import y2.C2927h;

public final class n extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    private String f25989a;

    /* renamed from: b  reason: collision with root package name */
    private C2655d f25990b;

    public n(String str) {
        this.f25989a = str;
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        t.e(viewHolder, "viewHolder");
        t.e(obj, "object");
        C2927h hVar = (C2927h) viewHolder;
        Context context = viewHolder.view.getContext();
        t.d(context, "getContext(...)");
        hVar.a((C2643C) obj, context, this.f25989a, this.f25990b);
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        t.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_old_version_item, viewGroup, false);
        inflate.setFocusable(true);
        inflate.setFocusableInTouchMode(true);
        inflate.setBackgroundColor(ContextCompat.getColor(viewGroup.getContext(), R.color.white));
        t.b(inflate);
        return new C2927h(inflate);
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        t.e(viewHolder, "viewHolder");
    }

    public n(C2655d dVar) {
        t.e(dVar, "appInstalled");
        this.f25989a = dVar.o();
        this.f25990b = dVar;
    }
}
