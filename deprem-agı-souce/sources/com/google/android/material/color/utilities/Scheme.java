package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@Deprecated
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Scheme {
    private int background;
    private int error;
    private int errorContainer;
    private int inverseOnSurface;
    private int inversePrimary;
    private int inverseSurface;
    private int onBackground;
    private int onError;
    private int onErrorContainer;
    private int onPrimary;
    private int onPrimaryContainer;
    private int onSecondary;
    private int onSecondaryContainer;
    private int onSurface;
    private int onSurfaceVariant;
    private int onTertiary;
    private int onTertiaryContainer;
    private int outline;
    private int outlineVariant;
    private int primary;
    private int primaryContainer;
    private int scrim;
    private int secondary;
    private int secondaryContainer;
    private int shadow;
    private int surface;
    private int surfaceVariant;
    private int tertiary;
    private int tertiaryContainer;

    public Scheme() {
    }

    public static Scheme dark(int i5) {
        return darkFromCorePalette(CorePalette.of(i5));
    }

    public static Scheme darkContent(int i5) {
        return darkFromCorePalette(CorePalette.contentOf(i5));
    }

    private static Scheme darkFromCorePalette(CorePalette corePalette) {
        return new Scheme().withPrimary(corePalette.f6976a1.tone(80)).withOnPrimary(corePalette.f6976a1.tone(20)).withPrimaryContainer(corePalette.f6976a1.tone(30)).withOnPrimaryContainer(corePalette.f6976a1.tone(90)).withSecondary(corePalette.f6977a2.tone(80)).withOnSecondary(corePalette.f6977a2.tone(20)).withSecondaryContainer(corePalette.f6977a2.tone(30)).withOnSecondaryContainer(corePalette.f6977a2.tone(90)).withTertiary(corePalette.f6978a3.tone(80)).withOnTertiary(corePalette.f6978a3.tone(20)).withTertiaryContainer(corePalette.f6978a3.tone(30)).withOnTertiaryContainer(corePalette.f6978a3.tone(90)).withError(corePalette.error.tone(80)).withOnError(corePalette.error.tone(20)).withErrorContainer(corePalette.error.tone(30)).withOnErrorContainer(corePalette.error.tone(80)).withBackground(corePalette.f6979n1.tone(10)).withOnBackground(corePalette.f6979n1.tone(90)).withSurface(corePalette.f6979n1.tone(10)).withOnSurface(corePalette.f6979n1.tone(90)).withSurfaceVariant(corePalette.f6980n2.tone(30)).withOnSurfaceVariant(corePalette.f6980n2.tone(80)).withOutline(corePalette.f6980n2.tone(60)).withOutlineVariant(corePalette.f6980n2.tone(30)).withShadow(corePalette.f6979n1.tone(0)).withScrim(corePalette.f6979n1.tone(0)).withInverseSurface(corePalette.f6979n1.tone(90)).withInverseOnSurface(corePalette.f6979n1.tone(20)).withInversePrimary(corePalette.f6976a1.tone(40));
    }

    public static Scheme light(int i5) {
        return lightFromCorePalette(CorePalette.of(i5));
    }

    public static Scheme lightContent(int i5) {
        return lightFromCorePalette(CorePalette.contentOf(i5));
    }

    private static Scheme lightFromCorePalette(CorePalette corePalette) {
        return new Scheme().withPrimary(corePalette.f6976a1.tone(40)).withOnPrimary(corePalette.f6976a1.tone(100)).withPrimaryContainer(corePalette.f6976a1.tone(90)).withOnPrimaryContainer(corePalette.f6976a1.tone(10)).withSecondary(corePalette.f6977a2.tone(40)).withOnSecondary(corePalette.f6977a2.tone(100)).withSecondaryContainer(corePalette.f6977a2.tone(90)).withOnSecondaryContainer(corePalette.f6977a2.tone(10)).withTertiary(corePalette.f6978a3.tone(40)).withOnTertiary(corePalette.f6978a3.tone(100)).withTertiaryContainer(corePalette.f6978a3.tone(90)).withOnTertiaryContainer(corePalette.f6978a3.tone(10)).withError(corePalette.error.tone(40)).withOnError(corePalette.error.tone(100)).withErrorContainer(corePalette.error.tone(90)).withOnErrorContainer(corePalette.error.tone(10)).withBackground(corePalette.f6979n1.tone(99)).withOnBackground(corePalette.f6979n1.tone(10)).withSurface(corePalette.f6979n1.tone(99)).withOnSurface(corePalette.f6979n1.tone(10)).withSurfaceVariant(corePalette.f6980n2.tone(90)).withOnSurfaceVariant(corePalette.f6980n2.tone(30)).withOutline(corePalette.f6980n2.tone(50)).withOutlineVariant(corePalette.f6980n2.tone(80)).withShadow(corePalette.f6979n1.tone(0)).withScrim(corePalette.f6979n1.tone(0)).withInverseSurface(corePalette.f6979n1.tone(20)).withInverseOnSurface(corePalette.f6979n1.tone(95)).withInversePrimary(corePalette.f6976a1.tone(80));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scheme)) {
            return false;
        }
        Scheme scheme = (Scheme) obj;
        if (this.primary == scheme.primary && this.onPrimary == scheme.onPrimary && this.primaryContainer == scheme.primaryContainer && this.onPrimaryContainer == scheme.onPrimaryContainer && this.secondary == scheme.secondary && this.onSecondary == scheme.onSecondary && this.secondaryContainer == scheme.secondaryContainer && this.onSecondaryContainer == scheme.onSecondaryContainer && this.tertiary == scheme.tertiary && this.onTertiary == scheme.onTertiary && this.tertiaryContainer == scheme.tertiaryContainer && this.onTertiaryContainer == scheme.onTertiaryContainer && this.error == scheme.error && this.onError == scheme.onError && this.errorContainer == scheme.errorContainer && this.onErrorContainer == scheme.onErrorContainer && this.background == scheme.background && this.onBackground == scheme.onBackground && this.surface == scheme.surface && this.onSurface == scheme.onSurface && this.surfaceVariant == scheme.surfaceVariant && this.onSurfaceVariant == scheme.onSurfaceVariant && this.outline == scheme.outline && this.outlineVariant == scheme.outlineVariant && this.shadow == scheme.shadow && this.scrim == scheme.scrim && this.inverseSurface == scheme.inverseSurface && this.inverseOnSurface == scheme.inverseOnSurface && this.inversePrimary == scheme.inversePrimary) {
            return true;
        }
        return false;
    }

    public int getBackground() {
        return this.background;
    }

    public int getError() {
        return this.error;
    }

    public int getErrorContainer() {
        return this.errorContainer;
    }

    public int getInverseOnSurface() {
        return this.inverseOnSurface;
    }

    public int getInversePrimary() {
        return this.inversePrimary;
    }

    public int getInverseSurface() {
        return this.inverseSurface;
    }

    public int getOnBackground() {
        return this.onBackground;
    }

    public int getOnError() {
        return this.onError;
    }

    public int getOnErrorContainer() {
        return this.onErrorContainer;
    }

    public int getOnPrimary() {
        return this.onPrimary;
    }

    public int getOnPrimaryContainer() {
        return this.onPrimaryContainer;
    }

    public int getOnSecondary() {
        return this.onSecondary;
    }

    public int getOnSecondaryContainer() {
        return this.onSecondaryContainer;
    }

    public int getOnSurface() {
        return this.onSurface;
    }

    public int getOnSurfaceVariant() {
        return this.onSurfaceVariant;
    }

    public int getOnTertiary() {
        return this.onTertiary;
    }

    public int getOnTertiaryContainer() {
        return this.onTertiaryContainer;
    }

    public int getOutline() {
        return this.outline;
    }

    public int getOutlineVariant() {
        return this.outlineVariant;
    }

    public int getPrimary() {
        return this.primary;
    }

    public int getPrimaryContainer() {
        return this.primaryContainer;
    }

    public int getScrim() {
        return this.scrim;
    }

    public int getSecondary() {
        return this.secondary;
    }

    public int getSecondaryContainer() {
        return this.secondaryContainer;
    }

    public int getShadow() {
        return this.shadow;
    }

    public int getSurface() {
        return this.surface;
    }

    public int getSurfaceVariant() {
        return this.surfaceVariant;
    }

    public int getTertiary() {
        return this.tertiary;
    }

    public int getTertiaryContainer() {
        return this.tertiaryContainer;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((System.identityHashCode(this) * 31) + this.primary) * 31) + this.onPrimary) * 31) + this.primaryContainer) * 31) + this.onPrimaryContainer) * 31) + this.secondary) * 31) + this.onSecondary) * 31) + this.secondaryContainer) * 31) + this.onSecondaryContainer) * 31) + this.tertiary) * 31) + this.onTertiary) * 31) + this.tertiaryContainer) * 31) + this.onTertiaryContainer) * 31) + this.error) * 31) + this.onError) * 31) + this.errorContainer) * 31) + this.onErrorContainer) * 31) + this.background) * 31) + this.onBackground) * 31) + this.surface) * 31) + this.onSurface) * 31) + this.surfaceVariant) * 31) + this.onSurfaceVariant) * 31) + this.outline) * 31) + this.outlineVariant) * 31) + this.shadow) * 31) + this.scrim) * 31) + this.inverseSurface) * 31) + this.inverseOnSurface) * 31) + this.inversePrimary;
    }

    public void setBackground(int i5) {
        this.background = i5;
    }

    public void setError(int i5) {
        this.error = i5;
    }

    public void setErrorContainer(int i5) {
        this.errorContainer = i5;
    }

    public void setInverseOnSurface(int i5) {
        this.inverseOnSurface = i5;
    }

    public void setInversePrimary(int i5) {
        this.inversePrimary = i5;
    }

    public void setInverseSurface(int i5) {
        this.inverseSurface = i5;
    }

    public void setOnBackground(int i5) {
        this.onBackground = i5;
    }

    public void setOnError(int i5) {
        this.onError = i5;
    }

    public void setOnErrorContainer(int i5) {
        this.onErrorContainer = i5;
    }

    public void setOnPrimary(int i5) {
        this.onPrimary = i5;
    }

    public void setOnPrimaryContainer(int i5) {
        this.onPrimaryContainer = i5;
    }

    public void setOnSecondary(int i5) {
        this.onSecondary = i5;
    }

    public void setOnSecondaryContainer(int i5) {
        this.onSecondaryContainer = i5;
    }

    public void setOnSurface(int i5) {
        this.onSurface = i5;
    }

    public void setOnSurfaceVariant(int i5) {
        this.onSurfaceVariant = i5;
    }

    public void setOnTertiary(int i5) {
        this.onTertiary = i5;
    }

    public void setOnTertiaryContainer(int i5) {
        this.onTertiaryContainer = i5;
    }

    public void setOutline(int i5) {
        this.outline = i5;
    }

    public void setOutlineVariant(int i5) {
        this.outlineVariant = i5;
    }

    public void setPrimary(int i5) {
        this.primary = i5;
    }

    public void setPrimaryContainer(int i5) {
        this.primaryContainer = i5;
    }

    public void setScrim(int i5) {
        this.scrim = i5;
    }

    public void setSecondary(int i5) {
        this.secondary = i5;
    }

    public void setSecondaryContainer(int i5) {
        this.secondaryContainer = i5;
    }

    public void setShadow(int i5) {
        this.shadow = i5;
    }

    public void setSurface(int i5) {
        this.surface = i5;
    }

    public void setSurfaceVariant(int i5) {
        this.surfaceVariant = i5;
    }

    public void setTertiary(int i5) {
        this.tertiary = i5;
    }

    public void setTertiaryContainer(int i5) {
        this.tertiaryContainer = i5;
    }

    public String toString() {
        return "Scheme{primary=" + this.primary + ", onPrimary=" + this.onPrimary + ", primaryContainer=" + this.primaryContainer + ", onPrimaryContainer=" + this.onPrimaryContainer + ", secondary=" + this.secondary + ", onSecondary=" + this.onSecondary + ", secondaryContainer=" + this.secondaryContainer + ", onSecondaryContainer=" + this.onSecondaryContainer + ", tertiary=" + this.tertiary + ", onTertiary=" + this.onTertiary + ", tertiaryContainer=" + this.tertiaryContainer + ", onTertiaryContainer=" + this.onTertiaryContainer + ", error=" + this.error + ", onError=" + this.onError + ", errorContainer=" + this.errorContainer + ", onErrorContainer=" + this.onErrorContainer + ", background=" + this.background + ", onBackground=" + this.onBackground + ", surface=" + this.surface + ", onSurface=" + this.onSurface + ", surfaceVariant=" + this.surfaceVariant + ", onSurfaceVariant=" + this.onSurfaceVariant + ", outline=" + this.outline + ", outlineVariant=" + this.outlineVariant + ", shadow=" + this.shadow + ", scrim=" + this.scrim + ", inverseSurface=" + this.inverseSurface + ", inverseOnSurface=" + this.inverseOnSurface + ", inversePrimary=" + this.inversePrimary + '}';
    }

    public Scheme withBackground(int i5) {
        this.background = i5;
        return this;
    }

    public Scheme withError(int i5) {
        this.error = i5;
        return this;
    }

    public Scheme withErrorContainer(int i5) {
        this.errorContainer = i5;
        return this;
    }

    public Scheme withInverseOnSurface(int i5) {
        this.inverseOnSurface = i5;
        return this;
    }

    public Scheme withInversePrimary(int i5) {
        this.inversePrimary = i5;
        return this;
    }

    public Scheme withInverseSurface(int i5) {
        this.inverseSurface = i5;
        return this;
    }

    public Scheme withOnBackground(int i5) {
        this.onBackground = i5;
        return this;
    }

    public Scheme withOnError(int i5) {
        this.onError = i5;
        return this;
    }

    public Scheme withOnErrorContainer(int i5) {
        this.onErrorContainer = i5;
        return this;
    }

    public Scheme withOnPrimary(int i5) {
        this.onPrimary = i5;
        return this;
    }

    public Scheme withOnPrimaryContainer(int i5) {
        this.onPrimaryContainer = i5;
        return this;
    }

    public Scheme withOnSecondary(int i5) {
        this.onSecondary = i5;
        return this;
    }

    public Scheme withOnSecondaryContainer(int i5) {
        this.onSecondaryContainer = i5;
        return this;
    }

    public Scheme withOnSurface(int i5) {
        this.onSurface = i5;
        return this;
    }

    public Scheme withOnSurfaceVariant(int i5) {
        this.onSurfaceVariant = i5;
        return this;
    }

    public Scheme withOnTertiary(int i5) {
        this.onTertiary = i5;
        return this;
    }

    public Scheme withOnTertiaryContainer(int i5) {
        this.onTertiaryContainer = i5;
        return this;
    }

    public Scheme withOutline(int i5) {
        this.outline = i5;
        return this;
    }

    public Scheme withOutlineVariant(int i5) {
        this.outlineVariant = i5;
        return this;
    }

    public Scheme withPrimary(int i5) {
        this.primary = i5;
        return this;
    }

    public Scheme withPrimaryContainer(int i5) {
        this.primaryContainer = i5;
        return this;
    }

    public Scheme withScrim(int i5) {
        this.scrim = i5;
        return this;
    }

    public Scheme withSecondary(int i5) {
        this.secondary = i5;
        return this;
    }

    public Scheme withSecondaryContainer(int i5) {
        this.secondaryContainer = i5;
        return this;
    }

    public Scheme withShadow(int i5) {
        this.shadow = i5;
        return this;
    }

    public Scheme withSurface(int i5) {
        this.surface = i5;
        return this;
    }

    public Scheme withSurfaceVariant(int i5) {
        this.surfaceVariant = i5;
        return this;
    }

    public Scheme withTertiary(int i5) {
        this.tertiary = i5;
        return this;
    }

    public Scheme withTertiaryContainer(int i5) {
        this.tertiaryContainer = i5;
        return this;
    }

    public Scheme(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33) {
        this.primary = i5;
        this.onPrimary = i6;
        this.primaryContainer = i7;
        this.onPrimaryContainer = i8;
        this.secondary = i9;
        this.onSecondary = i10;
        this.secondaryContainer = i11;
        this.onSecondaryContainer = i12;
        this.tertiary = i13;
        this.onTertiary = i14;
        this.tertiaryContainer = i15;
        this.onTertiaryContainer = i16;
        this.error = i17;
        this.onError = i18;
        this.errorContainer = i19;
        this.onErrorContainer = i20;
        this.background = i21;
        this.onBackground = i22;
        this.surface = i23;
        this.onSurface = i24;
        this.surfaceVariant = i25;
        this.onSurfaceVariant = i26;
        this.outline = i27;
        this.outlineVariant = i28;
        this.shadow = i29;
        this.scrim = i30;
        this.inverseSurface = i31;
        this.inverseOnSurface = i32;
        this.inversePrimary = i33;
    }
}
