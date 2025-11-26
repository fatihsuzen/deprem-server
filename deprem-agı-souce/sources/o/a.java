package o;

import androidx.appcompat.widget.SearchView;
import c.h;
import java.util.List;
import kotlin.jvm.internal.t;

public final class a implements SearchView.OnQueryTextListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f962a;

    public a(i iVar) {
        this.f962a = iVar;
    }

    public final boolean onQueryTextChange(String str) {
        boolean z4;
        t.e(str, "newText");
        h hVar = this.f962a.f985s;
        k kVar = null;
        if (hVar == null) {
            t.w("switchAdapter");
            hVar = null;
        }
        k kVar2 = this.f962a.f983q;
        if (kVar2 == null) {
            t.w("viewModel");
        } else {
            kVar = kVar2;
        }
        List c5 = kVar.c(str);
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
