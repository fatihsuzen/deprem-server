package com.google.android.material.button;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialSplitButton extends MaterialButtonGroup {
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_MaterialSplitButton;
    private static final int REQUIRED_BUTTON_COUNT = 2;

    public MaterialSplitButton(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public static /* synthetic */ void b(MaterialSplitButton materialSplitButton, MaterialButton materialButton, boolean z4) {
        int i5;
        Resources resources = materialSplitButton.getResources();
        if (z4) {
            i5 = R.string.mtrl_button_expanded_content_description;
        } else {
            i5 = R.string.mtrl_button_collapsed_content_description;
        }
        materialButton.setStateDescription(resources.getString(i5));
    }

    public void addView(@NonNull View view, int i5, @Nullable ViewGroup.LayoutParams layoutParams) {
        int i6;
        if (!(view instanceof MaterialButton)) {
            throw new IllegalArgumentException("MaterialSplitButton can only hold MaterialButtons.");
        } else if (getChildCount() <= 2) {
            MaterialButton materialButton = (MaterialButton) view;
            super.addView(view, i5, layoutParams);
            if (indexOfChild(view) == 1) {
                materialButton.setCheckable(true);
                materialButton.setA11yClassName(Button.class.getName());
                if (Build.VERSION.SDK_INT >= 30) {
                    Resources resources = getResources();
                    if (materialButton.isChecked()) {
                        i6 = R.string.mtrl_button_expanded_content_description;
                    } else {
                        i6 = R.string.mtrl_button_collapsed_content_description;
                    }
                    materialButton.setStateDescription(resources.getString(i6));
                    materialButton.addOnCheckedChangeListener(new e(this));
                }
            }
        } else {
            throw new IllegalArgumentException("MaterialSplitButton can only hold two MaterialButtons.");
        }
    }

    public MaterialSplitButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialSplitButtonStyle);
    }

    public MaterialSplitButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i5, DEF_STYLE_RES), attributeSet, i5);
    }
}
