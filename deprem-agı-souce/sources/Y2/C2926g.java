package y2;

import S1.k;
import Y1.C2257a;
import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.leanback.widget.Presenter;
import b2.C2291k;
import com.uptodown.R;
import java.io.File;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import l2.C2668q;
import t3.s;

/* renamed from: y2.g  reason: case insensitive filesystem */
public final class C2926g extends Presenter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private TextView f26365a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f26366b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f26367c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressBar f26368d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2926g(View view) {
        super(view);
        t.e(view, "itemView");
        View findViewById = view.findViewById(R.id.tv_nombre_app);
        t.d(findViewById, "findViewById(...)");
        this.f26365a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_size_download);
        t.d(findViewById2, "findViewById(...)");
        this.f26366b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_date_download);
        t.d(findViewById3, "findViewById(...)");
        this.f26367c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.progressbar_downloading);
        t.d(findViewById4, "findViewById(...)");
        this.f26368d = (ProgressBar) findViewById4;
        TextView textView = this.f26365a;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.x());
        this.f26366b.setTypeface(aVar.x());
        this.f26367c.setTypeface(aVar.x());
    }

    public final void a(C2668q qVar, Context context) {
        t.e(qVar, "download");
        if (context != null) {
            TextView textView = this.f26365a;
            textView.setText(qVar.i() + ' ' + qVar.H());
            TextView textView2 = this.f26365a;
            k.a aVar = k.f32g;
            textView2.setTypeface(aVar.x());
            this.f26366b.setTypeface(aVar.x());
            this.f26367c.setTypeface(aVar.x());
            if (qVar.x() <= 0 || qVar.x() >= 100) {
                C2257a i5 = aVar.i();
                if (i5 == null || !s.E(i5.b(), qVar.w(), true) || qVar.E() <= 0 || i5.e() != qVar.E()) {
                    File n5 = qVar.n();
                    if (n5 != null) {
                        long lastModified = n5.lastModified();
                        DateFormat dateTimeInstance = DateFormat.getDateTimeInstance();
                        this.f26367c.setVisibility(0);
                        this.f26367c.setText(dateTimeInstance.format(new Date(lastModified)));
                        this.f26366b.setText(new C2291k().d(qVar.z(), context));
                        this.f26368d.setVisibility(4);
                        return;
                    }
                    return;
                }
                this.f26368d.setIndeterminate(true);
                this.f26368d.setVisibility(0);
                this.f26367c.setText(R.string.installing);
                this.f26366b.setText(new C2291k().d(qVar.y(), context));
                return;
            }
            TextView textView3 = this.f26366b;
            Q q5 = Q.f24695a;
            String format = String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(qVar.x())}, 1));
            t.d(format, "format(...)");
            textView3.setText(format);
            this.f26367c.setVisibility(8);
            this.f26368d.setProgress(qVar.x());
            this.f26368d.setVisibility(0);
        }
    }
}
