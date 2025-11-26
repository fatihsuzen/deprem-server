package com.google.android.material.color.utilities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import java.util.function.Function;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DynamicColor {
    public final Function<DynamicScheme, DynamicColor> background;
    public final ContrastCurve contrastCurve;
    private final HashMap<DynamicScheme, Hct> hctCache = new HashMap<>();
    public final boolean isBackground;
    public final String name;
    public final Function<DynamicScheme, Double> opacity;
    public final Function<DynamicScheme, TonalPalette> palette;
    public final Function<DynamicScheme, DynamicColor> secondBackground;
    public final Function<DynamicScheme, Double> tone;
    public final Function<DynamicScheme, ToneDeltaPair> toneDeltaPair;

    public DynamicColor(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2, boolean z4, @Nullable Function<DynamicScheme, DynamicColor> function3, @Nullable Function<DynamicScheme, DynamicColor> function4, @Nullable ContrastCurve contrastCurve2, @Nullable Function<DynamicScheme, ToneDeltaPair> function5) {
        this.name = str;
        this.palette = function;
        this.tone = function2;
        this.isBackground = z4;
        this.background = function3;
        this.secondBackground = function4;
        this.contrastCurve = contrastCurve2;
        this.toneDeltaPair = function5;
        this.opacity = null;
    }

    public static /* synthetic */ TonalPalette b(TonalPalette tonalPalette, DynamicScheme dynamicScheme) {
        return tonalPalette;
    }

    public static double enableLightForeground(double d5) {
        if (!tonePrefersLightForeground(d5) || toneAllowsLightForeground(d5)) {
            return d5;
        }
        return 49.0d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static double foregroundTone(double r10, double r12) {
        /*
            double r0 = com.google.android.material.color.utilities.Contrast.lighterUnsafe(r10, r12)
            double r2 = com.google.android.material.color.utilities.Contrast.darkerUnsafe(r10, r12)
            double r4 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r0, r10)
            double r6 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r2, r10)
            boolean r10 = tonePrefersLightForeground(r10)
            if (r10 == 0) goto L_0x003b
            double r10 = r4 - r6
            double r10 = java.lang.Math.abs(r10)
            r8 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            int r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r10 >= 0) goto L_0x002f
            int r10 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r10 >= 0) goto L_0x002f
            int r10 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r10 >= 0) goto L_0x002f
            r10 = 1
            goto L_0x0030
        L_0x002f:
            r10 = 0
        L_0x0030:
            int r11 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r11 >= 0) goto L_0x0044
            int r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r11 >= 0) goto L_0x0044
            if (r10 == 0) goto L_0x0045
            goto L_0x0044
        L_0x003b:
            int r10 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r10 >= 0) goto L_0x0045
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 < 0) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            return r0
        L_0x0045:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.DynamicColor.foregroundTone(double, double):double");
    }

    @NonNull
    public static DynamicColor fromArgb(@NonNull String str, int i5) {
        return fromPalette(str, new C1468a(TonalPalette.fromInt(i5)), new C1471b(Hct.fromInt(i5)));
    }

    @NonNull
    public static DynamicColor fromPalette(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2) {
        return new DynamicColor(str, function, function2, false, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public static boolean toneAllowsLightForeground(double d5) {
        if (Math.round(d5) <= 49) {
            return true;
        }
        return false;
    }

    public static boolean tonePrefersLightForeground(double d5) {
        if (Math.round(d5) < 60) {
            return true;
        }
        return false;
    }

    public int getArgb(@NonNull DynamicScheme dynamicScheme) {
        int i5 = getHct(dynamicScheme).toInt();
        Function<DynamicScheme, Double> function = this.opacity;
        if (function == null) {
            return i5;
        }
        return (MathUtils.clampInt(0, 255, (int) Math.round(function.apply(dynamicScheme).doubleValue() * 255.0d)) << 24) | (i5 & ViewCompat.MEASURED_SIZE_MASK);
    }

    @NonNull
    public Hct getHct(@NonNull DynamicScheme dynamicScheme) {
        Hct hct = this.hctCache.get(dynamicScheme);
        if (hct != null) {
            return hct;
        }
        Hct hct2 = this.palette.apply(dynamicScheme).getHct(getTone(dynamicScheme));
        if (this.hctCache.size() > 4) {
            this.hctCache.clear();
        }
        this.hctCache.put(dynamicScheme, hct2);
        return hct2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x013e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x013f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double getTone(@androidx.annotation.NonNull com.google.android.material.color.utilities.DynamicScheme r33) {
        /*
            r32 = this;
            r0 = r32
            r1 = r33
            double r2 = r1.contrastLevel
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r3 = 0
            r6 = 1
            if (r2 >= 0) goto L_0x0010
            r2 = r6
            goto L_0x0011
        L_0x0010:
            r2 = r3
        L_0x0011:
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.ToneDeltaPair> r7 = r0.toneDeltaPair
            if (r7 == 0) goto L_0x0140
            java.lang.Object r7 = r7.apply(r1)
            com.google.android.material.color.utilities.ToneDeltaPair r7 = (com.google.android.material.color.utilities.ToneDeltaPair) r7
            com.google.android.material.color.utilities.DynamicColor r16 = r7.getRoleA()
            com.google.android.material.color.utilities.DynamicColor r17 = r7.getRoleB()
            double r18 = r7.getDelta()
            r20 = r4
            com.google.android.material.color.utilities.TonePolarity r4 = r7.getPolarity()
            boolean r5 = r7.getStayTogether()
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r7 = r0.background
            java.lang.Object r7 = r7.apply(r1)
            com.google.android.material.color.utilities.DynamicColor r7 = (com.google.android.material.color.utilities.DynamicColor) r7
            r22 = 4632233691727265792(0x4049000000000000, double:50.0)
            double r8 = r7.getTone(r1)
            com.google.android.material.color.utilities.TonePolarity r7 = com.google.android.material.color.utilities.TonePolarity.NEARER
            if (r4 == r7) goto L_0x0053
            com.google.android.material.color.utilities.TonePolarity r7 = com.google.android.material.color.utilities.TonePolarity.LIGHTER
            if (r4 != r7) goto L_0x004b
            boolean r7 = r1.isDark
            if (r7 == 0) goto L_0x0053
        L_0x004b:
            com.google.android.material.color.utilities.TonePolarity r7 = com.google.android.material.color.utilities.TonePolarity.DARKER
            if (r4 != r7) goto L_0x0054
            boolean r4 = r1.isDark
            if (r4 == 0) goto L_0x0054
        L_0x0053:
            r3 = r6
        L_0x0054:
            if (r3 == 0) goto L_0x0059
            r4 = r16
            goto L_0x005b
        L_0x0059:
            r4 = r17
        L_0x005b:
            if (r3 == 0) goto L_0x0060
            r3 = r17
            goto L_0x0062
        L_0x0060:
            r3 = r16
        L_0x0062:
            java.lang.String r6 = r0.name
            java.lang.String r7 = r4.name
            boolean r6 = r6.equals(r7)
            boolean r7 = r1.isDark
            if (r7 == 0) goto L_0x0071
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L_0x0073
        L_0x0071:
            r10 = -4616189618054758400(0xbff0000000000000, double:-1.0)
        L_0x0073:
            com.google.android.material.color.utilities.ContrastCurve r7 = r4.contrastCurve
            r16 = 4633641066610819072(0x404e000000000000, double:60.0)
            double r14 = r1.contrastLevel
            double r14 = r7.get(r14)
            com.google.android.material.color.utilities.ContrastCurve r7 = r3.contrastCurve
            r24 = 4632092954238910464(0x4048800000000000, double:49.0)
            double r12 = r1.contrastLevel
            double r12 = r7.get(r12)
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, java.lang.Double> r4 = r4.tone
            java.lang.Object r4 = r4.apply(r1)
            java.lang.Double r4 = (java.lang.Double) r4
            r7 = r5
            double r4 = r4.doubleValue()
            double r26 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r8, r4)
            int r26 = (r26 > r14 ? 1 : (r26 == r14 ? 0 : -1))
            if (r26 < 0) goto L_0x00a0
            goto L_0x00a4
        L_0x00a0:
            double r4 = foregroundTone(r8, r14)
        L_0x00a4:
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, java.lang.Double> r3 = r3.tone
            java.lang.Object r1 = r3.apply(r1)
            java.lang.Double r1 = (java.lang.Double) r1
            r26 = r2
            double r1 = r1.doubleValue()
            double r27 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r8, r1)
            int r3 = (r27 > r12 ? 1 : (r27 == r12 ? 0 : -1))
            if (r3 < 0) goto L_0x00bb
            goto L_0x00bf
        L_0x00bb:
            double r1 = foregroundTone(r8, r12)
        L_0x00bf:
            if (r26 == 0) goto L_0x00c9
            double r4 = foregroundTone(r8, r14)
            double r1 = foregroundTone(r8, r12)
        L_0x00c9:
            double r8 = r1 - r4
            double r8 = r8 * r10
            int r3 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
            if (r3 >= 0) goto L_0x00ee
            double r1 = r18 * r10
            double r30 = r4 + r1
            r26 = 0
            r28 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r8 = com.google.android.material.color.utilities.MathUtils.clampDouble(r26, r28, r30)
            double r12 = r8 - r4
            double r12 = r12 * r10
            int r3 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1))
            if (r3 >= 0) goto L_0x00ed
            r28 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r30 = r8 - r1
            r26 = 0
            double r4 = com.google.android.material.color.utilities.MathUtils.clampDouble(r26, r28, r30)
        L_0x00ed:
            r1 = r8
        L_0x00ee:
            int r3 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r3 > 0) goto L_0x0111
            int r3 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r3 >= 0) goto L_0x0111
            int r3 = (r10 > r20 ? 1 : (r10 == r20 ? 0 : -1))
            if (r3 <= 0) goto L_0x0105
            double r18 = r18 * r10
            double r3 = r18 + r16
            double r12 = java.lang.Math.max(r1, r3)
        L_0x0102:
            r4 = r16
            goto L_0x013c
        L_0x0105:
            double r18 = r18 * r10
            double r3 = r18 + r24
            double r1 = java.lang.Math.min(r1, r3)
        L_0x010d:
            r12 = r1
            r4 = r24
            goto L_0x013c
        L_0x0111:
            int r3 = (r22 > r1 ? 1 : (r22 == r1 ? 0 : -1))
            if (r3 > 0) goto L_0x013b
            int r3 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r3 >= 0) goto L_0x013b
            if (r7 == 0) goto L_0x0131
            int r3 = (r10 > r20 ? 1 : (r10 == r20 ? 0 : -1))
            if (r3 <= 0) goto L_0x0128
            double r18 = r18 * r10
            double r3 = r18 + r16
            double r12 = java.lang.Math.max(r1, r3)
            goto L_0x0102
        L_0x0128:
            double r18 = r18 * r10
            double r3 = r18 + r24
            double r1 = java.lang.Math.min(r1, r3)
            goto L_0x010d
        L_0x0131:
            int r1 = (r10 > r20 ? 1 : (r10 == r20 ? 0 : -1))
            if (r1 <= 0) goto L_0x0138
            r12 = r16
            goto L_0x013c
        L_0x0138:
            r12 = r24
            goto L_0x013c
        L_0x013b:
            r12 = r1
        L_0x013c:
            if (r6 == 0) goto L_0x013f
            return r4
        L_0x013f:
            return r12
        L_0x0140:
            r26 = r2
            r20 = r4
            r16 = 4633641066610819072(0x404e000000000000, double:60.0)
            r22 = 4632233691727265792(0x4049000000000000, double:50.0)
            r24 = 4632092954238910464(0x4048800000000000, double:49.0)
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, java.lang.Double> r2 = r0.tone
            java.lang.Object r2 = r2.apply(r1)
            java.lang.Double r2 = (java.lang.Double) r2
            double r4 = r2.doubleValue()
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r2 = r0.background
            if (r2 != 0) goto L_0x015e
            return r4
        L_0x015e:
            java.lang.Object r2 = r2.apply(r1)
            com.google.android.material.color.utilities.DynamicColor r2 = (com.google.android.material.color.utilities.DynamicColor) r2
            double r7 = r2.getTone(r1)
            com.google.android.material.color.utilities.ContrastCurve r2 = r0.contrastCurve
            double r12 = r1.contrastLevel
            double r12 = r2.get(r12)
            double r14 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r7, r4)
            int r2 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r2 < 0) goto L_0x0179
            goto L_0x017d
        L_0x0179:
            double r4 = foregroundTone(r7, r12)
        L_0x017d:
            if (r26 == 0) goto L_0x0183
            double r4 = foregroundTone(r7, r12)
        L_0x0183:
            boolean r2 = r0.isBackground
            if (r2 == 0) goto L_0x019d
            int r2 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x019d
            int r2 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r2 >= 0) goto L_0x019d
            r14 = r24
            double r4 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r14, r7)
            int r2 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r2 < 0) goto L_0x019a
            goto L_0x019e
        L_0x019a:
            r14 = r16
            goto L_0x019e
        L_0x019d:
            r14 = r4
        L_0x019e:
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r2 = r0.secondBackground
            if (r2 == 0) goto L_0x0220
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r2 = r0.background
            java.lang.Object r2 = r2.apply(r1)
            com.google.android.material.color.utilities.DynamicColor r2 = (com.google.android.material.color.utilities.DynamicColor) r2
            double r4 = r2.getTone(r1)
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r2 = r0.secondBackground
            java.lang.Object r2 = r2.apply(r1)
            com.google.android.material.color.utilities.DynamicColor r2 = (com.google.android.material.color.utilities.DynamicColor) r2
            double r1 = r2.getTone(r1)
            double r7 = java.lang.Math.max(r4, r1)
            r16 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            double r10 = java.lang.Math.min(r4, r1)
            double r18 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r7, r14)
            int r9 = (r18 > r12 ? 1 : (r18 == r12 ? 0 : -1))
            if (r9 < 0) goto L_0x01d5
            double r18 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r10, r14)
            int r9 = (r18 > r12 ? 1 : (r18 == r12 ? 0 : -1))
            if (r9 < 0) goto L_0x01d5
            goto L_0x0220
        L_0x01d5:
            double r7 = com.google.android.material.color.utilities.Contrast.lighter(r7, r12)
            double r9 = com.google.android.material.color.utilities.Contrast.darker(r10, r12)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            int r12 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r12 == 0) goto L_0x01ed
            java.lang.Double r13 = java.lang.Double.valueOf(r7)
            r11.add(r13)
        L_0x01ed:
            int r13 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r13 == 0) goto L_0x01f8
            java.lang.Double r14 = java.lang.Double.valueOf(r9)
            r11.add(r14)
        L_0x01f8:
            boolean r4 = tonePrefersLightForeground(r4)
            if (r4 != 0) goto L_0x021a
            boolean r1 = tonePrefersLightForeground(r1)
            if (r1 == 0) goto L_0x0205
            goto L_0x021a
        L_0x0205:
            int r1 = r11.size()
            if (r1 != r6) goto L_0x0216
            java.lang.Object r1 = r11.get(r3)
            java.lang.Double r1 = (java.lang.Double) r1
            double r1 = r1.doubleValue()
            return r1
        L_0x0216:
            if (r13 != 0) goto L_0x0219
            return r20
        L_0x0219:
            return r9
        L_0x021a:
            if (r12 != 0) goto L_0x021f
            r1 = 4636737291354636288(0x4059000000000000, double:100.0)
            return r1
        L_0x021f:
            return r7
        L_0x0220:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.DynamicColor.getTone(com.google.android.material.color.utilities.DynamicScheme):double");
    }

    @NonNull
    public static DynamicColor fromPalette(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2, boolean z4) {
        return new DynamicColor(str, function, function2, z4, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2, boolean z4, @Nullable Function<DynamicScheme, DynamicColor> function3, @Nullable Function<DynamicScheme, DynamicColor> function4, @Nullable ContrastCurve contrastCurve2, @Nullable Function<DynamicScheme, ToneDeltaPair> function5, @Nullable Function<DynamicScheme, Double> function6) {
        this.name = str;
        this.palette = function;
        this.tone = function2;
        this.isBackground = z4;
        this.background = function3;
        this.secondBackground = function4;
        this.contrastCurve = contrastCurve2;
        this.toneDeltaPair = function5;
        this.opacity = function6;
    }
}
