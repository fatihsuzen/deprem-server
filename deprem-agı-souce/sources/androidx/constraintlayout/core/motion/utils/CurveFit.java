package androidx.constraintlayout.core.motion.utils;

public abstract class CurveFit {
    public static final int CONSTANT = 2;
    public static final int LINEAR = 1;
    public static final int SPLINE = 0;

    static class Constant extends CurveFit {
        double mTime;
        double[] mValue;

        Constant(double d5, double[] dArr) {
            this.mTime = d5;
            this.mValue = dArr;
        }

        public void getPos(double d5, double[] dArr) {
            double[] dArr2 = this.mValue;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        public double getSlope(double d5, int i5) {
            return 0.0d;
        }

        public double[] getTimePoints() {
            return new double[]{this.mTime};
        }

        public void getPos(double d5, float[] fArr) {
            int i5 = 0;
            while (true) {
                double[] dArr = this.mValue;
                if (i5 < dArr.length) {
                    fArr[i5] = (float) dArr[i5];
                    i5++;
                } else {
                    return;
                }
            }
        }

        public void getSlope(double d5, double[] dArr) {
            for (int i5 = 0; i5 < this.mValue.length; i5++) {
                dArr[i5] = 0.0d;
            }
        }

        public double getPos(double d5, int i5) {
            return this.mValue[i5];
        }
    }

    public static CurveFit get(int i5, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i5 = 2;
        }
        if (i5 == 0) {
            return new MonotonicCurveFit(dArr, dArr2);
        }
        if (i5 != 2) {
            return new LinearCurveFit(dArr, dArr2);
        }
        return new Constant(dArr[0], dArr2[0]);
    }

    public static CurveFit getArc(int[] iArr, double[] dArr, double[][] dArr2) {
        return new ArcCurveFit(iArr, dArr, dArr2);
    }

    public abstract double getPos(double d5, int i5);

    public abstract void getPos(double d5, double[] dArr);

    public abstract void getPos(double d5, float[] fArr);

    public abstract double getSlope(double d5, int i5);

    public abstract void getSlope(double d5, double[] dArr);

    public abstract double[] getTimePoints();
}
