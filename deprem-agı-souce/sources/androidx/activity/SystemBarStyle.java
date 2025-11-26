package androidx.activity;

import androidx.annotation.ColorInt;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class SystemBarStyle {
    public static final Companion Companion = new Companion((C2633k) null);
    private final int darkScrim;
    private final l detectDarkMode;
    private final int lightScrim;
    private final int nightMode;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public static /* synthetic */ SystemBarStyle auto$default(Companion companion, int i5, int i6, l lVar, int i7, Object obj) {
            if ((i7 & 4) != 0) {
                lVar = SystemBarStyle$Companion$auto$1.INSTANCE;
            }
            return companion.auto(i5, i6, lVar);
        }

        public final SystemBarStyle auto(@ColorInt int i5, @ColorInt int i6) {
            return auto$default(this, i5, i6, (l) null, 4, (Object) null);
        }

        public final SystemBarStyle dark(@ColorInt int i5) {
            return new SystemBarStyle(i5, i5, 2, SystemBarStyle$Companion$dark$1.INSTANCE, (C2633k) null);
        }

        public final SystemBarStyle light(@ColorInt int i5, @ColorInt int i6) {
            return new SystemBarStyle(i5, i6, 1, SystemBarStyle$Companion$light$1.INSTANCE, (C2633k) null);
        }

        private Companion() {
        }

        public final SystemBarStyle auto(@ColorInt int i5, @ColorInt int i6, l lVar) {
            t.e(lVar, "detectDarkMode");
            return new SystemBarStyle(i5, i6, 0, lVar, (C2633k) null);
        }
    }

    public /* synthetic */ SystemBarStyle(int i5, int i6, int i7, l lVar, C2633k kVar) {
        this(i5, i6, i7, lVar);
    }

    public static final SystemBarStyle auto(@ColorInt int i5, @ColorInt int i6) {
        return Companion.auto(i5, i6);
    }

    public static final SystemBarStyle dark(@ColorInt int i5) {
        return Companion.dark(i5);
    }

    public static final SystemBarStyle light(@ColorInt int i5, @ColorInt int i6) {
        return Companion.light(i5, i6);
    }

    public final int getDarkScrim$activity_release() {
        return this.darkScrim;
    }

    public final l getDetectDarkMode$activity_release() {
        return this.detectDarkMode;
    }

    public final int getNightMode$activity_release() {
        return this.nightMode;
    }

    public final int getScrim$activity_release(boolean z4) {
        if (z4) {
            return this.darkScrim;
        }
        return this.lightScrim;
    }

    public final int getScrimWithEnforcedContrast$activity_release(boolean z4) {
        if (this.nightMode == 0) {
            return 0;
        }
        if (z4) {
            return this.darkScrim;
        }
        return this.lightScrim;
    }

    private SystemBarStyle(int i5, int i6, int i7, l lVar) {
        this.lightScrim = i5;
        this.darkScrim = i6;
        this.nightMode = i7;
        this.detectDarkMode = lVar;
    }

    public static final SystemBarStyle auto(@ColorInt int i5, @ColorInt int i6, l lVar) {
        return Companion.auto(i5, i6, lVar);
    }
}
