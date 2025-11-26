package w2;

import android.view.View;
import com.uptodown.tv.ui.fragment.TvMyDownloadsFragment;
import l2.C2668q;

/* renamed from: w2.M  reason: case insensitive filesystem */
public final /* synthetic */ class C2818M implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2668q f26145a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TvMyDownloadsFragment f26146b;

    public /* synthetic */ C2818M(C2668q qVar, TvMyDownloadsFragment tvMyDownloadsFragment) {
        this.f26145a = qVar;
        this.f26146b = tvMyDownloadsFragment;
    }

    public final void onClick(View view) {
        TvMyDownloadsFragment.p(this.f26145a, this.f26146b, view);
    }
}
