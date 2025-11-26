package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CorePalette {

    /* renamed from: a1  reason: collision with root package name */
    public TonalPalette f6976a1;

    /* renamed from: a2  reason: collision with root package name */
    public TonalPalette f6977a2;

    /* renamed from: a3  reason: collision with root package name */
    public TonalPalette f6978a3;
    public TonalPalette error;

    /* renamed from: n1  reason: collision with root package name */
    public TonalPalette f6979n1;

    /* renamed from: n2  reason: collision with root package name */
    public TonalPalette f6980n2;

    private CorePalette(int i5, boolean z4) {
        Hct fromInt = Hct.fromInt(i5);
        double hue = fromInt.getHue();
        double chroma = fromInt.getChroma();
        if (z4) {
            this.f6976a1 = TonalPalette.fromHueAndChroma(hue, chroma);
            this.f6977a2 = TonalPalette.fromHueAndChroma(hue, chroma / 3.0d);
            this.f6978a3 = TonalPalette.fromHueAndChroma(60.0d + hue, chroma / 2.0d);
            this.f6979n1 = TonalPalette.fromHueAndChroma(hue, Math.min(chroma / 12.0d, 4.0d));
            this.f6980n2 = TonalPalette.fromHueAndChroma(hue, Math.min(chroma / 6.0d, 8.0d));
        } else {
            this.f6976a1 = TonalPalette.fromHueAndChroma(hue, Math.max(48.0d, chroma));
            this.f6977a2 = TonalPalette.fromHueAndChroma(hue, 16.0d);
            this.f6978a3 = TonalPalette.fromHueAndChroma(60.0d + hue, 24.0d);
            this.f6979n1 = TonalPalette.fromHueAndChroma(hue, 4.0d);
            this.f6980n2 = TonalPalette.fromHueAndChroma(hue, 8.0d);
        }
        this.error = TonalPalette.fromHueAndChroma(25.0d, 84.0d);
    }

    public static CorePalette contentOf(int i5) {
        return new CorePalette(i5, true);
    }

    public static CorePalette of(int i5) {
        return new CorePalette(i5, false);
    }
}
