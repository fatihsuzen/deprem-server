package com.mbridge.msdk.video.dynview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

public class ObservableScrollView extends HorizontalScrollView {

    /* renamed from: a  reason: collision with root package name */
    private a f12290a = null;

    public ObservableScrollView(Context context) {
        super(context);
    }

    public void fling(int i5) {
        super.fling(i5 / 4);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i5, int i6, int i7, int i8) {
        super.onScrollChanged(i5, i6, i7, i8);
        a aVar = this.f12290a;
        if (aVar != null) {
            aVar.a(this, i5, i6, i7, i8);
        }
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
