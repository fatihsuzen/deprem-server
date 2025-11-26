package R1;

import C2.C2012e0;
import C2.C2059u0;
import C2.S;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;
import k2.C2615z;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2657f;

/* renamed from: R1.s  reason: case insensitive filesystem */
public final class C0987s extends RecyclerView.Adapter {

    /* renamed from: g  reason: collision with root package name */
    public static final a f4280g = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private C2657f f4281a;

    /* renamed from: b  reason: collision with root package name */
    private C2655d f4282b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f4283c;

    /* renamed from: d  reason: collision with root package name */
    private final C2615z f4284d;

    /* renamed from: e  reason: collision with root package name */
    private final int f4285e;

    /* renamed from: f  reason: collision with root package name */
    private int f4286f;

    /* renamed from: R1.s$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public C0987s(C2657f fVar, C2655d dVar, Context context, C2615z zVar, int i5) {
        t.e(fVar, "appInfo");
        t.e(context, "context");
        t.e(zVar, "listener");
        this.f4281a = fVar;
        this.f4282b = dVar;
        this.f4283c = context;
        this.f4284d = zVar;
        this.f4285e = i5;
    }

    /* access modifiers changed from: private */
    public static final void c(C0987s sVar, View view) {
        sVar.f4284d.a();
    }

    /* access modifiers changed from: private */
    public static final void d(C0987s sVar, View view) {
        sVar.f4284d.d();
    }

    public final void e(C2655d dVar) {
        this.f4282b = dVar;
    }

    public final void f(ArrayList arrayList) {
        this.f4281a.U0(arrayList);
    }

    public final void g(int i5) {
        this.f4286f = i5;
    }

    public int getItemCount() {
        ArrayList Q4 = this.f4281a.Q();
        t.b(Q4);
        return Q4.size() + 1;
    }

    public int getItemViewType(int i5) {
        if (i5 == 0) {
            return 0;
        }
        ArrayList Q4 = this.f4281a.Q();
        t.b(Q4);
        if (i5 < Q4.size()) {
            return 1;
        }
        return 2;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        t.e(viewHolder, "viewHolder");
        if (viewHolder instanceof S) {
            C2655d dVar = this.f4282b;
            if (dVar != null) {
                ((S) viewHolder).a(dVar);
            } else {
                ((S) viewHolder).b(this.f4281a);
            }
        } else if (viewHolder instanceof C2059u0) {
            ((C2059u0) viewHolder).h(this.f4281a, this.f4282b, i5);
        } else if (!(viewHolder instanceof C2012e0)) {
        } else {
            if (this.f4285e > 20) {
                C2012e0 e0Var = (C2012e0) viewHolder;
                e0Var.a().setOnClickListener(new C0986q(this));
                e0Var.b().setOnClickListener(new r(this));
                if (this.f4286f <= 0) {
                    e0Var.a().setVisibility(4);
                } else {
                    e0Var.a().setVisibility(0);
                }
                int i6 = this.f4286f + 1;
                ArrayList Q4 = this.f4281a.Q();
                t.b(Q4);
                if (Q4.size() < 20 || i6 * 20 == this.f4285e - 1) {
                    e0Var.b().setVisibility(4);
                } else {
                    e0Var.b().setVisibility(0);
                }
                e0Var.d().setText(String.valueOf(i6));
                return;
            }
            ((C2012e0) viewHolder).c().setVisibility(8);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        if (i5 == 0) {
            View inflate = LayoutInflater.from(this.f4283c).inflate(R.layout.header_installed_app, viewGroup, false);
            t.b(inflate);
            return new S(inflate, this.f4283c);
        } else if (i5 != 1) {
            View inflate2 = LayoutInflater.from(this.f4283c).inflate(R.layout.load_more_versions, viewGroup, false);
            t.b(inflate2);
            return new C2012e0(inflate2);
        } else {
            View inflate3 = LayoutInflater.from(this.f4283c).inflate(R.layout.old_version_item, viewGroup, false);
            t.b(inflate3);
            return new C2059u0(inflate3, this.f4284d);
        }
    }
}
