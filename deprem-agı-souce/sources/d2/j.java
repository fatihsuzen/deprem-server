package D2;

import android.text.TextUtils;
import android.widget.TextView;
import kotlin.jvm.internal.t;

public abstract class j {
    public static final void b(TextView textView) {
        t.e(textView, "<this>");
        textView.postDelayed(new i(textView), 3000);
    }

    /* access modifiers changed from: private */
    public static final void c(TextView textView) {
        textView.setSelected(true);
    }

    public static final void d(TextView textView) {
        t.e(textView, "<this>");
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setMarqueeRepeatLimit(1);
        textView.setFocusable(true);
        textView.setFocusableInTouchMode(true);
        textView.setHorizontallyScrolling(true);
    }
}
