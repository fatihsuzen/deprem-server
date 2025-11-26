package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import s3.C2751e;

public final class MenuKt$children$1 implements C2751e {
    final /* synthetic */ Menu $this_children;

    MenuKt$children$1(Menu menu) {
        this.$this_children = menu;
    }

    public Iterator<MenuItem> iterator() {
        return MenuKt.iterator(this.$this_children);
    }
}
