package com.google.android.material.color.utilities;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.function.Function;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialDynamicColors {
    private final boolean isExtendedFidelity;

    public MaterialDynamicColors() {
        this.isExtendedFidelity = false;
    }

    public static /* synthetic */ Double A0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 80.0d;
        } else {
            d5 = 40.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ ToneDeltaPair B(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.secondaryContainer(), materialDynamicColors.secondary(), 10.0d, TonePolarity.NEARER, false);
    }

    public static /* synthetic */ Double B0(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        double d5;
        double d6;
        if (materialDynamicColors.isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.foregroundTone(materialDynamicColors.primaryContainer().tone.apply(dynamicScheme).doubleValue(), 4.5d));
        }
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d6 = 0.0d;
            } else {
                d6 = 100.0d;
            }
            return Double.valueOf(d6);
        }
        if (dynamicScheme.isDark) {
            d5 = 90.0d;
        } else {
            d5 = 30.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double B1(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 30.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ ToneDeltaPair C(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.errorContainer(), materialDynamicColors.error(), 10.0d, TonePolarity.NEARER, false);
    }

    public static /* synthetic */ Double C1(DynamicScheme dynamicScheme) {
        double d5;
        double d6;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d6 = 90.0d;
            } else {
                d6 = 25.0d;
            }
            return Double.valueOf(d6);
        }
        if (dynamicScheme.isDark) {
            d5 = 80.0d;
        } else {
            d5 = 40.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double D0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 20.0d;
        } else {
            d5 = 95.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double E0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 6.0d;
        } else {
            d5 = new ContrastCurve(87.0d, 87.0d, 80.0d, 75.0d).get(dynamicScheme.contrastLevel);
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double F(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 60.0d;
        } else {
            d5 = 50.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double F1(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 10.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double G(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = new ContrastCurve(12.0d, 12.0d, 16.0d, 20.0d).get(dynamicScheme.contrastLevel);
        } else {
            d5 = new ContrastCurve(94.0d, 94.0d, 92.0d, 90.0d).get(dynamicScheme.contrastLevel);
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double G0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 80.0d;
        } else {
            d5 = 40.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double G1(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        double d5;
        double d6;
        if (materialDynamicColors.isFidelity(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.sourceColorHct.getTone());
        }
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d6 = 85.0d;
            } else {
                d6 = 25.0d;
            }
            return Double.valueOf(d6);
        }
        if (dynamicScheme.isDark) {
            d5 = 30.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double H1(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 30.0d;
        } else {
            d5 = 80.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double I1(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 80.0d;
        } else {
            d5 = 30.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double J(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 90.0d;
        } else {
            d5 = 10.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double J0(DynamicScheme dynamicScheme) {
        double d5;
        double d6;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d6 = 100.0d;
            } else {
                d6 = 0.0d;
            }
            return Double.valueOf(d6);
        }
        if (dynamicScheme.isDark) {
            d5 = 80.0d;
        } else {
            d5 = 40.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double K(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 10.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double L(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = new ContrastCurve(24.0d, 24.0d, 29.0d, 34.0d).get(dynamicScheme.contrastLevel);
        } else {
            d5 = 98.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double L0(DynamicScheme dynamicScheme) {
        double d5;
        double d6;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d6 = 10.0d;
            } else {
                d6 = 90.0d;
            }
            return Double.valueOf(d6);
        }
        if (dynamicScheme.isDark) {
            d5 = 20.0d;
        } else {
            d5 = 100.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double M(DynamicScheme dynamicScheme) {
        double d5 = 100.0d;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d5 = 10.0d;
            }
            return Double.valueOf(d5);
        }
        if (dynamicScheme.isDark) {
            d5 = 20.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double M1(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 30.0d;
        } else {
            d5 = 80.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double P0(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 90.0d;
        } else {
            d5 = 30.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double Q(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        double d5;
        double d6;
        materialDynamicColors.getClass();
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d6 = 60.0d;
            } else {
                d6 = 49.0d;
            }
            return Double.valueOf(d6);
        } else if (materialDynamicColors.isFidelity(dynamicScheme)) {
            return Double.valueOf(DislikeAnalyzer.fixIfDisliked(dynamicScheme.tertiaryPalette.getHct(dynamicScheme.sourceColorHct.getTone())).getTone());
        } else {
            if (dynamicScheme.isDark) {
                d5 = 30.0d;
            } else {
                d5 = 90.0d;
            }
            return Double.valueOf(d5);
        }
    }

    public static /* synthetic */ Double R0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 90.0d;
        } else {
            d5 = 20.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double S0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = new ContrastCurve(22.0d, 22.0d, 26.0d, 30.0d).get(dynamicScheme.contrastLevel);
        } else {
            d5 = new ContrastCurve(90.0d, 90.0d, 84.0d, 80.0d).get(dynamicScheme.contrastLevel);
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double U(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 40.0d;
        } else {
            d5 = 80.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double U1(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 25.0d;
        } else {
            d5 = 30.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double W(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 80.0d;
        } else {
            d5 = 30.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double W0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 10.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double W1(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 30.0d;
        } else {
            d5 = 80.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ ToneDeltaPair X1(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.tertiaryFixed(), materialDynamicColors.tertiaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public static /* synthetic */ Double Y0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 10.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double Z(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 100.0d;
        } else {
            d5 = 0.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ ToneDeltaPair Z0(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.secondaryContainer(), materialDynamicColors.secondary(), 10.0d, TonePolarity.NEARER, false);
    }

    public static /* synthetic */ ToneDeltaPair a(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.primaryFixed(), materialDynamicColors.primaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public static /* synthetic */ Double a0(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        double d5;
        materialDynamicColors.getClass();
        double d6 = 30.0d;
        if (dynamicScheme.isDark) {
            d5 = 30.0d;
        } else {
            d5 = 90.0d;
        }
        if (isMonochrome(dynamicScheme)) {
            if (!dynamicScheme.isDark) {
                d6 = 85.0d;
            }
            return Double.valueOf(d6);
        } else if (!materialDynamicColors.isFidelity(dynamicScheme)) {
            return Double.valueOf(d5);
        } else {
            return Double.valueOf(findDesiredChromaByTone(dynamicScheme.secondaryPalette.getHue(), dynamicScheme.secondaryPalette.getChroma(), d5, !dynamicScheme.isDark));
        }
    }

    public static /* synthetic */ Double a1(DynamicScheme dynamicScheme) {
        double d5;
        double d6;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d6 = 10.0d;
            } else {
                d6 = 90.0d;
            }
            return Double.valueOf(d6);
        }
        if (dynamicScheme.isDark) {
            d5 = 20.0d;
        } else {
            d5 = 100.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double b(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 20.0d;
        } else {
            d5 = 100.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double b0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = new ContrastCurve(17.0d, 17.0d, 21.0d, 25.0d).get(dynamicScheme.contrastLevel);
        } else {
            d5 = new ContrastCurve(92.0d, 92.0d, 88.0d, 85.0d).get(dynamicScheme.contrastLevel);
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double b1(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 90.0d;
        } else {
            d5 = 30.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double d1(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 90.0d;
        } else {
            d5 = 10.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ ToneDeltaPair e1(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.secondaryFixed(), materialDynamicColors.secondaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public static /* synthetic */ ToneDeltaPair f(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.primaryFixed(), materialDynamicColors.primaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public static /* synthetic */ Double f2(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = new ContrastCurve(10.0d, 10.0d, 11.0d, 12.0d).get(dynamicScheme.contrastLevel);
        } else {
            d5 = new ContrastCurve(96.0d, 96.0d, 96.0d, 95.0d).get(dynamicScheme.contrastLevel);
        }
        return Double.valueOf(d5);
    }

    static double findDesiredChromaByTone(double d5, double d6, double d7, boolean z4) {
        double d8;
        Hct from = Hct.from(d5, d6, d7);
        if (from.getChroma() < d6) {
            double chroma = from.getChroma();
            while (from.getChroma() < d6) {
                if (z4) {
                    d8 = -1.0d;
                } else {
                    d8 = 1.0d;
                }
                d7 += d8;
                Hct from2 = Hct.from(d5, d6, d7);
                if (chroma > from2.getChroma() || Math.abs(from2.getChroma() - d6) < 0.4d) {
                    return d7;
                }
                if (Math.abs(from2.getChroma() - d6) < Math.abs(from.getChroma() - d6)) {
                    from = from2;
                }
                chroma = Math.max(chroma, from2.getChroma());
            }
        }
        return d7;
    }

    public static /* synthetic */ Double g(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 30.0d;
        } else {
            d5 = 80.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double g1(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        double d5;
        double d6;
        materialDynamicColors.getClass();
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d6 = 0.0d;
            } else {
                d6 = 100.0d;
            }
            return Double.valueOf(d6);
        } else if (materialDynamicColors.isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.foregroundTone(materialDynamicColors.tertiaryContainer().tone.apply(dynamicScheme).doubleValue(), 4.5d));
        } else {
            if (dynamicScheme.isDark) {
                d5 = 90.0d;
            } else {
                d5 = 30.0d;
            }
            return Double.valueOf(d5);
        }
    }

    public static /* synthetic */ Double i1(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 40.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    private boolean isFidelity(DynamicScheme dynamicScheme) {
        Variant variant;
        Variant variant2;
        if ((this.isExtendedFidelity && (variant2 = dynamicScheme.variant) != Variant.MONOCHROME && variant2 != Variant.NEUTRAL) || (variant = dynamicScheme.variant) == Variant.FIDELITY || variant == Variant.CONTENT) {
            return true;
        }
        return false;
    }

    private static boolean isMonochrome(DynamicScheme dynamicScheme) {
        if (dynamicScheme.variant == Variant.MONOCHROME) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ Double j(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 100.0d;
        } else {
            d5 = 10.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double k1(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 30.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double l(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        materialDynamicColors.getClass();
        double d5 = 90.0d;
        if (isMonochrome(dynamicScheme)) {
            if (!dynamicScheme.isDark) {
                d5 = 10.0d;
            }
            return Double.valueOf(d5);
        } else if (materialDynamicColors.isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.foregroundTone(materialDynamicColors.secondaryContainer().tone.apply(dynamicScheme).doubleValue(), 4.5d));
        } else {
            if (!dynamicScheme.isDark) {
                d5 = 30.0d;
            }
            return Double.valueOf(d5);
        }
    }

    public static /* synthetic */ Double l0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 30.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ ToneDeltaPair l1(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.primaryContainer(), materialDynamicColors.primary(), 10.0d, TonePolarity.NEARER, false);
    }

    public static /* synthetic */ Double m(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 80.0d;
        } else {
            d5 = 40.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double n0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 0.2d;
        } else {
            d5 = 0.12d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double o1(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 80.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double p(DynamicScheme dynamicScheme) {
        double d5 = 90.0d;
        if (isMonochrome(dynamicScheme)) {
            if (!dynamicScheme.isDark) {
                d5 = 10.0d;
            }
            return Double.valueOf(d5);
        }
        if (!dynamicScheme.isDark) {
            d5 = 30.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ ToneDeltaPair p0(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.errorContainer(), materialDynamicColors.error(), 10.0d, TonePolarity.NEARER, false);
    }

    public static /* synthetic */ Double q0(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 40.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double r(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = new ContrastCurve(4.0d, 4.0d, 2.0d, 0.0d).get(dynamicScheme.contrastLevel);
        } else {
            d5 = 100.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double s(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 6.0d;
        } else {
            d5 = 98.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double s1(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 100.0d;
        } else {
            d5 = 10.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ ToneDeltaPair t(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.primaryContainer(), materialDynamicColors.primary(), 10.0d, TonePolarity.NEARER, false);
    }

    public static /* synthetic */ ToneDeltaPair t0(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.secondaryFixed(), materialDynamicColors.secondaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public static /* synthetic */ ToneDeltaPair u1(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.tertiaryFixed(), materialDynamicColors.tertiaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public static /* synthetic */ Double v1(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 70.0d;
        } else {
            d5 = 80.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double y0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 6.0d;
        } else {
            d5 = 98.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ ToneDeltaPair y1(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.tertiaryContainer(), materialDynamicColors.tertiary(), 10.0d, TonePolarity.NEARER, false);
    }

    public static /* synthetic */ ToneDeltaPair z0(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.tertiaryContainer(), materialDynamicColors.tertiary(), 10.0d, TonePolarity.NEARER, false);
    }

    @NonNull
    public DynamicColor background() {
        return new DynamicColor("background", new Z0(), new C1470a1(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor controlActivated() {
        return DynamicColor.fromPalette("control_activated", new C1531v0(), new C1534w0());
    }

    @NonNull
    public DynamicColor controlHighlight() {
        return new DynamicColor("control_highlight", new S0(), new T0(), false, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null, new U0());
    }

    @NonNull
    public DynamicColor controlNormal() {
        return DynamicColor.fromPalette("control_normal", new C1487g0(), new C1519r0());
    }

    @NonNull
    public DynamicColor error() {
        return new DynamicColor(CampaignEx.JSON_NATIVE_VIDEO_ERROR, new I(), new K(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 7.0d), new L(this));
    }

    @NonNull
    public DynamicColor errorContainer() {
        return new DynamicColor("error_container", new C1472b0(), new C1475c0(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), new C1478d0(this));
    }

    @NonNull
    public DynamicColor highestSurface(@NonNull DynamicScheme dynamicScheme) {
        if (dynamicScheme.isDark) {
            return surfaceBright();
        }
        return surfaceDim();
    }

    @NonNull
    public DynamicColor inverseOnSurface() {
        return new DynamicColor("inverse_on_surface", new C1527u(), new C1530v(), false, new C1533w(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor inversePrimary() {
        return new DynamicColor("inverse_primary", new C1512o1(), new C1515p1(), false, new C1518q1(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 7.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor inverseSurface() {
        return new DynamicColor("inverse_surface", new T(), new U(), false, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor neutralPaletteKeyColor() {
        return DynamicColor.fromPalette("neutral_palette_key_color", new C1507n(), new C1539y());
    }

    @NonNull
    public DynamicColor neutralVariantPaletteKeyColor() {
        return DynamicColor.fromPalette("neutral_variant_palette_key_color", new R1(), new S1());
    }

    @NonNull
    public DynamicColor onBackground() {
        return new DynamicColor("on_background", new C1479d1(), new C1482e1(), false, new C1485f1(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 3.0d, 4.5d, 7.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onError() {
        return new DynamicColor("on_error", new D1(), new E1(), false, new F1(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onErrorContainer() {
        return new DynamicColor("on_error_container", new W(), new X(), false, new Y(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onPrimary() {
        return new DynamicColor("on_primary", new C1503l1(), new C1506m1(), false, new C1509n1(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onPrimaryContainer() {
        return new DynamicColor("on_primary_container", new I1(), new J1(this), false, new K1(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onPrimaryFixed() {
        return new DynamicColor("on_primary_fixed", new E(), new F(), false, new G(this), new H(this), new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onPrimaryFixedVariant() {
        return new DynamicColor("on_primary_fixed_variant", new C1532v1(), new C1535w1(), false, new C1538x1(this), new C1541y1(this), new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onSecondary() {
        return new DynamicColor("on_secondary", new C1477d(), new C1480e(), false, new C1483f(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onSecondaryContainer() {
        return new DynamicColor("on_secondary_container", new B(), new C(this), false, new D(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onSecondaryFixed() {
        return new DynamicColor("on_secondary_fixed", new C1516q(), new r(), false, new C1521s(this), new C1524t(this), new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onSecondaryFixedVariant() {
        return new DynamicColor("on_secondary_fixed_variant", new C1508n0(), new C1511o0(), false, new C1514p0(this), new C1517q0(this), new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onSurface() {
        return new DynamicColor("on_surface", new N1(), new Y1(), false, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onSurfaceVariant() {
        return new DynamicColor("on_surface_variant", new Q(), new S(), false, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onTertiary() {
        return new DynamicColor("on_tertiary", new C1488g1(), new C1520r1(), false, new C1(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onTertiaryContainer() {
        return new DynamicColor("on_tertiary_container", new C1536x(), new C1542z(this), false, new A(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onTertiaryFixed() {
        return new DynamicColor("on_tertiary_fixed", new M0(), new N0(), false, new O0(this), new P0(this), new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onTertiaryFixedVariant() {
        return new DynamicColor("on_tertiary_fixed_variant", new A0(), new B0(), false, new C0(this), new D0(this), new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor outline() {
        return new DynamicColor("outline", new C1501l(), new C1504m(), false, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.5d, 3.0d, 4.5d, 7.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor outlineVariant() {
        return new DynamicColor("outline_variant", new C1491h1(), new C1494i1(), false, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor primary() {
        return new DynamicColor("primary", new C1493i0(), new C1496j0(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 7.0d), new C1499k0(this));
    }

    @NonNull
    public DynamicColor primaryContainer() {
        return new DynamicColor("primary_container", new W0(), new X0(this), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), new Y0(this));
    }

    @NonNull
    public DynamicColor primaryFixed() {
        return new DynamicColor("primary_fixed", new a2(), new b2(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), new c2(this));
    }

    @NonNull
    public DynamicColor primaryFixedDim() {
        return new DynamicColor("primary_fixed_dim", new d2(), new e2(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), new f2(this));
    }

    @NonNull
    public DynamicColor primaryPaletteKeyColor() {
        return DynamicColor.fromPalette("primary_palette_key_color", new C1537x0(), new C1540y0());
    }

    @NonNull
    public DynamicColor scrim() {
        return new DynamicColor("scrim", new C1502l0(), new C1505m0(), false, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor secondary() {
        return new DynamicColor("secondary", new C1486g(), new C1489h(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 7.0d), new C1492i(this));
    }

    @NonNull
    public DynamicColor secondaryContainer() {
        return new DynamicColor("secondary_container", new I0(), new J0(this), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), new L0(this));
    }

    @NonNull
    public DynamicColor secondaryFixed() {
        return new DynamicColor("secondary_fixed", new C1523s1(), new C1526t1(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), new C1529u1(this));
    }

    @NonNull
    public DynamicColor secondaryFixedDim() {
        return new DynamicColor("secondary_fixed_dim", new L1(), new M1(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), new O1(this));
    }

    @NonNull
    public DynamicColor secondaryPaletteKeyColor() {
        return DynamicColor.fromPalette("secondary_palette_key_color", new E0(), new F0());
    }

    @NonNull
    public DynamicColor shadow() {
        return new DynamicColor("shadow", new V1(), new W1(), false, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor surface() {
        return new DynamicColor("surface", new C1474c(), new C1543z0(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor surfaceBright() {
        return new DynamicColor("surface_bright", new C1497j1(), new C1500k1(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor surfaceContainer() {
        return new DynamicColor("surface_container", new O(), new P(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor surfaceContainerHigh() {
        return new DynamicColor("surface_container_high", new C1473b1(), new C1476c1(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor surfaceContainerHighest() {
        return new DynamicColor("surface_container_highest", new X1(), new Z1(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor surfaceContainerLow() {
        return new DynamicColor("surface_container_low", new G0(), new H0(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor surfaceContainerLowest() {
        return new DynamicColor("surface_container_lowest", new C1495j(), new C1498k(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor surfaceDim() {
        return new DynamicColor("surface_dim", new J(), new V(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor surfaceTint() {
        return new DynamicColor("surface_tint", new C1510o(), new C1513p(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor surfaceVariant() {
        return new DynamicColor("surface_variant", new P1(), new Q1(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor tertiary() {
        return new DynamicColor("tertiary", new C1522s0(), new C1525t0(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 7.0d), new C1528u0(this));
    }

    @NonNull
    public DynamicColor tertiaryContainer() {
        return new DynamicColor("tertiary_container", new g2(), new h2(this), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), new i2(this));
    }

    @NonNull
    public DynamicColor tertiaryFixed() {
        return new DynamicColor("tertiary_fixed", new C1481e0(), new C1484f0(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), new C1490h0(this));
    }

    @NonNull
    public DynamicColor tertiaryFixedDim() {
        return new DynamicColor("tertiary_fixed_dim", new C1544z1(), new A1(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d), new B1(this));
    }

    @NonNull
    public DynamicColor tertiaryPaletteKeyColor() {
        return DynamicColor.fromPalette("tertiary_palette_key_color", new Q0(), new R0());
    }

    @NonNull
    public DynamicColor textHintInverse() {
        return DynamicColor.fromPalette("text_hint_inverse", new T1(), new U1());
    }

    @NonNull
    public DynamicColor textPrimaryInverse() {
        return DynamicColor.fromPalette("text_primary_inverse", new M(), new N());
    }

    @NonNull
    public DynamicColor textPrimaryInverseDisableOnly() {
        return DynamicColor.fromPalette("text_primary_inverse_disable_only", new G1(), new H1());
    }

    @NonNull
    public DynamicColor textSecondaryAndTertiaryInverse() {
        return DynamicColor.fromPalette("text_secondary_and_tertiary_inverse", new Z(), new C1469a0());
    }

    @NonNull
    public DynamicColor textSecondaryAndTertiaryInverseDisabled() {
        return DynamicColor.fromPalette("text_secondary_and_tertiary_inverse_disabled", new K0(), new V0());
    }

    public MaterialDynamicColors(boolean z4) {
        this.isExtendedFidelity = z4;
    }
}
