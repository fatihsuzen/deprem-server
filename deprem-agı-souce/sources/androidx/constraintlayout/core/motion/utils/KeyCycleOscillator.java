package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.MotionWidget;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    private CycleOscillator mCycleOscillator;
    private String mType;
    public int mVariesBy = 0;
    ArrayList<WavePoint> mWavePoints = new ArrayList<>();
    private int mWaveShape = 0;
    private String mWaveString = null;

    private static class CoreSpline extends KeyCycleOscillator {
        String mType;
        int mTypeId;

        CoreSpline(String str) {
            this.mType = str;
            this.mTypeId = c.a(str);
        }

        public void setProperty(MotionWidget motionWidget, float f5) {
            motionWidget.setValue(this.mTypeId, get(f5));
        }
    }

    static class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        static final int UNSET = -1;
        CurveFit mCurveFit;
        float[] mOffsetArr;
        private final int mOffst = 0;
        Oscillator mOscillator;
        float mPathLength;
        float[] mPeriod;
        private final int mPhase = 1;
        float[] mPhaseArr;
        double[] mPosition;
        float[] mScale;
        double[] mSplineSlopeCache;
        double[] mSplineValueCache;
        private final int mValue = 2;
        float[] mValues;
        private final int mVariesBy;
        int mWaveShape;

        CycleOscillator(int i5, String str, int i6, int i7) {
            Oscillator oscillator = new Oscillator();
            this.mOscillator = oscillator;
            this.mWaveShape = i5;
            this.mVariesBy = i6;
            oscillator.setType(i5, str);
            this.mValues = new float[i7];
            this.mPosition = new double[i7];
            this.mPeriod = new float[i7];
            this.mOffsetArr = new float[i7];
            this.mPhaseArr = new float[i7];
            this.mScale = new float[i7];
        }

        public double getLastPhase() {
            return this.mSplineValueCache[1];
        }

        public double getSlope(float f5) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                double d5 = (double) f5;
                curveFit.getSlope(d5, this.mSplineSlopeCache);
                this.mCurveFit.getPos(d5, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineSlopeCache;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d6 = (double) f5;
            double value = this.mOscillator.getValue(d6, this.mSplineValueCache[1]);
            double slope = this.mOscillator.getSlope(d6, this.mSplineValueCache[1], this.mSplineSlopeCache[1]);
            double[] dArr2 = this.mSplineSlopeCache;
            return dArr2[0] + (value * dArr2[2]) + (slope * this.mSplineValueCache[2]);
        }

        public double getValues(float f5) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                curveFit.getPos((double) f5, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineValueCache;
                dArr[0] = (double) this.mOffsetArr[0];
                dArr[1] = (double) this.mPhaseArr[0];
                dArr[2] = (double) this.mValues[0];
            }
            double[] dArr2 = this.mSplineValueCache;
            return dArr2[0] + (this.mOscillator.getValue((double) f5, dArr2[1]) * this.mSplineValueCache[2]);
        }

        public void setPoint(int i5, int i6, float f5, float f6, float f7, float f8) {
            this.mPosition[i5] = ((double) i6) / 100.0d;
            this.mPeriod[i5] = f5;
            this.mOffsetArr[i5] = f6;
            this.mPhaseArr[i5] = f7;
            this.mValues[i5] = f8;
        }

        public void setup(float f5) {
            this.mPathLength = f5;
            int length = this.mPosition.length;
            int[] iArr = new int[2];
            iArr[1] = 3;
            iArr[0] = length;
            double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, iArr);
            float[] fArr = this.mValues;
            this.mSplineValueCache = new double[(fArr.length + 2)];
            this.mSplineSlopeCache = new double[(fArr.length + 2)];
            if (this.mPosition[0] > 0.0d) {
                this.mOscillator.addPoint(0.0d, this.mPeriod[0]);
            }
            double[] dArr2 = this.mPosition;
            int length2 = dArr2.length - 1;
            if (dArr2[length2] < 1.0d) {
                this.mOscillator.addPoint(1.0d, this.mPeriod[length2]);
            }
            for (int i5 = 0; i5 < dArr.length; i5++) {
                double[] dArr3 = dArr[i5];
                dArr3[0] = (double) this.mOffsetArr[i5];
                dArr3[1] = (double) this.mPhaseArr[i5];
                dArr3[2] = (double) this.mValues[i5];
                this.mOscillator.addPoint(this.mPosition[i5], this.mPeriod[i5]);
            }
            this.mOscillator.normalize();
            double[] dArr4 = this.mPosition;
            if (dArr4.length > 1) {
                this.mCurveFit = CurveFit.get(0, dArr4, dArr);
            } else {
                this.mCurveFit = null;
            }
        }
    }

    public static class PathRotateSet extends KeyCycleOscillator {
        String mType;
        int mTypeId;

        public PathRotateSet(String str) {
            this.mType = str;
            this.mTypeId = c.a(str);
        }

        public void setPathRotate(MotionWidget motionWidget, float f5, double d5, double d6) {
            motionWidget.setRotationZ(get(f5) + ((float) Math.toDegrees(Math.atan2(d6, d5))));
        }

        public void setProperty(MotionWidget motionWidget, float f5) {
            motionWidget.setValue(this.mTypeId, get(f5));
        }
    }

    static class WavePoint {
        float mOffset;
        float mPeriod;
        float mPhase;
        int mPosition;
        float mValue;

        WavePoint(int i5, float f5, float f6, float f7, float f8) {
            this.mPosition = i5;
            this.mValue = f8;
            this.mOffset = f6;
            this.mPeriod = f5;
            this.mPhase = f7;
        }
    }

    public static KeyCycleOscillator makeWidgetCycle(String str) {
        if (str.equals("pathRotate")) {
            return new PathRotateSet(str);
        }
        return new CoreSpline(str);
    }

    public float get(float f5) {
        return (float) this.mCycleOscillator.getValues(f5);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f5) {
        return (float) this.mCycleOscillator.getSlope(f5);
    }

    /* access modifiers changed from: protected */
    public void setCustom(Object obj) {
    }

    public void setPoint(int i5, int i6, String str, int i7, float f5, float f6, float f7, float f8, Object obj) {
        this.mWavePoints.add(new WavePoint(i5, f5, f6, f7, f8));
        if (i7 != -1) {
            this.mVariesBy = i7;
        }
        this.mWaveShape = i6;
        setCustom(obj);
        this.mWaveString = str;
    }

    public void setProperty(MotionWidget motionWidget, float f5) {
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(float f5) {
        int size = this.mWavePoints.size();
        if (size != 0) {
            Collections.sort(this.mWavePoints, new Comparator<WavePoint>() {
                public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                    return Integer.compare(wavePoint.mPosition, wavePoint2.mPosition);
                }
            });
            double[] dArr = new double[size];
            char c5 = 2;
            int[] iArr = new int[2];
            iArr[1] = 3;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mWaveString, this.mVariesBy, size);
            ArrayList<WavePoint> arrayList = this.mWavePoints;
            int size2 = arrayList.size();
            int i5 = 0;
            int i6 = 0;
            while (i5 < size2) {
                int i7 = i5 + 1;
                WavePoint wavePoint = arrayList.get(i5);
                float f6 = wavePoint.mPeriod;
                dArr[i6] = ((double) f6) * 0.01d;
                double[] dArr3 = dArr2[i6];
                float f7 = wavePoint.mValue;
                dArr3[0] = (double) f7;
                float f8 = wavePoint.mOffset;
                char c6 = c5;
                dArr3[1] = (double) f8;
                float f9 = wavePoint.mPhase;
                dArr3[c6] = (double) f9;
                this.mCycleOscillator.setPoint(i6, wavePoint.mPosition, f6, f8, f9, f7);
                i6++;
                i5 = i7;
                c5 = c6;
                dArr2 = dArr2;
            }
            double[][] dArr4 = dArr2;
            this.mCycleOscillator.setup(f5);
            this.mCurveFit = CurveFit.get(0, dArr, dArr2);
        }
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        ArrayList<WavePoint> arrayList = this.mWavePoints;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            WavePoint wavePoint = arrayList.get(i5);
            i5++;
            WavePoint wavePoint2 = wavePoint;
            str = str + "[" + wavePoint2.mPosition + " , " + decimalFormat.format((double) wavePoint2.mValue) + "] ";
        }
        return str;
    }

    public boolean variesByPath() {
        if (this.mVariesBy == 1) {
            return true;
        }
        return false;
    }

    public void setPoint(int i5, int i6, String str, int i7, float f5, float f6, float f7, float f8) {
        this.mWavePoints.add(new WavePoint(i5, f5, f6, f7, f8));
        if (i7 != -1) {
            this.mVariesBy = i7;
        }
        this.mWaveShape = i6;
        this.mWaveString = str;
    }
}
