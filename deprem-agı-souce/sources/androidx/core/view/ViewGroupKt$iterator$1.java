package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import l3.C2677a;

public final class ViewGroupKt$iterator$1 implements Iterator<View>, C2677a {
    final /* synthetic */ ViewGroup $this_iterator;
    private int index;

    ViewGroupKt$iterator$1(ViewGroup viewGroup) {
        this.$this_iterator = viewGroup;
    }

    public boolean hasNext() {
        if (this.index < this.$this_iterator.getChildCount()) {
            return true;
        }
        return false;
    }

    public void remove() {
        ViewGroup viewGroup = this.$this_iterator;
        int i5 = this.index - 1;
        this.index = i5;
        viewGroup.removeViewAt(i5);
    }

    public View next() {
        ViewGroup viewGroup = this.$this_iterator;
        int i5 = this.index;
        this.index = i5 + 1;
        View childAt = viewGroup.getChildAt(i5);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException();
    }
}
