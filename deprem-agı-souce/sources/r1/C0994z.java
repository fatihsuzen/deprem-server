package R1;

import C2.C2029k;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.squareup.picasso.s;
import com.squareup.picasso.w;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import h2.W;
import java.util.ArrayList;
import k2.C2592b;
import kotlin.jvm.internal.t;
import l2.C2657f;

/* renamed from: R1.z  reason: case insensitive filesystem */
public final class C0994z extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f4332a;

    /* renamed from: b  reason: collision with root package name */
    private C2592b f4333b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f4334c;

    /* renamed from: R1.z$a */
    public final class a extends C2029k {

        /* renamed from: b  reason: collision with root package name */
        private final W f4335b;

        /* renamed from: c  reason: collision with root package name */
        private C2592b f4336c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C0994z f4337d;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(R1.C0994z r3, h2.W r4, k2.C2592b r5) {
            /*
                r2 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.t.e(r4, r0)
                java.lang.String r0 = "listener"
                kotlin.jvm.internal.t.e(r5, r0)
                r2.f4337d = r3
                android.widget.RelativeLayout r3 = r4.getRoot()
                java.lang.String r0 = "getRoot(...)"
                kotlin.jvm.internal.t.d(r3, r0)
                android.widget.RelativeLayout r0 = r4.getRoot()
                android.content.Context r0 = r0.getContext()
                java.lang.String r1 = "getContext(...)"
                kotlin.jvm.internal.t.d(r0, r1)
                r2.<init>(r3, r0)
                r2.f4335b = r4
                r2.f4336c = r5
                android.widget.TextView r3 = r4.f22678j
                S1.k$a r5 = S1.k.f32g
                android.graphics.Typeface r0 = r5.w()
                r3.setTypeface(r0)
                android.widget.TextView r3 = r4.f22676h
                android.graphics.Typeface r4 = r5.x()
                r3.setTypeface(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: R1.C0994z.a.<init>(R1.z, h2.W, k2.b):void");
        }

        /* access modifiers changed from: private */
        public static final void n(a aVar, int i5, View view) {
            aVar.f4336c.a(i5);
        }

        public final void m(C2657f fVar, int i5) {
            t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            RelativeLayout b5 = this.f4335b.getRoot();
            Context context = this.itemView.getContext();
            t.d(context, "getContext(...)");
            b5.setLayoutParams(b(layoutParams, context, i5, this.f4337d.f4334c));
            w l5 = s.h().l(fVar.E()).l(R.drawable.shape_bg_placeholder);
            UptodownApp.a aVar = UptodownApp.f13477F;
            Context context2 = this.itemView.getContext();
            t.d(context2, "getContext(...)");
            l5.n(aVar.g0(context2)).i(this.f4335b.f22671c);
            w f5 = s.h().l(fVar.D()).l(R.drawable.shape_bg_placeholder).a().f();
            Context context3 = this.itemView.getContext();
            t.d(context3, "getContext(...)");
            f5.n(aVar.f0(context3)).i(this.f4335b.f22670b);
            this.f4335b.f22678j.setText(fVar.N());
            this.f4335b.f22676h.setText(fVar.o0());
            this.f4335b.getRoot().setOnClickListener(new C0993y(this, i5));
        }
    }

    public C0994z(ArrayList arrayList, C2592b bVar) {
        t.e(arrayList, "apps");
        t.e(bVar, "listener");
        this.f4332a = arrayList;
        this.f4333b = bVar;
        this.f4334c = arrayList.size() - 1;
    }

    /* renamed from: b */
    public void onBindViewHolder(a aVar, int i5) {
        t.e(aVar, "holder");
        Object obj = this.f4332a.get(i5);
        t.d(obj, "get(...)");
        aVar.m((C2657f) obj, i5);
    }

    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "parent");
        W c5 = W.c(LayoutInflater.from(viewGroup.getContext()));
        t.d(c5, "inflate(...)");
        return new a(this, c5, this.f4333b);
    }

    public int getItemCount() {
        return this.f4332a.size();
    }
}
