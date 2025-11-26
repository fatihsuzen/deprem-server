package B2;

import android.text.Layout;
import android.widget.TextView;
import kotlin.jvm.internal.t;

public abstract class s {
    public static final boolean a(TextView textView) {
        int lineCount;
        t.e(textView, "<this>");
        Layout layout = textView.getLayout();
        if (layout == null || (lineCount = layout.getLineCount()) <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
            return false;
        }
        return true;
    }
}
