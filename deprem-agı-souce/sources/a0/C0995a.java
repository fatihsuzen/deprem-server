package a0;

import android.os.Build;

/* renamed from: a0.a  reason: case insensitive filesystem */
public abstract class C0995a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f4506a;

    static {
        int i5;
        if (Build.VERSION.SDK_INT >= 31) {
            i5 = 33554432;
        } else {
            i5 = 0;
        }
        f4506a = i5;
    }
}
