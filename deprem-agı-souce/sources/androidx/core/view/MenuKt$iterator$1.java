package androidx.core.view;

import W2.J;
import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import l3.C2677a;

public final class MenuKt$iterator$1 implements Iterator<MenuItem>, C2677a {
    final /* synthetic */ Menu $this_iterator;
    private int index;

    MenuKt$iterator$1(Menu menu) {
        this.$this_iterator = menu;
    }

    public boolean hasNext() {
        if (this.index < this.$this_iterator.size()) {
            return true;
        }
        return false;
    }

    public void remove() {
        J j5;
        Menu menu = this.$this_iterator;
        int i5 = this.index - 1;
        this.index = i5;
        MenuItem item = menu.getItem(i5);
        if (item != null) {
            menu.removeItem(item.getItemId());
            j5 = J.f19942a;
        } else {
            j5 = null;
        }
        if (j5 == null) {
            throw new IndexOutOfBoundsException();
        }
    }

    public MenuItem next() {
        Menu menu = this.$this_iterator;
        int i5 = this.index;
        this.index = i5 + 1;
        MenuItem item = menu.getItem(i5);
        if (item != null) {
            return item;
        }
        throw new IndexOutOfBoundsException();
    }
}
