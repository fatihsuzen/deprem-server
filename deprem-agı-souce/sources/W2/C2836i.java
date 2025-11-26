package w2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;

/* renamed from: w2.i  reason: case insensitive filesystem */
public final /* synthetic */ class C2836i implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvAppDetailFragment f26173a;

    public /* synthetic */ C2836i(TvAppDetailFragment tvAppDetailFragment) {
        this.f26173a = tvAppDetailFragment;
    }

    public final void onActivityResult(Object obj) {
        TvAppDetailFragment.k0(this.f26173a, (ActivityResult) obj);
    }
}
