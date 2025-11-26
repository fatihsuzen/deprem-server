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

public final class I extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private C2594d f4032a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C2591a f4033b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f4034c = new ArrayList();

    public final class a extends C2029k {

        /* renamed from: b  reason: collision with root package name */
        private C2594d f4035b;

        /* renamed from: c  reason: collision with root package name */
        private final ImageView f4036c;

        /* renamed from: d  reason: collision with root package name */
        private final ProgressBar f4037d;

        /* renamed from: e  reason: collision with root package name */
        private final TextView f4038e;

        /* renamed from: f  reason: collision with root package name */
        private final TextView f4039f;

        /* renamed from: g  reason: collision with root package name */
        private final TextView f4040g;

        /* renamed from: h  reason: collision with root package name */
        private final TextView f4041h;

        /* renamed from: i  reason: collision with root package name */
        private final TextView f4042i;

        /* renamed from: j  reason: collision with root package name */
        private final TextView f4043j;

        /* renamed from: k  reason: collision with root package name */
        private final LinearLayout f4044k;

        /* renamed from: l  reason: collision with root package name */
        private final RelativeLayout f4045l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ I f4046m;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(R1.I r7, android.view.View r8, k2.C2594d r9) {
            /*
                r6 = this;
                java.lang.String r0 = "itemView"
                kotlin.jvm.internal.t.e(r8, r0)
                java.lang.String r0 = "listener"
                kotlin.jvm.internal.t.e(r9, r0)
                r6.f4046m = r7
                android.content.Context r7 = r8.getContext()
                java.lang.String r0 = "getContext(...)"
                kotlin.jvm.internal.t.d(r7, r0)
                r6.<init>(r8, r7)
                r6.f4035b = r9
                r7 = 2131362411(0x7f0a026b, float:1.8344602E38)
                android.view.View r7 = r8.findViewById(r7)
                java.lang.String r9 = "findViewById(...)"
                kotlin.jvm.internal.t.d(r7, r9)
                android.widget.ImageView r7 = (android.widget.ImageView) r7
                r6.f4036c = r7
                r7 = 2131363109(0x7f0a0525, float:1.8346018E38)
                android.view.View r7 = r8.findViewById(r7)
                kotlin.jvm.internal.t.d(r7, r9)
                android.widget.ProgressBar r7 = (android.widget.ProgressBar) r7
                r6.f4037d = r7
                r7 = 2131364459(0x7f0a0a6b, float:1.8348756E38)
                android.view.View r7 = r8.findViewById(r7)
                kotlin.jvm.internal.t.d(r7, r9)
                android.widget.TextView r7 = (android.widget.TextView) r7
                r6.f4038e = r7
                r0 = 2131364149(0x7f0a0935, float:1.8348127E38)
                android.view.View r0 = r8.findViewById(r0)
                kotlin.jvm.internal.t.d(r0, r9)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r6.f4039f = r0
                r1 = 2131364278(0x7f0a09b6, float:1.8348389E38)
                android.view.View r1 = r8.findViewById(r1)
                kotlin.jvm.internal.t.d(r1, r9)
                android.widget.TextView r1 = (android.widget.TextView) r1
                r6.f4040g = r1
                r2 = 2131364367(0x7f0a0a0f, float:1.834857E38)
                android.view.View r2 = r8.findViewById(r2)
                kotlin.jvm.internal.t.d(r2, r9)
                android.widget.TextView r2 = (android.widget.TextView) r2
                r6.f4041h = r2
                r3 = 2131364228(0x7f0a0984, float:1.8348287E38)
                android.view.View r3 = r8.findViewById(r3)
                kotlin.jvm.internal.t.d(r3, r9)
                android.widget.TextView r3 = (android.widget.TextView) r3
                r6.f4042i = r3
                r4 = 2131364559(0x7f0a0acf, float:1.8348958E38)
                android.view.View r4 = r8.findViewById(r4)
                kotlin.jvm.internal.t.d(r4, r9)
                android.widget.TextView r4 = (android.widget.TextView) r4
                r6.f4043j = r4
                r5 = 2131362689(0x7f0a0381, float:1.8345166E38)
                android.view.View r5 = r8.findViewById(r5)
                kotlin.jvm.internal.t.d(r5, r9)
                android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
                r6.f4044k = r5
                r5 = 2131363225(0x7f0a0599, float:1.8346253E38)
                android.view.View r8 = r8.findViewById(r5)
                kotlin.jvm.internal.t.d(r8, r9)
                android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8
                r6.f4045l = r8
                S1.k$a r8 = S1.k.f32g
                android.graphics.Typeface r9 = r8.w()
                r0.setTypeface(r9)
                android.graphics.Typeface r9 = r8.w()
                r7.setTypeface(r9)
                android.graphics.Typeface r7 = r8.x()
                r1.setTypeface(r7)
                android.graphics.Typeface r7 = r8.x()
                r2.setTypeface(r7)
                android.graphics.Typeface r7 = r8.x()
                r3.setTypeface(r7)
                android.graphics.Typeface r7 = r8.x()
                r4.setTypeface(r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: R1.I.a.<init>(R1.I, android.view.View, k2.d):void");
        }

        /* access modifiers changed from: private */
        public static final boolean n(I i5, C2657f fVar, int i6, View view) {
            i5.f4033b.a(fVar, i6);
            return true;
        }

        public final void m(C2657f fVar, int i5, int i6) {
            t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (i5 >= 10) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.setMarginStart((int) this.itemView.getContext().getResources().getDimension(R.dimen.top_card_margin_index_ten));
                this.f4045l.setLayoutParams(layoutParams2);
            } else {
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.setMarginStart((int) this.itemView.getContext().getResources().getDimension(R.dimen.top_download_horizontal_card_margin));
                this.f4045l.setLayoutParams(layoutParams3);
            }
            View view = this.itemView;
            Context context = view.getContext();
            t.d(context, "getContext(...)");
            view.setLayoutParams(b(layoutParams, context, i5, 20));
            this.f4039f.setText(String.valueOf(i5));
            View view2 = this.itemView;
            t.d(view2, "itemView");
            c(view2, this.f4035b, fVar);
            this.itemView.setOnLongClickListener(new H(this.f4046m, fVar, i6));
            i(fVar, this.f4038e, this.f4040g);
            h(this.f4036c, fVar.G());
            e(fVar, this.f4037d, this.f4036c, this.f4040g, this.f4042i, this.f4041h, this.f4044k);
        }
    }

    public I(C2594d dVar, C2591a aVar) {
        t.e(dVar, "listener");
        t.e(aVar, "actionsClickListener");
        this.f4032a = dVar;
        this.f4033b = aVar;
    }

    public final ArrayList b() {
        return this.f4034c;
    }

    public final void c(ArrayList arrayList) {
        t.e(arrayList, "appList");
        ArrayList arrayList2 = this.f4034c;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f4034c.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        t.e(viewHolder, "holder");
        Object obj = this.f4034c.get(i5);
        t.d(obj, "get(...)");
        ((a) viewHolder).m((C2657f) obj, i5 + 1, i5);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_top_download, viewGroup, false);
        t.b(inflate);
        return new a(this, inflate, this.f4032a);
    }
}
