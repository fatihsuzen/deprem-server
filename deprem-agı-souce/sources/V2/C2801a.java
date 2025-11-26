package v2;

import androidx.fragment.app.Fragment;
import com.uptodown.tv.ui.activity.TvAppDetailActivity;

/* renamed from: v2.a  reason: case insensitive filesystem */
public final /* synthetic */ class C2801a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Fragment f26037a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TvAppDetailActivity.c f26038b;

    public /* synthetic */ C2801a(Fragment fragment, TvAppDetailActivity.c cVar) {
        this.f26037a = fragment;
        this.f26038b = cVar;
    }

    public final void run() {
        TvAppDetailActivity.c.b(this.f26037a, this.f26038b);
    }
}
