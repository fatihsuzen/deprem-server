package com.google.android.gms.common.util;

import N.C0720n;

public abstract class b {
    public static boolean a(int[] iArr, int i5) {
        if (iArr != null) {
            for (int i6 : iArr) {
                if (i6 == i5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(Object[] objArr, Object obj) {
        int i5;
        if (objArr != null) {
            i5 = objArr.length;
        } else {
            i5 = 0;
        }
        int i6 = 0;
        while (true) {
            if (i6 >= i5) {
                break;
            } else if (!C0720n.a(objArr[i6], obj)) {
                i6++;
            } else if (i6 >= 0) {
                return true;
            }
        }
        return false;
    }
}
