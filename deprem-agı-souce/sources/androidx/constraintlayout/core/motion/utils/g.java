package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.utils.TypedValues;

public abstract /* synthetic */ class g {
    static {
        String str = TypedValues.TransitionType.NAME;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.lang.String r2) {
        /*
            r2.getClass()
            int r0 = r2.hashCode()
            r1 = -1
            switch(r0) {
                case -1996906958: goto L_0x005b;
                case -1992012396: goto L_0x0050;
                case -1357874275: goto L_0x0045;
                case -1298065308: goto L_0x003a;
                case 3707: goto L_0x002f;
                case 3151786: goto L_0x0024;
                case 1310733335: goto L_0x0019;
                case 1839260940: goto L_0x000e;
                default: goto L_0x000b;
            }
        L_0x000b:
            r2 = r1
            goto L_0x0065
        L_0x000e:
            java.lang.String r0 = "staggered"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0017
            goto L_0x000b
        L_0x0017:
            r2 = 7
            goto L_0x0065
        L_0x0019:
            java.lang.String r0 = "pathMotionArc"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0022
            goto L_0x000b
        L_0x0022:
            r2 = 6
            goto L_0x0065
        L_0x0024:
            java.lang.String r0 = "from"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x002d
            goto L_0x000b
        L_0x002d:
            r2 = 5
            goto L_0x0065
        L_0x002f:
            java.lang.String r0 = "to"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0038
            goto L_0x000b
        L_0x0038:
            r2 = 4
            goto L_0x0065
        L_0x003a:
            java.lang.String r0 = "autoTransition"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0043
            goto L_0x000b
        L_0x0043:
            r2 = 3
            goto L_0x0065
        L_0x0045:
            java.lang.String r0 = "motionInterpolator"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x004e
            goto L_0x000b
        L_0x004e:
            r2 = 2
            goto L_0x0065
        L_0x0050:
            java.lang.String r0 = "duration"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0059
            goto L_0x000b
        L_0x0059:
            r2 = 1
            goto L_0x0065
        L_0x005b:
            java.lang.String r0 = "transitionFlags"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0064
            goto L_0x000b
        L_0x0064:
            r2 = 0
        L_0x0065:
            switch(r2) {
                case 0: goto L_0x007e;
                case 1: goto L_0x007b;
                case 2: goto L_0x0078;
                case 3: goto L_0x0075;
                case 4: goto L_0x0072;
                case 5: goto L_0x006f;
                case 6: goto L_0x006c;
                case 7: goto L_0x0069;
                default: goto L_0x0068;
            }
        L_0x0068:
            return r1
        L_0x0069:
            r2 = 706(0x2c2, float:9.9E-43)
            return r2
        L_0x006c:
            r2 = 509(0x1fd, float:7.13E-43)
            return r2
        L_0x006f:
            r2 = 701(0x2bd, float:9.82E-43)
            return r2
        L_0x0072:
            r2 = 702(0x2be, float:9.84E-43)
            return r2
        L_0x0075:
            r2 = 704(0x2c0, float:9.87E-43)
            return r2
        L_0x0078:
            r2 = 705(0x2c1, float:9.88E-43)
            return r2
        L_0x007b:
            r2 = 700(0x2bc, float:9.81E-43)
            return r2
        L_0x007e:
            r2 = 707(0x2c3, float:9.91E-43)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.g.a(java.lang.String):int");
    }

    public static int b(int i5) {
        if (i5 == 509) {
            return 2;
        }
        switch (i5) {
            case TypedValues.TransitionType.TYPE_DURATION:
                return 2;
            case TypedValues.TransitionType.TYPE_FROM:
            case TypedValues.TransitionType.TYPE_TO:
                return 8;
            default:
                switch (i5) {
                    case TypedValues.TransitionType.TYPE_INTERPOLATOR:
                    case TypedValues.TransitionType.TYPE_TRANSITION_FLAGS:
                        return 8;
                    case TypedValues.TransitionType.TYPE_STAGGERED:
                        return 4;
                    default:
                        return -1;
                }
        }
    }
}
