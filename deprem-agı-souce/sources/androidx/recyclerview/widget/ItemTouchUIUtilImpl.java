package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;

class ItemTouchUIUtilImpl implements ItemTouchUIUtil {
    static final ItemTouchUIUtil INSTANCE = new ItemTouchUIUtilImpl();

    ItemTouchUIUtilImpl() {
    }

    private static float findMaxElevation(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f5 = 0.0f;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = recyclerView.getChildAt(i5);
            if (childAt != view) {
                float elevation = ViewCompat.getElevation(childAt);
                if (elevation > f5) {
                    f5 = elevation;
                }
            }
        }
        return f5;
    }

    public void clearView(@NonNull View view) {
        int i5 = R.id.item_touch_helper_previous_elevation;
        Object tag = view.getTag(i5);
        if (tag instanceof Float) {
            ViewCompat.setElevation(view, ((Float) tag).floatValue());
        }
        view.setTag(i5, (Object) null);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull View view, float f5, float f6, int i5, boolean z4) {
        if (z4) {
            int i6 = R.id.item_touch_helper_previous_elevation;
            if (view.getTag(i6) == null) {
                Float valueOf = Float.valueOf(ViewCompat.getElevation(view));
                ViewCompat.setElevation(view, findMaxElevation(recyclerView, view) + 1.0f);
                view.setTag(i6, valueOf);
            }
        }
        view.setTranslationX(f5);
        view.setTranslationY(f6);
    }

    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull View view, float f5, float f6, int i5, boolean z4) {
    }

    public void onSelected(@NonNull View view) {
    }
}
