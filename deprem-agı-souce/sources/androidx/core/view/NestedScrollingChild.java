package androidx.core.view;

import androidx.annotation.Nullable;

public interface NestedScrollingChild {
    boolean dispatchNestedFling(float f5, float f6, boolean z4);

    boolean dispatchNestedPreFling(float f5, float f6);

    boolean dispatchNestedPreScroll(int i5, int i6, @Nullable int[] iArr, @Nullable int[] iArr2);

    boolean dispatchNestedScroll(int i5, int i6, int i7, int i8, @Nullable int[] iArr);

    boolean hasNestedScrollingParent();

    boolean isNestedScrollingEnabled();

    void setNestedScrollingEnabled(boolean z4);

    boolean startNestedScroll(int i5);

    void stopNestedScroll();
}
