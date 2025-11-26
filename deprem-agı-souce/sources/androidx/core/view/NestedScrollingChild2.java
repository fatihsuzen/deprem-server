package androidx.core.view;

import androidx.annotation.Nullable;

public interface NestedScrollingChild2 extends NestedScrollingChild {
    boolean dispatchNestedPreScroll(int i5, int i6, @Nullable int[] iArr, @Nullable int[] iArr2, int i7);

    boolean dispatchNestedScroll(int i5, int i6, int i7, int i8, @Nullable int[] iArr, int i9);

    boolean hasNestedScrollingParent(int i5);

    boolean startNestedScroll(int i5, int i6);

    void stopNestedScroll(int i5);
}
