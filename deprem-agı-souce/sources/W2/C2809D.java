package w2;

import com.uptodown.tv.ui.fragment.TvMyAppsFragment;
import java.util.Comparator;
import k3.p;

/* renamed from: w2.D  reason: case insensitive filesystem */
public final /* synthetic */ class C2809D implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f26130a;

    public /* synthetic */ C2809D(p pVar) {
        this.f26130a = pVar;
    }

    public final int compare(Object obj, Object obj2) {
        return TvMyAppsFragment.S(this.f26130a, obj, obj2);
    }
}
