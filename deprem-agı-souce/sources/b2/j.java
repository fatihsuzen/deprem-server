package B2;

import android.view.animation.Interpolator;

public final class j implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private double f17345a;

    /* renamed from: b  reason: collision with root package name */
    private double f17346b;

    public j(double d5, double d6) {
        this.f17345a = d5;
        this.f17346b = d6;
    }

    public float getInterpolation(float f5) {
        return (float) ((((double) -1) * Math.pow(2.718281828459045d, ((double) (-f5)) / this.f17345a) * Math.cos(this.f17346b * ((double) f5))) + ((double) 1));
    }
}
