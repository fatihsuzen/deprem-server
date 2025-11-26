package B2;

import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class k implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f17347a = new a((C2633k) null);

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final void a(TextView textView) {
            t.e(textView, "<this>");
            textView.setOnTouchListener(new k());
        }

        private a() {
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action;
        boolean z4;
        t.e(view, "v");
        t.e(motionEvent, NotificationCompat.CATEGORY_EVENT);
        TextView textView = (TextView) view;
        CharSequence text = textView.getText();
        t.d(text, "getText(...)");
        if ((text instanceof Spanned) && ((action = motionEvent.getAction()) == 0 || action == 1)) {
            int x4 = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y4 = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x4 + textView.getScrollX();
            int scrollY = y4 + textView.getScrollY();
            Layout layout = textView.getLayout();
            t.d(layout, "getLayout(...)");
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spanned) text).getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            t.b(clickableSpanArr);
            if (clickableSpanArr.length == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                if (action == 1) {
                    clickableSpanArr[0].onClick(textView);
                }
                return true;
            }
        }
        return false;
    }
}
