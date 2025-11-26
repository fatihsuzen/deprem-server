package C2;

import S1.k;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import b2.C2301u;
import com.uptodown.R;
import k2.C2590G;
import kotlin.jvm.internal.t;
import l2.C2655d;

public final class Q0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final C2590G f17578a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f17579b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f17580c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f17581d;

    /* renamed from: e  reason: collision with root package name */
    private final ImageView f17582e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Q0(View view, C2590G g5) {
        super(view);
        t.e(view, "itemView");
        this.f17578a = g5;
        View findViewById = view.findViewById(R.id.tv_name_rollback_item);
        t.d(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        this.f17579b = textView;
        View findViewById2 = view.findViewById(R.id.tv_version_rollback_item);
        t.d(findViewById2, "findViewById(...)");
        TextView textView2 = (TextView) findViewById2;
        this.f17580c = textView2;
        View findViewById3 = view.findViewById(R.id.tv_size_rollback_item);
        t.d(findViewById3, "findViewById(...)");
        TextView textView3 = (TextView) findViewById3;
        this.f17581d = textView3;
        View findViewById4 = view.findViewById(R.id.iv_icon_rollback_item);
        t.d(findViewById4, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById4;
        this.f17582e = imageView;
        view.setOnClickListener(new O0(this));
        imageView.setOnClickListener(new P0(this));
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        textView2.setTypeface(aVar.x());
        textView3.setTypeface(aVar.w());
    }

    /* access modifiers changed from: private */
    public static final void c(Q0 q02, View view) {
        int bindingAdapterPosition;
        if (q02.f17578a != null && (bindingAdapterPosition = q02.getBindingAdapterPosition()) != -1) {
            q02.f17578a.a(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final void d(Q0 q02, View view) {
        int bindingAdapterPosition;
        if (q02.f17578a != null && (bindingAdapterPosition = q02.getBindingAdapterPosition()) != -1) {
            q02.f17578a.b(bindingAdapterPosition);
        }
    }

    public final void e(C2655d dVar, Context context) {
        t.e(dVar, "item");
        t.e(context, "context");
        try {
            PackageManager packageManager = context.getPackageManager();
            t.d(packageManager, "getPackageManager(...)");
            String o5 = dVar.o();
            t.b(o5);
            ApplicationInfo applicationInfo = C2301u.d(packageManager, o5, 0).applicationInfo;
            if (applicationInfo != null) {
                ImageView imageView = this.f17582e;
                t.b(applicationInfo);
                imageView.setImageDrawable(applicationInfo.loadIcon(context.getPackageManager()));
            }
        } catch (Exception e5) {
            this.f17582e.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_uptodown_logo_disabled));
            e5.printStackTrace();
        }
        this.f17579b.setText(dVar.m());
        this.f17580c.setText(dVar.B());
        this.f17581d.setText(dVar.u(context));
    }
}
