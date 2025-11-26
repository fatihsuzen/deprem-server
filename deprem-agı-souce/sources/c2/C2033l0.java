package C2;

import S1.k;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.uptodown.R;
import k2.C2612w;
import kotlin.jvm.internal.t;

/* renamed from: C2.l0  reason: case insensitive filesystem */
public final class C2033l0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final C2612w f17827a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f17828b;

    /* renamed from: c  reason: collision with root package name */
    private final ImageView f17829c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2033l0(View view, String str, C2612w wVar) {
        super(view);
        t.e(view, "itemView");
        t.e(str, MimeTypes.BASE_TYPE_TEXT);
        this.f17827a = wVar;
        View findViewById = view.findViewById(R.id.tv_myappsupdates_title);
        t.d(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        this.f17828b = textView;
        this.f17829c = (ImageView) view.findViewById(R.id.iv_myappsupdates_info);
        textView.setTypeface(k.f32g.w());
        textView.setText(str);
    }

    /* access modifiers changed from: private */
    public static final void d(C2033l0 l0Var, View view) {
        l0Var.f17827a.a();
    }

    /* access modifiers changed from: private */
    public static final void f(C2033l0 l0Var, View view) {
        l0Var.f17827a.a();
    }

    public final void c(boolean z4) {
        if (z4) {
            this.f17828b.setVisibility(0);
        } else {
            this.f17828b.setVisibility(8);
        }
        if (this.f17827a != null) {
            ImageView imageView = this.f17829c;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.f17829c;
            if (imageView2 != null) {
                imageView2.setOnClickListener(new C2030k0(this));
                return;
            }
            return;
        }
        ImageView imageView3 = this.f17829c;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
    }

    public final void e(boolean z4) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, (int) this.itemView.getContext().getResources().getDimension(R.dimen.margin_l), 0, 0);
        this.itemView.setLayoutParams(layoutParams);
        if (z4) {
            this.f17828b.setVisibility(0);
        } else {
            this.f17828b.setVisibility(8);
        }
        if (this.f17827a != null) {
            ImageView imageView = this.f17829c;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.f17829c;
            if (imageView2 != null) {
                imageView2.setOnClickListener(new C2027j0(this));
                return;
            }
            return;
        }
        ImageView imageView3 = this.f17829c;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
    }
}
