package androidx.savedstate.serialization;

import O3.d;
import O3.h;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class SavedStateConfiguration {
    public static final Companion Companion = new Companion((C2633k) null);
    public static final SavedStateConfiguration DEFAULT = new SavedStateConfiguration((d) null, 0, false, 7, (C2633k) null);
    private final int classDiscriminatorMode;
    private final boolean encodeDefaults;
    private final d serializersModule;

    public static final class Builder {
        private int classDiscriminatorMode;
        private boolean encodeDefaults;
        private d serializersModule;

        public Builder(SavedStateConfiguration savedStateConfiguration) {
            t.e(savedStateConfiguration, "configuration");
            this.serializersModule = savedStateConfiguration.getSerializersModule();
            this.encodeDefaults = savedStateConfiguration.getEncodeDefaults();
            this.classDiscriminatorMode = savedStateConfiguration.getClassDiscriminatorMode();
        }

        public static /* synthetic */ void getClassDiscriminatorMode$annotations() {
        }

        public static /* synthetic */ void getEncodeDefaults$annotations() {
        }

        public final SavedStateConfiguration build$savedstate_release() {
            return new SavedStateConfiguration(h.b(SavedStateConfigurationKt.DEFAULT_SERIALIZERS_MODULE, this.serializersModule), this.classDiscriminatorMode, this.encodeDefaults, (C2633k) null);
        }

        public final int getClassDiscriminatorMode() {
            return this.classDiscriminatorMode;
        }

        public final boolean getEncodeDefaults() {
            return this.encodeDefaults;
        }

        public final d getSerializersModule() {
            return this.serializersModule;
        }

        public final void setClassDiscriminatorMode(int i5) {
            this.classDiscriminatorMode = i5;
        }

        public final void setEncodeDefaults(boolean z4) {
            this.encodeDefaults = z4;
        }

        public final void setSerializersModule(d dVar) {
            t.e(dVar, "<set-?>");
            this.serializersModule = dVar;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ SavedStateConfiguration(d dVar, int i5, boolean z4, C2633k kVar) {
        this(dVar, i5, z4);
    }

    public final int getClassDiscriminatorMode() {
        return this.classDiscriminatorMode;
    }

    public final boolean getEncodeDefaults() {
        return this.encodeDefaults;
    }

    public final d getSerializersModule() {
        return this.serializersModule;
    }

    private SavedStateConfiguration(d dVar, int i5, boolean z4) {
        this.serializersModule = dVar;
        this.classDiscriminatorMode = i5;
        this.encodeDefaults = z4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ SavedStateConfiguration(d dVar, int i5, boolean z4, int i6, C2633k kVar) {
        this((i6 & 1) != 0 ? SavedStateConfigurationKt.DEFAULT_SERIALIZERS_MODULE : dVar, (i6 & 2) != 0 ? 2 : i5, (i6 & 4) != 0 ? false : z4);
    }
}
