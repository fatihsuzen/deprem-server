package androidx.appcompat.app;

class TwilightCalculator {
    private static final float ALTIDUTE_CORRECTION_CIVIL_TWILIGHT = -0.10471976f;

    /* renamed from: C1  reason: collision with root package name */
    private static final float f197C1 = 0.0334196f;

    /* renamed from: C2  reason: collision with root package name */
    private static final float f198C2 = 3.49066E-4f;

    /* renamed from: C3  reason: collision with root package name */
    private static final float f199C3 = 5.236E-6f;
    public static final int DAY = 0;
    private static final float DEGREES_TO_RADIANS = 0.017453292f;

    /* renamed from: J0  reason: collision with root package name */
    private static final float f200J0 = 9.0E-4f;
    public static final int NIGHT = 1;
    private static final float OBLIQUITY = 0.4092797f;
    private static final long UTC_2000 = 946728000000L;
    private static TwilightCalculator sInstance;
    public int state;
    public long sunrise;
    public long sunset;

    TwilightCalculator() {
    }

    static TwilightCalculator getInstance() {
        if (sInstance == null) {
            sInstance = new TwilightCalculator();
        }
        return sInstance;
    }

    public void calculateTwilight(long j5, double d5, double d6) {
        float f5 = ((float) (j5 - UTC_2000)) / 8.64E7f;
        float f6 = (0.01720197f * f5) + 6.24006f;
        double d7 = (double) f6;
        double sin = (Math.sin(d7) * 0.03341960161924362d) + d7 + (Math.sin((double) (2.0f * f6)) * 3.4906598739326E-4d) + (Math.sin((double) (f6 * 3.0f)) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double d8 = (-d6) / 360.0d;
        double round = ((double) (((float) Math.round(((double) (f5 - f200J0)) - d8)) + f200J0)) + d8 + (Math.sin(d7) * 0.0053d) + (Math.sin(2.0d * sin) * -0.0069d);
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d9 = 0.01745329238474369d * d5;
        double sin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d9) * Math.sin(asin))) / (Math.cos(d9) * Math.cos(asin));
        if (sin2 >= 1.0d) {
            this.state = 1;
            this.sunset = -1;
            this.sunrise = -1;
        } else if (sin2 <= -1.0d) {
            this.state = 0;
            this.sunset = -1;
            this.sunrise = -1;
        } else {
            double acos = (double) ((float) (Math.acos(sin2) / 6.283185307179586d));
            this.sunset = Math.round((round + acos) * 8.64E7d) + UTC_2000;
            long round2 = Math.round((round - acos) * 8.64E7d) + UTC_2000;
            this.sunrise = round2;
            if (round2 >= j5 || this.sunset <= j5) {
                this.state = 1;
            } else {
                this.state = 0;
            }
        }
    }
}
