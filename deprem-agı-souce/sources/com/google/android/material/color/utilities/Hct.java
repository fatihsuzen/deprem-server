package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Hct {
    private int argb;
    private double chroma;
    private double hue;
    private double tone;

    private Hct(int i5) {
        setInternalState(i5);
    }

    public static Hct from(double d5, double d6, double d7) {
        return new Hct(HctSolver.solveToInt(d5, d6, d7));
    }

    public static Hct fromInt(int i5) {
        return new Hct(i5);
    }

    private void setInternalState(int i5) {
        this.argb = i5;
        Cam16 fromInt = Cam16.fromInt(i5);
        this.hue = fromInt.getHue();
        this.chroma = fromInt.getChroma();
        this.tone = ColorUtils.lstarFromArgb(i5);
    }

    public double getChroma() {
        return this.chroma;
    }

    public double getHue() {
        return this.hue;
    }

    public double getTone() {
        return this.tone;
    }

    public Hct inViewingConditions(ViewingConditions viewingConditions) {
        double[] xyzInViewingConditions = Cam16.fromInt(toInt()).xyzInViewingConditions(viewingConditions, (double[]) null);
        Cam16 fromXyzInViewingConditions = Cam16.fromXyzInViewingConditions(xyzInViewingConditions[0], xyzInViewingConditions[1], xyzInViewingConditions[2], ViewingConditions.DEFAULT);
        return from(fromXyzInViewingConditions.getHue(), fromXyzInViewingConditions.getChroma(), ColorUtils.lstarFromY(xyzInViewingConditions[1]));
    }

    public void setChroma(double d5) {
        setInternalState(HctSolver.solveToInt(this.hue, d5, this.tone));
    }

    public void setHue(double d5) {
        setInternalState(HctSolver.solveToInt(d5, this.chroma, this.tone));
    }

    public void setTone(double d5) {
        setInternalState(HctSolver.solveToInt(this.hue, this.chroma, d5));
    }

    public int toInt() {
        return this.argb;
    }
}
