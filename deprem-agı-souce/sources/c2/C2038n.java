package C2;

import D2.n;
import W2.J;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.t;

/* renamed from: C2.n  reason: case insensitive filesystem */
public abstract class C2038n extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private boolean f17840a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2038n(View view) {
        super(view);
        t.e(view, "itemView");
    }

    /* access modifiers changed from: private */
    public static final J d(ProgressBar progressBar, C2038n nVar) {
        progressBar.setVisibility(8);
        nVar.f17840a = false;
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J f(C2038n nVar) {
        nVar.f17840a = false;
        return J.f19942a;
    }

    public final void c(ProgressBar progressBar, ImageView imageView) {
        t.e(progressBar, "pb");
        t.e(imageView, "ivIcon");
        if (progressBar.getVisibility() == 0 && !this.f17840a) {
            this.f17840a = true;
            Context context = this.itemView.getContext();
            t.d(context, "getContext(...)");
            new n(context).j(imageView, new C2035m(progressBar, this));
        }
    }

    public final void e(ProgressBar progressBar, ImageView imageView) {
        t.e(progressBar, "pb");
        t.e(imageView, "ivIcon");
        if (progressBar.getVisibility() == 8 && !this.f17840a) {
            progressBar.setVisibility(0);
            this.f17840a = true;
            Context context = this.itemView.getContext();
            t.d(context, "getContext(...)");
            new n(context).l(imageView, new C2032l(this));
        }
    }
}
