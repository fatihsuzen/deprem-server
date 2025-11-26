package C2;

import S1.k;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b2.C2291k;
import com.uptodown.R;
import k2.C2593c;
import kotlin.jvm.internal.t;
import l2.C2673w;
import t3.s;

/* renamed from: C2.d  reason: case insensitive filesystem */
public final class C2008d extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private C2593c f17721a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f17722b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f17723c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f17724d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f17725e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2008d(View view, C2593c cVar) {
        super(view);
        t.e(view, "itemView");
        t.e(cVar, "listener");
        this.f17721a = cVar;
        View findViewById = view.findViewById(R.id.rl_app_file_item);
        t.d(findViewById, "findViewById(...)");
        this.f17722b = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_type_app_file_item);
        t.d(findViewById2, "findViewById(...)");
        this.f17723c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_name_app_file_item);
        t.d(findViewById3, "findViewById(...)");
        this.f17724d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_size_app_file_item);
        t.d(findViewById4, "findViewById(...)");
        this.f17725e = (TextView) findViewById4;
        TextView textView = this.f17723c;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.x());
        this.f17724d.setTypeface(aVar.w());
        this.f17725e.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void c(C2008d dVar, C2673w wVar, View view) {
        dVar.f17721a.a(wVar);
    }

    public final void b(C2673w wVar) {
        t.e(wVar, "fileInfo");
        this.f17722b.setOnClickListener(new C2005c(this, wVar));
        String b5 = wVar.b();
        if (b5 != null) {
            TextView textView = this.f17723c;
            String substring = b5.substring(s.l0(b5, ".", 0, false, 6, (Object) null) + 1);
            t.d(substring, "substring(...)");
            textView.setText(substring);
        }
        this.f17724d.setText(wVar.b());
        TextView textView2 = this.f17725e;
        C2291k kVar = new C2291k();
        long d5 = wVar.d();
        Context context = this.itemView.getContext();
        t.d(context, "getContext(...)");
        textView2.setText(kVar.d(d5, context));
    }
}
