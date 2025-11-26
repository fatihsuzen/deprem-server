package C2;

import D2.n;
import S1.k;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.a;
import k2.K;
import kotlin.jvm.internal.t;
import z2.C2962v;

/* renamed from: C2.p1  reason: case insensitive filesystem */
public final class C2046p1 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final K f17862a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f17863b;

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f17864c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f17865d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f17866e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2046p1(View view, K k5) {
        super(view);
        t.e(view, "itemView");
        t.e(k5, "updatesTrackingListener");
        this.f17862a = k5;
        View findViewById = view.findViewById(R.id.tv_updates_available_updates_header);
        t.d(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        this.f17863b = textView;
        View findViewById2 = view.findViewById(R.id.ll_no_pending_updates_header);
        t.d(findViewById2, "findViewById(...)");
        this.f17864c = (LinearLayout) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_last_check_updates_header);
        t.d(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        this.f17865d = textView2;
        View findViewById4 = view.findViewById(R.id.tv_check_updates_header);
        t.d(findViewById4, "findViewById(...)");
        TextView textView3 = (TextView) findViewById4;
        this.f17866e = textView3;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        textView2.setTypeface(aVar.x());
        textView3.setTypeface(aVar.w());
    }

    /* access modifiers changed from: private */
    public static final void c(C2046p1 p1Var, View view) {
        p1Var.f17862a.b();
    }

    public final void b(int i5) {
        if (i5 == 0) {
            UptodownApp.a aVar = UptodownApp.f13477F;
            Context context = this.itemView.getContext();
            t.d(context, "getContext(...)");
            if (aVar.S("TrackingWorkerSingle", context)) {
                this.f17866e.setOnClickListener((View.OnClickListener) null);
                Context context2 = this.itemView.getContext();
                t.d(context2, "getContext(...)");
                new n(context2).d(this.f17866e, 0.3f);
            } else {
                this.f17866e.setOnClickListener(new C2043o1(this));
                Context context3 = this.itemView.getContext();
                t.d(context3, "getContext(...)");
                new n(context3).d(this.f17866e, 1.0f);
            }
            this.f17863b.setText(this.itemView.getContext().getString(R.string.you_are_up_to_date));
            TextView textView = this.f17865d;
            Resources resources = this.itemView.getResources();
            C2962v vVar = new C2962v();
            a.C0147a aVar2 = a.f15150a;
            Context context4 = this.itemView.getContext();
            t.d(context4, "getContext(...)");
            textView.setText(resources.getString(R.string.last_check, new Object[]{String.valueOf(vVar.o(aVar2.y(context4)))}));
            this.f17864c.setVisibility(0);
            return;
        }
        this.f17863b.setText(this.itemView.getContext().getString(R.string.my_downloads_pending));
        this.f17864c.setVisibility(8);
    }
}
