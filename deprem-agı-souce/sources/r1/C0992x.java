package R1;

import C2.A0;
import C2.C2015f0;
import C2.U0;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import h2.F0;
import java.util.ArrayList;
import java.util.Iterator;
import k2.Y;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2647G;

/* renamed from: R1.x  reason: case insensitive filesystem */
public final class C0992x extends RecyclerView.Adapter {

    /* renamed from: f  reason: collision with root package name */
    public static final a f4324f = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f4325a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f4326b;

    /* renamed from: c  reason: collision with root package name */
    private final Y f4327c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList f4328d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private boolean f4329e;

    /* renamed from: R1.x$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public C0992x(ArrayList arrayList, Context context, Y y4) {
        t.e(arrayList, "userData");
        t.e(context, "context");
        t.e(y4, "listener");
        this.f4325a = arrayList;
        this.f4326b = context;
        this.f4327c = y4;
        a(this.f4325a);
    }

    private final void a(ArrayList arrayList) {
        this.f4328d = new ArrayList();
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                this.f4328d.add((C2647G) next);
            }
            notifyDataSetChanged();
        }
    }

    public final ArrayList b() {
        return this.f4328d;
    }

    public final void c(ArrayList arrayList) {
        t.e(arrayList, "userData");
        a(arrayList);
    }

    public int getItemCount() {
        return this.f4328d.size() + (this.f4329e ? 1 : 0);
    }

    public int getItemViewType(int i5) {
        if (i5 == this.f4328d.size()) {
            return 4;
        }
        return 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        t.e(viewHolder, "viewHolder");
        if (viewHolder instanceof A0) {
            Object obj = this.f4328d.get(i5);
            t.d(obj, "get(...)");
            ((A0) viewHolder).e((C2647G) obj);
        } else if (viewHolder instanceof U0) {
            ((U0) viewHolder).a();
        } else if (!(viewHolder instanceof C2015f0)) {
            throw new IllegalArgumentException("ViewHolder unknown!!");
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        if (i5 == 0) {
            F0 c5 = F0.c(LayoutInflater.from(this.f4326b), viewGroup, false);
            t.d(c5, "inflate(...)");
            return new A0(c5, this.f4326b, this.f4327c, true);
        } else if (i5 == 4) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_loading_more_content, viewGroup, false);
            t.b(inflate);
            return new C2015f0(inflate);
        } else {
            throw new IllegalArgumentException("viewType unknown");
        }
    }
}
