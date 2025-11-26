package C2;

import S1.k;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.s;
import com.squareup.picasso.w;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.util.views.UsernameTextView;
import h2.N;
import k2.C2603m;
import kotlin.jvm.internal.t;
import l2.C2672v;
import l2.V;
import z2.C2962v;

public final class H extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final N f17489a;

    /* renamed from: b  reason: collision with root package name */
    private final C2603m f17490b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f17491c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public H(N n5, C2603m mVar) {
        super(n5.getRoot());
        t.e(n5, "feedItemBinding");
        t.e(mVar, "listener");
        this.f17489a = n5;
        this.f17490b = mVar;
        this.f17491c = n5.getRoot().getContext();
        UsernameTextView usernameTextView = n5.f22528j;
        k.a aVar = k.f32g;
        usernameTextView.setTypeface(aVar.w());
        n5.f22525g.setTypeface(aVar.x());
        n5.f22527i.setTypeface(aVar.x());
        n5.f22526h.setTypeface(aVar.w());
    }

    /* access modifiers changed from: private */
    public static final void e(H h5, C2672v vVar, View view) {
        h5.f17490b.c(vVar.o());
    }

    /* access modifiers changed from: private */
    public static final void f(H h5, C2672v vVar, View view) {
        h5.f17490b.c(vVar.o());
    }

    /* access modifiers changed from: private */
    public static final void g(H h5, View view) {
        h5.f17490b.a();
    }

    public final void d(C2672v vVar) {
        t.e(vVar, "item");
        s h5 = s.h();
        V.b bVar = V.f24870q;
        w l5 = h5.l(bVar.f(vVar.l()));
        UptodownApp.a aVar = UptodownApp.f13477F;
        Context context = this.f17491c;
        t.d(context, "context");
        l5.n(aVar.g0(context)).i(this.f17489a.f22520b);
        this.f17489a.f22522d.setImageDrawable(ContextCompat.getDrawable(this.f17491c, R.drawable.vector_feed_subscription));
        this.f17489a.f22523e.setOnClickListener(new E(this, vVar));
        if (vVar.m() == 1) {
            C2962v.a aVar2 = C2962v.f26557a;
            ImageView imageView = this.f17489a.f22520b;
            t.d(imageView, "ivAvatarFeedItem");
            aVar2.b(imageView);
            this.f17489a.f22521c.setVisibility(0);
        } else {
            C2962v.a aVar3 = C2962v.f26557a;
            ImageView imageView2 = this.f17489a.f22520b;
            t.d(imageView2, "ivAvatarFeedItem");
            aVar3.a(imageView2);
            this.f17489a.f22521c.setVisibility(8);
        }
        this.f17489a.f22528j.setText(vVar.p());
        UsernameTextView.a aVar4 = UsernameTextView.f21329k;
        UsernameTextView usernameTextView = this.f17489a.f22528j;
        t.d(usernameTextView, "tvUsernameFeedItem");
        aVar4.a(usernameTextView, vVar.s(), vVar.q());
        this.f17489a.f22528j.setOnClickListener(new F(this, vVar));
        this.f17489a.f22525g.setText(vVar.k());
        this.f17489a.f22527i.setText(vVar.n());
        Context context2 = this.f17491c;
        t.d(context2, "context");
        V h6 = bVar.h(context2);
        if (h6 == null || !h6.q()) {
            this.f17489a.f22526h.setVisibility(8);
            return;
        }
        this.f17489a.f22526h.setOnClickListener(new G(this));
        this.f17489a.f22526h.setVisibility(0);
    }
}
