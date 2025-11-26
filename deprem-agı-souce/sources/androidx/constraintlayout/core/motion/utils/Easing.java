package androidx.constraintlayout.core.motion.utils;

import java.io.PrintStream;
import java.util.Arrays;

public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String ANTICIPATE = "cubic(0.36, 0, 0.66, -0.56)";
    private static final String ANTICIPATE_NAME = "anticipate";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = {STANDARD_NAME, ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};
    private static final String OVERSHOOT = "cubic(0.34, 1.56, 0.64, 1)";
    private static final String OVERSHOOT_NAME = "overshoot";
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    private static final String STANDARD_NAME = "standard";
    static Easing sDefault = new Easing();
    String mStr = "identity";

    public static Easing getInterpolator(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        if (str.startsWith("spline")) {
            return new StepCurve(str);
        }
        if (str.startsWith("Schlick")) {
            return new Schlick(str);
        }
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals(ACCELERATE_NAME)) {
                    c5 = 0;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals(DECELERATE_NAME)) {
                    c5 = 1;
                    break;
                }
                break;
            case -1197605014:
                if (str.equals(ANTICIPATE_NAME)) {
                    c5 = 2;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals(LINEAR_NAME)) {
                    c5 = 3;
                    break;
                }
                break;
            case -749065269:
                if (str.equals(OVERSHOOT_NAME)) {
                    c5 = 4;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals(STANDARD_NAME)) {
                    c5 = 5;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                return new CubicEasing(ACCELERATE);
            case 1:
                return new CubicEasing(DECELERATE);
            case 2:
                return new CubicEasing(ANTICIPATE);
            case 3:
                return new CubicEasing(LINEAR);
            case 4:
                return new CubicEasing(OVERSHOOT);
            case 5:
                return new CubicEasing(STANDARD);
            default:
                PrintStream printStream = System.err;
                printStream.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(NAMED_EASING));
                return sDefault;
        }
    }

    public double get(double d5) {
        return d5;
    }

    public double getDiff(double d5) {
        return 1.0d;
    }

    public String toString() {
        return this.mStr;
    }

    static class CubicEasing extends Easing {
        private static double sDError = 1.0E-4d;
        private static double sError = 0.01d;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        CubicEasing(String str) {
            this.mStr = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.mX1 = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i5 = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i5);
            this.mY1 = Double.parseDouble(str.substring(i5, indexOf3).trim());
            int i6 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i6);
            this.mX2 = Double.parseDouble(str.substring(i6, indexOf4).trim());
            int i7 = indexOf4 + 1;
            this.mY2 = Double.parseDouble(str.substring(i7, str.indexOf(41, i7)).trim());
        }

        private double getDiffX(double d5) {
            double d6 = 1.0d - d5;
            double d7 = this.mX1;
            double d8 = this.mX2;
            return (d6 * 3.0d * d6 * d7) + (d6 * 6.0d * d5 * (d8 - d7)) + (3.0d * d5 * d5 * (1.0d - d8));
        }

        private double getDiffY(double d5) {
            double d6 = 1.0d - d5;
            double d7 = this.mY1;
            double d8 = this.mY2;
            return (d6 * 3.0d * d6 * d7) + (d6 * 6.0d * d5 * (d8 - d7)) + (3.0d * d5 * d5 * (1.0d - d8));
        }

        private double getX(double d5) {
            double d6 = 1.0d - d5;
            double d7 = 3.0d * d6;
            return (this.mX1 * d6 * d7 * d5) + (this.mX2 * d7 * d5 * d5) + (d5 * d5 * d5);
        }

        private double getY(double d5) {
            double d6 = 1.0d - d5;
            double d7 = 3.0d * d6;
            return (this.mY1 * d6 * d7 * d5) + (this.mY2 * d7 * d5 * d5) + (d5 * d5 * d5);
        }

        public double get(double d5) {
            if (d5 <= 0.0d) {
                return 0.0d;
            }
            if (d5 >= 1.0d) {
                return 1.0d;
            }
            double d6 = 0.5d;
            double d7 = 0.5d;
            while (d6 > sError) {
                d6 *= 0.5d;
                if (getX(d7) < d5) {
                    d7 += d6;
                } else {
                    d7 -= d6;
                }
            }
            double d8 = d7 - d6;
            double x4 = getX(d8);
            double d9 = d7 + d6;
            double x5 = getX(d9);
            double y4 = getY(d8);
            return (((getY(d9) - y4) * (d5 - x4)) / (x5 - x4)) + y4;
        }

        public double getDiff(double d5) {
            double d6 = 0.5d;
            double d7 = 0.5d;
            while (d6 > sDError) {
                d6 *= 0.5d;
                if (getX(d7) < d5) {
                    d7 += d6;
                } else {
                    d7 -= d6;
                }
            }
            double d8 = d7 - d6;
            double x4 = getX(d8);
            double d9 = d7 + d6;
            return (getY(d9) - getY(d8)) / (getX(d9) - x4);
        }

        /* access modifiers changed from: package-private */
        public void setup(double d5, double d6, double d7, double d8) {
            this.mX1 = d5;
            this.mY1 = d6;
            this.mX2 = d7;
            this.mY2 = d8;
        }

        CubicEasing(double d5, double d6, double d7, double d8) {
            setup(d5, d6, d7, d8);
        }
    }
}
