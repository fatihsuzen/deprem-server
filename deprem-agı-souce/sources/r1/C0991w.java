package R1;

import C2.K;
import D2.n;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2586C;
import kotlin.jvm.internal.t;
import l2.C2647G;

/* renamed from: R1.w  reason: case insensitive filesystem */
public final class C0991w extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4320a;

    /* renamed from: b  reason: collision with root package name */
    private final C2586C f4321b;

    /* renamed from: c  reason: collision with root package name */
    private int f4322c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList f4323d = new ArrayList();

    public C0991w(Context context, C2586C c5) {
        t.e(context, "context");
        t.e(c5, "listener");
        this.f4320a = context;
        this.f4321b = c5;
    }

    /* access modifiers changed from: private */
    public static final void c(C0991w wVar, C2647G g5, View view) {
        wVar.f4321b.a(g5);
    }

    public final void b(C2647G g5) {
        t.e(g5, "preRegister");
        this.f4323d.add(g5);
        notifyItemInserted(this.f4323d.size());
    }

    public final void d(C2647G g5) {
        t.e(g5, "preRegister");
        Iterator it = this.f4323d.iterator();
        int i5 = 0;
        while (true) {
            if (!it.hasNext()) {
                i5 = -1;
                break;
            }
            int i6 = i5 + 1;
            if (((C2647G) it.next()).b() == g5.b()) {
                break;
            }
            i5 = i6;
        }
        e(i5);
    }

    public final void e(int i5) {
        if (i5 > -1 && i5 < this.f4323d.size()) {
            this.f4323d.remove(i5);
            this.f4322c--;
            notifyDataSetChanged();
            this.f4321b.b();
        }
    }

    public int getItemCount() {
        return this.f4323d.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        t.e(viewHolder, "viewHolder");
        int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
        Object obj = this.f4323d.get(absoluteAdapterPosition);
        t.d(obj, "get(...)");
        C2647G g5 = (C2647G) obj;
        if (viewHolder instanceof K) {
            K k5 = (K) viewHolder;
            k5.d().setText(g5.f());
            s.h().l(g5.e()).l(R.drawable.shape_bg_placeholder).n(UptodownApp.f13477F.g0(this.f4320a)).i(k5.a());
            k5.b().setText(this.f4320a.getString(R.string.preregister_available_to_download));
            k5.c().setText(this.f4320a.getString(R.string.updates_button_download_app));
        }
        if (absoluteAdapterPosition > this.f4322c) {
            Context context = viewHolder.itemView.getContext();
            t.d(context, "getContext(...)");
            n nVar = new n(context);
            View view = viewHolder.itemView;
            t.d(view, "itemView");
            nVar.h(view, R.anim.slide_in_bottom);
            this.f4322c = absoluteAdapterPosition;
        }
        viewHolder.itemView.setOnClickListener(new C0990v(this, g5));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(this.f4320a).inflate(R.layout.floating_notification, viewGroup, false);
        t.b(inflate);
        return new K(inflate);
    }
}
