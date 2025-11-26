package androidx.preference;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;

public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
    }

    public boolean isEnabled() {
        return false;
    }

    public void onBindViewHolder(@NonNull PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        if (Build.VERSION.SDK_INT >= 28) {
            preferenceViewHolder.itemView.setAccessibilityHeading(true);
        }
    }

    public boolean shouldDisableDependents() {
        return !super.isEnabled();
    }

    public PreferenceCategory(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public PreferenceCategory(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, R.attr.preferenceCategoryStyle, 16842892));
    }

    public PreferenceCategory(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }
}
