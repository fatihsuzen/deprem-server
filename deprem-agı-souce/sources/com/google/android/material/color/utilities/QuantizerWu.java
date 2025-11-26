package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerWu implements Quantizer {
    private static final int INDEX_BITS = 5;
    private static final int INDEX_COUNT = 33;
    private static final int TOTAL_SIZE = 35937;
    Box[] cubes;
    double[] moments;
    int[] momentsB;
    int[] momentsG;
    int[] momentsR;
    int[] weights;

    private static final class Box {

        /* renamed from: b0  reason: collision with root package name */
        int f6994b0;

        /* renamed from: b1  reason: collision with root package name */
        int f6995b1;

        /* renamed from: g0  reason: collision with root package name */
        int f6996g0;

        /* renamed from: g1  reason: collision with root package name */
        int f6997g1;

        /* renamed from: r0  reason: collision with root package name */
        int f6998r0;

        /* renamed from: r1  reason: collision with root package name */
        int f6999r1;
        int vol;

        private Box() {
            this.f6998r0 = 0;
            this.f6999r1 = 0;
            this.f6996g0 = 0;
            this.f6997g1 = 0;
            this.f6994b0 = 0;
            this.f6995b1 = 0;
            this.vol = 0;
        }
    }

    private static final class CreateBoxesResult {
        int resultCount;

        CreateBoxesResult(int i5, int i6) {
            this.resultCount = i6;
        }
    }

    private enum Direction {
        RED,
        GREEN,
        BLUE
    }

    private static final class MaximizeResult {
        int cutLocation;
        double maximum;

        MaximizeResult(int i5, double d5) {
            this.cutLocation = i5;
            this.maximum = d5;
        }
    }

    static int bottom(Box box, Direction direction, int[] iArr) {
        int i5;
        int i6;
        int ordinal = direction.ordinal();
        if (ordinal == 0) {
            i5 = (-iArr[getIndex(box.f6998r0, box.f6997g1, box.f6995b1)]) + iArr[getIndex(box.f6998r0, box.f6997g1, box.f6994b0)] + iArr[getIndex(box.f6998r0, box.f6996g0, box.f6995b1)];
            i6 = iArr[getIndex(box.f6998r0, box.f6996g0, box.f6994b0)];
        } else if (ordinal == 1) {
            i5 = (-iArr[getIndex(box.f6999r1, box.f6996g0, box.f6995b1)]) + iArr[getIndex(box.f6999r1, box.f6996g0, box.f6994b0)] + iArr[getIndex(box.f6998r0, box.f6996g0, box.f6995b1)];
            i6 = iArr[getIndex(box.f6998r0, box.f6996g0, box.f6994b0)];
        } else if (ordinal == 2) {
            i5 = (-iArr[getIndex(box.f6999r1, box.f6997g1, box.f6994b0)]) + iArr[getIndex(box.f6999r1, box.f6996g0, box.f6994b0)] + iArr[getIndex(box.f6998r0, box.f6997g1, box.f6994b0)];
            i6 = iArr[getIndex(box.f6998r0, box.f6996g0, box.f6994b0)];
        } else {
            throw new IllegalArgumentException("unexpected direction " + direction);
        }
        return i5 - i6;
    }

    static int getIndex(int i5, int i6, int i7) {
        return (i5 << 10) + (i5 << 6) + i5 + (i6 << 5) + i6 + i7;
    }

    static int top(Box box, Direction direction, int i5, int[] iArr) {
        int i6;
        int i7;
        int ordinal = direction.ordinal();
        if (ordinal == 0) {
            i6 = (iArr[getIndex(i5, box.f6997g1, box.f6995b1)] - iArr[getIndex(i5, box.f6997g1, box.f6994b0)]) - iArr[getIndex(i5, box.f6996g0, box.f6995b1)];
            i7 = iArr[getIndex(i5, box.f6996g0, box.f6994b0)];
        } else if (ordinal == 1) {
            i6 = (iArr[getIndex(box.f6999r1, i5, box.f6995b1)] - iArr[getIndex(box.f6999r1, i5, box.f6994b0)]) - iArr[getIndex(box.f6998r0, i5, box.f6995b1)];
            i7 = iArr[getIndex(box.f6998r0, i5, box.f6994b0)];
        } else if (ordinal == 2) {
            i6 = (iArr[getIndex(box.f6999r1, box.f6997g1, i5)] - iArr[getIndex(box.f6999r1, box.f6996g0, i5)]) - iArr[getIndex(box.f6998r0, box.f6997g1, i5)];
            i7 = iArr[getIndex(box.f6998r0, box.f6996g0, i5)];
        } else {
            throw new IllegalArgumentException("unexpected direction " + direction);
        }
        return i6 + i7;
    }

    static int volume(Box box, int[] iArr) {
        return ((((((iArr[getIndex(box.f6999r1, box.f6997g1, box.f6995b1)] - iArr[getIndex(box.f6999r1, box.f6997g1, box.f6994b0)]) - iArr[getIndex(box.f6999r1, box.f6996g0, box.f6995b1)]) + iArr[getIndex(box.f6999r1, box.f6996g0, box.f6994b0)]) - iArr[getIndex(box.f6998r0, box.f6997g1, box.f6995b1)]) + iArr[getIndex(box.f6998r0, box.f6997g1, box.f6994b0)]) + iArr[getIndex(box.f6998r0, box.f6996g0, box.f6995b1)]) - iArr[getIndex(box.f6998r0, box.f6996g0, box.f6994b0)];
    }

    /* access modifiers changed from: package-private */
    public void constructHistogram(Map<Integer, Integer> map) {
        this.weights = new int[TOTAL_SIZE];
        this.momentsR = new int[TOTAL_SIZE];
        this.momentsG = new int[TOTAL_SIZE];
        this.momentsB = new int[TOTAL_SIZE];
        this.moments = new double[TOTAL_SIZE];
        for (Map.Entry next : map.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            int intValue2 = ((Integer) next.getValue()).intValue();
            int redFromArgb = ColorUtils.redFromArgb(intValue);
            int greenFromArgb = ColorUtils.greenFromArgb(intValue);
            int blueFromArgb = ColorUtils.blueFromArgb(intValue);
            int index = getIndex((redFromArgb >> 3) + 1, (greenFromArgb >> 3) + 1, (blueFromArgb >> 3) + 1);
            int[] iArr = this.weights;
            iArr[index] = iArr[index] + intValue2;
            int[] iArr2 = this.momentsR;
            iArr2[index] = iArr2[index] + (redFromArgb * intValue2);
            int[] iArr3 = this.momentsG;
            iArr3[index] = iArr3[index] + (greenFromArgb * intValue2);
            int[] iArr4 = this.momentsB;
            iArr4[index] = iArr4[index] + (blueFromArgb * intValue2);
            double[] dArr = this.moments;
            dArr[index] = dArr[index] + ((double) (intValue2 * ((redFromArgb * redFromArgb) + (greenFromArgb * greenFromArgb) + (blueFromArgb * blueFromArgb))));
        }
    }

    /* access modifiers changed from: package-private */
    public CreateBoxesResult createBoxes(int i5) {
        int i6;
        double d5;
        double d6;
        this.cubes = new Box[i5];
        for (int i7 = 0; i7 < i5; i7++) {
            this.cubes[i7] = new Box();
        }
        double[] dArr = new double[i5];
        Box box = this.cubes[0];
        box.f6999r1 = 32;
        box.f6997g1 = 32;
        box.f6995b1 = 32;
        int i8 = 0;
        int i9 = 1;
        while (true) {
            if (i9 >= i5) {
                i6 = i5;
                break;
            }
            Box[] boxArr = this.cubes;
            if (cut(boxArr[i8], boxArr[i9]).booleanValue()) {
                Box box2 = this.cubes[i8];
                if (box2.vol > 1) {
                    d5 = variance(box2);
                } else {
                    d5 = 0.0d;
                }
                dArr[i8] = d5;
                Box box3 = this.cubes[i9];
                if (box3.vol > 1) {
                    d6 = variance(box3);
                } else {
                    d6 = 0.0d;
                }
                dArr[i9] = d6;
            } else {
                dArr[i8] = 0.0d;
                i9--;
            }
            double d7 = dArr[0];
            int i10 = 0;
            for (int i11 = 1; i11 <= i9; i11++) {
                double d8 = dArr[i11];
                if (d8 > d7) {
                    i10 = i11;
                    d7 = d8;
                }
            }
            if (d7 <= 0.0d) {
                i6 = i9 + 1;
                break;
            }
            i9++;
            i8 = i10;
        }
        return new CreateBoxesResult(i5, i6);
    }

    /* access modifiers changed from: package-private */
    public void createMoments() {
        int i5 = 1;
        while (true) {
            int i6 = 33;
            if (i5 < 33) {
                int[] iArr = new int[33];
                int[] iArr2 = new int[33];
                int[] iArr3 = new int[33];
                int[] iArr4 = new int[33];
                double[] dArr = new double[33];
                int i7 = 1;
                while (i7 < i6) {
                    int i8 = 0;
                    int i9 = 0;
                    double d5 = 0.0d;
                    int i10 = 1;
                    int i11 = 0;
                    int i12 = 0;
                    while (i10 < i6) {
                        int index = getIndex(i5, i7, i10);
                        i8 += this.weights[index];
                        i11 += this.momentsR[index];
                        i12 += this.momentsG[index];
                        i9 += this.momentsB[index];
                        d5 += this.moments[index];
                        iArr[i10] = iArr[i10] + i8;
                        iArr2[i10] = iArr2[i10] + i11;
                        iArr3[i10] = iArr3[i10] + i12;
                        iArr4[i10] = iArr4[i10] + i9;
                        dArr[i10] = dArr[i10] + d5;
                        int index2 = getIndex(i5 - 1, i7, i10);
                        int i13 = i10;
                        int[] iArr5 = this.weights;
                        iArr5[index] = iArr5[index2] + iArr[i13];
                        int[] iArr6 = this.momentsR;
                        iArr6[index] = iArr6[index2] + iArr2[i13];
                        int[] iArr7 = this.momentsG;
                        iArr7[index] = iArr7[index2] + iArr3[i13];
                        int[] iArr8 = this.momentsB;
                        iArr8[index] = iArr8[index2] + iArr4[i13];
                        double[] dArr2 = this.moments;
                        dArr2[index] = dArr2[index2] + dArr[i13];
                        i10 = i13 + 1;
                        i6 = 33;
                    }
                    i7++;
                    i6 = 33;
                }
                i5++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public List<Integer> createResult(int i5) {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < i5; i6++) {
            Box box = this.cubes[i6];
            int volume = volume(box, this.weights);
            if (volume > 0) {
                int volume2 = volume(box, this.momentsG) / volume;
                arrayList.add(Integer.valueOf(((volume(box, this.momentsB) / volume) & 255) | (((volume(box, this.momentsR) / volume) & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((volume2 & 255) << 8)));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public Boolean cut(Box box, Box box2) {
        Box box3 = box;
        Box box4 = box2;
        int volume = volume(box3, this.momentsR);
        int volume2 = volume(box3, this.momentsG);
        int volume3 = volume(box3, this.momentsB);
        int volume4 = volume(box3, this.weights);
        Direction direction = Direction.RED;
        MaximizeResult maximize = maximize(box3, direction, box3.f6998r0 + 1, box3.f6999r1, volume, volume2, volume3, volume4);
        Direction direction2 = direction;
        Direction direction3 = Direction.GREEN;
        MaximizeResult maximize2 = maximize(box3, direction3, box3.f6996g0 + 1, box3.f6997g1, volume, volume2, volume3, volume4);
        Direction direction4 = direction3;
        Direction direction5 = Direction.BLUE;
        MaximizeResult maximize3 = maximize(box3, direction5, box3.f6994b0 + 1, box3.f6995b1, volume, volume2, volume3, volume4);
        double d5 = maximize.maximum;
        double d6 = maximize2.maximum;
        MaximizeResult maximizeResult = maximize;
        double d7 = maximize3.maximum;
        if (d5 < d6 || d5 < d7) {
            if (d6 >= d5 && d6 >= d7) {
                direction5 = direction4;
            }
        } else if (maximizeResult.cutLocation < 0) {
            return Boolean.FALSE;
        } else {
            direction5 = direction2;
        }
        box4.f6999r1 = box3.f6999r1;
        box4.f6997g1 = box3.f6997g1;
        box4.f6995b1 = box3.f6995b1;
        int ordinal = direction5.ordinal();
        if (ordinal == 0) {
            int i5 = maximizeResult.cutLocation;
            box3.f6999r1 = i5;
            box4.f6998r0 = i5;
            box4.f6996g0 = box3.f6996g0;
            box4.f6994b0 = box3.f6994b0;
        } else if (ordinal == 1) {
            int i6 = maximize2.cutLocation;
            box3.f6997g1 = i6;
            box4.f6998r0 = box3.f6998r0;
            box4.f6996g0 = i6;
            box4.f6994b0 = box3.f6994b0;
        } else if (ordinal == 2) {
            int i7 = maximize3.cutLocation;
            box3.f6995b1 = i7;
            box4.f6998r0 = box3.f6998r0;
            box4.f6996g0 = box3.f6996g0;
            box4.f6994b0 = i7;
        }
        box3.vol = (box3.f6999r1 - box3.f6998r0) * (box3.f6997g1 - box3.f6996g0) * (box3.f6995b1 - box3.f6994b0);
        box4.vol = (box4.f6999r1 - box4.f6998r0) * (box4.f6997g1 - box4.f6996g0) * (box4.f6995b1 - box4.f6994b0);
        return Boolean.TRUE;
    }

    /* access modifiers changed from: package-private */
    public MaximizeResult maximize(Box box, Direction direction, int i5, int i6, int i7, int i8, int i9, int i10) {
        QuantizerWu quantizerWu = this;
        Box box2 = box;
        Direction direction2 = direction;
        int bottom = bottom(box2, direction2, quantizerWu.momentsR);
        int bottom2 = bottom(box2, direction2, quantizerWu.momentsG);
        int bottom3 = bottom(box2, direction2, quantizerWu.momentsB);
        int bottom4 = bottom(box2, direction2, quantizerWu.weights);
        int i11 = i6;
        int i12 = -1;
        double d5 = 0.0d;
        int i13 = i5;
        while (i13 < i11) {
            int pVar = top(box2, direction2, i13, quantizerWu.momentsR) + bottom;
            int pVar2 = top(box2, direction2, i13, quantizerWu.momentsG) + bottom2;
            int pVar3 = top(box2, direction2, i13, quantizerWu.momentsB) + bottom3;
            int pVar4 = top(box2, direction2, i13, quantizerWu.weights) + bottom4;
            if (pVar4 != 0) {
                double d6 = ((double) (((pVar * pVar) + (pVar2 * pVar2)) + (pVar3 * pVar3))) / ((double) pVar4);
                int i14 = i7 - pVar;
                int i15 = i8 - pVar2;
                int i16 = i9 - pVar3;
                int i17 = i10 - pVar4;
                if (i17 != 0) {
                    double d7 = d6 + (((double) (((i14 * i14) + (i15 * i15)) + (i16 * i16))) / ((double) i17));
                    if (d7 > d5) {
                        d5 = d7;
                        i12 = i13;
                    }
                }
            }
            i13++;
            quantizerWu = this;
            box2 = box;
        }
        return new MaximizeResult(i12, d5);
    }

    public QuantizerResult quantize(int[] iArr, int i5) {
        constructHistogram(new QuantizerMap().quantize(iArr, i5).colorToCount);
        createMoments();
        List<Integer> createResult = createResult(createBoxes(i5).resultCount);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Integer next : createResult) {
            next.intValue();
            linkedHashMap.put(next, 0);
        }
        return new QuantizerResult(linkedHashMap);
    }

    /* access modifiers changed from: package-private */
    public double variance(Box box) {
        int volume = volume(box, this.momentsR);
        int volume2 = volume(box, this.momentsG);
        int volume3 = volume(box, this.momentsB);
        return (((((((this.moments[getIndex(box.f6999r1, box.f6997g1, box.f6995b1)] - this.moments[getIndex(box.f6999r1, box.f6997g1, box.f6994b0)]) - this.moments[getIndex(box.f6999r1, box.f6996g0, box.f6995b1)]) + this.moments[getIndex(box.f6999r1, box.f6996g0, box.f6994b0)]) - this.moments[getIndex(box.f6998r0, box.f6997g1, box.f6995b1)]) + this.moments[getIndex(box.f6998r0, box.f6997g1, box.f6994b0)]) + this.moments[getIndex(box.f6998r0, box.f6996g0, box.f6995b1)]) - this.moments[getIndex(box.f6998r0, box.f6996g0, box.f6994b0)]) - (((double) (((volume * volume) + (volume2 * volume2)) + (volume3 * volume3))) / ((double) volume(box, this.weights)));
    }
}
