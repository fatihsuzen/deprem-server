package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.app.AppCompatViewInflater;

public class LeanbackAppCompatViewInflater extends AppCompatViewInflater {
    /* access modifiers changed from: protected */
    public View createView(Context context, String str, AttributeSet attributeSet) {
        str.getClass();
        if (!str.equals("androidx.leanback.widget.GuidedActionEditText")) {
            return null;
        }
        return new GuidedActionAppCompatEditText(context, attributeSet);
    }
}
