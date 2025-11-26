package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import j$.util.Comparator$CC;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TemperatureCache {
    private final Hct input;
    private Hct precomputedComplement;
    private List<Hct> precomputedHctsByHue;
    private List<Hct> precomputedHctsByTemp;
    private Map<Hct, Double> precomputedTempsByHct;

    private TemperatureCache() {
        throw new UnsupportedOperationException();
    }

    private Hct getColdest() {
        return getHctsByTemp().get(0);
    }

    private List<Hct> getHctsByHue() {
        List<Hct> list = this.precomputedHctsByHue;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (double d5 = 0.0d; d5 <= 360.0d; d5 += 1.0d) {
            arrayList.add(Hct.from(d5, this.input.getChroma(), this.input.getTone()));
        }
        List<Hct> unmodifiableList = DesugarCollections.unmodifiableList(arrayList);
        this.precomputedHctsByHue = unmodifiableList;
        return unmodifiableList;
    }

    private List<Hct> getHctsByTemp() {
        List<Hct> list = this.precomputedHctsByTemp;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(getHctsByHue());
        arrayList.add(this.input);
        Collections.sort(arrayList, Comparator$CC.comparing(new k2(this), new l2()));
        this.precomputedHctsByTemp = arrayList;
        return arrayList;
    }

    private Map<Hct, Double> getTempsByHct() {
        Map<Hct, Double> map = this.precomputedTempsByHct;
        if (map != null) {
            return map;
        }
        ArrayList arrayList = new ArrayList(getHctsByHue());
        arrayList.add(this.input);
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            Hct hct = (Hct) obj;
            hashMap.put(hct, Double.valueOf(rawTemperature(hct)));
        }
        this.precomputedTempsByHct = hashMap;
        return hashMap;
    }

    private Hct getWarmest() {
        return getHctsByTemp().get(getHctsByTemp().size() - 1);
    }

    private static boolean isBetween(double d5, double d6, double d7) {
        return d6 < d7 ? d6 <= d5 && d5 <= d7 : d6 <= d5 || d5 <= d7;
    }

    public static double rawTemperature(Hct hct) {
        double[] labFromArgb = ColorUtils.labFromArgb(hct.toInt());
        return ((Math.pow(Math.hypot(labFromArgb[1], labFromArgb[2]), 1.07d) * 0.02d) * Math.cos(Math.toRadians(MathUtils.sanitizeDegreesDouble(MathUtils.sanitizeDegreesDouble(Math.toDegrees(Math.atan2(labFromArgb[2], labFromArgb[1]))) - 50.0d)))) - 8.0d;
    }

    public List<Hct> getAnalogousColors() {
        return getAnalogousColors(5, 12);
    }

    public Hct getComplement() {
        double d5;
        double d6;
        double d7;
        Hct hct = this.precomputedComplement;
        if (hct != null) {
            return hct;
        }
        double hue = getColdest().getHue();
        double doubleValue = getTempsByHct().get(getColdest()).doubleValue();
        double hue2 = getWarmest().getHue();
        double doubleValue2 = getTempsByHct().get(getWarmest()).doubleValue() - doubleValue;
        boolean isBetween = isBetween(this.input.getHue(), hue, hue2);
        if (isBetween) {
            d5 = hue2;
        } else {
            d5 = hue;
        }
        if (isBetween) {
            d6 = hue;
        } else {
            d6 = hue2;
        }
        Hct hct2 = getHctsByHue().get((int) Math.round(this.input.getHue()));
        double d8 = 1.0d;
        double relativeTemperature = 1.0d - getRelativeTemperature(this.input);
        double d9 = 1000.0d;
        double d10 = 0.0d;
        while (d10 <= 360.0d) {
            double sanitizeDegreesDouble = MathUtils.sanitizeDegreesDouble((d8 * d10) + d5);
            if (!isBetween(sanitizeDegreesDouble, d5, d6)) {
                d7 = d8;
            } else {
                d7 = d8;
                Hct hct3 = getHctsByHue().get((int) Math.round(sanitizeDegreesDouble));
                double abs = Math.abs(relativeTemperature - ((getTempsByHct().get(hct3).doubleValue() - doubleValue) / doubleValue2));
                if (abs < d9) {
                    hct2 = hct3;
                    d9 = abs;
                }
            }
            d10 += d7;
            d8 = d7;
        }
        this.precomputedComplement = hct2;
        return hct2;
    }

    public double getRelativeTemperature(Hct hct) {
        double doubleValue = getTempsByHct().get(getWarmest()).doubleValue() - getTempsByHct().get(getColdest()).doubleValue();
        double doubleValue2 = getTempsByHct().get(hct).doubleValue() - getTempsByHct().get(getColdest()).doubleValue();
        if (doubleValue == 0.0d) {
            return 0.5d;
        }
        return doubleValue2 / doubleValue;
    }

    public List<Hct> getAnalogousColors(int i5, int i6) {
        int i7 = i5;
        int i8 = i6;
        int round = (int) Math.round(this.input.getHue());
        Hct hct = getHctsByHue().get(round);
        double relativeTemperature = getRelativeTemperature(hct);
        ArrayList arrayList = new ArrayList();
        arrayList.add(hct);
        double d5 = 0.0d;
        double d6 = 0.0d;
        int i9 = 0;
        while (i9 < 360) {
            double relativeTemperature2 = getRelativeTemperature(getHctsByHue().get(MathUtils.sanitizeDegreesInt(round + i9)));
            d6 += Math.abs(relativeTemperature2 - relativeTemperature);
            i9++;
            relativeTemperature = relativeTemperature2;
        }
        double d7 = d6 / ((double) i8);
        double relativeTemperature3 = getRelativeTemperature(hct);
        int i10 = 1;
        while (true) {
            if (arrayList.size() >= i8) {
                break;
            }
            Hct hct2 = getHctsByHue().get(MathUtils.sanitizeDegreesInt(round + i10));
            double relativeTemperature4 = getRelativeTemperature(hct2);
            d5 += Math.abs(relativeTemperature4 - relativeTemperature3);
            boolean z4 = d5 >= ((double) arrayList.size()) * d7;
            int i11 = 1;
            while (z4 && arrayList.size() < i8) {
                arrayList.add(hct2);
                int i12 = i10;
                z4 = d5 >= ((double) (arrayList.size() + i11)) * d7;
                i11++;
                i10 = i12;
            }
            i10++;
            if (i10 > 360) {
                while (arrayList.size() < i8) {
                    arrayList.add(hct2);
                }
            } else {
                relativeTemperature3 = relativeTemperature4;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.input);
        int floor = (int) Math.floor((((double) i7) - 1.0d) / 2.0d);
        for (int i13 = 1; i13 < floor + 1; i13++) {
            int i14 = 0 - i13;
            while (i14 < 0) {
                i14 += arrayList.size();
            }
            if (i14 >= arrayList.size()) {
                i14 %= arrayList.size();
            }
            arrayList2.add(0, (Hct) arrayList.get(i14));
        }
        int i15 = i7 - floor;
        for (int i16 = 1; i16 < i15; i16++) {
            int i17 = i16;
            while (i17 < 0) {
                i17 += arrayList.size();
            }
            if (i17 >= arrayList.size()) {
                i17 %= arrayList.size();
            }
            arrayList2.add((Hct) arrayList.get(i17));
        }
        return arrayList2;
    }

    public TemperatureCache(Hct hct) {
        this.input = hct;
    }
}
