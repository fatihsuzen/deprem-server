package w2;

import android.content.DialogInterface;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import l2.C2668q;

/* renamed from: w2.g  reason: case insensitive filesystem */
public final /* synthetic */ class C2834g implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvAppDetailFragment f26171a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2668q f26172b;

    public /* synthetic */ C2834g(TvAppDetailFragment tvAppDetailFragment, C2668q qVar) {
        this.f26171a = tvAppDetailFragment;
        this.f26172b = qVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i5) {
        TvAppDetailFragment.S(this.f26171a, this.f26172b, dialogInterface, i5);
    }
}
