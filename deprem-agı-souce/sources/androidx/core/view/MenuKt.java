package androidx.core.view;

import W2.J;
import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import k3.l;
import k3.p;
import kotlin.jvm.internal.t;
import s3.C2751e;

public final class MenuKt {
    public static final boolean contains(Menu menu, MenuItem menuItem) {
        int size = menu.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (t.a(menu.getItem(i5), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(Menu menu, l lVar) {
        int size = menu.size();
        for (int i5 = 0; i5 < size; i5++) {
            lVar.invoke(menu.getItem(i5));
        }
    }

    public static final void forEachIndexed(Menu menu, p pVar) {
        int size = menu.size();
        for (int i5 = 0; i5 < size; i5++) {
            pVar.invoke(Integer.valueOf(i5), menu.getItem(i5));
        }
    }

    public static final MenuItem get(Menu menu, int i5) {
        return menu.getItem(i5);
    }

    public static final C2751e getChildren(Menu menu) {
        return new MenuKt$children$1(menu);
    }

    public static final int getSize(Menu menu) {
        return menu.size();
    }

    public static final boolean isEmpty(Menu menu) {
        if (menu.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(Menu menu) {
        if (menu.size() != 0) {
            return true;
        }
        return false;
    }

    public static final Iterator<MenuItem> iterator(Menu menu) {
        return new MenuKt$iterator$1(menu);
    }

    public static final void minusAssign(Menu menu, MenuItem menuItem) {
        menu.removeItem(menuItem.getItemId());
    }

    public static final void removeItemAt(Menu menu, int i5) {
        J j5;
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
}
