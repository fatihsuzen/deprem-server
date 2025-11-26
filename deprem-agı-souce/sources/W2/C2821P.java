package w2;

import android.content.DialogInterface;
import com.uptodown.tv.ui.fragment.TvOldVersionsFragment;

/* renamed from: w2.P  reason: case insensitive filesystem */
public final /* synthetic */ class C2821P implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvOldVersionsFragment f26148a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f26149b;

    public /* synthetic */ C2821P(TvOldVersionsFragment tvOldVersionsFragment, String str) {
        this.f26148a = tvOldVersionsFragment;
        this.f26149b = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i5) {
        TvOldVersionsFragment.p(this.f26148a, this.f26149b, dialogInterface, i5);
    }
}
