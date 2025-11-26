package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

public class ArcCurveFit extends CurveFit {
    public static final int ARC_ABOVE = 5;
    public static final int ARC_BELOW = 4;
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int DOWN_ARC = 4;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    private static final int UP_ARC = 5;
    Arc[] mArcs;
    private boolean mExtrapolate = true;
    private final double[] mTime;

    private static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] sOurPercent = new double[91];
        double mArcDistance;
        double mArcVelocity;
        double mEllipseA;
        double mEllipseB;
        double mEllipseCenterX;
        double mEllipseCenterY;
        boolean mLinear = false;
        double[] mLut;
        double mOneOverDeltaTime;
        double mTime1;
        double mTime2;
        double mTmpCosAngle;
        double mTmpSinAngle;
        boolean mVertical;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        Arc(int i5, double d5, double d6, double d7, double d8, double d9, double d10) {
            int i6;
            double d11;
            double d12;
            int i7 = i5;
            double d13 = d5;
            double d14 = d6;
            boolean z4 = false;
            double d15 = d9 - d7;
            double d16 = d10 - d8;
            int i8 = 1;
            if (i7 == 1) {
                this.mVertical = true;
            } else if (i7 == 4) {
                this.mVertical = d16 > 0.0d ? true : z4;
            } else if (i7 != 5) {
                this.mVertical = false;
            } else {
                this.mVertical = d16 < 0.0d ? true : z4;
            }
            this.mTime1 = d13;
            this.mTime2 = d14;
            this.mOneOverDeltaTime = 1.0d / (d14 - d13);
            if (3 == i7) {
                this.mLinear = true;
            }
            if (this.mLinear || Math.abs(d15) < EPSILON || Math.abs(d16) < EPSILON) {
                double d17 = d7;
                double d18 = d8;
                double d19 = d9;
                double d20 = d10;
                this.mLinear = true;
                this.mX1 = d17;
                this.mX2 = d19;
                this.mY1 = d18;
                this.mY2 = d20;
                double hypot = Math.hypot(d16, d15);
                this.mArcDistance = hypot;
                this.mArcVelocity = hypot * this.mOneOverDeltaTime;
                double d21 = this.mTime2;
                double d22 = this.mTime1;
                this.mEllipseCenterX = d15 / (d21 - d22);
                this.mEllipseCenterY = d16 / (d21 - d22);
                return;
            }
            this.mLut = new double[101];
            boolean z5 = this.mVertical;
            if (z5) {
                i6 = -1;
            } else {
                i6 = 1;
            }
            this.mEllipseA = d15 * ((double) i6);
            this.mEllipseB = d16 * ((double) (!z5 ? -1 : i8));
            if (z5) {
                d11 = d9;
            } else {
                d11 = d7;
            }
            this.mEllipseCenterX = d11;
            if (z5) {
                d12 = d8;
            } else {
                d12 = d10;
            }
            this.mEllipseCenterY = d12;
            buildTable(d7, d8, d9, d10);
            this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
        }

        private void buildTable(double d5, double d6, double d7, double d8) {
            double d9 = d7 - d5;
            double d10 = d6 - d8;
            int i5 = 0;
            double d11 = 0.0d;
            double d12 = 0.0d;
            double d13 = 0.0d;
            while (true) {
                double[] dArr = sOurPercent;
                if (i5 >= dArr.length) {
                    break;
                }
                int i6 = i5;
                double radians = Math.toRadians((((double) i5) * 90.0d) / ((double) (dArr.length - 1)));
                double sin = Math.sin(radians) * d9;
                double cos = Math.cos(radians) * d10;
                if (i6 > 0) {
                    d11 += Math.hypot(sin - d12, cos - d13);
                    sOurPercent[i6] = d11;
                }
                i5 = i6 + 1;
                d12 = sin;
                d13 = cos;
            }
            this.mArcDistance = d11;
            int i7 = 0;
            while (true) {
                double[] dArr2 = sOurPercent;
                if (i7 >= dArr2.length) {
                    break;
                }
                dArr2[i7] = dArr2[i7] / d11;
                i7++;
            }
            int i8 = 0;
            while (true) {
                double[] dArr3 = this.mLut;
                if (i8 < dArr3.length) {
                    double length = ((double) i8) / ((double) (dArr3.length - 1));
                    int binarySearch = Arrays.binarySearch(sOurPercent, length);
                    if (binarySearch >= 0) {
                        this.mLut[i8] = ((double) binarySearch) / ((double) (sOurPercent.length - 1));
                    } else if (binarySearch == -1) {
                        this.mLut[i8] = 0.0d;
                    } else {
                        int i9 = -binarySearch;
                        int i10 = i9 - 2;
                        double[] dArr4 = sOurPercent;
                        double d14 = dArr4[i10];
                        this.mLut[i8] = (((double) i10) + ((length - d14) / (dArr4[i9 - 1] - d14))) / ((double) (dArr4.length - 1));
                    }
                    i8++;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public double getDX() {
            double d5 = this.mEllipseA * this.mTmpCosAngle;
            double hypot = this.mArcVelocity / Math.hypot(d5, (-this.mEllipseB) * this.mTmpSinAngle);
            if (this.mVertical) {
                return (-d5) * hypot;
            }
            return d5 * hypot;
        }

        /* access modifiers changed from: package-private */
        public double getDY() {
            double d5 = this.mEllipseA * this.mTmpCosAngle;
            double d6 = (-this.mEllipseB) * this.mTmpSinAngle;
            double hypot = this.mArcVelocity / Math.hypot(d5, d6);
            if (this.mVertical) {
                return (-d6) * hypot;
            }
            return d6 * hypot;
        }

        public double getLinearDX(double d5) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double d5) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double d5) {
            double d6 = (d5 - this.mTime1) * this.mOneOverDeltaTime;
            double d7 = this.mX1;
            return d7 + (d6 * (this.mX2 - d7));
        }

        public double getLinearY(double d5) {
            double d6 = (d5 - this.mTime1) * this.mOneOverDeltaTime;
            double d7 = this.mY1;
            return d7 + (d6 * (this.mY2 - d7));
        }

        /* access modifiers changed from: package-private */
        public double getX() {
            return this.mEllipseCenterX + (this.mEllipseA * this.mTmpSinAngle);
        }

        /* access modifiers changed from: package-private */
        public double getY() {
            return this.mEllipseCenterY + (this.mEllipseB * this.mTmpCosAngle);
        }

        /* access modifiers changed from: package-private */
        public double lookup(double d5) {
            if (d5 <= 0.0d) {
                return 0.0d;
            }
            if (d5 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.mLut;
            double length = d5 * ((double) (dArr.length - 1));
            int i5 = (int) length;
            double d6 = length - ((double) i5);
            double d7 = dArr[i5];
            return d7 + (d6 * (dArr[i5 + 1] - d7));
        }

        /* access modifiers changed from: package-private */
        public void setPoint(double d5) {
            double d6;
            if (this.mVertical) {
                d6 = this.mTime2 - d5;
            } else {
                d6 = d5 - this.mTime1;
            }
            double lookup = lookup(d6 * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(lookup);
            this.mTmpCosAngle = Math.cos(lookup);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r5 == 1) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ArcCurveFit(int[] r24, double[] r25, double[][] r26) {
        /*
            r23 = this;
            r0 = r23
            r1 = r25
            r0.<init>()
            r2 = 1
            r0.mExtrapolate = r2
            r0.mTime = r1
            int r3 = r1.length
            int r3 = r3 - r2
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc[] r3 = new androidx.constraintlayout.core.motion.utils.ArcCurveFit.Arc[r3]
            r0.mArcs = r3
            r3 = 0
            r5 = r2
            r6 = r5
            r4 = r3
        L_0x0016:
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc[] r7 = r0.mArcs
            int r8 = r7.length
            if (r4 >= r8) goto L_0x005b
            r8 = r24[r4]
            r9 = 3
            if (r8 == 0) goto L_0x0038
            if (r8 == r2) goto L_0x0036
            r10 = 2
            if (r8 == r10) goto L_0x0034
            if (r8 == r9) goto L_0x002f
            r9 = 4
            if (r8 == r9) goto L_0x0038
            r9 = 5
            if (r8 == r9) goto L_0x0038
            r9 = r6
            goto L_0x0038
        L_0x002f:
            if (r5 != r2) goto L_0x0036
            goto L_0x0034
        L_0x0032:
            r9 = r5
            goto L_0x0038
        L_0x0034:
            r5 = r10
            goto L_0x0032
        L_0x0036:
            r5 = r2
            goto L_0x0032
        L_0x0038:
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc r8 = new androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc
            r10 = r1[r4]
            int r6 = r4 + 1
            r12 = r1[r6]
            r14 = r26[r4]
            r15 = r14[r3]
            r17 = r14[r2]
            r14 = r26[r6]
            r19 = r14[r3]
            r21 = r14[r2]
            r14 = r15
            r16 = r17
            r18 = r19
            r20 = r21
            r8.<init>(r9, r10, r12, r14, r16, r18, r20)
            r7[r4] = r8
            r4 = r6
            r6 = r9
            goto L_0x0016
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.ArcCurveFit.<init>(int[], double[], double[][]):void");
    }

    public void getPos(double d5, double[] dArr) {
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            Arc arc = arcArr[0];
            double d6 = arc.mTime1;
            if (d5 < d6) {
                double d7 = d5 - d6;
                if (arc.mLinear) {
                    dArr[0] = arc.getLinearX(d6) + (this.mArcs[0].getLinearDX(d6) * d7);
                    dArr[1] = this.mArcs[0].getLinearY(d6) + (d7 * this.mArcs[0].getLinearDY(d6));
                    return;
                }
                arc.setPoint(d6);
                dArr[0] = this.mArcs[0].getX() + (this.mArcs[0].getDX() * d7);
                dArr[1] = this.mArcs[0].getY() + (d7 * this.mArcs[0].getDY());
                return;
            } else if (d5 > arcArr[arcArr.length - 1].mTime2) {
                double d8 = arcArr[arcArr.length - 1].mTime2;
                double d9 = d5 - d8;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.mLinear) {
                    dArr[0] = arc2.getLinearX(d8) + (this.mArcs[length].getLinearDX(d8) * d9);
                    dArr[1] = this.mArcs[length].getLinearY(d8) + (d9 * this.mArcs[length].getLinearDY(d8));
                    return;
                }
                arc2.setPoint(d5);
                dArr[0] = this.mArcs[length].getX() + (this.mArcs[length].getDX() * d9);
                dArr[1] = this.mArcs[length].getY() + (d9 * this.mArcs[length].getDY());
                return;
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            double d10 = arcArr2[0].mTime1;
            if (d5 < d10) {
                d5 = d10;
            }
            if (d5 > arcArr2[arcArr2.length - 1].mTime2) {
                d5 = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        int i5 = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i5 < arcArr3.length) {
                Arc arc3 = arcArr3[i5];
                if (d5 > arc3.mTime2) {
                    i5++;
                } else if (arc3.mLinear) {
                    dArr[0] = arc3.getLinearX(d5);
                    dArr[1] = this.mArcs[i5].getLinearY(d5);
                    return;
                } else {
                    arc3.setPoint(d5);
                    dArr[0] = this.mArcs[i5].getX();
                    dArr[1] = this.mArcs[i5].getY();
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void getSlope(double d5, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        double d6 = arcArr[0].mTime1;
        if (d5 < d6) {
            d5 = d6;
        } else if (d5 > arcArr[arcArr.length - 1].mTime2) {
            d5 = arcArr[arcArr.length - 1].mTime2;
        }
        int i5 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i5 < arcArr2.length) {
                Arc arc = arcArr2[i5];
                if (d5 > arc.mTime2) {
                    i5++;
                } else if (arc.mLinear) {
                    dArr[0] = arc.getLinearDX(d5);
                    dArr[1] = this.mArcs[i5].getLinearDY(d5);
                    return;
                } else {
                    arc.setPoint(d5);
                    dArr[0] = this.mArcs[i5].getDX();
                    dArr[1] = this.mArcs[i5].getDY();
                    return;
                }
            } else {
                return;
            }
        }
    }

    public double[] getTimePoints() {
        return this.mTime;
    }

    public double getSlope(double d5, int i5) {
        Arc[] arcArr = this.mArcs;
        int i6 = 0;
        double d6 = arcArr[0].mTime1;
        if (d5 < d6) {
            d5 = d6;
        }
        if (d5 > arcArr[arcArr.length - 1].mTime2) {
            d5 = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i6 >= arcArr2.length) {
                return Double.NaN;
            }
            Arc arc = arcArr2[i6];
            if (d5 > arc.mTime2) {
                i6++;
            } else if (!arc.mLinear) {
                arc.setPoint(d5);
                if (i5 == 0) {
                    return this.mArcs[i6].getDX();
                }
                return this.mArcs[i6].getDY();
            } else if (i5 == 0) {
                return arc.getLinearDX(d5);
            } else {
                return arc.getLinearDY(d5);
            }
        }
    }

    public void getPos(double d5, float[] fArr) {
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            Arc arc = arcArr[0];
            double d6 = arc.mTime1;
            if (d5 < d6) {
                double d7 = d5 - d6;
                if (arc.mLinear) {
                    fArr[0] = (float) (arc.getLinearX(d6) + (this.mArcs[0].getLinearDX(d6) * d7));
                    fArr[1] = (float) (this.mArcs[0].getLinearY(d6) + (d7 * this.mArcs[0].getLinearDY(d6)));
                    return;
                }
                arc.setPoint(d6);
                fArr[0] = (float) (this.mArcs[0].getX() + (this.mArcs[0].getDX() * d7));
                fArr[1] = (float) (this.mArcs[0].getY() + (d7 * this.mArcs[0].getDY()));
                return;
            } else if (d5 > arcArr[arcArr.length - 1].mTime2) {
                double d8 = arcArr[arcArr.length - 1].mTime2;
                double d9 = d5 - d8;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.mLinear) {
                    fArr[0] = (float) (arc2.getLinearX(d8) + (this.mArcs[length].getLinearDX(d8) * d9));
                    fArr[1] = (float) (this.mArcs[length].getLinearY(d8) + (d9 * this.mArcs[length].getLinearDY(d8)));
                    return;
                }
                arc2.setPoint(d5);
                fArr[0] = (float) this.mArcs[length].getX();
                fArr[1] = (float) this.mArcs[length].getY();
                return;
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            double d10 = arcArr2[0].mTime1;
            if (d5 < d10) {
                d5 = d10;
            } else if (d5 > arcArr2[arcArr2.length - 1].mTime2) {
                d5 = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        int i5 = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i5 < arcArr3.length) {
                Arc arc3 = arcArr3[i5];
                if (d5 > arc3.mTime2) {
                    i5++;
                } else if (arc3.mLinear) {
                    fArr[0] = (float) arc3.getLinearX(d5);
                    fArr[1] = (float) this.mArcs[i5].getLinearY(d5);
                    return;
                } else {
                    arc3.setPoint(d5);
                    fArr[0] = (float) this.mArcs[i5].getX();
                    fArr[1] = (float) this.mArcs[i5].getY();
                    return;
                }
            } else {
                return;
            }
        }
    }

    public double getPos(double d5, int i5) {
        double linearY;
        double linearDY;
        double y4;
        double dy;
        double linearY2;
        double linearDY2;
        int i6 = 0;
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            Arc arc = arcArr[0];
            double d6 = arc.mTime1;
            if (d5 < d6) {
                double d7 = d5 - d6;
                if (arc.mLinear) {
                    if (i5 == 0) {
                        linearY2 = arc.getLinearX(d6);
                        linearDY2 = this.mArcs[0].getLinearDX(d6);
                    } else {
                        linearY2 = arc.getLinearY(d6);
                        linearDY2 = this.mArcs[0].getLinearDY(d6);
                    }
                    return linearY2 + (d7 * linearDY2);
                }
                arc.setPoint(d6);
                if (i5 == 0) {
                    y4 = this.mArcs[0].getX();
                    dy = this.mArcs[0].getDX();
                } else {
                    y4 = this.mArcs[0].getY();
                    dy = this.mArcs[0].getDY();
                }
                return y4 + (d7 * dy);
            } else if (d5 > arcArr[arcArr.length - 1].mTime2) {
                double d8 = arcArr[arcArr.length - 1].mTime2;
                double d9 = d5 - d8;
                int length = arcArr.length - 1;
                if (i5 == 0) {
                    linearY = arcArr[length].getLinearX(d8);
                    linearDY = this.mArcs[length].getLinearDX(d8);
                } else {
                    linearY = arcArr[length].getLinearY(d8);
                    linearDY = this.mArcs[length].getLinearDY(d8);
                }
                return linearY + (d9 * linearDY);
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            double d10 = arcArr2[0].mTime1;
            if (d5 < d10) {
                d5 = d10;
            } else if (d5 > arcArr2[arcArr2.length - 1].mTime2) {
                d5 = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i6 >= arcArr3.length) {
                return Double.NaN;
            }
            Arc arc2 = arcArr3[i6];
            if (d5 > arc2.mTime2) {
                i6++;
            } else if (!arc2.mLinear) {
                arc2.setPoint(d5);
                if (i5 == 0) {
                    return this.mArcs[i6].getX();
                }
                return this.mArcs[i6].getY();
            } else if (i5 == 0) {
                return arc2.getLinearX(d5);
            } else {
                return arc2.getLinearY(d5);
            }
        }
    }
}
