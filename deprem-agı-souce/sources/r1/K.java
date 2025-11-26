package R1;

import C2.C2029k;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import java.util.ArrayList;
import k2.C2591a;
import k2.C2594d;
import kotlin.jvm.internal.t;
import l2.C2657f;

public final class K extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private C2594d f4050a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C2591a f4051b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f4052c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList f4053d = new ArrayList();

    public final class a extends C2029k {

        /* renamed from: b  reason: collision with root package name */
        private C2594d f4054b;

        /* renamed from: c  reason: collision with root package name */
        private final ImageView f4055c;

        /* renamed from: d  reason: collision with root package name */
        private final ProgressBar f4056d;

        /* renamed from: e  reason: collision with root package name */
        private final TextView f4057e;

        /* renamed from: f  reason: collision with root package name */
        private final TextView f4058f;

        /* renamed from: g  reason: collision with root package name */
        private final TextView f4059g;

        /* renamed from: h  reason: collision with root package name */
        private final TextView f4060h;

        /* renamed from: i  reason: collision with root package name */
        private final LinearLayout f4061i;

        /* renamed from: j  reason: collision with root package name */
        private final TextView f4062j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ K f4063k;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(R1.K r5, android.view.View r6, k2.C2594d r7) {
            /*
                r4 = this;
                java.lang.String r0 = "itemView"
                kotlin.jvm.internal.t.e(r6, r0)
                java.lang.String r0 = "listener"
                kotlin.jvm.internal.t.e(r7, r0)
                r4.f4063k = r5
                android.content.Context r5 = r6.getContext()
                java.lang.String r0 = "getContext(...)"
                kotlin.jvm.internal.t.d(r5, r0)
                r4.<init>(r6, r5)
                r4.f4054b = r7
                r5 = 2131362410(0x7f0a026a, float:1.83446E38)
                android.view.View r5 = r6.findViewById(r5)
                java.lang.String r7 = "findViewById(...)"
                kotlin.jvm.internal.t.d(r5, r7)
                android.widget.ImageView r5 = (android.widget.ImageView) r5
                r4.f4055c = r5
                r5 = 2131363108(0x7f0a0524, float:1.8346016E38)
                android.view.View r5 = r6.findViewById(r5)
                kotlin.jvm.internal.t.d(r5, r7)
                android.widget.ProgressBar r5 = (android.widget.ProgressBar) r5
                r4.f4056d = r5
                r5 = 2131364456(0x7f0a0a68, float:1.834875E38)
                android.view.View r5 = r6.findViewById(r5)
                kotlin.jvm.internal.t.d(r5, r7)
                android.widget.TextView r5 = (android.widget.TextView) r5
                r4.f4057e = r5
                r0 = 2131364275(0x7f0a09b3, float:1.8348382E38)
                android.view.View r0 = r6.findViewById(r0)
                kotlin.jvm.internal.t.d(r0, r7)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r4.f4058f = r0
                r1 = 2131364227(0x7f0a0983, float:1.8348285E38)
                android.view.View r1 = r6.findViewById(r1)
                kotlin.jvm.internal.t.d(r1, r7)
                android.widget.TextView r1 = (android.widget.TextView) r1
                r4.f4059g = r1
                r2 = 2131364558(0x7f0a0ace, float:1.8348956E38)
                android.view.View r2 = r6.findViewById(r2)
                kotlin.jvm.internal.t.d(r2, r7)
                android.widget.TextView r2 = (android.widget.TextView) r2
                r4.f4060h = r2
                r3 = 2131362688(0x7f0a0380, float:1.8345164E38)
                android.view.View r3 = r6.findViewById(r3)
                kotlin.jvm.internal.t.d(r3, r7)
                android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
                r4.f4061i = r3
                r3 = 2131364366(0x7f0a0a0e, float:1.8348567E38)
                android.view.View r6 = r6.findViewById(r3)
                kotlin.jvm.internal.t.d(r6, r7)
                android.widget.TextView r6 = (android.widget.TextView) r6
                r4.f4062j = r6
                S1.k$a r7 = S1.k.f32g
                android.graphics.Typeface r3 = r7.w()
                r5.setTypeface(r3)
                android.graphics.Typeface r5 = r7.x()
                r0.setTypeface(r5)
                android.graphics.Typeface r5 = r7.x()
                r6.setTypeface(r5)
                android.graphics.Typeface r5 = r7.x()
                r1.setTypeface(r5)
                android.graphics.Typeface r5 = r7.x()
                r2.setTypeface(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: R1.K.a.<init>(R1.K, android.view.View, k2.d):void");
        }

        /* access modifiers changed from: private */
        public static final boolean n(K k5, C2657f fVar, int i5, View view) {
            k5.f4051b.a(fVar, i5);
            return true;
        }

        public final void m(C2657f fVar, int i5) {
            t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) this.itemView.getContext().getResources().getDimension(R.dimen.top_horizontal_card_width), -2);
            View view = this.itemView;
            Context context = view.getContext();
            t.d(context, "getContext(...)");
            view.setLayoutParams(b(layoutParams, context, i5, this.f4063k.f4052c));
            View view2 = this.itemView;
            t.d(view2, "itemView");
            c(view2, this.f4054b, fVar);
            this.itemView.setOnLongClickListener(new J(this.f4063k, fVar, i5));
            i(fVar, this.f4057e, this.f4058f);
            h(this.f4055c, fVar.G());
            e(fVar, this.f4056d, this.f4055c, this.f4058f, this.f4059g, this.f4062j, this.f4061i);
        }
    }

    public K(C2594d dVar, C2591a aVar, int i5) {
        t.e(dVar, "listener");
        t.e(aVar, "actionsClickListener");
        this.f4050a = dVar;
        this.f4051b = aVar;
        this.f4052c = i5;
    }

    public final ArrayList c() {
        return this.f4053d;
    }

    public final void d(ArrayList arrayList) {
        t.e(arrayList, "appList");
        ArrayList arrayList2 = this.f4053d;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f4053d.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        t.e(viewHolder, "holder");
        Object obj = this.f4053d.get(i5);
        t.d(obj, "get(...)");
        ((a) viewHolder).m((C2657f) obj, i5 + 1);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, viewGroup, false);
        t.b(inflate);
        return new a(this, inflate, this.f4050a);
    }
}
