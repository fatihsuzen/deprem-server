package androidx.constraintlayout.core.motion.utils;

public class Schlick extends Easing {
    private static final boolean DEBUG = false;
    double mEps;
    double mS;
    double mT;

    Schlick(String str) {
        this.mStr = str;
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(44, indexOf);
        this.mS = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
        int i5 = indexOf2 + 1;
        this.mT = Double.parseDouble(str.substring(i5, str.indexOf(44, i5)).trim());
    }

    private double dfunc(double d5) {
        double d6 = this.mT;
        if (d5 < d6) {
            double d7 = this.mS;
            return ((d7 * d6) * d6) / ((((d6 - d5) * d7) + d5) * ((d7 * (d6 - d5)) + d5));
        }
        double d8 = this.mS;
        return (((d6 - 1.0d) * d8) * (d6 - 1.0d)) / (((((-d8) * (d6 - d5)) - d5) + 1.0d) * ((((-d8) * (d6 - d5)) - d5) + 1.0d));
    }

    private double func(double d5) {
        double d6 = this.mT;
        if (d5 < d6) {
            return (d6 * d5) / (d5 + (this.mS * (d6 - d5)));
        }
        return ((1.0d - d6) * (d5 - 1.0d)) / ((1.0d - d5) - (this.mS * (d6 - d5)));
    }

    public double get(double d5) {
        return func(d5);
    }

    public double getDiff(double d5) {
        return dfunc(d5);
    }
}
