package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.R;

public class ChildrenAlphaProperty extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> CHILDREN_ALPHA = new ChildrenAlphaProperty("childrenAlpha");

    private ChildrenAlphaProperty(String str) {
        super(Float.class, str);
    }

    @NonNull
    public Float get(@NonNull ViewGroup viewGroup) {
        Float f5 = (Float) viewGroup.getTag(R.id.mtrl_internal_children_alpha_tag);
        if (f5 != null) {
            return f5;
        }
        return Float.valueOf(1.0f);
    }

    public void set(@NonNull ViewGroup viewGroup, @NonNull Float f5) {
        float floatValue = f5.floatValue();
        viewGroup.setTag(R.id.mtrl_internal_children_alpha_tag, f5);
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            viewGroup.getChildAt(i5).setAlpha(floatValue);
        }
    }
}
