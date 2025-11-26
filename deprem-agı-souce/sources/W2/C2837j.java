package w2;

import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.OnActionClickedListener;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;

/* renamed from: w2.j  reason: case insensitive filesystem */
public final /* synthetic */ class C2837j implements OnActionClickedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvAppDetailFragment f26174a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f26175b;

    public /* synthetic */ C2837j(TvAppDetailFragment tvAppDetailFragment, FragmentActivity fragmentActivity) {
        this.f26174a = tvAppDetailFragment;
        this.f26175b = fragmentActivity;
    }

    public final void onActionClicked(Action action) {
        TvAppDetailFragment.H0(this.f26174a, this.f26175b, action);
    }
}
