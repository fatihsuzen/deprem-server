package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

public interface NestedScrollingParent {
    int getNestedScrollAxes();

    boolean onNestedFling(@NonNull View view, float f5, float f6, boolean z4);

    boolean onNestedPreFling(@NonNull View view, float f5, float f6);

    void onNestedPreScroll(@NonNull View view, int i5, int i6, @NonNull int[] iArr);

    void onNestedScroll(@NonNull View view, int i5, int i6, int i7, int i8);

    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i5);

    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i5);

    void onStopNestedScroll(@NonNull View view);
}
