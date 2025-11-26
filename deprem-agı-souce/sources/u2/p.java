package u2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import kotlin.jvm.internal.t;
import l2.C2657f;
import y2.i;

public final class p extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    private int f25992a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f25993b = -1;

    /* access modifiers changed from: private */
    public static final void b(p pVar, View view, boolean z4) {
        t.b(view);
        pVar.c(view, z4);
    }

    private final void c(View view, boolean z4) {
        int i5;
        if (z4) {
            i5 = this.f25992a;
        } else {
            i5 = this.f25993b;
        }
        view.setBackgroundColor(i5);
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        t.e(viewHolder, "viewHolder");
        t.e(obj, "object");
        ((i) viewHolder).a((C2657f) obj);
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        t.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_program_day, viewGroup, false);
        this.f25993b = ContextCompat.getColor(viewGroup.getContext(), R.color.main_blue);
        this.f25992a = ContextCompat.getColor(viewGroup.getContext(), R.color.main_blue_pressed);
        inflate.setFocusable(true);
        inflate.setFocusableInTouchMode(true);
        inflate.setOnFocusChangeListener(new o(this));
        t.b(inflate);
        c(inflate, false);
        return new i(inflate);
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        t.e(viewHolder, "viewHolder");
    }
}
