package w2;

import android.view.View;
import androidx.leanback.widget.Presenter;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;
import l2.C2655d;

/* renamed from: w2.G  reason: case insensitive filesystem */
public final /* synthetic */ class C2812G implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvMyAppsFragment f26132a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2655d f26133b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Presenter.ViewHolder f26134c;

    public /* synthetic */ C2812G(TvMyAppsFragment tvMyAppsFragment, C2655d dVar, Presenter.ViewHolder viewHolder) {
        this.f26132a = tvMyAppsFragment;
        this.f26133b = dVar;
        this.f26134c = viewHolder;
    }

    public final void onClick(View view) {
        TvMyAppsFragment.D(this.f26132a, this.f26133b, this.f26134c, view);
    }
}
