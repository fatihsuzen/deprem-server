package u2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import kotlin.jvm.internal.t;
import s2.C2745b;
import y2.C2925f;

public final class k extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    private int f25979a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f25980b = -1;

    /* access modifiers changed from: private */
    public static final void b(k kVar, View view, boolean z4) {
        t.b(view);
        kVar.c(view, z4);
    }

    private final void c(View view, boolean z4) {
        int i5;
        if (z4) {
            i5 = this.f25979a;
        } else {
            i5 = this.f25980b;
        }
        view.setBackgroundColor(i5);
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        t.e(viewHolder, "viewHolder");
        t.e(obj, "object");
        ((C2925f) viewHolder).a((C2745b) obj);
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        t.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_manage_apps_item, viewGroup, false);
        this.f25980b = ContextCompat.getColor(viewGroup.getContext(), R.color.main_blue);
        this.f25979a = ContextCompat.getColor(viewGroup.getContext(), R.color.main_blue_pressed);
        inflate.setFocusable(true);
        inflate.setFocusableInTouchMode(true);
        inflate.setOnFocusChangeListener(new j(this));
        t.b(inflate);
        c(inflate, false);
        return new C2925f(inflate);
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        t.e(viewHolder, "viewHolder");
    }
}
