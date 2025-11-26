package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.utils.TypedValues;

public abstract /* synthetic */ class f {
    static {
        String str = TypedValues.PositionType.NAME;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.lang.String r2) {
        /*
            r2.getClass()
            int r0 = r2.hashCode()
            r1 = -1
            switch(r0) {
                case -1812823328: goto L_0x004f;
                case -1127236479: goto L_0x0044;
                case -1017587252: goto L_0x0039;
                case -827014263: goto L_0x002e;
                case -200259324: goto L_0x0023;
                case 428090547: goto L_0x0018;
                case 428090548: goto L_0x000d;
                default: goto L_0x000b;
            }
        L_0x000b:
            r2 = r1
            goto L_0x0059
        L_0x000d:
            java.lang.String r0 = "percentY"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0016
            goto L_0x000b
        L_0x0016:
            r2 = 6
            goto L_0x0059
        L_0x0018:
            java.lang.String r0 = "percentX"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0021
            goto L_0x000b
        L_0x0021:
            r2 = 5
            goto L_0x0059
        L_0x0023:
            java.lang.String r0 = "sizePercent"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x002c
            goto L_0x000b
        L_0x002c:
            r2 = 4
            goto L_0x0059
        L_0x002e:
            java.lang.String r0 = "drawPath"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0037
            goto L_0x000b
        L_0x0037:
            r2 = 3
            goto L_0x0059
        L_0x0039:
            java.lang.String r0 = "percentHeight"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0042
            goto L_0x000b
        L_0x0042:
            r2 = 2
            goto L_0x0059
        L_0x0044:
            java.lang.String r0 = "percentWidth"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x004d
            goto L_0x000b
        L_0x004d:
            r2 = 1
            goto L_0x0059
        L_0x004f:
            java.lang.String r0 = "transitionEasing"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0058
            goto L_0x000b
        L_0x0058:
            r2 = 0
        L_0x0059:
            switch(r2) {
                case 0: goto L_0x006f;
                case 1: goto L_0x006c;
                case 2: goto L_0x0069;
                case 3: goto L_0x0066;
                case 4: goto L_0x0063;
                case 5: goto L_0x0060;
                case 6: goto L_0x005d;
                default: goto L_0x005c;
            }
        L_0x005c:
            return r1
        L_0x005d:
            r2 = 507(0x1fb, float:7.1E-43)
            return r2
        L_0x0060:
            r2 = 506(0x1fa, float:7.09E-43)
            return r2
        L_0x0063:
            r2 = 505(0x1f9, float:7.08E-43)
            return r2
        L_0x0066:
            r2 = 502(0x1f6, float:7.03E-43)
            return r2
        L_0x0069:
            r2 = 504(0x1f8, float:7.06E-43)
            return r2
        L_0x006c:
            r2 = 503(0x1f7, float:7.05E-43)
            return r2
        L_0x006f:
            r2 = 501(0x1f5, float:7.02E-43)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.f.a(java.lang.String):int");
    }

    public static int b(int i5) {
        if (i5 == 100) {
            return 2;
        }
        if (i5 == 101) {
            return 8;
        }
        switch (i5) {
            case TypedValues.PositionType.TYPE_TRANSITION_EASING:
            case TypedValues.PositionType.TYPE_DRAWPATH:
                return 8;
            case TypedValues.PositionType.TYPE_PERCENT_WIDTH:
            case TypedValues.PositionType.TYPE_PERCENT_HEIGHT:
            case TypedValues.PositionType.TYPE_SIZE_PERCENT:
            case TypedValues.PositionType.TYPE_PERCENT_X:
            case TypedValues.PositionType.TYPE_PERCENT_Y:
                return 4;
            case TypedValues.PositionType.TYPE_CURVE_FIT:
                return 2;
            default:
                return -1;
        }
    }
}
