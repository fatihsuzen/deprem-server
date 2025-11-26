package w2;

import android.content.DialogInterface;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import l2.C2668q;

/* renamed from: w2.k  reason: case insensitive filesystem */
public final /* synthetic */ class C2838k implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2668q f26176a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TvAppDetailFragment f26177b;

    public /* synthetic */ C2838k(C2668q qVar, TvAppDetailFragment tvAppDetailFragment) {
        this.f26176a = qVar;
        this.f26177b = tvAppDetailFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i5) {
        TvAppDetailFragment.P(this.f26176a, this.f26177b, dialogInterface, i5);
    }
}
