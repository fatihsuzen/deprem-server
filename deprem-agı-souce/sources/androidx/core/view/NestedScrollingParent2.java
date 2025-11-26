package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

public interface NestedScrollingParent2 extends NestedScrollingParent {
    void onNestedPreScroll(@NonNull View view, int i5, int i6, @NonNull int[] iArr, int i7);

    void onNestedScroll(@NonNull View view, int i5, int i6, int i7, int i8, int i9);

    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i5, int i6);

    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i5, int i6);

    void onStopNestedScroll(@NonNull View view, int i5);
}
