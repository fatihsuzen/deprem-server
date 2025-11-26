package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TonalPalette {
    Map<Integer, Integer> cache = new HashMap();
    double chroma;
    double hue;
    Hct keyColor;

    private static final class KeyColor {
        private static final double MAX_CHROMA_VALUE = 200.0d;
        private final Map<Integer, Double> chromaCache = new HashMap();
        private final double hue;
        private final double requestedChroma;

        public KeyColor(double d5, double d6) {
            this.hue = d5;
            this.requestedChroma = d6;
        }

        private double maxChroma(int i5) {
            if (this.chromaCache.get(Integer.valueOf(i5)) == null) {
                this.chromaCache.put(Integer.valueOf(i5), Double.valueOf(Hct.from(this.hue, MAX_CHROMA_VALUE, (double) i5).getChroma()));
            }
            return this.chromaCache.get(Integer.valueOf(i5)).doubleValue();
        }

        public Hct create() {
            boolean z4;
            int i5 = 100;
            int i6 = 0;
            while (i6 < i5) {
                int i7 = (i6 + i5) / 2;
                int i8 = i7 + 1;
                if (maxChroma(i7) < maxChroma(i8)) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (maxChroma(i7) >= this.requestedChroma - 0.01d) {
                    if (Math.abs(i6 - 50) >= Math.abs(i5 - 50)) {
                        if (i6 == i7) {
                            return Hct.from(this.hue, this.requestedChroma, (double) i6);
                        }
                        i6 = i7;
                    }
                } else if (z4) {
                    i6 = i8;
                }
                i5 = i7;
            }
            return Hct.from(this.hue, this.requestedChroma, (double) i6);
        }
    }

    private TonalPalette(double d5, double d6, Hct hct) {
        this.hue = d5;
        this.chroma = d6;
        this.keyColor = hct;
    }

    public static TonalPalette fromHct(Hct hct) {
        return new TonalPalette(hct.getHue(), hct.getChroma(), hct);
    }

    public static TonalPalette fromHueAndChroma(double d5, double d6) {
        return new TonalPalette(d5, d6, new KeyColor(d5, d6).create());
    }

    public static TonalPalette fromInt(int i5) {
        return fromHct(Hct.fromInt(i5));
    }

    public double getChroma() {
        return this.chroma;
    }

    public Hct getHct(double d5) {
        return Hct.from(this.hue, this.chroma, d5);
    }

    public double getHue() {
        return this.hue;
    }

    public Hct getKeyColor() {
        return this.keyColor;
    }

    public int tone(int i5) {
        Integer num = this.cache.get(Integer.valueOf(i5));
        if (num == null) {
            num = Integer.valueOf(Hct.from(this.hue, this.chroma, (double) i5).toInt());
            this.cache.put(Integer.valueOf(i5), num);
        }
        return num.intValue();
    }
}
