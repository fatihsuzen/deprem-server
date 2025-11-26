package C2;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.squareup.picasso.s;
import com.squareup.picasso.w;
import com.uptodown.UptodownApp;
import com.uptodown.views.FullHeightImageView;
import k2.H;
import kotlin.jvm.internal.t;
import l2.P;
import l2.b0;

public final class T0 extends RecyclerView.ViewHolder {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public H f17608a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f17609b;

    public static final class a implements M1.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ T0 f17610a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ P f17611b;

        a(T0 t02, P p5) {
            this.f17610a = t02;
            this.f17611b = p5;
        }

        public void a(Exception exc) {
            t.e(exc, "e");
            exc.printStackTrace();
            this.f17610a.f17608a.b(this.f17611b);
        }

        public void onSuccess() {
            this.f17610a.itemView.setVisibility(0);
            if (this.f17610a.f17609b == 0) {
                View view = this.f17610a.itemView;
                t.c(view, "null cannot be cast to non-null type com.uptodown.views.FullHeightImageView");
                if (((FullHeightImageView) view).getWidth() > 0) {
                    T0 t02 = this.f17610a;
                    View view2 = t02.itemView;
                    t.c(view2, "null cannot be cast to non-null type com.uptodown.views.FullHeightImageView");
                    t02.f17609b = ((FullHeightImageView) view2).getWidth();
                }
            }
        }
    }

    public static final class b implements M1.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ T0 f17612a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b0 f17613b;

        b(T0 t02, b0 b0Var) {
            this.f17612a = t02;
            this.f17613b = b0Var;
        }

        public void a(Exception exc) {
            t.e(exc, "e");
            exc.printStackTrace();
            this.f17612a.f17608a.d(this.f17613b);
        }

        public void onSuccess() {
            this.f17612a.itemView.setVisibility(0);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public T0(View view, H h5) {
        super(view);
        t.e(view, "itemView");
        t.e(h5, "listener");
        this.f17608a = h5;
    }

    /* access modifiers changed from: private */
    public static final void h(T0 t02, P p5, View view) {
        t02.f17608a.c(p5);
    }

    /* access modifiers changed from: private */
    public static final void i(T0 t02, b0 b0Var, View view) {
        t02.f17608a.a(b0Var);
    }

    public final void f(P p5) {
        t.e(p5, "screenShot");
        this.itemView.setOnClickListener(new S0(this, p5));
        View view = this.itemView;
        t.c(view, "null cannot be cast to non-null type com.uptodown.views.FullHeightImageView");
        ((FullHeightImageView) view).setMinimumWidth(this.f17609b);
        w l5 = s.h().l(p5.d());
        UptodownApp.a aVar = UptodownApp.f13477F;
        Context context = this.itemView.getContext();
        t.d(context, "getContext(...)");
        w n5 = l5.n(aVar.h0(context));
        View view2 = this.itemView;
        t.c(view2, "null cannot be cast to non-null type com.uptodown.views.FullHeightImageView");
        n5.j((FullHeightImageView) view2, new a(this, p5));
    }

    public final void g(b0 b0Var) {
        t.e(b0Var, MimeTypes.BASE_TYPE_VIDEO);
        this.itemView.setOnClickListener(new R0(this, b0Var));
        w l5 = s.h().l(b0Var.b());
        UptodownApp.a aVar = UptodownApp.f13477F;
        Context context = this.itemView.getContext();
        t.d(context, "getContext(...)");
        w n5 = l5.n(aVar.f0(context));
        View view = this.itemView;
        t.c(view, "null cannot be cast to non-null type com.uptodown.views.FullHeightImageView");
        n5.j((FullHeightImageView) view, new b(this, b0Var));
    }
}
