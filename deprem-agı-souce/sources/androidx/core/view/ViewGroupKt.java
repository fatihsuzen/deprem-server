package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import java.util.Iterator;
import k3.l;
import k3.p;
import q3.C2728d;
import q3.C2729e;
import s3.C2751e;

public final class ViewGroupKt {
    public static final boolean contains(ViewGroup viewGroup, View view) {
        if (viewGroup.indexOfChild(view) != -1) {
            return true;
        }
        return false;
    }

    public static final void forEach(ViewGroup viewGroup, l lVar) {
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            lVar.invoke(viewGroup.getChildAt(i5));
        }
    }

    public static final void forEachIndexed(ViewGroup viewGroup, p pVar) {
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            pVar.invoke(Integer.valueOf(i5), viewGroup.getChildAt(i5));
        }
    }

    public static final View get(ViewGroup viewGroup, int i5) {
        View childAt = viewGroup.getChildAt(i5);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i5 + ", Size: " + viewGroup.getChildCount());
    }

    public static final C2751e getChildren(ViewGroup viewGroup) {
        return new ViewGroupKt$children$1(viewGroup);
    }

    public static final C2751e getDescendants(ViewGroup viewGroup) {
        return new ViewGroupKt$special$$inlined$Sequence$1(viewGroup);
    }

    public static final C2728d getIndices(ViewGroup viewGroup) {
        return C2729e.l(0, viewGroup.getChildCount());
    }

    public static final int getSize(ViewGroup viewGroup) {
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup viewGroup) {
        if (viewGroup.getChildCount() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(ViewGroup viewGroup) {
        if (viewGroup.getChildCount() != 0) {
            return true;
        }
        return false;
    }

    public static final Iterator<View> iterator(ViewGroup viewGroup) {
        return new ViewGroupKt$iterator$1(viewGroup);
    }

    public static final void minusAssign(ViewGroup viewGroup, View view) {
        viewGroup.removeView(view);
    }

    public static final void plusAssign(ViewGroup viewGroup, View view) {
        viewGroup.addView(view);
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i5) {
        marginLayoutParams.setMargins(i5, i5, i5, i5);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i5, @Px int i6, @Px int i7, @Px int i8) {
        marginLayoutParams.setMargins(i5, i6, i7, i8);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i5, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i5 = marginLayoutParams.leftMargin;
        }
        if ((i9 & 2) != 0) {
            i6 = marginLayoutParams.topMargin;
        }
        if ((i9 & 4) != 0) {
            i7 = marginLayoutParams.rightMargin;
        }
        if ((i9 & 8) != 0) {
            i8 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMargins(i5, i6, i7, i8);
    }

    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i5, @Px int i6, @Px int i7, @Px int i8) {
        marginLayoutParams.setMarginStart(i5);
        marginLayoutParams.topMargin = i6;
        marginLayoutParams.setMarginEnd(i7);
        marginLayoutParams.bottomMargin = i8;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i5, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i5 = marginLayoutParams.getMarginStart();
        }
        if ((i9 & 2) != 0) {
            i6 = marginLayoutParams.topMargin;
        }
        if ((i9 & 4) != 0) {
            i7 = marginLayoutParams.getMarginEnd();
        }
        if ((i9 & 8) != 0) {
            i8 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMarginStart(i5);
        marginLayoutParams.topMargin = i6;
        marginLayoutParams.setMarginEnd(i7);
        marginLayoutParams.bottomMargin = i8;
    }
}
