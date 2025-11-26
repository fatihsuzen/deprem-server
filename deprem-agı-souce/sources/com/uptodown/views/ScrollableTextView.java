package com.uptodown.views;

import D2.j;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.jvm.internal.t;

public final class ScrollableTextView extends AppCompatTextView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        t.e(context, "context");
        if (getText().toString().length() > 0) {
            j.d(this);
            j.b(this);
        }
    }
}
