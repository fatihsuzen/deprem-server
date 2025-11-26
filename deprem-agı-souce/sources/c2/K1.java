package C2;

import S1.k;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.s;
import com.squareup.picasso.w;
import com.uptodown.UptodownApp;
import h2.i1;
import k2.C2592b;
import kotlin.jvm.internal.t;
import l2.X;
import z2.C2962v;

public final class K1 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final i1 f17529a;

    /* renamed from: b  reason: collision with root package name */
    private final C2592b f17530b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public K1(i1 i1Var, C2592b bVar) {
        super(i1Var.getRoot());
        t.e(i1Var, "binding");
        t.e(bVar, "listener");
        this.f17529a = i1Var;
        this.f17530b = bVar;
        i1Var.getRoot().setOnClickListener(new I1(this));
        i1Var.f23237b.setOnClickListener(new J1(this));
        TextView textView = i1Var.f23242g;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        i1Var.f23241f.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void c(K1 k12, View view) {
        k12.e();
    }

    /* access modifiers changed from: private */
    public static final void d(K1 k12, View view) {
        k12.e();
    }

    private final void e() {
        int bindingAdapterPosition = getBindingAdapterPosition();
        if (bindingAdapterPosition != -1) {
            this.f17530b.a(bindingAdapterPosition);
        }
    }

    public final void f(X.c cVar) {
        t.e(cVar, "userDeviceApp");
        this.f17529a.f23242g.setText(cVar.c());
        this.f17529a.f23241f.setText(new C2962v().p(cVar.b()));
        w l5 = s.h().l(cVar.a());
        UptodownApp.a aVar = UptodownApp.f13477F;
        Context context = this.itemView.getContext();
        t.d(context, "getContext(...)");
        l5.n(aVar.g0(context)).i(this.f17529a.f23238c);
    }
}
