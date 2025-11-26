package com.google.android.material.datepicker;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import com.google.android.material.internal.ViewUtils;

public abstract /* synthetic */ class e {
    public static boolean a(Context context) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void b(EditText[] editTextArr, View view, boolean z4) {
        int length = editTextArr.length;
        int i5 = 0;
        while (i5 < length) {
            if (!editTextArr[i5].hasFocus()) {
                i5++;
            } else {
                return;
            }
        }
        ViewUtils.hideKeyboard(view, false);
    }

    public static void d(EditText... editTextArr) {
        if (editTextArr.length != 0) {
            c cVar = new c(editTextArr);
            for (EditText onFocusChangeListener : editTextArr) {
                onFocusChangeListener.setOnFocusChangeListener(cVar);
            }
            EditText editText = editTextArr[0];
            editText.postDelayed(new d(editText), 100);
        }
    }
}
