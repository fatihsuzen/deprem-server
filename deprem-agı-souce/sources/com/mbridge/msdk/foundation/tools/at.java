package com.mbridge.msdk.foundation.tools;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.concurrent.atomic.AtomicInteger;

public final class at {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f9670a = new AtomicInteger(1);

    public static void a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static int a() {
        AtomicInteger atomicInteger;
        int i5;
        int i6;
        do {
            atomicInteger = f9670a;
            i5 = atomicInteger.get();
            i6 = i5 + 1;
            if (i6 > 16777215) {
                i6 = 1;
            }
        } while (!atomicInteger.compareAndSet(i5, i6));
        return i5;
    }
}
