package O2;

import androidx.appcompat.widget.SearchView;
import c.h;
import java.util.List;
import kotlin.jvm.internal.t;

public final class b implements SearchView.OnQueryTextListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f18807a;

    public b(i iVar) {
        this.f18807a = iVar;
    }

    public final boolean onQueryTextChange(String str) {
        boolean z4;
        t.e(str, "newText");
        h hVar = this.f18807a.f18828p;
        l lVar = null;
        if (hVar == null) {
            t.w("switchAdapter");
            hVar = null;
        }
        l lVar2 = this.f18807a.f18827o;
        if (lVar2 == null) {
            t.w("viewModel");
        } else {
            lVar = lVar2;
        }
        List c5 = lVar.c(str);
        if (str.length() > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        hVar.getClass();
        t.e(c5, "switchItems");
        hVar.f884a = c5;
        if (!z4) {
            hVar.a();
        }
        hVar.notifyDataSetChanged();
        return true;
    }

    public final boolean onQueryTextSubmit(String str) {
        return true;
    }
}
