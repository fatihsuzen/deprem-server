package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.utils.TypedValues;

public abstract /* synthetic */ class d {
    static {
        String str = TypedValues.MotionScene.NAME;
    }

    public static int a(String str) {
        str.getClass();
        if (str.equals(TypedValues.MotionScene.S_DEFAULT_DURATION)) {
            return 600;
        }
        if (!str.equals(TypedValues.MotionScene.S_LAYOUT_DURING_TRANSITION)) {
            return -1;
        }
        return 601;
    }

    public static int b(int i5) {
        if (i5 == 600) {
            return 2;
        }
        if (i5 != 601) {
            return -1;
        }
        return 1;
    }
}
