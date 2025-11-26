package B2;

import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.uptodown.R;
import kotlin.jvm.internal.t;

public abstract class v {
    public static final void a(TextView textView) {
        t.e(textView, "<this>");
        textView.setVisibility(0);
        textView.setBackground(ContextCompat.getDrawable(textView.getContext(), R.drawable.ripple_blue_primary_button));
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.white));
    }

    public static final void b(TextView textView) {
        t.e(textView, "<this>");
        textView.setVisibility(0);
        textView.setBackground(ContextCompat.getDrawable(textView.getContext(), R.drawable.ripple_open_button));
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.blue_primary));
    }

    public static final void c(TextView textView) {
        t.e(textView, "<this>");
        textView.setVisibility(0);
        textView.setBackground(ContextCompat.getDrawable(textView.getContext(), R.drawable.ripple_install_button));
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.white));
    }

    public static final void d(TextView textView) {
        t.e(textView, "<this>");
        textView.setVisibility(0);
        textView.setBackground(ContextCompat.getDrawable(textView.getContext(), R.drawable.ripple_cancel_button));
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.white));
    }
}
